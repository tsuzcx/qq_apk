package com.tencent.mm.plugin.fts.ui.hotsearch.uic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adw;
import com.tencent.mm.plugin.fts.ui.hotsearch.a.c;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSMainUIEducationLayout;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainEducationSearchUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "educationTabTitleTV2", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getEducationTabTitleTV2", "()Landroid/widget/TextView;", "educationTabTitleTV2$delegate", "Lkotlin/Lazy;", "hasExpose", "", "searchEducationLayout", "Lcom/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout;", "getSearchEducationLayout", "()Lcom/tencent/mm/plugin/fts/ui/widget/FTSMainUIEducationLayout;", "searchEducationLayout$delegate", "searchEducationLayout2", "Landroid/widget/LinearLayout;", "getSearchEducationLayout2", "()Landroid/widget/LinearLayout;", "searchEducationLayout2$delegate", "searchEducationTabLayout2", "getSearchEducationTabLayout2", "searchEducationTabLayout2$delegate", "webSearchConfigEventIListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/WebSearchConfigEvent;", "initEducationTabLayout", "educationItemList", "", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/SearchEducationItem;", "isFirstLine", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "reportCellExpose", "updateCell", "item", "cellView", "Landroid/view/View;", "titleTV", "redDotView", "updateEducationLayout2", "CellClickListener", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.mvvmbase.a
{
  private final j HzE;
  private final j HzI;
  private final j HzJ;
  private final j HzK;
  private final IListener<adw> HzL;
  private boolean HzM;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(265792);
    this.HzI = kotlin.k.cm((kotlin.g.a.a)new d.e(paramAppCompatActivity));
    this.HzE = kotlin.k.cm((kotlin.g.a.a)new d.f(paramAppCompatActivity));
    this.HzJ = kotlin.k.cm((kotlin.g.a.a)new d.g(paramAppCompatActivity));
    this.HzK = kotlin.k.cm((kotlin.g.a.a)new d.b(paramAppCompatActivity));
    this.HzL = ((IListener)new FTSMainEducationSearchUIC.webSearchConfigEventIListener.1(this, com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(265792);
  }
  
  private final void a(c paramc, View paramView1, TextView paramTextView, View paramView2, boolean paramBoolean)
  {
    AppMethodBeat.i(265848);
    if (paramc == null)
    {
      paramc = null;
      if (paramc != null) {
        break label116;
      }
      if (paramBoolean)
      {
        paramView1.setVisibility(8);
        AppMethodBeat.o(265848);
      }
    }
    else
    {
      paramTextView.setText((CharSequence)paramc.Hzu);
      paramTextView.setTextSize(1, 15.0F * com.tencent.mm.cd.a.jO(paramTextView.getContext()));
      paramView1.setOnClickListener((View.OnClickListener)new a(paramc, paramView2));
      paramView1.setVisibility(0);
      if (paramc.iaS) {
        paramView2.setVisibility(0);
      }
      for (;;)
      {
        paramc = ah.aiuX;
        break;
        paramView2.setVisibility(8);
      }
    }
    paramView1.setVisibility(4);
    label116:
    AppMethodBeat.o(265848);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(265861);
    s.u(paramd, "this$0");
    if (paramd.fyI().getHeight() != 0)
    {
      UIStateCenter localUIStateCenter = paramd.getStateCenter();
      if (localUIStateCenter != null) {
        localUIStateCenter.dispatch((IStateAction)new com.tencent.mm.plugin.fts.ui.hotsearch.a.e(paramd.fyI().getHeight()));
      }
    }
    AppMethodBeat.o(265861);
  }
  
  private static final void a(d paramd, View paramView)
  {
    boolean bool = false;
    AppMethodBeat.i(265859);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramd);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainEducationSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramd, "this$0");
    localObject2 = new com.tencent.mm.plugin.fts.ui.hotsearch.a.d();
    localObject1 = paramView.getTag();
    int i;
    if ((localObject1 instanceof JSONObject))
    {
      localObject1 = (JSONObject)localObject1;
      if (localObject1 != null) {
        break label224;
      }
      i = 0;
      label101:
      ((com.tencent.mm.plugin.fts.ui.hotsearch.a.d)localObject2).type = i;
      localObject1 = paramView.getTag();
      if (!(localObject1 instanceof JSONObject)) {
        break label237;
      }
      localObject1 = (JSONObject)localObject1;
      label128:
      if (localObject1 != null) {
        break label243;
      }
      label133:
      ((com.tencent.mm.plugin.fts.ui.hotsearch.a.d)localObject2).Hzv = bool;
      paramView = paramView.getTag(p.d.tv_content);
      if (!(paramView instanceof TextView)) {
        break label256;
      }
      paramView = (TextView)paramView;
      label159:
      if (paramView != null) {
        break label261;
      }
      paramView = "";
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.fts.ui.hotsearch.a.d)localObject2).setTitle(paramView);
      paramd = paramd.getStateCenter();
      if (paramd != null) {
        paramd.dispatch((IStateAction)localObject2);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainEducationSearchUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265859);
      return;
      localObject1 = null;
      break;
      label224:
      i = ((JSONObject)localObject1).optInt("businessType", 0);
      break label101;
      label237:
      localObject1 = null;
      break label128;
      label243:
      bool = ((JSONObject)localObject1).optBoolean("needHideKeyBoard", false);
      break label133;
      label256:
      paramView = null;
      break label159;
      label261:
      paramView = paramView.getText();
      if (paramView == null)
      {
        paramView = "";
      }
      else
      {
        localObject1 = paramView.toString();
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = "";
        }
      }
    }
  }
  
  private static final void a(d paramd, com.tencent.mm.plugin.fts.ui.hotsearch.a.a parama)
  {
    AppMethodBeat.i(265854);
    s.u(paramd, "this$0");
    s.u(parama, "state");
    parama = (com.tencent.mm.plugin.fts.ui.hotsearch.a.f)parama.checkAction(com.tencent.mm.plugin.fts.ui.hotsearch.a.f.class);
    if (parama != null)
    {
      if (parama.visible)
      {
        if (o.fyA())
        {
          paramd.fyI().setVisibility(0);
          AppMethodBeat.o(265854);
          return;
        }
        paramd.fyL().setVisibility(0);
        paramd.fyL().updateView();
        AppMethodBeat.o(265854);
        return;
      }
      if (o.fyA())
      {
        paramd.fyI().setVisibility(8);
        AppMethodBeat.o(265854);
        return;
      }
      paramd.fyL().setVisibility(8);
    }
    AppMethodBeat.o(265854);
  }
  
  private LinearLayout fyI()
  {
    AppMethodBeat.i(265798);
    LinearLayout localLinearLayout = (LinearLayout)this.HzE.getValue();
    AppMethodBeat.o(265798);
    return localLinearLayout;
  }
  
  private LinearLayout fyM()
  {
    AppMethodBeat.i(265802);
    LinearLayout localLinearLayout = (LinearLayout)this.HzJ.getValue();
    AppMethodBeat.o(265802);
    return localLinearLayout;
  }
  
  private TextView fyN()
  {
    AppMethodBeat.i(265809);
    TextView localTextView = (TextView)this.HzK.getValue();
    AppMethodBeat.o(265809);
    return localTextView;
  }
  
  private final void fyO()
  {
    AppMethodBeat.i(265828);
    fyN().setTextSize(1, com.tencent.mm.cd.a.getScaleSize((Context)getContext()) * 14.0F);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = al.bix("educationTab").optJSONArray("items");
    Object localObject2;
    int j;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) && (!aj.aBu()))
      {
        localObject1 = MMApplicationContext.getContext();
        localObject2 = ((Context)localObject1).getString(p.g.search_education_timeline);
        s.s(localObject2, "context.getString(R.stri…earch_education_timeline)");
        localArrayList.add(new c(8, (String)localObject2, 5));
        localObject2 = ((Context)localObject1).getString(p.g.search_education_article);
        s.s(localObject2, "context.getString(R.stri…search_education_article)");
        localArrayList.add(new c(2, (String)localObject2, 5));
        localObject1 = ((Context)localObject1).getString(p.g.search_education_biz_contact);
        s.s(localObject1, "context.getString(R.stri…ch_education_biz_contact)");
        localArrayList.add(new c(1, (String)localObject1, 5));
      }
      fyM().removeAllViews();
      localObject2 = (Iterable)localArrayList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      j = 0;
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label462;
        }
        localObject3 = ((Iterator)localObject2).next();
        if (j < 0) {
          p.kkW();
        }
        if (j < 0) {
          break label457;
        }
        if (j > 3) {
          break;
        }
        i = 1;
        label255:
        if (i != 0) {
          ((Collection)localObject1).add(localObject3);
        }
        j += 1;
      }
    }
    if (((JSONArray)localObject1).length() > 0)
    {
      i = 1;
      label286:
      if (i == 0) {
        break label306;
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label312;
      }
      localObject1 = null;
      break;
      i = 0;
      break label286;
      label306:
      localObject1 = null;
    }
    label312:
    int k = ((JSONArray)localObject1).length();
    if (k > 0) {}
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localObject3 = ((JSONArray)localObject1).optJSONObject(i);
      if (localObject3 != null)
      {
        i = ((JSONObject)localObject3).optInt("businessType", 0);
        localObject2 = ((JSONObject)localObject3).optString("hotword", "");
        s.s(localObject2, "tabObj.optString(\"hotword\", \"\")");
        localObject2 = new c(i, (String)localObject2, ((JSONObject)localObject3).optInt("optype", 0));
        ((c)localObject2).Hzv = ((JSONObject)localObject3).optBoolean("needHideKeyBoard", false);
        localObject3 = com.tencent.mm.plugin.fts.ui.c.k.HBV;
        ((c)localObject2).iaS = com.tencent.mm.plugin.fts.ui.c.k.ru(((c)localObject2).businessType);
        localObject3 = ah.aiuX;
        localArrayList.add(localObject2);
      }
      if (j >= k)
      {
        localObject1 = ah.aiuX;
        break;
        i = 0;
        break label255;
        label457:
        i = 0;
        break label255;
        label462:
        localObject1 = r((List)localObject1, true);
        fyM().addView((View)localObject1);
        localObject2 = (Iterable)localArrayList;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        j = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          if (j < 0) {
            p.kkW();
          }
          if (4 <= j) {
            if (j <= 7) {
              i = 1;
            }
          }
          for (;;)
          {
            if (i != 0) {
              ((Collection)localObject1).add(localObject3);
            }
            j += 1;
            break;
            i = 0;
            continue;
            i = 0;
          }
        }
        localObject1 = (List)localObject1;
        if (!((Collection)localObject1).isEmpty()) {}
        for (i = 1;; i = 0)
        {
          if (i != 0)
          {
            localObject1 = r((List)localObject1, false);
            fyM().addView((View)localObject1);
          }
          hV((List)localArrayList);
          fyI().post(new d..ExternalSyntheticLambda2(this));
          AppMethodBeat.o(265828);
          return;
        }
      }
    }
  }
  
  private final void hV(List<c> paramList)
  {
    AppMethodBeat.i(265835);
    if (!this.HzM)
    {
      this.HzM = true;
      paramList = p.a((Iterable)paramList, (CharSequence)";", null, null, 0, null, (kotlin.g.a.b)d.HzR, 30);
      as.nV(com.tencent.mm.plugin.fts.a.e.fxw(), paramList);
      AppMethodBeat.o(265835);
      return;
    }
    AppMethodBeat.o(265835);
  }
  
  private final LinearLayout r(List<c> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(265840);
    View localView1 = LayoutInflater.from((Context)getActivity()).inflate(p.e.fts_main_ui_education_cell_layout_2, (ViewGroup)fyM(), false);
    Object localObject1 = (c)p.ae(paramList, 0);
    Object localObject2 = localView1.findViewById(p.d.cell_1);
    s.s(localObject2, "layout.findViewById(R.id.cell_1)");
    Object localObject3 = localView1.findViewById(p.d.textview_1);
    s.s(localObject3, "layout.findViewById(R.id.textview_1)");
    localObject3 = (TextView)localObject3;
    View localView2 = localView1.findViewById(p.d.red_dot_1);
    s.s(localView2, "layout.findViewById(R.id.red_dot_1)");
    a((c)localObject1, (View)localObject2, (TextView)localObject3, localView2, paramBoolean);
    localObject1 = (c)p.ae(paramList, 1);
    localObject2 = localView1.findViewById(p.d.cell_2);
    s.s(localObject2, "layout.findViewById(R.id.cell_2)");
    localObject3 = localView1.findViewById(p.d.textview_2);
    s.s(localObject3, "layout.findViewById(R.id.textview_2)");
    localObject3 = (TextView)localObject3;
    localView2 = localView1.findViewById(p.d.red_dot_2);
    s.s(localView2, "layout.findViewById(R.id.red_dot_2)");
    a((c)localObject1, (View)localObject2, (TextView)localObject3, localView2, paramBoolean);
    localObject1 = (c)p.ae(paramList, 2);
    localObject2 = localView1.findViewById(p.d.cell_3);
    s.s(localObject2, "layout.findViewById(R.id.cell_3)");
    localObject3 = localView1.findViewById(p.d.textview_3);
    s.s(localObject3, "layout.findViewById(R.id.textview_3)");
    localObject3 = (TextView)localObject3;
    localView2 = localView1.findViewById(p.d.red_dot_3);
    s.s(localView2, "layout.findViewById(R.id.red_dot_3)");
    a((c)localObject1, (View)localObject2, (TextView)localObject3, localView2, paramBoolean);
    paramList = (c)p.ae(paramList, 3);
    localObject1 = localView1.findViewById(p.d.cell_4);
    s.s(localObject1, "layout.findViewById(R.id.cell_4)");
    localObject2 = localView1.findViewById(p.d.textview_4);
    s.s(localObject2, "layout.findViewById(R.id.textview_4)");
    localObject2 = (TextView)localObject2;
    localObject3 = localView1.findViewById(p.d.red_dot_4);
    s.s(localObject3, "layout.findViewById(R.id.red_dot_4)");
    a(paramList, (View)localObject1, (TextView)localObject2, (View)localObject3, paramBoolean);
    if (localView1 == null)
    {
      paramList = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(265840);
      throw paramList;
    }
    paramList = (LinearLayout)localView1;
    AppMethodBeat.o(265840);
    return paramList;
  }
  
  public final FTSMainUIEducationLayout fyL()
  {
    AppMethodBeat.i(265886);
    FTSMainUIEducationLayout localFTSMainUIEducationLayout = (FTSMainUIEducationLayout)this.HzI.getValue();
    AppMethodBeat.o(265886);
    return localFTSMainUIEducationLayout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265891);
    super.onCreate(paramBundle);
    this.HzL.alive();
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.process((q)getActivity(), (kotlin.g.a.b)c.HzQ);
    }
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)getActivity(), new d..ExternalSyntheticLambda1(this));
    }
    if (o.fyA())
    {
      fyL().setVisibility(8);
      fyI().setVisibility(0);
      fyO();
      AppMethodBeat.o(265891);
      return;
    }
    fyL().setVisibility(0);
    fyI().setVisibility(8);
    fyL().setOnCellClickListener(new d..ExternalSyntheticLambda0(this));
    fyL().setNeedHotWord(false);
    AppMethodBeat.o(265891);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(265899);
    this.HzL.dead();
    AppMethodBeat.o(265899);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(265896);
    if (!o.fyA())
    {
      fyL().updateView();
      AppMethodBeat.o(265896);
      return;
    }
    fyO();
    AppMethodBeat.o(265896);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainEducationSearchUIC$CellClickListener;", "Landroid/view/View$OnClickListener;", "item", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/SearchEducationItem;", "retDotView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainEducationSearchUIC;Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/SearchEducationItem;Landroid/view/View;)V", "getItem", "()Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/SearchEducationItem;", "getRetDotView", "()Landroid/view/View;", "onClick", "", "v", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements View.OnClickListener
  {
    private final c HzN;
    private final View HzO;
    
    public a(View paramView)
    {
      AppMethodBeat.i(265763);
      this.HzN = paramView;
      this.HzO = localObject;
      AppMethodBeat.o(265763);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265771);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainEducationSearchUIC$CellClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      paramView = new com.tencent.mm.plugin.fts.ui.hotsearch.a.d();
      paramView.type = this.HzN.businessType;
      paramView.Hzv = this.HzN.Hzv;
      paramView.setTitle(this.HzN.Hzu);
      localObject = d.this.getStateCenter();
      if (localObject != null) {
        ((UIStateCenter)localObject).dispatch((IStateAction)paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/hotsearch/uic/FTSMainEducationSearchUIC$CellClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265771);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/FTSMainState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.fts.ui.hotsearch.a.a, ah>
  {
    public static final c HzQ;
    
    static
    {
      AppMethodBeat.i(265762);
      HzQ = new c();
      AppMethodBeat.o(265762);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/fts/ui/hotsearch/model/SearchEducationItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<c, CharSequence>
  {
    public static final d HzR;
    
    static
    {
      AppMethodBeat.i(265766);
      HzR = new d();
      AppMethodBeat.o(265766);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.hotsearch.uic.d
 * JD-Core Version:    0.7.0.1
 */