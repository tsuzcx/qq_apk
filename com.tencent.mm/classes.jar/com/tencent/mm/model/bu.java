package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.Log;

public final class bu
  extends q
  implements m
{
  private i callback;
  private final d lvf;
  public int lvg;
  public int lvh;
  public int lvi;
  public int type;
  
  public bu(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(177084);
    this.lvg = 0;
    this.lvh = 0;
    this.lvi = 0;
    this.type = 0;
    zd localzd = new zd();
    localzd.CPw = paramInt;
    localzd.Slg = paramString1;
    localzd.Dtb = paramString2;
    localzd.Slh = paramString3;
    localzd.Sll = paramString4;
    localzd.Slk = paramString5;
    paramString1 = new d.a();
    paramString1.lBU = localzd;
    paramString1.lBV = new ze();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.funcId = 813;
    paramString1.lBW = 0;
    paramString1.respCmdId = 0;
    this.lvf = paramString1.bgN();
    this.lvf.option = 1;
    Log.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s] uuid[%s] adid[%s]", new Object[] { Integer.valueOf(paramInt), localzd.Slg, localzd.Dtb, localzd.Slh, localzd.Sll, localzd.Slk });
    AppMethodBeat.o(177084);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(127600);
    this.callback = parami;
    int i = dispatch(paramg, this.lvf, this);
    AppMethodBeat.o(127600);
    return i;
  }
  
  public final int getType()
  {
    return 813;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(127601);
    Log.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (ze)d.c.b(this.lvf.lBS);
      this.lvg = params.Slo;
      this.lvh = params.Sln;
      this.type = params.rWu;
      this.lvi = params.Slm;
      Log.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(params.Sln), Integer.valueOf(params.Slm), Integer.valueOf(params.Slo) });
    }
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(127601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bu
 * JD-Core Version:    0.7.0.1
 */