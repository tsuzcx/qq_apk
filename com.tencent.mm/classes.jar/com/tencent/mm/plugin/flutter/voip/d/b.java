package com.tencent.mm.plugin.flutter.voip.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.flutter.voip.b.a.a;
import com.tencent.mm.plugin.flutter.voip.b.a.a.a;
import com.tencent.mm.plugin.flutter.voip.b.a.f;
import com.tencent.mm.plugin.mmsight.model.d;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/flutter/voip/ui/FlutterVoipUI;", "Lcom/tencent/mm/plugin/voip/ui/IVoipUI;", "voipMgr", "Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterVoipMgr;", "(Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterVoipMgr;)V", "mRemoteOrientation", "", "mStatus", "orientationEventListener", "Lcom/tencent/mm/plugin/mmsight/model/DeviceOrientationListener;", "playDevice", "screenOffLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "getVoipMgr", "()Lcom/tencent/mm/plugin/flutter/voip/manager/FlutterVoipMgr;", "setVoipMgr", "adjustHWViewAspectRatio", "", "w", "h", "dismissNetStatusWarning", "getBeautyData", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyData;", "fbType", "getSpatioTemporalFilterData", "Lcom/tencent/mm/plugin/voip/video/videoprocessing/SpatioTemporalFilterData;", "getVoipUIContext", "Landroid/content/Context;", "onConfigurationChanged", "onDecModeChanged", "decMode", "onLinkToAutoSwitchMobile", "caller", "onLocalCaptureDataAvailable", "sendRet", "onNetWorkCostMax", "onRemoteOrientationChanged", "orientation", "onRemoteVideoDataAvailable", "onResumeTick", "", "onStartRecordFailed", "onStopRing", "onVoipBeautyCmdSet", "cmd", "onVoipSTFilterCmdSet", "releaseSurfaceTexture", "requestFinish", "needDelay", "", "isMinimize", "requestRender", "resetCaptureView", "setCaptureFrameData", "pBuffer", "", "lBufferSize", "MediaFmt", "dblSampleTime", "", "mirror", "angle", "setCaptureView", "captureView", "Lcom/tencent/mm/plugin/voip/video/camera/prev/CaptureView;", "setConnectSec", "connectSec", "setFaceDetectResult", "faceLocation", "", "rotateAngle", "setHWDecMode", "mode", "setMute", "muted", "setNewState", "action", "newState", "setRemoteVideoData", "outlen", "outData", "setScreenEnable", "isEnable", "setSpatiotemporalDenosing", "setSurfaceTexture", "texture", "Landroid/graphics/SurfaceTexture;", "videoTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "setVoicePlayDevice", "device", "setVoipBeauty", "showError", "errCode", "errMsg", "", "showNetWorkChangeMobileNet", "showRiskTips", "tips", "tryShowNetStatusWarning", "isSelfNetBad", "turnOffScreen", "turnOnScreen", "uninit", "uninitGLRender", "Companion", "plugin-flutter-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.voip.ui.b
{
  public static final b.a HnP;
  private int HnQ;
  private int HnR;
  private PowerManager.WakeLock HnS;
  private com.tencent.mm.plugin.flutter.voip.manager.b Hnh;
  private int mStatus;
  private d orientationEventListener;
  
  static
  {
    AppMethodBeat.i(263367);
    HnP = new b.a((byte)0);
    AppMethodBeat.o(263367);
  }
  
  public b(com.tencent.mm.plugin.flutter.voip.manager.b paramb)
  {
    AppMethodBeat.i(263322);
    this.Hnh = paramb;
    this.mStatus = -1;
    this.HnQ = -1;
    this.HnR = 1;
    paramb = new d(MMApplicationContext.getContext());
    paramb.enable();
    paramb.KUU = new b..ExternalSyntheticLambda0(this);
    ah localah = ah.aiuX;
    this.orientationEventListener = paramb;
    AppMethodBeat.o(263322);
  }
  
  private static final void a(b paramb, int paramInt)
  {
    AppMethodBeat.i(263356);
    s.u(paramb, "this$0");
    Object localObject = MMApplicationContext.getContext().getSystemService("window");
    if (localObject == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(263356);
      throw paramb;
    }
    switch (((WindowManager)localObject).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      paramb.Hnh.apT(paramInt);
      AppMethodBeat.o(263356);
      return;
      paramInt = 0;
      continue;
      paramInt = 180;
      continue;
      paramInt = 90;
      continue;
      paramInt = 270;
    }
  }
  
  private static final void b(b paramb, int paramInt)
  {
    AppMethodBeat.i(263362);
    s.u(paramb, "this$0");
    paramb.HnR = paramInt;
    AppMethodBeat.o(263362);
  }
  
  private final void fwt()
  {
    try
    {
      AppMethodBeat.i(263336);
      Object localObject1 = MMApplicationContext.getContext().getSystemService("power");
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        AppMethodBeat.o(263336);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    PowerManager localPowerManager = (PowerManager)localObject2;
    PowerManager.WakeLock localWakeLock = this.HnS;
    if (localWakeLock == null)
    {
      localWakeLock = localPowerManager.newWakeLock(32, "wechat:screen flutter-Lock");
      this.HnS = localWakeLock;
      if (localWakeLock.isHeld()) {
        break label175;
      }
      a.b(localWakeLock, "com/tencent/mm/plugin/flutter/voip/ui/FlutterVoipUI", "turnOffScreen", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      localWakeLock.acquire();
      a.c(localWakeLock, "com/tencent/mm/plugin/flutter/voip/ui/FlutterVoipUI", "turnOffScreen", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      Log.i("MicroMsg.FlutterVoipUI", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(localWakeLock.isHeld()) });
      this.Hnh.onScreenStateChange(false);
      AppMethodBeat.o(263336);
    }
    for (;;)
    {
      return;
      break;
      label175:
      Log.w("MicroMsg.FlutterVoipUI", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
      AppMethodBeat.o(263336);
    }
  }
  
  /* Error */
  private final void fwu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 313
    //   5: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 254	com/tencent/mm/plugin/flutter/voip/d/b:HnS	Landroid/os/PowerManager$WakeLock;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +110 -> 124
    //   17: aload_1
    //   18: invokevirtual 266	android/os/PowerManager$WakeLock:isHeld	()Z
    //   21: ifeq +103 -> 124
    //   24: aload_1
    //   25: ldc_w 268
    //   28: ldc_w 314
    //   31: ldc_w 270
    //   34: ldc_w 272
    //   37: ldc_w 316
    //   40: ldc_w 270
    //   43: invokestatic 279	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_1
    //   47: invokevirtual 318	android/os/PowerManager$WakeLock:release	()V
    //   50: aload_1
    //   51: ldc_w 268
    //   54: ldc_w 314
    //   57: ldc_w 270
    //   60: ldc_w 272
    //   63: ldc_w 316
    //   66: ldc_w 270
    //   69: invokestatic 284	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc_w 286
    //   75: ldc_w 320
    //   78: iconst_2
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_0
    //   85: invokevirtual 292	com/tencent/mm/plugin/flutter/voip/d/b:toString	()Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload_1
    //   92: invokevirtual 266	android/os/PowerManager$WakeLock:isHeld	()Z
    //   95: invokestatic 298	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   98: aastore
    //   99: invokestatic 303	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: aload_0
    //   103: aconst_null
    //   104: putfield 254	com/tencent/mm/plugin/flutter/voip/d/b:HnS	Landroid/os/PowerManager$WakeLock;
    //   107: aload_0
    //   108: getfield 171	com/tencent/mm/plugin/flutter/voip/d/b:Hnh	Lcom/tencent/mm/plugin/flutter/voip/manager/b;
    //   111: iconst_1
    //   112: invokevirtual 307	com/tencent/mm/plugin/flutter/voip/manager/b:onScreenStateChange	(Z)V
    //   115: ldc_w 313
    //   118: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: monitorexit
    //   123: return
    //   124: ldc_w 286
    //   127: ldc_w 322
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload_0
    //   137: invokevirtual 292	com/tencent/mm/plugin/flutter/voip/d/b:toString	()Ljava/lang/String;
    //   140: aastore
    //   141: invokestatic 311	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: ldc_w 313
    //   147: invokestatic 143	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: goto -29 -> 121
    //   153: astore_1
    //   154: aload_0
    //   155: monitorexit
    //   156: aload_1
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	b
    //   12	80	1	localWakeLock	PowerManager.WakeLock
    //   153	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	153	finally
    //   17	121	153	finally
    //   124	150	153	finally
  }
  
  public final void VR(int paramInt)
  {
    AppMethodBeat.i(263492);
    h.ahAA.bk(new b..ExternalSyntheticLambda1(this, paramInt));
    AppMethodBeat.o(263492);
  }
  
  public final void VV(int paramInt) {}
  
  public final void VW(int paramInt) {}
  
  public final void VX(int paramInt) {}
  
  public final void VY(int paramInt) {}
  
  public final void aDJ(String paramString)
  {
    AppMethodBeat.i(263419);
    if (paramString != null)
    {
      com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
      com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmR, paramString);
    }
    AppMethodBeat.o(263419);
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void bX(int paramInt, String paramString)
  {
    AppMethodBeat.i(263508);
    if (paramInt == 233) {
      SubCoreVoip.hVp().hYu();
    }
    AppMethodBeat.o(263508);
  }
  
  public final void fwi() {}
  
  public final void fwq() {}
  
  public final Context fwr()
  {
    AppMethodBeat.i(263398);
    Object localObject = this.Hnh.activity;
    if (localObject == null)
    {
      localObject = MMApplicationContext.getContext();
      s.s(localObject, "getContext()");
      AppMethodBeat.o(263398);
      return localObject;
    }
    localObject = (Context)localObject;
    AppMethodBeat.o(263398);
    return localObject;
  }
  
  public final void fws() {}
  
  public final void fwv()
  {
    AppMethodBeat.i(263449);
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmQ);
    AppMethodBeat.o(263449);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(263474);
    Log.d("MicroMsg.FlutterVoipUI", "dismissNetStatusWarning");
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmO);
    AppMethodBeat.o(263474);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(263503);
    SubCoreVoip.hVp();
    if (u.hYH())
    {
      com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
      com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmP);
    }
    AppMethodBeat.o(263503);
  }
  
  public final void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(263515);
    this.mStatus = paramInt2;
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.iT(paramInt1, paramInt2);
    AppMethodBeat.o(263515);
  }
  
  public final void setConnectSec(long paramLong) {}
  
  public final void setMute(boolean paramBoolean) {}
  
  public final void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(263413);
    if (!paramBoolean)
    {
      fwt();
      AppMethodBeat.o(263413);
      return;
    }
    fwu();
    AppMethodBeat.o(263413);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(263460);
    if (this.HnQ != -1) {
      switch (paramInt)
      {
      default: 
        if (!this.Hnh.hVh()) {
          setScreenEnable(true);
        }
        break;
      }
    }
    for (;;)
    {
      this.Hnh.setVoicePlayDevice(paramInt);
      Object localObject = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
      localObject = a.a.Hmf;
      com.tencent.mm.plugin.flutter.voip.c.b.a(a.a.a.VO(paramInt));
      this.HnQ = paramInt;
      AppMethodBeat.o(263460);
      return;
      if (!this.Hnh.hVh()) {
        setScreenEnable(true);
      }
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(263434);
    fwu();
    d locald = this.orientationEventListener;
    locald.disable();
    locald.KUU = null;
    AppMethodBeat.o(263434);
  }
  
  public final void vJ(boolean paramBoolean)
  {
    AppMethodBeat.i(263465);
    Log.d("MicroMsg.FlutterVoipUI", s.X("tryShowNetStatusWarning isSelfNetBad", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
      com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmM);
      AppMethodBeat.o(263465);
      return;
    }
    com.tencent.mm.plugin.flutter.voip.c.b localb = com.tencent.mm.plugin.flutter.voip.c.b.HnG;
    com.tencent.mm.plugin.flutter.voip.c.b.a(a.f.HmN);
    AppMethodBeat.o(263465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.voip.d.b
 * JD-Core Version:    0.7.0.1
 */