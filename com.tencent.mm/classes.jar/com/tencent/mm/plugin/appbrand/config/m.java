package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ah.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.cmi;
import com.tencent.mm.protocal.c.cmk;
import com.tencent.mm.sdk.platformtools.bk;

public final class m
  extends a<cmk>
{
  final com.tencent.mm.ah.b dmK;
  
  public m(String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    cmi localcmi = new cmi();
    localcmi.tMY = paramString1;
    if (bk.bl(paramString1))
    {
      paramString1 = e.aaT().e(paramString2, new String[] { "syncVersion" });
      if (paramString1 == null) {
        paramString1 = "";
      }
    }
    for (paramString1 = new com.tencent.mm.bv.b(paramString1.getBytes());; paramString1 = s.sC(paramString1))
    {
      localcmi.sCF = paramString1;
      localcmi.tZo = paramString2;
      locala.ecH = localcmi;
      locala.ecI = new cmk();
      locala.ecG = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      paramString1 = locala.Kt();
      this.dmK = paramString1;
      this.dmK = paramString1;
      return;
      paramString1 = bk.pm(paramString1.field_syncVersion);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.m
 * JD-Core Version:    0.7.0.1
 */