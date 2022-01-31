package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FilenameFilter;

public final class am
{
  public static void a(FilenameFilter paramFilenameFilter)
  {
    AppMethodBeat.i(59481);
    String str = g.RL().cachePath;
    Object localObject = str;
    if (!str.endsWith("/")) {
      localObject = str + "/";
    }
    localObject = new File((String)localObject + "appbrand/jscache");
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      paramFilenameFilter = ((File)localObject).listFiles(paramFilenameFilter);
      if ((paramFilenameFilter != null) && (paramFilenameFilter.length > 0))
      {
        int j = paramFilenameFilter.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramFilenameFilter[i];
          com.tencent.mm.a.e.o((File)localObject);
          ab.i("WxaJsCacheStorage", "clear file:%s", new Object[] { ((File)localObject).getName() });
          i += 1;
        }
      }
    }
    AppMethodBeat.o(59481);
  }
  
  public final void clear(String paramString)
  {
    AppMethodBeat.i(59482);
    a(new am.1(this, paramString));
    AppMethodBeat.o(59482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.am
 * JD-Core Version:    0.7.0.1
 */