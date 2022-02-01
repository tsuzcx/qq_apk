package com.tencent.mm.bf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class a
  extends q
  implements m
{
  private i callback;
  public String lYi;
  public String lYj;
  public byte[] lYk;
  private final d rr;
  
  public a()
  {
    this(com.tencent.mm.model.z.bcZ(), Util.nullAsNil((Integer)h.aHG().aHp().b(66561, null)), 0);
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
    this.lYi = null;
    this.lYj = null;
    this.lYk = null;
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cba();
    ((d.a)localObject).lBV = new cbb();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/getqrcode";
    ((d.a)localObject).funcId = 168;
    ((d.a)localObject).lBW = 67;
    ((d.a)localObject).respCmdId = 1000000067;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cba)d.b.b(this.rr.lBR);
    ((cba)localObject).SrH = com.tencent.mm.platformtools.z.ZW(paramString);
    ((cba)localObject).RVf = paramInt1;
    ((cba)localObject).RLe = paramInt2;
    Log.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(150871);
  }
  
  public final int doScene(g paramg, i parami)
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
      paramArrayOfByte = (cba)d.b.b(this.rr.lBR);
      params = (cbb)d.c.b(this.rr.lBS);
      paramArrayOfByte = com.tencent.mm.platformtools.z.a(paramArrayOfByte.SrH);
      this.lYk = com.tencent.mm.platformtools.z.a(params.Thg, new byte[0]);
      this.lYi = params.Tjr;
      Log.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", new Object[] { this.lYi, params.Tjs, params.Tjt });
      if (com.tencent.mm.model.z.bcZ().equals(paramArrayOfByte))
      {
        paramArrayOfByte = params.Tjs;
        String str = (String)h.aHG().aHp().b(66563, "");
        if ((paramArrayOfByte != null) && (!str.equals(paramArrayOfByte)))
        {
          h.aHG().aHp().i(66563, paramArrayOfByte);
          this.lYj = params.Tjt;
        }
        h.aHG().aHp().i(66561, Integer.valueOf(params.RVf));
      }
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(150873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bf.a
 * JD-Core Version:    0.7.0.1
 */