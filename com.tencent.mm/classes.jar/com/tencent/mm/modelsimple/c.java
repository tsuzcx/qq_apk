package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class c
  extends q
  implements m
{
  private i heq;
  private final s iMO;
  
  public c()
  {
    AppMethodBeat.i(134149);
    this.iMO = new d();
    j.c localc = (j.c)this.iMO.getReqObj();
    this.iMO.getRespObj();
    hx localhx = new hx();
    Object localObject1 = new ia();
    localc.Kzu.KLV = ((ia)localObject1);
    localc.Kzu.KLW = localhx;
    localhx.KLS = new dfx();
    Object localObject2 = com.tencent.mm.network.b.bjq().bjr();
    Object localObject3;
    int i;
    Object localObject4;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localhx.KLS.LrO = com.tencent.mm.network.b.bjq().jDB.LrO;
      localhx.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.MMDisasterAuth", "disaster auth add public key , length " + ((String)localObject2).length());
      localObject2 = bh.aVK();
      localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
      if (localObject3 != null) {
        break label642;
      }
      i = -1;
      Log.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = Util.decodeHexString((String)localObject3);
      localObject3 = new hy();
      if (Util.isNullOrNil((byte[])localObject4)) {
        break label684;
      }
      localhx.KKZ = new SKBuiltinBuffer_t().setBuffer((byte[])localObject4);
      Log.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localhx.KKZ.getBuffer().zy.length), Integer.valueOf(localObject4.length) });
    }
    label642:
    label684:
    label940:
    label952:
    label958:
    for (;;)
    {
      jk localjk;
      try
      {
        ((hy)localObject3).parseFrom((byte[])localObject4);
        if (((hy)localObject3).KLT == null) {
          break label719;
        }
        ((ia)localObject1).KLX = ((hy)localObject3).KLT;
        Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((hy)localObject3).KLT.getBuffer().zy.length), Util.dumpHex(((hy)localObject3).KLT.getBuffer().zy) });
        com.tencent.mm.kernel.g.aAi();
        localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null));
        com.tencent.mm.kernel.g.aAi();
        localObject4 = new p(Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(9, null), 0));
        if (!Util.isNullOrNil((String)localObject1)) {
          break label958;
        }
        localObject1 = ((p)localObject4).toString();
        Log.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.KyO) });
        localc.setSceneStatus(2);
        localjk = new jk();
        localjk.KOa = 1;
        localjk.KLf = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localjk.KLe = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject2 = new ewr();
        localjk.KNY = ((ewr)localObject2);
        ((ewr)localObject2).KQx = "";
        ((ewr)localObject2).KQw = "";
        ((ewr)localObject2).Num = "";
        localObject2 = new fca();
        localjk.KNZ = ((fca)localObject2);
        ((fca)localObject2).MbK = "";
        ((fca)localObject2).MbJ = "";
        if (com.tencent.mm.kernel.g.aAc()) {
          break label761;
        }
        Log.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(134149);
        return;
        localhx.KLS.LrO = 0;
        localhx.KLS.KLU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        Log.e("MicroMsg.MMDisasterAuth", "get sign key failed");
        break;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 15L, 1L, false);
        Log.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 16L, 1L, false);
      localhx.KKZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      continue;
      label719:
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 17L, 1L, false);
      ((ia)localObject1).KLX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label761:
      com.tencent.mm.kernel.g.aAi();
      localObject3 = com.tencent.mm.kernel.g.aAf().azh().a(localIOException.longValue(), "", false);
      localhx.KFu = MMApplicationContext.getApplicationId();
      SKBuiltinBuffer_t localSKBuiltinBuffer_t;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label940;
        }
        localObject2 = "null";
        Log.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s], AndroidPackageName:%s", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2, localhx.KFu });
        localSKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        if (!Util.isNullOrNil((byte[])localObject3)) {
          break label952;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localjk.KNX = localSKBuiltinBuffer_t.setBuffer((byte[])localObject2);
        localhx.KLK = localjk;
        localc.username = ((String)localObject1);
        localObject1 = new b.a();
        ((b.a)localObject1).jDD = com.tencent.mm.network.b.bjq().bjr();
        ((b.a)localObject1).jDC = com.tencent.mm.network.b.bjq().jDC;
        localc.setCGiVerifyKey((b.a)localObject1);
        AppMethodBeat.o(134149);
        return;
        i = localObject3.length;
        break;
        localObject2 = Util.secPrint(Util.dumpHex((byte[])localObject3));
        break label808;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(134150);
    this.heq = parami;
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(paramg, this.iMO, this);
    AppMethodBeat.o(134150);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134152);
    int i = this.iMO.getType();
    AppMethodBeat.o(134152);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134151);
    params = ((j.d)params.getRespObj()).Kzw;
    if (params != null)
    {
      paramArrayOfByte = params.NkA;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.KQk != null) && (paramArrayOfByte.KQl != null) && (paramArrayOfByte.KQj != null)) {
        break label113;
      }
    }
    for (;;)
    {
      aj.a(params.NkB);
      this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(134151);
      return;
      label113:
      bh.a(false, paramArrayOfByte.KQk, paramArrayOfByte.KQl, paramArrayOfByte.KQj);
    }
    com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(134151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.c
 * JD-Core Version:    0.7.0.1
 */