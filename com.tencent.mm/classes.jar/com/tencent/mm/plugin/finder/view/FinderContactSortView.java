package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.f;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import d.l;
import d.n.n;
import d.v;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView;", "Lcom/tencent/mm/ui/base/sortview/BaseSortView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getItemViewCreator", "Lcom/tencent/mm/ui/base/sortview/SortAdapter$IViewCreator;", "getListView", "Landroid/widget/ListView;", "getNoResultView", "Landroid/view/View;", "getScrollBar", "Lcom/tencent/mm/ui/base/VerticalScrollBar;", "inflate", "init", "", "isMatch", "", "word", "entity", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "ViewHolder", "plugin-finder_release"})
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
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(168303);
    if (paramString != null)
    {
      if (paramd != null) {}
      for (paramd = paramd.fjz();; paramd = null)
      {
        paramd = bs.nullAsNil(paramd);
        d.g.b.k.g(paramd, "Util.nullAsNil(entity?.alpha)");
        boolean bool = n.nb(paramString, paramd);
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
    c.a locala = (c.a)new b(this);
    AppMethodBeat.o(168304);
    return locala;
  }
  
  public final ListView getListView()
  {
    AppMethodBeat.i(168301);
    Object localObject = findViewById(2131301452);
    d.g.b.k.g(localObject, "this.findViewById(R.id.list_view)");
    localObject = (ListView)localObject;
    AppMethodBeat.o(168301);
    return localObject;
  }
  
  public final View getNoResultView()
  {
    AppMethodBeat.i(168302);
    View localView = findViewById(2131302883);
    d.g.b.k.g(localView, "this.findViewById(R.id.no_result)");
    AppMethodBeat.o(168302);
    return localView;
  }
  
  public final VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(168300);
    Object localObject = findViewById(2131305114);
    d.g.b.k.g(localObject, "this.findViewById(R.id.sort_bar)");
    localObject = (VerticalScrollBar)localObject;
    AppMethodBeat.o(168300);
    return localObject;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(168299);
    View localView = View.inflate(getContext(), 2131494023, (ViewGroup)this);
    d.g.b.k.g(localView, "View.inflate(context, R.…_contact_sort_view, this)");
    AppMethodBeat.o(168299);
    return localView;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView$ViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "catalogTv", "Landroid/widget/TextView;", "getCatalogTv", "()Landroid/widget/TextView;", "setCatalogTv", "(Landroid/widget/TextView;)V", "content", "Landroid/view/View;", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "nickTv", "getNickTv", "setNickTv", "plugin-finder_release"})
  public static final class a
  {
    ImageView fxQ;
    TextView iIT;
    TextView iNX;
    View nCh;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "item", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "convertView", "parent", "Landroid/view/ViewGroup;", "position", "", "count", "isFirstOfPage", "", "isLastOfPage", "createView"})
  static final class b
    implements c.a
  {
    b(FinderContactSortView paramFinderContactSortView) {}
    
    public final View a(com.tencent.mm.ui.base.sortview.d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(168297);
      Object localObject1;
      if (paramView == null)
      {
        paramView = View.inflate(this.rWG.getContext(), 2131494021, null);
        localObject1 = new FinderContactSortView.a();
        ((FinderContactSortView.a)localObject1).fxQ = ((ImageView)paramView.findViewById(2131297008));
        ((FinderContactSortView.a)localObject1).iNX = ((TextView)paramView.findViewById(2131302867));
        ((FinderContactSortView.a)localObject1).iIT = ((TextView)paramView.findViewById(2131297925));
        ((FinderContactSortView.a)localObject1).nCh = paramView.findViewById(2131301145);
        d.g.b.k.g(paramView, "itemView");
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        d.g.b.k.g(paramd, "item");
        localObject2 = paramd.getData();
        if (localObject2 != null) {
          break;
        }
        paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
        AppMethodBeat.o(168297);
        throw paramd;
        d.g.b.k.g(paramView, "convertView");
        localObject1 = paramView.getTag();
        if (localObject1 == null)
        {
          paramd = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.FinderContactSortView.ViewHolder");
          AppMethodBeat.o(168297);
          throw paramd;
        }
        localObject1 = (FinderContactSortView.a)localObject1;
      }
      Object localObject2 = (f)localObject2;
      Object localObject3 = h.rtK;
      localObject3 = h.cwo();
      com.tencent.mm.plugin.finder.loader.a locala = new com.tencent.mm.plugin.finder.loader.a(((f)localObject2).crZ());
      ImageView localImageView = ((FinderContactSortView.a)localObject1).fxQ;
      if (localImageView == null) {
        d.g.b.k.fOy();
      }
      h localh = h.rtK;
      ((com.tencent.mm.loader.d)localObject3).a(locala, localImageView, h.a(h.a.rtN));
      localObject3 = ((FinderContactSortView.a)localObject1).iNX;
      if (localObject3 != null) {
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c(this.rWG.getContext(), (CharSequence)((f)localObject2).Tn()));
      }
      if ((this.rWG.fjw()) && (paramBoolean1))
      {
        localObject2 = ((FinderContactSortView.a)localObject1).iIT;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)paramd.fjz());
        }
        paramd = ((FinderContactSortView.a)localObject1).iIT;
        if (paramd != null) {
          paramd.setVisibility(0);
        }
        if ((this.rWG.getMode() != 0) || (!paramBoolean2)) {
          break label390;
        }
        paramd = ((FinderContactSortView.a)localObject1).nCh;
        if (paramd != null) {
          paramd.setBackgroundResource(2131231820);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(168297);
        return paramView;
        paramd = ((FinderContactSortView.a)localObject1).iIT;
        if (paramd == null) {
          break;
        }
        paramd.setVisibility(8);
        break;
        label390:
        paramd = ((FinderContactSortView.a)localObject1).nCh;
        if (paramd != null) {
          paramd.setBackgroundResource(2131232867);
        }
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "adapterView", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class c
    implements AdapterView.OnItemClickListener
  {
    c(FinderContactSortView paramFinderContactSortView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168298);
      if ((paramLong >= 0L) && (paramLong < this.rWG.getDatas().size()))
      {
        paramAdapterView = new Intent();
        paramView = this.rWG.getDatas().get((int)paramLong);
        d.g.b.k.g(paramView, "datas[id.toInt()]");
        paramView = ((com.tencent.mm.ui.base.sortview.d)paramView).getData();
        if (paramView == null)
        {
          paramAdapterView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(168298);
          throw paramAdapterView;
        }
        paramAdapterView.putExtra("finder_username", ((f)paramView).getUsername());
        paramView = FinderReporterUIC.seQ;
        paramView = this.rWG.getContext();
        d.g.b.k.g(paramView, "context");
        FinderReporterUIC.a.a(paramView, paramAdapterView, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
        paramView = this.rWG.getContext();
        d.g.b.k.g(paramView, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, paramAdapterView);
      }
      AppMethodBeat.o(168298);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderContactSortView
 * JD-Core Version:    0.7.0.1
 */