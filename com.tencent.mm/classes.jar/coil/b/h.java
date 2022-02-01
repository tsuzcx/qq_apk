package coil.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.b.c;
import coil.memory.u;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/bitmap/RealBitmapReferenceCounter;", "Lcoil/bitmap/BitmapReferenceCounter;", "weakMemoryCache", "Lcoil/memory/WeakMemoryCache;", "bitmapPool", "Lcoil/bitmap/BitmapPool;", "logger", "Lcoil/util/Logger;", "(Lcoil/memory/WeakMemoryCache;Lcoil/bitmap/BitmapPool;Lcoil/util/Logger;)V", "operationsSinceCleanUp", "", "getOperationsSinceCleanUp$coil_base_release$annotations", "()V", "getOperationsSinceCleanUp$coil_base_release", "()I", "setOperationsSinceCleanUp$coil_base_release", "(I)V", "values", "Landroidx/collection/SparseArrayCompat;", "Lcoil/bitmap/RealBitmapReferenceCounter$Value;", "getValues$coil_base_release$annotations", "getValues$coil_base_release", "()Landroidx/collection/SparseArrayCompat;", "cleanUp", "", "cleanUp$coil_base_release", "cleanUpIfNecessary", "decrement", "", "bitmap", "Landroid/graphics/Bitmap;", "getValue", "key", "getValueOrNull", "increment", "setValid", "isValid", "Companion", "Value", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements d
{
  public static final h.a clT;
  private static final Handler clX;
  private final u clU;
  private final androidx.b.h<b> clV;
  private int clW;
  private final k cli;
  private final b clr;
  
  static
  {
    AppMethodBeat.i(188231);
    clT = new h.a((byte)0);
    clX = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(188231);
  }
  
  public h(u paramu, b paramb, k paramk)
  {
    AppMethodBeat.i(188169);
    this.clU = paramu;
    this.clr = paramb;
    this.cli = paramk;
    this.clV = new androidx.b.h();
    AppMethodBeat.o(188169);
  }
  
  private final void MH()
  {
    AppMethodBeat.i(188180);
    int i = this.clW;
    this.clW = (i + 1);
    if (i >= 50) {
      MI();
    }
    AppMethodBeat.o(188180);
  }
  
  private void MI()
  {
    int j = 0;
    AppMethodBeat.i(188192);
    Object localObject = new ArrayList();
    int m = this.clV.size();
    if (m > 0) {}
    int k;
    for (int i = 0;; i = k)
    {
      k = i + 1;
      if (((b)this.clV.bl(i)).clY.get() == null) {
        ((Collection)localObject).add(Integer.valueOf(i));
      }
      if (k >= m)
      {
        localObject = (List)localObject;
        androidx.b.h localh = this.clV;
        k = ((List)localObject).size() - 1;
        if (k >= 0) {}
        for (i = j;; i = j)
        {
          j = i + 1;
          localh.bj(((Number)((List)localObject).get(i)).intValue());
          if (j > k)
          {
            AppMethodBeat.o(188192);
            return;
          }
        }
      }
    }
  }
  
  private final b a(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188202);
    b localb2 = b(paramInt, paramBitmap);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b(new WeakReference(paramBitmap), false);
      this.clV.put(paramInt, localb1);
    }
    AppMethodBeat.o(188202);
    return localb1;
  }
  
  private static final void a(h paramh, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188221);
    s.u(paramh, "this$0");
    s.u(paramBitmap, "$bitmap");
    paramh.clr.n(paramBitmap);
    AppMethodBeat.o(188221);
  }
  
  private final b b(int paramInt, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188212);
    b localb = (b)this.clV.d(paramInt, null);
    if (localb != null)
    {
      if (localb.clY.get() == paramBitmap) {}
      for (paramInt = 1; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(188212);
        return localb;
      }
    }
    AppMethodBeat.o(188212);
    return null;
  }
  
  /* Error */
  public final void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 218
    //   4: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 219
    //   10: invokestatic 118	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: invokestatic 225	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   17: istore_3
    //   18: iload_2
    //   19: ifeq +48 -> 67
    //   22: aload_0
    //   23: iload_3
    //   24: aload_1
    //   25: invokespecial 190	coil/b/h:b	(ILandroid/graphics/Bitmap;)Lcoil/b/h$b;
    //   28: ifnonnull +27 -> 55
    //   31: aload_0
    //   32: getfield 133	coil/b/h:clV	Landroidx/b/h;
    //   35: iload_3
    //   36: new 10	coil/b/h$b
    //   39: dup
    //   40: new 157	java/lang/ref/WeakReference
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 193	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   48: iconst_1
    //   49: invokespecial 196	coil/b/h$b:<init>	(Ljava/lang/ref/WeakReference;Z)V
    //   52: invokevirtual 200	androidx/b/h:put	(ILjava/lang/Object;)V
    //   55: aload_0
    //   56: invokespecial 227	coil/b/h:MH	()V
    //   59: ldc 218
    //   61: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: iload_3
    //   69: aload_1
    //   70: invokespecial 229	coil/b/h:a	(ILandroid/graphics/Bitmap;)Lcoil/b/h$b;
    //   73: iconst_0
    //   74: putfield 233	coil/b/h$b:clZ	Z
    //   77: goto -22 -> 55
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	h
    //   0	85	1	paramBitmap	Bitmap
    //   0	85	2	paramBoolean	boolean
    //   17	52	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	18	80	finally
    //   22	55	80	finally
    //   55	64	80	finally
    //   67	77	80	finally
  }
  
  public final void p(Bitmap paramBitmap)
  {
    try
    {
      AppMethodBeat.i(188250);
      s.u(paramBitmap, "bitmap");
      int i = System.identityHashCode(paramBitmap);
      paramBitmap = a(i, paramBitmap);
      paramBitmap.count += 1;
      k localk = this.cli;
      if ((localk != null) && (localk.getLevel() <= 2)) {
        new StringBuilder("INCREMENT: [").append(i).append(", ").append(paramBitmap.count).append(", ").append(paramBitmap.clZ).append(']');
      }
      MH();
      AppMethodBeat.o(188250);
      return;
    }
    finally {}
  }
  
  public final boolean q(Bitmap paramBitmap)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(188257);
        s.u(paramBitmap, "bitmap");
        int i = System.identityHashCode(paramBitmap);
        Object localObject = b(i, paramBitmap);
        if (localObject == null)
        {
          paramBitmap = ((h)this).cli;
          if ((paramBitmap != null) && (paramBitmap.getLevel() <= 2)) {
            new StringBuilder("DECREMENT: [").append(i).append(", UNKNOWN, UNKNOWN]");
          }
          AppMethodBeat.o(188257);
          bool = false;
          return bool;
        }
        ((b)localObject).count -= 1;
        k localk = this.cli;
        if ((localk != null) && (localk.getLevel() <= 2)) {
          new StringBuilder("DECREMENT: [").append(i).append(", ").append(((b)localObject).count).append(", ").append(((b)localObject).clZ).append(']');
        }
        if ((((b)localObject).count <= 0) && (((b)localObject).clZ))
        {
          if (bool)
          {
            localObject = this.clV;
            i = c.a(((androidx.b.h)localObject).Sk, ((androidx.b.h)localObject).mSize, i);
            if ((i >= 0) && (localObject.RY[i] != androidx.b.h.RV))
            {
              ((androidx.b.h)localObject).RY[i] = androidx.b.h.RV;
              ((androidx.b.h)localObject).RW = true;
            }
            this.clU.r(paramBitmap);
            clX.post(new h..ExternalSyntheticLambda0(this, paramBitmap));
          }
          MH();
          AppMethodBeat.o(188257);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  @Metadata(d1={""}, d2={"Lcoil/bitmap/RealBitmapReferenceCounter$Value;", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "count", "", "isValid", "", "(Ljava/lang/ref/WeakReference;IZ)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getCount", "()I", "setCount", "(I)V", "()Z", "setValid", "(Z)V", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final WeakReference<Bitmap> clY;
    boolean clZ;
    int count;
    
    public b(WeakReference<Bitmap> paramWeakReference, boolean paramBoolean)
    {
      AppMethodBeat.i(188131);
      this.clY = paramWeakReference;
      this.count = 0;
      this.clZ = paramBoolean;
      AppMethodBeat.o(188131);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     coil.b.h
 * JD-Core Version:    0.7.0.1
 */