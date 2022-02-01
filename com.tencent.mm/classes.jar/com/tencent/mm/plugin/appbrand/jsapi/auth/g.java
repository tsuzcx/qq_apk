package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "()V", "Companion", "GetHeadIconPathCallback", "plugin-appbrand-integration_release"})
public final class g
{
  private static final String TAG = "AuthorizeHelper";
  public static final a lFD;
  
  static
  {
    AppMethodBeat.i(50446);
    lFD = new a((byte)0);
    TAG = "AuthorizeHelper";
    AppMethodBeat.o(50446);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "TAG", "", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "plugin-appbrand-integration_release"})
  public static final class a
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
          p.aYn();
          if (!e.Mm(paramString)) {
            break;
          }
        }
        p.aYn();
        localObject = paramString;
        if (paramString == null) {
          localObject = "";
        }
        localObject = e.L((String)localObject, false);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        paramb.UI(paramString);
        AppMethodBeat.o(50445);
        return;
      }
      localObject = new com.tencent.mm.aj.f();
      ((com.tencent.mm.aj.f)localObject).a(paramString, (f.c)new a((com.tencent.mm.aj.f)localObject, paramb, paramString));
      AppMethodBeat.o(50445);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "resultCallback"})
    static final class a
      implements f.c
    {
      a(com.tencent.mm.aj.f paramf, g.b paramb, String paramString) {}
      
      public final int dp(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(50444);
        Log.i(g.access$getTAG$cp(), "GetHDHeadImg errType=%d  errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        this.lFE.sQ();
        g.b localb = paramb;
        if (localb != null)
        {
          p.aYn();
          String str2 = e.L(paramString, false);
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          localb.UI(str1);
        }
        AppMethodBeat.o(50444);
        return 0;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void UI(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.g
 * JD-Core Version:    0.7.0.1
 */