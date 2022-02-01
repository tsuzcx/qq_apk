package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.e;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class p
  extends e
{
  private static double aNi(String paramString)
  {
    AppMethodBeat.i(55755);
    if (paramString == null)
    {
      AppMethodBeat.o(55755);
      return 0.0D;
    }
    double d = Util.getDouble(paramString, 0.0D);
    AppMethodBeat.o(55755);
    return d;
  }
  
  private static String fM(List<String> paramList)
  {
    AppMethodBeat.i(55756);
    List localList = n.eMj().eMr();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label174:
    for (;;)
    {
      String str;
      if (paramList.hasNext())
      {
        str = (String)paramList.next();
        Iterator localIterator = localList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((String)localIterator.next()).equals(str));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label174;
        }
        localLinkedList.add(str);
        break;
        if (localLinkedList.isEmpty())
        {
          AppMethodBeat.o(55756);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(com.tencent.mm.model.z.bcZ()))
          {
            AppMethodBeat.o(55756);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(55756);
        return null;
      }
    }
  }
  
  private static String fN(List<String> paramList)
  {
    AppMethodBeat.i(55757);
    Object localObject = n.eMj().eMr();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label174:
    for (;;)
    {
      String str;
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!((String)localIterator.next()).equals(str));
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label174;
        }
        localLinkedList.add(str);
        break;
        if (localLinkedList.isEmpty())
        {
          AppMethodBeat.o(55757);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(com.tencent.mm.model.z.bcZ()))
          {
            AppMethodBeat.o(55757);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(55757);
        return null;
      }
    }
  }
  
  public final h.b b(h.a parama)
  {
    AppMethodBeat.i(55754);
    Object localObject3 = parama.jQG;
    if (localObject3 == null)
    {
      Log.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(55754);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = com.tencent.mm.platformtools.z.a(((db)localObject3).RID);
    Object localObject2 = com.tencent.mm.platformtools.z.a(((db)localObject3).RIE);
    Object localObject4;
    String str;
    double d1;
    double d2;
    int i;
    if (((String)h.aHG().aHp().b(2, null)).equals(localObject1))
    {
      parama = (h.a)localObject2;
      localObject3 = com.tencent.mm.platformtools.z.a(((db)localObject3).RIF);
      Log.d("MicroMsg.TrackMsgExtension", "cmd ".concat(String.valueOf(localObject3)));
      localObject3 = XmlParser.parseXml((String)localObject3, "sysmsg", null);
      if (localObject3 != null) {
        try
        {
          localObject4 = new StringBuffer();
          ((StringBuffer)localObject4).append("talk  " + parama + "\r\n");
          ((StringBuffer)localObject4).append("from fromUser " + (String)localObject1 + "\r\n");
          ((StringBuffer)localObject4).append("from toUser " + (String)localObject2 + "\r\n");
          str = (String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
          d1 = aNi((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
          ((StringBuffer)localObject4).append("lat " + d1 + "\r\n");
          d2 = aNi((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
          ((StringBuffer)localObject4).append("lng " + d2 + "\r\n");
          i = Util.getInt((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0);
          ((StringBuffer)localObject4).append("times " + i + "\r\n");
          i = 0;
          for (;;)
          {
            localObject2 = new StringBuilder(".sysmsg.trackmsg.trackroominfo.trackmemberlist.member");
            if (i != 0) {
              break;
            }
            localObject1 = "";
            label387:
            localObject1 = localObject1;
            localObject1 = (String)((Map)localObject3).get((String)localObject1 + ".username");
            if (Util.isNullOrNil((String)localObject1)) {
              break label492;
            }
            i += 1;
            localLinkedList.add(localObject1);
          }
          AppMethodBeat.o(55754);
        }
        catch (Exception parama)
        {
          Log.printErrStackTrace("MicroMsg.TrackMsgExtension", parama, "", new Object[0]);
        }
      }
    }
    for (;;)
    {
      return null;
      parama = (h.a)localObject1;
      break;
      localObject1 = Integer.valueOf(i);
      break label387;
      label492:
      ((StringBuffer)localObject4).append("userNameList size " + localLinkedList.size() + "\r\n");
      Log.i("MicroMsg.TrackMsgExtension", "xml : " + ((StringBuffer)localObject4).toString());
      localObject1 = null;
      localObject3 = null;
      localObject2 = localObject3;
      if (parama.equals(n.eMj().uJM))
      {
        localObject4 = fM(localLinkedList);
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (Util.isNullOrNil((String)localObject4))
        {
          localObject2 = fN(localLinkedList);
          localObject1 = localObject4;
        }
      }
      n.eMk().a(parama, localLinkedList, d1, d2, str, (String)localObject1, (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.p
 * JD-Core Version:    0.7.0.1
 */