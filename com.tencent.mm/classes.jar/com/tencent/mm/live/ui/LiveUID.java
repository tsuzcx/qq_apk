package com.tencent.mm.live.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.b.l.d;
import com.tencent.mm.live.b.o;
import com.tencent.mm.live.b.u;
import com.tencent.mm.live.d.d;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"})
public final class LiveUID
  extends MMActivity
  implements i
{
  private final String TAG;
  private ImageView kIE;
  private TextView kIF;
  private TextView kIG;
  private View kIH;
  private TextView kII;
  private TextView kIJ;
  private TextView kIK;
  private Button kIL;
  private View kIM;
  private ImageView kIN;
  private View kIO;
  private View kIP;
  private ImageView kIQ;
  private View kIR;
  private ImageView kIS;
  private View kIT;
  private ImageView kIU;
  private Button kIV;
  private final int kIW;
  private final int kIX;
  private LiveConfig kIY;
  private int kIZ;
  private int kIv;
  private boolean kJa;
  
  public LiveUID()
  {
    AppMethodBeat.i(195586);
    this.TAG = "MicroMsg.LiveUID";
    this.kIX = 1;
    this.kIZ = this.kIW;
    AppMethodBeat.o(195586);
  }
  
  private final void aQX()
  {
    AppMethodBeat.i(195556);
    int i = this.kIZ;
    TextView localTextView;
    AppCompatActivity localAppCompatActivity;
    if (i == this.kIW)
    {
      localTextView = this.kII;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.j(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(b.h.live_replay_range_only_self));
        AppMethodBeat.o(195556);
        return;
      }
      AppMethodBeat.o(195556);
      return;
    }
    if (i == this.kIX)
    {
      localTextView = this.kII;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.j(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(b.h.live_replay_range_room));
        AppMethodBeat.o(195556);
        return;
      }
    }
    AppMethodBeat.o(195556);
  }
  
  private final void aQY()
  {
    AppMethodBeat.i(195558);
    Object localObject = this.kIP;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(ax.au((Context)getContext()).y);
        if (localObject == null) {}
      }
    }
    for (localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);; localObject = null)
    {
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new a(this));
      }
      if (localObject == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(195558);
      return;
    }
    AppMethodBeat.o(195558);
  }
  
  private final void aQZ()
  {
    AppMethodBeat.i(195562);
    Object localObject = this.kIL;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.kIK;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.kIE;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.kIF;
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(195562);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = aw.fromDPToPix((Context)getContext(), 72);
    localObject = this.kIF;
    if (localObject != null)
    {
      ((TextView)localObject).requestLayout();
      AppMethodBeat.o(195562);
      return;
    }
    AppMethodBeat.o(195562);
  }
  
  public final int getLayoutId()
  {
    return b.f.live_replay_profile_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(195554);
    View localView = this.kIO;
    if ((localView != null) && (localView.isShown() == true))
    {
      aQY();
      AppMethodBeat.o(195554);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(195554);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(195548);
    setTheme(b.i.AppTheme_DarkMode_NoTitleTransparent);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.kIv = getIntent().getIntExtra("FROM_SENCE", 2);
    long l;
    switch (this.kIv)
    {
    default: 
      setSelfNavigationBarVisible(8);
      getWindow().addFlags(2097280);
      getWindow().addFlags(67108864);
      if (Build.VERSION.SDK_INT >= 21)
      {
        getWindow().clearFlags(67108864);
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        paramBundle = paramBundle.getDecorView();
        p.j(paramBundle, "window.decorView");
        paramBundle.setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        paramBundle = getWindow();
        p.j(paramBundle, "window");
        paramBundle.setStatusBarColor(0);
      }
      getWindow().setFormat(-3);
      getWindow().setSoftInputMode(3);
      this.kIY = ((LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
      if (this.kIY != null)
      {
        paramBundle = u.kwz;
        u.a(new crq());
        paramBundle = u.kwz;
        paramBundle = u.aOr();
        localObject = this.kIY;
        if (localObject != null)
        {
          l = ((LiveConfig)localObject).getLiveId();
          label246:
          paramBundle.klE = l;
          paramBundle = u.kwz;
          paramBundle = this.kIY;
          if (paramBundle != null)
          {
            localObject = paramBundle.aJg();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          u.Ob(paramBundle);
          paramBundle = u.kwz;
          paramBundle = this.kIY;
          if (paramBundle != null)
          {
            localObject = paramBundle.aJk();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          u.Od(paramBundle);
        }
      }
      else
      {
        paramBundle = this.TAG;
        localObject = new StringBuilder("initConfig liveId:");
        u localu = u.kwz;
        localObject = ((StringBuilder)localObject).append(u.aOr().klE).append(" wechatRoomId:");
        localu = u.kwz;
        Log.i(paramBundle, u.aOm());
        this.kIE = ((ImageView)findViewById(b.e.live_replay_profile_status_icon));
        this.kIF = ((TextView)findViewById(b.e.live_replay_profile_title_tv));
        this.kIG = ((TextView)findViewById(b.e.live_replay_profile_desc_tv));
        this.kIH = findViewById(b.e.live_replay_profile_range_group);
        this.kII = ((TextView)findViewById(b.e.live_replay_profile_range_tip_tv));
        this.kIJ = ((TextView)findViewById(b.e.live_replay_profile_btn_tip_tv));
        this.kIK = ((TextView)findViewById(b.e.live_replay_profile_generating_tv));
        this.kIL = ((Button)findViewById(b.e.live_replay_profile_btn));
        this.kIM = findViewById(b.e.live_replay_profile_content_group);
        this.kIN = ((ImageView)findViewById(b.e.live_replay_profile_back_btn));
        paramBundle = this.kIM;
        if (paramBundle == null) {
          break label614;
        }
      }
      break;
    }
    label614:
    for (paramBundle = paramBundle.getLayoutParams();; paramBundle = null)
    {
      if (paramBundle != null) {
        break label619;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(195548);
      throw paramBundle;
      paramBundle = u.kwz;
      if (p.h(u.aOt(), z.bcZ()))
      {
        d.aQC();
        break;
      }
      d.aQE();
      break;
      paramBundle = u.kwz;
      if (p.h(u.aOt(), z.bcZ()))
      {
        d.aQD();
        break;
      }
      d.aQF();
      break;
      l = 0L;
      break label246;
    }
    label619:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    int i = ax.ew((Context)getContext());
    paramBundle.topMargin = (ax.getStatusBarHeight((Context)getContext()) + i);
    paramBundle = this.kIE;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.kIF;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(195548);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).topMargin = aw.fromDPToPix((Context)getContext(), 72);
    paramBundle = this.kIF;
    if (paramBundle != null) {
      paramBundle.requestLayout();
    }
    paramBundle = this.kIH;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = this.kIN;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
    }
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    paramBundle = (String)paramBundle.aHp().get(2);
    Object localObject = u.kwz;
    if (Util.isEqual(paramBundle, u.aOt()))
    {
      paramBundle = this.kIH;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    for (;;)
    {
      aQX();
      this.kIO = findViewById(b.e.live_replay_profile_range_panel);
      this.kIP = findViewById(b.e.live_replay_profile_range_content_panel);
      this.kIQ = ((ImageView)findViewById(b.e.live_replay_profile_range_content_close));
      this.kIR = findViewById(b.e.live_replay_profile_range_self_group);
      this.kIS = ((ImageView)findViewById(b.e.live_replay_profile_range_self_check));
      this.kIT = findViewById(b.e.live_replay_profile_range_room_group);
      this.kIU = ((ImageView)findViewById(b.e.live_replay_profile_range_room_check));
      this.kIV = ((Button)findViewById(b.e.live_replay_profile_range_content_btn));
      paramBundle = this.kIO;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.kIP;
      if (paramBundle != null) {
        paramBundle.setTranslationY(ax.au((Context)getContext()).y);
      }
      paramBundle = this.kIR;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      paramBundle = this.kIT;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      paramBundle = this.kIO;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      }
      paramBundle = this.kIV;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      }
      paramBundle = this.kIQ;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      }
      paramBundle = o.kvA;
      o.aOb();
      paramBundle = h.aHF();
      p.j(paramBundle, "MMKernel.network()");
      paramBundle.aGY().a(3806, (i)this);
      paramBundle = h.aHF();
      p.j(paramBundle, "MMKernel.network()");
      paramBundle.aGY().a(3712, (i)this);
      AppMethodBeat.o(195548);
      return;
      paramBundle = this.kIH;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(195551);
    super.onDestroy();
    Object localObject = h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((c)localObject).aGY().b(3806, (i)this);
    localObject = h.aHF();
    p.j(localObject, "MMKernel.network()");
    ((c)localObject).aGY().b(3712, (i)this);
    if (this.kIY != null)
    {
      localObject = u.kwz;
      u.ate();
    }
    AppMethodBeat.o(195551);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(195550);
    super.onResume();
    AppMethodBeat.o(195550);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(195583);
    Log.i(this.TAG, "errType:" + paramInt1 + ", errCode:" + paramInt2);
    if ((paramq instanceof com.tencent.mm.live.b.a.b))
    {
      paramString = u.kwz;
      int i;
      if (u.aOr().TyE)
      {
        i = this.kIX;
        this.kIZ = i;
        aQX();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1160;
        }
        paramString = u.kwz;
        paramString = u.aOr();
        if (!p.h(paramString.TyF, paramString.TyG)) {
          break label319;
        }
        paramString = (CharSequence)paramString.SMa;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label309;
        }
        paramInt1 = 1;
        label130:
        if (paramInt1 != 0) {
          break label314;
        }
        paramInt1 = 1;
        label136:
        if (paramInt1 == 0) {
          break label419;
        }
        paramString = this.kIK;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kIJ;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kIL;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.kIL;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(b.h.live_after_replay_scan));
        }
        paramString = this.kIL;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new k(this));
        }
        paramString = this.kIE;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kIF;
        if (paramString == null) {
          break label368;
        }
      }
      label309:
      label314:
      label319:
      label363:
      label368:
      for (paramString = paramString.getLayoutParams();; paramString = null)
      {
        if (paramString != null) {
          break label373;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(195583);
        throw paramString;
        i = this.kIW;
        break;
        paramInt1 = 0;
        break label130;
        paramInt1 = 0;
        break label136;
        if (paramString.TyE)
        {
          paramString = (CharSequence)paramString.SMa;
          if ((paramString == null) || (paramString.length() == 0)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label363;
            }
            paramInt1 = 1;
            break;
          }
        }
        paramInt1 = 0;
        break label136;
      }
      label373:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aw.fromDPToPix((Context)getContext(), 72);
      paramString = this.kIF;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(195583);
        return;
      }
      AppMethodBeat.o(195583);
      return;
      label419:
      paramString = u.kwz;
      paramInt1 = u.aOr().status;
      paramString = l.d.kuw;
      if (paramInt1 == l.d.aNI())
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label779;
        }
        paramString = this.kIF;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(b.h.live_replay_profile_title_invalid));
        }
        paramString = this.kIG;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(b.h.live_replay_profile_desc_invalid));
        }
        paramString = this.kIK;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kIJ;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kIL;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.kIL;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(b.h.app_i_know));
        }
        paramString = this.kIL;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new j(this));
        }
        paramString = this.kIE;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.kIE;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setImageDrawable(paramq.getResources().getDrawable(b.g.icons_dark_help));
        }
        paramString = this.kIF;
        if (paramString == null) {
          break label728;
        }
      }
      label728:
      for (paramString = paramString.getLayoutParams();; paramString = null)
      {
        if (paramString != null) {
          break label733;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(195583);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label733:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aw.fromDPToPix((Context)getContext(), 40);
      paramString = this.kIF;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(195583);
        return;
      }
      AppMethodBeat.o(195583);
      return;
      label779:
      paramString = u.kwz;
      paramString = u.aOr();
      paramInt1 = paramString.status;
      paramq = l.d.kuw;
      if ((paramInt1 == l.d.aNH()) && (!paramString.TyE))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1149;
        }
        paramString = this.kIF;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(b.h.live_replay_profile_title_closed));
        }
        paramString = this.kIG;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(b.h.live_replay_profile_desc_closed));
        }
        paramString = this.kIK;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kIJ;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.kIL;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.kIL;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(b.h.app_i_know));
        }
        paramString = this.kIL;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new i(this));
        }
        paramString = this.kIE;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.kIE;
        if (paramString != null)
        {
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setImageDrawable(paramq.getResources().getDrawable(b.g.icons_dark_help));
        }
        paramString = this.kIF;
        if (paramString == null) {
          break label1098;
        }
      }
      label1098:
      for (paramString = paramString.getLayoutParams();; paramString = null)
      {
        if (paramString != null) {
          break label1103;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(195583);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label1103:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aw.fromDPToPix((Context)getContext(), 40);
      paramString = this.kIF;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(195583);
        return;
      }
      AppMethodBeat.o(195583);
      return;
      label1149:
      aQZ();
      AppMethodBeat.o(195583);
      return;
      label1160:
      aQZ();
    }
    AppMethodBeat.o(195583);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(199338);
      paramAnimator = LiveUID.l(this.kJb);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(199338);
        return;
      }
      AppMethodBeat.o(199338);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193759);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (LiveUID.b(this.kJb)) {
        if (LiveUID.d(this.kJb) != LiveUID.e(this.kJb)) {
          d.aQz();
        }
      }
      for (;;)
      {
        LiveUID.a(this.kJb, LiveUID.e(this.kJb));
        paramView = LiveUID.f(this.kJb);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = LiveUID.g(this.kJb);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193759);
        return;
        d.aQv();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193416);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (LiveUID.b(this.kJb)) {
        if (LiveUID.d(this.kJb) != LiveUID.h(this.kJb)) {
          d.aQA();
        }
      }
      for (;;)
      {
        LiveUID.a(this.kJb, LiveUID.h(this.kJb));
        paramView = LiveUID.f(this.kJb);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = LiveUID.g(this.kJb);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(193416);
        return;
        d.aQw();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(194344);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      LiveUID.i(this.kJb);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194344);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(188239);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      LiveUID.j(this.kJb);
      LiveUID.k(this.kJb);
      LiveUID.i(this.kJb);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(188239);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(194393);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      LiveUID.i(this.kJb);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194393);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199949);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      LiveUID.a(this.kJb);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(199949);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200499);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.kJb.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200499);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(200580);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.kJb.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(200580);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198928);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.kJb.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(198928);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199828);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      localObject = new Intent((Context)this.kJb.getContext(), LiveUIB.class);
      ((Intent)localObject).putExtra("FROM_SENCE", LiveUID.m(this.kJb));
      paramView = this.kJb.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = u.kwz;
      if (p.h(u.aOt(), z.bcZ())) {
        d.aQx();
      }
      for (;;)
      {
        LiveUID.c(this.kJb);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199828);
        return;
        d.aQG();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID
 * JD-Core Version:    0.7.0.1
 */