package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.c.av;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.bcm;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cit;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class af
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  public final com.tencent.mm.ak.b rr;
  
  public af(int paramInt)
  {
    AppMethodBeat.i(131111);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new bcm();
    ((b.a)localObject).hvu = new bcn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((b.a)localObject).funcId = 143;
    ((b.a)localObject).reqCmdId = 38;
    ((b.a)localObject).respCmdId = 1000000038;
    this.rr = ((b.a)localObject).aAz();
    localObject = (bcm)this.rr.hvr.hvw;
    ((bcm)localObject).fZz = 1;
    ((bcm)localObject).ESB = paramInt;
    AppMethodBeat.o(131111);
  }
  
  private static void a(ciu paramciu)
  {
    AppMethodBeat.i(131114);
    Object localObject1 = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).hpA.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label42:
      if (i >= paramciu.ncL) {
        break label690;
      }
      localObject2 = (cit)paramciu.FwP.get(i);
      ac.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((cit)localObject2).ESB + " name:" + ((cit)localObject2).EIM + " mem:" + ((cit)localObject2).Exi + " wei:" + ((cit)localObject2).FwO + " md5:" + ((cit)localObject2).MD5);
      if (((cit)localObject2).ESB >= 0) {
        break label279;
      }
      localObject1 = null;
      label151:
      if (localObject1 != null) {
        break label341;
      }
      ac.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i)));
    }
    label279:
    label341:
    while (((aq)localObject1).iLB == 0)
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
        localHashMap.put(Integer.valueOf(((aq)localObject2).iLA), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new aq();
      ((aq)localObject1).iLA = ((cit)localObject2).ESB;
      ((aq)localObject1).iLH = ((cit)localObject2).EIM;
      ((aq)localObject1).iLB = ((cit)localObject2).Exi;
      ((aq)localObject1).iLC = ((cit)localObject2).FwO;
      ((aq)localObject1).iLG = ((cit)localObject2).MD5;
      break label151;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (aq)localHashMap.get(Integer.valueOf(((aq)localObject1).iLA));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((aq)localObject1).iLD = ((int)bs.aNx());
        ((aq)localObject1).iLE = ((int)bs.aNx());
        ((aq)localObject1).iLF = 1;
        localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          ac.d("MicroMsg.QQGroupStorage", "insert: name:" + ((aq)localObject1).aPX());
          ((aq)localObject1).drx = -1;
          ContentValues localContentValues = ((aq)localObject1).aPV();
          if ((int)((ar)localObject2).hpA.a("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ar)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          ac.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((aq)localObject1).aPX() + " ret:" + bool);
          break;
        }
      }
      ((aq)localObject2).iLF = -1;
      ac.d("MicroMsg.NetSceneGetQQGroup", ((aq)localObject1).aPW() + " " + ((aq)localObject2).aPW() + " " + ((aq)localObject1).iLA);
      if (((aq)localObject2).aPW().equals(((aq)localObject1).aPW())) {
        break;
      }
      ((aq)localObject1).iLE = ((int)bs.aNx());
      ((aq)localObject1).iLF = 1;
      ((aq)localObject1).drx = -1;
      boolean bool = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a((aq)localObject1);
      ac.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((aq)localObject1).aPX() + " ret:" + bool);
      break;
      label690:
      if (localHashMap != null)
      {
        paramciu = localHashMap.keySet().iterator();
        while (paramciu.hasNext())
        {
          localObject1 = (aq)localHashMap.get(paramciu.next());
          if (((aq)localObject1).iLF == 0)
          {
            localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
            i = ((aq)localObject1).iLA;
            ac.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((ar)localObject2).hpA.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ar)localObject2).doNotify();
              bool = true;
              ac.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((aq)localObject1).aPX() + " ret:" + bool);
              localObject2 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
              i = ((aq)localObject1).iLA;
              ac.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((at)localObject2).hpA.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label965;
              }
            }
            label965:
            for (bool = true;; bool = false)
            {
              ac.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((aq)localObject1).aPX() + " ret:" + bool);
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
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(131112);
    this.callback = paramg;
    paramg = (bcm)this.rr.hvr.hvw;
    if ((paramg.fZz == 1) && (((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).qP(paramg.ESB) == null))
    {
      ac.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
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
      ac.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131113);
      return;
    }
    ac.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bcm)this.rr.hvr.hvw;
    Object localObject2 = (bcn)this.rr.hvs.hvw;
    if (paramArrayOfByte.fZz == 0) {
      a(((bcn)localObject2).ESC);
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
      while (j < ((bcn)localObject2).ESD.ncL)
      {
        localObject3 = (cir)((bcn)localObject2).ESD.FwN.get(j);
        paramInt1 = paramArrayOfByte.ESB;
        ac.v("MicroMsg.NetSceneGetQQGroup", "friend");
        paramq = new as();
        paramq.iLI = new com.tencent.mm.b.p(((cir)localObject3).FwJ).longValue();
        c.e(paramq.iLI, 3);
        paramq.iLK = paramInt1;
        paramq.iLJ = ((cir)localObject3).FwL;
        label552:
        label694:
        int i;
        if (((cir)localObject3).FwL != 0)
        {
          if ((((cir)localObject3).ncR == null) || (((cir)localObject3).ncR.equals("")))
          {
            paramq = null;
            ((List)localObject1).add(paramq);
            paramq = new j();
            paramq.exL = ((cir)localObject3).iJT;
            paramq.exU = ((cir)localObject3).iJX;
            paramq.exV = ((cir)localObject3).iJU;
            paramq.exW = ((cir)localObject3).iJV;
            paramq.signature = ((cir)localObject3).iJW;
            paramq.username = ((cir)localObject3).ncR;
            localArrayList1.add(paramq);
            paramq = new i();
            paramq.exK = 3;
            paramq.ez(true);
            paramq.username = ((cir)localObject3).ncR;
            paramq.huF = ((cir)localObject3).Eof;
            paramq.huE = ((cir)localObject3).Eog;
            localArrayList2.add(paramq);
            j += 1;
            continue;
          }
          ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((cir)localObject3).ncR);
          if ((localai != null) && (localai.field_username.equals(((cir)localObject3).ncR)) && (com.tencent.mm.n.b.ln(localai.field_type))) {
            paramq.iLJ = 2;
          }
        }
        else
        {
          paramq.username = ((cir)localObject3).ncR;
          paramq.nickname = ((cir)localObject3).ndW;
          paramq.iLQ = ((cir)localObject3).FwM;
          paramq.iLR = f.Fw(((cir)localObject3).FwM);
          paramq.iLS = f.Fv(((cir)localObject3).FwM);
          paramq.iLL = f.Fw(((cir)localObject3).ndW);
          paramq.iLM = f.Fv(((cir)localObject3).ndW);
          paramq.iLN = ((cir)localObject3).FwK;
          paramq.iLO = f.Fw(((cir)localObject3).FwK);
          paramq.iLP = f.Fv(((cir)localObject3).FwK);
          paramInt1 = 32;
          if (bs.isNullOrNil(paramq.aQd())) {
            break label791;
          }
          paramInt1 = paramq.aQd().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          paramq.huB = i;
          com.tencent.mm.plugin.c.a.aRW().axc().lv(((cir)localObject3).ncR, ((cir)localObject3).ELg);
          ac.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + paramq.aPZ() + "  remark: " + paramq.aQc());
          break;
          paramq.iLJ = 1;
          break label552;
          label791:
          if (!bs.isNullOrNil(paramq.aQe()))
          {
            paramInt1 = paramq.aQe().charAt(0);
            break label694;
          }
          if (!bs.isNullOrNil(paramq.aQa()))
          {
            paramInt1 = paramq.aQa().charAt(0);
            break label694;
          }
          if (bs.isNullOrNil(paramq.aQb())) {
            break label694;
          }
          paramInt1 = paramq.aQb().charAt(0);
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
      paramInt1 = paramArrayOfByte.ESB;
      ac.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((at)localObject2).hpA.a((String)localObject3, null, 0);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new as();
        ((as)localObject3).convertFrom((Cursor)localObject2);
        paramq.put(Long.valueOf(((as)localObject3).iLI), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (as)((Iterator)localObject1).next();
        if (paramq.containsKey(Long.valueOf(((as)localObject2).iLI)))
        {
          localObject3 = (as)paramq.get(Long.valueOf(((as)localObject2).iLI));
          if (!bs.H(Long.valueOf(((as)localObject3).iLI), Long.valueOf(((as)localObject2).iLI))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1525;
            }
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((as)localObject2).iLI, (as)localObject2);
            paramq.remove(Long.valueOf(((as)localObject2).iLI));
            break;
            if (!bs.H(Integer.valueOf(((as)localObject3).iLJ), Integer.valueOf(((as)localObject2).iLJ))) {
              paramInt1 = 0;
            } else if (!bs.H(Integer.valueOf(((as)localObject3).iLK), Integer.valueOf(((as)localObject2).iLK))) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).username, ((as)localObject2).username)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).nickname, ((as)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLL, ((as)localObject2).iLL)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLM, ((as)localObject2).iLM)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLN, ((as)localObject2).iLN)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLO, ((as)localObject2).iLO)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLP, ((as)localObject2).iLP)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLQ, ((as)localObject2).iLQ)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLR, ((as)localObject2).iLR)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).iLS, ((as)localObject2).iLS)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).huz, ((as)localObject2).huz)) {
              paramInt1 = 0;
            } else if (!bs.H(((as)localObject3).huA, ((as)localObject2).huA)) {
              paramInt1 = 0;
            } else if (!bs.H(Integer.valueOf(((as)localObject3).huB), Integer.valueOf(((as)localObject2).huB))) {
              paramInt1 = 0;
            } else if (!bs.H(Integer.valueOf(((as)localObject3).huC), Integer.valueOf(((as)localObject2).huC))) {
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
        ac.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(l)));
        if (((at)localObject1).hpA.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((at)localObject1).b(5, (com.tencent.mm.sdk.e.n)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).al(localArrayList1);
      com.tencent.mm.aj.p.aBw().al(localArrayList2);
      paramq = new aq();
      paramq.iLA = paramArrayOfByte.ESB;
      paramq.iLF = 0;
      paramq.iLE = ((int)bs.aNx());
      paramq.drx = 48;
      ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */