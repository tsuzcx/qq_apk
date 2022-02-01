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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.o.e;
import com.tencent.mm.live.b.r;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.d.d;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"})
public final class LiveUID
  extends MMActivity
  implements i
{
  private final String TAG;
  private int hTW;
  private int hUA;
  private boolean hUB;
  private ImageView hUf;
  private TextView hUg;
  private TextView hUh;
  private View hUi;
  private TextView hUj;
  private TextView hUk;
  private TextView hUl;
  private Button hUm;
  private View hUn;
  private ImageView hUo;
  private View hUp;
  private View hUq;
  private ImageView hUr;
  private View hUs;
  private ImageView hUt;
  private View hUu;
  private ImageView hUv;
  private Button hUw;
  private final int hUx;
  private final int hUy;
  private LiveConfig hUz;
  
  public LiveUID()
  {
    AppMethodBeat.i(208408);
    this.TAG = "MicroMsg.LiveUID";
    this.hUy = 1;
    this.hUA = this.hUx;
    AppMethodBeat.o(208408);
  }
  
  private final void aIZ()
  {
    AppMethodBeat.i(208404);
    int i = this.hUA;
    TextView localTextView;
    AppCompatActivity localAppCompatActivity;
    if (i == this.hUx)
    {
      localTextView = this.hUj;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131762370));
        AppMethodBeat.o(208404);
        return;
      }
      AppMethodBeat.o(208404);
      return;
    }
    if (i == this.hUy)
    {
      localTextView = this.hUj;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        p.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131762371));
        AppMethodBeat.o(208404);
        return;
      }
    }
    AppMethodBeat.o(208404);
  }
  
  private final void aJa()
  {
    AppMethodBeat.i(208405);
    Object localObject = this.hUq;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(au.az((Context)getContext()).y);
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
      AppMethodBeat.o(208405);
      return;
    }
    AppMethodBeat.o(208405);
  }
  
  private final void aJb()
  {
    AppMethodBeat.i(208406);
    Object localObject = this.hUm;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.hUl;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.hUf;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.hUg;
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(208406);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = at.fromDPToPix((Context)getContext(), 72);
    localObject = this.hUg;
    if (localObject != null)
    {
      ((TextView)localObject).requestLayout();
      AppMethodBeat.o(208406);
      return;
    }
    AppMethodBeat.o(208406);
  }
  
  public final int getLayoutId()
  {
    return 2131495274;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(208403);
    View localView = this.hUp;
    if ((localView != null) && (localView.isShown() == true))
    {
      aJa();
      AppMethodBeat.o(208403);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(208403);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(208400);
    setTheme(2131820572);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.hTW = getIntent().getIntExtra("FROM_SENCE", 2);
    long l;
    switch (this.hTW)
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
      this.hUz = ((LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
      if (this.hUz != null)
      {
        paramBundle = x.hJf;
        x.a(new civ());
        paramBundle = x.hJf;
        paramBundle = x.aGr();
        localObject = this.hUz;
        if (localObject != null)
        {
          l = ((LiveConfig)localObject).getLiveId();
          label246:
          paramBundle.hyH = l;
          paramBundle = x.hJf;
          paramBundle = this.hUz;
          if (paramBundle != null)
          {
            localObject = paramBundle.aBD();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          x.GQ(paramBundle);
          paramBundle = x.hJf;
          paramBundle = this.hUz;
          if (paramBundle != null)
          {
            localObject = paramBundle.aBG();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          x.GS(paramBundle);
        }
      }
      else
      {
        paramBundle = this.TAG;
        localObject = new StringBuilder("initConfig liveId:");
        x localx = x.hJf;
        localObject = ((StringBuilder)localObject).append(x.aGr().hyH).append(" wechatRoomId:");
        localx = x.hJf;
        Log.i(paramBundle, x.aGm());
        this.hUf = ((ImageView)findViewById(2131303532));
        this.hUg = ((TextView)findViewById(2131303533));
        this.hUh = ((TextView)findViewById(2131303517));
        this.hUi = findViewById(2131303523);
        this.hUj = ((TextView)findViewById(2131303531));
        this.hUk = ((TextView)findViewById(2131303515));
        this.hUl = ((TextView)findViewById(2131303518));
        this.hUm = ((Button)findViewById(2131303513));
        this.hUn = findViewById(2131303516);
        this.hUo = ((ImageView)findViewById(2131303512));
        paramBundle = this.hUn;
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
      AppMethodBeat.o(208400);
      throw paramBundle;
      paramBundle = x.hJf;
      if (p.j(x.aGt(), z.aTY()))
      {
        d.aIE();
        break;
      }
      d.aIG();
      break;
      paramBundle = x.hJf;
      if (p.j(x.aGt(), z.aTY()))
      {
        d.aIF();
        break;
      }
      d.aIH();
      break;
      l = 0L;
      break label246;
    }
    label619:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    int i = au.eu((Context)getContext());
    paramBundle.topMargin = (au.getStatusBarHeight((Context)getContext()) + i);
    paramBundle = this.hUf;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.hUg;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(208400);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).topMargin = at.fromDPToPix((Context)getContext(), 72);
    paramBundle = this.hUg;
    if (paramBundle != null) {
      paramBundle.requestLayout();
    }
    paramBundle = this.hUi;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    }
    paramBundle = this.hUo;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new h(this));
    }
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle = (String)paramBundle.azQ().get(2);
    Object localObject = x.hJf;
    if (Util.isEqual(paramBundle, x.aGt()))
    {
      paramBundle = this.hUi;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    for (;;)
    {
      aIZ();
      this.hUp = findViewById(2131303525);
      this.hUq = findViewById(2131303522);
      this.hUr = ((ImageView)findViewById(2131303521));
      this.hUs = findViewById(2131303530);
      this.hUt = ((ImageView)findViewById(2131303529));
      this.hUu = findViewById(2131303528);
      this.hUv = ((ImageView)findViewById(2131303527));
      this.hUw = ((Button)findViewById(2131303520));
      paramBundle = this.hUp;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.hUq;
      if (paramBundle != null) {
        paramBundle.setTranslationY(au.az((Context)getContext()).y);
      }
      paramBundle = this.hUs;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      paramBundle = this.hUu;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      paramBundle = this.hUp;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      }
      paramBundle = this.hUw;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      }
      paramBundle = this.hUr;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new f(this));
      }
      paramBundle = r.hIg;
      r.aGb();
      paramBundle = g.aAg();
      p.g(paramBundle, "MMKernel.network()");
      paramBundle.azz().a(3806, (i)this);
      paramBundle = g.aAg();
      p.g(paramBundle, "MMKernel.network()");
      paramBundle.azz().a(3712, (i)this);
      AppMethodBeat.o(208400);
      return;
      paramBundle = this.hUi;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(208402);
    super.onDestroy();
    Object localObject = g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().b(3806, (i)this);
    localObject = g.aAg();
    p.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).azz().b(3712, (i)this);
    if (this.hUz != null)
    {
      localObject = x.hJf;
      x.and();
    }
    AppMethodBeat.o(208402);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(208401);
    super.onResume();
    AppMethodBeat.o(208401);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(208407);
    Log.i(this.TAG, "errType:" + paramInt1 + ", errCode:" + paramInt2);
    if ((paramq instanceof com.tencent.mm.live.b.a.b))
    {
      paramString = x.hJf;
      int i;
      if (x.aGr().MnK)
      {
        i = this.hUy;
        this.hUA = i;
        aIZ();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1160;
        }
        paramString = x.hJf;
        paramString = x.aGr();
        if (!p.j(paramString.MnL, paramString.MnM)) {
          break label319;
        }
        paramString = (CharSequence)paramString.MnI;
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
        paramString = this.hUl;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hUk;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hUm;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hUm;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(2131762248));
        }
        paramString = this.hUm;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new k(this));
        }
        paramString = this.hUf;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hUg;
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
        AppMethodBeat.o(208407);
        throw paramString;
        i = this.hUx;
        break;
        paramInt1 = 0;
        break label130;
        paramInt1 = 0;
        break label136;
        if (paramString.MnK)
        {
          paramString = (CharSequence)paramString.MnI;
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
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = at.fromDPToPix((Context)getContext(), 72);
      paramString = this.hUg;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(208407);
        return;
      }
      AppMethodBeat.o(208407);
      return;
      label419:
      paramString = x.hJf;
      paramInt1 = x.aGr().status;
      paramString = o.e.hGR;
      if (paramInt1 == o.e.aFB())
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label779;
        }
        paramString = this.hUg;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(2131762368));
        }
        paramString = this.hUh;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(2131762363));
        }
        paramString = this.hUl;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hUk;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hUm;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hUm;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(2131755873));
        }
        paramString = this.hUm;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new j(this));
        }
        paramString = this.hUf;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hUf;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setImageDrawable(paramq.getResources().getDrawable(2131690471));
        }
        paramString = this.hUg;
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
        AppMethodBeat.o(208407);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label733:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = at.fromDPToPix((Context)getContext(), 40);
      paramString = this.hUg;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(208407);
        return;
      }
      AppMethodBeat.o(208407);
      return;
      label779:
      paramString = x.hJf;
      paramString = x.aGr();
      paramInt1 = paramString.status;
      paramq = o.e.hGR;
      if ((paramInt1 == o.e.aFA()) && (!paramString.MnK))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1149;
        }
        paramString = this.hUg;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(2131762366));
        }
        paramString = this.hUh;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(2131762362));
        }
        paramString = this.hUl;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hUk;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.hUm;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hUm;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setText((CharSequence)paramq.getResources().getString(2131755873));
        }
        paramString = this.hUm;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new i(this));
        }
        paramString = this.hUf;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.hUf;
        if (paramString != null)
        {
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setImageDrawable(paramq.getResources().getDrawable(2131690471));
        }
        paramString = this.hUg;
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
        AppMethodBeat.o(208407);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label1103:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = at.fromDPToPix((Context)getContext(), 40);
      paramString = this.hUg;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(208407);
        return;
      }
      AppMethodBeat.o(208407);
      return;
      label1149:
      aJb();
      AppMethodBeat.o(208407);
      return;
      label1160:
      aJb();
    }
    AppMethodBeat.o(208407);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(208389);
      paramAnimator = LiveUID.l(this.hUC);
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(8);
        AppMethodBeat.o(208389);
        return;
      }
      AppMethodBeat.o(208389);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208390);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (LiveUID.b(this.hUC)) {
        if (LiveUID.d(this.hUC) != LiveUID.e(this.hUC)) {
          d.aIB();
        }
      }
      for (;;)
      {
        LiveUID.a(this.hUC, LiveUID.e(this.hUC));
        paramView = LiveUID.f(this.hUC);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = LiveUID.g(this.hUC);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208390);
        return;
        d.aIx();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208391);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (LiveUID.b(this.hUC)) {
        if (LiveUID.d(this.hUC) != LiveUID.h(this.hUC)) {
          d.aIC();
        }
      }
      for (;;)
      {
        LiveUID.a(this.hUC, LiveUID.h(this.hUC));
        paramView = LiveUID.f(this.hUC);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = LiveUID.g(this.hUC);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208391);
        return;
        d.aIy();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208392);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      LiveUID.i(this.hUC);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208392);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208393);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      LiveUID.j(this.hUC);
      LiveUID.k(this.hUC);
      LiveUID.i(this.hUC);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208393);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208394);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      LiveUID.i(this.hUC);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initRangePanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208394);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208395);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      LiveUID.a(this.hUC);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208395);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208396);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.hUC.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208396);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208397);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.hUC.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayClosed$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208397);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208398);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.hUC.finish();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayDeprecated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(208398);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class k
    implements View.OnClickListener
  {
    k(LiveUID paramLiveUID) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(208399);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      localObject = new Intent((Context)this.hUC.getContext(), LiveUIB.class);
      ((Intent)localObject).putExtra("FROM_SENCE", LiveUID.m(this.hUC));
      paramView = this.hUC.getContext();
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView = x.hJf;
      if (p.j(x.aGt(), z.aTY())) {
        d.aIz();
      }
      for (;;)
      {
        LiveUID.c(this.hUC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208399);
        return;
        d.aII();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID
 * JD-Core Version:    0.7.0.1
 */