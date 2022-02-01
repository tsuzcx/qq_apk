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
    AppMethodBeat.i(217363);
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
          AppMethodBeat.o(217363);
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
            AppMethodBeat.o(217363);
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
        }
      }
      finally
      {
        AppMethodBeat.o(217363);
        return;
      }
      int i = 0;
    }
  }
  
  public static void deleteOldFileToday(String paramString)
  {
    AppMethodBeat.i(217308);
    deleteOldFileToday(paramString, maxLogFileNum);
    AppMethodBeat.o(217308);
  }
  
  public static void deleteOldFileToday(String paramString, int paramInt)
  {
    AppMethodBeat.i(217319);
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
    AppMethodBeat.o(217319);
  }
  
  private static int getConfValue(SharedPreferences paramSharedPreferences, String paramString, int paramInt)
  {
    AppMethodBeat.i(217391);
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
    finally
    {
      for (;;)
      {
        String.format(Locale.CHINA, "Read log conf[%s] error: %s", new Object[] { paramString, paramSharedPreferences.getMessage() });
        i = paramInt;
      }
    }
    AppMethodBeat.o(217391);
    return i;
  }
  
  public static double getFileOrFilesSize(String paramString)
  {
    AppMethodBeat.i(217264);
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
      finally
      {
        long l2;
        label32:
        double d;
        label50:
        break label32;
      }
      d = l1 / 1024L / 1024L;
      AppMethodBeat.o(217264);
      return d;
      l2 = getFileSize(paramString);
    }
  }
  
  private static long getFileSize(File paramFile)
  {
    AppMethodBeat.i(217275);
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
      finally
      {
        label43:
        label50:
        break label43;
      }
      AppMethodBeat.o(217275);
      return l1;
      l1 = l2;
      paramFile.createNewFile();
    }
  }
  
  private static long getFileSizes(File paramFile)
  {
    AppMethodBeat.i(217285);
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
    AppMethodBeat.o(217285);
    return l;
  }
  
  public static String getLastLogFileName(String paramString)
  {
    AppMethodBeat.i(217328);
    paramString = getLogFiles(paramString, getToday());
    if (paramString.size() > 0)
    {
      paramString = ((File)paramString.get(paramString.size() - 1)).getName();
      AppMethodBeat.o(217328);
      return paramString;
    }
    AppMethodBeat.o(217328);
    return "";
  }
  
  public static ArrayList<File> getLogFiles(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217341);
    paramString1 = new File(paramString1);
    if (paramString1.isDirectory())
    {
      paramString1 = paramString1.listFiles(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          AppMethodBeat.i(217271);
          boolean bool = paramAnonymousString.startsWith(this.val$prefix);
          AppMethodBeat.o(217271);
          return bool;
        }
      });
      Arrays.sort(paramString1, new Comparator()
      {
        private int extractNumber(String paramAnonymousString)
        {
          AppMethodBeat.i(217277);
          try
          {
            i = Integer.parseInt(paramAnonymousString.substring(paramAnonymousString.indexOf('_') + 1, paramAnonymousString.lastIndexOf('.')));
            AppMethodBeat.o(217277);
            return i;
          }
          finally
          {
            for (;;)
            {
              int i = 0;
            }
          }
        }
        
        public final int compare(File paramAnonymousFile1, File paramAnonymousFile2)
        {
          AppMethodBeat.i(217283);
          int i = extractNumber(paramAnonymousFile1.getName());
          int j = extractNumber(paramAnonymousFile2.getName());
          AppMethodBeat.o(217283);
          return i - j;
        }
      });
      paramString1 = new ArrayList(Arrays.asList(paramString1));
      AppMethodBeat.o(217341);
      return paramString1;
    }
    paramString1 = new ArrayList();
    AppMethodBeat.o(217341);
    return paramString1;
  }
  
  public static double getSDCardSpace()
  {
    AppMethodBeat.i(217298);
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      l = localStatFs.getBlockSize();
      l = localStatFs.getAvailableBlocks() * l / 1024L / 1024L;
      double d = l;
      AppMethodBeat.o(217298);
      return d;
    }
    finally
    {
      for (;;)
      {
        new StringBuilder("getSDCardSpace: ").append(localObject.toString());
        long l = 0L;
      }
    }
  }
  
  public static String getToday()
  {
    AppMethodBeat.i(217350);
    String str = new SimpleDateFormat("yyyyMMdd", Locale.CHINA).format(new Date(System.currentTimeMillis()));
    AppMethodBeat.o(217350);
    return str;
  }
  
  public static boolean initLogDir(String paramString)
  {
    AppMethodBeat.i(217371);
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
      {
        boolean bool = localFile.mkdirs();
        AppMethodBeat.o(217371);
        return bool;
      }
      deleteFileUpMaxInDir(paramString, maxLogFileSizeMB, maxDirSizeMB, maxLogKeepDays);
      deleteOldFileToday(paramString, maxLogFileNum);
      AppMethodBeat.o(217371);
      return true;
    }
    finally
    {
      new StringBuilder("init log dir error: ").append(paramString.toString());
      AppMethodBeat.o(217371);
    }
    return false;
  }
  
  public static boolean isDebugMode(String paramString)
  {
    AppMethodBeat.i(217380);
    boolean bool = new File(paramString + "MidasLogDebug.ini").exists();
    AppMethodBeat.o(217380);
    return bool;
  }
  
  public static void readLogKeepConf(Context paramContext)
  {
    AppMethodBeat.i(217401);
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
      AppMethodBeat.o(217401);
      return;
      i = 1;
      break;
      i = 2;
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.midas.comm.log.util.APLogFileUtil
 * JD-Core Version:    0.7.0.1
 */