package com.tencent.mm.plugin.appbrand.page.capsulebar;

import com.tencent.luggage.wxa.a.c;
import com.tencent.luggage.wxa.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract interface a
{
  public abstract i.a a(b paramb);
  
  public abstract int cfu();
  
  public static final class a
  {
    private static final a qwJ;
    
    static
    {
      AppMethodBeat.i(242760);
      qwJ = new a()
      {
        public final i.a a(a.b paramAnonymousb)
        {
          return i.qxA;
        }
        
        public final int cfu()
        {
          return -2147483648;
        }
      };
      AppMethodBeat.o(242760);
    }
    
    public static a a(AppBrandRuntime paramAppBrandRuntime, i.a parama)
    {
      AppMethodBeat.i(242758);
      paramAppBrandRuntime = new b(paramAppBrandRuntime, parama);
      AppMethodBeat.o(242758);
      return paramAppBrandRuntime;
    }
    
    public static a ah(AppBrandRuntime paramAppBrandRuntime)
    {
      AppMethodBeat.i(242756);
      if ((paramAppBrandRuntime == null) || (paramAppBrandRuntime.ntU.get()) || (paramAppBrandRuntime.aol))
      {
        paramAppBrandRuntime = qwJ;
        AppMethodBeat.o(242756);
        return paramAppBrandRuntime;
      }
      paramAppBrandRuntime = paramAppBrandRuntime.ntG.qxh;
      AppMethodBeat.o(242756);
      return paramAppBrandRuntime;
    }
  }
  
  public static enum b
  {
    final int qwP;
    final int qwQ;
    
    static
    {
      AppMethodBeat.i(244705);
      qwK = new b("NORMAL", 0, -1, -1);
      qwL = new b("LBS", 1, a.g.luggage_app_brand_jsapi_getting_location, a.c.app_brand_actionbar_capsule_lbs_dark);
      qwM = new b("VOICE", 2, a.g.luggage_app_brand_jsapi_recording, a.c.app_brand_actionbar_capsule_voice_dark);
      qwN = new b("VIDEO", 3, -1, a.c.app_brand_actionbar_capsule_video_dark);
      qwO = new b("LOADING", 4, -1, -1);
      qwR = new b[] { qwK, qwL, qwM, qwN, qwO };
      AppMethodBeat.o(244705);
    }
    
    private b(int paramInt1, int paramInt2)
    {
      this.qwP = paramInt1;
      this.qwQ = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.a
 * JD-Core Version:    0.7.0.1
 */