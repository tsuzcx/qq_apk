package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.ji;
import com.tencent.mm.protocal.protobuf.jj;

public final class g
  extends c<jj>
{
  final b rr;
  
  public g(ji paramji)
  {
    this(paramji, "/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl");
  }
  
  private g(ji paramji, String paramString)
  {
    AppMethodBeat.i(174705);
    b.a locala = new b.a();
    locala.funcId = 1713;
    locala.uri = paramString;
    locala.gUU = paramji;
    locala.gUV = new jj();
    paramji = locala.atI();
    this.rr = paramji;
    this.rr = paramji;
    AppMethodBeat.o(174705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.g
 * JD-Core Version:    0.7.0.1
 */