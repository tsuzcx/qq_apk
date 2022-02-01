package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Pattern;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/QRCodeDataPatternForWxa;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "isMatched", "", "qbarString", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g kPi;
  
  static
  {
    AppMethodBeat.i(228018);
    kPi = new g();
    AppMethodBeat.o(228018);
  }
  
  static Pattern bwN()
  {
    AppMethodBeat.i(228017);
    for (;;)
    {
      try
      {
        localObject1 = ((b)com.tencent.mm.kernel.g.af(b.class)).a(b.a.rUD, "");
        Log.i("MicroMsg.AppBrand.QRCodeDataPatternForWxa", "get by config, get pattern ".concat(String.valueOf(localObject1)));
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
        Log.e("MicroMsg.AppBrand.QRCodeDataPatternForWxa", "get by config, get exception ".concat(String.valueOf(localException)));
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(228017);
      return localObject1;
      i = 0;
      continue;
      localObject1 = Pattern.compile((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.predownload.g
 * JD-Core Version:    0.7.0.1
 */