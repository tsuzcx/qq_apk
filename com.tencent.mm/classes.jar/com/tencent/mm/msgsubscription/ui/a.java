package com.tencent.mm.msgsubscription.ui;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter;", "VH", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "value", "", "exampleTitle", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "mList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/ArrayList;", "getMList", "()Ljava/util/ArrayList;", "setMList", "(Ljava/util/ArrayList;)V", "setList", "", "list", "SubscribeMsgItemOpListener", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<VH extends RecyclerView.v>
  extends RecyclerView.a<VH>
{
  String pjA = "";
  ArrayList<SubscribeMsgTmpItem> pkR = new ArrayList();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/BaseSubscribeMsgListAdapter$SubscribeMsgItemOpListener;", "", "getCheckBoxState", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "onCheckBoxStatusChanged", "", "check", "onItemInfoClick", "view", "Landroid/view/View;", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem, boolean paramBoolean);
    
    public abstract boolean a(SubscribeMsgTmpItem paramSubscribeMsgTmpItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.a
 * JD-Core Version:    0.7.0.1
 */