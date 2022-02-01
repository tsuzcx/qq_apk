package com.tencent.mm.audio.mix.h;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static boolean dgN = false;
  
  public static k PB()
  {
    AppMethodBeat.i(195431);
    k localk2 = k.W(ak.getContext().getExternalCacheDir());
    k localk1 = localk2;
    if (localk2 == null) {
      localk1 = k.W(ak.getContext().getCacheDir());
    }
    localk1 = new k(localk1, "MixAudio");
    localk1.mkdirs();
    AppMethodBeat.o(195431);
    return localk1;
  }
  
  public static String R(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136956);
    k localk = PB();
    if ((paramString2.contains(".")) && (paramString2.contains("/")) && (paramString2.lastIndexOf(".") > paramString2.lastIndexOf("/"))) {
      paramString2 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
    }
    for (paramString2 = paramString2 + "_cache.pcm";; paramString2 = c.ej(new StringBuilder().append(paramString2.hashCode()).toString()) + "_cache.pcm")
    {
      localk = new k(w.B(localk.mUri) + "/" + paramString1);
      if (!localk.exists()) {
        localk.mkdirs();
      }
      b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { w.B(localk.mUri), paramString1 });
      paramString1 = w.B(new k(localk, paramString2).mUri);
      AppMethodBeat.o(136956);
      return paramString1;
    }
  }
  
  public static void b(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(136957);
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = R(paramString, (String)paramArrayList.next());
        k localk = new k(str);
        if (localk.exists())
        {
          localk.delete();
          b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", new Object[] { str });
        }
      }
    }
    AppMethodBeat.o(136957);
  }
  
  public static String gB(String paramString)
  {
    AppMethodBeat.i(136954);
    k localk = PB();
    if ((paramString.contains(".")) && (paramString.contains("/")) && (paramString.lastIndexOf(".") > paramString.lastIndexOf("/"))) {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
    }
    for (paramString = paramString + "_convert.pcm";; paramString = c.ej(new StringBuilder().append(paramString.hashCode()).toString()) + "_convert.pcm")
    {
      paramString = w.B(new k(localk, paramString).mUri);
      AppMethodBeat.o(136954);
      return paramString;
    }
  }
  
  public static k gC(String paramString)
  {
    AppMethodBeat.i(177346);
    paramString = new k(paramString);
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
  
  public static boolean gD(String paramString)
  {
    AppMethodBeat.i(136958);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(136958);
      return false;
    }
    k localk = new k(paramString);
    if (!localk.exists())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    if (localk.isDirectory())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    int i;
    if (paramString.endsWith(".wav"))
    {
      if (localk.length() >= 5000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    if (!paramString.endsWith(".wav"))
    {
      if (localk.length() >= 2000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    AppMethodBeat.o(136958);
    return true;
  }
  
  public static long gE(String paramString)
  {
    AppMethodBeat.i(136959);
    paramString = new k(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.a
 * JD-Core Version:    0.7.0.1
 */