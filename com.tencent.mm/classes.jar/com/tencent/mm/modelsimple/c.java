package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ac;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bi;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.protocal.protobuf.fmx;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.iz;
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
  private i jQg;
  private final s lCW;
  
  public c()
  {
    AppMethodBeat.i(134149);
    this.lCW = new d();
    j.c localc = (j.c)this.lCW.getReqObj();
    this.lCW.getRespObj();
    hn localhn = new hn();
    Object localObject1 = new hq();
    localc.RBk.RMS = ((hq)localObject1);
    localc.RBk.RMT = localhn;
    localhn.RMP = new dpr();
    Object localObject2 = com.tencent.mm.network.b.bsU().bsV();
    Object localObject3;
    int i;
    Object localObject4;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localhn.RMP.Stl = com.tencent.mm.network.b.bsU().mue.Stl;
      localhn.RMP.RMR = new eae().dc(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.MMDisasterAuth", "disaster auth add public key , length " + ((String)localObject2).length());
      localObject2 = bi.beN();
      localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
      if (localObject3 != null) {
        break label642;
      }
      i = -1;
      Log.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = Util.decodeHexString((String)localObject3);
      localObject3 = new ho();
      if (Util.isNullOrNil((byte[])localObject4)) {
        break label684;
      }
      localhn.RLV = new eae().dc((byte[])localObject4);
      Log.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localhn.RLV.Tkb.UH.length), Integer.valueOf(localObject4.length) });
    }
    label642:
    label684:
    label940:
    label952:
    label958:
    for (;;)
    {
      iz localiz;
      try
      {
        ((ho)localObject3).parseFrom((byte[])localObject4);
        if (((ho)localObject3).RMQ == null) {
          break label719;
        }
        ((hq)localObject1).RMU = ((ho)localObject3).RMQ;
        Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ho)localObject3).RMQ.Tkb.UH.length), Util.dumpHex(((ho)localObject3).RMQ.Tkb.UH) });
        h.aHH();
        localObject1 = Util.nullAsNil((String)h.aHG().aHp().b(2, null));
        h.aHH();
        localObject4 = new p(Util.nullAs((Integer)h.aHG().aHp().b(9, null), 0));
        if (!Util.isNullOrNil((String)localObject1)) {
          break label958;
        }
        localObject1 = ((p)localObject4).toString();
        Log.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.RAD) });
        localc.setSceneStatus(2);
        localiz = new iz();
        localiz.ROU = 1;
        localiz.RMb = new eae().dc(new byte[0]);
        localiz.RMa = new eae().dc(new byte[0]);
        localObject2 = new fhd();
        localiz.ROS = ((fhd)localObject2);
        ((fhd)localObject2).RRv = "";
        ((fhd)localObject2).RRu = "";
        ((fhd)localObject2).UHm = "";
        localObject2 = new fmx();
        localiz.ROT = ((fmx)localObject2);
        ((fmx)localObject2).Tlm = "";
        ((fmx)localObject2).Tll = "";
        if (h.aHB()) {
          break label761;
        }
        Log.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(134149);
        return;
        localhn.RMP.Stl = 0;
        localhn.RMP.RMR = new eae().dc(new byte[0]);
        Log.e("MicroMsg.MMDisasterAuth", "get sign key failed");
        break;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 15L, 1L, false);
        Log.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 16L, 1L, false);
      localhn.RLV = new eae().dc(new byte[0]);
      continue;
      label719:
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 17L, 1L, false);
      ((hq)localObject1).RMU = new eae().dc(new byte[0]);
      Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label761:
      h.aHH();
      localObject3 = h.aHE().aGC().a(localIOException.longValue(), "", false);
      localhn.RGL = MMApplicationContext.getApplicationId();
      eae localeae;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label940;
        }
        localObject2 = "null";
        Log.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s], AndroidPackageName:%s", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2, localhn.RGL });
        localeae = new eae();
        if (!Util.isNullOrNil((byte[])localObject3)) {
          break label952;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localiz.ROR = localeae.dc((byte[])localObject2);
        localhn.RMG = localiz;
        localc.username = ((String)localObject1);
        localObject1 = new b.a();
        ((b.a)localObject1).mug = com.tencent.mm.network.b.bsU().bsV();
        ((b.a)localObject1).muf = com.tencent.mm.network.b.bsU().muf;
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
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(134150);
    this.jQg = parami;
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(paramg, this.lCW, this);
    AppMethodBeat.o(134150);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134152);
    int i = this.lCW.getType();
    AppMethodBeat.o(134152);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134151);
    params = ((j.d)params.getRespObj()).RBm;
    if (params != null)
    {
      paramArrayOfByte = params.Uxk;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.RRi != null) && (paramArrayOfByte.RRj != null) && (paramArrayOfByte.RRh != null)) {
        break label113;
      }
    }
    for (;;)
    {
      aj.a(params.Uxl);
      this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(134151);
      return;
      label113:
      bi.a(false, paramArrayOfByte.RRi, paramArrayOfByte.RRj, paramArrayOfByte.RRh, false, 0);
    }
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(134151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.c
 * JD-Core Version:    0.7.0.1
 */