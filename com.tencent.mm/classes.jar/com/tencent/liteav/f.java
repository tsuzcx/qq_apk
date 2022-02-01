package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.a.a.b;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.p;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.renderer.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class f
  extends n
  implements TXCRenderAndDec.a, TXCRenderAndDec.b, d, com.tencent.liteav.audio.f, com.tencent.liteav.basic.c.b, com.tencent.liteav.network.h, com.tencent.liteav.renderer.a.a, g
{
  private int A;
  private int B;
  private int C;
  private com.tencent.liteav.renderer.h D;
  private com.tencent.liteav.renderer.h E;
  private float[] F;
  private float[] G;
  private String H;
  private int I;
  private com.tencent.liteav.basic.b.b J;
  private Object K;
  private com.tencent.liteav.basic.c.a L;
  private TXLivePlayer.ITXAudioRawDataListener M;
  private String N;
  private boolean O;
  private long P;
  private long Q;
  private a R;
  private TXCRenderAndDec e;
  private com.tencent.liteav.renderer.a f;
  private TXCStreamDownloader g;
  private Handler h;
  private TextureView i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  private int n;
  private boolean o;
  private Surface p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private int w;
  private com.tencent.liteav.a.a x;
  private TXRecordCommon.ITXVideoRecordListener y;
  private e z;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(229349);
    this.e = null;
    this.f = null;
    this.g = null;
    this.j = false;
    this.k = false;
    this.l = 100;
    this.m = 0;
    this.n = 0;
    this.o = false;
    this.q = 2;
    this.r = 48000;
    this.s = 16;
    this.t = false;
    this.u = false;
    this.v = false;
    this.w = 0;
    this.A = 0;
    this.B = 0;
    this.C = 0;
    this.D = null;
    this.E = null;
    this.F = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F };
    this.G = new float[16];
    this.H = "";
    this.J = com.tencent.liteav.basic.b.b.a;
    this.K = null;
    this.L = new com.tencent.liteav.basic.c.a()
    {
      public void onError(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(229435);
        f.c(f.this, "onError => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        paramAnonymousString1 = f.this.d;
        if (paramAnonymousString1 == null)
        {
          paramAnonymousString1 = null;
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString1 = new Bundle();
            paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
            paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            paramAnonymousString1.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
            if (paramAnonymousString2 != null)
            {
              paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
              if (paramAnonymousString3 == null) {
                break label169;
              }
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          f.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(229435);
          return;
          paramAnonymousString1 = (com.tencent.liteav.basic.c.b)paramAnonymousString1.get();
          break;
          label169:
          paramAnonymousString3 = "";
        }
      }
      
      public void onEvent(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(229420);
        f.a(f.this, "onEvent => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        paramAnonymousString1 = f.this.d;
        if (paramAnonymousString1 == null)
        {
          paramAnonymousString1 = null;
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString1 = new Bundle();
            paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
            paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            paramAnonymousString1.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
            if (paramAnonymousString2 != null)
            {
              paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
              if (paramAnonymousString3 == null) {
                break label169;
              }
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          f.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(229420);
          return;
          paramAnonymousString1 = (com.tencent.liteav.basic.c.b)paramAnonymousString1.get();
          break;
          label169:
          paramAnonymousString3 = "";
        }
      }
      
      public void onWarning(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(229428);
        f.b(f.this, "onWarning => id:" + paramAnonymousString1 + " code:" + paramAnonymousInt + " msg:" + paramAnonymousString2 + " params:" + paramAnonymousString3);
        paramAnonymousString1 = f.this.d;
        if (paramAnonymousString1 == null)
        {
          paramAnonymousString1 = null;
          if (paramAnonymousString1 != null)
          {
            paramAnonymousString1 = new Bundle();
            paramAnonymousString1.putInt("EVT_ID", paramAnonymousInt);
            paramAnonymousString1.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (paramAnonymousString2 != null)
            {
              paramAnonymousString2 = new StringBuilder().append(paramAnonymousString2);
              if (paramAnonymousString3 == null) {
                break label160;
              }
            }
          }
        }
        for (;;)
        {
          paramAnonymousString1.putCharSequence("EVT_MSG", paramAnonymousString3);
          f.this.onNotifyEvent(paramAnonymousInt, paramAnonymousString1);
          AppMethodBeat.o(229428);
          return;
          paramAnonymousString1 = (com.tencent.liteav.basic.c.b)paramAnonymousString1.get();
          break;
          label160:
          paramAnonymousString3 = "";
        }
      }
    };
    this.N = "";
    this.O = false;
    this.P = 0L;
    this.Q = 0L;
    this.R = null;
    c.a().a(paramContext);
    TXCAudioEngine.CreateInstance(paramContext, c.a().c());
    TXCAudioEngine.getInstance().addEventCallback(new WeakReference(this.L));
    long l1 = c.a().a("Audio", "EnableAutoRestartDevice");
    paramContext = TXCAudioEngine.getInstance();
    if ((l1 == 1L) || (l1 == -1L)) {
      bool = true;
    }
    paramContext.enableAutoRestartDevice(bool);
    this.h = new Handler(Looper.getMainLooper());
    this.f = new com.tencent.liteav.renderer.a();
    this.f.a(this);
    this.R = new a(this);
    c("[FirstFramePath] TXCLivePlayer: create player success. instance:" + hashCode());
    AppMethodBeat.o(229349);
  }
  
  private void a(final int paramInt, String paramString)
  {
    AppMethodBeat.i(229439);
    if (this.d != null)
    {
      final Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_ID", paramInt);
      localBundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
      localBundle.putLong("EVT_UTC_TIME", TXCTimeUtil.getUtcTimeTick());
      if (paramString != null) {
        localBundle.putCharSequence("EVT_MSG", paramString);
      }
      if (this.h != null) {
        this.h.post(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(229413);
            com.tencent.liteav.basic.util.h.a(f.this.d, paramInt, localBundle);
            AppMethodBeat.o(229413);
          }
        });
      }
    }
    AppMethodBeat.o(229439);
  }
  
  private int b(String paramString, int paramInt, com.tencent.liteav.network.e parame)
  {
    int i1 = 0;
    AppMethodBeat.i(229391);
    if (paramInt == 0)
    {
      this.g = new TXCStreamDownloader(this.b, 1);
      c("start network. network instance:" + this.g.hashCode());
      this.g.setID(this.N);
      this.g.setListener(this);
      this.g.setNotifyListener(this);
      this.g.setHeaders(this.a.p);
      if (paramInt == 5) {
        i1 = 1;
      }
      if (i1 == 0) {
        break label242;
      }
      this.g.setRetryTimes(5);
      this.g.setRetryInterval(1);
    }
    for (;;)
    {
      paramInt = this.g.start(paramString, this.a.i, this.a.m, this.a.j, this.a.k, parame);
      AppMethodBeat.o(229391);
      return paramInt;
      if (paramInt == 5)
      {
        this.g = new TXCStreamDownloader(this.b, 4);
        break;
      }
      this.g = new TXCStreamDownloader(this.b, 0);
      if (TextUtils.isEmpty(this.a.l)) {
        break;
      }
      this.g.setFlvSessionKey(this.a.l);
      break;
      label242:
      this.g.setRetryTimes(this.a.e);
      this.g.setRetryInterval(this.a.f);
    }
  }
  
  private void b(String paramString)
  {
    AppMethodBeat.i(229411);
    this.N = String.format("%s-%d", new Object[] { paramString, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000L) });
    if (this.e != null) {
      this.e.setID(this.N);
    }
    if (this.f != null) {
      this.f.setID(this.N);
    }
    if (this.g != null) {
      this.g.setID(this.N);
    }
    if (this.z != null) {
      this.z.d(this.N);
    }
    AppMethodBeat.o(229411);
  }
  
  private void c(String paramString)
  {
    AppMethodBeat.i(229445);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    TXCLog.i("TXCLivePlayer", "TXCLivePlayer(" + hashCode() + ") " + str);
    AppMethodBeat.o(229445);
  }
  
  private void d(String paramString)
  {
    AppMethodBeat.i(229450);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    TXCLog.e("TXCLivePlayer", "TXCLivePlayer(" + hashCode() + ") " + str);
    AppMethodBeat.o(229450);
  }
  
  private void e(String paramString)
  {
    AppMethodBeat.i(229458);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    TXCLog.w("TXCLivePlayer", "TXCLivePlayer(" + hashCode() + ") " + str);
    AppMethodBeat.o(229458);
  }
  
  private void g(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(229371);
    if (this.i != null) {
      this.i.setVisibility(0);
    }
    this.e = new TXCRenderAndDec(this.b);
    this.e.setNotifyListener(this);
    this.e.setVideoRender(this.f);
    this.e.setDecListener(this);
    this.e.setRenderAndDecDelegate(this);
    this.e.setConfig(this.a);
    this.e.setID(this.N);
    TXCRenderAndDec localTXCRenderAndDec = this.e;
    if (paramInt == 5) {
      bool = true;
    }
    localTXCRenderAndDec.start(bool);
    this.e.setRenderMode(this.n);
    this.e.setRenderRotation(this.m);
    AppMethodBeat.o(229371);
  }
  
  private void j()
  {
    AppMethodBeat.i(229352);
    if (this.x == null)
    {
      this.A = this.f.h();
      this.B = this.f.i();
      com.tencent.liteav.a.a.a locala = l();
      this.x = new com.tencent.liteav.a.a(this.b);
      this.x.a(locala);
      this.x.a(new a.b()
      {
        public void a(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          AppMethodBeat.i(229436);
          TXRecordCommon.TXRecordResult localTXRecordResult;
          if (f.a(f.this) != null)
          {
            localTXRecordResult = new TXRecordCommon.TXRecordResult();
            if (paramAnonymousInt != 0) {
              break label95;
            }
          }
          label95:
          for (localTXRecordResult.retCode = 0;; localTXRecordResult.retCode = -1)
          {
            localTXRecordResult.descMsg = paramAnonymousString1;
            localTXRecordResult.videoPath = paramAnonymousString2;
            localTXRecordResult.coverPath = paramAnonymousString3;
            f.a(f.this).onRecordComplete(localTXRecordResult);
            f.b(f.this).a(null);
            f.b(f.this).a(null);
            AppMethodBeat.o(229436);
            return;
          }
        }
        
        public void a(long paramAnonymousLong)
        {
          AppMethodBeat.i(229440);
          if (f.a(f.this) != null) {
            f.a(f.this).onRecordProgress(paramAnonymousLong);
          }
          AppMethodBeat.o(229440);
        }
      });
    }
    if (this.D == null)
    {
      this.D = new com.tencent.liteav.renderer.h(Boolean.TRUE);
      this.D.b();
      this.D.b(this.A, this.B);
      this.D.a(this.A, this.B);
    }
    if (this.E == null)
    {
      this.E = new com.tencent.liteav.renderer.h(Boolean.FALSE);
      this.E.b();
      this.E.b(this.f.f(), this.f.g());
      this.E.a(this.f.f(), this.f.g());
      Matrix.setIdentityM(this.G, 0);
    }
    AppMethodBeat.o(229352);
  }
  
  private void k()
  {
    AppMethodBeat.i(229357);
    if (this.D != null)
    {
      this.D.c();
      this.D = null;
    }
    if (this.E != null)
    {
      this.E.c();
      this.E = null;
    }
    AppMethodBeat.o(229357);
  }
  
  private com.tencent.liteav.a.a.a l()
  {
    AppMethodBeat.i(229365);
    int i3 = 480;
    int i4 = 640;
    int i2 = i4;
    int i1 = i3;
    if (this.A > 0)
    {
      i2 = i4;
      i1 = i3;
      if (this.B > 0)
      {
        i1 = this.A;
        i2 = this.B;
      }
    }
    com.tencent.liteav.a.a.a locala = new com.tencent.liteav.a.a.a();
    locala.a = i1;
    locala.b = i2;
    locala.c = 20;
    double d = i1 * i1;
    locala.d = ((int)(Math.sqrt(i2 * i2 + d * 1.0D) * 1.2D));
    locala.h = this.q;
    locala.i = this.r;
    locala.j = this.s;
    locala.f = com.tencent.liteav.a.a.a(this.b, ".mp4");
    locala.g = com.tencent.liteav.a.a.a(this.b, ".jpg");
    locala.e = this.f.b();
    TXCLog.d("TXCLivePlayer", "record config: ".concat(String.valueOf(locala)));
    AppMethodBeat.o(229365);
    return locala;
  }
  
  private void m()
  {
    AppMethodBeat.i(229376);
    if (this.e != null)
    {
      this.e.stop();
      this.e.setVideoRender(null);
      this.e.setDecListener(null);
      this.e.setNotifyListener(null);
      this.e = null;
    }
    AppMethodBeat.o(229376);
  }
  
  private void n()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(229379);
    boolean bool1;
    if (this.I == 5)
    {
      bool1 = true;
      TXCAudioEngine.getInstance();
      TXCAudioEngine.enableAudioVolumeEvaluation(true, 300);
      a(this.M);
      if (this.I != 5) {
        break label186;
      }
      localTXCAudioEngine = TXCAudioEngine.getInstance();
      str = this.N;
      if (this.a.g) {
        break label181;
      }
    }
    for (;;)
    {
      localTXCAudioEngine.setRemoteAudioCacheParams(str, bool2, (int)(com.tencent.liteav.basic.b.a.b * 1000.0F), (int)(com.tencent.liteav.basic.b.a.b * 1000.0F), (int)(com.tencent.liteav.basic.b.a.c * 1000.0F));
      TXCAudioEngine.getInstance().muteRemoteAudio(this.N, this.j);
      TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.N, this.k);
      TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.N, this.l);
      TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.N, this);
      x();
      TXCAudioEngine.getInstance().startRemoteAudio(this.N, bool1);
      AppMethodBeat.o(229379);
      return;
      bool1 = false;
      break;
      label181:
      bool2 = false;
    }
    label186:
    TXCAudioEngine localTXCAudioEngine = TXCAudioEngine.getInstance();
    String str = this.N;
    if (!this.a.g) {}
    for (bool2 = bool3;; bool2 = false)
    {
      localTXCAudioEngine.setRemoteAudioCacheParams(str, bool2, (int)(this.a.a * 1000.0F), (int)(this.a.c * 1000.0F), (int)(this.a.b * 1000.0F));
      break;
    }
  }
  
  private void o()
  {
    AppMethodBeat.i(229385);
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(this.N, null);
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, null);
    TXCAudioEngine.getInstance().stopRemoteAudio(this.N);
    TXCAudioEngine.getInstance().UnInitAudioDevice();
    AppMethodBeat.o(229385);
  }
  
  private void p()
  {
    AppMethodBeat.i(229397);
    if (this.g != null)
    {
      c("stop network. network instance:" + this.g.hashCode());
      this.g.setListener(null);
      this.g.setNotifyListener(null);
      this.g.stop();
      this.g = null;
    }
    AppMethodBeat.o(229397);
  }
  
  private void q()
  {
    boolean bool = true;
    AppMethodBeat.i(229399);
    this.z = new e(this.b);
    this.z.a(this.H);
    e locale;
    if ((this.H.contains("live.p2p.com")) && (this.H.contains("127.0.0.1")))
    {
      this.z.b(true);
      this.C = 1;
      locale = this.z;
      if (this.I != 5) {
        break label146;
      }
    }
    for (;;)
    {
      locale.a(bool);
      this.z.d(this.N);
      this.z.e(this.g.getRTMPProxyUserId());
      this.z.a();
      AppMethodBeat.o(229399);
      return;
      this.z.b(false);
      this.C = 0;
      break;
      label146:
      bool = false;
    }
  }
  
  private void r()
  {
    AppMethodBeat.i(229406);
    if (this.z != null)
    {
      this.z.c();
      this.z = null;
    }
    AppMethodBeat.o(229406);
  }
  
  private void s()
  {
    AppMethodBeat.i(229415);
    this.O = false;
    x();
    AppMethodBeat.o(229415);
  }
  
  private void t()
  {
    AppMethodBeat.i(229419);
    if (this.P > 0L)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("EVT_PLAY_PROGRESS", (int)(this.P / 1000L));
      localBundle.putInt("EVT_PLAY_PROGRESS_MS", (int)this.P);
      onNotifyEvent(2005, localBundle);
    }
    if ((this.h != null) && (this.O)) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229421);
          if (f.c(f.this)) {
            f.d(f.this);
          }
          AppMethodBeat.o(229421);
        }
      }, 1000L);
    }
    AppMethodBeat.o(229419);
  }
  
  private void u()
  {
    AppMethodBeat.i(229425);
    if (this.h != null) {
      this.h.postDelayed(this.R, 2000L);
    }
    AppMethodBeat.o(229425);
  }
  
  private void v()
  {
    AppMethodBeat.i(229430);
    if (this.h != null) {
      this.h.removeCallbacks(this.R);
    }
    AppMethodBeat.o(229430);
  }
  
  private void w()
  {
    AppMethodBeat.i(229433);
    ArrayList localArrayList = new ArrayList();
    if (this.N != null) {
      localArrayList.add(this.N);
    }
    a.a("18446744073709551615", localArrayList);
    AppMethodBeat.o(229433);
  }
  
  private void x()
  {
    AppMethodBeat.i(229443);
    if ((this.t) || (this.M != null) || (this.O)) {
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, this);
    }
    if ((!this.t) && (this.M == null) && (!this.O)) {
      TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(this.N, null);
    }
    AppMethodBeat.o(229443);
  }
  
  public int a(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(229590);
    paramArrayOfFloat = this.x;
    if ((this.t) && (paramArrayOfFloat != null) && (this.D != null))
    {
      int i1 = this.D.d(paramInt);
      paramArrayOfFloat.a(i1, TXCTimeUtil.getTimeTick());
      this.f.a(i1, this.A, this.B, false, 0);
    }
    if (this.t) {
      j();
    }
    for (;;)
    {
      AppMethodBeat.o(229590);
      return paramInt;
      k();
    }
  }
  
  public int a(String paramString)
  {
    AppMethodBeat.i(229522);
    int i1 = a(paramString, null);
    AppMethodBeat.o(229522);
    return i1;
  }
  
  public int a(String paramString, int paramInt)
  {
    AppMethodBeat.i(229504);
    paramInt = a(paramString, paramInt, null);
    AppMethodBeat.o(229504);
    return paramInt;
  }
  
  public int a(String paramString, int paramInt, com.tencent.liteav.network.e parame)
  {
    AppMethodBeat.i(229514);
    if (c())
    {
      e("play: ignore start play when is playing");
      AppMethodBeat.o(229514);
      return -2;
    }
    if ((this.a != null) && (this.a.c > this.a.b))
    {
      d("play: can not start play while invalid cache config [minAutoAdjustCacheTime(" + this.a.c + ") > maxAutoAdjustCacheTime(" + this.a.b + ")]!!!!!!");
      AppMethodBeat.o(229514);
      return -1;
    }
    if ((this.a.a > this.a.b) || (this.a.a < this.a.c))
    {
      e("play: invalid cacheTime " + this.a.a + ", need between minAutoAdjustCacheTime " + this.a.c + " and maxAutoAdjustCacheTime " + this.a.b + " , fix to maxAutoAdjustCacheTime");
      this.a.a = this.a.b;
    }
    c("[FirstFramePath] TXCLivePlayer: start play. instance: " + hashCode());
    this.H = paramString;
    this.I = paramInt;
    b(paramString);
    this.o = true;
    this.w = 0;
    this.u = true;
    g(paramInt);
    n();
    paramInt = b(paramString, paramInt, parame);
    if (paramInt != 0)
    {
      this.o = false;
      p();
      m();
      o();
      if (this.i != null) {
        this.i.setVisibility(8);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(229514);
      return paramInt;
      a(this.p);
      q();
      u();
      if ((this.J == com.tencent.liteav.basic.b.b.c) && (this.i == null) && (this.f != null)) {
        this.f.c(this.K);
      }
      try
      {
        if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
          TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bF);
        }
      }
      catch (Exception paramString) {}
    }
  }
  
  public int a(String paramString, com.tencent.liteav.network.e parame)
  {
    AppMethodBeat.i(229523);
    if ((c()) && (this.g != null))
    {
      int i1;
      if (this.I == 5)
      {
        i1 = 1;
        if (i1 == 0) {
          break label149;
        }
        this.g.setRetryTimes(5);
        this.g.setRetryInterval(1);
      }
      for (;;)
      {
        boolean bool = this.g.switchStream(paramString, parame);
        long l1 = 0L;
        long l2 = TXCStatus.c(this.N, 2007);
        if (this.e != null) {
          l1 = this.e.getVideoCacheDuration();
        }
        c("[SwitchStream] current jitter size when start switch stream. video:" + l1 + " audio:" + l2);
        if (!bool) {
          break label180;
        }
        this.H = paramString;
        AppMethodBeat.o(229523);
        return 0;
        i1 = 0;
        break;
        label149:
        this.g.setRetryTimes(this.a.e);
        this.g.setRetryInterval(this.a.f);
      }
      label180:
      AppMethodBeat.o(229523);
      return -2;
    }
    AppMethodBeat.o(229523);
    return -1;
  }
  
  public int a(boolean paramBoolean)
  {
    AppMethodBeat.i(229519);
    if (!c())
    {
      e("play: ignore stop play when not started");
      AppMethodBeat.o(229519);
      return -2;
    }
    TXCLog.i("TXCLivePlayer", "play: stop");
    this.o = false;
    p();
    m();
    if ((this.i != null) && (paramBoolean)) {
      this.i.setVisibility(8);
    }
    if (this.f != null) {
      this.f.a(null);
    }
    if ((this.i == null) && (this.f != null)) {
      this.f.d();
    }
    o();
    r();
    v();
    s();
    AppMethodBeat.o(229519);
    return 0;
  }
  
  public void a()
  {
    AppMethodBeat.i(229524);
    a(false);
    AppMethodBeat.o(229524);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(229533);
    this.n = paramInt;
    if (this.e != null) {
      this.e.setRenderMode(paramInt);
    }
    AppMethodBeat.o(229533);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229497);
    if (this.f != null) {
      this.f.d(paramInt1, paramInt2);
    }
    AppMethodBeat.o(229497);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(229598);
    k();
    d();
    AppMethodBeat.o(229598);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(229495);
    this.p = paramSurface;
    if (this.f != null) {
      this.f.a(paramSurface);
    }
    AppMethodBeat.o(229495);
  }
  
  public void a(p paramp)
  {
    AppMethodBeat.i(229558);
    if (this.f != null) {
      this.f.a(paramp);
    }
    AppMethodBeat.o(229558);
  }
  
  public void a(h paramh)
  {
    AppMethodBeat.i(229501);
    super.a(paramh);
    if (this.e != null) {
      this.e.setConfig(paramh);
    }
    AppMethodBeat.o(229501);
  }
  
  public void a(o paramo, com.tencent.liteav.basic.b.b paramb, Object paramObject)
  {
    AppMethodBeat.i(229555);
    this.J = paramb;
    this.K = paramObject;
    if ((c()) && (this.J == com.tencent.liteav.basic.b.b.c) && (this.i == null) && (paramo != null) && (this.f != null)) {
      this.f.c(this.K);
    }
    if (this.e != null)
    {
      this.e.setVideoFrameListener(paramo, paramb);
      AppMethodBeat.o(229555);
      return;
    }
    e("setVideoFrameListener->enter with renderAndDec is empty");
    AppMethodBeat.o(229555);
  }
  
  public void a(TXLivePlayer.ITXAudioRawDataListener paramITXAudioRawDataListener)
  {
    AppMethodBeat.i(229549);
    this.M = paramITXAudioRawDataListener;
    x();
    AppMethodBeat.o(229549);
  }
  
  public void a(TXCloudVideoView paramTXCloudVideoView)
  {
    AppMethodBeat.i(229490);
    if ((this.c != null) && (this.c != paramTXCloudVideoView))
    {
      TextureView localTextureView = this.c.getVideoView();
      if (localTextureView != null) {
        this.c.removeView(localTextureView);
      }
    }
    super.a(paramTXCloudVideoView);
    if (this.c != null)
    {
      this.i = this.c.getVideoView();
      if (this.i == null) {
        this.i = new TextureView(this.c.getContext());
      }
      this.c.addVideoView(this.i);
    }
    if (this.f != null) {
      this.f.a(this.i);
    }
    AppMethodBeat.o(229490);
  }
  
  public void a(TXRecordCommon.ITXVideoRecordListener paramITXVideoRecordListener)
  {
    this.y = paramITXVideoRecordListener;
  }
  
  public void b()
  {
    AppMethodBeat.i(229528);
    a(this.H, this.I);
    AppMethodBeat.o(229528);
  }
  
  public void b(int paramInt)
  {
    AppMethodBeat.i(229537);
    this.m = paramInt;
    if (this.e != null) {
      this.e.setRenderRotation(paramInt);
    }
    AppMethodBeat.o(229537);
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(229539);
    this.j = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudio(this.N, this.j);
    AppMethodBeat.o(229539);
  }
  
  public void c(int paramInt)
  {
    AppMethodBeat.i(229545);
    this.l = paramInt;
    TXCAudioEngine.getInstance().setRemotePlayoutVolume(this.N, this.l);
    AppMethodBeat.o(229545);
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(229541);
    this.k = paramBoolean;
    TXCAudioEngine.getInstance().muteRemoteAudioInSpeaker(this.N, paramBoolean);
    AppMethodBeat.o(229541);
  }
  
  public boolean c()
  {
    return this.o;
  }
  
  public int d()
  {
    AppMethodBeat.i(229552);
    if (!this.t)
    {
      e("stopRecord: no recording task exist");
      AppMethodBeat.o(229552);
      return -1;
    }
    this.t = false;
    x();
    if (this.x != null)
    {
      this.x.a();
      this.x = null;
    }
    AppMethodBeat.o(229552);
    return 0;
  }
  
  public int d(int paramInt)
  {
    AppMethodBeat.i(229547);
    if (this.t)
    {
      d("startRecord: there is existing uncompleted record task");
      AppMethodBeat.o(229547);
      return -1;
    }
    this.t = true;
    this.f.a(this);
    this.f.a(this);
    x();
    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.aw);
    AppMethodBeat.o(229547);
    return 0;
  }
  
  public void e(int paramInt)
  {
    AppMethodBeat.i(229564);
    TXCStatus.a(this.N, 6015, Integer.valueOf(paramInt));
    AppMethodBeat.o(229564);
  }
  
  public boolean e()
  {
    return true;
  }
  
  public void f()
  {
    AppMethodBeat.i(229561);
    this.Q = 0L;
    if (this.O)
    {
      AppMethodBeat.o(229561);
      return;
    }
    this.O = true;
    x();
    if (this.h != null) {
      this.h.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229427);
          if (f.c(f.this)) {
            f.d(f.this);
          }
          AppMethodBeat.o(229427);
        }
      }, 1000L);
    }
    AppMethodBeat.o(229561);
  }
  
  public void g()
  {
    AppMethodBeat.i(229573);
    w();
    Object localObject = com.tencent.liteav.basic.util.h.a();
    int i1 = localObject[0] / 10;
    int i2 = localObject[1] / 10;
    localObject = i1 + "/" + i2 + "%";
    int i3 = TXCStatus.c(this.N, 7102);
    int i4 = TXCStatus.c(this.N, 7101);
    String str = TXCStatus.b(this.N, 7110);
    i2 = (int)TXCStatus.d(this.N, 6002);
    Bundle localBundle = new Bundle();
    if (this.f != null)
    {
      localBundle.putInt("VIDEO_WIDTH", this.f.h());
      localBundle.putInt("VIDEO_HEIGHT", this.f.i());
    }
    if (this.e != null)
    {
      localBundle.putInt("VIDEO_CACHE", (int)this.e.getVideoCacheDuration());
      localBundle.putInt("V_SUM_CACHE_SIZE", (int)this.e.getVideoCacheFrameCount());
      localBundle.putInt("V_DEC_CACHE_SIZE", this.e.getVideoDecCacheFrameCount());
      localBundle.putInt("AV_PLAY_INTERVAL", (int)this.e.getAVPlayInterval());
      localBundle.putInt("AV_RECV_INTERVAL", (int)this.e.getAVNetRecvInterval());
      if (i2 != 0) {
        break label632;
      }
    }
    label614:
    label632:
    for (i1 = 15;; i1 = i2)
    {
      localBundle.putInt("VIDEO_GOP", (int)(TXCStatus.c(this.N, 7120) * 10 / i1 / 10.0F + 0.5D));
      i1 = TXCAudioEngine.getInstance().getPlayAECType();
      int i5 = TXCStatus.c(this.N, 2019);
      int i6 = TXCStatus.c(this.N, 2020);
      int i7 = TXCAudioEngine.getInstance().getPlaySampleRate();
      int i8 = TXCAudioEngine.getInstance().getPlayChannels();
      localBundle.putString("AUDIO_PLAY_INFO", i1 + " | " + i5 + "," + i6 + " | " + i7 + "," + i8);
      localBundle.putInt("AUDIO_CACHE", TXCStatus.c(this.N, 2007));
      localBundle.putInt("NET_JITTER", TXCStatus.c(this.N, 2018));
      localBundle.putFloat("AUDIO_CACHE_THRESHOLD", TXCStatus.c(this.N, 2021) / 1000.0F);
      localBundle.putInt("NET_SPEED", i4 + i3);
      localBundle.putInt("VIDEO_FPS", i2);
      localBundle.putInt("VIDEO_BITRATE", i4);
      localBundle.putInt("AUDIO_BITRATE", i3);
      localBundle.putCharSequence("SERVER_IP", str);
      localBundle.putCharSequence("CPU_USAGE", (CharSequence)localObject);
      localBundle.putInt("IS_P2P", this.C);
      this.w += 1;
      if (this.w == 5)
      {
        if (!this.v) {
          break label614;
        }
        TXCStatus.a(this.N, 6013, Long.valueOf(0L));
      }
      for (;;)
      {
        com.tencent.liteav.basic.util.h.a(this.d, 15001, localBundle);
        if (this.e != null) {
          this.e.updateLoadInfo();
        }
        if (this.z != null) {
          this.z.f();
        }
        AppMethodBeat.o(229573);
        return;
        TXCStatus.a(this.N, 6013, Long.valueOf(1L));
      }
    }
  }
  
  public int h()
  {
    AppMethodBeat.i(229609);
    int i1 = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(this.N);
    AppMethodBeat.o(229609);
    return i1;
  }
  
  public void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(229606);
    onNotifyEvent(paramInt, null);
    AppMethodBeat.o(229606);
  }
  
  public void onAudioPlayPcmData(String paramString, byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229602);
    this.r = paramInt1;
    this.q = paramInt2;
    long l1 = paramLong;
    if (this.x != null)
    {
      l1 = paramLong;
      if (paramLong <= 0L) {
        l1 = TXCTimeUtil.getTimeTick();
      }
      this.x.a(paramArrayOfByte, l1);
    }
    if ((this.Q <= 0L) && (this.M != null)) {
      this.M.onAudioInfoChanged(paramInt1, paramInt2, 16);
    }
    if (this.M != null) {
      this.M.onPcmDataAvailable(paramArrayOfByte, l1);
    }
    if (this.Q <= 0L)
    {
      this.Q = l1;
      AppMethodBeat.o(229602);
      return;
    }
    this.P = (l1 - this.Q);
    AppMethodBeat.o(229602);
  }
  
  public void onNotifyEvent(final int paramInt, final Bundle paramBundle)
  {
    AppMethodBeat.i(229586);
    if ((2003 == paramInt) && (!this.v)) {
      this.v = true;
    }
    if ((2003 == paramInt) || (2026 == paramInt))
    {
      if (this.u)
      {
        a(2004, "Video play started");
        this.u = false;
      }
      if (2026 == paramInt)
      {
        a(2026, "Audio play started");
        TXCStatus.a(this.N, 2033, Long.valueOf(TXCTimeUtil.getTimeTick()));
        AppMethodBeat.o(229586);
        return;
      }
    }
    if (2025 == paramInt)
    {
      a(2004, "Video play started");
      AppMethodBeat.o(229586);
      return;
    }
    if ((2023 == paramInt) || (2024 == paramInt))
    {
      a(2007, "Video play loading");
      AppMethodBeat.o(229586);
      return;
    }
    if (this.h != null) {
      this.h.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229417);
          com.tencent.liteav.basic.util.h.a(f.this.d, paramInt, paramBundle);
          if ((paramInt == 2103) && (f.f(f.this) != null)) {
            f.f(f.this).restartDecoder();
          }
          AppMethodBeat.o(229417);
        }
      });
    }
    AppMethodBeat.o(229586);
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama) {}
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(229580);
    if (!this.o)
    {
      AppMethodBeat.o(229580);
      return;
    }
    try
    {
      if (this.e != null) {
        this.e.decVideo(paramTXSNALPacket);
      }
      AppMethodBeat.o(229580);
      return;
    }
    catch (Exception paramTXSNALPacket)
    {
      d("decode video failed." + paramTXSNALPacket.getMessage());
      AppMethodBeat.o(229580);
    }
  }
  
  public void onRequestKeyFrame(String paramString, int paramInt)
  {
    AppMethodBeat.i(229612);
    if ((this.o) && (this.g != null)) {
      this.g.requestKeyFrame(this.H);
    }
    AppMethodBeat.o(229612);
  }
  
  public void onTextureProcess(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(229595);
    com.tencent.liteav.a.a locala = this.x;
    if ((this.t) && (locala != null) && (this.E != null))
    {
      this.E.a(this.F);
      locala.a(this.E.d(paramInt1), TXCTimeUtil.getTimeTick());
      this.E.a(this.G);
      this.E.c(paramInt1);
    }
    if (this.t)
    {
      j();
      AppMethodBeat.o(229595);
      return;
    }
    k();
    AppMethodBeat.o(229595);
  }
  
  static class a
    implements Runnable
  {
    private WeakReference<f> a;
    
    a(f paramf)
    {
      AppMethodBeat.i(229326);
      this.a = new WeakReference(paramf);
      AppMethodBeat.o(229326);
    }
    
    public void run()
    {
      AppMethodBeat.i(229330);
      f localf = (f)this.a.get();
      if (localf == null)
      {
        AppMethodBeat.o(229330);
        return;
      }
      localf.g();
      f.e(localf);
      AppMethodBeat.o(229330);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.f
 * JD-Core Version:    0.7.0.1
 */