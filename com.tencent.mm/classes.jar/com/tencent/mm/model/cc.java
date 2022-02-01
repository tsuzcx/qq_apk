package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.b;
import com.tencent.mm.al.f.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.cs;
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

public final class cc
  implements f
{
  private Map<String, o> gPA;
  private Map<String, List<a>> gPx;
  private Map<String, List<a>> gPy;
  private Map<String, List<p>> gPz;
  
  public cc()
  {
    AppMethodBeat.i(42988);
    this.gPx = new HashMap();
    this.gPy = new HashMap();
    this.gPz = new HashMap();
    this.gPA = new ConcurrentHashMap();
    AppMethodBeat.o(42988);
  }
  
  @Deprecated
  private void a(String paramString, f.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(42996);
    if (paramBoolean) {}
    synchronized (this.gPy)
    {
      paramString = (List)???.get(paramString);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        ad.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(42996);
        return;
        ??? = this.gPx;
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
      synchronized (this.gPy)
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
          ??? = this.gPx;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final void a(String paramString, o paramo)
  {
    AppMethodBeat.i(42993);
    if ((bt.isNullOrNil(paramString)) || (paramo == null))
    {
      AppMethodBeat.o(42993);
      return;
    }
    if (this.gPA.containsKey(paramString)) {
      ad.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", new Object[] { paramString, bt.eGN() });
    }
    this.gPA.put(paramString, paramo);
    AppMethodBeat.o(42993);
  }
  
  public final void a(String paramString, p paramp)
  {
    AppMethodBeat.i(42991);
    if ((bt.isNullOrNil(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(42991);
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.gPz)
      {
        localObject = (List)this.gPz.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          this.gPz.put(paramString, localObject);
          paramString = (String)localObject;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(42995);
    Object localObject1 = parama.fTo;
    switch (((cs)localObject1).saz)
    {
    default: 
      ad.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", new Object[] { Integer.valueOf(((cs)localObject1).saz) });
      AppMethodBeat.o(42995);
      return null;
    case 10001: 
      a(z.a(((cs)localObject1).Cxx), parama, false);
      e.vIY.kvStat(10395, String.valueOf(((cs)localObject1).uKZ));
      AppMethodBeat.o(42995);
      return null;
    }
    Object localObject2 = z.a(((cs)localObject1).Cxz);
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.SysCmdMsgExtension", "null msg content");
      AppMethodBeat.o(42995);
      return null;
    }
    String str;
    if (((String)localObject2).startsWith("~SEMI_XML~"))
    {
      localObject1 = bj.aFP((String)localObject2);
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
        synchronized (this.gPz)
        {
          localObject2 = (List)this.gPz.get(str);
          if ((localObject2 == null) || (((List)localObject2).isEmpty()))
          {
            ad.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            localObject2 = (o)this.gPA.get(str);
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
              ad.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = bw.K((String)localObject1, "sysmsg");
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
              localObject1 = bw.K((String)localObject1, "appmsg");
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
            ((p)((Iterator)???).next()).onNewXmlReceived(str, (Map)localObject1, parama);
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
  
  public final void b(f.c paramc)
  {
    AppMethodBeat.i(42997);
    if ((paramc == null) || (paramc.gVp == null))
    {
      AppMethodBeat.o(42997);
      return;
    }
    ad.i("MicroMsg.SysCmdMsgExtension", "delete subType:%s, msgId:%s", new Object[] { paramc.gVp, paramc.gVq });
    Object localObject2 = paramc.gVp;
    synchronized (this.gPy)
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
    synchronized (this.gPy)
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
        ??? = this.gPx;
      }
    }
    AppMethodBeat.o(42990);
  }
  
  public final void b(String paramString, o arg2)
  {
    AppMethodBeat.i(42994);
    if ((bt.isNullOrNil(paramString)) || (??? == null))
    {
      AppMethodBeat.o(42994);
      return;
    }
    synchronized (this.gPA)
    {
      this.gPA.remove(paramString);
      AppMethodBeat.o(42994);
      return;
    }
  }
  
  public final void b(String paramString, p paramp)
  {
    AppMethodBeat.i(42992);
    if ((bt.isNullOrNil(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(42992);
      return;
    }
    synchronized (this.gPz)
    {
      paramString = (List)this.gPz.get(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.cc
 * JD-Core Version:    0.7.0.1
 */