package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "appId", "", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetPhoneItems", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class q
  extends RecyclerView.a<a>
{
  private final String appId;
  final Context context;
  ArrayList<PhoneItem> jGn;
  
  public q(String paramString, Context paramContext, ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148068);
    this.appId = paramString;
    this.context = paramContext;
    this.jGn = paramArrayList;
    AppMethodBeat.o(148068);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(148066);
    int i = this.jGn.size();
    AppMethodBeat.o(148066);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "checkIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView ljT;
    final TextView ljU;
    final ImageView ljZ;
    final q lka;
    
    public a(q paramq, View paramView)
    {
      super();
      AppMethodBeat.i(148063);
      this.lka = paramq;
      paramq = paramView.findViewById(2131303228);
      k.g(paramq, "view.findViewById(R.id.p…anager_dialog_item_phone)");
      this.ljT = ((TextView)paramq);
      paramq = paramView.findViewById(2131303229);
      k.g(paramq, "view.findViewById(R.id.p…nager_dialog_item_remark)");
      this.ljU = ((TextView)paramq);
      paramq = paramView.findViewById(2131303226);
      k.g(paramq, "view.findViewById(R.id.p…anager_dialog_item_check)");
      this.ljZ = ((ImageView)paramq);
      AppMethodBeat.o(148063);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(q paramq, PhoneItem paramPhoneItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148064);
      q.a(this.lkb);
      this.ljX.lki = true;
      this.lkb.notifyDataSetChanged();
      AppMethodBeat.o(148064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.q
 * JD-Core Version:    0.7.0.1
 */