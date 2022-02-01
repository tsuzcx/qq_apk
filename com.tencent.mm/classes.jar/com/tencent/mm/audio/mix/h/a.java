package com.tencent.mm.audio.mix.h;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static boolean fqM = false;
  
  public static String X(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136956);
    q localq = aeF();
    paramString2 = c.getMD5String(new StringBuilder().append(paramString2.hashCode()).toString()) + "_cache.pcm";
    localq = new q(localq.getPath() + "/" + paramString1);
    if (!localq.ifE()) {
      localq.ifL();
    }
    b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { localq.getPath(), paramString1 });
    paramString1 = new q(localq, paramString2).getPath();
    AppMethodBeat.o(136956);
    return paramString1;
  }
  
  public static String Y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(257487);
    q localq = aeF();
    localq = new q(localq.getPath() + "/" + paramString1);
    if (!localq.ifE()) {
      localq.ifL();
    }
    b.i("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { localq.getPath(), paramString1 });
    paramString1 = new q(localq, paramString2).getPath();
    AppMethodBeat.o(257487);
    return paramString1;
  }
  
  public static q aeF()
  {
    AppMethodBeat.i(257485);
    q localq2 = q.Q(MMApplicationContext.getContext().getExternalCacheDir());
    q localq1 = localq2;
    if (localq2 == null) {
      localq1 = q.Q(MMApplicationContext.getContext().getCacheDir());
    }
    localq1 = new q(localq1, "MixAudio");
    localq1.ifL();
    AppMethodBeat.o(257485);
    return localq1;
  }
  
  public static boolean bJ(long paramLong)
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
        String str = X(paramString, (String)paramArrayList.next());
        q localq = new q(str);
        if (localq.ifE())
        {
          localq.cFq();
          b.i("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", new Object[] { str });
        }
      }
    }
    AppMethodBeat.o(136957);
  }
  
  public static String jdMethod_if(String paramString)
  {
    AppMethodBeat.i(136954);
    paramString = new q(aeF(), c.getMD5String(new StringBuilder().append(paramString.hashCode()).toString()) + "_convert.pcm").getPath();
    AppMethodBeat.o(136954);
    return paramString;
  }
  
  public static q ig(String paramString)
  {
    AppMethodBeat.i(177346);
    paramString = new q(paramString);
    if (!paramString.ifE()) {}
    try
    {
      paramString.ifM();
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
  
  public static File ih(String paramString)
  {
    AppMethodBeat.i(257486);
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      AppMethodBeat.o(257486);
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
  
  public static boolean ii(String paramString)
  {
    AppMethodBeat.i(136958);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(136958);
      return false;
    }
    q localq = new q(paramString);
    if (!localq.ifE())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    if (localq.isDirectory())
    {
      AppMethodBeat.o(136958);
      return false;
    }
    int i;
    if (paramString.endsWith(".wav"))
    {
      if (localq.length() >= 5000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    if (!paramString.endsWith(".wav"))
    {
      if (localq.length() >= 2000000L) {}
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(136958);
        return false;
      }
    }
    AppMethodBeat.o(136958);
    return true;
  }
  
  public static long ij(String paramString)
  {
    AppMethodBeat.i(136959);
    paramString = new q(paramString);
    if (paramString.ifE())
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