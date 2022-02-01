package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.p;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthConstants;", "()V", "Companion", "GetHeadIconPathCallback", "plugin-appbrand-integration_release"})
public final class g
{
  private static final String TAG = "AuthorizeHelper";
  public static final a jDa;
  
  static
  {
    AppMethodBeat.i(50446);
    jDa = new a((byte)0);
    TAG = "AuthorizeHelper";
    AppMethodBeat.o(50446);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$Companion;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "TAG", "", "getHeadIconPath", "", "username", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "plugin-appbrand-integration_release"})
  public static final class a
    implements f
  {
    public static void a(final String paramString, final g.b paramb)
    {
      AppMethodBeat.i(50445);
      k.h(paramString, "username");
      p.auq();
      if (e.vU(paramString))
      {
        p.auq();
        localObject = e.I(paramString, false);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
        paramb.DD(paramString);
        AppMethodBeat.o(50445);
        return;
      }
      Object localObject = new com.tencent.mm.ak.f();
      ((com.tencent.mm.ak.f)localObject).a(paramString, (f.c)new a((com.tencent.mm.ak.f)localObject, paramb, paramString));
      AppMethodBeat.o(50445);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errType", "errCode", "resultCallback"})
    static final class a
      implements f.c
    {
      a(com.tencent.mm.ak.f paramf, g.b paramb, String paramString) {}
      
      public final int dd(int paramInt1, int paramInt2)
      {
        AppMethodBeat.i(50444);
        ad.i(g.access$getTAG$cp(), "GetHDHeadImg errType=%d  errCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        this.jDb.auu();
        g.b localb = paramb;
        if (localb != null)
        {
          p.auq();
          String str2 = e.I(paramString, false);
          String str1 = str2;
          if (str2 == null) {
            str1 = "";
          }
          localb.DD(str1);
        }
        AppMethodBeat.o(50444);
        return 0;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthorizeHelper$GetHeadIconPathCallback;", "", "onCallback", "", "path", "", "plugin-appbrand-integration_release"})
  public static abstract interface b
  {
    public abstract void DD(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.g
 * JD-Core Version:    0.7.0.1
 */