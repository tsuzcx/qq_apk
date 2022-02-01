package androidx.camera.lifecycle;

import androidx.camera.core.a.c;
import androidx.camera.core.a.c.b;
import androidx.core.f.f;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class LifecycleCameraRepository
{
  public final Map<a, LifecycleCamera> QJ;
  final Map<LifecycleCameraRepositoryObserver, Set<a>> QK;
  private final ArrayDeque<q> QL;
  public final Object mLock;
  
  LifecycleCameraRepository()
  {
    AppMethodBeat.i(197239);
    this.mLock = new Object();
    this.QJ = new HashMap();
    this.QK = new HashMap();
    this.QL = new ArrayDeque();
    AppMethodBeat.o(197239);
  }
  
  private boolean d(q paramq)
  {
    AppMethodBeat.i(197243);
    synchronized (this.mLock)
    {
      paramq = a(paramq);
      if (paramq == null)
      {
        AppMethodBeat.o(197243);
        return false;
      }
      paramq = ((Set)this.QK.get(paramq)).iterator();
      while (paramq.hasNext())
      {
        a locala = (a)paramq.next();
        if (!((LifecycleCamera)f.checkNotNull((LifecycleCamera)this.QJ.get(locala))).kV().isEmpty())
        {
          AppMethodBeat.o(197243);
          return true;
        }
      }
      AppMethodBeat.o(197243);
      return false;
    }
  }
  
  private void e(q paramq)
  {
    AppMethodBeat.i(197252);
    synchronized (this.mLock)
    {
      paramq = a(paramq);
      paramq = ((Set)this.QK.get(paramq)).iterator();
      if (paramq.hasNext())
      {
        a locala = (a)paramq.next();
        ((LifecycleCamera)f.checkNotNull((LifecycleCamera)this.QJ.get(locala))).lb();
      }
    }
    AppMethodBeat.o(197252);
  }
  
  private void f(q paramq)
  {
    AppMethodBeat.i(197261);
    synchronized (this.mLock)
    {
      paramq = a(paramq);
      paramq = ((Set)this.QK.get(paramq)).iterator();
      while (paramq.hasNext())
      {
        Object localObject2 = (a)paramq.next();
        localObject2 = (LifecycleCamera)this.QJ.get(localObject2);
        if (!((LifecycleCamera)f.checkNotNull(localObject2)).kV().isEmpty()) {
          ((LifecycleCamera)localObject2).lc();
        }
      }
    }
    AppMethodBeat.o(197261);
  }
  
  public final LifecycleCamera a(q paramq, c.b paramb)
  {
    AppMethodBeat.i(197275);
    synchronized (this.mLock)
    {
      paramq = (LifecycleCamera)this.QJ.get(a.b(paramq, paramb));
      AppMethodBeat.o(197275);
      return paramq;
    }
  }
  
  public final LifecycleCamera a(q paramq, c arg2)
  {
    AppMethodBeat.i(197270);
    for (;;)
    {
      synchronized (this.mLock)
      {
        localObject2 = a.b(paramq, ???.Qg);
        if (this.QJ.get(localObject2) == null)
        {
          bool = true;
          f.checkArgument(bool, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
          if (paramq.getLifecycle().getCurrentState() != j.b.bHg) {
            break;
          }
          paramq = new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
          AppMethodBeat.o(197270);
          throw paramq;
        }
      }
      boolean bool = false;
    }
    Object localObject2 = new LifecycleCamera(paramq, ???);
    if (???.kV().isEmpty()) {
      ((LifecycleCamera)localObject2).lb();
    }
    synchronized (this.mLock)
    {
      q localq = ((LifecycleCamera)localObject2).getLifecycleOwner();
      Object localObject3 = a.b(localq, ((LifecycleCamera)localObject2).QH.Qg);
      LifecycleCameraRepositoryObserver localLifecycleCameraRepositoryObserver = a(localq);
      if (localLifecycleCameraRepositoryObserver != null)
      {
        paramq = (Set)this.QK.get(localLifecycleCameraRepositoryObserver);
        paramq.add(localObject3);
        this.QJ.put(localObject3, localObject2);
        if (localLifecycleCameraRepositoryObserver == null)
        {
          localObject3 = new LifecycleCameraRepositoryObserver(localq, this);
          this.QK.put(localObject3, paramq);
          localq.getLifecycle().addObserver((p)localObject3);
        }
        AppMethodBeat.o(197270);
        return localObject2;
      }
      paramq = new HashSet();
    }
  }
  
  final LifecycleCameraRepositoryObserver a(q paramq)
  {
    AppMethodBeat.i(197286);
    synchronized (this.mLock)
    {
      Iterator localIterator = this.QK.keySet().iterator();
      while (localIterator.hasNext())
      {
        LifecycleCameraRepositoryObserver localLifecycleCameraRepositoryObserver = (LifecycleCameraRepositoryObserver)localIterator.next();
        if (paramq.equals(localLifecycleCameraRepositoryObserver.QG))
        {
          AppMethodBeat.o(197286);
          return localLifecycleCameraRepositoryObserver;
        }
      }
      AppMethodBeat.o(197286);
      return null;
    }
  }
  
  /* Error */
  public final void a(LifecycleCamera paramLifecycleCamera, Collection<androidx.camera.core.ax> paramCollection)
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 33	androidx/camera/lifecycle/LifecycleCameraRepository:mLock	Ljava/lang/Object;
    //   9: astore 4
    //   11: aload 4
    //   13: monitorenter
    //   14: aload_2
    //   15: invokeinterface 198 1 0
    //   20: ifne +138 -> 158
    //   23: iconst_1
    //   24: istore_3
    //   25: iload_3
    //   26: invokestatic 201	androidx/core/f/f:checkArgument	(Z)V
    //   29: aload_1
    //   30: invokevirtual 157	androidx/camera/lifecycle/LifecycleCamera:getLifecycleOwner	()Landroidx/lifecycle/q;
    //   33: astore 5
    //   35: aload_0
    //   36: aload 5
    //   38: invokevirtual 55	androidx/camera/lifecycle/LifecycleCameraRepository:a	(Landroidx/lifecycle/q;)Landroidx/camera/lifecycle/LifecycleCameraRepository$LifecycleCameraRepositoryObserver;
    //   41: astore 6
    //   43: aload_0
    //   44: getfield 40	androidx/camera/lifecycle/LifecycleCameraRepository:QK	Ljava/util/Map;
    //   47: aload 6
    //   49: invokeinterface 61 2 0
    //   54: checkcast 63	java/util/Set
    //   57: invokeinterface 67 1 0
    //   62: astore 6
    //   64: aload 6
    //   66: invokeinterface 73 1 0
    //   71: ifeq +92 -> 163
    //   74: aload 6
    //   76: invokeinterface 77 1 0
    //   81: checkcast 9	androidx/camera/lifecycle/LifecycleCameraRepository$a
    //   84: astore 7
    //   86: aload_0
    //   87: getfield 38	androidx/camera/lifecycle/LifecycleCameraRepository:QJ	Ljava/util/Map;
    //   90: aload 7
    //   92: invokeinterface 61 2 0
    //   97: checkcast 79	androidx/camera/lifecycle/LifecycleCamera
    //   100: invokestatic 84	androidx/core/f/f:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: checkcast 79	androidx/camera/lifecycle/LifecycleCamera
    //   106: astore 7
    //   108: aload 7
    //   110: aload_1
    //   111: invokevirtual 191	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   114: ifne -50 -> 64
    //   117: aload 7
    //   119: invokevirtual 88	androidx/camera/lifecycle/LifecycleCamera:kV	()Ljava/util/List;
    //   122: invokeinterface 93 1 0
    //   127: ifne -63 -> 64
    //   130: new 144	java/lang/IllegalArgumentException
    //   133: dup
    //   134: ldc 203
    //   136: invokespecial 149	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   139: astore_1
    //   140: ldc 195
    //   142: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload_1
    //   146: athrow
    //   147: astore_1
    //   148: aload 4
    //   150: monitorexit
    //   151: ldc 195
    //   153: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: aload_1
    //   157: athrow
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -135 -> 25
    //   163: aload_1
    //   164: getfield 161	androidx/camera/lifecycle/LifecycleCamera:QH	Landroidx/camera/core/a/c;
    //   167: astore 7
    //   169: aload 7
    //   171: getfield 204	androidx/camera/core/a/c:mLock	Ljava/lang/Object;
    //   174: astore 6
    //   176: aload 6
    //   178: monitorenter
    //   179: aload 7
    //   181: aconst_null
    //   182: putfield 208	androidx/camera/core/a/c:Qi	Landroidx/camera/core/az;
    //   185: aload 6
    //   187: monitorexit
    //   188: aload_1
    //   189: aload_2
    //   190: invokevirtual 212	androidx/camera/lifecycle/LifecycleCamera:m	(Ljava/util/Collection;)V
    //   193: aload 5
    //   195: invokeinterface 130 1 0
    //   200: invokevirtual 136	androidx/lifecycle/j:getCurrentState	()Landroidx/lifecycle/j$b;
    //   203: getstatic 215	androidx/lifecycle/j$b:bHj	Landroidx/lifecycle/j$b;
    //   206: invokevirtual 218	androidx/lifecycle/j$b:d	(Landroidx/lifecycle/j$b;)Z
    //   209: ifeq +9 -> 218
    //   212: aload_0
    //   213: aload 5
    //   215: invokevirtual 220	androidx/camera/lifecycle/LifecycleCameraRepository:b	(Landroidx/lifecycle/q;)V
    //   218: aload 4
    //   220: monitorexit
    //   221: ldc 195
    //   223: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: return
    //   227: astore_1
    //   228: aload 6
    //   230: monitorexit
    //   231: ldc 195
    //   233: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aload_1
    //   237: athrow
    //   238: astore_1
    //   239: new 144	java/lang/IllegalArgumentException
    //   242: dup
    //   243: aload_1
    //   244: invokevirtual 224	androidx/camera/core/a/c$a:getMessage	()Ljava/lang/String;
    //   247: invokespecial 149	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   250: astore_1
    //   251: ldc 195
    //   253: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_1
    //   257: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	LifecycleCameraRepository
    //   0	258	1	paramLifecycleCamera	LifecycleCamera
    //   0	258	2	paramCollection	Collection<androidx.camera.core.ax>
    //   24	136	3	bool	boolean
    //   9	210	4	localObject1	Object
    //   33	181	5	localq	q
    //   84	96	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   14	23	147	finally
    //   25	64	147	finally
    //   64	147	147	finally
    //   163	179	147	finally
    //   188	193	147	finally
    //   193	218	147	finally
    //   218	221	147	finally
    //   228	238	147	finally
    //   239	258	147	finally
    //   179	188	227	finally
    //   163	179	238	androidx/camera/core/a/c$a
    //   188	193	238	androidx/camera/core/a/c$a
    //   228	238	238	androidx/camera/core/a/c$a
  }
  
  final void b(q paramq)
  {
    AppMethodBeat.i(197298);
    synchronized (this.mLock)
    {
      if (!d(paramq))
      {
        AppMethodBeat.o(197298);
        return;
      }
      if (this.QL.isEmpty()) {
        this.QL.push(paramq);
      }
      q localq;
      do
      {
        f(paramq);
        AppMethodBeat.o(197298);
        return;
        localq = (q)this.QL.peek();
      } while (paramq.equals(localq));
      e(localq);
      this.QL.remove(paramq);
      this.QL.push(paramq);
    }
  }
  
  public final void c(q paramq)
  {
    AppMethodBeat.i(197301);
    synchronized (this.mLock)
    {
      this.QL.remove(paramq);
      e(paramq);
      if (!this.QL.isEmpty()) {
        f((q)this.QL.peek());
      }
      AppMethodBeat.o(197301);
      return;
    }
  }
  
  public final Collection<LifecycleCamera> ld()
  {
    AppMethodBeat.i(197280);
    synchronized (this.mLock)
    {
      Collection localCollection = Collections.unmodifiableCollection(this.QJ.values());
      AppMethodBeat.o(197280);
      return localCollection;
    }
  }
  
  static class LifecycleCameraRepositoryObserver
    implements p
  {
    final q QG;
    private final LifecycleCameraRepository QM;
    
    LifecycleCameraRepositoryObserver(q paramq, LifecycleCameraRepository paramLifecycleCameraRepository)
    {
      this.QG = paramq;
      this.QM = paramLifecycleCameraRepository;
    }
    
    @z(Ho=j.a.ON_DESTROY)
    public void onDestroy(q paramq)
    {
      AppMethodBeat.i(197295);
      LifecycleCameraRepository localLifecycleCameraRepository = this.QM;
      LifecycleCameraRepositoryObserver localLifecycleCameraRepositoryObserver;
      synchronized (localLifecycleCameraRepository.mLock)
      {
        localLifecycleCameraRepositoryObserver = localLifecycleCameraRepository.a(paramq);
        if (localLifecycleCameraRepositoryObserver == null)
        {
          AppMethodBeat.o(197295);
          return;
        }
        localLifecycleCameraRepository.c(paramq);
        paramq = ((Set)localLifecycleCameraRepository.QK.get(localLifecycleCameraRepositoryObserver)).iterator();
        if (paramq.hasNext())
        {
          LifecycleCameraRepository.a locala = (LifecycleCameraRepository.a)paramq.next();
          localLifecycleCameraRepository.QJ.remove(locala);
        }
      }
      localLifecycleCameraRepository.QK.remove(localLifecycleCameraRepositoryObserver);
      localLifecycleCameraRepositoryObserver.QG.getLifecycle().removeObserver(localLifecycleCameraRepositoryObserver);
      AppMethodBeat.o(197295);
    }
    
    @z(Ho=j.a.ON_START)
    public void onStart(q paramq)
    {
      AppMethodBeat.i(197258);
      this.QM.b(paramq);
      AppMethodBeat.o(197258);
    }
    
    @z(Ho=j.a.ON_STOP)
    public void onStop(q paramq)
    {
      AppMethodBeat.i(197268);
      this.QM.c(paramq);
      AppMethodBeat.o(197268);
    }
  }
  
  public static abstract class a
  {
    static a b(q paramq, c.b paramb)
    {
      return new a(paramq, paramb);
    }
    
    public abstract q getLifecycleOwner();
    
    public abstract c.b la();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.lifecycle.LifecycleCameraRepository
 * JD-Core Version:    0.7.0.1
 */