package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ae
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private LinkedList<aqq> fgA;
  public String fgB;
  
  public ae(ArrayList<String> paramArrayList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aqr();
    ((b.a)localObject).ecI = new aqs();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
    ((b.a)localObject).ecG = 489;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    this.fgA = new LinkedList();
    if (paramArrayList.size() > 0)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = new aqq();
        ((aqq)localObject).sAZ = ((String)paramArrayList.get(i));
        this.fgA.add(localObject);
        i += 1;
      }
    }
  }
  
  public final aqs Xb()
  {
    return (aqs)this.dmK.ecF.ecN;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
    this.dmL = paramf;
    paramf = (aqr)this.dmK.ecE.ecN;
    paramf.hPS = this.fgA.size();
    paramf.hPT = this.fgA;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 489;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ae
 * JD-Core Version:    0.7.0.1
 */