package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.co.f;
import com.tencent.mm.co.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fct;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class p
  extends com.tencent.mm.plugin.appbrand.networking.b<fcv>
{
  final d rr;
  
  public p(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null, localacc);
    AppMethodBeat.i(44853);
    AppMethodBeat.o(44853);
  }
  
  public p(String paramString1, String paramString2, String paramString3, acc paramacc)
  {
    super(paramString2, paramString1);
    AppMethodBeat.i(226464);
    d.a locala = new d.a();
    fct localfct = new fct();
    localfct.Mmv = paramString1;
    if (Util.isNullOrNil(paramString1))
    {
      localObject = n.buC().e(paramString2, new String[] { "syncVersion" });
      if (localObject == null) {
        localObject = "";
      }
    }
    for (Object localObject = new com.tencent.mm.bw.b(((String)localObject).getBytes());; localObject = n.buC().Xp(paramString1))
    {
      localfct.KSW = ((com.tencent.mm.bw.b)localObject);
      localfct.NyI = paramString2;
      localfct.Mmu = paramString3;
      localfct.NyJ = 0;
      localfct.KOF = ((acc)Objects.requireNonNull(paramacc));
      locala.iLN = localfct;
      locala.iLO = new fcv();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      localObject = locala.aXF();
      this.rr = ((d)localObject);
      c((d)localObject);
      Log.i("MicroMsg.CgiWxaAttrSync", "<init> hash:%d, username:%s, appId:%s, cleanUpdate:%b, instanceId:%s, scene:%d, source:%s", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, Boolean.FALSE, paramString3, Integer.valueOf(0), com.tencent.mm.ah.a.a(paramacc) });
      AppMethodBeat.o(226464);
      return;
      localObject = Util.nullAsNil(((WxaAttributes)localObject).field_syncVersion);
      break;
    }
  }
  
  public final f<com.tencent.mm.ak.c.a<fcv>> bAe()
  {
    AppMethodBeat.i(226465);
    if (!com.tencent.mm.plugin.appbrand.networking.a.eA(((fct)this.rr.iLK.iLR).NyI, ((fct)this.rr.iLK.iLR).Mmv))
    {
      f localf = g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(226465);
      return localf;
    }
    AppMethodBeat.o(226465);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */