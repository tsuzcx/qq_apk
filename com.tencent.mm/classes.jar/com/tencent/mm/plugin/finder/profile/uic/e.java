package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.service.r;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.finder.viewmodel.component.ao;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.plugin.findersdk.b.b.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "callback1", "Lkotlin/Function0;", "", "canNoLongerShowBtn", "", "getCanNoLongerShowBtn", "()Z", "setCanNoLongerShowBtn", "(Z)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "clickGo", "getClickGo", "setClickGo", "clickToLoad", "getClickToLoad", "setClickToLoad", "fromMusic", "getFromMusic", "setFromMusic", "hasLoad", "getHasLoad", "setHasLoad", "isRecyclerInit", "isSelf", "isSelfFlag", "isSelfFlag$delegate", "justWatchedIndex", "", "justWatchedLayout", "Landroid/view/View;", "getJustWatchedLayout", "()Landroid/view/View;", "justWatchedLayout$delegate", "justWatchedLittleIcon1", "getJustWatchedLittleIcon1", "justWatchedLittleIcon1$delegate", "justWatchedLoading", "getJustWatchedLoading", "justWatchedLoading$delegate", "loadingComponent", "Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "getLoadingComponent", "()Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;", "setLoadingComponent", "(Lcom/tencent/mm/plugin/findersdk/cgi/DelayLoadingComponent;)V", "nowPosition", "profileSettingCallback", "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "tipsLayout", "getTipsLayout", "tipsLayout$delegate", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "tv$delegate", "username", "", "getUsername", "()Ljava/lang/String;", "username$delegate", "beginLoad", "btnGone", "btnNoLongerShow", "checkjumpToJustWatchedBtn", "doSet", "isChecked", "endLoad", "initLinkText", "jumpToJustWatched", "onCreateAfter", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "report21874", "action", "report21875", "eid", "actionId", "report21875ForJustWatched", "source", "resetLoading", "callback", "setNowPosition", "pos", "setRecyclerView", "profileRecyclerView", "setjustWatchedIndex", "index", "showEduBottomSheet", "showWxProfileTips", "switchWxProfileSetting", "updateBottomSheetCount", "updateCount", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
{
  private final j AIq;
  private final j AxO;
  private final j BlK;
  com.tencent.mm.plugin.findersdk.b.b DiB;
  private final j Fdg;
  private final j Fdh;
  private final j Fdi;
  private boolean Fdj;
  private boolean Fdk;
  private final j Fdl;
  private final j Fdm;
  boolean Fdn;
  int Fdo;
  int Fdp;
  boolean Fdq;
  boolean Fdr;
  private final h Fds;
  kotlin.g.a.a<ah> Fdt;
  private boolean Fdu;
  RecyclerView mkw;
  
  public e(final AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348940);
    this.Fdg = kotlin.k.cm((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.Fdh = kotlin.k.cm((kotlin.g.a.a)new a(paramAppCompatActivity));
    this.Fdi = kotlin.k.cm((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.Fdl = kotlin.k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    this.AxO = kotlin.k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.Fdm = kotlin.k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.Fdo = -1;
    this.Fdp = -1;
    this.AIq = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.BlK = kotlin.k.cm((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.Fds = new h(this, paramAppCompatActivity);
    AppMethodBeat.o(348940);
  }
  
  private static final void a(RecyclerView paramRecyclerView, int paramInt, e parame, View paramView)
  {
    AppMethodBeat.i(349125);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRecyclerView, "$recyclerView");
    s.u(parame, "this$0");
    paramView = paramRecyclerView.getLayoutManager();
    if (paramView == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(349125);
      throw paramRecyclerView;
    }
    ((FinderStaggeredGridLayoutManager)paramView).u(paramRecyclerView, paramInt + 1);
    parame.Fdq = true;
    paramRecyclerView.postDelayed(new e..ExternalSyntheticLambda8(parame), 200L);
    parame.eu("channel_profile_recentviewed", 1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349125);
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(349076);
    s.u(parame, "this$0");
    if (!parame.Fdk) {
      a(parame, "cancel", 0, null, 6);
    }
    AppMethodBeat.o(349076);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(349063);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    parame.getCheckBox().toggle();
    parame.eJb();
    eJa();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349063);
  }
  
  private static final void a(e parame, com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(349086);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    s.u(paramd, "$this_apply");
    a(parame, "set", 0, null, 6);
    parame.Fdk = true;
    parame.getCheckBox().setChecked(true);
    parame.th(true);
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349086);
  }
  
  private static final void b(e parame)
  {
    AppMethodBeat.i(349116);
    s.u(parame, "this$0");
    parame.eJe();
    AppMethodBeat.o(349116);
  }
  
  private static final void b(e parame, View paramView)
  {
    AppMethodBeat.i(349070);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    parame.eJb();
    eJa();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349070);
  }
  
  private static final void c(e parame, View paramView)
  {
    AppMethodBeat.i(349109);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parame, "this$0");
    if (!parame.Fdu)
    {
      parame.Fdu = true;
      if (parame.eIZ().getVisibility() == 0)
      {
        parame.eIZ().setVisibility(8);
        parame.dUT().setVisibility(0);
      }
      parame = parame.Fdt;
      if (parame != null) {
        parame.invoke();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349109);
  }
  
  private View dUT()
  {
    AppMethodBeat.i(348962);
    Object localObject = this.AxO.getValue();
    s.s(localObject, "<get-justWatchedLoading>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(348962);
    return localObject;
  }
  
  private View eIW()
  {
    AppMethodBeat.i(348947);
    View localView = (View)this.Fdg.getValue();
    AppMethodBeat.o(348947);
    return localView;
  }
  
  private TextView eIX()
  {
    AppMethodBeat.i(348956);
    TextView localTextView = (TextView)this.Fdi.getValue();
    AppMethodBeat.o(348956);
    return localTextView;
  }
  
  private View eIZ()
  {
    AppMethodBeat.i(348970);
    Object localObject = this.Fdm.getValue();
    s.s(localObject, "<get-justWatchedLittleIcon1>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(348970);
    return localObject;
  }
  
  private static void eJa()
  {
    AppMethodBeat.i(349001);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.addO, Integer.valueOf(1));
    AppMethodBeat.o(349001);
  }
  
  private final void eJb()
  {
    AppMethodBeat.i(349012);
    Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.b((Context)getActivity(), 13L, 1L);
    boolean bool = getCheckBox().isChecked();
    localObject = av.GiL;
    if (bool != av.ffW()) {
      th(bool);
    }
    AppMethodBeat.o(349012);
  }
  
  private final void eJc()
  {
    AppMethodBeat.i(349025);
    Object localObject = this.DiB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).end();
    }
    localObject = com.tencent.mm.plugin.findersdk.b.b.HcE;
    this.DiB = b.a.d((Context)getContext(), getContext().getString(com.tencent.mm.plugin.finder.e.h.app_waiting), 500L);
    localObject = this.DiB;
    if (localObject != null) {
      ((com.tencent.mm.plugin.findersdk.b.b)localObject).begin();
    }
    AppMethodBeat.o(349025);
  }
  
  private void eu(String paramString, int paramInt)
  {
    AppMethodBeat.i(349051);
    s.u(paramString, "eid");
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("source", 1);
    String str2 = ((JSONObject)localObject).toString();
    s.s(str2, "JSONObject().apply {\n   …rce)\n        }.toString()");
    String str3 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    String str1 = getActivity().getIntent().getStringExtra("key_context_id");
    localObject = str1;
    if (str1 == null) {
      localObject = "";
    }
    if (isSelf()) {}
    for (int i = 33;; i = 32)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.plugin.report.service.h.OAn.b(21875, new Object[] { str3, localObject, Integer.valueOf(i), Integer.valueOf(paramInt), String.valueOf(l), str2, paramString });
      AppMethodBeat.o(349051);
      return;
    }
  }
  
  private final String getUsername()
  {
    AppMethodBeat.i(348993);
    String str = (String)this.BlK.getValue();
    AppMethodBeat.o(348993);
    return str;
  }
  
  private static final void i(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(349093);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "$this_apply");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(349093);
  }
  
  private final boolean isSelf()
  {
    AppMethodBeat.i(348984);
    boolean bool = s.p(getUsername(), com.tencent.mm.model.z.bAW());
    AppMethodBeat.o(348984);
    return bool;
  }
  
  private final boolean isSelfFlag()
  {
    AppMethodBeat.i(348976);
    boolean bool = ((Boolean)this.AIq.getValue()).booleanValue();
    AppMethodBeat.o(348976);
    return bool;
  }
  
  private static final void q(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(349100);
    s.u(paramRecyclerView, "$recyclerView");
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    if (localLayoutManager == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager");
      AppMethodBeat.o(349100);
      throw paramRecyclerView;
    }
    ((FinderStaggeredGridLayoutManager)localLayoutManager).u(paramRecyclerView, paramInt + 1);
    AppMethodBeat.o(349100);
  }
  
  private final void th(boolean paramBoolean)
  {
    AppMethodBeat.i(349020);
    Log.i("SimpleUIComponent", s.X("change isShowAtWxProfile, now:", Boolean.valueOf(paramBoolean)));
    eJc();
    ((r)com.tencent.mm.kernel.h.ax(r.class)).a(paramBoolean, (ck)this.Fds);
    AppMethodBeat.o(349020);
  }
  
  public final void O(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(349240);
    s.u(paramString1, "eid");
    s.u(paramString2, "actionId");
    String str = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    Object localObject2 = getActivity().getIntent().getStringExtra("key_context_id");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    long l = System.currentTimeMillis();
    localObject2 = new JSONObject();
    label144:
    do
    {
      try
      {
        int i = paramString1.hashCode();
        switch (i)
        {
        }
      }
      finally
      {
        break label144;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(21875, new Object[] { str, localObject1, Integer.valueOf(78), Integer.valueOf(paramInt), String.valueOf(l), paramString1, ((JSONObject)localObject2).toString() });
      AppMethodBeat.o(349240);
      return;
    } while (!paramString1.equals("music_card"));
    for (;;)
    {
      ((JSONObject)localObject2).put("feedid", paramString2);
      break;
      if (!paramString1.equals("mvdelete"))
      {
        if ((goto 144) || (!paramString1.equals("draftdelete"))) {
          break;
        }
        do
        {
          ((JSONObject)localObject2).put("draftid", paramString2);
          break;
        } while (paramString1.equals("draft"));
        break;
        if (!paramString1.equals("mv"))
        {
          break;
          boolean bool = paramString1.equals("music_play");
          if (!bool) {
            break;
          }
        }
      }
    }
  }
  
  public final View eIY()
  {
    AppMethodBeat.i(349192);
    Object localObject = this.Fdl.getValue();
    s.s(localObject, "<get-justWatchedLayout>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(349192);
    return localObject;
  }
  
  public final void eJd()
  {
    AppMethodBeat.i(349257);
    if ((this.Fdn) && (this.Fdo != -1) && ((this.Fdp != -1) || (this.Fdr)))
    {
      int i = this.Fdo;
      int j = this.Fdp;
      RecyclerView localRecyclerView = this.mkw;
      if (localRecyclerView == null)
      {
        s.bIx("recyclerView");
        localRecyclerView = null;
      }
      for (;;)
      {
        s.u(localRecyclerView, "recyclerView");
        if (j == -2)
        {
          this.Fdq = false;
          this.Fdr = true;
          this.Fdu = false;
          if (dUT().getVisibility() == 0)
          {
            dUT().setVisibility(8);
            eIZ().setVisibility(0);
          }
        }
        if ((i >= j + 1) && (j != -1)) {
          this.Fdq = true;
        }
        if (this.Fdq) {
          break label410;
        }
        if ((i < 8) && (!this.Fdu)) {
          break label399;
        }
        if ((j == -1) && (!this.Fdr) && (!this.Fdu)) {
          break;
        }
        if (eIY().getVisibility() == 4)
        {
          eIY().setVisibility(0);
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(eIY().getWidth(), 0.0F, 0.0F, 0.0F);
          localTranslateAnimation.setDuration(300L);
          localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator((Context)getContext(), 17432581));
          eIY().startAnimation((Animation)localTranslateAnimation);
          eu("channel_profile_recentviewed", 0);
        }
        if ((this.Fdu) && (j != -1))
        {
          this.Fdq = true;
          eJe();
          localRecyclerView.postDelayed(new e..ExternalSyntheticLambda7(localRecyclerView, j), 200L);
          eu("channel_profile_recentviewed", 1);
        }
        if ((this.Fdr) && (j == -1) && (!this.Fdu) && (!eIY().hasOnClickListeners())) {
          eIY().setOnClickListener(new e..ExternalSyntheticLambda2(this));
        }
        if ((this.Fdu) || (j == -1)) {
          break label414;
        }
        eIY().setOnClickListener(new e..ExternalSyntheticLambda0(localRecyclerView, j, this));
        AppMethodBeat.o(349257);
        return;
      }
      eJe();
      AppMethodBeat.o(349257);
      return;
      label399:
      eJe();
      AppMethodBeat.o(349257);
      return;
      label410:
      eJe();
    }
    label414:
    AppMethodBeat.o(349257);
  }
  
  public final void eJe()
  {
    AppMethodBeat.i(349266);
    if ((eIY() != null) && (eIY().getVisibility() == 0))
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, eIY().getWidth(), 0.0F, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator((Context)getContext(), 17432581));
      eIY().startAnimation((Animation)localTranslateAnimation);
      eIY().setVisibility(4);
    }
    AppMethodBeat.o(349266);
  }
  
  public final CheckBox getCheckBox()
  {
    AppMethodBeat.i(349189);
    CheckBox localCheckBox = (CheckBox)this.Fdh.getValue();
    AppMethodBeat.o(349189);
    return localCheckBox;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(349220);
    super.onCreateAfter(paramBundle);
    boolean bool;
    if (getIntent().getIntExtra("key_from_profile_share_scene", 0) == 19) {
      bool = true;
    }
    for (;;)
    {
      this.Fdj = bool;
      if (this.Fdj)
      {
        paramBundle = com.tencent.mm.ui.component.k.aeZF;
        ((ao)com.tencent.mm.ui.component.k.d(getActivity()).q(ao.class)).iv("Source", "1");
      }
      paramBundle = new StringBuilder("showWxProfileTips ").append(isSelf()).append(", ").append(isSelfFlag()).append(", ");
      Object localObject1 = com.tencent.mm.plugin.finder.utils.aq.Giv;
      paramBundle = paramBundle.append(com.tencent.mm.plugin.finder.utils.aq.ffG()).append(", ");
      localObject1 = av.GiL;
      label139:
      label169:
      int i;
      label252:
      Object localObject3;
      label517:
      label569:
      Object localObject4;
      long l;
      Object localObject5;
      if (!av.ffW())
      {
        bool = true;
        paramBundle = paramBundle.append(bool).append(", ");
        if (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.addO, 0) != 0) {
          break label1109;
        }
        bool = true;
        Log.i("SimpleUIComponent", bool);
        if ((!isSelf()) || (!isSelfFlag())) {
          break label1114;
        }
        paramBundle = com.tencent.mm.plugin.finder.utils.aq.Giv;
        if (!com.tencent.mm.plugin.finder.utils.aq.ffG()) {
          break label1114;
        }
        paramBundle = av.GiL;
        if ((av.ffW()) || (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.addO, 0) != 0) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())) {
          break label1114;
        }
        i = 1;
        if (i == 0) {
          break label1119;
        }
        paramBundle = com.tencent.mm.plugin.finder.report.z.FrZ;
        com.tencent.mm.plugin.finder.report.z.b((Context)getActivity(), 13L, 2L);
        eIW().setVisibility(0);
        paramBundle = getCheckBox();
        localObject1 = av.GiL;
        paramBundle.setChecked(av.ffW());
        localObject1 = getContext().getString(com.tencent.mm.plugin.finder.e.h.finder_profile_show_tips_link);
        s.s(localObject1, "context.getString(R.stri…r_profile_show_tips_link)");
        paramBundle = getContext().getString(com.tencent.mm.plugin.finder.e.h.finder_profile_show_tips, new Object[] { localObject1 });
        s.s(paramBundle, "context.getString(R.stri…file_show_tips, linkText)");
        paramBundle = p.b((Context)getActivity(), (CharSequence)paramBundle);
        s.s(paramBundle, "tips");
        i = n.a((CharSequence)paramBundle, (String)localObject1, 0, false, 6);
        if (i >= 0) {
          paramBundle.setSpan(new q((String)localObject1, getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Link), getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Link_Alpha_0_6), (kotlin.g.a.b)new b(this)), i, ((String)localObject1).length() + i, 17);
        }
        eIX().setText((CharSequence)paramBundle);
        localObject1 = av.GiL;
        localObject1 = eIX();
        s.s(localObject1, "tv");
        av.a((TextView)localObject1, (Spannable)paramBundle);
        eIW().setOnClickListener(new e..ExternalSyntheticLambda3(this));
        getCheckBox().setOnClickListener(new e..ExternalSyntheticLambda1(this));
        if ((!isSelf()) || (!isSelfFlag())) {
          break label1131;
        }
        paramBundle = com.tencent.mm.plugin.finder.utils.aq.Giv;
        if (!com.tencent.mm.plugin.finder.utils.aq.ffG()) {
          break label1131;
        }
        paramBundle = av.GiL;
        if ((av.ffW()) || (com.tencent.mm.kernel.h.baE().ban().getInt(at.a.addP, 0) != 0)) {
          break label1131;
        }
        i = 1;
        if (i != 0)
        {
          com.tencent.mm.kernel.h.baE().ban().set(at.a.addP, Integer.valueOf(1));
          paramBundle = new com.tencent.mm.plugin.finder.view.d((Context)getActivity());
          paramBundle.UD(com.tencent.mm.plugin.finder.e.f.finder_wxprofile_edu_bottom_sheet);
          localObject1 = paramBundle.rootView.findViewById(com.tencent.mm.plugin.finder.e.e.wxprofile_apply_title_tv);
          s.s(localObject1, "rootView.findViewById<Te…wxprofile_apply_title_tv)");
          i.setTextBold((TextView)localObject1);
          localObject1 = new SpannableStringBuilder();
          ((SpannableStringBuilder)localObject1).append((CharSequence)getContext().getString(com.tencent.mm.plugin.finder.e.h.finder_wxprofile_apply_desc));
          localObject3 = p.b((Context)getContext(), (CharSequence)getContext().getString(com.tencent.mm.plugin.finder.e.h.finder_wxprofile_apply_desc_click));
          localObject4 = ((SpannableString)localObject3).toString();
          s.s(localObject4, "linkSpan.toString()");
          ((SpannableString)localObject3).setSpan(new q((String)localObject4, getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Link), getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Link_Alpha_0_6), (kotlin.g.a.b)new g(this)), 0, ((SpannableString)localObject3).length(), 17);
          ((SpannableStringBuilder)localObject1).append((CharSequence)localObject3);
          localObject3 = (TextView)paramBundle.rootView.findViewById(com.tencent.mm.plugin.finder.e.e.wxprofile_apply_desc_tv);
          ((TextView)localObject3).setText((CharSequence)localObject1);
          localObject4 = av.GiL;
          s.s(localObject3, "descTv");
          av.a((TextView)localObject3, (Spannable)localObject1);
          paramBundle.GwT = new e..ExternalSyntheticLambda6(this);
          paramBundle.rootView.findViewById(com.tencent.mm.plugin.finder.e.e.wxprofile_apply_btn).setOnClickListener(new e..ExternalSyntheticLambda4(this, paramBundle));
          paramBundle.rootView.findViewById(com.tencent.mm.plugin.finder.e.e.wxprofile_no_apply_btn).setOnClickListener(new e..ExternalSyntheticLambda5(paramBundle));
          paramBundle.dDn();
          localObject3 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
          localObject1 = getActivity().getIntent().getStringExtra("key_context_id");
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = "";
          }
          i = getActivity().getIntent().getIntExtra("KEY_REF_COMMENTSCENE", 0);
          l = System.currentTimeMillis();
          localObject5 = new JSONObject();
        }
      }
      try
      {
        if (this.Fdj)
        {
          ((JSONObject)localObject5).put("Source", 1);
          label974:
          localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
          localObject4 = getUsername();
          localObject5 = ((JSONObject)localObject5).toString();
          com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
          ((com.tencent.mm.plugin.report.service.h)localObject1).b(21874, new Object[] { localObject3, paramBundle, Integer.valueOf(78), Integer.valueOf(2), String.valueOf(l), localObject4, localObject5, ((as)com.tencent.mm.ui.component.k.d(getActivity()).q(as.class)).zIB, Integer.valueOf(i), Integer.valueOf(0) });
          AppMethodBeat.o(349220);
          return;
          bool = false;
          continue;
          bool = false;
          break label139;
          label1109:
          bool = false;
          break label169;
          label1114:
          i = 0;
          break label252;
          label1119:
          eIW().setVisibility(8);
          break label517;
          label1131:
          i = 0;
          break label569;
        }
        ((JSONObject)localObject5).put("Source", 0);
      }
      finally
      {
        break label974;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(349226);
    super.onResume();
    CheckBox localCheckBox = getCheckBox();
    av localav = av.GiL;
    localCheckBox.setChecked(av.ffW());
    AppMethodBeat.o(349226);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<CheckBox>
  {
    a(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<View>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<View>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/profile/uic/FinderProfileEduUIC$profileSettingCallback$1", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "onModifyResult", "", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements ck<bqe>
  {
    h(e parame, AppCompatActivity paramAppCompatActivity) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<View>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<TextView>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<String>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.profile.uic.e
 * JD-Core Version:    0.7.0.1
 */