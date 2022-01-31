package com.tencent.mm.modelsimple;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.v.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import junit.framework.Assert;

public final class w
  extends m
  implements k
{
  private f dmL;
  private final com.tencent.mm.network.q edR = new b();
  
  public w(int paramInt, String paramString)
  {
    this(paramInt, paramString, "");
  }
  
  public w(int paramInt, String paramString1, String paramString2)
  {
    v.a locala = (v.a)this.edR.Kv();
    locala.sqn.hPY = com.tencent.mm.model.q.Gj();
    bou localbou = locala.sqn;
    Object localObject = new StringBuilder();
    int i = paramInt;
    if (paramInt == 0) {
      i = 64;
    }
    StringBuilder localStringBuilder = ((StringBuilder)localObject).append(i).append(";");
    localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localbou.kVs = ((String)localObject);
    y.d("MicroMsg.NetSceneSendCard", "content:" + locala.sqn.kVs);
    Assert.assertTrue("empty sendcard", true);
    locala.sqn.tvg = 64;
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      locala.sqn.tHd = paramString2;
    }
  }
  
  public w(String paramString)
  {
    v.a locala = (v.a)this.edR.Kv();
    locala.sqn.hPY = com.tencent.mm.model.q.Gj();
    locala.sqn.kVs = paramString;
    y.d("MicroMsg.NetSceneSendCard", "content:" + paramString);
    locala.sqn.tga = bk.g((Integer)g.DP().Dz().get(66561, null));
    Assert.assertTrue("empty sendcard", true);
    locala.sqn.tvg = 128;
  }
  
  public w(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    v.a locala = (v.a)this.edR.Kv();
    locala.sqn.hPY = com.tencent.mm.model.q.Gj();
    locala.sqn.kVs = paramString;
    y.d("MicroMsg.NetSceneSendCard", "content:" + paramString);
    locala.sqn.tga = bk.g((Integer)g.DP().Dz().get(66561, null));
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label143;
      }
    }
    label143:
    for (int j = 4;; j = 0)
    {
      Assert.assertTrue("empty sendcard", true);
      locala.sqn.tvg = (j | i | 0x0 | 0x0 | 0x8);
      return;
      i = 0;
      break;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.edR, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramq.HF().spP, this);
  }
  
  public final int getType()
  {
    return 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.w
 * JD-Core Version:    0.7.0.1
 */