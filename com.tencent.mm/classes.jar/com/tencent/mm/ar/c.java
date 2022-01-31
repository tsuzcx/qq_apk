package com.tencent.mm.ar;

import android.database.Cursor;
import android.os.HandlerThread;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.w;
import com.tencent.mm.cg.h;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aji;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

final class c
  implements ao.b
{
  f<String, Integer> fCL;
  Map<String, ao.b.a> fCM;
  Queue<aji> fCN;
  Queue<a> fCO;
  long fCP;
  final int fCQ;
  final int fCR;
  ap fCS;
  final ap fCT;
  private long frA;
  boolean frp;
  
  c()
  {
    AppMethodBeat.i(16478);
    this.frp = false;
    this.fCL = new com.tencent.mm.memory.a.c(200);
    this.fCM = new HashMap();
    this.fCN = new LinkedList();
    this.fCO = new LinkedList();
    this.fCP = 0L;
    this.fCQ = 500;
    this.fCR = 10000;
    this.frA = 0L;
    this.fCS = new ap(aw.RO().oNc.getLooper(), new c.2(this), false);
    this.fCT = new ap(aw.RO().oNc.getLooper(), new c.7(this), true);
    AppMethodBeat.o(16478);
  }
  
  private static boolean aN(String paramString1, String paramString2)
  {
    AppMethodBeat.i(16484);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(16484);
      return false;
    }
    Object localObject = r.Zn();
    String str = r.Zo();
    if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
    {
      ab.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      AppMethodBeat.o(16484);
      return false;
    }
    localObject = new a();
    ((a)localObject).username = paramString1;
    ((a)localObject).fnu = bo.nullAsNil(paramString2);
    ((a)localObject).fCI = bo.aoy();
    boolean bool = d.ahd().a((a)localObject);
    AppMethodBeat.o(16484);
    return bool;
  }
  
  private void aha()
  {
    AppMethodBeat.i(16485);
    Object localObject1 = d.ahd();
    long l = this.fCP;
    Cursor localCursor = ((b)localObject1).fnw.a("select getcontactinfov2.username,getcontactinfov2.inserttime,getcontactinfov2.type,getcontactinfov2.lastgettime,getcontactinfov2.reserved1,getcontactinfov2.reserved2,getcontactinfov2.reserved3,getcontactinfov2.reserved4 from getcontactinfov2 where inserttime> ?  order by inserttime asc limit ?", new String[] { String.valueOf(l), "80" }, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(16485);
      return;
    }
    int i = localCursor.getCount();
    ab.i("MicroMsg.GetContactService", "getFromDb count:%d", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      localCursor.close();
      AppMethodBeat.o(16485);
      return;
    }
    Object localObject2 = new LinkedList();
    localObject1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    LinkedList localLinkedList1 = new LinkedList();
    Object localObject3;
    Object localObject4;
    if (localCursor.moveToNext())
    {
      Object localObject6 = new a();
      ((a)localObject6).username = localCursor.getString(0);
      ((a)localObject6).fCI = localCursor.getLong(1);
      ((a)localObject6).type = localCursor.getInt(2);
      ((a)localObject6).fCJ = localCursor.getInt(3);
      ((a)localObject6).fns = localCursor.getInt(4);
      ((a)localObject6).fCK = localCursor.getInt(5);
      ((a)localObject6).fnu = localCursor.getString(6);
      ((a)localObject6).fnv = localCursor.getString(7);
      localObject3 = ((a)localObject6).getUsername();
      localObject4 = bo.nullAsNil(((a)localObject6).agY());
      i = bo.g(Integer.valueOf(((a)localObject6).fCK));
      Object localObject5 = bo.nullAsNil(((a)localObject6).agZ());
      this.fCP = ((a)localObject6).fCI;
      localObject6 = (String)localObject3 + "#" + (String)localObject4;
      int j = bo.a((Integer)this.fCL.Y(localObject6), 0);
      if (j < 3)
      {
        this.fCL.f(localObject6, Integer.valueOf(j + 1));
        if (t.nK((String)localObject3))
        {
          localObject5 = new aji();
          ((LinkedList)localObject2).add(new bwc().aoF((String)localObject3));
          ((LinkedList)localObject1).add(new bwc().aoF((String)localObject4));
          ((aji)localObject5).wou = ((LinkedList)localObject2);
          ((aji)localObject5).xaP = ((LinkedList)localObject1);
          this.fCN.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ab.i("MicroMsg.GetContactService", "getFromDb this is openRoom now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.fCN.size()), Integer.valueOf(((aji)localObject5).wou.size()), localObject3 });
        }
      }
      for (;;)
      {
        if (((LinkedList)localObject2).size() < 20)
        {
          localObject4 = localObject1;
          localObject3 = localObject2;
          if (!localCursor.isLast()) {}
        }
        else
        {
          localObject5 = new aji();
          ((aji)localObject5).wou = ((LinkedList)localObject2);
          ((aji)localObject5).xaL = ((LinkedList)localObject2).size();
          ((aji)localObject5).xaP = ((LinkedList)localObject1);
          ((aji)localObject5).xaO = ((LinkedList)localObject1).size();
          this.fCN.add(localObject5);
          localObject3 = new LinkedList();
          localObject4 = new LinkedList();
          ab.i("MicroMsg.GetContactService", "getFromDb now reqlist size:%d , this req usr count:%d", new Object[] { Integer.valueOf(this.fCN.size()), Integer.valueOf(((aji)localObject5).wou.size()) });
        }
        localObject1 = localObject4;
        localObject2 = localObject3;
        break;
        if (ad.arf((String)localObject3))
        {
          localObject5 = new aji();
          ((LinkedList)localObject2).add(new bwc().aoF((String)localObject3));
          ((LinkedList)localObject1).add(new bwc().aoF((String)localObject4));
          ((aji)localObject5).wou = ((LinkedList)localObject2);
          ((aji)localObject5).xaP = ((LinkedList)localObject1);
          this.fCN.add(localObject5);
          localObject2 = new LinkedList();
          localObject1 = new LinkedList();
          ab.i("MicroMsg.GetContactService", "getFromDb this is isOpenIM now reqlist size:%d , this req usr count:%d usr %s", new Object[] { Integer.valueOf(this.fCN.size()), Integer.valueOf(((aji)localObject5).wou.size()), localObject3 });
        }
        else if (i == 1)
        {
          localLinkedList2.add(new Pair(new bwc().aoF((String)localObject3), new bwc().aoF((String)localObject5)));
          ab.i("MicroMsg.GetContactService", "getFromDb add user:%s scene:%s ticket:%s", new Object[] { localObject3, Integer.valueOf(i), localObject5 });
        }
        else
        {
          ((LinkedList)localObject2).add(new bwc().aoF((String)localObject3));
          ((LinkedList)localObject1).add(new bwc().aoF((String)localObject4));
          ab.i("MicroMsg.GetContactService", "getFromDb add user:%s room:%s", new Object[] { localObject3, localObject4 });
          continue;
          localLinkedList1.add(localObject3);
          I((String)localObject3, false);
        }
      }
    }
    localCursor.close();
    localObject1 = localLinkedList2.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Pair)((Iterator)localObject1).next();
      localObject3 = new aji();
      localObject4 = new LinkedList();
      ((LinkedList)localObject4).add(((Pair)localObject2).first);
      ((aji)localObject3).wou = ((LinkedList)localObject4);
      ((aji)localObject3).xaL = ((LinkedList)localObject4).size();
      ((aji)localObject3).xaQ = 1;
      ((aji)localObject3).xaR = ((bwc)((Pair)localObject2).second);
      this.fCN.add(localObject3);
    }
    localLinkedList2.clear();
    i = 0;
    while (i < localLinkedList1.size())
    {
      localObject1 = (String)localLinkedList1.get(i);
      boolean bool1 = t.lA((String)localObject1);
      ab.w("MicroMsg.GetContactService", "getFromDb try getContact Too much room usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool1) {
        d.ahd().sT((String)localObject1);
      }
      boolean bool2 = t.nL((String)localObject1);
      ab.w("MicroMsg.GetContactService", "getFromDb try getContact Too much biz usr:%s; remove from table:%s ", new Object[] { localObject1, Boolean.valueOf(bool1) });
      if (bool2)
      {
        d.ahd().sT((String)localObject1);
        e.qrI.idkeyStat(832L, 3L, 1L, false);
      }
      i += 1;
    }
    AppMethodBeat.o(16485);
  }
  
  final void I(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(16486);
    al.d(new c.3(this, paramString, paramBoolean));
    AppMethodBeat.o(16486);
  }
  
  public final void a(String paramString1, String paramString2, ao.b.a parama)
  {
    AppMethodBeat.i(16482);
    ab.i("MicroMsg.GetContactService", "dkverify getNow :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bo.dtY());
    if (aN(paramString1, paramString2))
    {
      this.fCM.put(paramString1, parama);
      this.fCS.ag(0L, 0L);
    }
    AppMethodBeat.o(16482);
  }
  
  final void ahb()
  {
    for (;;)
    {
      long l;
      try
      {
        AppMethodBeat.i(16487);
        if (com.tencent.mm.plugin.subapp.b.gmP.BV())
        {
          ab.w("MicroMsg.GetContactService", "tryStartNetscene need init , never get contact");
          AppMethodBeat.o(16487);
          return;
        }
        l = bo.aoy();
        if ((this.frp) && (l - this.frA > 600000L))
        {
          ab.w("MicroMsg.GetContactService", "tryStartNetscene Not Callback too long:%d . Force Run Now", new Object[] { Long.valueOf(l - this.frA) });
          this.frp = false;
        }
        if (this.frp)
        {
          ab.i("MicroMsg.GetContactService", "tryStartNetscene netSceneRunning: " + this.frp + " ret");
          AppMethodBeat.o(16487);
          continue;
        }
        localObject3 = (aji)this.fCN.poll();
      }
      finally {}
      Object localObject2 = localObject3;
      if (localObject3 == null)
      {
        aha();
        localObject3 = (aji)this.fCN.poll();
        if ((localObject3 != null) && (((aji)localObject3).wou != null))
        {
          localObject2 = localObject3;
          if (((aji)localObject3).wou.size() != 0) {}
        }
        else
        {
          ab.i("MicroMsg.GetContactService", "tryStartNetscene Not any more contact.");
          AppMethodBeat.o(16487);
          continue;
        }
      }
      this.frA = l;
      this.frp = true;
      Object localObject3 = new LinkedList();
      Object localObject4 = new LinkedList();
      Object localObject5 = ((aji)localObject2).wou.iterator();
      Object localObject6;
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = aa.a((bwc)((Iterator)localObject5).next());
        if (t.nK((String)localObject6)) {
          ((LinkedList)localObject3).add(localObject6);
        }
        if (ad.arf((String)localObject6)) {
          ((LinkedList)localObject4).add(localObject6);
        }
      }
      if (((LinkedList)localObject3).size() > 0)
      {
        localObject2 = (String)((LinkedList)localObject3).get(0);
        if (t.nK((String)localObject2)) {
          com.tencent.mm.roomsdk.a.b.aoI((String)localObject2).kT((String)localObject2).d(new c.4(this, (String)localObject2)).drn();
        }
        AppMethodBeat.o(16487);
      }
      else if (((LinkedList)localObject4).size() > 0)
      {
        localObject5 = (String)((LinkedList)localObject4).get(0);
        localObject6 = new anb();
        ((anb)localObject6).gfL = ((String)localObject5);
        localObject4 = "";
        localObject3 = localObject4;
        if (((aji)localObject2).xaP != null)
        {
          localObject3 = localObject4;
          if (((aji)localObject2).xaP.size() > 0) {
            localObject3 = aa.a((bwc)((aji)localObject2).xaP.get(0));
          }
        }
        ((anb)localObject6).gfK = ((String)localObject3);
        localObject2 = new b.a();
        ((b.a)localObject2).fsX = ((com.tencent.mm.bv.a)localObject6);
        ((b.a)localObject2).fsY = new anc();
        ((b.a)localObject2).uri = "/cgi-bin/micromsg-bin/getopenimcontact";
        ((b.a)localObject2).funcId = 881;
        ab.i("MicroMsg.GetContactService", "request roomName %s userOpenImname %s", new Object[] { localObject3, localObject5 });
        w.a(((b.a)localObject2).ado(), new c.5(this, (String)localObject5), true);
        AppMethodBeat.o(16487);
      }
      else
      {
        localObject3 = new b.a();
        ((b.a)localObject3).fsX = ((com.tencent.mm.bv.a)localObject2);
        ((b.a)localObject3).fsY = new ajj();
        ((b.a)localObject3).uri = "/cgi-bin/micromsg-bin/getcontact";
        ((b.a)localObject3).funcId = 182;
        w.a(((b.a)localObject3).ado(), new c.6(this), true);
        AppMethodBeat.o(16487);
      }
    }
  }
  
  public final void am(String paramString1, String paramString2)
  {
    AppMethodBeat.i(16480);
    ab.i("MicroMsg.GetContactService", "dkverify add Contact :" + paramString1 + " chatroom: " + paramString2 + " stack:" + bo.dtY());
    if (aN(paramString1, paramString2)) {
      this.fCS.ag(500L, 500L);
    }
    AppMethodBeat.o(16480);
  }
  
  public final void an(String paramString1, String paramString2)
  {
    boolean bool = false;
    AppMethodBeat.i(16481);
    if (bo.isNullOrNil(paramString1)) {}
    for (;;)
    {
      if (bool) {
        this.fCS.ag(500L, 500L);
      }
      AppMethodBeat.o(16481);
      return;
      Object localObject = r.Zn();
      String str = r.Zo();
      if ((paramString1.equals(localObject)) || (paramString1.equals(str)))
      {
        ab.i("MicroMsg.GetContactService", "addToStg username: " + paramString1 + " equal to user: " + (String)localObject + " alias: " + str + " ret");
      }
      else
      {
        localObject = new a();
        ((a)localObject).username = paramString1;
        ((a)localObject).fnv = bo.nullAsNil(paramString2);
        ((a)localObject).fCK = bo.g(Integer.valueOf(1));
        ((a)localObject).fCI = bo.aoy();
        bool = d.ahd().a((a)localObject);
      }
    }
  }
  
  public final void pl(String paramString)
  {
    AppMethodBeat.i(16479);
    this.fCM.remove(paramString);
    AppMethodBeat.o(16479);
  }
  
  public final void pm(String paramString)
  {
    AppMethodBeat.i(16483);
    aw.RO().ac(new c.1(this, paramString));
    AppMethodBeat.o(16483);
  }
  
  final class a
  {
    int errCode;
    String errMsg;
    int errType;
    ajj fDb;
    int fDc = 0;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ar.c
 * JD-Core Version:    0.7.0.1
 */