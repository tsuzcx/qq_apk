package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.protocal.protobuf.bdp;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/CgiAdGetPkgCDNDownloadURL;", "Lcom/tencent/mm/plugin/appbrand/appcache/CgiGetPkgDownloadInfo;", "request", "Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;", "(Lcom/tencent/mm/protocal/protobuf/GetWxaAppCDNDownloadUrlRequest;)V", "TAG", "", "plugin-appbrand-integration_release"})
public final class a
  extends h
{
  private final String TAG;
  
  public a(bdp parambdp)
  {
    super(parambdp, 1996, "/cgi-bin/mmbiz-bin/wxaapp/getadwxacdndownloadurl");
    AppMethodBeat.i(50183);
    this.TAG = "MicroMsg.AppBrand.CgiAdGetPkgCDNDownloadURL";
    AppMethodBeat.o(50183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.a
 * JD-Core Version:    0.7.0.1
 */