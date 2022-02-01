package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.cre;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private int jAI;
  private int mEntryScene;
  private String mToken;
  private HashMap<String, n> mUa;
  private ArrayList<n> mWU;
  private int mWV;
  private int mWW;
  private final com.tencent.mm.an.d rr;
  
  public ai(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    AppMethodBeat.i(131126);
    this.mUa = new HashMap();
    d.a locala = new d.a();
    locala.lBU = new cre();
    locala.lBV = new crf();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.mWU = paramArrayList;
    this.mEntryScene = paramInt;
    this.mWV = 0;
    this.mWW = 1;
    this.mUa = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(131126);
  }
  
  private void a(crf paramcrf)
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
        Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramcrf.rVx) });
        if ((paramcrf.rVy == null) || (paramcrf.rVy.size() <= 0)) {
          break label574;
        }
        int k = paramcrf.rVy.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        chq localchq = (chq)paramcrf.rVy.get(j);
        if (TextUtils.isEmpty(localchq.UserName)) {
          break label594;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(localchq.UserName);
        if ((localObject1 == null) || (!com.tencent.mm.contact.d.rk(((ax)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.mUa == null) || (!this.mUa.containsKey(localchq.RQy))) {
          break label582;
        }
        localObject2 = (n)this.mUa.get(localchq.RQy);
        ((n)localObject2).field_username = localchq.UserName;
        ((n)localObject2).field_nickname = localchq.rWI;
        ((n)localObject2).field_usernamepy = f.ZK(localchq.rWI);
        ((n)localObject2).field_nicknameqp = f.ZJ(localchq.rWI);
        ((n)localObject2).field_ret = localchq.CqV;
        ((n)localObject2).field_small_url = localchq.ToY;
        ((n)localObject2).field_big_url = localchq.ToX;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((n)localObject2).field_googlenamepy = f.ZK(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.f.c.g)localObject1).field_userName = localchq.UserName;
            ((com.tencent.mm.f.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.f.c.g)localObject1).field_ticket = localchq.Tav;
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
      Object localObject2 = com.tencent.mm.am.q.bhP().TS(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new j();
      }
      ((j)localObject1).username = str3;
      ((j)localObject1).hDc = 3;
      ((j)localObject1).lBe = com.tencent.mm.am.d.bf(str1, str2);
      ((j)localObject1).lBd = com.tencent.mm.am.d.bf(str1, str2);
      ((j)localObject1).gg(true);
      ((j)localObject1).cUP = 31;
      com.tencent.mm.am.q.bhP().b((j)localObject1);
      continue;
      label540:
      ((o)((com.tencent.mm.plugin.account.sdk.a.a)h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).A(localArrayList);
      com.tencent.mm.plugin.c.a.bBt().bcn().jt(localLinkedList);
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
  
  public final crf byz()
  {
    AppMethodBeat.i(193917);
    crf localcrf = (crf)d.c.b(this.rr.lBS);
    AppMethodBeat.o(193917);
    return localcrf;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(131127);
    Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = parami;
    parami = (cre)d.b.b(this.rr.lBR);
    int i;
    if (this.mWU != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.jAI = this.mWU.size();
      i = this.mWV;
      while ((i < this.jAI) && (i < this.mWV + 500))
      {
        chr localchr = new chr();
        localchr.RQy = ((n)this.mWU.get(i)).field_googlegmail;
        localLinkedList.add(localchr);
        i += 1;
      }
      parami.rVy = localLinkedList;
      parami.rVx = localLinkedList.size();
      if (this.mWV + 500 <= this.jAI) {
        break label240;
      }
    }
    label240:
    for (this.mWW = 0;; this.mWW = 1)
    {
      parami.Saq = this.mWW;
      parami.Typ = this.mEntryScene;
      Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.jAI), Integer.valueOf(this.mWV), Integer.valueOf(this.mWW) });
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
    a(byz());
    if (this.mWW == 1)
    {
      this.mWV += 500;
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
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ai
 * JD-Core Version:    0.7.0.1
 */