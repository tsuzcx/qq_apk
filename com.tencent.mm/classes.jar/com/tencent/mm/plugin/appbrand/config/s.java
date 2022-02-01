package com.tencent.mm.plugin.appbrand.config;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/MiniProgramUserAgentUtils;", "", "()V", "make", "", "context", "Landroid/content/Context;", "originalUserAgent", "luggage-wechat-full-sdk_release"})
public final class s
{
  public static final s lfH;
  
  static
  {
    AppMethodBeat.i(230056);
    lfH = new s();
    AppMethodBeat.o(230056);
  }
  
  public static final String aa(Context paramContext, String paramString)
  {
    AppMethodBeat.i(230055);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    paramString = com.tencent.mm.plugin.appbrand.ac.p.a(localContext, paramContext, (p.a)e.M(p.a.class));
    kotlin.g.b.p.g(paramString, "ua");
    paramContext = paramString;
    if (!n.a((CharSequence)paramString, (CharSequence)"MiniProgramEnv/android", false)) {
      paramContext = paramString + " MiniProgramEnv/android";
    }
    kotlin.g.b.p.g(paramContext, "ua");
    AppMethodBeat.o(230055);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.s
 * JD-Core Version:    0.7.0.1
 */