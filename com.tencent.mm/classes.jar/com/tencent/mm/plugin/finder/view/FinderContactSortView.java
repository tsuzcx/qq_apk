package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import com.tencent.mm.ui.base.sortview.d;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView;", "Lcom/tencent/mm/ui/base/sortview/BaseSortView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getItemViewCreator", "Lcom/tencent/mm/ui/base/sortview/SortAdapter$IViewCreator;", "getListView", "Landroid/widget/ListView;", "getNoResultView", "Landroid/view/View;", "getScrollBar", "Lcom/tencent/mm/ui/base/VerticalScrollBar;", "inflate", "init", "", "isMatch", "", "word", "entity", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "ViewHolder", "plugin-finder_release"})
public final class FinderContactSortView
  extends BaseSortView
{
  private final String TAG;
  
  public FinderContactSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168305);
    this.TAG = "Finder.FinderContactSortView";
    setOnItemClickListener((AdapterView.OnItemClickListener)new c(this));
    AppMethodBeat.o(168305);
  }
  
  public final boolean a(String paramString, d paramd)
  {
    AppMethodBeat.i(168303);
    if (paramString != null)
    {
      if (paramd != null) {}
      for (paramd = paramd.eTM();; paramd = null)
      {
        paramd = bt.nullAsNil(paramd);
        k.g(paramd, "Util.nullAsNil(entity?.alpha)");
        boolean bool = n.mA(paramString, paramd);
        AppMethodBeat.o(168303);
        return bool;
      }
    }
    AppMethodBeat.o(168303);
    return false;
  }
  
  public final c.a getItemViewCreator()
  {
    AppMethodBeat.i(168304);
    c.a locala = (c.a)new FinderContactSortView.b(this);
    AppMethodBeat.o(168304);
    return locala;
  }
  
  public final ListView getListView()
  {
    AppMethodBeat.i(168301);
    Object localObject = findViewById(2131301452);
    k.g(localObject, "this.findViewById(R.id.list_view)");
    localObject = (ListView)localObject;
    AppMethodBeat.o(168301);
    return localObject;
  }
  
  public final View getNoResultView()
  {
    AppMethodBeat.i(168302);
    View localView = findViewById(2131302883);
    k.g(localView, "this.findViewById(R.id.no_result)");
    AppMethodBeat.o(168302);
    return localView;
  }
  
  public final VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(168300);
    Object localObject = findViewById(2131305114);
    k.g(localObject, "this.findViewById(R.id.sort_bar)");
    localObject = (VerticalScrollBar)localObject;
    AppMethodBeat.o(168300);
    return localObject;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(168299);
    View localView = View.inflate(getContext(), 2131494023, (ViewGroup)this);
    k.g(localView, "View.inflate(context, R.…_contact_sort_view, this)");
    AppMethodBeat.o(168299);
    return localView;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "adapterView", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class c
    implements AdapterView.OnItemClickListener
  {
    c(FinderContactSortView paramFinderContactSortView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168298);
      if ((paramLong >= 0L) && (paramLong < this.qWr.getDatas().size()))
      {
        paramAdapterView = new Intent();
        paramView = this.qWr.getDatas().get((int)paramLong);
        k.g(paramView, "datas[id.toInt()]");
        paramView = ((d)paramView).getData();
        if (paramView == null)
        {
          paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(168298);
          throw paramAdapterView;
        }
        paramAdapterView.putExtra("finder_username", ((f)paramView).getUsername());
        paramView = FinderReporterUIC.Ljl;
        paramView = this.qWr.getContext();
        k.g(paramView, "context");
        FinderReporterUIC.a.a(paramView, paramAdapterView, 0L, 0, false, 124);
        paramView = a.qSb;
        paramView = this.qWr.getContext();
        k.g(paramView, "context");
        a.enterFinderProfileUI(paramView, paramAdapterView);
      }
      AppMethodBeat.o(168298);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderContactSortView
 * JD-Core Version:    0.7.0.1
 */