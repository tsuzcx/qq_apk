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
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.ayw;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class aa
  extends m
  implements k
{
  public final b dmK;
  private f dmL;
  
  public aa(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new ayv();
    locala.ecI = new ayw();
    locala.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
    locala.ecG = 135;
    locala.ecJ = 23;
    locala.ecK = 1000000023;
    this.dmK = locala.Kt();
    ((ayv)this.dmK.ecE.ecN).tmx = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramq = (ayw)this.dmK.ecF.ecN;
    y.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + paramq.kVS.size() + " group:" + paramq.swl.size());
    paramArrayOfByte = new HashSet();
    LinkedList localLinkedList = new LinkedList();
    paramInt1 = 0;
    while (paramInt1 < paramq.tuF)
    {
      if (!paramArrayOfByte.contains(((ayz)paramq.kVS.get(paramInt1)).hPY))
      {
        localLinkedList.add(paramq.kVS.get(paramInt1));
        paramArrayOfByte.add(((ayz)paramq.kVS.get(paramInt1)).hPY);
      }
      paramInt1 += 1;
    }
    paramq.kVS = localLinkedList;
    paramq.tuF = localLinkedList.size();
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 135;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aa
 * JD-Core Version:    0.7.0.1
 */