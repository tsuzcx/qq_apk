package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.fwd;
import com.tencent.mm.protocal.protobuf.fwe;
import com.tencent.mm.sdk.platformtools.Log;

public class t
  extends p
  implements m
{
  private h callback;
  public String psE;
  public String psF;
  public String psp;
  private final c rr;
  
  public t(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(235810);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new fwd();
    ((c.a)localObject).otF = new fwe();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
    ((c.a)localObject).funcId = 853;
    this.rr = ((c.a)localObject).bEF();
    this.psp = paramString1;
    this.psE = paramString2;
    localObject = (fwd)c.b.b(this.rr.otB);
    ((fwd)localObject).psp = paramString1;
    ((fwd)localObject).psE = paramString2;
    ((fwd)localObject).YFU = paramInt;
    Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(235810);
  }
  
  public int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(151227);
    this.callback = paramh;
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
    Log.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, this.psp });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(151226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.model.t
 * JD-Core Version:    0.7.0.1
 */