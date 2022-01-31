package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.atl;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.protocal.protobuf.bag;
import com.tencent.mm.protocal.protobuf.bah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class af
  extends m
  implements k
{
  private f callback;
  private HashMap<String, n> gvq;
  private ArrayList<n> gyk;
  private int gyl;
  private int gym;
  private int gyn;
  private int gyo;
  private String mToken;
  private final com.tencent.mm.ai.b rr;
  
  public af(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    AppMethodBeat.i(108465);
    this.gvq = new HashMap();
    b.a locala = new b.a();
    locala.fsX = new bag();
    locala.fsY = new bah();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.gyk = paramArrayList;
    this.gyl = paramInt;
    this.gym = 0;
    this.gyo = 1;
    this.gvq = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(108465);
  }
  
  private void a(bah parambah)
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
        AppMethodBeat.i(108468);
        ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(parambah.jJu) });
        if ((parambah.jJv == null) || (parambah.jJv.size() <= 0)) {
          break label574;
        }
        int k = parambah.jJv.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        atl localatl = (atl)parambah.jJv.get(j);
        if (TextUtils.isEmpty(localatl.jJA)) {
          break label594;
        }
        localObject1 = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(localatl.jJA);
        if ((localObject1 == null) || (!com.tencent.mm.n.a.je(((aq)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.gvq == null) || (!this.gvq.containsKey(localatl.wvt))) {
          break label582;
        }
        localObject2 = (n)this.gvq.get(localatl.wvt);
        ((n)localObject2).field_username = localatl.jJA;
        ((n)localObject2).field_nickname = localatl.jKG;
        ((n)localObject2).field_usernamepy = com.tencent.mm.platformtools.g.wr(localatl.jKG);
        ((n)localObject2).field_nicknameqp = com.tencent.mm.platformtools.g.wq(localatl.jKG);
        ((n)localObject2).field_ret = localatl.Ret;
        ((n)localObject2).field_small_url = localatl.xiI;
        ((n)localObject2).field_big_url = localatl.xiH;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((n)localObject2).field_googlenamepy = com.tencent.mm.platformtools.g.wr(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.g.c.g)localObject1).field_userName = localatl.jJA;
            ((com.tencent.mm.g.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.g.c.g)localObject1).field_ticket = localatl.wYu;
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
      Object localObject2 = com.tencent.mm.ah.o.adg().rj(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new h();
      }
      ((h)localObject1).username = str3;
      ((h)localObject1).dqB = 3;
      ((h)localObject1).fsl = com.tencent.mm.ah.b.ax(str1, str2);
      ((h)localObject1).fsk = com.tencent.mm.ah.b.ax(str1, str2);
      ((h)localObject1).cM(true);
      ((h)localObject1).bsY = 31;
      com.tencent.mm.ah.o.adg().b((h)localObject1);
      continue;
      label540:
      ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).i(localArrayList);
      com.tencent.mm.plugin.c.a.asD().Zb().ev(localLinkedList);
      label574:
      AppMethodBeat.o(108468);
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
  
  public final bah aqG()
  {
    return (bah)this.rr.fsW.fta;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(108466);
    ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = paramf;
    paramf = (bag)this.rr.fsV.fta;
    int i;
    if (this.gyk != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.gyn = this.gyk.size();
      i = this.gym;
      while ((i < this.gyn) && (i < this.gym + 500))
      {
        atm localatm = new atm();
        localatm.wvt = ((n)this.gyk.get(i)).field_googlegmail;
        localLinkedList.add(localatm);
        i += 1;
      }
      paramf.jJv = localLinkedList;
      paramf.jJu = localLinkedList.size();
      if (this.gym + 500 <= this.gyn) {
        break label240;
      }
    }
    label240:
    for (this.gyo = 0;; this.gyo = 1)
    {
      paramf.wBX = this.gyo;
      paramf.xpx = this.gyl;
      ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.gyn), Integer.valueOf(this.gym), Integer.valueOf(this.gyo) });
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108466);
      return i;
    }
  }
  
  public final int getType()
  {
    return 488;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108467);
    ab.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108467);
      return;
    }
    a(aqG());
    if (this.gyo == 1)
    {
      this.gym += 500;
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ab.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108467);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */