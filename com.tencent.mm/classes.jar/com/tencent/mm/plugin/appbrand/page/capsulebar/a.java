package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.luggage.wxa.a.c;
import com.tencent.luggage.wxa.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface a
{
  public abstract m.a a(b paramb);
  
  public abstract m.a a(b paramb, boolean paramBoolean, String paramString);
  
  public abstract void afa(String paramString);
  
  public abstract int cGf();
  
  public static final class a
  {
    private static final a tBI;
    
    static
    {
      AppMethodBeat.i(325230);
      tBI = new a()
      {
        public final m.a a(a.b paramAnonymousb)
        {
          return m.tCD;
        }
        
        public final m.a a(a.b paramAnonymousb, boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          return m.tCD;
        }
        
        public final void afa(String paramAnonymousString) {}
        
        public final int cGf()
        {
          return -2147483648;
        }
      };
      AppMethodBeat.o(325230);
    }
    
    public static a a(AppBrandRuntime paramAppBrandRuntime, m.a parama)
    {
      AppMethodBeat.i(325225);
      paramAppBrandRuntime = new b(paramAppBrandRuntime, parama);
      AppMethodBeat.o(325225);
      return paramAppBrandRuntime;
    }
    
    public static a av(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(325220);
      if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.qsE.get()) || (paramAppBrandRuntime.ccV))
      {
        paramAppBrandRuntime = tBI;
        AppMethodBeat.o(325220);
        return paramAppBrandRuntime;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.qsp.cGm();
      AppMethodBeat.o(325220);
      return paramAppBrandRuntime;
    }
  }
  
  public static enum b
  {
    final int tBO;
    final int tBP;
    
    static
    {
      AppMethodBeat.i(325237);
      tBJ = new b("NORMAL", 0, -1, -1);
      tBK = new b("LBS", 1, a.g.luggage_app_brand_jsapi_getting_location, a.c.app_brand_actionbar_capsule_lbs_dark);
      tBL = new b("VOICE", 2, a.g.luggage_app_brand_jsapi_recording, a.c.app_brand_actionbar_capsule_voice_dark);
      tBM = new b("VIDEO", 3, -1, a.c.app_brand_actionbar_capsule_video_dark);
      tBN = new b("LOADING", 4, -1, -1);
      tBQ = new b[] { tBJ, tBK, tBL, tBM, tBN };
      AppMethodBeat.o(325237);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.tBO = paramInt1;
      this.tBP = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.a
 * JD-Core Version:    0.7.0.1
 */