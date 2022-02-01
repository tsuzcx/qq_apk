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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.an.e;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.emoji.debug.EmojiDebugUI;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.eggspring.PluginEggSpring;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/eggspring/ui/SpringCardActivity;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mars/cdn/CdnLogic$DownloadCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMVideoViewCallback;", "Lcom/tencent/mm/pluginsdk/ui/IMMVideoView$IMMDownloadFinish;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo$IVideoCdnCallback;", "()V", "appForegroundLis", "Lcom/tencent/mm/app/IAppForegroundListener;", "appId", "", "blessingBtmImgReady", "", "blessingTopImgReady", "bottomBrandBgImg", "Lcom/tencent/mm/plugin/gif/MMAnimateView;", "bottomBrandClickableImg", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomBrandClickableTxt", "Landroid/widget/TextView;", "bottomBrandClickableTxtLayout", "Landroid/view/View;", "bottomBrandIntroTxt", "brandCardAcceptBtn", "Landroid/widget/Button;", "brandCardBlessingStyleBottomImg", "brandCardBlessingStyleImgMedia", "brandCardBlessingStyleLayout", "Landroid/view/ViewGroup;", "brandCardBlessingStyleVideoMedia", "Lcom/tencent/mm/plugin/eggspring/ui/SpringEggVideoView;", "brandCardContent", "Lcom/tencent/mm/plugin/eggspring/model/BrandCardContent;", "brandCardImgMedia", "brandCardLayout", "brandCardMainWording", "brandCardMediaLayout", "brandCardSubWording", "brandCardTitleLayout", "brandCardTitleLogo", "brandCardTitleName", "cardIsShowing", "count", "", "curPoi", "duration", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "fireWorksColor", "", "isVideo", "keyWord", "lastShowCardRunnable", "Ljava/lang/Runnable;", "loadingAnimTimerStartMS", "", "luckyBagLoadingImg", "rootLayout", "rptCount", "sum", "traceId", "uiHandler", "Landroid/os/Handler;", "videoMediaId", "addFireWorks", "", "parent", "offset", "adjustCloseBtnColor", "color", "againConfigView", "boundView", "changeCardStyle", "createVideoPlayCDNTask", "Lcom/tencent/mm/cdn/keep_VideoTaskInfo;", "mediaId", "url", "path", "dealWithMedia", "downLoadImg", "getCachePath", "getFireworksColor", "getLayoutId", "getRandomByRange", "low", "high", "getSavePath", "getTempPath", "imgExist", "initBar", "initConfigView", "initVideoView", "isVideoDataAvailable", "length", "onBlessingMediaReady", "type", "onC2CDownloadCompleted", "filekey", "result", "Lcom/tencent/mars/cdn/CdnLogic$C2CDownloadResult;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataAvailable", "onDestroy", "onDownloadFinish", "isPlayNow", "onDownloadProgressChanged", "finished", "total", "tryshow", "onError", "sessionId", "errorMsg", "what", "extra", "onFinish", "ret", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onGetVideoSize", "width", "height", "onMediaReady", "onMoovReady", "svrflag", "onPause", "onPrepared", "onProgress", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onVideoEnded", "onVideoFirstFrameDraw", "onVideoPause", "onVideoPlay", "onVideoWaiting", "onVideoWaitingEnd", "playCardAnim", "requestBrandCardContent", "requestVideoData", "setIEngineCallback", "callback", "startHttpStream", "stop", "Companion", "plugin-eggspring_release"})
public final class SpringCardActivity
  extends MMActivity
  implements CdnLogic.DownloadCallback, f, h.a, com.tencent.mm.modelvideo.b, i.a, i.b
{
  public static final SpringCardActivity.a pGD;
  private String appId;
  private Handler cBv;
  private int count;
  private int duration;
  private String ilP;
  private String jWi;
  private com.tencent.mm.plugin.eggspring.b.a pFR;
  private ViewGroup pFW;
  private MMAnimateView pFX;
  private View pFY;
  private TextView pFZ;
  private boolean pGA;
  private boolean pGB;
  private final int[] pGC;
  private WeImageView pGa;
  private TextView pGb;
  private MMAnimateView pGc;
  private ViewGroup pGd;
  private View pGe;
  private MMAnimateView pGf;
  private TextView pGg;
  private TextView pGh;
  private TextView pGi;
  private Button pGj;
  private ViewGroup pGk;
  private MMAnimateView pGl;
  private ViewGroup pGm;
  private MMAnimateView pGn;
  private SpringEggVideoView pGo;
  private MMAnimateView pGp;
  private String pGq;
  private com.tencent.mm.modelvideo.b.a pGr;
  private long pGs;
  private com.tencent.mm.app.o pGt;
  private boolean pGu;
  private boolean pGv;
  private final Runnable pGw;
  private int pGx;
  private int pGy;
  private int pGz;
  
  static
  {
    AppMethodBeat.i(108208);
    pGD = new SpringCardActivity.a((byte)0);
    AppMethodBeat.o(108208);
  }
  
  public SpringCardActivity()
  {
    AppMethodBeat.i(108207);
    this.pGw = ((Runnable)new e(this));
    this.duration = -1;
    this.count = -1;
    this.pGx = -1;
    this.pGy = -1;
    this.pGC = new int[] { 2131100372, 2131100373, 2131100374 };
    AppMethodBeat.o(108207);
  }
  
  private final void BW(int paramInt)
  {
    AppMethodBeat.i(162214);
    if (ao.acF(paramInt))
    {
      updateBackBtn(ao.k((Context)this, 2131690535, -1));
      AppMethodBeat.o(162214);
      return;
    }
    updateBackBtn(ao.k((Context)this, 2131690535, -16777216));
    AppMethodBeat.o(162214);
  }
  
  private final void BX(int paramInt)
  {
    AppMethodBeat.i(160274);
    if (paramInt == 0)
    {
      this.pGu = true;
      if (!this.pGv) {}
    }
    for (;;)
    {
      cgX();
      do
      {
        do
        {
          AppMethodBeat.o(160274);
          return;
        } while (1 != paramInt);
        this.pGv = true;
        if (this.pGu) {
          break;
        }
      } while (!this.pGA);
    }
  }
  
  private static String Gc(String paramString)
  {
    AppMethodBeat.i(108186);
    paramString = PluginEggSpring.pFm + '/' + paramString.hashCode();
    AppMethodBeat.o(108186);
    return paramString;
  }
  
  private final void abQ(String paramString)
  {
    AppMethodBeat.i(108185);
    Object localObject = EmojiDebugUI.gjU;
    if (EmojiDebugUI.aeC())
    {
      ae.d("MicroMsg.SpringCardActivity", "stop cdn!!!");
      AppMethodBeat.o(108185);
      return;
    }
    localObject = new CdnLogic.C2CDownloadRequest();
    ((CdnLogic.C2CDownloadRequest)localObject).fileKey = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).url = paramString;
    ((CdnLogic.C2CDownloadRequest)localObject).setSavePath(Gc(paramString));
    CdnLogic.startHttpsDownload((CdnLogic.C2CDownloadRequest)localObject, (CdnLogic.DownloadCallback)this);
    AppMethodBeat.o(108185);
  }
  
  private static String abR(String paramString)
  {
    AppMethodBeat.i(108187);
    paramString = PluginEggSpring.pFm + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(108187);
    return paramString;
  }
  
  private final void cgX()
  {
    AppMethodBeat.i(160275);
    Handler localHandler = this.cBv;
    if (localHandler == null) {
      p.bdF("uiHandler");
    }
    localHandler.removeCallbacks(this.pGw);
    if (this.pGB)
    {
      AppMethodBeat.o(160275);
      return;
    }
    long l = System.currentTimeMillis() - this.pGs;
    if (l > 1000L)
    {
      cgY();
      AppMethodBeat.o(160275);
      return;
    }
    localHandler = this.cBv;
    if (localHandler == null) {
      p.bdF("uiHandler");
    }
    localHandler.postDelayed((Runnable)new m(this), 1000L - l);
    AppMethodBeat.o(160275);
  }
  
  private final void cgY()
  {
    AppMethodBeat.i(160276);
    this.pGB = true;
    Object localObject1 = this.pGd;
    if (localObject1 == null) {
      p.bdF("brandCardLayout");
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
    localObject6 = this.pGd;
    if (localObject6 == null) {
      p.bdF("brandCardLayout");
    }
    localObject1 = ObjectAnimator.ofPropertyValuesHolder(localObject6, new PropertyValuesHolder[] { localObject1, localObject2, localObject3, localObject4, localObject5 });
    p.g(localObject1, "animator");
    ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ObjectAnimator)localObject1).setDuration(500L).start();
    ((ObjectAnimator)localObject1).addListener((Animator.AnimatorListener)new p(this));
    AppMethodBeat.o(160276);
  }
  
  private final int cgZ()
  {
    AppMethodBeat.i(108204);
    int i = this.pGC[new java.util.Random().nextInt(this.pGC.length)];
    AppMethodBeat.o(108204);
    return i;
  }
  
  private static int fk(int paramInt1, int paramInt2)
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
    int m = aq.fromDPToPix((Context)getContext(), 216) / 4;
    localObject1 = d.k.j.a((d.k.d)d.k.j.lv(0, 4), 3);
    int i = ((d.k.d)localObject1).Njm;
    int n = ((d.k.d)localObject1).Njn;
    int i1 = ((d.k.d)localObject1).kyd;
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
            ((WeImageView)localObject1).setIconColor(((AppCompatActivity)localObject2).getResources().getColor(cgZ()));
            localObject2 = getContext();
            p.g(localObject2, "context");
            int i2 = ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166302);
            localObject2 = getContext();
            p.g(localObject2, "context");
            localObject2 = new RelativeLayout.LayoutParams(i2, ((AppCompatActivity)localObject2).getResources().getDimensionPixelSize(2131166301));
            i2 = fk(i * k, (i + 1) * k);
            int i3 = fk(j * m, (j + 1) * m) + paramInt;
            ae.d("MicroMsg.SpringCardActivity", "x %s y %s", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3) });
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
    this.pGr = parama;
  }
  
  public final void a(final String paramString, final int paramInt, com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(108202);
    p.h(paramString, "mediaId");
    ae.d("MicroMsg.SpringCardActivity", "onFinish!!! mediaId[%s].", new Object[] { paramString });
    if ((this.pGr != null) && (this.pGq != null) && (p.i(this.pGq, paramString))) {
      ar.f((Runnable)new l(this, paramString, paramInt));
    }
    AppMethodBeat.o(108202);
  }
  
  public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
  {
    AppMethodBeat.i(212323);
    p.h(paramString1, "mediaId");
    ae.d("MicroMsg.SpringCardActivity", "onMoovReady!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString1, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.pGr != null) && (this.pGq != null) && (p.i(this.pGq, paramString1))) {
      ar.f((Runnable)new n(this, paramString1, paramLong1, paramLong2, paramString2));
    }
    AppMethodBeat.o(212323);
  }
  
  public final void aM(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(108194);
    if (paramString != null)
    {
      String str = d.n.n.h(paramString, ".temp", "", false);
      if ((!com.tencent.mm.vfs.o.fB(str)) && (d.n.n.nG(paramString, ".temp"))) {
        com.tencent.mm.vfs.o.mF(paramString, str);
      }
      AppMethodBeat.o(108194);
      return;
    }
    AppMethodBeat.o(108194);
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108190);
    ae.i("MicroMsg.SpringCardActivity", "onError!!! mediaId[%s] errorMsg[%s].", new Object[] { paramString2, paramString3 });
    com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 10);
    paramString1 = this.pGn;
    if (paramString1 == null) {
      p.bdF("brandCardBlessingStyleImgMedia");
    }
    paramString1.setVisibility(0);
    paramString1 = this.pGo;
    if (paramString1 == null) {
      p.bdF("brandCardBlessingStyleVideoMedia");
    }
    paramString1.setVisibility(8);
    AppMethodBeat.o(108190);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(160278);
    ae.d("MicroMsg.SpringCardActivity", "onGetVideoSize!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160278);
  }
  
  public final void ds(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160277);
    ae.d("MicroMsg.SpringCardActivity", "onPrepared!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160277);
  }
  
  public final void dt(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108191);
    ae.d("MicroMsg.SpringCardActivity", "onVideoEnded!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108191);
  }
  
  public final void du(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160279);
    ae.d("MicroMsg.SpringCardActivity", "onVideoPause!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(160279);
  }
  
  public final void dv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(160280);
    paramString1 = this.pGo;
    if (paramString1 == null) {
      p.bdF("brandCardBlessingStyleVideoMedia");
    }
    ae.d("MicroMsg.SpringCardActivity", "onVideoPlay!!! mediaId[%s], duration[%s].", new Object[] { paramString2, Integer.valueOf(paramString1.getVideoDurationSec()) });
    if (this.duration <= 0)
    {
      paramString1 = this.pGo;
      if (paramString1 == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      this.duration = (paramString1.getVideoDurationSec() * 1000);
    }
    this.count += 1;
    this.pGz += 1;
    ae.d("MicroMsg.SpringCardActivity", "videoInfo count: [%s] rptCount: [%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.pGz) });
    AppMethodBeat.o(160280);
  }
  
  public final void dw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108192);
    ae.d("MicroMsg.SpringCardActivity", "onVideoWaiting!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108192);
  }
  
  public final void dx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108193);
    ae.d("MicroMsg.SpringCardActivity", "onVideoWaitingEnd!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(108193);
  }
  
  public final void eX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(212322);
    ae.d("MicroMsg.SpringCardActivity", "onVideoFirstFrameDraw!!! mediaId[%s].", new Object[] { paramString2 });
    AppMethodBeat.o(212322);
  }
  
  public final int getLayoutId()
  {
    return 2131495639;
  }
  
  public final void gp(String paramString)
  {
    AppMethodBeat.i(108196);
    p.h(paramString, "mediaId");
    String str = this.pGq;
    if (str != null)
    {
      if (p.i(str, paramString)) {
        com.tencent.mm.modelvideo.o.aNi().m(paramString, null);
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
    ae.d("MicroMsg.SpringCardActivity", "onProgress!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.pGr != null) && (this.pGq != null) && (p.i(this.pGq, paramString))) {
      ar.f((Runnable)new o(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108201);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    AppMethodBeat.i(108198);
    ae.d("MicroMsg.SpringCardActivity", "isVideoDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    String str = this.pGq;
    boolean bool1 = bool2;
    if (str != null)
    {
      bool1 = bool2;
      if (p.i(str, paramString)) {
        bool1 = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
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
      com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 9);
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
    this.cBv = new Handler(getMainLooper());
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this), 2131690535);
    paramBundle = getContext();
    p.g(paramBundle, "context");
    int i = paramBundle.getResources().getColor(2131100950);
    setActionbarColor(i);
    BW(i);
    hideActionbarLine();
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(2050);
    paramBundle = findViewById(2131304246);
    p.g(paramBundle, "findViewById(R.id.root_layout)");
    this.pFW = ((ViewGroup)paramBundle);
    paramBundle = findViewById(2131297434);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_bg_img)");
    this.pFX = ((MMAnimateView)paramBundle);
    paramBundle = findViewById(2131297437);
    p.g(paramBundle, "findViewById(R.id.bottom…and_clickable_txt_layout)");
    this.pFY = paramBundle;
    paramBundle = this.pFY;
    if (paramBundle == null) {
      p.bdF("bottomBrandClickableTxtLayout");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = findViewById(2131297436);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_click_txt)");
    this.pFZ = ((TextView)paramBundle);
    paramBundle = findViewById(2131297435);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_click_img)");
    this.pGa = ((WeImageView)paramBundle);
    paramBundle = findViewById(2131297438);
    p.g(paramBundle, "findViewById(R.id.bottom_brand_intro_txt)");
    this.pGb = ((TextView)paramBundle);
    paramBundle = findViewById(2131301713);
    p.g(paramBundle, "findViewById(R.id.lucky_bag_loading_img)");
    this.pGc = ((MMAnimateView)paramBundle);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.vfs.o.fB(PluginEggSpring.pFn))
    {
      paramBundle = this.pGc;
      if (paramBundle == null) {
        p.bdF("luckyBagLoadingImg");
      }
      paramBundle.setImageFilePath(PluginEggSpring.pFn);
      paramBundle = findViewById(2131297500);
      p.g(paramBundle, "findViewById(R.id.brand_card_layout)");
      this.pGd = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297504);
      p.g(paramBundle, "findViewById(R.id.brand_card_title_layout)");
      this.pGe = paramBundle;
      paramBundle = findViewById(2131297505);
      p.g(paramBundle, "findViewById(R.id.brand_card_title_logo)");
      this.pGf = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297506);
      p.g(paramBundle, "findViewById(R.id.brand_card_title_name)");
      this.pGg = ((TextView)paramBundle);
      paramBundle = findViewById(2131297501);
      p.g(paramBundle, "findViewById(R.id.brand_card_main_wording)");
      this.pGh = ((TextView)paramBundle);
      paramBundle = findViewById(2131297503);
      p.g(paramBundle, "findViewById(R.id.brand_card_sub_wording)");
      this.pGi = ((TextView)paramBundle);
      paramBundle = findViewById(2131297494);
      p.g(paramBundle, "findViewById(R.id.brand_card_accept_btn)");
      this.pGj = ((Button)paramBundle);
      paramBundle = this.pGj;
      if (paramBundle == null) {
        p.bdF("brandCardAcceptBtn");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      paramBundle = findViewById(2131297502);
      p.g(paramBundle, "findViewById(R.id.brand_card_media_layout)");
      this.pGk = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297499);
      p.g(paramBundle, "findViewById(R.id.brand_card_img_media)");
      this.pGl = ((MMAnimateView)paramBundle);
      paramBundle = findViewById(2131297497);
      p.g(paramBundle, "findViewById(R.id.brand_…rd_blessing_style_layout)");
      this.pGm = ((ViewGroup)paramBundle);
      paramBundle = findViewById(2131297496);
      p.g(paramBundle, "findViewById(R.id.brand_…blessing_style_img_media)");
      this.pGn = ((MMAnimateView)paramBundle);
      paramBundle = this.pGn;
      if (paramBundle == null) {
        p.bdF("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setDefaultImageResource(2131231321);
      paramBundle = findViewById(2131297498);
      p.g(paramBundle, "findViewById(R.id.brand_…essing_style_video_media)");
      this.pGo = ((SpringEggVideoView)paramBundle);
      paramBundle = findViewById(2131297495);
      p.g(paramBundle, "findViewById(R.id.brand_…lessing_style_bottom_img)");
      this.pGp = ((MMAnimateView)paramBundle);
      paramBundle = this.pGp;
      if (paramBundle == null) {
        p.bdF("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setDefaultImageResource(2131231319);
      ae.d("MicroMsg.SpringCardActivity", "init config view.");
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBtmImg");
      if (!bu.isNullOrNil(paramBundle))
      {
        localObject1 = this.pFX;
        if (localObject1 == null) {
          p.bdF("bottomBrandBgImg");
        }
        localObject2 = new StringBuilder();
        com.tencent.mm.plugin.eggspring.b.b.a locala = com.tencent.mm.plugin.eggspring.b.b.pFL;
        ((MMAnimateView)localObject1).setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.cgW() + paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BrandBgColor");
      if (!bu.isNullOrNil(paramBundle))
      {
        i = Color.parseColor(paramBundle);
        paramBundle = this.pFW;
        if (paramBundle == null) {
          p.bdF("rootLayout");
        }
        paramBundle.setBackgroundColor(i);
        setActionbarColor(i);
        BW(i);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTile");
      if (!bu.isNullOrNil(paramBundle))
      {
        localObject1 = this.pFZ;
        if (localObject1 == null) {
          p.bdF("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmMainTileColor");
      if (!bu.isNullOrNil(paramBundle))
      {
        localObject1 = this.pFZ;
        if (localObject1 == null) {
          p.bdF("bottomBrandClickableTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
        localObject1 = this.pGa;
        if (localObject1 == null) {
          p.bdF("bottomBrandClickableImg");
        }
        ((WeImageView)localObject1).setIconColor(Color.parseColor(paramBundle));
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitle");
      if (!bu.isNullOrNil(paramBundle))
      {
        localObject1 = this.pGb;
        if (localObject1 == null) {
          p.bdF("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setText((CharSequence)paramBundle);
      }
      paramBundle = getIntent().getStringExtra("SpringCard.BtmSubTitleColor");
      if (!bu.isNullOrNil(paramBundle))
      {
        localObject1 = this.pGb;
        if (localObject1 == null) {
          p.bdF("bottomBrandIntroTxt");
        }
        ((TextView)localObject1).setTextColor(Color.parseColor(paramBundle));
      }
      paramBundle = this.pGn;
      if (paramBundle == null) {
        p.bdF("brandCardBlessingStyleImgMedia");
      }
      paramBundle.setImageResource(2131231321);
      paramBundle = this.pGp;
      if (paramBundle == null) {
        p.bdF("brandCardBlessingStyleBottomImg");
      }
      paramBundle.setImageResource(2131231319);
      paramBundle = this.cBv;
      if (paramBundle == null) {
        p.bdF("uiHandler");
      }
      paramBundle.postDelayed(this.pGw, 3000L);
      this.pGs = System.currentTimeMillis();
      if (com.tencent.mm.sdk.platformtools.j.DEBUG)
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
      com.tencent.mm.kernel.g.ajj().a(2809, (f)this);
      com.tencent.mm.kernel.g.ajj().a(2812, (f)this);
      this.ilP = getIntent().getStringExtra("SpringCard.KeyWord");
      this.appId = getIntent().getStringExtra("SpringCard.AppId");
      this.jWi = getIntent().getStringExtra("SpringCard.TraceId");
      if ((!bu.isNullOrNil(this.ilP)) && (!bu.isNullOrNil(this.appId)) && (!bu.isNullOrNil(this.jWi))) {
        break label1427;
      }
    }
    for (;;)
    {
      this.pGt = ((com.tencent.mm.app.o)new j(this));
      paramBundle = AppForegroundDelegate.cTA;
      localObject1 = this.pGt;
      if (localObject1 == null) {
        p.bdF("appForegroundLis");
      }
      paramBundle.a((com.tencent.mm.app.o)localObject1);
      AppMethodBeat.o(108179);
      return;
      paramBundle = this.pGc;
      if (paramBundle == null) {
        p.bdF("luckyBagLoadingImg");
      }
      paramBundle.setImageResource(2131232880);
      break;
      label1427:
      paramBundle = EmojiDebugUI.gjU;
      if (EmojiDebugUI.aeB())
      {
        ae.d("MicroMsg.SpringCardActivity", "stop cgi!!!");
      }
      else
      {
        paramBundle = this.ilP;
        if (paramBundle == null) {
          p.gkB();
        }
        localObject1 = this.appId;
        if (localObject1 == null) {
          p.gkB();
        }
        localObject2 = this.jWi;
        if (localObject2 == null) {
          p.gkB();
        }
        paramBundle = new com.tencent.mm.plugin.eggspring.c.b(paramBundle, (String)localObject1, (String)localObject2);
        com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)paramBundle);
      }
    }
  }
  
  public final void onDataAvailable(final String paramString, final long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(108200);
    p.h(paramString, "mediaId");
    ae.d("MicroMsg.SpringCardActivity", "onDataAvailable!!! mediaId[%s] offset[%s] length[%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    if ((this.pGr != null) && (this.pGq != null) && (p.i(this.pGq, paramString))) {
      ar.f((Runnable)new k(this, paramString, paramLong1, paramLong2));
    }
    AppMethodBeat.o(108200);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(108183);
    super.onDestroy();
    Object localObject = this.pGq;
    if (localObject != null) {
      com.tencent.mm.modelvideo.o.aNi().m((String)localObject, null);
    }
    if (this.pGA)
    {
      localObject = this.pGo;
      if (localObject == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIDestroy();
    }
    com.tencent.mm.kernel.g.ajj().b(2809, (f)this);
    com.tencent.mm.kernel.g.ajj().b(2812, (f)this);
    ae.i("MicroMsg.SpringCardActivity", "videoInfo, count:[%s], rptCount:[%s], duration:[%s], curPoi:[%s].", new Object[] { Integer.valueOf(this.count), Integer.valueOf(this.pGz), Integer.valueOf(this.duration), Integer.valueOf(this.pGy) });
    if (this.count >= 0)
    {
      this.pGx = (this.count * this.duration + this.pGy);
      localObject = com.tencent.mm.plugin.eggspring.a.pFw;
      localObject = com.tencent.mm.plugin.eggspring.a.cgU();
      int i = this.duration;
      int j = this.pGz;
      int k = this.pGx;
      com.tencent.mm.plugin.report.service.g.yxI.f(18916, new Object[] { ((com.tencent.mm.plugin.eggspring.a)localObject).pFs, ((com.tencent.mm.plugin.eggspring.a)localObject).pFu, Integer.valueOf(16), "", Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    }
    for (;;)
    {
      localObject = AppForegroundDelegate.cTA;
      com.tencent.mm.app.o localo = this.pGt;
      if (localo == null) {
        p.bdF("appForegroundLis");
      }
      ((AppForegroundDelegate)localObject).b(localo);
      AppMethodBeat.o(108183);
      return;
      localObject = com.tencent.mm.plugin.eggspring.a.pFw;
      com.tencent.mm.plugin.eggspring.a.cgU().BV(16);
    }
  }
  
  public final void onDownloadProgressChanged(String paramString, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(108188);
    p.h(paramString, "filekey");
    ae.d("MicroMsg.SpringCardActivity", "onDownloadProgressChanged, fileKey [%s], finished [%s], total [%s].", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(108188);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(108182);
    super.onPause();
    if (this.pGA)
    {
      SpringEggVideoView localSpringEggVideoView = this.pGo;
      if (localSpringEggVideoView == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      this.pGy = localSpringEggVideoView.getCurrPosMs();
      ae.d("MicroMsg.SpringCardActivity", "videoInfo, curPoi: [%s].", new Object[] { Integer.valueOf(this.pGy) });
      localSpringEggVideoView = this.pGo;
      if (localSpringEggVideoView == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      localSpringEggVideoView.onUIPause();
    }
    AppMethodBeat.o(108182);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(108181);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.eggspring.a.pFw;
    com.tencent.mm.plugin.eggspring.a.cgU().BV(1);
    if (this.pGA)
    {
      localObject = this.pGo;
      if (localObject == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject).onUIResume();
    }
    AppMethodBeat.o(108181);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(108184);
    p.h(paramn, "scene");
    ae.i("MicroMsg.SpringCardActivity", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject1;
    if (2809 == paramn.getType())
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 5);
        AppMethodBeat.o(108184);
        return;
      }
      if (this.pGB)
      {
        ae.i("MicroMsg.SpringCardActivity", "card is showing, return.");
        AppMethodBeat.o(108184);
        return;
      }
      this.pFR = ((com.tencent.mm.plugin.eggspring.c.b)paramn).pFR;
      if (this.pFR == null) {
        break label3226;
      }
      ae.i("MicroMsg.SpringCardActivity", "brandCardContent: %s.", new Object[] { String.valueOf(this.pFR) });
      paramString = com.tencent.mm.plugin.eggspring.a.pFw;
      paramn = com.tencent.mm.plugin.eggspring.a.cgU();
      paramString = this.pFR;
      if (paramString != null)
      {
        paramString = Integer.valueOf(paramString.pFK);
        paramn.pFu = paramString;
        if (this.pFR != null)
        {
          localObject1 = this.pFR;
          if (localObject1 != null)
          {
            if ((bu.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFA)) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFC == null)) {
              break label498;
            }
            paramString = com.tencent.mm.plugin.eggspring.a.pFw;
            com.tencent.mm.plugin.eggspring.a.cgU().BV(2);
            paramString = this.pFZ;
            if (paramString == null) {
              p.bdF("bottomBrandClickableTxt");
            }
            paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFA);
            paramString = this.pGa;
            if (paramString == null) {
              p.bdF("bottomBrandClickableImg");
            }
            paramString.setVisibility(0);
            if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz) || (!bu.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFF))) {
              break label550;
            }
            ae.e("MicroMsg.SpringCardActivity", "red pocket type, accept url is invalid!!!");
          }
        }
      }
      for (;;)
      {
        paramString = this.pFR;
        if (paramString == null) {
          break label2594;
        }
        if (4 != paramString.pFz) {
          break label2470;
        }
        if (1 != paramString.pFI) {
          break label2167;
        }
        if (!bu.isNullOrNil(paramString.pFB))
        {
          paramn = paramString.pFB;
          if (paramn == null) {
            p.gkB();
          }
          if (!com.tencent.mm.vfs.o.fB(Gc(paramn))) {
            break label2144;
          }
          paramn = this.pGn;
          if (paramn == null) {
            p.bdF("brandCardBlessingStyleImgMedia");
          }
          localObject1 = paramString.pFB;
          if (localObject1 == null) {
            p.gkB();
          }
          paramn.setImageFilePath(Gc((String)localObject1));
          BX(0);
        }
        label408:
        if (bu.isNullOrNil(paramString.pFH)) {
          break label2587;
        }
        paramn = paramString.pFH;
        if (paramn == null) {
          p.gkB();
        }
        if (!com.tencent.mm.vfs.o.fB(Gc(paramn))) {
          break label2446;
        }
        paramn = this.pGp;
        if (paramn == null) {
          p.bdF("brandCardBlessingStyleBottomImg");
        }
        paramString = paramString.pFH;
        if (paramString == null) {
          p.gkB();
        }
        paramn.setImageFilePath(Gc(paramString));
        BX(1);
        AppMethodBeat.o(108184);
        return;
        paramString = null;
        break;
        label498:
        if (((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFC == null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.e("MicroMsg.SpringCardActivity", "not support jump!!! jumpInfo==null? [%s].", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 8);
          break;
        }
        label550:
        if ((2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz) || (((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFG != null)) {
          break label579;
        }
        ae.e("MicroMsg.SpringCardActivity", "coupon type, couponInfo is null!!!");
      }
      label579:
      if (4 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz)
      {
        paramString = this.pGm;
        if (paramString == null) {
          p.bdF("brandCardBlessingStyleLayout");
        }
        g(paramString, aq.fromDPToPix((Context)getContext(), 144));
        paramString = this.pGn;
        if (paramString == null) {
          p.bdF("brandCardBlessingStyleImgMedia");
        }
        paramString = (View)paramString;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFI) {
          break label3233;
        }
        paramString = this.pGo;
        if (paramString == null) {
          p.bdF("brandCardBlessingStyleVideoMedia");
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
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFJ)
      {
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFI)
        {
          paramn = com.tencent.mm.plugin.eggspring.a.pFw;
          com.tencent.mm.plugin.eggspring.a.cgU().BV(6);
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
          localObject3 = this.pGp;
          if (localObject3 == null) {
            p.bdF("brandCardBlessingStyleBottomImg");
          }
          ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((MMAnimateView)localObject3).getId());
          ((RelativeLayout.LayoutParams)localObject2).addRule(14);
          localObject3 = this.pGm;
          if (localObject3 == null) {
            p.bdF("brandCardBlessingStyleLayout");
          }
          ((ViewGroup)localObject3).removeView(paramString);
          localObject3 = new FrameLayout.LayoutParams(-1, -1);
          paramString.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          paramn.addView(paramString, (ViewGroup.LayoutParams)localObject3);
          paramString = this.pGm;
          if (paramString == null) {
            p.bdF("brandCardBlessingStyleLayout");
          }
          paramString.addView((View)paramn, (ViewGroup.LayoutParams)localObject2);
          if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFI) {
            break;
          }
          paramString = this.pGn;
          if (paramString == null) {
            p.bdF("brandCardBlessingStyleImgMedia");
          }
          paramString.setDefaultImageResource(2131231320);
          paramString = this.pGn;
          if (paramString == null) {
            p.bdF("brandCardBlessingStyleImgMedia");
          }
          paramString.setImageResource(2131231320);
          break;
          paramn = com.tencent.mm.plugin.eggspring.a.pFw;
          com.tencent.mm.plugin.eggspring.a.cgU().BV(8);
        }
      }
      if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFJ) {
        break;
      }
      if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFI)
      {
        paramn = com.tencent.mm.plugin.eggspring.a.pFw;
        com.tencent.mm.plugin.eggspring.a.cgU().BV(5);
      }
      for (;;)
      {
        paramn = this.pGm;
        if (paramn == null) {
          p.bdF("brandCardBlessingStyleLayout");
        }
        paramn.removeView(paramString);
        paramn = new RelativeLayout.LayoutParams(-2, -2);
        localObject1 = this.pGp;
        if (localObject1 == null) {
          p.bdF("brandCardBlessingStyleBottomImg");
        }
        paramn.addRule(2, ((MMAnimateView)localObject1).getId());
        paramn.addRule(14);
        localObject1 = this.pGm;
        if (localObject1 == null) {
          p.bdF("brandCardBlessingStyleLayout");
        }
        ((ViewGroup)localObject1).addView(paramString, (ViewGroup.LayoutParams)paramn);
        break;
        paramn = com.tencent.mm.plugin.eggspring.a.pFw;
        com.tencent.mm.plugin.eggspring.a.cgU().BV(7);
      }
      if ((1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz) && (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz)) {
        break;
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandIcon");
      if (!bu.isNullOrNil(paramString))
      {
        paramn = this.pGf;
        if (paramn == null) {
          p.bdF("brandCardTitleLogo");
        }
        localObject2 = new StringBuilder();
        localObject3 = com.tencent.mm.plugin.eggspring.b.b.pFL;
        paramn.setImageFilePath(com.tencent.mm.plugin.eggspring.b.b.a.cgW() + paramString);
      }
      paramString = getIntent().getStringExtra("SpringCard.BrandName");
      if (!bu.isNullOrNil(paramString))
      {
        paramn = this.pGg;
        if (paramn == null) {
          p.bdF("brandCardTitleName");
        }
        paramn.setText((CharSequence)paramString);
      }
      paramString = "";
      paramn = "";
      if (1 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz)
      {
        paramString = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandRedPocketCoverSubTitle");
        label1318:
        if (!bu.isNullOrNil(paramString))
        {
          localObject2 = this.pGh;
          if (localObject2 == null) {
            p.bdF("brandCardMainWording");
          }
          ((TextView)localObject2).setText((CharSequence)paramString);
        }
        if (!bu.isNullOrNil(paramn))
        {
          paramString = this.pGi;
          if (paramString == null) {
            p.bdF("brandCardSubWording");
          }
          paramString.setText((CharSequence)paramn);
        }
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFD))
        {
          paramString = this.pGh;
          if (paramString == null) {
            p.bdF("brandCardMainWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFD);
        }
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFE))
        {
          paramString = this.pGi;
          if (paramString == null) {
            p.bdF("brandCardSubWording");
          }
          paramString.setText((CharSequence)((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFE);
        }
        paramString = this.pGk;
        if (paramString == null) {
          p.bdF("brandCardMediaLayout");
        }
        g(paramString, 0);
        paramString = this.pGk;
        if (paramString == null) {
          p.bdF("brandCardMediaLayout");
        }
        paramn = this.pGl;
        if (paramn == null) {
          p.bdF("brandCardImgMedia");
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
        localObject2 = this.pGk;
        if (localObject2 == null) {
          p.bdF("brandCardMediaLayout");
        }
        ((ViewGroup)localObject2).addView((View)paramString, (ViewGroup.LayoutParams)paramn);
        paramn = new FrameLayout.LayoutParams(-2, -2);
        if (1 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz) {
          break label2010;
        }
        localObject1 = getContext();
        p.g(localObject1, "context");
        paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166752);
        localObject1 = getContext();
        p.g(localObject1, "context");
        paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166751);
        localObject1 = this.pGl;
        if (localObject1 == null) {
          p.bdF("brandCardImgMedia");
        }
        ((MMAnimateView)localObject1).setImageResource(2131233816);
        localObject1 = this.pGj;
        if (localObject1 == null) {
          p.bdF("brandCardAcceptBtn");
        }
        ((Button)localObject1).setText(2131755116);
        localObject1 = com.tencent.mm.plugin.eggspring.a.pFw;
        com.tencent.mm.plugin.eggspring.a.cgU().BV(3);
      }
      for (;;)
      {
        localObject1 = this.pGl;
        if (localObject1 == null) {
          p.bdF("brandCardImgMedia");
        }
        paramString.addView((View)localObject1, (ViewGroup.LayoutParams)paramn);
        paramString = this.pGe;
        if (paramString == null) {
          p.bdF("brandCardTitleLayout");
        }
        paramString.setVisibility(0);
        paramString = this.pGh;
        if (paramString == null) {
          p.bdF("brandCardMainWording");
        }
        paramString.setVisibility(0);
        paramString = this.pGi;
        if (paramString == null) {
          p.bdF("brandCardSubWording");
        }
        paramString.setVisibility(0);
        paramString = this.pGj;
        if (paramString == null) {
          p.bdF("brandCardAcceptBtn");
        }
        paramString.setVisibility(0);
        paramString = this.pGk;
        if (paramString == null) {
          p.bdF("brandCardMediaLayout");
        }
        paramString.setVisibility(0);
        paramString = this.pGm;
        if (paramString == null) {
          p.bdF("brandCardBlessingStyleLayout");
        }
        paramString.setVisibility(8);
        break;
        if (2 != ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz) {
          break label1318;
        }
        paramString = getIntent().getStringExtra("SpringCard.BrandCouponMainTitle");
        paramn = getIntent().getStringExtra("SpringCard.BrandCouponSubTitle");
        break label1318;
        label2010:
        if (2 == ((com.tencent.mm.plugin.eggspring.b.a)localObject1).pFz)
        {
          localObject1 = getContext();
          p.g(localObject1, "context");
          paramn.width = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166077);
          localObject1 = getContext();
          p.g(localObject1, "context");
          paramn.height = ((AppCompatActivity)localObject1).getResources().getDimensionPixelSize(2131166076);
          localObject1 = this.pGl;
          if (localObject1 == null) {
            p.bdF("brandCardImgMedia");
          }
          ((MMAnimateView)localObject1).setImageResource(2131231861);
          localObject1 = this.pGj;
          if (localObject1 == null) {
            p.bdF("brandCardAcceptBtn");
          }
          ((Button)localObject1).setText(2131755113);
          localObject1 = com.tencent.mm.plugin.eggspring.a.pFw;
          com.tencent.mm.plugin.eggspring.a.cgU().BV(4);
        }
      }
      label2144:
      paramn = paramString.pFB;
      if (paramn == null) {
        p.gkB();
      }
      abQ(paramn);
      break label408;
      label2167:
      if (2 != paramString.pFI) {
        break label408;
      }
      paramn = this.pGn;
      if (paramn == null) {
        p.bdF("brandCardBlessingStyleImgMedia");
      }
      paramn.setVisibility(8);
      paramn = this.pGo;
      if (paramn == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      paramn.setVisibility(0);
      this.pGA = true;
      paramn = this.pFR;
      if ((paramn == null) || (bu.isNullOrNil(paramn.pFB))) {
        break label408;
      }
      localObject1 = this.pGo;
      if (localObject1 == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setLoop(true);
      localObject1 = this.pGo;
      if (localObject1 == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMVideoViewCallback((i.b)this);
      localObject1 = this.pGo;
      if (localObject1 == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIMMDownloadFinish((i.a)this);
      localObject1 = this.pGo;
      if (localObject1 == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this);
      localObject1 = this.pGo;
      if (localObject1 == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      ((SpringEggVideoView)localObject1).c(false, paramn.pFB, 0);
      localObject1 = this.pGo;
      if (localObject1 == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      paramn = paramn.pFB;
      if (paramn == null) {
        p.gkB();
      }
      ((SpringEggVideoView)localObject1).setFilepath(abR(paramn));
      paramn = this.pGo;
      if (paramn == null) {
        p.bdF("brandCardBlessingStyleVideoMedia");
      }
      paramn.start();
      break label408;
      paramString = paramString.pFH;
      if (paramString == null) {
        p.gkB();
      }
      abQ(paramString);
      AppMethodBeat.o(108184);
      return;
      label2470:
      if (((1 == paramString.pFz) || (2 == paramString.pFz)) && (!bu.isNullOrNil(paramString.pFB)))
      {
        paramn = paramString.pFB;
        if (paramn == null) {
          p.gkB();
        }
        if (com.tencent.mm.vfs.o.fB(Gc(paramn)))
        {
          paramn = this.pGl;
          if (paramn == null) {
            p.bdF("brandCardImgMedia");
          }
          paramString = paramString.pFB;
          if (paramString == null) {
            p.gkB();
          }
          paramn.setImageFilePath(Gc(paramString));
          cgX();
          AppMethodBeat.o(108184);
          return;
        }
        paramString = paramString.pFB;
        if (paramString == null) {
          p.gkB();
        }
        abQ(paramString);
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
          paramString = com.tencent.mm.plugin.eggspring.a.pFw;
          com.tencent.mm.plugin.eggspring.a.cgU().BV(14);
          com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 6);
          paramString = (Context)getContext();
          paramn = getContext();
          p.g(paramn, "context");
          t.co(paramString, paramn.getResources().getString(2131764540));
          AppMethodBeat.o(108184);
          return;
        }
        paramString = (com.tencent.mm.plugin.eggspring.c.a)paramn;
        paramn = paramString.pFO;
        ae.i("MicroMsg.SpringCardActivity", "coupon, retCode: %s, retMsg: %s.", new Object[] { paramn, paramString.pFP });
        if (paramn != null)
        {
          long l = ((Number)paramn).longValue();
          if (0L == l)
          {
            paramString = com.tencent.mm.plugin.eggspring.a.pFw;
            com.tencent.mm.plugin.eggspring.a.cgU().BV(13);
            paramString = (Context)getContext();
            paramn = getContext();
            p.g(paramn, "context");
            t.cn(paramString, paramn.getResources().getString(2131755117));
            paramString = this.pGj;
            if (paramString == null) {
              p.bdF("brandCardAcceptBtn");
            }
            paramString.setText(2131755115);
            paramString = this.pGj;
            if (paramString == null) {
              p.bdF("brandCardAcceptBtn");
            }
            paramString.setEnabled(false);
          }
          for (;;)
          {
            if (l != 0L)
            {
              paramString = com.tencent.mm.plugin.eggspring.a.pFw;
              com.tencent.mm.plugin.eggspring.a.cgU().BV(14);
              com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 6);
            }
            AppMethodBeat.o(108184);
            return;
            if ((268456656L == l) || (268457508L == l) || (268456641L == l) || (268456640L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.co(paramString, paramn.getResources().getString(2131757954));
              paramString = this.pGj;
              if (paramString == null) {
                p.bdF("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.pGj;
              if (paramString == null) {
                p.bdF("brandCardAcceptBtn");
              }
              paramString.setEnabled(false);
            }
            else if ((268456461L == l) || (268455949L == l) || (268456007L == l) || (268456320L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.co(paramString, paramn.getResources().getString(2131756775));
              paramString = this.pGj;
              if (paramString == null) {
                p.bdF("brandCardAcceptBtn");
              }
              paramString.setText(2131755114);
              paramString = this.pGj;
              if (paramString == null) {
                p.bdF("brandCardAcceptBtn");
              }
              paramString.setEnabled(false);
            }
            else if ((270100487L == l) || (270100488L == l))
            {
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.co(paramString, paramn.getResources().getString(2131764540));
            }
            else
            {
              ae.i("MicroMsg.SpringCardActivity", "other err![%s]", new Object[] { paramn });
              paramString = (Context)getContext();
              paramn = getContext();
              p.g(paramn, "context");
              t.co(paramString, paramn.getResources().getString(2131756775));
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
    this.pGq = paramString1;
    if (com.tencent.mm.vfs.o.fB(PluginEggSpring.pFm + "MMVideo_" + paramString3.hashCode() + ".mp4"))
    {
      a(paramString1, 0, null);
      AppMethodBeat.o(108195);
      return;
    }
    e locale = com.tencent.mm.modelvideo.o.aNi();
    h localh = new h();
    localh.fLl = "task_SpringCardActivity";
    localh.field_mediaId = paramString1;
    localh.url = paramString3;
    localh.fLI = 1;
    localh.fLD = 5;
    localh.concurrentCount = 3;
    localh.field_fullpath = paramString2;
    localh.fLQ = ((h.a)this);
    locale.a(localh, false);
    AppMethodBeat.o(108195);
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(108197);
    String str = this.pGq;
    if (str != null)
    {
      if (p.i(str, paramString))
      {
        com.tencent.mm.modelvideo.o.aNi();
        e.r(paramString, paramInt1, paramInt2);
      }
      AppMethodBeat.o(108197);
      return;
    }
    AppMethodBeat.o(108197);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108165);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      if (SpringCardActivity.q(this.pGE).getVisibility() == 0)
      {
        paramView = com.tencent.mm.plugin.eggspring.a.pFw;
        com.tencent.mm.plugin.eggspring.a.cgU().BV(10);
        paramView = (Context)this.pGE;
        localObject = SpringCardActivity.r(this.pGE);
        if (localObject == null) {
          p.gkB();
        }
        com.tencent.mm.plugin.eggspring.d.a.a(paramView, ((com.tencent.mm.plugin.eggspring.b.a)localObject).pFC);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108165);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108166);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = SpringCardActivity.r(this.pGE);
      if (paramView != null) {
        switch (paramView.pFz)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$boundView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(108166);
        return;
        if (!bu.isNullOrNil(paramView.pFF))
        {
          localObject = com.tencent.mm.plugin.eggspring.a.pFw;
          com.tencent.mm.plugin.eggspring.a.cgU().BV(11);
          ae.d("MicroMsg.SpringCardActivity", "acceptRedPocketCoverUrl: %s.", new Object[] { paramView.pFF });
          localObject = new Intent();
          ((Intent)localObject).putExtra("rawUrl", paramView.pFF);
          com.tencent.mm.br.d.b((Context)this.pGE.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
        }
        else
        {
          ae.e("MicroMsg.SpringCardActivity", "red pocket cover accept url is invalid, impossible!!!");
          continue;
          paramView = paramView.pFG;
          if (paramView != null)
          {
            localObject = com.tencent.mm.plugin.eggspring.a.pFw;
            com.tencent.mm.plugin.eggspring.a.cgU().BV(12);
            paramView = new com.tencent.mm.plugin.eggspring.c.a(paramView);
            com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)paramView);
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(SpringCardActivity paramSpringCardActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(162211);
      this.pGE.finish();
      AppMethodBeat.o(162211);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(160272);
      if (SpringCardActivity.r(this.pGE) != null)
      {
        localObject = SpringCardActivity.r(this.pGE);
        if (localObject == null) {
          p.gkB();
        }
        if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).pFz == 4) || (SpringCardActivity.g(this.pGE).getVisibility() != 0))
        {
          localObject = SpringCardActivity.r(this.pGE);
          if (localObject == null) {
            p.gkB();
          }
          if ((((com.tencent.mm.plugin.eggspring.b.a)localObject).pFz != 4) || (SpringCardActivity.x(this.pGE)) || (SpringCardActivity.y(this.pGE))) {
            break label117;
          }
        }
      }
      Object localObject = com.tencent.mm.plugin.eggspring.a.pFw;
      com.tencent.mm.plugin.eggspring.a.cgU().BV(9);
      com.tencent.mm.plugin.report.service.g.yxI.dD(1263, 7);
      label117:
      SpringCardActivity.a(this.pGE);
      AppMethodBeat.o(160272);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(SpringCardActivity paramSpringCardActivity, String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(108169);
      if (SpringCardActivity.j(this.pGE))
      {
        AppMethodBeat.o(108169);
        return;
      }
      com.tencent.mm.plugin.eggspring.b.a locala = SpringCardActivity.r(this.pGE);
      if (locala != null)
      {
        if ((p.i(paramString, locala.pFB)) && ((1 == locala.pFz) || (2 == locala.pFz) || ((4 == locala.pFz) && (2 != locala.pFI))))
        {
          ae.d("MicroMsg.SpringCardActivity", "onC2CDownloadCompleted, filekey: [%s], cardType: [%s].", new Object[] { paramString, Integer.valueOf(locala.pFz) });
          if (4 == locala.pFz)
          {
            SpringCardActivity.i(this.pGE).setImageFilePath(SpringCardActivity.abT(paramString));
            SpringCardActivity.c(this.pGE, 0);
            AppMethodBeat.o(108169);
            return;
          }
          if ((1 == locala.pFz) || (2 == locala.pFz))
          {
            SpringCardActivity.t(this.pGE).setImageFilePath(SpringCardActivity.abT(paramString));
            SpringCardActivity.u(this.pGE);
          }
          AppMethodBeat.o(108169);
          return;
        }
        if ((p.i(paramString, locala.pFH)) && (4 == locala.pFz))
        {
          SpringCardActivity.v(this.pGE).setImageFilePath(SpringCardActivity.abT(paramString));
          SpringCardActivity.c(this.pGE, 1);
        }
        AppMethodBeat.o(108169);
        return;
      }
      AppMethodBeat.o(108169);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108170);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      SpringCardActivity.a(this.pGE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108170);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108171);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      SpringCardActivity.b(this.pGE).setVisibility(8);
      SpringCardActivity.c(this.pGE).setVisibility(8);
      SpringCardActivity.d(this.pGE).setVisibility(8);
      SpringCardActivity.e(this.pGE).setVisibility(8);
      SpringCardActivity.f(this.pGE).setVisibility(8);
      SpringCardActivity.g(this.pGE).setVisibility(0);
      SpringCardActivity.h(this.pGE).setLoop(true);
      SpringCardActivity.h(this.pGE).setIMMVideoViewCallback((i.b)this.pGE);
      SpringCardActivity.h(this.pGE).setIMMDownloadFinish((i.a)this.pGE);
      SpringCardActivity.h(this.pGE).setIOnlineVideoProxy((com.tencent.mm.modelvideo.b)this.pGE);
      SpringCardActivity.h(this.pGE).c(false, "http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023", 0);
      SpringCardActivity.h(this.pGE).setFilepath(SpringCardActivity.abS("http://wxsnsdy.wxs.qq.com/105/20210/snsdyvideodownload?m=2db9548b50447c83a47c69b7054b536c&filekey=30340201010420301e0201690402534804102db9548b50447c83a47c69b7054b536c0203146fae040d00000004627466730000000131&hy=SH&storeid=32303138303731323036353235363030306236313235313336666664393330343561333230613030303030303639&bizid=1023"));
      SpringCardActivity.h(this.pGE).start();
      SpringCardActivity.i(this.pGE).setVisibility(8);
      SpringCardActivity.h(this.pGE).setVisibility(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108171);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(SpringCardActivity paramSpringCardActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(108172);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      SpringCardActivity.k(this.pGE);
      SpringCardActivity.l(this.pGE).setVisibility(0);
      SpringCardActivity.m(this.pGE).setVisibility(4);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108172);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$onCreate$4", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-eggspring_release"})
  public static final class j
    implements com.tencent.mm.app.o
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(162213);
      ae.d("MicroMsg.SpringCardActivity", "onAppBackground");
      if (SpringCardActivity.n(this.pGE))
      {
        SpringCardActivity.a(this.pGE, SpringCardActivity.o(this.pGE) - 1);
        SpringCardActivity.b(this.pGE, SpringCardActivity.p(this.pGE) - 1);
      }
      AppMethodBeat.o(162213);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(162212);
      ae.d("MicroMsg.SpringCardActivity", "onAppForeground");
      AppMethodBeat.o(162212);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108173);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pGE);
      if (locala == null) {
        p.gkB();
      }
      locala.onDataAvailable(paramString, paramLong1, this.pGI);
      AppMethodBeat.o(108173);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(SpringCardActivity paramSpringCardActivity, String paramString, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(108174);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pGE);
      if (locala == null) {
        p.gkB();
      }
      locala.at(paramString, paramInt);
      AppMethodBeat.o(108174);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class m
    implements Runnable
  {
    m(SpringCardActivity paramSpringCardActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(160273);
      SpringCardActivity.a(this.pGE);
      AppMethodBeat.o(160273);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class n
    implements Runnable
  {
    n(SpringCardActivity paramSpringCardActivity, String paramString1, long paramLong1, long paramLong2, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108175);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pGE);
      if (locala == null) {
        p.gkB();
      }
      locala.sC(paramLong1);
      AppMethodBeat.o(108175);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class o
    implements Runnable
  {
    o(SpringCardActivity paramSpringCardActivity, String paramString, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(108176);
      com.tencent.mm.modelvideo.b.a locala = SpringCardActivity.w(this.pGE);
      if (locala == null) {
        p.gkB();
      }
      locala.i(paramString, paramLong1, this.pGL);
      AppMethodBeat.o(108176);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/eggspring/ui/SpringCardActivity$playCardAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-eggspring_release"})
  public static final class p
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(108177);
      ae.d("MicroMsg.SpringCardActivity", "onAnimationEnd");
      SpringCardActivity.l(this.pGE).setVisibility(8);
      paramAnimator = com.tencent.mm.plugin.eggspring.a.pFw;
      paramAnimator = com.tencent.mm.plugin.eggspring.a.cgU();
      long l1 = System.currentTimeMillis();
      long l2 = SpringCardActivity.s(this.pGE);
      com.tencent.mm.plugin.report.service.g.yxI.f(18916, new Object[] { paramAnimator.pFs, paramAnimator.pFu, Integer.valueOf(15), Long.valueOf(l1 - l2) });
      AppMethodBeat.o(108177);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(108178);
      ae.d("MicroMsg.SpringCardActivity", "onAnimationStart");
      AppMethodBeat.o(108178);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.ui.SpringCardActivity
 * JD-Core Version:    0.7.0.1
 */