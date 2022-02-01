package com.tencent.mm.plugin.emoji.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private int mScene;
  private final d rr;
  public byte[] uGe;
  private int uGq;
  
  public q(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private q(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(108715);
    this.uGe = null;
    d.a locala = new d.a();
    locala.lBU = new cai();
    locala.lBV = new caj();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    this.uGq = paramInt;
    this.uGe = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(108715);
  }
  
  public static l a(caj paramcaj)
  {
    AppMethodBeat.i(108718);
    Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (paramcaj == null)
    {
      AppMethodBeat.o(108718);
      return null;
    }
    l locall = new l();
    if ((paramcaj != null) && (paramcaj.Tek != null))
    {
      locall.uEw = paramcaj.Tek.size();
      ArrayList localArrayList = new ArrayList();
      paramcaj = paramcaj.Tek.iterator();
      while (paramcaj.hasNext())
      {
        akh localakh = (akh)paramcaj.next();
        if (localakh.ProductID != null) {
          localArrayList.add(new f(localakh));
        }
      }
      locall.uEx = localArrayList;
    }
    AppMethodBeat.o(108718);
    return locall;
  }
  
  public final caj cVj()
  {
    AppMethodBeat.i(257981);
    if (this.rr == null)
    {
      AppMethodBeat.o(257981);
      return null;
    }
    caj localcaj = (caj)d.c.b(this.rr.lBS);
    AppMethodBeat.o(257981);
    return localcaj;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(108717);
    this.callback = parami;
    parami = (cai)d.b.b(this.rr.lBR);
    parami.TdG = this.uGq;
    if (this.uGe != null)
    {
      parami.RJA = z.aN(this.uGe);
      parami.CPw = this.mScene;
      if (parami.RJA != null) {
        break label106;
      }
    }
    label106:
    for (parami = "Buf is NULL";; parami = parami.RJA.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", parami);
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108717);
      return i;
      parami.RJA = new eae();
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
    params = (caj)d.c.b(((d)params).lBS);
    if (params.RJA != null) {
      this.uGe = z.a(params.RJA);
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
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.q
 * JD-Core Version:    0.7.0.1
 */