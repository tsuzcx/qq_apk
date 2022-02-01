package com.tencent.mm.plugin.downloader.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static final String[] ppW;
  private static final Map<String, String> ppX;
  
  static
  {
    AppMethodBeat.i(123485);
    ppW = new String[] { "dlied4.myapp.com", "dlied5.myapp.com" };
    ppX = new ConcurrentHashMap();
    AppMethodBeat.o(123485);
  }
  
  public static String aaQ(String paramString)
  {
    AppMethodBeat.i(123483);
    if (bu.isNullOrNil(paramString)) {}
    for (Object localObject = ""; (bu.isNullOrNil((String)localObject)) || (!Arrays.asList(ppW).contains(localObject)); localObject = Uri.parse(paramString).getHost())
    {
      ae.i("MicroMsg.GameDownloadExtension", "domain is not dlied4/dlied5");
      AppMethodBeat.o(123483);
      return paramString;
    }
    localObject = (IPCString)h.a("com.tencent.mm", new IPCString(paramString), a.class);
    if (localObject != null) {}
    for (localObject = ((IPCString)localObject).value;; localObject = "")
    {
      paramString = fp(fp(paramString, String.format("openid=%s", new Object[] { localObject })), "p=wechat");
      ae.i("MicroMsg.GameDownloadExtension", "after openid added, url: %s", new Object[] { paramString });
      AppMethodBeat.o(123483);
      return paramString;
    }
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(123482);
    ppX.clear();
    AppMethodBeat.o(123482);
  }
  
  private static String fp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123484);
    try
    {
      URI localURI = new URI(paramString1);
      String str = localURI.getQuery();
      if (str == null) {}
      for (;;)
      {
        paramString2 = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), paramString2, localURI.getFragment()).toString();
        AppMethodBeat.o(123484);
        return paramString2;
        paramString2 = str + "&" + paramString2;
      }
      return paramString1;
    }
    catch (URISyntaxException paramString2)
    {
      AppMethodBeat.o(123484);
    }
  }
  
  public static void h(String paramString, String... paramVarArgs)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(123480);
        if (!bu.isNullOrNil(paramString))
        {
          i = 0;
          if (i < 2)
          {
            if (bu.isNullOrNil(paramVarArgs[i])) {
              break label62;
            }
            ppX.put(paramVarArgs[i], paramString);
            break label62;
          }
        }
        AppMethodBeat.o(123480);
        return;
      }
      finally {}
      label62:
      i += 1;
    }
  }
  
  public static void u(String... paramVarArgs)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(123481);
        i = 0;
        if (i < 2)
        {
          if (!bu.isNullOrNil(paramVarArgs[i])) {
            ppX.remove(paramVarArgs[i]);
          }
        }
        else
        {
          AppMethodBeat.o(123481);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  static class a
    implements k<IPCString, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.a.c
 * JD-Core Version:    0.7.0.1
 */