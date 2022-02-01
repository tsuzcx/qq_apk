package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.ct;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.m;
import com.tencent.mm.plugin.finder.profile.FlowLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSurveyView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSurveyItem;", "Lkotlin/collections/ArrayList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "disableClick", "", "setItemClickListener", "listener", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "setSurveyList", "list", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSurveyView
  extends FrameLayout
{
  public static final a AZc;
  public WxRecyclerView AZd;
  private ArrayList<m> pUj;
  
  static
  {
    AppMethodBeat.i(362672);
    AZc = new a((byte)0);
    AppMethodBeat.o(362672);
  }
  
  public FinderSurveyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(362656);
    this.pUj = new ArrayList();
    LayoutInflater.from(getContext()).inflate(e.f.finder_survey_view, (ViewGroup)this, true);
    this.AZd = ((WxRecyclerView)findViewById(e.e.survey_list));
    paramContext = this.AZd;
    if (paramContext != null) {
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new FlowLayoutManager());
    }
    paramContext = new WxRecyclerAdapter(dUK(), this.pUj, false);
    paramAttributeSet = this.AZd;
    if (paramAttributeSet != null) {
      paramAttributeSet.setAdapter((RecyclerView.a)paramContext);
    }
    AppMethodBeat.o(362656);
  }
  
  public FinderSurveyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(362664);
    this.pUj = new ArrayList();
    LayoutInflater.from(getContext()).inflate(e.f.finder_survey_view, (ViewGroup)this, true);
    this.AZd = ((WxRecyclerView)findViewById(e.e.survey_list));
    paramContext = this.AZd;
    if (paramContext != null) {
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new FlowLayoutManager());
    }
    paramContext = new WxRecyclerAdapter(dUK(), this.pUj, false);
    paramAttributeSet = this.AZd;
    if (paramAttributeSet != null) {
      paramAttributeSet.setAdapter((RecyclerView.a)paramContext);
    }
    AppMethodBeat.o(362664);
  }
  
  private static g dUK()
  {
    AppMethodBeat.i(362668);
    g localg = (g)new b();
    AppMethodBeat.o(362668);
    return localg;
  }
  
  public final void setItemClickListener(i.c<j> paramc)
  {
    AppMethodBeat.i(362690);
    s.u(paramc, "listener");
    Object localObject = this.AZd;
    if (localObject != null)
    {
      localObject = ((WxRecyclerView)localObject).getAdapter();
      if ((localObject != null) && ((localObject instanceof WxRecyclerAdapter))) {
        ((WxRecyclerAdapter)localObject).agOe = paramc;
      }
    }
    AppMethodBeat.o(362690);
  }
  
  public final void setSurveyList(Collection<m> paramCollection)
  {
    AppMethodBeat.i(362680);
    s.u(paramCollection, "list");
    this.pUj.clear();
    this.pUj.addAll(paramCollection);
    paramCollection = this.AZd;
    if (paramCollection != null)
    {
      paramCollection = paramCollection.getAdapter();
      if (paramCollection != null) {
        paramCollection.bZE.notifyChanged();
      }
    }
    AppMethodBeat.o(362680);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderSurveyView$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderSurveyView$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(362481);
      f localf = (f)new ct();
      AppMethodBeat.o(362481);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderSurveyView
 * JD-Core Version:    0.7.0.1
 */