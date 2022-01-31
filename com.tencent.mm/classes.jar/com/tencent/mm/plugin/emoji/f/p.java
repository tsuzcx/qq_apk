package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  public byte[] liN;
  private int liY;
  private int mScene;
  private final b rr;
  
  public p(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private p(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(53143);
    this.liN = null;
    b.a locala = new b.a();
    locala.fsX = new aob();
    locala.fsY = new aoc();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    this.liY = paramInt;
    this.liN = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(53143);
  }
  
  public static com.tencent.mm.plugin.emoji.model.e a(aoc paramaoc)
  {
    AppMethodBeat.i(53146);
    ab.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (paramaoc == null)
    {
      AppMethodBeat.o(53146);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.e locale = new com.tencent.mm.plugin.emoji.model.e();
    if ((paramaoc != null) && (paramaoc.EmotionList != null))
    {
      locale.lhk = paramaoc.EmotionList.size();
      ArrayList localArrayList = new ArrayList();
      paramaoc = paramaoc.EmotionList.iterator();
      while (paramaoc.hasNext())
      {
        EmotionSummary localEmotionSummary = (EmotionSummary)paramaoc.next();
        if (localEmotionSummary.ProductID != null) {
          localArrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(localEmotionSummary));
        }
      }
      locale.lhl = localArrayList;
    }
    AppMethodBeat.o(53146);
    return locale;
  }
  
  public final aoc blK()
  {
    if (this.rr == null) {
      return null;
    }
    return (aoc)this.rr.fsW.fta;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(53145);
    this.callback = paramf;
    paramf = (aob)this.rr.fsV.fta;
    paramf.DesignerUin = this.liY;
    if (this.liN != null)
    {
      paramf.ReqBuf = aa.ac(this.liN);
      paramf.Scene = this.mScene;
      if (paramf.ReqBuf != null) {
        break label106;
      }
    }
    label106:
    for (paramf = "Buf is NULL";; paramf = paramf.ReqBuf.toString())
    {
      ab.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", paramf);
      int i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(53145);
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
    AppMethodBeat.i(53144);
    ab.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramq = (aoc)((b)paramq).fsW.fta;
    if (paramq.ReqBuf != null) {
      this.liN = aa.a(paramq.ReqBuf);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(53144);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.p
 * JD-Core Version:    0.7.0.1
 */