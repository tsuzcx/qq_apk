package com.tencent.mm.plugin.appbrand.phonenumber;

import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter$ViewHolder;", "context", "Landroid/content/Context;", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getContext", "()Landroid/content/Context;", "deletePhoneItems", "getDeletePhoneItems", "()Ljava/util/ArrayList;", "getPhoneItems", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showDelete", "", "getShowDelete", "()Z", "setShowDelete", "(Z)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "remove", "phoneItem", "updatePhoneItems", "", "ViewHolder", "plugin-appbrand-integration_release"})
public final class i
  extends RecyclerView.a<i.a>
{
  final Context context;
  final ArrayList<PhoneItem> iDc;
  boolean iDd;
  ArrayList<PhoneItem> iDe;
  
  public i(Context paramContext, ArrayList<PhoneItem> paramArrayList)
  {
    AppMethodBeat.i(134791);
    this.context = paramContext;
    this.iDe = paramArrayList;
    this.iDc = new ArrayList();
    AppMethodBeat.o(134791);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(134789);
    int i = this.iDe.size();
    AppMethodBeat.o(134789);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i
 * JD-Core Version:    0.7.0.1
 */