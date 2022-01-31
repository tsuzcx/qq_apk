package com.tencent.mm.plugin.downloader.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static final String[] kVE;
  private static final Map<String, String> kVF;
  
  static
  {
    AppMethodBeat.i(67892);
    kVE = new String[] { "dlied4.myapp.com", "dlied5.myapp.com" };
    kVF = new ConcurrentHashMap();
    AppMethodBeat.o(67892);
  }
  
  public static String Jz(String paramString)
  {
    AppMethodBeat.i(67890);
    if (bo.isNullOrNil(paramString)) {}
    for (Object localObject = ""; (bo.isNullOrNil((String)localObject)) || (!Arrays.asList(kVE).contains(localObject)); localObject = Uri.parse(paramString).getHost())
    {
      ab.i("MicroMsg.GameDownloadExtension", "domain is not dlied4/dlied5");
      AppMethodBeat.o(67890);
      return paramString;
    }
    localObject = (IPCString)f.a("com.tencent.mm", new IPCString(paramString), c.a.class);
    if (localObject != null) {}
    for (localObject = ((IPCString)localObject).value;; localObject = "")
    {
      paramString = dF(dF(paramString, String.format("openid=%s", new Object[] { localObject })), "p=wechat");
      ab.i("MicroMsg.GameDownloadExtension", "after openid added, url: %s", new Object[] { paramString });
      AppMethodBeat.o(67890);
      return paramString;
    }
  }
  
  public static void clearCache()
  {
    AppMethodBeat.i(67889);
    kVF.clear();
    AppMethodBeat.o(67889);
  }
  
  private static String dF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(67891);
    try
    {
      URI localURI = new URI(paramString1);
      String str = localURI.getQuery();
      if (str == null) {}
      for (;;)
      {
        paramString2 = new URI(localURI.getScheme(), localURI.getAuthority(), localURI.getPath(), paramString2, localURI.getFragment()).toString();
        AppMethodBeat.o(67891);
        return paramString2;
        paramString2 = str + "&" + paramString2;
      }
      return paramString1;
    }
    catch (URISyntaxException paramString2)
    {
      AppMethodBeat.o(67891);
    }
  }
  
  public static void h(String paramString, String... paramVarArgs)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67887);
        if (!bo.isNullOrNil(paramString))
        {
          i = 0;
          if (i < 2)
          {
            if (bo.isNullOrNil(paramVarArgs[i])) {
              break label62;
            }
            kVF.put(paramVarArgs[i], paramString);
            break label62;
          }
        }
        AppMethodBeat.o(67887);
        return;
      }
      finally {}
      label62:
      i += 1;
    }
  }
  
  public static void m(String... paramVarArgs)
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(67888);
        i = 0;
        if (i < 2)
        {
          if (!bo.isNullOrNil(paramVarArgs[i])) {
            kVF.remove(paramVarArgs[i]);
          }
        }
        else
        {
          AppMethodBeat.o(67888);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.a.c
 * JD-Core Version:    0.7.0.1
 */