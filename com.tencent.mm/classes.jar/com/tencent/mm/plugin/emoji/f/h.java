package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.emoji.sync.e;
import com.tencent.mm.emoji.sync.e.a.a;
import com.tencent.mm.emoji.sync.e.a.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public final class h
  extends com.tencent.mm.an.q
  implements m
{
  private i jQg;
  private boolean kUn;
  public String lPn;
  private int mScene;
  private final com.tencent.mm.an.d rr;
  public String uFI;
  public String uFJ;
  public String uFK;
  private String uFL;
  public String uFM;
  private int uFN;
  private boolean uFO;
  private g.a uFP;
  private EmojiGroupInfo uFQ;
  
  public h(String paramString)
  {
    this(paramString, null, "", null, null, 1, 0);
  }
  
  public h(String paramString, byte paramByte)
  {
    this(paramString, null, "", null, null, 1, 1);
  }
  
  public h(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2, null, null, 0, 0);
  }
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null, null);
  }
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, 0, 0);
  }
  
  private h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257937);
    this.lPn = "";
    this.uFP = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108679);
        if ((Util.isNullOrNil(h.a(h.this))) || (!paramAnonymousString.equals(h.a(h.this))))
        {
          Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt == -21006)
        {
          Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { h.a(h.this) });
          h.j(h.b(h.this), 6, 0, h.a(h.this));
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[] { h.b(h.this) });
          h.j(h.b(h.this), -1, 0, h.a(h.this));
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          if (paramAnonymousc.field_finishedLength == paramAnonymousc.field_toltalLength)
          {
            Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
            AppMethodBeat.o(108679);
            return 0;
          }
          Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { h.a(h.this), Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          if (!h.c(h.this)) {
            h.j(h.b(h.this), 6, (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F), h.a(h.this));
          }
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(10625, new Object[] { Integer.valueOf(2), paramAnonymousd.field_fileId, h.b(h.this), paramAnonymousd.field_transInfo });
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[] { h.b(h.this), Integer.valueOf(paramAnonymousd.field_retCode) });
            h.j(h.b(h.this), -1, 0, h.a(h.this));
          }
        }
        else
        {
          AppMethodBeat.o(108679);
          return 0;
        }
        Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
        paramAnonymousString = e.jNQ;
        paramAnonymousString = h.b(h.this);
        kotlin.g.b.p.k(paramAnonymousString, "productId");
        Log.i(e.access$getTAG$cp(), "checkPack: ".concat(String.valueOf(paramAnonymousString)));
        com.tencent.mm.ae.d.h((kotlin.g.a.a)new e.a.a(paramAnonymousString, (kotlin.g.a.b)e.a.b.jNU));
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.emoji.e.c.cUj();
          paramAnonymousc = h.b(h.this);
          if ((paramAnonymousString.uCv != null) && (paramAnonymousString.uCv.contains(paramAnonymousc))) {
            paramAnonymousString.uCv.remove(paramAnonymousc);
          }
          EmojiLogic.a(h.b(h.this), h.d(h.this), h.e(h.this), h.f(h.this), h.g(h.this));
          com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.doNotify();
          h.j(h.b(h.this), 7, 100, h.a(h.this));
          paramAnonymousString = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSO() + h.b(h.this));
          if ((paramAnonymousString.ifH()) && (paramAnonymousString.ifE())) {
            paramAnonymousString.cFq();
          }
          h.aS(h.b(h.this), true);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + Util.getStack());
          h.j(h.b(h.this), -1, 0, h.a(h.this));
          h.aS(h.b(h.this), false);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (OutOfMemoryError paramAnonymousString)
        {
          for (;;)
          {
            Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + Util.getStack());
          }
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.uFI = paramString1;
    this.uFJ = paramString3;
    this.uFK = paramString2;
    this.uFL = paramString4;
    this.uFM = paramString5;
    this.uFQ = null;
    this.uFN = paramInt1;
    this.mScene = paramInt2;
    this.uFO = false;
    paramString1 = new d.a();
    paramString1.lBU = new akx();
    paramString1.lBV = new aky();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.lBW = 213;
    paramString1.respCmdId = 1000000213;
    this.rr = paramString1.bgN();
    AppMethodBeat.o(257937);
  }
  
  private static void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108683);
    com.tencent.mm.plugin.emoji.model.p.cUT().i(paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(108683);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108684);
    super.cancel();
    this.kUn = true;
    AppMethodBeat.o(108684);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(108682);
    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.jQg = parami;
    if (this.mScene == 0) {
      i(this.uFI, 6, 0, this.lPn);
    }
    parami = (akx)d.b.b(this.rr.lBR);
    parami.ProductID = this.uFI;
    parami.SvE = this.uFK;
    parami.VHS = this.uFN;
    parami.CPw = this.mScene;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108682);
    return i;
  }
  
  public final int getType()
  {
    return 423;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108681);
    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      i(this.uFI, -1, 0, this.lPn);
      AppMethodBeat.o(108681);
      return;
    }
    params = com.tencent.mm.emoji.e.d.jPE;
    com.tencent.mm.emoji.e.d.LT(this.uFI);
    if (this.mScene == 0)
    {
      params = new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSO());
      if (!params.ifE()) {
        params.ifL();
      }
      if (!this.uFO)
      {
        long l = System.currentTimeMillis();
        params = new StringBuilder();
        com.tencent.mm.kernel.h.aHE();
        this.lPn = com.tencent.mm.aq.c.a("downzip", l, com.tencent.mm.kernel.b.getUin(), "emoji");
      }
      params = ((aky)d.c.b(this.rr.lBS)).VHT;
      paramArrayOfByte = new com.tencent.mm.i.g();
      paramArrayOfByte.taskName = "task_NetSceneExchangeEmotionPack";
      paramArrayOfByte.field_mediaId = this.lPn;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.loader.j.b.aSO() + this.uFI);
      paramArrayOfByte.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = params.HlG;
      paramArrayOfByte.field_aesKey = params.AesKey;
      paramArrayOfByte.field_fileId = params.Url;
      paramArrayOfByte.field_priority = com.tencent.mm.i.a.iTU;
      paramArrayOfByte.iUG = this.uFP;
      paramArrayOfByte.field_needStorage = true;
      this.kUn = false;
      if (!com.tencent.mm.aq.f.bkg().b(paramArrayOfByte, -1)) {
        Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new l(this.uFI);
      com.tencent.mm.kernel.h.aHF().kcd.a(paramString, 0);
      AppMethodBeat.o(108681);
      return;
      Log.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */