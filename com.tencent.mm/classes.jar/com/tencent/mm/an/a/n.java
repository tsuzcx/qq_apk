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
import com.tencent.mm.protocal.protobuf.agj;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends p
  implements m
{
  private h callback;
  Object cpt;
  public String oyw;
  public c rr;
  
  public n(String paramString1, String paramString2, String paramString3, Object paramObject)
  {
    AppMethodBeat.i(124295);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new agj();
    ((c.a)localObject).otF = new agk();
    ((c.a)localObject).uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
    ((c.a)localObject).funcId = 1315;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (agj)c.b.b(this.rr.otB);
    ((agj)localObject).ZpC = paramString1;
    ((agj)localObject).ZpE = paramString2;
    ((agj)localObject).ZpD = paramString3;
    this.cpt = paramObject;
    AppMethodBeat.o(124295);
  }
  
  public final agk bHD()
  {
    AppMethodBeat.i(239500);
    if ((this.rr != null) && (c.c.b(this.rr.otC) != null))
    {
      agk localagk = (agk)c.c.b(this.rr.otC);
      AppMethodBeat.o(239500);
      return localagk;
    }
    AppMethodBeat.o(239500);
    return null;
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(124297);
    this.callback = paramh;
    Log.i("MicroMsg.NetSceneConvertBizChat", "do scene");
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(124297);
    return i;
  }
  
  public final int getType()
  {
    return 1315;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(124296);
    Log.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(124296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.a.n
 * JD-Core Version:    0.7.0.1
 */