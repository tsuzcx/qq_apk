package com.tencent.mm.media.widget.a;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/widget/camera/CameraHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "TAG", "", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "curZoomStep", "", "getCurZoomStep$plugin_mediaeditor_release", "()I", "setCurZoomStep$plugin_mediaeditor_release", "(I)V", "displayH", "getDisplayH$plugin_mediaeditor_release", "setDisplayH$plugin_mediaeditor_release", "displayW", "getDisplayW$plugin_mediaeditor_release", "setDisplayW$plugin_mediaeditor_release", "forInitialize", "getForInitialize$plugin_mediaeditor_release", "setForInitialize$plugin_mediaeditor_release", "sAutoFocusBack", "getSAutoFocusBack$plugin_mediaeditor_release", "setSAutoFocusBack$plugin_mediaeditor_release", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "getSAutoFocusCallback$plugin_mediaeditor_release", "()Landroid/hardware/Camera$AutoFocusCallback;", "setSAutoFocusCallback$plugin_mediaeditor_release", "(Landroid/hardware/Camera$AutoFocusCallback;)V", "touchX", "", "getTouchX$plugin_mediaeditor_release", "()F", "setTouchX$plugin_mediaeditor_release", "(F)V", "touchY", "getTouchY$plugin_mediaeditor_release", "setTouchY$plugin_mediaeditor_release", "zoomed", "getZoomed$plugin_mediaeditor_release", "setZoomed$plugin_mediaeditor_release", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "calculateTapArea$plugin_mediaeditor_release", "clamp", "min", "max", "clamp$plugin_mediaeditor_release", "getTargetZoomStep", "params", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getTargetZoomStep$plugin_mediaeditor_release", "getTargetZoomValue", "getTargetZoomValue$plugin_mediaeditor_release", "handleMessage", "", "msg", "Landroid/os/Message;", "trigetAutoFocus", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "trigetAutoFocus$plugin_mediaeditor_release", "triggerAutoFocus", "triggerAutoFocus$plugin_mediaeditor_release", "Companion", "plugin-mediaeditor_release"})
public final class c
  extends ak
{
  private static final int fai = 4353;
  private static final int faj = 4354;
  private static final int fak = 10;
  private static final int fal = 20;
  private static final int fam = 6;
  public static final c.a fan;
  private final String TAG;
  private int eZY;
  boolean eZZ;
  private boolean faa;
  boolean fab;
  float fac;
  float fad;
  int fae;
  int faf;
  boolean fag;
  private Camera.AutoFocusCallback fah;
  
  static
  {
    AppMethodBeat.i(13194);
    fan = new c.a((byte)0);
    fai = 4353;
    faj = 4354;
    fak = 10;
    fal = 20;
    fam = 6;
    AppMethodBeat.o(13194);
  }
  
  public c(Looper paramLooper)
  {
    super(paramLooper);
    AppMethodBeat.i(13193);
    this.TAG = "MicroMsg.CameraHandler";
    this.fag = true;
    this.fah = ((Camera.AutoFocusCallback)new c.b(this));
    AppMethodBeat.o(13193);
  }
  
  private static Rect a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(13190);
    paramFloat3 = 80.0F * paramFloat3;
    paramFloat1 /= paramInt1;
    paramFloat2 /= paramInt2;
    paramFloat1 = paramFloat1 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    paramFloat2 = paramFloat2 * 2000.0F - 1000.0F - paramFloat3 / 2.0F;
    Object localObject = new RectF();
    ((RectF)localObject).set(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat3 + paramFloat2);
    localObject = new Rect(kg(Math.round(((RectF)localObject).left)), kg(Math.round(((RectF)localObject).top)), kg(Math.round(((RectF)localObject).right)), kg(Math.round(((RectF)localObject).bottom)));
    AppMethodBeat.o(13190);
    return localObject;
  }
  
  private int c(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(13191);
    if (paramParameters == null)
    {
      AppMethodBeat.o(13191);
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
        ab.e(this.TAG, "get target zoom value error: %s", new Object[] { paramParameters.getMessage() });
        int i = 0;
      }
    }
    AppMethodBeat.o(13191);
    return i;
  }
  
  private static int kg(int paramInt)
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
    AppMethodBeat.i(13192);
    j.q(paramMessage, "msg");
    int i = paramMessage.what;
    Object localObject2;
    Object localObject1;
    Camera.Parameters localParameters;
    if (i == faj)
    {
      paramMessage = paramMessage.obj;
      if (paramMessage == null)
      {
        paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.compatible.deviceinfo.MCamera");
        AppMethodBeat.o(13192);
        throw paramMessage;
      }
      paramMessage = (u)paramMessage;
      if ((this.fae == 0) || (this.faf == 0) || (d.fw(14)))
      {
        if (paramMessage == null)
        {
          ab.w(this.TAG, "want to auto focus, but camera is null, do nothing");
          AppMethodBeat.o(13192);
          return;
        }
        if (!this.fag)
        {
          ab.w(this.TAG, "auto focus not back");
          AppMethodBeat.o(13192);
          return;
        }
        this.fag = false;
        try
        {
          ab.i(this.TAG, "triggerAutoFocus");
          paramMessage.cancelAutoFocus();
          paramMessage.autoFocus(this.fah);
          AppMethodBeat.o(13192);
          return;
        }
        catch (Exception paramMessage)
        {
          ab.w(this.TAG, "autofocus fail, exception %s", new Object[] { paramMessage.getMessage() });
          this.fag = true;
          AppMethodBeat.o(13192);
          return;
        }
      }
      float f1 = this.fac;
      float f2 = this.fad;
      i = this.fae;
      j = this.faf;
      if (paramMessage == null)
      {
        ab.w(this.TAG, "want to auto focus, but camera is null, do nothing");
        AppMethodBeat.o(13192);
        return;
      }
      if (!this.fag)
      {
        ab.w(this.TAG, "auto focus not back");
        AppMethodBeat.o(13192);
        return;
      }
      this.fag = false;
      try
      {
        paramMessage.cancelAutoFocus();
        ab.i(this.TAG, "ashutest:: touch %f %f, display %d %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
        localObject2 = a(f1, f2, 1.0F, i, j);
        localObject1 = a(f1, f2, 1.5F, i, j);
        ab.i(this.TAG, "ashutest:: focus rect %s, meter rect %s", new Object[] { localObject2, localObject1 });
        localParameters = paramMessage.getParameters();
        j.p(localParameters, "parameters");
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
        paramMessage.autoFocus(this.fah);
        AppMethodBeat.o(13192);
        return;
      }
      catch (Exception paramMessage)
      {
        ab.w(this.TAG, "autofocus with area fail, exception %s", new Object[] { paramMessage.getMessage() });
        this.fag = true;
        AppMethodBeat.o(13192);
        return;
      }
    }
    if (i == fai)
    {
      if (this.fab)
      {
        AppMethodBeat.o(13192);
        return;
      }
      localObject1 = paramMessage.obj;
      if (localObject1 == null)
      {
        paramMessage = new v("null cannot be cast to non-null type com.tencent.mm.compatible.deviceinfo.MCamera");
        AppMethodBeat.o(13192);
        throw paramMessage;
      }
      localObject1 = (u)localObject1;
      localParameters = ((u)localObject1).getParameters();
      localObject2 = this.TAG;
      boolean bool = this.eZZ;
      i = this.eZY;
      j.p(localParameters, "params");
      ab.i((String)localObject2, "zoomed %s curZoomStep %s params.getZoom() %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(localParameters.getZoom()) });
      i = localParameters.getZoom();
      i = this.eZY + i;
      if (!this.eZZ) {
        break label818;
      }
      int k = c(localParameters);
      if (i < k) {
        break label771;
      }
      i = k;
    }
    for (;;)
    {
      localParameters.setZoom(i);
      try
      {
        ((u)localObject1).setParameters(localParameters);
        label746:
        if (j != 0)
        {
          this.fae = 0;
          this.faf = this.fae;
        }
        AppMethodBeat.o(13192);
        return;
        label771:
        paramMessage = obtainMessage(fai, paramMessage.obj);
        if (this.faa) {}
        for (j = fak;; j = fal)
        {
          sendMessageDelayed(paramMessage, j);
          j = 0;
          break;
        }
        label818:
        if (i <= 0)
        {
          i = 0;
          continue;
        }
        paramMessage = obtainMessage(fai, paramMessage.obj);
        if (this.faa) {}
        for (j = fak;; j = fal)
        {
          sendMessageDelayed(paramMessage, j);
          j = 0;
          break;
        }
      }
      catch (Exception paramMessage)
      {
        break label746;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.c
 * JD-Core Version:    0.7.0.1
 */