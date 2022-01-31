package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.a.r;
import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.bzm;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "callback"})
final class e$b
  implements b.a
{
  e$b(r paramr) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(143929);
    r localr = this.iCH;
    if (localr != null)
    {
      j.p(paramb, "rr");
      paramb = paramb.adn();
      if (paramb == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SendVerifyCodeResp");
        AppMethodBeat.o(143929);
        throw paramString;
      }
      localr.a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, (bzm)paramb);
      AppMethodBeat.o(143929);
      return;
    }
    AppMethodBeat.o(143929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.e.b
 * JD-Core Version:    0.7.0.1
 */