package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bzv;
import com.tencent.mm.protocal.protobuf.bzw;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private int gQp;
  private HashMap<String, n> kcB;
  private ArrayList<n> kfv;
  private int kfw;
  private int kfx;
  private int mEntryScene;
  private String mToken;
  private final d rr;
  
  public ai(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    AppMethodBeat.i(131126);
    this.kcB = new HashMap();
    d.a locala = new d.a();
    locala.iLN = new cii();
    locala.iLO = new cij();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.kfv = paramArrayList;
    this.mEntryScene = paramInt;
    this.kfw = 0;
    this.kfx = 1;
    this.kcB = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(131126);
  }
  
  private void a(cij paramcij)
  {
    for (;;)
    {
      ArrayList localArrayList;
      LinkedList localLinkedList;
      int j;
      String str1;
      String str2;
      try
      {
        AppMethodBeat.i(131129);
        Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramcij.oTz) });
        if ((paramcij.oTA == null) || (paramcij.oTA.size() <= 0)) {
          break label574;
        }
        int k = paramcij.oTA.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        bzv localbzv = (bzv)paramcij.oTA.get(j);
        if (TextUtils.isEmpty(localbzv.UserName)) {
          break label594;
        }
        localObject1 = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(localbzv.UserName);
        if ((localObject1 == null) || (!com.tencent.mm.contact.c.oR(((ax)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.kcB == null) || (!this.kcB.containsKey(localbzv.KPA))) {
          break label582;
        }
        localObject2 = (n)this.kcB.get(localbzv.KPA);
        ((n)localObject2).field_username = localbzv.UserName;
        ((n)localObject2).field_nickname = localbzv.oUJ;
        ((n)localObject2).field_usernamepy = f.Si(localbzv.oUJ);
        ((n)localObject2).field_nicknameqp = f.Sh(localbzv.oUJ);
        ((n)localObject2).field_ret = localbzv.Ret;
        ((n)localObject2).field_small_url = localbzv.Mfu;
        ((n)localObject2).field_big_url = localbzv.Mft;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((n)localObject2).field_googlenamepy = f.Si(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.g.c.g)localObject1).field_userName = localbzv.UserName;
            ((com.tencent.mm.g.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.g.c.g)localObject1).field_ticket = localbzv.LRO;
            localLinkedList.add(localObject1);
            break label582;
          }
        }
        else
        {
          ((n)localObject2).field_contecttype = "google";
          continue;
        }
        str3 = (String)localObject1 + "@google";
      }
      finally {}
      String str3;
      Object localObject2 = p.aYB().Mx(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new com.tencent.mm.aj.i();
      }
      ((com.tencent.mm.aj.i)localObject1).username = str3;
      ((com.tencent.mm.aj.i)localObject1).fuz = 3;
      ((com.tencent.mm.aj.i)localObject1).iKX = com.tencent.mm.aj.c.ba(str1, str2);
      ((com.tencent.mm.aj.i)localObject1).iKW = com.tencent.mm.aj.c.ba(str1, str2);
      ((com.tencent.mm.aj.i)localObject1).fv(true);
      ((com.tencent.mm.aj.i)localObject1).cSx = 31;
      p.aYB().b((com.tencent.mm.aj.i)localObject1);
      continue;
      label540:
      ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).z(localArrayList);
      com.tencent.mm.plugin.c.a.bqE().aTp().iB(localLinkedList);
      label574:
      AppMethodBeat.o(131129);
      return;
      label582:
      j += 1;
      continue;
      label589:
      int i = 0;
      continue;
      label594:
      i = 1;
    }
  }
  
  public final cij boq()
  {
    return (cij)this.rr.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(131127);
    Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = parami;
    parami = (cii)this.rr.iLK.iLR;
    int i;
    if (this.kfv != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.gQp = this.kfv.size();
      i = this.kfw;
      while ((i < this.gQp) && (i < this.kfw + 500))
      {
        bzw localbzw = new bzw();
        localbzw.KPA = ((n)this.kfv.get(i)).field_googlegmail;
        localLinkedList.add(localbzw);
        i += 1;
      }
      parami.oTA = localLinkedList;
      parami.oTz = localLinkedList.size();
      if (this.kfw + 500 <= this.gQp) {
        break label240;
      }
    }
    label240:
    for (this.kfx = 0;; this.kfx = 1)
    {
      parami.KZh = this.kfx;
      parami.Mnu = this.mEntryScene;
      Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.gQp), Integer.valueOf(this.kfw), Integer.valueOf(this.kfx) });
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(131127);
      return i;
    }
  }
  
  public final int getType()
  {
    return 488;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131128);
    Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131128);
      return;
    }
    a(boq());
    if (this.kfx == 1)
    {
      this.kfw += 500;
      if (doScene(dispatcher(), this.callback) < 0)
      {
        Log.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(131128);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ai
 * JD-Core Version:    0.7.0.1
 */