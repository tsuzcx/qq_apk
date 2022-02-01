package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.protocal.protobuf.eiz;
import com.tencent.mm.protocal.protobuf.eja;
import com.tencent.mm.protocal.protobuf.ejb;
import com.tencent.mm.protocal.protobuf.ejc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ac
  extends com.tencent.mm.am.p
  implements m
{
  private com.tencent.mm.am.h callback;
  public final c rr;
  
  public ac(int paramInt)
  {
    AppMethodBeat.i(131111);
    this.callback = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cqf();
    ((c.a)localObject).otF = new cqg();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((c.a)localObject).funcId = 143;
    ((c.a)localObject).otG = 38;
    ((c.a)localObject).respCmdId = 1000000038;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cqf)c.b.b(this.rr.otB);
    ((cqf)localObject).muC = 1;
    ((cqf)localObject).aajG = paramInt;
    AppMethodBeat.o(131111);
  }
  
  private static void a(ejc paramejc)
  {
    AppMethodBeat.i(131114);
    Object localObject1 = ((ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).omV.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label41:
      if (i >= paramejc.vgN) {
        break label689;
      }
      localObject2 = (ejb)paramejc.abnS.get(i);
      Log.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((ejb)localObject2).aajG + " name:" + ((ejb)localObject2).aajr + " mem:" + ((ejb)localObject2).ZvC + " wei:" + ((ejb)localObject2).abnR + " md5:" + ((ejb)localObject2).MD5);
      if (((ejb)localObject2).aajG >= 0) {
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
    while (((an)localObject1).pTN == 0)
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
        localObject2 = new an();
        ((an)localObject2).convertFrom((Cursor)localObject1);
        localHashMap.put(Integer.valueOf(((an)localObject2).pTM), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new an();
      ((an)localObject1).pTM = ((ejb)localObject2).aajG;
      ((an)localObject1).pTT = ((ejb)localObject2).aajr;
      ((an)localObject1).pTN = ((ejb)localObject2).ZvC;
      ((an)localObject1).pTO = ((ejb)localObject2).abnR;
      ((an)localObject1).pTS = ((ejb)localObject2).MD5;
      break label150;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (an)localHashMap.get(Integer.valueOf(((an)localObject1).pTM));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((an)localObject1).pTP = ((int)Util.nowSecond());
        ((an)localObject1).pTQ = ((int)Util.nowSecond());
        ((an)localObject1).pTR = 1;
        localObject2 = (ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          Log.d("MicroMsg.QQGroupStorage", "insert: name:" + ((an)localObject1).bXr());
          ((an)localObject1).eQp = -1;
          ContentValues localContentValues = ((an)localObject1).bXp();
          if ((int)((ao)localObject2).omV.insert("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ao)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          Log.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((an)localObject1).bXr() + " ret:" + bool);
          break;
        }
      }
      ((an)localObject2).pTR = -1;
      Log.d("MicroMsg.NetSceneGetQQGroup", ((an)localObject1).bXq() + " " + ((an)localObject2).bXq() + " " + ((an)localObject1).pTM);
      if (((an)localObject2).bXq().equals(((an)localObject1).bXq())) {
        break;
      }
      ((an)localObject1).pTQ = ((int)Util.nowSecond());
      ((an)localObject1).pTR = 1;
      ((an)localObject1).eQp = -1;
      boolean bool = ((ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).a((an)localObject1);
      Log.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((an)localObject1).bXr() + " ret:" + bool);
      break;
      label689:
      if (localHashMap != null)
      {
        paramejc = localHashMap.keySet().iterator();
        while (paramejc.hasNext())
        {
          localObject1 = (an)localHashMap.get(paramejc.next());
          if (((an)localObject1).pTR == 0)
          {
            localObject2 = (ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg();
            i = ((an)localObject1).pTM;
            Log.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((ao)localObject2).omV.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ao)localObject2).doNotify();
              bool = true;
              Log.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((an)localObject1).bXr() + " ret:" + bool);
              localObject2 = (aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
              i = ((an)localObject1).pTM;
              Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((aq)localObject2).omV.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label964;
              }
            }
            label964:
            for (bool = true;; bool = false)
            {
              Log.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((an)localObject1).bXr() + " ret:" + bool);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131112);
    this.callback = paramh;
    paramh = (cqf)c.b.b(this.rr.otB);
    if ((paramh.muC == 1) && (((ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).ys(paramh.aajG) == null))
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
    paramArrayOfByte = (cqf)c.b.b(this.rr.otB);
    Object localObject2 = (cqg)c.c.b(this.rr.otC);
    if (paramArrayOfByte.muC == 0) {
      a(((cqg)localObject2).aawL);
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
      while (j < ((cqg)localObject2).aawM.vgN)
      {
        localObject3 = (eiz)((cqg)localObject2).aawM.abnQ.get(j);
        paramInt1 = paramArrayOfByte.aajG;
        Log.v("MicroMsg.NetSceneGetQQGroup", "friend");
        params = new ap();
        params.pTU = new com.tencent.mm.b.p(((eiz)localObject3).abnM).longValue();
        com.tencent.mm.modelavatar.d.n(params.pTU, 3);
        params.pTW = paramInt1;
        params.pTV = ((eiz)localObject3).abnO;
        label552:
        label694:
        int i;
        if (((eiz)localObject3).abnO != 0)
        {
          if ((((eiz)localObject3).UserName == null) || (((eiz)localObject3).UserName.equals("")))
          {
            params = null;
            ((List)localObject1).add(params);
            params = new g();
            params.sex = ((eiz)localObject3).pSf;
            params.kag = ((eiz)localObject3).pSj;
            params.province = ((eiz)localObject3).pSg;
            params.city = ((eiz)localObject3).pSh;
            params.signature = ((eiz)localObject3).pSi;
            params.username = ((eiz)localObject3).UserName;
            localArrayList1.add(params);
            params = new j();
            params.jZY = 3;
            params.gX(true);
            params.username = ((eiz)localObject3).UserName;
            params.osN = ((eiz)localObject3).ZhO;
            params.osM = ((eiz)localObject3).ZhP;
            localArrayList2.add(params);
            j += 1;
            continue;
          }
          au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(((eiz)localObject3).UserName);
          if ((localau != null) && (localau.field_username.equals(((eiz)localObject3).UserName)) && (com.tencent.mm.contact.d.rs(localau.field_type))) {
            params.pTV = 2;
          }
        }
        else
        {
          params.username = ((eiz)localObject3).UserName;
          params.nickname = ((eiz)localObject3).vhX;
          params.pUc = ((eiz)localObject3).abnP;
          params.pUd = f.Sa(((eiz)localObject3).abnP);
          params.pUe = f.RZ(((eiz)localObject3).abnP);
          params.pTX = f.Sa(((eiz)localObject3).vhX);
          params.pTY = f.RZ(((eiz)localObject3).vhX);
          params.pTZ = ((eiz)localObject3).abnN;
          params.pUa = f.Sa(((eiz)localObject3).abnN);
          params.pUb = f.RZ(((eiz)localObject3).abnN);
          paramInt1 = 32;
          if (Util.isNullOrNil(params.bXx())) {
            break label791;
          }
          paramInt1 = params.bXx().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          params.osC = i;
          com.tencent.mm.plugin.c.a.caJ().bAc().pE(((eiz)localObject3).UserName, ((eiz)localObject3).aant);
          Log.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + params.bXt() + "  remark: " + params.bXw());
          break;
          params.pTV = 1;
          break label552;
          label791:
          if (!Util.isNullOrNil(params.bXy()))
          {
            paramInt1 = params.bXy().charAt(0);
            break label694;
          }
          if (!Util.isNullOrNil(params.bXu()))
          {
            paramInt1 = params.bXu().charAt(0);
            break label694;
          }
          if (Util.isNullOrNil(params.bXv())) {
            break label694;
          }
          paramInt1 = params.bXv().charAt(0);
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
      localObject2 = (aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
      paramInt1 = paramArrayOfByte.aajG;
      Log.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((aq)localObject2).omV.rawQuery((String)localObject3, null);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new ap();
        ((ap)localObject3).convertFrom((Cursor)localObject2);
        params.put(Long.valueOf(((ap)localObject3).pTU), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ap)((Iterator)localObject1).next();
        if (params.containsKey(Long.valueOf(((ap)localObject2).pTU)))
        {
          localObject3 = (ap)params.get(Long.valueOf(((ap)localObject2).pTU));
          if (!Util.compare(Long.valueOf(((ap)localObject3).pTU), Long.valueOf(((ap)localObject2).pTU))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1524;
            }
            ((aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a(((ap)localObject2).pTU, (ap)localObject2);
            params.remove(Long.valueOf(((ap)localObject2).pTU));
            break;
            if (!Util.compare(Integer.valueOf(((ap)localObject3).pTV), Integer.valueOf(((ap)localObject2).pTV))) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((ap)localObject3).pTW), Integer.valueOf(((ap)localObject2).pTW))) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).username, ((ap)localObject2).username)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).nickname, ((ap)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pTX, ((ap)localObject2).pTX)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pTY, ((ap)localObject2).pTY)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pTZ, ((ap)localObject2).pTZ)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pUa, ((ap)localObject2).pUa)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pUb, ((ap)localObject2).pUb)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pUc, ((ap)localObject2).pUc)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pUd, ((ap)localObject2).pUd)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).pUe, ((ap)localObject2).pUe)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).osA, ((ap)localObject2).osA)) {
              paramInt1 = 0;
            } else if (!Util.compare(((ap)localObject3).osB, ((ap)localObject2).osB)) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((ap)localObject3).osC), Integer.valueOf(((ap)localObject2).osC))) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((ap)localObject3).osD), Integer.valueOf(((ap)localObject2).osD))) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
          }
        }
        else
        {
          label1524:
          ((aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg()).a((ap)localObject2);
        }
      }
      params = params.keySet().iterator();
      while (params.hasNext())
      {
        long l = ((Long)params.next()).longValue();
        localObject1 = (aq)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQListStg();
        Log.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(l)));
        if (((aq)localObject1).omV.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((aq)localObject1).doNotify(5, (MStorageEx)localObject1, String.valueOf(l));
        }
      }
      ((h)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getFrdExtStg()).bY(localArrayList1);
      q.bFE().bY(localArrayList2);
      params = new an();
      params.pTM = paramArrayOfByte.aajG;
      params.pTR = 0;
      params.pTQ = ((int)Util.nowSecond());
      params.eQp = 48;
      ((ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg()).a(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.ac
 * JD-Core Version:    0.7.0.1
 */