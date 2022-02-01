package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bgs;
import com.tencent.mm.protocal.protobuf.bgt;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private int mScene;
  public byte[] pME;
  private int pMQ;
  private final b rr;
  
  public p(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private p(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(108715);
    this.pME = null;
    b.a locala = new b.a();
    locala.hQF = new bgs();
    locala.hQG = new bgt();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    this.pMQ = paramInt;
    this.pME = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(108715);
  }
  
  public static com.tencent.mm.plugin.emoji.model.f a(bgt parambgt)
  {
    AppMethodBeat.i(108718);
    ae.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (parambgt == null)
    {
      AppMethodBeat.o(108718);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if ((parambgt != null) && (parambgt.EmotionList != null))
    {
      localf.pKM = parambgt.EmotionList.size();
      ArrayList localArrayList = new ArrayList();
      parambgt = parambgt.EmotionList.iterator();
      while (parambgt.hasNext())
      {
        EmotionSummary localEmotionSummary = (EmotionSummary)parambgt.next();
        if (localEmotionSummary.ProductID != null) {
          localArrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
        }
      }
      localf.pKN = localArrayList;
    }
    AppMethodBeat.o(108718);
    return localf;
  }
  
  public final bgt ciC()
  {
    if (this.rr == null) {
      return null;
    }
    return (bgt)this.rr.hQE.hQJ;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(108717);
    this.callback = paramf;
    paramf = (bgs)this.rr.hQD.hQJ;
    paramf.DesignerUin = this.pMQ;
    if (this.pME != null)
    {
      paramf.ReqBuf = z.al(this.pME);
      paramf.Scene = this.mScene;
      if (paramf.ReqBuf != null) {
        break label106;
      }
    }
    label106:
    for (paramf = "Buf is NULL";; paramf = paramf.ReqBuf.toString())
    {
      ae.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", paramf);
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
    ae.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bgt)((b)paramq).hQE.hQJ;
    if (paramq.ReqBuf != null) {
      this.pME = z.a(paramq.ReqBuf);
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
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */