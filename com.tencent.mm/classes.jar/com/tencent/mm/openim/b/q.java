package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.epp;
import com.tencent.mm.sdk.platformtools.Log;

public final class q
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  public String jGZ;
  public String jHi;
  public String jHj;
  private final d rr;
  
  public q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(223646);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new epo();
    ((d.a)localObject).iLO = new epp();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((d.a)localObject).funcId = 853;
    this.rr = ((d.a)localObject).aXF();
    this.jGZ = paramString1;
    this.jHi = paramString2;
    localObject = (epo)this.rr.iLK.iLR;
    ((epo)localObject).jGZ = paramString1;
    ((epo)localObject).jHi = paramString2;
    ((epo)localObject).KHA = paramInt;
    Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(223646);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151227);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151227);
    return i;
  }
  
  public final int getType()
  {
    return 853;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151226);
    Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.jGZ });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.b.q
 * JD-Core Version:    0.7.0.1
 */