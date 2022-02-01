package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.com;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private com.tencent.mm.ak.f callback;
  public final b rr;
  
  public af(int paramInt)
  {
    AppMethodBeat.i(131111);
    this.callback = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bhg();
    ((b.a)localObject).hQG = new bhh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((b.a)localObject).funcId = 143;
    ((b.a)localObject).hQH = 38;
    ((b.a)localObject).respCmdId = 1000000038;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bhg)this.rr.hQD.hQJ;
    ((bhg)localObject).gvx = 1;
    ((bhg)localObject).GLu = paramInt;
    AppMethodBeat.o(131111);
  }
  
  private static void a(coo paramcoo)
  {
    AppMethodBeat.i(131114);
    Object localObject1 = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).hKK.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label42:
      if (i >= paramcoo.nID) {
        break label690;
      }
      localObject2 = (con)paramcoo.HAu.get(i);
      ae.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((con)localObject2).GLu + " name:" + ((con)localObject2).GLc + " mem:" + ((con)localObject2).Gxt + " wei:" + ((con)localObject2).HAt + " md5:" + ((con)localObject2).MD5);
      if (((con)localObject2).GLu >= 0) {
        break label279;
      }
      localObject1 = null;
      label151:
      if (localObject1 != null) {
        break label341;
      }
      ae.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i)));
    }
    label279:
    label341:
    while (((aq)localObject1).jhD == 0)
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
        localHashMap.put(Integer.valueOf(((aq)localObject2).jhC), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new aq();
      ((aq)localObject1).jhC = ((con)localObject2).GLu;
      ((aq)localObject1).jhJ = ((con)localObject2).GLc;
      ((aq)localObject1).jhD = ((con)localObject2).Gxt;
      ((aq)localObject1).jhE = ((con)localObject2).HAt;
      ((aq)localObject1).jhI = ((con)localObject2).MD5;
      break label151;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (aq)localHashMap.get(Integer.valueOf(((aq)localObject1).jhC));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((aq)localObject1).jhF = ((int)bu.aRi());
        ((aq)localObject1).jhG = ((int)bu.aRi());
        ((aq)localObject1).jhH = 1;
        localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          ae.d("MicroMsg.QQGroupStorage", "insert: name:" + ((aq)localObject1).aTI());
          ((aq)localObject1).dEu = -1;
          ContentValues localContentValues = ((aq)localObject1).aTG();
          if ((int)((ar)localObject2).hKK.a("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ar)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          ae.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((aq)localObject1).aTI() + " ret:" + bool);
          break;
        }
      }
      ((aq)localObject2).jhH = -1;
      ae.d("MicroMsg.NetSceneGetQQGroup", ((aq)localObject1).aTH() + " " + ((aq)localObject2).aTH() + " " + ((aq)localObject1).jhC);
      if (((aq)localObject2).aTH().equals(((aq)localObject1).aTH())) {
        break;
      }
      ((aq)localObject1).jhG = ((int)bu.aRi());
      ((aq)localObject1).jhH = 1;
      ((aq)localObject1).dEu = -1;
      boolean bool = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a((aq)localObject1);
      ae.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((aq)localObject1).aTI() + " ret:" + bool);
      break;
      label690:
      if (localHashMap != null)
      {
        paramcoo = localHashMap.keySet().iterator();
        while (paramcoo.hasNext())
        {
          localObject1 = (aq)localHashMap.get(paramcoo.next());
          if (((aq)localObject1).jhH == 0)
          {
            localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
            i = ((aq)localObject1).jhC;
            ae.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((ar)localObject2).hKK.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ar)localObject2).doNotify();
              bool = true;
              ae.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((aq)localObject1).aTI() + " ret:" + bool);
              localObject2 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
              i = ((aq)localObject1).jhC;
              ae.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((at)localObject2).hKK.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label965;
              }
            }
            label965:
            for (bool = true;; bool = false)
            {
              ae.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((aq)localObject1).aTI() + " ret:" + bool);
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
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(131112);
    this.callback = paramf;
    paramf = (bhg)this.rr.hQD.hQJ;
    if ((paramf.gvx == 1) && (((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).rs(paramf.GLu) == null))
    {
      ae.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
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
      ae.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131113);
      return;
    }
    ae.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bhg)this.rr.hQD.hQJ;
    Object localObject2 = (bhh)this.rr.hQE.hQJ;
    if (paramArrayOfByte.gvx == 0) {
      a(((bhh)localObject2).GVv);
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
      while (j < ((bhh)localObject2).GVw.nID)
      {
        localObject3 = (col)((bhh)localObject2).GVw.HAs.get(j);
        paramInt1 = paramArrayOfByte.GLu;
        ae.v("MicroMsg.NetSceneGetQQGroup", "friend");
        paramq = new as();
        paramq.jhK = new com.tencent.mm.b.p(((col)localObject3).HAo).longValue();
        com.tencent.mm.aj.c.e(paramq.jhK, 3);
        paramq.jhM = paramInt1;
        paramq.jhL = ((col)localObject3).HAq;
        label552:
        label694:
        int i;
        if (((col)localObject3).HAq != 0)
        {
          if ((((col)localObject3).nIJ == null) || (((col)localObject3).nIJ.equals("")))
          {
            paramq = null;
            ((List)localObject1).add(paramq);
            paramq = new j();
            paramq.eQV = ((col)localObject3).jfV;
            paramq.eRe = ((col)localObject3).jfZ;
            paramq.eRf = ((col)localObject3).jfW;
            paramq.eRg = ((col)localObject3).jfX;
            paramq.signature = ((col)localObject3).jfY;
            paramq.username = ((col)localObject3).nIJ;
            localArrayList1.add(paramq);
            paramq = new i();
            paramq.eQU = 3;
            paramq.eD(true);
            paramq.username = ((col)localObject3).nIJ;
            paramq.hPQ = ((col)localObject3).GnN;
            paramq.hPP = ((col)localObject3).GnO;
            localArrayList2.add(paramq);
            j += 1;
            continue;
          }
          an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(((col)localObject3).nIJ);
          if ((localan != null) && (localan.field_username.equals(((col)localObject3).nIJ)) && (com.tencent.mm.contact.c.lO(localan.field_type))) {
            paramq.jhL = 2;
          }
        }
        else
        {
          paramq.username = ((col)localObject3).nIJ;
          paramq.nickname = ((col)localObject3).nJO;
          paramq.jhS = ((col)localObject3).HAr;
          paramq.jhT = com.tencent.mm.platformtools.f.Jl(((col)localObject3).HAr);
          paramq.jhU = com.tencent.mm.platformtools.f.Jk(((col)localObject3).HAr);
          paramq.jhN = com.tencent.mm.platformtools.f.Jl(((col)localObject3).nJO);
          paramq.jhO = com.tencent.mm.platformtools.f.Jk(((col)localObject3).nJO);
          paramq.jhP = ((col)localObject3).HAp;
          paramq.jhQ = com.tencent.mm.platformtools.f.Jl(((col)localObject3).HAp);
          paramq.jhR = com.tencent.mm.platformtools.f.Jk(((col)localObject3).HAp);
          paramInt1 = 32;
          if (bu.isNullOrNil(paramq.aTO())) {
            break label791;
          }
          paramInt1 = paramq.aTO().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          paramq.hPM = i;
          com.tencent.mm.plugin.c.a.aVH().aAh().mb(((col)localObject3).nIJ, ((col)localObject3).GNI);
          ae.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + paramq.aTK() + "  remark: " + paramq.aTN());
          break;
          paramq.jhL = 1;
          break label552;
          label791:
          if (!bu.isNullOrNil(paramq.aTP()))
          {
            paramInt1 = paramq.aTP().charAt(0);
            break label694;
          }
          if (!bu.isNullOrNil(paramq.aTL()))
          {
            paramInt1 = paramq.aTL().charAt(0);
            break label694;
          }
          if (bu.isNullOrNil(paramq.aTM())) {
            break label694;
          }
          paramInt1 = paramq.aTM().charAt(0);
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
      paramInt1 = paramArrayOfByte.GLu;
      ae.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((at)localObject2).hKK.a((String)localObject3, null, 0);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new as();
        ((as)localObject3).convertFrom((Cursor)localObject2);
        paramq.put(Long.valueOf(((as)localObject3).jhK), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (as)((Iterator)localObject1).next();
        if (paramq.containsKey(Long.valueOf(((as)localObject2).jhK)))
        {
          localObject3 = (as)paramq.get(Long.valueOf(((as)localObject2).jhK));
          if (!bu.J(Long.valueOf(((as)localObject3).jhK), Long.valueOf(((as)localObject2).jhK))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1525;
            }
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((as)localObject2).jhK, (as)localObject2);
            paramq.remove(Long.valueOf(((as)localObject2).jhK));
            break;
            if (!bu.J(Integer.valueOf(((as)localObject3).jhL), Integer.valueOf(((as)localObject2).jhL))) {
              paramInt1 = 0;
            } else if (!bu.J(Integer.valueOf(((as)localObject3).jhM), Integer.valueOf(((as)localObject2).jhM))) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).username, ((as)localObject2).username)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).nickname, ((as)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhN, ((as)localObject2).jhN)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhO, ((as)localObject2).jhO)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhP, ((as)localObject2).jhP)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhQ, ((as)localObject2).jhQ)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhR, ((as)localObject2).jhR)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhS, ((as)localObject2).jhS)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhT, ((as)localObject2).jhT)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).jhU, ((as)localObject2).jhU)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).hPK, ((as)localObject2).hPK)) {
              paramInt1 = 0;
            } else if (!bu.J(((as)localObject3).hPL, ((as)localObject2).hPL)) {
              paramInt1 = 0;
            } else if (!bu.J(Integer.valueOf(((as)localObject3).hPM), Integer.valueOf(((as)localObject2).hPM))) {
              paramInt1 = 0;
            } else if (!bu.J(Integer.valueOf(((as)localObject3).hPN), Integer.valueOf(((as)localObject2).hPN))) {
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
        ae.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(l)));
        if (((at)localObject1).hKK.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((at)localObject1).b(5, (com.tencent.mm.sdk.e.n)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).am(localArrayList1);
      com.tencent.mm.aj.p.aEN().am(localArrayList2);
      paramq = new aq();
      paramq.jhC = paramArrayOfByte.GLu;
      paramq.jhH = 0;
      paramq.jhG = ((int)bu.aRi());
      paramq.dEu = 48;
      ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */