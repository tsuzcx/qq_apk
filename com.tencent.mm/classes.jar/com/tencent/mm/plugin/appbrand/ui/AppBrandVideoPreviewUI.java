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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.aj.z.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.AppBrandVideoViewControlBar;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandVideoPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/message/MsgJobCallback;", "()V", "BASIC_PADDING", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "TOGGLE_PADDING", "appBrandVideoViewControlBar", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/progressbar/AppBrandVideoViewControlBar;", "mAdditionButtonStr", "mAdditionMsgId", "", "Ljava/lang/Long;", "mAdditionSenderUsername", "mAdditionStartAppBrandId", "mAdditionTalkerUsername", "mAdditionText", "mChattingType", "Ljava/lang/Integer;", "mCoverUrl", "mExtData", "Landroid/os/Bundle;", "mLocalPath", "mScene", "mShouldAutoSave", "", "Ljava/lang/Boolean;", "mVideoUrl", "mVideoView", "Lcom/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView;", "checkParams", "doInBackground", "", "job", "Lcom/tencent/mm/message/MsgJobCallback$Job;", "doOnlySelectRecordMsg", "bundle", "failDoJob", "getLayoutId", "getUIFlag", "initVideoView", "isFromMoreSelectRetransmit", "isJustTransAsNormalMsg", "isOnlySelectRecordMsg", "onCreate", "savedInstanceState", "onDestroy", "onPause", "onResume", "onSwipeBackFinish", "onWindowFocusChanged", "hasFocus", "reportWitrhType", "type", "requestExitSelectedMode", "resumeEditMode", "setWindowStyle", "plugin-appbrand-integration_release"})
public final class AppBrandVideoPreviewUI
  extends MMActivity
  implements z
{
  final String TAG;
  private HashMap _$_findViewCache;
  private Bundle okw;
  private String puJ;
  private String qZW;
  private AppBrandVideoView qZX;
  private String qZY;
  private Boolean qZZ;
  private Integer raa;
  private Integer rab;
  private String rac;
  private String rad;
  private String rae;
  private Long raf;
  private String rag;
  private String rah;
  private AppBrandVideoViewControlBar rai;
  private int raj;
  private int rak;
  
  public AppBrandVideoPreviewUI()
  {
    AppMethodBeat.i(51170);
    this.TAG = "MicroMsg.AppBrandVideoPreviewUI";
    this.puJ = "";
    this.qZY = "";
    this.qZZ = Boolean.FALSE;
    this.raa = Integer.valueOf(0);
    this.rab = Integer.valueOf(0);
    this.rac = "";
    this.rad = "";
    this.rae = "";
    this.raf = Long.valueOf(-1L);
    this.rag = "";
    this.rah = "";
    AppMethodBeat.o(51170);
  }
  
  private final void CS(int paramInt)
  {
    AppMethodBeat.i(51165);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    if (ab.Lj(this.rag)) {}
    for (int i = 2;; i = 1)
    {
      localh.a(17608, new Object[] { Integer.valueOf(i), this.rae, Integer.valueOf(paramInt), Integer.valueOf(1) });
      AppMethodBeat.o(51165);
      return;
    }
  }
  
  public final void H(Bundle paramBundle) {}
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(273679);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(273679);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(273678);
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
    AppMethodBeat.o(273678);
    return localView1;
  }
  
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
  
  public final boolean bbA()
  {
    return true;
  }
  
  public final boolean bbB()
  {
    return false;
  }
  
  public final boolean bbC()
  {
    return false;
  }
  
  public final void c(z.a parama)
  {
    AppMethodBeat.i(51163);
    Log.i(this.TAG, "hy: requestExitSelectedMode do job: %s", new Object[] { parama });
    if (parama == z.a.lqs) {
      CS(4);
    }
    AppMethodBeat.o(51163);
  }
  
  public final int getLayoutId()
  {
    return au.g.app_brand_video_preview_ui;
  }
  
  public final void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(51164);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    d.ue(true);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setNavigationBarColor(-16777216);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.setStatusBarColor(0);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.j(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    paramBundle = getWindow();
    p.j(paramBundle, "window");
    paramBundle.getDecorView().setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)new f(this));
    this.raj = com.tencent.mm.ci.a.aZ((Context)this, au.d.LargerPadding);
    this.rak = (com.tencent.mm.ci.a.aZ((Context)this, au.d.app_brand_video_control_bar_height) + this.raj);
    this.qZW = getIntent().getStringExtra("key_video_url");
    this.puJ = getIntent().getStringExtra("key_cover_path");
    this.qZY = getIntent().getStringExtra("key_local_file_path");
    this.qZZ = Boolean.valueOf(getIntent().getBooleanExtra("key_auto_save", false));
    this.raa = Integer.valueOf(getIntent().getIntExtra("key_scene", 0));
    this.okw = getIntent().getBundleExtra("key_ext_data");
    if (this.puJ != null)
    {
      paramBundle = this.puJ;
      if (paramBundle == null) {
        p.iCn();
      }
      if (kotlin.n.n.M(paramBundle, "/", false)) {
        this.puJ = ("file:/" + this.puJ);
      }
    }
    int i;
    if (Util.isNullOrNil(this.qZW)) {
      i = 0;
    }
    label372:
    Object localObject;
    while (i == 0)
    {
      finish();
      AppMethodBeat.o(51164);
      return;
      paramBundle = this.raa;
      if (paramBundle == null) {}
      while (paramBundle.intValue() != 1)
      {
        i = 1;
        break;
      }
      paramBundle = this.okw;
      if (paramBundle != null)
      {
        paramBundle = Integer.valueOf(paramBundle.getInt("key_chatting_type"));
        this.rab = paramBundle;
        paramBundle = this.okw;
        if (paramBundle == null) {
          break label555;
        }
        paramBundle = paramBundle.getString("key_chatting_wording");
        label394:
        this.rac = paramBundle;
        paramBundle = this.okw;
        if (paramBundle == null) {
          break label560;
        }
        paramBundle = paramBundle.getString("key_chatting_text");
        label416:
        this.rad = paramBundle;
        paramBundle = this.okw;
        if (paramBundle == null) {
          break label565;
        }
        paramBundle = paramBundle.getString("key_chatting_appid");
        label438:
        this.rae = paramBundle;
        paramBundle = this.okw;
        if (paramBundle == null) {
          break label570;
        }
        paramBundle = Long.valueOf(paramBundle.getLong("key_msg_id", -1L));
        label466:
        this.raf = paramBundle;
        paramBundle = this.okw;
        if (paramBundle == null) {
          break label575;
        }
        paramBundle = paramBundle.getString("key_talker_username");
        label488:
        this.rag = paramBundle;
        paramBundle = this.okw;
        if (paramBundle == null) {
          break label580;
        }
      }
      label555:
      label560:
      label565:
      label570:
      label575:
      label580:
      for (paramBundle = paramBundle.getString("key_sender_username");; paramBundle = null)
      {
        this.rah = paramBundle;
        if ((!Util.isNullOrNil(this.rae)) && (!Util.isNullOrNil(this.rag)) && (!Util.isNullOrNil(this.rah))) {
          break label585;
        }
        i = 0;
        break;
        paramBundle = null;
        break label372;
        paramBundle = null;
        break label394;
        paramBundle = null;
        break label416;
        paramBundle = null;
        break label438;
        paramBundle = null;
        break label466;
        paramBundle = null;
        break label488;
      }
      label585:
      if (this.raf != null)
      {
        paramBundle = this.raf;
        if (paramBundle == null) {}
        while (paramBundle.longValue() != -1L)
        {
          paramBundle = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          p.j(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
          paramBundle = ((com.tencent.mm.plugin.messenger.foundation.a.n)paramBundle).eSe();
          localObject = this.raf;
          if (localObject == null) {
            p.iCn();
          }
          paramBundle.Oq(((Long)localObject).longValue());
          break;
        }
      }
      i = 0;
    }
    CS(2);
    paramBundle = this.raa;
    if (paramBundle == null)
    {
      setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandVideoPreviewUI.e(this));
      setMMTitle("");
      hideActionbarLine();
      setActionbarColor(-16777216);
      label713:
      paramBundle = new AppBrandVideoWrapper((Context)this);
      this.qZX = new AppBrandVideoView((Context)this, (View)paramBundle);
      this.rai = new AppBrandVideoViewControlBar((Context)this);
      localObject = this.rai;
      if (localObject == null) {
        p.iCn();
      }
      ((AppBrandVideoViewControlBar)localObject).setId(au.f.app_brand_video_preview_ui_controller_bar_id);
      localObject = this.qZX;
      if (localObject != null) {
        ((AppBrandVideoView)localObject).a((d.a)this.rai);
      }
      paramBundle.setVideoFooterView((d.b)this.rai);
      paramBundle = this.rab;
      if (paramBundle != null) {
        break label1188;
      }
    }
    for (;;)
    {
      ((RelativeLayout)findViewById(au.f.contentFrameLayout)).addView((View)this.qZX, 0, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setAutoPlay(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setLoop(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setMute(false);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setCookieData(null);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.aiL(this.puJ);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setObjectFit("contain");
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setShowDanmakuBtn(false);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setShowMuteBtn(false);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setShowPlayBtn(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setShowProgress(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setShowFullScreenBtn(false);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setIsShowBasicControls(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setIsEnableBottomProgressBar(false);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setShowCenterPlayBtn(false);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setShowControlProgress(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.setPageGesture(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.iC(true);
      }
      paramBundle = this.qZX;
      if (paramBundle != null) {
        paramBundle.f(this.qZW, false, 0);
      }
      paramBundle = this.raa;
      if (paramBundle != null) {
        break label1214;
      }
      AppMethodBeat.o(51164);
      return;
      if (paramBundle.intValue() != 1) {
        break;
      }
      ((ImageView)findViewById(au.f.preview_close)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.c(this));
      ((ImageView)findViewById(au.f.preview_share)).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.d(this));
      break label713;
      label1188:
      if (paramBundle.intValue() == 48)
      {
        paramBundle = this.rai;
        if (paramBundle != null) {
          paramBundle.setAutoHide(false);
        }
      }
    }
    label1214:
    if (paramBundle.intValue() == 1)
    {
      paramBundle = LayoutInflater.from((Context)this).inflate(au.g.app_brand_video_preview_additional, (ViewGroup)findViewById(au.f.contentFrameLayout), false);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = this.rak;
      ((RelativeLayout)findViewById(au.f.contentFrameLayout)).addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = paramBundle.findViewById(au.f.addition_text);
      p.j(localObject, "additionView.findViewByI…View>(R.id.addition_text)");
      ((TextView)localObject).setText((CharSequence)this.rac);
      localObject = (Button)paramBundle.findViewById(au.f.addition_button);
      p.j(localObject, "startBtn");
      ((Button)localObject).setText((CharSequence)this.rad);
      ((Button)localObject).setOnClickListener((View.OnClickListener)new AppBrandVideoPreviewUI.a(this));
      localObject = this.rai;
      if (localObject != null)
      {
        ((AppBrandVideoViewControlBar)localObject).a((d.f)new b(this, paramBundle));
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
    AppBrandVideoView localAppBrandVideoView = this.qZX;
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
    AppBrandVideoView localAppBrandVideoView = this.qZX;
    if (localAppBrandVideoView != null)
    {
      localAppBrandVideoView.AO(3);
      AppMethodBeat.o(51168);
      return;
    }
    AppMethodBeat.o(51168);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51167);
    super.onResume();
    AppBrandVideoView localAppBrandVideoView = this.qZX;
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
    p.j(localObject, "window");
    localObject = ((Window)localObject).getDecorView();
    p.j(localObject, "window.decorView");
    ((View)localObject).setSystemUiVisibility(1280);
    AppMethodBeat.o(51166);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements d.f
  {
    b(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI, View paramView) {}
    
    public final void onVisibilityChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(51156);
      if (!paramBoolean)
      {
        localObject = this.ral.findViewById(au.f.preview_close);
        p.j(localObject, "findViewById<ImageView>(R.id.preview_close)");
        ((ImageView)localObject).setVisibility(8);
        localObject = this.ral.findViewById(au.f.preview_share);
        p.j(localObject, "findViewById<ImageView>(R.id.preview_share)");
        ((ImageView)localObject).setVisibility(8);
        localObject = paramBundle;
        p.j(localObject, "additionView");
        localObject = ((View)localObject).getLayoutParams();
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(51156);
          throw ((Throwable)localObject);
        }
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.e(this.ral);
        AppMethodBeat.o(51156);
        return;
      }
      Object localObject = this.ral.findViewById(au.f.preview_close);
      p.j(localObject, "findViewById<ImageView>(R.id.preview_close)");
      ((ImageView)localObject).setVisibility(0);
      localObject = this.ral.findViewById(au.f.preview_share);
      p.j(localObject, "findViewById<ImageView>(R.id.preview_share)");
      ((ImageView)localObject).setVisibility(0);
      localObject = paramBundle;
      p.j(localObject, "additionView");
      localObject = ((View)localObject).getLayoutParams();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(51156);
        throw ((Throwable)localObject);
      }
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AppBrandVideoPreviewUI.f(this.ral);
      AppMethodBeat.o(51156);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onSystemUiVisibilityChange"})
  static final class f
    implements View.OnSystemUiVisibilityChangeListener
  {
    f(AppBrandVideoPreviewUI paramAppBrandVideoPreviewUI) {}
    
    public final void onSystemUiVisibilityChange(int paramInt)
    {
      AppMethodBeat.i(51160);
      if ((paramInt & 0x4) == 0)
      {
        Object localObject = this.ral.getWindow();
        p.j(localObject, "window");
        localObject = ((Window)localObject).getDecorView();
        p.j(localObject, "window.decorView");
        ((View)localObject).setSystemUiVisibility(AppBrandVideoPreviewUI.cks());
      }
      AppMethodBeat.o(51160);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */