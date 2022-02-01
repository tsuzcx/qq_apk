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
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "Landroid/hardware/SensorEventListener;", "ctx", "Landroid/content/Context;", "video", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "context", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "currentDisplayRotation", "", "mCurrentZ", "", "mSensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "orientationChangeListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1;", "videoView", "getVideoView", "setVideoView", "checkContext", "", "enable", "", "isLockRotation", "onAccuracyChanged", "p0", "p1", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "release", "setInitData", "Companion", "plugin-brandservice_release"})
public final class h
  implements SensorEventListener
{
  public static final h.a nlh;
  public int gBw;
  public WeakReference<Context> jyt;
  public SensorManager mSensorManager;
  public WeakReference<MPVideoView> nld;
  public Sensor nle;
  private float nlf;
  public b nlg;
  
  static
  {
    AppMethodBeat.i(7306);
    nlh = new h.a((byte)0);
    AppMethodBeat.o(7306);
  }
  
  public h(Context paramContext, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(7305);
    this.jyt = new WeakReference(paramContext);
    this.nld = new WeakReference(paramMPVideoView);
    this.nlf = 10.0F;
    paramContext = (Context)this.jyt.get();
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      this.nlg = new b(this, paramContext);
      AppMethodBeat.o(7305);
      return;
    }
  }
  
  public final boolean aob()
  {
    AppMethodBeat.i(7303);
    if (this.jyt.get() == null)
    {
      AppMethodBeat.o(7303);
      return false;
    }
    AppMethodBeat.o(7303);
    return true;
  }
  
  public final boolean bGn()
  {
    AppMethodBeat.i(7302);
    if (this.jyt.get() == null)
    {
      AppMethodBeat.o(7302);
      return true;
    }
    Object localObject = this.jyt.get();
    if (localObject == null) {
      k.fvU();
    }
    k.g(localObject, "context.get()!!");
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
    k.g(localSensor, "event.sensor");
    if (localSensor.getType() == 1) {
      this.nlf = paramSensorEvent.values[2];
    }
    AppMethodBeat.o(7304);
  }
  
  public final void release()
  {
    AppMethodBeat.i(175530);
    this.nlg.disable();
    SensorManager localSensorManager = this.mSensorManager;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener((SensorEventListener)this, this.nle);
    }
    this.mSensorManager = null;
    this.nle = null;
    AppMethodBeat.o(175530);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-brandservice_release"})
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
      if ((!h.a(this.nli)) || (this.nli.nld.get() == null))
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
        if (h.b(this.nli) == paramInt)
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
      ad.v("MicroMsg.BizVideoOrientationHelper", "last rotation :" + h.b(this.nli) + " ,current rotation:" + paramInt);
      Object localObject = this.nli.nld.get();
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
      localObject = this.nli.nld.get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView");
        AppMethodBeat.o(7301);
        throw ((Throwable)localObject);
      }
      if (((MPVideoView)localObject).bcg())
      {
        if (paramInt == 0)
        {
          if ((!this.nli.bGn()) && (Math.abs(h.c(this.nli)) < 6.0F))
          {
            localObject = (MPVideoView)this.nli.nld.get();
            if (localObject != null) {
              ((MPVideoView)localObject).p(false, 0);
            }
            h.a(this.nli, 0);
            AppMethodBeat.o(7301);
          }
        }
        else
        {
          if (paramInt == 90)
          {
            localObject = (MPVideoView)this.nli.nld.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(90);
            }
            localObject = this.nli.jyt.get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(0);
            h.a(this.nli, 90);
            AppMethodBeat.o(7301);
            return;
          }
          if (paramInt == -90)
          {
            localObject = (MPVideoView)this.nli.nld.get();
            if (localObject != null) {
              ((MPVideoView)localObject).setFullScreenDirection(-90);
            }
            localObject = this.nli.jyt.get();
            if (localObject == null)
            {
              localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(7301);
              throw ((Throwable)localObject);
            }
            ((MMActivity)localObject).setRequestedOrientation(8);
            h.a(this.nli, -90);
          }
          AppMethodBeat.o(7301);
        }
      }
      else if ((!this.nli.bGn()) && ((paramInt == 90) || (paramInt == -90)))
      {
        localObject = (MPVideoView)this.nli.nld.get();
        if (localObject != null) {
          ((MPVideoView)localObject).setFullScreenDirection(paramInt);
        }
        localObject = (MPVideoView)this.nli.nld.get();
        if (localObject != null) {
          ((MPVideoView)localObject).p(true, paramInt);
        }
        h.a(this.nli, paramInt);
      }
      AppMethodBeat.o(7301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.h
 * JD-Core Version:    0.7.0.1
 */