package com.tencent.mm.model;

import com.tencent.mm.ah.e;
import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.ah.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.ba;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bx
  implements e
{
  private Map<String, List<a>> dXQ = new HashMap();
  private Map<String, List<a>> dXR = new HashMap();
  private Map<String, List<o>> dXS = new HashMap();
  private Map<String, n> dXT = new ConcurrentHashMap();
  
  @Deprecated
  private void a(String paramString, e.a parama, boolean paramBoolean)
  {
    Map localMap;
    if (paramBoolean)
    {
      localMap = this.dXR;
      paramString = (List)localMap.get(paramString);
      if ((paramString != null) && (!paramString.isEmpty())) {
        break label52;
      }
      y.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
    }
    for (;;)
    {
      return;
      localMap = this.dXQ;
      break;
      label52:
      y.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(paramString.size()) });
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        ((a)paramString.next()).a(parama);
      }
    }
  }
  
  public final void a(e.c paramc) {}
  
  @Deprecated
  public final void a(String paramString, a parama, boolean paramBoolean)
  {
    if ((bk.bl(paramString)) || (parama == null)) {
      return;
    }
    if (paramBoolean) {}
    for (Map localMap = this.dXR;; localMap = this.dXQ)
    {
      List localList = (List)localMap.get(paramString);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new LinkedList();
        localMap.put(paramString, localObject);
      }
      if (((List)localObject).contains(parama)) {
        break;
      }
      ((List)localObject).add(parama);
      return;
    }
  }
  
  public final void a(String paramString, n paramn)
  {
    if ((bk.bl(paramString)) || (paramn == null)) {
      return;
    }
    if (this.dXT.containsKey(paramString)) {
      y.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", new Object[] { paramString, bk.csb() });
    }
    this.dXT.put(paramString, paramn);
  }
  
  public final void a(String paramString, o paramo)
  {
    if ((bk.bl(paramString)) || (paramo == null)) {
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.dXS)
      {
        localObject = (List)this.dXS.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          this.dXS.put(paramString, localObject);
          paramString = (String)localObject;
          try
          {
            if (!paramString.contains(paramo)) {
              paramString.add(paramo);
            }
            return;
          }
          finally {}
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final e.b b(e.a parama)
  {
    Object localObject1 = parama.dBs;
    String str;
    switch (((cd)localObject1).kSW)
    {
    default: 
      y.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", new Object[] { Integer.valueOf(((cd)localObject1).kSW) });
      return null;
    case 10001: 
      str = aa.a(((cd)localObject1).svF);
      aa.a(((cd)localObject1).svH);
      a(str, parama, false);
      f.nEG.aC(10395, String.valueOf(((cd)localObject1).ndp));
      return null;
    }
    Object localObject2 = aa.a(((cd)localObject1).svH);
    if (bk.bl((String)localObject2))
    {
      y.e("MicroMsg.SysCmdMsgExtension", "null msg content");
      return null;
    }
    if (((String)localObject2).startsWith("~SEMI_XML~"))
    {
      localObject1 = ba.Zx((String)localObject2);
      if (localObject1 == null)
      {
        y.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject2 });
        return null;
      }
      str = "brand_service";
      y.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", new Object[] { localObject2, str });
      if (str != null) {
        a(str, parama, true);
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.dXS)
        {
          localObject2 = (List)this.dXS.get(str);
          if ((localObject2 == null) || (((List)localObject2).isEmpty()))
          {
            y.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            localObject2 = (n)this.dXT.get(str);
            if (localObject2 == null) {
              break label555;
            }
            return ((n)localObject2).a(str, (Map)localObject1, parama);
            int i = ((String)localObject2).indexOf("<sysmsg");
            if (i != -1)
            {
              localObject1 = ((String)localObject2).substring(i);
              y.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = bn.s((String)localObject1, "sysmsg");
              if (localObject1 == null)
              {
                y.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                return null;
              }
              str = (String)((Map)localObject1).get(".sysmsg.$type");
              break;
            }
            i = ((String)localObject2).indexOf("<appmsg");
            if (i != -1)
            {
              y.i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
              localObject1 = ((String)localObject2).substring(i);
              y.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = bn.s((String)localObject1, "appmsg");
              if (localObject1 == null)
              {
                y.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                return null;
              }
              str = (String)((Map)localObject1).get(".appmsg.title");
              break;
            }
            y.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
            return null;
          }
        }
        y.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        try
        {
          ??? = ((List)localObject2).iterator();
          while (((Iterator)???).hasNext()) {
            ((o)((Iterator)???).next()).onNewXmlReceived(str, (Map)localObject1, parama);
          }
        }
        finally {}
      }
      label555:
      y.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", new Object[] { str });
    }
    return null;
  }
  
  @Deprecated
  public final void b(String paramString, a parama, boolean paramBoolean)
  {
    if ((bk.bl(paramString)) || (parama == null)) {
      return;
    }
    if (paramBoolean) {}
    for (Map localMap = this.dXR;; localMap = this.dXQ)
    {
      paramString = (List)localMap.get(paramString);
      if (paramString == null) {
        break;
      }
      paramString.remove(parama);
      return;
    }
  }
  
  public final void b(String paramString, n arg2)
  {
    if ((bk.bl(paramString)) || (??? == null)) {
      return;
    }
    synchronized (this.dXT)
    {
      this.dXT.remove(paramString);
      return;
    }
  }
  
  public final void b(String paramString, o paramo)
  {
    if ((bk.bl(paramString)) || (paramo == null)) {}
    for (;;)
    {
      return;
      synchronized (this.dXS)
      {
        paramString = (List)this.dXS.get(paramString);
        if (paramString == null) {
          continue;
        }
        try
        {
          paramString.remove(paramo);
          return;
        }
        finally {}
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(e.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bx
 * JD-Core Version:    0.7.0.1
 */