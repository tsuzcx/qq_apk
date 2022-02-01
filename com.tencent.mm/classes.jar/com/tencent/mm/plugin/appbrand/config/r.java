package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.b;
import com.tencent.mm.cp.f;
import com.tencent.mm.cp.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.gkt;
import com.tencent.mm.protocal.protobuf.gkv;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import junit.framework.Assert;

public final class r
  extends com.tencent.mm.plugin.appbrand.networking.b<gkv>
{
  final c rr;
  
  public r(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, null, 0, localaeo);
    AppMethodBeat.i(44853);
    AppMethodBeat.o(44853);
  }
  
  public r(String paramString1, String paramString2, String paramString3, int paramInt, aeo paramaeo)
  {
    super(paramString2, paramString1);
    AppMethodBeat.i(323362);
    if ((BuildInfo.DEBUG) && (Util.isNullOrNil(paramString1)) && (Util.isNullOrNil(paramString2))) {
      Assert.fail("username and appId should not be null or nil!");
    }
    if ((BuildInfo.DEBUG) && (!Util.isNullOrNil(paramString1)) && (!paramString1.endsWith("@app"))) {
      Assert.fail("username should end with '@app', call @smoothieli to fix this");
    }
    com.tencent.mm.am.c.a locala = new com.tencent.mm.am.c.a();
    gkt localgkt = new gkt();
    localgkt.aaLU = paramString1;
    Object localObject;
    if (Util.isNullOrNil(paramString1))
    {
      localObject = n.cfc().e(paramString2, new String[] { "syncVersion" });
      if (localObject == null) {
        localObject = new com.tencent.mm.bx.b(new byte[0]);
      }
    }
    for (;;)
    {
      localgkt.YRt = ((com.tencent.mm.bx.b)localObject);
      localgkt.acgG = paramString2;
      localgkt.aaLT = paramString3;
      localgkt.acgH = paramInt;
      localgkt.YMR = ((aeo)Objects.requireNonNull(paramaeo));
      locala.otE = localgkt;
      locala.otF = new gkv();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      localObject = locala.bEF();
      this.rr = ((c)localObject);
      c((c)localObject);
      Log.i("MicroMsg.CgiWxaAttrSync", "<init> hash:%d, username:%s, appId:%s, cleanUpdate:%b, instanceId:%s, scene:%d, source:%s", new Object[] { Integer.valueOf(hashCode()), paramString1, paramString2, Boolean.FALSE, paramString3, Integer.valueOf(paramInt), com.tencent.mm.ak.a.b(paramaeo) });
      AppMethodBeat.o(323362);
      return;
      localObject = ac.d((WxaAttributes)localObject);
      continue;
      localObject = ac.d(n.cfc().d(paramString1, new String[] { "syncVersion" }));
    }
  }
  
  public final f<b.a<gkv>> ckO()
  {
    AppMethodBeat.i(323366);
    if (!com.tencent.mm.plugin.appbrand.networking.a.ff(((gkt)c.b.b(this.rr.otB)).acgG, ((gkt)c.b.b(this.rr.otB)).aaLU))
    {
      f localf = g.c(new com.tencent.mm.vending.g.c.a() {});
      AppMethodBeat.o(323366);
      return localf;
    }
    AppMethodBeat.o(323366);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.r
 * JD-Core Version:    0.7.0.1
 */