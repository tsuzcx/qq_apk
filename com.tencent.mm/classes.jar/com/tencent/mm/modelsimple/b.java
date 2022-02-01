package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.z;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import java.io.IOException;

public final class b
  extends n
  implements k
{
  private final q gVZ;
  private com.tencent.mm.al.g gbr;
  
  public b()
  {
    AppMethodBeat.i(134149);
    this.gVZ = new c();
    j.c localc = (j.c)this.gVZ.getReqObj();
    this.gVZ.getRespObj();
    gz localgz = new gz();
    Object localObject1 = new hc();
    localc.Cqm.CBX = ((hc)localObject1);
    localc.Cqm.CBY = localgz;
    Object localObject2 = ba.asa();
    Object localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
    int i;
    Object localObject4;
    if (localObject3 == null)
    {
      i = -1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = bt.aGd((String)localObject3);
      localObject3 = new ha();
      if (bt.cw((byte[])localObject4)) {
        break label550;
      }
      localgz.CBc = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localgz.CBc.getBuffer().wA.length), Integer.valueOf(localObject4.length) });
    }
    label768:
    label774:
    for (;;)
    {
      ik localik;
      try
      {
        ((ha)localObject3).parseFrom((byte[])localObject4);
        if (((ha)localObject3).CBV == null) {
          break label585;
        }
        ((hc)localObject1).CBZ = ((ha)localObject3).CBV;
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ha)localObject3).CBV.getBuffer().wA.length), bt.cv(((ha)localObject3).CBV.getBuffer().wA) });
        com.tencent.mm.kernel.g.afC();
        localObject1 = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(2, null));
        com.tencent.mm.kernel.g.afC();
        localObject4 = new p(bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(9, null), 0));
        if (!bt.isNullOrNil((String)localObject1)) {
          break label774;
        }
        localObject1 = ((p)localObject4).toString();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(d.CpK) });
        localc.setSceneStatus(2);
        localik = new ik();
        localik.CEa = 1;
        localik.CBi = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localik.CBh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject2 = new dph();
        localik.CDY = ((dph)localObject2);
        ((dph)localObject2).CGu = "";
        ((dph)localObject2).CGt = "";
        ((dph)localObject2).EFs = "";
        localObject2 = new dtw();
        localik.CDZ = ((dtw)localObject2);
        ((dtw)localObject2).DyE = "";
        ((dtw)localObject2).DyD = "";
        if (com.tencent.mm.kernel.g.afw()) {
          break label627;
        }
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(134149);
        return;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 15L, 1L, false);
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      label550:
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 16L, 1L, false);
      localgz.CBc = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      continue;
      label585:
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 17L, 1L, false);
      ((hc)localObject1).CBZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label627:
      com.tencent.mm.kernel.g.afC();
      localObject3 = com.tencent.mm.kernel.g.afz().aeA().a(localIOException.longValue(), "", false);
      label666:
      SKBuiltinBuffer_t localSKBuiltinBuffer_t;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label756;
        }
        localObject2 = "null";
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2 });
        localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (!bt.cw((byte[])localObject3)) {
          break label768;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localik.CDX = localSKBuiltinBuffer_t.setBuffer((byte[])localObject2);
        localgz.CBN = localik;
        localc.username = ((String)localObject1);
        AppMethodBeat.o(134149);
        return;
        i = localObject3.length;
        break;
        label756:
        localObject2 = bt.aGs(bt.cv((byte[])localObject3));
        break label666;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(134150);
    this.gbr = paramg;
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(parame, this.gVZ, this);
    AppMethodBeat.o(134150);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134152);
    int i = this.gVZ.getType();
    AppMethodBeat.o(134152);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134151);
    paramq = ((j.d)paramq.getRespObj()).Cqo;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.EwR;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.CGh != null) && (paramArrayOfByte.CGi != null) && (paramArrayOfByte.CGg != null)) {
        break label113;
      }
    }
    for (;;)
    {
      com.tencent.mm.model.ad.a(paramq.EwS);
      this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(134151);
      return;
      label113:
      ba.a(false, paramArrayOfByte.CGh, paramArrayOfByte.CGi, paramArrayOfByte.CGg);
    }
    com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(134151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.b
 * JD-Core Version:    0.7.0.1
 */