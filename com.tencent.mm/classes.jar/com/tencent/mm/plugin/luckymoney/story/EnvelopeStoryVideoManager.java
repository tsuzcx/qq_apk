package com.tencent.mm.plugin.luckymoney.story;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a;
import com.tencent.mm.g.d;
import com.tencent.mm.g.g.a;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.f;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeStoryVideoManager
  implements p
{
  private static Set<String> Kyf;
  private int EuH;
  Map<Integer, c> Kye;
  private boolean hqz;
  private boolean lAj;
  private com.tencent.mm.compatible.util.b peV;
  MMActivity wrG;
  
  static
  {
    AppMethodBeat.i(163670);
    Kyf = new HashSet();
    AppMethodBeat.o(163670);
  }
  
  public EnvelopeStoryVideoManager()
  {
    AppMethodBeat.i(163655);
    this.EuH = -1;
    this.lAj = false;
    this.peV = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.hqz = false;
    this.Kye = new HashMap();
    AppMethodBeat.o(163655);
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(284024);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    final c localc = (c)this.Kye.get(Integer.valueOf(paramInt3));
    if ((localc == null) || (localc.Kyw == null))
    {
      localc = new c();
      localc.Kyw = new EnvelopeStoryVideoView(paramContext);
      localc.Kyw.setContentDescription(paramContext.getString(a.i.lucky_money_detail_envelope_video_desc_accessibility_text1));
      localc.url = paramString;
      localc.sessionId = UUID.randomUUID().toString();
      localc.yBc = paramImageView;
      localc.Kyz = paramProgressBar;
      localc.Kyq = paramBoolean1;
      localc.isPreview = paramBoolean2;
      localc.Kyx = ((ViewGroup)paramFrameLayout.findViewById(a.f.lukcy_money_detail_story_item_video_control_layout));
      localc.sHp = ((ImageView)paramFrameLayout.findViewById(a.f.lukcy_money_detail_story_item_video_play_iv));
      localc.sHF = ((ImageView)paramFrameLayout.findViewById(a.f.lucky_money_detail_story_mute_iv));
      localc.Kyy = ((ViewGroup)paramFrameLayout.findViewById(a.f.lucky_money_detail_story_item_retry_layout));
      localc.bCB = paramFrameLayout;
      localc.Kyw.setIsShowBasicControls(false);
      localc.Kyw.KyC = new EnvelopeStoryVideoView.a()
      {
        public final void a(EnvelopeStoryVideoView paramAnonymousEnvelopeStoryVideoView)
        {
          AppMethodBeat.i(182457);
          int i = localc.Kyv.addAndGet(1);
          localc.vYw = paramAnonymousEnvelopeStoryVideoView.getVideoDurationSec();
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", new Object[] { localc.sessionId, Integer.valueOf(i) });
          AppMethodBeat.o(182457);
        }
      };
      localc.Kyw.setIMMVideoViewCallback(new i.b()
      {
        public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(182459);
          Log.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousString3 });
          com.tencent.mm.plugin.report.service.h.OAn.b(19228, new Object[] { localc.url, Integer.valueOf(localc.Kyw.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(localc.Kys), Integer.valueOf(localc.Kyw.getRealPlayDurationSec()), Integer.valueOf(localc.HFl), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(182459);
        }
        
        public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void el(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182460);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.vYw = localc.Kyw.getVideoDurationSec();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182458);
              if (EnvelopeStoryVideoManager.6.this.Kyh.Kyz != null) {
                EnvelopeStoryVideoManager.6.this.Kyh.Kyz.setVisibility(8);
              }
              View localView = EnvelopeStoryVideoManager.6.this.Kyh.Kyw.findViewById(a.f.video_root);
              if (localView != null)
              {
                localView = (View)localView.getParent();
                localView.setFocusable(false);
                ((View)localView.getParent()).setFocusable(false);
              }
              if (EnvelopeStoryVideoManager.6.this.Kyh.Kyw.getParent() != null) {
                ((ViewGroup)EnvelopeStoryVideoManager.6.this.Kyh.Kyw.getParent()).bringToFront();
              }
              if (!EnvelopeStoryVideoManager.6.this.Kyh.isPreview) {
                EnvelopeStoryVideoManager.6.this.Kyh.sHF.setVisibility(0);
              }
              AppMethodBeat.o(182458);
            }
          }, 10L);
          AppMethodBeat.o(182460);
        }
        
        public final void em(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182461);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182461);
        }
        
        public final void en(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182462);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182462);
        }
        
        public final void eo(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182463);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182463);
        }
        
        public final void ep(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182464);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.Kyr = ((int)SystemClock.elapsedRealtime() / 1000);
          if (localc.Kyz != null)
          {
            localc.Kyz.bringToFront();
            localc.Kyz.setVisibility(0);
          }
          AppMethodBeat.o(182464);
        }
        
        public final void eq(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182465);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (localc.Kyr > 0)
          {
            paramAnonymousString1 = localc;
            paramAnonymousString1.HFl = ((int)(paramAnonymousString1.HFl + (SystemClock.elapsedRealtime() / 1000L - localc.Kyr)));
            localc.Kyr = 0;
          }
          if (localc.Kyz != null) {
            localc.Kyz.setVisibility(8);
          }
          AppMethodBeat.o(182465);
        }
        
        public final void gE(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(284017);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(284017);
        }
        
        public final void onSeekComplete(ITPPlayer paramAnonymousITPPlayer) {}
      });
      localc.sHp.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284009);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
          if ((localc.Kyw != null) && (localc.Kyw.isPlaying()))
          {
            AppMethodBeat.o(284009);
            return;
          }
          localc.sHp.setVisibility(4);
          EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
          AppMethodBeat.o(284009);
        }
      });
      localc.Kyx.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
      {
        public final void dr(View paramAnonymousView)
        {
          AppMethodBeat.i(284008);
          if ((EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this) != -1) && (localc.Kyw != null)) {
            EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, localc);
          }
          AppMethodBeat.o(284008);
        }
      });
      paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramContext.gravity = 17;
      paramFrameLayout.addView(localc.Kyw, 0, paramContext);
      localc.Kyx.setLayoutParams(paramContext);
      this.Kye.put(Integer.valueOf(paramInt3), localc);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174345);
          EnvelopeStoryVideoManager.e(localc);
          AppMethodBeat.o(174345);
        }
      });
      localc.Kyw.setSessionId(localc.sessionId);
      localc.Kyw.setIOnlineVideoProxy(new b(localc));
      localc.Kyw.setLocalPreDownloadVideo(localc.Kyq);
      localc.Kyw.b(false, localc.url, 0);
      localc.oYq = localc.Kyw.getMediaId();
      b(localc);
      a(localc);
      c(localc);
      AppMethodBeat.o(284024);
      return;
    }
    localc.isPreview = paramBoolean2;
    b(localc);
    a(localc);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174346);
        if ((localc.cJs) && (localc.Kyw.aFF()))
        {
          localc.Kyw.onUIResume();
          localc.Kyt = localc.Kyw.getCurrPosSec();
          localc.Kyu = 0L;
        }
        for (;;)
        {
          localc.Kyv.set(1);
          AppMethodBeat.o(174346);
          return;
          if (localc.Kyw.isPlaying())
          {
            Log.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
            localc.Kyw.stop();
            localc.Kyw.start();
            localc.Kyt = 0L;
            localc.Kyu = 0L;
          }
        }
      }
    }, 200L);
    AppMethodBeat.o(284024);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(174361);
    boolean bool = paramc.Kyw.KyA;
    if (bool) {
      paramc.sHF.setImageResource(a.h.lucky_money_mute_icon);
    }
    for (;;)
    {
      paramc.bCB.setTag(a.f.video_mute_state_key, Boolean.valueOf(bool));
      AppMethodBeat.o(174361);
      return;
      paramc.sHF.setImageResource(a.h.lucky_money_unmute_icon);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, g.a parama, h.a parama1)
  {
    AppMethodBeat.i(174367);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    int i;
    if (paramBoolean)
    {
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXr, 1) == 0) {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "can not preload video");
      }
      for (i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(174367);
        return;
      }
    }
    long l = SystemClock.elapsedRealtime();
    com.tencent.mm.g.h localh = new com.tencent.mm.g.h();
    localh.taskName = "task_EnvelopeStoryVideoManager";
    localh.field_mediaId = paramString1;
    localh.field_fileId = paramString1;
    localh.url = paramString3;
    if (paramBoolean)
    {
      i = 2;
      localh.lxi = i;
      localh.field_preloadRatio = 20;
      localh.lxd = new EnvelopeStoryVideoManager.10(paramString3, l);
      if (parama == null) {
        break label275;
      }
    }
    label275:
    for (localh.lwL = parama;; localh.lwL = new EnvelopeStoryVideoManager.2(paramString2))
    {
      localh.lxc = 3;
      localh.field_fullpath = paramString2;
      localh.field_filemd5 = paramString4;
      localh.allow_mobile_net_download = true;
      localh.lxs = parama1;
      localh.field_fileType = a.MediaType_VIDEO;
      localh.field_requestVideoFormat = 1;
      localh.lxb = localh.lxi;
      if (!paramBoolean) {
        break label318;
      }
      if (!Kyf.contains(paramString1)) {
        break label291;
      }
      Log.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", new Object[] { paramString1 });
      AppMethodBeat.o(174367);
      return;
      i = 1;
      break;
    }
    label291:
    Kyf.add(paramString1);
    com.tencent.mm.modelcdntran.k.bHW().b(localh, -1);
    AppMethodBeat.o(174367);
    return;
    label318:
    if (Kyf.contains(paramString1))
    {
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
      com.tencent.mm.modelcdntran.k.bHW().Nz(paramString1);
    }
    v.bOi().e(localh);
    AppMethodBeat.o(174367);
  }
  
  public static MultiProcessMMKV aBP()
  {
    AppMethodBeat.i(369813);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(fXX());
    AppMethodBeat.o(369813);
    return localMultiProcessMMKV;
  }
  
  public static String aKF(String paramString)
  {
    AppMethodBeat.i(163663);
    paramString = "MMVideo_" + paramString.hashCode();
    AppMethodBeat.o(163663);
    return paramString;
  }
  
  public static String aKG(String paramString)
  {
    AppMethodBeat.i(163664);
    paramString = EnvelopeStoryVideoView.ROOT_PATH + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(163664);
    return paramString;
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(284029);
    if (paramc.isPreview)
    {
      paramc.sHF.setVisibility(4);
      paramc.Kyw.setMute(true);
      AppMethodBeat.o(284029);
      return;
    }
    paramc.sHF.setVisibility(0);
    paramc.Kyw.setMute(this.lAj);
    AppMethodBeat.o(284029);
  }
  
  private void c(c paramc)
  {
    AppMethodBeat.i(174362);
    if ((!paramc.Kyq) && (d(paramc))) {
      paramc.Kyw.setLocal(true);
    }
    paramc.yBc.bringToFront();
    if (paramc.Kyp > 0)
    {
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", new Object[] { Integer.valueOf(paramc.Kyp) });
      paramc.Kyw.b(paramc.Kyp, true);
      paramc.Kyt = paramc.Kyp;
    }
    for (paramc.Kyu = 0L;; paramc.Kyu = 0L)
    {
      paramc.Kyv.set(1);
      if (!this.hqz)
      {
        this.peV.requestFocus();
        this.hqz = true;
      }
      paramc.cJs = true;
      b.KyJ += 1;
      b.KyI.add(paramc.url);
      AppMethodBeat.o(174362);
      return;
      paramc.Kyw.start();
      paramc.Kyt = 0L;
    }
  }
  
  public static boolean ci(int paramInt, String paramString)
  {
    AppMethodBeat.i(284042);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yXn, true);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource switch] canGetLuckyMoneyEnvelopeLocalVideoRes ：%s", new Object[] { Boolean.valueOf(bool) });
    if ((paramInt > 0) && (!Util.isNullOrNil(paramString)) && (y.ZC(paramString)) && (bool))
    {
      bool = true;
      if (!bool) {
        break label104;
      }
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalVideoRes：%s", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(284042);
      return bool;
      bool = false;
      break;
      label104:
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource] use net: LuckyMoneyEnvelopeLocalVideoRes:%s", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private static boolean d(c paramc)
  {
    AppMethodBeat.i(174363);
    boolean bool2 = y.ZC(aKG(paramc.url));
    if (MultiProcessMMKV.getMMKV(fXX()).getInt(paramc.oYq, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramc.Kys = 1;
      AppMethodBeat.o(174363);
      return true;
    }
    if (bool2) {}
    for (paramc.Kys = 3;; paramc.Kys = 2)
    {
      MultiProcessMMKV.getMMKV(fXX()).putInt(paramc.oYq, 0);
      AppMethodBeat.o(174363);
      return false;
    }
  }
  
  private c fXW()
  {
    AppMethodBeat.i(174366);
    c localc = (c)this.Kye.get(Integer.valueOf(this.EuH));
    AppMethodBeat.o(174366);
    return localc;
  }
  
  private static String fXX()
  {
    AppMethodBeat.i(163666);
    String str = MMApplicationContext.getPackageName() + "_luckymoney_story_video";
    AppMethodBeat.o(163666);
    return str;
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(284050);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.EuH), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean3), paramString });
    c localc = (c)this.Kye.get(Integer.valueOf(paramInt3));
    if (localc != null)
    {
      localc.isPreview = paramBoolean3;
      b(localc);
      a(localc);
    }
    if (paramInt3 != this.EuH)
    {
      localc = (c)this.Kye.get(Integer.valueOf(this.EuH));
      if (localc != null)
      {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
        if (localc.cJs)
        {
          localc.Kyu = localc.Kyw.getCurrPosSec();
          localc.Kyw.onUIPause();
        }
      }
      this.EuH = paramInt3;
      if (paramBoolean1) {
        a(paramContext, paramFrameLayout, paramImageView, paramProgressBar, paramString, paramInt1, paramInt2, paramInt3, paramBoolean2, paramBoolean3);
      }
      AppMethodBeat.o(284050);
      return;
    }
    Log.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
    AppMethodBeat.o(284050);
  }
  
  public final void fXV()
  {
    AppMethodBeat.i(174365);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s, %s", new Object[] { Integer.valueOf(this.Kye.size()), Util.getStack() });
    if (this.hqz)
    {
      this.peV.aPS();
      this.hqz = false;
    }
    Iterator localIterator = this.Kye.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
      c localc = (c)localEntry.getValue();
      if (localc.Kyr > 0) {
        localc.HFl = ((int)(localc.HFl + (SystemClock.elapsedRealtime() / 1000L - localc.Kyr)));
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(19228, new Object[] { localc.url, Integer.valueOf(localc.Kyw.getVideoDurationSec()), Integer.valueOf(1), Integer.valueOf(localc.Kys), Integer.valueOf(localc.Kyw.getRealPlayDurationSec()), Integer.valueOf(localc.HFl), Integer.valueOf(0), Integer.valueOf(0) });
      if (((c)localEntry.getValue()).Kyw.getParent() != null)
      {
        ((ViewGroup)((c)localEntry.getValue()).Kyw.getParent()).removeView(((c)localEntry.getValue()).Kyw);
        localc.Kyw.stop();
      }
    }
    this.Kye.clear();
    this.EuH = -1;
    AppMethodBeat.o(174365);
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public void onUIDestroy()
  {
    AppMethodBeat.i(163661);
    AppMethodBeat.o(163661);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(163660);
    if (this.hqz)
    {
      this.peV.aPS();
      this.hqz = false;
    }
    c localc = fXW();
    if (localc != null) {
      localc.Kyw.onUIPause();
    }
    AppMethodBeat.o(163660);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(163659);
    c localc = fXW();
    if (localc != null)
    {
      localc.Kyw.onUIResume();
      if (localc.Kyw.isPlaying())
      {
        this.peV.requestFocus();
        this.hqz = true;
      }
    }
    AppMethodBeat.o(163659);
  }
  
  public final class a
    implements h.a
  {
    private WeakReference<EnvelopeStoryVideoManager.c> akix;
    
    public a(EnvelopeStoryVideoManager.c paramc)
    {
      AppMethodBeat.i(369811);
      this.akix = new WeakReference(paramc);
      AppMethodBeat.o(369811);
    }
    
    public final void a(String paramString, int paramInt, d paramd)
    {
      AppMethodBeat.i(163648);
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", new Object[] { paramString });
        EnvelopeStoryVideoManager.aBP().putInt(paramString, 1).commit();
      }
      paramd = (EnvelopeStoryVideoManager.c)this.akix.get();
      if (paramd == null)
      {
        AppMethodBeat.o(163648);
        return;
      }
      paramd.Kyw.bb(paramString, paramInt);
      AppMethodBeat.o(163648);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(284011);
      final EnvelopeStoryVideoManager.c localc = (EnvelopeStoryVideoManager.c)this.akix.get();
      if (localc == null)
      {
        AppMethodBeat.o(284011);
        return;
      }
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163644);
          localc.Kyw.jb(paramLong1);
          AppMethodBeat.o(163644);
        }
      });
      AppMethodBeat.o(284011);
    }
    
    public final void h(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163647);
      EnvelopeStoryVideoManager.c localc = (EnvelopeStoryVideoManager.c)this.akix.get();
      if (localc == null)
      {
        AppMethodBeat.o(163647);
        return;
      }
      localc.Kyw.h(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163647);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163646);
      EnvelopeStoryVideoManager.c localc = (EnvelopeStoryVideoManager.c)this.akix.get();
      if (localc == null)
      {
        AppMethodBeat.o(163646);
        return;
      }
      localc.Kyw.onDataAvailable(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163646);
    }
    
    public final void onM3U8Ready(String paramString1, String paramString2) {}
  }
  
  final class b
    implements f
  {
    private WeakReference<EnvelopeStoryVideoManager.c> akix;
    
    public b(EnvelopeStoryVideoManager.c paramc)
    {
      AppMethodBeat.i(369812);
      this.akix = new WeakReference(paramc);
      AppMethodBeat.o(369812);
    }
    
    public final void a(f.a parama) {}
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163654);
      boolean bool = v.bOi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163654);
      return bool;
    }
    
    public final void js(String paramString)
    {
      AppMethodBeat.i(163652);
      v.bOi().k(paramString, null);
      AppMethodBeat.o(163652);
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163653);
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "request video data: %s", new Object[] { paramString });
      v.bOi();
      j.v(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163653);
    }
    
    public final void w(String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(163651);
      EnvelopeStoryVideoManager.c localc = (EnvelopeStoryVideoManager.c)this.akix.get();
      if (localc == null)
      {
        AppMethodBeat.o(163651);
        return;
      }
      EnvelopeStoryVideoManager.a locala = new EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
      EnvelopeStoryVideoManager.a(paramString1, paramString2, paramString3, localc.md5, false, new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, final com.tencent.mm.g.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163650);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt != 0)
          {
            y.deleteFile(paramString2);
            paramAnonymousc = (EnvelopeStoryVideoManager.c)EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).get();
            if (paramAnonymousc == null)
            {
              AppMethodBeat.o(163650);
              return 0;
            }
            if (paramAnonymousc.oYq.equals(paramAnonymousString))
            {
              Log.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", new Object[] { paramString3 });
              paramAnonymousc.Kyy.setVisibility(0);
              paramAnonymousc.Kyy.setOnClickListener(new com.tencent.mm.wallet_core.ui.k()
              {
                public final void dr(View paramAnonymous2View)
                {
                  AppMethodBeat.i(284026);
                  Log.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                  paramAnonymousc.sessionId = UUID.randomUUID().toString();
                  paramAnonymousc.Kyw.setSessionId(paramAnonymousc.sessionId);
                  paramAnonymousc.Kyw.setLocal(false);
                  EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, paramAnonymousc);
                  AppMethodBeat.o(284026);
                }
              });
              com.tencent.mm.plugin.report.service.h.OAn.b(19228, new Object[] { paramAnonymousc.url, Integer.valueOf(paramAnonymousc.Kyw.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(paramAnonymousc.Kys), Integer.valueOf(paramAnonymousc.Kyw.getRealPlayDurationSec()), Integer.valueOf(paramAnonymousc.HFl), Integer.valueOf(0), Integer.valueOf(-9999) });
            }
          }
          AppMethodBeat.o(163650);
          return 0;
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      }, locala);
      AppMethodBeat.o(163651);
    }
  }
  
  public static final class c
  {
    int HFl;
    int Kyp;
    boolean Kyq;
    int Kyr;
    int Kys;
    long Kyt;
    long Kyu;
    AtomicInteger Kyv;
    EnvelopeStoryVideoView Kyw;
    ViewGroup Kyx;
    ViewGroup Kyy;
    ProgressBar Kyz;
    ViewGroup bCB;
    boolean cJs;
    boolean isPreview;
    String md5;
    String oYq;
    ImageView sHF;
    ImageView sHp;
    String sessionId;
    String url;
    long vYw;
    ImageView yBc;
    
    public c()
    {
      AppMethodBeat.i(182469);
      this.cJs = false;
      this.isPreview = false;
      this.Kyr = 0;
      this.HFl = 0;
      this.Kyv = new AtomicInteger(1);
      AppMethodBeat.o(182469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager
 * JD-Core Version:    0.7.0.1
 */