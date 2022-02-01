package com.tencent.mm.plugin.finder.viewmodel.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.c.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.feed.model.internal.m.a;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.protocal.protobuf.bex;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "backBtn", "Landroid/widget/LinearLayout;", "cancelText", "Landroid/widget/TextView;", "doneBtn", "Landroid/widget/Button;", "headerText", "manageText", "stateMachine", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine;", "username", "", "addMentionInfo", "", "modList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModMentionedInfo;", "feedIdList", "", "", "opType", "", "fitTextViewBigFont", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onLoadMore", "increment", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onPause", "onResume", "resetEnterUI", "resetExitUI", "plugin-finder_release"})
@SuppressLint({"StaticFieldLeak"})
public final class h
  extends UIComponent
{
  b BiA;
  private TextView Biw;
  private TextView Bix;
  private TextView Biy;
  private Button Biz;
  private String username;
  private LinearLayout wWT;
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(267588);
    String str = getIntent().getStringExtra("KEY_PARAMS_USERNAME");
    paramAppCompatActivity = str;
    if (str == null) {
      paramAppCompatActivity = "";
    }
    this.username = paramAppCompatActivity;
    AppMethodBeat.o(267588);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(267580);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(b.f.backBtn);
    p.j(paramBundle, "activity.findViewById(R.id.backBtn)");
    this.wWT = ((LinearLayout)paramBundle);
    paramBundle = getActivity().findViewById(b.f.at_feed_header_cancel_text);
    p.j(paramBundle, "activity.findViewById(R.…_feed_header_cancel_text)");
    this.Biw = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.at_feed_header_text);
    p.j(paramBundle, "activity.findViewById(R.id.at_feed_header_text)");
    this.Bix = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.at_feed_header_manage_text);
    p.j(paramBundle, "activity.findViewById(R.…_feed_header_manage_text)");
    this.Biy = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.at_feed_header_manage_done_btn);
    p.j(paramBundle, "activity.findViewById(R.…d_header_manage_done_btn)");
    this.Biz = ((Button)paramBundle);
    paramBundle = this.Bix;
    if (paramBundle == null) {
      p.bGy("headerText");
    }
    ar.a((Paint)paramBundle.getPaint(), 0.8F);
    paramBundle = this.wWT;
    if (paramBundle == null) {
      p.bGy("backBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new a(this));
    paramBundle = this.Biw;
    if (paramBundle == null) {
      p.bGy("cancelText");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    paramBundle = this.Biz;
    if (paramBundle == null) {
      p.bGy("doneBtn");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = this.Biy;
    if (paramBundle == null) {
      p.bGy("manageText");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new d(this));
    paramBundle = this.Biw;
    if (paramBundle == null) {
      p.bGy("cancelText");
    }
    paramBundle.setTextSize(1, 17.0F);
    paramBundle = this.Bix;
    if (paramBundle == null) {
      p.bGy("headerText");
    }
    paramBundle.setTextSize(1, 17.0F);
    paramBundle = this.Biy;
    if (paramBundle == null) {
      p.bGy("manageText");
    }
    paramBundle.setTextSize(1, 17.0F);
    paramBundle = this.Biz;
    if (paramBundle == null) {
      p.bGy("doneBtn");
    }
    paramBundle.setTextSize(1, 14.0F);
    AppMethodBeat.o(267580);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(267582);
    super.onCreateAfter(paramBundle);
    paramBundle = getActivity();
    Object localObject = g.Xox;
    localObject = ((f)g.b(getActivity()).i(f.class)).ekp().getDataListJustForAdapter();
    if (localObject == null)
    {
      paramBundle = new t("null cannot be cast to non-null type kotlin.collections.MutableList<com.tencent.mm.plugin.finder.model.BaseFinderFeed>");
      AppMethodBeat.o(267582);
      throw paramBundle;
    }
    this.BiA = new b(paramBundle, ag.ff(localObject));
    paramBundle = this.BiA;
    if (paramBundle == null) {
      p.bGy("stateMachine");
    }
    paramBundle.BhI.alive();
    paramBundle = this.BiA;
    if (paramBundle == null) {
      p.bGy("stateMachine");
    }
    localObject = (b.c)new e(this);
    p.k(localObject, "listener");
    if (!paramBundle.BhH.contains(localObject)) {
      paramBundle.BhH.add(localObject);
    }
    AppMethodBeat.o(267582);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(267587);
    super.onDestroy();
    b localb = this.BiA;
    if (localb == null) {
      p.bGy("stateMachine");
    }
    localb.BhH.clear();
    localb = this.BiA;
    if (localb == null) {
      p.bGy("stateMachine");
    }
    localb.BhI.dead();
    AppMethodBeat.o(267587);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(267585);
    super.onPause();
    AppMethodBeat.o(267585);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(267583);
    super.onResume();
    AppMethodBeat.o(267583);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289198);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!this.BiB.getActivity().isFinishing())
      {
        paramView = n.zWF;
        paramView = g.Xox;
        n.a(1, "manage_return", "", ((aj)g.b(this.BiB.getActivity()).i(aj.class)).ekY());
        h.a(this.BiB).a(b.d.BhR);
        this.BiB.getActivity().finish();
      }
      a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289198);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(290739);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      h.a(this.BiB).ekg();
      a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(290739);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285406);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = h.a(this.BiB);
      paramView.rB(false);
      paramView.a(b.d.BhO);
      a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285406);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(h paramh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(279925);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = h.a(this.BiB);
      localObject = paramView.BhD;
      switch (c.$EnumSwitchMapping$0[localObject.ordinal()])
      {
      default: 
        Log.i("Finder.AtFeedSelectStateMachine", "enterSelect transition error! state:" + paramView.BhD);
      }
      for (;;)
      {
        a.a(this, "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(279925);
        return;
        paramView.rB(true);
        paramView.a(b.d.BhN);
        continue;
        paramView.rB(true);
        paramView.a(b.d.BhN);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateListener;", "onStateChange", "", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "data", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateData;", "plugin-finder_release"})
  public static final class e
    implements b.c
  {
    public final void a(b.d paramd, b.b paramb)
    {
      AppMethodBeat.i(288801);
      p.k(paramd, "state");
      p.k(paramb, "data");
      switch (i.$EnumSwitchMapping$0[paramd.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(288801);
        return;
        paramd = g.Xox;
        paramd = ((f)g.b(this.BiB.getActivity()).i(f.class)).ekp();
        paramb = h.a(this.BiB).ekh();
        paramd.q((List)paramb.Mx, 3);
        paramd.q((List)paramb.My, 2);
        h.b(this.BiB);
        AppMethodBeat.o(288801);
        return;
        h.c(this.BiB);
        AppMethodBeat.o(288801);
        return;
        paramd = new LinkedList();
        List localList = paramb.BhK;
        if ((localList != null) && (localList.isEmpty() == true))
        {
          localList = paramb.BhL;
          if ((localList != null) && (localList.isEmpty() == true)) {}
        }
        else
        {
          h.a(paramd, paramb.BhK, 0);
          h.a(paramd, paramb.BhL, 1);
          paramd = new com.tencent.mm.plugin.finder.cgi.x(0, 0L, h.d(this.BiB), paramd, null, 16).e((Context)this.BiB.getActivity(), "", 100L).bhW();
          paramb = this.BiB.getActivity();
          if (paramb == null)
          {
            paramd = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(288801);
            throw paramd;
          }
          paramd = paramd.a((com.tencent.mm.vending.e.b)paramb);
          p.j(paramd, "CgiFinderModMentioned(Cg…e(activity as MMActivity)");
          d.b((com.tencent.mm.vending.g.c)paramd, (kotlin.g.a.b)new a(this));
          AppMethodBeat.o(288801);
          return;
        }
        h.a(this.BiB).rA(false);
        AppMethodBeat.o(288801);
        return;
        h.a(this.BiB).ekg();
        paramd = m.xKK;
        m.a.c("atFeedManage", h.a(this.BiB).BhF);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<c.a<bex>, kotlin.x>
    {
      a(h.e parame)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.h
 * JD-Core Version:    0.7.0.1
 */