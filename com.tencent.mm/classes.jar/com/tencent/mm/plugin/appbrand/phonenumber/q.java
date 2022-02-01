package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.luggage.m.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "appId", "", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;)V", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resetPhoneItems", "ViewHolder", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends RecyclerView.a<a>
{
  private final String appId;
  final Context context;
  public ArrayList<PhoneItem> rIF;
  
  public q(String paramString, Context paramContext, ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(148068);
    this.appId = paramString;
    this.context = paramContext;
    this.rIF = paramArrayList;
    AppMethodBeat.o(148068);
  }
  
  private static final void a(q paramq, PhoneItem paramPhoneItem, View paramView)
  {
    AppMethodBeat.i(318880);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramq);
    localb.cH(paramPhoneItem);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramq, "this$0");
    s.u(paramPhoneItem, "$phoneItem");
    paramq.cHz();
    paramPhoneItem.tGP = true;
    paramq.bZE.notifyChanged();
    a.a(new Object(), "com/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(318880);
  }
  
  private final void cHz()
  {
    AppMethodBeat.i(318877);
    Iterator localIterator = this.rIF.iterator();
    while (localIterator.hasNext()) {
      ((PhoneItem)localIterator.next()).tGP = false;
    }
    AppMethodBeat.o(318877);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(148066);
    int i = this.rIF.size();
    AppMethodBeat.o(148066);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/ItemAdapter;", "checkIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isAllCharDigit", "", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RecyclerView.v
  {
    final TextView tGB;
    final TextView tGC;
    final q tGG;
    final ImageView tGH;
    
    public a(q paramq, View paramView)
    {
      super();
      AppMethodBeat.i(148063);
      this.tGG = paramq;
      paramq = paramView.findViewById(a.d.phone_number_manager_dialog_item_phone);
      s.s(paramq, "view.findViewById(R.id.p…anager_dialog_item_phone)");
      this.tGB = ((TextView)paramq);
      paramq = paramView.findViewById(a.d.phone_number_manager_dialog_item_remark);
      s.s(paramq, "view.findViewById(R.id.p…nager_dialog_item_remark)");
      this.tGC = ((TextView)paramq);
      paramq = paramView.findViewById(a.d.phone_number_manager_dialog_item_check);
      s.s(paramq, "view.findViewById(R.id.p…anager_dialog_item_check)");
      this.tGH = ((ImageView)paramq);
      AppMethodBeat.o(148063);
    }
    
    static boolean afw(String paramString)
    {
      AppMethodBeat.i(318933);
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        i += 1;
        if (!Character.isDigit(c))
        {
          AppMethodBeat.o(318933);
          return false;
        }
      }
      AppMethodBeat.o(318933);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.q
 * JD-Core Version:    0.7.0.1
 */