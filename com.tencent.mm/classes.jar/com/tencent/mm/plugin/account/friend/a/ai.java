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
import com.tencent.mm.g.c.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.bem;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.blw;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private HashMap<String, n> iio;
  private ArrayList<n> ili;
  private int ilj;
  private int ilk;
  private int ill;
  private int mEntryScene;
  private String mToken;
  private final com.tencent.mm.al.b rr;
  
  public ai(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    AppMethodBeat.i(131126);
    this.iio = new HashMap();
    b.a locala = new b.a();
    locala.gUU = new blw();
    locala.gUV = new blx();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.ili = paramArrayList;
    this.mEntryScene = paramInt;
    this.ilj = 0;
    this.ill = 1;
    this.iio = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(131126);
  }
  
  private void a(blx paramblx)
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
        ad.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramblx.mAK) });
        if ((paramblx.mAL == null) || (paramblx.mAL.size() <= 0)) {
          break label574;
        }
        int k = paramblx.mAL.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        bem localbem = (bem)paramblx.mAL.get(j);
        if (TextUtils.isEmpty(localbem.mAQ)) {
          break label594;
        }
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localbem.mAQ);
        if ((localObject1 == null) || (!com.tencent.mm.n.b.ls(((au)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.iio == null) || (!this.iio.containsKey(localbem.CFy))) {
          break label582;
        }
        localObject2 = (n)this.iio.get(localbem.CFy);
        ((n)localObject2).field_username = localbem.mAQ;
        ((n)localObject2).field_nickname = localbem.mBV;
        ((n)localObject2).field_usernamepy = f.Bs(localbem.mBV);
        ((n)localObject2).field_nicknameqp = f.Br(localbem.mBV);
        ((n)localObject2).field_ret = localbem.Ret;
        ((n)localObject2).field_small_url = localbem.DCa;
        ((n)localObject2).field_big_url = localbem.DBZ;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((n)localObject2).field_googlenamepy = f.Bs(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.g.c.g)localObject1).field_userName = localbem.mAQ;
            ((com.tencent.mm.g.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.g.c.g)localObject1).field_ticket = localbem.Dqd;
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
      Object localObject2 = p.auF().we(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new i();
      }
      ((i)localObject1).username = str3;
      ((i)localObject1).evo = 3;
      ((i)localObject1).gUg = c.aN(str1, str2);
      ((i)localObject1).gUf = c.aN(str1, str2);
      ((i)localObject1).ee(true);
      ((i)localObject1).dtM = 31;
      p.auF().b((i)localObject1);
      continue;
      label540:
      ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).p(localArrayList);
      com.tencent.mm.plugin.c.a.aLf().aqn().gP(localLinkedList);
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
  
  public final blx aJc()
  {
    return (blx)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(131127);
    ad.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = paramg;
    paramg = (blw)this.rr.gUS.gUX;
    int i;
    if (this.ili != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.ilk = this.ili.size();
      i = this.ilj;
      while ((i < this.ilk) && (i < this.ilj + 500))
      {
        ben localben = new ben();
        localben.CFy = ((n)this.ili.get(i)).field_googlegmail;
        localLinkedList.add(localben);
        i += 1;
      }
      paramg.mAL = localLinkedList;
      paramg.mAK = localLinkedList.size();
      if (this.ilj + 500 <= this.ilk) {
        break label240;
      }
    }
    label240:
    for (this.ill = 0;; this.ill = 1)
    {
      paramg.CNq = this.ill;
      paramg.DJt = this.mEntryScene;
      ad.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.ilk), Integer.valueOf(this.ilj), Integer.valueOf(this.ill) });
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
    a(aJc());
    if (this.ill == 1)
    {
      this.ilj += 500;
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ai
 * JD-Core Version:    0.7.0.1
 */