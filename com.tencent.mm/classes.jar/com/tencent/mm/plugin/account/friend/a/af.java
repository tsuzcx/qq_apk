package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.dgk;
import com.tencent.mm.protocal.protobuf.dgl;
import com.tencent.mm.protocal.protobuf.dgm;
import com.tencent.mm.protocal.protobuf.dgn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class af
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  public final d rr;
  
  public af(int paramInt)
  {
    AppMethodBeat.i(131111);
    this.callback = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bte();
    ((d.a)localObject).iLO = new btf();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getqqgroup";
    ((d.a)localObject).funcId = 143;
    ((d.a)localObject).iLP = 38;
    ((d.a)localObject).respCmdId = 1000000038;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bte)this.rr.iLK.iLR;
    ((bte)localObject).him = 1;
    ((bte)localObject).LPy = paramInt;
    AppMethodBeat.o(131111);
  }
  
  private static void a(dgn paramdgn)
  {
    AppMethodBeat.i(131114);
    Object localObject1 = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).iFy.rawQuery("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null);
    HashMap localHashMap;
    int i;
    if (localObject1 == null)
    {
      localHashMap = null;
      i = 0;
      label41:
      if (i >= paramdgn.oTz) {
        break label689;
      }
      localObject2 = (dgm)paramdgn.MLf.get(i);
      Log.d("MicroMsg.NetSceneGetQQGroup", "id:" + ((dgm)localObject2).LPy + " name:" + ((dgm)localObject2).LPg + " mem:" + ((dgm)localObject2).Ltc + " wei:" + ((dgm)localObject2).MLe + " md5:" + ((dgm)localObject2).MD5);
      if (((dgm)localObject2).LPy >= 0) {
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
    while (((aq)localObject1).kfG == 0)
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
        localHashMap.put(Integer.valueOf(((aq)localObject2).kfF), localObject2);
        i += 1;
      }
      ((Cursor)localObject1).close();
      break;
      localObject1 = new aq();
      ((aq)localObject1).kfF = ((dgm)localObject2).LPy;
      ((aq)localObject1).kfM = ((dgm)localObject2).LPg;
      ((aq)localObject1).kfG = ((dgm)localObject2).Ltc;
      ((aq)localObject1).kfH = ((dgm)localObject2).MLe;
      ((aq)localObject1).kfL = ((dgm)localObject2).MD5;
      break label150;
    }
    if (localHashMap != null) {}
    for (Object localObject2 = (aq)localHashMap.get(Integer.valueOf(((aq)localObject1).kfF));; localObject2 = null)
    {
      if (localObject2 == null)
      {
        ((aq)localObject1).kfI = ((int)Util.nowSecond());
        ((aq)localObject1).kfJ = ((int)Util.nowSecond());
        ((aq)localObject1).kfK = 1;
        localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        if (localObject1 != null)
        {
          Log.d("MicroMsg.QQGroupStorage", "insert: name:" + ((aq)localObject1).bou());
          ((aq)localObject1).cSx = -1;
          ContentValues localContentValues = ((aq)localObject1).bos();
          if ((int)((ar)localObject2).iFy.insert("qqgroup", "grouopid", localContentValues) >= 0) {
            ((ar)localObject2).doNotify();
          }
        }
        for (bool = true;; bool = false)
        {
          Log.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + ((aq)localObject1).bou() + " ret:" + bool);
          break;
        }
      }
      ((aq)localObject2).kfK = -1;
      Log.d("MicroMsg.NetSceneGetQQGroup", ((aq)localObject1).bot() + " " + ((aq)localObject2).bot() + " " + ((aq)localObject1).kfF);
      if (((aq)localObject2).bot().equals(((aq)localObject1).bot())) {
        break;
      }
      ((aq)localObject1).kfJ = ((int)Util.nowSecond());
      ((aq)localObject1).kfK = 1;
      ((aq)localObject1).cSx = -1;
      boolean bool = ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a((aq)localObject1);
      Log.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + ((aq)localObject1).bou() + " ret:" + bool);
      break;
      label689:
      if (localHashMap != null)
      {
        paramdgn = localHashMap.keySet().iterator();
        while (paramdgn.hasNext())
        {
          localObject1 = (aq)localHashMap.get(paramdgn.next());
          if (((aq)localObject1).kfK == 0)
          {
            localObject2 = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
            i = ((aq)localObject1).kfF;
            Log.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(i)));
            if (((ar)localObject2).iFy.delete("qqgroup", "grouopid= ?", new String[] { String.valueOf(i) }) > 0)
            {
              ((ar)localObject2).doNotify();
              bool = true;
              Log.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + ((aq)localObject1).bou() + " ret:" + bool);
              localObject2 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
              i = ((aq)localObject1).kfF;
              Log.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(i)));
              if (((at)localObject2).iFy.delete("qqlist", "groupid= ?", new String[] { String.valueOf(i) }) <= 0) {
                break label964;
              }
            }
            label964:
            for (bool = true;; bool = false)
            {
              Log.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + ((aq)localObject1).bou() + " ret:" + bool);
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(131112);
    this.callback = parami;
    parami = (bte)this.rr.iLK.iLR;
    if ((parami.him == 1) && (((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).vi(parami.LPy) == null))
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
    paramArrayOfByte = (bte)this.rr.iLK.iLR;
    Object localObject2 = (btf)this.rr.iLL.iLR;
    if (paramArrayOfByte.him == 0) {
      a(((btf)localObject2).LZP);
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
      while (j < ((btf)localObject2).LZQ.oTz)
      {
        localObject3 = (dgk)((btf)localObject2).LZQ.MLd.get(j);
        paramInt1 = paramArrayOfByte.LPy;
        Log.v("MicroMsg.NetSceneGetQQGroup", "friend");
        params = new as();
        params.kfN = new com.tencent.mm.b.p(((dgk)localObject3).MKZ).longValue();
        com.tencent.mm.aj.c.e(params.kfN, 3);
        params.kfP = paramInt1;
        params.kfO = ((dgk)localObject3).MLb;
        label552:
        label694:
        int i;
        if (((dgk)localObject3).MLb != 0)
        {
          if ((((dgk)localObject3).UserName == null) || (((dgk)localObject3).UserName.equals("")))
          {
            params = null;
            ((List)localObject1).add(params);
            params = new j();
            params.fuA = ((dgk)localObject3).kdY;
            params.fuI = ((dgk)localObject3).kec;
            params.fuJ = ((dgk)localObject3).kdZ;
            params.fuK = ((dgk)localObject3).kea;
            params.signature = ((dgk)localObject3).keb;
            params.username = ((dgk)localObject3).UserName;
            localArrayList1.add(params);
            params = new com.tencent.mm.aj.i();
            params.fuz = 3;
            params.fv(true);
            params.username = ((dgk)localObject3).UserName;
            params.iKX = ((dgk)localObject3).Lir;
            params.iKW = ((dgk)localObject3).Lis;
            localArrayList2.add(params);
            j += 1;
            continue;
          }
          com.tencent.mm.storage.as localas = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(((dgk)localObject3).UserName);
          if ((localas != null) && (localas.field_username.equals(((dgk)localObject3).UserName)) && (com.tencent.mm.contact.c.oR(localas.field_type))) {
            params.kfO = 2;
          }
        }
        else
        {
          params.username = ((dgk)localObject3).UserName;
          params.nickname = ((dgk)localObject3).oUJ;
          params.kfV = ((dgk)localObject3).MLc;
          params.kfW = f.Si(((dgk)localObject3).MLc);
          params.kfX = f.Sh(((dgk)localObject3).MLc);
          params.kfQ = f.Si(((dgk)localObject3).oUJ);
          params.kfR = f.Sh(((dgk)localObject3).oUJ);
          params.kfS = ((dgk)localObject3).MLa;
          params.kfT = f.Si(((dgk)localObject3).MLa);
          params.kfU = f.Sh(((dgk)localObject3).MLa);
          paramInt1 = 32;
          if (Util.isNullOrNil(params.boA())) {
            break label791;
          }
          paramInt1 = params.boA().charAt(0);
          if ((paramInt1 < 97) || (paramInt1 > 122)) {
            break label863;
          }
          i = (char)(paramInt1 - 32);
        }
        for (;;)
        {
          params.iKT = i;
          com.tencent.mm.plugin.c.a.bqE().aTp().mP(((dgk)localObject3).UserName, ((dgk)localObject3).LRO);
          Log.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + params.bow() + "  remark: " + params.boz());
          break;
          params.kfO = 1;
          break label552;
          label791:
          if (!Util.isNullOrNil(params.boB()))
          {
            paramInt1 = params.boB().charAt(0);
            break label694;
          }
          if (!Util.isNullOrNil(params.box()))
          {
            paramInt1 = params.box().charAt(0);
            break label694;
          }
          if (Util.isNullOrNil(params.boy())) {
            break label694;
          }
          paramInt1 = params.boy().charAt(0);
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
      localObject2 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
      paramInt1 = paramArrayOfByte.LPy;
      Log.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(paramInt1)));
      Object localObject3 = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + paramInt1 + "\"";
      localObject2 = ((at)localObject2).iFy.rawQuery((String)localObject3, null);
      while (((Cursor)localObject2).moveToNext())
      {
        localObject3 = new as();
        ((as)localObject3).convertFrom((Cursor)localObject2);
        params.put(Long.valueOf(((as)localObject3).kfN), localObject3);
      }
      ((Cursor)localObject2).close();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (as)((Iterator)localObject1).next();
        if (params.containsKey(Long.valueOf(((as)localObject2).kfN)))
        {
          localObject3 = (as)params.get(Long.valueOf(((as)localObject2).kfN));
          if (!Util.compare(Long.valueOf(((as)localObject3).kfN), Long.valueOf(((as)localObject2).kfN))) {
            paramInt1 = 0;
          }
          for (;;)
          {
            if (paramInt1 != 0) {
              break label1524;
            }
            ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(((as)localObject2).kfN, (as)localObject2);
            params.remove(Long.valueOf(((as)localObject2).kfN));
            break;
            if (!Util.compare(Integer.valueOf(((as)localObject3).kfO), Integer.valueOf(((as)localObject2).kfO))) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((as)localObject3).kfP), Integer.valueOf(((as)localObject2).kfP))) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).username, ((as)localObject2).username)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).nickname, ((as)localObject2).nickname)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfQ, ((as)localObject2).kfQ)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfR, ((as)localObject2).kfR)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfS, ((as)localObject2).kfS)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfT, ((as)localObject2).kfT)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfU, ((as)localObject2).kfU)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfV, ((as)localObject2).kfV)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfW, ((as)localObject2).kfW)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).kfX, ((as)localObject2).kfX)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).iKR, ((as)localObject2).iKR)) {
              paramInt1 = 0;
            } else if (!Util.compare(((as)localObject3).iKS, ((as)localObject2).iKS)) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((as)localObject3).iKT), Integer.valueOf(((as)localObject2).iKT))) {
              paramInt1 = 0;
            } else if (!Util.compare(Integer.valueOf(((as)localObject3).iKU), Integer.valueOf(((as)localObject2).iKU))) {
              paramInt1 = 0;
            } else {
              paramInt1 = 1;
            }
          }
        }
        else
        {
          label1524:
          ((at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a((as)localObject2);
        }
      }
      params = params.keySet().iterator();
      while (params.hasNext())
      {
        long l = ((Long)params.next()).longValue();
        localObject1 = (at)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
        Log.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(l)));
        if (((at)localObject1).iFy.delete("qqlist", "qq= ?", new String[] { String.valueOf(l) }) > 0) {
          ((at)localObject1).doNotify(5, (MStorageEx)localObject1, String.valueOf(l));
        }
      }
      ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).av(localArrayList1);
      com.tencent.mm.aj.p.aYB().av(localArrayList2);
      params = new aq();
      params.kfF = paramArrayOfByte.LPy;
      params.kfK = 0;
      params.kfJ = ((int)Util.nowSecond());
      params.cSx = 48;
      ((ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */