package com.tencent.mm.plugin.downloader.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static final String[] oco;
  private static final Map<String, String> ocp;
  
  static
  {
    AppMethodBeat.i(123485);
    oco = new String[] { "dlied4.myapp.com", "dlied5.myapp.com" };
    ocp = new ConcurrentHashMap();
    AppMethodBeat.o(123485);
  }
  
  public static String Sg(String paramString)
  {
    AppMethodBeat.i(123483);
    if (bt.isNullOrNil(paramString)) {}
    for (Object localObject = ""; (bt.isNullOrNil((String)localObject)) || (!Arrays.asList(oco).contains(localObject)); localObject = Uri.parse(paramString).getHost())
    {
      ad.i("MicroMsg.GameDownloadExtension", "domain is not dlied4/dlied5");
      AppMethodBeat.o(123483);
      return paramString;
    }
    localObject = (IPCString)h.a("com.tencent.mm", new IPCString(paramString), a.class);
    if (localObject != null) {}
    for (localObject = ((IPCString)localObject).value;; localObject = "")
    {
      paramString = eO(eO(paramString, String.format("openid=%s", new Object[] { localObject })), "p=wechat");
      ad.i("MicroMsg.GameDownloadExtension", "after openid added, url: %s", new Object[] { paramString });
      AppMethodBeat.o(123483);
      return paramString;
    }
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(123482);
    ocp.clear();
    AppMethodBeat.o(123482);
  }
  
  private static String eO(String paramString1, String paramString2)
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
        if (!bt.isNullOrNil(paramString))
        {
          i = 0;
          if (i < 2)
          {
            if (bt.isNullOrNil(paramVarArgs[i])) {
              break label62;
            }
            ocp.put(paramVarArgs[i], paramString);
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
  
  public static void t(String... paramVarArgs)
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
          if (!bt.isNullOrNil(paramVarArgs[i])) {
            ocp.remove(paramVarArgs[i]);
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