package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.sdk.platformtools.ab;

final class a$b$1
  implements b.a
{
  a$b$1(a.b paramb, c paramc, String paramString1, String paramString2) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(10817);
    ab.i("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd errType[%d], errCode[%d] ,errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      a.b.b(this.eEg, false, "cgi fail");
      AppMethodBeat.o(10817);
      return;
    }
    if (paramb.fsW.fta != null)
    {
      paramString = (axt)paramb.fsW.fta;
      paramInt1 = paramString.xmS.csV;
      paramb = paramString.xmS.csW;
      ab.i("MicroMsg.IPCInvoke_DoAuthorize", "NetSceneJSAuthorize jsErrcode[%d], jsErrmsg[%s]", new Object[] { Integer.valueOf(paramInt1), paramb });
      if (paramInt1 == -12000)
      {
        a.b.a(this.hoH, this.hoG, a.b.Bh(paramString.ntp), a.b.Bh(paramString.wnz), paramString.wYt, new a.a()
        {
          public final void o(Bundle paramAnonymousBundle)
          {
            AppMethodBeat.i(10816);
            int i = paramAnonymousBundle.getInt("retCode");
            if (i == 1)
            {
              i = paramAnonymousBundle.getInt("resultCode");
              paramAnonymousBundle = paramAnonymousBundle.getBundle("resultData");
              a.b.a(a.b.1.this.hoH, a.b.1.this.hoG, a.b.1.this.val$appId, paramAnonymousBundle, i, a.b.1.this.eEg);
              AppMethodBeat.o(10816);
              return;
            }
            a.b.b(a.b.1.this.eEg, false, "deny");
            ab.e("MicroMsg.IPCInvoke_DoAuthorize", "authorize fail, retCode[%d]", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(10816);
          }
        });
        AppMethodBeat.o(10817);
        return;
      }
      if (paramInt1 == 0)
      {
        a.b.a(this.hoH, this.hoG);
        a.b.b(this.eEg, true, "");
        AppMethodBeat.o(10817);
        return;
      }
      ab.e("MicroMsg.IPCInvoke_DoAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[] { paramb });
      a.b.b(this.eEg, false, String.valueOf(paramb));
    }
    AppMethodBeat.o(10817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */