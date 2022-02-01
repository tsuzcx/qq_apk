package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView;", "Lcom/tencent/mm/ui/base/sortview/BaseSortView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "getItemViewCreator", "Lcom/tencent/mm/ui/base/sortview/SortAdapter$IViewCreator;", "getListView", "Landroid/widget/ListView;", "getNoResultView", "Landroid/view/View;", "getScrollBar", "Lcom/tencent/mm/ui/base/VerticalScrollBar;", "inflate", "init", "", "isMatch", "", "word", "entity", "Lcom/tencent/mm/ui/base/sortview/SortEntity;", "ViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderContactSortView
  extends BaseSortView
{
  private final String TAG;
  
  public FinderContactSortView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168305);
    this.TAG = "Finder.FinderContactSortView";
    setOnItemClickListener(new FinderContactSortView..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(168305);
  }
  
  private static final View a(FinderContactSortView paramFinderContactSortView, com.tencent.mm.ui.base.sortview.d paramd, View paramView, ViewGroup paramViewGroup, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(345284);
    s.u(paramFinderContactSortView, "this$0");
    if (paramView == null)
    {
      paramView = View.inflate(paramFinderContactSortView.getContext(), e.f.finder_contact_sort_list_item, null);
      paramViewGroup = new a();
      paramViewGroup.lKK = ((ImageView)paramView.findViewById(e.e.avatar_iv));
      paramViewGroup.pWj = ((TextView)paramView.findViewById(e.e.nickname_tv));
      paramViewGroup.pRf = ((TextView)paramView.findViewById(e.e.catalogTV));
      paramViewGroup.yBS = paramView.findViewById(e.e.item_content);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      localObject1 = paramd.cpt;
      if (localObject1 != null) {
        break;
      }
      paramFinderContactSortView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
      AppMethodBeat.o(345284);
      throw paramFinderContactSortView;
      paramViewGroup = paramView.getTag();
      if (paramViewGroup == null)
      {
        paramFinderContactSortView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.FinderContactSortView.ViewHolder");
        AppMethodBeat.o(345284);
        throw paramFinderContactSortView;
      }
      paramViewGroup = (a)paramViewGroup;
    }
    Object localObject1 = (m)localObject1;
    Object localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
    com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((m)localObject1).amx());
    ImageView localImageView = paramViewGroup.lKK;
    s.checkNotNull(localImageView);
    com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject2).a(localb, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    localObject2 = paramViewGroup.pWj;
    if (localObject2 != null) {
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramFinderContactSortView.getContext(), (CharSequence)((m)localObject1).getNickname()));
    }
    if ((paramFinderContactSortView.aeaD) && (paramBoolean1))
    {
      localObject1 = paramViewGroup.pRf;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)paramd.aeaK);
      }
      paramd = paramViewGroup.pRf;
      if (paramd != null) {
        paramd.setVisibility(0);
      }
      if ((paramFinderContactSortView.getMode() != 0) || (!paramBoolean2)) {
        break label353;
      }
      paramFinderContactSortView = paramViewGroup.yBS;
      if (paramFinderContactSortView != null) {
        paramFinderContactSortView.setBackgroundResource(e.d.comm_list_item_selector_no_divider);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(345284);
      return paramView;
      paramd = paramViewGroup.pRf;
      if (paramd == null) {
        break;
      }
      paramd.setVisibility(8);
      break;
      label353:
      paramFinderContactSortView = paramViewGroup.yBS;
      if (paramFinderContactSortView != null) {
        paramFinderContactSortView.setBackgroundResource(e.d.list_item_normal);
      }
    }
  }
  
  private static final void a(FinderContactSortView paramFinderContactSortView, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(345240);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderContactSortView);
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/FinderContactSortView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject, localb.aYj());
    s.u(paramFinderContactSortView, "this$0");
    if ((paramLong >= 0L) && (paramLong < paramFinderContactSortView.getDatas().size()))
    {
      paramAdapterView = new Intent();
      paramView = ((com.tencent.mm.ui.base.sortview.d)paramFinderContactSortView.getDatas().get((int)paramLong)).cpt;
      if (paramView == null)
      {
        paramFinderContactSortView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.api.LocalFinderContact");
        AppMethodBeat.o(345240);
        throw paramFinderContactSortView;
      }
      paramAdapterView.putExtra("finder_username", ((m)paramView).getUsername());
      paramView = as.GSQ;
      paramView = paramFinderContactSortView.getContext();
      s.s(paramView, "context");
      as.a.a(paramView, paramAdapterView, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderContactSortView = paramFinderContactSortView.getContext();
      s.s(paramFinderContactSortView, "context");
      paramView.enterFinderProfileUI(paramFinderContactSortView, paramAdapterView);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/FinderContactSortView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(345240);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(168303);
    if (paramString == null)
    {
      AppMethodBeat.o(168303);
      return false;
    }
    if (paramd == null) {}
    for (paramd = null;; paramd = paramd.aeaK)
    {
      paramd = Util.nullAsNil(paramd);
      s.s(paramd, "nullAsNil(entity?.alpha)");
      boolean bool = n.U(paramString, paramd, false);
      AppMethodBeat.o(168303);
      return bool;
    }
  }
  
  public final View fF()
  {
    AppMethodBeat.i(168299);
    View localView = View.inflate(getContext(), e.f.finder_contact_sort_view, (ViewGroup)this);
    s.s(localView, "inflate(context, R.layou…_contact_sort_view, this)");
    AppMethodBeat.o(168299);
    return localView;
  }
  
  public final c.a getItemViewCreator()
  {
    AppMethodBeat.i(168304);
    FinderContactSortView..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new FinderContactSortView..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(168304);
    return localExternalSyntheticLambda1;
  }
  
  public final ListView getListView()
  {
    AppMethodBeat.i(168301);
    Object localObject = findViewById(e.e.list_view);
    s.s(localObject, "this.findViewById(R.id.list_view)");
    localObject = (ListView)localObject;
    AppMethodBeat.o(168301);
    return localObject;
  }
  
  public final View getNoResultView()
  {
    AppMethodBeat.i(168302);
    View localView = findViewById(e.e.no_result);
    s.s(localView, "this.findViewById(R.id.no_result)");
    AppMethodBeat.o(168302);
    return localView;
  }
  
  public final VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(168300);
    Object localObject = findViewById(e.e.sort_bar);
    s.s(localObject, "this.findViewById(R.id.sort_bar)");
    localObject = (VerticalScrollBar)localObject;
    AppMethodBeat.o(168300);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderContactSortView$ViewHolder;", "", "()V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "catalogTv", "Landroid/widget/TextView;", "getCatalogTv", "()Landroid/widget/TextView;", "setCatalogTv", "(Landroid/widget/TextView;)V", "content", "Landroid/view/View;", "getContent", "()Landroid/view/View;", "setContent", "(Landroid/view/View;)V", "nickTv", "getNickTv", "setNickTv", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    ImageView lKK;
    TextView pRf;
    TextView pWj;
    View yBS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderContactSortView
 * JD-Core Version:    0.7.0.1
 */