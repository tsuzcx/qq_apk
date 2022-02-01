package com.tencent.mm.chatting;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "CONVERSATION", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$ConversationHolder;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "afterConversationChange", "Lkotlin/Function0;", "", "getAfterConversationChange", "()Lkotlin/jvm/functions/Function0;", "setAfterConversationChange", "(Lkotlin/jvm/functions/Function0;)V", "getDataList", "", "insertConvList", "convs", "onConversationOrContactChange", "", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onNotifyChange", "compat_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BasePrivateMsgConvListFragment$a<CONVERSATION>
  extends RecyclerView.a<BasePrivateMsgConvListFragment.b>
  implements MStorage.IOnStorageChange
{
  a<ah> lPE;
  
  public abstract boolean a(String paramString, MStorageEventData paramMStorageEventData);
  
  public abstract void bw(List<? extends CONVERSATION> paramList);
  
  public abstract List<CONVERSATION> getDataList();
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    if (a(paramString, paramMStorageEventData))
    {
      paramString = this.lPE;
      if (paramString != null) {
        paramString.invoke();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a
 * JD-Core Version:    0.7.0.1
 */