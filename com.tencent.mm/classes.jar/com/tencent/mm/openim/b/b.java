package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dk;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends q
  implements m
{
  private i callback;
  public String jGZ;
  private final d rr;
  
  public b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151180);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new dk();
    ((d.a)localObject).iLO = new dl();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/addopenimcontact";
    ((d.a)localObject).funcId = 667;
    this.rr = ((d.a)localObject).aXF();
    this.jGZ = paramString1;
    localObject = (dk)this.rr.iLK.iLR;
    ((dk)localObject).jGZ = paramString1;
    ((dk)localObject).KHz = paramString2;
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(151180);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151182);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151182);
    return i;
  }
  
  public final int getType()
  {
    return 667;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151181);
    Log.i("MicroMsg.Openim.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.jGZ });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.b.b
 * JD-Core Version:    0.7.0.1
 */