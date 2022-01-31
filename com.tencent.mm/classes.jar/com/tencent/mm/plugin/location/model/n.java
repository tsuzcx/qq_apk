package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.ah.e.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Ljava.lang.String;>;
import java.util.Map;

public final class n
  extends com.tencent.mm.model.e
{
  private static double Gw(String paramString)
  {
    if (paramString == null) {
      return 0.0D;
    }
    return bk.getDouble(paramString, 0.0D);
  }
  
  private static String bH(List<String> paramList)
  {
    Object localObject = l.bdX().bee();
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    label151:
    label156:
    for (;;)
    {
      String str;
      if (paramList.hasNext())
      {
        str = (String)paramList.next();
        Iterator localIterator = ((List)localObject).iterator();
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
          break label156;
        }
        localLinkedList.add(str);
        break;
        if (localLinkedList.isEmpty())
        {
          paramList = null;
          return paramList;
        }
        i = 0;
        for (;;)
        {
          if (i >= localLinkedList.size()) {
            break label151;
          }
          localObject = (String)localLinkedList.get(i);
          paramList = (List<String>)localObject;
          if (!((String)localObject).equals(q.Gj())) {
            break;
          }
          i += 1;
        }
        return null;
      }
    }
  }
  
  private static String bI(List<String> paramList)
  {
    Object localObject = l.bdX().bee();
    LinkedList localLinkedList = new LinkedList();
    localObject = ((List)localObject).iterator();
    label151:
    label156:
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
          break label156;
        }
        localLinkedList.add(str);
        break;
        if (localLinkedList.isEmpty())
        {
          paramList = null;
          return paramList;
        }
        i = 0;
        for (;;)
        {
          if (i >= localLinkedList.size()) {
            break label151;
          }
          localObject = (String)localLinkedList.get(i);
          paramList = (List<String>)localObject;
          if (!((String)localObject).equals(q.Gj())) {
            break;
          }
          i += 1;
        }
        return null;
      }
    }
  }
  
  public final e.b b(e.a parama)
  {
    Object localObject3 = parama.dBs;
    if (localObject3 == null) {
      y.e("MicroMsg.TrackMsgExtension", "onPreAddMessage cmdAM is null");
    }
    LinkedList localLinkedList;
    Object localObject2;
    Object localObject1;
    Map localMap;
    do
    {
      return null;
      localLinkedList = new LinkedList();
      parama = aa.a(((cd)localObject3).svF);
      localObject2 = aa.a(((cd)localObject3).svG);
      if (!((String)g.DP().Dz().get(2, null)).equals(parama)) {
        break;
      }
      localObject1 = localObject2;
      localObject3 = aa.a(((cd)localObject3).svH);
      y.d("MicroMsg.TrackMsgExtension", "cmd " + (String)localObject3);
      localMap = bn.s((String)localObject3, "sysmsg");
    } while (localMap == null);
    StringBuffer localStringBuffer;
    double d1;
    double d2;
    for (;;)
    {
      int i;
      try
      {
        localStringBuffer = new StringBuffer();
        localStringBuffer.append("talk  " + (String)localObject1 + "\r\n");
        localStringBuffer.append("from fromUser " + parama + "\r\n");
        localStringBuffer.append("from toUser " + (String)localObject2 + "\r\n");
        localObject3 = (String)localMap.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.addr");
        d1 = Gw((String)localMap.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.latitude"));
        localStringBuffer.append("lat " + d1 + "\r\n");
        d2 = Gw((String)localMap.get(".sysmsg.trackmsg.trackroominfo.trackroompoi.longitude"));
        localStringBuffer.append("lng " + d2 + "\r\n");
        i = bk.getInt((String)localMap.get(".sysmsg.trackmsg.trackroominfo.timestamp"), 0);
        localStringBuffer.append("times " + i + "\r\n");
        i = 0;
        localObject2 = new StringBuilder(".sysmsg.trackmsg.trackroominfo.trackmemberlist.member");
        if (i != 0) {
          break label465;
        }
        parama = "";
        parama = parama;
        parama = (String)localMap.get(parama + ".username");
        if (bk.bl(parama)) {
          break label474;
        }
        i += 1;
        localLinkedList.add(parama);
        continue;
        localObject1 = parama;
      }
      catch (Exception parama)
      {
        y.printErrStackTrace("MicroMsg.TrackMsgExtension", parama, "", new Object[0]);
        return null;
      }
      break;
      label465:
      parama = Integer.valueOf(i);
    }
    label474:
    localStringBuffer.append("userNameList size " + localLinkedList.size() + "\r\n");
    y.i("MicroMsg.TrackMsgExtension", "xml : " + localStringBuffer.toString());
    if (((String)localObject1).equals(l.bdX().lEc))
    {
      localObject2 = bH(localLinkedList);
      if (bk.bl((String)localObject2)) {
        parama = bI(localLinkedList);
      }
    }
    for (;;)
    {
      l.bdY().a((String)localObject1, localLinkedList, d1, d2, (String)localObject3, (String)localObject2, parama);
      return null;
      parama = null;
      continue;
      parama = null;
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.model.n
 * JD-Core Version:    0.7.0.1
 */