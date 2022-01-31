package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpa;
import com.tencent.mm.protocal.c.bpb;
import java.util.LinkedList;

public final class ah
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public ah(int[] paramArrayOfInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bpa();
    ((b.a)localObject).ecI = new bpb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendinviteemail";
    ((b.a)localObject).ecG = 116;
    ((b.a)localObject).ecJ = 41;
    ((b.a)localObject).ecK = 1000000041;
    this.dmK = ((b.a)localObject).Kt();
    localObject = new LinkedList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      ((LinkedList)localObject).add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    ((bpa)this.dmK.ecE.ecN).tHh = ((LinkedList)localObject);
    ((bpa)this.dmK.ecE.ecN).tHg = ((LinkedList)localObject).size();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 116;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ah
 * JD-Core Version:    0.7.0.1
 */