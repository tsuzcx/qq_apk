package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mm.ag.z;
import com.tencent.mm.ag.z.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/message/MsgJobCallback;", "()V", "BASIC_PADDING", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOGGLE_PADDING", "appBrandVideoViewControlBar", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar;", "mAdditionButtonStr", "mAdditionMsgId", "", "Ljava/lang/Long;", "mAdditionSenderUsername", "mAdditionStartAppBrandId", "mAdditionTalkerUsername", "mAdditionText", "mChattingType", "Ljava/lang/Integer;", "mCoverUrl", "mExtData", "Landroid/os/Bundle;", "mLocalPath", "mScene", "mShouldAutoSave", "", "Ljava/lang/Boolean;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "checkParams", "doInBackground", "", "job", "Lcom/tencent/mm/message/MsgJobCallback$Job;", "doOnlySelectRecordMsg", "bundle", "failDoJob", "getLayoutId", "getUIFlag", "initVideoView", "isFromMoreSelectRetransmit", "isJustTransAsNormalMsg", "isOnlySelectRecordMsg", "onCreate", "savedInstanceState", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "onWindowFocusChanged", "hasFocus", "reportWitrhType", "type", "requestExitSelectedMode", "resumeEditMode", "setWindowStyle", "plugin-appbrand-integration_release"})
public final class AppBrandVideoPreviewUI
  extends MMActivity
  implements z
{
  final String TAG;
  private HashMap _$_findViewCache;
  private Bundle lpM;
  private String mwj;
  private int nYA;
  private String nYm;
  private AppBrandVideoView nYn;
  private String nYo;
  private Boolean nYp;
  private Integer nYq;
  private Integer nYr;
  private String nYs;
  private String nYt;
  private String nYu;
  private Long nYv;
  private String nYw;
  private String nYx;
  private AppBrandVideoViewControlBar nYy;
  private int nYz;
  
  public AppBrandVideoPreviewUI()
  {
    AppMethodBeat.i(51170);
    this.TAG = "MicroMsg.AppBrandVideoPreviewUI";
    this.mwj = "";
    this.nYo = "";
    this.nYp = Boolean.FALSE;
    this.nYq = Integer.valueOf(0);
    this.nYr = Integer.valueOf(0);
    this.nYs = "";
    this.nYt = "";
    this.nYu = "";
    this.nYv = Long.valueOf(-1L);
    this.nYw = "";
    this.nYx = "";
    AppMethodBeat.o(51170);
  }
  
  private final void zp(int paramInt)
  {
    AppMethodBeat.i(51165);
    h localh = h.CyF;
    if (ab.Eq(this.nYw)) {}
    for (int i = 2;; i = 1)
    {
      localh.a(17608, new Object[] { Integer.valueOf(i), this.nYu, Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(51165);
      return;
    }
  }
  
  public final void B(Bundle paramBundle) {}
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229540);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229540);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229539);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(229539);
    return localView1;
  }
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(51161);
    Log.i(this.TAG, "hy: fail do job: %s", new Object[] { parama });
    AppMethodBeat.o(51161);
  }
  
  public final boolean aSC()
  {
    return true;
  }
  
  public final boolean aSD()
  {
    return false;
  }
  
  public final boolean aSE()
  {
    return false;
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(51162);
    Log.i(this.TAG, "hy: doInBackground do job: %s", new Object[] { parama });
    AppMethodBeat.o(51162);
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(51163);
    Log.i(this.TAG, "hy: requestExitSelectedMode do job: %s", new Object[] { parama });
    if (parama == z.a.iAU) {
      zp(4);
    }
    AppMethodBeat.o(51163);
  }
  
  public final int getLayoutId()
  {
    return 2131493116;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(51164);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.rb(true);
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
    this.nYz = com.tencent.mm.cb.a.aH((Context)this, 2131165501);
    this.nYA = (com.tencent.mm.cb.a.aH((Context)this, 2131165893) + this.nYz);
    this.nYm = getIntent().getStringExtra("key_video_url");
    this.mwj = getIntent().getStringExtra("key_cover_path");
    this.nYo = getIntent().getStringExtra("key_local_file_path");
    this.nYp = Boolean.valueOf(getIntent().getBooleanExtra("key_auto_save", false));
    this.nYq = Integer.valueOf(getIntent().getIntExtra("key_scene", 0));
    this.lpM = getIntent().getBundleExtra("key_ext_data");
    if (this.mwj != null)
    {
      paramBundle = this.mwj;
      if (paramBundle == null) {
        p.hyc();
      }
      if (n.J(paramBundle, "/", false)) {
        this.mwj = ("file:/" + this.mwj);
      }
    }
    int i;
    if (Util.isNullOrNil(this.nYm)) {
      i = 0;
    }
    label370:
    Object localObject;
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(51164);
      return;
      paramBundle = this.nYq;
      if (paramBundle == null) {}
      while (paramBundle.intValue() != 1)
      {
        i = 1;
        break;
      }
      paramBundle = this.lpM;
      if (paramBundle != null)
      {
        paramBundle = Integer.valueOf(paramBundle.getInt("key_chatting_type"));
        this.nYr = paramBundle;
        paramBundle = this.lpM;
        if (paramBundle == null) {
          break label553;
        }
        paramBundle = paramBundle.getString("key_chatting_wording");
        label392:
        this.nYs = paramBundle;
        paramBundle = this.lpM;
        if (paramBundle == null) {
          break label558;
        }
        paramBundle = paramBundle.getString("key_chatting_text");
        label414:
        this.nYt = paramBundle;
        paramBundle = this.lpM;
        if (paramBundle == null) {
          break label563;
        }
        paramBundle = paramBundle.getString("key_chatting_appid");
        label436:
        this.nYu = paramBundle;
        paramBundle = this.lpM;
        if (paramBundle == null) {
          break label568;
        }
        paramBundle = Long.valueOf(paramBundle.getLong("key_msg_id", -1L));
        label464:
        this.nYv = paramBundle;
        paramBundle = this.lpM;
        if (paramBundle == null) {
          break label573;
        }
        paramBundle = paramBundle.getString("key_talker_username");
        label486:
        this.nYw = paramBundle;
        paramBundle = this.lpM;
        if (paramBundle == null) {
          break label578;
        }
      }
      label553:
      label558:
      label563:
      label568:
      label573:
      label578:
      for (paramBundle = paramBundle.getString("key_sender_username");; paramBundle = null)
      {
        this.nYx = paramBundle;
        if ((!Util.isNullOrNil(this.nYu)) && (!Util.isNullOrNil(this.nYw)) && (!Util.isNullOrNil(this.nYx))) {
          break label583;
        }
        i = 0;
        break;
        paramBundle = null;
        break label370;
        paramBundle = null;
        break label392;
        paramBundle = null;
        break label414;
        paramBundle = null;
        break label436;
        paramBundle = null;
        break label464;
        paramBundle = null;
        break label486;
      }
      label583:
      if (this.nYv != null)
      {
        paramBundle = this.nYv;
        if (paramBundle == null) {}
        while (paramBundle.longValue() != -1L)
        {
          paramBundle = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
          p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
          paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).eiy();
          localObject = this.nYv;
          if (localObject == null) {
            p.hyc();
          }
          paramBundle.Hb(((Long)localObject).longValue());
          break;
        }
      }
      i = 0;
    }
    zp(2);
    paramBundle = this.nYq;
    if (paramBundle == null)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandVideoPreviewUI.e(this));
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(-16777216);
      label711:
      paramBundle = new AppBrandVideoWrapper((Context)this);
      this.nYn = new AppBrandVideoView((Context)this, (View)paramBundle);
      this.nYy = new AppBrandVideoViewControlBar((Context)this);
      localObject = this.nYy;
      if (localObject == null) {
        p.hyc();
      }
      ((AppBrandVideoViewControlBar)localObject).setId(2131296933);
      localObject = this.nYn;
      if (localObject != null) {
        ((AppBrandVideoView)localObject).a((e.a)this.nYy);
      }
      paramBundle.setVideoFooterView((e.b)this.nYy);
      paramBundle = this.nYr;
      if (paramBundle != null) {
        break label1185;
      }
    }
    for (;;)
    {
      ((RelativeLayout)findViewById(2131299181)).addView((View)this.nYn, 0, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setAutoPlay(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setLoop(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setMute(false);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setCookieData(null);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setCover$16da05f7(this.mwj);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setObjectFit("contain");
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setShowDanmakuBtn(false);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setShowMuteBtn(false);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setShowPlayBtn(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setShowProgress(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setShowFullScreenBtn(false);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setIsShowBasicControls(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setIsEnableBottomProgressBar(false);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setShowCenterPlayBtn(false);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setShowControlProgress(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.setPageGesture(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.hM(true);
      }
      paramBundle = this.nYn;
      if (paramBundle != null) {
        paramBundle.e(this.nYm, false, 0);
      }
      paramBundle = this.nYq;
      if (paramBundle != null) {
        break label1211;
      }
      AppMethodBeat.o(51164);
      return;
      if (paramBundle.intValue() != 1) {
        break;
      }
      ((ImageView)findViewById(2131306106)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.c(this));
      ((ImageView)findViewById(2131306118)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.d(this));
      break label711;
      label1185:
      if (paramBundle.intValue() == 48)
      {
        paramBundle = this.nYy;
        if (paramBundle != null) {
          paramBundle.setAutoHide(false);
        }
      }
    }
    label1211:
    if (paramBundle.intValue() == 1)
    {
      paramBundle = LayoutInflater.from((Context)this).inflate(2131493115, (ViewGroup)findViewById(2131299181), false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = this.nYA;
      ((RelativeLayout)findViewById(2131299181)).addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = paramBundle.findViewById(2131296541);
      p.g(localObject, "additionView.findViewByI…View>(R.id.addition_text)");
      ((TextView)localObject).setText((CharSequence)this.nYs);
      localObject = (Button)paramBundle.findViewById(2131296540);
      p.g(localObject, "startBtn");
      ((Button)localObject).setText((CharSequence)this.nYt);
      ((Button)localObject).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.a(this));
      localObject = this.nYy;
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
    AppBrandVideoView localAppBrandVideoView = this.nYn;
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
    AppBrandVideoView localAppBrandVideoView = this.nYn;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.xr(3);
      AppMethodBeat.o(51168);
      return;
    }
    AppMethodBeat.o(51168);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51167);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.nYn;
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
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    Object localObject = getWindow();
    p.g(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.g(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1280);
    AppMethodBeat.o(51166);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements e.f
  {
    b(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView) {}
    
    public final void onVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(51156);
      if (!paramBoolean)
      {
        localObject = this.nYB.findViewById(2131306106);
        p.g(localObject, "findViewById<ImageView>(R.id.preview_close)");
        ((ImageView)localObject).setVisibility(8);
        localObject = this.nYB.findViewById(2131306118);
        p.g(localObject, "findViewById<ImageView>(R.id.preview_share)");
        ((ImageView)localObject).setVisibility(8);
        localObject = paramBundle;
        p.g(localObject, "additionView");
        localObject = ((View)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(51156);
          throw ((Throwable)localObject);
        }
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.e(this.nYB);
        AppMethodBeat.o(51156);
        return;
      }
      Object localObject = this.nYB.findViewById(2131306106);
      p.g(localObject, "findViewById<ImageView>(R.id.preview_close)");
      ((ImageView)localObject).setVisibility(0);
      localObject = this.nYB.findViewById(2131306118);
      p.g(localObject, "findViewById<ImageView>(R.id.preview_share)");
      ((ImageView)localObject).setVisibility(0);
      localObject = paramBundle;
      p.g(localObject, "additionView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(51156);
        throw ((Throwable)localObject);
      }
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.f(this.nYB);
      AppMethodBeat.o(51156);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onSystemUiVisibilityChange"})
  static final class f
    implements View.OnSystemUiVisibilityChangeListener
  {
    f(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
    
    public final void onSystemUiVisibilityChange(int paramInt)
    {
      AppMethodBeat.i(51160);
      if ((paramInt & 0x4) == 0)
      {
        Object localObject = this.nYB.getWindow();
        p.g(localObject, "window");
        localObject = ((Window)localObject).getDecorView();
        p.g(localObject, "window.decorView");
        ((View)localObject).setSystemUiVisibility(AppBrandVideoPreviewUI.bXI());
      }
      AppMethodBeat.o(51160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */