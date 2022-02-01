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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.f.d;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.d.d;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"})
public final class LiveUID
  extends MMActivity
  implements f
{
  private final String TAG;
  private TextView gYA;
  private View gYB;
  private TextView gYC;
  private TextView gYD;
  private TextView gYE;
  private Button gYF;
  private View gYG;
  private ImageView gYH;
  private View gYI;
  private View gYJ;
  private ImageView gYK;
  private View gYL;
  private ImageView gYM;
  private View gYN;
  private ImageView gYO;
  private Button gYP;
  private final int gYQ;
  private final int gYR;
  private LiveConfig gYS;
  private int gYT;
  private boolean gYU;
  private int gYp;
  private ImageView gYy;
  private TextView gYz;
  
  public LiveUID()
  {
    AppMethodBeat.i(212819);
    this.TAG = "MicroMsg.LiveUID";
    this.gYR = 1;
    this.gYT = this.gYQ;
    AppMethodBeat.o(212819);
  }
  
  private final void aqm()
  {
    AppMethodBeat.i(212815);
    int i = this.gYT;
    TextView localTextView;
    AppCompatActivity localAppCompatActivity;
    if (i == this.gYQ)
    {
      localTextView = this.gYC;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766673));
        AppMethodBeat.o(212815);
        return;
      }
      AppMethodBeat.o(212815);
      return;
    }
    if (i == this.gYR)
    {
      localTextView = this.gYC;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766674));
        AppMethodBeat.o(212815);
        return;
      }
    }
    AppMethodBeat.o(212815);
  }
  
  private final void aqn()
  {
    AppMethodBeat.i(212816);
    Object localObject = this.gYJ;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(ar.ci((Context)getContext()).y);
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
      AppMethodBeat.o(212816);
      return;
    }
    AppMethodBeat.o(212816);
  }
  
  private final void aqo()
  {
    AppMethodBeat.i(212817);
    Object localObject = this.gYF;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.gYE;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.gYy;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.gYz;
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(212817);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = aq.fromDPToPix((Context)getContext(), 72);
    localObject = this.gYz;
    if (localObject != null)
    {
      ((TextView)localObject).requestLayout();
      AppMethodBeat.o(212817);
      return;
    }
    AppMethodBeat.o(212817);
  }
  
  public final int getLayoutId()
  {
    return 2131496334;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(212814);
    View localView = this.gYI;
    if ((localView != null) && (localView.isShown() == true))
    {
      aqn();
      AppMethodBeat.o(212814);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(212814);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212811);
    setTheme(2131820571);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.gYp = getIntent().getIntExtra("FROM_SENCE", 2);
    long l;
    switch (this.gYp)
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
      this.gYS = ((LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
      if (this.gYS != null)
      {
        paramBundle = com.tencent.mm.live.b.g.gOr;
        com.tencent.mm.live.b.g.a(new buq());
        paramBundle = com.tencent.mm.live.b.g.gOr;
        paramBundle = com.tencent.mm.live.b.g.ans();
        localObject = this.gYS;
        if (localObject != null)
        {
          l = ((LiveConfig)localObject).akX();
          label246:
          paramBundle.Fsa = l;
          paramBundle = com.tencent.mm.live.b.g.gOr;
          paramBundle = this.gYS;
          if (paramBundle != null)
          {
            localObject = paramBundle.akV();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          com.tencent.mm.live.b.g.xE(paramBundle);
          paramBundle = com.tencent.mm.live.b.g.gOr;
          paramBundle = this.gYS;
          if (paramBundle != null)
          {
            localObject = paramBundle.akZ();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          com.tencent.mm.live.b.g.xG(paramBundle);
        }
      }
      else
      {
        paramBundle = this.TAG;
        localObject = new StringBuilder("initConfig liveId:");
        com.tencent.mm.live.b.g localg = com.tencent.mm.live.b.g.gOr;
        localObject = ((StringBuilder)localObject).append(com.tencent.mm.live.b.g.ans().Fsa).append(" wechatRoomId:");
        localg = com.tencent.mm.live.b.g.gOr;
        ad.i(paramBundle, com.tencent.mm.live.b.g.anm());
        this.gYy = ((ImageView)findViewById(2131307746));
        this.gYz = ((TextView)findViewById(2131307747));
        this.gYA = ((TextView)findViewById(2131307731));
        this.gYB = findViewById(2131307737);
        this.gYC = ((TextView)findViewById(2131307745));
        this.gYD = ((TextView)findViewById(2131307729));
        this.gYE = ((TextView)findViewById(2131307732));
        this.gYF = ((Button)findViewById(2131307727));
        this.gYG = findViewById(2131307730);
        this.gYH = ((ImageView)findViewById(2131307726));
        paramBundle = this.gYG;
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
      AppMethodBeat.o(212811);
      throw paramBundle;
      paramBundle = com.tencent.mm.live.b.g.gOr;
      if (p.i(com.tencent.mm.live.b.g.anu(), u.aAm()))
      {
        d.apR();
        break;
      }
      d.apT();
      break;
      paramBundle = com.tencent.mm.live.b.g.gOr;
      if (p.i(com.tencent.mm.live.b.g.anu(), u.aAm()))
      {
        d.apS();
        break;
      }
      d.apU();
      break;
      l = 0L;
      break label246;
    }
    label619:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    int i = ar.dT((Context)getContext());
    paramBundle.topMargin = (ar.jG((Context)getContext()) + i);
    paramBundle = this.gYy;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.gYz;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(212811);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).topMargin = aq.fromDPToPix((Context)getContext(), 72);
    paramBundle = this.gYz;
    if (paramBundle != null) {
      paramBundle.requestLayout();
    }
    paramBundle = this.gYB;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = this.gYH;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
    }
    paramBundle = com.tencent.mm.kernel.g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle = (String)paramBundle.ajl().get(2);
    Object localObject = com.tencent.mm.live.b.g.gOr;
    if (bt.lQ(paramBundle, com.tencent.mm.live.b.g.anu()))
    {
      paramBundle = this.gYB;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    for (;;)
    {
      aqm();
      this.gYI = findViewById(2131307739);
      this.gYJ = findViewById(2131307736);
      this.gYK = ((ImageView)findViewById(2131307735));
      this.gYL = findViewById(2131307744);
      this.gYM = ((ImageView)findViewById(2131307743));
      this.gYN = findViewById(2131307742);
      this.gYO = ((ImageView)findViewById(2131307741));
      this.gYP = ((Button)findViewById(2131307734));
      paramBundle = this.gYI;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.gYJ;
      if (paramBundle != null) {
        paramBundle.setTranslationY(ar.ci((Context)getContext()).y);
      }
      paramBundle = this.gYL;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      paramBundle = this.gYN;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      paramBundle = this.gYI;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      }
      paramBundle = this.gYP;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      }
      paramBundle = this.gYK;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      }
      paramBundle = i.gPh;
      i.aoq();
      paramBundle = com.tencent.mm.kernel.g.ajB();
      p.g(paramBundle, "MMKernel.network()");
      paramBundle.aiU().a(3806, (f)this);
      paramBundle = com.tencent.mm.kernel.g.ajB();
      p.g(paramBundle, "MMKernel.network()");
      paramBundle.aiU().a(3712, (f)this);
      AppMethodBeat.o(212811);
      return;
      paramBundle = this.gYB;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(212813);
    super.onDestroy();
    Object localObject = com.tencent.mm.kernel.g.ajB();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aiU().b(3806, (f)this);
    localObject = com.tencent.mm.kernel.g.ajB();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aiU().b(3712, (f)this);
    if (this.gYS != null)
    {
      localObject = com.tencent.mm.live.b.g.gOr;
      com.tencent.mm.live.b.g.Zh();
    }
    AppMethodBeat.o(212813);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(212812);
    super.onResume();
    AppMethodBeat.o(212812);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(212818);
    ad.i(this.TAG, "errType:" + paramInt1 + ", errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      paramString = com.tencent.mm.live.b.g.gOr;
      int i;
      if (com.tencent.mm.live.b.g.ans().GOH)
      {
        i = this.gYR;
        this.gYT = i;
        aqm();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1160;
        }
        paramString = com.tencent.mm.live.b.g.gOr;
        paramString = com.tencent.mm.live.b.g.ans();
        if (!p.i(paramString.GOI, paramString.GOJ)) {
          break label319;
        }
        paramString = (CharSequence)paramString.GOF;
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
        paramString = this.gYE;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYD;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYF;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gYF;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766561));
        }
        paramString = this.gYF;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new k(this));
        }
        paramString = this.gYy;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYz;
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
        AppMethodBeat.o(212818);
        throw paramString;
        i = this.gYQ;
        break;
        paramInt1 = 0;
        break label130;
        paramInt1 = 0;
        break label136;
        if (paramString.GOH)
        {
          paramString = (CharSequence)paramString.GOF;
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
      paramString = this.gYz;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(212818);
        return;
      }
      AppMethodBeat.o(212818);
      return;
      label419:
      paramString = com.tencent.mm.live.b.g.gOr;
      paramInt1 = com.tencent.mm.live.b.g.ans().status;
      paramString = f.d.gNg;
      if (paramInt1 == f.d.ana())
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label779;
        }
        paramString = this.gYz;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766671));
        }
        paramString = this.gYA;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766666));
        }
        paramString = this.gYE;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYD;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYF;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gYF;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.gYF;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new j(this));
        }
        paramString = this.gYy;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gYy;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691509));
        }
        paramString = this.gYz;
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
        AppMethodBeat.o(212818);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label733:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aq.fromDPToPix((Context)getContext(), 40);
      paramString = this.gYz;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(212818);
        return;
      }
      AppMethodBeat.o(212818);
      return;
      label779:
      paramString = com.tencent.mm.live.b.g.gOr;
      paramString = com.tencent.mm.live.b.g.ans();
      paramInt1 = paramString.status;
      paramn = f.d.gNg;
      if ((paramInt1 == f.d.amZ()) && (!paramString.GOH))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1149;
        }
        paramString = this.gYz;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766669));
        }
        paramString = this.gYA;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766665));
        }
        paramString = this.gYE;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYD;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.gYF;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gYF;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.gYF;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new i(this));
        }
        paramString = this.gYy;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.gYy;
        if (paramString != null)
        {
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691509));
        }
        paramString = this.gYz;
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
        AppMethodBeat.o(212818);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label1103:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = aq.fromDPToPix((Context)getContext(), 40);
      paramString = this.gYz;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(212818);
        return;
      }
      AppMethodBeat.o(212818);
      return;
      label1149:
      aqo();
      AppMethodBeat.o(212818);
      return;
      label1160:
      aqo();
    }
    AppMethodBeat.o(212818);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(212800);
      paramAnimator = LiveUID.l(this.gYV);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(212800);
        return;
      }
      AppMethodBeat.o(212800);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212801);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (LiveUID.b(this.gYV)) {
        if (LiveUID.d(this.gYV) != LiveUID.e(this.gYV)) {
          d.apO();
        }
      }
      for (;;)
      {
        LiveUID.a(this.gYV, LiveUID.e(this.gYV));
        paramView = LiveUID.f(this.gYV);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = LiveUID.g(this.gYV);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212801);
        return;
        d.apK();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212802);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (LiveUID.b(this.gYV)) {
        if (LiveUID.d(this.gYV) != LiveUID.h(this.gYV)) {
          d.apP();
        }
      }
      for (;;)
      {
        LiveUID.a(this.gYV, LiveUID.h(this.gYV));
        paramView = LiveUID.f(this.gYV);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = LiveUID.g(this.gYV);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212802);
        return;
        d.apL();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212803);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      LiveUID.i(this.gYV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212803);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212804);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      LiveUID.j(this.gYV);
      LiveUID.k(this.gYV);
      LiveUID.i(this.gYV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212804);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212805);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      LiveUID.i(this.gYV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212805);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212806);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      LiveUID.a(this.gYV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212806);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212807);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.gYV.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212807);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212808);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.gYV.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212808);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212809);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.gYV.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212809);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(212810);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      localObject = new Intent((Context)this.gYV.getContext(), LiveUIB.class);
      ((Intent)localObject).putExtra("FROM_SENCE", LiveUID.m(this.gYV));
      paramView = this.gYV.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = com.tencent.mm.live.b.g.gOr;
      if (p.i(com.tencent.mm.live.b.g.anu(), u.aAm())) {
        d.apM();
      }
      for (;;)
      {
        LiveUID.c(this.gYV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212810);
        return;
        d.apV();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID
 * JD-Core Version:    0.7.0.1
 */