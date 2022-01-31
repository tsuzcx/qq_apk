package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.j.c;
import com.tencent.mm.j.f.a;
import com.tencent.mm.plugin.emoji.e.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.at;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

final class h$1
  implements f.a
{
  h$1(h paramh) {}
  
  public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.j.d paramd, boolean paramBoolean)
  {
    if ((bk.bl(this.iZK.eoQ)) || (!paramString.equals(this.iZK.eoQ))) {
      y.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
    }
    do
    {
      do
      {
        return 0;
        if (paramInt == -21006)
        {
          y.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { this.iZK.eoQ });
          h.g(this.iZK.iZD, 6, 0, this.iZK.eoQ);
          return 0;
        }
        if (paramInt != 0)
        {
          y.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[] { this.iZK.iZD });
          h.g(this.iZK.iZD, -1, 0, this.iZK.eoQ);
          return 0;
        }
        if (paramc == null) {
          break;
        }
        if (paramc.field_finishedLength == paramc.field_toltalLength)
        {
          y.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
          return 0;
        }
        y.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { this.iZK.eoQ, Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength) });
      } while (this.iZK.edT);
      h.g(this.iZK.iZD, 6, (int)(paramc.field_finishedLength / paramc.field_toltalLength * 100.0F), this.iZK.eoQ);
      return 0;
    } while (paramd == null);
    com.tencent.mm.plugin.report.service.h.nFQ.f(10625, new Object[] { Integer.valueOf(2), paramd.field_fileId, this.iZK.iZD, paramd.field_transInfo });
    if (paramd.field_retCode != 0)
    {
      y.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[] { this.iZK.iZD, Integer.valueOf(paramd.field_retCode) });
      h.g(this.iZK.iZD, -1, 0, this.iZK.eoQ);
      return 0;
    }
    y.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
    try
    {
      paramString = b.aGZ();
      paramc = this.iZK.iZD;
      if ((paramString.iWv != null) && (paramString.iWv.contains(paramc))) {
        paramString.iWv.remove(paramc);
      }
      EmojiLogic.a(this.iZK.iZD, this.iZK.iZE, this.iZK.iZG, this.iZK.iZJ);
      i.getEmojiStorageMgr().uBb.doNotify();
      h.g(this.iZK.iZD, 7, 100, this.iZK.eoQ);
      paramString = new File(e.dzB + this.iZK.iZD);
      if ((paramString.isFile()) && (paramString.exists())) {
        paramString.delete();
      }
      h.an(this.iZK.iZD, true);
      return 0;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bk.csb());
      h.g(this.iZK.iZD, -1, 0, this.iZK.eoQ);
      h.an(this.iZK.iZD, false);
      return 0;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bk.csb());
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h.1
 * JD-Core Version:    0.7.0.1
 */