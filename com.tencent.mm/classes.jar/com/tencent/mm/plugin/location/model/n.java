package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class n
  extends com.tencent.mm.model.e
{
  private static double RZ(String paramString)
  {
    AppMethodBeat.i(113380);
    if (paramString == null)
    {
      AppMethodBeat.o(113380);
      return 0.0D;
    }
    double d = bo.getDouble(paramString, 0.0D);
    AppMethodBeat.o(113380);
    return d;
  }
  
  private static String ce(List<String> paramList)
  {
    AppMethodBeat.i(113381);
    List localList = l.bLr().bLy();
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
          AppMethodBeat.o(113381);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(r.Zn()))
          {
            AppMethodBeat.o(113381);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(113381);
        return null;
      }
    }
  }
  
  private static String cf(List<String> paramList)
  {
    AppMethodBeat.i(113382);
    Object localObject = l.bLr().bLy();
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
          AppMethodBeat.o(113382);
          return null;
        }
        i = 0;
        while (i < localLinkedList.size())
        {
          paramList = (String)localLinkedList.get(i);
          if (!paramList.equals(r.Zn()))
          {
            AppMethodBeat.o(113382);
            return paramList;
          }
          i += 1;
        }
        AppMethodBeat.o(113382);
        return null;
      }
    }
  }
  
  public final e.b b(e.a parama)
  {
    AppMethodBeat.i(113379);
    Object localObject3 = parama.eyJ;
    if (localObject3 == null)
    {
      ab.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(113379);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = aa.a(((cm)localObject3).woP);
    Object localObject2 = aa.a(((cm)localObject3).woQ);
    Object localObject4;
    String str;
    double d1;
    double d2;
    int i;
    if (((String)g.RL().Ru().get(2, null)).equals(localObject1))
    {
      parama = (e.a)localObject2;
      localObject3 = aa.a(((cm)localObject3).woR);
      ab.d("MicroMsg.TrackMsgExtension", "cmd ".concat(String.valueOf(localObject3)));
      localObject3 = br.F((String)localObject3, "sysmsg");
      if (localObject3 != null) {
        try
        {
          localObject4 = new StringBuffer();
          ((StringBuffer)localObject4).append("talk  " + parama + "\r\n");
          ((StringBuffer)localObject4).append("from fromUser " + (String)localObject1 + "\r\n");
          ((StringBuffer)localObject4).append("from toUser " + (String)localObject2 + "\r\n");
          str = (String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
          d1 = RZ((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
          ((StringBuffer)localObject4).append("lat " + d1 + "\r\n");
          d2 = RZ((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
          ((StringBuffer)localObject4).append("lng " + d2 + "\r\n");
          i = bo.getInt((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0);
          ((StringBuffer)localObject4).append("times " + i + "\r\n");
          i = 0;
          for (;;)
          {
            localObject2 = new StringBuilder(".sysmsg.trackmsg.trackroominfo.trackmemberlist.member");
            if (i != 0) {
              break;
            }
            localObject1 = "";
            label386:
            localObject1 = localObject1;
            localObject1 = (String)((Map)localObject3).get((String)localObject1 + ".username");
            if (bo.isNullOrNil((String)localObject1)) {
              break label491;
            }
            i += 1;
            localLinkedList.add(localObject1);
          }
          AppMethodBeat.o(113379);
        }
        catch (Exception parama)
        {
          ab.printErrStackTrace("MicroMsg.TrackMsgExtension", parama, "", new Object[0]);
        }
      }
    }
    for (;;)
    {
      return null;
      parama = (e.a)localObject1;
      break;
      localObject1 = Integer.valueOf(i);
      break label386;
      label491:
      ((StringBuffer)localObject4).append("userNameList size " + localLinkedList.size() + "\r\n");
      ab.i("MicroMsg.TrackMsgExtension", "xml : " + ((StringBuffer)localObject4).toString());
      localObject1 = null;
      localObject3 = null;
      localObject2 = localObject3;
      if (parama.equals(l.bLr().obp))
      {
        localObject4 = ce(localLinkedList);
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (bo.isNullOrNil((String)localObject4))
        {
          localObject2 = cf(localLinkedList);
          localObject1 = localObject4;
        }
      }
      l.bLs().a(parama, localLinkedList, d1, d2, str, (String)localObject1, (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */