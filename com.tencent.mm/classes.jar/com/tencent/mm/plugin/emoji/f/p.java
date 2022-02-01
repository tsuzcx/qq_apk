package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ayg;
import com.tencent.mm.protocal.protobuf.ayh;
import com.tencent.mm.sdk.platformtools.ad;
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
  public byte[] oyQ;
  private int ozc;
  private final b rr;
  
  public p(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private p(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(108715);
    this.oyQ = null;
    b.a locala = new b.a();
    locala.gUU = new ayg();
    locala.gUV = new ayh();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    this.ozc = paramInt;
    this.oyQ = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(108715);
  }
  
  public static com.tencent.mm.plugin.emoji.model.f a(ayh paramayh)
  {
    AppMethodBeat.i(108718);
    ad.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (paramayh == null)
    {
      AppMethodBeat.o(108718);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.f localf = new com.tencent.mm.plugin.emoji.model.f();
    if ((paramayh != null) && (paramayh.EmotionList != null))
    {
      localf.owY = paramayh.EmotionList.size();
      ArrayList localArrayList = new ArrayList();
      paramayh = paramayh.EmotionList.iterator();
      while (paramayh.hasNext())
      {
        EmotionSummary localEmotionSummary = (EmotionSummary)paramayh.next();
        if (localEmotionSummary.ProductID != null) {
          localArrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
        }
      }
      localf.owZ = localArrayList;
    }
    AppMethodBeat.o(108718);
    return localf;
  }
  
  public final ayh bVv()
  {
    if (this.rr == null) {
      return null;
    }
    return (ayh)this.rr.gUT.gUX;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(108717);
    this.callback = paramg;
    paramg = (ayg)this.rr.gUS.gUX;
    paramg.DesignerUin = this.ozc;
    if (this.oyQ != null)
    {
      paramg.ReqBuf = z.am(this.oyQ);
      paramg.Scene = this.mScene;
      if (paramg.ReqBuf != null) {
        break label106;
      }
    }
    label106:
    for (paramg = "Buf is NULL";; paramg = paramg.ReqBuf.toString())
    {
      ad.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", paramg);
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
    ad.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (ayh)((b)paramq).gUT.gUX;
    if (paramq.ReqBuf != null) {
      this.oyQ = z.a(paramq.ReqBuf);
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */