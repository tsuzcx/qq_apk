package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends n
  implements k
{
  private g callback;
  private int mScene;
  private int pcC;
  public byte[] pcq;
  private final b rr;
  
  public p(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private p(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(108715);
    this.pcq = null;
    b.a locala = new b.a();
    locala.hvt = new bby();
    locala.hvu = new bbz();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    this.pcC = paramInt;
    this.pcq = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(108715);
  }
  
  public static com.tencent.mm.plugin.emoji.model.f a(bbz parambbz)
  {
    AppMethodBeat.i(108718);
    ac.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (parambbz == null)
    {
      AppMethodBeat.o(108718);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if ((parambbz != null) && (parambbz.EmotionList != null))
    {
      localf.pay = parambbz.EmotionList.size();
      ArrayList localArrayList = new ArrayList();
      parambbz = parambbz.EmotionList.iterator();
      while (parambbz.hasNext())
      {
        EmotionSummary localEmotionSummary = (EmotionSummary)parambbz.next();
        if (localEmotionSummary.ProductID != null) {
          localArrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
        }
      }
      localf.paz = localArrayList;
    }
    AppMethodBeat.o(108718);
    return localf;
  }
  
  public final bbz ccI()
  {
    if (this.rr == null) {
      return null;
    }
    return (bbz)this.rr.hvs.hvw;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108717);
    this.callback = paramg;
    paramg = (bby)this.rr.hvr.hvw;
    paramg.DesignerUin = this.pcC;
    if (this.pcq != null)
    {
      paramg.ReqBuf = z.al(this.pcq);
      paramg.Scene = this.mScene;
      if (paramg.ReqBuf != null) {
        break label106;
      }
    }
    label106:
    for (paramg = "Buf is NULL";; paramg = paramg.ReqBuf.toString())
    {
      ac.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", paramg);
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(108717);
      return i;
      paramg.ReqBuf = new SKBuiltinBuffer_t();
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
    ac.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (bbz)((b)paramq).hvs.hvw;
    if (paramq.ReqBuf != null) {
      this.pcq = z.a(paramq.ReqBuf);
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
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */