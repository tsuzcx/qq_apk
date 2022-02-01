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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "Landroid/hardware/SensorEventListener;", "ctx", "Landroid/content/Context;", "video", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "context", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "currentDisplayRotation", "", "mCurrentZ", "", "mSensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "orientationChangeListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1;", "videoView", "getVideoView", "setVideoView", "checkContext", "", "enable", "", "isLockRotation", "onAccuracyChanged", "p0", "p1", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "release", "setInitData", "Companion", "plugin-brandservice_release"})
public final class h
  implements SensorEventListener
{
  public static final h.a oqN;
  public int hub;
  public WeakReference<Context> ktm;
  public SensorManager mSensorManager;
  public WeakReference<MPVideoView> oqJ;
  public Sensor oqK;
  private float oqL;
  public b oqM;
  
  static
  {
    AppMethodBeat.i(7306);
    oqN = new h.a((byte)0);
    AppMethodBeat.o(7306);
  }
  
  public h(Context paramContext, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(7305);
    this.ktm = new WeakReference(paramContext);
    this.oqJ = new WeakReference(paramMPVideoView);
    this.oqL = 10.0F;
    paramContext = (Context)this.ktm.get();
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      this.oqM = new b(this, paramContext);
      AppMethodBeat.o(7305);
      return;
    }
  }
  
  public final boolean axF()
  {
    AppMethodBeat.i(7303);
    if (this.ktm.get() == null)
    {
      AppMethodBeat.o(7303);
      return false;
    }
    AppMethodBeat.o(7303);
    return true;
  }
  
  public final boolean bSa()
  {
    AppMethodBeat.i(7302);
    if (this.ktm.get() == null)
    {
      AppMethodBeat.o(7302);
      return true;
    }
    Object localObject = this.ktm.get();
    if (localObject == null) {
      p.gfZ();
    }
    p.g(localObject, "context.get()!!");
    int i = Settings.System.getInt(((Context)localObject).getContentResolver(), "accelerometer_rotation", 0);
    ad.i("MicroMsg.BizVideoOrientationHelper", "accRotation=".concat(String.valueOf(i)));
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
      this.oqL = paramSensorEvent.values[2];
    }
    AppMethodBeat.o(7304);
  }
  
  public final void release()
  {
    AppMethodBeat.i(175530);
    this.oqM.disable();
    SensorManager localSensorManager = this.mSensorManager;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener((SensorEventListener)this, this.oqK);
    }
    this.mSensorManager = null;
    this.oqK = null;
    AppMethodBeat.o(175530);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-brandservice_release"})
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
      if ((!h.a(this.oqO)) || (this.oqO.oqJ.get() == null))
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
        if (h.b(this.oqO) == paramInt)
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
      ad.v("MicroMsg.BizVideoOrientationHelper", "last rotation :" + h.b(this.oqO) + " ,current rotation:" + paramInt);
      Object localObject = this.oqO.oqJ.get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
        AppMethodBeat.o(7301);
        throw ((Throwable)localObject);
      }
      if (bt.isNullOrNil(((MPVideoView)localObject).getVideoPath()))
      {
        AppMethodBeat.o(7301);
        return;
      }
      localObject = this.oqO.oqJ.get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
        AppMethodBeat.o(7301);
        throw ((Throwable)localObject);
      }
      if (((MPVideoView)localObject).bmN())
      {
        if (paramInt == 0)
        {
          if ((!this.oqO.bSa()) && (Math.abs(h.c(this.oqO)) < 6.0F))
          {
            localObject = (MPVideoView)this.oqO.oqJ.get();
            if (localObject != null) {
              ((MPVideoView)localObject).p(false, 0);
            }
            h.a(this.oqO, 0);
            AppMethodBeat.o(7301);
          }
        }
        else
        {
          if (paramInt == 90)
          {
            localObject = (MPVideoView)this.oqO.oqJ.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(90);
            }
            localObject = this.oqO.ktm.get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(0);
            h.a(this.oqO, 90);
            AppMethodBeat.o(7301);
            return;
          }
          if (paramInt == -90)
          {
            localObject = (MPVideoView)this.oqO.oqJ.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(-90);
            }
            localObject = this.oqO.ktm.get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(8);
            h.a(this.oqO, -90);
          }
          AppMethodBeat.o(7301);
        }
      }
      else if ((!this.oqO.bSa()) && ((paramInt == 90) || (paramInt == -90)))
      {
        localObject = (MPVideoView)this.oqO.oqJ.get();
        if (localObject != null) {
          ((MPVideoView)localObject).setFullScreenDirection(paramInt);
        }
        localObject = (MPVideoView)this.oqO.oqJ.get();
        if (localObject != null) {
          ((MPVideoView)localObject).p(true, paramInt);
        }
        h.a(this.oqO, paramInt);
      }
      AppMethodBeat.o(7301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h
 * JD-Core Version:    0.7.0.1
 */