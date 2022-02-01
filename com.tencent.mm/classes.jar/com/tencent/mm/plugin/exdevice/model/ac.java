package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.frq;
import com.tencent.mm.protocal.protobuf.frr;

public final class ac
  extends p
  implements m
{
  private h callback;
  private String hEl;
  private String hEr;
  public String kDc;
  private c rr;
  private int ysh;
  
  public ac(String paramString1, String paramString2, String paramString3)
  {
    this.kDc = paramString3;
    this.hEl = paramString1;
    this.hEr = paramString2;
    this.ysh = 0;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(23422);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new frq();
    paramh.otF = new frr();
    paramh.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
    paramh.funcId = getType();
    paramh.otG = 0;
    paramh.respCmdId = 0;
    this.rr = paramh.bEF();
    paramh = (frq)c.b.b(this.rr.otB);
    paramh.kDc = this.kDc;
    paramh.MyW = this.hEl;
    paramh.devicetype = this.hEr;
    paramh.abQY = this.ysh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(23422);
    return i;
  }
  
  public final int getType()
  {
    return 1263;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23423);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ac
 * JD-Core Version:    0.7.0.1
 */