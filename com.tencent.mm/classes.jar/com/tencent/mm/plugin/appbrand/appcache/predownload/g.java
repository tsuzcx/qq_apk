package com.tencent.mm.plugin.appbrand.appcache.predownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/predownload/QRCodeDataPatternForWxa;", "", "()V", "PATTERN", "Ljava/util/regex/Pattern;", "getPATTERN", "()Ljava/util/regex/Pattern;", "TAG", "", "isMatched", "", "qbarString", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g qIW;
  
  static
  {
    AppMethodBeat.i(320493);
    qIW = new g();
    AppMethodBeat.o(320493);
  }
  
  static Pattern chq()
  {
    AppMethodBeat.i(320485);
    for (;;)
    {
      try
      {
        localObject1 = ((c)h.ax(c.class)).a(c.a.yPf, "");
        Log.i("MicroMsg.AppBrand.QRCodeDataPatternForWxa", s.X("get by config, get pattern ", localObject1));
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
        Log.e("MicroMsg.AppBrand.QRCodeDataPatternForWxa", s.X("get by config, get exception ", localException));
        Object localObject2 = null;
        continue;
      }
      AppMethodBeat.o(320485);
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