package com.tencent.mm.plugin.ab;

import com.tencent.mm.plugin.mvvmlist.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mvvmcomm/DefaultMvvmListItem;", "T", "Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "", "uid", "", "iType", "", "(Ljava/lang/String;I)V", "getIType", "()I", "getUid", "()Ljava/lang/String;", "cloneItem", "()Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;", "convert", "K", "item", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)Ljava/lang/Object;", "getChangeObject", "Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "old", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)Lcom/tencent/mm/plugin/mvvmlist/MvvmListItemChangeObj;", "getItemId", "", "getItemType", "getUniqueId", "isSameItem", "", "other", "(Lcom/tencent/mm/plugin/mvvmlist/IMvvmListItem;)Z", "plugin-mvvmcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T extends b<T>>
  implements b<T>, Cloneable
{
  private final int MmC;
  private final String mXG;
  
  private a(String paramString)
  {
    this.mXG = paramString;
    this.MmC = 0;
  }
  
  public final long bZA()
  {
    return this.mXG.hashCode();
  }
  
  public final int bZB()
  {
    return this.MmC;
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public final String fcs()
  {
    return this.mXG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.a
 * JD-Core Version:    0.7.0.1
 */