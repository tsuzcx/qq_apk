package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;

final class k
{
  final boolean enable;
  
  k(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  final ArrayList<AppBrandRecentTaskInfo> M(ArrayList<AppBrandRecentTaskInfo> paramArrayList)
  {
    AppMethodBeat.i(49208);
    if ((!this.enable) || (Util.isNullOrNil(paramArrayList)))
    {
      AppMethodBeat.o(49208);
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList(paramArrayList.size());
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AppBrandRecentTaskInfo localAppBrandRecentTaskInfo = (AppBrandRecentTaskInfo)paramArrayList.next();
      if (!localAppBrandRecentTaskInfo.nPC) {
        localArrayList.add(localAppBrandRecentTaskInfo);
      }
    }
    AppMethodBeat.o(49208);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.k
 * JD-Core Version:    0.7.0.1
 */