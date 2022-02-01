package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.protocal.protobuf.eag;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.sdk.platformtools.bs;

public final class o
  extends c<eai>
{
  final com.tencent.mm.ak.b rr;
  
  public o(String paramString1, String paramString2)
  {
    AppMethodBeat.i(44853);
    b.a locala = new b.a();
    eag localeag = new eag();
    localeag.Fed = paramString1;
    if (bs.isNullOrNil(paramString1))
    {
      paramString1 = j.aVu().e(paramString2, new String[] { "syncVersion" });
      if (paramString1 == null) {
        paramString1 = "";
      }
    }
    for (paramString1 = new com.tencent.mm.bw.b(paramString1.getBytes());; paramString1 = j.aVu().Kd(paramString1))
    {
      localeag.EaW = paramString1;
      localeag.Ggm = paramString2;
      locala.hvt = localeag;
      locala.hvu = new eai();
      locala.funcId = 1151;
      locala.uri = "/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync";
      paramString1 = locala.aAz();
      this.rr = paramString1;
      this.rr = paramString1;
      AppMethodBeat.o(44853);
      return;
      paramString1 = bs.nullAsNil(paramString1.field_syncVersion);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.o
 * JD-Core Version:    0.7.0.1
 */