package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ak.c;
import com.tencent.mm.j.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.File;

public final class h
  extends m
  implements k
{
  private com.tencent.mm.ah.f dIJ;
  private final com.tencent.mm.ah.b dmK;
  boolean edT;
  public String eoQ = "";
  private int fzn;
  public String iZD;
  public String iZE;
  public String iZF;
  String iZG;
  private int iZH;
  private f.a iZI = new h.1(this);
  EmojiGroupInfo iZJ;
  
  public h(String paramString)
  {
    this(paramString, null, "", null, 1, 0);
  }
  
  public h(String paramString, byte paramByte)
  {
    this(paramString, null, "", null, 1, 1);
  }
  
  public h(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2, null, 0, 0);
  }
  
  public h(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, null);
  }
  
  public h(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, paramString4, 0, 0);
  }
  
  private h(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this.iZD = paramString1;
    this.iZE = paramString3;
    this.iZF = paramString2;
    this.iZG = paramString4;
    this.iZJ = null;
    this.iZH = paramInt1;
    this.fzn = paramInt2;
    paramString1 = new b.a();
    paramString1.ecH = new vy();
    paramString1.ecI = new vz();
    paramString1.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
    paramString1.ecG = 423;
    paramString1.ecJ = 213;
    paramString1.ecK = 1000000213;
    this.dmK = paramString1.Kt();
  }
  
  static void g(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    i.aHU().g(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    y.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
    this.dIJ = paramf;
    if (this.fzn == 0) {
      g(this.iZD, 6, 0, this.eoQ);
    }
    paramf = (vy)this.dmK.ecE.ecN;
    paramf.syc = this.iZD;
    paramf.sTa = this.iZF;
    paramf.sTb = this.iZH;
    paramf.pyo = this.fzn;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      g(this.iZD, -1, 0, this.eoQ);
      return;
    }
    if (this.fzn == 0)
    {
      paramq = new File(com.tencent.mm.compatible.util.e.dzB);
      if (!paramq.exists()) {
        paramq.mkdirs();
      }
      long l = System.currentTimeMillis();
      paramq = new StringBuilder();
      g.DN();
      this.eoQ = c.a("downzip", l, com.tencent.mm.kernel.a.CK(), "emoji");
      paramq = ((vz)this.dmK.ecF.ecN).sTc;
      paramArrayOfByte = new com.tencent.mm.j.f();
      paramArrayOfByte.field_mediaId = this.eoQ;
      paramArrayOfByte.field_fullpath = (com.tencent.mm.compatible.util.e.dzB + this.iZD);
      paramArrayOfByte.field_fileType = com.tencent.mm.j.a.MediaType_FILE;
      paramArrayOfByte.field_totalLen = paramq.ndo;
      paramArrayOfByte.field_aesKey = paramq.sRu;
      paramArrayOfByte.field_fileId = paramq.kSC;
      paramArrayOfByte.field_priority = com.tencent.mm.j.a.dlk;
      paramArrayOfByte.dlP = this.iZI;
      paramArrayOfByte.field_needStorage = true;
      this.edT = false;
      if (!com.tencent.mm.ak.f.Nd().b(paramArrayOfByte, -1)) {
        y.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
      }
    }
    for (;;)
    {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
      paramString = new l(this.iZD);
      g.DO().dJT.a(paramString, 0);
      return;
      y.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
    }
  }
  
  protected final void cancel()
  {
    super.cancel();
    this.edT = true;
  }
  
  public final int getType()
  {
    return 423;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.h
 * JD-Core Version:    0.7.0.1
 */