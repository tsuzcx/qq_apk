package com.tencent.mm.bs;

import android.content.Context;
import android.content.res.Resources;
import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public final class b
{
  private static String bsi(String paramString)
  {
    AppMethodBeat.i(32073);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32073);
      return "";
    }
    paramString = paramString.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
    AppMethodBeat.o(32073);
    return paramString;
  }
  
  public static String getRomInfo()
  {
    AppMethodBeat.i(32077);
    String str2 = "";
    String str1 = str2;
    try
    {
      StatFs localStatFs = new StatFs(g.aQa().getPath());
      str1 = str2;
      long l = localStatFs.getBlockSize();
      str1 = str2;
      str2 = "" + "AvailableSizes:" + localStatFs.getAvailableBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "FreeSizes:" + localStatFs.getFreeBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "AllSize:" + l * localStatFs.getBlockCount() + ";";
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    str1 = str1.replace(",", "_");
    AppMethodBeat.o(32077);
    return str1;
  }
  
  public static String iPg()
  {
    AppMethodBeat.i(32074);
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(y.Lh("/proc/cpuinfo"), "UTF-8"));
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(256);
        for (;;)
        {
          String str2 = localBufferedReader.readLine();
          if (str2 == null) {
            break;
          }
          if (!Util.isNullOrNil(str2)) {
            localStringBuilder.append(bsi(str2)).append(';');
          }
        }
        try
        {
          Log.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", localThrowable, "unexpected exception occurred.", new Object[0]);
          return "";
        }
        finally
        {
          String str1;
          Util.qualityClose(localBufferedReader);
          AppMethodBeat.o(32074);
        }
      }
      finally {}
    }
    finally
    {
      BufferedReader localBufferedReader = null;
    }
    str1 = localThrowable.toString().replace(',', '_');
    Util.qualityClose(localBufferedReader);
    AppMethodBeat.o(32074);
    return str1;
  }
  
  public static String iPh()
  {
    AppMethodBeat.i(32075);
    try
    {
      localBufferedReader = new BufferedReader(new InputStreamReader(y.Lh("/proc/meminfo"), "UTF-8"));
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(256);
        for (;;)
        {
          String str2 = localBufferedReader.readLine();
          if (str2 == null) {
            break;
          }
          if (!Util.isNullOrNil(str2)) {
            localStringBuilder.append(bsi(str2)).append(';');
          }
        }
        try
        {
          Log.printErrStackTrace("MicroMsg.PostTaskHardwareInfo", localThrowable, "unexpected exception occurred.", new Object[0]);
          return "";
        }
        finally
        {
          String str1;
          Util.qualityClose(localBufferedReader);
          AppMethodBeat.o(32075);
        }
      }
      finally {}
    }
    finally
    {
      BufferedReader localBufferedReader = null;
    }
    str1 = localThrowable.toString().replace(',', '_');
    Util.qualityClose(localBufferedReader);
    AppMethodBeat.o(32075);
    return str1;
  }
  
  public static String iPi()
  {
    AppMethodBeat.i(32076);
    Object localObject1 = "";
    try
    {
      new DisplayMetrics();
      Object localObject2 = MMApplicationContext.getContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject2).widthPixels;
      int j = ((DisplayMetrics)localObject2).heightPixels;
      float f1 = ((DisplayMetrics)localObject2).density;
      float f2 = ((DisplayMetrics)localObject2).xdpi;
      float f3 = ((DisplayMetrics)localObject2).ydpi;
      localObject2 = "" + "width:" + String.valueOf(i) + ";";
      localObject2 = (String)localObject2 + "height:" + String.valueOf(j) + ";";
      localObject2 = (String)localObject2 + "density:" + String.valueOf(f1) + ";";
      localObject2 = (String)localObject2 + "xd:" + String.valueOf(f2) + ";";
      localObject2 = (String)localObject2 + "yd:" + String.valueOf(f3) + ";";
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    localObject1 = ((String)localObject1).replace(",", "_");
    AppMethodBeat.o(32076);
    return localObject1;
  }
  
  public static String iPj()
  {
    AppMethodBeat.i(32078);
    String str2 = "";
    String str1 = str2;
    try
    {
      StatFs localStatFs = new StatFs(com.tencent.mm.loader.i.b.bmz());
      str1 = str2;
      long l = localStatFs.getBlockSize();
      str1 = str2;
      str2 = "" + "AvailableSizes:" + localStatFs.getAvailableBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "FreeSizes:" + localStatFs.getFreeBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "AllSize:" + l * localStatFs.getBlockCount() + ";";
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    str1 = str1.replace(",", "_");
    AppMethodBeat.o(32078);
    return str1;
  }
  
  public static String iPk()
  {
    AppMethodBeat.i(32079);
    bh.bCz();
    String str = (String)c.ban().d(71, null);
    AppMethodBeat.o(32079);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bs.b
 * JD-Core Version:    0.7.0.1
 */