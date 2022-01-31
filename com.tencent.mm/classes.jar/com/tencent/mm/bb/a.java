package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.aor;
import com.tencent.mm.protocal.protobuf.aos;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class a
  extends m
  implements k
{
  private f callback;
  public String fMS;
  public String fMT;
  public byte[] fMU;
  private final b rr;
  
  public a()
  {
    this(r.Zn(), bo.g((Integer)g.RL().Ru().get(66561, null)), 0);
    AppMethodBeat.i(78520);
    AppMethodBeat.o(78520);
  }
  
  public a(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
  }
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(78521);
    this.callback = null;
    this.fMS = null;
    this.fMT = null;
    this.fMU = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new aor();
    ((b.a)localObject).fsY = new aos();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((b.a)localObject).funcId = 168;
    ((b.a)localObject).reqCmdId = 67;
    ((b.a)localObject).respCmdId = 1000000067;
    this.rr = ((b.a)localObject).ado();
    localObject = (aor)this.rr.fsV.fta;
    ((aor)localObject).wOT = aa.wA(paramString);
    ((aor)localObject).xez = paramInt1;
    ((aor)localObject).OpCode = paramInt2;
    ab.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(78521);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(78522);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78522);
    return i;
  }
  
  public final int getType()
  {
    return 168;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78523);
    ab.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (aor)this.rr.fsV.fta;
      paramq = (aos)this.rr.fsW.fta;
      paramArrayOfByte = aa.a(paramArrayOfByte.wOT);
      this.fMU = aa.a(paramq.xeA, new byte[0]);
      this.fMS = paramq.xeB;
      ab.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.fMS, paramq.xeC, paramq.xeD });
      if (r.Zn().equals(paramArrayOfByte))
      {
        paramArrayOfByte = paramq.xeC;
        String str = (String)g.RL().Ru().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          g.RL().Ru().set(66563, paramArrayOfByte);
          this.fMT = paramq.xeD;
        }
        g.RL().Ru().set(66561, Integer.valueOf(paramq.xez));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */