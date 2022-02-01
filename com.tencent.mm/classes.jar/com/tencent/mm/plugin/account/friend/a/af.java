package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.b.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.cax;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.dqf;
import com.tencent.mm.protocal.protobuf.dqg;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class af
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  public final com.tencent.mm.an.d rr;
  
  public af(int paramInt)
  {
    AppMethodBeat.i(131111);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new caw();
    ((d.a)localObject).lBV = new cax();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((d.a)localObject).funcId = 143;
    ((d.a)localObject).lBW = 38;
    ((d.a)localObject).respCmdId = 1000000038;
    this.rr = ((d.a)localObject).bgN();
    localObject = (caw)d.b.b(this.rr.lBR);
    ((caw)localObject).jUk = 1;
    ((caw)localObject).SXM = paramInt;
    AppMethodBeat.o(131111);
  }
  
  private static void a(dqh paramdqh)
  {
    AppMethodBeat.i(131114);
    Object localObject1 = ((ar)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).lvy.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label41:
      if (i >= paramdqh.rVx) {
        break label689;
      }
      localObject2 = (dqg)paramdqh.TXa.get(i);
      Log.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((dqg)localObject2).SXM + " name:" + ((dqg)localObject2).SXx + " mem:" + ((dqg)localObject2).Svx + " wei:" + ((dqg)localObject2).TWZ + " md5:" + ((dqg)localObject2).MD5);
      if (((dqg)localObject2).SXM >= 0) {
        break label278;
      }
      localObject1 = null;
      label150:
      if (localObject1 != null) {
        break label340;
      }
      Log.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i)));
    }
    label278:
    label340:
    while (((aq)localObject1).mXf == 0)
    {
      i += 1;
      break label41;
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
        localHashMap.put(Integer.valueOf(((aq)localObject2).mXe), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new aq();
      ((aq)localObject1).mXe = ((dqg)localObject2).SXM;
      ((aq)localObject1).mXl = ((dqg)localObject2).SXx;
      ((aq)localObject1).mXf = ((dqg)localObject2).Svx;
      ((aq)localObject1).mXg = ((dqg)localObject2).TWZ;
      ((aq)localObject1).mXk = ((dqg)localObject2).MD5;
      break label150;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (aq)localHashMap.get(Integer.valueOf(((aq)localObject1).mXe));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((aq)localObject1).mXh = ((int)Util.nowSecond());
        ((aq)localObject1).mXi = ((int)Util.nowSecond());
        ((aq)localObject1).mXj = 1;
        localObject2 = (ar)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          Log.d("MicroMsg.QQGroupStorage", "insert: name:" + ((aq)localObject1).byD());
          ((aq)localObject1).cUP = -1;
          ContentValues localContentValues = ((aq)localObject1).byB();
          if ((int)((ar)localObject2).lvy.insert("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ar)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          Log.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((aq)localObject1).byD() + " ret:" + bool);
          break;
        }
      }
      ((aq)localObject2).mXj = -1;
      Log.d("MicroMsg.NetSceneGetQQGroup", ((aq)localObject1).byC() + " " + ((aq)localObject2).byC() + " " + ((aq)localObject1).mXe);
      if (((aq)localObject2).byC().equals(((aq)localObject1).byC())) {
        break;
      }
      ((aq)localObject1).mXi = ((int)Util.nowSecond());
      ((aq)localObject1).mXj = 1;
      ((aq)localObject1).cUP = -1;
      boolean bool = ((ar)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).a((aq)localObject1);
      Log.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((aq)localObject1).byD() + " ret:" + bool);
      break;
      label689:
      if (localHashMap != null)
      {
        paramdqh = localHashMap.keySet().iterator();
        while (paramdqh.hasNext())
        {
          localObject1 = (aq)localHashMap.get(paramdqh.next());
          if (((aq)localObject1).mXj == 0)
          {
            localObject2 = (ar)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg();
            i = ((aq)localObject1).mXe;
            Log.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((ar)localObject2).lvy.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ar)localObject2).doNotify();
              bool = true;
              Log.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((aq)localObject1).byD() + " ret:" + bool);
              localObject2 = (at)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
              i = ((aq)localObject1).mXe;
              Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((at)localObject2).lvy.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label964;
              }
            }
            label964:
            for (bool = true;; bool = false)
            {
              Log.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((aq)localObject1).byD() + " ret:" + bool);
              break;
              bool = false;
              break label814;
            }
          }
        }
      }
      label814:
      AppMethodBeat.o(131114);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(131112);
    this.callback = parami;
    parami = (caw)d.b.b(this.rr.lBR);
    if ((parami.jUk == 1) && (((ar)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).ym(parami.SXM) == null))
    {
      Log.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
      AppMethodBeat.o(131112);
      return -1;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131112);
    return i;
  }
  
  public final int getType()
  {
    return 143;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131113);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131113);
      return;
    }
    Log.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (caw)d.b.b(this.rr.lBR);
    Object localObject2 = (cax)d.c.b(this.rr.lBS);
    if (paramArrayOfByte.jUk == 0) {
      a(((cax)localObject2).Tji);
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
      while (j < ((cax)localObject2).Tjj.rVx)
      {
        localObject3 = (dqe)((cax)localObject2).Tjj.TWY.get(j);
        paramInt1 = paramArrayOfByte.SXM;
        Log.v("MicroMsg.NetSceneGetQQGroup", "friend");
        params = new as();
        params.mXm = new p(((dqe)localObject3).TWU).longValue();
        com.tencent.mm.am.d.f(params.mXm, 3);
        params.mXo = paramInt1;
        params.mXn = ((dqe)localObject3).TWW;
        label552:
        label694:
        int i;
        if (((dqe)localObject3).TWW != 0)
        {
          if ((((dqe)localObject3).UserName == null) || (((dqe)localObject3).UserName.equals("")))
          {
            params = null;
            ((List)localObject1).add(params);
            params = new j();
            params.sex = ((dqe)localObject3).mVy;
            params.hDk = ((dqe)localObject3).mVC;
            params.province = ((dqe)localObject3).mVz;
            params.city = ((dqe)localObject3).mVA;
            params.signature = ((dqe)localObject3).mVB;
            params.username = ((dqe)localObject3).UserName;
            localArrayList1.add(params);
            params = new com.tencent.mm.am.j();
            params.hDc = 3;
            params.gg(true);
            params.username = ((dqe)localObject3).UserName;
            params.lBe = ((dqe)localObject3).SjI;
            params.lBd = ((dqe)localObject3).SjJ;
            localArrayList2.add(params);
            j += 1;
            continue;
          }
          com.tencent.mm.storage.as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(((dqe)localObject3).UserName);
          if ((localas != null) && (localas.field_username.equals(((dqe)localObject3).UserName)) && (com.tencent.mm.contact.d.rk(localas.field_type))) {
            params.mXn = 2;
          }
        }
        else
        {
          params.username = ((dqe)localObject3).UserName;
          params.nickname = ((dqe)localObject3).rWI;
          params.mXu = ((dqe)localObject3).TWX;
          params.mXv = f.ZK(((dqe)localObject3).TWX);
          params.mXw = f.ZJ(((dqe)localObject3).TWX);
          params.mXp = f.ZK(((dqe)localObject3).rWI);
          params.mXq = f.ZJ(((dqe)localObject3).rWI);
          params.mXr = ((dqe)localObject3).TWV;
          params.mXs = f.ZK(((dqe)localObject3).TWV);
          params.mXt = f.ZJ(((dqe)localObject3).TWV);
          paramInt1 = 32;
          if (Util.isNullOrNil(params.byJ())) {
            break label791;
          }
          paramInt1 = params.byJ().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          params.lBa = i;
          com.tencent.mm.plugin.c.a.bBt().bcn().nG(((dqe)localObject3).UserName, ((dqe)localObject3).Tav);
          Log.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + params.byF() + "  remark: " + params.byI());
          break;
          params.mXn = 1;
          break label552;
          label791:
          if (!Util.isNullOrNil(params.byK()))
          {
            paramInt1 = params.byK().charAt(0);
            break label694;
          }
          if (!Util.isNullOrNil(params.byG()))
          {
            paramInt1 = params.byG().charAt(0);
            break label694;
          }
          if (Util.isNullOrNil(params.byH())) {
            break label694;
          }
          paramInt1 = params.byH().charAt(0);
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
      params = new HashMap();
      localObject2 = (at)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
      paramInt1 = paramArrayOfByte.SXM;
      Log.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((at)localObject2).lvy.rawQuery((String)localObject3, null);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new as();
        ((as)localObject3).convertFrom((Cursor)localObject2);
        params.put(Long.valueOf(((as)localObject3).mXm), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (as)((Iterator)localObject1).next();
        if (params.containsKey(Long.valueOf(((as)localObject2).mXm)))
        {
          localObject3 = (as)params.get(Long.valueOf(((as)localObject2).mXm));
          if (!Util.compare(Long.valueOf(((as)localObject3).mXm), Long.valueOf(((as)localObject2).mXm))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1524;
            }
            ((at)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(((as)localObject2).mXm, (as)localObject2);
            params.remove(Long.valueOf(((as)localObject2).mXm));
            break;
            if (!Util.compare(Integer.valueOf(((as)localObject3).mXn), Integer.valueOf(((as)localObject2).mXn))) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((as)localObject3).mXo), Integer.valueOf(((as)localObject2).mXo))) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).username, ((as)localObject2).username)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).nickname, ((as)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXp, ((as)localObject2).mXp)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXq, ((as)localObject2).mXq)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXr, ((as)localObject2).mXr)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXs, ((as)localObject2).mXs)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXt, ((as)localObject2).mXt)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXu, ((as)localObject2).mXu)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXv, ((as)localObject2).mXv)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).mXw, ((as)localObject2).mXw)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).lAY, ((as)localObject2).lAY)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).lAZ, ((as)localObject2).lAZ)) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((as)localObject3).lBa), Integer.valueOf(((as)localObject2).lBa))) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((as)localObject3).lBb), Integer.valueOf(((as)localObject2).lBb))) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
          }
        }
        else
        {
          label1524:
          ((at)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a((as)localObject2);
        }
      }
      params = params.keySet().iterator();
      while (params.hasNext())
      {
        long l = ((Long)params.next()).longValue();
        localObject1 = (at)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
        Log.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(l)));
        if (((at)localObject1).lvy.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((at)localObject1).doNotify(5, (MStorageEx)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getFrdExtStg()).at(localArrayList1);
      com.tencent.mm.am.q.bhP().at(localArrayList2);
      params = new aq();
      params.mXe = paramArrayOfByte.SXM;
      params.mXj = 0;
      params.mXi = ((int)Util.nowSecond());
      params.cUP = 48;
      ((ar)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).a(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */