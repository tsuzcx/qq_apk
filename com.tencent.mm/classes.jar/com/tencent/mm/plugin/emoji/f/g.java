package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.emoji.sync.d.a.a;
import com.tencent.mm.emoji.sync.d.a.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public final class g
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g gbr;
  boolean gqP;
  public String hhN;
  private int mScene;
  private int oyA;
  public boolean oyB;
  private g.a oyC;
  EmojiGroupInfo oyD;
  public String oyw;
  public String oyx;
  public String oyy;
  String oyz;
  private final com.tencent.mm.al.b rr;
  
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
    this.hhN = "";
    this.oyC = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108679);
        if ((bt.isNullOrNil(g.this.hhN)) || (!paramAnonymousString.equals(g.this.hhN)))
        {
          ad.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt == -21006)
        {
          ad.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { g.this.hhN });
          g.g(g.this.oyw, 6, 0, g.this.hhN);
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ad.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[] { g.this.oyw });
          g.g(g.this.oyw, -1, 0, g.this.hhN);
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == paramAnonymousc.field_toltalLength)
          {
            ad.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
            AppMethodBeat.o(108679);
            return 0;
          }
          ad.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { g.this.hhN, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          if (!g.this.gqP) {
            g.g(g.this.oyw, 6, (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F), g.this.hhN);
          }
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          h.vKh.f(10625, new Object[] { Integer.valueOf(2), paramAnonymousd.field_fileId, g.this.oyw, paramAnonymousd.field_transInfo });
          if (paramAnonymousd.field_retCode != 0)
          {
            ad.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[] { g.this.oyw, Integer.valueOf(paramAnonymousd.field_retCode) });
            g.g(g.this.oyw, -1, 0, g.this.hhN);
          }
        }
        else
        {
          AppMethodBeat.o(108679);
          return 0;
        }
        ad.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
        paramAnonymousString = com.tencent.mm.emoji.sync.d.fRE;
        paramAnonymousString = g.this.oyw;
        d.g.b.k.h(paramAnonymousString, "productId");
        ad.i(com.tencent.mm.emoji.sync.d.access$getTAG$cp(), "checkPack: ".concat(String.valueOf(paramAnonymousString)));
        com.tencent.mm.ad.c.b(null, (d.g.a.a)new d.a.a(paramAnonymousString, (d.g.a.b)d.a.b.fRI));
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.emoji.e.c.bUz();
          paramAnonymousc = g.this.oyw;
          if ((paramAnonymousString.ovl != null) && (paramAnonymousString.ovl.contains(paramAnonymousc))) {
            paramAnonymousString.ovl.remove(paramAnonymousc);
          }
          EmojiLogic.a(g.this.oyw, g.this.oyx, g.this.oyz, g.this.oyD);
          com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().FyY.doNotify();
          g.g(g.this.oyw, 7, 100, g.this.hhN);
          paramAnonymousString = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aij() + g.this.oyw);
          if ((paramAnonymousString.isFile()) && (paramAnonymousString.exists())) {
            paramAnonymousString.delete();
          }
          g.aI(g.this.oyw, true);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (Exception paramAnonymousString)
        {
          ad.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bt.eGN());
          g.g(g.this.oyw, -1, 0, g.this.hhN);
          g.aI(g.this.oyw, false);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (OutOfMemoryError paramAnonymousString)
        {
          for (;;)
          {
            ad.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bt.eGN());
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.oyw = paramString1;
    this.oyx = paramString3;
    this.oyy = paramString2;
    this.oyz = paramString4;
    this.oyD = null;
    this.oyA = paramInt1;
    this.mScene = paramInt2;
    this.oyB = false;
    paramString1 = new b.a();
    paramString1.gUU = new ExchangeEmotionPackRequest();
    paramString1.gUV = new ExchangeEmotionPackResponse();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.reqCmdId = 213;
    paramString1.respCmdId = 1000000213;
    this.rr = paramString1.atI();
    AppMethodBeat.o(108680);
  }
  
  static void g(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108683);
    com.tencent.mm.plugin.emoji.model.k.bVe().g(paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(108683);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108684);
    super.cancel();
    this.gqP = true;
    AppMethodBeat.o(108684);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(108682);
    ad.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.gbr = paramg;
    if (this.mScene == 0) {
      g(this.oyw, 6, 0, this.hhN);
    }
    paramg = (ExchangeEmotionPackRequest)this.rr.gUS.gUX;
    paramg.ProductID = this.oyw;
    paramg.SeriesID = this.oyy;
    paramg.IsAutomatic = this.oyA;
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
    ad.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      g(this.oyw, -1, 0, this.hhN);
      AppMethodBeat.o(108681);
      return;
    }
    if (this.mScene == 0)
    {
      paramq = new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aij());
      if (!paramq.exists()) {
        paramq.mkdirs();
      }
      if (!this.oyB)
      {
        long l = System.currentTimeMillis();
        paramq = new StringBuilder();
        com.tencent.mm.kernel.g.afz();
        this.hhN = com.tencent.mm.ao.c.a("downzip", l, com.tencent.mm.kernel.a.getUin(), "emoji");
      }
      paramq = ((ExchangeEmotionPackResponse)this.rr.gUT.gUX).DownloadInfo;
      paramArrayOfByte = new com.tencent.mm.i.g();
      paramArrayOfByte.field_mediaId = this.hhN;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.loader.j.b.aij() + this.oyw);
      paramArrayOfByte.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = paramq.FileSize;
      paramArrayOfByte.field_aesKey = paramq.AesKey;
      paramArrayOfByte.field_fileId = paramq.Url;
      paramArrayOfByte.field_priority = com.tencent.mm.i.a.fmV;
      paramArrayOfByte.fnH = this.oyC;
      paramArrayOfByte.field_needStorage = true;
      this.gqP = false;
      if (!com.tencent.mm.ao.f.awL().b(paramArrayOfByte, -1)) {
        ad.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new k(this.oyw);
      com.tencent.mm.kernel.g.afA().gcy.a(paramString, 0);
      AppMethodBeat.o(108681);
      return;
      ad.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.g
 * JD-Core Version:    0.7.0.1
 */