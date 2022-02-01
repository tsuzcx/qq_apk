package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.l.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "appId", "", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetPhoneItems", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class q
  extends RecyclerView.a<a>
{
  private final String appId;
  final Context context;
  public ArrayList<PhoneItem> oFB;
  
  public q(String paramString, Context paramContext, ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148068);
    this.appId = paramString;
    this.context = paramContext;
    this.oFB = paramArrayList;
    AppMethodBeat.o(148068);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(148066);
    int i = this.oFB.size();
    AppMethodBeat.o(148066);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "checkIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
  public static final class a
    extends RecyclerView.v
  {
    final ImageView qBB;
    final q qBC;
    final TextView qBs;
    final TextView qBt;
    
    public a(q paramq, View paramView)
    {
      super();
      AppMethodBeat.i(148063);
      this.qBC = paramq;
      paramq = paramView.findViewById(a.d.phone_number_manager_dialog_item_phone);
      p.j(paramq, "view.findViewById(R.id.p…anager_dialog_item_phone)");
      this.qBs = ((TextView)paramq);
      paramq = paramView.findViewById(a.d.phone_number_manager_dialog_item_remark);
      p.j(paramq, "view.findViewById(R.id.p…nager_dialog_item_remark)");
      this.qBt = ((TextView)paramq);
      paramq = paramView.findViewById(a.d.phone_number_manager_dialog_item_check);
      p.j(paramq, "view.findViewById(R.id.p…anager_dialog_item_check)");
      this.qBB = ((ImageView)paramq);
      AppMethodBeat.o(148063);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(q paramq, PhoneItem paramPhoneItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(148064);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      q.a(this.qBD);
      this.qBw.qBK = true;
      this.qBD.notifyDataSetChanged();
      a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(148064);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.q
 * JD-Core Version:    0.7.0.1
 */