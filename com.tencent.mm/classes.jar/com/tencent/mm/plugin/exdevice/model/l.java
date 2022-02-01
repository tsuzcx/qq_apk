package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.i.c;
import com.tencent.mm.plugin.exdevice.service.f.a;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;

public final class l
  extends n
  implements k
{
  private g callback;
  private com.tencent.mm.al.b rr;
  
  public l(String paramString, int paramInt)
  {
    AppMethodBeat.i(23383);
    this.callback = null;
    this.rr = null;
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ku();
    ((b.a)localObject).gUV = new kv();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindharddevice";
    ((b.a)localObject).funcId = 536;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ku)this.rr.gUS.gUX;
    ((ku)localObject).CEV = bt.nullAsNil(paramString);
    ((ku)localObject).CFA = bt.l(Integer.valueOf(paramInt));
    AppMethodBeat.o(23383);
  }
  
  public final kv bZz()
  {
    if ((this.rr != null) && (this.rr.gUT.gUX != null)) {
      return (kv)this.rr.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(23385);
    this.callback = paramg;
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneBindHardDevice", "onGYNetEnd netId = " + paramInt1 + " errType = " + paramInt2 + " errCode = " + paramInt3 + paramString);
    label290:
    long l;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = bZz();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDevice : DeviceIdServer = %s, DeviceType = %s", new Object[] { paramArrayOfByte.CFB.mAT, paramArrayOfByte.CFB.CBS });
      String str1 = paramArrayOfByte.CFC.CBj;
      String str2 = paramArrayOfByte.CFC.DCD;
      String str3 = paramArrayOfByte.CFC.CEQ;
      String str4 = paramArrayOfByte.CFC.DCE;
      paramInt1 = paramArrayOfByte.CFC.DCF;
      if (paramArrayOfByte.Cxm != 0) {
        break label464;
      }
      paramq = "sync";
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneBindHardDevice", "hardDeviceAttr : AuthKey = %s, BrandName = %s, Mac = %s, connProto = %s, ConnStrategy = %s, bindFlag = %s", new Object[] { str1, str2, str3, str4, Integer.valueOf(paramInt1), paramq });
      paramInt1 = 0;
      if (ad.bZG().fi(paramArrayOfByte.CFC.DCD, paramArrayOfByte.CFB.mAT) == null) {
        break label472;
      }
      boolean bool = ad.bZG().fj(paramArrayOfByte.CFB.mAT, paramArrayOfByte.CFC.DCD);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneBindHardDevice", "delete local deviceinfo : %s, ret : %b", new Object[] { paramArrayOfByte.CFC.DCD, Boolean.valueOf(bool) });
      if (bool) {
        paramInt1 = 1;
      }
      paramq = new com.tencent.mm.plugin.exdevice.i.b();
      f.a(paramq, paramArrayOfByte.CFB, paramArrayOfByte.CFC);
      paramq.field_url = "";
      paramArrayOfByte = u.cah().oT(paramq.field_mac);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.dgF == 2))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.NetSceneBindHardDevice", "before do bind netscene, stop the channel now");
        ad.bZN();
        d.oH(paramq.field_mac);
        paramArrayOfByte = u.cah();
        l = paramq.field_mac;
        if (!paramArrayOfByte.oZl.containsKey(Long.valueOf(l))) {
          break label477;
        }
        paramArrayOfByte.oZl.remove(Long.valueOf(l));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "remove the device from map : %d", new Object[] { Long.valueOf(l) });
      }
      label430:
      if (paramInt1 == 0) {
        break label501;
      }
      ad.bZG().insert(paramq);
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
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.exdevice.ExdeviceInfoManager", "device id not contains in the map : %d", new Object[] { Long.valueOf(l) });
      break label430;
      label501:
      ad.bZG().e(paramq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.l
 * JD-Core Version:    0.7.0.1
 */