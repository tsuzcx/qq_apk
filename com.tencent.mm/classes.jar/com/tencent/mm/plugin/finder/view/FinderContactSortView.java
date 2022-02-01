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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView;", "Lcom/tencent/mm/ui/base/sortview/BaseSortView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getItemViewCreator", "Lcom/tencent/mm/ui/base/sortview/SortAdapter$IViewCreator;", "getListView", "Landroid/widget/ListView;", "getNoResultView", "Landroid/view/View;", "getScrollBar", "Lcom/tencent/mm/ui/base/VerticalScrollBar;", "inflate", "init", "", "isMatch", "", "word", "entity", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "ViewHolder", "plugin-finder_release"})
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
      for (paramd = paramd.hLf();; paramd = null)
      {
        paramd = Util.nullAsNil(paramd);
        p.j(paramd, "Util.nullAsNil(entity?.alpha)");
        boolean bool = n.M(paramString, paramd, false);
        AppMethodBeat.o(168303);
        return bool;
      }
    }
    AppMethodBeat.o(168303);
    return false;
  }
  
  public final View eI()
  {
    AppMethodBeat.i(168299);
    View localView = View.inflate(getContext(), b.g.finder_contact_sort_view, (ViewGroup)this);
    p.j(localView, "View.inflate(context, R.…_contact_sort_view, this)");
    AppMethodBeat.o(168299);
    return localView;
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
    Object localObject = findViewById(b.f.list_view);
    p.j(localObject, "this.findViewById(R.id.list_view)");
    localObject = (ListView)localObject;
    AppMethodBeat.o(168301);
    return localObject;
  }
  
  public final View getNoResultView()
  {
    AppMethodBeat.i(168302);
    View localView = findViewById(b.f.no_result);
    p.j(localView, "this.findViewById(R.id.no_result)");
    AppMethodBeat.o(168302);
    return localView;
  }
  
  public final VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(168300);
    Object localObject = findViewById(b.f.sort_bar);
    p.j(localObject, "this.findViewById(R.id.sort_bar)");
    localObject = (VerticalScrollBar)localObject;
    AppMethodBeat.o(168300);
    return localObject;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView$ViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "catalogTv", "Landroid/widget/TextView;", "getCatalogTv", "()Landroid/widget/TextView;", "setCatalogTv", "(Landroid/widget/TextView;)V", "content", "Landroid/view/View;", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "nickTv", "getNickTv", "setNickTv", "plugin-finder_release"})
  public static final class a
  {
    ImageView jiu;
    TextView mUx;
    TextView mZA;
    View vpA;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "item", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "convertView", "parent", "Landroid/view/ViewGroup;", "position", "", "count", "isFirstOfPage", "", "isLastOfPage", "createView"})
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
        paramView = View.inflate(this.AWl.getContext(), b.g.finder_contact_sort_list_item, null);
        localObject1 = new FinderContactSortView.a();
        ((FinderContactSortView.a)localObject1).jiu = ((ImageView)paramView.findViewById(b.f.avatar_iv));
        ((FinderContactSortView.a)localObject1).mZA = ((TextView)paramView.findViewById(b.f.nickname_tv));
        ((FinderContactSortView.a)localObject1).mUx = ((TextView)paramView.findViewById(b.f.catalogTV));
        ((FinderContactSortView.a)localObject1).vpA = paramView.findViewById(b.f.item_content);
        p.j(paramView, "itemView");
        paramView.setTag(localObject1);
      }
      for (;;)
      {
        p.j(paramd, "item");
        localObject2 = paramd.getData();
        if (localObject2 != null) {
          break;
        }
        paramd = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
        AppMethodBeat.o(168297);
        throw paramd;
        p.j(paramView, "convertView");
        localObject1 = paramView.getTag();
        if (localObject1 == null)
        {
          paramd = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.FinderContactSortView.ViewHolder");
          AppMethodBeat.o(168297);
          throw paramd;
        }
        localObject1 = (FinderContactSortView.a)localObject1;
      }
      Object localObject2 = (i)localObject2;
      Object localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      localObject3 = com.tencent.mm.plugin.finder.loader.t.dJh();
      e locale = new e(((i)localObject2).Mm());
      ImageView localImageView = ((FinderContactSortView.a)localObject1).jiu;
      if (localImageView == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
      ((com.tencent.mm.loader.d)localObject3).a(locale, localImageView, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
      localObject3 = ((FinderContactSortView.a)localObject1).mZA;
      if (localObject3 != null) {
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.AWl.getContext(), (CharSequence)((i)localObject2).getNickname()));
      }
      if ((this.AWl.hLc()) && (paramBoolean1))
      {
        localObject2 = ((FinderContactSortView.a)localObject1).mUx;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)paramd.hLf());
        }
        paramd = ((FinderContactSortView.a)localObject1).mUx;
        if (paramd != null) {
          paramd.setVisibility(0);
        }
        if ((this.AWl.getMode() != 0) || (!paramBoolean2)) {
          break label396;
        }
        paramd = ((FinderContactSortView.a)localObject1).vpA;
        if (paramd != null) {
          paramd.setBackgroundResource(b.e.comm_list_item_selector_no_divider);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(168297);
        return paramView;
        paramd = ((FinderContactSortView.a)localObject1).mUx;
        if (paramd == null) {
          break;
        }
        paramd.setVisibility(8);
        break;
        label396:
        paramd = ((FinderContactSortView.a)localObject1).vpA;
        if (paramd != null) {
          paramd.setBackgroundResource(b.e.list_item_normal);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "adapterView", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class c
    implements AdapterView.OnItemClickListener
  {
    c(FinderContactSortView paramFinderContactSortView) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(168298);
      b localb = new b();
      localb.bn(paramAdapterView);
      localb.bn(paramView);
      localb.sg(paramInt);
      localb.Fs(paramLong);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderContactSortView$init$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
      if ((paramLong >= 0L) && (paramLong < this.AWl.getDatas().size()))
      {
        paramAdapterView = new Intent();
        paramView = this.AWl.getDatas().get((int)paramLong);
        p.j(paramView, "datas[id.toInt()]");
        paramView = ((com.tencent.mm.ui.base.sortview.d)paramView).getData();
        if (paramView == null)
        {
          paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
          AppMethodBeat.o(168298);
          throw paramAdapterView;
        }
        paramAdapterView.putExtra("finder_username", ((i)paramView).getUsername());
        paramView = aj.Bnu;
        paramView = this.AWl.getContext();
        p.j(paramView, "context");
        aj.a.a(paramView, paramAdapterView, 0L, 0, false, 124);
        paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
        paramView = this.AWl.getContext();
        p.j(paramView, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, paramAdapterView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderContactSortView$init$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(168298);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderContactSortView
 * JD-Core Version:    0.7.0.1
 */