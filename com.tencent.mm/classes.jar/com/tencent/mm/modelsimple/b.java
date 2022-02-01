package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.z;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.bb;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.efr;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.io.IOException;

public final class b
  extends n
  implements k
{
  private f gzH;
  private final q hON;
  
  public b()
  {
    AppMethodBeat.i(134149);
    this.hON = new c();
    j.c localc = (j.c)this.hON.getReqObj();
    this.hON.getRespObj();
    hk localhk = new hk();
    Object localObject1 = new hn();
    localc.FnL.FzO = ((hn)localObject1);
    localc.FnL.FzP = localhk;
    Object localObject2 = bb.aBV();
    Object localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
    int i;
    Object localObject4;
    if (localObject3 == null)
    {
      i = -1;
      ad.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = bt.aRa((String)localObject3);
      localObject3 = new hl();
      if (bt.cC((byte[])localObject4)) {
        break label550;
      }
      localhk.FyU = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
      ad.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localhk.FyU.getBuffer().zr.length), Integer.valueOf(localObject4.length) });
    }
    label768:
    label774:
    for (;;)
    {
      ix localix;
      try
      {
        ((hl)localObject3).parseFrom((byte[])localObject4);
        if (((hl)localObject3).FzM == null) {
          break label585;
        }
        ((hn)localObject1).FzQ = ((hl)localObject3).FzM;
        ad.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((hl)localObject3).FzM.getBuffer().zr.length), bt.cB(((hl)localObject3).FzM.getBuffer().zr) });
        g.ajD();
        localObject1 = bt.nullAsNil((String)g.ajC().ajl().get(2, null));
        g.ajD();
        localObject4 = new p(bt.a((Integer)g.ajC().ajl().get(9, null), 0));
        if (!bt.isNullOrNil((String)localObject1)) {
          break label774;
        }
        localObject1 = ((p)localObject4).toString();
        ad.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(d.Fnj) });
        localc.setSceneStatus(2);
        localix = new ix();
        localix.FBW = 1;
        localix.Fza = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localix.FyZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject2 = new eas();
        localix.FBU = ((eas)localObject2);
        ((eas)localObject2).FEq = "";
        ((eas)localObject2).FEp = "";
        ((eas)localObject2).HNB = "";
        localObject2 = new efr();
        localix.FBV = ((efr)localObject2);
        ((efr)localObject2).GDx = "";
        ((efr)localObject2).GDw = "";
        if (g.ajx()) {
          break label627;
        }
        ad.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(134149);
        return;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 15L, 1L, false);
        ad.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      label550:
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 16L, 1L, false);
      localhk.FyU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      continue;
      label585:
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 17L, 1L, false);
      ((hn)localObject1).FzQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ad.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label627:
      g.ajD();
      localObject3 = g.ajA().aiC().a(localIOException.longValue(), "", false);
      label666:
      SKBuiltinBuffer_t localSKBuiltinBuffer_t;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label756;
        }
        localObject2 = "null";
        ad.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2 });
        localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (!bt.cC((byte[])localObject3)) {
          break label768;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localix.FBT = localSKBuiltinBuffer_t.setBuffer((byte[])localObject2);
        localhk.FzF = localix;
        localc.username = ((String)localObject1);
        AppMethodBeat.o(134149);
        return;
        i = localObject3.length;
        break;
        label756:
        localObject2 = bt.aRp(bt.cB((byte[])localObject3));
        break label666;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(134150);
    this.gzH = paramf;
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(parame, this.hON, this);
    AppMethodBeat.o(134150);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134152);
    int i = this.hON.getType();
    AppMethodBeat.o(134152);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134151);
    paramq = ((j.d)paramq.getRespObj()).FnN;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.HEH;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.FEd != null) && (paramArrayOfByte.FEe != null) && (paramArrayOfByte.FEc != null)) {
        break label113;
      }
    }
    for (;;)
    {
      ae.a(paramq.HEI);
      this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(134151);
      return;
      label113:
      bb.a(false, paramArrayOfByte.FEd, paramArrayOfByte.FEe, paramArrayOfByte.FEc);
    }
    com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(134151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.b
 * JD-Core Version:    0.7.0.1
 */