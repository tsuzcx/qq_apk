package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bgd;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  private int mScene;
  public byte[] pGa;
  private int pGm;
  private final b rr;
  
  public p(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private p(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(108715);
    this.pGa = null;
    b.a locala = new b.a();
    locala.hNM = new bgc();
    locala.hNN = new bgd();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    this.pGm = paramInt;
    this.pGa = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(108715);
  }
  
  public static com.tencent.mm.plugin.emoji.model.f a(bgd parambgd)
  {
    AppMethodBeat.i(108718);
    ad.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (parambgd == null)
    {
      AppMethodBeat.o(108718);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if ((parambgd != null) && (parambgd.EmotionList != null))
    {
      localf.pEi = parambgd.EmotionList.size();
      ArrayList localArrayList = new ArrayList();
      parambgd = parambgd.EmotionList.iterator();
      while (parambgd.hasNext())
      {
        EmotionSummary localEmotionSummary = (EmotionSummary)parambgd.next();
        if (localEmotionSummary.ProductID != null) {
          localArrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
        }
      }
      localf.pEj = localArrayList;
    }
    AppMethodBeat.o(108718);
    return localf;
  }
  
  public final bgd chm()
  {
    if (this.rr == null) {
      return null;
    }
    return (bgd)this.rr.hNL.hNQ;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(108717);
    this.callback = paramf;
    paramf = (bgc)this.rr.hNK.hNQ;
    paramf.DesignerUin = this.pGm;
    if (this.pGa != null)
    {
      paramf.ReqBuf = z.al(this.pGa);
      paramf.Scene = this.mScene;
      if (paramf.ReqBuf != null) {
        break label106;
      }
    }
    label106:
    for (paramf = "Buf is NULL";; paramf = paramf.ReqBuf.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", paramf);
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108717);
      return i;
      paramf.ReqBuf = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public final int getType()
  {
    return 720;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108716);
    ad.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bgd)((b)paramq).hNL.hNQ;
    if (paramq.ReqBuf != null) {
      this.pGa = z.a(paramq.ReqBuf);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108716);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */