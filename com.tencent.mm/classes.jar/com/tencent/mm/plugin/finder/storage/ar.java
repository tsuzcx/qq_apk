package com.tencent.mm.plugin.finder.storage;

import android.content.Context;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.storage.data.g;
import com.tencent.mm.protocal.protobuf.FinderContact;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "", "canAddList", "", "getCache", "Lcom/tencent/mm/plugin/finder/storage/data/FinderContactPage;", "getEmptyTips", "", "context", "Landroid/content/Context;", "getInitData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getItemData", "netScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "getLastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "getNetScene", "lastBuff", "getSubTitleStr", "getTips", "fromPrivacySelect", "getTitleStrId", "", "needLoadMore", "onAddUserList", "nameList", "", "", "onItemDelete", "contact", "callBack", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "", "contacts", "onSearchBarClick", "", "OnItemDelCallBack", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ar
{
  public abstract p a(FinderContact paramFinderContact, ar.a parama);
  
  public abstract int ePJ();
  
  public abstract boolean ePK();
  
  public abstract g ePL();
  
  public abstract LinkedList<FinderContact> ePM();
  
  public abstract boolean ePN();
  
  public abstract p g(b paramb);
  
  public abstract CharSequence gR(Context paramContext);
  
  public abstract CharSequence gS(Context paramContext);
  
  public abstract void gT(Context paramContext);
  
  public abstract CharSequence gU(Context paramContext);
  
  public abstract Set<p> hx(List<? extends FinderContact> paramList);
  
  public abstract p hy(List<String> paramList);
  
  public abstract b i(p paramp);
  
  public abstract LinkedList<FinderContact> j(p paramp);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ar
 * JD-Core Version:    0.7.0.1
 */