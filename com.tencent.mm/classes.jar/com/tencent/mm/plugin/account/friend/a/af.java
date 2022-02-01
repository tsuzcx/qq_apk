package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.protocal.protobuf.cdr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class af
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  public final com.tencent.mm.al.b rr;
  
  public af(int paramInt)
  {
    AppMethodBeat.i(131111);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ayu();
    ((b.a)localObject).gUV = new ayv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((b.a)localObject).funcId = 143;
    ((b.a)localObject).reqCmdId = 38;
    ((b.a)localObject).respCmdId = 1000000038;
    this.rr = ((b.a)localObject).atI();
    localObject = (ayu)this.rr.gUS.gUX;
    ((ayu)localObject).fVE = 1;
    ((ayu)localObject).Dxg = paramInt;
    AppMethodBeat.o(131111);
  }
  
  private static void a(cdr paramcdr)
  {
    AppMethodBeat.i(131114);
    Object localObject1 = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).gPa.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label42:
      if (i >= paramcdr.mAK) {
        break label690;
      }
      localObject2 = (cdq)paramcdr.DZU.get(i);
      ad.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((cdq)localObject2).Dxg + " name:" + ((cdq)localObject2).DnM + " mem:" + ((cdq)localObject2).Dec + " wei:" + ((cdq)localObject2).DZT + " md5:" + ((cdq)localObject2).MD5);
      if (((cdq)localObject2).Dxg >= 0) {
        break label279;
      }
      localObject1 = null;
      label151:
      if (localObject1 != null) {
        break label341;
      }
      ad.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i)));
    }
    label279:
    label341:
    while (((aq)localObject1).ilu == 0)
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
        localObject2 = new aq();
        ((aq)localObject2).convertFrom((Cursor)localObject1);
        localHashMap.put(Integer.valueOf(((aq)localObject2).ilt), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new aq();
      ((aq)localObject1).ilt = ((cdq)localObject2).Dxg;
      ((aq)localObject1).ilA = ((cdq)localObject2).DnM;
      ((aq)localObject1).ilu = ((cdq)localObject2).Dec;
      ((aq)localObject1).ilv = ((cdq)localObject2).DZT;
      ((aq)localObject1).ilz = ((cdq)localObject2).MD5;
      break label151;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (aq)localHashMap.get(Integer.valueOf(((aq)localObject1).ilt));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((aq)localObject1).ilw = ((int)bt.aGK());
        ((aq)localObject1).ilx = ((int)bt.aGK());
        ((aq)localObject1).ily = 1;
        localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          ad.d("MicroMsg.QQGroupStorage", "insert: name:" + ((aq)localObject1).aJg());
          ((aq)localObject1).dtM = -1;
          ContentValues localContentValues = ((aq)localObject1).aJe();
          if ((int)((ar)localObject2).gPa.a("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ar)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          ad.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((aq)localObject1).aJg() + " ret:" + bool);
          break;
        }
      }
      ((aq)localObject2).ily = -1;
      ad.d("MicroMsg.NetSceneGetQQGroup", ((aq)localObject1).aJf() + " " + ((aq)localObject2).aJf() + " " + ((aq)localObject1).ilt);
      if (((aq)localObject2).aJf().equals(((aq)localObject1).aJf())) {
        break;
      }
      ((aq)localObject1).ilx = ((int)bt.aGK());
      ((aq)localObject1).ily = 1;
      ((aq)localObject1).dtM = -1;
      boolean bool = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a((aq)localObject1);
      ad.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((aq)localObject1).aJg() + " ret:" + bool);
      break;
      label690:
      if (localHashMap != null)
      {
        paramcdr = localHashMap.keySet().iterator();
        while (paramcdr.hasNext())
        {
          localObject1 = (aq)localHashMap.get(paramcdr.next());
          if (((aq)localObject1).ily == 0)
          {
            localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
            i = ((aq)localObject1).ilt;
            ad.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((ar)localObject2).gPa.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ar)localObject2).doNotify();
              bool = true;
              ad.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((aq)localObject1).aJg() + " ret:" + bool);
              localObject2 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
              i = ((aq)localObject1).ilt;
              ad.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((at)localObject2).gPa.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label965;
              }
            }
            label965:
            for (bool = true;; bool = false)
            {
              ad.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((aq)localObject1).aJg() + " ret:" + bool);
              break;
              bool = false;
              break label815;
            }
          }
        }
      }
      label815:
      AppMethodBeat.o(131114);
      return;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(131112);
    this.callback = paramg;
    paramg = (ayu)this.rr.gUS.gUX;
    if ((paramg.fVE == 1) && (((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).qc(paramg.Dxg) == null))
    {
      ad.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
      AppMethodBeat.o(131112);
      return -1;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131112);
    return i;
  }
  
  public final int getType()
  {
    return 143;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131113);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131113);
      return;
    }
    ad.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (ayu)this.rr.gUS.gUX;
    Object localObject2 = (ayv)this.rr.gUT.gUX;
    if (paramArrayOfByte.fVE == 0) {
      a(((ayv)localObject2).Dxh);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131113);
      return;
      Object localObject1 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int j = 0;
      while (j < ((ayv)localObject2).Dxi.mAK)
      {
        localObject3 = (cdo)((ayv)localObject2).Dxi.DZS.get(j);
        paramInt1 = paramArrayOfByte.Dxg;
        ad.v("MicroMsg.NetSceneGetQQGroup", "friend");
        paramq = new as();
        paramq.ilB = new com.tencent.mm.b.p(((cdo)localObject3).DZO).longValue();
        c.e(paramq.ilB, 3);
        paramq.ilD = paramInt1;
        paramq.ilC = ((cdo)localObject3).DZQ;
        label552:
        label694:
        int i;
        if (((cdo)localObject3).DZQ != 0)
        {
          if ((((cdo)localObject3).mAQ == null) || (((cdo)localObject3).mAQ.equals("")))
          {
            paramq = null;
            ((List)localObject1).add(paramq);
            paramq = new j();
            paramq.evp = ((cdo)localObject3).ijM;
            paramq.evy = ((cdo)localObject3).ijQ;
            paramq.evz = ((cdo)localObject3).ijN;
            paramq.evA = ((cdo)localObject3).ijO;
            paramq.signature = ((cdo)localObject3).ijP;
            paramq.username = ((cdo)localObject3).mAQ;
            localArrayList1.add(paramq);
            paramq = new i();
            paramq.evo = 3;
            paramq.ee(true);
            paramq.username = ((cdo)localObject3).mAQ;
            paramq.gUg = ((cdo)localObject3).CVv;
            paramq.gUf = ((cdo)localObject3).CVw;
            localArrayList2.add(paramq);
            j += 1;
            continue;
          }
          com.tencent.mm.storage.af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(((cdo)localObject3).mAQ);
          if ((localaf != null) && (localaf.field_username.equals(((cdo)localObject3).mAQ)) && (com.tencent.mm.n.b.ls(localaf.field_type))) {
            paramq.ilC = 2;
          }
        }
        else
        {
          paramq.username = ((cdo)localObject3).mAQ;
          paramq.nickname = ((cdo)localObject3).mBV;
          paramq.ilJ = ((cdo)localObject3).DZR;
          paramq.ilK = f.Bs(((cdo)localObject3).DZR);
          paramq.ilL = f.Br(((cdo)localObject3).DZR);
          paramq.ilE = f.Bs(((cdo)localObject3).mBV);
          paramq.ilF = f.Br(((cdo)localObject3).mBV);
          paramq.ilG = ((cdo)localObject3).DZP;
          paramq.ilH = f.Bs(((cdo)localObject3).DZP);
          paramq.ilI = f.Br(((cdo)localObject3).DZP);
          paramInt1 = 32;
          if (bt.isNullOrNil(paramq.aJm())) {
            break label791;
          }
          paramInt1 = paramq.aJm().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          paramq.gUc = i;
          com.tencent.mm.plugin.c.a.aLf().aqn().kY(((cdo)localObject3).mAQ, ((cdo)localObject3).Dqd);
          ad.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + paramq.aJi() + "  remark: " + paramq.aJl());
          break;
          paramq.ilC = 1;
          break label552;
          label791:
          if (!bt.isNullOrNil(paramq.aJn()))
          {
            paramInt1 = paramq.aJn().charAt(0);
            break label694;
          }
          if (!bt.isNullOrNil(paramq.aJj()))
          {
            paramInt1 = paramq.aJj().charAt(0);
            break label694;
          }
          if (bt.isNullOrNil(paramq.aJk())) {
            break label694;
          }
          paramInt1 = paramq.aJk().charAt(0);
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
      localObject2 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
      paramInt1 = paramArrayOfByte.Dxg;
      ad.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((at)localObject2).gPa.a((String)localObject3, null, 0);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new as();
        ((as)localObject3).convertFrom((Cursor)localObject2);
        paramq.put(Long.valueOf(((as)localObject3).ilB), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (as)((Iterator)localObject1).next();
        if (paramq.containsKey(Long.valueOf(((as)localObject2).ilB)))
        {
          localObject3 = (as)paramq.get(Long.valueOf(((as)localObject2).ilB));
          if (!bt.H(Long.valueOf(((as)localObject3).ilB), Long.valueOf(((as)localObject2).ilB))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1525;
            }
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((as)localObject2).ilB, (as)localObject2);
            paramq.remove(Long.valueOf(((as)localObject2).ilB));
            break;
            if (!bt.H(Integer.valueOf(((as)localObject3).ilC), Integer.valueOf(((as)localObject2).ilC))) {
              paramInt1 = 0;
            } else if (!bt.H(Integer.valueOf(((as)localObject3).ilD), Integer.valueOf(((as)localObject2).ilD))) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).username, ((as)localObject2).username)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).nickname, ((as)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilE, ((as)localObject2).ilE)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilF, ((as)localObject2).ilF)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilG, ((as)localObject2).ilG)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilH, ((as)localObject2).ilH)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilI, ((as)localObject2).ilI)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilJ, ((as)localObject2).ilJ)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilK, ((as)localObject2).ilK)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).ilL, ((as)localObject2).ilL)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).gUa, ((as)localObject2).gUa)) {
              paramInt1 = 0;
            } else if (!bt.H(((as)localObject3).gUb, ((as)localObject2).gUb)) {
              paramInt1 = 0;
            } else if (!bt.H(Integer.valueOf(((as)localObject3).gUc), Integer.valueOf(((as)localObject2).gUc))) {
              paramInt1 = 0;
            } else if (!bt.H(Integer.valueOf(((as)localObject3).gUd), Integer.valueOf(((as)localObject2).gUd))) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
          }
        }
        else
        {
          label1525:
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a((as)localObject2);
        }
      }
      paramq = paramq.keySet().iterator();
      while (paramq.hasNext())
      {
        long l = ((Long)paramq.next()).longValue();
        localObject1 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        ad.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(l)));
        if (((at)localObject1).gPa.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((at)localObject1).b(5, (com.tencent.mm.sdk.e.n)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).ao(localArrayList1);
      com.tencent.mm.ak.p.auF().ao(localArrayList2);
      paramq = new aq();
      paramq.ilt = paramArrayOfByte.Dxg;
      paramq.ily = 0;
      paramq.ilx = ((int)bt.aGK());
      paramq.dtM = 48;
      ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */