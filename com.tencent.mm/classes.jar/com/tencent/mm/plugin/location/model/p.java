package com.tencent.mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ae;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class p
  extends com.tencent.mm.model.e
{
  private static double ajN(String paramString)
  {
    AppMethodBeat.i(55755);
    if (paramString == null)
    {
      AppMethodBeat.o(55755);
      return 0.0D;
    }
    double d = bs.getDouble(paramString, 0.0D);
    AppMethodBeat.o(55755);
    return d;
  }
  
  private static String dZ(List<String> paramList)
  {
    AppMethodBeat.i(55756);
    List localList = n.cWV().cXc();
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
          if (!paramList.equals(u.axw()))
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
  
  private static String ea(List<String> paramList)
  {
    AppMethodBeat.i(55757);
    Object localObject = n.cWV().cXc();
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
          if (!paramList.equals(u.axw()))
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
  
  public final f.b b(f.a parama)
  {
    AppMethodBeat.i(55754);
    Object localObject3 = parama.fXi;
    if (localObject3 == null)
    {
      ac.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
      AppMethodBeat.o(55754);
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = z.a(((cu)localObject3).DPT);
    Object localObject2 = z.a(((cu)localObject3).DPU);
    Object localObject4;
    String str;
    double d1;
    double d2;
    int i;
    if (((String)g.agR().agA().get(2, null)).equals(localObject1))
    {
      parama = (f.a)localObject2;
      localObject3 = z.a(((cu)localObject3).DPV);
      ac.d("MicroMsg.TrackMsgExtension", "cmd ".concat(String.valueOf(localObject3)));
      localObject3 = bv.L((String)localObject3, "sysmsg");
      if (localObject3 != null) {
        try
        {
          localObject4 = new StringBuffer();
          ((StringBuffer)localObject4).append("talk  " + parama + "\r\n");
          ((StringBuffer)localObject4).append("from fromUser " + (String)localObject1 + "\r\n");
          ((StringBuffer)localObject4).append("from toUser " + (String)localObject2 + "\r\n");
          str = (String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
          d1 = ajN((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
          ((StringBuffer)localObject4).append("lat " + d1 + "\r\n");
          d2 = ajN((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
          ((StringBuffer)localObject4).append("lng " + d2 + "\r\n");
          i = bs.getInt((String)((Map)localObject3).get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0);
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
            if (bs.isNullOrNil((String)localObject1)) {
              break label491;
            }
            i += 1;
            localLinkedList.add(localObject1);
          }
          AppMethodBeat.o(55754);
        }
        catch (Exception parama)
        {
          ac.printErrStackTrace("MicroMsg.TrackMsgExtension", parama, "", new Object[0]);
        }
      }
    }
    for (;;)
    {
      return null;
      parama = (f.a)localObject1;
      break;
      localObject1 = Integer.valueOf(i);
      break label386;
      label491:
      ((StringBuffer)localObject4).append("userNameList size " + localLinkedList.size() + "\r\n");
      ac.i("MicroMsg.TrackMsgExtension", "xml : " + ((StringBuffer)localObject4).toString());
      localObject1 = null;
      localObject3 = null;
      localObject2 = localObject3;
      if (parama.equals(n.cWV().tYc))
      {
        localObject4 = dZ(localLinkedList);
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (bs.isNullOrNil((String)localObject4))
        {
          localObject2 = ea(localLinkedList);
          localObject1 = localObject4;
        }
      }
      n.cWW().a(parama, localLinkedList, d1, d2, str, (String)localObject1, (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.p
 * JD-Core Version:    0.7.0.1
 */