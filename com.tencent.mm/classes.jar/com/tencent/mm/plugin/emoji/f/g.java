package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.al.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.File;

public final class g
  extends m
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ai.f eGj;
  boolean eUJ;
  public String fFo;
  EmojiGroupInfo liA;
  public String liu;
  public String liv;
  public String liw;
  String lix;
  private int liy;
  private g.a liz;
  private int mScene;
  private final com.tencent.mm.ai.b rr;
  
  public g(String paramString)
  {
    this(paramString, null, "", null, 1, 0);
  }
  
  public g(String paramString, byte paramByte)
  {
    this(paramString, null, "", null, 1, 1);
  }
  
  public g(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2, null, 0, 0);
  }
  
  public g(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null);
  }
  
  public g(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramString4, 0, 0);
  }
  
  private g(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(53108);
    this.fFo = "";
    this.liz = new g.1(this);
    this.liu = paramString1;
    this.liv = paramString3;
    this.liw = paramString2;
    this.lix = paramString4;
    this.liA = null;
    this.liy = paramInt1;
    this.mScene = paramInt2;
    paramString1 = new b.a();
    paramString1.fsX = new ExchangeEmotionPackRequest();
    paramString1.fsY = new ExchangeEmotionPackResponse();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.reqCmdId = 213;
    paramString1.respCmdId = 1000000213;
    this.rr = paramString1.ado();
    AppMethodBeat.o(53108);
  }
  
  static void g(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(53111);
    i.blu().g(paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(53111);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(53112);
    super.cancel();
    this.eUJ = true;
    AppMethodBeat.o(53112);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(53110);
    ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.eGj = paramf;
    if (this.mScene == 0) {
      g(this.liu, 6, 0, this.fFo);
    }
    paramf = (ExchangeEmotionPackRequest)this.rr.fsV.fta;
    paramf.ProductID = this.liu;
    paramf.SeriesID = this.liw;
    paramf.IsAutomatic = this.liy;
    paramf.Scene = this.mScene;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(53110);
    return i;
  }
  
  public final int getType()
  {
    return 423;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53109);
    ab.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      g(this.liu, -1, 0, this.fFo);
      AppMethodBeat.o(53109);
      return;
    }
    if (this.mScene == 0)
    {
      paramq = new File(com.tencent.mm.compatible.util.e.esq);
      if (!paramq.exists()) {
        paramq.mkdirs();
      }
      long l = System.currentTimeMillis();
      paramq = new StringBuilder();
      com.tencent.mm.kernel.g.RJ();
      this.fFo = c.a("downzip", l, com.tencent.mm.kernel.a.getUin(), "emoji");
      paramq = ((ExchangeEmotionPackResponse)this.rr.fsW.fta).DownloadInfo;
      paramArrayOfByte = new com.tencent.mm.i.g();
      paramArrayOfByte.field_mediaId = this.fFo;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.compatible.util.e.esq + this.liu);
      paramArrayOfByte.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = paramq.FileSize;
      paramArrayOfByte.field_aesKey = paramq.AesKey;
      paramArrayOfByte.field_fileId = paramq.Url;
      paramArrayOfByte.field_priority = com.tencent.mm.i.a.ecF;
      paramArrayOfByte.edp = this.liz;
      paramArrayOfByte.field_needStorage = true;
      this.eUJ = false;
      if (!com.tencent.mm.al.f.afO().b(paramArrayOfByte, -1)) {
        ab.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new k(this.liu);
      com.tencent.mm.kernel.g.RK().eHt.a(paramString, 0);
      AppMethodBeat.o(53109);
      return;
      ab.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */