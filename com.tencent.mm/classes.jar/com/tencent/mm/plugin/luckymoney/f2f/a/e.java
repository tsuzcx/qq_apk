package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.Log;

public final class e
  extends q
  implements m
{
  private i callback;
  private d hJu;
  public String rCq;
  public String yQE;
  private aln yRX;
  private alo yRY;
  public String yRZ;
  public String ySa;
  public int ySb;
  
  public e()
  {
    AppMethodBeat.i(65047);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new aln();
    ((d.a)localObject).iLO = new alo();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
    this.hJu = ((d.a)localObject).aXF();
    this.yRX = ((aln)this.hJu.iLK.iLR);
    this.yRX.timestamp = (System.currentTimeMillis() / 1000L);
    localObject = k.fQy();
    if (localObject != null)
    {
      this.yRX.latitude = ((bf)localObject).latitude;
      this.yRX.longitude = ((bf)localObject).longitude;
    }
    AppMethodBeat.o(65047);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(65049);
    this.callback = parami;
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(65049);
    return i;
  }
  
  public final int getType()
  {
    return 1990;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(65048);
    Log.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.yRY = ((alo)((d)params).iLL.iLR);
    this.yQE = this.yRY.yQE;
    this.rCq = this.yRY.rCq;
    this.ySb = this.yRY.Lut;
    this.yRZ = this.yRY.yRZ;
    this.ySa = this.yRY.ySa;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, this.yRY.dDN, this.yRY.qwn, this);
    }
    AppMethodBeat.o(65048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.a.e
 * JD-Core Version:    0.7.0.1
 */