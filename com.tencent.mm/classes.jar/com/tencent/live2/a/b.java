package com.tencent.live2.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl;
import com.tencent.liteav.audio.TXAudioEffectManagerImpl.TXAudioEffectManagerListener;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.liteav.device.TXDeviceManagerImpl;
import com.tencent.liteav.device.TXDeviceManagerImpl.TXDeviceManagerListener;
import com.tencent.live2.V2TXLiveDef.V2TXLiveAudioQuality;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveMirrorType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePusherStatistics;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTexture;
import com.tencent.live2.V2TXLiveDef.V2TXLiveTranscodingConfig;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoFrame;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.live2.V2TXLivePusher;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.c;
import com.tencent.live2.impl.a.e;
import com.tencent.live2.impl.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.AudioCustomProcessListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.Locale;

public class b
  extends V2TXLivePusher
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, ITXLivePushListener, TXLivePusher.AudioCustomProcessListener, TXLivePusher.ITXAudioVolumeEvaluationListener, TXLivePusher.VideoCustomProcessListener
{
  private boolean A;
  private Context a;
  private TXLivePushConfig b;
  private TXLivePusher c;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private int k;
  private V2TXLiveDef.V2TXLivePusherStatistics l;
  private a.e m;
  private int n;
  private boolean o;
  private int p;
  private boolean q;
  private TXCloudVideoView r;
  private TextureView s;
  private SurfaceView t;
  private V2TXLivePusherObserver u;
  private TXDeviceManager v;
  private Surface w;
  private a.a x;
  private boolean y;
  private a.c z;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(211770);
    this.a = paramContext.getApplicationContext();
    this.l = new V2TXLiveDef.V2TXLivePusherStatistics();
    this.c = new TXLivePusher(this.a);
    this.c.setPushListener(this);
    this.c.setAudioVolumeEvaluationListener(this);
    this.b = new TXLivePushConfig();
    this.b.setTouchFocus(false);
    this.c.setConfig(this.b);
    a(this.c);
    TXAudioEffectManagerImpl.getAutoCacheHolder().setAudioEffectManagerListener(new TXAudioEffectManagerImpl.TXAudioEffectManagerListener()
    {
      public void onSwitchVoiceEarMonitor(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(211735);
        b.a(b.this).enableAudioEarMonitoring(paramAnonymousBoolean);
        AppMethodBeat.o(211735);
      }
    });
    ((TXDeviceManagerImpl)this.v).setDeviceManagerListener(new TXDeviceManagerImpl.TXDeviceManagerListener()
    {
      public void onSwitchAutoFocus(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(211740);
        TXLivePushConfig localTXLivePushConfig = b.a(b.this);
        if (!paramAnonymousBoolean) {}
        for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
        {
          localTXLivePushConfig.setTouchFocus(paramAnonymousBoolean);
          AppMethodBeat.o(211740);
          return;
        }
      }
      
      public void onSwitchCamera(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(211728);
        b.a(b.this).setFrontCamera(paramAnonymousBoolean);
        AppMethodBeat.o(211728);
      }
      
      public void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramAnonymousTXSystemVolumeType)
      {
        int j = 0;
        AppMethodBeat.i(211754);
        b.a(b.this, "updateConfig: volumeType-".concat(String.valueOf(paramAnonymousTXSystemVolumeType)));
        int i = j;
        switch (b.4.a[paramAnonymousTXSystemVolumeType.ordinal()])
        {
        default: 
          i = j;
        }
        for (;;)
        {
          b.a(b.this).setVolumeType(i);
          AppMethodBeat.o(211754);
          return;
          i = 1;
          continue;
          i = 2;
        }
      }
    });
    a();
    AppMethodBeat.o(211770);
  }
  
  private int a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 1;
    AppMethodBeat.i(211811);
    a("getFinalResolution: [rtmpResolution:" + paramInt + "][portrait:" + paramBoolean1 + "][isCameraCapture:" + paramBoolean2 + "]");
    if (paramBoolean2) {
      paramBoolean1 = true;
    }
    switch (paramInt)
    {
    default: 
      i1 = -1;
    }
    for (;;)
    {
      int i2 = i1;
      if (i1 == -1)
      {
        c("getFinalResolution: seriously error!!! can't map resolution, use original resolution.");
        i2 = paramInt;
      }
      a("getFinalResolution: [old res:" + paramInt + "][new res:" + i2 + "]");
      AppMethodBeat.o(211811);
      return i2;
      i1 = paramInt;
      continue;
      if (paramBoolean1)
      {
        i1 = 11;
      }
      else
      {
        i1 = 14;
        continue;
        if (paramBoolean1)
        {
          i1 = 12;
        }
        else
        {
          i1 = 15;
          continue;
          if (paramBoolean1)
          {
            i1 = 13;
          }
          else
          {
            i1 = 16;
            continue;
            if (paramBoolean1)
            {
              i1 = 7;
            }
            else
            {
              i1 = 9;
              continue;
              if (paramBoolean1)
              {
                i1 = 8;
              }
              else
              {
                i1 = 10;
                continue;
                if (paramBoolean1)
                {
                  i1 = 0;
                }
                else
                {
                  i1 = 3;
                  continue;
                  if (!paramBoolean1)
                  {
                    i1 = 4;
                    continue;
                    if (paramBoolean1)
                    {
                      i1 = 2;
                    }
                    else
                    {
                      i1 = 5;
                      continue;
                      if (paramBoolean1) {
                        i1 = 30;
                      } else {
                        i1 = 31;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private V2TXLiveDef.V2TXLiveVideoFrame a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211787);
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame = new V2TXLiveDef.V2TXLiveVideoFrame();
    localV2TXLiveVideoFrame.texture = new V2TXLiveDef.V2TXLiveTexture();
    localV2TXLiveVideoFrame.texture.textureId = paramInt1;
    localV2TXLiveVideoFrame.width = paramInt2;
    localV2TXLiveVideoFrame.height = paramInt3;
    Object localObject = TXCOpenGlUtils.e();
    if ((localObject instanceof android.opengl.EGLContext)) {
      localV2TXLiveVideoFrame.texture.eglContext14 = ((android.opengl.EGLContext)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(211787);
      return localV2TXLiveVideoFrame;
      localV2TXLiveVideoFrame.texture.eglContext10 = ((javax.microedition.khronos.egl.EGLContext)localObject);
    }
  }
  
  private void a()
  {
    AppMethodBeat.i(211794);
    if (this.d)
    {
      a("updateConfig: update config success.");
      this.c.setConfig(this.b);
    }
    AppMethodBeat.o(211794);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(211817);
    if ((paramInt3 <= 0) || (paramInt4 <= 0))
    {
      c("setVideoEncoderParam: fail, invalid encoder params.");
      AppMethodBeat.o(211817);
      return;
    }
    int i1 = paramInt2;
    if (paramInt2 == 0) {
      i1 = paramInt3;
    }
    this.b.setMaxVideoBitrate(paramInt3);
    this.b.setVideoBitrate(paramInt3);
    this.b.setMinVideoBitrate(i1);
    this.b.setVideoResolution(paramInt1);
    this.b.setVideoFPS(paramInt4);
    if (paramInt5 > 0) {
      this.b.setVideoEncodeGop(paramInt5);
    }
    this.b.setAutoAdjustStrategy(paramInt6);
    AppMethodBeat.o(211817);
  }
  
  private void a(a.e parame)
  {
    AppMethodBeat.i(211802);
    if (parame == null)
    {
      c("setVideoQualityInner: param is null.");
      AppMethodBeat.o(211802);
      return;
    }
    if ((!this.e) && (!this.f) && (!this.o))
    {
      b("setVideoQualityInner: not start video yet, waiting....");
      AppMethodBeat.o(211802);
      return;
    }
    a("setVideoQualityInner: ".concat(String.valueOf(parame)));
    a(a(parame.e, parame.f, this.e), parame.c, parame.b, parame.a, parame.d, parame.h);
    b();
    a();
    AppMethodBeat.o(211802);
  }
  
  /* Error */
  private void a(TXLivePusher paramTXLivePusher)
  {
    // Byte code:
    //   0: ldc_w 307
    //   3: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore_3
    //   8: ldc 92
    //   10: ldc_w 309
    //   13: invokevirtual 315	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   16: astore_2
    //   17: aload_2
    //   18: iconst_1
    //   19: invokevirtual 320	java/lang/reflect/Field:setAccessible	(Z)V
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual 324	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: checkcast 326	com/tencent/rtmp/TXLivePusherImpl
    //   30: astore_1
    //   31: aload_0
    //   32: ldc_w 328
    //   35: aload_1
    //   36: invokestatic 279	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   39: invokevirtual 283	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokespecial 178	com/tencent/live2/a/b:a	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: ifnonnull +37 -> 83
    //   49: aload_0
    //   50: ldc_w 330
    //   53: invokespecial 182	com/tencent/live2/a/b:c	(Ljava/lang/String;)V
    //   56: ldc_w 307
    //   59: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: astore_2
    //   64: aload_3
    //   65: astore_1
    //   66: aload_0
    //   67: ldc_w 332
    //   70: aload_2
    //   71: invokestatic 279	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokevirtual 283	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokespecial 182	com/tencent/live2/a/b:c	(Ljava/lang/String;)V
    //   80: goto -35 -> 45
    //   83: ldc_w 326
    //   86: ldc_w 334
    //   89: iconst_0
    //   90: anewarray 311	java/lang/Class
    //   93: invokevirtual 338	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   96: astore_2
    //   97: aload_2
    //   98: iconst_1
    //   99: invokevirtual 341	java/lang/reflect/Method:setAccessible	(Z)V
    //   102: aload_0
    //   103: aload_2
    //   104: aload_1
    //   105: iconst_0
    //   106: anewarray 343	java/lang/Object
    //   109: invokevirtual 347	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 349	com/tencent/liteav/device/TXDeviceManager
    //   115: putfield 135	com/tencent/live2/a/b:v	Lcom/tencent/liteav/device/TXDeviceManager;
    //   118: aload_0
    //   119: new 151	java/lang/StringBuilder
    //   122: dup
    //   123: ldc_w 351
    //   126: invokespecial 156	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: aload_0
    //   130: getfield 135	com/tencent/live2/a/b:v	Lcom/tencent/liteav/device/TXDeviceManager;
    //   133: invokevirtual 354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 178	com/tencent/live2/a/b:a	(Ljava/lang/String;)V
    //   142: ldc_w 307
    //   145: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: return
    //   149: astore_1
    //   150: aload_0
    //   151: ldc_w 356
    //   154: aload_1
    //   155: invokestatic 279	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual 283	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   161: invokespecial 182	com/tencent/live2/a/b:c	(Ljava/lang/String;)V
    //   164: ldc_w 307
    //   167: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: astore_2
    //   172: goto -106 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	b
    //   0	175	1	paramTXLivePusher	TXLivePusher
    //   16	7	2	localField	java.lang.reflect.Field
    //   63	8	2	localException1	Exception
    //   96	8	2	localMethod	java.lang.reflect.Method
    //   171	1	2	localException2	Exception
    //   7	58	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	31	63	java/lang/Exception
    //   83	142	149	java/lang/Exception
    //   31	45	171	java/lang/Exception
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(211881);
    TXLog.i("V2-TXRTMPPusherImpl", "v2_api_rtmp_pusher(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211881);
  }
  
  private void b()
  {
    int i2 = 1;
    AppMethodBeat.i(211824);
    a.e locale = this.m;
    int i1;
    if (this.e)
    {
      if (locale == null) {
        break label165;
      }
      if (!locale.f)
      {
        i1 = 90;
        i2 = 0;
      }
    }
    for (;;)
    {
      a("fixRenderRotation sdk rule: [homeOrientation:" + i2 + "][innerRotation:" + i1 + "]");
      int i4 = i1;
      int i3 = i2;
      if (locale != null)
      {
        i4 = i1;
        i3 = i2;
        if (locale.g != -1)
        {
          i3 = locale.g;
          a("fixRenderRotation outside rule: [homeOrientation:" + i3 + "][innerRotation:0]");
          i4 = 0;
        }
      }
      this.b.setHomeOrientation(i3);
      this.k = i4;
      c();
      AppMethodBeat.o(211824);
      return;
      i1 = 0;
      continue;
      label165:
      i1 = 0;
    }
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(211884);
    TXLog.w("V2-TXRTMPPusherImpl", "v2_api_rtmp_pusher(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211884);
  }
  
  private void c()
  {
    AppMethodBeat.i(211830);
    int i1 = this.n;
    int i2 = this.k;
    a("setRenderRotationInner: [external:" + this.n + "][inner:" + this.k + "]");
    this.c.setRenderRotation(i1 + i2);
    AppMethodBeat.o(211830);
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(211888);
    TXLog.e("V2-TXRTMPPusherImpl", "v2_api_rtmp_pusher(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211888);
  }
  
  private void d()
  {
    AppMethodBeat.i(211836);
    a("stopPushInner:");
    i();
    this.d = false;
    this.h = false;
    this.k = 0;
    this.l = new V2TXLiveDef.V2TXLivePusherStatistics();
    e();
    f();
    g();
    this.c.setMute(false);
    this.c.stopPusher();
    AppMethodBeat.o(211836);
  }
  
  private void e()
  {
    AppMethodBeat.i(211843);
    a("stopCameraInner: ");
    this.i = false;
    this.e = false;
    this.c.stopCameraPreview(true);
    AppMethodBeat.o(211843);
  }
  
  private void f()
  {
    AppMethodBeat.i(211849);
    a("stopMicrophoneInner: ");
    this.j = false;
    this.g = false;
    this.c.setMute(true);
    AppMethodBeat.o(211849);
  }
  
  private void g()
  {
    AppMethodBeat.i(211856);
    a("stopScreenCaptureInner: ");
    this.i = false;
    this.f = false;
    this.c.stopScreenCapture();
    AppMethodBeat.o(211856);
  }
  
  private void h()
  {
    AppMethodBeat.i(211869);
    this.c.setSurface(null);
    this.c.setSurfaceSize(0, 0);
    TXCloudVideoView localTXCloudVideoView = this.r;
    Object localObject1 = this.s;
    Object localObject2 = this.t;
    Surface localSurface = this.w;
    if (localTXCloudVideoView != null)
    {
      a("bindRenderView: bind cloud view success.");
      AppMethodBeat.o(211869);
      return;
    }
    if (localObject1 != null)
    {
      localObject2 = ((TextureView)localObject1).getSurfaceTexture();
      ((TextureView)localObject1).setSurfaceTextureListener(this);
      if (localObject2 != null)
      {
        a("bindRenderView: bind texture view success.");
        localObject2 = new Surface((SurfaceTexture)localObject2);
        this.c.setSurface((Surface)localObject2);
        this.c.setSurfaceSize(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
      }
      AppMethodBeat.o(211869);
      return;
    }
    if (localObject2 != null)
    {
      ((SurfaceView)localObject2).getHolder().addCallback(this);
      localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
      if (((Surface)localObject1).isValid())
      {
        a("bindRenderView: bind surface view success.");
        this.c.setSurface((Surface)localObject1);
        this.c.setSurfaceSize(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
        AppMethodBeat.o(211869);
      }
    }
    else
    {
      if (localSurface != null)
      {
        a("bindRenderView: bind surface success.");
        this.c.setSurface(localSurface);
        localObject1 = this.x;
        if (localObject1 != null) {
          this.c.setSurfaceSize(((a.a)localObject1).a, ((a.a)localObject1).b);
        }
        AppMethodBeat.o(211869);
        return;
      }
      c("bindRender: all view is null, bind fail.");
    }
    AppMethodBeat.o(211869);
  }
  
  private void i()
  {
    AppMethodBeat.i(211875);
    Object localObject = this.s;
    if (localObject != null)
    {
      a("unbindRenderView: unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    localObject = this.t;
    if (localObject != null)
    {
      a("unbindRenderView: unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    if (this.w != null)
    {
      a("unbindRenderView: unbind surface.");
      this.c.setSurface(null);
      this.c.setSurfaceSize(0, 0);
    }
    AppMethodBeat.o(211875);
  }
  
  public int enableCustomVideoCapture(boolean paramBoolean)
  {
    AppMethodBeat.i(211953);
    this.o = paramBoolean;
    if (this.o)
    {
      a(this.m);
      this.b.setCustomModeType(2);
    }
    for (;;)
    {
      AppMethodBeat.o(211953);
      return 0;
      this.b.setCustomModeType(0);
    }
  }
  
  public int enableCustomVideoProcess(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    AppMethodBeat.i(211952);
    if (paramBoolean) {
      this.c.setVideoProcessListener(this);
    }
    for (;;)
    {
      AppMethodBeat.o(211952);
      return 0;
      this.c.setVideoProcessListener(null);
    }
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(211950);
    this.p = paramInt;
    this.c.enableAudioVolumeEvaluation(paramInt);
    AppMethodBeat.o(211950);
    return 0;
  }
  
  public TXAudioEffectManager getAudioEffectManager()
  {
    AppMethodBeat.i(211945);
    TXAudioEffectManager localTXAudioEffectManager = this.c.getAudioEffectManager();
    AppMethodBeat.o(211945);
    return localTXAudioEffectManager;
  }
  
  public TXBeautyManager getBeautyManager()
  {
    AppMethodBeat.i(211942);
    TXBeautyManager localTXBeautyManager = this.c.getBeautyManager();
    AppMethodBeat.o(211942);
    return localTXBeautyManager;
  }
  
  public TXDeviceManager getDeviceManager()
  {
    return this.v;
  }
  
  public int isPushing()
  {
    if (this.d) {
      return 1;
    }
    return 0;
  }
  
  public void onAudioVolumeEvaluationNotify(int paramInt)
  {
    AppMethodBeat.i(211959);
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onMicrophoneVolumeUpdate(paramInt);
    }
    AppMethodBeat.o(211959);
  }
  
  public void onDetectFacePoints(float[] paramArrayOfFloat) {}
  
  public void onNetStatus(Bundle paramBundle)
  {
    AppMethodBeat.i(211973);
    try
    {
      localObject = h.a();
      if ((localObject != null) && (localObject.length == 2))
      {
        this.l.appCpu = (localObject[0] / 10);
        this.l.systemCpu = (localObject[1] / 10);
      }
      this.l.width = paramBundle.getInt("VIDEO_WIDTH");
      this.l.height = paramBundle.getInt("VIDEO_HEIGHT");
      this.l.fps = paramBundle.getInt("VIDEO_FPS");
      this.l.videoBitrate = paramBundle.getInt("VIDEO_BITRATE");
      this.l.audioBitrate = paramBundle.getInt("AUDIO_BITRATE");
    }
    catch (Exception localException)
    {
      Object localObject;
      label116:
      break label116;
    }
    localObject = this.u;
    if (localObject != null) {
      ((V2TXLivePusherObserver)localObject).onStatisticsUpdate(this.l);
    }
    if ((localObject != null) && ((localObject instanceof com.tencent.live2.impl.a.b))) {
      ((com.tencent.live2.impl.a.b)localObject).onPushNetStatus(paramBundle);
    }
    AppMethodBeat.o(211973);
  }
  
  public void onPushEvent(int paramInt, Bundle paramBundle)
  {
    int i1 = -1301;
    AppMethodBeat.i(211971);
    if (paramInt != 1020) {
      a("push event:" + paramInt + " param:" + paramBundle);
    }
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof com.tencent.live2.impl.a.b))) {
        ((com.tencent.live2.impl.a.b)localV2TXLivePusherObserver).onPushEvent(paramInt, paramBundle);
      }
      AppMethodBeat.o(211971);
      return;
      if (!this.j)
      {
        a("onPushEvent: onCaptureFirstAudioFrame");
        this.j = true;
        if (localV2TXLivePusherObserver != null)
        {
          localV2TXLivePusherObserver.onCaptureFirstAudioFrame();
          continue;
          if (!this.i)
          {
            a("onPushEvent: onCaptureFirstVideoFrame");
            this.i = true;
            if (localV2TXLivePusherObserver != null)
            {
              localV2TXLivePusherObserver.onCaptureFirstVideoFrame();
              continue;
              Object localObject2;
              Object localObject1;
              if (this.h)
              {
                a("onPushEvent: reconnected to the server successfully.");
                this.h = false;
                if (localV2TXLivePusherObserver != null)
                {
                  localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess;
                  if (paramBundle != null) {}
                  for (localObject1 = paramBundle;; localObject1 = new Bundle())
                  {
                    localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "reconnected to the server successfully.", (Bundle)localObject1);
                    break;
                  }
                }
              }
              else
              {
                a("onPushEvent: connected to the server successfully.");
                if (localV2TXLivePusherObserver != null)
                {
                  localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess;
                  if (paramBundle != null) {}
                  for (localObject1 = paramBundle;; localObject1 = new Bundle())
                  {
                    localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "connected to the server successfully.", (Bundle)localObject1);
                    break;
                  }
                  c("onPushEvent: reset connection state.");
                  this.d = false;
                  this.h = false;
                  if (localV2TXLivePusherObserver != null)
                  {
                    localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected;
                    if (paramBundle != null) {}
                    for (localObject1 = paramBundle;; localObject1 = new Bundle())
                    {
                      localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "disconnected from the server.", (Bundle)localObject1);
                      break;
                    }
                    if (!this.h)
                    {
                      a("onPushEvent: reconnecting to the server.");
                      this.h = true;
                      if (localV2TXLivePusherObserver != null)
                      {
                        localObject2 = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusReconnecting;
                        if (paramBundle != null) {}
                        for (localObject1 = paramBundle;; localObject1 = new Bundle())
                        {
                          localV2TXLivePusherObserver.onPushStatusUpdate((V2TXLiveDef.V2TXLivePushStatus)localObject2, "reconnecting to the server.", (Bundle)localObject1);
                          break;
                        }
                        c("onPushEvent: camera failed to launch.");
                        localObject1 = "";
                        switch (paramInt)
                        {
                        default: 
                          e();
                          if (localV2TXLivePusherObserver != null) {
                            if (paramBundle != null) {}
                          }
                          break;
                        case -1301: 
                        case -1314: 
                        case -1316: 
                          label572:
                          for (localObject2 = new Bundle();; localObject2 = paramBundle)
                          {
                            localV2TXLivePusherObserver.onWarning(i1, (String)localObject1, (Bundle)localObject2);
                            break;
                            localObject1 = "camera failed to open.";
                            break label572;
                            i1 = -1314;
                            localObject1 = "camera not authorized.";
                            break label572;
                            i1 = -1316;
                            localObject1 = "camera is occupied.";
                            break label572;
                          }
                          c("onPushEvent: microphone failed to launch.");
                          localObject1 = "";
                          switch (paramInt)
                          {
                          default: 
                            i1 = -1302;
                            f();
                            if (localV2TXLivePusherObserver != null) {
                              if (paramBundle != null) {}
                            }
                            break;
                          case -1302: 
                          case -1317: 
                          case -1319: 
                            label696:
                            for (localObject2 = new Bundle();; localObject2 = paramBundle)
                            {
                              localV2TXLivePusherObserver.onWarning(i1, (String)localObject1, (Bundle)localObject2);
                              break;
                              localObject1 = "microphone failed to open.";
                              i1 = -1302;
                              break label696;
                              i1 = -1317;
                              localObject1 = "microphone not authorized.";
                              break label696;
                              i1 = -1319;
                              localObject1 = "microphone is occupied.";
                              break label696;
                            }
                            localObject1 = "";
                            switch (paramInt)
                            {
                            default: 
                              i1 = -1308;
                              g();
                              if (localV2TXLivePusherObserver != null) {
                                if (paramBundle != null) {}
                              }
                              break;
                            case -1308: 
                            case -1309: 
                            case -7001: 
                              label816:
                              for (localObject2 = new Bundle();; localObject2 = paramBundle)
                              {
                                localV2TXLivePusherObserver.onWarning(i1, (String)localObject1, (Bundle)localObject2);
                                break;
                                localObject1 = "screen capture failed to start.";
                                i1 = -1308;
                                break label816;
                                i1 = -1309;
                                localObject1 = "screen capture is not supported on the system.";
                                break label816;
                                i1 = -7001;
                                localObject1 = "screen capture is interrupted by the system.";
                                break label816;
                              }
                              if (localV2TXLivePusherObserver != null) {
                                localV2TXLivePusherObserver.onWarning(1101, "Network is busy, please check your network status.", new Bundle());
                              }
                              break;
                            }
                            break;
                          }
                          break;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onRecordPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onRecordRawPcmData(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211981);
    a("TextureView: available width-" + paramInt1 + " height-" + paramInt2);
    if (paramSurfaceTexture != null) {
      this.c.setSurface(new Surface(paramSurfaceTexture));
    }
    this.c.setSurfaceSize(paramInt1, paramInt2);
    AppMethodBeat.o(211981);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(211984);
    a("TextureView: destroyed.");
    this.c.setSurface(null);
    AppMethodBeat.o(211984);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211982);
    a("TextureView: size changed width-" + paramInt1 + " height-" + paramInt2);
    this.c.setSurfaceSize(paramInt1, paramInt2);
    AppMethodBeat.o(211982);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public int onTextureCustomProcess(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211961);
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (!this.A)
    {
      this.A = true;
      a("onGLContextCreate");
      if (localV2TXLivePusherObserver != null) {
        localV2TXLivePusherObserver.onGLContextCreated();
      }
    }
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame1 = a(paramInt1, paramInt2, paramInt3);
    V2TXLiveDef.V2TXLiveVideoFrame localV2TXLiveVideoFrame2 = a(paramInt1, paramInt2, paramInt3);
    if (localV2TXLivePusherObserver != null)
    {
      localV2TXLivePusherObserver.onProcessVideoFrame(localV2TXLiveVideoFrame1, localV2TXLiveVideoFrame2);
      paramInt1 = localV2TXLiveVideoFrame2.texture.textureId;
      AppMethodBeat.o(211961);
      return paramInt1;
    }
    paramInt1 = localV2TXLiveVideoFrame1.texture.textureId;
    AppMethodBeat.o(211961);
    return paramInt1;
  }
  
  public void onTextureDestoryed()
  {
    AppMethodBeat.i(211966);
    a("onGLContextDestroy");
    this.A = false;
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onGLContextDestroyed();
    }
    AppMethodBeat.o(211966);
  }
  
  public int sendCustomVideoFrame(V2TXLiveDef.V2TXLiveVideoFrame paramV2TXLiveVideoFrame)
  {
    AppMethodBeat.i(211955);
    if ((paramV2TXLiveVideoFrame.pixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatI420) && (paramV2TXLiveVideoFrame.bufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeByteArray))
    {
      this.c.sendCustomVideoData(paramV2TXLiveVideoFrame.data, 3, paramV2TXLiveVideoFrame.width, paramV2TXLiveVideoFrame.height);
      AppMethodBeat.o(211955);
      return 0;
    }
    if ((paramV2TXLiveVideoFrame.pixelFormat == V2TXLiveDef.V2TXLivePixelFormat.V2TXLivePixelFormatTexture2D) && (paramV2TXLiveVideoFrame.bufferType == V2TXLiveDef.V2TXLiveBufferType.V2TXLiveBufferTypeTexture))
    {
      this.c.sendCustomVideoTexture(paramV2TXLiveVideoFrame.texture.textureId, paramV2TXLiveVideoFrame.width, paramV2TXLiveVideoFrame.height);
      AppMethodBeat.o(211955);
      return 0;
    }
    AppMethodBeat.o(211955);
    return -4;
  }
  
  public int setAudioQuality(V2TXLiveDef.V2TXLiveAudioQuality paramV2TXLiveAudioQuality)
  {
    int i3 = 48000;
    int i4 = 1;
    AppMethodBeat.i(211939);
    a("setAudioQuality: quality-".concat(String.valueOf(paramV2TXLiveAudioQuality)));
    if (isPushing() == 1)
    {
      c("set audio quality fail. can't set audio quality after start push.");
      AppMethodBeat.o(211939);
      return -3;
    }
    V2TXLiveDef.V2TXLiveAudioQuality localV2TXLiveAudioQuality = paramV2TXLiveAudioQuality;
    if (paramV2TXLiveAudioQuality == null) {
      localV2TXLiveAudioQuality = V2TXLiveDef.V2TXLiveAudioQuality.V2TXLiveAudioQualityDefault;
    }
    int i1 = i4;
    int i2 = i3;
    switch (4.c[localV2TXLiveAudioQuality.ordinal()])
    {
    default: 
      i2 = i3;
      i1 = i4;
    }
    for (;;)
    {
      this.b.setAudioSampleRate(i2);
      this.b.setAudioChannels(i1);
      AppMethodBeat.o(211939);
      return 0;
      i2 = 16000;
      i1 = i4;
      continue;
      i1 = 2;
      i2 = i3;
    }
  }
  
  public int setEncoderMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(211949);
    this.c.setMirror(paramBoolean);
    AppMethodBeat.o(211949);
    return 0;
  }
  
  public int setMixTranscodingConfig(V2TXLiveDef.V2TXLiveTranscodingConfig paramV2TXLiveTranscodingConfig)
  {
    return -4;
  }
  
  public void setObserver(V2TXLivePusherObserver paramV2TXLivePusherObserver)
  {
    this.u = paramV2TXLivePusherObserver;
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    int i2 = 3;
    AppMethodBeat.i(211903);
    if (paramString != "sendSEIMessage") {
      a("set property, key:" + paramString + " value:" + paramObject);
    }
    int i1 = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i1)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(211903);
      return 0;
      if (!paramString.equals("enableAudioAGC")) {
        break;
      }
      i1 = 0;
      break;
      if (!paramString.equals("enableAudioANS")) {
        break;
      }
      i1 = 1;
      break;
      if (!paramString.equals("setPureAudioPushMode")) {
        break;
      }
      i1 = 2;
      break;
      if (!paramString.equals("enableCameraZoom")) {
        break;
      }
      i1 = 3;
      break;
      if (!paramString.equals("setSurface")) {
        break;
      }
      i1 = 4;
      break;
      if (!paramString.equals("setSurfaceSize")) {
        break;
      }
      i1 = 5;
      break;
      if (!paramString.equals("muteAudio")) {
        break;
      }
      i1 = 6;
      break;
      if (!paramString.equals("setCustomVideoEncParam")) {
        break;
      }
      i1 = 7;
      break;
      if (!paramString.equals("setVideoQuality")) {
        break;
      }
      i1 = 8;
      break;
      if (!paramString.equals("sendSEIMessage")) {
        break;
      }
      i1 = 9;
      break;
      if (!paramString.equals("setPauseParam")) {
        break;
      }
      i1 = 10;
      break;
      if (!paramString.equals("pausePusher")) {
        break;
      }
      i1 = 11;
      break;
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        this.b.enableAGC(((Boolean)paramObject).booleanValue());
        a();
        continue;
        if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          this.b.enableANS(((Boolean)paramObject).booleanValue());
          a();
          continue;
          if ((paramObject != null) && ((paramObject instanceof Boolean)))
          {
            this.b.enablePureAudioPush(((Boolean)paramObject).booleanValue());
            a();
            continue;
            if ((paramObject != null) && ((paramObject instanceof Boolean)))
            {
              this.b.setEnableZoom(((Boolean)paramObject).booleanValue());
              a();
              continue;
              if (paramObject == null)
              {
                this.w = null;
                this.c.setSurface(null);
              }
              else if ((paramObject instanceof Surface))
              {
                this.w = ((Surface)paramObject);
                this.c.setSurface(this.w);
                continue;
                if (paramObject == null)
                {
                  this.x = null;
                  this.c.setSurfaceSize(0, 0);
                }
                else if ((paramObject instanceof a.a))
                {
                  this.x = ((a.a)paramObject);
                  this.c.setSurfaceSize(this.x.a, this.x.b);
                  continue;
                  if ((paramObject != null) && ((paramObject instanceof Boolean)))
                  {
                    this.y = ((Boolean)paramObject).booleanValue();
                    this.c.setMute(this.y);
                    continue;
                    if ((paramObject != null) && ((paramObject instanceof a.e)))
                    {
                      this.m = ((a.e)paramObject);
                      a(this.m);
                      continue;
                      if ((paramObject != null) && ((paramObject instanceof a.f)))
                      {
                        paramString = (a.f)paramObject;
                        this.c.setVideoQuality(paramString.a, paramString.c, paramString.b);
                        continue;
                        if ((paramObject != null) && ((paramObject instanceof byte[])))
                        {
                          this.c.sendMessageEx((byte[])paramObject);
                          continue;
                          if (paramObject == null)
                          {
                            this.z = null;
                            this.b.setPauseImg(null);
                            a();
                          }
                          else if ((paramObject instanceof a.c))
                          {
                            this.z = ((a.c)paramObject);
                            this.b.setPauseImg(this.z.a);
                            this.b.setPauseImg(this.z.e, this.z.b);
                            if ((this.z.d) && (this.z.c)) {
                              i1 = i2;
                            }
                            for (;;)
                            {
                              this.b.setPauseFlag(i1);
                              a();
                              break;
                              if (this.z.d) {
                                i1 = 2;
                              } else {
                                i1 = 1;
                              }
                            }
                            if ((paramObject != null) && ((paramObject instanceof Boolean))) {
                              if (((Boolean)paramObject).booleanValue()) {
                                this.c.pausePusher();
                              } else {
                                this.c.resumePusher();
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public int setRenderMirror(V2TXLiveDef.V2TXLiveMirrorType paramV2TXLiveMirrorType)
  {
    AppMethodBeat.i(211916);
    V2TXLiveDef.V2TXLiveMirrorType localV2TXLiveMirrorType = paramV2TXLiveMirrorType;
    if (paramV2TXLiveMirrorType == null) {
      localV2TXLiveMirrorType = V2TXLiveDef.V2TXLiveMirrorType.V2TXLiveMirrorTypeAuto;
    }
    switch (4.b[localV2TXLiveMirrorType.ordinal()])
    {
    }
    for (;;)
    {
      a();
      AppMethodBeat.o(211916);
      return 0;
      this.b.setLocalVideoMirrorType(0);
      continue;
      this.b.setLocalVideoMirrorType(1);
      continue;
      this.b.setLocalVideoMirrorType(2);
    }
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(211920);
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null) {
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    this.n = com.tencent.live2.impl.b.a(localV2TXLiveRotation);
    c();
    AppMethodBeat.o(211920);
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(211912);
    i();
    this.t = paramSurfaceView;
    h();
    AppMethodBeat.o(211912);
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    AppMethodBeat.i(211910);
    i();
    this.s = paramTextureView;
    h();
    AppMethodBeat.o(211910);
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(211907);
    boolean bool = this.e;
    if (bool) {
      this.c.stopCameraPreview(false);
    }
    i();
    this.r = paramTXCloudVideoView;
    if (paramTXCloudVideoView != null) {
      paramTXCloudVideoView.showLog(this.q);
    }
    if (bool) {
      this.c.startCameraPreview(paramTXCloudVideoView);
    }
    AppMethodBeat.o(211907);
    return 0;
  }
  
  public int setVideoQuality(V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode)
  {
    AppMethodBeat.i(211941);
    a("setVideoQuality: resolution-" + paramV2TXLiveVideoResolution + " mode-" + paramV2TXLiveVideoResolutionMode);
    V2TXLiveDef.V2TXLiveVideoResolution localV2TXLiveVideoResolution = paramV2TXLiveVideoResolution;
    if (paramV2TXLiveVideoResolution == null)
    {
      localV2TXLiveVideoResolution = V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540;
      b("setVideoQuality: resolution is null, force set to ".concat(String.valueOf(localV2TXLiveVideoResolution)));
    }
    paramV2TXLiveVideoResolution = paramV2TXLiveVideoResolutionMode;
    if (paramV2TXLiveVideoResolutionMode == null)
    {
      paramV2TXLiveVideoResolution = V2TXLiveDef.V2TXLiveVideoResolutionMode.V2TXLiveVideoResolutionModePortrait;
      b("setVideoQuality: mode is null, force set to ".concat(String.valueOf(paramV2TXLiveVideoResolution)));
    }
    paramV2TXLiveVideoResolution = new a.e(localV2TXLiveVideoResolution, paramV2TXLiveVideoResolution);
    this.m = paramV2TXLiveVideoResolution;
    a(paramV2TXLiveVideoResolution);
    AppMethodBeat.o(211941);
    return 0;
  }
  
  public int setWatermark(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(211947);
    this.b.setWatermark(paramBitmap, paramFloat1, paramFloat2, paramFloat3);
    a();
    AppMethodBeat.o(211947);
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    AppMethodBeat.i(211956);
    this.q = paramBoolean;
    if (this.r != null) {
      this.r.showLog(this.q);
    }
    AppMethodBeat.o(211956);
  }
  
  public int snapshot()
  {
    AppMethodBeat.i(211946);
    this.c.snapshot(new TXLivePusher.ITXSnapshotListener()
    {
      public void onSnapshot(Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(211724);
        V2TXLivePusherObserver localV2TXLivePusherObserver = b.b(b.this);
        if (localV2TXLivePusherObserver != null) {
          localV2TXLivePusherObserver.onSnapshotComplete(paramAnonymousBitmap);
        }
        AppMethodBeat.o(211724);
      }
    });
    AppMethodBeat.o(211946);
    return 0;
  }
  
  public int startCamera(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(211923);
    this.i = false;
    this.e = true;
    a(this.m);
    getDeviceManager().switchCamera(paramBoolean);
    this.b.setFrontCamera(paramBoolean);
    TXLivePushConfig localTXLivePushConfig = this.b;
    if (!getDeviceManager().isAutoFocusEnabled()) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localTXLivePushConfig.setTouchFocus(paramBoolean);
      a();
      this.c.startCameraPreview(this.r);
      h();
      AppMethodBeat.o(211923);
      return 0;
    }
  }
  
  public int startMicrophone()
  {
    AppMethodBeat.i(211931);
    a("startMicrophone: pushing-" + this.d);
    this.g = true;
    this.c.setMute(this.y);
    AppMethodBeat.o(211931);
    return 0;
  }
  
  public int startPush(String paramString)
  {
    AppMethodBeat.i(211935);
    a("startPush: url-".concat(String.valueOf(paramString)));
    this.d = true;
    this.c.setConfig(this.b);
    int i1;
    if ((!this.g) || (this.y == true))
    {
      this.c.setMute(true);
      this.c.callExperimentalAPI(String.format(Locale.ENGLISH, "{\"api\":\"setInterfaceType\", \"params\": {\"type\":%d}}", new Object[] { Integer.valueOf(1) }));
      i1 = this.c.startPusher(paramString);
      if (i1 != 0) {
        break label155;
      }
      this.c.enableAudioVolumeEvaluation(this.p);
      paramString = this.u;
      if (paramString != null) {
        paramString.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnecting, "connecting to the server.", new Bundle());
      }
    }
    for (;;)
    {
      AppMethodBeat.o(211935);
      return 0;
      this.c.setMute(false);
      break;
      label155:
      this.d = false;
      c("startPush: error, result-".concat(String.valueOf(i1)));
    }
  }
  
  public int startScreenCapture()
  {
    AppMethodBeat.i(211928);
    this.i = false;
    this.f = true;
    a(this.m);
    this.c.startScreenCapture();
    AppMethodBeat.o(211928);
    return 0;
  }
  
  public int stopCamera()
  {
    AppMethodBeat.i(211926);
    e();
    i();
    AppMethodBeat.o(211926);
    return 0;
  }
  
  public int stopMicrophone()
  {
    AppMethodBeat.i(211933);
    f();
    AppMethodBeat.o(211933);
    return 0;
  }
  
  public int stopPush()
  {
    AppMethodBeat.i(211936);
    a("stopPush:");
    if (!this.d)
    {
      e();
      f();
      g();
      AppMethodBeat.o(211936);
      return 0;
    }
    d();
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.u;
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected, "disconnected from the server.", new Bundle());
    }
    AppMethodBeat.o(211936);
    return 0;
  }
  
  public int stopScreenCapture()
  {
    AppMethodBeat.i(211930);
    g();
    AppMethodBeat.o(211930);
    return 0;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211976);
    a("SurfaceView: onSizeChanged. width-" + paramInt2 + " height-" + paramInt3);
    this.c.setSurfaceSize(paramInt2, paramInt3);
    AppMethodBeat.o(211976);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(211974);
    a("SurfaceView: onCreate.");
    this.c.setSurface(paramSurfaceHolder.getSurface());
    AppMethodBeat.o(211974);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(211979);
    a("SurfaceView: onDestroyed.");
    this.c.setSurface(null);
    AppMethodBeat.o(211979);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.a.b
 * JD-Core Version:    0.7.0.1
 */