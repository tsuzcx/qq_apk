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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.d.d;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"})
public final class LiveUID
  extends MMActivity
  implements f
{
  private final String TAG;
  private View hbA;
  private ImageView hbB;
  private Button hbC;
  private final int hbD;
  private final int hbE;
  private LiveConfig hbF;
  private int hbG;
  private boolean hbH;
  private int hbc;
  private ImageView hbl;
  private TextView hbm;
  private TextView hbn;
  private View hbo;
  private TextView hbp;
  private TextView hbq;
  private TextView hbr;
  private Button hbs;
  private View hbt;
  private ImageView hbu;
  private View hbv;
  private View hbw;
  private ImageView hbx;
  private View hby;
  private ImageView hbz;
  
  public LiveUID()
  {
    AppMethodBeat.i(216447);
    this.TAG = "MicroMsg.LiveUID";
    this.hbE = 1;
    this.hbG = this.hbD;
    AppMethodBeat.o(216447);
  }
  
  private final void aqB()
  {
    AppMethodBeat.i(216443);
    int i = this.hbG;
    TextView localTextView;
    AppCompatActivity localAppCompatActivity;
    if (i == this.hbD)
    {
      localTextView = this.hbp;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766673));
        AppMethodBeat.o(216443);
        return;
      }
      AppMethodBeat.o(216443);
      return;
    }
    if (i == this.hbE)
    {
      localTextView = this.hbp;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766674));
        AppMethodBeat.o(216443);
        return;
      }
    }
    AppMethodBeat.o(216443);
  }
  
  private final void aqC()
  {
    AppMethodBeat.i(216444);
    Object localObject = this.hbw;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(ar.ck((Context)getContext()).y);
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
      AppMethodBeat.o(216444);
      return;
    }
    AppMethodBeat.o(216444);
  }
  
  private final void aqD()
  {
    AppMethodBeat.i(216445);
    Object localObject = this.hbs;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.hbr;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.hbl;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.hbm;
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(216445);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = aq.fromDPToPix((Context)getContext(), 72);
    localObject = this.hbm;
    if (localObject != null)
    {
      ((TextView)localObject).requestLayout();
      AppMethodBeat.o(216445);
      return;
    }
    AppMethodBeat.o(216445);
  }
  
  public final int getLayoutId()
  {
    return 2131496334;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(216442);
    View localView = this.hbv;
    if ((localView != null) && (localView.isShown() == true))
    {
      aqC();
      AppMethodBeat.o(216442);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(216442);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216439);
    setTheme(2131820571);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.hbc = getIntent().getIntExtra("FROM_SENCE", 2);
    long l;
    switch (this.hbc)
    {
    default: 
      setSelfNavigationBarVisible(8);
      getWindow().addFlags(2097280);
      getWindow().addFlags(67108864);
      if (Build.VERSION.SDK_INT >= 21)
      {
        getWindow().clearFlags(67108864);
        paramBundle = getWindow();
        p.g(paramBundle, "window");
        paramBundle = paramBundle.getDecorView();
        p.g(paramBundle, "window.decorView");
        paramBundle.setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        paramBundle = getWindow();
        p.g(paramBundle, "window");
        paramBundle.setStatusBarColor(0);
      }
      getWindow().setFormat(-3);
      getWindow().setSoftInputMode(3);
      this.hbF = ((LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
      if (this.hbF != null)
      {
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        com.tencent.mm.live.b.g.a(new bvk());
        paramBundle = com.tencent.mm.live.b.g.gQZ;
        paramBundle = com.tencent.mm.live.b.g.anH();
        localObject = this.hbF;
        if (localObject != null)
        {
          l = ((LiveConfig)localObject).alm();
          label246:
          paramBundle.FKy = l;
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          paramBundle = this.hbF;
          if (paramBundle != null)
          {
            localObject = paramBundle.alk();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          com.tencent.mm.live.b.g.yn(paramBundle);
          paramBundle = com.tencent.mm.live.b.g.gQZ;
          paramBundle = this.hbF;
          if (paramBundle != null)
          {
            localObject = paramBundle.alo();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          com.tencent.mm.live.b.g.yp(paramBundle);
        }
      }
      else
      {
        paramBundle = this.TAG;
        localObject = new StringBuilder("initConfig liveId:");
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gQZ;
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.live.b.g.anH().FKy).append(" wechatRoomId:");
        localg = com.tencent.mm.live.b.g.gQZ;
        ae.i(paramBundle, com.tencent.mm.live.b.g.anC());
        this.hbl = ((ImageView)findViewById(2131307746));
        this.hbm = ((TextView)findViewById(2131307747));
        this.hbn = ((TextView)findViewById(2131307731));
        this.hbo = findViewById(2131307737);
        this.hbp = ((TextView)findViewById(2131307745));
        this.hbq = ((TextView)findViewById(2131307729));
        this.hbr = ((TextView)findViewById(2131307732));
        this.hbs = ((Button)findViewById(2131307727));
        this.hbt = findViewById(2131307730);
        this.hbu = ((ImageView)findViewById(2131307726));
        paramBundle = this.hbt;
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
      paramBundle = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(216439);
      throw paramBundle;
      paramBundle = com.tencent.mm.live.b.g.gQZ;
      if (p.i(com.tencent.mm.live.b.g.anJ(), com.tencent.mm.model.v.aAC()))
      {
        d.aqf();
        break;
      }
      d.aqh();
      break;
      paramBundle = com.tencent.mm.live.b.g.gQZ;
      if (p.i(com.tencent.mm.live.b.g.anJ(), com.tencent.mm.model.v.aAC()))
      {
        d.aqg();
        break;
      }
      d.aqi();
      break;
      l = 0L;
      break label246;
    }
    label619:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    int i = ar.dX((Context)getContext());
    paramBundle.topMargin = (ar.jN((Context)getContext()) + i);
    paramBundle = this.hbl;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.hbm;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(216439);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).topMargin = aq.fromDPToPix((Context)getContext(), 72);
    paramBundle = this.hbm;
    if (paramBundle != null) {
      paramBundle.requestLayout();
    }
    paramBundle = this.hbo;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = this.hbu;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
    }
    paramBundle = com.tencent.mm.kernel.g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle = (String)paramBundle.ajA().get(2);
    Object localObject = com.tencent.mm.live.b.g.gQZ;
    if (bu.lX(paramBundle, com.tencent.mm.live.b.g.anJ()))
    {
      paramBundle = this.hbo;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    for (;;)
    {
      aqB();
      this.hbv = findViewById(2131307739);
      this.hbw = findViewById(2131307736);
      this.hbx = ((ImageView)findViewById(2131307735));
      this.hby = findViewById(2131307744);
      this.hbz = ((ImageView)findViewById(2131307743));
      this.hbA = findViewById(2131307742);
      this.hbB = ((ImageView)findViewById(2131307741));
      this.hbC = ((Button)findViewById(2131307734));
      paramBundle = this.hbv;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.hbw;
      if (paramBundle != null) {
        paramBundle.setTranslationY(ar.ck((Context)getContext()).y);
      }
      paramBundle = this.hby;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      paramBundle = this.hbA;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      paramBundle = this.hbv;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      }
      paramBundle = this.hbC;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      }
      paramBundle = this.hbx;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      }
      paramBundle = i.gRP;
      i.aoF();
      paramBundle = com.tencent.mm.kernel.g.ajQ();
      p.g(paramBundle, "MMKernel.network()");
      paramBundle.ajj().a(3806, (f)this);
      paramBundle = com.tencent.mm.kernel.g.ajQ();
      p.g(paramBundle, "MMKernel.network()");
      paramBundle.ajj().a(3712, (f)this);
      AppMethodBeat.o(216439);
      return;
      paramBundle = this.hbo;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(216441);
    super.onDestroy();
    Object localObject = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).ajj().b(3806, (f)this);
    localObject = com.tencent.mm.kernel.g.ajQ();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).ajj().b(3712, (f)this);
    if (this.hbF != null)
    {
      localObject = com.tencent.mm.live.b.g.gQZ;
      com.tencent.mm.live.b.g.Zq();
    }
    AppMethodBeat.o(216441);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(216440);
    super.onResume();
    AppMethodBeat.o(216440);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(216446);
    ae.i(this.TAG, "errType:" + paramInt1 + ", errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      paramString = com.tencent.mm.live.b.g.gQZ;
      int i;
      if (com.tencent.mm.live.b.g.anH().Hih)
      {
        i = this.hbE;
        this.hbG = i;
        aqB();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1160;
        }
        paramString = com.tencent.mm.live.b.g.gQZ;
        paramString = com.tencent.mm.live.b.g.anH();
        if (!p.i(paramString.Hii, paramString.Hij)) {
          break label319;
        }
        paramString = (CharSequence)paramString.Hif;
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
        paramString = this.hbr;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hbq;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hbs;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hbs;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766561));
        }
        paramString = this.hbs;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new k(this));
        }
        paramString = this.hbl;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hbm;
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
        paramString = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216446);
        throw paramString;
        i = this.hbD;
        break;
        paramInt1 = 0;
        break label130;
        paramInt1 = 0;
        break label136;
        if (paramString.Hih)
        {
          paramString = (CharSequence)paramString.Hif;
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
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aq.fromDPToPix((Context)getContext(), 72);
      paramString = this.hbm;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(216446);
        return;
      }
      AppMethodBeat.o(216446);
      return;
      label419:
      paramString = com.tencent.mm.live.b.g.gQZ;
      paramInt1 = com.tencent.mm.live.b.g.anH().status;
      paramString = f.d.gPP;
      if (paramInt1 == f.d.anp())
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label779;
        }
        paramString = this.hbm;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766671));
        }
        paramString = this.hbn;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766666));
        }
        paramString = this.hbr;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hbq;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hbs;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hbs;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.hbs;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new j(this));
        }
        paramString = this.hbl;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hbl;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691509));
        }
        paramString = this.hbm;
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
        paramString = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216446);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label733:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aq.fromDPToPix((Context)getContext(), 40);
      paramString = this.hbm;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(216446);
        return;
      }
      AppMethodBeat.o(216446);
      return;
      label779:
      paramString = com.tencent.mm.live.b.g.gQZ;
      paramString = com.tencent.mm.live.b.g.anH();
      paramInt1 = paramString.status;
      paramn = f.d.gPP;
      if ((paramInt1 == f.d.ano()) && (!paramString.Hih))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1149;
        }
        paramString = this.hbm;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766669));
        }
        paramString = this.hbn;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766665));
        }
        paramString = this.hbr;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hbq;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hbs;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hbs;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.hbs;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new i(this));
        }
        paramString = this.hbl;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hbl;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691509));
        }
        paramString = this.hbm;
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
        paramString = new d.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(216446);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label1103:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aq.fromDPToPix((Context)getContext(), 40);
      paramString = this.hbm;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(216446);
        return;
      }
      AppMethodBeat.o(216446);
      return;
      label1149:
      aqD();
      AppMethodBeat.o(216446);
      return;
      label1160:
      aqD();
    }
    AppMethodBeat.o(216446);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(216428);
      paramAnimator = LiveUID.l(this.hbI);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(216428);
        return;
      }
      AppMethodBeat.o(216428);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216429);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (LiveUID.b(this.hbI)) {
        if (LiveUID.d(this.hbI) != LiveUID.e(this.hbI)) {
          d.aqc();
        }
      }
      for (;;)
      {
        LiveUID.a(this.hbI, LiveUID.e(this.hbI));
        paramView = LiveUID.f(this.hbI);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = LiveUID.g(this.hbI);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216429);
        return;
        d.apY();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216430);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (LiveUID.b(this.hbI)) {
        if (LiveUID.d(this.hbI) != LiveUID.h(this.hbI)) {
          d.aqd();
        }
      }
      for (;;)
      {
        LiveUID.a(this.hbI, LiveUID.h(this.hbI));
        paramView = LiveUID.f(this.hbI);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = LiveUID.g(this.hbI);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216430);
        return;
        d.apZ();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216431);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      LiveUID.i(this.hbI);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216431);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216432);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      LiveUID.j(this.hbI);
      LiveUID.k(this.hbI);
      LiveUID.i(this.hbI);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216432);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216433);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      LiveUID.i(this.hbI);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216433);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216434);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      LiveUID.a(this.hbI);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216434);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216435);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.hbI.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216435);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216436);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.hbI.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216436);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216437);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.hbI.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216437);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216438);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      localObject = new Intent((Context)this.hbI.getContext(), LiveUIB.class);
      ((Intent)localObject).putExtra("FROM_SENCE", LiveUID.m(this.hbI));
      paramView = this.hbI.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = com.tencent.mm.live.b.g.gQZ;
      if (p.i(com.tencent.mm.live.b.g.anJ(), com.tencent.mm.model.v.aAC())) {
        d.aqa();
      }
      for (;;)
      {
        LiveUID.c(this.hbI);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216438);
        return;
        d.aqj();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID
 * JD-Core Version:    0.7.0.1
 */