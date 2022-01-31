package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class BaseAppBrandRecentView$d
  implements Runnable
{
  List<a> hCW = new ArrayList();
  boolean hCX = true;
  List<a> hfb = new ArrayList();
  
  public BaseAppBrandRecentView$d(BaseAppBrandRecentView paramBaseAppBrandRecentView) {}
  
  public final void run()
  {
    for (;;)
    {
      synchronized (BaseAppBrandRecentView.f(this.hCR))
      {
        BaseAppBrandRecentView.a(this.hCR, true);
        ??? = null;
        if (BaseAppBrandRecentView.g(this.hCR) != null) {
          ??? = BaseAppBrandRecentView.g(this.hCR).mG(this.hCR.getLoadCount());
        }
        this.hfb.clear();
        this.hCW.clear();
        if (??? == null) {
          break;
        }
        if (this.hCR.getSceneFactory() != null)
        {
          LocalUsageInfo localLocalUsageInfo1 = this.hCR.getSceneFactory().anx();
          ??? = ((List)???).iterator();
          if (!((Iterator)???).hasNext()) {
            break;
          }
          LocalUsageInfo localLocalUsageInfo2 = (LocalUsageInfo)((Iterator)???).next();
          if ((localLocalUsageInfo1 != null) && (localLocalUsageInfo2.username.equals(localLocalUsageInfo1.username)) && (localLocalUsageInfo2.fJy == localLocalUsageInfo1.fJy)) {
            continue;
          }
          if (this.hfb.size() < this.hCR.getShowCount()) {
            this.hfb.add(new a(localLocalUsageInfo2));
          }
          if (BaseAppBrandRecentView.h(this.hCR)) {
            this.hCW.add(new a(localLocalUsageInfo2));
          }
          y.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", new Object[] { localLocalUsageInfo2.username, localLocalUsageInfo2.nickname, localLocalUsageInfo2.fJX, localLocalUsageInfo2.fJY, localLocalUsageInfo2.appId, Integer.valueOf(localLocalUsageInfo2.fJy), this.hCR.hrp });
        }
      }
      Object localObject3 = null;
    }
    this.hCR.aE(this.hfb);
    y.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", new Object[] { this.hCR.getType(), Integer.valueOf(BaseAppBrandRecentView.b(this.hCR).size()), Integer.valueOf(BaseAppBrandRecentView.i(this.hCR).size()), this.hCR.hrp });
    ai.d(new BaseAppBrandRecentView.d.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.d
 * JD-Core Version:    0.7.0.1
 */