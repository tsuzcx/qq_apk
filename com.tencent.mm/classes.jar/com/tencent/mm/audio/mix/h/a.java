package com.tencent.mm.audio.mix.h;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static boolean huV = false;
  
  public static u aGD()
  {
    AppMethodBeat.i(236169);
    u localu2 = u.V(MMApplicationContext.getContext().getExternalCacheDir());
    u localu1 = localu2;
    if (localu2 == null) {
      localu1 = u.V(MMApplicationContext.getContext().getCacheDir());
    }
    localu1 = new u(localu1, "MixAudio");
    localu1.jKY();
    AppMethodBeat.o(236169);
    return localu1;
  }
  
  public static String ac(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136956);
    u localu = aGD();
    paramString2 = c.getMD5String(new StringBuilder().append(paramString2.hashCode()).toString()) + "_cache.pcm";
    localu = new u(ah.v(localu.mUri) + "/" + paramString1);
    if (!localu.jKS()) {
      localu.jKY();
    }
    b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { ah.v(localu.mUri), paramString1 });
    paramString1 = ah.v(new u(localu, paramString2).mUri);
    AppMethodBeat.o(136956);
    return paramString1;
  }
  
  public static String ad(String paramString1, String paramString2)
  {
    AppMethodBeat.i(236179);
    u localu = aGD();
    localu = new u(ah.v(localu.mUri) + "/" + paramString1);
    if (!localu.jKS()) {
      localu.jKY();
    }
    b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { ah.v(localu.mUri), paramString1 });
    paramString1 = ah.v(new u(localu, paramString2).mUri);
    AppMethodBeat.o(236179);
    return paramString1;
  }
  
  public static void c(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(136957);
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = ac(paramString, (String)paramArrayList.next());
        u localu = new u(str);
        if (localu.jKS())
        {
          localu.diJ();
          b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", new Object[] { str });
        }
      }
    }
    AppMethodBeat.o(136957);
  }
  
  public static boolean dZ(long paramLong)
  {
    return paramLong >= 2000000L;
  }
  
  public static String jG(String paramString)
  {
    AppMethodBeat.i(136954);
    paramString = ah.v(new u(aGD(), c.getMD5String(new StringBuilder().append(paramString.hashCode()).toString()) + "_convert.pcm").mUri);
    AppMethodBeat.o(136954);
    return paramString;
  }
  
  public static u jH(String paramString)
  {
    AppMethodBeat.i(177346);
    paramString = new u(paramString);
    if (!paramString.jKS()) {}
    try
    {
      paramString.jKZ();
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
  
  public static File jI(String paramString)
  {
    AppMethodBeat.i(236171);
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      AppMethodBeat.o(236171);
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
  
  public static boolean jJ(String paramString)
  {
    AppMethodBeat.i(136958);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(136958);
      return false;
    }
    u localu = new u(paramString);
    if (!localu.jKS())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    if (localu.isDirectory())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    int i;
    if (paramString.endsWith(".wav"))
    {
      if (localu.length() >= 5000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    if (!paramString.endsWith(".wav"))
    {
      if (localu.length() >= 2000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    AppMethodBeat.o(136958);
    return true;
  }
  
  public static long jK(String paramString)
  {
    AppMethodBeat.i(136959);
    paramString = new u(paramString);
    if (paramString.jKS())
    {
      long l = paramString.length();
      AppMethodBeat.o(136959);
      return l;
    }
    AppMethodBeat.o(136959);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.a
 * JD-Core Version:    0.7.0.1
 */