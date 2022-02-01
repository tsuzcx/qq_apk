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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/widget/camera/CameraHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "TAG", "", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "curZoomStep", "", "getCurZoomStep$plugin_mediaeditor_release", "()I", "setCurZoomStep$plugin_mediaeditor_release", "(I)V", "displayH", "getDisplayH$plugin_mediaeditor_release", "setDisplayH$plugin_mediaeditor_release", "displayW", "getDisplayW$plugin_mediaeditor_release", "setDisplayW$plugin_mediaeditor_release", "focusMode", "getFocusMode$plugin_mediaeditor_release", "()Ljava/lang/String;", "setFocusMode$plugin_mediaeditor_release", "(Ljava/lang/String;)V", "forInitialize", "getForInitialize$plugin_mediaeditor_release", "setForInitialize$plugin_mediaeditor_release", "sAutoFocusBack", "getSAutoFocusBack$plugin_mediaeditor_release", "setSAutoFocusBack$plugin_mediaeditor_release", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "touchX", "", "getTouchX$plugin_mediaeditor_release", "()F", "setTouchX$plugin_mediaeditor_release", "(F)V", "touchY", "getTouchY$plugin_mediaeditor_release", "setTouchY$plugin_mediaeditor_release", "zoomed", "getZoomed$plugin_mediaeditor_release", "setZoomed$plugin_mediaeditor_release", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "calculateTapArea$plugin_mediaeditor_release", "clamp", "min", "max", "clamp$plugin_mediaeditor_release", "getTargetZoomStep", "params", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getTargetZoomStep$plugin_mediaeditor_release", "getTargetZoomValue", "getTargetZoomValue$plugin_mediaeditor_release", "handleMessage", "", "msg", "Landroid/os/Message;", "trigetAutoFocus", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "trigetAutoFocus$plugin_mediaeditor_release", "triggerAutoFocus", "triggerAutoFocus$plugin_mediaeditor_release", "Companion", "plugin-mediaeditor_release"})
public final class c
  extends aq
{
  private static final int hsr = 4353;
  private static final int hss = 4354;
  private static final int hst = 10;
  private static final int hsu = 20;
  private static final int hsv = 6;
  public static final c.a hsw;
  private final String TAG;
  float gpg;
  float gph;
  private int hsi;
  boolean hsj;
  private boolean hsk;
  boolean hsl;
  int hsm;
  int hsn;
  boolean hso;
  String hsp;
  private Camera.AutoFocusCallback hsq;
  
  static
  {
    AppMethodBeat.i(94016);
    hsw = new c.a((byte)0);
    hsr = 4353;
    hss = 4354;
    hst = 10;
    hsu = 20;
    hsv = 6;
    AppMethodBeat.o(94016);
  }
  
  public c(Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(94015);
    this.TAG = "MicroMsg.CameraHandler";
    this.hso = true;
    this.hsp = "auto";
    this.hsq = ((Camera.AutoFocusCallback)new b(this));
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
        ae.e(this.TAG, "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
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
    localObject = new Rect(nY(Math.round(((RectF)localObject).left)), nY(Math.round(((RectF)localObject).top)), nY(Math.round(((RectF)localObject).right)), nY(Math.round(((RectF)localObject).bottom)));
    AppMethodBeat.o(94012);
    return localObject;
  }
  
  private static int nY(int paramInt)
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
    if (i == hss)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new d.v("null cannot be cast to non-null type com.tencent.mm.compatible.deviceinfo.MCamera");
        AppMethodBeat.o(94014);
        throw paramMessage;
      }
      paramMessage = (com.tencent.mm.compatible.deviceinfo.v)paramMessage;
      if ((this.hsm == 0) || (this.hsn == 0) || (d.lB(14)))
      {
        if (paramMessage == null)
        {
          ae.w(this.TAG, "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(94014);
          return;
        }
        if (!this.hso)
        {
          ae.w(this.TAG, "auto focus not back");
          AppMethodBeat.o(94014);
          return;
        }
        this.hso = false;
        localObject1 = paramMessage.getParameters();
        p.g(localObject1, "camera.parameters");
        this.hsp = ((Camera.Parameters)localObject1).getFocusMode();
        try
        {
          ae.i(this.TAG, "triggerAutoFocus");
          paramMessage.cancelAutoFocus();
          paramMessage.autoFocus(this.hsq);
          AppMethodBeat.o(94014);
          return;
        }
        catch (Exception paramMessage)
        {
          ae.w(this.TAG, "autofocus fail, exception %s", new Object[] { paramMessage.getMessage() });
          this.hso = true;
          AppMethodBeat.o(94014);
          return;
        }
      }
      float f1 = this.gpg;
      float f2 = this.gph;
      i = this.hsm;
      j = this.hsn;
      if (paramMessage == null)
      {
        ae.w(this.TAG, "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(94014);
        return;
      }
      if (!this.hso)
      {
        ae.w(this.TAG, "auto focus not back");
        AppMethodBeat.o(94014);
        return;
      }
      this.hso = false;
      try
      {
        localObject1 = paramMessage.getParameters();
        p.g(localObject1, "camera.parameters");
        this.hsp = ((Camera.Parameters)localObject1).getFocusMode();
        paramMessage.cancelAutoFocus();
        ae.i(this.TAG, "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
        localObject2 = a(f1, f2, 1.0F, i, j);
        localObject1 = a(f1, f2, 1.5F, i, j);
        ae.i(this.TAG, "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
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
        paramMessage.autoFocus(this.hsq);
        AppMethodBeat.o(94014);
        return;
      }
      catch (Exception paramMessage)
      {
        ae.w(this.TAG, "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
        this.hso = true;
        AppMethodBeat.o(94014);
        return;
      }
    }
    if (i == hsr)
    {
      if (this.hsl)
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
      boolean bool = this.hsj;
      i = this.hsi;
      p.g(localParameters, "params");
      ae.i((String)localObject2, "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localParameters.getZoom()) });
      i = localParameters.getZoom();
      i = this.hsi + i;
      if (!this.hsj) {
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
          this.hsm = 0;
          this.hsn = this.hsm;
        }
        AppMethodBeat.o(94014);
        return;
        label802:
        paramMessage = obtainMessage(hsr, paramMessage.obj);
        if (this.hsk) {}
        for (j = hst;; j = hsu)
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
        paramMessage = obtainMessage(hsr, paramMessage.obj);
        if (this.hsk) {}
        for (j = hst;; j = hsu)
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "camera", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"})
  static final class b
    implements Camera.AutoFocusCallback
  {
    b(c paramc) {}
    
    public final void onAutoFocus(boolean paramBoolean, Camera paramCamera)
    {
      AppMethodBeat.i(94011);
      ae.v(c.a(this.hsx), "auto focus callback success ".concat(String.valueOf(paramBoolean)));
      this.hsx.hso = true;
      if (!this.hsx.hsl) {
        try
        {
          p.g(paramCamera, "camera");
          Camera.Parameters localParameters = paramCamera.getParameters();
          p.g(localParameters, "camera.parameters");
          if ((localParameters.getFocusMode() != null) && (this.hsx.hsp != null))
          {
            localParameters.setFocusMode(this.hsx.hsp);
            paramCamera.setParameters(localParameters);
            AppMethodBeat.o(94011);
            return;
          }
        }
        catch (Exception paramCamera)
        {
          ae.e(c.a(this.hsx), "auto focus return while camera is release");
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