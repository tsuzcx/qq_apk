package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ak.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.j.a;
import com.tencent.mm.j.d;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;

public final class k
  implements f.a
{
  public String jxH = null;
  public a lQG;
  public String lQH;
  private boolean lQI = true;
  
  public static String bfK()
  {
    return bk.pm(com.tencent.mm.ak.c.a("NewYearImg", System.currentTimeMillis(), q.GQ().field_username, ""));
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.j.c paramc, d paramd, boolean paramBoolean)
  {
    y.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramString, Integer.valueOf(paramInt), paramc, paramd });
    if ((paramd != null) && (this.jxH.equals(paramString)) && (!bk.bl(paramd.field_fileId)))
    {
      y.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer success, sceneResult.field_retCode:" + paramd.field_retCode);
      if ((paramInt == 0) && (paramd.field_retCode == 0)) {
        if (this.lQI)
        {
          y.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, upload callback success");
          y.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd:transfer done, mediaid=%s, completeInfo=%s", new Object[] { paramString, paramd.toString() });
          if (this.lQG != null) {
            this.lQG.a(paramd, this.lQH, true);
          }
        }
      }
    }
    label273:
    do
    {
      do
      {
        do
        {
          return 0;
          y.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, download callback success");
          break;
          y.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail");
        } while (this.lQG == null);
        this.lQG.a(paramd, this.lQH, false);
        return 0;
        if ((paramd == null) || (!this.jxH.equals(paramString)) || (paramd.field_retCode == 0)) {
          break label273;
        }
        y.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: transfer done, fail, sceneResult.field_retCode:" + paramd.field_retCode);
      } while (this.lQG == null);
      this.lQG.a(paramd, this.lQH, false);
      return 0;
    } while (paramc == null);
    y.d("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: upload progressing....");
    return 0;
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final boolean a(String paramString1, String paramString2, int paramInt, String paramString3, a parama)
  {
    y.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. imageId:%s", new Object[] { paramString1 });
    this.lQI = false;
    this.jxH = bfK();
    y.i("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: downloadImage. client id:%s", new Object[] { this.jxH });
    this.lQH = paramString3;
    this.lQG = parama;
    parama = new com.tencent.mm.j.f();
    parama.ceg = false;
    parama.dlP = this;
    parama.field_fullpath = paramString3;
    parama.field_mediaId = this.jxH;
    parama.field_fileId = paramString1;
    parama.field_aesKey = paramString2;
    parama.field_totalLen = paramInt;
    parama.field_fileType = a.MediaType_FILE;
    parama.field_priority = a.dlk;
    parama.field_needStorage = false;
    parama.field_isStreamMedia = false;
    parama.field_appType = 0;
    parama.field_bzScene = 0;
    if (!com.tencent.mm.ak.f.Nd().b(parama, -1))
    {
      y.e("MicroMsg.LuckyMoneyNewYearImageUploader", "ljd: cdntra addSendTask failed. imageId:%s", new Object[] { paramString1 });
      return false;
    }
    return true;
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd, String paramString, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.b.k
 * JD-Core Version:    0.7.0.1
 */