package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.emoji.sync.d.a.a;
import com.tencent.mm.emoji.sync.d.a.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.p;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f gCo;
  boolean hmD;
  public String idX;
  private int mScene;
  public String pMk;
  public String pMl;
  public String pMm;
  String pMn;
  private int pMo;
  public boolean pMp;
  private g.a pMq;
  EmojiGroupInfo pMr;
  private final com.tencent.mm.ak.b rr;
  
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
    AppMethodBeat.i(108680);
    this.idX = "";
    this.pMq = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108679);
        if ((bu.isNullOrNil(g.this.idX)) || (!paramAnonymousString.equals(g.this.idX)))
        {
          ae.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt == -21006)
        {
          ae.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { g.this.idX });
          g.h(g.this.pMk, 6, 0, g.this.idX);
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ae.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[] { g.this.pMk });
          g.h(g.this.pMk, -1, 0, g.this.idX);
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == paramAnonymousc.field_toltalLength)
          {
            ae.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
            AppMethodBeat.o(108679);
            return 0;
          }
          ae.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { g.this.idX, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          if (!g.this.hmD) {
            g.h(g.this.pMk, 6, (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F), g.this.idX);
          }
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(10625, new Object[] { Integer.valueOf(2), paramAnonymousd.field_fileId, g.this.pMk, paramAnonymousd.field_transInfo });
          if (paramAnonymousd.field_retCode != 0)
          {
            ae.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[] { g.this.pMk, Integer.valueOf(paramAnonymousd.field_retCode) });
            g.h(g.this.pMk, -1, 0, g.this.idX);
          }
        }
        else
        {
          AppMethodBeat.o(108679);
          return 0;
        }
        ae.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
        paramAnonymousString = com.tencent.mm.emoji.sync.d.grx;
        paramAnonymousString = g.this.pMk;
        p.h(paramAnonymousString, "productId");
        ae.i(com.tencent.mm.emoji.sync.d.access$getTAG$cp(), "checkPack: ".concat(String.valueOf(paramAnonymousString)));
        com.tencent.mm.ac.c.b(null, (d.g.a.a)new d.a.a(paramAnonymousString, (d.g.a.b)d.a.b.grB));
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.emoji.e.c.chG();
          paramAnonymousc = g.this.pMk;
          if ((paramAnonymousString.pIZ != null) && (paramAnonymousString.pIZ.contains(paramAnonymousc))) {
            paramAnonymousString.pIZ.remove(paramAnonymousc);
          }
          EmojiLogic.a(g.this.pMk, g.this.pMl, g.this.pMn, g.this.pMr);
          com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().JfU.doNotify();
          g.h(g.this.pMk, 7, 100, g.this.idX);
          paramAnonymousString = new com.tencent.mm.vfs.k(com.tencent.mm.loader.j.b.asm() + g.this.pMk);
          if ((paramAnonymousString.isFile()) && (paramAnonymousString.exists())) {
            paramAnonymousString.delete();
          }
          g.aN(g.this.pMk, true);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (Exception paramAnonymousString)
        {
          ae.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bu.fpN());
          g.h(g.this.pMk, -1, 0, g.this.idX);
          g.aN(g.this.pMk, false);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (OutOfMemoryError paramAnonymousString)
        {
          for (;;)
          {
            ae.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bu.fpN());
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.pMk = paramString1;
    this.pMl = paramString3;
    this.pMm = paramString2;
    this.pMn = paramString4;
    this.pMr = null;
    this.pMo = paramInt1;
    this.mScene = paramInt2;
    this.pMp = false;
    paramString1 = new b.a();
    paramString1.hQF = new ExchangeEmotionPackRequest();
    paramString1.hQG = new ExchangeEmotionPackResponse();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.hQH = 213;
    paramString1.respCmdId = 1000000213;
    this.rr = paramString1.aDS();
    AppMethodBeat.o(108680);
  }
  
  static void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108683);
    com.tencent.mm.plugin.emoji.model.k.cil().h(paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(108683);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108684);
    super.cancel();
    this.hmD = true;
    AppMethodBeat.o(108684);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(108682);
    ae.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.gCo = paramf;
    if (this.mScene == 0) {
      h(this.pMk, 6, 0, this.idX);
    }
    paramf = (ExchangeEmotionPackRequest)this.rr.hQD.hQJ;
    paramf.ProductID = this.pMk;
    paramf.SeriesID = this.pMm;
    paramf.IsAutomatic = this.pMo;
    paramf.Scene = this.mScene;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108682);
    return i;
  }
  
  public final int getType()
  {
    return 423;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108681);
    ae.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      h(this.pMk, -1, 0, this.idX);
      AppMethodBeat.o(108681);
      return;
    }
    paramq = com.tencent.mm.emoji.d.d.gsN;
    com.tencent.mm.emoji.d.d.wK(this.pMk);
    if (this.mScene == 0)
    {
      paramq = new com.tencent.mm.vfs.k(com.tencent.mm.loader.j.b.asm());
      if (!paramq.exists()) {
        paramq.mkdirs();
      }
      if (!this.pMp)
      {
        long l = System.currentTimeMillis();
        paramq = new StringBuilder();
        com.tencent.mm.kernel.g.ajP();
        this.idX = com.tencent.mm.an.c.a("downzip", l, com.tencent.mm.kernel.a.getUin(), "emoji");
      }
      paramq = ((ExchangeEmotionPackResponse)this.rr.hQE.hQJ).DownloadInfo;
      paramArrayOfByte = new com.tencent.mm.i.g();
      paramArrayOfByte.fLl = "task_NetSceneExchangeEmotionPack";
      paramArrayOfByte.field_mediaId = this.idX;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.loader.j.b.asm() + this.pMk);
      paramArrayOfByte.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = paramq.FileSize;
      paramArrayOfByte.field_aesKey = paramq.AesKey;
      paramArrayOfByte.field_fileId = paramq.Url;
      paramArrayOfByte.field_priority = com.tencent.mm.i.a.fKA;
      paramArrayOfByte.fLm = this.pMq;
      paramArrayOfByte.field_needStorage = true;
      this.hmD = false;
      if (!com.tencent.mm.an.f.aGZ().b(paramArrayOfByte, -1)) {
        ae.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new k(this.pMk);
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramString, 0);
      AppMethodBeat.o(108681);
      return;
      ae.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */