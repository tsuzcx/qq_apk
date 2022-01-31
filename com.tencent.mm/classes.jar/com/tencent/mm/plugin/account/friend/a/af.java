package com.tencent.mm.plugin.account.friend.a;

import android.text.TextUtils;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.c.anv;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.protocal.c.aub;
import com.tencent.mm.sdk.platformtools.y;
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
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  private String fdD;
  private HashMap<String, n> fdG = new HashMap();
  private ArrayList<n> fgC;
  private int fgD;
  private int fgE;
  private int fgF;
  private int fgG;
  
  public af(ArrayList<n> paramArrayList, int paramInt, HashMap<String, n> paramHashMap, String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new aua();
    locala.ecI = new aub();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.ecG = 488;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.fgC = paramArrayList;
    this.fgD = paramInt;
    this.fgE = 0;
    this.fgG = 1;
    this.fdG = paramHashMap;
    this.fdD = paramString;
  }
  
  private void a(aub paramaub)
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
        y.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramaub.hPS) });
        if ((paramaub.hPT == null) || (paramaub.hPT.size() <= 0)) {
          break label576;
        }
        int k = paramaub.hPT.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label542;
        }
        anv localanv = (anv)paramaub.hPT.get(j);
        if (TextUtils.isEmpty(localanv.hPY)) {
          break label591;
        }
        localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(localanv.hPY);
        if ((localObject1 == null) || (!com.tencent.mm.n.a.gR(((ao)localObject1).field_type))) {
          break label586;
        }
        i = 2;
        if ((this.fdG == null) || (!this.fdG.containsKey(localanv.sAZ))) {
          break label579;
        }
        localObject2 = (n)this.fdG.get(localanv.sAZ);
        ((n)localObject2).field_username = localanv.hPY;
        ((n)localObject2).field_nickname = localanv.hRf;
        ((n)localObject2).field_usernamepy = com.tencent.mm.platformtools.g.oZ(localanv.hRf);
        ((n)localObject2).field_nicknameqp = com.tencent.mm.platformtools.g.oY(localanv.hRf);
        ((n)localObject2).field_ret = localanv.sze;
        ((n)localObject2).field_small_url = localanv.tjR;
        ((n)localObject2).field_big_url = localanv.tjQ;
        ((n)localObject2).field_status = i;
        ((n)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((n)localObject2).field_contecttype = ("weixin" + j);
          ((n)localObject2).field_googlenamepy = com.tencent.mm.platformtools.g.oZ(((n)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((n)localObject2).field_googleid;
          str1 = ((n)localObject2).field_googlephotourl;
          str2 = this.fdD;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.h.c.g)localObject1).field_userName = localanv.hPY;
            ((com.tencent.mm.h.c.g)localObject1).field_scene = 58;
            ((com.tencent.mm.h.c.g)localObject1).field_ticket = localanv.tac;
            localLinkedList.add(localObject1);
            break label579;
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
      Object localObject2 = com.tencent.mm.ag.o.Kh().kp(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new h();
      }
      ((h)localObject1).username = str3;
      ((h)localObject1).cCq = 3;
      ((h)localObject1).ebT = com.tencent.mm.ag.b.ah(str1, str2);
      ((h)localObject1).ebS = com.tencent.mm.ag.b.ah(str1, str2);
      ((h)localObject1).bK(true);
      ((h)localObject1).bcw = 31;
      com.tencent.mm.ag.o.Kh().a((h)localObject1);
      continue;
      label542:
      ((o)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage()).i(localArrayList);
      com.tencent.mm.plugin.c.a.YT().Ga().dn(localLinkedList);
      label576:
      return;
      label579:
      j += 1;
      continue;
      label586:
      int i = 0;
      continue;
      label591:
      i = 1;
    }
  }
  
  protected final int Ka()
  {
    return 20;
  }
  
  public final aub Xc()
  {
    return (aub)this.dmK.ecF.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.dmL = paramf;
    paramf = (aua)this.dmK.ecE.ecN;
    if (this.fgC != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.fgF = this.fgC.size();
      int i = this.fgE;
      while ((i < this.fgF) && (i < this.fgE + 500))
      {
        anw localanw = new anw();
        localanw.sAZ = ((n)this.fgC.get(i)).field_googlegmail;
        localLinkedList.add(localanw);
        i += 1;
      }
      paramf.hPT = localLinkedList;
      paramf.hPS = localLinkedList.size();
      if (this.fgE + 500 <= this.fgF) {
        break label226;
      }
    }
    label226:
    for (this.fgG = 0;; this.fgG = 1)
    {
      paramf.sFD = this.fgG;
      paramf.tpA = this.fgD;
      y.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.fgF), Integer.valueOf(this.fgE), Integer.valueOf(this.fgG) });
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    a(Xc());
    if (this.fgG == 1)
    {
      this.fgE += 500;
      if (a(this.edc, this.dmL) < 0)
      {
        y.e("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene again failed");
        this.dmL.onSceneEnd(3, -1, "", this);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  protected final m.b b(q paramq)
  {
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 488;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.af
 * JD-Core Version:    0.7.0.1
 */