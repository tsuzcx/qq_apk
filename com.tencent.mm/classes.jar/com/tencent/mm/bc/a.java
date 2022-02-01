package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class a
  extends q
  implements m
{
  private i callback;
  public String jhF;
  public String jhG;
  public byte[] jhH;
  private final d rr;
  
  public a()
  {
    this(com.tencent.mm.model.z.aTY(), Util.nullAsNil((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(66561, null)), 0);
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
    this.jhF = null;
    this.jhG = null;
    this.jhH = null;
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bti();
    ((d.a)localObject).iLO = new btj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((d.a)localObject).funcId = 168;
    ((d.a)localObject).iLP = 67;
    ((d.a)localObject).respCmdId = 1000000067;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bti)this.rr.iLK.iLR;
    ((bti)localObject).Lqk = com.tencent.mm.platformtools.z.Su(paramString);
    ((bti)localObject).KUh = paramInt1;
    ((bti)localObject).OpCode = paramInt2;
    Log.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150871);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(150872);
    this.callback = parami;
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
      paramArrayOfByte = (bti)this.rr.iLK.iLR;
      params = (btj)this.rr.iLL.iLR;
      paramArrayOfByte = com.tencent.mm.platformtools.z.a(paramArrayOfByte.Lqk);
      this.jhH = com.tencent.mm.platformtools.z.a(params.LXP, new byte[0]);
      this.jhF = params.LZY;
      Log.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.jhF, params.LZZ, params.Maa });
      if (com.tencent.mm.model.z.aTY().equals(paramArrayOfByte))
      {
        paramArrayOfByte = params.LZZ;
        String str = (String)com.tencent.mm.kernel.g.aAh().azQ().get(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          com.tencent.mm.kernel.g.aAh().azQ().set(66563, paramArrayOfByte);
          this.jhG = params.Maa;
        }
        com.tencent.mm.kernel.g.aAh().azQ().set(66561, Integer.valueOf(params.KUh));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.a
 * JD-Core Version:    0.7.0.1
 */