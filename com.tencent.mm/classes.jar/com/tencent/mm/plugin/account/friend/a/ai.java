package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bpu;
import com.tencent.mm.protocal.protobuf.bpv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private HashMap<String, n> iIw;
  private ArrayList<n> iLp;
  private int iLq;
  private int iLr;
  private int iLs;
  private int mEntryScene;
  private String mToken;
  private final com.tencent.mm.ak.b rr;
  
  public ai(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    AppMethodBeat.i(131126);
    this.iIw = new HashMap();
    b.a locala = new b.a();
    locala.hvt = new bpu();
    locala.hvu = new bpv();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.iLp = paramArrayList;
    this.mEntryScene = paramInt;
    this.iLq = 0;
    this.iLs = 1;
    this.iIw = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(131126);
  }
  
  private void a(bpv parambpv)
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
        ac.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(parambpv.ncL) });
        if ((parambpv.ncM == null) || (parambpv.ncM.size() <= 0)) {
          break label574;
        }
        int k = parambpv.ncM.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        bie localbie = (bie)parambpv.ncM.get(j);
        if (TextUtils.isEmpty(localbie.ncR)) {
          break label594;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localbie.ncR);
        if ((localObject1 == null) || (!com.tencent.mm.n.b.ln(((av)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.iIw == null) || (!this.iIw.containsKey(localbie.DXY))) {
          break label582;
        }
        localObject2 = (n)this.iIw.get(localbie.DXY);
        ((n)localObject2).field_username = localbie.ncR;
        ((n)localObject2).field_nickname = localbie.ndW;
        ((n)localObject2).field_usernamepy = f.Fw(localbie.ndW);
        ((n)localObject2).field_nicknameqp = f.Fv(localbie.ndW);
        ((n)localObject2).field_ret = localbie.Ret;
        ((n)localObject2).field_small_url = localbie.EXw;
        ((n)localObject2).field_big_url = localbie.EXv;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((n)localObject2).field_googlenamepy = f.Fw(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.g.c.g)localObject1).field_userName = localbie.ncR;
            ((com.tencent.mm.g.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.g.c.g)localObject1).field_ticket = localbie.ELg;
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
      Object localObject2 = p.aBw().Ak(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new i();
      }
      ((i)localObject1).username = str3;
      ((i)localObject1).exK = 3;
      ((i)localObject1).huF = c.aV(str1, str2);
      ((i)localObject1).huE = c.aV(str1, str2);
      ((i)localObject1).ez(true);
      ((i)localObject1).drx = 31;
      p.aBw().b((i)localObject1);
      continue;
      label540:
      ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).u(localArrayList);
      com.tencent.mm.plugin.c.a.aRW().axc().hc(localLinkedList);
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
  
  public final bpv aPT()
  {
    return (bpv)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(131127);
    ac.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = paramg;
    paramg = (bpu)this.rr.hvr.hvw;
    int i;
    if (this.iLp != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.iLr = this.iLp.size();
      i = this.iLq;
      while ((i < this.iLr) && (i < this.iLq + 500))
      {
        bif localbif = new bif();
        localbif.DXY = ((n)this.iLp.get(i)).field_googlegmail;
        localLinkedList.add(localbif);
        i += 1;
      }
      paramg.ncM = localLinkedList;
      paramg.ncL = localLinkedList.size();
      if (this.iLq + 500 <= this.iLr) {
        break label240;
      }
    }
    label240:
    for (this.iLs = 0;; this.iLs = 1)
    {
      paramg.EfS = this.iLs;
      paramg.FeO = this.mEntryScene;
      ac.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.iLr), Integer.valueOf(this.iLq), Integer.valueOf(this.iLs) });
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
    ac.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131128);
      return;
    }
    a(aPT());
    if (this.iLs == 1)
    {
      this.iLq += 500;
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ac.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
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
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ai
 * JD-Core Version:    0.7.0.1
 */