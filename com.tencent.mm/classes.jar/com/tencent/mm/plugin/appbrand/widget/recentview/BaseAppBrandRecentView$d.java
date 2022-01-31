package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class BaseAppBrandRecentView$d
  implements Runnable
{
  List<a> iQp;
  List<a> jvx;
  boolean jvy;
  
  public BaseAppBrandRecentView$d(BaseAppBrandRecentView paramBaseAppBrandRecentView)
  {
    AppMethodBeat.i(134354);
    this.jvy = true;
    this.jvy = true;
    this.iQp = new ArrayList();
    this.jvx = new ArrayList();
    AppMethodBeat.o(134354);
  }
  
  public final void run()
  {
    AppMethodBeat.i(134355);
    for (;;)
    {
      synchronized (BaseAppBrandRecentView.f(this.jvt))
      {
        BaseAppBrandRecentView.a(this.jvt, true);
        ??? = null;
        if (BaseAppBrandRecentView.g(this.jvt) != null) {
          ??? = BaseAppBrandRecentView.g(this.jvt).qi(this.jvt.getLoadCount());
        }
        this.iQp.clear();
        this.jvx.clear();
        if (??? == null) {
          break;
        }
        if (this.jvt.getSceneFactory() != null)
        {
          LocalUsageInfo localLocalUsageInfo1 = this.jvt.getSceneFactory().aJB();
          ??? = ((List)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break;
          }
          LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
          if ((localLocalUsageInfo1 != null) && (localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) && (localLocalUsageInfo2.hcr == localLocalUsageInfo1.hcr)) {
            continue;
          }
          if (this.iQp.size() < this.jvt.getShowCount()) {
            this.iQp.add(new a(localLocalUsageInfo2));
          }
          if (BaseAppBrandRecentView.h(this.jvt)) {
            this.jvx.add(new a(localLocalUsageInfo2));
          }
          ab.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.bDi, localLocalUsageInfo2.hcN, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.hcr), this.jvt.jhO });
        }
      }
      Object localObject3 = null;
    }
    this.jvt.aO(this.iQp);
    ab.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { this.jvt.getType(), Integer.valueOf(BaseAppBrandRecentView.b(this.jvt).size()), Integer.valueOf(BaseAppBrandRecentView.i(this.jvt).size()), this.jvt.jhO });
    al.d(new BaseAppBrandRecentView.d.1(this));
    AppMethodBeat.o(134355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.d
 * JD-Core Version:    0.7.0.1
 */