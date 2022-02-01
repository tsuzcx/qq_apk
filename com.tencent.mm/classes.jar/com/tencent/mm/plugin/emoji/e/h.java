package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.emoji.sync.e;
import com.tencent.mm.emoji.sync.e.a.a;
import com.tencent.mm.emoji.sync.e.a.b;
import com.tencent.mm.g.g.a;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public final class h
  extends p
  implements m
{
  private com.tencent.mm.am.h mAY;
  private int mScene;
  private String mToken;
  private boolean nzW;
  public String oHX;
  private final com.tencent.mm.am.c rr;
  public String xOk;
  public String xOl;
  public String xOm;
  private String xOn;
  public String xOo;
  private int xOp;
  private int xOq;
  private boolean xOr;
  private g.a xOs;
  private EmojiGroupInfo xOt;
  
  public h(String paramString)
  {
    this(paramString, null, "", null, null, 1, 0, 0, null);
  }
  
  public h(String paramString, byte paramByte)
  {
    this(paramString, null, "", null, null, 1, 1, 0, null);
  }
  
  public h(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2, null, null, 0, 0, 0, null);
  }
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null, null);
  }
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramString5, 0, 0, 0, null);
  }
  
  private h(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, String paramString6)
  {
    AppMethodBeat.i(269816);
    this.oHX = "";
    this.xOs = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
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
          com.tencent.mm.plugin.report.service.h.OAn.b(10625, new Object[] { Integer.valueOf(2), paramAnonymousd.field_fileId, h.b(h.this), paramAnonymousd.field_transInfo });
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
        paramAnonymousString = e.mmI;
        paramAnonymousString = h.b(h.this);
        kotlin.g.b.s.u(paramAnonymousString, "productId");
        Log.i(e.access$getTAG$cp(), kotlin.g.b.s.X("checkPack: ", paramAnonymousString));
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new e.a.a(paramAnonymousString, (kotlin.g.a.b)e.a.b.mmQ));
        try
        {
          paramAnonymousString = com.tencent.mm.plugin.emoji.mgr.c.dzq();
          paramAnonymousc = h.b(h.this);
          if ((paramAnonymousString.xKR != null) && (paramAnonymousString.xKR.contains(paramAnonymousc))) {
            paramAnonymousString.xKR.remove(paramAnonymousc);
          }
          EmojiLogic.a(h.b(h.this), h.d(h.this), h.e(h.this), h.f(h.this), h.g(h.this));
          com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.doNotify();
          h.j(h.b(h.this), 7, 100, h.a(h.this));
          paramAnonymousString = new u(com.tencent.mm.loader.i.b.bmC() + h.b(h.this));
          if ((paramAnonymousString.jKV()) && (paramAnonymousString.jKS())) {
            paramAnonymousString.diJ();
          }
          h.be(h.b(h.this), true);
          AppMethodBeat.o(108679);
          return 0;
        }
        catch (Exception paramAnonymousString)
        {
          Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + Util.getStack());
          h.j(h.b(h.this), -1, 0, h.a(h.this));
          h.be(h.b(h.this), false);
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
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.xOk = paramString1;
    this.xOl = paramString3;
    this.xOm = paramString2;
    this.xOn = paramString4;
    this.xOo = paramString5;
    this.xOt = null;
    this.xOp = paramInt1;
    this.mScene = paramInt2;
    this.xOr = false;
    this.xOq = paramInt3;
    this.mToken = paramString6;
    paramString1 = new c.a();
    paramString1.otE = new cjc();
    paramString1.otF = new cjd();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.funcId = 423;
    paramString1.otG = 213;
    paramString1.respCmdId = 1000000213;
    this.rr = paramString1.bEF();
    AppMethodBeat.o(269816);
  }
  
  private static void i(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(108683);
    com.tencent.mm.plugin.emoji.model.s.dAq().i(paramString1, paramInt1, paramInt2, paramString2);
    AppMethodBeat.o(108683);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(108684);
    super.cancel();
    this.nzW = true;
    AppMethodBeat.o(108684);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(108682);
    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.mAY = paramh;
    if (this.mScene == 0) {
      i(this.xOk, 6, 0, this.oHX);
    }
    paramh = (cjc)c.b.b(this.rr.otB);
    paramh.ProductID = this.xOk;
    paramh.ZvK = this.xOm;
    paramh.akkD = this.xOp;
    paramh.IJG = this.mScene;
    paramh.IcB = this.xOq;
    paramh.akkE = w.ak(this.mToken, false);
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(108682);
    return i;
  }
  
  public final int getType()
  {
    return 423;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108681);
    Log.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      i(this.xOk, -1, 0, this.oHX);
      AppMethodBeat.o(108681);
      return;
    }
    params = com.tencent.mm.emoji.f.f.mow;
    com.tencent.mm.emoji.f.f.Ez(this.xOk);
    if (this.mScene == 0)
    {
      params = new u(com.tencent.mm.loader.i.b.bmC());
      if (!params.jKS()) {
        params.jKY();
      }
      if (!this.xOr)
      {
        long l = System.currentTimeMillis();
        params = new StringBuilder();
        com.tencent.mm.kernel.h.baC();
        this.oHX = com.tencent.mm.modelcdntran.h.a("downzip", l, com.tencent.mm.kernel.b.getUin(), "emoji");
      }
      params = ((cjd)c.c.b(this.rr.otC)).akkF;
      paramArrayOfByte = new com.tencent.mm.g.g();
      paramArrayOfByte.taskName = "task_NetSceneExchangeEmotionPack";
      paramArrayOfByte.field_mediaId = this.oHX;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.loader.i.b.bmC() + this.xOk);
      paramArrayOfByte.field_fileType = com.tencent.mm.g.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = params.Nju;
      paramArrayOfByte.field_aesKey = params.AesKey;
      paramArrayOfByte.field_fileId = params.Url;
      paramArrayOfByte.field_priority = com.tencent.mm.g.a.lvZ;
      paramArrayOfByte.lwL = this.xOs;
      paramArrayOfByte.field_needStorage = true;
      this.nzW = false;
      if (!k.bHW().b(paramArrayOfByte, -1)) {
        Log.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new l(this.xOk);
      com.tencent.mm.kernel.h.baD().mCm.a(paramString, 0);
      AppMethodBeat.o(108681);
      return;
      Log.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.h
 * JD-Core Version:    0.7.0.1
 */