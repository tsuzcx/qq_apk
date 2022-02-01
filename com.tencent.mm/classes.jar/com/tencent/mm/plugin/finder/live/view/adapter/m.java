package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "header", "", "getHeader", "()Ljava/lang/String;", "setHeader", "(Ljava/lang/String;)V", "headerViewHodler", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewHolder;", "headerViewItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewItem;", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "getViewItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "HeaderViewHolder", "HeaderViewItem", "plugin-finder_release"})
public final class m
  extends a
{
  String header;
  private final b yXO;
  final a yXP;
  
  public m(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(278749);
    this.yXO = new b();
    this.yXP = new a();
    AppMethodBeat.o(278749);
  }
  
  public final void a(Context paramContext, a.a parama) {}
  
  public final a.b bwF()
  {
    return (a.b)this.yXO;
  }
  
  public final a.a bwG()
  {
    return (a.a)this.yXP;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;)V", "headerRoot", "Landroid/view/View;", "getHeaderRoot", "()Landroid/view/View;", "setHeaderRoot", "(Landroid/view/View;)V", "headerTV", "Landroid/widget/TextView;", "getHeaderTV", "()Landroid/widget/TextView;", "setHeaderTV", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class a
    extends a.a
  {
    TextView tOY;
    View yXQ;
    
    public a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem$HeaderViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveHeaderDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "convertView", "onItemClick", "v", "plugin-finder_release"})
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(287260);
      p.k(paramContext, "context");
      p.k(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramContext).inflate(b.g.select_ui_listheaderitem, paramViewGroup, false);
      paramContext = (a.a)this.yXR.yXP;
      if (paramContext == null)
      {
        paramContext = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.adapter.FinderLiveHeaderDataItem.HeaderViewHolder");
        AppMethodBeat.o(287260);
        throw paramContext;
      }
      m.a locala = (m.a)paramContext;
      if (paramViewGroup != null) {}
      for (paramContext = (TextView)paramViewGroup.findViewById(b.f.header_tv); paramContext == null; paramContext = null)
      {
        paramContext = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(287260);
        throw paramContext;
      }
      locala.tOY = paramContext;
      if (paramViewGroup != null) {}
      for (paramContext = paramViewGroup.findViewById(b.f.header_tv_root);; paramContext = null)
      {
        locala.yXQ = paramContext;
        paramContext = locala.yXQ;
        if (paramContext != null) {
          paramContext.setVisibility(8);
        }
        if (paramViewGroup != null) {
          paramViewGroup.setTag(locala);
        }
        AppMethodBeat.o(287260);
        return paramViewGroup;
      }
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(287261);
      p.k(paramContext, "context");
      p.k(parama, "holder");
      p.k(parama1, "data");
      paramContext = (m.a)parama;
      n.a(((m)parama1).header, paramContext.tOY);
      AppMethodBeat.o(287261);
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      AppMethodBeat.i(287262);
      p.k(paramContext, "context");
      p.k(paramView, "v");
      p.k(parama, "data");
      AppMethodBeat.o(287262);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.m
 * JD-Core Version:    0.7.0.1
 */