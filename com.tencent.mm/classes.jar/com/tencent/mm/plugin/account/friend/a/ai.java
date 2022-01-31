package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bpm;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ai
  extends m
  implements k
{
  private final b dmK;
  private f dmL = null;
  
  public ai(String paramString, List<String> paramList)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bpm();
    ((b.a)localObject).ecI = new bpn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
    ((b.a)localObject).ecG = 432;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bpm)this.dmK.ecE.ecN;
    ((bpm)localObject).sRr = paramString;
    ((bpm)localObject).tpC = new LinkedList();
    ((bpm)localObject).tpB = paramList.size();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      if (!bk.bl(paramList)) {
        ((bpm)localObject).tpC.add(new bml().YI(paramList));
      }
    }
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
    return 432;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ai
 * JD-Core Version:    0.7.0.1
 */