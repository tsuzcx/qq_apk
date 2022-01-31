package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axr;
import com.tencent.mm.sdk.platformtools.ab;

final class a$b$2
  implements b.a
{
  a$b$2(a.b paramb, c paramc, int paramInt, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(10818);
    ab.d("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      a.b.b(this.eEg, false, "cgi fail");
      AppMethodBeat.o(10818);
      return;
    }
    if (paramb.fsW.fta != null)
    {
      if (this.hoJ == 2)
      {
        a.b.b(this.eEg, false, "cgi fail");
        AppMethodBeat.o(10818);
        return;
      }
      paramString = (axr)paramb.fsW.fta;
      paramInt1 = paramString.xmS.csV;
      ab.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorizeConfirm jsErrcode[%d], jsErrmsg[%s]", new Object[] { Integer.valueOf(paramInt1), paramString.xmS.csW });
      if (paramInt1 == 0)
      {
        a.b.a(this.hoH, this.hoG);
        a.b.b(this.eEg, true, "");
        AppMethodBeat.o(10818);
        return;
      }
      a.b.b(this.eEg, false, "cgi fail");
    }
    AppMethodBeat.o(10818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b.2
 * JD-Core Version:    0.7.0.1
 */