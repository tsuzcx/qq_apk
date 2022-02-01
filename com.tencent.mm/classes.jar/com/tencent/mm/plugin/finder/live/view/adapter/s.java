package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "header", "", "getHeader", "()Ljava/lang/String;", "setHeader", "(Ljava/lang/String;)V", "headerViewHodler", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewHolder;", "headerViewItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewItem;", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "HeaderViewHolder", "HeaderViewItem", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends a
{
  private final b DRt;
  final a DRu;
  String header;
  
  public s(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(358618);
    this.DRt = new b();
    this.DRu = new a();
    AppMethodBeat.o(358618);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bVv()
  {
    return (a.b)this.DRt;
  }
  
  public final a.a bVw()
  {
    return (a.a)this.DRu;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;)V", "headerRoot", "Landroid/view/View;", "getHeaderRoot", "()Landroid/view/View;", "setHeaderRoot", "(Landroid/view/View;)V", "headerTV", "Landroid/widget/TextView;", "getHeaderTV", "()Landroid/widget/TextView;", "setHeaderTV", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends a.a
  {
    View DRv;
    TextView wSo;
    
    public a()
    {
      super();
      AppMethodBeat.i(359006);
      AppMethodBeat.o(359006);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends a.b
  {
    public b()
    {
      super();
      AppMethodBeat.i(359012);
      AppMethodBeat.o(359012);
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(359026);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramContext).inflate(p.f.select_ui_listheaderitem, paramViewGroup, false);
      s.a locala = (s.a)this.DRw.DRu;
      if (paramViewGroup == null) {}
      for (paramContext = null; paramContext == null; paramContext = (TextView)paramViewGroup.findViewById(p.e.header_tv))
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(359026);
        throw paramContext;
      }
      locala.wSo = paramContext;
      if (paramViewGroup == null) {}
      for (paramContext = null;; paramContext = paramViewGroup.findViewById(p.e.header_tv_root))
      {
        locala.DRv = paramContext;
        paramContext = locala.DRv;
        if (paramContext != null) {
          paramContext.setVisibility(8);
        }
        if (paramViewGroup != null) {
          paramViewGroup.setTag(locala);
        }
        AppMethodBeat.o(359026);
        return paramViewGroup;
      }
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(359035);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(parama, "holder");
      kotlin.g.b.s.u(parama1, "data");
      paramContext = (s.a)parama;
      o.b(((s)parama1).header, paramContext.wSo);
      AppMethodBeat.o(359035);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      AppMethodBeat.i(359043);
      kotlin.g.b.s.u(paramContext, "context");
      kotlin.g.b.s.u(paramView, "v");
      kotlin.g.b.s.u(parama, "data");
      AppMethodBeat.o(359043);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.s
 * JD-Core Version:    0.7.0.1
 */