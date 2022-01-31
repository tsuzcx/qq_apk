package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "adapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;Landroid/view/View;)V", "getAdapter", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "deleteIv", "Landroid/widget/ImageView;", "phoneTv", "Landroid/widget/TextView;", "remarkTv", "fillItem", "", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "plugin-appbrand-integration_release"})
public final class i$a
  extends RecyclerView.v
{
  final ImageView iDf;
  final TextView iDg;
  final TextView iDh;
  final i iDi;
  
  public i$a(i parami, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(134787);
    this.iDi = parami;
    parami = paramView.findViewById(2131821284);
    j.p(parami, "view.findViewById(R.id.p…nager_dialog_item_delete)");
    this.iDf = ((ImageView)parami);
    parami = paramView.findViewById(2131821285);
    j.p(parami, "view.findViewById(R.id.p…anager_dialog_item_phone)");
    this.iDg = ((TextView)parami);
    parami = paramView.findViewById(2131821286);
    j.p(parami, "view.findViewById(R.id.p…nager_dialog_item_remark)");
    this.iDh = ((TextView)parami);
    AppMethodBeat.o(134787);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(i.a parama, PhoneItem paramPhoneItem) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(134786);
      paramView = this.iDj.iDi;
      PhoneItem localPhoneItem = this.iDk;
      j.q(localPhoneItem, "phoneItem");
      paramView.iDc.add(localPhoneItem);
      paramView.iDe.remove(localPhoneItem);
      paramView.notifyDataSetChanged();
      AppMethodBeat.o(134786);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i.a
 * JD-Core Version:    0.7.0.1
 */