package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;

public final class l
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  private com.tencent.mm.ak.b rr;
  
  public l(String paramString, int paramInt)
  {
    AppMethodBeat.i(23383);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new lk();
    ((b.a)localObject).hQG = new ll();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindharddevice";
    ((b.a)localObject).funcId = 536;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (lk)this.rr.hQD.hQJ;
    ((lk)localObject).FVm = bu.nullAsNil(paramString);
    ((lk)localObject).FVR = bu.o(Integer.valueOf(paramInt));
    AppMethodBeat.o(23383);
  }
  
  public final ll cmC()
  {
    if ((this.rr != null) && (this.rr.hQE.hQJ != null)) {
      return (ll)this.rr.hQE.hQJ;
    }
    return null;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(23385);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23385);
    return i;
  }
  
  public final int getType()
  {
    return 536;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23384);
    ae.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    label290:
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = cmC();
      ae.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[] { paramArrayOfByte.FVS.nIM, paramArrayOfByte.FVS.FSh });
      String str1 = paramArrayOfByte.FVT.FRz;
      String str2 = paramArrayOfByte.FVT.HaX;
      String str3 = paramArrayOfByte.FVT.FVh;
      String str4 = paramArrayOfByte.FVT.HaY;
      paramInt1 = paramArrayOfByte.FVT.HaZ;
      if (paramArrayOfByte.FNv != 0) {
        break label464;
      }
      paramq = "sync";
      ae.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt1), paramq });
      paramInt1 = 0;
      if (ad.cmJ().fJ(paramArrayOfByte.FVT.HaX, paramArrayOfByte.FVS.nIM) == null) {
        break label472;
      }
      boolean bool = ad.cmJ().fK(paramArrayOfByte.FVS.nIM, paramArrayOfByte.FVT.HaX);
      ae.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramArrayOfByte.FVT.HaX, Boolean.valueOf(bool) });
      if (bool) {
        paramInt1 = 1;
      }
      paramq = new com.tencent.mm.plugin.exdevice.i.b();
      f.a(paramq, paramArrayOfByte.FVS, paramArrayOfByte.FVT);
      paramq.field_url = "";
      paramArrayOfByte = u.cnk().uU(paramq.field_mac);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.dqB == 2))
      {
        ae.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
        ad.cmQ();
        d.uI(paramq.field_mac);
        paramArrayOfByte = u.cnk();
        l = paramq.field_mac;
        if (!paramArrayOfByte.qmG.containsKey(Long.valueOf(l))) {
          break label477;
        }
        paramArrayOfByte.qmG.remove(Long.valueOf(l));
        ae.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[] { Long.valueOf(l) });
      }
      label430:
      if (paramInt1 == 0) {
        break label501;
      }
      ad.cmJ().insert(paramq);
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(23384);
      return;
      label464:
      paramq = "async";
      break;
      label472:
      paramInt1 = 1;
      break label290;
      label477:
      ae.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[] { Long.valueOf(l) });
      break label430;
      label501:
      ad.cmJ().e(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.l
 * JD-Core Version:    0.7.0.1
 */