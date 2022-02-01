package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cpr;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class r
  extends p
  implements com.tencent.mm.network.m
{
  private h callback;
  private int mScene;
  private final c rr;
  public byte[] xOH;
  private int xOW;
  
  public r(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, (byte)0);
  }
  
  private r(int paramInt, byte[] paramArrayOfByte, byte paramByte)
  {
    AppMethodBeat.i(108715);
    this.xOH = null;
    c.a locala = new c.a();
    locala.otE = new cpr();
    locala.otF = new cps();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetpersonaldesigner";
    locala.funcId = 720;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    this.xOW = paramInt;
    this.xOH = paramArrayOfByte;
    this.mScene = 0;
    AppMethodBeat.o(108715);
  }
  
  public static com.tencent.mm.plugin.emoji.model.m a(cps paramcps)
  {
    AppMethodBeat.i(108718);
    Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", "getEmotionListModel");
    if (paramcps == null)
    {
      AppMethodBeat.o(108718);
      return null;
    }
    com.tencent.mm.plugin.emoji.model.m localm = new com.tencent.mm.plugin.emoji.model.m();
    if ((paramcps != null) && (paramcps.Zvf != null))
    {
      localm.xMT = paramcps.Zvf.size();
      ArrayList localArrayList = new ArrayList();
      paramcps = paramcps.Zvf.iterator();
      while (paramcps.hasNext())
      {
        cjb localcjb = (cjb)paramcps.next();
        if (localcjb.ProductID != null) {
          localArrayList.add(new f(localcjb));
        }
      }
      localm.xMU = localArrayList;
    }
    AppMethodBeat.o(108718);
    return localm;
  }
  
  public final cps dAJ()
  {
    AppMethodBeat.i(269840);
    if (this.rr == null)
    {
      AppMethodBeat.o(269840);
      return null;
    }
    cps localcps = (cps)c.c.b(this.rr.otC);
    AppMethodBeat.o(269840);
    return localcps;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(108717);
    this.callback = paramh;
    paramh = (cpr)c.b.b(this.rr.otB);
    paramh.ZtX = this.xOW;
    if (this.xOH != null)
    {
      paramh.YGU = w.aN(this.xOH);
      paramh.IJG = this.mScene;
      if (paramh.YGU != null) {
        break label106;
      }
    }
    label106:
    for (paramh = "Buf is NULL";; paramh = paramh.YGU.toString())
    {
      Log.d("MicroMsg.emoji.NetSceneGetPersonalDesigner", paramh);
      int i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(108717);
      return i;
      paramh.YGU = new gol();
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
    params = (cps)c.c.b(((c)params).otC);
    if (params.YGU != null) {
      this.xOH = w.a(params.YGU);
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(108716);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.r
 * JD-Core Version:    0.7.0.1
 */