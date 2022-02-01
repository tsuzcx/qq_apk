package com.tencent.midas.comm.log.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

public class APLogFileUtil
{
  private static final String DEBUG_CONF = "MidasLogDebug.ini";
  private static final int DEFAULT_MAX_LOG_FILE_NUM = 2;
  private static final int DEFAULT_MAX_LOG_FILE_SIZE_MB = 1;
  private static final int DEFAULT_MAX_LOG_KEEP_DAYS = 15;
  public static final String SEPARATOR_LINE = "\r\n";
  public static final String SEPARATOR_LOG = " | ";
  private static int maxDirSizeMB = maxLogFileNum * 15 * maxLogFileSizeMB;
  public static int maxLogFileNum;
  public static int maxLogFileSizeMB = 1;
  public static int maxLogKeepDays;
  public static int minSDCardSpace;
  
  static
  {
    maxLogFileNum = 2;
    minSDCardSpace = 20;
    maxLogKeepDays = 15;
  }
  
  public static void deleteFileUpMaxInDir(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(193459);
    for (;;)
    {
      try
      {
        File localFile = new File(paramString);
        if (localFile.exists())
        {
          boolean bool = localFile.isFile();
          if (!bool) {}
        }
        else
        {
          AppMethodBeat.o(193459);
          return;
        }
        if (getFileOrFilesSize(paramString) >= paramLong2)
        {
          i = 1;
          paramString = localFile.listFiles();
          if (paramString != null)
          {
            j = paramString.length;
            if (j != 0) {}
          }
          else
          {
            AppMethodBeat.o(193459);
            return;
          }
          paramLong2 = System.currentTimeMillis();
          int k = paramString.length;
          int j = 0;
          if (j < k)
          {
            localFile = paramString[j];
            long l = localFile.lastModified();
            if ((!localFile.getName().equals("MidasLog.mmap")) && (localFile.isFile()) && ((i != 0) || (paramLong2 - l > paramInt * 24 * 3600 * 1000) || (getFileSize(localFile) / 1024L / 1024L >= paramLong1))) {
              localFile.delete();
            }
            j += 1;
            continue;
          }
          AppMethodBeat.o(193459);
          return;
        }
      }
      catch (Throwable paramString)
      {
        AppMethodBeat.o(193459);
        return;
      }
      int i = 0;
    }
  }
  
  public static void deleteOldFileToday(String paramString)
  {
    AppMethodBeat.i(193454);
    deleteOldFileToday(paramString, maxLogFileNum);
    AppMethodBeat.o(193454);
  }
  
  public static void deleteOldFileToday(String paramString, int paramInt)
  {
    AppMethodBeat.i(193455);
    paramString = getLogFiles(paramString, getToday() + "_");
    int j = paramString.size();
    if ((j >= paramInt) && (paramInt > 0))
    {
      int i = 0;
      while (i < j)
      {
        File localFile = (File)paramString.get(i);
        if (localFile != null)
        {
          new StringBuilder("get: ").append(localFile.getName());
          if (i < j - paramInt)
          {
            new StringBuilder("delete: ").append(localFile.getName());
            localFile.delete();
          }
        }
        i += 1;
      }
    }
    AppMethodBeat.o(193455);
  }
  
  private static int getConfValue(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    AppMethodBeat.i(193462);
    paramSharedPreferences = paramSharedPreferences.getString(paramString, null);
    i = paramInt;
    if (!TextUtils.isEmpty(paramSharedPreferences)) {}
    try
    {
      String.format(Locale.CHINA, "Read log conf[%s]: %s", new Object[] { paramString, paramSharedPreferences });
      int j = Integer.parseInt(paramSharedPreferences);
      i = paramInt;
      if (j > 0) {
        i = j;
      }
    }
    catch (Throwable paramSharedPreferences)
    {
      for (;;)
      {
        String.format(Locale.CHINA, "Read log conf[%s] error: %s", new Object[] { paramString, paramSharedPreferences.getMessage() });
        i = paramInt;
      }
    }
    AppMethodBeat.o(193462);
    return i;
  }
  
  public static double getFileOrFilesSize(String paramString)
  {
    AppMethodBeat.i(193450);
    paramString = new File(paramString);
    for (long l1 = 0L;; l1 = l2)
    {
      try
      {
        if (!paramString.isDirectory()) {
          break label50;
        }
        l2 = getFileSizes(paramString);
        l1 = l2;
      }
      catch (Throwable paramString)
      {
        long l2;
        label32:
        double d;
        label50:
        break label32;
      }
      d = l1 / 1024L / 1024L;
      AppMethodBeat.o(193450);
      return d;
      l2 = getFileSize(paramString);
    }
  }
  
  private static long getFileSize(File paramFile)
  {
    AppMethodBeat.i(193451);
    long l2 = 0L;
    for (long l1 = l2;; l1 = l2)
    {
      try
      {
        if (!paramFile.exists()) {
          break label50;
        }
        l1 = l2;
        paramFile = new FileInputStream(paramFile);
        l1 = l2;
        l2 = paramFile.available();
        l1 = l2;
        paramFile.close();
        l1 = l2;
      }
      catch (Throwable paramFile)
      {
        label43:
        label50:
        break label43;
      }
      AppMethodBeat.o(193451);
      return l1;
      l1 = l2;
      paramFile.createNewFile();
    }
  }
  
  private static long getFileSizes(File paramFile)
  {
    AppMethodBeat.i(193452);
    long l = 0L;
    paramFile = paramFile.listFiles();
    int i = 0;
    if (i < paramFile.length)
    {
      if (paramFile[i].isDirectory()) {}
      for (l += getFileSizes(paramFile[i]);; l += getFileSize(paramFile[i]))
      {
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(193452);
    return l;
  }
  
  public static String getLastLogFileName(String paramString)
  {
    AppMethodBeat.i(193456);
    paramString = getLogFiles(paramString, getToday());
    if (paramString.size() > 0)
    {
      paramString = ((File)paramString.get(paramString.size() - 1)).getName();
      AppMethodBeat.o(193456);
      return paramString;
    }
    AppMethodBeat.o(193456);
    return "";
  }
  
  public static ArrayList<File> getLogFiles(String paramString1, String paramString2)
  {
    AppMethodBeat.i(193457);
    paramString1 = new File(paramString1);
    if (paramString1.isDirectory())
    {
      paramString1 = paramString1.listFiles(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          AppMethodBeat.i(193446);
          boolean bool = paramAnonymousString.startsWith(this.val$prefix);
          AppMethodBeat.o(193446);
          return bool;
        }
      });
      Arrays.sort(paramString1, new Comparator()
      {
        private int extractNumber(String paramAnonymousString)
        {
          AppMethodBeat.i(193448);
          try
          {
            i = Integer.parseInt(paramAnonymousString.substring(paramAnonymousString.indexOf('_') + 1, paramAnonymousString.lastIndexOf('.')));
            AppMethodBeat.o(193448);
            return i;
          }
          catch (Throwable paramAnonymousString)
          {
            for (;;)
            {
              int i = 0;
            }
          }
        }
        
        public final int compare(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          AppMethodBeat.i(193447);
          int i = extractNumber(paramAnonymousFile1.getName());
          int j = extractNumber(paramAnonymousFile2.getName());
          AppMethodBeat.o(193447);
          return i - j;
        }
      });
      paramString1 = new ArrayList(Arrays.asList(paramString1));
      AppMethodBeat.o(193457);
      return paramString1;
    }
    paramString1 = new ArrayList();
    AppMethodBeat.o(193457);
    return paramString1;
  }
  
  public static double getSDCardSpace()
  {
    AppMethodBeat.i(193453);
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L / 1024L;
      double d = l;
      AppMethodBeat.o(193453);
      return d;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        new StringBuilder("getSDCardSpace: ").append(localThrowable.toString());
        long l = 0L;
      }
    }
  }
  
  public static String getToday()
  {
    AppMethodBeat.i(193458);
    String str = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    AppMethodBeat.o(193458);
    return str;
  }
  
  public static boolean initLogDir(String paramString)
  {
    AppMethodBeat.i(193460);
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        AppMethodBeat.o(193460);
        return bool;
      }
      deleteFileUpMaxInDir(paramString, maxLogFileSizeMB, maxDirSizeMB, maxLogKeepDays);
      deleteOldFileToday(paramString, maxLogFileNum);
      AppMethodBeat.o(193460);
      return true;
    }
    catch (Throwable paramString)
    {
      new StringBuilder("init log dir error: ").append(paramString.toString());
      AppMethodBeat.o(193460);
    }
    return false;
  }
  
  public static boolean isDebugMode(String paramString)
  {
    AppMethodBeat.i(193461);
    boolean bool = new File(paramString + "MidasLogDebug.ini").exists();
    AppMethodBeat.o(193461);
    return bool;
  }
  
  public static void readLogKeepConf(Context paramContext)
  {
    AppMethodBeat.i(193463);
    if (maxLogFileSizeMB > 0)
    {
      i = maxLogFileSizeMB;
      maxLogFileSizeMB = i;
      if (maxLogFileNum <= 0) {
        break label218;
      }
      i = maxLogFileNum;
      label30:
      maxLogFileNum = i;
      if (maxLogKeepDays <= 0) {
        break label223;
      }
    }
    label218:
    label223:
    for (int i = maxLogKeepDays;; i = 15)
    {
      maxLogKeepDays = i;
      maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * maxLogKeepDays;
      String.format(Locale.CHINA, "current config: max log size: %d MB, max log num: %d, max keep %d DAYS", new Object[] { Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays) });
      paramContext = paramContext.getSharedPreferences("TencentUnipay", 4);
      maxLogFileSizeMB = getConfValue(paramContext, "size", maxLogFileSizeMB);
      maxLogFileNum = getConfValue(paramContext, "num", maxLogFileNum);
      maxLogKeepDays = getConfValue(paramContext, "log_keep_time", maxLogKeepDays);
      maxDirSizeMB = maxLogFileSizeMB * maxLogFileNum * maxLogKeepDays;
      String.format(Locale.CHINA, "final config: max log size: %d MB, max log num: %d, max keep %d DAYS", new Object[] { Integer.valueOf(maxLogFileSizeMB), Integer.valueOf(maxLogFileNum), Integer.valueOf(maxLogKeepDays) });
      AppMethodBeat.o(193463);
      return;
      i = 1;
      break;
      i = 2;
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.comm.log.util.APLogFileUtil
 * JD-Core Version:    0.7.0.1
 */