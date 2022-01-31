package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "appId", "", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetPhoneItems", "ViewHolder", "plugin-appbrand-integration_release"})
public final class j
  extends RecyclerView.a<a>
{
  private final String appId;
  final Context context;
  ArrayList<PhoneItem> iDe;
  
  public j(String paramString, Context paramContext, ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(134797);
    this.appId = paramString;
    this.context = paramContext;
    this.iDe = paramArrayList;
    AppMethodBeat.o(134797);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(134795);
    int i = this.iDe.size();
    AppMethodBeat.o(134795);
    return i;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "checkIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
  public static final class a
    extends RecyclerView.v
  {
    final TextView iDg;
    final TextView iDh;
    final ImageView iDl;
    final j iDm;
    
    public a(j paramj, View paramView)
    {
      super();
      AppMethodBeat.i(134792);
      this.iDm = paramj;
      paramj = paramView.findViewById(2131821285);
      a.f.b.j.p(paramj, "view.findViewById(R.id.p…anager_dialog_item_phone)");
      this.iDg = ((TextView)paramj);
      paramj = paramView.findViewById(2131821286);
      a.f.b.j.p(paramj, "view.findViewById(R.id.p…nager_dialog_item_remark)");
      this.iDh = ((TextView)paramj);
      paramj = paramView.findViewById(2131821287);
      a.f.b.j.p(paramj, "view.findViewById(R.id.p…anager_dialog_item_check)");
      this.iDl = ((ImageView)paramj);
      AppMethodBeat.o(134792);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.j
 * JD-Core Version:    0.7.0.1
 */