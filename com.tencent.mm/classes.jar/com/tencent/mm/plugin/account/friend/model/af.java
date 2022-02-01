package com.tencent.mm.plugin.account.friend.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cxq;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.g.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class af
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int mEntryScene;
  private String mToken;
  private HashMap<String, k> pQI;
  private ArrayList<k> pTB;
  private int pTC;
  private int pTD;
  private int pTE;
  private final c rr;
  
  public af(ArrayList<k> paramArrayList, int paramInt, HashMap<String, k> paramHashMap, String paramString)
  {
    AppMethodBeat.i(131126);
    this.pQI = new HashMap();
    c.a locala = new c.a();
    locala.otE = new dhz();
    locala.otF = new dia();
    locala.uri = "/cgi-bin/micromsg-bin/listgooglecontact";
    locala.funcId = 488;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.pTB = paramArrayList;
    this.mEntryScene = paramInt;
    this.pTC = 0;
    this.pTE = 1;
    this.pQI = paramHashMap;
    this.mToken = paramString;
    AppMethodBeat.o(131126);
  }
  
  private void a(dia paramdia)
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
        Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "handleListGoogleContactCGIResponse Count:%d", new Object[] { Integer.valueOf(paramdia.vgN) });
        if ((paramdia.vgO == null) || (paramdia.vgO.size() <= 0)) {
          break label574;
        }
        int k = paramdia.vgO.size();
        localArrayList = new ArrayList();
        localLinkedList = new LinkedList();
        j = 0;
        if (j >= k) {
          break label540;
        }
        cxq localcxq = (cxq)paramdia.vgO.get(j);
        if (TextUtils.isEmpty(localcxq.UserName)) {
          break label594;
        }
        localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localcxq.UserName);
        if ((localObject1 == null) || (!com.tencent.mm.contact.d.rs(((az)localObject1).field_type))) {
          break label589;
        }
        i = 2;
        if ((this.pQI == null) || (!this.pQI.containsKey(localcxq.YNO))) {
          break label582;
        }
        localObject2 = (k)this.pQI.get(localcxq.YNO);
        ((k)localObject2).field_username = localcxq.UserName;
        ((k)localObject2).field_nickname = localcxq.vhX;
        ((k)localObject2).field_usernamepy = f.Sa(localcxq.vhX);
        ((k)localObject2).field_nicknameqp = f.RZ(localcxq.vhX);
        ((k)localObject2).field_ret = localcxq.Idd;
        ((k)localObject2).field_small_url = localcxq.aaDa;
        ((k)localObject2).field_big_url = localcxq.aaCZ;
        ((k)localObject2).field_status = i;
        ((k)localObject2).field_googlecgistatus = 2;
        if ((i == 2) || (i == 0))
        {
          ((k)localObject2).field_contecttype = "weixin".concat(String.valueOf(j));
          ((k)localObject2).field_googlenamepy = f.Sa(((k)localObject2).field_googlename);
          localArrayList.add(localObject2);
          localObject1 = ((k)localObject2).field_googleid;
          str1 = ((k)localObject2).field_googlephotourl;
          str2 = this.mToken;
          if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
          {
            localObject1 = new g.a();
            ((com.tencent.mm.autogen.b.g)localObject1).field_userName = localcxq.UserName;
            ((com.tencent.mm.autogen.b.g)localObject1).field_scene = 58;
            ((com.tencent.mm.autogen.b.g)localObject1).field_ticket = localcxq.aant;
            localLinkedList.add(localObject1);
            break label582;
          }
        }
        else
        {
          ((k)localObject2).field_contecttype = "google";
          continue;
        }
        str3 = (String)localObject1 + "@google";
      }
      finally {}
      String str3;
      Object localObject2 = q.bFE().LS(str3);
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new j();
      }
      ((j)localObject1).username = str3;
      ((j)localObject1).jZY = 3;
      ((j)localObject1).osN = com.tencent.mm.modelavatar.d.bp(str1, str2);
      ((j)localObject1).osM = com.tencent.mm.modelavatar.d.bp(str1, str2);
      ((j)localObject1).gX(true);
      ((j)localObject1).eQp = 31;
      q.bFE().b((j)localObject1);
      continue;
      label540:
      ((l)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getGoogleFriendStorage()).D(localArrayList);
      com.tencent.mm.plugin.c.a.caJ().bAc().mF(localLinkedList);
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
  
  public final dia bXn()
  {
    AppMethodBeat.i(304810);
    dia localdia = (dia)c.c.b(this.rr.otC);
    AppMethodBeat.o(304810);
    return localdia;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131127);
    Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doScene");
    this.callback = paramh;
    paramh = (dhz)c.b.b(this.rr.otB);
    int i;
    if (this.pTB != null)
    {
      LinkedList localLinkedList = new LinkedList();
      this.pTD = this.pTB.size();
      i = this.pTC;
      while ((i < this.pTD) && (i < this.pTC + 500))
      {
        cxr localcxr = new cxr();
        localcxr.YNO = ((k)this.pTB.get(i)).field_googlegmail;
        localLinkedList.add(localcxr);
        i += 1;
      }
      paramh.vgO = localLinkedList;
      paramh.vgN = localLinkedList.size();
      if (this.pTC + 500 <= this.pTD) {
        break label240;
      }
    }
    label240:
    for (this.pTE = 0;; this.pTE = 1)
    {
      paramh.YYp = this.pTE;
      paramh.aaMX = this.mEntryScene;
      Log.i("MicroMsg.GoogleContact.NetSceneListGoogleContact", "doscene mTotalSize:%d, mStarIndex:%d, mContinueFlag:%d", new Object[] { Integer.valueOf(this.pTD), Integer.valueOf(this.pTC), Integer.valueOf(this.pTE) });
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
    a(bXn());
    if (this.pTE == 1)
    {
      this.pTC += 500;
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
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.af
 * JD-Core Version:    0.7.0.1
 */