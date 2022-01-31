package com.tencent.mm.plugin.appbrand.game.a;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.game.a.a.a;
import com.tencent.mm.plugin.appbrand.game.a.a.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class i$2
  implements j.a
{
  public final void a(String paramString, l paraml)
  {
    y.i("MicroMsg.SearchMiniGameQueryLogic", "AppBrandUsage storage change: event=%s | eventData=%s", new Object[] { paramString, paraml });
    switch (paraml.gbI)
    {
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          if (!"batch".equals(paramString)) {
            break;
          }
        } while ((paraml.obj == null) || (!(paraml.obj instanceof List)));
        paraml = (List)paraml.obj;
        paramString = new ArrayList();
        paraml = paraml.iterator();
        while (paraml.hasNext())
        {
          localObject = i.tt((String)paraml.next());
          if (localObject != null) {
            paramString.add(i.b((AppBrandRecentTaskInfo)localObject));
          }
        }
        e.abh().b(paramString, true);
        return;
        paramString = i.tt(paraml.obj.toString());
      } while (paramString == null);
      paramString = i.b(paramString);
      e.abh().a(paramString, true);
      return;
      if (!"batch".equals(paramString)) {
        break;
      }
    } while ((paraml.obj == null) || (!(paraml.obj instanceof List)));
    paraml = (List)paraml.obj;
    paramString = new ArrayList();
    paraml = paraml.iterator();
    while (paraml.hasNext())
    {
      localObject = i.tt((String)paraml.next());
      if (localObject != null)
      {
        localObject = i.b((AppBrandRecentTaskInfo)localObject);
        if (localObject != null) {
          paramString.add(((a)localObject).dzp);
        }
      }
    }
    e.abh().av(paramString);
    return;
    e.abh().Z(paraml.obj.toString(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.i.2
 * JD-Core Version:    0.7.0.1
 */