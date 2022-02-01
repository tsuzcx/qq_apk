package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.b;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class cj
  implements h
{
  private Map<String, List<a>> iFV;
  private Map<String, List<a>> iFW;
  private Map<String, List<q>> iFX;
  private Map<String, p> iFY;
  
  public cj()
  {
    AppMethodBeat.i(42988);
    this.iFV = new HashMap();
    this.iFW = new HashMap();
    this.iFX = new HashMap();
    this.iFY = new ConcurrentHashMap();
    AppMethodBeat.o(42988);
  }
  
  @Deprecated
  private void a(String paramString, h.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(42996);
    if (paramBoolean) {}
    synchronized (this.iFW)
    {
      paramString = (List)???.get(paramString);
      if ((paramString == null) || (paramString.isEmpty()))
      {
        Log.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(42996);
        return;
        ??? = this.iFV;
      }
    }
    Log.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(paramString.size()) });
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
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(42989);
      return;
    }
    if (paramBoolean) {}
    for (;;)
    {
      Object localObject;
      synchronized (this.iFW)
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
          ??? = this.iFV;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final void a(String paramString, p paramp)
  {
    AppMethodBeat.i(42993);
    if ((Util.isNullOrNil(paramString)) || (paramp == null))
    {
      AppMethodBeat.o(42993);
      return;
    }
    if (this.iFY.containsKey(paramString)) {
      Log.w("MicroMsg.SysCmdMsgExtension", "NewXmlConsumer for %s has exist! %s", new Object[] { paramString, Util.getStack() });
    }
    this.iFY.put(paramString, paramp);
    AppMethodBeat.o(42993);
  }
  
  public final void a(String paramString, q paramq)
  {
    AppMethodBeat.i(42991);
    if ((Util.isNullOrNil(paramString)) || (paramq == null))
    {
      AppMethodBeat.o(42991);
      return;
    }
    for (;;)
    {
      Object localObject;
      synchronized (this.iFX)
      {
        localObject = (List)this.iFX.get(paramString);
        if (localObject == null)
        {
          localObject = new LinkedList();
          this.iFX.put(paramString, localObject);
          paramString = (String)localObject;
        }
      }
      paramString = (String)localObject;
    }
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(42995);
    Object localObject1 = parama.heO;
    switch (((de)localObject1).xKb)
    {
    default: 
      Log.w("MicroMsg.SysCmdMsgExtension", "cmdAM msgType is %d, ignore, return now", new Object[] { Integer.valueOf(((de)localObject1).xKb) });
      AppMethodBeat.o(42995);
      return null;
    case 10001: 
      a(z.a(((de)localObject1).KHl), parama, false);
      e.Cxv.kvStat(10395, String.valueOf(((de)localObject1).Brn));
      AppMethodBeat.o(42995);
      return null;
    }
    Object localObject2 = z.a(((de)localObject1).KHn);
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.SysCmdMsgExtension", "null msg content");
      AppMethodBeat.o(42995);
      return null;
    }
    String str;
    if (((String)localObject2).startsWith("~SEMI_XML~"))
    {
      localObject1 = SemiXml.decode((String)localObject2);
      if (localObject1 == null)
      {
        Log.e("MicroMsg.SysCmdMsgExtension", "SemiXml values is null, msgContent %s", new Object[] { localObject2 });
        AppMethodBeat.o(42995);
        return null;
      }
      str = "brand_service";
      Log.d("MicroMsg.SysCmdMsgExtension", "recieve a syscmd_newxml %s subType %s", new Object[] { localObject2, str });
      if (str != null) {
        a(str, parama, true);
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.iFX)
        {
          localObject2 = (List)this.iFX.get(str);
          if ((localObject2 == null) || (((List)localObject2).isEmpty()))
          {
            Log.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
            localObject2 = (p)this.iFY.get(str);
            if (localObject2 == null) {
              break label603;
            }
            parama = ((p)localObject2).a(str, (Map)localObject1, parama);
            AppMethodBeat.o(42995);
            return parama;
            int i = ((String)localObject2).indexOf("<sysmsg");
            if (i != -1)
            {
              localObject1 = ((String)localObject2).substring(i);
              Log.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = XmlParser.parseXml((String)localObject1, "sysmsg", null);
              if (localObject1 == null)
              {
                Log.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(42995);
                return null;
              }
              str = (String)((Map)localObject1).get(".sysmsg.$type");
              break;
            }
            i = ((String)localObject2).indexOf("<appmsg");
            if (i != -1)
            {
              Log.i("MicroMsg.SysCmdMsgExtension", "msgContent start with <appmsg");
              localObject1 = ((String)localObject2).substring(i);
              Log.d("MicroMsg.SysCmdMsgExtension", "oneliang, msg content:%s,sub content:%s", new Object[] { localObject2, localObject1 });
              localObject1 = XmlParser.parseXml((String)localObject1, "appmsg", null);
              if (localObject1 == null)
              {
                Log.e("MicroMsg.SysCmdMsgExtension", "XmlParser values is null, msgContent %s", new Object[] { localObject2 });
                AppMethodBeat.o(42995);
                return null;
              }
              str = (String)((Map)localObject1).get(".appmsg.title");
              break;
            }
            Log.e("MicroMsg.SysCmdMsgExtension", "msgContent not start with <sysmsg or <appmsg");
            AppMethodBeat.o(42995);
            return null;
          }
        }
        Log.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
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
      label603:
      Log.e("MicroMsg.SysCmdMsgExtension", "no NewXmlConsumer to consume cmd %s!!", new Object[] { str });
    }
    AppMethodBeat.o(42995);
    return null;
  }
  
  public final void b(h.c paramc)
  {
    AppMethodBeat.i(42997);
    if ((paramc == null) || (paramc.iMe == null))
    {
      AppMethodBeat.o(42997);
      return;
    }
    Log.i("MicroMsg.SysCmdMsgExtension", "delete subType:%s, msgId:%s", new Object[] { paramc.iMe, paramc.iMf });
    Object localObject2 = paramc.iMe;
    synchronized (this.iFW)
    {
      localObject2 = (List)((Map)???).get(localObject2);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        Log.w("MicroMsg.SysCmdMsgExtension", "listener list is empty, return now");
        AppMethodBeat.o(42997);
        return;
      }
    }
    Log.i("MicroMsg.SysCmdMsgExtension", "listener list size is %d", new Object[] { Integer.valueOf(((List)localObject2).size()) });
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
    if ((Util.isNullOrNil(paramString)) || (parama == null))
    {
      AppMethodBeat.o(42990);
      return;
    }
    if (paramBoolean) {}
    synchronized (this.iFW)
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
        ??? = this.iFV;
      }
    }
    AppMethodBeat.o(42990);
  }
  
  public final void b(String paramString, p arg2)
  {
    AppMethodBeat.i(42994);
    if ((Util.isNullOrNil(paramString)) || (??? == null))
    {
      AppMethodBeat.o(42994);
      return;
    }
    synchronized (this.iFY)
    {
      this.iFY.remove(paramString);
      AppMethodBeat.o(42994);
      return;
    }
  }
  
  public final void b(String paramString, q paramq)
  {
    AppMethodBeat.i(42992);
    if ((Util.isNullOrNil(paramString)) || (paramq == null))
    {
      AppMethodBeat.o(42992);
      return;
    }
    synchronized (this.iFX)
    {
      paramString = (List)this.iFX.get(paramString);
      if (paramString == null) {}
    }
    AppMethodBeat.o(42992);
  }
  
  public static abstract interface a
  {
    public abstract void a(h.a parama);
    
    public abstract void a(h.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.cj
 * JD-Core Version:    0.7.0.1
 */