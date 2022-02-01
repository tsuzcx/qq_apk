package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.jy;

public final class g
  extends a<jy>
{
  final b rr;
  
  public g(jx paramjx)
  {
    this(paramjx, "/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl");
  }
  
  private g(jx paramjx, String paramString)
  {
    AppMethodBeat.i(174705);
    b.a locala = new b.a();
    locala.funcId = 1713;
    locala.uri = paramString;
    locala.hQF = paramjx;
    locala.hQG = new jy();
    paramjx = locala.aDS();
    this.rr = paramjx;
    c(paramjx);
    AppMethodBeat.o(174705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.g
 * JD-Core Version:    0.7.0.1
 */