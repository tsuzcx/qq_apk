package com.tencent.mm.plugin.appbrand.config;

import android.content.Context;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/MiniProgramUserAgentUtils;", "", "()V", "make", "", "context", "Landroid/content/Context;", "originalUserAgent", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v raJ;
  
  static
  {
    AppMethodBeat.i(323372);
    raJ = new v();
    AppMethodBeat.o(323372);
  }
  
  public static final String Y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(323365);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    paramString = r.a(localContext, paramContext, (r.a)e.T(r.a.class));
    s.s(paramString, "ua");
    paramContext = paramString;
    if (!n.a((CharSequence)paramString, (CharSequence)"MiniProgramEnv/android", false)) {
      paramContext = s.X(paramString, " MiniProgramEnv/android");
    }
    s.s(paramContext, "ua");
    AppMethodBeat.o(323365);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.v
 * JD-Core Version:    0.7.0.1
 */