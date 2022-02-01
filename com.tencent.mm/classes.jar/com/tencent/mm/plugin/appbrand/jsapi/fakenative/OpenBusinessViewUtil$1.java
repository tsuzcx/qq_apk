package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.Log;

final class OpenBusinessViewUtil$1
  implements IPCRunCgi.a
{
  OpenBusinessViewUtil$1(OpenBusinessViewUtil.a parama) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(46299);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (d.c.b(paramd.lBS) != null) && ((d.c.b(paramd.lBS) instanceof cpx)))
    {
      paramString = (cpx)d.c.b(paramd.lBS);
      Log.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramString.appid, paramString.Txf });
      if (this.oRx != null) {
        this.oRx.R(paramString.appid, paramString.Txf);
      }
      AppMethodBeat.o(46299);
      return;
    }
    Log.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
    if (this.oRx != null) {
      this.oRx.am(paramInt2, paramString);
    }
    AppMethodBeat.o(46299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.1
 * JD-Core Version:    0.7.0.1
 */