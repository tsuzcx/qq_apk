package com.tencent.mm.audio.mix.h;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static boolean chZ = false;
  
  public static String J(String paramString1, String paramString2)
  {
    AppMethodBeat.i(137207);
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    if ((chZ) && (paramString2.contains(".")) && (paramString2.contains("/")))
    {
      paramString2 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
      paramString2 = paramString2 + "_cache.pcm";
    }
    for (;;)
    {
      paramString1 = File.separator + paramString1;
      paramString1 = (String)localObject + paramString1;
      localObject = new File(paramString1);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString1 = paramString1 + File.separator + paramString2;
      AppMethodBeat.o(137207);
      return paramString1;
      if ((paramString2.contains(".")) && (paramString2.contains("/")) && (paramString2.lastIndexOf(".") > paramString2.lastIndexOf("/")))
      {
        paramString2 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
        paramString2 = paramString2 + "_cache.pcm";
        localObject = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
      else
      {
        paramString2 = c.cE(new StringBuilder().append(paramString2.hashCode()).toString()) + "_cache.pcm";
        localObject = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
    }
  }
  
  public static void b(String paramString, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(137208);
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = J(paramString, (String)paramArrayList.next());
        File localFile = new File(str);
        if (localFile.exists())
        {
          localFile.delete();
          b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", new Object[] { str });
        }
      }
    }
    AppMethodBeat.o(137208);
  }
  
  public static String eD(String paramString)
  {
    AppMethodBeat.i(137205);
    Object localObject = Environment.getExternalStorageDirectory().getAbsolutePath();
    String str;
    if ((chZ) && (paramString.contains(".")) && (paramString.contains("/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      str = paramString + "_convert.pcm";
      paramString = (String)localObject;
    }
    for (;;)
    {
      localObject = new File(paramString);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString = paramString + File.separator + str;
      AppMethodBeat.o(137205);
      return paramString;
      if ((paramString.contains(".")) && (paramString.contains("/")) && (paramString.lastIndexOf(".") > paramString.lastIndexOf("/")))
      {
        paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
        str = paramString + "_convert.pcm";
        paramString = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
      else
      {
        str = c.cE(new StringBuilder().append(paramString.hashCode()).toString()) + "_convert.pcm";
        paramString = (String)localObject + "/tencent/MicroMsg/MixAudio";
      }
    }
  }
  
  public static File eE(String paramString)
  {
    AppMethodBeat.i(137206);
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      AppMethodBeat.o(137206);
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
  
  public static boolean eF(String paramString)
  {
    AppMethodBeat.i(137209);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(137209);
      return false;
    }
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      AppMethodBeat.o(137209);
      return false;
    }
    if (localFile.isDirectory())
    {
      AppMethodBeat.o(137209);
      return false;
    }
    int i;
    if (paramString.endsWith(".wav"))
    {
      if (localFile.length() >= 5000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(137209);
        return false;
      }
    }
    if (!paramString.endsWith(".wav"))
    {
      if (localFile.length() >= 2000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(137209);
        return false;
      }
    }
    AppMethodBeat.o(137209);
    return true;
  }
  
  public static long eG(String paramString)
  {
    AppMethodBeat.i(137210);
    paramString = new File(paramString);
    if (paramString.exists())
    {
      long l = paramString.length();
      AppMethodBeat.o(137210);
      return l;
    }
    AppMethodBeat.o(137210);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.a
 * JD-Core Version:    0.7.0.1
 */