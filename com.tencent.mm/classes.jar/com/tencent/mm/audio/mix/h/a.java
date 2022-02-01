package com.tencent.mm.audio.mix.h;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static boolean dfL = false;
  
  public static String R(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136956);
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    if ((dfL) && (paramString2.contains(".")) && (paramString2.contains("/")))
    {
      paramString2 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
      paramString2 = paramString2 + "_cache.pcm";
    }
    for (;;)
    {
      paramString1 = "/".concat(String.valueOf(paramString1));
      paramString1 = (String)localObject + paramString1;
      localObject = new e(paramString1);
      if (!((e)localObject).exists()) {
        ((e)localObject).mkdirs();
      }
      paramString1 = paramString1 + "/" + paramString2;
      AppMethodBeat.o(136956);
      return paramString1;
      if ((paramString2.contains(".")) && (paramString2.contains("/")) && (paramString2.lastIndexOf(".") > paramString2.lastIndexOf("/")))
      {
        paramString2 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
        paramString2 = paramString2 + "_cache.pcm";
        localObject = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
      else
      {
        paramString2 = c.ee(new StringBuilder().append(paramString2.hashCode()).toString()) + "_cache.pcm";
        localObject = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
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
        e locale = new e(str);
        if (locale.exists())
        {
          locale.delete();
          b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", new Object[] { str });
        }
      }
    }
    AppMethodBeat.o(136957);
  }
  
  public static String gv(String paramString)
  {
    AppMethodBeat.i(136954);
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    String str;
    if ((dfL) && (paramString.contains(".")) && (paramString.contains("/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      str = paramString + "_convert.pcm";
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = new e(paramString);
      if (!((e)localObject).exists()) {
        ((e)localObject).mkdirs();
      }
      paramString = paramString + "/" + str;
      AppMethodBeat.o(136954);
      return paramString;
      if ((paramString.contains(".")) && (paramString.contains("/")) && (paramString.lastIndexOf(".") > paramString.lastIndexOf("/")))
      {
        paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
        str = paramString + "_convert.pcm";
        paramString = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
      else
      {
        str = c.ee(new StringBuilder().append(paramString.hashCode()).toString()) + "_convert.pcm";
        paramString = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
    }
  }
  
  public static e gw(String paramString)
  {
    AppMethodBeat.i(177346);
    paramString = new e(paramString);
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
  
  public static boolean gx(String paramString)
  {
    AppMethodBeat.i(136958);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(136958);
      return false;
    }
    e locale = new e(paramString);
    if (!locale.exists())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    if (locale.isDirectory())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    int i;
    if (paramString.endsWith(".wav"))
    {
      if (locale.length() >= 5000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    if (!paramString.endsWith(".wav"))
    {
      if (locale.length() >= 2000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    AppMethodBeat.o(136958);
    return true;
  }
  
  public static long gy(String paramString)
  {
    AppMethodBeat.i(136959);
    paramString = new e(paramString);
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
 * Qualified Name:     com.tencent.mm.audio.mix.h.a
 * JD-Core Version:    0.7.0.1
 */