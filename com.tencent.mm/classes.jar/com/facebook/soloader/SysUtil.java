package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class SysUtil
{
  public static int a(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(208100);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if ((paramArrayOfString[i] != null) && (paramString.equals(paramArrayOfString[i])))
      {
        AppMethodBeat.o(208100);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(208100);
    return -1;
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    AppMethodBeat.i(208168);
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {}
    try
    {
      int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      AppMethodBeat.o(208168);
      return i;
    }
    catch (RuntimeException paramContext)
    {
      AppMethodBeat.o(208168);
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label35:
      break label35;
    }
  }
  
  public static String[] getSupportedAbis()
  {
    AppMethodBeat.i(208129);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject = a.getSupportedAbis();
      AppMethodBeat.o(208129);
      return localObject;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = LollipopSysdeps.getSupportedAbis();
      AppMethodBeat.o(208129);
      return localObject;
    }
    Object localObject = Build.CPU_ABI;
    String str = Build.CPU_ABI2;
    AppMethodBeat.o(208129);
    return new String[] { localObject, str };
  }
  
  public static boolean is64Bit()
  {
    boolean bool2 = false;
    AppMethodBeat.i(208178);
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 23) {
      bool1 = Process.is64Bit();
    }
    for (;;)
    {
      AppMethodBeat.o(208178);
      return bool1;
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21) {
        try
        {
          bool1 = LollipopSysdeps.is64Bit();
        }
        catch (Exception localException)
        {
          String.format("Could not read /proc/self/exe. Err msg: %s", new Object[] { localException.getMessage() });
          bool1 = bool2;
        }
      }
    }
  }
  
  private static void u(File paramFile)
  {
    AppMethodBeat.i(208116);
    File localFile = paramFile.getParentFile();
    if ((localFile != null) && (!localFile.canWrite()) && (!localFile.setWritable(true))) {
      new StringBuilder("Enable write permission failed: ").append(localFile);
    }
    if ((!paramFile.delete()) && (paramFile.exists()))
    {
      paramFile = new IOException("Could not delete file ".concat(String.valueOf(paramFile)));
      AppMethodBeat.o(208116);
      throw paramFile;
    }
    AppMethodBeat.o(208116);
  }
  
  public static void v(File paramFile)
  {
    AppMethodBeat.i(208142);
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
      {
        AppMethodBeat.o(208142);
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        v(arrayOfFile[i]);
        i += 1;
      }
    }
    u(paramFile);
    AppMethodBeat.o(208142);
  }
  
  static void w(File paramFile)
  {
    AppMethodBeat.i(208161);
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null)
      {
        paramFile = new IOException("cannot list directory ".concat(String.valueOf(paramFile)));
        AppMethodBeat.o(208161);
        throw paramFile;
      }
      int i = 0;
      while (i < arrayOfFile.length)
      {
        w(arrayOfFile[i]);
        i += 1;
      }
      AppMethodBeat.o(208161);
      return;
    }
    if (!paramFile.getPath().endsWith("_lock"))
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
      try
      {
        localRandomAccessFile.getFD().sync();
        localRandomAccessFile.close();
        AppMethodBeat.o(208161);
        return;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(208161);
          throw paramFile;
        }
        finally {}
      }
      for (;;)
      {
        try
        {
          localRandomAccessFile.close();
          AppMethodBeat.o(208161);
          throw localObject;
        }
        finally
        {
          paramFile.addSuppressed(localThrowable);
        }
        localThrowable.close();
      }
    }
    AppMethodBeat.o(208161);
  }
  
  static final class LollipopSysdeps
  {
    public static void fallocateIfSupported(FileDescriptor paramFileDescriptor, long paramLong)
    {
      AppMethodBeat.i(208159);
      try
      {
        Os.posix_fallocate(paramFileDescriptor, 0L, paramLong);
        AppMethodBeat.o(208159);
        return;
      }
      catch (ErrnoException paramFileDescriptor)
      {
        if ((paramFileDescriptor.errno != OsConstants.EOPNOTSUPP) && (paramFileDescriptor.errno != OsConstants.ENOSYS) && (paramFileDescriptor.errno != OsConstants.EINVAL))
        {
          paramFileDescriptor = new IOException(paramFileDescriptor.toString(), paramFileDescriptor);
          AppMethodBeat.o(208159);
          throw paramFileDescriptor;
        }
        AppMethodBeat.o(208159);
      }
    }
    
    public static String[] getSupportedAbis()
    {
      AppMethodBeat.i(208149);
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      TreeSet localTreeSet = new TreeSet();
      try
      {
        if (is64Bit())
        {
          localTreeSet.add(k.b.cCV.toString());
          localTreeSet.add(k.b.cCU.toString());
        }
        ArrayList localArrayList;
        for (;;)
        {
          localArrayList = new ArrayList();
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            if (localTreeSet.contains(str)) {
              localArrayList.add(str);
            }
            i += 1;
          }
          localTreeSet.add(k.b.cCT.toString());
          localTreeSet.add(k.b.cCS.toString());
        }
        arrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
      }
      catch (ErrnoException localErrnoException)
      {
        String.format("Could not read /proc/self/exe. Falling back to default ABI list: %s. errno: %d Err msg: %s", new Object[] { Arrays.toString(arrayOfString), Integer.valueOf(localErrnoException.errno), localErrnoException.getMessage() });
        arrayOfString = Build.SUPPORTED_ABIS;
        AppMethodBeat.o(208149);
        return arrayOfString;
      }
      AppMethodBeat.o(208149);
      return arrayOfString;
    }
    
    public static boolean is64Bit()
    {
      AppMethodBeat.i(208167);
      boolean bool = Os.readlink("/proc/self/exe").contains("64");
      AppMethodBeat.o(208167);
      return bool;
    }
  }
  
  static final class a
  {
    static boolean aL(Context paramContext)
    {
      AppMethodBeat.i(208155);
      paramContext = new ZipFile(new File(paramContext.getApplicationInfo().sourceDir));
      try
      {
        Enumeration localEnumeration = paramContext.entries();
        while (localEnumeration.hasMoreElements())
        {
          ZipEntry localZipEntry = (ZipEntry)localEnumeration.nextElement();
          if ((localZipEntry != null) && (localZipEntry.getName().endsWith(".so")) && (localZipEntry.getName().contains("/lib")))
          {
            int i = localZipEntry.getMethod();
            if (i == 0) {}
            for (boolean bool = true;; bool = false)
            {
              paramContext.close();
              AppMethodBeat.o(208155);
              return bool;
            }
          }
        }
        paramContext.close();
        AppMethodBeat.o(208155);
        return false;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(208155);
          throw localObject1;
        }
        finally {}
      }
      for (;;)
      {
        try
        {
          paramContext.close();
          AppMethodBeat.o(208155);
          throw localObject2;
        }
        finally
        {
          localObject1.addSuppressed(paramContext);
        }
        paramContext.close();
      }
    }
    
    public static String[] getSupportedAbis()
    {
      AppMethodBeat.i(208137);
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      TreeSet localTreeSet = new TreeSet();
      if (Process.is64Bit())
      {
        localTreeSet.add(k.b.cCV.toString());
        localTreeSet.add(k.b.cCU.toString());
      }
      ArrayList localArrayList;
      for (;;)
      {
        localArrayList = new ArrayList();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (localTreeSet.contains(str)) {
            localArrayList.add(str);
          }
          i += 1;
        }
        localTreeSet.add(k.b.cCT.toString());
        localTreeSet.add(k.b.cCS.toString());
      }
      arrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
      AppMethodBeat.o(208137);
      return arrayOfString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.SysUtil
 * JD-Core Version:    0.7.0.1
 */