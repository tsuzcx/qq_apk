package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cc
  implements f
{
  private Map<String, List<a>> hpX;
  private Map<String, List<a>> hpY;
  private Map<String, List<p>> hpZ;
  private Map<String, o> hqa;
  
  public cc()
  {
    AppMethodBeat.i(42988);
    this.hpX = new HashMap();
    this.hpY = new HashMap();
    this.hpZ = new HashMap();
    this.hqa = new ConcurrentHashMap();
    AppMethodBeat.o(42988);
  }
  
  @Deprecated
  private void a(String paramString, f.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(42996);
    if (paramBoolean) {}
    synchronized (this.hpY)
    {
      paramString = (List)???.get(paramString);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        ac.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(42996);
        return;
        ??? = this.hpX;
      }
    }
    ac.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(paramString.size()) });
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
    if ((bs.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(42989);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.hpY)
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
          ??? = this.hpX;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(42993);
    if ((bs.isNullOrNil(paramString)) || (paramo == null))
    {
      AppMethodBeat.o(42993);
      return;
    }
    if (this.hqa.containsKey(paramString)) {
      ac.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", new Object[] { paramString, bs.eWi() });
    }
    this.hqa.put(paramString, paramo);
    AppMethodBeat.o(42993);
  }
  
  public final void a(String paramString, p paramp)
  {
    AppMethodBeat.i(42991);
    if ((bs.isNullOrNil(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(42991);
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.hpZ)
      {
        localObject = (List)this.hpZ.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          this.hpZ.put(paramString, localObject);
          paramString = (String)localObject;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(42995);
    Object localObject1 = parama.fXi;
    switch (((cu)localObject1).tit)
    {
    default: 
      ac.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", new Object[] { Integer.valueOf(((cu)localObject1).tit) });
      AppMethodBeat.o(42995);
      return null;
    case 10001: 
      a(z.a(((cu)localObject1).DPT), parama, false);
      e.wTc.kvStat(10395, String.valueOf(((cu)localObject1).vTQ));
      AppMethodBeat.o(42995);
      return null;
    }
    Object localObject2 = z.a(((cu)localObject1).DPV);
    if (bs.isNullOrNil((String)localObject2))
    {
      ac.e("MicroMsg.SysCmdMsgExtension", "null msg content");
      AppMethodBeat.o(42995);
      return null;
    }
    String str;
    if (((String)localObject2).startsWith("~SEMI_XML~"))
    {
      localObject1 = bi.aLg((String)localObject2);
      if (localObject1 == null)
      {
        ac.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject2 });
        AppMethodBeat.o(42995);
        return null;
      }
      str = "brand_service";
      ac.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", new Object[] { localObject2, str });
      if (str != null) {
        a(str, parama, true);
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.hpZ)
        {
          localObject2 = (List)this.hpZ.get(str);
          if ((localObject2 == null) || (((List)localObject2).isEmpty()))
          {
            ac.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            localObject2 = (o)this.hqa.get(str);
            if (localObject2 == null) {
              break label601;
            }
            parama = ((o)localObject2).a(str, (Map)localObject1, parama);
            AppMethodBeat.o(42995);
            return parama;
            int i = ((String)localObject2).indexOf("<sysmsg");
            if (i != -1)
            {
              localObject1 = ((String)localObject2).substring(i);
              ac.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = bv.L((String)localObject1, "sysmsg");
              if (localObject1 == null)
              {
                ac.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(42995);
                return null;
              }
              str = (String)((Map)localObject1).get(".sysmsg.$type");
              break;
            }
            i = ((String)localObject2).indexOf("<appmsg");
            if (i != -1)
            {
              ac.i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
              localObject1 = ((String)localObject2).substring(i);
              ac.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = bv.L((String)localObject1, "appmsg");
              if (localObject1 == null)
              {
                ac.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(42995);
                return null;
              }
              str = (String)((Map)localObject1).get(".appmsg.title");
              break;
            }
            ac.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
            AppMethodBeat.o(42995);
            return null;
          }
        }
        ac.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        try
        {
          ??? = ((List)localObject2).iterator();
          while (((Iterator)???).hasNext()) {
            ((p)((Iterator)???).next()).onNewXmlReceived(str, (Map)localObject1, parama);
          }
        }
        finally
        {
          AppMethodBeat.o(42995);
        }
      }
      label601:
      ac.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", new Object[] { str });
    }
    AppMethodBeat.o(42995);
    return null;
  }
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(42997);
    if ((paramc == null) || (paramc.hvO == null))
    {
      AppMethodBeat.o(42997);
      return;
    }
    ac.i("MicroMsg.SysCmdMsgExtension", "delete subType:%s, msgId:%s", new Object[] { paramc.hvO, paramc.hvP });
    Object localObject2 = paramc.hvO;
    synchronized (this.hpY)
    {
      localObject2 = (List)((Map)???).get(localObject2);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        ac.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(42997);
        return;
      }
    }
    ac.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
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
    if ((bs.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(42990);
      return;
    }
    if (paramBoolean) {}
    synchronized (this.hpY)
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
        ??? = this.hpX;
      }
    }
    AppMethodBeat.o(42990);
  }
  
  public final void b(String paramString, o arg2)
  {
    AppMethodBeat.i(42994);
    if ((bs.isNullOrNil(paramString)) || (??? == null))
    {
      AppMethodBeat.o(42994);
      return;
    }
    synchronized (this.hqa)
    {
      this.hqa.remove(paramString);
      AppMethodBeat.o(42994);
      return;
    }
  }
  
  public final void b(String paramString, p paramp)
  {
    AppMethodBeat.i(42992);
    if ((bs.isNullOrNil(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(42992);
      return;
    }
    synchronized (this.hpZ)
    {
      paramString = (List)this.hpZ.get(paramString);
      if (paramString == null) {}
    }
    AppMethodBeat.o(42992);
  }
  
  public static abstract interface a
  {
    public abstract void a(f.a parama);
    
    public abstract void a(f.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.cc
 * JD-Core Version:    0.7.0.1
 */