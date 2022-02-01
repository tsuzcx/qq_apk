package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.b;
import com.tencent.mm.al.e.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cd
  implements com.tencent.mm.al.e
{
  private Map<String, List<a>> hIp;
  private Map<String, List<a>> hIq;
  private Map<String, List<q>> hIr;
  private Map<String, p> hIs;
  
  public cd()
  {
    AppMethodBeat.i(42988);
    this.hIp = new HashMap();
    this.hIq = new HashMap();
    this.hIr = new HashMap();
    this.hIs = new ConcurrentHashMap();
    AppMethodBeat.o(42988);
  }
  
  @Deprecated
  private void a(String paramString, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(42996);
    if (paramBoolean) {}
    synchronized (this.hIq)
    {
      paramString = (List)???.get(paramString);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        ad.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(42996);
        return;
        ??? = this.hIp;
      }
    }
    ad.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(paramString.size()) });
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((a)paramString.next()).a(parama);
    }
    AppMethodBeat.o(42996);
  }
  
  @Deprecated
  public final void a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(42989);
    if ((bt.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(42989);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.hIq)
      {
        localObject = (List)???.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          ???.put(paramString, localObject);
          paramString = (String)localObject;
          try
          {
            if (!paramString.contains(parama)) {
              paramString.add(parama);
            }
            return;
          }
          finally
          {
            AppMethodBeat.o(42989);
          }
          ??? = this.hIp;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final void a(String paramString, p paramp)
  {
    AppMethodBeat.i(42993);
    if ((bt.isNullOrNil(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(42993);
      return;
    }
    if (this.hIs.containsKey(paramString)) {
      ad.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", new Object[] { paramString, bt.flS() });
    }
    this.hIs.put(paramString, paramp);
    AppMethodBeat.o(42993);
  }
  
  public final void a(String paramString, q paramq)
  {
    AppMethodBeat.i(42991);
    if ((bt.isNullOrNil(paramString)) || (paramq == null))
    {
      AppMethodBeat.o(42991);
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.hIr)
      {
        localObject = (List)this.hIr.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          this.hIr.put(paramString, localObject);
          paramString = (String)localObject;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(42995);
    Object localObject1 = parama.gqE;
    switch (((cv)localObject1).ugm)
    {
    default: 
      ad.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", new Object[] { Integer.valueOf(((cv)localObject1).ugm) });
      AppMethodBeat.o(42995);
      return null;
    case 10001: 
      a(z.a(((cv)localObject1).Fvi), parama, false);
      com.tencent.mm.plugin.report.e.ygI.kvStat(10395, String.valueOf(((cv)localObject1).xbt));
      AppMethodBeat.o(42995);
      return null;
    }
    Object localObject2 = z.a(((cv)localObject1).Fvk);
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.SysCmdMsgExtension", "null msg content");
      AppMethodBeat.o(42995);
      return null;
    }
    String str;
    if (((String)localObject2).startsWith("~SEMI_XML~"))
    {
      localObject1 = bj.aQM((String)localObject2);
      if (localObject1 == null)
      {
        ad.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject2 });
        AppMethodBeat.o(42995);
        return null;
      }
      str = "brand_service";
      ad.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", new Object[] { localObject2, str });
      if (str != null) {
        a(str, parama, true);
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.hIr)
        {
          localObject2 = (List)this.hIr.get(str);
          if ((localObject2 == null) || (((List)localObject2).isEmpty()))
          {
            ad.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            localObject2 = (p)this.hIs.get(str);
            if (localObject2 == null) {
              break label601;
            }
            parama = ((p)localObject2).a(str, (Map)localObject1, parama);
            AppMethodBeat.o(42995);
            return parama;
            int i = ((String)localObject2).indexOf("<sysmsg");
            if (i != -1)
            {
              localObject1 = ((String)localObject2).substring(i);
              ad.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = bw.M((String)localObject1, "sysmsg");
              if (localObject1 == null)
              {
                ad.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(42995);
                return null;
              }
              str = (String)((Map)localObject1).get(".sysmsg.$type");
              break;
            }
            i = ((String)localObject2).indexOf("<appmsg");
            if (i != -1)
            {
              ad.i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
              localObject1 = ((String)localObject2).substring(i);
              ad.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = bw.M((String)localObject1, "appmsg");
              if (localObject1 == null)
              {
                ad.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(42995);
                return null;
              }
              str = (String)((Map)localObject1).get(".appmsg.title");
              break;
            }
            ad.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
            AppMethodBeat.o(42995);
            return null;
          }
        }
        ad.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        try
        {
          ??? = ((List)localObject2).iterator();
          while (((Iterator)???).hasNext()) {
            ((q)((Iterator)???).next()).onNewXmlReceived(str, (Map)localObject1, parama);
          }
        }
        finally
        {
          AppMethodBeat.o(42995);
        }
      }
      label601:
      ad.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", new Object[] { str });
    }
    AppMethodBeat.o(42995);
    return null;
  }
  
  public final void b(e.c paramc)
  {
    AppMethodBeat.i(42997);
    if ((paramc == null) || (paramc.hOd == null))
    {
      AppMethodBeat.o(42997);
      return;
    }
    ad.i("MicroMsg.SysCmdMsgExtension", "delete subType:%s, msgId:%s", new Object[] { paramc.hOd, paramc.hOe });
    Object localObject2 = paramc.hOd;
    synchronized (this.hIq)
    {
      localObject2 = (List)((Map)???).get(localObject2);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        ad.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(42997);
        return;
      }
    }
    ad.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
    ??? = ((List)localObject2).iterator();
    while (((Iterator)???).hasNext()) {
      ((a)((Iterator)???).next()).a(paramc);
    }
    AppMethodBeat.o(42997);
  }
  
  @Deprecated
  public final void b(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(42990);
    if ((bt.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(42990);
      return;
    }
    if (paramBoolean) {}
    synchronized (this.hIq)
    {
      paramString = (List)???.get(paramString);
      if (paramString != null)
      {
        try
        {
          paramString.remove(parama);
          return;
        }
        finally
        {
          AppMethodBeat.o(42990);
        }
        ??? = this.hIp;
      }
    }
    AppMethodBeat.o(42990);
  }
  
  public final void b(String paramString, p arg2)
  {
    AppMethodBeat.i(42994);
    if ((bt.isNullOrNil(paramString)) || (??? == null))
    {
      AppMethodBeat.o(42994);
      return;
    }
    synchronized (this.hIs)
    {
      this.hIs.remove(paramString);
      AppMethodBeat.o(42994);
      return;
    }
  }
  
  public final void b(String paramString, q paramq)
  {
    AppMethodBeat.i(42992);
    if ((bt.isNullOrNil(paramString)) || (paramq == null))
    {
      AppMethodBeat.o(42992);
      return;
    }
    synchronized (this.hIr)
    {
      paramString = (List)this.hIr.get(paramString);
      if (paramString == null) {}
    }
    AppMethodBeat.o(42992);
  }
  
  public static abstract interface a
  {
    public abstract void a(e.a parama);
    
    public abstract void a(e.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.cd
 * JD-Core Version:    0.7.0.1
 */