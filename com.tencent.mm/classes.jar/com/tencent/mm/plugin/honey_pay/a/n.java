package com.tencent.mm.plugin.honey_pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p;

public final class n
  extends p
{
  private final String TAG;
  public cmg nHp;
  
  public n(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41743);
    this.TAG = "MicroMsg.NetSceneUnbindHoneyPayCard";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cmf();
    ((b.a)localObject).fsY = new cmg();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/unbindhpcard";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (cmf)this.rr.fsV.fta;
    ((cmf)localObject).xcf = paramString1;
    ((cmf)localObject).wOx = paramString2;
    AppMethodBeat.o(41743);
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(41744);
    ab.i("MicroMsg.NetSceneUnbindHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nHp = ((cmg)((b)paramq).fsW.fta);
    ab.i("MicroMsg.NetSceneUnbindHoneyPayCard", "retcode: %s, retmsg: %s", new Object[] { Integer.valueOf(this.nHp.koj), this.nHp.kok });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(41744);
  }
  
  public final void e(q paramq)
  {
    paramq = (cmg)((b)paramq).fsW.fta;
    this.AXb = paramq.koj;
    this.AXc = paramq.kok;
  }
  
  public final int getType()
  {
    return 2659;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.a.n
 * JD-Core Version:    0.7.0.1
 */