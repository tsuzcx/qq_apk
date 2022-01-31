package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.y;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ax;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class b
  extends m
  implements k
{
  private f eGj;
  private final q ftU;
  
  public b()
  {
    AppMethodBeat.i(154510);
    this.ftU = new c();
    j.c localc = (j.c)this.ftU.getReqObj();
    this.ftU.getRespObj();
    gd localgd = new gd();
    Object localObject1 = new gg();
    localc.wij.wsv = ((gg)localObject1);
    localc.wij.wsw = localgd;
    Object localObject2 = ax.aaF();
    Object localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
    int i;
    Object localObject4;
    if (localObject3 == null)
    {
      i = -1;
      ab.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = bo.apQ((String)localObject3);
      localObject3 = new ge();
      if (bo.ce((byte[])localObject4)) {
        break label550;
      }
      localgd.wrL = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
      ab.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localgd.wrL.getBuffer().pW.length), Integer.valueOf(localObject4.length) });
    }
    label768:
    label774:
    for (;;)
    {
      hm localhm;
      try
      {
        ((ge)localObject3).parseFrom((byte[])localObject4);
        if (((ge)localObject3).wst == null) {
          break label585;
        }
        ((gg)localObject1).wsx = ((ge)localObject3).wst;
        ab.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ge)localObject3).wst.getBuffer().pW.length), bo.cd(((ge)localObject3).wst.getBuffer().pW) });
        g.RM();
        localObject1 = bo.nullAsNil((String)g.RL().Ru().get(2, null));
        g.RM();
        localObject4 = new p(bo.a((Integer)g.RL().Ru().get(9, null), 0));
        if (!bo.isNullOrNil((String)localObject1)) {
          break label774;
        }
        localObject1 = ((p)localObject4).toString();
        ab.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(d.whH) });
        localc.setSceneStatus(2);
        localhm = new hm();
        localhm.wuk = 1;
        localhm.wrR = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localhm.wrQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject2 = new cvg();
        localhm.wui = ((cvg)localObject2);
        ((cvg)localObject2).wwl = "";
        ((cvg)localObject2).wwk = "";
        ((cvg)localObject2).ydL = "";
        localObject2 = new czg();
        localhm.wuj = ((czg)localObject2);
        ((czg)localObject2).xfJ = "";
        ((czg)localObject2).xfI = "";
        if (g.RG()) {
          break label627;
        }
        ab.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(154510);
        return;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 15L, 1L, false);
        ab.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      label550:
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 16L, 1L, false);
      localgd.wrL = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      continue;
      label585:
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 17L, 1L, false);
      ((gg)localObject1).wsx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      ab.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label627:
      g.RM();
      localObject3 = g.RJ().QN().a(localIOException.longValue(), "", false);
      label666:
      SKBuiltinBuffer_t localSKBuiltinBuffer_t;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label756;
        }
        localObject2 = "null";
        ab.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2 });
        localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (!bo.ce((byte[])localObject3)) {
          break label768;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localhm.wuh = localSKBuiltinBuffer_t.setBuffer((byte[])localObject2);
        localgd.wsm = localhm;
        localc.username = ((String)localObject1);
        AppMethodBeat.o(154510);
        return;
        i = localObject3.length;
        break;
        label756:
        localObject2 = bo.aqg(bo.cd((byte[])localObject3));
        break label666;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(154511);
    this.eGj = paramf;
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(parame, this.ftU, this);
    AppMethodBeat.o(154511);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(154513);
    int i = this.ftU.getType();
    AppMethodBeat.o(154513);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(154512);
    paramq = ((j.d)paramq.getRespObj()).wil;
    if (paramq != null)
    {
      paramArrayOfByte = paramq.xWo;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.wvY != null) && (paramArrayOfByte.wvZ != null) && (paramArrayOfByte.wvX != null)) {
        break label113;
      }
    }
    for (;;)
    {
      aa.a(paramq.xWp);
      this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(154512);
      return;
      label113:
      ax.a(false, paramArrayOfByte.wvY, paramArrayOfByte.wvZ, paramArrayOfByte.wvX);
    }
    com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(154512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.b
 * JD-Core Version:    0.7.0.1
 */