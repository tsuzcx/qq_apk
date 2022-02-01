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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.d.d;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"})
public final class LiveUID
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private final String TAG;
  private int gEF;
  private ImageView gEO;
  private TextView gEP;
  private TextView gEQ;
  private View gER;
  private TextView gES;
  private TextView gET;
  private TextView gEU;
  private Button gEV;
  private View gEW;
  private ImageView gEX;
  private View gEY;
  private View gEZ;
  private ImageView gFa;
  private View gFb;
  private ImageView gFc;
  private View gFd;
  private ImageView gFe;
  private Button gFf;
  private final int gFg;
  private final int gFh;
  private LiveConfig gFi;
  private int gFj;
  private boolean gFk;
  
  public LiveUID()
  {
    AppMethodBeat.i(190529);
    this.TAG = "MicroMsg.LiveUID";
    this.gFh = 1;
    this.gFj = this.gFg;
    AppMethodBeat.o(190529);
  }
  
  private final void anA()
  {
    AppMethodBeat.i(190525);
    int i = this.gFj;
    TextView localTextView;
    AppCompatActivity localAppCompatActivity;
    if (i == this.gFg)
    {
      localTextView = this.gES;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        k.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766673));
        AppMethodBeat.o(190525);
        return;
      }
      AppMethodBeat.o(190525);
      return;
    }
    if (i == this.gFh)
    {
      localTextView = this.gES;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        k.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766674));
        AppMethodBeat.o(190525);
        return;
      }
    }
    AppMethodBeat.o(190525);
  }
  
  private final void anB()
  {
    AppMethodBeat.i(190526);
    Object localObject = this.gEZ;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(ap.cl((Context)getContext()).y);
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
      AppMethodBeat.o(190526);
      return;
    }
    AppMethodBeat.o(190526);
  }
  
  private final void anC()
  {
    AppMethodBeat.i(190527);
    Object localObject = this.gEV;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.gEU;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.gEO;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.gEP;
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(190527);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ao.fromDPToPix((Context)getContext(), 72);
    localObject = this.gEP;
    if (localObject != null)
    {
      ((TextView)localObject).requestLayout();
      AppMethodBeat.o(190527);
      return;
    }
    AppMethodBeat.o(190527);
  }
  
  public final int getLayoutId()
  {
    return 2131496334;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(190524);
    View localView = this.gEY;
    if ((localView != null) && (localView.isShown() == true))
    {
      anB();
      AppMethodBeat.o(190524);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(190524);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(190521);
    setTheme(2131820571);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.gEF = getIntent().getIntExtra("FROM_SENCE", 2);
    long l;
    switch (this.gEF)
    {
    default: 
      setSelfNavigationBarVisible(8);
      getWindow().addFlags(2097280);
      getWindow().addFlags(67108864);
      if (Build.VERSION.SDK_INT >= 21)
      {
        getWindow().clearFlags(67108864);
        paramBundle = getWindow();
        k.g(paramBundle, "window");
        paramBundle = paramBundle.getDecorView();
        k.g(paramBundle, "window.decorView");
        paramBundle.setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        paramBundle = getWindow();
        k.g(paramBundle, "window");
        paramBundle.setStatusBarColor(0);
      }
      getWindow().setFormat(-3);
      getWindow().setSoftInputMode(3);
      this.gFi = ((LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
      if (this.gFi != null)
      {
        paramBundle = com.tencent.mm.live.b.g.guG;
        com.tencent.mm.live.b.g.a(new bqd());
        paramBundle = com.tencent.mm.live.b.g.guG;
        paramBundle = com.tencent.mm.live.b.g.akF();
        localObject = this.gFi;
        if (localObject != null)
        {
          l = ((LiveConfig)localObject).ail();
          label246:
          paramBundle.DMV = l;
          paramBundle = com.tencent.mm.live.b.g.guG;
          paramBundle = this.gFi;
          if (paramBundle != null)
          {
            localObject = paramBundle.aij();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          com.tencent.mm.live.b.g.uO(paramBundle);
          paramBundle = com.tencent.mm.live.b.g.guG;
          paramBundle = this.gFi;
          if (paramBundle != null)
          {
            localObject = paramBundle.ain();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          com.tencent.mm.live.b.g.uQ(paramBundle);
        }
      }
      else
      {
        paramBundle = this.TAG;
        localObject = new StringBuilder("initConfig liveId:");
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.guG;
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.live.b.g.akF().DMV).append(" wechatRoomId:");
        localg = com.tencent.mm.live.b.g.guG;
        ac.i(paramBundle, com.tencent.mm.live.b.g.akA());
        this.gEO = ((ImageView)findViewById(2131307746));
        this.gEP = ((TextView)findViewById(2131307747));
        this.gEQ = ((TextView)findViewById(2131307731));
        this.gER = findViewById(2131307737);
        this.gES = ((TextView)findViewById(2131307745));
        this.gET = ((TextView)findViewById(2131307729));
        this.gEU = ((TextView)findViewById(2131307732));
        this.gEV = ((Button)findViewById(2131307727));
        this.gEW = findViewById(2131307730);
        this.gEX = ((ImageView)findViewById(2131307726));
        paramBundle = this.gEW;
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
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(190521);
      throw paramBundle;
      paramBundle = com.tencent.mm.live.b.g.guG;
      if (k.g(com.tencent.mm.live.b.g.akH(), u.axw()))
      {
        d.ane();
        break;
      }
      d.ang();
      break;
      paramBundle = com.tencent.mm.live.b.g.guG;
      if (k.g(com.tencent.mm.live.b.g.akH(), u.axw()))
      {
        d.anf();
        break;
      }
      d.anh();
      break;
      l = 0L;
      break label246;
    }
    label619:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    int i = ap.dT((Context)getContext());
    paramBundle.topMargin = (ap.ji((Context)getContext()) + i);
    paramBundle = this.gEO;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.gEP;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(190521);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).topMargin = ao.fromDPToPix((Context)getContext(), 72);
    paramBundle = this.gEP;
    if (paramBundle != null) {
      paramBundle.requestLayout();
    }
    paramBundle = this.gER;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = this.gEX;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
    }
    paramBundle = com.tencent.mm.kernel.g.agR();
    k.g(paramBundle, "MMKernel.storage()");
    paramBundle = (String)paramBundle.agA().get(2);
    Object localObject = com.tencent.mm.live.b.g.guG;
    if (bs.lr(paramBundle, com.tencent.mm.live.b.g.akH()))
    {
      paramBundle = this.gER;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    for (;;)
    {
      anA();
      this.gEY = findViewById(2131307739);
      this.gEZ = findViewById(2131307736);
      this.gFa = ((ImageView)findViewById(2131307735));
      this.gFb = findViewById(2131307744);
      this.gFc = ((ImageView)findViewById(2131307743));
      this.gFd = findViewById(2131307742);
      this.gFe = ((ImageView)findViewById(2131307741));
      this.gFf = ((Button)findViewById(2131307734));
      paramBundle = this.gEY;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.gEZ;
      if (paramBundle != null) {
        paramBundle.setTranslationY(ap.cl((Context)getContext()).y);
      }
      paramBundle = this.gFb;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      paramBundle = this.gFd;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      paramBundle = this.gEY;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      }
      paramBundle = this.gFf;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      }
      paramBundle = this.gFa;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      }
      paramBundle = i.gvw;
      i.alD();
      paramBundle = com.tencent.mm.kernel.g.agQ();
      k.g(paramBundle, "MMKernel.network()");
      paramBundle.agi().a(3806, (com.tencent.mm.ak.g)this);
      paramBundle = com.tencent.mm.kernel.g.agQ();
      k.g(paramBundle, "MMKernel.network()");
      paramBundle.agi().a(3712, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(190521);
      return;
      paramBundle = this.gER;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(190523);
    super.onDestroy();
    Object localObject = com.tencent.mm.kernel.g.agQ();
    k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).agi().b(3806, (com.tencent.mm.ak.g)this);
    localObject = com.tencent.mm.kernel.g.agQ();
    k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).agi().b(3712, (com.tencent.mm.ak.g)this);
    if (this.gFi != null)
    {
      localObject = com.tencent.mm.live.b.g.guG;
      com.tencent.mm.live.b.g.WN();
    }
    AppMethodBeat.o(190523);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(190522);
    super.onResume();
    AppMethodBeat.o(190522);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(190528);
    ac.i(this.TAG, "errType:" + paramInt1 + ", errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      paramString = com.tencent.mm.live.b.g.guG;
      int i;
      if (com.tencent.mm.live.b.g.akF().Ffd)
      {
        i = this.gFh;
        this.gFj = i;
        anA();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1160;
        }
        paramString = com.tencent.mm.live.b.g.guG;
        paramString = com.tencent.mm.live.b.g.akF();
        if (!k.g(paramString.Ffe, paramString.Fff)) {
          break label319;
        }
        paramString = (CharSequence)paramString.Ffb;
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
        paramString = this.gEU;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gET;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gEV;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gEV;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766561));
        }
        paramString = this.gEV;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new k(this));
        }
        paramString = this.gEO;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gEP;
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
        paramString = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190528);
        throw paramString;
        i = this.gFg;
        break;
        paramInt1 = 0;
        break label130;
        paramInt1 = 0;
        break label136;
        if (paramString.Ffd)
        {
          paramString = (CharSequence)paramString.Ffb;
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
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = ao.fromDPToPix((Context)getContext(), 72);
      paramString = this.gEP;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(190528);
        return;
      }
      AppMethodBeat.o(190528);
      return;
      label419:
      paramString = com.tencent.mm.live.b.g.guG;
      paramInt1 = com.tencent.mm.live.b.g.akF().status;
      paramString = f.d.gtv;
      if (paramInt1 == f.d.ako())
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label779;
        }
        paramString = this.gEP;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766671));
        }
        paramString = this.gEQ;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766666));
        }
        paramString = this.gEU;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gET;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gEV;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gEV;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.gEV;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new j(this));
        }
        paramString = this.gEO;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gEO;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691509));
        }
        paramString = this.gEP;
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
        paramString = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190528);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label733:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = ao.fromDPToPix((Context)getContext(), 40);
      paramString = this.gEP;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(190528);
        return;
      }
      AppMethodBeat.o(190528);
      return;
      label779:
      paramString = com.tencent.mm.live.b.g.guG;
      paramString = com.tencent.mm.live.b.g.akF();
      paramInt1 = paramString.status;
      paramn = f.d.gtv;
      if ((paramInt1 == f.d.akn()) && (!paramString.Ffd))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1149;
        }
        paramString = this.gEP;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766669));
        }
        paramString = this.gEQ;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766665));
        }
        paramString = this.gEU;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gET;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gEV;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gEV;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.gEV;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new i(this));
        }
        paramString = this.gEO;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gEO;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691509));
        }
        paramString = this.gEP;
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
        paramString = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190528);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label1103:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = ao.fromDPToPix((Context)getContext(), 40);
      paramString = this.gEP;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(190528);
        return;
      }
      AppMethodBeat.o(190528);
      return;
      label1149:
      anC();
      AppMethodBeat.o(190528);
      return;
      label1160:
      anC();
    }
    AppMethodBeat.o(190528);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(190510);
      paramAnimator = LiveUID.l(this.gFl);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(190510);
        return;
      }
      AppMethodBeat.o(190510);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190511);
      if (LiveUID.b(this.gFl)) {
        if (LiveUID.d(this.gFl) != LiveUID.e(this.gFl)) {
          d.anb();
        }
      }
      for (;;)
      {
        LiveUID.a(this.gFl, LiveUID.e(this.gFl));
        paramView = LiveUID.f(this.gFl);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = LiveUID.g(this.gFl);
        if (paramView == null) {
          break;
        }
        paramView.setVisibility(8);
        AppMethodBeat.o(190511);
        return;
        d.amX();
      }
      AppMethodBeat.o(190511);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190512);
      if (LiveUID.b(this.gFl)) {
        if (LiveUID.d(this.gFl) != LiveUID.h(this.gFl)) {
          d.anc();
        }
      }
      for (;;)
      {
        LiveUID.a(this.gFl, LiveUID.h(this.gFl));
        paramView = LiveUID.f(this.gFl);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = LiveUID.g(this.gFl);
        if (paramView == null) {
          break;
        }
        paramView.setVisibility(0);
        AppMethodBeat.o(190512);
        return;
        d.amY();
      }
      AppMethodBeat.o(190512);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190513);
      LiveUID.i(this.gFl);
      AppMethodBeat.o(190513);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190514);
      LiveUID.j(this.gFl);
      LiveUID.k(this.gFl);
      LiveUID.i(this.gFl);
      AppMethodBeat.o(190514);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190515);
      LiveUID.i(this.gFl);
      AppMethodBeat.o(190515);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190516);
      LiveUID.a(this.gFl);
      AppMethodBeat.o(190516);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190517);
      this.gFl.finish();
      AppMethodBeat.o(190517);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190518);
      this.gFl.finish();
      AppMethodBeat.o(190518);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190519);
      this.gFl.finish();
      AppMethodBeat.o(190519);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190520);
      Object localObject = new Intent((Context)this.gFl.getContext(), LiveUIB.class);
      ((Intent)localObject).putExtra("FROM_SENCE", LiveUID.m(this.gFl));
      paramView = this.gFl.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = com.tencent.mm.live.b.g.guG;
      if (k.g(com.tencent.mm.live.b.g.akH(), u.axw())) {
        d.amZ();
      }
      for (;;)
      {
        LiveUID.c(this.gFl);
        AppMethodBeat.o(190520);
        return;
        d.ani();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID
 * JD-Core Version:    0.7.0.1
 */