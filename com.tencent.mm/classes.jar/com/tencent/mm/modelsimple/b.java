package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.z;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import java.io.IOException;

public final class b
  extends n
  implements k
{
  private com.tencent.mm.ak.g gfX;
  private final q hwy;
  
  public b()
  {
    AppMethodBeat.i(134149);
    this.hwy = new c();
    j.c localc = (j.c)this.hwy.getReqObj();
    this.hwy.getRespObj();
    hd localhd = new hd();
    Object localObject1 = new hg();
    localc.DIE.DUu = ((hg)localObject1);
    localc.DIE.DUv = localhd;
    Object localObject2 = ba.ayR();
    Object localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
    int i;
    Object localObject4;
    if (localObject3 == null)
    {
      i = -1;
      ac.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = bs.aLu((String)localObject3);
      localObject3 = new he();
      if (bs.cv((byte[])localObject4)) {
        break label550;
      }
      localhd.DTA = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
      ac.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localhd.DTA.getBuffer().xy.length), Integer.valueOf(localObject4.length) });
    }
    label768:
    label774:
    for (;;)
    {
      iq localiq;
      try
      {
        ((he)localObject3).parseFrom((byte[])localObject4);
        if (((he)localObject3).DUs == null) {
          break label585;
        }
        ((hg)localObject1).DUw = ((he)localObject3).DUs;
        ac.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((he)localObject3).DUs.getBuffer().xy.length), bs.cu(((he)localObject3).DUs.getBuffer().xy) });
        com.tencent.mm.kernel.g.agS();
        localObject1 = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(2, null));
        com.tencent.mm.kernel.g.agS();
        localObject4 = new p(bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(9, null), 0));
        if (!bs.isNullOrNil((String)localObject1)) {
          break label774;
        }
        localObject1 = ((p)localObject4).toString();
        ac.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(d.DIc) });
        localc.setSceneStatus(2);
        localiq = new iq();
        localiq.DWA = 1;
        localiq.DTG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localiq.DTF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject2 = new duy();
        localiq.DWy = ((duy)localObject2);
        ((duy)localObject2).DYU = "";
        ((duy)localObject2).DYT = "";
        ((duy)localObject2).GcE = "";
        localObject2 = new dzn();
        localiq.DWz = ((dzn)localObject2);
        ((dzn)localObject2).EUa = "";
        ((dzn)localObject2).ETZ = "";
        if (com.tencent.mm.kernel.g.agM()) {
          break label627;
        }
        ac.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(134149);
        return;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 15L, 1L, false);
        ac.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      label550:
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 16L, 1L, false);
      localhd.DTA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      continue;
      label585:
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 17L, 1L, false);
      ((hg)localObject1).DUw = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ac.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label627:
      com.tencent.mm.kernel.g.agS();
      localObject3 = com.tencent.mm.kernel.g.agP().afQ().a(localIOException.longValue(), "", false);
      label666:
      SKBuiltinBuffer_t localSKBuiltinBuffer_t;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label756;
        }
        localObject2 = "null";
        ac.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2 });
        localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (!bs.cv((byte[])localObject3)) {
          break label768;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localiq.DWx = localSKBuiltinBuffer_t.setBuffer((byte[])localObject2);
        localhd.DUl = localiq;
        localc.username = ((String)localObject1);
        AppMethodBeat.o(134149);
        return;
        i = localObject3.length;
        break;
        label756:
        localObject2 = bs.aLJ(bs.cu((byte[])localObject3));
        break label666;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(134150);
    this.gfX = paramg;
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(134150);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134152);
    int i = this.hwy.getType();
    AppMethodBeat.o(134152);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134151);
    paramq = ((j.d)paramq.getRespObj()).DIG;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.FTT;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.DYH != null) && (paramArrayOfByte.DYI != null) && (paramArrayOfByte.DYG != null)) {
        break label113;
      }
    }
    for (;;)
    {
      ad.a(paramq.FTU);
      this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(134151);
      return;
      label113:
      ba.a(false, paramArrayOfByte.DYH, paramArrayOfByte.DYI, paramArrayOfByte.DYG);
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(134151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.b
 * JD-Core Version:    0.7.0.1
 */