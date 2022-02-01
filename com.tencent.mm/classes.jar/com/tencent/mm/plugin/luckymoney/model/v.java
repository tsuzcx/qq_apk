package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.ByteArrayOutputStream;

public final class v
  implements g.a
{
  String oXR = null;
  a teA;
  String teB;
  boolean teC = true;
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(65240);
    ad.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (this.oXR.equals(paramString)) && (!bt.isNullOrNil(paramd.field_fileId)))
    {
      ad.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + paramd.field_retCode);
      if ((paramInt == 0) && (paramd.field_retCode == 0)) {
        if (this.teC)
        {
          ad.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
          ad.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", new Object[] { paramString, paramd.toString() });
          if (this.teA != null) {
            this.teA.bh(this.teB, true);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65240);
      return 0;
      ad.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
      break;
      ad.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
      if (this.teA != null)
      {
        this.teA.bh(this.teB, false);
        continue;
        if ((paramd != null) && (this.oXR.equals(paramString)) && (paramd.field_retCode != 0))
        {
          ad.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + paramd.field_retCode);
          if (this.teA != null) {
            this.teA.bh(this.teB, false);
          }
        }
        else if (paramc != null)
        {
          ad.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
        }
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void bh(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.v
 * JD-Core Version:    0.7.0.1
 */