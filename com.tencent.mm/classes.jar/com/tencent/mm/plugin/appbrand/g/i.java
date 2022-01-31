package com.tencent.mm.plugin.appbrand.g;

import android.os.HandlerThread;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

 enum i
{
  private static final a fYE = new a();
  
  static List<AppBrandRecentTaskInfo> afN()
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject;
    if (e.aaZ() != null)
    {
      localObject = e.aaZ().adt();
      if (!bk.dk((List)localObject)) {
        localLinkedList.addAll((Collection)localObject);
      }
    }
    if (com.tencent.mm.modelappbrand.a.Jj())
    {
      localObject = localLinkedList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((AppBrandRecentTaskInfo)((Iterator)localObject).next()).ZH()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    return localLinkedList;
  }
  
  static void e(j.a parama)
  {
    if (e.aaZ() != null) {
      e.aaZ().c(parama);
    }
  }
  
  static void f(j.a parama)
  {
    if (e.aaZ() != null) {
      e.aaZ().d(parama);
    }
  }
  
  static void onCreate()
  {
    r.aem().a(fYE, c.DS().mnU.getLooper());
  }
  
  static void onDestroy()
  {
    r.aem().d(fYE);
  }
  
  static AppBrandRecentTaskInfo tm(String paramString)
  {
    if (e.aaZ() == null) {}
    do
    {
      return null;
      paramString = e.aaZ().rI(paramString);
    } while ((paramString == null) || ((paramString.ZH()) && (com.tencent.mm.modelappbrand.a.Jj())));
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.i
 * JD-Core Version:    0.7.0.1
 */