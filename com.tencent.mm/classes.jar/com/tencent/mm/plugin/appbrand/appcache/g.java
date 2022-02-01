package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.protocal.protobuf.jp;

public final class g
  extends c<jp>
{
  final b rr;
  
  public g(jo paramjo)
  {
    this(paramjo, "/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl");
  }
  
  private g(jo paramjo, String paramString)
  {
    AppMethodBeat.i(174705);
    b.a locala = new b.a();
    locala.funcId = 1713;
    locala.uri = paramString;
    locala.hvt = paramjo;
    locala.hvu = new jp();
    paramjo = locala.aAz();
    this.rr = paramjo;
    this.rr = paramjo;
    AppMethodBeat.o(174705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.g
 * JD-Core Version:    0.7.0.1
 */