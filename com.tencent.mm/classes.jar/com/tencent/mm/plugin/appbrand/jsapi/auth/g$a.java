package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.q;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "TAG", "", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "plugin-appbrand-integration_release"})
public final class g$a
  implements f
{
  public static void a(final String paramString, final g.b paramb)
  {
    AppMethodBeat.i(50445);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        q.bhz();
        if (!com.tencent.mm.am.f.TH(paramString)) {
          break;
        }
      }
      q.bhz();
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      localObject = com.tencent.mm.am.f.N((String)localObject, false);
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      paramb.acs(paramString);
      AppMethodBeat.o(50445);
      return;
    }
    localObject = new com.tencent.mm.am.g();
    ((com.tencent.mm.am.g)localObject).a(paramString, (g.c)new a((com.tencent.mm.am.g)localObject, paramb, paramString));
    AppMethodBeat.o(50445);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "resultCallback"})
  static final class a
    implements g.c
  {
    a(com.tencent.mm.am.g paramg, g.b paramb, String paramString) {}
    
    public final int dL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(50444);
      Log.i(g.access$getTAG$cp(), "GetHDHeadImg errType=%d  errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      this.oBf.qE();
      g.b localb = paramb;
      if (localb != null)
      {
        q.bhz();
        String str2 = com.tencent.mm.am.f.N(paramString, false);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        localb.acs(str1);
      }
      AppMethodBeat.o(50444);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.g.a
 * JD-Core Version:    0.7.0.1
 */