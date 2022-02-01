package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayOutputStream;

public final class v
  implements g.a
{
  String qlm = null;
  a vBA;
  String vBB;
  boolean vBC = true;
  
  public final int a(String paramString, int paramInt, c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(65240);
    ae.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (this.qlm.equals(paramString)) && (!bu.isNullOrNil(paramd.field_fileId)))
    {
      ae.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + paramd.field_retCode);
      if ((paramInt == 0) && (paramd.field_retCode == 0)) {
        if (this.vBC)
        {
          ae.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
          ae.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", new Object[] { paramString, paramd.toString() });
          if (this.vBA != null) {
            this.vBA.by(this.vBB, true);
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65240);
      return 0;
      ae.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
      break;
      ae.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
      if (this.vBA != null)
      {
        this.vBA.by(this.vBB, false);
        continue;
        if ((paramd != null) && (this.qlm.equals(paramString)) && (paramd.field_retCode != 0))
        {
          ae.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + paramd.field_retCode);
          if (this.vBA != null) {
            this.vBA.by(this.vBB, false);
          }
        }
        else if (paramc != null)
        {
          ae.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
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
    public abstract void by(String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.v
 * JD-Core Version:    0.7.0.1
 */