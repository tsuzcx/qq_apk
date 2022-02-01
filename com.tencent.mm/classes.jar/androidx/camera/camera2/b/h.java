package androidx.camera.camera2.b;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Size;
import android.view.Surface;
import androidx.c.a.b.a;
import androidx.camera.camera2.b.a.n;
import androidx.camera.camera2.b.a.n.b;
import androidx.camera.core.al;
import androidx.camera.core.ax;
import androidx.camera.core.impl.a.b.c;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ad;
import androidx.camera.core.impl.ad.a;
import androidx.camera.core.impl.ao;
import androidx.camera.core.impl.aq;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bb.c;
import androidx.camera.core.impl.bb.f;
import androidx.camera.core.impl.bc;
import androidx.camera.core.impl.bj;
import androidx.camera.core.impl.bj.b;
import androidx.camera.core.impl.m;
import androidx.camera.core.impl.o;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.p.b;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t.a;
import androidx.camera.core.impl.v.b;
import androidx.camera.core.impl.z;
import androidx.camera.core.impl.z.a;
import androidx.camera.core.r.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

final class h
  extends androidx.camera.core.impl.t
{
  private final aq<t.a> AA;
  private final v AB;
  private final f AC;
  private final d AD;
  final i AE;
  CameraDevice AF;
  int AG;
  ab AH;
  final AtomicInteger AI;
  b.a<Void> AJ;
  final Map<ab, com.google.b.b.a.f<Void>> AK;
  private final a AL;
  final Set<aa> AM;
  private aj AN;
  private final ac AO;
  private final ap.a AP;
  private final Set<String> AQ;
  private m AR;
  private bc AS;
  private final androidx.camera.core.impl.v At;
  private final n Au;
  final bj Ax;
  private final ScheduledExecutorService Ay;
  volatile c Az;
  private final Executor mExecutor;
  final Object mLock;
  
  /* Error */
  h(n arg1, String paramString, i parami, androidx.camera.core.impl.v paramv, Executor paramExecutor, android.os.Handler paramHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 151	androidx/camera/core/impl/t:<init>	()V
    //   4: ldc 152
    //   6: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getstatic 155	androidx/camera/camera2/b/h$c:AY	Landroidx/camera/camera2/b/h$c;
    //   13: putfield 157	androidx/camera/camera2/b/h:Az	Landroidx/camera/camera2/b/h$c;
    //   16: aload_0
    //   17: new 159	androidx/camera/core/impl/aq
    //   20: dup
    //   21: invokespecial 160	androidx/camera/core/impl/aq:<init>	()V
    //   24: putfield 162	androidx/camera/camera2/b/h:AA	Landroidx/camera/core/impl/aq;
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 164	androidx/camera/camera2/b/h:AG	I
    //   32: aload_0
    //   33: new 166	java/util/concurrent/atomic/AtomicInteger
    //   36: dup
    //   37: iconst_0
    //   38: invokespecial 168	java/util/concurrent/atomic/AtomicInteger:<init>	(I)V
    //   41: putfield 170	androidx/camera/camera2/b/h:AI	Ljava/util/concurrent/atomic/AtomicInteger;
    //   44: aload_0
    //   45: new 172	java/util/LinkedHashMap
    //   48: dup
    //   49: invokespecial 173	java/util/LinkedHashMap:<init>	()V
    //   52: putfield 175	androidx/camera/camera2/b/h:AK	Ljava/util/Map;
    //   55: aload_0
    //   56: new 177	java/util/HashSet
    //   59: dup
    //   60: invokespecial 178	java/util/HashSet:<init>	()V
    //   63: putfield 180	androidx/camera/camera2/b/h:AM	Ljava/util/Set;
    //   66: aload_0
    //   67: new 177	java/util/HashSet
    //   70: dup
    //   71: invokespecial 178	java/util/HashSet:<init>	()V
    //   74: putfield 182	androidx/camera/camera2/b/h:AQ	Ljava/util/Set;
    //   77: aload_0
    //   78: new 184	java/lang/Object
    //   81: dup
    //   82: invokespecial 185	java/lang/Object:<init>	()V
    //   85: putfield 187	androidx/camera/camera2/b/h:mLock	Ljava/lang/Object;
    //   88: aload_0
    //   89: aload_1
    //   90: putfield 189	androidx/camera/camera2/b/h:Au	Landroidx/camera/camera2/b/a/n;
    //   93: aload_0
    //   94: aload 4
    //   96: putfield 191	androidx/camera/camera2/b/h:At	Landroidx/camera/core/impl/v;
    //   99: aload_0
    //   100: aload 6
    //   102: invokestatic 196	androidx/camera/core/impl/a/a/a:b	(Landroid/os/Handler;)Ljava/util/concurrent/ScheduledExecutorService;
    //   105: putfield 198	androidx/camera/camera2/b/h:Ay	Ljava/util/concurrent/ScheduledExecutorService;
    //   108: aload_0
    //   109: aload 5
    //   111: invokestatic 201	androidx/camera/core/impl/a/a/a:b	(Ljava/util/concurrent/Executor;)Ljava/util/concurrent/Executor;
    //   114: putfield 203	androidx/camera/camera2/b/h:mExecutor	Ljava/util/concurrent/Executor;
    //   117: aload_0
    //   118: new 21	androidx/camera/camera2/b/h$d
    //   121: dup
    //   122: aload_0
    //   123: aload_0
    //   124: getfield 203	androidx/camera/camera2/b/h:mExecutor	Ljava/util/concurrent/Executor;
    //   127: aload_0
    //   128: getfield 198	androidx/camera/camera2/b/h:Ay	Ljava/util/concurrent/ScheduledExecutorService;
    //   131: invokespecial 206	androidx/camera/camera2/b/h$d:<init>	(Landroidx/camera/camera2/b/h;Ljava/util/concurrent/Executor;Ljava/util/concurrent/ScheduledExecutorService;)V
    //   134: putfield 208	androidx/camera/camera2/b/h:AD	Landroidx/camera/camera2/b/h$d;
    //   137: aload_0
    //   138: new 210	androidx/camera/core/impl/bj
    //   141: dup
    //   142: aload_2
    //   143: invokespecial 212	androidx/camera/core/impl/bj:<init>	(Ljava/lang/String;)V
    //   146: putfield 214	androidx/camera/camera2/b/h:Ax	Landroidx/camera/core/impl/bj;
    //   149: aload_0
    //   150: getfield 162	androidx/camera/camera2/b/h:AA	Landroidx/camera/core/impl/aq;
    //   153: getstatic 220	androidx/camera/core/impl/t$a:LD	Landroidx/camera/core/impl/t$a;
    //   156: invokevirtual 224	androidx/camera/core/impl/aq:t	(Ljava/lang/Object;)V
    //   159: aload_0
    //   160: new 226	androidx/camera/camera2/b/v
    //   163: dup
    //   164: aload 4
    //   166: invokespecial 229	androidx/camera/camera2/b/v:<init>	(Landroidx/camera/core/impl/v;)V
    //   169: putfield 231	androidx/camera/camera2/b/h:AB	Landroidx/camera/camera2/b/v;
    //   172: aload_0
    //   173: new 233	androidx/camera/camera2/b/ac
    //   176: dup
    //   177: aload_0
    //   178: getfield 203	androidx/camera/camera2/b/h:mExecutor	Ljava/util/concurrent/Executor;
    //   181: invokespecial 236	androidx/camera/camera2/b/ac:<init>	(Ljava/util/concurrent/Executor;)V
    //   184: putfield 238	androidx/camera/camera2/b/h:AO	Landroidx/camera/camera2/b/ac;
    //   187: aload_0
    //   188: aload_0
    //   189: invokespecial 242	androidx/camera/camera2/b/h:gE	()Landroidx/camera/camera2/b/ab;
    //   192: putfield 244	androidx/camera/camera2/b/h:AH	Landroidx/camera/camera2/b/ab;
    //   195: aload_0
    //   196: new 246	androidx/camera/camera2/b/f
    //   199: dup
    //   200: aload_0
    //   201: getfield 189	androidx/camera/camera2/b/h:Au	Landroidx/camera/camera2/b/a/n;
    //   204: aload_2
    //   205: invokevirtual 252	androidx/camera/camera2/b/a/n:H	(Ljava/lang/String;)Landroidx/camera/camera2/b/a/h;
    //   208: aload_0
    //   209: getfield 198	androidx/camera/camera2/b/h:Ay	Ljava/util/concurrent/ScheduledExecutorService;
    //   212: aload_0
    //   213: getfield 203	androidx/camera/camera2/b/h:mExecutor	Ljava/util/concurrent/Executor;
    //   216: new 15	androidx/camera/camera2/b/h$b
    //   219: dup
    //   220: aload_0
    //   221: invokespecial 255	androidx/camera/camera2/b/h$b:<init>	(Landroidx/camera/camera2/b/h;)V
    //   224: aload_3
    //   225: getfield 261	androidx/camera/camera2/b/i:Bt	Landroidx/camera/core/impl/az;
    //   228: invokespecial 264	androidx/camera/camera2/b/f:<init>	(Landroidx/camera/camera2/b/a/h;Ljava/util/concurrent/ScheduledExecutorService;Ljava/util/concurrent/Executor;Landroidx/camera/core/impl/p$b;Landroidx/camera/core/impl/az;)V
    //   231: putfield 266	androidx/camera/camera2/b/h:AC	Landroidx/camera/camera2/b/f;
    //   234: aload_0
    //   235: aload_3
    //   236: putfield 268	androidx/camera/camera2/b/h:AE	Landroidx/camera/camera2/b/i;
    //   239: aload_0
    //   240: getfield 268	androidx/camera/camera2/b/h:AE	Landroidx/camera/camera2/b/i;
    //   243: aload_0
    //   244: getfield 266	androidx/camera/camera2/b/h:AC	Landroidx/camera/camera2/b/f;
    //   247: invokevirtual 271	androidx/camera/camera2/b/i:a	(Landroidx/camera/camera2/b/f;)V
    //   250: aload_0
    //   251: getfield 268	androidx/camera/camera2/b/h:AE	Landroidx/camera/camera2/b/i;
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 231	androidx/camera/camera2/b/h:AB	Landroidx/camera/camera2/b/v;
    //   259: getfield 275	androidx/camera/camera2/b/v:Ca	Landroidx/lifecycle/x;
    //   262: astore_3
    //   263: aload_1
    //   264: getfield 279	androidx/camera/camera2/b/i:Br	Landroidx/camera/camera2/b/i$a;
    //   267: aload_3
    //   268: invokevirtual 284	androidx/camera/camera2/b/i$a:a	(Landroidx/lifecycle/LiveData;)V
    //   271: aload_0
    //   272: new 286	androidx/camera/camera2/b/ap$a
    //   275: dup
    //   276: aload_0
    //   277: getfield 203	androidx/camera/camera2/b/h:mExecutor	Ljava/util/concurrent/Executor;
    //   280: aload_0
    //   281: getfield 198	androidx/camera/camera2/b/h:Ay	Ljava/util/concurrent/ScheduledExecutorService;
    //   284: aload 6
    //   286: aload_0
    //   287: getfield 238	androidx/camera/camera2/b/h:AO	Landroidx/camera/camera2/b/ac;
    //   290: aload_0
    //   291: getfield 268	androidx/camera/camera2/b/h:AE	Landroidx/camera/camera2/b/i;
    //   294: invokevirtual 290	androidx/camera/camera2/b/i:gX	()I
    //   297: invokespecial 293	androidx/camera/camera2/b/ap$a:<init>	(Ljava/util/concurrent/Executor;Ljava/util/concurrent/ScheduledExecutorService;Landroid/os/Handler;Landroidx/camera/camera2/b/ac;I)V
    //   300: putfield 295	androidx/camera/camera2/b/h:AP	Landroidx/camera/camera2/b/ap$a;
    //   303: aload_0
    //   304: new 12	androidx/camera/camera2/b/h$a
    //   307: dup
    //   308: aload_0
    //   309: aload_2
    //   310: invokespecial 297	androidx/camera/camera2/b/h$a:<init>	(Landroidx/camera/camera2/b/h;Ljava/lang/String;)V
    //   313: putfield 299	androidx/camera/camera2/b/h:AL	Landroidx/camera/camera2/b/h$a;
    //   316: aload_0
    //   317: getfield 191	androidx/camera/camera2/b/h:At	Landroidx/camera/core/impl/v;
    //   320: astore_2
    //   321: aload_0
    //   322: getfield 203	androidx/camera/camera2/b/h:mExecutor	Ljava/util/concurrent/Executor;
    //   325: astore_3
    //   326: aload_0
    //   327: getfield 299	androidx/camera/camera2/b/h:AL	Landroidx/camera/camera2/b/h$a;
    //   330: astore 4
    //   332: aload_2
    //   333: getfield 302	androidx/camera/core/impl/v:mLock	Ljava/lang/Object;
    //   336: astore_1
    //   337: aload_1
    //   338: monitorenter
    //   339: aload_2
    //   340: getfield 305	androidx/camera/core/impl/v:LN	Ljava/util/Map;
    //   343: aload_0
    //   344: invokeinterface 311 2 0
    //   349: ifne +89 -> 438
    //   352: iconst_1
    //   353: istore 7
    //   355: iload 7
    //   357: ldc_w 313
    //   360: aload_0
    //   361: invokestatic 319	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   364: invokevirtual 323	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   367: invokestatic 328	androidx/core/f/f:b	(ZLjava/lang/String;)V
    //   370: aload_2
    //   371: getfield 305	androidx/camera/core/impl/v:LN	Ljava/util/Map;
    //   374: aload_0
    //   375: new 330	androidx/camera/core/impl/v$a
    //   378: dup
    //   379: aload_3
    //   380: aload 4
    //   382: invokespecial 333	androidx/camera/core/impl/v$a:<init>	(Ljava/util/concurrent/Executor;Landroidx/camera/core/impl/v$b;)V
    //   385: invokeinterface 337 3 0
    //   390: pop
    //   391: aload_1
    //   392: monitorexit
    //   393: aload_0
    //   394: getfield 189	androidx/camera/camera2/b/h:Au	Landroidx/camera/camera2/b/a/n;
    //   397: astore_1
    //   398: aload_0
    //   399: getfield 203	androidx/camera/camera2/b/h:mExecutor	Ljava/util/concurrent/Executor;
    //   402: astore_2
    //   403: aload_0
    //   404: getfield 299	androidx/camera/camera2/b/h:AL	Landroidx/camera/camera2/b/h$a;
    //   407: astore_3
    //   408: aload_1
    //   409: getfield 341	androidx/camera/camera2/b/a/n:Fh	Landroidx/camera/camera2/b/a/n$b;
    //   412: aload_2
    //   413: aload_3
    //   414: invokeinterface 346 3 0
    //   419: ldc 152
    //   421: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: return
    //   425: astore_1
    //   426: aload_1
    //   427: invokestatic 351	androidx/camera/camera2/b/w:a	(Landroidx/camera/camera2/b/a/b;)Landroidx/camera/core/s;
    //   430: astore_1
    //   431: ldc 152
    //   433: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: aload_1
    //   437: athrow
    //   438: iconst_0
    //   439: istore 7
    //   441: goto -86 -> 355
    //   444: astore_2
    //   445: aload_1
    //   446: monitorexit
    //   447: ldc 152
    //   449: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: aload_2
    //   453: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	h
    //   0	454	2	paramString	String
    //   0	454	3	parami	i
    //   0	454	4	paramv	androidx.camera.core.impl.v
    //   0	454	5	paramExecutor	Executor
    //   0	454	6	paramHandler	android.os.Handler
    //   353	87	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   195	271	425	androidx/camera/camera2/b/a/b
    //   339	352	444	finally
    //   355	393	444	finally
  }
  
  private void Z(boolean paramBoolean)
  {
    AppMethodBeat.i(197642);
    if (!paramBoolean) {
      this.AD.Bj.Bk = -1L;
    }
    this.AD.gS();
    B("Opening camera.");
    a(c.Ba, null, true);
    try
    {
      this.Au.a(this.AE.AW, this.mExecutor, gN());
      AppMethodBeat.o(197642);
      return;
    }
    catch (androidx.camera.camera2.b.a.b localb)
    {
      B("Unable to open camera due to " + localb.getMessage());
      switch (localb.EV)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(197642);
        return;
        a(c.AY, r.a.a(7, localb), true);
      }
    }
    catch (SecurityException localSecurityException)
    {
      B("Unable to open camera due to " + localSecurityException.getMessage());
      a(c.Bd, null, true);
      this.AD.gR();
      AppMethodBeat.o(197642);
    }
  }
  
  private com.google.b.b.a.f<Void> a(final ab paramab, boolean paramBoolean)
  {
    AppMethodBeat.i(197595);
    paramab.close();
    com.google.b.b.a.f localf = paramab.ab(paramBoolean);
    B("Releasing session in state " + this.Az.name());
    this.AK.put(paramab, localf);
    e.a(localf, new c()
    {
      public final void onFailure(Throwable paramAnonymousThrowable) {}
    }, androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(197595);
    return localf;
  }
  
  static String aH(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN ERROR";
    case 0: 
      return "ERROR_NONE";
    case 4: 
      return "ERROR_CAMERA_DEVICE";
    case 3: 
      return "ERROR_CAMERA_DISABLED";
    case 1: 
      return "ERROR_CAMERA_IN_USE";
    case 5: 
      return "ERROR_CAMERA_SERVICE";
    }
    return "ERROR_MAX_CAMERAS_IN_USE";
  }
  
  private void aa(boolean paramBoolean)
  {
    AppMethodBeat.i(197649);
    if (this.AH != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      androidx.core.f.f.b(paramBoolean, null);
      B("Resetting Capture Session");
      ab localab = this.AH;
      bb localbb = localab.gh();
      List localList = localab.hg();
      this.AH = gE();
      this.AH.b(localbb);
      this.AH.s(localList);
      a(localab, false);
      AppMethodBeat.o(197649);
      return;
    }
  }
  
  private static String e(ax paramax)
  {
    AppMethodBeat.i(197663);
    paramax = paramax.getName() + paramax.hashCode();
    AppMethodBeat.o(197663);
    return paramax;
  }
  
  private static Collection<e> f(Collection<ax> paramCollection)
  {
    AppMethodBeat.i(197604);
    ArrayList localArrayList = new ArrayList();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      ax localax = (ax)paramCollection.next();
      localArrayList.add(new b(e(localax), localax.getClass(), localax.JL, localax.JJ));
    }
    AppMethodBeat.o(197604);
    return localArrayList;
  }
  
  private ab gE()
  {
    AppMethodBeat.i(197591);
    synchronized (this.mLock)
    {
      if (this.AS == null)
      {
        localObject2 = new aa();
        AppMethodBeat.o(197591);
        return localObject2;
      }
      Object localObject2 = new ak(this.AS, this.AE, this.mExecutor, this.Ay);
      AppMethodBeat.o(197591);
      return localObject2;
    }
  }
  
  private void gI()
  {
    AppMethodBeat.i(197626);
    bb localbb = this.Ax.kE().ky();
    z localz = localbb.Ne;
    int i = Collections.unmodifiableList(localz.Fs).size();
    int j = Collections.unmodifiableList(localbb.Fs).size();
    if (!Collections.unmodifiableList(localbb.Fs).isEmpty())
    {
      if (Collections.unmodifiableList(localz.Fs).isEmpty())
      {
        if (this.AN == null) {
          this.AN = new aj(this.AE.Bm);
        }
        if (this.AN != null)
        {
          this.Ax.e("MeteringRepeating" + this.AN.hashCode(), this.AN.Cj);
          this.Ax.d("MeteringRepeating" + this.AN.hashCode(), this.AN.Cj);
        }
        AppMethodBeat.o(197626);
        return;
      }
      if ((j == 1) && (i == 1))
      {
        gJ();
        AppMethodBeat.o(197626);
        return;
      }
      if (i >= 2)
      {
        gJ();
        AppMethodBeat.o(197626);
        return;
      }
      new StringBuilder("mMeteringRepeating is ATTACHED, SessionConfig Surfaces: ").append(j).append(", CaptureConfig Surfaces: ").append(i);
      al.O("Camera2CameraImpl");
    }
    AppMethodBeat.o(197626);
  }
  
  private void gJ()
  {
    AppMethodBeat.i(197632);
    if (this.AN != null)
    {
      this.Ax.aa("MeteringRepeating" + this.AN.hashCode());
      this.Ax.Z("MeteringRepeating" + this.AN.hashCode());
      this.AN.clear();
      this.AN = null;
    }
    AppMethodBeat.o(197632);
  }
  
  private CameraDevice.StateCallback gN()
  {
    AppMethodBeat.i(197656);
    Object localObject = new ArrayList(this.Ax.kE().ky().Na);
    ((List)localObject).add(this.AO.CG);
    ((List)localObject).add(this.AD);
    localObject = t.r((List)localObject);
    AppMethodBeat.o(197656);
    return localObject;
  }
  
  private void k(List<ax> paramList)
  {
    AppMethodBeat.i(197610);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ax localax = (ax)paramList.next();
      String str = e(localax);
      if (!this.AQ.contains(str))
      {
        this.AQ.add(str);
        localax.jB();
      }
    }
    AppMethodBeat.o(197610);
  }
  
  private void l(List<ax> paramList)
  {
    AppMethodBeat.i(197618);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ax localax = (ax)paramList.next();
      String str = e(localax);
      if (this.AQ.contains(str))
      {
        localax.iW();
        this.AQ.remove(str);
      }
    }
    AppMethodBeat.o(197618);
  }
  
  final void B(String paramString)
  {
    AppMethodBeat.i(197851);
    String.format("{%s} %s", new Object[] { toString(), paramString });
    al.P("Camera2CameraImpl");
    AppMethodBeat.o(197851);
  }
  
  final void Y(boolean paramBoolean)
  {
    AppMethodBeat.i(197819);
    B("Attempting to open the camera.");
    if ((this.AL.AX) && (this.At.a(this))) {}
    for (int i = 1; i == 0; i = 0)
    {
      B("No cameras available. Waiting for available camera before opening camera.");
      a(c.AZ, null, true);
      AppMethodBeat.o(197819);
      return;
    }
    Z(paramBoolean);
    AppMethodBeat.o(197819);
  }
  
  final void a(c paramc, r.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(197854);
    B("Transitioning camera internal state: " + this.Az + " --> " + paramc);
    this.Az = paramc;
    switch (3.AV[paramc.ordinal()])
    {
    default: 
      paramc = new IllegalStateException("Unknown state: ".concat(String.valueOf(paramc)));
      AppMethodBeat.o(197854);
      throw paramc;
    case 1: 
      paramc = t.a.LD;
    }
    for (;;)
    {
      this.At.a(this, paramc, paramBoolean);
      this.AA.t(paramc);
      this.AB.a(paramc, parama);
      AppMethodBeat.o(197854);
      return;
      paramc = t.a.Lz;
      continue;
      paramc = t.a.LA;
      continue;
      paramc = t.a.LB;
      continue;
      paramc = t.a.LC;
      continue;
      paramc = t.a.LE;
      continue;
      paramc = t.a.LF;
    }
  }
  
  public final void a(ax paramax)
  {
    AppMethodBeat.i(197770);
    androidx.core.f.f.checkNotNull(paramax);
    String str = e(paramax);
    paramax = paramax.JL;
    this.mExecutor.execute(new h..ExternalSyntheticLambda3(this, str, paramax));
    AppMethodBeat.o(197770);
  }
  
  final void a(bb parambb)
  {
    AppMethodBeat.i(197836);
    ScheduledExecutorService localScheduledExecutorService = androidx.camera.core.impl.a.a.f.kR();
    Object localObject = parambb.Nd;
    if (!((List)localObject).isEmpty())
    {
      localObject = (bb.c)((List)localObject).get(0);
      new Throwable();
      B("Posting surface closed");
      localScheduledExecutorService.execute(new h..ExternalSyntheticLambda8((bb.c)localObject, parambb));
    }
    AppMethodBeat.o(197836);
  }
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(197805);
    ??? = paramm;
    if (paramm == null) {
      ??? = o.jV();
    }
    paramm = ((m)???).jU();
    this.AR = ((m)???);
    synchronized (this.mLock)
    {
      this.AS = paramm;
      AppMethodBeat.o(197805);
      return;
    }
  }
  
  final boolean a(z.a parama)
  {
    AppMethodBeat.i(197842);
    if (!parama.LY.isEmpty())
    {
      al.R("Camera2CameraImpl");
      AppMethodBeat.o(197842);
      return false;
    }
    Iterator localIterator = this.Ax.kD().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = Collections.unmodifiableList(((bb)localIterator.next()).Ne.Fs);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          parama.b((ad)((Iterator)localObject).next());
        }
      }
    }
    if (parama.LY.isEmpty())
    {
      al.R("Camera2CameraImpl");
      AppMethodBeat.o(197842);
      return false;
    }
    AppMethodBeat.o(197842);
    return true;
  }
  
  public final void b(ax paramax)
  {
    AppMethodBeat.i(197778);
    androidx.core.f.f.checkNotNull(paramax);
    paramax = e(paramax);
    this.mExecutor.execute(new h..ExternalSyntheticLambda2(this, paramax));
    AppMethodBeat.o(197778);
  }
  
  public final void c(ax paramax)
  {
    AppMethodBeat.i(197785);
    androidx.core.f.f.checkNotNull(paramax);
    String str = e(paramax);
    paramax = paramax.JL;
    this.mExecutor.execute(new h..ExternalSyntheticLambda4(this, str, paramax));
    AppMethodBeat.o(197785);
  }
  
  public final void d(ax paramax)
  {
    AppMethodBeat.i(197794);
    androidx.core.f.f.checkNotNull(paramax);
    String str = e(paramax);
    paramax = paramax.JL;
    this.mExecutor.execute(new h..ExternalSyntheticLambda5(this, str, paramax));
    AppMethodBeat.o(197794);
  }
  
  public final void e(Collection<ax> paramCollection)
  {
    AppMethodBeat.i(197802);
    paramCollection = new ArrayList(paramCollection);
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(197802);
      return;
    }
    this.AC.gp();
    k(new ArrayList(paramCollection));
    paramCollection = new ArrayList(f(paramCollection));
    try
    {
      this.mExecutor.execute(new h..ExternalSyntheticLambda6(this, paramCollection));
      AppMethodBeat.o(197802);
      return;
    }
    catch (RejectedExecutionException paramCollection)
    {
      B("Unable to attach use cases.");
      this.AC.gq();
      AppMethodBeat.o(197802);
    }
  }
  
  public final void g(Collection<ax> paramCollection)
  {
    AppMethodBeat.i(197812);
    paramCollection = new ArrayList(paramCollection);
    if (paramCollection.isEmpty())
    {
      AppMethodBeat.o(197812);
      return;
    }
    ArrayList localArrayList = new ArrayList(f(paramCollection));
    l(new ArrayList(paramCollection));
    this.mExecutor.execute(new h..ExternalSyntheticLambda7(this, localArrayList));
    AppMethodBeat.o(197812);
  }
  
  final boolean gF()
  {
    AppMethodBeat.i(197752);
    if ((this.AK.isEmpty()) && (this.AM.isEmpty()))
    {
      AppMethodBeat.o(197752);
      return true;
    }
    AppMethodBeat.o(197752);
    return false;
  }
  
  final void gG()
  {
    AppMethodBeat.i(197755);
    if ((this.Az == c.Be) || (this.Az == c.Bc)) {}
    for (boolean bool = true;; bool = false)
    {
      androidx.core.f.f.b(bool, null);
      androidx.core.f.f.b(this.AK.isEmpty(), null);
      this.AF = null;
      if (this.Az != c.Bc) {
        break;
      }
      a(c.AY, null, true);
      AppMethodBeat.o(197755);
      return;
    }
    n localn = this.Au;
    a locala = this.AL;
    localn.Fh.b(locala);
    a(c.Bf, null, true);
    if (this.AJ != null)
    {
      this.AJ.ap(null);
      this.AJ = null;
    }
    AppMethodBeat.o(197755);
  }
  
  final void gH()
  {
    AppMethodBeat.i(197765);
    boolean bool;
    int i;
    if ((this.Az == c.Bc) || (this.Az == c.Be) || ((this.Az == c.Bd) && (this.AG != 0)))
    {
      bool = true;
      androidx.core.f.f.b(bool, "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.Az + " (error: " + aH(this.AG) + ")");
      if ((Build.VERSION.SDK_INT <= 23) || (Build.VERSION.SDK_INT >= 29)) {
        break label317;
      }
      if (((i)this.AE).gX() != 2) {
        break label312;
      }
      i = 1;
      label123:
      if ((i == 0) || (this.AG != 0)) {
        break label317;
      }
      aa localaa = new aa();
      this.AM.add(localaa);
      aa(false);
      Object localObject2 = new SurfaceTexture(0);
      ((SurfaceTexture)localObject2).setDefaultBufferSize(640, 480);
      Object localObject1 = new Surface((SurfaceTexture)localObject2);
      localObject2 = new h..ExternalSyntheticLambda0((Surface)localObject1, (SurfaceTexture)localObject2);
      bb.b localb = new bb.b();
      localObject1 = new ao((Surface)localObject1);
      localb.c((ad)localObject1);
      localb.aW(1);
      B("Start configAndClose.");
      localaa.a(localb.ky(), (CameraDevice)androidx.core.f.f.checkNotNull(this.AF), this.AP.hM()).a(new h..ExternalSyntheticLambda1(this, localaa, (ad)localObject1, (Runnable)localObject2), this.mExecutor);
    }
    for (;;)
    {
      this.AH.hi();
      AppMethodBeat.o(197765);
      return;
      bool = false;
      break;
      label312:
      i = 0;
      break label123;
      label317:
      aa(false);
    }
  }
  
  public final s gK()
  {
    return this.AE;
  }
  
  final void gL()
  {
    AppMethodBeat.i(197825);
    Object localObject2 = this.Ax;
    Object localObject1 = new bb.f();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((bj)localObject2).ND.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (Map.Entry)localIterator.next();
      bj.b localb = (bj.b)((Map.Entry)localObject3).getValue();
      if ((localb.mActive) && (localb.NE))
      {
        localObject3 = (String)((Map.Entry)localObject3).getKey();
        ((bb.f)localObject1).e(localb.Cj);
        localArrayList.add(localObject3);
      }
    }
    new StringBuilder("Active and attached use case: ").append(localArrayList).append(" for camera: ").append(((bj)localObject2).AW);
    al.O("UseCaseAttachState");
    if (((bb.f)localObject1).isValid())
    {
      localObject2 = ((bb.f)localObject1).ky();
      this.AC.aE(((bb)localObject2).Ne.LW);
      ((bb.f)localObject1).e(this.AC.gh());
      localObject1 = ((bb.f)localObject1).ky();
      this.AH.b((bb)localObject1);
      AppMethodBeat.o(197825);
      return;
    }
    this.AC.aE(1);
    this.AH.b(this.AC.gh());
    AppMethodBeat.o(197825);
  }
  
  final void gM()
  {
    AppMethodBeat.i(197833);
    if (this.Az == c.Bb) {}
    bb.f localf;
    for (boolean bool = true;; bool = false)
    {
      androidx.core.f.f.b(bool, null);
      localf = this.Ax.kE();
      if (localf.isValid()) {
        break;
      }
      B("Unable to create capture session due to conflicting configurations");
      AppMethodBeat.o(197833);
      return;
    }
    e.a(this.AH.a(localf.ky(), (CameraDevice)androidx.core.f.f.checkNotNull(this.AF), this.AP.hM()), new c()
    {
      public final void onFailure(Throwable paramAnonymousThrowable)
      {
        AppMethodBeat.i(197878);
        if ((paramAnonymousThrowable instanceof ad.a))
        {
          Object localObject = h.this;
          ad localad = ((ad.a)paramAnonymousThrowable).Dm;
          localObject = ((h)localObject).Ax.kC().iterator();
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            paramAnonymousThrowable = (bb)((Iterator)localObject).next();
          } while (!Collections.unmodifiableList(paramAnonymousThrowable.Fs).contains(localad));
          for (;;)
          {
            if (paramAnonymousThrowable != null) {
              h.this.a(paramAnonymousThrowable);
            }
            AppMethodBeat.o(197878);
            return;
            paramAnonymousThrowable = null;
          }
        }
        if ((paramAnonymousThrowable instanceof CancellationException))
        {
          h.this.B("Unable to configure camera cancelled");
          AppMethodBeat.o(197878);
          return;
        }
        if (h.this.Az == h.c.Bb) {
          h.this.a(h.c.Bb, r.a.a(4, paramAnonymousThrowable), true);
        }
        if ((paramAnonymousThrowable instanceof CameraAccessException))
        {
          h.this.B("Unable to configure camera due to " + paramAnonymousThrowable.getMessage());
          AppMethodBeat.o(197878);
          return;
        }
        if ((paramAnonymousThrowable instanceof TimeoutException))
        {
          new StringBuilder("Unable to configure camera ").append(h.this.AE.AW).append(", timeout!");
          al.T("Camera2CameraImpl");
        }
        AppMethodBeat.o(197878);
      }
    }, this.mExecutor);
    AppMethodBeat.o(197833);
  }
  
  public final p gO()
  {
    return this.AC;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197848);
    String str = String.format(Locale.US, "Camera@%x[id=%s]", new Object[] { Integer.valueOf(hashCode()), this.AE.AW });
    AppMethodBeat.o(197848);
    return str;
  }
  
  final class a
    extends CameraManager.AvailabilityCallback
    implements v.b
  {
    private final String AW;
    boolean AX = true;
    
    a(String paramString)
    {
      this.AW = paramString;
    }
    
    public final void gP()
    {
      AppMethodBeat.i(197796);
      if (h.this.Az == h.c.AZ) {
        h.this.Y(false);
      }
      AppMethodBeat.o(197796);
    }
    
    public final void onCameraAvailable(String paramString)
    {
      AppMethodBeat.i(197777);
      if (!this.AW.equals(paramString))
      {
        AppMethodBeat.o(197777);
        return;
      }
      this.AX = true;
      if (h.this.Az == h.c.AZ) {
        h.this.Y(false);
      }
      AppMethodBeat.o(197777);
    }
    
    public final void onCameraUnavailable(String paramString)
    {
      AppMethodBeat.i(197786);
      if (!this.AW.equals(paramString))
      {
        AppMethodBeat.o(197786);
        return;
      }
      this.AX = false;
      AppMethodBeat.o(197786);
    }
  }
  
  final class b
    implements p.b
  {
    b() {}
    
    public final void gQ()
    {
      AppMethodBeat.i(197763);
      h.this.gL();
      AppMethodBeat.o(197763);
    }
    
    public final void o(List<z> paramList)
    {
      AppMethodBeat.i(197773);
      h localh = h.this;
      Object localObject = (List)androidx.core.f.f.checkNotNull(paramList);
      paramList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        z localz = (z)((Iterator)localObject).next();
        z.a locala = z.a.a(localz);
        if ((!Collections.unmodifiableList(localz.Fs).isEmpty()) || (!localz.LX) || (localh.a(locala))) {
          paramList.add(locala.kc());
        }
      }
      localh.B("Issue capture request");
      localh.AH.s(paramList);
      AppMethodBeat.o(197773);
    }
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(197781);
      AY = new c("INITIALIZED", 0);
      AZ = new c("PENDING_OPEN", 1);
      Ba = new c("OPENING", 2);
      Bb = new c("OPENED", 3);
      Bc = new c("CLOSING", 4);
      Bd = new c("REOPENING", 5);
      Be = new c("RELEASING", 6);
      Bf = new c("RELEASED", 7);
      Bg = new c[] { AY, AZ, Ba, Bb, Bc, Bd, Be, Bf };
      AppMethodBeat.o(197781);
    }
    
    private c() {}
  }
  
  final class d
    extends CameraDevice.StateCallback
  {
    private b Bh;
    ScheduledFuture<?> Bi;
    final a Bj;
    private final Executor mExecutor;
    private final ScheduledExecutorService mScheduler;
    
    d(Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService)
    {
      AppMethodBeat.i(197780);
      this.Bj = new a();
      this.mExecutor = paramExecutor;
      this.mScheduler = paramScheduledExecutorService;
      AppMethodBeat.o(197780);
    }
    
    final void gR()
    {
      boolean bool2 = true;
      AppMethodBeat.i(197823);
      if (this.Bh == null)
      {
        bool1 = true;
        androidx.core.f.f.b(bool1, null);
        if (this.Bi != null) {
          break label121;
        }
      }
      label121:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        androidx.core.f.f.b(bool1, null);
        if (!this.Bj.gT()) {
          break label126;
        }
        this.Bh = new b(this.mExecutor);
        h.this.B("Attempting camera re-open in 700ms: " + this.Bh);
        this.Bi = this.mScheduler.schedule(this.Bh, 700L, TimeUnit.MILLISECONDS);
        AppMethodBeat.o(197823);
        return;
        bool1 = false;
        break;
      }
      label126:
      al.T("Camera2CameraImpl");
      h.this.a(h.c.AZ, null, false);
      AppMethodBeat.o(197823);
    }
    
    final boolean gS()
    {
      boolean bool = true;
      AppMethodBeat.i(197827);
      if (this.Bi != null)
      {
        h.this.B("Cancelling scheduled re-open: " + this.Bh);
        this.Bh.mCancelled = true;
        this.Bh = null;
        this.Bi.cancel(false);
        this.Bi = null;
      }
      for (;;)
      {
        AppMethodBeat.o(197827);
        return bool;
        bool = false;
      }
    }
    
    public final void onClosed(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(197800);
      h.this.B("CameraDevice.onClosed()");
      if (h.this.AF == null) {}
      for (boolean bool = true;; bool = false)
      {
        androidx.core.f.f.b(bool, "Unexpected onClose callback on camera device: ".concat(String.valueOf(paramCameraDevice)));
        switch (h.3.AV[h.this.Az.ordinal()])
        {
        case 4: 
        case 5: 
        default: 
          paramCameraDevice = new IllegalStateException("Camera closed while in state: " + h.this.Az);
          AppMethodBeat.o(197800);
          throw paramCameraDevice;
        }
      }
      androidx.core.f.f.b(h.this.gF(), null);
      h.this.gG();
      AppMethodBeat.o(197800);
      return;
      if (h.this.AG != 0)
      {
        h.this.B("Camera closed due to error: " + h.aH(h.this.AG));
        gR();
        AppMethodBeat.o(197800);
        return;
      }
      h.this.Y(false);
      AppMethodBeat.o(197800);
    }
    
    public final void onDisconnected(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(197806);
      h.this.B("CameraDevice.onDisconnected()");
      onError(paramCameraDevice, 1);
      AppMethodBeat.o(197806);
    }
    
    public final void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      boolean bool2 = false;
      AppMethodBeat.i(197816);
      h.this.AF = paramCameraDevice;
      h.this.AG = paramInt;
      switch (h.3.AV[h.this.Az.ordinal()])
      {
      default: 
        paramCameraDevice = new IllegalStateException("onError() should not be possible from state: " + h.this.Az);
        AppMethodBeat.o(197816);
        throw paramCameraDevice;
      case 3: 
      case 7: 
        String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", new Object[] { paramCameraDevice.getId(), h.aH(paramInt), h.this.Az.name() });
        al.T("Camera2CameraImpl");
        h.this.gH();
        AppMethodBeat.o(197816);
        return;
      }
      String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", new Object[] { paramCameraDevice.getId(), h.aH(paramInt), h.this.Az.name() });
      al.O("Camera2CameraImpl");
      boolean bool1;
      if ((h.this.Az == h.c.Ba) || (h.this.Az == h.c.Bb) || (h.this.Az == h.c.Bd))
      {
        bool1 = true;
        androidx.core.f.f.b(bool1, "Attempt to handle open error from non open state: " + h.this.Az);
        switch (paramInt)
        {
        case 3: 
        default: 
          new StringBuilder("Error observed on open (or opening) camera device ").append(paramCameraDevice.getId()).append(": ").append(h.aH(paramInt)).append(" closing camera.");
          al.T("Camera2CameraImpl");
          if (paramInt != 3) {
            break;
          }
        }
      }
      for (paramInt = 5;; paramInt = 6)
      {
        h.this.a(h.c.Bc, r.a.a(paramInt, null), true);
        h.this.gH();
        AppMethodBeat.o(197816);
        return;
        bool1 = false;
        break;
        String.format("Attempt to reopen camera[%s] after error[%s]", new Object[] { paramCameraDevice.getId(), h.aH(paramInt) });
        al.O("Camera2CameraImpl");
        bool1 = bool2;
        if (h.this.AG != 0) {
          bool1 = true;
        }
        androidx.core.f.f.b(bool1, "Can only reopen camera device after error if the camera device is actually in an error state.");
        switch (paramInt)
        {
        default: 
          paramInt = 3;
        }
        for (;;)
        {
          h.this.a(h.c.Bd, r.a.a(paramInt, null), true);
          h.this.gH();
          AppMethodBeat.o(197816);
          return;
          paramInt = 2;
          continue;
          paramInt = 1;
        }
      }
    }
    
    public final void onOpened(CameraDevice paramCameraDevice)
    {
      AppMethodBeat.i(197789);
      h.this.B("CameraDevice.onOpened()");
      h.this.AF = paramCameraDevice;
      h.this.AG = 0;
      switch (h.3.AV[h.this.Az.ordinal()])
      {
      case 4: 
      default: 
        paramCameraDevice = new IllegalStateException("onOpened() should not be possible from state: " + h.this.Az);
        AppMethodBeat.o(197789);
        throw paramCameraDevice;
      case 3: 
      case 7: 
        androidx.core.f.f.b(h.this.gF(), null);
        h.this.AF.close();
        h.this.AF = null;
        AppMethodBeat.o(197789);
        return;
      }
      h.this.a(h.c.Bb, null, true);
      h.this.gM();
      AppMethodBeat.o(197789);
    }
    
    final class a
    {
      long Bk = -1L;
      
      a() {}
      
      final boolean gT()
      {
        AppMethodBeat.i(197324);
        long l = SystemClock.uptimeMillis();
        if (this.Bk == -1L)
        {
          this.Bk = l;
          AppMethodBeat.o(197324);
          return true;
        }
        if (l - this.Bk >= 10000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.Bk = -1L;
          AppMethodBeat.o(197324);
          return false;
        }
        AppMethodBeat.o(197324);
        return true;
      }
    }
    
    final class b
      implements Runnable
    {
      boolean mCancelled = false;
      private Executor mExecutor;
      
      b(Executor paramExecutor)
      {
        this.mExecutor = paramExecutor;
      }
      
      public final void run()
      {
        AppMethodBeat.i(197349);
        this.mExecutor.execute(new h.d.b..ExternalSyntheticLambda0(this));
        AppMethodBeat.o(197349);
      }
    }
  }
  
  static abstract class e
  {
    abstract String gf();
    
    abstract Class<?> gg();
    
    abstract bb gh();
    
    abstract Size gi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.h
 * JD-Core Version:    0.7.0.1
 */