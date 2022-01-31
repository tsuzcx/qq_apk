package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

final class k
{
  final boolean enable;
  
  k(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  final ArrayList<AppBrandRecentTaskInfo> q(ArrayList<AppBrandRecentTaskInfo> paramArrayList)
  {
    AppMethodBeat.i(133482);
    if ((!this.enable) || (bo.es(paramArrayList)))
    {
      AppMethodBeat.o(133482);
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)paramArrayList.next();
      if (!localAppBrandRecentTaskInfo.hcd) {
        localArrayList.add(localAppBrandRecentTaskInfo);
      }
    }
    AppMethodBeat.o(133482);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.k
 * JD-Core Version:    0.7.0.1
 */