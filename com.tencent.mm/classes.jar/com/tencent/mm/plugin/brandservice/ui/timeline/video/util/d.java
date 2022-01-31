package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import a.f.b.j;
import a.l;
import a.v;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper;", "Landroid/hardware/SensorEventListener;", "ctx", "Landroid/content/Context;", "video", "Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/brandservice/ui/widget/MPVideoView;)V", "context", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "getContext", "()Ljava/lang/ref/WeakReference;", "setContext", "(Ljava/lang/ref/WeakReference;)V", "currentDisplayRotation", "", "mCurrentZ", "", "mSensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "orientationChangeListener", "com/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoOrientationHelper$orientationChangeListener$1;", "videoView", "getVideoView", "setVideoView", "checkContext", "", "enable", "", "isLockRotation", "onAccuracyChanged", "p0", "p1", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "release", "Companion", "plugin-brandservice_release"})
public final class d
  implements SensorEventListener
{
  public static final d.a kic;
  public SensorManager bmB;
  private int fbs;
  WeakReference<Context> hyV;
  WeakReference<MPVideoView> khY;
  public Sensor khZ;
  private float kia;
  public d.b kib;
  
  static
  {
    AppMethodBeat.i(15316);
    kic = new d.a((byte)0);
    AppMethodBeat.o(15316);
  }
  
  public d(Context paramContext, MPVideoView paramMPVideoView)
  {
    AppMethodBeat.i(15315);
    this.hyV = new WeakReference(paramContext);
    this.khY = new WeakReference(paramMPVideoView);
    this.kia = 10.0F;
    paramContext = (Context)this.hyV.get();
    if (paramContext != null) {}
    for (paramContext = paramContext.getApplicationContext();; paramContext = null)
    {
      this.kib = new d.b(this, paramContext);
      AppMethodBeat.o(15315);
      return;
    }
  }
  
  private final boolean Xj()
  {
    AppMethodBeat.i(15314);
    if (this.hyV.get() == null)
    {
      AppMethodBeat.o(15314);
      return false;
    }
    AppMethodBeat.o(15314);
    return true;
  }
  
  public final boolean aZN()
  {
    AppMethodBeat.i(156727);
    if (this.hyV.get() == null)
    {
      AppMethodBeat.o(156727);
      return true;
    }
    Object localObject = this.hyV.get();
    if (localObject == null) {
      j.ebi();
    }
    j.p(localObject, "context.get()!!");
    int i = Settings.System.getInt(((Context)localObject).getContentResolver(), "accelerometer_rotation", 0);
    ab.i("MicroMsg.BizVideoOrientationHelper", "accRotation=".concat(String.valueOf(i)));
    if (i == 0)
    {
      AppMethodBeat.o(156727);
      return true;
    }
    AppMethodBeat.o(156727);
    return false;
  }
  
  public final void fR(boolean paramBoolean)
  {
    AppMethodBeat.i(15313);
    ab.i("MicroMsg.BizVideoOrientationHelper", "enable :".concat(String.valueOf(paramBoolean)));
    if (!Xj())
    {
      AppMethodBeat.o(15313);
      return;
    }
    Object localObject;
    if (paramBoolean)
    {
      this.kib.enable();
      if (this.bmB == null)
      {
        localObject = ah.getContext().getSystemService("sensor");
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.hardware.SensorManager");
          AppMethodBeat.o(15313);
          throw ((Throwable)localObject);
        }
        this.bmB = ((SensorManager)localObject);
        localObject = this.bmB;
        if (localObject != null) {}
        for (localObject = ((SensorManager)localObject).getDefaultSensor(1);; localObject = null)
        {
          this.khZ = ((Sensor)localObject);
          localObject = this.bmB;
          if (localObject == null) {
            break;
          }
          ((SensorManager)localObject).registerListener((SensorEventListener)this, this.khZ, 3);
          AppMethodBeat.o(15313);
          return;
        }
        AppMethodBeat.o(15313);
      }
    }
    else
    {
      this.kib.disable();
      localObject = this.hyV.get();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(15313);
        throw ((Throwable)localObject);
      }
      ((MMActivity)localObject).setRequestedOrientation(1);
      this.fbs = 0;
    }
    AppMethodBeat.o(15313);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(156728);
    if (paramSensorEvent != null) {}
    for (Sensor localSensor = paramSensorEvent.sensor; localSensor == null; localSensor = null)
    {
      AppMethodBeat.o(156728);
      return;
    }
    localSensor = paramSensorEvent.sensor;
    j.p(localSensor, "event.sensor");
    if (localSensor.getType() == 1) {
      this.kia = paramSensorEvent.values[2];
    }
    AppMethodBeat.o(156728);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.util.d
 * JD-Core Version:    0.7.0.1
 */