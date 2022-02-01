package com.tencent.mm.plugin.appbrand.appcache.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.util.regex.Pattern;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/QRCodeDataPatternForWxa;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "isMatched", "", "qbarString", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g jNb;
  
  static
  {
    AppMethodBeat.i(223226);
    jNb = new g();
    AppMethodBeat.o(223226);
  }
  
  static Pattern bbA()
  {
    AppMethodBeat.i(223225);
    for (;;)
    {
      try
      {
        localObject1 = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qBQ, "");
        ae.i("MicroMsg.AppBrand.QRCodeDataPatternForWxa", "get by config, get pattern ".concat(String.valueOf(localObject1)));
        CharSequence localCharSequence = (CharSequence)localObject1;
        if (localCharSequence != null)
        {
          i = localCharSequence.length();
          if (i != 0) {
            continue;
          }
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        localObject1 = null;
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i;
        ae.e("MicroMsg.AppBrand.QRCodeDataPatternForWxa", "get by config, get exception ".concat(String.valueOf(localException)));
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(223225);
      return localObject1;
      i = 0;
      continue;
      localObject1 = Pattern.compile((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.g
 * JD-Core Version:    0.7.0.1
 */