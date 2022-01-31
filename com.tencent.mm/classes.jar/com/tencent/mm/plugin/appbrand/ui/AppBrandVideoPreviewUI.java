package com.tencent.mm.plugin.appbrand.ui;

import a.l;
import a.l.m;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.t.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/message/MsgJobCallback;", "()V", "BASIC_PADDING", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOGGLE_PADDING", "appBrandVideoViewControlBar", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoViewControlBar;", "mAdditionButtonStr", "mAdditionMsgId", "", "Ljava/lang/Long;", "mAdditionSenderUsername", "mAdditionStartAppBrandId", "mAdditionTalkerUsername", "mAdditionText", "mCoverUrl", "mExtData", "Landroid/os/Bundle;", "mLocalPath", "mScene", "Ljava/lang/Integer;", "mShouldAutoSave", "", "Ljava/lang/Boolean;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "checkParams", "doInBackground", "", "job", "Lcom/tencent/mm/message/MsgJobCallback$Job;", "failDoJob", "getLayoutId", "initVideoView", "isJustTransAsNormalMsg", "onCreate", "savedInstanceState", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "reportWitrhType", "type", "requestExitSelectedMode", "resumeEditMode", "setWindowStyle", "plugin-appbrand-integration_release"})
@com.tencent.mm.ui.base.a(32)
public final class AppBrandVideoPreviewUI
  extends MMActivity
  implements com.tencent.mm.af.t
{
  final String TAG;
  private Bundle hrf;
  private String iPG;
  private AppBrandVideoView iPH;
  private String iPI;
  private Boolean iPJ;
  private Integer iPK;
  private String iPL;
  private String iPM;
  private String iPN;
  private Long iPO;
  private String iPP;
  private String iPQ;
  private AppBrandVideoViewControlBar iPR;
  private int iPS;
  private int iPT;
  private String icM;
  
  public AppBrandVideoPreviewUI()
  {
    AppMethodBeat.i(143995);
    this.TAG = "MicroMsg.AppBrandVideoPreviewUI";
    this.icM = "";
    this.iPI = "";
    this.iPJ = Boolean.FALSE;
    this.iPK = Integer.valueOf(0);
    this.iPL = "";
    this.iPM = "";
    this.iPN = "";
    this.iPO = Long.valueOf(-1L);
    this.iPP = "";
    this.iPQ = "";
    AppMethodBeat.o(143995);
  }
  
  private final void pC(int paramInt)
  {
    AppMethodBeat.i(143994);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.qsU;
    if (com.tencent.mm.model.t.lA(this.iPP)) {}
    for (int i = 2;; i = 1)
    {
      localh.e(17608, new Object[] { Integer.valueOf(i), this.iPN, Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(143994);
      return;
    }
  }
  
  public final boolean Yr()
  {
    return true;
  }
  
  public final void a(t.a parama)
  {
    AppMethodBeat.i(143991);
    ab.i(this.TAG, "hy: fail do job: %s", new Object[] { parama });
    AppMethodBeat.o(143991);
  }
  
  public final void b(t.a parama)
  {
    AppMethodBeat.i(143992);
    ab.i(this.TAG, "hy: doInBackground do job: %s", new Object[] { parama });
    AppMethodBeat.o(143992);
  }
  
  public final void c(t.a parama)
  {
    AppMethodBeat.i(143993);
    ab.i(this.TAG, "hy: requestExitSelectedMode do job: %s", new Object[] { parama });
    if (parama == t.a.fke) {
      pC(4);
    }
    AppMethodBeat.o(143993);
  }
  
  public final int getLayoutId()
  {
    return 2130968749;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(135004);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    d.jm(true);
    this.iPS = com.tencent.mm.cb.a.ap((Context)this, 2131427775);
    this.iPT = (com.tencent.mm.cb.a.ap((Context)this, 2131428091) + this.iPS);
    this.iPG = getIntent().getStringExtra("key_video_url");
    this.icM = getIntent().getStringExtra("key_cover_path");
    this.iPI = getIntent().getStringExtra("key_local_file_path");
    this.iPJ = Boolean.valueOf(getIntent().getBooleanExtra("key_auto_save", false));
    this.iPK = Integer.valueOf(getIntent().getIntExtra("key_scene", 0));
    this.hrf = getIntent().getBundleExtra("key_ext_data");
    if (this.icM != null)
    {
      paramBundle = this.icM;
      if (paramBundle == null) {
        a.f.b.j.ebi();
      }
      if (m.jw(paramBundle, "/")) {
        this.icM = ("file:/" + this.icM);
      }
    }
    int i;
    if (bo.isNullOrNil(this.iPG)) {
      i = 0;
    }
    label286:
    label308:
    label330:
    label358:
    label380:
    Object localObject;
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(135004);
      return;
      paramBundle = this.iPK;
      if (paramBundle == null) {}
      while (paramBundle.intValue() != 1)
      {
        i = 1;
        break;
      }
      paramBundle = this.hrf;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("key_chatting_wording");
        this.iPL = paramBundle;
        paramBundle = this.hrf;
        if (paramBundle == null) {
          break label447;
        }
        paramBundle = paramBundle.getString("key_chatting_text");
        this.iPM = paramBundle;
        paramBundle = this.hrf;
        if (paramBundle == null) {
          break label452;
        }
        paramBundle = paramBundle.getString("key_chatting_appid");
        this.iPN = paramBundle;
        paramBundle = this.hrf;
        if (paramBundle == null) {
          break label457;
        }
        paramBundle = Long.valueOf(paramBundle.getLong("key_msg_id", -1L));
        this.iPO = paramBundle;
        paramBundle = this.hrf;
        if (paramBundle == null) {
          break label462;
        }
        paramBundle = paramBundle.getString("key_talker_username");
        this.iPP = paramBundle;
        paramBundle = this.hrf;
        if (paramBundle == null) {
          break label467;
        }
      }
      label447:
      label452:
      label457:
      label462:
      label467:
      for (paramBundle = paramBundle.getString("key_sender_username");; paramBundle = null)
      {
        this.iPQ = paramBundle;
        if ((!bo.isNullOrNil(this.iPN)) && (!bo.isNullOrNil(this.iPP)) && (!bo.isNullOrNil(this.iPQ))) {
          break label472;
        }
        i = 0;
        break;
        paramBundle = null;
        break label286;
        paramBundle = null;
        break label308;
        paramBundle = null;
        break label330;
        paramBundle = null;
        break label358;
        paramBundle = null;
        break label380;
      }
      label472:
      if (this.iPO != null)
      {
        paramBundle = this.iPO;
        if (paramBundle == null) {}
        while (paramBundle.longValue() != -1L)
        {
          paramBundle = com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
          a.f.b.j.p(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
          paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.j)paramBundle).bPQ();
          localObject = this.iPO;
          if (localObject == null) {
            a.f.b.j.ebi();
          }
          paramBundle.kB(((Long)localObject).longValue());
          break;
        }
      }
      i = 0;
    }
    pC(2);
    paramBundle = this.iPK;
    if (paramBundle == null)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandVideoPreviewUI.e(this));
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(-16777216);
    }
    for (;;)
    {
      paramBundle = new AppBrandVideoWrapper((Context)this);
      this.iPH = new AppBrandVideoView((Context)this, (View)paramBundle);
      this.iPR = new AppBrandVideoViewControlBar((Context)this);
      localObject = this.iPR;
      if (localObject == null) {
        a.f.b.j.ebi();
      }
      ((AppBrandVideoViewControlBar)localObject).setId(2131820574);
      localObject = this.iPH;
      if (localObject != null) {
        ((AppBrandVideoView)localObject).a((d.a)this.iPR);
      }
      paramBundle.setVideoFooterView((com.tencent.mm.pluginsdk.ui.g)this.iPR);
      ((RelativeLayout)findViewById(2131821452)).addView((View)this.iPH, 0, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setAutoPlay(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setLoop(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setMute(false);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setCookieData(null);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setCover$16da05f7(this.icM);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setObjectFit("contain");
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setShowDanmakuBtn(false);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setShowMuteBtn(false);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setShowPlayBtn(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setShowProgress(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setShowFullScreenBtn(false);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setIsShowBasicControls(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setIsEnableBottomProgressBar(false);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setShowCenterPlayBtn(false);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setShowControlProgress(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.setPageGesture(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.ex(true);
      }
      paramBundle = this.iPH;
      if (paramBundle != null) {
        paramBundle.f(this.iPG, false, 0);
      }
      paramBundle = this.iPK;
      if (paramBundle != null) {
        break label1065;
      }
      AppMethodBeat.o(135004);
      return;
      if (paramBundle.intValue() != 1) {
        break;
      }
      ((ImageView)findViewById(2131821453)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.c(this));
      ((ImageView)findViewById(2131821454)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.d(this));
    }
    label1065:
    if (paramBundle.intValue() == 1)
    {
      paramBundle = LayoutInflater.from((Context)this).inflate(2130968748, (ViewGroup)findViewById(2131821452), false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = this.iPT;
      ((RelativeLayout)findViewById(2131821452)).addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = paramBundle.findViewById(2131821450);
      a.f.b.j.p(localObject, "additionView.findViewByI…View>(R.id.addition_text)");
      ((TextView)localObject).setText((CharSequence)this.iPL);
      localObject = (Button)paramBundle.findViewById(2131821451);
      a.f.b.j.p(localObject, "startBtn");
      ((Button)localObject).setText((CharSequence)this.iPM);
      ((Button)localObject).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.a(this));
      localObject = this.iPR;
      if (localObject != null)
      {
        ((AppBrandVideoViewControlBar)localObject).a((d.e)new AppBrandVideoPreviewUI.b(this, paramBundle));
        AppMethodBeat.o(135004);
        return;
      }
    }
    AppMethodBeat.o(135004);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(135007);
    super.onDestroy();
    AppBrandVideoView localAppBrandVideoView = this.iPH;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.aEM();
      AppMethodBeat.o(135007);
      return;
    }
    AppMethodBeat.o(135007);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(135006);
    super.onPause();
    AppBrandVideoView localAppBrandVideoView = this.iPH;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.oj(3);
      AppMethodBeat.o(135006);
      return;
    }
    AppMethodBeat.o(135006);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(135005);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.iPH;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.alp();
      AppMethodBeat.o(135005);
      return;
    }
    AppMethodBeat.o(135005);
  }
  
  public final boolean onSwipeBackFinish()
  {
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */