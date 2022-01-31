package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;
import java.util.Iterator;

final class k
{
  final boolean bIU;
  
  k(boolean paramBoolean)
  {
    this.bIU = paramBoolean;
  }
  
  final ArrayList<AppBrandRecentTaskInfo> n(ArrayList<AppBrandRecentTaskInfo> paramArrayList)
  {
    if ((!this.bIU) || (bk.dk(paramArrayList))) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)paramArrayList.next();
      if (!localAppBrandRecentTaskInfo.fJl) {
        localArrayList.add(localAppBrandRecentTaskInfo);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.k
 * JD-Core Version:    0.7.0.1
 */