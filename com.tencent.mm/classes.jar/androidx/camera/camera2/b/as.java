package androidx.camera.camera2.b;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build.VERSION;
import android.os.Looper;
import androidx.c.a.b;
import androidx.c.a.b.a;
import androidx.camera.camera2.a.a.a;
import androidx.camera.camera2.b.a.h;
import androidx.camera.core.a.d;
import androidx.camera.core.ba;
import androidx.camera.core.impl.a.b.e;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;

final class as
{
  final f Bo;
  final at EK;
  final x<ba> EL;
  final a EM;
  private f.c EN;
  private final Executor mExecutor;
  boolean mIsActive;
  
  as(f paramf, h paramh, Executor paramExecutor)
  {
    AppMethodBeat.i(197354);
    this.mIsActive = false;
    this.EN = new f.c()
    {
      public final boolean onCaptureResult(TotalCaptureResult paramAnonymousTotalCaptureResult)
      {
        AppMethodBeat.i(197721);
        as.this.EM.a(paramAnonymousTotalCaptureResult);
        AppMethodBeat.o(197721);
        return false;
      }
    };
    this.Bo = paramf;
    this.mExecutor = paramExecutor;
    this.EM = a(paramh);
    this.EK = new at(this.EM.getMaxZoom(), this.EM.getMinZoom());
    this.EK.i(1.0F);
    this.EL = new x(d.b(this.EK));
    paramf.b(this.EN);
    AppMethodBeat.o(197354);
  }
  
  static a a(h paramh)
  {
    AppMethodBeat.i(197364);
    if (b(paramh))
    {
      paramh = new a(paramh);
      AppMethodBeat.o(197364);
      return paramh;
    }
    paramh = new ad(paramh);
    AppMethodBeat.o(197364);
    return paramh;
  }
  
  private static boolean b(h paramh)
  {
    AppMethodBeat.i(197375);
    if ((Build.VERSION.SDK_INT >= 30) && (paramh.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE) != null))
    {
      AppMethodBeat.o(197375);
      return true;
    }
    AppMethodBeat.o(197375);
    return false;
  }
  
  final void a(ba paramba)
  {
    AppMethodBeat.i(197456);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.EL.setValue(paramba);
      AppMethodBeat.o(197456);
      return;
    }
    this.EL.t(paramba);
    AppMethodBeat.o(197456);
  }
  
  final com.google.b.b.a.f<Void> h(float paramFloat)
  {
    AppMethodBeat.i(197445);
    synchronized (this.EK)
    {
      try
      {
        this.EK.i(paramFloat);
        ba localba = d.b(this.EK);
        a(localba);
        ??? = b.a(new as..ExternalSyntheticLambda0(this, localba));
        AppMethodBeat.o(197445);
        return ???;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        com.google.b.b.a.f localf = e.i(localIllegalArgumentException);
        AppMethodBeat.o(197445);
        return localf;
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a(float paramFloat, b.a<Void> parama);
    
    public abstract void a(TotalCaptureResult paramTotalCaptureResult);
    
    public abstract void a(a.a parama);
    
    public abstract void gd();
    
    public abstract Rect ge();
    
    public abstract float getMaxZoom();
    
    public abstract float getMinZoom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.camera.camera2.b.as
 * JD-Core Version:    0.7.0.1
 */