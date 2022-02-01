package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.sync.d.a.a;
import com.tencent.mm.emoji.sync.d.a.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.protocal.protobuf.EmotionCDNUrl;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackRequest;
import com.tencent.mm.protocal.protobuf.ExchangeEmotionPackResponse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import kotlin.g.b.p;

public final class h
  extends q
  implements m
{
  private i heq;
  public String iYT;
  boolean ifz;
  private int mScene;
  public String rcD;
  public String rcE;
  public String rcF;
  String rcG;
  public String rcH;
  private int rcI;
  private boolean rcJ;
  private g.a rcK;
  EmojiGroupInfo rcL;
  private final com.tencent.mm.ak.d rr;
  
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
    AppMethodBeat.i(240153);
    this.iYT = "";
    this.rcK = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(108679);
        if ((Util.isNullOrNil(h.this.iYT)) || (!paramAnonymousString.equals(h.this.iYT)))
        {
          Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt == -21006)
        {
          Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[] { h.this.iYT });
          h.h(h.this.rcD, 6, 0, h.this.iYT);
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[] { h.this.rcD });
          h.h(h.this.rcD, -1, 0, h.this.iYT);
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
          Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[] { h.this.iYT, Long.valueOf(paramAnonymousc.field_finishedLength), Long.valueOf(paramAnonymousc.field_toltalLength) });
          if (!h.this.ifz) {
            h.h(h.this.rcD, 6, (int)((float)paramAnonymousc.field_finishedLength / (float)paramAnonymousc.field_toltalLength * 100.0F), h.this.iYT);
          }
          AppMethodBeat.o(108679);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(10625, new Object[] { Integer.valueOf(2), paramAnonymousd.field_fileId, h.this.rcD, paramAnonymousd.field_transInfo });
          if (paramAnonymousd.field_retCode != 0)
          {
            Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[] { h.this.rcD, Integer.valueOf(paramAnonymousd.field_retCode) });
            h.h(h.this.rcD, -1, 0, h.this.iYT);
          }
        }
        else
        {
          AppMethodBeat.o(108679);
          return 0;
        }
        Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
        paramAnonymousString = com.tencent.mm.emoji.sync.d.hcI;
        paramAnonymousString = h.this.rcD;
        p.h(paramAnonymousString, "productId");
        Log.i(com.tencent.mm.emoji.sync.d.access$getTAG$cp(), "checkPack: ".concat(String.valueOf(paramAnonymousString)));
        com.tencent.mm.ac.d.i((kotlin.g.a.a)new d.a.a(paramAnonymousString, (kotlin.g.a.b)d.a.b.hcM));
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.emoji.e.c.cFD();
          paramAnonymousc = h.this.rcD;
          if ((paramAnonymousString.qZu != null) && (paramAnonymousString.qZu.contains(paramAnonymousc))) {
            paramAnonymousString.qZu.remove(paramAnonymousc);
          }
          EmojiLogic.a(h.this.rcD, h.this.rcE, h.this.rcG, h.this.rcH, h.this.rcL);
          k.getEmojiStorageMgr().OpN.doNotify();
          h.h(h.this.rcD, 7, 100, h.this.iYT);
          paramAnonymousString = new o(com.tencent.mm.loader.j.b.aKM() + h.this.rcD);
          if ((paramAnonymousString.isFile()) && (paramAnonymousString.exists())) {
            paramAnonymousString.delete();
          }
          h.aP(h.this.rcD, true);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + Util.getStack());
          h.h(h.this.rcD, -1, 0, h.this.iYT);
          h.aP(h.this.rcD, false);
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
    this.rcD = paramString1;
    this.rcE = paramString3;
    this.rcF = paramString2;
    this.rcG = paramString4;
    this.rcH = paramString5;
    this.rcL = null;
    this.rcI = paramInt1;
    this.mScene = paramInt2;
    this.rcJ = false;
    paramString1 = new d.a();
    paramString1.iLN = new ExchangeEmotionPackRequest();
    paramString1.iLO = new ExchangeEmotionPackResponse();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.iLP = 213;
    paramString1.respCmdId = 1000000213;
    this.rr = paramString1.aXF();
    AppMethodBeat.o(240153);
  }
  
  static void h(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108683);
    k.cGk().h(paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(108683);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108684);
    super.cancel();
    this.ifz = true;
    AppMethodBeat.o(108684);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(108682);
    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.heq = parami;
    if (this.mScene == 0) {
      h(this.rcD, 6, 0, this.iYT);
    }
    parami = (ExchangeEmotionPackRequest)this.rr.iLK.iLR;
    parami.ProductID = this.rcD;
    parami.SeriesID = this.rcF;
    parami.IsAutomatic = this.rcI;
    parami.Scene = this.mScene;
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
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
      h(this.rcD, -1, 0, this.iYT);
      AppMethodBeat.o(108681);
      return;
    }
    params = com.tencent.mm.emoji.e.d.hdY;
    com.tencent.mm.emoji.e.d.Fa(this.rcD);
    if (this.mScene == 0)
    {
      params = new o(com.tencent.mm.loader.j.b.aKM());
      if (!params.exists()) {
        params.mkdirs();
      }
      if (!this.rcJ)
      {
        long l = System.currentTimeMillis();
        params = new StringBuilder();
        com.tencent.mm.kernel.g.aAf();
        this.iYT = com.tencent.mm.an.c.a("downzip", l, com.tencent.mm.kernel.a.getUin(), "emoji");
      }
      params = ((ExchangeEmotionPackResponse)this.rr.iLL.iLR).DownloadInfo;
      paramArrayOfByte = new com.tencent.mm.i.g();
      paramArrayOfByte.taskName = "task_NetSceneExchangeEmotionPack";
      paramArrayOfByte.field_mediaId = this.iYT;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.loader.j.b.aKM() + this.rcD);
      paramArrayOfByte.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = params.FileSize;
      paramArrayOfByte.field_aesKey = params.AesKey;
      paramArrayOfByte.field_fileId = params.Url;
      paramArrayOfByte.field_priority = com.tencent.mm.i.a.gpM;
      paramArrayOfByte.gqy = this.rcK;
      paramArrayOfByte.field_needStorage = true;
      this.ifz = false;
      if (!com.tencent.mm.an.f.baQ().b(paramArrayOfByte, -1)) {
        Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new l(this.rcD);
      com.tencent.mm.kernel.g.aAg().hqi.a(paramString, 0);
      AppMethodBeat.o(108681);
      return;
      Log.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */