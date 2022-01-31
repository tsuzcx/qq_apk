package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.ag.i;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.protocal.c.ajh;
import com.tencent.mm.protocal.c.bgt;
import com.tencent.mm.protocal.c.bgu;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.protocal.c.bgw;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  extends com.tencent.mm.ah.m
  implements com.tencent.mm.network.k
{
  public final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  
  public ac(int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ajg();
    ((b.a)localObject).ecI = new ajh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((b.a)localObject).ecG = 143;
    ((b.a)localObject).ecJ = 38;
    ((b.a)localObject).ecK = 1000000038;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ajg)this.dmK.ecE.ecN;
    ((ajg)localObject).kTS = 1;
    ((ajg)localObject).tfR = paramInt;
  }
  
  private static void a(bgw parambgw)
  {
    Object localObject1 = ((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).dXo.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label37:
      if (i >= parambgw.hPS) {
        break label688;
      }
      localObject2 = (bgv)parambgw.tBz.get(i);
      y.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((bgv)localObject2).tfR + " name:" + ((bgv)localObject2).sYM + " mem:" + ((bgv)localObject2).sSW + " wei:" + ((bgv)localObject2).tBy + " md5:" + ((bgv)localObject2).sRE);
      if (((bgv)localObject2).tfR >= 0) {
        break label281;
      }
      localObject1 = null;
      label146:
      if (localObject1 != null) {
        break label343;
      }
      y.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:" + i);
    }
    label281:
    label343:
    while (((am)localObject1).fgP == 0)
    {
      i += 1;
      break label37;
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
        ((am)localObject2).d((Cursor)localObject1);
        localHashMap.put(Integer.valueOf(((am)localObject2).fgO), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new am();
      ((am)localObject1).fgO = ((bgv)localObject2).tfR;
      ((am)localObject1).fgV = ((bgv)localObject2).sYM;
      ((am)localObject1).fgP = ((bgv)localObject2).sSW;
      ((am)localObject1).fgQ = ((bgv)localObject2).tBy;
      ((am)localObject1).fgU = ((bgv)localObject2).sRE;
      break label146;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (am)localHashMap.get(Integer.valueOf(((am)localObject1).fgO));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((am)localObject1).fgR = ((int)bk.UX());
        ((am)localObject1).fgS = ((int)bk.UX());
        ((am)localObject1).fgT = 1;
        localObject2 = (an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          y.d("MicroMsg.QQGroupStorage", "insert: name:" + ((am)localObject1).Xg());
          ((am)localObject1).bcw = -1;
          ContentValues localContentValues = ((am)localObject1).Xe();
          if ((int)((an)localObject2).dXo.insert("qqgroup", "grouopid", localContentValues) >= 0) {
            ((an)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          y.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((am)localObject1).Xg() + " ret:" + bool);
          break;
        }
      }
      ((am)localObject2).fgT = -1;
      y.d("MicroMsg.NetSceneGetQQGroup", ((am)localObject1).Xf() + " " + ((am)localObject2).Xf() + " " + ((am)localObject1).fgO);
      if (((am)localObject2).Xf().equals(((am)localObject1).Xf())) {
        break;
      }
      ((am)localObject1).fgS = ((int)bk.UX());
      ((am)localObject1).fgT = 1;
      ((am)localObject1).bcw = -1;
      boolean bool = ((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a((am)localObject1);
      y.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((am)localObject1).Xg() + " ret:" + bool);
      break;
      label688:
      if (localHashMap != null)
      {
        parambgw = localHashMap.keySet().iterator();
        while (parambgw.hasNext())
        {
          localObject1 = (am)localHashMap.get(parambgw.next());
          if (((am)localObject1).fgT == 0)
          {
            localObject2 = (an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
            i = ((am)localObject1).fgO;
            y.d("MicroMsg.QQGroupStorage", "delete: id:" + i);
            if (((an)localObject2).dXo.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((an)localObject2).doNotify();
              bool = true;
              label818:
              y.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((am)localObject1).Xg() + " ret:" + bool);
              localObject2 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
              i = ((am)localObject1).fgO;
              y.d("MicroMsg.QQListStorage", "delete: GroupID:" + i);
              if (((ap)localObject2).dXo.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label975;
              }
            }
            label975:
            for (bool = true;; bool = false)
            {
              y.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((am)localObject1).Xg() + " ret:" + bool);
              break;
              bool = false;
              break label818;
            }
          }
        }
      }
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (ajg)this.dmK.ecE.ecN;
    if ((paramf.kTS == 1) && (((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).jZ(paramf.tfR) == null))
    {
      y.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
      return -1;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ajg)this.dmK.ecE.ecN;
    Object localObject2 = (ajh)this.dmK.ecF.ecN;
    if (paramArrayOfByte.kTS == 0) {
      a(((ajh)localObject2).tfS);
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      Object localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int j = 0;
      while (j < ((ajh)localObject2).tfT.hPS)
      {
        localObject3 = (bgt)((ajh)localObject2).tfT.tBx.get(j);
        paramInt1 = paramArrayOfByte.tfR;
        y.v("MicroMsg.NetSceneGetQQGroup", "friend");
        paramq = new ao();
        paramq.fgW = new com.tencent.mm.a.o(((bgt)localObject3).tBt).longValue();
        com.tencent.mm.ag.b.c(paramq.fgW, 3);
        paramq.fgY = paramInt1;
        paramq.fgX = ((bgt)localObject3).tBv;
        label534:
        label676:
        int i;
        if (((bgt)localObject3).tBv != 0)
        {
          if ((((bgt)localObject3).hPY == null) || (((bgt)localObject3).hPY.equals("")))
          {
            paramq = null;
            ((List)localObject1).add(paramq);
            paramq = new j();
            paramq.sex = ((bgt)localObject3).ffh;
            paramq.cCz = ((bgt)localObject3).ffl;
            paramq.cCA = ((bgt)localObject3).ffi;
            paramq.cCB = ((bgt)localObject3).ffj;
            paramq.signature = ((bgt)localObject3).ffk;
            paramq.username = ((bgt)localObject3).hPY;
            localArrayList1.add(paramq);
            paramq = new com.tencent.mm.ag.h();
            paramq.cCq = 3;
            paramq.bK(true);
            paramq.username = ((bgt)localObject3).hPY;
            paramq.ebT = ((bgt)localObject3).sLD;
            paramq.ebS = ((bgt)localObject3).sLE;
            localArrayList2.add(paramq);
            j += 1;
            continue;
          }
          ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(((bgt)localObject3).hPY);
          if ((localad != null) && (localad.field_username.equals(((bgt)localObject3).hPY)) && (com.tencent.mm.n.a.gR(localad.field_type))) {
            paramq.fgX = 2;
          }
        }
        else
        {
          paramq.username = ((bgt)localObject3).hPY;
          paramq.nickname = ((bgt)localObject3).hRf;
          paramq.fhe = ((bgt)localObject3).tBw;
          paramq.fhf = com.tencent.mm.platformtools.g.oZ(((bgt)localObject3).tBw);
          paramq.fhg = com.tencent.mm.platformtools.g.oY(((bgt)localObject3).tBw);
          paramq.fgZ = com.tencent.mm.platformtools.g.oZ(((bgt)localObject3).hRf);
          paramq.fha = com.tencent.mm.platformtools.g.oY(((bgt)localObject3).hRf);
          paramq.fhb = ((bgt)localObject3).tBu;
          paramq.fhc = com.tencent.mm.platformtools.g.oZ(((bgt)localObject3).tBu);
          paramq.fhd = com.tencent.mm.platformtools.g.oY(((bgt)localObject3).tBu);
          paramInt1 = 32;
          if (bk.bl(paramq.Xm())) {
            break label773;
          }
          paramInt1 = paramq.Xm().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label845;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          paramq.ebP = i;
          com.tencent.mm.plugin.c.a.YT().Ga().gm(((bgt)localObject3).hPY, ((bgt)localObject3).tac);
          y.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + paramq.Xi() + "  remark: " + paramq.Xl());
          break;
          paramq.fgX = 1;
          break label534;
          label773:
          if (!bk.bl(paramq.Xn()))
          {
            paramInt1 = paramq.Xn().charAt(0);
            break label676;
          }
          if (!bk.bl(paramq.Xj()))
          {
            paramInt1 = paramq.Xj().charAt(0);
            break label676;
          }
          if (bk.bl(paramq.Xk())) {
            break label676;
          }
          paramInt1 = paramq.Xk().charAt(0);
          break label676;
          label845:
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
      localObject2 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
      paramInt1 = paramArrayOfByte.tfR;
      y.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + paramInt1);
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((ap)localObject2).dXo.a((String)localObject3, null, 0);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new ao();
        ((ao)localObject3).d((Cursor)localObject2);
        paramq.put(Long.valueOf(((ao)localObject3).fgW), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ao)((Iterator)localObject1).next();
        if (paramq.containsKey(Long.valueOf(((ao)localObject2).fgW)))
        {
          localObject3 = (ao)paramq.get(Long.valueOf(((ao)localObject2).fgW));
          if (!bk.o(Long.valueOf(((ao)localObject3).fgW), Long.valueOf(((ao)localObject2).fgW))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1514;
            }
            ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((ao)localObject2).fgW, (ao)localObject2);
            paramq.remove(Long.valueOf(((ao)localObject2).fgW));
            break;
            if (!bk.o(Integer.valueOf(((ao)localObject3).fgX), Integer.valueOf(((ao)localObject2).fgX))) {
              paramInt1 = 0;
            } else if (!bk.o(Integer.valueOf(((ao)localObject3).fgY), Integer.valueOf(((ao)localObject2).fgY))) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).username, ((ao)localObject2).username)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).nickname, ((ao)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fgZ, ((ao)localObject2).fgZ)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fha, ((ao)localObject2).fha)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fhb, ((ao)localObject2).fhb)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fhc, ((ao)localObject2).fhc)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fhd, ((ao)localObject2).fhd)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fhe, ((ao)localObject2).fhe)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fhf, ((ao)localObject2).fhf)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).fhg, ((ao)localObject2).fhg)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).ebN, ((ao)localObject2).ebN)) {
              paramInt1 = 0;
            } else if (!bk.o(((ao)localObject3).ebO, ((ao)localObject2).ebO)) {
              paramInt1 = 0;
            } else if (!bk.o(Integer.valueOf(((ao)localObject3).ebP), Integer.valueOf(((ao)localObject2).ebP))) {
              paramInt1 = 0;
            } else if (!bk.o(Integer.valueOf(((ao)localObject3).ebQ), Integer.valueOf(((ao)localObject2).ebQ))) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
          }
        }
        else
        {
          label1514:
          ((ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a((ao)localObject2);
        }
      }
      paramq = paramq.keySet().iterator();
      while (paramq.hasNext())
      {
        long l = ((Long)paramq.next()).longValue();
        localObject1 = (ap)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        y.d("MicroMsg.QQListStorage", "delete: QQ:" + l);
        if (((ap)localObject1).dXo.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((ap)localObject1).b(5, (com.tencent.mm.sdk.e.m)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).Q(localArrayList1);
      com.tencent.mm.ag.o.Kh().Q(localArrayList2);
      paramq = new am();
      paramq.fgO = paramArrayOfByte.tfR;
      paramq.fgT = 0;
      paramq.fgS = ((int)bk.UX());
      paramq.bcw = 48;
      ((an)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(paramq);
    }
  }
  
  public final int getType()
  {
    return 143;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ac
 * JD-Core Version:    0.7.0.1
 */