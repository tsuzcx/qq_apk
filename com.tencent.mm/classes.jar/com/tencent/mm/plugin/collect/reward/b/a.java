package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.mm.j.c;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Map;

public final class a
  implements f.a
{
  public static final String iIi = b.dOP + "wallet/img/";
  private static a iIj;
  private String filename;
  public Map<String, a.a> hLB;
  
  public static a aEF()
  {
    if (iIj == null) {
      iIj = new a();
    }
    return iIj;
  }
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    y.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", new Object[] { paramString, Integer.valueOf(paramInt), paramd });
    ai.d(new a.1(this, paramString, paramd, paramInt));
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final boolean aEG()
  {
    return new File(iIi + aEH()).exists();
  }
  
  public final String aEH()
  {
    if (bk.bl(this.filename)) {
      this.filename = ad.bB(q.Gj() + "_reward_img");
    }
    return this.filename;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.b.a
 * JD-Core Version:    0.7.0.1
 */