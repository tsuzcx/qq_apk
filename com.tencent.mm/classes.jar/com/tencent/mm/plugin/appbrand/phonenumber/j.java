package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "onPhoneItemRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "phoneItem", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "getOnPhoneItemRemove", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemRemove", "(Lkotlin/jvm/functions/Function1;)V", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updatePhoneItems", "", "ViewHolder", "luggage-wechat-full-sdk_release"})
public final class j
  extends RecyclerView.a<a>
{
  final Context context;
  ArrayList<PhoneItem> kBz;
  boolean mjv;
  d.g.a.b<? super PhoneItem, z> mjw;
  
  public j(Context paramContext, ArrayList<PhoneItem> paramArrayList, d.g.a.b<? super PhoneItem, z> paramb)
  {
    AppMethodBeat.i(148059);
    this.context = paramContext;
    this.kBz = paramArrayList;
    this.mjw = paramb;
    AppMethodBeat.o(148059);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(148057);
    int i = this.kBz.size();
    AppMethodBeat.o(148057);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "deleteIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
  public static final class a
    extends RecyclerView.w
  {
    final j mjA;
    final ImageView mjx;
    final TextView mjy;
    final TextView mjz;
    
    public a(j paramj, View paramView)
    {
      super();
      AppMethodBeat.i(148055);
      this.mjA = paramj;
      paramj = paramView.findViewById(2131303227);
      p.g(paramj, "view.findViewById(R.id.p…nager_dialog_item_delete)");
      this.mjx = ((ImageView)paramj);
      paramj = paramView.findViewById(2131303228);
      p.g(paramj, "view.findViewById(R.id.p…anager_dialog_item_phone)");
      this.mjy = ((TextView)paramj);
      paramj = paramView.findViewById(2131303229);
      p.g(paramj, "view.findViewById(R.id.p…nager_dialog_item_remark)");
      this.mjz = ((TextView)paramj);
      AppMethodBeat.o(148055);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(j.a parama, PhoneItem paramPhoneItem) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(148054);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        a.b("com/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder$fillItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.mjB.mjA.mjw.invoke(this.mjC);
        a.a(this, "com/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder$fillItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(148054);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.j
 * JD-Core Version:    0.7.0.1
 */