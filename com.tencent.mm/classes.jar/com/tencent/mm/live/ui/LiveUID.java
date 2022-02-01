package com.tencent.mm.live.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.i;
import com.tencent.mm.live.c.d;
import com.tencent.mm.live.model.l.d;
import com.tencent.mm.live.model.o;
import com.tencent.mm.live.model.u;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/LiveUID;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "RANGE_ROOM", "", "RANGE_SELF_ONLY", "TAG", "", "curRange", "fromSence", "hasBeenEnterReplay", "", "liveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "profileBackBtn", "Landroid/widget/ImageView;", "profileContentGroup", "Landroid/view/View;", "profileDescTv", "Landroid/widget/TextView;", "profileGeneratingTipTv", "profileGeneratingTv", "profileIconIv", "profileRangeBtn", "profileRangeClose", "profileRangeContentPanel", "profileRangeFinishBtn", "Landroid/widget/Button;", "profileRangePanel", "profileRangeRoomGroup", "profileRangeRoomSelect", "profileRangeSelfGroup", "profileRangeSelfSelect", "profileRangeTipTv", "profileReplayBtn", "profileTitleTv", "doReplaySwitch", "", "getLayoutId", "hideRangePanel", "initConfig", "initRangePanel", "initViews", "isAnchor", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "isReplayClosed", "isReplayDeprecated", "isReplayGenerated", "loadLiveInfo", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "replayClosed", "replayDeprecated", "replayGenerated", "replayGenerating", "setWindowStyle", "showRangePanel", "updateReplayRange", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveUID
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private final String TAG;
  private int nkY;
  private LiveConfig nlA;
  private int nlB;
  private boolean nlC;
  private ImageView nlg;
  private TextView nlh;
  private TextView nli;
  private View nlj;
  private TextView nlk;
  private TextView nll;
  private TextView nlm;
  private Button nln;
  private View nlo;
  private ImageView nlp;
  private View nlq;
  private View nlr;
  private ImageView nls;
  private View nlt;
  private ImageView nlu;
  private View nlv;
  private ImageView nlw;
  private Button nlx;
  private final int nly;
  private final int nlz;
  
  public LiveUID()
  {
    AppMethodBeat.i(246280);
    this.TAG = "MicroMsg.LiveUID";
    this.nlz = 1;
    this.nlB = this.nly;
    AppMethodBeat.o(246280);
  }
  
  private static final void a(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246322);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    int i = paramLiveUID.nlB;
    if (i == paramLiveUID.nly)
    {
      paramView = paramLiveUID.nlu;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = paramLiveUID.nlw;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = paramLiveUID.nlq;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramLiveUID = paramLiveUID.nlr;
      if (paramLiveUID != null) {
        break label206;
      }
      paramLiveUID = null;
    }
    for (;;)
    {
      if (paramLiveUID != null) {
        paramLiveUID.setListener(null);
      }
      if (paramLiveUID != null) {
        paramLiveUID.start();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246322);
      return;
      if (i != paramLiveUID.nlz) {
        break;
      }
      paramView = paramLiveUID.nlu;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramView = paramLiveUID.nlw;
      if (paramView == null) {
        break;
      }
      paramView.setVisibility(0);
      break;
      label206:
      paramLiveUID = paramLiveUID.animate();
      if (paramLiveUID == null)
      {
        paramLiveUID = null;
      }
      else
      {
        paramLiveUID = paramLiveUID.translationY(0.0F);
        if (paramLiveUID == null) {
          paramLiveUID = null;
        } else {
          paramLiveUID = paramLiveUID.setDuration(200L);
        }
      }
    }
  }
  
  private static final void b(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246330);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    paramLiveUID.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246330);
  }
  
  private final void bkK()
  {
    AppMethodBeat.i(246290);
    int i = this.nlB;
    TextView localTextView;
    if (i == this.nly)
    {
      localTextView = this.nlk;
      if (localTextView != null)
      {
        localTextView.setText((CharSequence)getContext().getResources().getString(b.h.live_replay_range_only_self));
        AppMethodBeat.o(246290);
      }
    }
    else if (i == this.nlz)
    {
      localTextView = this.nlk;
      if (localTextView != null) {
        localTextView.setText((CharSequence)getContext().getResources().getString(b.h.live_replay_range_room));
      }
    }
    AppMethodBeat.o(246290);
  }
  
  private final void bkL()
  {
    Object localObject2 = null;
    AppMethodBeat.i(246301);
    Object localObject1 = this.nlr;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (localObject1 != null) {
        ((ViewPropertyAnimator)localObject1).setListener((Animator.AnimatorListener)new a(this));
      }
      if (localObject1 != null) {
        ((ViewPropertyAnimator)localObject1).start();
      }
      AppMethodBeat.o(246301);
      return;
      ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate();
      localObject1 = localObject2;
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.translationY(bf.bf((Context)getContext()).y);
        localObject1 = localObject2;
        if (localViewPropertyAnimator != null) {
          localObject1 = localViewPropertyAnimator.setDuration(200L);
        }
      }
    }
  }
  
  private final void bkM()
  {
    AppMethodBeat.i(246311);
    Object localObject = this.nln;
    if (localObject != null) {
      ((Button)localObject).setVisibility(8);
    }
    localObject = this.nlm;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(0);
    }
    localObject = this.nlg;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(8);
    }
    localObject = this.nlh;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((TextView)localObject).getLayoutParams())
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(246311);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = bd.fromDPToPix((Context)getContext(), 72);
    localObject = this.nlh;
    if (localObject != null) {
      ((TextView)localObject).requestLayout();
    }
    AppMethodBeat.o(246311);
  }
  
  private static final void c(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246336);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    if (paramLiveUID.nlC) {
      if (paramLiveUID.nlB != paramLiveUID.nly) {
        d.bkm();
      }
    }
    for (;;)
    {
      paramLiveUID.nlB = paramLiveUID.nly;
      paramView = paramLiveUID.nlu;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramLiveUID = paramLiveUID.nlw;
      if (paramLiveUID != null) {
        paramLiveUID.setVisibility(8);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246336);
      return;
      d.bki();
    }
  }
  
  private static final void d(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246344);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    if (paramLiveUID.nlC) {
      if (paramLiveUID.nlB != paramLiveUID.nlz) {
        d.bkn();
      }
    }
    for (;;)
    {
      paramLiveUID.nlB = paramLiveUID.nlz;
      paramView = paramLiveUID.nlu;
      if (paramView != null) {
        paramView.setVisibility(8);
      }
      paramLiveUID = paramLiveUID.nlw;
      if (paramLiveUID != null) {
        paramLiveUID.setVisibility(0);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246344);
      return;
      d.bkj();
    }
  }
  
  private static final void e(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246353);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    paramLiveUID.bkL();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246353);
  }
  
  private static final void f(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246360);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    int i = paramLiveUID.nlB;
    if (i == paramLiveUID.nly)
    {
      paramView = o.mZb;
      o.fT(false);
    }
    for (;;)
    {
      paramLiveUID.bkK();
      paramLiveUID.bkL();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246360);
      return;
      if (i == paramLiveUID.nlz)
      {
        paramView = o.mZb;
        o.fT(true);
      }
    }
  }
  
  private static final void g(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246366);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    paramLiveUID.bkL();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246366);
  }
  
  private static final void h(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246376);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    localObject = new Intent((Context)paramLiveUID.getContext(), LiveUIB.class);
    ((Intent)localObject).putExtra("FROM_SENCE", paramLiveUID.nkY);
    paramView = paramLiveUID.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/live/ui/LiveUID", "replayGenerated$lambda-7", "(Lcom/tencent/mm/live/ui/LiveUID;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/live/ui/LiveUID", "replayGenerated$lambda-7", "(Lcom/tencent/mm/live/ui/LiveUID;Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView = u.mZl;
    if (kotlin.g.b.s.p(u.big(), z.bAM())) {
      d.bkk();
    }
    for (;;)
    {
      paramLiveUID.nlC = true;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246376);
      return;
      d.bkt();
    }
  }
  
  private static final void i(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246383);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    paramLiveUID.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246383);
  }
  
  private static final void j(LiveUID paramLiveUID, View paramView)
  {
    AppMethodBeat.i(246390);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramLiveUID);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramLiveUID, "this$0");
    paramLiveUID.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/ui/LiveUID", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246390);
  }
  
  public final int getLayoutId()
  {
    return b.f.live_replay_profile_ui;
  }
  
  public final void onBackPressed()
  {
    int i = 1;
    AppMethodBeat.i(246508);
    View localView = this.nlq;
    if ((localView != null) && (localView.isShown() == true)) {}
    while (i != 0)
    {
      bkL();
      AppMethodBeat.o(246508);
      return;
      i = 0;
    }
    super.onBackPressed();
    AppMethodBeat.o(246508);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246485);
    setTheme(b.i.AppTheme_DarkMode_NoTitleTransparent);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    this.nkY = getIntent().getIntExtra("FROM_SENCE", 2);
    long l;
    switch (this.nkY)
    {
    default: 
      setSelfNavigationBarVisible(8);
      getWindow().addFlags(2097280);
      getWindow().addFlags(67108864);
      if (Build.VERSION.SDK_INT >= 21)
      {
        getWindow().clearFlags(67108864);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        getWindow().addFlags(-2147483648);
        getWindow().setStatusBarColor(0);
      }
      getWindow().setFormat(-3);
      getWindow().setSoftInputMode(3);
      this.nlA = ((LiveConfig)getIntent().getParcelableExtra("KEY_PARAMS_CONFIG"));
      if (this.nlA != null)
      {
        paramBundle = u.mZl;
        u.a(new dio());
        paramBundle = u.mZl;
        paramBundle = u.bie();
        localObject = this.nlA;
        if (localObject == null)
        {
          l = 0L;
          label215:
          paramBundle.mMJ = l;
          paramBundle = u.mZl;
          paramBundle = this.nlA;
          if (paramBundle != null) {
            break label556;
          }
          paramBundle = "";
          label237:
          u.Go(paramBundle);
          paramBundle = u.mZl;
          paramBundle = this.nlA;
          if (paramBundle != null) {
            break label577;
          }
          paramBundle = "";
          label258:
          u.Gq(paramBundle);
        }
      }
      else
      {
        paramBundle = this.TAG;
        localObject = new StringBuilder("initConfig liveId:");
        u localu = u.mZl;
        localObject = ((StringBuilder)localObject).append(u.bie().mMJ).append(" wechatRoomId:");
        localu = u.mZl;
        Log.i(paramBundle, u.bhZ());
        this.nlg = ((ImageView)findViewById(b.e.live_replay_profile_status_icon));
        this.nlh = ((TextView)findViewById(b.e.live_replay_profile_title_tv));
        this.nli = ((TextView)findViewById(b.e.live_replay_profile_desc_tv));
        this.nlj = findViewById(b.e.live_replay_profile_range_group);
        this.nlk = ((TextView)findViewById(b.e.live_replay_profile_range_tip_tv));
        this.nll = ((TextView)findViewById(b.e.live_replay_profile_btn_tip_tv));
        this.nlm = ((TextView)findViewById(b.e.live_replay_profile_generating_tv));
        this.nln = ((Button)findViewById(b.e.live_replay_profile_btn));
        this.nlo = findViewById(b.e.live_replay_profile_content_group);
        this.nlp = ((ImageView)findViewById(b.e.live_replay_profile_back_btn));
        paramBundle = this.nlo;
        if (paramBundle != null) {
          break label598;
        }
      }
      break;
    }
    label556:
    label577:
    label598:
    for (paramBundle = null;; paramBundle = paramBundle.getLayoutParams())
    {
      if (paramBundle != null) {
        break label606;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(246485);
      throw paramBundle;
      paramBundle = u.mZl;
      if (kotlin.g.b.s.p(u.big(), z.bAM()))
      {
        d.bkp();
        break;
      }
      d.bkr();
      break;
      paramBundle = u.mZl;
      if (kotlin.g.b.s.p(u.big(), z.bAM()))
      {
        d.bkq();
        break;
      }
      d.bks();
      break;
      l = ((LiveConfig)localObject).liveId;
      break label215;
      localObject = paramBundle.mIz;
      paramBundle = (Bundle)localObject;
      if (localObject != null) {
        break label237;
      }
      paramBundle = "";
      break label237;
      localObject = paramBundle.mIC;
      paramBundle = (Bundle)localObject;
      if (localObject != null) {
        break label258;
      }
      paramBundle = "";
      break label258;
    }
    label606:
    paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
    int i = bf.fs((Context)getContext());
    paramBundle.topMargin = (bf.getStatusBarHeight((Context)getContext()) + i);
    paramBundle = this.nlg;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.nlh;
    if (paramBundle == null) {}
    for (paramBundle = null; paramBundle == null; paramBundle = paramBundle.getLayoutParams())
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(246485);
      throw paramBundle;
    }
    ((ViewGroup.MarginLayoutParams)paramBundle).topMargin = bd.fromDPToPix((Context)getContext(), 72);
    paramBundle = this.nlh;
    if (paramBundle != null) {
      paramBundle.requestLayout();
    }
    paramBundle = this.nlj;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new LiveUID..ExternalSyntheticLambda6(this));
    }
    paramBundle = this.nlp;
    if (paramBundle != null) {
      paramBundle.setOnClickListener(new LiveUID..ExternalSyntheticLambda3(this));
    }
    paramBundle = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
    Object localObject = u.mZl;
    if (Util.isEqual(paramBundle, u.big()))
    {
      paramBundle = this.nlj;
      if (paramBundle != null) {
        paramBundle.setVisibility(0);
      }
    }
    for (;;)
    {
      bkK();
      this.nlq = findViewById(b.e.live_replay_profile_range_panel);
      this.nlr = findViewById(b.e.live_replay_profile_range_content_panel);
      this.nls = ((ImageView)findViewById(b.e.live_replay_profile_range_content_close));
      this.nlt = findViewById(b.e.live_replay_profile_range_self_group);
      this.nlu = ((ImageView)findViewById(b.e.live_replay_profile_range_self_check));
      this.nlv = findViewById(b.e.live_replay_profile_range_room_group);
      this.nlw = ((ImageView)findViewById(b.e.live_replay_profile_range_room_check));
      this.nlx = ((Button)findViewById(b.e.live_replay_profile_range_content_btn));
      paramBundle = this.nlq;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.nlr;
      if (paramBundle != null) {
        paramBundle.setTranslationY(bf.bf((Context)getContext()).y);
      }
      paramBundle = this.nlt;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new LiveUID..ExternalSyntheticLambda2(this));
      }
      paramBundle = this.nlv;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new LiveUID..ExternalSyntheticLambda0(this));
      }
      paramBundle = this.nlq;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new LiveUID..ExternalSyntheticLambda7(this));
      }
      paramBundle = this.nlx;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new LiveUID..ExternalSyntheticLambda8(this));
      }
      paramBundle = this.nls;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new LiveUID..ExternalSyntheticLambda4(this));
      }
      paramBundle = o.mZb;
      o.bhM();
      com.tencent.mm.kernel.h.baD().mCm.a(3806, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.baD().mCm.a(3712, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(246485);
      return;
      paramBundle = this.nlj;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(246499);
    super.onDestroy();
    com.tencent.mm.kernel.h.baD().mCm.b(3806, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.baD().mCm.b(3712, (com.tencent.mm.am.h)this);
    if (this.nlA != null)
    {
      u localu = u.mZl;
      u.aNm();
    }
    AppMethodBeat.o(246499);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(246492);
    super.onResume();
    AppMethodBeat.o(246492);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(246529);
    Log.i(this.TAG, "errType:" + paramInt1 + ", errCode:" + paramInt2);
    if ((paramp instanceof com.tencent.mm.live.model.a.b))
    {
      paramString = u.mZl;
      int i;
      if (u.bie().aaNm)
      {
        i = this.nlz;
        this.nlB = i;
        bkK();
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label1031;
        }
        paramString = u.mZl;
        paramString = u.bie();
        if (!kotlin.g.b.s.p(paramString.aaNn, paramString.aaNo)) {
          break label302;
        }
        paramString = (CharSequence)paramString.ZRm;
        if ((paramString != null) && (paramString.length() != 0)) {
          break label292;
        }
        paramInt1 = 1;
        label130:
        if (paramInt1 != 0) {
          break label297;
        }
        paramInt1 = 1;
        label136:
        if (paramInt1 == 0) {
          break label398;
        }
        paramString = this.nlm;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.nll;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setText((CharSequence)getContext().getResources().getString(b.h.live_after_replay_scan));
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setOnClickListener(new LiveUID..ExternalSyntheticLambda9(this));
        }
        paramString = this.nlg;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.nlh;
        if (paramString != null) {
          break label351;
        }
      }
      label292:
      label297:
      label302:
      label346:
      label351:
      for (paramString = null;; paramString = paramString.getLayoutParams())
      {
        if (paramString != null) {
          break label359;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(246529);
        throw paramString;
        i = this.nly;
        break;
        paramInt1 = 0;
        break label130;
        paramInt1 = 0;
        break label136;
        if (paramString.aaNm)
        {
          paramString = (CharSequence)paramString.ZRm;
          if ((paramString == null) || (paramString.length() == 0)) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            if (paramInt1 != 0) {
              break label346;
            }
            paramInt1 = 1;
            break;
          }
        }
        paramInt1 = 0;
        break label136;
      }
      label359:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = bd.fromDPToPix((Context)getContext(), 72);
      paramString = this.nlh;
      if (paramString != null) {
        paramString.requestLayout();
      }
      AppMethodBeat.o(246529);
      return;
      label398:
      paramString = u.mZl;
      paramInt1 = u.bie().status;
      paramString = l.d.mYm;
      if (paramInt1 == l.d.bht())
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label704;
        }
        paramString = this.nlh;
        if (paramString != null) {
          paramString.setText((CharSequence)getContext().getResources().getString(b.h.live_replay_profile_title_invalid));
        }
        paramString = this.nli;
        if (paramString != null) {
          paramString.setText((CharSequence)getContext().getResources().getString(b.h.live_replay_profile_desc_invalid));
        }
        paramString = this.nlm;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.nll;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setText((CharSequence)getContext().getResources().getString(b.h.app_i_know));
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setOnClickListener(new LiveUID..ExternalSyntheticLambda5(this));
        }
        paramString = this.nlg;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.nlg;
        if (paramString != null) {
          paramString.setImageDrawable(getContext().getResources().getDrawable(b.g.icons_dark_help));
        }
        paramString = this.nlh;
        if (paramString != null) {
          break label657;
        }
      }
      label657:
      for (paramString = null;; paramString = paramString.getLayoutParams())
      {
        if (paramString != null) {
          break label665;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(246529);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label665:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = bd.fromDPToPix((Context)getContext(), 40);
      paramString = this.nlh;
      if (paramString != null) {
        paramString.requestLayout();
      }
      AppMethodBeat.o(246529);
      return;
      label704:
      paramString = u.mZl;
      paramString = u.bie();
      paramInt1 = paramString.status;
      paramp = l.d.mYm;
      if ((paramInt1 == l.d.bhs()) && (!paramString.aaNm))
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1020;
        }
        paramString = this.nlh;
        if (paramString != null) {
          paramString.setText((CharSequence)getContext().getResources().getString(b.h.live_replay_profile_title_closed));
        }
        paramString = this.nli;
        if (paramString != null) {
          paramString.setText((CharSequence)getContext().getResources().getString(b.h.live_replay_profile_desc_closed));
        }
        paramString = this.nlm;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.nll;
        if (paramString != null) {
          paramString.setVisibility(8);
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setText((CharSequence)getContext().getResources().getString(b.h.app_i_know));
        }
        paramString = this.nln;
        if (paramString != null) {
          paramString.setOnClickListener(new LiveUID..ExternalSyntheticLambda1(this));
        }
        paramString = this.nlg;
        if (paramString != null) {
          paramString.setVisibility(0);
        }
        paramString = this.nlg;
        if (paramString != null) {
          paramString.setImageDrawable(getContext().getResources().getDrawable(b.g.icons_dark_help));
        }
        paramString = this.nlh;
        if (paramString != null) {
          break label973;
        }
      }
      label973:
      for (paramString = null;; paramString = paramString.getLayoutParams())
      {
        if (paramString != null) {
          break label981;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(246529);
        throw paramString;
        paramInt1 = 0;
        break;
      }
      label981:
      ((ViewGroup.MarginLayoutParams)paramString).topMargin = bd.fromDPToPix((Context)getContext(), 40);
      paramString = this.nlh;
      if (paramString != null) {
        paramString.requestLayout();
      }
      AppMethodBeat.o(246529);
      return;
      label1020:
      bkM();
      AppMethodBeat.o(246529);
      return;
      label1031:
      bkM();
    }
    AppMethodBeat.o(246529);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/ui/LiveUID$hideRangePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(LiveUID paramLiveUID) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246308);
      paramAnimator = LiveUID.a(this.nlD);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      AppMethodBeat.o(246308);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID
 * JD-Core Version:    0.7.0.1
 */