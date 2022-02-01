package com.tencent.mm.plugin.appbrand.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ap;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig.g;
import com.tencent.mm.plugin.appbrand.w;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/halfscreen/utils/AppBrandEmbedHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ruh;
  
  static
  {
    AppMethodBeat.i(317209);
    ruh = new a((byte)0);
    AppMethodBeat.o(317209);
  }
  
  public static final boolean F(w paramw)
  {
    AppMethodBeat.i(317190);
    boolean bool = a.F(paramw);
    AppMethodBeat.o(317190);
    return bool;
  }
  
  public static final w G(w paramw)
  {
    AppMethodBeat.i(317195);
    s.u(paramw, "host");
    if (a.F(paramw))
    {
      paramw = paramw.qsc;
      if (paramw != null)
      {
        paramw = (w)paramw.getActiveRuntime();
        AppMethodBeat.o(317195);
        return paramw;
      }
    }
    AppMethodBeat.o(317195);
    return null;
  }
  
  public static final w H(w paramw)
  {
    AppMethodBeat.i(317201);
    paramw = a.H(paramw);
    AppMethodBeat.o(317201);
    return paramw;
  }
  
  public static final boolean I(w paramw)
  {
    AppMethodBeat.i(317206);
    boolean bool = a.I(paramw);
    AppMethodBeat.o(317206);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/halfscreen/utils/AppBrandEmbedHelper$Companion;", "", "()V", "TAG", "", "getEmbeddedWxaForHost", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "host", "getEmbeddedWxaHost", "embedWxa", "isEmbedWxa", "", "isEmbeddedModeForHost", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean F(w paramw)
    {
      AppMethodBeat.i(317197);
      s.u(paramw, "host");
      Object localObject1 = paramw.qsc;
      if (localObject1 == null)
      {
        AppMethodBeat.o(317197);
        return false;
      }
      w localw = (w)((ap)localObject1).getActiveRuntime();
      if (localw == null)
      {
        AppMethodBeat.o(317197);
        return false;
      }
      if (s.p(paramw, localw))
      {
        AppMethodBeat.o(317197);
        return false;
      }
      if (I(localw)) {
        try
        {
          localObject1 = ((ap)localObject1).y((AppBrandRuntime)localw);
          if (localObject1 == paramw)
          {
            AppMethodBeat.o(317197);
            return true;
          }
        }
        finally
        {
          for (;;)
          {
            Object localObject3 = null;
          }
        }
      }
      AppMethodBeat.o(317197);
      return false;
    }
    
    public static w H(w paramw)
    {
      AppMethodBeat.i(317203);
      s.u(paramw, "embedWxa");
      if (I(paramw))
      {
        ap localap = paramw.qsc;
        if (localap == null)
        {
          AppMethodBeat.o(317203);
          return null;
        }
        if (localap.z((AppBrandRuntime)paramw))
        {
          paramw = (w)localap.y((AppBrandRuntime)paramw);
          AppMethodBeat.o(317203);
          return paramw;
        }
      }
      AppMethodBeat.o(317203);
      return null;
    }
    
    public static boolean I(w paramw)
    {
      AppMethodBeat.i(317207);
      s.u(paramw, "embedWxa");
      paramw = paramw.getInitConfig().qAT;
      s.s(paramw, "embedWxa.initConfig.halfScreenConfig");
      if ((paramw.isEnable()) && (paramw.rac == HalfScreenConfig.g.raA))
      {
        AppMethodBeat.o(317207);
        return true;
      }
      AppMethodBeat.o(317207);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.a.a
 * JD-Core Version:    0.7.0.1
 */