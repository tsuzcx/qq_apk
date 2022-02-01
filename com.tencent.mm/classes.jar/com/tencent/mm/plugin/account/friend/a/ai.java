package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bmm;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends com.tencent.mm.al.n
  implements k
{
  private com.tencent.mm.al.f callback;
  private HashMap<String, n> jbF;
  private int jeA;
  private int jeB;
  private ArrayList<n> jey;
  private int jez;
  private int mEntryScene;
  private String mToken;
  private final com.tencent.mm.al.b rr;
  
  public ai(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    AppMethodBeat.i(131126);
    this.jbF = new HashMap();
    b.a locala = new b.a();
    locala.hNM = new buh();
    locala.hNN = new bui();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.jey = paramArrayList;
    this.mEntryScene = paramInt;
    this.jez = 0;
    this.jeB = 1;
    this.jbF = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(131126);
  }
  
  private void a(bui parambui)
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
        ad.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(parambui.nDi) });
        if ((parambui.nDj == null) || (parambui.nDj.size() <= 0)) {
          break label574;
        }
        int k = parambui.nDj.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        bmm localbmm = (bmm)parambui.nDj.get(j);
        if (TextUtils.isEmpty(localbmm.nDo)) {
          break label594;
        }
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(localbmm.nDo);
        if ((localObject1 == null) || (!com.tencent.mm.o.b.lM(((aw)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.jbF == null) || (!this.jbF.containsKey(localbmm.FDu))) {
          break label582;
        }
        localObject2 = (n)this.jbF.get(localbmm.FDu);
        ((n)localObject2).field_username = localbmm.nDo;
        ((n)localObject2).field_nickname = localbmm.nEt;
        ((n)localObject2).field_usernamepy = com.tencent.mm.platformtools.f.IM(localbmm.nEt);
        ((n)localObject2).field_nicknameqp = com.tencent.mm.platformtools.f.IL(localbmm.nEt);
        ((n)localObject2).field_ret = localbmm.Ret;
        ((n)localObject2).field_small_url = localbmm.GGS;
        ((n)localObject2).field_big_url = localbmm.GGR;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((n)localObject2).field_googlenamepy = com.tencent.mm.platformtools.f.IM(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.g.c.g)localObject1).field_userName = localbmm.nDo;
            ((com.tencent.mm.g.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.g.c.g)localObject1).field_ticket = localbmm.Guj;
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
      Object localObject2 = p.aEx().Dj(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new i();
      }
      ((i)localObject1).username = str3;
      ((i)localObject1).ePj = 3;
      ((i)localObject1).hMX = c.aW(str1, str2);
      ((i)localObject1).hMW = c.aW(str1, str2);
      ((i)localObject1).eB(true);
      ((i)localObject1).dDp = 31;
      p.aEx().b((i)localObject1);
      continue;
      label540:
      ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).u(localArrayList);
      com.tencent.mm.plugin.c.a.aVi().azR().hn(localLinkedList);
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
  
  public final bui aTf()
  {
    return (bui)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(131127);
    ad.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (buh)this.rr.hNK.hNQ;
    int i;
    if (this.jey != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.jeA = this.jey.size();
      i = this.jez;
      while ((i < this.jeA) && (i < this.jez + 500))
      {
        bmn localbmn = new bmn();
        localbmn.FDu = ((n)this.jey.get(i)).field_googlegmail;
        localLinkedList.add(localbmn);
        i += 1;
      }
      paramf.nDj = localLinkedList;
      paramf.nDi = localLinkedList.size();
      if (this.jez + 500 <= this.jeA) {
        break label240;
      }
    }
    label240:
    for (this.jeB = 0;; this.jeB = 1)
    {
      paramf.FMr = this.jeB;
      paramf.GOs = this.mEntryScene;
      ad.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.jeA), Integer.valueOf(this.jez), Integer.valueOf(this.jeB) });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(131127);
      return i;
    }
  }
  
  public final int getType()
  {
    return 488;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131128);
    ad.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131128);
      return;
    }
    a(aTf());
    if (this.jeB == 1)
    {
      this.jez += 500;
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ad.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
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
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ai
 * JD-Core Version:    0.7.0.1
 */