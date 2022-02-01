package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Pattern;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/QRCodeDataPatternForWxa;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "isMatched", "", "qbarString", "plugin-appbrand-integration_release"})
public final class g
{
  public static final g nJo;
  
  static
  {
    AppMethodBeat.i(268264);
    nJo = new g();
    AppMethodBeat.o(268264);
  }
  
  static Pattern bHU()
  {
    AppMethodBeat.i(268262);
    for (;;)
    {
      try
      {
        localObject1 = ((b)h.ae(b.class)).a(b.a.vBn, "");
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
      AppMethodBeat.o(268262);
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