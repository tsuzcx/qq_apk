package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.m.a.d;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "onPhoneItemRemove", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "phoneItem", "", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getContext", "()Landroid/content/Context;", "getOnPhoneItemRemove", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemRemove", "(Lkotlin/jvm/functions/Function1;)V", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updatePhoneItems", "", "ViewHolder", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends RecyclerView.a<a>
{
  final Context context;
  ArrayList<PhoneItem> rIF;
  kotlin.g.a.b<? super PhoneItem, ah> tGx;
  boolean tGy;
  
  public j(Context paramContext, ArrayList<PhoneItem> paramArrayList, kotlin.g.a.b<? super PhoneItem, ah> paramb)
  {
    AppMethodBeat.i(148059);
    this.context = paramContext;
    this.rIF = paramArrayList;
    this.tGx = paramb;
    AppMethodBeat.o(148059);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(148057);
    int i = this.rIF.size();
    AppMethodBeat.o(148057);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "deleteIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    private final ImageView tGA;
    private final TextView tGB;
    private final TextView tGC;
    private final j tGz;
    
    public a(j paramj, View paramView)
    {
      super();
      AppMethodBeat.i(148055);
      this.tGz = paramj;
      paramj = paramView.findViewById(a.d.phone_number_manager_dialog_item_delete);
      s.s(paramj, "view.findViewById(R.id.p…nager_dialog_item_delete)");
      this.tGA = ((ImageView)paramj);
      paramj = paramView.findViewById(a.d.phone_number_manager_dialog_item_phone);
      s.s(paramj, "view.findViewById(R.id.p…anager_dialog_item_phone)");
      this.tGB = ((TextView)paramj);
      paramj = paramView.findViewById(a.d.phone_number_manager_dialog_item_remark);
      s.s(paramj, "view.findViewById(R.id.p…nager_dialog_item_remark)");
      this.tGC = ((TextView)paramj);
      AppMethodBeat.o(148055);
    }
    
    private static final void a(a parama, PhoneItem paramPhoneItem, View paramView)
    {
      AppMethodBeat.i(318867);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramPhoneItem);
      localb.cH(paramView);
      a.c("com/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      s.u(paramPhoneItem, "$phoneItem");
      parama.tGz.tGx.invoke(paramPhoneItem);
      a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(318867);
    }
    
    public final void a(PhoneItem paramPhoneItem)
    {
      AppMethodBeat.i(318874);
      s.u(paramPhoneItem, "phoneItem");
      this.tGB.setText((CharSequence)paramPhoneItem.tGJ);
      if (paramPhoneItem.tGO) {
        this.tGC.setText((CharSequence)this.tGz.context.getString(a.g.appbrand_phone_number_wechat_phone_number));
      }
      while ((this.tGz.tGy) && (!paramPhoneItem.tGO))
      {
        this.tGA.setVisibility(0);
        this.tGA.setOnClickListener(new j.a..ExternalSyntheticLambda0(this, paramPhoneItem));
        AppMethodBeat.o(318874);
        return;
        this.tGC.setText((CharSequence)"");
      }
      this.tGA.setVisibility(8);
      AppMethodBeat.o(318874);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.j
 * JD-Core Version:    0.7.0.1
 */