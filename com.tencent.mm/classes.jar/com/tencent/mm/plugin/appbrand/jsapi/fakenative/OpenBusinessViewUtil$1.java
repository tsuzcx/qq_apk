package com.tencent.mm.plugin.appbrand.jsapi.fakenative;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.sdk.platformtools.ab;

final class OpenBusinessViewUtil$1
  implements b.a
{
  OpenBusinessViewUtil$1(OpenBusinessViewUtil.a parama) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(131044);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.fsW.fta != null) && ((paramb.fsW.fta instanceof azl)))
    {
      paramString = (azl)paramb.fsW.fta;
      ab.i("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request success, appId:%s, path:%s", new Object[] { paramString.cwc, paramString.xoL });
      if (this.hLM != null) {
        this.hLM.cf(paramString.cwc, paramString.xoL);
      }
      AppMethodBeat.o(131044);
      return;
    }
    ab.e("MicroMsg.OpenBusinessViewUtil", "transBusinessAppInfo, request fail");
    if (this.hLM != null) {
      this.hLM.S(paramInt2, paramString);
    }
    AppMethodBeat.o(131044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.fakenative.OpenBusinessViewUtil.1
 * JD-Core Version:    0.7.0.1
 */