package com.tencent.mm.modelsimple;

import com.tencent.mm.a.n;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.o.a;
import com.tencent.mm.protocal.o.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import junit.framework.Assert;

public final class f
  extends m
  implements k
{
  public byte[] content;
  private com.tencent.mm.ah.f dmL;
  private q edR;
  public String eyU = "";
  
  public f(k.e parame)
  {
    parame = (o.b)parame;
    this.eyU = parame.eyU;
    this.content = parame.content;
  }
  
  public f(List<String> paramList, byte[] paramArrayOfByte)
  {
    if ((paramList.size() > 0) && (paramArrayOfByte != null)) {}
    int j;
    String str;
    for (boolean bool1 = true;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      j = (int)(System.currentTimeMillis() / 1000L);
      str = (String)paramList.get(0);
      int i = 1;
      while (i < paramList.size())
      {
        str = str + "," + ((String)paramList.get(i)).trim();
        i += 1;
      }
    }
    this.edR = new f.a();
    paramList = (o.a)this.edR.Kv();
    paramList.bNb = 111;
    paramList.bcw = 0;
    paramList.eAK = j;
    if (str != null)
    {
      bool1 = true;
      Assert.assertTrue(bool1);
      paramList.spY = str;
      if (paramArrayOfByte == null) {
        break label264;
      }
    }
    label264:
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramList.spZ = paramArrayOfByte;
      y.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111 seq=" + j);
      y.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + n.q(paramArrayOfByte, 0));
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean Kx()
  {
    return true;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelsimple.f
 * JD-Core Version:    0.7.0.1
 */