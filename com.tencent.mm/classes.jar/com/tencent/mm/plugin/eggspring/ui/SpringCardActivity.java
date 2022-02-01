package com.tencent.mm.plugin.eggspring.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.ao.e;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "appId", "", "blessingBtmImgReady", "", "blessingTopImgReady", "bottomBrandBgImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "bottomBrandClickableImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomBrandClickableTxt", "Landroid/widget/TextView;", "bottomBrandClickableTxtLayout", "Landroid/view/View;", "bottomBrandIntroTxt", "brandCardAcceptBtn", "Landroid/widget/Button;", "brandCardBlessingStyleBottomImg", "brandCardBlessingStyleImgMedia", "brandCardBlessingStyleLayout", "Landroid/view/ViewGroup;", "brandCardBlessingStyleVideoMedia", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "brandCardImgMedia", "brandCardLayout", "brandCardMainWording", "brandCardMediaLayout", "brandCardSubWording", "brandCardTitleLayout", "brandCardTitleLogo", "brandCardTitleName", "cardIsShowing", "count", "", "curPoi", "duration", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "fireWorksColor", "", "isVideo", "keyWord", "lastShowCardRunnable", "Ljava/lang/Runnable;", "loadingAnimTimerStartMS", "", "luckyBagLoadingImg", "rootLayout", "rptCount", "sum", "traceId", "uiHandler", "Landroid/os/Handler;", "videoMediaId", "addFireWorks", "", "parent", "offset", "adjustCloseBtnColor", "color", "againConfigView", "boundView", "changeCardStyle", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "dealWithMedia", "downLoadImg", "getCachePath", "getFireworksColor", "getLayoutId", "getRandomByRange", "low", "high", "getSavePath", "getTempPath", "imgExist", "initBar", "initConfigView", "initVideoView", "isVideoDataAvailable", "length", "onBlessingMediaReady", "type", "onC2CDownloadCompleted", "filekey", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataAvailable", "onDestroy", "onDownloadFinish", "isPlayNow", "onDownloadProgressChanged", "finished", "total", "tryshow", "onError", "sessionId", "errorMsg", "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMediaReady", "onMoovReady", "svrflag", "onPause", "onPrepared", "onProgress", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "playCardAnim", "requestBrandCardContent", "requestVideoData", "setIEngineCallback", "callback", "startHttpStream", "stop", "Companion", "plugin-eggspring_release"})
public final class SpringCardActivity
  extends MMActivity
  implements CdnLogic.DownloadCallback, f, h.a, com.tencent.mm.modelvideo.b, i.a, i.b
{
  public static final SpringCardActivity.a pzZ;
  private String appId;
  private Handler cAO;
  private int count;
  private int duration;
  private String iiW;
  private String jSR;
  private View pzA;
  private MMAnimateView pzB;
  private TextView pzC;
  private TextView pzD;
  private TextView pzE;
  private Button pzF;
  private ViewGroup pzG;
  private MMAnimateView pzH;
  private ViewGroup pzI;
  private MMAnimateView pzJ;
  private SpringEggVideoView pzK;
  private MMAnimateView pzL;
  private String pzM;
  private com.tencent.mm.modelvideo.b.a pzN;
  private long pzO;
  private com.tencent.mm.app.n pzP;
  private boolean pzQ;
  private boolean pzR;
  private final Runnable pzS;
  private int pzT;
  private int pzU;
  private int pzV;
  private boolean pzW;
  private boolean pzX;
  private final int[] pzY;
  private com.tencent.mm.plugin.eggspring.b.a pzn;
  private ViewGroup pzs;
  private MMAnimateView pzt;
  private View pzu;
  private TextView pzv;
  private WeImageView pzw;
  private TextView pzx;
  private MMAnimateView pzy;
  private ViewGroup pzz;
  
  static
  {
    AppMethodBeat.i(108208);
    pzZ = new SpringCardActivity.a((byte)0);
    AppMethodBeat.o(108208);
  }
  
  public SpringCardActivity()
  {
    AppMethodBeat.i(108207);
    this.pzS = ((Runnable)new e(this));
    this.duration = -1;
    this.count = -1;
    this.pzT = -1;
    this.pzU = -1;
    this.pzY = new int[] { 2131100372, 2131100373, 2131100374 };
    AppMethodBeat.o(108207);
  }
  
  private final void BK(int paramInt)
  {
    AppMethodBeat.i(162214);
    if (ao.abX(paramInt))
    {
      updateBackBtn(ao.k((Context)this, 2131690535, -1));
      AppMethodBeat.o(162214);
      return;
    }
    updateBackBtn(ao.k((Context)this, 2131690535, -16777216));
    AppMethodBeat.o(162214);
  }
  
  private final void BL(int paramInt)
  {
    AppMethodBeat.i(160274);
    if (paramInt == 0)
    {
      this.pzQ = true;
      if (!this.pzR) {}
    }
    for (;;)
    {
      cfH();
      do
      {
        do
        {
          AppMethodBeat.o(160274);
          return;
        } while (1 != paramInt);
        this.pzR = true;
        if (this.pzQ) {
          break;
        }
      } while (!this.pzW);
    }
  }
  
  private static String FA(String paramString)
  {
    AppMethodBeat.i(108186);
    paramString = PluginEggSpring.pyI + '/' + paramString.hashCode();
    AppMethodBeat.o(108186);
    return paramString;
  }
  
  private final void aaZ(String paramString)
  {
    AppMethodBeat.i(108185);
    Object localObject = EmojiDebugUI.ghC;
    if (EmojiDebugUI.aeq())
    {
      ad.d("MicroMsg.SpringCardActivity", "stop cdn!!!");
      AppMethodBeat.o(108185);
      return;
    }
    localObject = new CdnLogic.C2CDownloadRequest();
    ((CdnLogic.C2CDownloadRequest)localObject).fileKey = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).url = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).setSavePath(FA(paramString));
    CdnLogic.startHttpsDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.DownloadCallback)this);
    AppMethodBeat.o(108185);
  }
  
  private static String aba(String paramString)
  {
    AppMethodBeat.i(108187);
    paramString = PluginEggSpring.pyI + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(108187);
    return paramString;
  }
  
  private final void cfH()
  {
    AppMethodBeat.i(160275);
    Handler localHandler = this.cAO;
    if (localHandler == null) {
      p.bcb("uiHandler");
    }
    localHandler.removeCallbacks(this.pzS);
    if (this.pzX)
    {
      AppMethodBeat.o(160275);
      return;
    }
    long l = System.currentTimeMillis() - this.pzO;
    if (l > 1000L)
    {
      cfI();
      AppMethodBeat.o(160275);
      return;
    }
    localHandler = this.cAO;
    if (localHandler == null) {
      p.bcb("uiHandler");
    }
    localHandler.postDelayed((Runnable)new m(this), 1000L - l);
    AppMethodBeat.o(160275);
  }
  
  private final void cfI()
  {
    AppMethodBeat.i(160276);
    this.pzX = true;
    Object localObject1 = this.pzz;
    if (localObject1 == null) {
      p.bcb("brandCardLayout");
    }
    ((ViewGroup)localObject1).setVisibility(0);
    localObject1 = Keyframe.ofFloat(0.0F, 90.0F);
    Object localObject2 = Keyframe.ofFloat(1.0F, 0.0F);
    localObject1 = PropertyValuesHolder.ofKeyframe(View.ROTATION_X, new Keyframe[] { localObject1, localObject2 });
    Object localObject3 = Keyframe.ofFloat(0.0F, 0.0F);
    Object localObject4 = Keyframe.ofFloat(1.0F, 1.0F);
    localObject2 = PropertyValuesHolder.ofKeyframe(View.SCALE_X, new Keyframe[] { localObject3, localObject4 });
    localObject3 = PropertyValuesHolder.ofKeyframe(View.SCALE_Y, new Keyframe[] { localObject3, localObject4 });
    localObject4 = Keyframe.ofFloat(0.0F, 0.0F);
    Object localObject5 = Keyframe.ofFloat(1.0F, 1.0F);
    localObject4 = PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[] { localObject4, localObject5 });
    localObject5 = Keyframe.ofFloat(0.0F, -50.0F);
    Object localObject6 = Keyframe.ofFloat(0.5F, -610.0F);
    Keyframe localKeyframe = Keyframe.ofFloat(1.0F, 0.0F);
    localObject5 = PropertyValuesHolder.ofKeyframe(View.Y, new Keyframe[] { localObject5, localObject6, localKeyframe });
    localObject6 = this.pzz;
    if (localObject6 == null) {
      p.bcb("brandCardLayout");
    }
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(localObject6, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localObject4, localObject5 });
    p.g(localObject1, "animator");
    ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ObjectAnimator)localObject1).setDuration(500L).start();
    ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)new p(this));
    AppMethodBeat.o(160276);
  }
  
  private final int cfJ()
  {
    AppMethodBeat.i(108204);
    int i = this.pzY[new java.util.Random().nextInt(this.pzY.length)];
    AppMethodBeat.o(108204);
    return i;
  }
  
  private static int fj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108205);
    paramInt1 = (int)(paramInt1 + Math.random() * (paramInt2 - paramInt1));
    AppMethodBeat.o(108205);
    return paramInt1;
  }
  
  private final void g(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(108203);
    Object localObject1 = getContext();
    p.g(localObject1, "context");
    int k = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131165944) / 4;
    int m = com.tencent.mm.ui.aq.fromDPToPix((Context)getContext(), 216) / 4;
    localObject1 = d.k.h.a((d.k.b)d.k.h.lo(0, 4), 3);
    int i = ((d.k.b)localObject1).MMh;
    int n = ((d.k.b)localObject1).MMi;
    int i1 = ((d.k.b)localObject1).kuN;
    if (i1 >= 0)
    {
      if (i > n) {}
    }
    else {
      for (;;)
      {
        int j = 0;
        for (;;)
        {
          if (j < 4)
          {
            localObject1 = new WeImageView((Context)getContext());
            ((WeImageView)localObject1).setImageResource(2131690201);
            Object localObject2 = getContext();
            p.g(localObject2, "context");
            ((WeImageView)localObject1).setIconColor(((AppCompatActivity)localObject2).getResources().getColor(cfJ()));
            localObject2 = getContext();
            p.g(localObject2, "context");
            int i2 = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166302);
            localObject2 = getContext();
            p.g(localObject2, "context");
            localObject2 = new RelativeLayout.LayoutParams(i2, ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166301));
            i2 = fj(i * k, (i + 1) * k);
            int i3 = fj(j * m, (j + 1) * m) + paramInt;
            ad.d("MicroMsg.SpringCardActivity", "x %s y %s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
            ((RelativeLayout.LayoutParams)localObject2).topMargin = i3;
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = i2;
            paramViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            j += 1;
            continue;
            if (i < n) {
              break label347;
            }
            break;
          }
        }
        if (i == n) {
          break;
        }
        i += i1;
      }
    }
    label347:
    AppMethodBeat.o(108203);
  }
  
  public final void a(com.tencent.mm.modelvideo.b.a parama)
  {
    this.pzN = parama;
  }
  
  public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(108202);
    p.h(paramString, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onFinish!!! mediaId[%s].", new Object[] { paramString });
    if ((this.pzN != null) && (this.pzM != null) && (p.i(this.pzM, paramString))) {
      com.tencent.mm.sdk.platformtools.aq.f((Runnable)new l(this, paramString, paramInt));
    }
    AppMethodBeat.o(108202);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(217574);
    p.h(paramString1, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.pzN != null) && (this.pzM != null) && (p.i(this.pzM, paramString1))) {
      com.tencent.mm.sdk.platformtools.aq.f((Runnable)new n(this, paramString1, paramLong1, paramLong2, paramString2));
    }
    AppMethodBeat.o(217574);
  }
  
  public final void aK(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108194);
    if (paramString != null)
    {
      String str = d.n.n.h(paramString, ".temp", "", false);
      if ((!com.tencent.mm.vfs.i.fv(str)) && (d.n.n.nA(paramString, ".temp"))) {
        com.tencent.mm.vfs.i.mz(paramString, str);
      }
      AppMethodBeat.o(108194);
      return;
    }
    AppMethodBeat.o(108194);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108190);
    ad.i("MicroMsg.SpringCardActivity", "onError!!! mediaId[%s] errorMsg[%s].", new Object[] { paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 10);
    paramString1 = this.pzJ;
    if (paramString1 == null) {
      p.bcb("brandCardBlessingStyleImgMedia");
    }
    paramString1.setVisibility(0);
    paramString1 = this.pzK;
    if (paramString1 == null) {
      p.bcb("brandCardBlessingStyleVideoMedia");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(108190);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(160278);
    ad.d("MicroMsg.SpringCardActivity", "onGetVideoSize!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160278);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160277);
    ad.d("MicroMsg.SpringCardActivity", "onPrepared!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160277);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108191);
    ad.d("MicroMsg.SpringCardActivity", "onVideoEnded!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108191);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160279);
    ad.d("MicroMsg.SpringCardActivity", "onVideoPause!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160279);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160280);
    paramString1 = this.pzK;
    if (paramString1 == null) {
      p.bcb("brandCardBlessingStyleVideoMedia");
    }
    ad.d("MicroMsg.SpringCardActivity", "onVideoPlay!!! mediaId[%s], duration[%s].", new Object[] { paramString2, Integer.valueOf(paramString1.getVideoDurationSec()) });
    if (this.duration <= 0)
    {
      paramString1 = this.pzK;
      if (paramString1 == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      this.duration = (paramString1.getVideoDurationSec() * 1000);
    }
    this.count += 1;
    this.pzV += 1;
    ad.d("MicroMsg.SpringCardActivity", "videoInfo count: [%s] rptCount: [%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.pzV) });
    AppMethodBeat.o(160280);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108192);
    ad.d("MicroMsg.SpringCardActivity", "onVideoWaiting!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108192);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108193);
    ad.d("MicroMsg.SpringCardActivity", "onVideoWaitingEnd!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108193);
  }
  
  public final void eT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217573);
    ad.d("MicroMsg.SpringCardActivity", "onVideoFirstFrameDraw!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(217573);
  }
  
  public final int getLayoutId()
  {
    return 2131495639;
  }
  
  public final void gj(String paramString)
  {
    AppMethodBeat.i(108196);
    p.h(paramString, "mediaId");
    String str = this.pzM;
    if (str != null)
    {
      if (p.i(str, paramString)) {
        o.aMK().m(paramString, null);
      }
      AppMethodBeat.o(108196);
      return;
    }
    AppMethodBeat.o(108196);
  }
  
  public final void i(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108201);
    p.h(paramString, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onProgress!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.pzN != null) && (this.pzM != null) && (p.i(this.pzM, paramString))) {
      com.tencent.mm.sdk.platformtools.aq.f((Runnable)new o(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108201);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(108198);
    ad.d("MicroMsg.SpringCardActivity", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.pzM;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (p.i(str, paramString)) {
        bool1 = o.aMK().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(108198);
    return bool1;
  }
  
  public final void onC2CDownloadCompleted(final String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(108189);
    p.h(paramString, "filekey");
    p.h(paramC2CDownloadResult, "result");
    if (paramC2CDownloadResult.errorCode != 0)
    {
      com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 9);
      AppMethodBeat.o(108189);
      return;
    }
    runOnUiThread((Runnable)new f(this, paramString));
    AppMethodBeat.o(108189);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108179);
    super.onCreate(paramBundle);
    getWindow().addFlags(2097280);
    this.cAO = new Handler(getMainLooper());
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), 2131690535);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131100950);
    setActionbarColor(i);
    BK(i);
    hideActionbarLine();
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(2050);
    paramBundle = findViewById(2131304246);
    p.g(paramBundle, "findViewById(R.id.root_layout)");
    this.pzs = ((ViewGroup)paramBundle);
    paramBundle = findViewById(2131297434);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_bg_img)");
    this.pzt = ((MMAnimateView)paramBundle);
    paramBundle = findViewById(2131297437);
    p.g(paramBundle, "findViewById(R.id.bottom…and_clickable_txt_layout)");
    this.pzu = paramBundle;
    paramBundle = this.pzu;
    if (paramBundle == null) {
      p.bcb("bottomBrandClickableTxtLayout");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(2131297436);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_click_txt)");
    this.pzv = ((TextView)paramBundle);
    paramBundle = findViewById(2131297435);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_click_img)");
    this.pzw = ((WeImageView)paramBundle);
    paramBundle = findViewById(2131297438);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_intro_txt)");
    this.pzx = ((TextView)paramBundle);
    paramBundle = findViewById(2131301713);
    p.g(paramBundle, "findViewById(R.id.lucky_bag_loading_img)");
    this.pzy = ((MMAnimateView)paramBundle);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.vfs.i.fv(PluginEggSpring.pyJ))
    {
      paramBundle = this.pzy;
      if (paramBundle == null) {
        p.bcb("luckyBagLoadingImg");
      }
      paramBundle.setImageFilePath(PluginEggSpring.pyJ);
      paramBundle = findViewById(2131297500);
      p.g(paramBundle, "findViewById(R.id.brand_card_layout)");
      this.pzz = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297504);
      p.g(paramBundle, "findViewById(R.id.brand_card_title_layout)");
      this.pzA = paramBundle;
      paramBundle = findViewById(2131297505);
      p.g(paramBundle, "findViewById(R.id.brand_card_title_logo)");
      this.pzB = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297506);
      p.g(paramBundle, "findViewById(R.id.brand_card_title_name)");
      this.pzC = ((TextView)paramBundle);
      paramBundle = findViewById(2131297501);
      p.g(paramBundle, "findViewById(R.id.brand_card_main_wording)");
      this.pzD = ((TextView)paramBundle);
      paramBundle = findViewById(2131297503);
      p.g(paramBundle, "findViewById(R.id.brand_card_sub_wording)");
      this.pzE = ((TextView)paramBundle);
      paramBundle = findViewById(2131297494);
      p.g(paramBundle, "findViewById(R.id.brand_card_accept_btn)");
      this.pzF = ((Button)paramBundle);
      paramBundle = this.pzF;
      if (paramBundle == null) {
        p.bcb("brandCardAcceptBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      paramBundle = findViewById(2131297502);
      p.g(paramBundle, "findViewById(R.id.brand_card_media_layout)");
      this.pzG = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297499);
      p.g(paramBundle, "findViewById(R.id.brand_card_img_media)");
      this.pzH = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297497);
      p.g(paramBundle, "findViewById(R.id.brand_…rd_blessing_style_layout)");
      this.pzI = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297496);
      p.g(paramBundle, "findViewById(R.id.brand_…blessing_style_img_media)");
      this.pzJ = ((MMAnimateView)paramBundle);
      paramBundle = this.pzJ;
      if (paramBundle == null) {
        p.bcb("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setDefaultImageResource(2131231321);
      paramBundle = findViewById(2131297498);
      p.g(paramBundle, "findViewById(R.id.brand_…essing_style_video_media)");
      this.pzK = ((SpringEggVideoView)paramBundle);
      paramBundle = findViewById(2131297495);
      p.g(paramBundle, "findViewById(R.id.brand_…lessing_style_bottom_img)");
      this.pzL = ((MMAnimateView)paramBundle);
      paramBundle = this.pzL;
      if (paramBundle == null) {
        p.bcb("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setDefaultImageResource(2131231319);
      ad.d("MicroMsg.SpringCardActivity", "init config view.");
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBtmImg");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.pzt;
        if (localObject1 == null) {
          p.bcb("bottomBrandBgImg");
        }
        localObject2 = new StringBuilder();
        com.tencent.mm.plugin.eggspring.b.b.a locala = com.tencent.mm.plugin.eggspring.b.b.pzh;
        ((MMAnimateView)localObject1).setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.cfG() + paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBgColor");
      if (!bt.isNullOrNil(paramBundle))
      {
        i = Color.parseColor(paramBundle);
        paramBundle = this.pzs;
        if (paramBundle == null) {
          p.bcb("rootLayout");
        }
        paramBundle.setBackgroundColor(i);
        setActionbarColor(i);
        BK(i);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTile");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.pzv;
        if (localObject1 == null) {
          p.bcb("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTileColor");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.pzv;
        if (localObject1 == null) {
          p.bcb("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
        localObject1 = this.pzw;
        if (localObject1 == null) {
          p.bcb("bottomBrandClickableImg");
        }
        ((WeImageView)localObject1).setIconColor(Color.parseColor(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitle");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.pzx;
        if (localObject1 == null) {
          p.bcb("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitleColor");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.pzx;
        if (localObject1 == null) {
          p.bcb("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
      }
      paramBundle = this.pzJ;
      if (paramBundle == null) {
        p.bcb("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setImageResource(2131231321);
      paramBundle = this.pzL;
      if (paramBundle == null) {
        p.bcb("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setImageResource(2131231319);
      paramBundle = this.cAO;
      if (paramBundle == null) {
        p.bcb("uiHandler");
      }
      paramBundle.postDelayed(this.pzS, 3000L);
      this.pzO = System.currentTimeMillis();
      if (com.tencent.mm.sdk.platformtools.i.DEBUG)
      {
        paramBundle = findViewById(2131305173);
        p.g(paramBundle, "findViewById<Button>(R.id.start)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131305173)).setOnClickListener((View.OnClickListener)new g(this));
        paramBundle = findViewById(2131306309);
        p.g(paramBundle, "findViewById<Button>(R.id.video)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131306309)).setOnClickListener((View.OnClickListener)new h(this));
        paramBundle = findViewById(2131304110);
        p.g(paramBundle, "findViewById<Button>(R.id.reset)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131304110)).setOnClickListener((View.OnClickListener)new i(this));
      }
      com.tencent.mm.kernel.g.aiU().a(2809, (f)this);
      com.tencent.mm.kernel.g.aiU().a(2812, (f)this);
      this.iiW = getIntent().getStringExtra("SpringCard.KeyWord");
      this.appId = getIntent().getStringExtra("SpringCard.AppId");
      this.jSR = getIntent().getStringExtra("SpringCard.TraceId");
      if ((!bt.isNullOrNil(this.iiW)) && (!bt.isNullOrNil(this.appId)) && (!bt.isNullOrNil(this.jSR))) {
        break label1427;
      }
    }
    for (;;)
    {
      this.pzP = ((com.tencent.mm.app.n)new j(this));
      paramBundle = AppForegroundDelegate.cSQ;
      localObject1 = this.pzP;
      if (localObject1 == null) {
        p.bcb("appForegroundLis");
      }
      paramBundle.a((com.tencent.mm.app.n)localObject1);
      AppMethodBeat.o(108179);
      return;
      paramBundle = this.pzy;
      if (paramBundle == null) {
        p.bcb("luckyBagLoadingImg");
      }
      paramBundle.setImageResource(2131232880);
      break;
      label1427:
      paramBundle = EmojiDebugUI.ghC;
      if (EmojiDebugUI.aep())
      {
        ad.d("MicroMsg.SpringCardActivity", "stop cgi!!!");
      }
      else
      {
        paramBundle = this.iiW;
        if (paramBundle == null) {
          p.gfZ();
        }
        localObject1 = this.appId;
        if (localObject1 == null) {
          p.gfZ();
        }
        localObject2 = this.jSR;
        if (localObject2 == null) {
          p.gfZ();
        }
        paramBundle = new com.tencent.mm.plugin.eggspring.c.b(paramBundle, (String)localObject1, (String)localObject2);
        com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)paramBundle);
      }
    }
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108200);
    p.h(paramString, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.pzN != null) && (this.pzM != null) && (p.i(this.pzM, paramString))) {
      com.tencent.mm.sdk.platformtools.aq.f((Runnable)new k(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108200);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(108183);
    super.onDestroy();
    Object localObject = this.pzM;
    if (localObject != null) {
      o.aMK().m((String)localObject, null);
    }
    if (this.pzW)
    {
      localObject = this.pzK;
      if (localObject == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIDestroy();
    }
    com.tencent.mm.kernel.g.aiU().b(2809, (f)this);
    com.tencent.mm.kernel.g.aiU().b(2812, (f)this);
    ad.i("MicroMsg.SpringCardActivity", "videoInfo, count:[%s], rptCount:[%s], duration:[%s], curPoi:[%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.pzV), Integer.valueOf(this.duration), Integer.valueOf(this.pzU) });
    if (this.count >= 0)
    {
      this.pzT = (this.count * this.duration + this.pzU);
      localObject = com.tencent.mm.plugin.eggspring.a.pyS;
      localObject = com.tencent.mm.plugin.eggspring.a.cfE();
      int i = this.duration;
      int j = this.pzV;
      int k = this.pzT;
      com.tencent.mm.plugin.report.service.g.yhR.f(18916, new Object[] { ((com.tencent.mm.plugin.eggspring.a)localObject).pyO, ((com.tencent.mm.plugin.eggspring.a)localObject).pyQ, Integer.valueOf(16), "", Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    }
    for (;;)
    {
      localObject = AppForegroundDelegate.cSQ;
      com.tencent.mm.app.n localn = this.pzP;
      if (localn == null) {
        p.bcb("appForegroundLis");
      }
      ((AppForegroundDelegate)localObject).b(localn);
      AppMethodBeat.o(108183);
      return;
      localObject = com.tencent.mm.plugin.eggspring.a.pyS;
      com.tencent.mm.plugin.eggspring.a.cfE().BJ(16);
    }
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(108188);
    p.h(paramString, "filekey");
    ad.d("MicroMsg.SpringCardActivity", "onDownloadProgressChanged, fileKey [%s], finished [%s], total [%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(108188);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(108182);
    super.onPause();
    if (this.pzW)
    {
      SpringEggVideoView localSpringEggVideoView = this.pzK;
      if (localSpringEggVideoView == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      this.pzU = localSpringEggVideoView.getCurrPosMs();
      ad.d("MicroMsg.SpringCardActivity", "videoInfo, curPoi: [%s].", new Object[] { Integer.valueOf(this.pzU) });
      localSpringEggVideoView = this.pzK;
      if (localSpringEggVideoView == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      localSpringEggVideoView.onUIPause();
    }
    AppMethodBeat.o(108182);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(108181);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.eggspring.a.pyS;
    com.tencent.mm.plugin.eggspring.a.cfE().BJ(1);
    if (this.pzW)
    {
      localObject = this.pzK;
      if (localObject == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIResume();
    }
    AppMethodBeat.o(108181);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(108184);
    p.h(paramn, "scene");
    ad.i("MicroMsg.SpringCardActivity", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject1;
    if (2809 == paramn.getType())
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 5);
        AppMethodBeat.o(108184);
        return;
      }
      if (this.pzX)
      {
        ad.i("MicroMsg.SpringCardActivity", "card is showing, return.");
        AppMethodBeat.o(108184);
        return;
      }
      this.pzn = ((com.tencent.mm.plugin.eggspring.c.b)paramn).pzn;
      if (this.pzn == null) {
        break label3226;
      }
      ad.i("MicroMsg.SpringCardActivity", "brandCardContent: %s.", new Object[] { String.valueOf(this.pzn) });
      paramString = com.tencent.mm.plugin.eggspring.a.pyS;
      paramn = com.tencent.mm.plugin.eggspring.a.cfE();
      paramString = this.pzn;
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.pzg);
        paramn.pyQ = paramString;
        if (this.pzn != null)
        {
          localObject1 = this.pzn;
          if (localObject1 != null)
          {
            if ((bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyW)) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyY == null)) {
              break label498;
            }
            paramString = com.tencent.mm.plugin.eggspring.a.pyS;
            com.tencent.mm.plugin.eggspring.a.cfE().BJ(2);
            paramString = this.pzv;
            if (paramString == null) {
              p.bcb("bottomBrandClickableTxt");
            }
            paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyW);
            paramString = this.pzw;
            if (paramString == null) {
              p.bcb("bottomBrandClickableImg");
            }
            paramString.setVisibility(0);
            if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV) || (!bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pzb))) {
              break label550;
            }
            ad.e("MicroMsg.SpringCardActivity", "red pocket type, accept url is invalid!!!");
          }
        }
      }
      for (;;)
      {
        paramString = this.pzn;
        if (paramString == null) {
          break label2594;
        }
        if (4 != paramString.pyV) {
          break label2470;
        }
        if (1 != paramString.pze) {
          break label2167;
        }
        if (!bt.isNullOrNil(paramString.pyX))
        {
          paramn = paramString.pyX;
          if (paramn == null) {
            p.gfZ();
          }
          if (!com.tencent.mm.vfs.i.fv(FA(paramn))) {
            break label2144;
          }
          paramn = this.pzJ;
          if (paramn == null) {
            p.bcb("brandCardBlessingStyleImgMedia");
          }
          localObject1 = paramString.pyX;
          if (localObject1 == null) {
            p.gfZ();
          }
          paramn.setImageFilePath(FA((String)localObject1));
          BL(0);
        }
        label408:
        if (bt.isNullOrNil(paramString.pzd)) {
          break label2587;
        }
        paramn = paramString.pzd;
        if (paramn == null) {
          p.gfZ();
        }
        if (!com.tencent.mm.vfs.i.fv(FA(paramn))) {
          break label2446;
        }
        paramn = this.pzL;
        if (paramn == null) {
          p.bcb("brandCardBlessingStyleBottomImg");
        }
        paramString = paramString.pzd;
        if (paramString == null) {
          p.gfZ();
        }
        paramn.setImageFilePath(FA(paramString));
        BL(1);
        AppMethodBeat.o(108184);
        return;
        paramString = null;
        break;
        label498:
        if (((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyY == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.e("MicroMsg.SpringCardActivity", "not support jump!!! jumpInfo==null? [%s].", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 8);
          break;
        }
        label550:
        if ((2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).pzc != null)) {
          break label579;
        }
        ad.e("MicroMsg.SpringCardActivity", "coupon type, couponInfo is null!!!");
      }
      label579:
      if (4 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV)
      {
        paramString = this.pzI;
        if (paramString == null) {
          p.bcb("brandCardBlessingStyleLayout");
        }
        g(paramString, com.tencent.mm.ui.aq.fromDPToPix((Context)getContext(), 144));
        paramString = this.pzJ;
        if (paramString == null) {
          p.bcb("brandCardBlessingStyleImgMedia");
        }
        paramString = (View)paramString;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pze) {
          break label3233;
        }
        paramString = this.pzK;
        if (paramString == null) {
          p.bcb("brandCardBlessingStyleVideoMedia");
        }
        paramString = (View)paramString;
      }
    }
    label2446:
    label2587:
    label3233:
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pzf)
      {
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pze)
        {
          paramn = com.tencent.mm.plugin.eggspring.a.pyS;
          com.tencent.mm.plugin.eggspring.a.cfE().BJ(6);
        }
        for (;;)
        {
          paramn = new RoundedCornerFrameLayout((Context)getContext());
          localObject2 = getContext();
          p.g(localObject2, "context");
          paramn.setRadius(((AppCompatActivity)localObject2).getResources().getDimension(2131165940));
          localObject2 = getContext();
          p.g(localObject2, "context");
          paramInt1 = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131165914);
          localObject2 = getContext();
          p.g(localObject2, "context");
          localObject2 = new RelativeLayout.LayoutParams(paramInt1, ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131165914));
          localObject3 = this.pzL;
          if (localObject3 == null) {
            p.bcb("brandCardBlessingStyleBottomImg");
          }
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((MMAnimateView)localObject3).getId());
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          localObject3 = this.pzI;
          if (localObject3 == null) {
            p.bcb("brandCardBlessingStyleLayout");
          }
          ((ViewGroup)localObject3).removeView(paramString);
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          paramString.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          paramn.addView(paramString, (ViewGroup.LayoutParams)localObject3);
          paramString = this.pzI;
          if (paramString == null) {
            p.bcb("brandCardBlessingStyleLayout");
          }
          paramString.addView((View)paramn, (ViewGroup.LayoutParams)localObject2);
          if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pze) {
            break;
          }
          paramString = this.pzJ;
          if (paramString == null) {
            p.bcb("brandCardBlessingStyleImgMedia");
          }
          paramString.setDefaultImageResource(2131231320);
          paramString = this.pzJ;
          if (paramString == null) {
            p.bcb("brandCardBlessingStyleImgMedia");
          }
          paramString.setImageResource(2131231320);
          break;
          paramn = com.tencent.mm.plugin.eggspring.a.pyS;
          com.tencent.mm.plugin.eggspring.a.cfE().BJ(8);
        }
      }
      if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pzf) {
        break;
      }
      if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pze)
      {
        paramn = com.tencent.mm.plugin.eggspring.a.pyS;
        com.tencent.mm.plugin.eggspring.a.cfE().BJ(5);
      }
      for (;;)
      {
        paramn = this.pzI;
        if (paramn == null) {
          p.bcb("brandCardBlessingStyleLayout");
        }
        paramn.removeView(paramString);
        paramn = new RelativeLayout.LayoutParams(-2, -2);
        localObject1 = this.pzL;
        if (localObject1 == null) {
          p.bcb("brandCardBlessingStyleBottomImg");
        }
        paramn.addRule(2, ((MMAnimateView)localObject1).getId());
        paramn.addRule(14);
        localObject1 = this.pzI;
        if (localObject1 == null) {
          p.bcb("brandCardBlessingStyleLayout");
        }
        ((ViewGroup)localObject1).addView(paramString, (ViewGroup.LayoutParams)paramn);
        break;
        paramn = com.tencent.mm.plugin.eggspring.a.pyS;
        com.tencent.mm.plugin.eggspring.a.cfE().BJ(7);
      }
      if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV) && (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV)) {
        break;
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandIcon");
      if (!bt.isNullOrNil(paramString))
      {
        paramn = this.pzB;
        if (paramn == null) {
          p.bcb("brandCardTitleLogo");
        }
        localObject2 = new StringBuilder();
        localObject3 = com.tencent.mm.plugin.eggspring.b.b.pzh;
        paramn.setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.cfG() + paramString);
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandName");
      if (!bt.isNullOrNil(paramString))
      {
        paramn = this.pzC;
        if (paramn == null) {
          p.bcb("brandCardTitleName");
        }
        paramn.setText((CharSequence)paramString);
      }
      paramString = "";
      paramn = "";
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV)
      {
        paramString = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverSubTitle");
        label1318:
        if (!bt.isNullOrNil(paramString))
        {
          localObject2 = this.pzD;
          if (localObject2 == null) {
            p.bcb("brandCardMainWording");
          }
          ((TextView)localObject2).setText((CharSequence)paramString);
        }
        if (!bt.isNullOrNil(paramn))
        {
          paramString = this.pzE;
          if (paramString == null) {
            p.bcb("brandCardSubWording");
          }
          paramString.setText((CharSequence)paramn);
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyZ))
        {
          paramString = this.pzD;
          if (paramString == null) {
            p.bcb("brandCardMainWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyZ);
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pza))
        {
          paramString = this.pzE;
          if (paramString == null) {
            p.bcb("brandCardSubWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).pza);
        }
        paramString = this.pzG;
        if (paramString == null) {
          p.bcb("brandCardMediaLayout");
        }
        g(paramString, 0);
        paramString = this.pzG;
        if (paramString == null) {
          p.bcb("brandCardMediaLayout");
        }
        paramn = this.pzH;
        if (paramn == null) {
          p.bcb("brandCardImgMedia");
        }
        paramString.removeView((View)paramn);
        paramString = new RoundedCornerFrameLayout((Context)getContext());
        paramn = getContext();
        p.g(paramn, "context");
        paramString.setRadius(paramn.getResources().getDimension(2131165943));
        paramn = new RelativeLayout.LayoutParams(-2, -2);
        paramn.addRule(14);
        localObject2 = getContext();
        p.g(localObject2, "context");
        paramn.topMargin = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131165294);
        localObject2 = getContext();
        p.g(localObject2, "context");
        paramn.topMargin = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166159);
        localObject2 = this.pzG;
        if (localObject2 == null) {
          p.bcb("brandCardMediaLayout");
        }
        ((ViewGroup)localObject2).addView((View)paramString, (ViewGroup.LayoutParams)paramn);
        paramn = new FrameLayout.LayoutParams(-2, -2);
        if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV) {
          break label2010;
        }
        localObject1 = getContext();
        p.g(localObject1, "context");
        paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166752);
        localObject1 = getContext();
        p.g(localObject1, "context");
        paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166751);
        localObject1 = this.pzH;
        if (localObject1 == null) {
          p.bcb("brandCardImgMedia");
        }
        ((MMAnimateView)localObject1).setImageResource(2131233816);
        localObject1 = this.pzF;
        if (localObject1 == null) {
          p.bcb("brandCardAcceptBtn");
        }
        ((Button)localObject1).setText(2131755116);
        localObject1 = com.tencent.mm.plugin.eggspring.a.pyS;
        com.tencent.mm.plugin.eggspring.a.cfE().BJ(3);
      }
      for (;;)
      {
        localObject1 = this.pzH;
        if (localObject1 == null) {
          p.bcb("brandCardImgMedia");
        }
        paramString.addView((View)localObject1, (ViewGroup.LayoutParams)paramn);
        paramString = this.pzA;
        if (paramString == null) {
          p.bcb("brandCardTitleLayout");
        }
        paramString.setVisibility(0);
        paramString = this.pzD;
        if (paramString == null) {
          p.bcb("brandCardMainWording");
        }
        paramString.setVisibility(0);
        paramString = this.pzE;
        if (paramString == null) {
          p.bcb("brandCardSubWording");
        }
        paramString.setVisibility(0);
        paramString = this.pzF;
        if (paramString == null) {
          p.bcb("brandCardAcceptBtn");
        }
        paramString.setVisibility(0);
        paramString = this.pzG;
        if (paramString == null) {
          p.bcb("brandCardMediaLayout");
        }
        paramString.setVisibility(0);
        paramString = this.pzI;
        if (paramString == null) {
          p.bcb("brandCardBlessingStyleLayout");
        }
        paramString.setVisibility(8);
        break;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV) {
          break label1318;
        }
        paramString = getIntent().getStringExtra("SpringCard.BrandCouponMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandCouponSubTitle");
        break label1318;
        label2010:
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pyV)
        {
          localObject1 = getContext();
          p.g(localObject1, "context");
          paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166077);
          localObject1 = getContext();
          p.g(localObject1, "context");
          paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166076);
          localObject1 = this.pzH;
          if (localObject1 == null) {
            p.bcb("brandCardImgMedia");
          }
          ((MMAnimateView)localObject1).setImageResource(2131231861);
          localObject1 = this.pzF;
          if (localObject1 == null) {
            p.bcb("brandCardAcceptBtn");
          }
          ((Button)localObject1).setText(2131755113);
          localObject1 = com.tencent.mm.plugin.eggspring.a.pyS;
          com.tencent.mm.plugin.eggspring.a.cfE().BJ(4);
        }
      }
      label2144:
      paramn = paramString.pyX;
      if (paramn == null) {
        p.gfZ();
      }
      aaZ(paramn);
      break label408;
      label2167:
      if (2 != paramString.pze) {
        break label408;
      }
      paramn = this.pzJ;
      if (paramn == null) {
        p.bcb("brandCardBlessingStyleImgMedia");
      }
      paramn.setVisibility(8);
      paramn = this.pzK;
      if (paramn == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      paramn.setVisibility(0);
      this.pzW = true;
      paramn = this.pzn;
      if ((paramn == null) || (bt.isNullOrNil(paramn.pyX))) {
        break label408;
      }
      localObject1 = this.pzK;
      if (localObject1 == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setLoop(true);
      localObject1 = this.pzK;
      if (localObject1 == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMVideoViewCallback((i.b)this);
      localObject1 = this.pzK;
      if (localObject1 == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMDownloadFinish((i.a)this);
      localObject1 = this.pzK;
      if (localObject1 == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this);
      localObject1 = this.pzK;
      if (localObject1 == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).c(false, paramn.pyX, 0);
      localObject1 = this.pzK;
      if (localObject1 == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      paramn = paramn.pyX;
      if (paramn == null) {
        p.gfZ();
      }
      ((SpringEggVideoView)localObject1).setFilepath(aba(paramn));
      paramn = this.pzK;
      if (paramn == null) {
        p.bcb("brandCardBlessingStyleVideoMedia");
      }
      paramn.start();
      break label408;
      paramString = paramString.pzd;
      if (paramString == null) {
        p.gfZ();
      }
      aaZ(paramString);
      AppMethodBeat.o(108184);
      return;
      label2470:
      if (((1 == paramString.pyV) || (2 == paramString.pyV)) && (!bt.isNullOrNil(paramString.pyX)))
      {
        paramn = paramString.pyX;
        if (paramn == null) {
          p.gfZ();
        }
        if (com.tencent.mm.vfs.i.fv(FA(paramn)))
        {
          paramn = this.pzH;
          if (paramn == null) {
            p.bcb("brandCardImgMedia");
          }
          paramString = paramString.pyX;
          if (paramString == null) {
            p.gfZ();
          }
          paramn.setImageFilePath(FA(paramString));
          cfH();
          AppMethodBeat.o(108184);
          return;
        }
        paramString = paramString.pyX;
        if (paramString == null) {
          p.gfZ();
        }
        aaZ(paramString);
      }
      AppMethodBeat.o(108184);
      return;
      label2594:
      AppMethodBeat.o(108184);
      return;
      if (2812 == paramn.getType())
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          paramString = com.tencent.mm.plugin.eggspring.a.pyS;
          com.tencent.mm.plugin.eggspring.a.cfE().BJ(14);
          com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 6);
          paramString = (Context)getContext();
          paramn = getContext();
          p.g(paramn, "context");
          t.cn(paramString, paramn.getResources().getString(2131764540));
          AppMethodBeat.o(108184);
          return;
        }
        paramString = (com.tencent.mm.plugin.eggspring.c.a)paramn;
        paramn = paramString.pzk;
        ad.i("MicroMsg.SpringCardActivity", "coupon, retCode: %s, retMsg: %s.", new Object[] { paramn, paramString.pzl });
        if (paramn != null)
        {
          long l = ((Number)paramn).longValue();
          if (0L == l)
          {
            paramString = com.tencent.mm.plugin.eggspring.a.pyS;
            com.tencent.mm.plugin.eggspring.a.cfE().BJ(13);
            paramString = (Context)getContext();
            paramn = getContext();
            p.g(paramn, "context");
            t.cm(paramString, paramn.getResources().getString(2131755117));
            paramString = this.pzF;
            if (paramString == null) {
              p.bcb("brandCardAcceptBtn");
            }
            paramString.setText(2131755115);
            paramString = this.pzF;
            if (paramString == null) {
              p.bcb("brandCardAcceptBtn");
            }
            paramString.setEnabled(false);
          }
          for (;;)
          {
            if (l != 0L)
            {
              paramString = com.tencent.mm.plugin.eggspring.a.pyS;
              com.tencent.mm.plugin.eggspring.a.cfE().BJ(14);
              com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 6);
            }
            AppMethodBeat.o(108184);
            return;
            if ((268456656L == l) || (268457508L == l) || (268456641L == l) || (268456640L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.cn(paramString, paramn.getResources().getString(2131757954));
              paramString = this.pzF;
              if (paramString == null) {
                p.bcb("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.pzF;
              if (paramString == null) {
                p.bcb("brandCardAcceptBtn");
              }
              paramString.setEnabled(false);
            }
            else if ((268456461L == l) || (268455949L == l) || (268456007L == l) || (268456320L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.cn(paramString, paramn.getResources().getString(2131756775));
              paramString = this.pzF;
              if (paramString == null) {
                p.bcb("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.pzF;
              if (paramString == null) {
                p.bcb("brandCardAcceptBtn");
              }
              paramString.setEnabled(false);
            }
            else if ((270100487L == l) || (270100488L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.cn(paramString, paramn.getResources().getString(2131764540));
            }
            else
            {
              ad.i("MicroMsg.SpringCardActivity", "other err![%s]", new Object[] { paramn });
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.cn(paramString, paramn.getResources().getString(2131756775));
            }
          }
        }
      }
      AppMethodBeat.o(108184);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void p(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108195);
    p.h(paramString1, "mediaId");
    p.h(paramString2, "path");
    p.h(paramString3, "url");
    this.pzM = paramString1;
    if (com.tencent.mm.vfs.i.fv(PluginEggSpring.pyI + "MMVideo_" + paramString3.hashCode() + ".mp4"))
    {
      a(paramString1, 0, null);
      AppMethodBeat.o(108195);
      return;
    }
    e locale = o.aMK();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.fJi = "task_SpringCardActivity";
    localh.field_mediaId = paramString1;
    localh.url = paramString3;
    localh.fJF = 1;
    localh.fJA = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString2;
    localh.fJN = ((h.a)this);
    locale.a(localh, false);
    AppMethodBeat.o(108195);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108197);
    String str = this.pzM;
    if (str != null)
    {
      if (p.i(str, paramString))
      {
        o.aMK();
        e.r(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(108197);
      return;
    }
    AppMethodBeat.o(108197);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108165);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      if (SpringCardActivity.q(this.pAa).getVisibility() == 0)
      {
        paramView = com.tencent.mm.plugin.eggspring.a.pyS;
        com.tencent.mm.plugin.eggspring.a.cfE().BJ(10);
        paramView = (Context)this.pAa;
        localObject = SpringCardActivity.r(this.pAa);
        if (localObject == null) {
          p.gfZ();
        }
        com.tencent.mm.plugin.eggspring.d.a.a(paramView, ((com.tencent.mm.plugin.eggspring.b.a)localObject).pyY);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108165);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108166);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      paramView = SpringCardActivity.r(this.pAa);
      if (paramView != null) {
        switch (paramView.pyV)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108166);
        return;
        if (!bt.isNullOrNil(paramView.pzb))
        {
          localObject = com.tencent.mm.plugin.eggspring.a.pyS;
          com.tencent.mm.plugin.eggspring.a.cfE().BJ(11);
          ad.d("MicroMsg.SpringCardActivity", "acceptRedPocketCoverUrl: %s.", new Object[] { paramView.pzb });
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.pzb);
          com.tencent.mm.bs.d.b((Context)this.pAa.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
        else
        {
          ad.e("MicroMsg.SpringCardActivity", "red pocket cover accept url is invalid, impossible!!!");
          continue;
          paramView = paramView.pzc;
          if (paramView != null)
          {
            localObject = com.tencent.mm.plugin.eggspring.a.pyS;
            com.tencent.mm.plugin.eggspring.a.cfE().BJ(12);
            paramView = new com.tencent.mm.plugin.eggspring.c.a(paramView);
            com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)paramView);
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(SpringCardActivity paramSpringCardActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(162211);
      this.pAa.finish();
      AppMethodBeat.o(162211);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(160272);
      if (SpringCardActivity.r(this.pAa) != null)
      {
        localObject = SpringCardActivity.r(this.pAa);
        if (localObject == null) {
          p.gfZ();
        }
        if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).pyV == 4) || (SpringCardActivity.g(this.pAa).getVisibility() != 0))
        {
          localObject = SpringCardActivity.r(this.pAa);
          if (localObject == null) {
            p.gfZ();
          }
          if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).pyV != 4) || (SpringCardActivity.x(this.pAa)) || (SpringCardActivity.y(this.pAa))) {
            break label117;
          }
        }
      }
      Object localObject = com.tencent.mm.plugin.eggspring.a.pyS;
      com.tencent.mm.plugin.eggspring.a.cfE().BJ(9);
      com.tencent.mm.plugin.report.service.g.yhR.dD(1263, 7);
      label117:
      SpringCardActivity.a(this.pAa);
      AppMethodBeat.o(160272);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(SpringCardActivity paramSpringCardActivity, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(108169);
      if (SpringCardActivity.j(this.pAa))
      {
        AppMethodBeat.o(108169);
        return;
      }
      com.tencent.mm.plugin.eggspring.b.a locala = SpringCardActivity.r(this.pAa);
      if (locala != null)
      {
        if ((p.i(paramString, locala.pyX)) && ((1 == locala.pyV) || (2 == locala.pyV) || ((4 == locala.pyV) && (2 != locala.pze))))
        {
          ad.d("MicroMsg.SpringCardActivity", "onC2CDownloadCompleted, filekey: [%s], cardType: [%s].", new Object[] { paramString, Integer.valueOf(locala.pyV) });
          if (4 == locala.pyV)
          {
            SpringCardActivity.i(this.pAa).setImageFilePath(SpringCardActivity.abc(paramString));
            SpringCardActivity.c(this.pAa, 0);
            AppMethodBeat.o(108169);
            return;
          }
          if ((1 == locala.pyV) || (2 == locala.pyV))
          {
            SpringCardActivity.t(this.pAa).setImageFilePath(SpringCardActivity.abc(paramString));
            SpringCardActivity.u(this.pAa);
          }
          AppMethodBeat.o(108169);
          return;
        }
        if ((p.i(paramString, locala.pzd)) && (4 == locala.pyV))
        {
          SpringCardActivity.v(this.pAa).setImageFilePath(SpringCardActivity.abc(paramString));
          SpringCardActivity.c(this.pAa, 1);
        }
        AppMethodBeat.o(108169);
        return;
      }
      AppMethodBeat.o(108169);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108170);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      SpringCardActivity.a(this.pAa);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108170);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108171);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      SpringCardActivity.b(this.pAa).setVisibility(8);
      SpringCardActivity.c(this.pAa).setVisibility(8);
      SpringCardActivity.d(this.pAa).setVisibility(8);
      SpringCardActivity.e(this.pAa).setVisibility(8);
      SpringCardActivity.f(this.pAa).setVisibility(8);
      SpringCardActivity.g(this.pAa).setVisibility(0);
      SpringCardActivity.h(this.pAa).setLoop(true);
      SpringCardActivity.h(this.pAa).setIMMVideoViewCallback((i.b)this.pAa);
      SpringCardActivity.h(this.pAa).setIMMDownloadFinish((i.a)this.pAa);
      SpringCardActivity.h(this.pAa).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.pAa);
      SpringCardActivity.h(this.pAa).c(false, "http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023", 0);
      SpringCardActivity.h(this.pAa).setFilepath(SpringCardActivity.abb("http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023"));
      SpringCardActivity.h(this.pAa).start();
      SpringCardActivity.i(this.pAa).setVisibility(8);
      SpringCardActivity.h(this.pAa).setVisibility(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108171);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108172);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      SpringCardActivity.k(this.pAa);
      SpringCardActivity.l(this.pAa).setVisibility(0);
      SpringCardActivity.m(this.pAa).setVisibility(4);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108172);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$4", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-eggspring_release"})
  public static final class j
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(162213);
      ad.d("MicroMsg.SpringCardActivity", "onAppBackground");
      if (SpringCardActivity.n(this.pAa))
      {
        SpringCardActivity.a(this.pAa, SpringCardActivity.o(this.pAa) - 1);
        SpringCardActivity.b(this.pAa, SpringCardActivity.p(this.pAa) - 1);
      }
      AppMethodBeat.o(162213);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(162212);
      ad.d("MicroMsg.SpringCardActivity", "onAppForeground");
      AppMethodBeat.o(162212);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108173);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pAa);
      if (locala == null) {
        p.gfZ();
      }
      locala.onDataAvailable(paramString, paramLong1, this.pAe);
      AppMethodBeat.o(108173);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(SpringCardActivity paramSpringCardActivity, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(108174);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pAa);
      if (locala == null) {
        p.gfZ();
      }
      locala.as(paramString, paramInt);
      AppMethodBeat.o(108174);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(160273);
      SpringCardActivity.a(this.pAa);
      AppMethodBeat.o(160273);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(SpringCardActivity paramSpringCardActivity, String paramString1, long paramLong1, long paramLong2, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108175);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pAa);
      if (locala == null) {
        p.gfZ();
      }
      locala.sp(paramLong1);
      AppMethodBeat.o(108175);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108176);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pAa);
      if (locala == null) {
        p.gfZ();
      }
      locala.i(paramString, paramLong1, this.pAh);
      AppMethodBeat.o(108176);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$playCardAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-eggspring_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(108177);
      ad.d("MicroMsg.SpringCardActivity", "onAnimationEnd");
      SpringCardActivity.l(this.pAa).setVisibility(8);
      paramAnimator = com.tencent.mm.plugin.eggspring.a.pyS;
      paramAnimator = com.tencent.mm.plugin.eggspring.a.cfE();
      long l1 = System.currentTimeMillis();
      long l2 = SpringCardActivity.s(this.pAa);
      com.tencent.mm.plugin.report.service.g.yhR.f(18916, new Object[] { paramAnimator.pyO, paramAnimator.pyQ, Integer.valueOf(15), Long.valueOf(l1 - l2) });
      AppMethodBeat.o(108177);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(108178);
      ad.d("MicroMsg.SpringCardActivity", "onAnimationStart");
      AppMethodBeat.o(108178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity
 * JD-Core Version:    0.7.0.1
 */