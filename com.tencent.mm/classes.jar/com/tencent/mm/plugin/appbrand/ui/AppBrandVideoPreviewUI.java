package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.vj;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.z;
import com.tencent.mm.message.z.a;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/message/MsgJobCallback;", "()V", "BASIC_PADDING", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOGGLE_PADDING", "appBrandVideoViewControlBar", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar;", "mAdditionButtonStr", "mAdditionMsgId", "", "Ljava/lang/Long;", "mAdditionSenderUsername", "mAdditionStartAppBrandId", "mAdditionTalkerUsername", "mAdditionText", "mChattingType", "Ljava/lang/Integer;", "mCoverUrl", "mExtData", "Landroid/os/Bundle;", "mLocalPath", "mScene", "mShouldAutoSave", "", "Ljava/lang/Boolean;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "checkParams", "doInBackground", "", "job", "Lcom/tencent/mm/message/MsgJobCallback$Job;", "doOnlySelectRecordMsg", "bundle", "failDoJob", "getLayoutId", "getUIFlag", "initVideoView", "isFromMoreSelectRetransmit", "isJustTransAsNormalMsg", "isOnlySelectRecordMsg", "onCreate", "savedInstanceState", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "onWindowFocusChanged", "hasFocus", "reportWitrhType", "type", "requestExitSelectedMode", "resumeEditMode", "setWindowStyle", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandVideoPreviewUI
  extends MMActivity
  implements z
{
  private final String TAG;
  private Bundle rnY;
  private String szP;
  private String ufS;
  private AppBrandVideoView ufT;
  private String ufU;
  private Boolean ufV;
  private Integer ufW;
  private Integer ufX;
  private String ufY;
  private String ufZ;
  private String uga;
  private Long ugb;
  private String ugc;
  private String ugd;
  private AppBrandVideoViewControlBar uge;
  private int ugf;
  private int ugg;
  
  public AppBrandVideoPreviewUI()
  {
    AppMethodBeat.i(51170);
    this.TAG = "MicroMsg.AppBrandVideoPreviewUI";
    this.szP = "";
    this.ufU = "";
    this.ufV = Boolean.FALSE;
    this.ufW = Integer.valueOf(0);
    this.ufX = Integer.valueOf(0);
    this.ufY = "";
    this.ufZ = "";
    this.uga = "";
    this.ugb = Long.valueOf(-1L);
    this.ugc = "";
    this.ugd = "";
    AppMethodBeat.o(51170);
  }
  
  private final void Dm(int paramInt)
  {
    AppMethodBeat.i(51165);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    if (au.bwE(this.ugc)) {}
    for (int i = 2;; i = 1)
    {
      localh.b(17608, new Object[] { Integer.valueOf(i), this.uga, Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(51165);
      return;
    }
  }
  
  private static final void a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, int paramInt)
  {
    AppMethodBeat.i(322433);
    s.u(paramAppBrandVideoPreviewUI, "this$0");
    if ((paramInt & 0x4) == 0) {
      paramAppBrandVideoPreviewUI.getWindow().getDecorView().setSystemUiVisibility(1280);
    }
    AppMethodBeat.o(322433);
  }
  
  private static final void a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView)
  {
    AppMethodBeat.i(322418);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAppBrandVideoPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAppBrandVideoPreviewUI, "this$0");
    paramAppBrandVideoPreviewUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322418);
  }
  
  private static final void a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(322442);
    s.u(paramAppBrandVideoPreviewUI, "this$0");
    if (!paramBoolean)
    {
      ((ImageView)paramAppBrandVideoPreviewUI.findViewById(ba.f.preview_close)).setVisibility(8);
      ((ImageView)paramAppBrandVideoPreviewUI.findViewById(ba.f.preview_share)).setVisibility(8);
      paramView = paramView.getLayoutParams();
      if (paramView == null)
      {
        paramAppBrandVideoPreviewUI = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(322442);
        throw paramAppBrandVideoPreviewUI;
      }
      ((RelativeLayout.LayoutParams)paramView).bottomMargin = paramAppBrandVideoPreviewUI.ugf;
      AppMethodBeat.o(322442);
      return;
    }
    ((ImageView)paramAppBrandVideoPreviewUI.findViewById(ba.f.preview_close)).setVisibility(0);
    ((ImageView)paramAppBrandVideoPreviewUI.findViewById(ba.f.preview_share)).setVisibility(0);
    paramView = paramView.getLayoutParams();
    if (paramView == null)
    {
      paramAppBrandVideoPreviewUI = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(322442);
      throw paramAppBrandVideoPreviewUI;
    }
    ((RelativeLayout.LayoutParams)paramView).bottomMargin = paramAppBrandVideoPreviewUI.ugg;
    AppMethodBeat.o(322442);
  }
  
  private static final boolean a(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(322429);
    s.u(paramAppBrandVideoPreviewUI, "this$0");
    paramAppBrandVideoPreviewUI.onBackPressed();
    AppMethodBeat.o(322429);
    return true;
  }
  
  private static final void b(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView)
  {
    AppMethodBeat.i(322424);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAppBrandVideoPreviewUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramAppBrandVideoPreviewUI, "this$0");
    Log.i(paramAppBrandVideoPreviewUI.TAG, "hy: on click menu");
    paramView = new vj();
    paramView.hZb.context = ((Context)paramAppBrandVideoPreviewUI);
    paramView.hZb.hZc = au.bwE(paramAppBrandVideoPreviewUI.ugc);
    localObject1 = new ArrayList();
    localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ();
    Long localLong = paramAppBrandVideoPreviewUI.ugb;
    s.checkNotNull(localLong);
    localObject2 = ((i)localObject2).sl(localLong.longValue());
    s.checkNotNull(localObject2);
    ((ArrayList)localObject1).add(localObject2);
    paramView.hZb.hXy = ((List)localObject1);
    paramView.hZb.talker = paramAppBrandVideoPreviewUI.ugc;
    paramView.hZb.hZd = ((z)paramAppBrandVideoPreviewUI);
    paramView.publish();
    paramAppBrandVideoPreviewUI.Dm(3);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322424);
  }
  
  private static final void c(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView)
  {
    AppMethodBeat.i(322438);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAppBrandVideoPreviewUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramAppBrandVideoPreviewUI, "this$0");
    Log.i(paramAppBrandVideoPreviewUI.TAG, s.X("hy: request start to appid ", paramAppBrandVideoPreviewUI.uga));
    paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ();
    localObject1 = paramAppBrandVideoPreviewUI.ugb;
    s.checkNotNull(localObject1);
    paramView = paramView.sl(((Long)localObject1).longValue());
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("stat_scene", 11);
    s.checkNotNull(paramView);
    ((Bundle)localObject1).putString("stat_msg_id", s.X("msg_", Long.toString(paramView.field_msgSvrId)));
    ((Bundle)localObject1).putString("stat_chat_talker_username", paramAppBrandVideoPreviewUI.ugc);
    ((Bundle)localObject1).putString("stat_send_msg_user", paramAppBrandVideoPreviewUI.ugd);
    localObject2 = paramAppBrandVideoPreviewUI.ugc;
    s.checkNotNull(localObject2);
    String str = paramAppBrandVideoPreviewUI.ugd;
    s.checkNotNull(str);
    com.tencent.mm.modelappbrand.b.a((String)localObject2, str, 1136, k.b.Hf(paramView.field_content), (Bundle)localObject1);
    paramAppBrandVideoPreviewUI.Dm(5);
    paramAppBrandVideoPreviewUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(322438);
  }
  
  public final void O(Bundle paramBundle) {}
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(z.a parama)
  {
    AppMethodBeat.i(51161);
    Log.i(this.TAG, "hy: fail do job: %s", new Object[] { parama });
    AppMethodBeat.o(51161);
  }
  
  public final void b(z.a parama)
  {
    AppMethodBeat.i(51162);
    Log.i(this.TAG, "hy: doInBackground do job: %s", new Object[] { parama });
    AppMethodBeat.o(51162);
  }
  
  public final boolean bws()
  {
    return true;
  }
  
  public final boolean bwt()
  {
    return false;
  }
  
  public final boolean bwu()
  {
    return false;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(51163);
    Log.i(this.TAG, "hy: requestExitSelectedMode do job: %s", new Object[] { parama });
    if (parama == z.a.nVv) {
      Dm(4);
    }
    AppMethodBeat.o(51163);
  }
  
  public final int getLayoutId()
  {
    return ba.g.app_brand_video_preview_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51164);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ys(true);
    getWindow().setNavigationBarColor(-16777216);
    getWindow().setStatusBarColor(0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new AppBrandVideoPreviewUI..ExternalSyntheticLambda4(this));
    this.ugf = com.tencent.mm.cd.a.bs((Context)this, ba.d.LargerPadding);
    this.ugg = (com.tencent.mm.cd.a.bs((Context)this, ba.d.app_brand_video_control_bar_height) + this.ugf);
    this.ufS = getIntent().getStringExtra("key_video_url");
    this.szP = getIntent().getStringExtra("key_cover_path");
    this.ufU = getIntent().getStringExtra("key_local_file_path");
    this.ufV = Boolean.valueOf(getIntent().getBooleanExtra("key_auto_save", false));
    this.ufW = Integer.valueOf(getIntent().getIntExtra("key_scene", 0));
    this.rnY = getIntent().getBundleExtra("key_ext_data");
    if (this.szP != null)
    {
      paramBundle = this.szP;
      s.checkNotNull(paramBundle);
      if (kotlin.n.n.U(paramBundle, "/", false)) {
        this.szP = s.X("file:/", this.szP);
      }
    }
    int i;
    if (Util.isNullOrNil(this.ufS)) {
      i = 0;
    }
    label278:
    label302:
    label318:
    label334:
    label350:
    label366:
    label382:
    Object localObject;
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(51164);
      return;
      paramBundle = this.ufW;
      if (paramBundle == null) {}
      while (paramBundle.intValue() != 1)
      {
        i = 1;
        break;
      }
      paramBundle = this.rnY;
      if (paramBundle == null)
      {
        paramBundle = null;
        this.ufX = paramBundle;
        paramBundle = this.rnY;
        if (paramBundle != null) {
          break label452;
        }
        paramBundle = null;
        this.ufY = paramBundle;
        paramBundle = this.rnY;
        if (paramBundle != null) {
          break label463;
        }
        paramBundle = null;
        this.ufZ = paramBundle;
        paramBundle = this.rnY;
        if (paramBundle != null) {
          break label474;
        }
        paramBundle = null;
        this.uga = paramBundle;
        paramBundle = this.rnY;
        if (paramBundle != null) {
          break label485;
        }
        paramBundle = null;
        this.ugb = paramBundle;
        paramBundle = this.rnY;
        if (paramBundle != null) {
          break label502;
        }
        paramBundle = null;
        this.ugc = paramBundle;
        paramBundle = this.rnY;
        if (paramBundle != null) {
          break label513;
        }
      }
      label513:
      for (paramBundle = null;; paramBundle = paramBundle.getString("key_sender_username"))
      {
        this.ugd = paramBundle;
        if ((!Util.isNullOrNil(this.uga)) && (!Util.isNullOrNil(this.ugc)) && (!Util.isNullOrNil(this.ugd))) {
          break label524;
        }
        i = 0;
        break;
        paramBundle = Integer.valueOf(paramBundle.getInt("key_chatting_type"));
        break label302;
        label452:
        paramBundle = paramBundle.getString("key_chatting_wording");
        break label318;
        label463:
        paramBundle = paramBundle.getString("key_chatting_text");
        break label334;
        label474:
        paramBundle = paramBundle.getString("key_chatting_appid");
        break label350;
        label485:
        paramBundle = Long.valueOf(paramBundle.getLong("key_msg_id", -1L));
        break label366;
        label502:
        paramBundle = paramBundle.getString("key_talker_username");
        break label382;
      }
      label524:
      if (this.ugb != null)
      {
        paramBundle = this.ugb;
        if (paramBundle == null) {}
        while (paramBundle.longValue() != -1L)
        {
          paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ();
          localObject = this.ugb;
          s.checkNotNull(localObject);
          if (paramBundle.sl(((Long)localObject).longValue()) != null) {
            break label278;
          }
          i = 0;
          break;
        }
      }
      i = 0;
    }
    Dm(2);
    paramBundle = this.ufW;
    if (paramBundle == null)
    {
      setBackBtn(new AppBrandVideoPreviewUI..ExternalSyntheticLambda0(this));
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(-16777216);
      label641:
      paramBundle = new AppBrandVideoWrapper((Context)this);
      this.ufT = new AppBrandVideoView((Context)this, (View)paramBundle);
      this.uge = new AppBrandVideoViewControlBar((Context)this);
      localObject = this.uge;
      s.checkNotNull(localObject);
      ((AppBrandVideoViewControlBar)localObject).setId(ba.f.app_brand_video_preview_ui_controller_bar_id);
      localObject = this.ufT;
      if (localObject != null) {
        ((AppBrandVideoView)localObject).a((d.a)this.uge);
      }
      paramBundle.setVideoFooterView((d.b)this.uge);
      paramBundle = this.ufX;
      if (paramBundle != null) {
        break label1107;
      }
    }
    for (;;)
    {
      ((RelativeLayout)findViewById(ba.f.contentFrameLayout)).addView((View)this.ufT, 0, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setAutoPlay(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setLoop(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setMute(false);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setCookieData(null);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.abL(this.szP);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setObjectFit("contain");
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setShowDanmakuBtn(false);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setShowMuteBtn(false);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setShowPlayBtn(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setShowProgress(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setShowFullScreenBtn(false);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setIsShowBasicControls(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setIsEnableBottomProgressBar(false);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setShowCenterPlayBtn(false);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setShowControlProgress(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.setPageGesture(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.jG(true);
      }
      paramBundle = this.ufT;
      if (paramBundle != null) {
        paramBundle.e(this.ufS, false, 0);
      }
      paramBundle = this.ufW;
      if (paramBundle != null) {
        break label1133;
      }
      AppMethodBeat.o(51164);
      return;
      if (paramBundle.intValue() != 1) {
        break;
      }
      ((ImageView)findViewById(ba.f.preview_close)).setOnClickListener(new AppBrandVideoPreviewUI..ExternalSyntheticLambda1(this));
      ((ImageView)findViewById(ba.f.preview_share)).setOnClickListener(new AppBrandVideoPreviewUI..ExternalSyntheticLambda3(this));
      break label641;
      label1107:
      if (paramBundle.intValue() == 48)
      {
        paramBundle = this.uge;
        if (paramBundle != null) {
          paramBundle.setAutoHide(false);
        }
      }
    }
    label1133:
    if (paramBundle.intValue() == 1)
    {
      paramBundle = LayoutInflater.from((Context)this).inflate(ba.g.app_brand_video_preview_additional, (ViewGroup)findViewById(ba.f.contentFrameLayout), false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = this.ugg;
      ((RelativeLayout)findViewById(ba.f.contentFrameLayout)).addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      ((TextView)paramBundle.findViewById(ba.f.addition_text)).setText((CharSequence)this.ufY);
      localObject = (Button)paramBundle.findViewById(ba.f.addition_button);
      ((Button)localObject).setText((CharSequence)this.ufZ);
      ((Button)localObject).setOnClickListener(new AppBrandVideoPreviewUI..ExternalSyntheticLambda2(this));
      localObject = this.uge;
      if (localObject != null) {
        ((AppBrandVideoViewControlBar)localObject).a(new AppBrandVideoPreviewUI..ExternalSyntheticLambda5(this, paramBundle));
      }
    }
    AppMethodBeat.o(51164);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51169);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.ufT;
    if (localAppBrandVideoView != null) {
      localAppBrandVideoView.onUIDestroy();
    }
    AppMethodBeat.o(51169);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51168);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.ufT;
    if (localAppBrandVideoView != null) {
      localAppBrandVideoView.Bd(3);
    }
    AppMethodBeat.o(51168);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51167);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.ufT;
    if (localAppBrandVideoView != null) {
      localAppBrandVideoView.onUIResume();
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
    getWindow().getDecorView().setSystemUiVisibility(1280);
    AppMethodBeat.o(51166);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */