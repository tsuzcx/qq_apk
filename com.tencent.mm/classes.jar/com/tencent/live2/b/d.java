package com.tencent.live2.b;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.a.a;
import com.tencent.live2.impl.a.d;
import com.tencent.live2.impl.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class d
  extends V2TXLivePlayer
  implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, f.a
{
  private V2TXLivePlayer a;
  private Context b;
  private Handler c;
  private V2TXLivePlayerObserver d;
  private TextureView e;
  private SurfaceView f;
  private TXCloudVideoView g;
  private Surface h;
  private int i;
  private int j;
  private V2TXLiveDef.V2TXLiveRotation k;
  private V2TXLiveDef.V2TXLiveFillMode l;
  private V2TXLiveDef.V2TXLivePixelFormat m;
  private V2TXLiveDef.V2TXLiveBufferType n;
  private int o;
  private int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private f u;
  private a v;
  
  public d(V2TXLivePlayer paramV2TXLivePlayer, Context paramContext)
  {
    AppMethodBeat.i(211386);
    this.c = new Handler(Looper.getMainLooper());
    this.o = -1;
    this.p = -1;
    this.a = paramV2TXLivePlayer;
    this.b = paramContext.getApplicationContext();
    f.a(paramContext);
    AppMethodBeat.o(211386);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211441);
    this.i = paramInt1;
    this.j = paramInt2;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), paramInt1, paramInt2);
    }
    AppMethodBeat.o(211441);
  }
  
  private void a(Surface paramSurface)
  {
    AppMethodBeat.i(211432);
    this.h = paramSurface;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), paramSurface);
    }
    AppMethodBeat.o(211432);
  }
  
  private boolean a()
  {
    AppMethodBeat.i(211373);
    if (this.u == null)
    {
      AppMethodBeat.o(211373);
      return false;
    }
    if (this.v == null)
    {
      AppMethodBeat.o(211373);
      return false;
    }
    if (this.v.e())
    {
      if (!"27eb683b73944771ce62fbddab2849a4".equals(this.v.b()))
      {
        AppMethodBeat.o(211373);
        return true;
      }
      AppMethodBeat.o(211373);
      return false;
    }
    AppMethodBeat.o(211373);
    return true;
  }
  
  private void b()
  {
    AppMethodBeat.i(211383);
    if (!a())
    {
      AppMethodBeat.o(211383);
      return;
    }
    String str = this.v.b();
    int i1 = this.v.c();
    this.u.a(str, i1, this.a, this.d);
    this.u.a(this.v.b(), this.v.c(), this.s, b.a(this.m), b.a(this.n));
    if (this.g != null) {
      this.u.a(str, i1, this.g);
    }
    for (;;)
    {
      if (this.k != null) {
        this.u.a(str, i1, this.k);
      }
      if (this.l != null) {
        this.u.a(str, i1, this.l);
      }
      this.u.a(str, i1, this.r);
      this.u.b(str, i1, this.q);
      if (this.p > 0) {
        this.u.a(this.p);
      }
      if (this.o > 0) {
        this.u.d(str, this.o);
      }
      this.u.f(this.t);
      AppMethodBeat.o(211383);
      return;
      if (this.h != null)
      {
        this.u.a(str, i1, this.h);
        this.u.a(str, i1, this.i, this.j);
      }
    }
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(211402);
    TXCLog.i("V2-TXTRTCPlayerImpl", "v2_api_trtc_player(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211402);
  }
  
  private int c()
  {
    AppMethodBeat.i(211396);
    b("stopPlayInner");
    if ((this.v == null) || (this.u == null))
    {
      c("stop play inner warning. have benn stop.");
      AppMethodBeat.o(211396);
      return 0;
    }
    e();
    this.u.a(this.v.b(), this.v.c(), false, 0, 0);
    this.u.c(this.v.b(), this.v.c());
    this.u.a(this.v.b(), this.v.c());
    if (this.v.e())
    {
      f.a(this.u);
      this.u = null;
    }
    this.v = null;
    b("stopPlayInner success");
    AppMethodBeat.o(211396);
    return 0;
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(211413);
    TXCLog.w("V2-TXTRTCPlayerImpl", "v2_api_trtc_player(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211413);
  }
  
  private void d()
  {
    AppMethodBeat.i(211451);
    TXCloudVideoView localTXCloudVideoView = this.g;
    Object localObject1 = this.e;
    Object localObject2 = this.f;
    if (localTXCloudVideoView != null)
    {
      if (a())
      {
        this.u.a(this.v.b(), this.v.c(), localTXCloudVideoView);
        AppMethodBeat.o(211451);
      }
    }
    else
    {
      if (localObject1 != null)
      {
        ((TextureView)localObject1).setSurfaceTextureListener(this);
        localObject2 = ((TextureView)localObject1).getSurfaceTexture();
        if (localObject2 != null)
        {
          b("bindRenderView surface texture is valid, set into player.");
          a(new Surface((SurfaceTexture)localObject2));
          a(((TextureView)localObject1).getWidth(), ((TextureView)localObject1).getHeight());
        }
        AppMethodBeat.o(211451);
        return;
      }
      if (localObject2 != null)
      {
        ((SurfaceView)localObject2).getHolder().addCallback(this);
        localObject1 = ((SurfaceView)localObject2).getHolder().getSurface();
        if (((Surface)localObject1).isValid())
        {
          b("bindRenderView surface is valid, set into player.");
          a((Surface)localObject1);
          a(((SurfaceView)localObject2).getWidth(), ((SurfaceView)localObject2).getHeight());
        }
      }
    }
    AppMethodBeat.o(211451);
  }
  
  private void d(String paramString)
  {
    AppMethodBeat.i(211420);
    TXCLog.e("V2-TXTRTCPlayerImpl", "v2_api_trtc_player(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(211420);
  }
  
  private void e()
  {
    AppMethodBeat.i(211460);
    Object localObject = this.e;
    if (localObject != null)
    {
      b("unbindRenderView unbind texture view.");
      ((TextureView)localObject).setSurfaceTextureListener(null);
      a(null);
      a(0, 0);
    }
    localObject = this.f;
    if (localObject != null)
    {
      b("unbindRenderView unbind surface view.");
      ((SurfaceView)localObject).getHolder().removeCallback(this);
      a(null);
      a(0, 0);
    }
    AppMethodBeat.o(211460);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(211793);
    d("onExitRoomByServer reason:" + paramInt + " stop play inner.");
    c();
    AppMethodBeat.o(211793);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(211800);
    d("onEnterRoomFail reason:" + paramLong + " stop play inner.");
    c();
    AppMethodBeat.o(211800);
  }
  
  public void a(String paramString)
  {
    AppMethodBeat.i(211783);
    b("notifyUserId [userId:" + paramString + "][isDefault:" + "27eb683b73944771ce62fbddab2849a4".equals(paramString) + "]");
    if (this.v == null)
    {
      d("notify user id fail. play url param is null. maybe something error.");
      AppMethodBeat.o(211783);
      return;
    }
    if (!this.v.e())
    {
      d("notify user id fail. current play is not trtc protocol. maybe something error.");
      AppMethodBeat.o(211783);
      return;
    }
    this.v.a(paramString);
    if (a()) {
      b();
    }
    AppMethodBeat.o(211783);
  }
  
  public int enableCustomRendering(boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType)
  {
    AppMethodBeat.i(211694);
    b("enableCustomRendering enable: " + paramBoolean + ", format: " + paramV2TXLivePixelFormat + ", type: " + paramV2TXLiveBufferType);
    this.s = paramBoolean;
    this.m = paramV2TXLivePixelFormat;
    this.n = paramV2TXLiveBufferType;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), paramBoolean, b.a(this.m), b.a(this.n));
    }
    AppMethodBeat.o(211694);
    return 0;
  }
  
  public int enableVolumeEvaluation(int paramInt)
  {
    AppMethodBeat.i(211673);
    this.p = paramInt;
    if (a()) {
      this.u.a(paramInt);
    }
    AppMethodBeat.o(211673);
    return 0;
  }
  
  public int isPlaying()
  {
    AppMethodBeat.i(211597);
    String str;
    int i1;
    boolean bool;
    if ((this.v != null) && (this.u != null))
    {
      str = this.v.b();
      i1 = this.v.c();
      if ("27eb683b73944771ce62fbddab2849a4".equals(str)) {
        bool = true;
      }
    }
    for (;;)
    {
      if (bool)
      {
        AppMethodBeat.o(211597);
        return 1;
        bool = this.u.b(str, i1);
      }
      else
      {
        AppMethodBeat.o(211597);
        return 0;
        bool = false;
      }
    }
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211715);
    b("onSurfaceTextureAvailable surface: " + paramSurfaceTexture + ", width: " + paramInt1 + ", height: " + paramInt2);
    if (paramSurfaceTexture != null) {
      a(new Surface(paramSurfaceTexture));
    }
    a(paramInt1, paramInt2);
    AppMethodBeat.o(211715);
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(211741);
    b("onSurfaceTextureDestroyed surface: ".concat(String.valueOf(paramSurfaceTexture)));
    a(null);
    AppMethodBeat.o(211741);
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211727);
    b("onSurfaceTextureSizeChanged surface: " + paramSurfaceTexture + ", width: " + paramInt1 + ", height: " + paramInt2);
    a(paramInt1, paramInt2);
    AppMethodBeat.o(211727);
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public int pauseAudio()
  {
    AppMethodBeat.i(211604);
    this.r = true;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't pause sub stream audio.");
        AppMethodBeat.o(211604);
        return -4;
      }
      this.u.a(this.v.b(), this.v.c(), true);
    }
    AppMethodBeat.o(211604);
    return 0;
  }
  
  public int pauseVideo()
  {
    AppMethodBeat.i(211627);
    this.q = true;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't pause sub stream video.");
        AppMethodBeat.o(211627);
        return -4;
      }
      this.u.b(this.v.b(), this.v.c(), true);
    }
    AppMethodBeat.o(211627);
    return 0;
  }
  
  public int resumeAudio()
  {
    AppMethodBeat.i(211616);
    this.r = false;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't resume sub stream audio.");
        AppMethodBeat.o(211616);
        return -4;
      }
      this.u.a(this.v.b(), this.v.c(), false);
    }
    AppMethodBeat.o(211616);
    return 0;
  }
  
  public int resumeVideo()
  {
    AppMethodBeat.i(211638);
    this.q = false;
    if (a())
    {
      if (this.v.c() == 2)
      {
        c("pause audio fail. you shouldn't resume sub stream video.");
        AppMethodBeat.o(211638);
        return -4;
      }
      this.u.b(this.v.b(), this.v.c(), false);
    }
    AppMethodBeat.o(211638);
    return 0;
  }
  
  public int setCacheParams(float paramFloat1, float paramFloat2)
  {
    return -4;
  }
  
  public void setObserver(V2TXLivePlayerObserver paramV2TXLivePlayerObserver)
  {
    AppMethodBeat.i(211486);
    this.d = paramV2TXLivePlayerObserver;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), this.a, this.d);
    }
    AppMethodBeat.o(211486);
  }
  
  public int setPlayoutVolume(int paramInt)
  {
    AppMethodBeat.i(211652);
    this.o = paramInt;
    if (a()) {
      this.u.d(this.v.b(), paramInt);
    }
    AppMethodBeat.o(211652);
    return 0;
  }
  
  public int setProperty(String paramString, Object paramObject)
  {
    AppMethodBeat.i(211499);
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
      AppMethodBeat.o(211499);
      return 0;
      if (!paramString.equals("setSurface")) {
        break;
      }
      i1 = 0;
      break;
      if (!paramString.equals("setSurfaceSize")) {
        break;
      }
      i1 = 1;
      break;
      if (paramObject == null)
      {
        this.h = null;
        a(null);
      }
      else if ((paramObject != null) && ((paramObject instanceof Surface)))
      {
        this.h = ((Surface)paramObject);
        a(this.h);
        continue;
        if (paramObject == null)
        {
          this.i = 0;
          this.j = 0;
          a(0, 0);
        }
        else if ((paramObject != null) && ((paramObject instanceof a.a)))
        {
          paramString = (a.a)paramObject;
          this.i = paramString.a;
          this.j = paramString.b;
          a(this.i, this.j);
        }
      }
    }
  }
  
  public int setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode)
  {
    AppMethodBeat.i(211558);
    V2TXLiveDef.V2TXLiveFillMode localV2TXLiveFillMode = paramV2TXLiveFillMode;
    if (paramV2TXLiveFillMode == null) {
      localV2TXLiveFillMode = V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFill;
    }
    this.l = localV2TXLiveFillMode;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), this.l);
    }
    AppMethodBeat.o(211558);
    return 0;
  }
  
  public int setRenderRotation(V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation)
  {
    AppMethodBeat.i(211549);
    V2TXLiveDef.V2TXLiveRotation localV2TXLiveRotation = paramV2TXLiveRotation;
    if (paramV2TXLiveRotation == null) {
      localV2TXLiveRotation = V2TXLiveDef.V2TXLiveRotation.V2TXLiveRotation0;
    }
    this.k = localV2TXLiveRotation;
    if (a()) {
      this.u.a(this.v.b(), this.v.c(), this.k);
    }
    AppMethodBeat.o(211549);
    return 0;
  }
  
  public int setRenderView(SurfaceView paramSurfaceView)
  {
    AppMethodBeat.i(211536);
    e();
    this.f = paramSurfaceView;
    d();
    AppMethodBeat.o(211536);
    return 0;
  }
  
  public int setRenderView(TextureView paramTextureView)
  {
    AppMethodBeat.i(211524);
    e();
    this.e = paramTextureView;
    d();
    AppMethodBeat.o(211524);
    return 0;
  }
  
  public int setRenderView(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(211512);
    e();
    this.g = paramTXCloudVideoView;
    d();
    AppMethodBeat.o(211512);
    return 0;
  }
  
  public void showDebugView(boolean paramBoolean)
  {
    AppMethodBeat.i(211703);
    this.t = paramBoolean;
    if (a()) {
      this.u.f(paramBoolean);
    }
    AppMethodBeat.o(211703);
  }
  
  public int snapshot()
  {
    AppMethodBeat.i(211679);
    if (a())
    {
      this.u.e(this.v.b(), this.v.c());
      AppMethodBeat.o(211679);
      return 0;
    }
    AppMethodBeat.o(211679);
    return -3;
  }
  
  public int startPlay(final String paramString)
  {
    AppMethodBeat.i(211574);
    b("startPlay url: ".concat(String.valueOf(paramString)));
    if ((this.u != null) && (this.v != null))
    {
      this.u.c(this.v.b(), this.v.c());
      if (this.v.e())
      {
        f.a(this.u);
        this.u = null;
      }
    }
    a locala = a.b(paramString);
    if ((locala.e()) && (f.a(locala.a())))
    {
      d("start play fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.");
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211446);
          V2TXLivePlayerObserver localV2TXLivePlayerObserver = d.a(d.this);
          if (localV2TXLivePlayerObserver != null) {
            localV2TXLivePlayerObserver.onError(d.b(d.this), -3, "start play fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.", new Bundle());
          }
          AppMethodBeat.o(211446);
        }
      });
      AppMethodBeat.o(211574);
      return -3;
    }
    this.u = f.a(this.b, locala.a(), locala.d(), this);
    if (this.u == null)
    {
      if (locala.d() == a.d.a) {}
      for (paramString = "start play fail. you should start pusher firstly when using room protocol.";; paramString = "start play fail. can't find available instance.")
      {
        d(paramString);
        this.c.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(211448);
            V2TXLivePlayerObserver localV2TXLivePlayerObserver = d.a(d.this);
            if (localV2TXLivePlayerObserver != null) {
              localV2TXLivePlayerObserver.onError(d.b(d.this), -3, paramString, new Bundle());
            }
            AppMethodBeat.o(211448);
          }
        });
        AppMethodBeat.o(211574);
        return -3;
      }
    }
    this.v = locala;
    e();
    d();
    b();
    final int i1 = this.u.d(paramString);
    if (i1 != 0) {
      this.c.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(211450);
          V2TXLivePlayerObserver localV2TXLivePlayerObserver = d.a(d.this);
          if (localV2TXLivePlayerObserver != null) {
            localV2TXLivePlayerObserver.onError(d.b(d.this), i1, "start play fail. [errorCode:" + i1 + "]", new Bundle());
          }
          AppMethodBeat.o(211450);
        }
      });
    }
    b("startPlay finish. result:".concat(String.valueOf(i1)));
    AppMethodBeat.o(211574);
    return i1;
  }
  
  public int stopPlay()
  {
    AppMethodBeat.i(211582);
    b("stopPlay");
    int i1 = c();
    AppMethodBeat.o(211582);
    return i1;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(211766);
    b("surfaceChanged holder: " + paramSurfaceHolder + ", format: " + paramInt1 + ", width: " + paramInt2 + ", height: " + paramInt3);
    a(paramInt2, paramInt3);
    AppMethodBeat.o(211766);
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(211758);
    if (paramSurfaceHolder != null)
    {
      b("surfaceCreated holder: " + paramSurfaceHolder + ", surface: " + paramSurfaceHolder.getSurface());
      a(paramSurfaceHolder.getSurface());
    }
    AppMethodBeat.o(211758);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(211774);
    b("surfaceDestroyed holder: ".concat(String.valueOf(paramSurfaceHolder)));
    a(null);
    AppMethodBeat.o(211774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.b.d
 * JD-Core Version:    0.7.0.1
 */