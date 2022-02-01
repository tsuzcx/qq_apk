package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import java.util.LinkedList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStrId", "getTitleStrId", "needLoadMore", "onAddUserList", "", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onSearchBarClick", "context", "Landroid/content/Context;", "OnItemDelCallBack", "plugin-finder_release"})
public abstract interface ak
{
  public abstract void a(FinderContact paramFinderContact, a parama);
  
  public abstract q c(b paramb);
  
  public abstract int dql();
  
  public abstract int dqm();
  
  public abstract boolean dqn();
  
  public abstract g dqo();
  
  public abstract LinkedList<FinderContact> dqp();
  
  public abstract boolean dqq();
  
  public abstract int dqr();
  
  public abstract void es(List<String> paramList);
  
  public abstract void fq(Context paramContext);
  
  public abstract b i(q paramq);
  
  public abstract LinkedList<FinderContact> j(q paramq);
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "onDel", "", "success", "", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void nN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ak
 * JD-Core Version:    0.7.0.1
 */