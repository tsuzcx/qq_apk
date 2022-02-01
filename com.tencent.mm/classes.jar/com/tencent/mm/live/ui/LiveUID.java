package com.tencent.mm.live.ui;

import android.animation.Animator.AnimatorListener;
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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e.d;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.d.d;
import com.tencent.mm.model.u;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"})
public final class LiveUID
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private ImageView KyA;
  private View KyB;
  private ImageView KyC;
  private View KyD;
  private ImageView KyE;
  private Button KyF;
  private final int KyG;
  private final int KyH;
  private LiveConfig KyI;
  private int KyJ;
  private boolean KyK;
  private int Kyf;
  private ImageView Kyo;
  private TextView Kyp;
  private TextView Kyq;
  private View Kyr;
  private TextView Kys;
  private TextView Kyt;
  private TextView Kyu;
  private Button Kyv;
  private View Kyw;
  private ImageView Kyx;
  private View Kyy;
  private View Kyz;
  private final String TAG;
  
  public LiveUID()
  {
    AppMethodBeat.i(203288);
    this.TAG = "MicroMsg.LiveUID";
    this.KyH = 1;
    this.KyJ = this.KyG;
    AppMethodBeat.o(203288);
  }
  
  private final void fQn()
  {
    AppMethodBeat.i(203284);
    int i = this.KyJ;
    TextView localTextView;
    AppCompatActivity localAppCompatActivity;
    if (i == this.KyG)
    {
      localTextView = this.Kys;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        k.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766638));
        AppMethodBeat.o(203284);
        return;
      }
      AppMethodBeat.o(203284);
      return;
    }
    if (i == this.KyH)
    {
      localTextView = this.Kys;
      if (localTextView != null)
      {
        localAppCompatActivity = getContext();
        k.g(localAppCompatActivity, "context");
        localTextView.setText((CharSequence)localAppCompatActivity.getResources().getString(2131766639));
        AppMethodBeat.o(203284);
        return;
      }
    }
    AppMethodBeat.o(203284);
  }
  
  private final void fQo()
  {
    AppMethodBeat.i(203285);
    Object localObject = this.Kyz;
    if (localObject != null)
    {
      localObject = ((View)localObject).animate();
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationY(ap.cf((Context)getContext()).y);
        if (localObject == null) {}
      }
    }
    for (localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);; localObject = null)
    {
      if (localObject != null) {
        ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new LiveUID.a(this));
      }
      if (localObject == null) {
        break;
      }
      ((ViewPropertyAnimator)localObject).start();
      AppMethodBeat.o(203285);
      return;
    }
    AppMethodBeat.o(203285);
  }
  
  private final void fQp()
  {
    AppMethodBeat.i(203286);
    Object localObject = this.Kyv;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.Kyu;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.Kyo;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.Kyp;
    if (localObject != null) {}
    for (localObject = ((TextView)localObject).getLayoutParams(); localObject == null; localObject = null)
    {
      localObject = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(203286);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = ao.fromDPToPix((Context)getContext(), 72);
    localObject = this.Kyp;
    if (localObject != null)
    {
      ((TextView)localObject).requestLayout();
      AppMethodBeat.o(203286);
      return;
    }
    AppMethodBeat.o(203286);
  }
  
  public final int getLayoutId()
  {
    return 2131496325;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(203283);
    View localView = this.Kyy;
    if ((localView != null) && (localView.isShown() == true))
    {
      fQo();
      AppMethodBeat.o(203283);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(203283);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203280);
    setTheme(2131820571);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.Kyf = getIntent().getIntExtra("FROM_SENCE", 2);
    long l;
    switch (this.Kyf)
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
      this.KyI = ((LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
      if (this.KyI != null)
      {
        paramBundle = f.rGw;
        f.a(new eas());
        paramBundle = f.rGw;
        paramBundle = f.eNG();
        localObject = this.KyI;
        if (localObject != null)
        {
          l = ((LiveConfig)localObject).ckB();
          label246:
          paramBundle.LwA = l;
          paramBundle = f.rGw;
          paramBundle = this.KyI;
          if (paramBundle != null)
          {
            localObject = paramBundle.ckA();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          f.aUk(paramBundle);
          paramBundle = f.rGw;
          paramBundle = this.KyI;
          if (paramBundle != null)
          {
            localObject = paramBundle.ckD();
            paramBundle = (Bundle)localObject;
            if (localObject != null) {}
          }
          else
          {
            paramBundle = "";
          }
          f.aUm(paramBundle);
        }
      }
      else
      {
        paramBundle = this.TAG;
        localObject = new StringBuilder("initConfig liveId:");
        f localf = f.rGw;
        localObject = ((StringBuilder)localObject).append(f.eNG().LwA).append(" wechatRoomId:");
        localf = f.rGw;
        ad.i(paramBundle, f.eNB());
        this.Kyo = ((ImageView)findViewById(2131307663));
        this.Kyp = ((TextView)findViewById(2131307664));
        this.Kyq = ((TextView)findViewById(2131307648));
        this.Kyr = findViewById(2131307654);
        this.Kys = ((TextView)findViewById(2131307662));
        this.Kyt = ((TextView)findViewById(2131307646));
        this.Kyu = ((TextView)findViewById(2131307649));
        this.Kyv = ((Button)findViewById(2131307644));
        this.Kyw = findViewById(2131307647);
        this.Kyx = ((ImageView)findViewById(2131307643));
        paramBundle = this.Kyw;
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
      AppMethodBeat.o(203280);
      throw paramBundle;
      paramBundle = f.rGw;
      if (k.g(f.eNI(), u.aqG()))
      {
        d.fPS();
        break;
      }
      d.fPU();
      break;
      paramBundle = f.rGw;
      if (k.g(f.eNI(), u.aqG()))
      {
        d.fPT();
        break;
      }
      d.fPV();
      break;
      l = 0L;
      break label246;
    }
    label619:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    int i = ap.dL((Context)getContext());
    paramBundle.topMargin = (ap.iX((Context)getContext()) + i);
    paramBundle = this.Kyo;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.Kyp;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getLayoutParams(); paramBundle == null; paramBundle = null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(203280);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).topMargin = ao.fromDPToPix((Context)getContext(), 72);
    paramBundle = this.Kyp;
    if (paramBundle != null) {
      paramBundle.requestLayout();
    }
    paramBundle = this.Kyr;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new LiveUID.g(this));
    }
    paramBundle = this.Kyx;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new LiveUID.h(this));
    }
    paramBundle = com.tencent.mm.kernel.g.afB();
    k.g(paramBundle, "MMKernel.storage()");
    paramBundle = (String)paramBundle.afk().get(2);
    Object localObject = f.rGw;
    if (bt.kU(paramBundle, f.eNI()))
    {
      paramBundle = this.Kyr;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    for (;;)
    {
      fQn();
      this.Kyy = findViewById(2131307656);
      this.Kyz = findViewById(2131307653);
      this.KyA = ((ImageView)findViewById(2131307652));
      this.KyB = findViewById(2131307661);
      this.KyC = ((ImageView)findViewById(2131307660));
      this.KyD = findViewById(2131307659);
      this.KyE = ((ImageView)findViewById(2131307658));
      this.KyF = ((Button)findViewById(2131307651));
      paramBundle = this.Kyy;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.Kyz;
      if (paramBundle != null) {
        paramBundle.setTranslationY(ap.cf((Context)getContext()).y);
      }
      paramBundle = this.KyB;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new LiveUID.b(this));
      }
      paramBundle = this.KyD;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new LiveUID.c(this));
      }
      paramBundle = this.Kyy;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new LiveUID.d(this));
      }
      paramBundle = this.KyF;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new LiveUID.e(this));
      }
      paramBundle = this.KyA;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new LiveUID.f(this));
      }
      paramBundle = h.xfu;
      h.fOH();
      paramBundle = com.tencent.mm.kernel.g.afA();
      k.g(paramBundle, "MMKernel.network()");
      paramBundle.aeS().a(3806, (com.tencent.mm.al.g)this);
      paramBundle = com.tencent.mm.kernel.g.afA();
      k.g(paramBundle, "MMKernel.network()");
      paramBundle.aeS().a(3712, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(203280);
      return;
      paramBundle = this.Kyr;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203282);
    super.onDestroy();
    Object localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aeS().b(3806, (com.tencent.mm.al.g)this);
    localObject = com.tencent.mm.kernel.g.afA();
    k.g(localObject, "MMKernel.network()");
    ((com.tencent.mm.kernel.b)localObject).aeS().b(3712, (com.tencent.mm.al.g)this);
    if (this.KyI != null)
    {
      localObject = f.rGw;
      f.VP();
    }
    AppMethodBeat.o(203282);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(203281);
    super.onResume();
    AppMethodBeat.o(203281);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203287);
    ad.i(this.TAG, "errType:" + paramInt1 + ", errCode:" + paramInt2);
    if ((paramn instanceof com.tencent.mm.live.b.a.b))
    {
      paramString = f.rGw;
      int i;
      if (f.eNG().Lzd)
      {
        i = this.KyH;
        this.KyJ = i;
        fQn();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1160;
        }
        paramString = f.rGw;
        paramString = f.eNG();
        if (!k.g(paramString.Lze, paramString.Lzf)) {
          break label319;
        }
        paramString = (CharSequence)paramString.Lzb;
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
        paramString = this.Kyu;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kyt;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kyv;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.Kyv;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766542));
        }
        paramString = this.Kyv;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new LiveUID.k(this));
        }
        paramString = this.Kyo;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kyp;
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
        AppMethodBeat.o(203287);
        throw paramString;
        i = this.KyG;
        break;
        paramInt1 = 0;
        break label130;
        paramInt1 = 0;
        break label136;
        if (paramString.Lzd)
        {
          paramString = (CharSequence)paramString.Lzb;
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
      paramString = this.Kyp;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(203287);
        return;
      }
      AppMethodBeat.o(203287);
      return;
      label419:
      paramString = f.rGw;
      paramInt1 = f.eNG().status;
      paramString = e.d.raJ;
      if (paramInt1 == e.d.eni())
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label779;
        }
        paramString = this.Kyp;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766636));
        }
        paramString = this.Kyq;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766631));
        }
        paramString = this.Kyu;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kyt;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kyv;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.Kyv;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.Kyv;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new LiveUID.j(this));
        }
        paramString = this.Kyo;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.Kyo;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691498));
        }
        paramString = this.Kyp;
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
        AppMethodBeat.o(203287);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label733:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = ao.fromDPToPix((Context)getContext(), 40);
      paramString = this.Kyp;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(203287);
        return;
      }
      AppMethodBeat.o(203287);
      return;
      label779:
      paramString = f.rGw;
      paramString = f.eNG();
      paramInt1 = paramString.status;
      paramn = e.d.raJ;
      if ((paramInt1 == e.d.emd()) && (!paramString.Lzd))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1149;
        }
        paramString = this.Kyp;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766634));
        }
        paramString = this.Kyq;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131766630));
        }
        paramString = this.Kyu;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kyt;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.Kyv;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.Kyv;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setText((CharSequence)paramn.getResources().getString(2131755792));
        }
        paramString = this.Kyv;
        if (paramString != null) {
          paramString.setOnClickListener((View.OnClickListener)new LiveUID.i(this));
        }
        paramString = this.Kyo;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.Kyo;
        if (paramString != null)
        {
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setImageDrawable(paramn.getResources().getDrawable(2131691498));
        }
        paramString = this.Kyp;
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
        AppMethodBeat.o(203287);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label1103:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = ao.fromDPToPix((Context)getContext(), 40);
      paramString = this.Kyp;
      if (paramString != null)
      {
        paramString.requestLayout();
        AppMethodBeat.o(203287);
        return;
      }
      AppMethodBeat.o(203287);
      return;
      label1149:
      fQp();
      AppMethodBeat.o(203287);
      return;
      label1160:
      fQp();
    }
    AppMethodBeat.o(203287);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID
 * JD-Core Version:    0.7.0.1
 */