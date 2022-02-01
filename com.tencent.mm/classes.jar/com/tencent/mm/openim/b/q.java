package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ezz;
import com.tencent.mm.protocal.protobuf.faa;
import com.tencent.mm.sdk.platformtools.Log;

public class q
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  public String myd;
  public String mym;
  public String myn;
  private final d rr;
  
  public q(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(214226);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ezz();
    ((d.a)localObject).lBV = new faa();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((d.a)localObject).funcId = 853;
    this.rr = ((d.a)localObject).bgN();
    this.myd = paramString1;
    this.mym = paramString2;
    localObject = (ezz)d.b.b(this.rr.lBR);
    ((ezz)localObject).myd = paramString1;
    ((ezz)localObject).mym = paramString2;
    ((ezz)localObject).RIT = paramInt;
    Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(214226);
  }
  
  public int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(151227);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(151227);
    return i;
  }
  
  public int getType()
  {
    return 853;
  }
  
  public void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(151226);
    Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.myd });
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