package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.sdk.platformtools.Log;

public final class o
  extends p
  implements m
{
  private h callback;
  Object cpt;
  public c rr;
  
  public o(String paramString, cam paramcam, Object paramObject)
  {
    AppMethodBeat.i(124298);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new agu();
    ((c.a)localObject).otF = new agv();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/createbizchatinfo";
    ((c.a)localObject).funcId = 1355;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (agu)c.b.b(this.rr.otB);
    ((agu)localObject).YRQ = paramString;
    ((agu)localObject).ZpT = paramcam;
    this.cpt = paramObject;
    AppMethodBeat.o(124298);
  }
  
  public final agv bHE()
  {
    AppMethodBeat.i(239501);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      agv localagv = (agv)c.c.b(this.rr.otC);
      AppMethodBeat.o(239501);
      return localagv;
    }
    AppMethodBeat.o(239501);
    return null;
  }
  
  public final agu bHF()
  {
    AppMethodBeat.i(239502);
    if ((this.rr != null) && (c.b.b(this.rr.otB) != null))
    {
      agu localagu = (agu)c.b.b(this.rr.otB);
      AppMethodBeat.o(239502);
      return localagu;
    }
    AppMethodBeat.o(239502);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124300);
    this.callback = paramh;
    Log.i("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124300);
    return i;
  }
  
  public final int getType()
  {
    return 1355;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124299);
    Log.d("MicroMsg.brandservice.NetSceneCreateBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.an.a.o
 * JD-Core Version:    0.7.0.1
 */