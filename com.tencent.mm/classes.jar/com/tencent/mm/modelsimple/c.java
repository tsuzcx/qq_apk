package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.z;
import com.tencent.mm.b.p;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.bd;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.protocal.protobuf.ehi;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import java.io.IOException;

public final class c
  extends n
  implements k
{
  private f gCo;
  private final q hRG;
  
  public c()
  {
    AppMethodBeat.i(134149);
    this.hRG = new d();
    j.c localc = (j.c)this.hRG.getReqObj();
    this.hRG.getRespObj();
    hk localhk = new hk();
    Object localObject1 = new hn();
    localc.FGj.FSm = ((hn)localObject1);
    localc.FGj.FSn = localhk;
    Object localObject2 = bd.aCl();
    Object localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
    int i;
    Object localObject4;
    if (localObject3 == null)
    {
      i = -1;
      ae.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = bu.aSx((String)localObject3);
      localObject3 = new hl();
      if (bu.cF((byte[])localObject4)) {
        break label550;
      }
      localhk.FRs = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
      ae.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localhk.FRs.getBuffer().zr.length), Integer.valueOf(localObject4.length) });
    }
    label768:
    label774:
    for (;;)
    {
      ix localix;
      try
      {
        ((hl)localObject3).parseFrom((byte[])localObject4);
        if (((hl)localObject3).FSk == null) {
          break label585;
        }
        ((hn)localObject1).FSo = ((hl)localObject3).FSk;
        ae.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((hl)localObject3).FSk.getBuffer().zr.length), bu.cE(((hl)localObject3).FSk.getBuffer().zr) });
        g.ajS();
        localObject1 = bu.nullAsNil((String)g.ajR().ajA().get(2, null));
        g.ajS();
        localObject4 = new p(bu.a((Integer)g.ajR().ajA().get(9, null), 0));
        if (!bu.isNullOrNil((String)localObject1)) {
          break label774;
        }
        localObject1 = ((p)localObject4).toString();
        ae.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.FFH) });
        localc.setSceneStatus(2);
        localix = new ix();
        localix.FUr = 1;
        localix.FRy = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localix.FRx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject2 = new ecj();
        localix.FUp = ((ecj)localObject2);
        ((ecj)localObject2).FWL = "";
        ((ecj)localObject2).FWK = "";
        ((ecj)localObject2).IhI = "";
        localObject2 = new ehi();
        localix.FUq = ((ehi)localObject2);
        ((ehi)localObject2).GXa = "";
        ((ehi)localObject2).GWZ = "";
        if (g.ajM()) {
          break label627;
        }
        ae.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(134149);
        return;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 15L, 1L, false);
        ae.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      label550:
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 16L, 1L, false);
      localhk.FRs = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      continue;
      label585:
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 17L, 1L, false);
      ((hn)localObject1).FSo = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ae.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label627:
      g.ajS();
      localObject3 = g.ajP().aiR().a(localIOException.longValue(), "", false);
      label666:
      SKBuiltinBuffer_t localSKBuiltinBuffer_t;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label756;
        }
        localObject2 = "null";
        ae.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2 });
        localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (!bu.cF((byte[])localObject3)) {
          break label768;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localix.FUo = localSKBuiltinBuffer_t.setBuffer((byte[])localObject2);
        localhk.FSd = localix;
        localc.username = ((String)localObject1);
        AppMethodBeat.o(134149);
        return;
        i = localObject3.length;
        break;
        label756:
        localObject2 = bu.aSM(bu.cE((byte[])localObject3));
        break label666;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(134150);
    this.gCo = paramf;
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(parame, this.hRG, this);
    AppMethodBeat.o(134150);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134152);
    int i = this.hRG.getType();
    AppMethodBeat.o(134152);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134151);
    paramq = ((j.d)paramq.getRespObj()).FGl;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.HYu;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.FWy != null) && (paramArrayOfByte.FWz != null) && (paramArrayOfByte.FWx != null)) {
        break label113;
      }
    }
    for (;;)
    {
      af.a(paramq.HYv);
      this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(134151);
      return;
      label113:
      bd.a(false, paramArrayOfByte.FWy, paramArrayOfByte.FWz, paramArrayOfByte.FWx);
    }
    com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(134151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.c
 * JD-Core Version:    0.7.0.1
 */