package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a
{
  private static final String zx = "code_cache" + File.separator + "secondary-dexes";
  private static final Set<String> zy = new HashSet();
  private static final boolean zz = o(System.getProperty("java.vm.version"));
  
  public static void K(Context paramContext)
  {
    if (zz) {}
    ApplicationInfo localApplicationInfo;
    Object localObject;
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 4) {
        throw new RuntimeException("Multi dex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
      }
      try
      {
        localApplicationInfo = L(paramContext);
        if (localApplicationInfo != null)
        {
          synchronized (zy)
          {
            localObject = localApplicationInfo.sourceDir;
            if (zy.contains(localObject)) {
              return;
            }
          }
          zy.add(localObject);
        }
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Multi dex installation failed (" + paramContext.getMessage() + ").");
      }
    }
    if (Build.VERSION.SDK_INT > 20) {
      new StringBuilder("MultiDex is not guaranteed to work in SDK version ").append(Build.VERSION.SDK_INT).append(": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"").append(System.getProperty("java.vm.version")).append("\"");
    }
    try
    {
      localObject = paramContext.getClassLoader();
      if (localObject == null) {
        return;
      }
    }
    catch (RuntimeException paramContext)
    {
      return;
    }
    try
    {
      M(paramContext);
      label190:
      File localFile = new File(localApplicationInfo.dataDir, zx);
      List localList = b.a(paramContext, localApplicationInfo, localFile, false);
      if (f(localList)) {
        a((ClassLoader)localObject, localFile, localList);
      }
      for (;;)
      {
        return;
        paramContext = b.a(paramContext, localApplicationInfo, localFile, true);
        if (!f(paramContext)) {
          break;
        }
        a((ClassLoader)localObject, localFile, paramContext);
      }
      throw new RuntimeException("Zip files were not valid.");
    }
    catch (Throwable localThrowable)
    {
      break label190;
    }
  }
  
  private static ApplicationInfo L(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = paramContext.getPackageName();
      if ((localPackageManager == null) || (paramContext == null)) {
        return null;
      }
      return localPackageManager.getApplicationInfo(paramContext, 128);
    }
    catch (RuntimeException paramContext) {}
    return null;
  }
  
  private static void M(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "secondary-dexes");
    File[] arrayOfFile;
    if (paramContext.isDirectory())
    {
      new StringBuilder("Clearing old secondary dex dir (").append(paramContext.getPath()).append(").");
      arrayOfFile = paramContext.listFiles();
      if (arrayOfFile == null) {
        new StringBuilder("Failed to list secondary dex dir content (").append(paramContext.getPath()).append(").");
      }
    }
    else
    {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      new StringBuilder("Trying to delete old file ").append(localFile.getPath()).append(" of size ").append(localFile.length());
      if (!localFile.delete()) {
        new StringBuilder("Failed to delete old file ").append(localFile.getPath());
      }
      for (;;)
      {
        i += 1;
        break;
        new StringBuilder("Deleted old file ").append(localFile.getPath());
      }
    }
    if (!paramContext.delete())
    {
      new StringBuilder("Failed to delete secondary dex dir ").append(paramContext.getPath());
      return;
    }
    new StringBuilder("Deleted old secondary dex dir ").append(paramContext.getPath());
  }
  
  private static void a(ClassLoader paramClassLoader, File paramFile, List<File> paramList)
  {
    if (!paramList.isEmpty())
    {
      if (Build.VERSION.SDK_INT >= 19) {
        b.install(paramClassLoader, paramList, paramFile);
      }
    }
    else {
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a.install(paramClassLoader, paramList, paramFile);
      return;
    }
    c.install(paramClassLoader, paramList);
  }
  
  private static boolean f(List<File> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (!b.l((File)paramList.next())) {
        return false;
      }
    }
    return true;
  }
  
  private static Field findField(Object paramObject, String paramString)
  {
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Field localField = localClass.getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    throw new NoSuchFieldException("Field " + paramString + " not found in " + paramObject.getClass());
  }
  
  private static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Method localMethod = localClass.getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    throw new NoSuchMethodException("Method " + paramString + " with parameters " + Arrays.asList(paramVarArgs) + " not found in " + paramObject.getClass());
  }
  
  private static boolean o(String paramString)
  {
    bool2 = false;
    bool1 = bool2;
    if (paramString != null)
    {
      localObject = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!((Matcher)localObject).matches()) {}
    }
    try
    {
      int i = Integer.parseInt(((Matcher)localObject).group(1));
      int j = Integer.parseInt(((Matcher)localObject).group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j <= 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    Object localObject = new StringBuilder("VM with version ").append(paramString);
    if (bool1) {}
    for (paramString = " has multidex support";; paramString = " does not have multidex support")
    {
      ((StringBuilder)localObject).append(paramString);
      return bool1;
    }
  }
  
  static final class a
  {
    static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    {
      paramClassLoader = a.b(paramClassLoader, "pathList").get(paramClassLoader);
      paramList = new ArrayList(paramList);
      a.a(paramClassLoader, "dexElements", (Object[])a.b(paramClassLoader, "makeDexElements", new Class[] { ArrayList.class, File.class }).invoke(paramClassLoader, new Object[] { paramList, paramFile }));
    }
  }
  
  static final class b
  {
    static void install(ClassLoader paramClassLoader, List<File> paramList, File paramFile)
    {
      Object localObject = a.b(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      paramList = new ArrayList(paramList);
      a.a(localObject, "dexElements", (Object[])a.b(localObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(localObject, new Object[] { paramList, paramFile, localArrayList }));
      if (localArrayList.size() > 0)
      {
        paramList = localArrayList.iterator();
        while (paramList.hasNext()) {
          paramList.next();
        }
        paramFile = a.b(paramClassLoader, "dexElementsSuppressedExceptions");
        localObject = (IOException[])paramFile.get(paramClassLoader);
        if (localObject != null) {
          break label167;
        }
        paramList = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
      }
      for (;;)
      {
        paramFile.set(paramClassLoader, paramList);
        return;
        label167:
        paramList = new IOException[localArrayList.size() + localObject.length];
        localArrayList.toArray(paramList);
        System.arraycopy(localObject, 0, paramList, localArrayList.size(), localObject.length);
      }
    }
  }
  
  static final class c
  {
    static void install(ClassLoader paramClassLoader, List<File> paramList)
    {
      int i = paramList.size();
      Field localField = a.b(paramClassLoader, "path");
      StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      paramList = paramList.listIterator();
      while (paramList.hasNext())
      {
        File localFile = (File)paramList.next();
        String str = localFile.getAbsolutePath();
        localStringBuilder.append(':').append(str);
        i = paramList.previousIndex();
        arrayOfString[i] = str;
        arrayOfFile[i] = localFile;
        arrayOfZipFile[i] = new ZipFile(localFile);
        arrayOfDexFile[i] = DexFile.loadDex(str, str + ".dex", 0);
      }
      localField.set(paramClassLoader, localStringBuilder.toString());
      a.a(paramClassLoader, "mPaths", arrayOfString);
      a.a(paramClassLoader, "mFiles", arrayOfFile);
      a.a(paramClassLoader, "mZips", arrayOfZipFile);
      a.a(paramClassLoader, "mDexs", arrayOfDexFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.multidex.a
 * JD-Core Version:    0.7.0.1
 */