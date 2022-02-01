package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.cw.f;
import com.tencent.mm.cw.g;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.fnu;
import com.tencent.mm.protocal.protobuf.fnw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;

public final class p
  extends com.tencent.mm.plugin.appbrand.networking.b<fnw>
{
  final d rr;
  
  public p(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null, localack);
    AppMethodBeat.i(44853);
    AppMethodBeat.o(44853);
  }
  
  public p(String paramString1, String paramString2, String paramString3, ack paramack)
  {
    super(paramString2, paramString1);
    AppMethodBeat.i(280158);
    d.a locala = new d.a();
    fnu localfnu = new fnu();
    localfnu.Txp = paramString1;
    if (Util.isNullOrNil(paramString1))
    {
      localObject = m.bFF().d(paramString2, new String[] { "syncVersion" });
      if (localObject == null) {
        localObject = "";
      }
    }
    for (Object localObject = new com.tencent.mm.cd.b(((String)localObject).getBytes());; localObject = m.bFF().afb(paramString1))
    {
      localfnu.RTT = ((com.tencent.mm.cd.b)localObject);
      localfnu.UMm = paramString2;
      localfnu.Txo = paramString3;
      localfnu.UMn = 0;
      localfnu.RPD = ((ack)Objects.requireNonNull(paramack));
      locala.lBU = localfnu;
      locala.lBV = new fnw();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      localObject = locala.bgN();
      this.rr = ((d)localObject);
      c((d)localObject);
      Log.i("MicroMsg.CgiWxaAttrSync", "<init> hash:%d, username:%s, appId:%s, cleanUpdate:%b, instanceId:%s, scene:%d, source:%s", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, Boolean.FALSE, paramString3, Integer.valueOf(0), com.tencent.mm.ak.a.a(paramack) });
      AppMethodBeat.o(280158);
      return;
      localObject = Util.nullAsNil(((WxaAttributes)localObject).field_syncVersion);
      break;
    }
  }
  
  public final f<com.tencent.mm.an.c.a<fnw>> bLt()
  {
    AppMethodBeat.i(280159);
    if (!com.tencent.mm.plugin.appbrand.networking.a.eO(((fnu)d.b.b(this.rr.lBR)).UMm, ((fnu)d.b.b(this.rr.lBR)).Txp))
    {
      f localf = g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(280159);
      return localf;
    }
    AppMethodBeat.o(280159);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.p
 * JD-Core Version:    0.7.0.1
 */