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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "Landroid/hardware/SensorEventListener;", "ctx", "Landroid/content/Context;", "video", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "context", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "currentDisplayRotation", "", "mCurrentZ", "", "mSensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "orientationChangeListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1;", "videoView", "getVideoView", "setVideoView", "checkContext", "", "enable", "", "isLockRotation", "onAccuracyChanged", "p0", "p1", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "release", "setInitData", "Companion", "plugin-brandservice_release"})
public final class h
  implements SensorEventListener
{
  public static final h.a oxj;
  public int hwP;
  public WeakReference<Context> kwC;
  public SensorManager mSensorManager;
  public WeakReference<MPVideoView> oxf;
  public Sensor oxg;
  private float oxh;
  public b oxi;
  
  static
  {
    AppMethodBeat.i(7306);
    oxj = new h.a((byte)0);
    AppMethodBeat.o(7306);
  }
  
  public h(Context paramContext, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(7305);
    this.kwC = new WeakReference(paramContext);
    this.oxf = new WeakReference(paramMPVideoView);
    this.oxh = 10.0F;
    paramContext = (Context)this.kwC.get();
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      this.oxi = new b(this, paramContext);
      AppMethodBeat.o(7305);
      return;
    }
  }
  
  public final boolean axU()
  {
    AppMethodBeat.i(7303);
    if (this.kwC.get() == null)
    {
      AppMethodBeat.o(7303);
      return false;
    }
    AppMethodBeat.o(7303);
    return true;
  }
  
  public final boolean bTm()
  {
    AppMethodBeat.i(7302);
    if (this.kwC.get() == null)
    {
      AppMethodBeat.o(7302);
      return true;
    }
    Object localObject = this.kwC.get();
    if (localObject == null) {
      p.gkB();
    }
    p.g(localObject, "context.get()!!");
    int i = Settings.System.getInt(((Context)localObject).getContentResolver(), "accelerometer_rotation", 0);
    ae.i("MicroMsg.BizVideoOrientationHelper", "accRotation=".concat(String.valueOf(i)));
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
      this.oxh = paramSensorEvent.values[2];
    }
    AppMethodBeat.o(7304);
  }
  
  public final void release()
  {
    AppMethodBeat.i(175530);
    this.oxi.disable();
    SensorManager localSensorManager = this.mSensorManager;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener((SensorEventListener)this, this.oxg);
    }
    this.mSensorManager = null;
    this.oxg = null;
    AppMethodBeat.o(175530);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-brandservice_release"})
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
      if ((!h.a(this.oxk)) || (this.oxk.oxf.get() == null))
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
        if (h.b(this.oxk) == paramInt)
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
      ae.v("MicroMsg.BizVideoOrientationHelper", "last rotation :" + h.b(this.oxk) + " ,current rotation:" + paramInt);
      Object localObject = this.oxk.oxf.get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
        AppMethodBeat.o(7301);
        throw ((Throwable)localObject);
      }
      if (bu.isNullOrNil(((MPVideoView)localObject).getVideoPath()))
      {
        AppMethodBeat.o(7301);
        return;
      }
      localObject = this.oxk.oxf.get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
        AppMethodBeat.o(7301);
        throw ((Throwable)localObject);
      }
      if (((MPVideoView)localObject).bnx())
      {
        if (paramInt == 0)
        {
          if ((!this.oxk.bTm()) && (Math.abs(h.c(this.oxk)) < 6.0F))
          {
            localObject = (MPVideoView)this.oxk.oxf.get();
            if (localObject != null) {
              ((MPVideoView)localObject).q(false, 0);
            }
            h.a(this.oxk, 0);
            AppMethodBeat.o(7301);
          }
        }
        else
        {
          if (paramInt == 90)
          {
            localObject = (MPVideoView)this.oxk.oxf.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(90);
            }
            localObject = this.oxk.kwC.get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(0);
            h.a(this.oxk, 90);
            AppMethodBeat.o(7301);
            return;
          }
          if (paramInt == -90)
          {
            localObject = (MPVideoView)this.oxk.oxf.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(-90);
            }
            localObject = this.oxk.kwC.get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(8);
            h.a(this.oxk, -90);
          }
          AppMethodBeat.o(7301);
        }
      }
      else if ((!this.oxk.bTm()) && ((paramInt == 90) || (paramInt == -90)))
      {
        localObject = (MPVideoView)this.oxk.oxf.get();
        if (localObject != null) {
          ((MPVideoView)localObject).setFullScreenDirection(paramInt);
        }
        localObject = (MPVideoView)this.oxk.oxf.get();
        if (localObject != null) {
          ((MPVideoView)localObject).q(true, paramInt);
        }
        h.a(this.oxk, paramInt);
      }
      AppMethodBeat.o(7301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h
 * JD-Core Version:    0.7.0.1
 */