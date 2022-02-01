package androidx.camera.camera2.b;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.view.Surface;
import androidx.c.a.a;
import androidx.c.a.b.a;
import androidx.c.a.b.d;
import androidx.camera.camera2.b.a.a.g;
import androidx.camera.core.al;
import androidx.camera.core.impl.a.b.d;
import androidx.camera.core.impl.a.b.e;
import androidx.camera.core.impl.ad;
import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

final class ao
  extends an
{
  private final CameraCaptureSession.CaptureCallback Cd;
  f<List<Surface>> Eo;
  private final Object Et;
  private final Set<String> Eu;
  private final f<Void> Ev;
  b.a<Void> Ew;
  private List<ad> Ex;
  f<Void> Ey;
  private boolean Ez;
  
  ao(Set<String> paramSet, ac paramac, Executor paramExecutor, ScheduledExecutorService paramScheduledExecutorService, Handler paramHandler)
  {
    super(paramac, paramExecutor, paramScheduledExecutorService, paramHandler);
    AppMethodBeat.i(197401);
    this.Et = new Object();
    this.Cd = new CameraCaptureSession.CaptureCallback()
    {
      public final void onCaptureSequenceAborted(CameraCaptureSession paramAnonymousCameraCaptureSession, int paramAnonymousInt)
      {
        paramAnonymousInt = 1;
        AppMethodBeat.i(197793);
        if (ao.this.Ew != null)
        {
          paramAnonymousCameraCaptureSession = ao.this.Ew;
          paramAnonymousCameraCaptureSession.bfX = true;
          b.d locald = paramAnonymousCameraCaptureSession.bfV;
          if ((locald == null) || (!locald.bfZ.cancel(true))) {
            break label72;
          }
        }
        for (;;)
        {
          if (paramAnonymousInt != 0) {
            paramAnonymousCameraCaptureSession.Cp();
          }
          ao.this.Ew = null;
          AppMethodBeat.o(197793);
          return;
          label72:
          paramAnonymousInt = 0;
        }
      }
      
      public final void onCaptureStarted(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(197782);
        if (ao.this.Ew != null)
        {
          ao.this.Ew.ap(null);
          ao.this.Ew = null;
        }
        AppMethodBeat.o(197782);
      }
    };
    this.Eu = paramSet;
    if (paramSet.contains("wait_for_request"))
    {
      this.Ev = androidx.c.a.b.a(new ao..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(197401);
      return;
    }
    this.Ev = e.v(null);
    AppMethodBeat.o(197401);
  }
  
  private void G(String paramString)
  {
    AppMethodBeat.i(197460);
    new StringBuilder("[").append(this).append("] ").append(paramString);
    al.O("SyncCaptureSessionImpl");
    AppMethodBeat.o(197460);
  }
  
  private static void b(Set<am> paramSet)
  {
    AppMethodBeat.i(197433);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      am localam = (am)paramSet.next();
      localam.hD().i(localam);
    }
    AppMethodBeat.o(197433);
  }
  
  private static void c(Set<am> paramSet)
  {
    AppMethodBeat.i(197447);
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      am localam = (am)paramSet.next();
      localam.hD().d(localam);
    }
    AppMethodBeat.o(197447);
  }
  
  private void hL()
  {
    AppMethodBeat.i(197419);
    synchronized (this.Et)
    {
      if (this.Ex == null)
      {
        G("deferrableSurface == null, maybe forceClose, skip close");
        AppMethodBeat.o(197419);
        return;
      }
      if (!this.Eu.contains("deferrableSurface_close")) {
        break label97;
      }
      Iterator localIterator = this.Ex.iterator();
      if (localIterator.hasNext()) {
        ((ad)localIterator.next()).close();
      }
    }
    G("deferrableSurface closed");
    label97:
    AppMethodBeat.o(197419);
  }
  
  public final f<Void> F(String paramString)
  {
    AppMethodBeat.i(197532);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        paramString = super.F(paramString);
        AppMethodBeat.o(197532);
        return paramString;
        if (paramString.equals("wait_for_request")) {
          i = 0;
        }
        break;
      }
    }
    paramString = e.d(this.Ev);
    AppMethodBeat.o(197532);
    return paramString;
  }
  
  public final int a(CaptureRequest paramCaptureRequest, CameraCaptureSession.CaptureCallback paramCaptureCallback)
  {
    AppMethodBeat.i(197563);
    if (this.Eu.contains("wait_for_request")) {
      synchronized (this.Et)
      {
        this.Ez = true;
        i = super.a(paramCaptureRequest, j.p(Arrays.asList(new CameraCaptureSession.CaptureCallback[] { this.Cd, paramCaptureCallback })));
        AppMethodBeat.o(197563);
        return i;
      }
    }
    int i = super.a(paramCaptureRequest, paramCaptureCallback);
    AppMethodBeat.o(197563);
    return i;
  }
  
  public final f<Void> a(CameraDevice paramCameraDevice, g paramg, List<ad> paramList)
  {
    AppMethodBeat.i(197519);
    ArrayList localArrayList;
    synchronized (this.Et)
    {
      Object localObject2 = this.AO.hk();
      localArrayList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext()) {
        localArrayList.add(((am)((Iterator)localObject2).next()).F("wait_for_request"));
      }
    }
    this.Ey = d.c(e.i(localArrayList)).a(new ao..ExternalSyntheticLambda1(this, paramCameraDevice, paramg, paramList), androidx.camera.core.impl.a.a.b.kP());
    paramCameraDevice = e.d(this.Ey);
    AppMethodBeat.o(197519);
    return paramCameraDevice;
  }
  
  public final f<List<Surface>> a(List<ad> paramList, long paramLong)
  {
    AppMethodBeat.i(197538);
    synchronized (this.Et)
    {
      this.Ex = paramList;
      paramList = e.d(super.a(paramList, paramLong));
      AppMethodBeat.o(197538);
      return paramList;
    }
  }
  
  public final void a(am paramam)
  {
    AppMethodBeat.i(197577);
    G("Session onConfigured()");
    LinkedHashSet localLinkedHashSet;
    Iterator localIterator;
    am localam;
    if (this.Eu.contains("force_close"))
    {
      localLinkedHashSet = new LinkedHashSet();
      localIterator = this.AO.hl().iterator();
      while (localIterator.hasNext())
      {
        localam = (am)localIterator.next();
        if (localam == paramam) {
          break;
        }
        localLinkedHashSet.add(localam);
      }
      c(localLinkedHashSet);
    }
    super.a(paramam);
    if (this.Eu.contains("force_close"))
    {
      localLinkedHashSet = new LinkedHashSet();
      localIterator = this.AO.hj().iterator();
      while (localIterator.hasNext())
      {
        localam = (am)localIterator.next();
        if (localam == paramam) {
          break;
        }
        localLinkedHashSet.add(localam);
      }
      b(localLinkedHashSet);
    }
    AppMethodBeat.o(197577);
  }
  
  public final void close()
  {
    AppMethodBeat.i(197592);
    G("Session call close()");
    if (this.Eu.contains("wait_for_request")) {}
    synchronized (this.Et)
    {
      if (!this.Ez) {
        this.Ev.cancel(true);
      }
      this.Ev.a(new ao..ExternalSyntheticLambda2(this), this.mExecutor);
      AppMethodBeat.o(197592);
      return;
    }
  }
  
  public final void i(am paramam)
  {
    AppMethodBeat.i(197598);
    hL();
    G("onClosed()");
    super.i(paramam);
    AppMethodBeat.o(197598);
  }
  
  public final boolean stop()
  {
    AppMethodBeat.i(197550);
    synchronized (this.Et)
    {
      if (hH()) {
        hL();
      }
      do
      {
        boolean bool = super.stop();
        AppMethodBeat.o(197550);
        return bool;
        if (this.Ey != null) {
          this.Ey.cancel(true);
        }
      } while (this.Eo == null);
      this.Eo.cancel(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.ao
 * JD-Core Version:    0.7.0.1
 */