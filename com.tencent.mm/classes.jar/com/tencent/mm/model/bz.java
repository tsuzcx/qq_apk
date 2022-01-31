package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bz
  implements com.tencent.mm.ai.e
{
  private Map<String, List<a>> fnV;
  private Map<String, List<a>> fnW;
  private Map<String, List<o>> fnX;
  private Map<String, n> fnY;
  
  public bz()
  {
    AppMethodBeat.i(59932);
    this.fnV = new HashMap();
    this.fnW = new HashMap();
    this.fnX = new HashMap();
    this.fnY = new ConcurrentHashMap();
    AppMethodBeat.o(59932);
  }
  
  @Deprecated
  private void a(String paramString, e.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(59940);
    if (paramBoolean) {}
    synchronized (this.fnW)
    {
      paramString = (List)???.get(paramString);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        ab.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(59940);
        return;
        ??? = this.fnV;
      }
    }
    ab.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(paramString.size()) });
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      ((a)paramString.next()).a(parama);
    }
    AppMethodBeat.o(59940);
  }
  
  public final void a(e.c paramc) {}
  
  @Deprecated
  public final void a(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(59933);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(59933);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.fnW)
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
            AppMethodBeat.o(59933);
          }
          ??? = this.fnV;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final void a(String paramString, n paramn)
  {
    AppMethodBeat.i(59937);
    if ((bo.isNullOrNil(paramString)) || (paramn == null))
    {
      AppMethodBeat.o(59937);
      return;
    }
    if (this.fnY.containsKey(paramString)) {
      ab.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", new Object[] { paramString, bo.dtY() });
    }
    this.fnY.put(paramString, paramn);
    AppMethodBeat.o(59937);
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(59935);
    if ((bo.isNullOrNil(paramString)) || (paramo == null))
    {
      AppMethodBeat.o(59935);
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.fnX)
      {
        localObject = (List)this.fnX.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          this.fnX.put(paramString, localObject);
          paramString = (String)localObject;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(59939);
    Object localObject1 = parama.eyJ;
    switch (((cm)localObject1).nqW)
    {
    default: 
      ab.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", new Object[] { Integer.valueOf(((cm)localObject1).nqW) });
      AppMethodBeat.o(59939);
      return null;
    case 10001: 
      a(aa.a(((cm)localObject1).woP), parama, false);
      com.tencent.mm.plugin.report.e.qrI.kvStat(10395, String.valueOf(((cm)localObject1).pIG));
      AppMethodBeat.o(59939);
      return null;
    }
    Object localObject2 = aa.a(((cm)localObject1).woR);
    if (bo.isNullOrNil((String)localObject2))
    {
      ab.e("MicroMsg.SysCmdMsgExtension", "null msg content");
      AppMethodBeat.o(59939);
      return null;
    }
    String str;
    if (((String)localObject2).startsWith("~SEMI_XML~"))
    {
      localObject1 = be.apC((String)localObject2);
      if (localObject1 == null)
      {
        ab.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject2 });
        AppMethodBeat.o(59939);
        return null;
      }
      str = "brand_service";
      ab.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", new Object[] { localObject2, str });
      if (str != null) {
        a(str, parama, true);
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.fnX)
        {
          localObject2 = (List)this.fnX.get(str);
          if ((localObject2 == null) || (((List)localObject2).isEmpty()))
          {
            ab.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            localObject2 = (n)this.fnY.get(str);
            if (localObject2 == null) {
              break label601;
            }
            parama = ((n)localObject2).a(str, (Map)localObject1, parama);
            AppMethodBeat.o(59939);
            return parama;
            int i = ((String)localObject2).indexOf("<sysmsg");
            if (i != -1)
            {
              localObject1 = ((String)localObject2).substring(i);
              ab.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = br.F((String)localObject1, "sysmsg");
              if (localObject1 == null)
              {
                ab.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(59939);
                return null;
              }
              str = (String)((Map)localObject1).get(".sysmsg.$type");
              break;
            }
            i = ((String)localObject2).indexOf("<appmsg");
            if (i != -1)
            {
              ab.i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
              localObject1 = ((String)localObject2).substring(i);
              ab.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = br.F((String)localObject1, "appmsg");
              if (localObject1 == null)
              {
                ab.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(59939);
                return null;
              }
              str = (String)((Map)localObject1).get(".appmsg.title");
              break;
            }
            ab.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
            AppMethodBeat.o(59939);
            return null;
          }
        }
        ab.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        try
        {
          ??? = ((List)localObject2).iterator();
          while (((Iterator)???).hasNext()) {
            ((o)((Iterator)???).next()).onNewXmlReceived(str, (Map)localObject1, parama);
          }
        }
        finally
        {
          AppMethodBeat.o(59939);
        }
      }
      label601:
      ab.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", new Object[] { str });
    }
    AppMethodBeat.o(59939);
    return null;
  }
  
  @Deprecated
  public final void b(String paramString, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(59934);
    if ((bo.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(59934);
      return;
    }
    if (paramBoolean) {}
    synchronized (this.fnW)
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
          AppMethodBeat.o(59934);
        }
        ??? = this.fnV;
      }
    }
    AppMethodBeat.o(59934);
  }
  
  public final void b(String paramString, n arg2)
  {
    AppMethodBeat.i(59938);
    if ((bo.isNullOrNil(paramString)) || (??? == null))
    {
      AppMethodBeat.o(59938);
      return;
    }
    synchronized (this.fnY)
    {
      this.fnY.remove(paramString);
      AppMethodBeat.o(59938);
      return;
    }
  }
  
  public final void b(String paramString, o paramo)
  {
    AppMethodBeat.i(59936);
    if ((bo.isNullOrNil(paramString)) || (paramo == null))
    {
      AppMethodBeat.o(59936);
      return;
    }
    synchronized (this.fnX)
    {
      paramString = (List)this.fnX.get(paramString);
      if (paramString == null) {}
    }
    AppMethodBeat.o(59936);
  }
  
  public static abstract interface a
  {
    public abstract void a(e.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bz
 * JD-Core Version:    0.7.0.1
 */