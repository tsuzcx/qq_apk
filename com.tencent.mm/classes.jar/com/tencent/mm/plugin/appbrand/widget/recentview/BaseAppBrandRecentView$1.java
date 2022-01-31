package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import java.util.List;

final class BaseAppBrandRecentView$1
  implements AppBrandRecentView.c<LocalUsageInfo>
{
  BaseAppBrandRecentView$1(BaseAppBrandRecentView paramBaseAppBrandRecentView) {}
  
  public final List<LocalUsageInfo> qi(int paramInt)
  {
    AppMethodBeat.i(134341);
    List localList = ((ag)g.E(ag.class)).nu(paramInt);
    AppMethodBeat.o(134341);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.1
 * JD-Core Version:    0.7.0.1
 */