package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "TAG", "", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "plugin-appbrand-integration_release"})
public final class g$a
  implements f
{
  public static void a(final String paramString, final g.b paramb)
  {
    AppMethodBeat.i(50445);
    k.h(paramString, "username");
    p.aBh();
    if (e.Aa(paramString))
    {
      p.aBh();
      localObject = e.J(paramString, false);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      paramb.HH(paramString);
      AppMethodBeat.o(50445);
      return;
    }
    Object localObject = new com.tencent.mm.aj.f();
    ((com.tencent.mm.aj.f)localObject).a(paramString, (f.c)new a((com.tencent.mm.aj.f)localObject, paramb, paramString));
    AppMethodBeat.o(50445);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errType", "errCode", "resultCallback"})
  static final class a
    implements f.c
  {
    a(com.tencent.mm.aj.f paramf, g.b paramb, String paramString) {}
    
    public final int dd(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50444);
      ac.i(g.access$getTAG$cp(), "GetHDHeadImg errType=%d  errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.kdx.aBl();
      g.b localb = paramb;
      if (localb != null)
      {
        p.aBh();
        String str2 = e.J(paramString, false);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localb.HH(str1);
      }
      AppMethodBeat.o(50444);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.g.a
 * JD-Core Version:    0.7.0.1
 */