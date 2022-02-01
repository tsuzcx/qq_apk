package androidx.camera.camera2.b;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Key;
import android.hardware.camera2.TotalCaptureResult;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.c.a.b.a;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.b.a.b.g;
import androidx.camera.camera2.c.c;
import androidx.camera.camera2.c.c.a;
import androidx.camera.core.al;
import androidx.camera.core.ba;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ac;
import androidx.camera.core.impl.ac.a;
import androidx.camera.core.impl.ac.c;
import androidx.camera.core.impl.az;
import androidx.camera.core.impl.bb;
import androidx.camera.core.impl.bb.b;
import androidx.camera.core.impl.bi;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.p;
import androidx.camera.core.impl.p.b;
import androidx.camera.core.impl.z.a;
import androidx.camera.core.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

public final class f
  implements p
{
  final as Aa;
  final ar Ab;
  private final af Ac;
  private final androidx.camera.camera2.c.a Ad;
  private final l Ae;
  private int Af;
  volatile boolean Ag;
  private volatile int Ah;
  private final androidx.camera.camera2.b.a.c.a Ai;
  private final androidx.camera.camera2.b.a.c.b Aj;
  private final AtomicLong Ak;
  private volatile com.google.b.b.a.f<Void> Al;
  private int Am;
  private long An;
  private final a Ao;
  final Executor mExecutor;
  private final Object mLock;
  final androidx.camera.camera2.b.a.h zI;
  final b zW;
  private final p.b zX;
  private final bb.b zY;
  final ah zZ;
  
  f(androidx.camera.camera2.b.a.h paramh, ScheduledExecutorService paramScheduledExecutorService, Executor paramExecutor, p.b paramb, az paramaz)
  {
    AppMethodBeat.i(197562);
    this.mLock = new Object();
    this.zY = new bb.b();
    this.Af = 0;
    this.Ag = false;
    this.Ah = 2;
    this.Aj = new androidx.camera.camera2.b.a.c.b();
    this.Ak = new AtomicLong(0L);
    this.Al = e.v(null);
    this.Am = 1;
    this.An = 0L;
    this.Ao = new a();
    this.zI = paramh;
    this.zX = paramb;
    this.mExecutor = paramExecutor;
    this.zW = new b(this.mExecutor);
    this.zY.aW(this.Am);
    this.zY.c(y.b(this.zW));
    this.zY.c(this.Ao);
    this.Ac = new af(this, this.zI, this.mExecutor);
    this.zZ = new ah(this, paramScheduledExecutorService, this.mExecutor);
    this.Aa = new as(this, this.zI, this.mExecutor);
    this.Ab = new ar(this, this.zI, this.mExecutor);
    this.Ai = new androidx.camera.camera2.b.a.c.a(paramaz);
    this.Ad = new androidx.camera.camera2.c.a(this, this.mExecutor);
    this.Ae = new l(this, this.zI, paramaz, this.mExecutor);
    this.mExecutor.execute(new f..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(197562);
  }
  
  static boolean a(TotalCaptureResult paramTotalCaptureResult, long paramLong)
  {
    AppMethodBeat.i(197578);
    if (paramTotalCaptureResult.getRequest() == null)
    {
      AppMethodBeat.o(197578);
      return false;
    }
    paramTotalCaptureResult = paramTotalCaptureResult.getRequest().getTag();
    if ((paramTotalCaptureResult instanceof bi))
    {
      paramTotalCaptureResult = (Long)((bi)paramTotalCaptureResult).getTag("CameraControlSessionUpdateId");
      if (paramTotalCaptureResult == null)
      {
        AppMethodBeat.o(197578);
        return false;
      }
      if (paramTotalCaptureResult.longValue() >= paramLong)
      {
        AppMethodBeat.o(197578);
        return true;
      }
    }
    AppMethodBeat.o(197578);
    return false;
  }
  
  private static boolean b(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == paramArrayOfInt[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private int gr()
  {
    synchronized (this.mLock)
    {
      int i = this.Af;
      return i;
    }
  }
  
  private boolean gu()
  {
    AppMethodBeat.i(197585);
    if (gr() > 0)
    {
      AppMethodBeat.o(197585);
      return true;
    }
    AppMethodBeat.o(197585);
    return false;
  }
  
  final void X(boolean paramBoolean)
  {
    AppMethodBeat.i(197807);
    this.Ag = paramBoolean;
    if (!paramBoolean)
    {
      z.a locala = new z.a();
      locala.LW = this.Am;
      locala.LX = true;
      a.a locala1 = new a.a();
      locala1.a(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(aG(1)));
      locala1.a(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      locala.j(locala1.fV());
      i(Collections.singletonList(locala.kc()));
    }
    gw();
    AppMethodBeat.o(197807);
  }
  
  public final com.google.b.b.a.f<androidx.camera.core.z> a(androidx.camera.core.y paramy)
  {
    AppMethodBeat.i(197726);
    if (!gu())
    {
      paramy = e.i(new k.a("Camera is not active."));
      AppMethodBeat.o(197726);
      return paramy;
    }
    paramy = e.d(this.zZ.a(paramy));
    AppMethodBeat.o(197726);
    return paramy;
  }
  
  public final com.google.b.b.a.f<List<Void>> a(List<androidx.camera.core.impl.z> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(197739);
    if (!gu())
    {
      al.R("Camera2CameraControlImp");
      paramList = e.i(new k.a("Camera is not active."));
      AppMethodBeat.o(197739);
      return paramList;
    }
    int i = this.Ah;
    paramList = androidx.camera.core.impl.a.b.d.c(this.Al).a(new f..ExternalSyntheticLambda3(this, paramList, paramInt1, i, paramInt2), this.mExecutor);
    AppMethodBeat.o(197739);
    return paramList;
  }
  
  public final void a(Rational paramRational)
  {
    this.zZ.CU = paramRational;
  }
  
  final void a(c paramc)
  {
    AppMethodBeat.i(197784);
    this.zW.c(paramc);
    AppMethodBeat.o(197784);
  }
  
  final void a(Executor paramExecutor, androidx.camera.core.impl.h paramh)
  {
    AppMethodBeat.i(197801);
    this.mExecutor.execute(new f..ExternalSyntheticLambda7(this, paramExecutor, paramh));
    AppMethodBeat.o(197801);
  }
  
  final void aE(int paramInt)
  {
    this.Am = paramInt;
    this.zZ.Am = this.Am;
    this.Ae.Am = this.Am;
  }
  
  final int aF(int paramInt)
  {
    AppMethodBeat.i(197815);
    int[] arrayOfInt = (int[])this.zI.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
    if (arrayOfInt == null)
    {
      AppMethodBeat.o(197815);
      return 0;
    }
    if (b(paramInt, arrayOfInt))
    {
      AppMethodBeat.o(197815);
      return paramInt;
    }
    if (b(4, arrayOfInt))
    {
      AppMethodBeat.o(197815);
      return 4;
    }
    if (b(1, arrayOfInt))
    {
      AppMethodBeat.o(197815);
      return 1;
    }
    AppMethodBeat.o(197815);
    return 0;
  }
  
  final int aG(int paramInt)
  {
    AppMethodBeat.i(197822);
    int[] arrayOfInt = (int[])this.zI.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
    if (arrayOfInt == null)
    {
      AppMethodBeat.o(197822);
      return 0;
    }
    if (b(paramInt, arrayOfInt))
    {
      AppMethodBeat.o(197822);
      return paramInt;
    }
    if (b(1, arrayOfInt))
    {
      AppMethodBeat.o(197822);
      return 1;
    }
    AppMethodBeat.o(197822);
    return 0;
  }
  
  final void b(c paramc)
  {
    AppMethodBeat.i(197795);
    this.zW.Ar.add(paramc);
    AppMethodBeat.o(197795);
  }
  
  public final void b(ac paramac)
  {
    AppMethodBeat.i(197703);
    this.Ad.a(c.a.c(paramac).ir()).a(f..ExternalSyntheticLambda8.INSTANCE, androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(197703);
  }
  
  final Rect ge()
  {
    AppMethodBeat.i(197771);
    Rect localRect = this.Aa.EM.ge();
    AppMethodBeat.o(197771);
    return localRect;
  }
  
  public final bb gh()
  {
    int j = 1;
    AppMethodBeat.i(197751);
    this.zY.aW(this.Am);
    Object localObject1 = this.zY;
    a.a locala = new a.a();
    locala.a(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
    Object localObject2 = this.zZ;
    int i;
    Object localObject3;
    if (((ah)localObject2).CW)
    {
      i = 1;
      locala.a(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(((ah)localObject2).By.aF(i)));
      if (((ah)localObject2).De.length != 0) {
        locala.a(CaptureRequest.CONTROL_AF_REGIONS, ((ah)localObject2).De);
      }
      if (((ah)localObject2).Df.length != 0) {
        locala.a(CaptureRequest.CONTROL_AE_REGIONS, ((ah)localObject2).Df);
      }
      if (((ah)localObject2).Dg.length != 0) {
        locala.a(CaptureRequest.CONTROL_AWB_REGIONS, ((ah)localObject2).Dg);
      }
      localObject2 = this.Ai;
      if (((androidx.camera.camera2.b.a.c.a)localObject2).FQ != null) {
        locala.a(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, ((androidx.camera.camera2.b.a.c.a)localObject2).FQ);
      }
      this.Aa.EM.a(locala);
      if (!this.Ag) {
        break label388;
      }
      locala.a(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
      i = 1;
      locala.a(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(aG(i)));
      localObject2 = CaptureRequest.CONTROL_AWB_MODE;
      localObject3 = (int[])this.zI.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
      if (localObject3 == null) {
        break label468;
      }
      if (!b(1, (int[])localObject3)) {
        break label457;
      }
      i = j;
    }
    for (;;)
    {
      locala.a((CaptureRequest.Key)localObject2, Integer.valueOf(i));
      localObject2 = this.Ac;
      locala.a(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(((af)localObject2).CQ.hs()));
      localObject2 = this.Ad.ip();
      localObject3 = ((ac)localObject2).ke().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ac.a locala1 = (ac.a)((Iterator)localObject3).next();
        locala.zH.a(locala1, ac.c.Mb, ((ac)localObject2).b(locala1));
      }
      i = ((ah)localObject2).hu();
      break;
      label388:
      switch (this.Ah)
      {
      default: 
        i = 1;
        break;
      case 2: 
        i = 1;
        break;
      case 1: 
        i = 3;
        break;
      case 0: 
        if ((g)androidx.camera.camera2.b.a.b.h.f(g.class) != null)
        {
          i = 1;
          break;
        }
        i = 2;
        break;
        label457:
        i = j;
        if (!b(1, (int[])localObject3)) {
          label468:
          i = 0;
        }
        break;
      }
    }
    ((bb.b)localObject1).i(locala.fV());
    localObject1 = this.Ad.ip().Dp.b(androidx.camera.camera2.a.a.zG, null);
    if ((localObject1 != null) && ((localObject1 instanceof Integer))) {
      this.zY.g("Camera2CameraControl", localObject1);
    }
    this.zY.g("CameraControlSessionUpdateId", Long.valueOf(this.An));
    localObject1 = this.zY.ky();
    AppMethodBeat.o(197751);
    return localObject1;
  }
  
  final void gp()
  {
    synchronized (this.mLock)
    {
      this.Af += 1;
      return;
    }
  }
  
  final void gq()
  {
    AppMethodBeat.i(197697);
    synchronized (this.mLock)
    {
      if (this.Af == 0)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("Decrementing use count occurs more times than incrementing");
        AppMethodBeat.o(197697);
        throw localIllegalStateException;
      }
    }
    this.Af -= 1;
    AppMethodBeat.o(197697);
  }
  
  public final void gs()
  {
    AppMethodBeat.i(197707);
    this.Ad.in().a(f..ExternalSyntheticLambda9.INSTANCE, androidx.camera.core.impl.a.a.b.kP());
    AppMethodBeat.o(197707);
  }
  
  public final ac gt()
  {
    AppMethodBeat.i(197712);
    androidx.camera.camera2.a.a locala = this.Ad.ip();
    AppMethodBeat.o(197712);
    return locala;
  }
  
  public final void gv()
  {
    AppMethodBeat.i(197758);
    this.mExecutor.execute(new f..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(197758);
  }
  
  final long gw()
  {
    AppMethodBeat.i(197766);
    this.An = this.Ak.getAndIncrement();
    this.zX.gQ();
    long l = this.An;
    AppMethodBeat.o(197766);
    return l;
  }
  
  public final Rect gx()
  {
    AppMethodBeat.i(197779);
    Rect localRect = (Rect)androidx.core.f.f.checkNotNull((Rect)this.zI.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    AppMethodBeat.o(197779);
    return localRect;
  }
  
  public final com.google.b.b.a.f<Void> h(float paramFloat)
  {
    AppMethodBeat.i(197730);
    if (!gu())
    {
      localf = e.i(new k.a("Camera is not active."));
      AppMethodBeat.o(197730);
      return localf;
    }
    com.google.b.b.a.f localf = e.d(this.Aa.h(paramFloat));
    AppMethodBeat.o(197730);
    return localf;
  }
  
  final void i(List<androidx.camera.core.impl.z> paramList)
  {
    AppMethodBeat.i(197814);
    this.zX.o(paramList);
    AppMethodBeat.o(197814);
  }
  
  final void setActive(boolean paramBoolean)
  {
    AppMethodBeat.i(197720);
    ??? = this.zZ;
    if (paramBoolean != ((ah)???).mIsActive)
    {
      ((ah)???).mIsActive = paramBoolean;
      if (!((ah)???).mIsActive) {
        ((ah)???).hw();
      }
    }
    Object localObject2 = this.Aa;
    if (((as)localObject2).mIsActive != paramBoolean)
    {
      ((as)localObject2).mIsActive = paramBoolean;
      if (((as)localObject2).mIsActive) {}
    }
    Object localObject5;
    synchronized (((as)localObject2).EK)
    {
      ((as)localObject2).EK.i(1.0F);
      localObject5 = androidx.camera.core.a.d.b(((as)localObject2).EK);
      ((as)localObject2).a((ba)localObject5);
      ((as)localObject2).EM.gd();
      ((as)localObject2).Bo.gw();
      ??? = this.Ab;
      if (((ar)???).mIsActive != paramBoolean)
      {
        ((ar)???).mIsActive = paramBoolean;
        if (!paramBoolean)
        {
          if (((ar)???).EJ)
          {
            ((ar)???).EJ = false;
            ((ar)???).Bo.X(false);
            ar.a(((ar)???).EG, Integer.valueOf(0));
          }
          if (((ar)???).EI != null)
          {
            ((ar)???).EI.h(new k.a("Camera is not active."));
            ((ar)???).EI = null;
          }
        }
      }
      localObject2 = this.Ac;
      if (paramBoolean != ((af)localObject2).mIsActive)
      {
        ((af)localObject2).mIsActive = paramBoolean;
        if (!((af)localObject2).mIsActive) {
          localObject5 = ((af)localObject2).CQ;
        }
      }
    }
    synchronized (((ag)localObject5).mLock)
    {
      ((ag)localObject5).CT = 0;
      if (((af)localObject2).CR != null)
      {
        ((af)localObject2).CR.h(new k.a("Cancelled by another setExposureCompensationIndex()"));
        ((af)localObject2).CR = null;
      }
      if (((af)localObject2).CS != null)
      {
        ((af)localObject2).By.a(((af)localObject2).CS);
        ((af)localObject2).CS = null;
      }
      this.Ad.setActive(paramBoolean);
      AppMethodBeat.o(197720);
      return;
      localObject3 = finally;
      AppMethodBeat.o(197720);
      throw localObject3;
    }
  }
  
  public final void setFlashMode(int paramInt)
  {
    AppMethodBeat.i(197736);
    if (!gu())
    {
      al.R("Camera2CameraControlImp");
      AppMethodBeat.o(197736);
      return;
    }
    this.Ah = paramInt;
    this.Al = e.d(androidx.c.a.b.a(new f..ExternalSyntheticLambda0(this)));
    AppMethodBeat.o(197736);
  }
  
  static final class a
    extends androidx.camera.core.impl.h
  {
    Set<androidx.camera.core.impl.h> Ap;
    Map<androidx.camera.core.impl.h, Executor> Aq;
    
    a()
    {
      AppMethodBeat.i(197735);
      this.Ap = new HashSet();
      this.Aq = new ArrayMap();
      AppMethodBeat.o(197735);
    }
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(197799);
      Iterator localIterator = this.Ap.iterator();
      while (localIterator.hasNext())
      {
        androidx.camera.core.impl.h localh = (androidx.camera.core.impl.h)localIterator.next();
        try
        {
          ((Executor)this.Aq.get(localh)).execute(new f.a..ExternalSyntheticLambda1(localh, paramj));
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          al.U("Camera2CameraControlImp");
        }
      }
      AppMethodBeat.o(197799);
    }
    
    public final void a(androidx.camera.core.impl.l paraml)
    {
      AppMethodBeat.i(197787);
      Iterator localIterator = this.Ap.iterator();
      while (localIterator.hasNext())
      {
        androidx.camera.core.impl.h localh = (androidx.camera.core.impl.h)localIterator.next();
        try
        {
          ((Executor)this.Aq.get(localh)).execute(new f.a..ExternalSyntheticLambda2(localh, paraml));
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          al.U("Camera2CameraControlImp");
        }
      }
      AppMethodBeat.o(197787);
    }
    
    public final void gB()
    {
      AppMethodBeat.i(197809);
      Iterator localIterator = this.Ap.iterator();
      while (localIterator.hasNext())
      {
        androidx.camera.core.impl.h localh = (androidx.camera.core.impl.h)localIterator.next();
        try
        {
          ((Executor)this.Aq.get(localh)).execute(new f.a..ExternalSyntheticLambda0(localh));
        }
        catch (RejectedExecutionException localRejectedExecutionException)
        {
          al.U("Camera2CameraControlImp");
        }
      }
      AppMethodBeat.o(197809);
    }
  }
  
  static final class b
    extends CameraCaptureSession.CaptureCallback
  {
    final Set<f.c> Ar;
    private final Executor mExecutor;
    
    b(Executor paramExecutor)
    {
      AppMethodBeat.i(197733);
      this.Ar = new HashSet();
      this.mExecutor = paramExecutor;
      AppMethodBeat.o(197733);
    }
    
    final void c(f.c paramc)
    {
      AppMethodBeat.i(197754);
      this.Ar.remove(paramc);
      AppMethodBeat.o(197754);
    }
    
    public final void onCaptureCompleted(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, TotalCaptureResult paramTotalCaptureResult)
    {
      AppMethodBeat.i(197764);
      this.mExecutor.execute(new f.b..ExternalSyntheticLambda0(this, paramTotalCaptureResult));
      AppMethodBeat.o(197764);
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean onCaptureResult(TotalCaptureResult paramTotalCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.f
 * JD-Core Version:    0.7.0.1
 */