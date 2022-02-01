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
import com.tencent.mm.ak.q;
import com.tencent.mm.an.e;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "appId", "", "blessingBtmImgReady", "", "blessingTopImgReady", "bottomBrandBgImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "bottomBrandClickableImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomBrandClickableTxt", "Landroid/widget/TextView;", "bottomBrandClickableTxtLayout", "Landroid/view/View;", "bottomBrandIntroTxt", "brandCardAcceptBtn", "Landroid/widget/Button;", "brandCardBlessingStyleBottomImg", "brandCardBlessingStyleImgMedia", "brandCardBlessingStyleLayout", "Landroid/view/ViewGroup;", "brandCardBlessingStyleVideoMedia", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "brandCardImgMedia", "brandCardLayout", "brandCardMainWording", "brandCardMediaLayout", "brandCardSubWording", "brandCardTitleLayout", "brandCardTitleLogo", "brandCardTitleName", "cardIsShowing", "count", "", "curPoi", "duration", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "fireWorksColor", "", "isVideo", "keyWord", "lastShowCardRunnable", "Ljava/lang/Runnable;", "loadingAnimTimerStartMS", "", "luckyBagLoadingImg", "rootLayout", "rptCount", "sum", "traceId", "uiHandler", "Landroid/os/Handler;", "videoMediaId", "addFireWorks", "", "parent", "offset", "adjustCloseBtnColor", "color", "againConfigView", "boundView", "changeCardStyle", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "dealWithMedia", "downLoadImg", "getCachePath", "getFireworksColor", "getLayoutId", "getRandomByRange", "low", "high", "getSavePath", "getTempPath", "imgExist", "initBar", "initConfigView", "initVideoView", "isVideoDataAvailable", "length", "onBlessingMediaReady", "type", "onC2CDownloadCompleted", "filekey", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataAvailable", "onDestroy", "onDownloadFinish", "isPlayNow", "onDownloadProgressChanged", "finished", "total", "tryshow", "onError", "sessionId", "errorMsg", "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMediaReady", "onMoovReady", "svrflag", "onPause", "onPrepared", "onProgress", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "playCardAnim", "requestBrandCardContent", "requestVideoData", "setIEngineCallback", "callback", "startHttpStream", "stop", "Companion", "plugin-eggspring_release"})
public final class SpringCardActivity
  extends MMActivity
  implements CdnLogic.DownloadCallback, com.tencent.mm.ak.g, com.tencent.mm.i.h.a, com.tencent.mm.modelvideo.b, com.tencent.mm.pluginsdk.ui.h.a, h.b
{
  public static final SpringCardActivity.a oWp;
  private String appId;
  private int count;
  private Handler cpW;
  private int duration;
  private String hPI;
  private String jyU;
  private com.tencent.mm.plugin.eggspring.b.a oVD;
  private ViewGroup oVI;
  private MMAnimateView oVJ;
  private View oVK;
  private TextView oVL;
  private WeImageView oVM;
  private TextView oVN;
  private MMAnimateView oVO;
  private ViewGroup oVP;
  private View oVQ;
  private MMAnimateView oVR;
  private TextView oVS;
  private TextView oVT;
  private TextView oVU;
  private Button oVV;
  private ViewGroup oVW;
  private MMAnimateView oVX;
  private ViewGroup oVY;
  private MMAnimateView oVZ;
  private SpringEggVideoView oWa;
  private MMAnimateView oWb;
  private String oWc;
  private com.tencent.mm.modelvideo.b.a oWd;
  private long oWe;
  private com.tencent.mm.app.n oWf;
  private boolean oWg;
  private boolean oWh;
  private final Runnable oWi;
  private int oWj;
  private int oWk;
  private int oWl;
  private boolean oWm;
  private boolean oWn;
  private final int[] oWo;
  
  static
  {
    AppMethodBeat.i(108208);
    oWp = new SpringCardActivity.a((byte)0);
    AppMethodBeat.o(108208);
  }
  
  public SpringCardActivity()
  {
    AppMethodBeat.i(108207);
    this.oWi = ((Runnable)new e(this));
    this.duration = -1;
    this.count = -1;
    this.oWj = -1;
    this.oWk = -1;
    this.oWo = new int[] { 2131100372, 2131100373, 2131100374 };
    AppMethodBeat.o(108207);
  }
  
  private final void Bc(int paramInt)
  {
    AppMethodBeat.i(162214);
    if (am.ZN(paramInt))
    {
      updateBackBtn(am.k((Context)this, 2131690535, -1));
      AppMethodBeat.o(162214);
      return;
    }
    updateBackBtn(am.k((Context)this, 2131690535, -16777216));
    AppMethodBeat.o(162214);
  }
  
  private final void Bd(int paramInt)
  {
    AppMethodBeat.i(160274);
    if (paramInt == 0)
    {
      this.oWg = true;
      if (!this.oWh) {}
    }
    for (;;)
    {
      cbd();
      do
      {
        do
        {
          AppMethodBeat.o(160274);
          return;
        } while (1 != paramInt);
        this.oWh = true;
        if (this.oWg) {
          break;
        }
      } while (!this.oWm);
    }
  }
  
  private static String Cw(String paramString)
  {
    AppMethodBeat.i(108186);
    paramString = PluginEggSpring.oUY + '/' + paramString.hashCode();
    AppMethodBeat.o(108186);
    return paramString;
  }
  
  private final void Xs(String paramString)
  {
    AppMethodBeat.i(108185);
    Object localObject = EmojiDebugUI.fOc;
    if (EmojiDebugUI.abM())
    {
      ac.d("MicroMsg.SpringCardActivity", "stop cdn!!!");
      AppMethodBeat.o(108185);
      return;
    }
    localObject = new CdnLogic.C2CDownloadRequest();
    ((CdnLogic.C2CDownloadRequest)localObject).fileKey = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).url = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).setSavePath(Cw(paramString));
    CdnLogic.startHttpsDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.DownloadCallback)this);
    AppMethodBeat.o(108185);
  }
  
  private static String Xt(String paramString)
  {
    AppMethodBeat.i(108187);
    paramString = PluginEggSpring.oUY + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(108187);
    return paramString;
  }
  
  private final void cbd()
  {
    AppMethodBeat.i(160275);
    Handler localHandler = this.cpW;
    if (localHandler == null) {
      k.aVY("uiHandler");
    }
    localHandler.removeCallbacks(this.oWi);
    if (this.oWn)
    {
      AppMethodBeat.o(160275);
      return;
    }
    long l = System.currentTimeMillis() - this.oWe;
    if (l > 1000L)
    {
      cbe();
      AppMethodBeat.o(160275);
      return;
    }
    localHandler = this.cpW;
    if (localHandler == null) {
      k.aVY("uiHandler");
    }
    localHandler.postDelayed((Runnable)new m(this), 1000L - l);
    AppMethodBeat.o(160275);
  }
  
  private final void cbe()
  {
    AppMethodBeat.i(160276);
    this.oWn = true;
    Object localObject1 = this.oVP;
    if (localObject1 == null) {
      k.aVY("brandCardLayout");
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
    localObject6 = this.oVP;
    if (localObject6 == null) {
      k.aVY("brandCardLayout");
    }
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(localObject6, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localObject4, localObject5 });
    k.g(localObject1, "animator");
    ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ObjectAnimator)localObject1).setDuration(500L).start();
    ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)new p(this));
    AppMethodBeat.o(160276);
  }
  
  private final int cbf()
  {
    AppMethodBeat.i(108204);
    int i = this.oWo[new java.util.Random().nextInt(this.oWo.length)];
    AppMethodBeat.o(108204);
    return i;
  }
  
  private final void f(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(108203);
    Object localObject1 = getContext();
    k.g(localObject1, "context");
    int k = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131165944) / 4;
    int m = ao.fromDPToPix((Context)getContext(), 216) / 4;
    localObject1 = d.k.h.a((d.k.b)d.k.h.kZ(0, 4), 3);
    int i = ((d.k.b)localObject1).KVb;
    int n = ((d.k.b)localObject1).KVc;
    int i1 = ((d.k.b)localObject1).kar;
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
            k.g(localObject2, "context");
            ((WeImageView)localObject1).setIconColor(((AppCompatActivity)localObject2).getResources().getColor(cbf()));
            localObject2 = getContext();
            k.g(localObject2, "context");
            int i2 = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166302);
            localObject2 = getContext();
            k.g(localObject2, "context");
            localObject2 = new RelativeLayout.LayoutParams(i2, ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166301));
            i2 = ff(i * k, (i + 1) * k);
            int i3 = ff(j * m, (j + 1) * m) + paramInt;
            ac.d("MicroMsg.SpringCardActivity", "x %s y %s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
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
  
  private static int ff(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108205);
    paramInt1 = (int)(paramInt1 + Math.random() * (paramInt2 - paramInt1));
    AppMethodBeat.o(108205);
    return paramInt1;
  }
  
  public final void a(com.tencent.mm.modelvideo.b.a parama)
  {
    this.oWd = parama;
  }
  
  public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(108202);
    k.h(paramString, "mediaId");
    ac.d("MicroMsg.SpringCardActivity", "onFinish!!! mediaId[%s].", new Object[] { paramString });
    if ((this.oWd != null) && (this.oWc != null) && (k.g(this.oWc, paramString))) {
      ap.f((Runnable)new l(this, paramString, paramInt));
    }
    AppMethodBeat.o(108202);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(206853);
    k.h(paramString1, "mediaId");
    ac.d("MicroMsg.SpringCardActivity", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.oWd != null) && (this.oWc != null) && (k.g(this.oWc, paramString1))) {
      ap.f((Runnable)new n(this, paramString1, paramLong1, paramLong2, paramString2));
    }
    AppMethodBeat.o(206853);
  }
  
  public final void aI(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108194);
    if (paramString != null)
    {
      String str = d.n.n.h(paramString, ".temp", "", false);
      if ((!i.eA(str)) && (d.n.n.nc(paramString, ".temp"))) {
        i.lZ(paramString, str);
      }
      AppMethodBeat.o(108194);
      return;
    }
    AppMethodBeat.o(108194);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108190);
    ac.i("MicroMsg.SpringCardActivity", "onError!!! mediaId[%s] errorMsg[%s].", new Object[] { paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 10);
    paramString1 = this.oVZ;
    if (paramString1 == null) {
      k.aVY("brandCardBlessingStyleImgMedia");
    }
    paramString1.setVisibility(0);
    paramString1 = this.oWa;
    if (paramString1 == null) {
      k.aVY("brandCardBlessingStyleVideoMedia");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(108190);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(160278);
    ac.d("MicroMsg.SpringCardActivity", "onGetVideoSize!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160278);
  }
  
  public final void jdMethod_do(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160277);
    ac.d("MicroMsg.SpringCardActivity", "onPrepared!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160277);
  }
  
  public final void dp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108191);
    ac.d("MicroMsg.SpringCardActivity", "onVideoEnded!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108191);
  }
  
  public final void dq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160279);
    ac.d("MicroMsg.SpringCardActivity", "onVideoPause!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160279);
  }
  
  public final void dr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160280);
    paramString1 = this.oWa;
    if (paramString1 == null) {
      k.aVY("brandCardBlessingStyleVideoMedia");
    }
    ac.d("MicroMsg.SpringCardActivity", "onVideoPlay!!! mediaId[%s], duration[%s].", new Object[] { paramString2, Integer.valueOf(paramString1.getVideoDurationSec()) });
    if (this.duration <= 0)
    {
      paramString1 = this.oWa;
      if (paramString1 == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      this.duration = (paramString1.getVideoDurationSec() * 1000);
    }
    this.count += 1;
    this.oWl += 1;
    ac.d("MicroMsg.SpringCardActivity", "videoInfo count: [%s] rptCount: [%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.oWl) });
    AppMethodBeat.o(160280);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108192);
    ac.d("MicroMsg.SpringCardActivity", "onVideoWaiting!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108192);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108193);
    ac.d("MicroMsg.SpringCardActivity", "onVideoWaitingEnd!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108193);
  }
  
  public final void eJ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206852);
    ac.d("MicroMsg.SpringCardActivity", "onVideoFirstFrameDraw!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(206852);
  }
  
  public final void fo(String paramString)
  {
    AppMethodBeat.i(108196);
    k.h(paramString, "mediaId");
    String str = this.oWc;
    if (str != null)
    {
      if (k.g(str, paramString)) {
        o.aJz().k(paramString, null);
      }
      AppMethodBeat.o(108196);
      return;
    }
    AppMethodBeat.o(108196);
  }
  
  public final int getLayoutId()
  {
    return 2131495639;
  }
  
  public final void i(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108201);
    k.h(paramString, "mediaId");
    ac.d("MicroMsg.SpringCardActivity", "onProgress!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.oWd != null) && (this.oWc != null) && (k.g(this.oWc, paramString))) {
      ap.f((Runnable)new o(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108201);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(108198);
    ac.d("MicroMsg.SpringCardActivity", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.oWc;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (k.g(str, paramString)) {
        bool1 = o.aJz().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(108198);
    return bool1;
  }
  
  public final void onC2CDownloadCompleted(final String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(108189);
    k.h(paramString, "filekey");
    k.h(paramC2CDownloadResult, "result");
    if (paramC2CDownloadResult.errorCode != 0)
    {
      com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 9);
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
    this.cpW = new Handler(getMainLooper());
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), 2131690535);
    paramBundle = getContext();
    k.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131100950);
    setActionbarColor(i);
    Bc(i);
    hideActionbarLine();
    paramBundle = getWindow();
    k.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    k.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(2050);
    paramBundle = findViewById(2131304246);
    k.g(paramBundle, "findViewById(R.id.root_layout)");
    this.oVI = ((ViewGroup)paramBundle);
    paramBundle = findViewById(2131297434);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_bg_img)");
    this.oVJ = ((MMAnimateView)paramBundle);
    paramBundle = findViewById(2131297437);
    k.g(paramBundle, "findViewById(R.id.bottom…and_clickable_txt_layout)");
    this.oVK = paramBundle;
    paramBundle = this.oVK;
    if (paramBundle == null) {
      k.aVY("bottomBrandClickableTxtLayout");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(2131297436);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_click_txt)");
    this.oVL = ((TextView)paramBundle);
    paramBundle = findViewById(2131297435);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_click_img)");
    this.oVM = ((WeImageView)paramBundle);
    paramBundle = findViewById(2131297438);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_intro_txt)");
    this.oVN = ((TextView)paramBundle);
    paramBundle = findViewById(2131301713);
    k.g(paramBundle, "findViewById(R.id.lucky_bag_loading_img)");
    this.oVO = ((MMAnimateView)paramBundle);
    Object localObject1;
    Object localObject2;
    if (i.eA(PluginEggSpring.oUZ))
    {
      paramBundle = this.oVO;
      if (paramBundle == null) {
        k.aVY("luckyBagLoadingImg");
      }
      paramBundle.setImageFilePath(PluginEggSpring.oUZ);
      paramBundle = findViewById(2131297500);
      k.g(paramBundle, "findViewById(R.id.brand_card_layout)");
      this.oVP = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297504);
      k.g(paramBundle, "findViewById(R.id.brand_card_title_layout)");
      this.oVQ = paramBundle;
      paramBundle = findViewById(2131297505);
      k.g(paramBundle, "findViewById(R.id.brand_card_title_logo)");
      this.oVR = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297506);
      k.g(paramBundle, "findViewById(R.id.brand_card_title_name)");
      this.oVS = ((TextView)paramBundle);
      paramBundle = findViewById(2131297501);
      k.g(paramBundle, "findViewById(R.id.brand_card_main_wording)");
      this.oVT = ((TextView)paramBundle);
      paramBundle = findViewById(2131297503);
      k.g(paramBundle, "findViewById(R.id.brand_card_sub_wording)");
      this.oVU = ((TextView)paramBundle);
      paramBundle = findViewById(2131297494);
      k.g(paramBundle, "findViewById(R.id.brand_card_accept_btn)");
      this.oVV = ((Button)paramBundle);
      paramBundle = this.oVV;
      if (paramBundle == null) {
        k.aVY("brandCardAcceptBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      paramBundle = findViewById(2131297502);
      k.g(paramBundle, "findViewById(R.id.brand_card_media_layout)");
      this.oVW = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297499);
      k.g(paramBundle, "findViewById(R.id.brand_card_img_media)");
      this.oVX = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297497);
      k.g(paramBundle, "findViewById(R.id.brand_…rd_blessing_style_layout)");
      this.oVY = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297496);
      k.g(paramBundle, "findViewById(R.id.brand_…blessing_style_img_media)");
      this.oVZ = ((MMAnimateView)paramBundle);
      paramBundle = this.oVZ;
      if (paramBundle == null) {
        k.aVY("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setDefaultImageResource(2131231321);
      paramBundle = findViewById(2131297498);
      k.g(paramBundle, "findViewById(R.id.brand_…essing_style_video_media)");
      this.oWa = ((SpringEggVideoView)paramBundle);
      paramBundle = findViewById(2131297495);
      k.g(paramBundle, "findViewById(R.id.brand_…lessing_style_bottom_img)");
      this.oWb = ((MMAnimateView)paramBundle);
      paramBundle = this.oWb;
      if (paramBundle == null) {
        k.aVY("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setDefaultImageResource(2131231319);
      ac.d("MicroMsg.SpringCardActivity", "init config view.");
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBtmImg");
      if (!bs.isNullOrNil(paramBundle))
      {
        localObject1 = this.oVJ;
        if (localObject1 == null) {
          k.aVY("bottomBrandBgImg");
        }
        localObject2 = new StringBuilder();
        com.tencent.mm.plugin.eggspring.b.b.a locala = com.tencent.mm.plugin.eggspring.b.b.oVx;
        ((MMAnimateView)localObject1).setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.cbc() + paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBgColor");
      if (!bs.isNullOrNil(paramBundle))
      {
        i = Color.parseColor(paramBundle);
        paramBundle = this.oVI;
        if (paramBundle == null) {
          k.aVY("rootLayout");
        }
        paramBundle.setBackgroundColor(i);
        setActionbarColor(i);
        Bc(i);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTile");
      if (!bs.isNullOrNil(paramBundle))
      {
        localObject1 = this.oVL;
        if (localObject1 == null) {
          k.aVY("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTileColor");
      if (!bs.isNullOrNil(paramBundle))
      {
        localObject1 = this.oVL;
        if (localObject1 == null) {
          k.aVY("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
        localObject1 = this.oVM;
        if (localObject1 == null) {
          k.aVY("bottomBrandClickableImg");
        }
        ((WeImageView)localObject1).setIconColor(Color.parseColor(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitle");
      if (!bs.isNullOrNil(paramBundle))
      {
        localObject1 = this.oVN;
        if (localObject1 == null) {
          k.aVY("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitleColor");
      if (!bs.isNullOrNil(paramBundle))
      {
        localObject1 = this.oVN;
        if (localObject1 == null) {
          k.aVY("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
      }
      paramBundle = this.oVZ;
      if (paramBundle == null) {
        k.aVY("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setImageResource(2131231321);
      paramBundle = this.oWb;
      if (paramBundle == null) {
        k.aVY("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setImageResource(2131231319);
      paramBundle = this.cpW;
      if (paramBundle == null) {
        k.aVY("uiHandler");
      }
      paramBundle.postDelayed(this.oWi, 3000L);
      this.oWe = System.currentTimeMillis();
      if (com.tencent.mm.sdk.platformtools.h.DEBUG)
      {
        paramBundle = findViewById(2131305173);
        k.g(paramBundle, "findViewById<Button>(R.id.start)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131305173)).setOnClickListener((View.OnClickListener)new g(this));
        paramBundle = findViewById(2131306309);
        k.g(paramBundle, "findViewById<Button>(R.id.video)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131306309)).setOnClickListener((View.OnClickListener)new h(this));
        paramBundle = findViewById(2131304110);
        k.g(paramBundle, "findViewById<Button>(R.id.reset)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131304110)).setOnClickListener((View.OnClickListener)new i(this));
      }
      com.tencent.mm.kernel.g.agi().a(2809, (com.tencent.mm.ak.g)this);
      com.tencent.mm.kernel.g.agi().a(2812, (com.tencent.mm.ak.g)this);
      this.hPI = getIntent().getStringExtra("SpringCard.KeyWord");
      this.appId = getIntent().getStringExtra("SpringCard.AppId");
      this.jyU = getIntent().getStringExtra("SpringCard.TraceId");
      if ((!bs.isNullOrNil(this.hPI)) && (!bs.isNullOrNil(this.appId)) && (!bs.isNullOrNil(this.jyU))) {
        break label1427;
      }
    }
    for (;;)
    {
      this.oWf = ((com.tencent.mm.app.n)new j(this));
      paramBundle = AppForegroundDelegate.cHM;
      localObject1 = this.oWf;
      if (localObject1 == null) {
        k.aVY("appForegroundLis");
      }
      paramBundle.a((com.tencent.mm.app.n)localObject1);
      AppMethodBeat.o(108179);
      return;
      paramBundle = this.oVO;
      if (paramBundle == null) {
        k.aVY("luckyBagLoadingImg");
      }
      paramBundle.setImageResource(2131232880);
      break;
      label1427:
      paramBundle = EmojiDebugUI.fOc;
      if (EmojiDebugUI.abL())
      {
        ac.d("MicroMsg.SpringCardActivity", "stop cgi!!!");
      }
      else
      {
        paramBundle = this.hPI;
        if (paramBundle == null) {
          k.fOy();
        }
        localObject1 = this.appId;
        if (localObject1 == null) {
          k.fOy();
        }
        localObject2 = this.jyU;
        if (localObject2 == null) {
          k.fOy();
        }
        paramBundle = new com.tencent.mm.plugin.eggspring.c.b(paramBundle, (String)localObject1, (String)localObject2);
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)paramBundle);
      }
    }
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108200);
    k.h(paramString, "mediaId");
    ac.d("MicroMsg.SpringCardActivity", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.oWd != null) && (this.oWc != null) && (k.g(this.oWc, paramString))) {
      ap.f((Runnable)new k(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108200);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(108183);
    super.onDestroy();
    Object localObject = this.oWc;
    if (localObject != null) {
      o.aJz().k((String)localObject, null);
    }
    if (this.oWm)
    {
      localObject = this.oWa;
      if (localObject == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIDestroy();
    }
    com.tencent.mm.kernel.g.agi().b(2809, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(2812, (com.tencent.mm.ak.g)this);
    ac.i("MicroMsg.SpringCardActivity", "videoInfo, count:[%s], rptCount:[%s], duration:[%s], curPoi:[%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.oWl), Integer.valueOf(this.duration), Integer.valueOf(this.oWk) });
    if (this.count >= 0)
    {
      this.oWj = (this.count * this.duration + this.oWk);
      localObject = com.tencent.mm.plugin.eggspring.a.oVi;
      localObject = com.tencent.mm.plugin.eggspring.a.cba();
      int i = this.duration;
      int j = this.oWl;
      int k = this.oWj;
      com.tencent.mm.plugin.report.service.h.wUl.f(18916, new Object[] { ((com.tencent.mm.plugin.eggspring.a)localObject).oVe, ((com.tencent.mm.plugin.eggspring.a)localObject).oVg, Integer.valueOf(16), "", Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    }
    for (;;)
    {
      localObject = AppForegroundDelegate.cHM;
      com.tencent.mm.app.n localn = this.oWf;
      if (localn == null) {
        k.aVY("appForegroundLis");
      }
      ((AppForegroundDelegate)localObject).b(localn);
      AppMethodBeat.o(108183);
      return;
      localObject = com.tencent.mm.plugin.eggspring.a.oVi;
      com.tencent.mm.plugin.eggspring.a.cba().Bb(16);
    }
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(108188);
    k.h(paramString, "filekey");
    ac.d("MicroMsg.SpringCardActivity", "onDownloadProgressChanged, fileKey [%s], finished [%s], total [%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(108188);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(108182);
    super.onPause();
    if (this.oWm)
    {
      SpringEggVideoView localSpringEggVideoView = this.oWa;
      if (localSpringEggVideoView == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      this.oWk = localSpringEggVideoView.getCurrPosMs();
      ac.d("MicroMsg.SpringCardActivity", "videoInfo, curPoi: [%s].", new Object[] { Integer.valueOf(this.oWk) });
      localSpringEggVideoView = this.oWa;
      if (localSpringEggVideoView == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      localSpringEggVideoView.onUIPause();
    }
    AppMethodBeat.o(108182);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(108181);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.eggspring.a.oVi;
    com.tencent.mm.plugin.eggspring.a.cba().Bb(1);
    if (this.oWm)
    {
      localObject = this.oWa;
      if (localObject == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIResume();
    }
    AppMethodBeat.o(108181);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(108184);
    k.h(paramn, "scene");
    ac.i("MicroMsg.SpringCardActivity", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject1;
    if (2809 == paramn.getType())
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 5);
        AppMethodBeat.o(108184);
        return;
      }
      if (this.oWn)
      {
        ac.i("MicroMsg.SpringCardActivity", "card is showing, return.");
        AppMethodBeat.o(108184);
        return;
      }
      this.oVD = ((com.tencent.mm.plugin.eggspring.c.b)paramn).oVD;
      if (this.oVD == null) {
        break label3226;
      }
      ac.i("MicroMsg.SpringCardActivity", "brandCardContent: %s.", new Object[] { String.valueOf(this.oVD) });
      paramString = com.tencent.mm.plugin.eggspring.a.oVi;
      paramn = com.tencent.mm.plugin.eggspring.a.cba();
      paramString = this.oVD;
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.oVw);
        paramn.oVg = paramString;
        if (this.oVD != null)
        {
          localObject1 = this.oVD;
          if (localObject1 != null)
          {
            if ((bs.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVm)) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVo == null)) {
              break label498;
            }
            paramString = com.tencent.mm.plugin.eggspring.a.oVi;
            com.tencent.mm.plugin.eggspring.a.cba().Bb(2);
            paramString = this.oVL;
            if (paramString == null) {
              k.aVY("bottomBrandClickableTxt");
            }
            paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVm);
            paramString = this.oVM;
            if (paramString == null) {
              k.aVY("bottomBrandClickableImg");
            }
            paramString.setVisibility(0);
            if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl) || (!bs.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVr))) {
              break label550;
            }
            ac.e("MicroMsg.SpringCardActivity", "red pocket type, accept url is invalid!!!");
          }
        }
      }
      for (;;)
      {
        paramString = this.oVD;
        if (paramString == null) {
          break label2594;
        }
        if (4 != paramString.oVl) {
          break label2470;
        }
        if (1 != paramString.oVu) {
          break label2167;
        }
        if (!bs.isNullOrNil(paramString.oVn))
        {
          paramn = paramString.oVn;
          if (paramn == null) {
            k.fOy();
          }
          if (!i.eA(Cw(paramn))) {
            break label2144;
          }
          paramn = this.oVZ;
          if (paramn == null) {
            k.aVY("brandCardBlessingStyleImgMedia");
          }
          localObject1 = paramString.oVn;
          if (localObject1 == null) {
            k.fOy();
          }
          paramn.setImageFilePath(Cw((String)localObject1));
          Bd(0);
        }
        label408:
        if (bs.isNullOrNil(paramString.oVt)) {
          break label2587;
        }
        paramn = paramString.oVt;
        if (paramn == null) {
          k.fOy();
        }
        if (!i.eA(Cw(paramn))) {
          break label2446;
        }
        paramn = this.oWb;
        if (paramn == null) {
          k.aVY("brandCardBlessingStyleBottomImg");
        }
        paramString = paramString.oVt;
        if (paramString == null) {
          k.fOy();
        }
        paramn.setImageFilePath(Cw(paramString));
        Bd(1);
        AppMethodBeat.o(108184);
        return;
        paramString = null;
        break;
        label498:
        if (((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVo == null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.e("MicroMsg.SpringCardActivity", "not support jump!!! jumpInfo==null? [%s].", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 8);
          break;
        }
        label550:
        if ((2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVs != null)) {
          break label579;
        }
        ac.e("MicroMsg.SpringCardActivity", "coupon type, couponInfo is null!!!");
      }
      label579:
      if (4 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl)
      {
        paramString = this.oVY;
        if (paramString == null) {
          k.aVY("brandCardBlessingStyleLayout");
        }
        f(paramString, ao.fromDPToPix((Context)getContext(), 144));
        paramString = this.oVZ;
        if (paramString == null) {
          k.aVY("brandCardBlessingStyleImgMedia");
        }
        paramString = (View)paramString;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVu) {
          break label3233;
        }
        paramString = this.oWa;
        if (paramString == null) {
          k.aVY("brandCardBlessingStyleVideoMedia");
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
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVv)
      {
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVu)
        {
          paramn = com.tencent.mm.plugin.eggspring.a.oVi;
          com.tencent.mm.plugin.eggspring.a.cba().Bb(6);
        }
        for (;;)
        {
          paramn = new RoundedCornerFrameLayout((Context)getContext());
          localObject2 = getContext();
          k.g(localObject2, "context");
          paramn.setRadius(((AppCompatActivity)localObject2).getResources().getDimension(2131165940));
          localObject2 = getContext();
          k.g(localObject2, "context");
          paramInt1 = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131165914);
          localObject2 = getContext();
          k.g(localObject2, "context");
          localObject2 = new RelativeLayout.LayoutParams(paramInt1, ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131165914));
          localObject3 = this.oWb;
          if (localObject3 == null) {
            k.aVY("brandCardBlessingStyleBottomImg");
          }
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((MMAnimateView)localObject3).getId());
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          localObject3 = this.oVY;
          if (localObject3 == null) {
            k.aVY("brandCardBlessingStyleLayout");
          }
          ((ViewGroup)localObject3).removeView(paramString);
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          paramString.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          paramn.addView(paramString, (ViewGroup.LayoutParams)localObject3);
          paramString = this.oVY;
          if (paramString == null) {
            k.aVY("brandCardBlessingStyleLayout");
          }
          paramString.addView((View)paramn, (ViewGroup.LayoutParams)localObject2);
          if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVu) {
            break;
          }
          paramString = this.oVZ;
          if (paramString == null) {
            k.aVY("brandCardBlessingStyleImgMedia");
          }
          paramString.setDefaultImageResource(2131231320);
          paramString = this.oVZ;
          if (paramString == null) {
            k.aVY("brandCardBlessingStyleImgMedia");
          }
          paramString.setImageResource(2131231320);
          break;
          paramn = com.tencent.mm.plugin.eggspring.a.oVi;
          com.tencent.mm.plugin.eggspring.a.cba().Bb(8);
        }
      }
      if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVv) {
        break;
      }
      if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVu)
      {
        paramn = com.tencent.mm.plugin.eggspring.a.oVi;
        com.tencent.mm.plugin.eggspring.a.cba().Bb(5);
      }
      for (;;)
      {
        paramn = this.oVY;
        if (paramn == null) {
          k.aVY("brandCardBlessingStyleLayout");
        }
        paramn.removeView(paramString);
        paramn = new RelativeLayout.LayoutParams(-2, -2);
        localObject1 = this.oWb;
        if (localObject1 == null) {
          k.aVY("brandCardBlessingStyleBottomImg");
        }
        paramn.addRule(2, ((MMAnimateView)localObject1).getId());
        paramn.addRule(14);
        localObject1 = this.oVY;
        if (localObject1 == null) {
          k.aVY("brandCardBlessingStyleLayout");
        }
        ((ViewGroup)localObject1).addView(paramString, (ViewGroup.LayoutParams)paramn);
        break;
        paramn = com.tencent.mm.plugin.eggspring.a.oVi;
        com.tencent.mm.plugin.eggspring.a.cba().Bb(7);
      }
      if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl) && (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl)) {
        break;
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandIcon");
      if (!bs.isNullOrNil(paramString))
      {
        paramn = this.oVR;
        if (paramn == null) {
          k.aVY("brandCardTitleLogo");
        }
        localObject2 = new StringBuilder();
        localObject3 = com.tencent.mm.plugin.eggspring.b.b.oVx;
        paramn.setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.cbc() + paramString);
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandName");
      if (!bs.isNullOrNil(paramString))
      {
        paramn = this.oVS;
        if (paramn == null) {
          k.aVY("brandCardTitleName");
        }
        paramn.setText((CharSequence)paramString);
      }
      paramString = "";
      paramn = "";
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl)
      {
        paramString = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverSubTitle");
        label1318:
        if (!bs.isNullOrNil(paramString))
        {
          localObject2 = this.oVT;
          if (localObject2 == null) {
            k.aVY("brandCardMainWording");
          }
          ((TextView)localObject2).setText((CharSequence)paramString);
        }
        if (!bs.isNullOrNil(paramn))
        {
          paramString = this.oVU;
          if (paramString == null) {
            k.aVY("brandCardSubWording");
          }
          paramString.setText((CharSequence)paramn);
        }
        if (!bs.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVp))
        {
          paramString = this.oVT;
          if (paramString == null) {
            k.aVY("brandCardMainWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVp);
        }
        if (!bs.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVq))
        {
          paramString = this.oVU;
          if (paramString == null) {
            k.aVY("brandCardSubWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVq);
        }
        paramString = this.oVW;
        if (paramString == null) {
          k.aVY("brandCardMediaLayout");
        }
        f(paramString, 0);
        paramString = this.oVW;
        if (paramString == null) {
          k.aVY("brandCardMediaLayout");
        }
        paramn = this.oVX;
        if (paramn == null) {
          k.aVY("brandCardImgMedia");
        }
        paramString.removeView((View)paramn);
        paramString = new RoundedCornerFrameLayout((Context)getContext());
        paramn = getContext();
        k.g(paramn, "context");
        paramString.setRadius(paramn.getResources().getDimension(2131165943));
        paramn = new RelativeLayout.LayoutParams(-2, -2);
        paramn.addRule(14);
        localObject2 = getContext();
        k.g(localObject2, "context");
        paramn.topMargin = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131165294);
        localObject2 = getContext();
        k.g(localObject2, "context");
        paramn.topMargin = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166159);
        localObject2 = this.oVW;
        if (localObject2 == null) {
          k.aVY("brandCardMediaLayout");
        }
        ((ViewGroup)localObject2).addView((View)paramString, (ViewGroup.LayoutParams)paramn);
        paramn = new FrameLayout.LayoutParams(-2, -2);
        if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl) {
          break label2010;
        }
        localObject1 = getContext();
        k.g(localObject1, "context");
        paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166752);
        localObject1 = getContext();
        k.g(localObject1, "context");
        paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166751);
        localObject1 = this.oVX;
        if (localObject1 == null) {
          k.aVY("brandCardImgMedia");
        }
        ((MMAnimateView)localObject1).setImageResource(2131233816);
        localObject1 = this.oVV;
        if (localObject1 == null) {
          k.aVY("brandCardAcceptBtn");
        }
        ((Button)localObject1).setText(2131755116);
        localObject1 = com.tencent.mm.plugin.eggspring.a.oVi;
        com.tencent.mm.plugin.eggspring.a.cba().Bb(3);
      }
      for (;;)
      {
        localObject1 = this.oVX;
        if (localObject1 == null) {
          k.aVY("brandCardImgMedia");
        }
        paramString.addView((View)localObject1, (ViewGroup.LayoutParams)paramn);
        paramString = this.oVQ;
        if (paramString == null) {
          k.aVY("brandCardTitleLayout");
        }
        paramString.setVisibility(0);
        paramString = this.oVT;
        if (paramString == null) {
          k.aVY("brandCardMainWording");
        }
        paramString.setVisibility(0);
        paramString = this.oVU;
        if (paramString == null) {
          k.aVY("brandCardSubWording");
        }
        paramString.setVisibility(0);
        paramString = this.oVV;
        if (paramString == null) {
          k.aVY("brandCardAcceptBtn");
        }
        paramString.setVisibility(0);
        paramString = this.oVW;
        if (paramString == null) {
          k.aVY("brandCardMediaLayout");
        }
        paramString.setVisibility(0);
        paramString = this.oVY;
        if (paramString == null) {
          k.aVY("brandCardBlessingStyleLayout");
        }
        paramString.setVisibility(8);
        break;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl) {
          break label1318;
        }
        paramString = getIntent().getStringExtra("SpringCard.BrandCouponMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandCouponSubTitle");
        break label1318;
        label2010:
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).oVl)
        {
          localObject1 = getContext();
          k.g(localObject1, "context");
          paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166077);
          localObject1 = getContext();
          k.g(localObject1, "context");
          paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166076);
          localObject1 = this.oVX;
          if (localObject1 == null) {
            k.aVY("brandCardImgMedia");
          }
          ((MMAnimateView)localObject1).setImageResource(2131231861);
          localObject1 = this.oVV;
          if (localObject1 == null) {
            k.aVY("brandCardAcceptBtn");
          }
          ((Button)localObject1).setText(2131755113);
          localObject1 = com.tencent.mm.plugin.eggspring.a.oVi;
          com.tencent.mm.plugin.eggspring.a.cba().Bb(4);
        }
      }
      label2144:
      paramn = paramString.oVn;
      if (paramn == null) {
        k.fOy();
      }
      Xs(paramn);
      break label408;
      label2167:
      if (2 != paramString.oVu) {
        break label408;
      }
      paramn = this.oVZ;
      if (paramn == null) {
        k.aVY("brandCardBlessingStyleImgMedia");
      }
      paramn.setVisibility(8);
      paramn = this.oWa;
      if (paramn == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      paramn.setVisibility(0);
      this.oWm = true;
      paramn = this.oVD;
      if ((paramn == null) || (bs.isNullOrNil(paramn.oVn))) {
        break label408;
      }
      localObject1 = this.oWa;
      if (localObject1 == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setLoop(true);
      localObject1 = this.oWa;
      if (localObject1 == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMVideoViewCallback((h.b)this);
      localObject1 = this.oWa;
      if (localObject1 == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMDownloadFinish((com.tencent.mm.pluginsdk.ui.h.a)this);
      localObject1 = this.oWa;
      if (localObject1 == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this);
      localObject1 = this.oWa;
      if (localObject1 == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).c(false, paramn.oVn, 0);
      localObject1 = this.oWa;
      if (localObject1 == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      paramn = paramn.oVn;
      if (paramn == null) {
        k.fOy();
      }
      ((SpringEggVideoView)localObject1).setFilepath(Xt(paramn));
      paramn = this.oWa;
      if (paramn == null) {
        k.aVY("brandCardBlessingStyleVideoMedia");
      }
      paramn.start();
      break label408;
      paramString = paramString.oVt;
      if (paramString == null) {
        k.fOy();
      }
      Xs(paramString);
      AppMethodBeat.o(108184);
      return;
      label2470:
      if (((1 == paramString.oVl) || (2 == paramString.oVl)) && (!bs.isNullOrNil(paramString.oVn)))
      {
        paramn = paramString.oVn;
        if (paramn == null) {
          k.fOy();
        }
        if (i.eA(Cw(paramn)))
        {
          paramn = this.oVX;
          if (paramn == null) {
            k.aVY("brandCardImgMedia");
          }
          paramString = paramString.oVn;
          if (paramString == null) {
            k.fOy();
          }
          paramn.setImageFilePath(Cw(paramString));
          cbd();
          AppMethodBeat.o(108184);
          return;
        }
        paramString = paramString.oVn;
        if (paramString == null) {
          k.fOy();
        }
        Xs(paramString);
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
          paramString = com.tencent.mm.plugin.eggspring.a.oVi;
          com.tencent.mm.plugin.eggspring.a.cba().Bb(14);
          com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 6);
          paramString = (Context)getContext();
          paramn = getContext();
          k.g(paramn, "context");
          t.ci(paramString, paramn.getResources().getString(2131764540));
          AppMethodBeat.o(108184);
          return;
        }
        paramString = (com.tencent.mm.plugin.eggspring.c.a)paramn;
        paramn = paramString.oVA;
        ac.i("MicroMsg.SpringCardActivity", "coupon, retCode: %s, retMsg: %s.", new Object[] { paramn, paramString.oVB });
        if (paramn != null)
        {
          long l = ((Number)paramn).longValue();
          if (0L == l)
          {
            paramString = com.tencent.mm.plugin.eggspring.a.oVi;
            com.tencent.mm.plugin.eggspring.a.cba().Bb(13);
            paramString = (Context)getContext();
            paramn = getContext();
            k.g(paramn, "context");
            t.ch(paramString, paramn.getResources().getString(2131755117));
            paramString = this.oVV;
            if (paramString == null) {
              k.aVY("brandCardAcceptBtn");
            }
            paramString.setText(2131755115);
            paramString = this.oVV;
            if (paramString == null) {
              k.aVY("brandCardAcceptBtn");
            }
            paramString.setEnabled(false);
          }
          for (;;)
          {
            if (l != 0L)
            {
              paramString = com.tencent.mm.plugin.eggspring.a.oVi;
              com.tencent.mm.plugin.eggspring.a.cba().Bb(14);
              com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 6);
            }
            AppMethodBeat.o(108184);
            return;
            if ((268456656L == l) || (268457508L == l) || (268456641L == l) || (268456640L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              k.g(paramn, "context");
              t.ci(paramString, paramn.getResources().getString(2131757954));
              paramString = this.oVV;
              if (paramString == null) {
                k.aVY("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.oVV;
              if (paramString == null) {
                k.aVY("brandCardAcceptBtn");
              }
              paramString.setEnabled(false);
            }
            else if ((268456461L == l) || (268455949L == l) || (268456007L == l) || (268456320L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              k.g(paramn, "context");
              t.ci(paramString, paramn.getResources().getString(2131756775));
              paramString = this.oVV;
              if (paramString == null) {
                k.aVY("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.oVV;
              if (paramString == null) {
                k.aVY("brandCardAcceptBtn");
              }
              paramString.setEnabled(false);
            }
            else if ((270100487L == l) || (270100488L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              k.g(paramn, "context");
              t.ci(paramString, paramn.getResources().getString(2131764540));
            }
            else
            {
              ac.i("MicroMsg.SpringCardActivity", "other err![%s]", new Object[] { paramn });
              paramString = (Context)getContext();
              paramn = getContext();
              k.g(paramn, "context");
              t.ci(paramString, paramn.getResources().getString(2131756775));
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
  
  public final void q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108195);
    k.h(paramString1, "mediaId");
    k.h(paramString2, "path");
    k.h(paramString3, "url");
    this.oWc = paramString1;
    if (i.eA(PluginEggSpring.oUY + "MMVideo_" + paramString3.hashCode() + ".mp4"))
    {
      a(paramString1, 0, null);
      AppMethodBeat.o(108195);
      return;
    }
    e locale = o.aJz();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = paramString1;
    localh.url = paramString3;
    localh.frw = 1;
    localh.frr = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString2;
    localh.frE = ((com.tencent.mm.i.h.a)this);
    locale.a(localh, false);
    AppMethodBeat.o(108195);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108197);
    String str = this.oWc;
    if (str != null)
    {
      if (k.g(str, paramString))
      {
        o.aJz();
        e.p(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(108197);
      return;
    }
    AppMethodBeat.o(108197);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108165);
      if (SpringCardActivity.q(this.oWq).getVisibility() == 0)
      {
        paramView = com.tencent.mm.plugin.eggspring.a.oVi;
        com.tencent.mm.plugin.eggspring.a.cba().Bb(10);
        paramView = (Context)this.oWq;
        com.tencent.mm.plugin.eggspring.b.a locala = SpringCardActivity.r(this.oWq);
        if (locala == null) {
          k.fOy();
        }
        com.tencent.mm.plugin.eggspring.d.a.a(paramView, locala.oVo);
      }
      AppMethodBeat.o(108165);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108166);
      paramView = SpringCardActivity.r(this.oWq);
      if (paramView != null)
      {
        switch (paramView.oVl)
        {
        }
        do
        {
          AppMethodBeat.o(108166);
          return;
          if (!bs.isNullOrNil(paramView.oVr))
          {
            localObject = com.tencent.mm.plugin.eggspring.a.oVi;
            com.tencent.mm.plugin.eggspring.a.cba().Bb(11);
            ac.d("MicroMsg.SpringCardActivity", "acceptRedPocketCoverUrl: %s.", new Object[] { paramView.oVr });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramView.oVr);
            com.tencent.mm.br.d.b((Context)this.oWq.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(108166);
            return;
          }
          ac.e("MicroMsg.SpringCardActivity", "red pocket cover accept url is invalid, impossible!!!");
          AppMethodBeat.o(108166);
          return;
          paramView = paramView.oVs;
        } while (paramView == null);
        Object localObject = com.tencent.mm.plugin.eggspring.a.oVi;
        com.tencent.mm.plugin.eggspring.a.cba().Bb(12);
        paramView = new com.tencent.mm.plugin.eggspring.c.a(paramView);
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)paramView);
        AppMethodBeat.o(108166);
        return;
      }
      AppMethodBeat.o(108166);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(SpringCardActivity paramSpringCardActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(162211);
      this.oWq.finish();
      AppMethodBeat.o(162211);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(160272);
      if (SpringCardActivity.r(this.oWq) != null)
      {
        localObject = SpringCardActivity.r(this.oWq);
        if (localObject == null) {
          k.fOy();
        }
        if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).oVl == 4) || (SpringCardActivity.g(this.oWq).getVisibility() != 0))
        {
          localObject = SpringCardActivity.r(this.oWq);
          if (localObject == null) {
            k.fOy();
          }
          if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).oVl != 4) || (SpringCardActivity.x(this.oWq)) || (SpringCardActivity.y(this.oWq))) {
            break label117;
          }
        }
      }
      Object localObject = com.tencent.mm.plugin.eggspring.a.oVi;
      com.tencent.mm.plugin.eggspring.a.cba().Bb(9);
      com.tencent.mm.plugin.report.service.h.wUl.dB(1263, 7);
      label117:
      SpringCardActivity.a(this.oWq);
      AppMethodBeat.o(160272);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(SpringCardActivity paramSpringCardActivity, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(108169);
      if (SpringCardActivity.j(this.oWq))
      {
        AppMethodBeat.o(108169);
        return;
      }
      com.tencent.mm.plugin.eggspring.b.a locala = SpringCardActivity.r(this.oWq);
      if (locala != null)
      {
        if ((k.g(paramString, locala.oVn)) && ((1 == locala.oVl) || (2 == locala.oVl) || ((4 == locala.oVl) && (2 != locala.oVu))))
        {
          ac.d("MicroMsg.SpringCardActivity", "onC2CDownloadCompleted, filekey: [%s], cardType: [%s].", new Object[] { paramString, Integer.valueOf(locala.oVl) });
          if (4 == locala.oVl)
          {
            SpringCardActivity.i(this.oWq).setImageFilePath(SpringCardActivity.Xv(paramString));
            SpringCardActivity.c(this.oWq, 0);
            AppMethodBeat.o(108169);
            return;
          }
          if ((1 == locala.oVl) || (2 == locala.oVl))
          {
            SpringCardActivity.t(this.oWq).setImageFilePath(SpringCardActivity.Xv(paramString));
            SpringCardActivity.u(this.oWq);
          }
          AppMethodBeat.o(108169);
          return;
        }
        if ((k.g(paramString, locala.oVt)) && (4 == locala.oVl))
        {
          SpringCardActivity.v(this.oWq).setImageFilePath(SpringCardActivity.Xv(paramString));
          SpringCardActivity.c(this.oWq, 1);
        }
        AppMethodBeat.o(108169);
        return;
      }
      AppMethodBeat.o(108169);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108170);
      SpringCardActivity.a(this.oWq);
      AppMethodBeat.o(108170);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108171);
      SpringCardActivity.b(this.oWq).setVisibility(8);
      SpringCardActivity.c(this.oWq).setVisibility(8);
      SpringCardActivity.d(this.oWq).setVisibility(8);
      SpringCardActivity.e(this.oWq).setVisibility(8);
      SpringCardActivity.f(this.oWq).setVisibility(8);
      SpringCardActivity.g(this.oWq).setVisibility(0);
      SpringCardActivity.h(this.oWq).setLoop(true);
      SpringCardActivity.h(this.oWq).setIMMVideoViewCallback((h.b)this.oWq);
      SpringCardActivity.h(this.oWq).setIMMDownloadFinish((com.tencent.mm.pluginsdk.ui.h.a)this.oWq);
      SpringCardActivity.h(this.oWq).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.oWq);
      SpringCardActivity.h(this.oWq).c(false, "http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023", 0);
      SpringCardActivity.h(this.oWq).setFilepath(SpringCardActivity.Xu("http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023"));
      SpringCardActivity.h(this.oWq).start();
      SpringCardActivity.i(this.oWq).setVisibility(8);
      SpringCardActivity.h(this.oWq).setVisibility(0);
      AppMethodBeat.o(108171);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108172);
      SpringCardActivity.k(this.oWq);
      SpringCardActivity.l(this.oWq).setVisibility(0);
      SpringCardActivity.m(this.oWq).setVisibility(4);
      AppMethodBeat.o(108172);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$4", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-eggspring_release"})
  public static final class j
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(162213);
      ac.d("MicroMsg.SpringCardActivity", "onAppBackground");
      if (SpringCardActivity.n(this.oWq))
      {
        SpringCardActivity.a(this.oWq, SpringCardActivity.o(this.oWq) - 1);
        SpringCardActivity.b(this.oWq, SpringCardActivity.p(this.oWq) - 1);
      }
      AppMethodBeat.o(162213);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(162212);
      ac.d("MicroMsg.SpringCardActivity", "onAppForeground");
      AppMethodBeat.o(162212);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108173);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.oWq);
      if (locala == null) {
        k.fOy();
      }
      locala.onDataAvailable(paramString, paramLong1, this.oWu);
      AppMethodBeat.o(108173);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(SpringCardActivity paramSpringCardActivity, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(108174);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.oWq);
      if (locala == null) {
        k.fOy();
      }
      locala.aq(paramString, paramInt);
      AppMethodBeat.o(108174);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(160273);
      SpringCardActivity.a(this.oWq);
      AppMethodBeat.o(160273);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(SpringCardActivity paramSpringCardActivity, String paramString1, long paramLong1, long paramLong2, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108175);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.oWq);
      if (locala == null) {
        k.fOy();
      }
      locala.qq(paramLong1);
      AppMethodBeat.o(108175);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108176);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.oWq);
      if (locala == null) {
        k.fOy();
      }
      locala.i(paramString, paramLong1, this.oWx);
      AppMethodBeat.o(108176);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$playCardAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-eggspring_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(108177);
      ac.d("MicroMsg.SpringCardActivity", "onAnimationEnd");
      SpringCardActivity.l(this.oWq).setVisibility(8);
      paramAnimator = com.tencent.mm.plugin.eggspring.a.oVi;
      paramAnimator = com.tencent.mm.plugin.eggspring.a.cba();
      long l1 = System.currentTimeMillis();
      long l2 = SpringCardActivity.s(this.oWq);
      com.tencent.mm.plugin.report.service.h.wUl.f(18916, new Object[] { paramAnimator.oVe, paramAnimator.oVg, Integer.valueOf(15), Long.valueOf(l1 - l2) });
      AppMethodBeat.o(108177);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(108178);
      ac.d("MicroMsg.SpringCardActivity", "onAnimationStart");
      AppMethodBeat.o(108178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity
 * JD-Core Version:    0.7.0.1
 */