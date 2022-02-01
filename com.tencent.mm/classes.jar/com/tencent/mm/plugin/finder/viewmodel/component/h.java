package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.feed.model.internal.m;
import com.tencent.mm.plugin.finder.feed.model.internal.m.a;
import com.tencent.mm.plugin.finder.loader.FinderAtFeedLoader;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.protocal.protobuf.bpy;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "backBtn", "Landroid/widget/LinearLayout;", "cancelText", "Landroid/widget/TextView;", "doneBtn", "Landroid/widget/Button;", "headerText", "manageText", "stateMachine", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine;", "username", "", "addMentionInfo", "", "modList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/ModMentionedInfo;", "feedIdList", "", "", "opType", "", "fitTextViewBigFont", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onLoadMore", "increment", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onPause", "onResume", "resetEnterUI", "resetExitUI", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends UIComponent
{
  private LinearLayout AtN;
  private TextView GNf;
  private TextView GNg;
  private TextView GNh;
  private Button GNi;
  b GNj;
  private String username;
  
  public h(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337805);
    String str = getIntent().getStringExtra("KEY_PARAMS_USERNAME");
    paramAppCompatActivity = str;
    if (str == null) {
      paramAppCompatActivity = "";
    }
    this.username = paramAppCompatActivity;
    AppMethodBeat.o(337805);
  }
  
  private static final void a(h paramh, View paramView)
  {
    AppMethodBeat.i(337816);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    if (!paramh.getActivity().isFinishing())
    {
      paramView = z.FrZ;
      paramView = k.aeZF;
      z.a(1, "manage_return", "", ((as)k.d(paramh.getActivity()).q(as.class)).fou());
      localObject = paramh.GNj;
      paramView = (View)localObject;
      if (localObject == null)
      {
        s.bIx("stateMachine");
        paramView = null;
      }
      paramView.fmV();
      paramh.getActivity().finish();
    }
    a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(337816);
  }
  
  private static final void b(h paramh, View paramView)
  {
    AppMethodBeat.i(337823);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramView = paramh.GNj;
    paramh = paramView;
    if (paramView == null)
    {
      s.bIx("stateMachine");
      paramh = null;
    }
    paramh.fmT();
    a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(337823);
  }
  
  private static final void c(h paramh, View paramView)
  {
    AppMethodBeat.i(337831);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramView = paramh.GNj;
    paramh = paramView;
    if (paramView == null)
    {
      s.bIx("stateMachine");
      paramh = null;
    }
    paramh.fmU();
    a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(337831);
  }
  
  private static final void d(h paramh, View paramView)
  {
    AppMethodBeat.i(337839);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "this$0");
    paramView = paramh.GNj;
    paramh = paramView;
    if (paramView == null)
    {
      s.bIx("stateMachine");
      paramh = null;
    }
    paramh.fmS();
    a.a(new Object(), "com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(337839);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(337920);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(e.e.backBtn);
    s.s(paramBundle, "activity.findViewById(R.id.backBtn)");
    this.AtN = ((LinearLayout)paramBundle);
    paramBundle = getActivity().findViewById(e.e.at_feed_header_cancel_text);
    s.s(paramBundle, "activity.findViewById(R.…_feed_header_cancel_text)");
    this.GNf = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(e.e.at_feed_header_text);
    s.s(paramBundle, "activity.findViewById(R.id.at_feed_header_text)");
    this.GNg = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(e.e.at_feed_header_manage_text);
    s.s(paramBundle, "activity.findViewById(R.…_feed_header_manage_text)");
    this.GNh = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(e.e.at_feed_header_manage_done_btn);
    s.s(paramBundle, "activity.findViewById(R.…d_header_manage_done_btn)");
    this.GNi = ((Button)paramBundle);
    Object localObject2 = this.GNg;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("headerText");
      paramBundle = null;
    }
    aw.a((Paint)paramBundle.getPaint(), 0.8F);
    localObject2 = this.AtN;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("backBtn");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new h..ExternalSyntheticLambda3(this));
    localObject2 = this.GNf;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("cancelText");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new h..ExternalSyntheticLambda0(this));
    localObject2 = this.GNi;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("doneBtn");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new h..ExternalSyntheticLambda1(this));
    localObject2 = this.GNh;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("manageText");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new h..ExternalSyntheticLambda2(this));
    localObject2 = this.GNf;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("cancelText");
      paramBundle = null;
    }
    paramBundle.setTextSize(1, 17.0F);
    localObject2 = this.GNg;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("headerText");
      paramBundle = null;
    }
    paramBundle.setTextSize(1, 17.0F);
    localObject2 = this.GNh;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      s.bIx("manageText");
      paramBundle = null;
    }
    paramBundle.setTextSize(1, 17.0F);
    paramBundle = this.GNi;
    if (paramBundle == null)
    {
      s.bIx("doneBtn");
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle.setTextSize(1, 14.0F);
      AppMethodBeat.o(337920);
      return;
    }
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    b.c localc = null;
    AppMethodBeat.i(337939);
    super.onCreateAfter(paramBundle);
    paramBundle = getActivity();
    Object localObject = k.aeZF;
    this.GNj = new b(paramBundle, (List)((g)k.d(getActivity()).q(g.class)).fnh().getDataListJustForAdapter());
    localObject = this.GNj;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("stateMachine");
      paramBundle = null;
    }
    paramBundle.GMg.alive();
    paramBundle = this.GNj;
    if (paramBundle == null)
    {
      s.bIx("stateMachine");
      paramBundle = localc;
    }
    for (;;)
    {
      localc = (b.c)new a(this);
      s.u(localc, "listener");
      if (!paramBundle.GMf.contains(localc)) {
        paramBundle.GMf.add(localc);
      }
      AppMethodBeat.o(337939);
      return;
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(337958);
    super.onDestroy();
    b localb = this.GNj;
    Object localObject1 = localb;
    if (localb == null)
    {
      s.bIx("stateMachine");
      localObject1 = null;
    }
    ((b)localObject1).GMf.clear();
    localObject1 = this.GNj;
    if (localObject1 == null)
    {
      s.bIx("stateMachine");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((b)localObject1).GMg.dead();
      AppMethodBeat.o(337958);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(337950);
    super.onPause();
    AppMethodBeat.o(337950);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337944);
    super.onResume();
    AppMethodBeat.o(337944);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderAtManagerHeaderUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateListener;", "onStateChange", "", "state", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$TransitionState;", "data", "Lcom/tencent/mm/plugin/finder/viewmodel/component/AtFeedSelectStateMachine$StateData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements b.c
  {
    a(h paramh) {}
    
    public final void a(b.d paramd, b.b paramb)
    {
      Object localObject1 = null;
      List localList = null;
      Object localObject2 = null;
      AppMethodBeat.i(338575);
      s.u(paramd, "state");
      s.u(paramb, "data");
      switch (a.$EnumSwitchMapping$0[paramd.ordinal()])
      {
      default: 
        AppMethodBeat.o(338575);
        return;
      case 1: 
        paramd = k.aeZF;
        paramb = ((g)k.d(this.GNk.getActivity()).q(g.class)).fnh();
        paramd = h.a(this.GNk);
        if (paramd == null)
        {
          s.bIx("stateMachine");
          paramd = localObject2;
        }
        for (;;)
        {
          paramd = paramd.fmW();
          paramb.J((List)paramd.bsC, 3);
          paramb.J((List)paramd.bsD, 2);
          h.b(this.GNk);
          AppMethodBeat.o(338575);
          return;
        }
      case 2: 
        h.c(this.GNk);
        AppMethodBeat.o(338575);
        return;
      case 3: 
        paramd = new LinkedList();
        localList = paramb.GMh;
        if ((localList != null) && (localList.isEmpty() == true))
        {
          i = 1;
          if (i != 0)
          {
            localList = paramb.GMi;
            if ((localList == null) || (localList.isEmpty() != true)) {
              break label353;
            }
          }
        }
        label353:
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label358;
          }
          h.a(paramd, paramb.GMh, 0);
          h.a(paramd, paramb.GMi, 1);
          paramd = new aj(0, 0L, h.d(this.GNk), paramd, null, 16).e((Context)this.GNk.getActivity(), "", 100L).bFJ().a((com.tencent.mm.vending.e.b)this.GNk.getActivity());
          s.s(paramd, "CgiFinderModMentioned(Cg…e(activity as MMActivity)");
          d.b((com.tencent.mm.vending.g.c)paramd, (kotlin.g.a.b)new b(this.GNk));
          AppMethodBeat.o(338575);
          return;
          i = 0;
          break;
        }
        label358:
        paramd = h.a(this.GNk);
        if (paramd == null)
        {
          s.bIx("stateMachine");
          paramd = localObject1;
        }
        for (;;)
        {
          paramd.vj(false);
          AppMethodBeat.o(338575);
          return;
        }
      }
      paramb = h.a(this.GNk);
      paramd = paramb;
      if (paramb == null)
      {
        s.bIx("stateMachine");
        paramd = null;
      }
      paramd.fmT();
      paramd = m.Bkx;
      paramd = h.a(this.GNk);
      if (paramd == null)
      {
        s.bIx("stateMachine");
        paramd = localList;
      }
      for (;;)
      {
        m.a.c("atFeedManage", paramd.GMd);
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderModMentionedResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<b.a<bpy>, ah>
    {
      b(h paramh)
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