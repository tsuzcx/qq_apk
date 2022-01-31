package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.protocal.protobuf.bpb;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ac
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  public final com.tencent.mm.ai.b rr;
  
  public ac(int paramInt)
  {
    AppMethodBeat.i(108450);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aon();
    ((b.a)localObject).fsY = new aoo();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((b.a)localObject).funcId = 143;
    ((b.a)localObject).reqCmdId = 38;
    ((b.a)localObject).respCmdId = 1000000038;
    this.rr = ((b.a)localObject).ado();
    localObject = (aon)this.rr.fsV.fta;
    ((aon)localObject).nrS = 1;
    ((aon)localObject).xeq = paramInt;
    AppMethodBeat.o(108450);
  }
  
  private static void a(bpc parambpc)
  {
    AppMethodBeat.i(108453);
    Object localObject1 = ((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).fnw.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label42:
      if (i >= parambpc.jJu) {
        break label690;
      }
      localObject2 = (bpb)parambpc.xDi.get(i);
      ab.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((bpb)localObject2).xeq + " name:" + ((bpb)localObject2).wXb + " mem:" + ((bpb)localObject2).wQS + " wei:" + ((bpb)localObject2).xDh + " md5:" + ((bpb)localObject2).wQr);
      if (((bpb)localObject2).xeq >= 0) {
        break label279;
      }
      localObject1 = null;
      label151:
      if (localObject1 != null) {
        break label341;
      }
      ab.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i)));
    }
    label279:
    label341:
    while (((am)localObject1).gyx == 0)
    {
      i += 1;
      break label42;
      if (((Cursor)localObject1).getCount() <= 0)
      {
        ((Cursor)localObject1).close();
        localHashMap = null;
        break;
      }
      localHashMap = new HashMap();
      i = 0;
      while (i < ((Cursor)localObject1).getCount())
      {
        ((Cursor)localObject1).moveToPosition(i);
        localObject2 = new am();
        ((am)localObject2).convertFrom((Cursor)localObject1);
        localHashMap.put(Integer.valueOf(((am)localObject2).gyw), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new am();
      ((am)localObject1).gyw = ((bpb)localObject2).xeq;
      ((am)localObject1).gyD = ((bpb)localObject2).wXb;
      ((am)localObject1).gyx = ((bpb)localObject2).wQS;
      ((am)localObject1).gyy = ((bpb)localObject2).xDh;
      ((am)localObject1).gyC = ((bpb)localObject2).wQr;
      break label151;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (am)localHashMap.get(Integer.valueOf(((am)localObject1).gyw));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((am)localObject1).gyz = ((int)bo.aox());
        ((am)localObject1).gyA = ((int)bo.aox());
        ((am)localObject1).gyB = 1;
        localObject2 = (an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          ab.d("MicroMsg.QQGroupStorage", "insert: name:" + ((am)localObject1).aqK());
          ((am)localObject1).bsY = -1;
          ContentValues localContentValues = ((am)localObject1).aqI();
          if ((int)((an)localObject2).fnw.a("qqgroup", "grouopid", localContentValues) >= 0) {
            ((an)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          ab.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((am)localObject1).aqK() + " ret:" + bool);
          break;
        }
      }
      ((am)localObject2).gyB = -1;
      ab.d("MicroMsg.NetSceneGetQQGroup", ((am)localObject1).aqJ() + " " + ((am)localObject2).aqJ() + " " + ((am)localObject1).gyw);
      if (((am)localObject2).aqJ().equals(((am)localObject1).aqJ())) {
        break;
      }
      ((am)localObject1).gyA = ((int)bo.aox());
      ((am)localObject1).gyB = 1;
      ((am)localObject1).bsY = -1;
      boolean bool = ((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a((am)localObject1);
      ab.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((am)localObject1).aqK() + " ret:" + bool);
      break;
      label690:
      if (localHashMap != null)
      {
        parambpc = localHashMap.keySet().iterator();
        while (parambpc.hasNext())
        {
          localObject1 = (am)localHashMap.get(parambpc.next());
          if (((am)localObject1).gyB == 0)
          {
            localObject2 = (an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
            i = ((am)localObject1).gyw;
            ab.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((an)localObject2).fnw.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((an)localObject2).doNotify();
              bool = true;
              ab.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((am)localObject1).aqK() + " ret:" + bool);
              localObject2 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
              i = ((am)localObject1).gyw;
              ab.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((ap)localObject2).fnw.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label965;
              }
            }
            label965:
            for (bool = true;; bool = false)
            {
              ab.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((am)localObject1).aqK() + " ret:" + bool);
              break;
              bool = false;
              break label815;
            }
          }
        }
      }
      label815:
      AppMethodBeat.o(108453);
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108451);
    this.callback = paramf;
    paramf = (aon)this.rr.fsV.fta;
    if ((paramf.nrS == 1) && (((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).mU(paramf.xeq) == null))
    {
      ab.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
      AppMethodBeat.o(108451);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108451);
    return i;
  }
  
  public final int getType()
  {
    return 143;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108452);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108452);
      return;
    }
    ab.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (aon)this.rr.fsV.fta;
    Object localObject2 = (aoo)this.rr.fsW.fta;
    if (paramArrayOfByte.nrS == 0) {
      a(((aoo)localObject2).xer);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108452);
      return;
      Object localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int j = 0;
      while (j < ((aoo)localObject2).xes.jJu)
      {
        localObject3 = (boz)((aoo)localObject2).xes.xDg.get(j);
        paramInt1 = paramArrayOfByte.xeq;
        ab.v("MicroMsg.NetSceneGetQQGroup", "friend");
        paramq = new ao();
        paramq.gyE = new p(((boz)localObject3).xDc).longValue();
        com.tencent.mm.ah.b.d(paramq.gyE, 3);
        paramq.gyG = paramInt1;
        paramq.gyF = ((boz)localObject3).xDe;
        label552:
        label694:
        int i;
        if (((boz)localObject3).xDe != 0)
        {
          if ((((boz)localObject3).jJA == null) || (((boz)localObject3).jJA.equals("")))
          {
            paramq = null;
            ((List)localObject1).add(paramq);
            paramq = new j();
            paramq.dqC = ((boz)localObject3).gwP;
            paramq.dqL = ((boz)localObject3).gwT;
            paramq.province = ((boz)localObject3).gwQ;
            paramq.city = ((boz)localObject3).gwR;
            paramq.signature = ((boz)localObject3).gwS;
            paramq.username = ((boz)localObject3).jJA;
            localArrayList1.add(paramq);
            paramq = new com.tencent.mm.ah.h();
            paramq.dqB = 3;
            paramq.cM(true);
            paramq.username = ((boz)localObject3).jJA;
            paramq.fsl = ((boz)localObject3).wJq;
            paramq.fsk = ((boz)localObject3).wJr;
            localArrayList2.add(paramq);
            j += 1;
            continue;
          }
          ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(((boz)localObject3).jJA);
          if ((localad != null) && (localad.field_username.equals(((boz)localObject3).jJA)) && (com.tencent.mm.n.a.je(localad.field_type))) {
            paramq.gyF = 2;
          }
        }
        else
        {
          paramq.username = ((boz)localObject3).jJA;
          paramq.nickname = ((boz)localObject3).jKG;
          paramq.gyM = ((boz)localObject3).xDf;
          paramq.gyN = com.tencent.mm.platformtools.g.wr(((boz)localObject3).xDf);
          paramq.gyO = com.tencent.mm.platformtools.g.wq(((boz)localObject3).xDf);
          paramq.gyH = com.tencent.mm.platformtools.g.wr(((boz)localObject3).jKG);
          paramq.gyI = com.tencent.mm.platformtools.g.wq(((boz)localObject3).jKG);
          paramq.gyJ = ((boz)localObject3).xDd;
          paramq.gyK = com.tencent.mm.platformtools.g.wr(((boz)localObject3).xDd);
          paramq.gyL = com.tencent.mm.platformtools.g.wq(((boz)localObject3).xDd);
          paramInt1 = 32;
          if (bo.isNullOrNil(paramq.aqQ())) {
            break label791;
          }
          paramInt1 = paramq.aqQ().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          paramq.fsh = i;
          com.tencent.mm.plugin.c.a.asD().Zb().in(((boz)localObject3).jJA, ((boz)localObject3).wYu);
          ab.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + paramq.aqM() + "  remark: " + paramq.aqP());
          break;
          paramq.gyF = 1;
          break label552;
          label791:
          if (!bo.isNullOrNil(paramq.aqR()))
          {
            paramInt1 = paramq.aqR().charAt(0);
            break label694;
          }
          if (!bo.isNullOrNil(paramq.aqN()))
          {
            paramInt1 = paramq.aqN().charAt(0);
            break label694;
          }
          if (bo.isNullOrNil(paramq.aqO())) {
            break label694;
          }
          paramInt1 = paramq.aqO().charAt(0);
          break label694;
          label863:
          if (paramInt1 >= 65)
          {
            i = paramInt1;
            if (paramInt1 <= 90) {}
          }
          else
          {
            i = 123;
          }
        }
      }
      paramq = new HashMap();
      localObject2 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
      paramInt1 = paramArrayOfByte.xeq;
      ab.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((ap)localObject2).fnw.a((String)localObject3, null, 0);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new ao();
        ((ao)localObject3).convertFrom((Cursor)localObject2);
        paramq.put(Long.valueOf(((ao)localObject3).gyE), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ao)((Iterator)localObject1).next();
        if (paramq.containsKey(Long.valueOf(((ao)localObject2).gyE)))
        {
          localObject3 = (ao)paramq.get(Long.valueOf(((ao)localObject2).gyE));
          if (!bo.y(Long.valueOf(((ao)localObject3).gyE), Long.valueOf(((ao)localObject2).gyE))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1525;
            }
            ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((ao)localObject2).gyE, (ao)localObject2);
            paramq.remove(Long.valueOf(((ao)localObject2).gyE));
            break;
            if (!bo.y(Integer.valueOf(((ao)localObject3).gyF), Integer.valueOf(((ao)localObject2).gyF))) {
              paramInt1 = 0;
            } else if (!bo.y(Integer.valueOf(((ao)localObject3).gyG), Integer.valueOf(((ao)localObject2).gyG))) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).username, ((ao)localObject2).username)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).nickname, ((ao)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyH, ((ao)localObject2).gyH)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyI, ((ao)localObject2).gyI)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyJ, ((ao)localObject2).gyJ)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyK, ((ao)localObject2).gyK)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyL, ((ao)localObject2).gyL)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyM, ((ao)localObject2).gyM)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyN, ((ao)localObject2).gyN)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).gyO, ((ao)localObject2).gyO)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).fsf, ((ao)localObject2).fsf)) {
              paramInt1 = 0;
            } else if (!bo.y(((ao)localObject3).fsg, ((ao)localObject2).fsg)) {
              paramInt1 = 0;
            } else if (!bo.y(Integer.valueOf(((ao)localObject3).fsh), Integer.valueOf(((ao)localObject2).fsh))) {
              paramInt1 = 0;
            } else if (!bo.y(Integer.valueOf(((ao)localObject3).fsi), Integer.valueOf(((ao)localObject2).fsi))) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
          }
        }
        else
        {
          label1525:
          ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a((ao)localObject2);
        }
      }
      paramq = paramq.keySet().iterator();
      while (paramq.hasNext())
      {
        long l = ((Long)paramq.next()).longValue();
        localObject1 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        ab.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(l)));
        if (((ap)localObject1).fnw.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((ap)localObject1).b(5, (n)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).X(localArrayList1);
      o.adg().X(localArrayList2);
      paramq = new am();
      paramq.gyw = paramArrayOfByte.xeq;
      paramq.gyB = 0;
      paramq.gyA = ((int)bo.aox());
      paramq.bsY = 48;
      ((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ac
 * JD-Core Version:    0.7.0.1
 */