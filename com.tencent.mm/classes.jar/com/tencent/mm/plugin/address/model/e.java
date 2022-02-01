package com.tencent.mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private f callback;
  public boolean juB;
  public String nickname;
  private b rr;
  public String username;
  
  public e(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(20777);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new crm();
    ((b.a)localObject).hQG = new crn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
    ((b.a)localObject).funcId = 417;
    ((b.a)localObject).hQH = 202;
    ((b.a)localObject).respCmdId = 1000000202;
    this.rr = ((b.a)localObject).aDS();
    localObject = (crm)this.rr.hQD.hQJ;
    ((crm)localObject).phB = 0;
    ((crm)localObject).HCR = paramString1;
    ((crm)localObject).dwb = paramString2;
    ((crm)localObject).scene = paramInt;
    AppMethodBeat.o(20777);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(20779);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(20779);
    return i;
  }
  
  public final int getType()
  {
    return 417;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    AppMethodBeat.i(20778);
    ae.d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (crn)((b)paramq).hQE.hQJ;
      this.username = paramq.qsG;
      this.nickname = paramq.HCU;
      if (paramq.HCT != 1) {
        break label198;
      }
    }
    for (;;)
    {
      this.juB = bool;
      if (paramq.HCE.HCH != null)
      {
        ae.d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + paramq.HCE.HCH.size());
        a.aVq();
        a.aVs().t(paramq.HCE.HCH);
        a.aVq();
        a.aVs().aVu();
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(20778);
      return;
      label198:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.e
 * JD-Core Version:    0.7.0.1
 */