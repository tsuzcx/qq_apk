package com.tencent.mm.plugin.eggspring.ui;

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
import com.tencent.mm.al.q;
import com.tencent.mm.ao.e;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "appId", "", "blessingBtmImgReady", "", "blessingTopImgReady", "bottomBrandBgImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "bottomBrandClickableImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomBrandClickableTxt", "Landroid/widget/TextView;", "bottomBrandClickableTxtLayout", "Landroid/view/View;", "bottomBrandIntroTxt", "brandCardAcceptBtn", "Landroid/widget/Button;", "brandCardBlessingStyleBottomImg", "brandCardBlessingStyleImgMedia", "brandCardBlessingStyleLayout", "Landroid/view/ViewGroup;", "brandCardBlessingStyleVideoMedia", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "brandCardImgMedia", "brandCardLayout", "brandCardMainWording", "brandCardMediaLayout", "brandCardSubWording", "brandCardTitleLayout", "brandCardTitleLogo", "brandCardTitleName", "cardIsShowing", "count", "", "curPoi", "duration", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "fireWorksColor", "", "isVideo", "keyWord", "lastShowCardRunnable", "Ljava/lang/Runnable;", "loadingAnimTimerStartMS", "", "luckyBagLoadingImg", "rootLayout", "rptCount", "sum", "traceId", "uiHandler", "Landroid/os/Handler;", "videoMediaId", "addFireWorks", "", "parent", "offset", "adjustCloseBtnColor", "color", "againConfigView", "boundView", "changeCardStyle", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "dealWithMedia", "downLoadImg", "getCachePath", "getFireworksColor", "getLayoutId", "getRandomByRange", "low", "high", "getSavePath", "getTempPath", "imgExist", "initBar", "initConfigView", "initVideoView", "isVideoDataAvailable", "length", "onBlessingMediaReady", "type", "onC2CDownloadCompleted", "filekey", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataAvailable", "onDestroy", "onDownloadFinish", "isPlayNow", "onDownloadProgressChanged", "finished", "total", "tryshow", "onError", "sessionId", "errorMsg", "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMediaReady", "onMoovReady", "svrflag", "onPause", "onPrepared", "onProgress", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "playCardAnim", "requestBrandCardContent", "requestVideoData", "setIEngineCallback", "callback", "startHttpStream", "stop", "Companion", "plugin-eggspring_release"})
public final class SpringCardActivity
  extends MMActivity
  implements CdnLogic.DownloadCallback, com.tencent.mm.al.g, com.tencent.mm.i.h.a, com.tencent.mm.modelvideo.b, com.tencent.mm.pluginsdk.ui.h.a, h.b
{
  public static final SpringCardActivity.a osP;
  private String appId;
  private int count;
  private Handler csO;
  private int duration;
  private String hpg;
  private String iYE;
  private SpringEggVideoView osA;
  private MMAnimateView osB;
  private String osC;
  private com.tencent.mm.modelvideo.b.a osD;
  private long osE;
  private com.tencent.mm.app.n osF;
  private boolean osG;
  private boolean osH;
  private final Runnable osI;
  private int osJ;
  private int osK;
  private int osL;
  private boolean osM;
  private boolean osN;
  private final int[] osO;
  private com.tencent.mm.plugin.eggspring.b.a osd;
  private ViewGroup osi;
  private MMAnimateView osj;
  private View osk;
  private TextView osl;
  private WeImageView osm;
  private TextView osn;
  private MMAnimateView oso;
  private ViewGroup osp;
  private View osq;
  private MMAnimateView osr;
  private TextView oss;
  private TextView ost;
  private TextView osu;
  private Button osv;
  private ViewGroup osw;
  private MMAnimateView osx;
  private ViewGroup osy;
  private MMAnimateView osz;
  
  static
  {
    AppMethodBeat.i(108208);
    osP = new SpringCardActivity.a((byte)0);
    AppMethodBeat.o(108208);
  }
  
  public SpringCardActivity()
  {
    AppMethodBeat.i(108207);
    this.osI = ((Runnable)new e(this));
    this.duration = -1;
    this.count = -1;
    this.osJ = -1;
    this.osK = -1;
    this.osO = new int[] { 2131100372, 2131100373, 2131100374 };
    AppMethodBeat.o(108207);
  }
  
  private final void Ak(int paramInt)
  {
    AppMethodBeat.i(162214);
    if (am.XC(paramInt))
    {
      updateBackBtn(am.i((Context)this, 2131690535, -1));
      AppMethodBeat.o(162214);
      return;
    }
    updateBackBtn(am.i((Context)this, 2131690535, -16777216));
    AppMethodBeat.o(162214);
  }
  
  private final void Al(int paramInt)
  {
    AppMethodBeat.i(160274);
    if (paramInt == 0)
    {
      this.osG = true;
      if (!this.osH) {}
    }
    for (;;)
    {
      bTP();
      do
      {
        do
        {
          AppMethodBeat.o(160274);
          return;
        } while (1 != paramInt);
        this.osH = true;
        if (this.osG) {
          break;
        }
      } while (!this.osM);
    }
  }
  
  private final void Tg(String paramString)
  {
    AppMethodBeat.i(108185);
    Object localObject = EmojiDebugUI.fKw;
    if (EmojiDebugUI.aaN())
    {
      ad.d("MicroMsg.SpringCardActivity", "stop cdn!!!");
      AppMethodBeat.o(108185);
      return;
    }
    localObject = new CdnLogic.C2CDownloadRequest();
    ((CdnLogic.C2CDownloadRequest)localObject).fileKey = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).url = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).setSavePath(yr(paramString));
    CdnLogic.startHttpsDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.DownloadCallback)this);
    AppMethodBeat.o(108185);
  }
  
  private static String Th(String paramString)
  {
    AppMethodBeat.i(108187);
    paramString = PluginEggSpring.ory + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(108187);
    return paramString;
  }
  
  private final void bTP()
  {
    AppMethodBeat.i(160275);
    Handler localHandler = this.csO;
    if (localHandler == null) {
      k.aPZ("uiHandler");
    }
    localHandler.removeCallbacks(this.osI);
    if (this.osN)
    {
      AppMethodBeat.o(160275);
      return;
    }
    long l = System.currentTimeMillis() - this.osE;
    if (l > 1000L)
    {
      bTQ();
      AppMethodBeat.o(160275);
      return;
    }
    localHandler = this.csO;
    if (localHandler == null) {
      k.aPZ("uiHandler");
    }
    localHandler.postDelayed((Runnable)new SpringCardActivity.m(this), 1000L - l);
    AppMethodBeat.o(160275);
  }
  
  private final void bTQ()
  {
    AppMethodBeat.i(160276);
    this.osN = true;
    Object localObject1 = this.osp;
    if (localObject1 == null) {
      k.aPZ("brandCardLayout");
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
    localObject6 = this.osp;
    if (localObject6 == null) {
      k.aPZ("brandCardLayout");
    }
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(localObject6, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localObject4, localObject5 });
    k.g(localObject1, "animator");
    ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ObjectAnimator)localObject1).setDuration(500L).start();
    ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)new SpringCardActivity.p(this));
    AppMethodBeat.o(160276);
  }
  
  private final int bTR()
  {
    AppMethodBeat.i(108204);
    int i = this.osO[new java.util.Random().nextInt(this.osO.length)];
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
    localObject1 = d.k.h.a((d.k.b)d.k.h.kJ(0, 4), 3);
    int i = ((d.k.b)localObject1).JhH;
    int n = ((d.k.b)localObject1).JhI;
    int i1 = ((d.k.b)localObject1).jzV;
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
            ((WeImageView)localObject1).setIconColor(((AppCompatActivity)localObject2).getResources().getColor(bTR()));
            localObject2 = getContext();
            k.g(localObject2, "context");
            int i2 = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166302);
            localObject2 = getContext();
            k.g(localObject2, "context");
            localObject2 = new RelativeLayout.LayoutParams(i2, ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166301));
            i2 = fc(i * k, (i + 1) * k);
            int i3 = fc(j * m, (j + 1) * m) + paramInt;
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
  
  private static int fc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108205);
    paramInt1 = (int)(paramInt1 + Math.random() * (paramInt2 - paramInt1));
    AppMethodBeat.o(108205);
    return paramInt1;
  }
  
  private static String yr(String paramString)
  {
    AppMethodBeat.i(108186);
    paramString = PluginEggSpring.ory + '/' + paramString.hashCode();
    AppMethodBeat.o(108186);
    return paramString;
  }
  
  public final void a(com.tencent.mm.modelvideo.b.a parama)
  {
    this.osD = parama;
  }
  
  public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(108202);
    k.h(paramString, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onFinish!!! mediaId[%s].", new Object[] { paramString });
    if ((this.osD != null) && (this.osC != null) && (k.g(this.osC, paramString))) {
      aq.f((Runnable)new l(this, paramString, paramInt));
    }
    AppMethodBeat.o(108202);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(204988);
    k.h(paramString1, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.osD != null) && (this.osC != null) && (k.g(this.osC, paramString1))) {
      aq.f((Runnable)new n(this, paramString1, paramLong1, paramLong2, paramString2));
    }
    AppMethodBeat.o(204988);
  }
  
  public final void aH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108194);
    if (paramString != null)
    {
      String str = d.n.n.h(paramString, ".temp", "", false);
      if ((!i.eK(str)) && (d.n.n.mB(paramString, ".temp"))) {
        i.lC(paramString, str);
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
    com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 10);
    paramString1 = this.osz;
    if (paramString1 == null) {
      k.aPZ("brandCardBlessingStyleImgMedia");
    }
    paramString1.setVisibility(0);
    paramString1 = this.osA;
    if (paramString1 == null) {
      k.aPZ("brandCardBlessingStyleVideoMedia");
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
  
  public final void db(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160277);
    ad.d("MicroMsg.SpringCardActivity", "onPrepared!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160277);
  }
  
  public final void dc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108191);
    ad.d("MicroMsg.SpringCardActivity", "onVideoEnded!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108191);
  }
  
  public final void dd(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160279);
    ad.d("MicroMsg.SpringCardActivity", "onVideoPause!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160279);
  }
  
  public final void de(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160280);
    paramString1 = this.osA;
    if (paramString1 == null) {
      k.aPZ("brandCardBlessingStyleVideoMedia");
    }
    ad.d("MicroMsg.SpringCardActivity", "onVideoPlay!!! mediaId[%s], duration[%s].", new Object[] { paramString2, Integer.valueOf(paramString1.getVideoDurationSec()) });
    if (this.duration <= 0)
    {
      paramString1 = this.osA;
      if (paramString1 == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      this.duration = (paramString1.getVideoDurationSec() * 1000);
    }
    this.count += 1;
    this.osL += 1;
    ad.d("MicroMsg.SpringCardActivity", "videoInfo count: [%s] rptCount: [%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.osL) });
    AppMethodBeat.o(160280);
  }
  
  public final void dg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108192);
    ad.d("MicroMsg.SpringCardActivity", "onVideoWaiting!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108192);
  }
  
  public final void dh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108193);
    ad.d("MicroMsg.SpringCardActivity", "onVideoWaitingEnd!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108193);
  }
  
  public final void fy(String paramString)
  {
    AppMethodBeat.i(108196);
    k.h(paramString, "mediaId");
    String str = this.osC;
    if (str != null)
    {
      if (k.g(str, paramString)) {
        o.aCJ().k(paramString, null);
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
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(108198);
    ad.d("MicroMsg.SpringCardActivity", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.osC;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (k.g(str, paramString)) {
        bool1 = o.aCJ().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      }
    }
    AppMethodBeat.o(108198);
    return bool1;
  }
  
  public final void jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(204987);
    ad.d("MicroMsg.SpringCardActivity", "onVideoFirstFrameDraw!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(204987);
  }
  
  public final void k(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108201);
    k.h(paramString, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onProgress!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.osD != null) && (this.osC != null) && (k.g(this.osC, paramString))) {
      aq.f((Runnable)new o(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108201);
  }
  
  public final void onC2CDownloadCompleted(final String paramString, CdnLogic.C2CDownloadResult paramC2CDownloadResult)
  {
    AppMethodBeat.i(108189);
    k.h(paramString, "filekey");
    k.h(paramC2CDownloadResult, "result");
    if (paramC2CDownloadResult.errorCode != 0)
    {
      com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 9);
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
    this.csO = new Handler(getMainLooper());
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new SpringCardActivity.d(this), 2131690535);
    paramBundle = getContext();
    k.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131100950);
    setActionbarColor(i);
    Ak(i);
    hideActionbarLine();
    paramBundle = getWindow();
    k.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    k.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(2050);
    paramBundle = findViewById(2131304246);
    k.g(paramBundle, "findViewById(R.id.root_layout)");
    this.osi = ((ViewGroup)paramBundle);
    paramBundle = findViewById(2131297434);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_bg_img)");
    this.osj = ((MMAnimateView)paramBundle);
    paramBundle = findViewById(2131297437);
    k.g(paramBundle, "findViewById(R.id.bottom…and_clickable_txt_layout)");
    this.osk = paramBundle;
    paramBundle = this.osk;
    if (paramBundle == null) {
      k.aPZ("bottomBrandClickableTxtLayout");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(2131297436);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_click_txt)");
    this.osl = ((TextView)paramBundle);
    paramBundle = findViewById(2131297435);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_click_img)");
    this.osm = ((WeImageView)paramBundle);
    paramBundle = findViewById(2131297438);
    k.g(paramBundle, "findViewById(R.id.bottom_brand_intro_txt)");
    this.osn = ((TextView)paramBundle);
    paramBundle = findViewById(2131301713);
    k.g(paramBundle, "findViewById(R.id.lucky_bag_loading_img)");
    this.oso = ((MMAnimateView)paramBundle);
    Object localObject1;
    Object localObject2;
    if (i.eK(PluginEggSpring.orz))
    {
      paramBundle = this.oso;
      if (paramBundle == null) {
        k.aPZ("luckyBagLoadingImg");
      }
      paramBundle.setImageFilePath(PluginEggSpring.orz);
      paramBundle = findViewById(2131297500);
      k.g(paramBundle, "findViewById(R.id.brand_card_layout)");
      this.osp = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297504);
      k.g(paramBundle, "findViewById(R.id.brand_card_title_layout)");
      this.osq = paramBundle;
      paramBundle = findViewById(2131297505);
      k.g(paramBundle, "findViewById(R.id.brand_card_title_logo)");
      this.osr = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297506);
      k.g(paramBundle, "findViewById(R.id.brand_card_title_name)");
      this.oss = ((TextView)paramBundle);
      paramBundle = findViewById(2131297501);
      k.g(paramBundle, "findViewById(R.id.brand_card_main_wording)");
      this.ost = ((TextView)paramBundle);
      paramBundle = findViewById(2131297503);
      k.g(paramBundle, "findViewById(R.id.brand_card_sub_wording)");
      this.osu = ((TextView)paramBundle);
      paramBundle = findViewById(2131297494);
      k.g(paramBundle, "findViewById(R.id.brand_card_accept_btn)");
      this.osv = ((Button)paramBundle);
      paramBundle = this.osv;
      if (paramBundle == null) {
        k.aPZ("brandCardAcceptBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      paramBundle = findViewById(2131297502);
      k.g(paramBundle, "findViewById(R.id.brand_card_media_layout)");
      this.osw = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297499);
      k.g(paramBundle, "findViewById(R.id.brand_card_img_media)");
      this.osx = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297497);
      k.g(paramBundle, "findViewById(R.id.brand_…rd_blessing_style_layout)");
      this.osy = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297496);
      k.g(paramBundle, "findViewById(R.id.brand_…blessing_style_img_media)");
      this.osz = ((MMAnimateView)paramBundle);
      paramBundle = this.osz;
      if (paramBundle == null) {
        k.aPZ("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setDefaultImageResource(2131231321);
      paramBundle = findViewById(2131297498);
      k.g(paramBundle, "findViewById(R.id.brand_…essing_style_video_media)");
      this.osA = ((SpringEggVideoView)paramBundle);
      paramBundle = findViewById(2131297495);
      k.g(paramBundle, "findViewById(R.id.brand_…lessing_style_bottom_img)");
      this.osB = ((MMAnimateView)paramBundle);
      paramBundle = this.osB;
      if (paramBundle == null) {
        k.aPZ("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setDefaultImageResource(2131231319);
      ad.d("MicroMsg.SpringCardActivity", "init config view.");
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBtmImg");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.osj;
        if (localObject1 == null) {
          k.aPZ("bottomBrandBgImg");
        }
        localObject2 = new StringBuilder();
        com.tencent.mm.plugin.eggspring.b.b.a locala = com.tencent.mm.plugin.eggspring.b.b.orX;
        ((MMAnimateView)localObject1).setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.bTO() + paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBgColor");
      if (!bt.isNullOrNil(paramBundle))
      {
        i = Color.parseColor(paramBundle);
        paramBundle = this.osi;
        if (paramBundle == null) {
          k.aPZ("rootLayout");
        }
        paramBundle.setBackgroundColor(i);
        setActionbarColor(i);
        Ak(i);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTile");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.osl;
        if (localObject1 == null) {
          k.aPZ("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTileColor");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.osl;
        if (localObject1 == null) {
          k.aPZ("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
        localObject1 = this.osm;
        if (localObject1 == null) {
          k.aPZ("bottomBrandClickableImg");
        }
        ((WeImageView)localObject1).setIconColor(Color.parseColor(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitle");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.osn;
        if (localObject1 == null) {
          k.aPZ("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitleColor");
      if (!bt.isNullOrNil(paramBundle))
      {
        localObject1 = this.osn;
        if (localObject1 == null) {
          k.aPZ("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
      }
      paramBundle = this.osz;
      if (paramBundle == null) {
        k.aPZ("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setImageResource(2131231321);
      paramBundle = this.osB;
      if (paramBundle == null) {
        k.aPZ("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setImageResource(2131231319);
      paramBundle = this.csO;
      if (paramBundle == null) {
        k.aPZ("uiHandler");
      }
      paramBundle.postDelayed(this.osI, 3000L);
      this.osE = System.currentTimeMillis();
      if (com.tencent.mm.sdk.platformtools.h.DEBUG)
      {
        paramBundle = findViewById(2131305173);
        k.g(paramBundle, "findViewById<Button>(R.id.start)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131305173)).setOnClickListener((View.OnClickListener)new SpringCardActivity.g(this));
        paramBundle = findViewById(2131306309);
        k.g(paramBundle, "findViewById<Button>(R.id.video)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131306309)).setOnClickListener((View.OnClickListener)new h(this));
        paramBundle = findViewById(2131304110);
        k.g(paramBundle, "findViewById<Button>(R.id.reset)");
        ((Button)paramBundle).setVisibility(0);
        ((Button)findViewById(2131304110)).setOnClickListener((View.OnClickListener)new i(this));
      }
      com.tencent.mm.kernel.g.aeS().a(2809, (com.tencent.mm.al.g)this);
      com.tencent.mm.kernel.g.aeS().a(2812, (com.tencent.mm.al.g)this);
      this.hpg = getIntent().getStringExtra("SpringCard.KeyWord");
      this.appId = getIntent().getStringExtra("SpringCard.AppId");
      this.iYE = getIntent().getStringExtra("SpringCard.TraceId");
      if ((!bt.isNullOrNil(this.hpg)) && (!bt.isNullOrNil(this.appId)) && (!bt.isNullOrNil(this.iYE))) {
        break label1427;
      }
    }
    for (;;)
    {
      this.osF = ((com.tencent.mm.app.n)new j(this));
      paramBundle = AppForegroundDelegate.cKE;
      localObject1 = this.osF;
      if (localObject1 == null) {
        k.aPZ("appForegroundLis");
      }
      paramBundle.a((com.tencent.mm.app.n)localObject1);
      AppMethodBeat.o(108179);
      return;
      paramBundle = this.oso;
      if (paramBundle == null) {
        k.aPZ("luckyBagLoadingImg");
      }
      paramBundle.setImageResource(2131232880);
      break;
      label1427:
      paramBundle = EmojiDebugUI.fKw;
      if (EmojiDebugUI.aaM())
      {
        ad.d("MicroMsg.SpringCardActivity", "stop cgi!!!");
      }
      else
      {
        paramBundle = this.hpg;
        if (paramBundle == null) {
          k.fvU();
        }
        localObject1 = this.appId;
        if (localObject1 == null) {
          k.fvU();
        }
        localObject2 = this.iYE;
        if (localObject2 == null) {
          k.fvU();
        }
        paramBundle = new com.tencent.mm.plugin.eggspring.c.b(paramBundle, (String)localObject1, (String)localObject2);
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramBundle);
      }
    }
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108200);
    k.h(paramString, "mediaId");
    ad.d("MicroMsg.SpringCardActivity", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.osD != null) && (this.osC != null) && (k.g(this.osC, paramString))) {
      aq.f((Runnable)new k(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108200);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(108183);
    super.onDestroy();
    Object localObject = this.osC;
    if (localObject != null) {
      o.aCJ().k((String)localObject, null);
    }
    if (this.osM)
    {
      localObject = this.osA;
      if (localObject == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIDestroy();
    }
    com.tencent.mm.kernel.g.aeS().b(2809, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(2812, (com.tencent.mm.al.g)this);
    ad.i("MicroMsg.SpringCardActivity", "videoInfo, count:[%s], rptCount:[%s], duration:[%s], curPoi:[%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.osL), Integer.valueOf(this.duration), Integer.valueOf(this.osK) });
    if (this.count >= 0)
    {
      this.osJ = (this.count * this.duration + this.osK);
      localObject = com.tencent.mm.plugin.eggspring.a.orI;
      localObject = com.tencent.mm.plugin.eggspring.a.bTM();
      int i = this.duration;
      int j = this.osL;
      int k = this.osJ;
      com.tencent.mm.plugin.report.service.h.vKh.f(18916, new Object[] { ((com.tencent.mm.plugin.eggspring.a)localObject).orE, ((com.tencent.mm.plugin.eggspring.a)localObject).orG, Integer.valueOf(16), "", Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    }
    for (;;)
    {
      localObject = AppForegroundDelegate.cKE;
      com.tencent.mm.app.n localn = this.osF;
      if (localn == null) {
        k.aPZ("appForegroundLis");
      }
      ((AppForegroundDelegate)localObject).b(localn);
      AppMethodBeat.o(108183);
      return;
      localObject = com.tencent.mm.plugin.eggspring.a.orI;
      com.tencent.mm.plugin.eggspring.a.bTM().Aj(16);
    }
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(108188);
    k.h(paramString, "filekey");
    ad.d("MicroMsg.SpringCardActivity", "onDownloadProgressChanged, fileKey [%s], finished [%s], total [%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(108188);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(108182);
    super.onPause();
    if (this.osM)
    {
      SpringEggVideoView localSpringEggVideoView = this.osA;
      if (localSpringEggVideoView == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      this.osK = localSpringEggVideoView.getCurrPosMs();
      ad.d("MicroMsg.SpringCardActivity", "videoInfo, curPoi: [%s].", new Object[] { Integer.valueOf(this.osK) });
      localSpringEggVideoView = this.osA;
      if (localSpringEggVideoView == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      localSpringEggVideoView.onUIPause();
    }
    AppMethodBeat.o(108182);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(108181);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.eggspring.a.orI;
    com.tencent.mm.plugin.eggspring.a.bTM().Aj(1);
    if (this.osM)
    {
      localObject = this.osA;
      if (localObject == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIResume();
    }
    AppMethodBeat.o(108181);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(108184);
    k.h(paramn, "scene");
    ad.i("MicroMsg.SpringCardActivity", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject1;
    if (2809 == paramn.getType())
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 5);
        AppMethodBeat.o(108184);
        return;
      }
      if (this.osN)
      {
        ad.i("MicroMsg.SpringCardActivity", "card is showing, return.");
        AppMethodBeat.o(108184);
        return;
      }
      this.osd = ((com.tencent.mm.plugin.eggspring.c.b)paramn).osd;
      if (this.osd == null) {
        break label3226;
      }
      ad.i("MicroMsg.SpringCardActivity", "brandCardContent: %s.", new Object[] { String.valueOf(this.osd) });
      paramString = com.tencent.mm.plugin.eggspring.a.orI;
      paramn = com.tencent.mm.plugin.eggspring.a.bTM();
      paramString = this.osd;
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.orW);
        paramn.orG = paramString;
        if (this.osd != null)
        {
          localObject1 = this.osd;
          if (localObject1 != null)
          {
            if ((bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).orM)) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).orO == null)) {
              break label498;
            }
            paramString = com.tencent.mm.plugin.eggspring.a.orI;
            com.tencent.mm.plugin.eggspring.a.bTM().Aj(2);
            paramString = this.osl;
            if (paramString == null) {
              k.aPZ("bottomBrandClickableTxt");
            }
            paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).orM);
            paramString = this.osm;
            if (paramString == null) {
              k.aPZ("bottomBrandClickableImg");
            }
            paramString.setVisibility(0);
            if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL) || (!bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).orR))) {
              break label550;
            }
            ad.e("MicroMsg.SpringCardActivity", "red pocket type, accept url is invalid!!!");
          }
        }
      }
      for (;;)
      {
        paramString = this.osd;
        if (paramString == null) {
          break label2594;
        }
        if (4 != paramString.orL) {
          break label2470;
        }
        if (1 != paramString.orU) {
          break label2167;
        }
        if (!bt.isNullOrNil(paramString.orN))
        {
          paramn = paramString.orN;
          if (paramn == null) {
            k.fvU();
          }
          if (!i.eK(yr(paramn))) {
            break label2144;
          }
          paramn = this.osz;
          if (paramn == null) {
            k.aPZ("brandCardBlessingStyleImgMedia");
          }
          localObject1 = paramString.orN;
          if (localObject1 == null) {
            k.fvU();
          }
          paramn.setImageFilePath(yr((String)localObject1));
          Al(0);
        }
        label408:
        if (bt.isNullOrNil(paramString.orT)) {
          break label2587;
        }
        paramn = paramString.orT;
        if (paramn == null) {
          k.fvU();
        }
        if (!i.eK(yr(paramn))) {
          break label2446;
        }
        paramn = this.osB;
        if (paramn == null) {
          k.aPZ("brandCardBlessingStyleBottomImg");
        }
        paramString = paramString.orT;
        if (paramString == null) {
          k.fvU();
        }
        paramn.setImageFilePath(yr(paramString));
        Al(1);
        AppMethodBeat.o(108184);
        return;
        paramString = null;
        break;
        label498:
        if (((com.tencent.mm.plugin.eggspring.b.a)localObject1).orO == null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.e("MicroMsg.SpringCardActivity", "not support jump!!! jumpInfo==null? [%s].", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 8);
          break;
        }
        label550:
        if ((2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).orS != null)) {
          break label579;
        }
        ad.e("MicroMsg.SpringCardActivity", "coupon type, couponInfo is null!!!");
      }
      label579:
      if (4 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL)
      {
        paramString = this.osy;
        if (paramString == null) {
          k.aPZ("brandCardBlessingStyleLayout");
        }
        f(paramString, ao.fromDPToPix((Context)getContext(), 144));
        paramString = this.osz;
        if (paramString == null) {
          k.aPZ("brandCardBlessingStyleImgMedia");
        }
        paramString = (View)paramString;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orU) {
          break label3233;
        }
        paramString = this.osA;
        if (paramString == null) {
          k.aPZ("brandCardBlessingStyleVideoMedia");
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
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orV)
      {
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orU)
        {
          paramn = com.tencent.mm.plugin.eggspring.a.orI;
          com.tencent.mm.plugin.eggspring.a.bTM().Aj(6);
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
          localObject3 = this.osB;
          if (localObject3 == null) {
            k.aPZ("brandCardBlessingStyleBottomImg");
          }
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((MMAnimateView)localObject3).getId());
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          localObject3 = this.osy;
          if (localObject3 == null) {
            k.aPZ("brandCardBlessingStyleLayout");
          }
          ((ViewGroup)localObject3).removeView(paramString);
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          paramString.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          paramn.addView(paramString, (ViewGroup.LayoutParams)localObject3);
          paramString = this.osy;
          if (paramString == null) {
            k.aPZ("brandCardBlessingStyleLayout");
          }
          paramString.addView((View)paramn, (ViewGroup.LayoutParams)localObject2);
          if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orU) {
            break;
          }
          paramString = this.osz;
          if (paramString == null) {
            k.aPZ("brandCardBlessingStyleImgMedia");
          }
          paramString.setDefaultImageResource(2131231320);
          paramString = this.osz;
          if (paramString == null) {
            k.aPZ("brandCardBlessingStyleImgMedia");
          }
          paramString.setImageResource(2131231320);
          break;
          paramn = com.tencent.mm.plugin.eggspring.a.orI;
          com.tencent.mm.plugin.eggspring.a.bTM().Aj(8);
        }
      }
      if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orV) {
        break;
      }
      if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orU)
      {
        paramn = com.tencent.mm.plugin.eggspring.a.orI;
        com.tencent.mm.plugin.eggspring.a.bTM().Aj(5);
      }
      for (;;)
      {
        paramn = this.osy;
        if (paramn == null) {
          k.aPZ("brandCardBlessingStyleLayout");
        }
        paramn.removeView(paramString);
        paramn = new RelativeLayout.LayoutParams(-2, -2);
        localObject1 = this.osB;
        if (localObject1 == null) {
          k.aPZ("brandCardBlessingStyleBottomImg");
        }
        paramn.addRule(2, ((MMAnimateView)localObject1).getId());
        paramn.addRule(14);
        localObject1 = this.osy;
        if (localObject1 == null) {
          k.aPZ("brandCardBlessingStyleLayout");
        }
        ((ViewGroup)localObject1).addView(paramString, (ViewGroup.LayoutParams)paramn);
        break;
        paramn = com.tencent.mm.plugin.eggspring.a.orI;
        com.tencent.mm.plugin.eggspring.a.bTM().Aj(7);
      }
      if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL) && (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL)) {
        break;
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandIcon");
      if (!bt.isNullOrNil(paramString))
      {
        paramn = this.osr;
        if (paramn == null) {
          k.aPZ("brandCardTitleLogo");
        }
        localObject2 = new StringBuilder();
        localObject3 = com.tencent.mm.plugin.eggspring.b.b.orX;
        paramn.setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.bTO() + paramString);
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandName");
      if (!bt.isNullOrNil(paramString))
      {
        paramn = this.oss;
        if (paramn == null) {
          k.aPZ("brandCardTitleName");
        }
        paramn.setText((CharSequence)paramString);
      }
      paramString = "";
      paramn = "";
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL)
      {
        paramString = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverSubTitle");
        label1318:
        if (!bt.isNullOrNil(paramString))
        {
          localObject2 = this.ost;
          if (localObject2 == null) {
            k.aPZ("brandCardMainWording");
          }
          ((TextView)localObject2).setText((CharSequence)paramString);
        }
        if (!bt.isNullOrNil(paramn))
        {
          paramString = this.osu;
          if (paramString == null) {
            k.aPZ("brandCardSubWording");
          }
          paramString.setText((CharSequence)paramn);
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).orP))
        {
          paramString = this.ost;
          if (paramString == null) {
            k.aPZ("brandCardMainWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).orP);
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).orQ))
        {
          paramString = this.osu;
          if (paramString == null) {
            k.aPZ("brandCardSubWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).orQ);
        }
        paramString = this.osw;
        if (paramString == null) {
          k.aPZ("brandCardMediaLayout");
        }
        f(paramString, 0);
        paramString = this.osw;
        if (paramString == null) {
          k.aPZ("brandCardMediaLayout");
        }
        paramn = this.osx;
        if (paramn == null) {
          k.aPZ("brandCardImgMedia");
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
        localObject2 = this.osw;
        if (localObject2 == null) {
          k.aPZ("brandCardMediaLayout");
        }
        ((ViewGroup)localObject2).addView((View)paramString, (ViewGroup.LayoutParams)paramn);
        paramn = new FrameLayout.LayoutParams(-2, -2);
        if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL) {
          break label2010;
        }
        localObject1 = getContext();
        k.g(localObject1, "context");
        paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166752);
        localObject1 = getContext();
        k.g(localObject1, "context");
        paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166751);
        localObject1 = this.osx;
        if (localObject1 == null) {
          k.aPZ("brandCardImgMedia");
        }
        ((MMAnimateView)localObject1).setImageResource(2131233816);
        localObject1 = this.osv;
        if (localObject1 == null) {
          k.aPZ("brandCardAcceptBtn");
        }
        ((Button)localObject1).setText(2131755116);
        localObject1 = com.tencent.mm.plugin.eggspring.a.orI;
        com.tencent.mm.plugin.eggspring.a.bTM().Aj(3);
      }
      for (;;)
      {
        localObject1 = this.osx;
        if (localObject1 == null) {
          k.aPZ("brandCardImgMedia");
        }
        paramString.addView((View)localObject1, (ViewGroup.LayoutParams)paramn);
        paramString = this.osq;
        if (paramString == null) {
          k.aPZ("brandCardTitleLayout");
        }
        paramString.setVisibility(0);
        paramString = this.ost;
        if (paramString == null) {
          k.aPZ("brandCardMainWording");
        }
        paramString.setVisibility(0);
        paramString = this.osu;
        if (paramString == null) {
          k.aPZ("brandCardSubWording");
        }
        paramString.setVisibility(0);
        paramString = this.osv;
        if (paramString == null) {
          k.aPZ("brandCardAcceptBtn");
        }
        paramString.setVisibility(0);
        paramString = this.osw;
        if (paramString == null) {
          k.aPZ("brandCardMediaLayout");
        }
        paramString.setVisibility(0);
        paramString = this.osy;
        if (paramString == null) {
          k.aPZ("brandCardBlessingStyleLayout");
        }
        paramString.setVisibility(8);
        break;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL) {
          break label1318;
        }
        paramString = getIntent().getStringExtra("SpringCard.BrandCouponMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandCouponSubTitle");
        break label1318;
        label2010:
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).orL)
        {
          localObject1 = getContext();
          k.g(localObject1, "context");
          paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166077);
          localObject1 = getContext();
          k.g(localObject1, "context");
          paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166076);
          localObject1 = this.osx;
          if (localObject1 == null) {
            k.aPZ("brandCardImgMedia");
          }
          ((MMAnimateView)localObject1).setImageResource(2131231861);
          localObject1 = this.osv;
          if (localObject1 == null) {
            k.aPZ("brandCardAcceptBtn");
          }
          ((Button)localObject1).setText(2131755113);
          localObject1 = com.tencent.mm.plugin.eggspring.a.orI;
          com.tencent.mm.plugin.eggspring.a.bTM().Aj(4);
        }
      }
      label2144:
      paramn = paramString.orN;
      if (paramn == null) {
        k.fvU();
      }
      Tg(paramn);
      break label408;
      label2167:
      if (2 != paramString.orU) {
        break label408;
      }
      paramn = this.osz;
      if (paramn == null) {
        k.aPZ("brandCardBlessingStyleImgMedia");
      }
      paramn.setVisibility(8);
      paramn = this.osA;
      if (paramn == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      paramn.setVisibility(0);
      this.osM = true;
      paramn = this.osd;
      if ((paramn == null) || (bt.isNullOrNil(paramn.orN))) {
        break label408;
      }
      localObject1 = this.osA;
      if (localObject1 == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setLoop(true);
      localObject1 = this.osA;
      if (localObject1 == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMVideoViewCallback((h.b)this);
      localObject1 = this.osA;
      if (localObject1 == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMDownloadFinish((com.tencent.mm.pluginsdk.ui.h.a)this);
      localObject1 = this.osA;
      if (localObject1 == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this);
      localObject1 = this.osA;
      if (localObject1 == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).c(false, paramn.orN, 0);
      localObject1 = this.osA;
      if (localObject1 == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      paramn = paramn.orN;
      if (paramn == null) {
        k.fvU();
      }
      ((SpringEggVideoView)localObject1).setFilepath(Th(paramn));
      paramn = this.osA;
      if (paramn == null) {
        k.aPZ("brandCardBlessingStyleVideoMedia");
      }
      paramn.start();
      break label408;
      paramString = paramString.orT;
      if (paramString == null) {
        k.fvU();
      }
      Tg(paramString);
      AppMethodBeat.o(108184);
      return;
      label2470:
      if (((1 == paramString.orL) || (2 == paramString.orL)) && (!bt.isNullOrNil(paramString.orN)))
      {
        paramn = paramString.orN;
        if (paramn == null) {
          k.fvU();
        }
        if (i.eK(yr(paramn)))
        {
          paramn = this.osx;
          if (paramn == null) {
            k.aPZ("brandCardImgMedia");
          }
          paramString = paramString.orN;
          if (paramString == null) {
            k.fvU();
          }
          paramn.setImageFilePath(yr(paramString));
          bTP();
          AppMethodBeat.o(108184);
          return;
        }
        paramString = paramString.orN;
        if (paramString == null) {
          k.fvU();
        }
        Tg(paramString);
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
          paramString = com.tencent.mm.plugin.eggspring.a.orI;
          com.tencent.mm.plugin.eggspring.a.bTM().Aj(14);
          com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 6);
          paramString = (Context)getContext();
          paramn = getContext();
          k.g(paramn, "context");
          t.ci(paramString, paramn.getResources().getString(2131764540));
          AppMethodBeat.o(108184);
          return;
        }
        paramString = (com.tencent.mm.plugin.eggspring.c.a)paramn;
        paramn = paramString.osa;
        ad.i("MicroMsg.SpringCardActivity", "coupon, retCode: %s, retMsg: %s.", new Object[] { paramn, paramString.osb });
        if (paramn != null)
        {
          long l = ((Number)paramn).longValue();
          if (0L == l)
          {
            paramString = com.tencent.mm.plugin.eggspring.a.orI;
            com.tencent.mm.plugin.eggspring.a.bTM().Aj(13);
            paramString = (Context)getContext();
            paramn = getContext();
            k.g(paramn, "context");
            t.cg(paramString, paramn.getResources().getString(2131755117));
            paramString = this.osv;
            if (paramString == null) {
              k.aPZ("brandCardAcceptBtn");
            }
            paramString.setText(2131755115);
            paramString = this.osv;
            if (paramString == null) {
              k.aPZ("brandCardAcceptBtn");
            }
            paramString.setEnabled(false);
          }
          for (;;)
          {
            if (l != 0L)
            {
              paramString = com.tencent.mm.plugin.eggspring.a.orI;
              com.tencent.mm.plugin.eggspring.a.bTM().Aj(14);
              com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 6);
            }
            AppMethodBeat.o(108184);
            return;
            if ((268456656L == l) || (268457508L == l) || (268456641L == l) || (268456640L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              k.g(paramn, "context");
              t.ci(paramString, paramn.getResources().getString(2131757954));
              paramString = this.osv;
              if (paramString == null) {
                k.aPZ("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.osv;
              if (paramString == null) {
                k.aPZ("brandCardAcceptBtn");
              }
              paramString.setEnabled(false);
            }
            else if ((268456461L == l) || (268455949L == l) || (268456007L == l) || (268456320L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              k.g(paramn, "context");
              t.ci(paramString, paramn.getResources().getString(2131756775));
              paramString = this.osv;
              if (paramString == null) {
                k.aPZ("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.osv;
              if (paramString == null) {
                k.aPZ("brandCardAcceptBtn");
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
              ad.i("MicroMsg.SpringCardActivity", "other err![%s]", new Object[] { paramn });
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
    this.osC = paramString1;
    if (i.eK(PluginEggSpring.ory + "MMVideo_" + paramString3.hashCode() + ".mp4"))
    {
      a(paramString1, 0, null);
      AppMethodBeat.o(108195);
      return;
    }
    e locale = o.aCJ();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = paramString1;
    localh.url = paramString3;
    localh.foc = 1;
    localh.fnX = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString2;
    localh.foj = ((com.tencent.mm.i.h.a)this);
    locale.a(localh, false);
    AppMethodBeat.o(108195);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108197);
    String str = this.osC;
    if (str != null)
    {
      if (k.g(str, paramString))
      {
        o.aCJ();
        e.q(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(108197);
      return;
    }
    AppMethodBeat.o(108197);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108165);
      if (SpringCardActivity.q(this.osQ).getVisibility() == 0)
      {
        paramView = com.tencent.mm.plugin.eggspring.a.orI;
        com.tencent.mm.plugin.eggspring.a.bTM().Aj(10);
        paramView = (Context)this.osQ;
        com.tencent.mm.plugin.eggspring.b.a locala = SpringCardActivity.r(this.osQ);
        if (locala == null) {
          k.fvU();
        }
        com.tencent.mm.plugin.eggspring.d.a.a(paramView, locala.orO);
      }
      AppMethodBeat.o(108165);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108166);
      paramView = SpringCardActivity.r(this.osQ);
      if (paramView != null)
      {
        switch (paramView.orL)
        {
        }
        do
        {
          AppMethodBeat.o(108166);
          return;
          if (!bt.isNullOrNil(paramView.orR))
          {
            localObject = com.tencent.mm.plugin.eggspring.a.orI;
            com.tencent.mm.plugin.eggspring.a.bTM().Aj(11);
            ad.d("MicroMsg.SpringCardActivity", "acceptRedPocketCoverUrl: %s.", new Object[] { paramView.orR });
            localObject = new Intent();
            ((Intent)localObject).putExtra("rawUrl", paramView.orR);
            com.tencent.mm.bs.d.b((Context)this.osQ.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
            AppMethodBeat.o(108166);
            return;
          }
          ad.e("MicroMsg.SpringCardActivity", "red pocket cover accept url is invalid, impossible!!!");
          AppMethodBeat.o(108166);
          return;
          paramView = paramView.orS;
        } while (paramView == null);
        Object localObject = com.tencent.mm.plugin.eggspring.a.orI;
        com.tencent.mm.plugin.eggspring.a.bTM().Aj(12);
        paramView = new com.tencent.mm.plugin.eggspring.c.a(paramView);
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramView);
        AppMethodBeat.o(108166);
        return;
      }
      AppMethodBeat.o(108166);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(160272);
      if (SpringCardActivity.r(this.osQ) != null)
      {
        localObject = SpringCardActivity.r(this.osQ);
        if (localObject == null) {
          k.fvU();
        }
        if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).orL == 4) || (SpringCardActivity.g(this.osQ).getVisibility() != 0))
        {
          localObject = SpringCardActivity.r(this.osQ);
          if (localObject == null) {
            k.fvU();
          }
          if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).orL != 4) || (SpringCardActivity.x(this.osQ)) || (SpringCardActivity.y(this.osQ))) {
            break label117;
          }
        }
      }
      Object localObject = com.tencent.mm.plugin.eggspring.a.orI;
      com.tencent.mm.plugin.eggspring.a.bTM().Aj(9);
      com.tencent.mm.plugin.report.service.h.vKh.dB(1263, 7);
      label117:
      SpringCardActivity.a(this.osQ);
      AppMethodBeat.o(160272);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(SpringCardActivity paramSpringCardActivity, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(108169);
      if (SpringCardActivity.j(this.osQ))
      {
        AppMethodBeat.o(108169);
        return;
      }
      com.tencent.mm.plugin.eggspring.b.a locala = SpringCardActivity.r(this.osQ);
      if (locala != null)
      {
        if ((k.g(paramString, locala.orN)) && ((1 == locala.orL) || (2 == locala.orL) || ((4 == locala.orL) && (2 != locala.orU))))
        {
          ad.d("MicroMsg.SpringCardActivity", "onC2CDownloadCompleted, filekey: [%s], cardType: [%s].", new Object[] { paramString, Integer.valueOf(locala.orL) });
          if (4 == locala.orL)
          {
            SpringCardActivity.i(this.osQ).setImageFilePath(SpringCardActivity.Tj(paramString));
            SpringCardActivity.c(this.osQ, 0);
            AppMethodBeat.o(108169);
            return;
          }
          if ((1 == locala.orL) || (2 == locala.orL))
          {
            SpringCardActivity.t(this.osQ).setImageFilePath(SpringCardActivity.Tj(paramString));
            SpringCardActivity.u(this.osQ);
          }
          AppMethodBeat.o(108169);
          return;
        }
        if ((k.g(paramString, locala.orT)) && (4 == locala.orL))
        {
          SpringCardActivity.v(this.osQ).setImageFilePath(SpringCardActivity.Tj(paramString));
          SpringCardActivity.c(this.osQ, 1);
        }
        AppMethodBeat.o(108169);
        return;
      }
      AppMethodBeat.o(108169);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108171);
      SpringCardActivity.b(this.osQ).setVisibility(8);
      SpringCardActivity.c(this.osQ).setVisibility(8);
      SpringCardActivity.d(this.osQ).setVisibility(8);
      SpringCardActivity.e(this.osQ).setVisibility(8);
      SpringCardActivity.f(this.osQ).setVisibility(8);
      SpringCardActivity.g(this.osQ).setVisibility(0);
      SpringCardActivity.h(this.osQ).setLoop(true);
      SpringCardActivity.h(this.osQ).setIMMVideoViewCallback((h.b)this.osQ);
      SpringCardActivity.h(this.osQ).setIMMDownloadFinish((com.tencent.mm.pluginsdk.ui.h.a)this.osQ);
      SpringCardActivity.h(this.osQ).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.osQ);
      SpringCardActivity.h(this.osQ).c(false, "http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023", 0);
      SpringCardActivity.h(this.osQ).setFilepath(SpringCardActivity.Ti("http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023"));
      SpringCardActivity.h(this.osQ).start();
      SpringCardActivity.i(this.osQ).setVisibility(8);
      SpringCardActivity.h(this.osQ).setVisibility(0);
      AppMethodBeat.o(108171);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108172);
      SpringCardActivity.k(this.osQ);
      SpringCardActivity.l(this.osQ).setVisibility(0);
      SpringCardActivity.m(this.osQ).setVisibility(4);
      AppMethodBeat.o(108172);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$4", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-eggspring_release"})
  public static final class j
    implements com.tencent.mm.app.n
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(162213);
      ad.d("MicroMsg.SpringCardActivity", "onAppBackground");
      if (SpringCardActivity.n(this.osQ))
      {
        SpringCardActivity.a(this.osQ, SpringCardActivity.o(this.osQ) - 1);
        SpringCardActivity.b(this.osQ, SpringCardActivity.p(this.osQ) - 1);
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108173);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.osQ);
      if (locala == null) {
        k.fvU();
      }
      locala.onDataAvailable(paramString, paramLong1, this.osU);
      AppMethodBeat.o(108173);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(SpringCardActivity paramSpringCardActivity, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(108174);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.osQ);
      if (locala == null) {
        k.fvU();
      }
      locala.am(paramString, paramInt);
      AppMethodBeat.o(108174);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(SpringCardActivity paramSpringCardActivity, String paramString1, long paramLong1, long paramLong2, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108175);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.osQ);
      if (locala == null) {
        k.fvU();
      }
      locala.Bl(paramLong1);
      AppMethodBeat.o(108175);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108176);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.osQ);
      if (locala == null) {
        k.fvU();
      }
      locala.k(paramString, paramLong1, this.osW);
      AppMethodBeat.o(108176);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity
 * JD-Core Version:    0.7.0.1
 */