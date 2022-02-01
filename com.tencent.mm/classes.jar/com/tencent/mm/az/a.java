package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class a
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  public String oRm;
  public String oRn;
  public byte[] oRo;
  private final c rr;
  
  public a()
  {
    this(z.bAM(), Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(66561, null)), 0);
    AppMethodBeat.i(150870);
    AppMethodBeat.o(150870);
  }
  
  public a(String paramString, int paramInt)
  {
    this(paramString, paramInt, 0);
  }
  
  public a(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(150871);
    this.callback = null;
    this.oRm = null;
    this.oRn = null;
    this.oRo = null;
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cqj();
    ((c.a)localObject).otF = new cqk();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((c.a)localObject).funcId = 168;
    ((c.a)localObject).otG = 67;
    ((c.a)localObject).respCmdId = 1000000067;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cqj)c.b.b(this.rr.otB);
    ((cqj)localObject).ZqL = w.Sk(paramString);
    ((cqj)localObject).bcb = paramInt1;
    ((cqj)localObject).YIq = paramInt2;
    Log.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150871);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(150872);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(150872);
    return i;
  }
  
  public final int getType()
  {
    return 168;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(150873);
    Log.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + paramInt2 + " errCode" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (cqj)c.b.b(this.rr.otB);
      params = (cqk)c.c.b(this.rr.otC);
      paramArrayOfByte = w.a(paramArrayOfByte.ZqL);
      this.oRo = w.a(params.aauw, new byte[0]);
      this.oRm = params.aawU;
      Log.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.oRm, params.aawV, params.aawW });
      if (z.bAM().equals(paramArrayOfByte))
      {
        paramArrayOfByte = params.aawV;
        String str = (String)com.tencent.mm.kernel.h.baE().ban().d(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          com.tencent.mm.kernel.h.baE().ban().B(66563, paramArrayOfByte);
          this.oRn = params.aawW;
        }
        com.tencent.mm.kernel.h.baE().ban().B(66561, Integer.valueOf(params.bcb));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.az.a
 * JD-Core Version:    0.7.0.1
 */