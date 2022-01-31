package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.at;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

final class g$1
  implements g.a
{
  g$1(g paramg) {}
  
  public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(53107);
    if ((bo.isNullOrNil(this.liB.fFo)) || (!paramString.equals(this.liB.fFo)))
    {
      ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
      AppMethodBeat.o(53107);
      return 0;
    }
    if (paramInt == -21006)
    {
      ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { this.liB.fFo });
      g.g(this.liB.liu, 6, 0, this.liB.fFo);
      AppMethodBeat.o(53107);
      return 0;
    }
    if (paramInt != 0)
    {
      ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[] { this.liB.liu });
      g.g(this.liB.liu, -1, 0, this.liB.fFo);
      AppMethodBeat.o(53107);
      return 0;
    }
    if (paramc != null)
    {
      if (paramc.field_finishedLength == paramc.field_toltalLength)
      {
        ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
        AppMethodBeat.o(53107);
        return 0;
      }
      ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { this.liB.fFo, Integer.valueOf(paramc.field_finishedLength), Integer.valueOf(paramc.field_toltalLength) });
      if (!this.liB.eUJ) {
        g.g(this.liB.liu, 6, (int)(paramc.field_finishedLength / paramc.field_toltalLength * 100.0F), this.liB.fFo);
      }
      AppMethodBeat.o(53107);
      return 0;
    }
    if (paramd != null)
    {
      h.qsU.e(10625, new Object[] { Integer.valueOf(2), paramd.field_fileId, this.liB.liu, paramd.field_transInfo });
      if (paramd.field_retCode != 0)
      {
        ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[] { this.liB.liu, Integer.valueOf(paramd.field_retCode) });
        g.g(this.liB.liu, -1, 0, this.liB.fFo);
      }
    }
    else
    {
      AppMethodBeat.o(53107);
      return 0;
    }
    ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
    try
    {
      paramString = com.tencent.mm.plugin.emoji.e.d.bkN();
      paramc = this.liB.liu;
      if ((paramString.lfD != null) && (paramString.lfD.contains(paramc))) {
        paramString.lfD.remove(paramc);
      }
      EmojiLogic.a(this.liB.liu, this.liB.liv, this.liB.lix, this.liB.liA);
      i.getEmojiStorageMgr().yNn.doNotify();
      g.g(this.liB.liu, 7, 100, this.liB.fFo);
      paramString = new File(e.esq + this.liB.liu);
      if ((paramString.isFile()) && (paramString.exists())) {
        paramString.delete();
      }
      g.aA(this.liB.liu, true);
      AppMethodBeat.o(53107);
      return 0;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bo.dtY());
      g.g(this.liB.liu, -1, 0, this.liB.fFo);
      g.aA(this.liB.liu, false);
      AppMethodBeat.o(53107);
      return 0;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bo.dtY());
      }
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public final byte[] l(String paramString, byte[] paramArrayOfByte)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g.1
 * JD-Core Version:    0.7.0.1
 */