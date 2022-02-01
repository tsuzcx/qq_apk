package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bj;
import com.tencent.mm.network.b.a;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.eil;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.gdp;
import com.tencent.mm.protocal.protobuf.gjp;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.ij;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public final class e
  extends com.tencent.mm.am.p
  implements m
{
  private com.tencent.mm.am.h mAY;
  private final s ouH;
  
  public e()
  {
    AppMethodBeat.i(134149);
    this.ouH = new f();
    j.c localc = (j.c)this.ouH.getReqObj();
    this.ouH.getRespObj();
    ij localij = new ij();
    Object localObject1 = new im();
    localc.YxN.YKg = ((im)localObject1);
    localc.YxN.YKh = localij;
    localij.YKd = new eil();
    Object localObject2 = com.tencent.mm.network.b.bQD().bQE();
    Object localObject3;
    int i;
    Object localObject4;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localij.YKd.Zsz = com.tencent.mm.network.b.bQD().pny.Zsz;
      localij.YKd.YKf = new gol().df(((String)localObject2).getBytes(StandardCharsets.ISO_8859_1));
      Log.i("MicroMsg.MMDisasterAuth", "disaster auth add public key , length " + ((String)localObject2).length());
      localObject2 = bj.bCE();
      localObject3 = ((SharedPreferences)localObject2).getString("_auth_key", "");
      if (localObject3 != null) {
        break label642;
      }
      i = -1;
      Log.i("MicroMsg.MMDisasterAuth", "disasterauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(i) });
      localObject4 = Util.decodeHexString((String)localObject3);
      localObject3 = new ik();
      if (Util.isNullOrNil((byte[])localObject4)) {
        break label684;
      }
      localij.YJj = new gol().df((byte[])localObject4);
      Log.i("MicroMsg.MMDisasterAuth", "disasterauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(localij.YJj.aaxD.Op.length), Integer.valueOf(localObject4.length) });
    }
    label642:
    label684:
    label940:
    label952:
    label958:
    for (;;)
    {
      jv localjv;
      try
      {
        ((ik)localObject3).parseFrom((byte[])localObject4);
        if (((ik)localObject3).YKe == null) {
          break label719;
        }
        ((im)localObject1).YKi = ((ik)localObject3).YKe;
        Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ik)localObject3).YKe.aaxD.Op.length), Util.dumpHex(((ik)localObject3).YKe.aaxD.Op) });
        com.tencent.mm.kernel.h.baF();
        localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(2, null));
        com.tencent.mm.kernel.h.baF();
        localObject4 = new com.tencent.mm.b.p(Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null), 0));
        if (!Util.isNullOrNil((String)localObject1)) {
          break label958;
        }
        localObject1 = ((com.tencent.mm.b.p)localObject4).toString();
        Log.d("MicroMsg.MMDisasterAuth", "disasterauths updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(((SharedPreferences)localObject2).getInt("key_auth_update_version", 0)), Integer.valueOf(d.Yxh) });
        localc.setSceneStatus(2);
        localjv = new jv();
        localjv.YMi = 1;
        localjv.YJp = new gol().df(new byte[0]);
        localjv.YJo = new gol().df(new byte[0]);
        localObject2 = new gdp();
        localjv.YMg = ((gdp)localObject2);
        ((gdp)localObject2).YON = "";
        ((gdp)localObject2).YOM = "";
        ((gdp)localObject2).acbw = "";
        localObject2 = new gjp();
        localjv.YMh = ((gjp)localObject2);
        ((gjp)localObject2).aayW = "";
        ((gjp)localObject2).aayV = "";
        if (com.tencent.mm.kernel.h.baz()) {
          break label761;
        }
        Log.e("MicroMsg.MMDisasterAuth", "disasterauths build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(134149);
        return;
        localij.YKd.Zsz = 0;
        localij.YKd.YKf = new gol().df(new byte[0]);
        Log.e("MicroMsg.MMDisasterAuth", "get sign key failed");
        break;
        i = ((String)localObject3).length();
      }
      catch (IOException localIOException)
      {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 15L, 1L, false);
        Log.printErrStackTrace("MicroMsg.MMDisasterAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
        continue;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 16L, 1L, false);
      localij.YJj = new gol().df(new byte[0]);
      continue;
      label719:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 17L, 1L, false);
      ((im)localObject1).YKi = new gol().df(new byte[0]);
      Log.w("MicroMsg.MMDisasterAuth", "disasterauths AesEncryptKey null!");
      continue;
      label761:
      com.tencent.mm.kernel.h.baF();
      localObject3 = com.tencent.mm.kernel.h.baC().aZE().a(localIOException.longValue(), "", false);
      localij.YDN = MMApplicationContext.getApplicationId();
      gol localgol;
      if (localObject3 == null)
      {
        i = -1;
        if (localObject3 != null) {
          break label940;
        }
        localObject2 = "null";
        Log.i("MicroMsg.MMDisasterAuth", "disasterauths loginbuf username:%s, qq:%s, len:%d, content:[%s], AndroidPackageName:%s", new Object[] { localObject1, localIOException, Integer.valueOf(i), localObject2, localij.YDN });
        localgol = new gol();
        if (!Util.isNullOrNil((byte[])localObject3)) {
          break label952;
        }
      }
      for (localObject2 = new byte[0];; localObject2 = localObject3)
      {
        localjv.YMf = localgol.df((byte[])localObject2);
        localij.YJU = localjv;
        localc.username = ((String)localObject1);
        localObject1 = new b.a();
        ((b.a)localObject1).pnA = com.tencent.mm.network.b.bQD().bQE();
        ((b.a)localObject1).pnz = com.tencent.mm.network.b.bQD().pnz;
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
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(134150);
    this.mAY = paramh;
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 126L, 1L, false);
    int i = dispatch(paramg, this.ouH, this);
    AppMethodBeat.o(134150);
    return i;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(134152);
    int i = this.ouH.getType();
    AppMethodBeat.o(134152);
    return i;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(134151);
    params = ((j.d)params.getRespObj()).YxP;
    if (params != null)
    {
      paramArrayOfByte = params.abQS;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.YOA != null) && (paramArrayOfByte.YOB != null) && (paramArrayOfByte.YOz != null)) {
        break label113;
      }
    }
    for (;;)
    {
      aj.a(params.abQT);
      this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
      if ((paramInt3 != 0) || (paramInt2 != 0)) {
        break;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 127L, 1L, false);
      AppMethodBeat.o(134151);
      return;
      label113:
      bj.a(false, paramArrayOfByte.YOA, paramArrayOfByte.YOB, paramArrayOfByte.YOz, false, 0);
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 128L, 1L, false);
    AppMethodBeat.o(134151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelsimple.e
 * JD-Core Version:    0.7.0.1
 */