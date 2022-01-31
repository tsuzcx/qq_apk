package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.protocal.protobuf.jp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class l
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private com.tencent.mm.ai.b rr;
  
  public l(String paramString, int paramInt)
  {
    AppMethodBeat.i(19314);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new jo();
    ((b.a)localObject).fsY = new jp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindharddevice";
    ((b.a)localObject).funcId = 536;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (jo)this.rr.fsV.fta;
    ((jo)localObject).wuY = bo.nullAsNil(paramString);
    ((jo)localObject).wvv = bo.g(Integer.valueOf(paramInt));
    AppMethodBeat.o(19314);
  }
  
  public final jp bpR()
  {
    if ((this.rr != null) && (this.rr.fsW.fta != null)) {
      return (jp)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(19316);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(19316);
    return i;
  }
  
  public final int getType()
  {
    return 536;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19315);
    ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    label290:
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = bpR();
      ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[] { paramArrayOfByte.wvw.jJD, paramArrayOfByte.wvw.wsq });
      String str1 = paramArrayOfByte.wvx.wrS;
      String str2 = paramArrayOfByte.wvx.xji;
      String str3 = paramArrayOfByte.wvx.wuT;
      String str4 = paramArrayOfByte.wvx.xjj;
      paramInt1 = paramArrayOfByte.wvx.xjk;
      if (paramArrayOfByte.woE != 0) {
        break label464;
      }
      paramq = "sync";
      ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt1), paramq });
      paramInt1 = 0;
      if (ad.bpY().dV(paramArrayOfByte.wvx.xji, paramArrayOfByte.wvw.jJD) == null) {
        break label472;
      }
      boolean bool = ad.bpY().dW(paramArrayOfByte.wvw.jJD, paramArrayOfByte.wvx.xji);
      ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramArrayOfByte.wvx.xji, Boolean.valueOf(bool) });
      if (bool) {
        paramInt1 = 1;
      }
      paramq = new com.tencent.mm.plugin.exdevice.h.b();
      f.a(paramq, paramArrayOfByte.wvw, paramArrayOfByte.wvx);
      paramq.field_url = "";
      paramArrayOfByte = u.bqz().jl(paramq.field_mac);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.crJ == 2))
      {
        ab.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
        ad.bqf();
        d.iZ(paramq.field_mac);
        paramArrayOfByte = u.bqz();
        l = paramq.field_mac;
        if (!paramArrayOfByte.lIA.containsKey(Long.valueOf(l))) {
          break label477;
        }
        paramArrayOfByte.lIA.remove(Long.valueOf(l));
        ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[] { Long.valueOf(l) });
      }
      label430:
      if (paramInt1 == 0) {
        break label501;
      }
      ad.bpY().insert(paramq);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(19315);
      return;
      label464:
      paramq = "async";
      break;
      label472:
      paramInt1 = 1;
      break label290;
      label477:
      ab.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[] { Long.valueOf(l) });
      break label430;
      label501:
      ad.bpY().e(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.l
 * JD-Core Version:    0.7.0.1
 */