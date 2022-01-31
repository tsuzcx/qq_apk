package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.coj;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class a
  extends m
  implements k
{
  private int audioFormat;
  f callback;
  private String fQQ;
  private int fQR;
  int fQS;
  private int fQT;
  private String filemd5;
  String filename;
  ap frx;
  private b rr;
  private int sampleRate;
  
  public a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(116535);
    this.fQQ = null;
    this.filemd5 = null;
    this.filename = null;
    this.sampleRate = 0;
    this.fQR = 0;
    this.audioFormat = 0;
    this.fQS = 0;
    this.fQT = 5;
    this.frx = new ap(new a.1(this), true);
    this.fQQ = bo.aoy();
    this.filename = paramString;
    this.fQT = paramInt1;
    this.sampleRate = paramInt2;
    this.fQR = paramInt3;
    this.audioFormat = paramInt4;
    paramInt1 = (int)com.tencent.mm.vfs.e.avI(this.filename);
    this.filemd5 = com.tencent.mm.a.g.w(com.tencent.mm.vfs.e.i(this.filename, 0, paramInt1));
    AppMethodBeat.o(116535);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 3960;
    AppMethodBeat.i(116536);
    this.callback = paramf;
    int k = (int)com.tencent.mm.vfs.e.avI(this.filename);
    ab.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ml() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.fQS + "this.filemd5 " + this.filemd5);
    if (k <= 0)
    {
      ab.e("MicroMsg.NetSceneUploadMedia", "read failed :" + this.filename);
      AppMethodBeat.o(116536);
      return -1;
    }
    int j = k - this.fQS;
    if (j > 3960) {}
    for (;;)
    {
      ab.i("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ml() + " read file:" + this.filename + " filelen:" + k + " oldoff:" + this.fQS + "  canReadLen " + i);
      paramf = com.tencent.mm.vfs.e.i(this.filename, this.fQS, i);
      if (paramf == null)
      {
        ab.e("MicroMsg.NetSceneUploadMedia", "read data error");
        AppMethodBeat.o(116536);
        return -1;
      }
      Object localObject = new b.a();
      ((b.a)localObject).fsX = new coj();
      ((b.a)localObject).fsY = new cok();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/mmuploadmedia";
      ((b.a)localObject).funcId = 240;
      ((b.a)localObject).reqCmdId = 111;
      ((b.a)localObject).respCmdId = 1000000111;
      this.rr = ((b.a)localObject).ado();
      localObject = (coj)this.rr.fsV.fta;
      ((coj)localObject).xXd = new bwc().aoF(this.fQQ);
      ((coj)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramf);
      ((coj)localObject).pIz = paramf.length;
      ((coj)localObject).xXe = new bwc().aoF(this.filemd5);
      ((coj)localObject).pIx = k;
      ((coj)localObject).pIy = this.fQS;
      ((coj)localObject).niE = this.fQT;
      ((coj)localObject).xXf = 1;
      ((coj)localObject).xXg = this.sampleRate;
      ((coj)localObject).xXh = this.fQR;
      ((coj)localObject).xXi = this.audioFormat;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(116536);
      return i;
      i = j;
    }
  }
  
  public final int getType()
  {
    return 240;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116537);
    updateDispatchId(paramInt1);
    ab.d("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd file:" + this.filename + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (coj)((b)paramq).fsV.fta;
    paramq = ((cok)((b)paramq).fsW.fta).fKz;
    ab.i("MicroMsg.NetSceneUploadMedia", "fileName:%s, md5:%s, totalLen:%d, dataLen:%d, startPos:%d", new Object[] { this.filename, paramq, Integer.valueOf(paramArrayOfByte.pIx), Integer.valueOf(paramArrayOfByte.pIz), Integer.valueOf(paramArrayOfByte.pIy) });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadMedia", com.tencent.mm.compatible.util.g.Ml() + " onGYNetEnd file:" + this.filename + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116537);
      return;
    }
    if ((paramArrayOfByte.pIx <= paramArrayOfByte.pIz + paramArrayOfByte.pIy) && (paramq != null) && (!paramq.equals("0")))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(116537);
      return;
    }
    paramInt1 = paramArrayOfByte.pIy;
    this.fQS = (paramArrayOfByte.pIA.getILen() + paramInt1);
    ab.d("MicroMsg.NetSceneUploadMedia", "onGYNetEnd file:" + this.filename + " delay:500");
    this.frx.ag(500L, 500L);
    AppMethodBeat.o(116537);
  }
  
  public final int securityLimitCount()
  {
    return 60;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bf.a
 * JD-Core Version:    0.7.0.1
 */