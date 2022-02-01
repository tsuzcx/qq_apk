package com.tencent.mm.media.widget.a;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/media/widget/camera/CameraHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "TAG", "", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "curZoomStep", "", "getCurZoomStep$plugin_mediaeditor_release", "()I", "setCurZoomStep$plugin_mediaeditor_release", "(I)V", "displayH", "getDisplayH$plugin_mediaeditor_release", "setDisplayH$plugin_mediaeditor_release", "displayW", "getDisplayW$plugin_mediaeditor_release", "setDisplayW$plugin_mediaeditor_release", "focusMode", "getFocusMode$plugin_mediaeditor_release", "()Ljava/lang/String;", "setFocusMode$plugin_mediaeditor_release", "(Ljava/lang/String;)V", "forInitialize", "getForInitialize$plugin_mediaeditor_release", "setForInitialize$plugin_mediaeditor_release", "sAutoFocusBack", "getSAutoFocusBack$plugin_mediaeditor_release", "setSAutoFocusBack$plugin_mediaeditor_release", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "touchX", "", "getTouchX$plugin_mediaeditor_release", "()F", "setTouchX$plugin_mediaeditor_release", "(F)V", "touchY", "getTouchY$plugin_mediaeditor_release", "setTouchY$plugin_mediaeditor_release", "zoomed", "getZoomed$plugin_mediaeditor_release", "setZoomed$plugin_mediaeditor_release", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "calculateTapArea$plugin_mediaeditor_release", "clamp", "min", "max", "clamp$plugin_mediaeditor_release", "getTargetZoomStep", "params", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getTargetZoomStep$plugin_mediaeditor_release", "getTargetZoomValue", "getTargetZoomValue$plugin_mediaeditor_release", "handleMessage", "", "msg", "Landroid/os/Message;", "trigetAutoFocus", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "trigetAutoFocus$plugin_mediaeditor_release", "triggerAutoFocus", "triggerAutoFocus$plugin_mediaeditor_release", "Companion", "plugin-mediaeditor_release"})
public final class c
  extends ap
{
  private static final int hpD = 4353;
  private static final int hpE = 4354;
  private static final int hpF = 10;
  private static final int hpG = 20;
  private static final int hpH = 6;
  public static final c.a hpI;
  private final String TAG;
  float gmK;
  float gmL;
  boolean hpA;
  String hpB;
  private Camera.AutoFocusCallback hpC;
  private int hpu;
  boolean hpv;
  private boolean hpw;
  boolean hpx;
  int hpy;
  int hpz;
  
  static
  {
    AppMethodBeat.i(94016);
    hpI = new c.a((byte)0);
    hpD = 4353;
    hpE = 4354;
    hpF = 10;
    hpG = 20;
    hpH = 6;
    AppMethodBeat.o(94016);
  }
  
  public c(Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(94015);
    this.TAG = "MicroMsg.CameraHandler";
    this.hpA = true;
    this.hpB = "auto";
    this.hpC = ((Camera.AutoFocusCallback)new b(this));
    AppMethodBeat.o(94015);
  }
  
  private int a(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(94013);
    if (paramParameters == null)
    {
      AppMethodBeat.o(94013);
      return 0;
    }
    try
    {
      int j = paramParameters.getMaxZoom() / 2;
      i = j;
      if (j <= 0) {
        i = paramParameters.getMaxZoom();
      }
    }
    catch (Exception paramParameters)
    {
      for (;;)
      {
        ad.e(this.TAG, "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
        int i = 0;
      }
    }
    AppMethodBeat.o(94013);
    return i;
  }
  
  private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(94012);
    paramFloat3 = 80.0F * paramFloat3;
    paramFloat1 /= paramInt1;
    paramFloat2 /= paramInt2;
    paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    Object localObject = new RectF();
    ((RectF)localObject).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
    localObject = new Rect(nV(Math.round(((RectF)localObject).left)), nV(Math.round(((RectF)localObject).top)), nV(Math.round(((RectF)localObject).right)), nV(Math.round(((RectF)localObject).bottom)));
    AppMethodBeat.o(94012);
    return localObject;
  }
  
  private static int nV(int paramInt)
  {
    int i;
    if (paramInt > 1000) {
      i = 1000;
    }
    do
    {
      return i;
      i = paramInt;
    } while (paramInt >= -1000);
    return -1000;
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int j = 1;
    AppMethodBeat.i(94014);
    p.h(paramMessage, "msg");
    int i = paramMessage.what;
    Object localObject1;
    Object localObject2;
    Camera.Parameters localParameters;
    if (i == hpE)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new d.v("null cannot be cast to non-null type com.tencent.mm.compatible.deviceinfo.MCamera");
        AppMethodBeat.o(94014);
        throw paramMessage;
      }
      paramMessage = (com.tencent.mm.compatible.deviceinfo.v)paramMessage;
      if ((this.hpy == 0) || (this.hpz == 0) || (d.lz(14)))
      {
        if (paramMessage == null)
        {
          ad.w(this.TAG, "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(94014);
          return;
        }
        if (!this.hpA)
        {
          ad.w(this.TAG, "auto focus not back");
          AppMethodBeat.o(94014);
          return;
        }
        this.hpA = false;
        localObject1 = paramMessage.getParameters();
        p.g(localObject1, "camera.parameters");
        this.hpB = ((Camera.Parameters)localObject1).getFocusMode();
        try
        {
          ad.i(this.TAG, "triggerAutoFocus");
          paramMessage.cancelAutoFocus();
          paramMessage.autoFocus(this.hpC);
          AppMethodBeat.o(94014);
          return;
        }
        catch (Exception paramMessage)
        {
          ad.w(this.TAG, "autofocus fail, exception %s", new Object[] { paramMessage.getMessage() });
          this.hpA = true;
          AppMethodBeat.o(94014);
          return;
        }
      }
      float f1 = this.gmK;
      float f2 = this.gmL;
      i = this.hpy;
      j = this.hpz;
      if (paramMessage == null)
      {
        ad.w(this.TAG, "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(94014);
        return;
      }
      if (!this.hpA)
      {
        ad.w(this.TAG, "auto focus not back");
        AppMethodBeat.o(94014);
        return;
      }
      this.hpA = false;
      try
      {
        localObject1 = paramMessage.getParameters();
        p.g(localObject1, "camera.parameters");
        this.hpB = ((Camera.Parameters)localObject1).getFocusMode();
        paramMessage.cancelAutoFocus();
        ad.i(this.TAG, "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
        localObject2 = a(f1, f2, 1.0F, i, j);
        localObject1 = a(f1, f2, 1.5F, i, j);
        ad.i(this.TAG, "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
        localParameters = paramMessage.getParameters();
        p.g(localParameters, "parameters");
        Object localObject3 = localParameters.getSupportedFocusModes();
        if ((localObject3 != null) && (((List)localObject3).contains("auto"))) {
          localParameters.setFocusMode("auto");
        }
        if (localParameters.getMaxNumFocusAreas() > 0)
        {
          localObject3 = new ArrayList(1);
          ((ArrayList)localObject3).add(new Camera.Area((Rect)localObject2, 1000));
          localParameters.setFocusAreas((List)localObject3);
        }
        if (localParameters.getMaxNumMeteringAreas() > 0)
        {
          localObject2 = new ArrayList(1);
          ((ArrayList)localObject2).add(new Camera.Area((Rect)localObject1, 1000));
          localParameters.setMeteringAreas((List)localObject2);
        }
        paramMessage.setParameters(localParameters);
        paramMessage.autoFocus(this.hpC);
        AppMethodBeat.o(94014);
        return;
      }
      catch (Exception paramMessage)
      {
        ad.w(this.TAG, "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
        this.hpA = true;
        AppMethodBeat.o(94014);
        return;
      }
    }
    if (i == hpD)
    {
      if (this.hpx)
      {
        AppMethodBeat.o(94014);
        return;
      }
      localObject1 = paramMessage.obj;
      if (localObject1 == null)
      {
        paramMessage = new d.v("null cannot be cast to non-null type com.tencent.mm.compatible.deviceinfo.MCamera");
        AppMethodBeat.o(94014);
        throw paramMessage;
      }
      localObject1 = (com.tencent.mm.compatible.deviceinfo.v)localObject1;
      localParameters = ((com.tencent.mm.compatible.deviceinfo.v)localObject1).getParameters();
      localObject2 = this.TAG;
      boolean bool = this.hpv;
      i = this.hpu;
      p.g(localParameters, "params");
      ad.i((String)localObject2, "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localParameters.getZoom()) });
      i = localParameters.getZoom();
      i = this.hpu + i;
      if (!this.hpv) {
        break label849;
      }
      int k = a(localParameters);
      if (i < k) {
        break label802;
      }
      i = k;
    }
    for (;;)
    {
      localParameters.setZoom(i);
      try
      {
        ((com.tencent.mm.compatible.deviceinfo.v)localObject1).setParameters(localParameters);
        label778:
        if (j != 0)
        {
          this.hpy = 0;
          this.hpz = this.hpy;
        }
        AppMethodBeat.o(94014);
        return;
        label802:
        paramMessage = obtainMessage(hpD, paramMessage.obj);
        if (this.hpw) {}
        for (j = hpF;; j = hpG)
        {
          sendMessageDelayed(paramMessage, j);
          j = 0;
          break;
        }
        label849:
        if (i <= 0)
        {
          i = 0;
          continue;
        }
        paramMessage = obtainMessage(hpD, paramMessage.obj);
        if (this.hpw) {}
        for (j = hpF;; j = hpG)
        {
          sendMessageDelayed(paramMessage, j);
          j = 0;
          break;
        }
      }
      catch (Exception paramMessage)
      {
        break label778;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "camera", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"})
  static final class b
    implements Camera.AutoFocusCallback
  {
    b(c paramc) {}
    
    public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      AppMethodBeat.i(94011);
      ad.v(c.a(this.hpJ), "auto focus callback success ".concat(String.valueOf(paramBoolean)));
      this.hpJ.hpA = true;
      if (!this.hpJ.hpx) {
        try
        {
          p.g(paramCamera, "camera");
          Camera.Parameters localParameters = paramCamera.getParameters();
          p.g(localParameters, "camera.parameters");
          if ((localParameters.getFocusMode() != null) && (this.hpJ.hpB != null))
          {
            localParameters.setFocusMode(this.hpJ.hpB);
            paramCamera.setParameters(localParameters);
            AppMethodBeat.o(94011);
            return;
          }
        }
        catch (Exception paramCamera)
        {
          ad.e(c.a(this.hpJ), "auto focus return while camera is release");
        }
      }
      AppMethodBeat.o(94011);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.c
 * JD-Core Version:    0.7.0.1
 */