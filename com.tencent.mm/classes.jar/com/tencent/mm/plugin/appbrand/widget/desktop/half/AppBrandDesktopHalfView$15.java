package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.recentview.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class AppBrandDesktopHalfView$15
  implements Runnable
{
  AppBrandDesktopHalfView$15(AppBrandDesktopHalfView paramAppBrandDesktopHalfView) {}
  
  public final void run()
  {
    for (;;)
    {
      long l;
      Object localObject2;
      Object localObject3;
      int i;
      Object localObject4;
      Object localObject5;
      Object localObject6;
      try
      {
        l = System.currentTimeMillis();
        localObject2 = AppBrandDesktopHalfView.d(this.hrR).getPreviewList();
        Object localObject1 = AppBrandDesktopHalfView.c(this.hrR).getPreviewList();
        localObject3 = new ArrayList();
        ((List)localObject3).addAll((Collection)localObject2);
        ((List)localObject3).addAll((Collection)localObject1);
        localObject1 = new HashMap();
        i = 0;
        if (i >= ((List)localObject3).size()) {
          break label667;
        }
        localObject4 = (a)((List)localObject3).get(i);
        if ((localObject4 == null) || (((a)localObject4).hqw == null) || (bk.bl(((a)localObject4).hqw.appId)) || (bk.bl(((a)localObject4).hqw.nickname))) {
          break label1442;
        }
        if (i >= ((List)localObject2).size()) {
          break label1449;
        }
        j = 2;
        int k;
        if (i < ((List)localObject2).size())
        {
          k = i - 1;
          y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", new Object[] { ((a)localObject4).hqw.nickname, Integer.valueOf(j), Integer.valueOf(k) });
          localObject5 = ((a)localObject4).hqw.appId + "," + ((a)localObject4).hqw.fJy + "," + j + "," + k;
          if (((Map)localObject1).containsKey(((a)localObject4).hqw.nickname))
          {
            y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", new Object[] { ((a)localObject4).hqw.nickname });
            localObject6 = (Map)((Map)localObject1).get(((a)localObject4).hqw.nickname);
            if (!((Map)localObject6).containsKey(localObject5)) {
              ((Map)localObject6).put(localObject5, localObject4);
            }
            if (!bk.bl(((a)localObject4).hqw.fJX)) {
              break label458;
            }
            y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
            break label1442;
          }
        }
        else
        {
          k = i - 1 - ((List)localObject2).size();
          continue;
        }
        y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", new Object[] { ((a)localObject4).hqw.nickname });
        localObject6 = new HashMap();
        ((Map)localObject6).put(localObject5, localObject4);
        ((Map)localObject1).put(((a)localObject4).hqw.nickname, localObject6);
        continue;
        if (!((a)localObject4).hqw.nickname.equals(((a)localObject4).hqw.fJX)) {
          break label516;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.AppBrandDesktopHalfView", localException, "alvinluo checkReportNameDuplicated", new Object[0]);
        return;
      }
      label458:
      y.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", new Object[] { ((a)localObject4).hqw.nickname, ((a)localObject4).hqw.fJX });
      break label1442;
      label516:
      if (localException.containsKey(((a)localObject4).hqw.fJX))
      {
        y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", new Object[] { ((a)localObject4).hqw.fJX });
        localObject6 = (Map)localException.get(((a)localObject4).hqw.fJX);
        if (!((Map)localObject6).containsKey(localObject5)) {
          ((Map)localObject6).put(localObject5, localObject4);
        }
      }
      else
      {
        y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", new Object[] { ((a)localObject4).hqw.fJX });
        localObject6 = new HashMap();
        ((Map)localObject6).put(localObject5, localObject4);
        localException.put(((a)localObject4).hqw.fJX, localObject6);
        break label1442;
        label667:
        localObject2 = localException.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = (Map)localException.get(localObject3);
          if ((localObject4 == null) || (((Map)localObject4).size() <= 1))
          {
            y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", new Object[] { localObject3 });
          }
          else
          {
            localObject6 = ((Map)localObject4).keySet();
            localObject5 = new HashMap();
            Iterator localIterator = ((Set)localObject6).iterator();
            Object localObject7;
            while (localIterator.hasNext())
            {
              localObject7 = (a)((Map)localObject4).get((String)localIterator.next());
              if ((localObject7 != null) && (((a)localObject7).hqw != null) && (!bk.bl(((a)localObject7).hqw.appId)) && (!((Map)localObject5).containsKey(((a)localObject7).hqw.appId))) {
                ((Map)localObject5).put(((a)localObject7).hqw.appId, localObject7);
              }
            }
            if (((Map)localObject5).size() <= 1)
            {
              y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", new Object[] { localObject3 });
            }
            else
            {
              localObject5 = new b.a((String)localObject3);
              localObject6 = ((Set)localObject6).iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (String)((Iterator)localObject6).next();
                String[] arrayOfString = ((String)localObject7).split(",");
                localIterator = arrayOfString[2];
                i = Integer.valueOf(arrayOfString[3]).intValue();
                localObject7 = (a)((Map)localObject4).get(localObject7);
                if ((localObject7 != null) && (((a)localObject7).hqw != null))
                {
                  y.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", new Object[] { ((a)localObject7).hqw.appId, ((a)localObject7).hqw.nickname, ((a)localObject7).hqw.fJX, localIterator, Integer.valueOf(i) });
                  if (((String)localObject3).equals(((a)localObject7).hqw.fJX))
                  {
                    ((b.a)localObject5).hCw.append(((a)localObject7).hqw.appId).append("#");
                    ((b.a)localObject5).hCx.append("1#");
                    ((b.a)localObject5).hCy.append(localIterator).append("#");
                    ((b.a)localObject5).hCz.append(i).append("#");
                    ((b.a)localObject5).hCA.append(((a)localObject7).hqw.cau).append("#");
                    ((b.a)localObject5).hCB.append(((a)localObject7).hqw.fJy + 1).append("#");
                  }
                  if (((String)localObject3).equals(((a)localObject7).hqw.nickname))
                  {
                    ((b.a)localObject5).hCw.append(((a)localObject7).hqw.appId).append("#");
                    ((b.a)localObject5).hCx.append("2#");
                    ((b.a)localObject5).hCy.append(localIterator).append("#");
                    ((b.a)localObject5).hCz.append(i).append("#");
                    ((b.a)localObject5).hCA.append(((a)localObject7).hqw.cau).append("#");
                    ((b.a)localObject5).hCB.append(((a)localObject7).hqw.fJy + 1).append("#");
                  }
                }
              }
              y.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", new Object[] { localObject5 });
              h.nFQ.f(15796, new Object[] { ((b.a)localObject5).hCv, ((b.a)localObject5).hCw, ((b.a)localObject5).hCx.toString(), ((b.a)localObject5).hCy.toString(), ((b.a)localObject5).hCz.toString(), ((b.a)localObject5).hCA.toString(), ((b.a)localObject5).hCB.toString() });
            }
          }
        }
        y.i("MicroMsg.AppBrandDesktopHalfView", "alvinluo computeNameDuplicatedResults cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        return;
      }
      label1442:
      i += 1;
      continue;
      label1449:
      int j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfView.15
 * JD-Core Version:    0.7.0.1
 */