package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStr", "getTips", "fromPrivacySelect", "getTitleStrId", "", "needLoadMore", "onAddUserList", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "contacts", "onSearchBarClick", "", "context", "Landroid/content/Context;", "OnItemDelCallBack", "plugin-finder_release"})
public abstract interface aj
{
  public abstract q a(FinderContact paramFinderContact, a parama);
  
  public abstract q d(b paramb);
  
  public abstract g dRA();
  
  public abstract LinkedList<FinderContact> dRB();
  
  public abstract boolean dRC();
  
  public abstract CharSequence dRD();
  
  public abstract int dRw();
  
  public abstract CharSequence dRx();
  
  public abstract CharSequence dRy();
  
  public abstract boolean dRz();
  
  public abstract Set<q> eL(List<? extends FinderContact> paramList);
  
  public abstract q eM(List<String> paramList);
  
  public abstract void fD(Context paramContext);
  
  public abstract b i(q paramq);
  
  public abstract LinkedList<FinderContact> j(q paramq);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "onDel", "", "success", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void pX(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.aj
 * JD-Core Version:    0.7.0.1
 */