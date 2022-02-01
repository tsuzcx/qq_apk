package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "onPhoneItemRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "phoneItem", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "getOnPhoneItemRemove", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemRemove", "(Lkotlin/jvm/functions/Function1;)V", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updatePhoneItems", "", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class j
  extends RecyclerView.a<a>
{
  final Context context;
  ArrayList<PhoneItem> jGn;
  boolean ljQ;
  b<? super PhoneItem, y> ljR;
  
  public j(Context paramContext, ArrayList<PhoneItem> paramArrayList, b<? super PhoneItem, y> paramb)
  {
    AppMethodBeat.i(148059);
    this.context = paramContext;
    this.jGn = paramArrayList;
    this.ljR = paramb;
    AppMethodBeat.o(148059);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(148057);
    int i = this.jGn.size();
    AppMethodBeat.o(148057);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "deleteIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView ljS;
    final TextView ljT;
    final TextView ljU;
    final j ljV;
    
    public a(j paramj, View paramView)
    {
      super();
      AppMethodBeat.i(148055);
      this.ljV = paramj;
      paramj = paramView.findViewById(2131303227);
      k.g(paramj, "view.findViewById(R.id.p…nager_dialog_item_delete)");
      this.ljS = ((ImageView)paramj);
      paramj = paramView.findViewById(2131303228);
      k.g(paramj, "view.findViewById(R.id.p…anager_dialog_item_phone)");
      this.ljT = ((TextView)paramj);
      paramj = paramView.findViewById(2131303229);
      k.g(paramj, "view.findViewById(R.id.p…nager_dialog_item_remark)");
      this.ljU = ((TextView)paramj);
      AppMethodBeat.o(148055);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(j.a parama, PhoneItem paramPhoneItem) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(148054);
        this.ljW.ljV.ljR.aA(this.ljX);
        AppMethodBeat.o(148054);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.j
 * JD-Core Version:    0.7.0.1
 */