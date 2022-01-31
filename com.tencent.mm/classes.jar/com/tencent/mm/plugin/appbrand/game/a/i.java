package com.tencent.mm.plugin.appbrand.game.a;

import android.os.HandlerThread;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.game.a.a.a;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

 enum i
{
  private static j.a gaL = new i.1();
  private static j.a gaM = new i.2();
  
  private static a a(AppBrandRecentTaskInfo paramAppBrandRecentTaskInfo)
  {
    if (paramAppBrandRecentTaskInfo == null) {
      return null;
    }
    a locala = new a();
    locala.dzp = paramAppBrandRecentTaskInfo.dzp;
    locala.euK = paramAppBrandRecentTaskInfo.appId;
    locala.kVn = paramAppBrandRecentTaskInfo.appName;
    locala.kSy = paramAppBrandRecentTaskInfo.fJk;
    locala.hPY = paramAppBrandRecentTaskInfo.bFn;
    locala.fEL = paramAppBrandRecentTaskInfo.fEL;
    return locala;
  }
  
  public static List<b> agv()
  {
    if (e.abh() == null) {
      return null;
    }
    Object localObject1 = new LinkedList();
    if (e.aaZ() != null)
    {
      localObject2 = e.aaZ().adt();
      if (!bk.dk((List)localObject2)) {
        ((List)localObject1).addAll((Collection)localObject2);
      }
    }
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (!((AppBrandRecentTaskInfo)((Iterator)localObject2).next()).ZH()) {
        ((Iterator)localObject2).remove();
      }
    }
    if (!bk.dk((List)localObject1))
    {
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((List)localObject2).add(a((AppBrandRecentTaskInfo)((Iterator)localObject1).next()));
      }
      e.abh().b((List)localObject2, false);
      y.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandRecentTaskInfo convert to MiniGameStorage, size:%d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
    }
    y.i("MicroMsg.SearchMiniGameQueryLogic", "updateMiniGameList");
    return e.abh().agw();
  }
  
  public static void e(j.a parama)
  {
    if (e.abh() != null) {
      e.abh().c(parama);
    }
  }
  
  public static void f(j.a parama)
  {
    if (e.abh() != null) {
      e.abh().d(parama);
    }
  }
  
  public static void onCreate()
  {
    r.aem().a(gaL, com.tencent.mm.plugin.appbrand.v.c.DS().mnU.getLooper());
    if (e.aaZ() != null) {
      e.aaZ().c(gaM);
    }
  }
  
  public static void onDestroy()
  {
    r.aem().d(gaL);
    if (e.aaZ() != null) {
      e.aaZ().d(gaM);
    }
  }
  
  public static b tr(String paramString)
  {
    if (e.abh() != null) {
      return e.abh().tr(paramString);
    }
    return null;
  }
  
  public static AppBrandRecentTaskInfo ts(String paramString)
  {
    if (e.aaZ() == null) {
      return null;
    }
    return e.aaZ().rI(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.i
 * JD-Core Version:    0.7.0.1
 */