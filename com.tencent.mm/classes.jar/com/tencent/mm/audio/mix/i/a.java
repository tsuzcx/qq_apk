package com.tencent.mm.audio.mix.i;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static boolean dxX = false;
  
  public static String S(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136956);
    o localo = ZW();
    paramString2 = c.getMD5String(new StringBuilder().append(paramString2.hashCode()).toString()) + "_cache.pcm";
    localo = new o(aa.z(localo.mUri) + "/" + paramString1);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { aa.z(localo.mUri), paramString1 });
    paramString1 = aa.z(new o(localo, paramString2).mUri);
    AppMethodBeat.o(136956);
    return paramString1;
  }
  
  public static String T(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198131);
    o localo = ZW();
    localo = new o(aa.z(localo.mUri) + "/" + paramString1);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { aa.z(localo.mUri), paramString1 });
    paramString1 = aa.z(new o(localo, paramString2).mUri);
    AppMethodBeat.o(198131);
    return paramString1;
  }
  
  public static o ZW()
  {
    AppMethodBeat.i(198129);
    o localo2 = o.X(MMApplicationContext.getContext().getExternalCacheDir());
    o localo1 = localo2;
    if (localo2 == null) {
      localo1 = o.X(MMApplicationContext.getContext().getCacheDir());
    }
    localo1 = new o(localo1, "MixAudio");
    localo1.mkdirs();
    AppMethodBeat.o(198129);
    return localo1;
  }
  
  public static boolean bu(long paramLong)
  {
    return paramLong >= 2000000L;
  }
  
  public static void c(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(136957);
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = S(paramString, (String)paramArrayList.next());
        o localo = new o(str);
        if (localo.exists())
        {
          localo.delete();
          b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", new Object[] { str });
        }
      }
    }
    AppMethodBeat.o(136957);
  }
  
  public static String hr(String paramString)
  {
    AppMethodBeat.i(136954);
    paramString = aa.z(new o(ZW(), c.getMD5String(new StringBuilder().append(paramString.hashCode()).toString()) + "_convert.pcm").mUri);
    AppMethodBeat.o(136954);
    return paramString;
  }
  
  public static o hs(String paramString)
  {
    AppMethodBeat.i(177346);
    paramString = new o(paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      AppMethodBeat.o(177346);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.printErrStackTrace("MicroMsg.Mix.FileUtil", localException, "createNewFile", new Object[0]);
      }
    }
  }
  
  public static File ht(String paramString)
  {
    AppMethodBeat.i(198130);
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      AppMethodBeat.o(198130);
      return paramString;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.printErrStackTrace("MicroMsg.Mix.FileUtil", localException, "createNewFile", new Object[0]);
      }
    }
  }
  
  public static boolean hu(String paramString)
  {
    AppMethodBeat.i(136958);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(136958);
      return false;
    }
    o localo = new o(paramString);
    if (!localo.exists())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    if (localo.isDirectory())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    int i;
    if (paramString.endsWith(".wav"))
    {
      if (localo.length() >= 5000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    if (!paramString.endsWith(".wav"))
    {
      if (localo.length() >= 2000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    AppMethodBeat.o(136958);
    return true;
  }
  
  public static long hv(String paramString)
  {
    AppMethodBeat.i(136959);
    paramString = new o(paramString);
    if (paramString.exists())
    {
      long l = paramString.length();
      AppMethodBeat.o(136959);
      return l;
    }
    AppMethodBeat.o(136959);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.i.a
 * JD-Core Version:    0.7.0.1
 */