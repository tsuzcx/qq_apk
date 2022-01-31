package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnv;
import com.tencent.mm.protocal.protobuf.cnw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.io.File;

public final class b
  extends m
  implements k
{
  private f callback;
  private int chT;
  private String clientId;
  public String fNq;
  private int fsd;
  private String imgPath;
  private com.tencent.mm.ai.b rr;
  private String username;
  
  private b(String paramString)
  {
    AppMethodBeat.i(136858);
    this.username = paramString;
    this.fsd = 0;
    this.chT = 0;
    paramString = new StringBuilder();
    g.RJ();
    this.clientId = (com.tencent.mm.kernel.a.getUin() + System.currentTimeMillis());
    AppMethodBeat.o(136858);
  }
  
  public b(String paramString1, String paramString2)
  {
    this(paramString1);
    this.imgPath = paramString2;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(136860);
    this.callback = paramf;
    if ((this.imgPath == null) || (this.imgPath.length() == 0))
    {
      ab.e("MicroMsg.NetSceneUploadCardImg", "imgPath is null or length = 0");
      AppMethodBeat.o(136860);
      return -1;
    }
    if (!com.tencent.mm.a.e.cN(this.imgPath))
    {
      ab.e("MicroMsg.NetSceneUploadCardImg", "The img does not exist, imgPath = " + this.imgPath);
      AppMethodBeat.o(136860);
      return -1;
    }
    if (this.fsd == 0) {
      this.fsd = ((int)new File(this.imgPath).length());
    }
    paramf = new b.a();
    paramf.fsX = new cnv();
    paramf.fsY = new cnw();
    paramf.uri = "/cgi-bin/micromsg-bin/uploadcardimg";
    paramf.funcId = 575;
    paramf.reqCmdId = 0;
    paramf.respCmdId = 0;
    this.rr = paramf.ado();
    int i = Math.min(this.fsd - this.chT, 32768);
    paramf = com.tencent.mm.a.e.i(this.imgPath, this.chT, i);
    if (paramf == null)
    {
      ab.e("MicroMsg.NetSceneUploadCardImg", "readFromFile error");
      AppMethodBeat.o(136860);
      return -1;
    }
    ab.i("MicroMsg.NetSceneUploadCardImg", "doScene uploadLen:%d, total: %d", new Object[] { Integer.valueOf(paramf.length), Integer.valueOf(this.fsd) });
    cnv localcnv = (cnv)this.rr.fsV.fta;
    localcnv.wPh = this.username;
    localcnv.pIx = this.fsd;
    localcnv.pIy = this.chT;
    localcnv.pIA = new SKBuiltinBuffer_t().setBuffer(paramf);
    localcnv.pIz = localcnv.pIA.getILen();
    localcnv.pIw = this.clientId;
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(136860);
    return i;
  }
  
  public final int getType()
  {
    return 575;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136861);
    ab.d("MicroMsg.NetSceneUploadCardImg", "onGYNetEnd:%s, %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadCardImg", "upload card img error");
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(136861);
      return;
    }
    paramq = (cnw)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.fNq = paramq.xtD;
    this.chT = paramq.pIy;
    if (this.chT < this.fsd)
    {
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ab.e("MicroMsg.NetSceneUploadCardImg", "doScene again failed");
        this.callback.onSceneEnd(3, -1, "", this);
      }
      ab.d("MicroMsg.NetSceneUploadCardImg", "doScene again");
      AppMethodBeat.o(136861);
      return;
    }
    if (!bo.isNullOrNil(this.fNq))
    {
      paramq = ((j)g.E(j.class)).YA().arw(this.username);
      if ((paramq != null) && ((int)paramq.euF > 0) && (com.tencent.mm.n.a.je(paramq.field_type)))
      {
        paramq.jN(this.fNq);
        ((j)g.E(j.class)).YA().b(this.username, paramq);
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(136861);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(136859);
    if ((this.imgPath == null) || (this.imgPath.length() == 0))
    {
      paramq = m.b.ftv;
      AppMethodBeat.o(136859);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(136859);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.b
 * JD-Core Version:    0.7.0.1
 */