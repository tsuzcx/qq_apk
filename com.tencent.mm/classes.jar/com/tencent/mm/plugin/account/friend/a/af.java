package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bgq;
import com.tencent.mm.protocal.protobuf.bgr;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
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
  private com.tencent.mm.al.f callback;
  public final com.tencent.mm.al.b rr;
  
  public af(int paramInt)
  {
    AppMethodBeat.i(131111);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bgq();
    ((b.a)localObject).hNN = new bgr();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((b.a)localObject).funcId = 143;
    ((b.a)localObject).hNO = 38;
    ((b.a)localObject).respCmdId = 1000000038;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bgq)this.rr.hNK.hNQ;
    ((bgq)localObject).gsV = 1;
    ((bgq)localObject).GrW = paramInt;
    AppMethodBeat.o(131111);
  }
  
  private static void a(cnu paramcnu)
  {
    AppMethodBeat.i(131114);
    Object localObject1 = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).hHS.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label42:
      if (i >= paramcnu.nDi) {
        break label690;
      }
      localObject2 = (cnt)paramcnu.HgU.get(i);
      ad.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((cnt)localObject2).GrW + " name:" + ((cnt)localObject2).GrE + " mem:" + ((cnt)localObject2).GeL + " wei:" + ((cnt)localObject2).HgT + " md5:" + ((cnt)localObject2).MD5);
      if (((cnt)localObject2).GrW >= 0) {
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
    while (((aq)localObject1).jeK == 0)
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
        localHashMap.put(Integer.valueOf(((aq)localObject2).jeJ), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new aq();
      ((aq)localObject1).jeJ = ((cnt)localObject2).GrW;
      ((aq)localObject1).jeQ = ((cnt)localObject2).GrE;
      ((aq)localObject1).jeK = ((cnt)localObject2).GeL;
      ((aq)localObject1).jeL = ((cnt)localObject2).HgT;
      ((aq)localObject1).jeP = ((cnt)localObject2).MD5;
      break label151;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (aq)localHashMap.get(Integer.valueOf(((aq)localObject1).jeJ));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((aq)localObject1).jeM = ((int)bt.aQJ());
        ((aq)localObject1).jeN = ((int)bt.aQJ());
        ((aq)localObject1).jeO = 1;
        localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          ad.d("MicroMsg.QQGroupStorage", "insert: name:" + ((aq)localObject1).aTj());
          ((aq)localObject1).dDp = -1;
          ContentValues localContentValues = ((aq)localObject1).aTh();
          if ((int)((ar)localObject2).hHS.a("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ar)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          ad.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((aq)localObject1).aTj() + " ret:" + bool);
          break;
        }
      }
      ((aq)localObject2).jeO = -1;
      ad.d("MicroMsg.NetSceneGetQQGroup", ((aq)localObject1).aTi() + " " + ((aq)localObject2).aTi() + " " + ((aq)localObject1).jeJ);
      if (((aq)localObject2).aTi().equals(((aq)localObject1).aTi())) {
        break;
      }
      ((aq)localObject1).jeN = ((int)bt.aQJ());
      ((aq)localObject1).jeO = 1;
      ((aq)localObject1).dDp = -1;
      boolean bool = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a((aq)localObject1);
      ad.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((aq)localObject1).aTj() + " ret:" + bool);
      break;
      label690:
      if (localHashMap != null)
      {
        paramcnu = localHashMap.keySet().iterator();
        while (paramcnu.hasNext())
        {
          localObject1 = (aq)localHashMap.get(paramcnu.next());
          if (((aq)localObject1).jeO == 0)
          {
            localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
            i = ((aq)localObject1).jeJ;
            ad.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((ar)localObject2).hHS.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ar)localObject2).doNotify();
              bool = true;
              ad.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((aq)localObject1).aTj() + " ret:" + bool);
              localObject2 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
              i = ((aq)localObject1).jeJ;
              ad.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((at)localObject2).hHS.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label965;
              }
            }
            label965:
            for (bool = true;; bool = false)
            {
              ad.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((aq)localObject1).aTj() + " ret:" + bool);
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
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(131112);
    this.callback = paramf;
    paramf = (bgq)this.rr.hNK.hNQ;
    if ((paramf.gsV == 1) && (((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).rp(paramf.GrW) == null))
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
    paramArrayOfByte = (bgq)this.rr.hNK.hNQ;
    Object localObject2 = (bgr)this.rr.hNL.hNQ;
    if (paramArrayOfByte.gsV == 0) {
      a(((bgr)localObject2).GBV);
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
      while (j < ((bgr)localObject2).GBW.nDi)
      {
        localObject3 = (cnr)((bgr)localObject2).GBW.HgS.get(j);
        paramInt1 = paramArrayOfByte.GrW;
        ad.v("MicroMsg.NetSceneGetQQGroup", "friend");
        paramq = new as();
        paramq.jeR = new com.tencent.mm.b.p(((cnr)localObject3).HgO).longValue();
        c.e(paramq.jeR, 3);
        paramq.jeT = paramInt1;
        paramq.jeS = ((cnr)localObject3).HgQ;
        label552:
        label694:
        int i;
        if (((cnr)localObject3).HgQ != 0)
        {
          if ((((cnr)localObject3).nDo == null) || (((cnr)localObject3).nDo.equals("")))
          {
            paramq = null;
            ((List)localObject1).add(paramq);
            paramq = new j();
            paramq.ePk = ((cnr)localObject3).jdc;
            paramq.ePt = ((cnr)localObject3).jdg;
            paramq.ePu = ((cnr)localObject3).jdd;
            paramq.ePv = ((cnr)localObject3).jde;
            paramq.signature = ((cnr)localObject3).jdf;
            paramq.username = ((cnr)localObject3).nDo;
            localArrayList1.add(paramq);
            paramq = new i();
            paramq.ePj = 3;
            paramq.eB(true);
            paramq.username = ((cnr)localObject3).nDo;
            paramq.hMX = ((cnr)localObject3).FVo;
            paramq.hMW = ((cnr)localObject3).FVp;
            localArrayList2.add(paramq);
            j += 1;
            continue;
          }
          am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(((cnr)localObject3).nDo);
          if ((localam != null) && (localam.field_username.equals(((cnr)localObject3).nDo)) && (com.tencent.mm.o.b.lM(localam.field_type))) {
            paramq.jeS = 2;
          }
        }
        else
        {
          paramq.username = ((cnr)localObject3).nDo;
          paramq.nickname = ((cnr)localObject3).nEt;
          paramq.jeZ = ((cnr)localObject3).HgR;
          paramq.jfa = com.tencent.mm.platformtools.f.IM(((cnr)localObject3).HgR);
          paramq.jfb = com.tencent.mm.platformtools.f.IL(((cnr)localObject3).HgR);
          paramq.jeU = com.tencent.mm.platformtools.f.IM(((cnr)localObject3).nEt);
          paramq.jeV = com.tencent.mm.platformtools.f.IL(((cnr)localObject3).nEt);
          paramq.jeW = ((cnr)localObject3).HgP;
          paramq.jeX = com.tencent.mm.platformtools.f.IM(((cnr)localObject3).HgP);
          paramq.jeY = com.tencent.mm.platformtools.f.IL(((cnr)localObject3).HgP);
          paramInt1 = 32;
          if (bt.isNullOrNil(paramq.aTp())) {
            break label791;
          }
          paramInt1 = paramq.aTp().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          paramq.hMT = i;
          com.tencent.mm.plugin.c.a.aVi().azR().lU(((cnr)localObject3).nDo, ((cnr)localObject3).Guj);
          ad.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + paramq.aTl() + "  remark: " + paramq.aTo());
          break;
          paramq.jeS = 1;
          break label552;
          label791:
          if (!bt.isNullOrNil(paramq.aTq()))
          {
            paramInt1 = paramq.aTq().charAt(0);
            break label694;
          }
          if (!bt.isNullOrNil(paramq.aTm()))
          {
            paramInt1 = paramq.aTm().charAt(0);
            break label694;
          }
          if (bt.isNullOrNil(paramq.aTn())) {
            break label694;
          }
          paramInt1 = paramq.aTn().charAt(0);
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
      paramInt1 = paramArrayOfByte.GrW;
      ad.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((at)localObject2).hHS.a((String)localObject3, null, 0);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new as();
        ((as)localObject3).convertFrom((Cursor)localObject2);
        paramq.put(Long.valueOf(((as)localObject3).jeR), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (as)((Iterator)localObject1).next();
        if (paramq.containsKey(Long.valueOf(((as)localObject2).jeR)))
        {
          localObject3 = (as)paramq.get(Long.valueOf(((as)localObject2).jeR));
          if (!bt.J(Long.valueOf(((as)localObject3).jeR), Long.valueOf(((as)localObject2).jeR))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1525;
            }
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((as)localObject2).jeR, (as)localObject2);
            paramq.remove(Long.valueOf(((as)localObject2).jeR));
            break;
            if (!bt.J(Integer.valueOf(((as)localObject3).jeS), Integer.valueOf(((as)localObject2).jeS))) {
              paramInt1 = 0;
            } else if (!bt.J(Integer.valueOf(((as)localObject3).jeT), Integer.valueOf(((as)localObject2).jeT))) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).username, ((as)localObject2).username)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).nickname, ((as)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jeU, ((as)localObject2).jeU)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jeV, ((as)localObject2).jeV)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jeW, ((as)localObject2).jeW)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jeX, ((as)localObject2).jeX)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jeY, ((as)localObject2).jeY)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jeZ, ((as)localObject2).jeZ)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jfa, ((as)localObject2).jfa)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).jfb, ((as)localObject2).jfb)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).hMR, ((as)localObject2).hMR)) {
              paramInt1 = 0;
            } else if (!bt.J(((as)localObject3).hMS, ((as)localObject2).hMS)) {
              paramInt1 = 0;
            } else if (!bt.J(Integer.valueOf(((as)localObject3).hMT), Integer.valueOf(((as)localObject2).hMT))) {
              paramInt1 = 0;
            } else if (!bt.J(Integer.valueOf(((as)localObject3).hMU), Integer.valueOf(((as)localObject2).hMU))) {
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
        if (((at)localObject1).hHS.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((at)localObject1).b(5, (com.tencent.mm.sdk.e.n)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).am(localArrayList1);
      com.tencent.mm.ak.p.aEx().am(localArrayList2);
      paramq = new aq();
      paramq.jeJ = paramArrayOfByte.GrW;
      paramq.jeO = 0;
      paramq.jeN = ((int)bt.aQJ());
      paramq.dDp = 48;
      ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */