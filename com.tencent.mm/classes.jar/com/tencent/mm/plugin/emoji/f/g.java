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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  boolean gRx;
  private com.tencent.mm.ak.g gfX;
  public String hIq;
  private int mScene;
  public String pbW;
  public String pbX;
  public String pbY;
  String pbZ;
  private int pca;
  public boolean pcb;
  private g.a pcc;
  EmojiGroupInfo pcd;
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
    this.hIq = "";
    this.pcc = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108679);
        if ((bs.isNullOrNil(g.this.hIq)) || (!paramAnonymousString.equals(g.this.hIq)))
        {
          ac.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt == -21006)
        {
          ac.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { g.this.hIq });
          g.h(g.this.pbW, 6, 0, g.this.hIq);
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ac.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[] { g.this.pbW });
          g.h(g.this.pbW, -1, 0, g.this.hIq);
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == paramAnonymousc.field_toltalLength)
          {
            ac.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
            AppMethodBeat.o(108679);
            return 0;
          }
          ac.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { g.this.hIq, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          if (!g.this.gRx) {
            g.h(g.this.pbW, 6, (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F), g.this.hIq);
          }
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          h.wUl.f(10625, new Object[] { Integer.valueOf(2), paramAnonymousd.field_fileId, g.this.pbW, paramAnonymousd.field_transInfo });
          if (paramAnonymousd.field_retCode != 0)
          {
            ac.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[] { g.this.pbW, Integer.valueOf(paramAnonymousd.field_retCode) });
            g.h(g.this.pbW, -1, 0, g.this.hIq);
          }
        }
        else
        {
          AppMethodBeat.o(108679);
          return 0;
        }
        ac.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
        paramAnonymousString = com.tencent.mm.emoji.sync.d.fVz;
        paramAnonymousString = g.this.pbW;
        d.g.b.k.h(paramAnonymousString, "productId");
        ac.i(com.tencent.mm.emoji.sync.d.access$getTAG$cp(), "checkPack: ".concat(String.valueOf(paramAnonymousString)));
        com.tencent.mm.ac.c.b(null, (d.g.a.a)new d.a.a(paramAnonymousString, (d.g.a.b)d.a.b.fVD));
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.emoji.e.c.cbM();
          paramAnonymousc = g.this.pbW;
          if ((paramAnonymousString.oYL != null) && (paramAnonymousString.oYL.contains(paramAnonymousc))) {
            paramAnonymousString.oYL.remove(paramAnonymousc);
          }
          EmojiLogic.a(g.this.pbW, g.this.pbX, g.this.pbZ, g.this.pcd);
          com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().GXZ.doNotify();
          g.h(g.this.pbW, 7, 100, g.this.hIq);
          paramAnonymousString = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apj() + g.this.pbW);
          if ((paramAnonymousString.isFile()) && (paramAnonymousString.exists())) {
            paramAnonymousString.delete();
          }
          g.aJ(g.this.pbW, true);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (Exception paramAnonymousString)
        {
          ac.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bs.eWi());
          g.h(g.this.pbW, -1, 0, g.this.hIq);
          g.aJ(g.this.pbW, false);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (OutOfMemoryError paramAnonymousString)
        {
          for (;;)
          {
            ac.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bs.eWi());
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.pbW = paramString1;
    this.pbX = paramString3;
    this.pbY = paramString2;
    this.pbZ = paramString4;
    this.pcd = null;
    this.pca = paramInt1;
    this.mScene = paramInt2;
    this.pcb = false;
    paramString1 = new b.a();
    paramString1.hvt = new ExchangeEmotionPackRequest();
    paramString1.hvu = new ExchangeEmotionPackResponse();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.reqCmdId = 213;
    paramString1.respCmdId = 1000000213;
    this.rr = paramString1.aAz();
    AppMethodBeat.o(108680);
  }
  
  static void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108683);
    com.tencent.mm.plugin.emoji.model.k.ccr().h(paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(108683);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108684);
    super.cancel();
    this.gRx = true;
    AppMethodBeat.o(108684);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(108682);
    ac.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.gfX = paramg;
    if (this.mScene == 0) {
      h(this.pbW, 6, 0, this.hIq);
    }
    paramg = (ExchangeEmotionPackRequest)this.rr.hvr.hvw;
    paramg.ProductID = this.pbW;
    paramg.SeriesID = this.pbY;
    paramg.IsAutomatic = this.pca;
    paramg.Scene = this.mScene;
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
    ac.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      h(this.pbW, -1, 0, this.hIq);
      AppMethodBeat.o(108681);
      return;
    }
    if (this.mScene == 0)
    {
      paramq = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.apj());
      if (!paramq.exists()) {
        paramq.mkdirs();
      }
      if (!this.pcb)
      {
        long l = System.currentTimeMillis();
        paramq = new StringBuilder();
        com.tencent.mm.kernel.g.agP();
        this.hIq = com.tencent.mm.an.c.a("downzip", l, com.tencent.mm.kernel.a.getUin(), "emoji");
      }
      paramq = ((ExchangeEmotionPackResponse)this.rr.hvs.hvw).DownloadInfo;
      paramArrayOfByte = new com.tencent.mm.i.g();
      paramArrayOfByte.field_mediaId = this.hIq;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.loader.j.b.apj() + this.pbW);
      paramArrayOfByte.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = paramq.FileSize;
      paramArrayOfByte.field_aesKey = paramq.AesKey;
      paramArrayOfByte.field_fileId = paramq.Url;
      paramArrayOfByte.field_priority = com.tencent.mm.i.a.fqp;
      paramArrayOfByte.frb = this.pcc;
      paramArrayOfByte.field_needStorage = true;
      this.gRx = false;
      if (!com.tencent.mm.an.f.aDD().b(paramArrayOfByte, -1)) {
        ac.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new k(this.pbW);
      com.tencent.mm.kernel.g.agQ().ghe.a(paramString, 0);
      AppMethodBeat.o(108681);
      return;
      ac.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */