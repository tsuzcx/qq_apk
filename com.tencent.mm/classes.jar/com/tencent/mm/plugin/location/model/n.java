package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.e;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n
  extends e
{
  private static double aKd(String paramString)
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
  
  private static String iK(List<String> paramList)
  {
    AppMethodBeat.i(55756);
    List localList = SubCoreLocation.fUB().fUJ();
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
          if (!paramList.equals(z.bAM()))
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
  
  private static String iL(List<String> paramList)
  {
    AppMethodBeat.i(55757);
    Object localObject = SubCoreLocation.fUB().fUJ();
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
          if (!paramList.equals(z.bAM()))
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
  
  public final g.b b(g.a parama)
  {
    AppMethodBeat.i(55754);
    Object localObject3 = parama.mpN;
    if (localObject3 == null)
    {
      Log.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(55754);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = w.a(((dl)localObject3).YFE);
    Object localObject2 = w.a(((dl)localObject3).YFF);
    Object localObject4;
    String str;
    double d1;
    double d2;
    int i;
    if (((String)h.baE().ban().d(2, null)).equals(localObject1))
    {
      parama = (g.a)localObject2;
      localObject3 = w.a(((dl)localObject3).YFG);
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
          d1 = aKd((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
          ((StringBuffer)localObject4).append("lat " + d1 + "\r\n");
          d2 = aKd((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
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
      parama = (g.a)localObject1;
      break;
      localObject1 = Integer.valueOf(i);
      break label387;
      label492:
      ((StringBuffer)localObject4).append("userNameList size " + localLinkedList.size() + "\r\n");
      Log.i("MicroMsg.TrackMsgExtension", "xml : " + ((StringBuffer)localObject4).toString());
      localObject1 = null;
      localObject3 = null;
      localObject2 = localObject3;
      if (parama.equals(SubCoreLocation.fUB().mpr))
      {
        localObject4 = iK(localLinkedList);
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (Util.isNullOrNil((String)localObject4))
        {
          localObject2 = iL(localLinkedList);
          localObject1 = localObject4;
        }
      }
      SubCoreLocation.fUC().a(parama, localLinkedList, d1, d2, str, (String)localObject1, (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */