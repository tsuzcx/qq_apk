package com.tencent.mm.plugin.appbrand.ui.collection;

import a.d.b.g;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class h
  extends RecyclerView.a<j>
{
  final ArrayList<LocalUsageInfo> hgv;
  
  public h(ArrayList<LocalUsageInfo> paramArrayList)
  {
    this.hgv = paramArrayList;
  }
  
  private void a(j paramj, int paramInt)
  {
    g.k(paramj, "holder");
    Object localObject = this.hgv.get(paramInt);
    g.j(localObject, "dataList[position]");
    paramj.f((LocalUsageInfo)localObject);
  }
  
  public final void aB(List<? extends LocalUsageInfo> paramList)
  {
    g.k(paramList, "list");
    synchronized (this.hgv)
    {
      this.hgv.clear();
      this.hgv.addAll((Collection)paramList);
      return;
    }
  }
  
  public final ArrayList<LocalUsageInfo> apF()
  {
    synchronized (this.hgv)
    {
      ArrayList localArrayList2 = new ArrayList(this.hgv.size());
      localArrayList2.addAll((Collection)this.hgv);
      return localArrayList2;
    }
  }
  
  public final int getItemCount()
  {
    return this.hgv.size();
  }
  
  public final long getItemId(int paramInt)
  {
    LocalUsageInfo localLocalUsageInfo = (LocalUsageInfo)this.hgv.get(paramInt);
    return (localLocalUsageInfo.username + localLocalUsageInfo.fJy).hashCode();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.collection.h
 * JD-Core Version:    0.7.0.1
 */