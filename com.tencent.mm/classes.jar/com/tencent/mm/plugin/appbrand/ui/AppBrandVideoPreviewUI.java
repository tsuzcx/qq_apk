package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.z;
import com.tencent.mm.ai.z.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.n.n;
import d.v;

@com.tencent.mm.ui.base.a(32)
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/message/MsgJobCallback;", "()V", "BASIC_PADDING", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOGGLE_PADDING", "appBrandVideoViewControlBar", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar;", "mAdditionButtonStr", "mAdditionMsgId", "", "Ljava/lang/Long;", "mAdditionSenderUsername", "mAdditionStartAppBrandId", "mAdditionTalkerUsername", "mAdditionText", "mChattingType", "Ljava/lang/Integer;", "mCoverUrl", "mExtData", "Landroid/os/Bundle;", "mLocalPath", "mScene", "mShouldAutoSave", "", "Ljava/lang/Boolean;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "checkParams", "doInBackground", "", "job", "Lcom/tencent/mm/message/MsgJobCallback$Job;", "doOnlySelectRecordMsg", "bundle", "failDoJob", "getLayoutId", "getUIFlag", "initVideoView", "isJustTransAsNormalMsg", "isOnlySelectRecordMsg", "onCreate", "savedInstanceState", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "onWindowFocusChanged", "hasFocus", "reportWitrhType", "type", "requestExitSelectedMode", "resumeEditMode", "setWindowStyle", "plugin-appbrand-integration_release"})
public final class AppBrandVideoPreviewUI
  extends MMActivity
  implements z
{
  final String TAG;
  private Bundle kiL;
  private String llg;
  private String mFX;
  private AppBrandVideoView mFY;
  private String mFZ;
  private Boolean mGa;
  private Integer mGb;
  private Integer mGc;
  private String mGd;
  private String mGe;
  private String mGf;
  private Long mGg;
  private String mGh;
  private String mGi;
  private AppBrandVideoViewControlBar mGj;
  private int mGk;
  private int mGl;
  
  public AppBrandVideoPreviewUI()
  {
    AppMethodBeat.i(51170);
    this.TAG = "MicroMsg.AppBrandVideoPreviewUI";
    this.llg = "";
    this.mFZ = "";
    this.mGa = Boolean.FALSE;
    this.mGb = Integer.valueOf(0);
    this.mGc = Integer.valueOf(0);
    this.mGd = "";
    this.mGe = "";
    this.mGf = "";
    this.mGg = Long.valueOf(-1L);
    this.mGh = "";
    this.mGi = "";
    AppMethodBeat.o(51170);
  }
  
  private final void vw(int paramInt)
  {
    AppMethodBeat.i(51165);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    if (w.vF(this.mGh)) {}
    for (int i = 2;; i = 1)
    {
      localg.f(17608, new Object[] { Integer.valueOf(i), this.mGf, Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(51165);
      return;
    }
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(51161);
    ad.i(this.TAG, "hy: fail do job: %s", new Object[] { parama });
    AppMethodBeat.o(51161);
  }
  
  public final boolean azg()
  {
    return true;
  }
  
  public final boolean azh()
  {
    return false;
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(51162);
    ad.i(this.TAG, "hy: doInBackground do job: %s", new Object[] { parama });
    AppMethodBeat.o(51162);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(51163);
    ad.i(this.TAG, "hy: requestExitSelectedMode do job: %s", new Object[] { parama });
    if (parama == z.a.hDT) {
      vw(4);
    }
    AppMethodBeat.o(51163);
  }
  
  public final int getLayoutId()
  {
    return 2131493074;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(51164);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.or(true);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.setNavigationBarColor(-16777216);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.setStatusBarColor(0);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.getDecorView().setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)new f(this));
    this.mGk = com.tencent.mm.cc.a.ay((Context)this, 2131165483);
    this.mGl = (com.tencent.mm.cc.a.ay((Context)this, 2131165867) + this.mGk);
    this.mFX = getIntent().getStringExtra("key_video_url");
    this.llg = getIntent().getStringExtra("key_cover_path");
    this.mFZ = getIntent().getStringExtra("key_local_file_path");
    this.mGa = Boolean.valueOf(getIntent().getBooleanExtra("key_auto_save", false));
    this.mGb = Integer.valueOf(getIntent().getIntExtra("key_scene", 0));
    this.kiL = getIntent().getBundleExtra("key_ext_data");
    if (this.llg != null)
    {
      paramBundle = this.llg;
      if (paramBundle == null) {
        p.gfZ();
      }
      if (n.nz(paramBundle, "/")) {
        this.llg = ("file:/" + this.llg);
      }
    }
    int i;
    if (bt.isNullOrNil(this.mFX)) {
      i = 0;
    }
    label364:
    Object localObject;
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(51164);
      return;
      paramBundle = this.mGb;
      if (paramBundle == null) {}
      while (paramBundle.intValue() != 1)
      {
        i = 1;
        break;
      }
      paramBundle = this.kiL;
      if (paramBundle != null)
      {
        paramBundle = Integer.valueOf(paramBundle.getInt("key_chatting_type"));
        this.mGc = paramBundle;
        paramBundle = this.kiL;
        if (paramBundle == null) {
          break label547;
        }
        paramBundle = paramBundle.getString("key_chatting_wording");
        label386:
        this.mGd = paramBundle;
        paramBundle = this.kiL;
        if (paramBundle == null) {
          break label552;
        }
        paramBundle = paramBundle.getString("key_chatting_text");
        label408:
        this.mGe = paramBundle;
        paramBundle = this.kiL;
        if (paramBundle == null) {
          break label557;
        }
        paramBundle = paramBundle.getString("key_chatting_appid");
        label430:
        this.mGf = paramBundle;
        paramBundle = this.kiL;
        if (paramBundle == null) {
          break label562;
        }
        paramBundle = Long.valueOf(paramBundle.getLong("key_msg_id", -1L));
        label458:
        this.mGg = paramBundle;
        paramBundle = this.kiL;
        if (paramBundle == null) {
          break label567;
        }
        paramBundle = paramBundle.getString("key_talker_username");
        label480:
        this.mGh = paramBundle;
        paramBundle = this.kiL;
        if (paramBundle == null) {
          break label572;
        }
      }
      label547:
      label552:
      label557:
      label562:
      label567:
      label572:
      for (paramBundle = paramBundle.getString("key_sender_username");; paramBundle = null)
      {
        this.mGi = paramBundle;
        if ((!bt.isNullOrNil(this.mGf)) && (!bt.isNullOrNil(this.mGh)) && (!bt.isNullOrNil(this.mGi))) {
          break label577;
        }
        i = 0;
        break;
        paramBundle = null;
        break label364;
        paramBundle = null;
        break label386;
        paramBundle = null;
        break label408;
        paramBundle = null;
        break label430;
        paramBundle = null;
        break label458;
        paramBundle = null;
        break label480;
      }
      label577:
      if (this.mGg != null)
      {
        paramBundle = this.mGg;
        if (paramBundle == null) {}
        while (paramBundle.longValue() != -1L)
        {
          paramBundle = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
          paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).dlK();
          localObject = this.mGg;
          if (localObject == null) {
            p.gfZ();
          }
          paramBundle.xY(((Long)localObject).longValue());
          break;
        }
      }
      i = 0;
    }
    vw(2);
    paramBundle = this.mGb;
    if (paramBundle == null)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandVideoPreviewUI.e(this));
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(-16777216);
      label704:
      paramBundle = new AppBrandVideoWrapper((Context)this);
      this.mFY = new AppBrandVideoView((Context)this, (View)paramBundle);
      this.mGj = new AppBrandVideoViewControlBar((Context)this);
      localObject = this.mGj;
      if (localObject == null) {
        p.gfZ();
      }
      ((AppBrandVideoViewControlBar)localObject).setId(2131296841);
      localObject = this.mFY;
      if (localObject != null) {
        ((AppBrandVideoView)localObject).a((e.a)this.mGj);
      }
      paramBundle.setVideoFooterView((e.b)this.mGj);
      paramBundle = this.mGc;
      if (paramBundle != null) {
        break label1178;
      }
    }
    for (;;)
    {
      ((RelativeLayout)findViewById(2131298740)).addView((View)this.mFY, 0, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setAutoPlay(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setLoop(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setMute(false);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setCookieData(null);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setCover$16da05f7(this.llg);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setObjectFit("contain");
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setShowDanmakuBtn(false);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setShowMuteBtn(false);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setShowPlayBtn(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setShowProgress(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setShowFullScreenBtn(false);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setIsShowBasicControls(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setIsEnableBottomProgressBar(false);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setShowCenterPlayBtn(false);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setShowControlProgress(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.setPageGesture(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.gP(true);
      }
      paramBundle = this.mFY;
      if (paramBundle != null) {
        paramBundle.e(this.mFX, false, 0);
      }
      paramBundle = this.mGb;
      if (paramBundle != null) {
        break label1204;
      }
      AppMethodBeat.o(51164);
      return;
      if (paramBundle.intValue() != 1) {
        break;
      }
      ((ImageView)findViewById(2131303392)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.c(this));
      ((ImageView)findViewById(2131303400)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.d(this));
      break label704;
      label1178:
      if (paramBundle.intValue() == 48)
      {
        paramBundle = this.mGj;
        if (paramBundle != null) {
          paramBundle.setAutoHide(false);
        }
      }
    }
    label1204:
    if (paramBundle.intValue() == 1)
    {
      paramBundle = LayoutInflater.from((Context)this).inflate(2131493073, (ViewGroup)findViewById(2131298740), false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = this.mGl;
      ((RelativeLayout)findViewById(2131298740)).addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = paramBundle.findViewById(2131296468);
      p.g(localObject, "additionView.findViewByI…View>(R.id.addition_text)");
      ((TextView)localObject).setText((CharSequence)this.mGd);
      localObject = (Button)paramBundle.findViewById(2131296467);
      p.g(localObject, "startBtn");
      ((Button)localObject).setText((CharSequence)this.mGe);
      ((Button)localObject).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.a(this));
      localObject = this.mGj;
      if (localObject != null)
      {
        ((AppBrandVideoViewControlBar)localObject).a((e.f)new b(this, paramBundle));
        AppMethodBeat.o(51164);
        return;
      }
    }
    AppMethodBeat.o(51164);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51169);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.mFY;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIDestroy();
      AppMethodBeat.o(51169);
      return;
    }
    AppMethodBeat.o(51169);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51168);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.mFY;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.tp(3);
      AppMethodBeat.o(51168);
      return;
    }
    AppMethodBeat.o(51168);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51167);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.mFY;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.onUIResume();
      AppMethodBeat.o(51167);
      return;
    }
    AppMethodBeat.o(51167);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(51166);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1280);
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(51166);
  }
  
  public final void u(Bundle paramBundle) {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements e.f
  {
    b(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView) {}
    
    public final void onVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(51156);
      if (!paramBoolean)
      {
        localObject = this.mGm.findViewById(2131303392);
        p.g(localObject, "findViewById<ImageView>(R.id.preview_close)");
        ((ImageView)localObject).setVisibility(8);
        localObject = this.mGm.findViewById(2131303400);
        p.g(localObject, "findViewById<ImageView>(R.id.preview_share)");
        ((ImageView)localObject).setVisibility(8);
        localObject = paramBundle;
        p.g(localObject, "additionView");
        localObject = ((View)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(51156);
          throw ((Throwable)localObject);
        }
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.e(this.mGm);
        AppMethodBeat.o(51156);
        return;
      }
      Object localObject = this.mGm.findViewById(2131303392);
      p.g(localObject, "findViewById<ImageView>(R.id.preview_close)");
      ((ImageView)localObject).setVisibility(0);
      localObject = this.mGm.findViewById(2131303400);
      p.g(localObject, "findViewById<ImageView>(R.id.preview_share)");
      ((ImageView)localObject).setVisibility(0);
      localObject = paramBundle;
      p.g(localObject, "additionView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(51156);
        throw ((Throwable)localObject);
      }
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.f(this.mGm);
      AppMethodBeat.o(51156);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "onSystemUiVisibilityChange"})
  static final class f
    implements View.OnSystemUiVisibilityChangeListener
  {
    f(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
    
    public final void onSystemUiVisibilityChange(int paramInt)
    {
      AppMethodBeat.i(51160);
      if ((paramInt & 0x4) == 0)
      {
        Object localObject = this.mGm.getWindow();
        p.g(localObject, "window");
        localObject = ((Window)localObject).getDecorView();
        p.g(localObject, "window.decorView");
        ((View)localObject).setSystemUiVisibility(AppBrandVideoPreviewUI.bzI());
      }
      AppMethodBeat.o(51160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */