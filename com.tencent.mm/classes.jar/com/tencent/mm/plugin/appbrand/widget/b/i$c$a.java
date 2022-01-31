package com.tencent.mm.plugin.appbrand.widget.b;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$ItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "items", "", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandRequestDialog$Item;", "(Landroid/view/View;Ljava/util/List;)V", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "getItems", "()Ljava/util/List;", "selected", "subTitle", "Landroid/widget/TextView;", "title", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "applyData", "", "item", "position", "", "checkStateChange", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "posChanged", "refreshCheckView", "check", "", "luggage-wechat-full-sdk_release"})
public final class i$c$a
  extends RecyclerView.v
{
  final TextView gui;
  ImageView iTH;
  final List<i.b> items;
  final TextView jjS;
  private final ImageView jjT;
  View view;
  
  public i$c$a(View paramView, List<i.b> paramList)
  {
    super(paramView);
    AppMethodBeat.i(102485);
    this.view = paramView;
    this.items = paramList;
    paramView = this.view.findViewById(2131820929);
    j.p(paramView, "view.findViewById(R.id.icon)");
    this.iTH = ((ImageView)paramView);
    paramView = this.view.findViewById(2131820680);
    j.p(paramView, "view.findViewById(R.id.title)");
    this.gui = ((TextView)paramView);
    paramView = this.view.findViewById(2131821272);
    j.p(paramView, "view.findViewById(R.id.sub_title)");
    this.jjS = ((TextView)paramView);
    paramView = this.view.findViewById(2131821273);
    j.p(paramView, "view.findViewById(R.id.selected)");
    this.jjT = ((ImageView)paramView);
    AppMethodBeat.o(102485);
  }
  
  final void fm(boolean paramBoolean)
  {
    AppMethodBeat.i(102484);
    if (this.items.size() == 1)
    {
      this.jjT.setVisibility(0);
      AppMethodBeat.o(102484);
      return;
    }
    if (paramBoolean)
    {
      this.jjT.setVisibility(0);
      AppMethodBeat.o(102484);
      return;
    }
    this.jjT.setVisibility(8);
    AppMethodBeat.o(102484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.i.c.a
 * JD-Core Version:    0.7.0.1
 */