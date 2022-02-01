package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  private int mScene;
  public byte[] rcY;
  private int rdk;
  private final d rr;
  
  public q(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private q(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(108715);
    this.rcY = null;
    d.a locala = new d.a();
    locala.iLN = new bso();
    locala.iLO = new bsp();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    this.rdk = paramInt;
    this.rcY = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(108715);
  }
  
  public static com.tencent.mm.plugin.emoji.model.g a(bsp parambsp)
  {
    AppMethodBeat.i(108718);
    Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (parambsp == null)
    {
      AppMethodBeat.o(108718);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.g localg = new com.tencent.mm.plugin.emoji.model.g();
    if ((parambsp != null) && (parambsp.EmotionList != null))
    {
      localg.rbs = parambsp.EmotionList.size();
      ArrayList localArrayList = new ArrayList();
      parambsp = parambsp.EmotionList.iterator();
      while (parambsp.hasNext())
      {
        EmotionSummary localEmotionSummary = (EmotionSummary)parambsp.next();
        if (localEmotionSummary.ProductID != null) {
          localArrayList.add(new f(localEmotionSummary));
        }
      }
      localg.rbt = localArrayList;
    }
    AppMethodBeat.o(108718);
    return localg;
  }
  
  public final bsp cGA()
  {
    if (this.rr == null) {
      return null;
    }
    return (bsp)this.rr.iLL.iLR;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(108717);
    this.callback = parami;
    parami = (bso)this.rr.iLK.iLR;
    parami.DesignerUin = this.rdk;
    if (this.rcY != null)
    {
      parami.ReqBuf = z.aC(this.rcY);
      parami.Scene = this.mScene;
      if (parami.ReqBuf != null) {
        break label106;
      }
    }
    label106:
    for (parami = "Buf is NULL";; parami = parami.ReqBuf.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", parami);
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108717);
      return i;
      parami.ReqBuf = new SKBuiltinBuffer_t();
      break;
    }
  }
  
  public final int getType()
  {
    return 720;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108716);
    Log.i("MicroMsg.emoji.NetSceneGetPersonalDesigner", "NetSceneGetPersonalDesigner errType:%d,errcode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    params = (bsp)((d)params).iLL.iLR;
    if (params.ReqBuf != null) {
      this.rcY = z.a(params.ReqBuf);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108716);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */