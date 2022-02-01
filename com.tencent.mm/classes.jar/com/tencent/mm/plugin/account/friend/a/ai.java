package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bne;
import com.tencent.mm.protocal.protobuf.bnf;
import com.tencent.mm.protocal.protobuf.bvb;
import com.tencent.mm.protocal.protobuf.bvc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends com.tencent.mm.ak.n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private HashMap<String, n> jey;
  private ArrayList<n> jhr;
  private int jhs;
  private int jht;
  private int jhu;
  private int mEntryScene;
  private String mToken;
  private final b rr;
  
  public ai(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    AppMethodBeat.i(131126);
    this.jey = new HashMap();
    b.a locala = new b.a();
    locala.hQF = new bvb();
    locala.hQG = new bvc();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.jhr = paramArrayList;
    this.mEntryScene = paramInt;
    this.jhs = 0;
    this.jhu = 1;
    this.jey = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(131126);
  }
  
  private void a(bvc parambvc)
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
        ae.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(parambvc.nID) });
        if ((parambvc.nIE == null) || (parambvc.nIE.size() <= 0)) {
          break label574;
        }
        int k = parambvc.nIE.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        bne localbne = (bne)parambvc.nIE.get(j);
        if (TextUtils.isEmpty(localbne.nIJ)) {
          break label594;
        }
        localObject1 = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localbne.nIJ);
        if ((localObject1 == null) || (!com.tencent.mm.contact.c.lO(((aw)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.jey == null) || (!this.jey.containsKey(localbne.FVP))) {
          break label582;
        }
        localObject2 = (n)this.jey.get(localbne.FVP);
        ((n)localObject2).field_username = localbne.nIJ;
        ((n)localObject2).field_nickname = localbne.nJO;
        ((n)localObject2).field_usernamepy = com.tencent.mm.platformtools.f.Jl(localbne.nJO);
        ((n)localObject2).field_nicknameqp = com.tencent.mm.platformtools.f.Jk(localbne.nJO);
        ((n)localObject2).field_ret = localbne.Ret;
        ((n)localObject2).field_small_url = localbne.Hau;
        ((n)localObject2).field_big_url = localbne.Hat;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((n)localObject2).field_googlenamepy = com.tencent.mm.platformtools.f.Jl(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.g.c.g)localObject1).field_userName = localbne.nIJ;
            ((com.tencent.mm.g.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.g.c.g)localObject1).field_ticket = localbne.GNI;
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
      Object localObject2 = p.aEN().DL(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new i();
      }
      ((i)localObject1).username = str3;
      ((i)localObject1).eQU = 3;
      ((i)localObject1).hPQ = com.tencent.mm.aj.c.aW(str1, str2);
      ((i)localObject1).hPP = com.tencent.mm.aj.c.aW(str1, str2);
      ((i)localObject1).eD(true);
      ((i)localObject1).dEu = 31;
      p.aEN().b((i)localObject1);
      continue;
      label540:
      ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).u(localArrayList);
      com.tencent.mm.plugin.c.a.aVH().aAh().hx(localLinkedList);
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
  
  public final bvc aTE()
  {
    return (bvc)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(131127);
    ae.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (bvb)this.rr.hQD.hQJ;
    int i;
    if (this.jhr != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.jht = this.jhr.size();
      i = this.jhs;
      while ((i < this.jht) && (i < this.jhs + 500))
      {
        bnf localbnf = new bnf();
        localbnf.FVP = ((n)this.jhr.get(i)).field_googlegmail;
        localLinkedList.add(localbnf);
        i += 1;
      }
      paramf.nIE = localLinkedList;
      paramf.nID = localLinkedList.size();
      if (this.jhs + 500 <= this.jht) {
        break label240;
      }
    }
    label240:
    for (this.jhu = 0;; this.jhu = 1)
    {
      paramf.GeQ = this.jhu;
      paramf.HhS = this.mEntryScene;
      ae.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.jht), Integer.valueOf(this.jhs), Integer.valueOf(this.jhu) });
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
    ae.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131128);
      return;
    }
    a(aTE());
    if (this.jhu == 1)
    {
      this.jhs += 500;
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ae.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
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
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ai
 * JD-Core Version:    0.7.0.1
 */