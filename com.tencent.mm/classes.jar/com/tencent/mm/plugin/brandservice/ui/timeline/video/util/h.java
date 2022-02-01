package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings.System;
import android.view.OrientationEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "Landroid/hardware/SensorEventListener;", "ctx", "Landroid/content/Context;", "video", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "context", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "currentDisplayRotation", "", "mCurrentZ", "", "mSensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "orientationChangeListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1;", "videoView", "getVideoView", "setVideoView", "checkContext", "", "enable", "", "isLockRotation", "onAccuracyChanged", "p0", "p1", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "release", "setInitData", "Companion", "plugin-brandservice_release"})
public final class h
  implements SensorEventListener
{
  public static final h.a pKN;
  public int iqr;
  public WeakReference<Context> lAM;
  public SensorManager mSensorManager;
  public WeakReference<MPVideoView> pKJ;
  public Sensor pKK;
  private float pKL;
  public b pKM;
  
  static
  {
    AppMethodBeat.i(7306);
    pKN = new h.a((byte)0);
    AppMethodBeat.o(7306);
  }
  
  public h(Context paramContext, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(7305);
    this.lAM = new WeakReference(paramContext);
    this.pKJ = new WeakReference(paramMPVideoView);
    this.pKL = 10.0F;
    paramContext = (Context)this.lAM.get();
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      this.pKM = new b(this, paramContext);
      AppMethodBeat.o(7305);
      return;
    }
  }
  
  public final boolean aQs()
  {
    AppMethodBeat.i(7303);
    if (this.lAM.get() == null)
    {
      AppMethodBeat.o(7303);
      return false;
    }
    AppMethodBeat.o(7303);
    return true;
  }
  
  public final boolean cqX()
  {
    AppMethodBeat.i(7302);
    if (this.lAM.get() == null)
    {
      AppMethodBeat.o(7302);
      return true;
    }
    Object localObject = this.lAM.get();
    if (localObject == null) {
      p.hyc();
    }
    p.g(localObject, "context.get()!!");
    int i = Settings.System.getInt(((Context)localObject).getContentResolver(), "accelerometer_rotation", 0);
    Log.i("MicroMsg.BizVideoOrientationHelper", "accRotation=".concat(String.valueOf(i)));
    if (i == 0)
    {
      AppMethodBeat.o(7302);
      return true;
    }
    AppMethodBeat.o(7302);
    return false;
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(7304);
    if (paramSensorEvent != null) {}
    for (Sensor localSensor = paramSensorEvent.sensor; localSensor == null; localSensor = null)
    {
      AppMethodBeat.o(7304);
      return;
    }
    localSensor = paramSensorEvent.sensor;
    p.g(localSensor, "event.sensor");
    if (localSensor.getType() == 1) {
      this.pKL = paramSensorEvent.values[2];
    }
    AppMethodBeat.o(7304);
  }
  
  public final void release()
  {
    AppMethodBeat.i(175530);
    this.pKM.disable();
    SensorManager localSensorManager = this.mSensorManager;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener((SensorEventListener)this, this.pKK);
    }
    this.mSensorManager = null;
    this.pKK = null;
    AppMethodBeat.o(175530);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-brandservice_release"})
  public static final class b
    extends OrientationEventListener
  {
    b(Context paramContext, int paramInt)
    {
      super(3);
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      AppMethodBeat.i(7301);
      if ((!h.a(this.pKO)) || (this.pKO.pKJ.get() == null))
      {
        AppMethodBeat.o(7301);
        return;
      }
      if (80 > paramInt)
      {
        if (260 <= paramInt) {
          break label101;
        }
        label49:
        if (170 <= paramInt) {
          break label114;
        }
        label56:
        if ((paramInt >= 10) && (paramInt <= 350)) {
          break label128;
        }
        paramInt = 0;
      }
      for (;;)
      {
        if (h.b(this.pKO) == paramInt)
        {
          AppMethodBeat.o(7301);
          return;
          if (100 < paramInt) {
            break;
          }
          paramInt = -90;
          continue;
          label101:
          if (280 < paramInt) {
            break label49;
          }
          paramInt = 90;
          continue;
          label114:
          if (190 < paramInt) {
            break label56;
          }
          paramInt = 180;
          continue;
          label128:
          AppMethodBeat.o(7301);
          return;
        }
      }
      Log.v("MicroMsg.BizVideoOrientationHelper", "last rotation :" + h.b(this.pKO) + " ,current rotation:" + paramInt);
      Object localObject = this.pKO.pKJ.get();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
        AppMethodBeat.o(7301);
        throw ((Throwable)localObject);
      }
      if (Util.isNullOrNil(((MPVideoView)localObject).getVideoPath()))
      {
        AppMethodBeat.o(7301);
        return;
      }
      localObject = this.pKO.pKJ.get();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
        AppMethodBeat.o(7301);
        throw ((Throwable)localObject);
      }
      if (((MPVideoView)localObject).bJb())
      {
        if (paramInt == 0)
        {
          if ((!this.pKO.cqX()) && (Math.abs(h.c(this.pKO)) < 6.0F))
          {
            localObject = (MPVideoView)this.pKO.pKJ.get();
            if (localObject != null) {
              ((MPVideoView)localObject).p(false, 0);
            }
            h.a(this.pKO, 0);
            AppMethodBeat.o(7301);
          }
        }
        else
        {
          if (paramInt == 90)
          {
            localObject = (MPVideoView)this.pKO.pKJ.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(90);
            }
            localObject = this.pKO.lAM.get();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(0);
            h.a(this.pKO, 90);
            AppMethodBeat.o(7301);
            return;
          }
          if (paramInt == -90)
          {
            localObject = (MPVideoView)this.pKO.pKJ.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(-90);
            }
            localObject = this.pKO.lAM.get();
            if (localObject == null)
            {
              localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(8);
            h.a(this.pKO, -90);
          }
          AppMethodBeat.o(7301);
        }
      }
      else if ((!this.pKO.cqX()) && ((paramInt == 90) || (paramInt == -90)))
      {
        localObject = (MPVideoView)this.pKO.pKJ.get();
        if (localObject != null) {
          ((MPVideoView)localObject).setFullScreenDirection(paramInt);
        }
        localObject = (MPVideoView)this.pKO.pKJ.get();
        if (localObject != null) {
          ((MPVideoView)localObject).p(true, paramInt);
        }
        h.a(this.pKO, paramInt);
      }
      AppMethodBeat.o(7301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h
 * JD-Core Version:    0.7.0.1
 */