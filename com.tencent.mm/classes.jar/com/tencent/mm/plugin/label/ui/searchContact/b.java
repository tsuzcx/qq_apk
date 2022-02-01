package com.tencent.mm.plugin.label.ui.searchContact;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.model.cn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItem;", "liveList", "Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;", "(Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;)V", "liveListData", "getLiveListData", "()Lcom/tencent/mm/plugin/label/ui/searchContact/ContactDataItemList;", "setLiveListData", "createViewHolder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "convertView", "Landroid/view/View;", "getLayoutId", "", "onBindViewHolder", "", "holder", "dataItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends f<a>
{
  public static final b.a JXu;
  private ContactDataItemList JXv;
  
  static
  {
    AppMethodBeat.i(268897);
    JXu = new b.a((byte)0);
    AppMethodBeat.o(268897);
  }
  
  public b(ContactDataItemList paramContactDataItemList)
  {
    this.JXv = paramContactDataItemList;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(268912);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(268912);
  }
  
  public final j b(RecyclerView paramRecyclerView, View paramView)
  {
    AppMethodBeat.i(268908);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramView, "convertView");
    long l = cn.bDw();
    paramRecyclerView = new a.a(paramView);
    Log.i("MicroMsg.Mvvm.AddressItemConvert", s.X("createViewHolder ", Long.valueOf(cn.bDw() - l)));
    paramRecyclerView = (j)paramRecyclerView;
    AppMethodBeat.o(268908);
    return paramRecyclerView;
  }
  
  public final int getLayoutId()
  {
    return R.i.gnQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.searchContact.b
 * JD-Core Version:    0.7.0.1
 */