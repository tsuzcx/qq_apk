package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
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
  private static final Set<File> acA;
  private static final boolean acB;
  
  static
  {
    AppMethodBeat.i(260790);
    acA = new HashSet();
    acB = Q(System.getProperty("java.vm.version"));
    AppMethodBeat.o(260790);
  }
  
  private static boolean Q(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(260772);
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
      AppMethodBeat.o(260772);
      return bool1;
    }
  }
  
  public static void W(Context paramContext)
  {
    AppMethodBeat.i(260767);
    if (acB)
    {
      AppMethodBeat.o(260767);
      return;
    }
    if (Build.VERSION.SDK_INT < 4)
    {
      paramContext = new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is 4.");
      AppMethodBeat.o(260767);
      throw paramContext;
    }
    try
    {
      ApplicationInfo localApplicationInfo = X(paramContext);
      if (localApplicationInfo == null)
      {
        AppMethodBeat.o(260767);
        return;
      }
      a(paramContext, new File(localApplicationInfo.sourceDir), new File(localApplicationInfo.dataDir), "secondary-dexes", "");
      AppMethodBeat.o(260767);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext = new RuntimeException("MultiDex installation failed (" + paramContext.getMessage() + ").");
      AppMethodBeat.o(260767);
      throw paramContext;
    }
  }
  
  private static ApplicationInfo X(Context paramContext)
  {
    AppMethodBeat.i(260770);
    try
    {
      paramContext = paramContext.getApplicationInfo();
      AppMethodBeat.o(260770);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      AppMethodBeat.o(260770);
    }
    return null;
  }
  
  private static void Y(Context paramContext)
  {
    AppMethodBeat.i(260778);
    paramContext = new File(paramContext.getFilesDir(), "secondary-dexes");
    if (paramContext.isDirectory())
    {
      new StringBuilder("Clearing old secondary dex dir (").append(paramContext.getPath()).append(").");
      File[] arrayOfFile = paramContext.listFiles();
      if (arrayOfFile == null)
      {
        new StringBuilder("Failed to list secondary dex dir content (").append(paramContext.getPath()).append(").");
        AppMethodBeat.o(260778);
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
        AppMethodBeat.o(260778);
        return;
      }
      new StringBuilder("Deleted old secondary dex dir ").append(paramContext.getPath());
    }
    AppMethodBeat.o(260778);
  }
  
  private static File a(Context paramContext, File paramFile, String paramString)
  {
    AppMethodBeat.i(260779);
    paramFile = new File(paramFile, "code_cache");
    try
    {
      n(paramFile);
      paramContext = paramFile;
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        paramContext = new File(paramContext.getFilesDir(), "code_cache");
        n(paramContext);
      }
    }
    paramContext = new File(paramContext, paramString);
    n(paramContext);
    AppMethodBeat.o(260779);
    return paramContext;
  }
  
  /* Error */
  private static void a(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 227
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 43	androidx/multidex/a:acA	Ljava/util/Set;
    //   8: astore 5
    //   10: aload 5
    //   12: monitorenter
    //   13: getstatic 43	androidx/multidex/a:acA	Ljava/util/Set;
    //   16: aload_1
    //   17: invokeinterface 233 2 0
    //   22: ifeq +12 -> 34
    //   25: aload 5
    //   27: monitorexit
    //   28: ldc 227
    //   30: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: getstatic 43	androidx/multidex/a:acA	Ljava/util/Set;
    //   37: aload_1
    //   38: invokeinterface 236 2 0
    //   43: pop
    //   44: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 20
    //   49: if_icmple +37 -> 86
    //   52: new 94	java/lang/StringBuilder
    //   55: dup
    //   56: ldc 238
    //   58: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   61: getstatic 118	android/os/Build$VERSION:SDK_INT	I
    //   64: invokevirtual 125	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc 240
    //   69: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 45
    //   74: invokestatic 51	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   77: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 242
    //   82: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_0
    //   87: invokevirtual 246	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   90: astore 6
    //   92: aload 6
    //   94: ifnonnull +22 -> 116
    //   97: aload 5
    //   99: monitorexit
    //   100: ldc 227
    //   102: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: return
    //   106: astore_0
    //   107: aload 5
    //   109: monitorexit
    //   110: ldc 227
    //   112: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: aload_0
    //   117: invokestatic 248	androidx/multidex/a:Y	(Landroid/content/Context;)V
    //   120: aload_0
    //   121: aload_2
    //   122: aload_3
    //   123: invokestatic 250	androidx/multidex/a:a	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   126: astore_2
    //   127: new 252	androidx/multidex/b
    //   130: dup
    //   131: aload_1
    //   132: aload_2
    //   133: invokespecial 255	androidx/multidex/b:<init>	(Ljava/io/File;Ljava/io/File;)V
    //   136: astore_3
    //   137: aconst_null
    //   138: astore_1
    //   139: aload_3
    //   140: aload_0
    //   141: aload 4
    //   143: iconst_0
    //   144: invokevirtual 258	androidx/multidex/b:a	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   147: astore 7
    //   149: aload 6
    //   151: aload_2
    //   152: aload 7
    //   154: invokestatic 261	androidx/multidex/a:a	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   157: aload_3
    //   158: invokevirtual 264	androidx/multidex/b:close	()V
    //   161: aload_1
    //   162: astore_0
    //   163: aload_0
    //   164: ifnull +52 -> 216
    //   167: ldc 227
    //   169: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   172: aload_0
    //   173: athrow
    //   174: astore_0
    //   175: aload 5
    //   177: monitorexit
    //   178: ldc 227
    //   180: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_0
    //   184: athrow
    //   185: astore 7
    //   187: aload 6
    //   189: aload_2
    //   190: aload_3
    //   191: aload_0
    //   192: aload 4
    //   194: iconst_1
    //   195: invokevirtual 258	androidx/multidex/b:a	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   198: invokestatic 261	androidx/multidex/a:a	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   201: goto -44 -> 157
    //   204: astore_0
    //   205: aload_3
    //   206: invokevirtual 264	androidx/multidex/b:close	()V
    //   209: ldc 227
    //   211: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_0
    //   215: athrow
    //   216: aload 5
    //   218: monitorexit
    //   219: ldc 227
    //   221: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: return
    //   225: astore 7
    //   227: goto -107 -> 120
    //   230: astore_0
    //   231: goto -68 -> 163
    //   234: astore_1
    //   235: goto -26 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramContext	Context
    //   0	238	1	paramFile1	File
    //   0	238	2	paramFile2	File
    //   0	238	3	paramString1	String
    //   0	238	4	paramString2	String
    //   8	209	5	localSet	Set
    //   90	98	6	localClassLoader	ClassLoader
    //   147	6	7	localList	List
    //   185	1	7	localIOException	IOException
    //   225	1	7	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   86	92	106	java/lang/RuntimeException
    //   13	28	174	finally
    //   34	86	174	finally
    //   86	92	174	finally
    //   107	110	174	finally
    //   116	120	174	finally
    //   120	137	174	finally
    //   157	161	174	finally
    //   167	174	174	finally
    //   205	209	174	finally
    //   209	216	174	finally
    //   216	219	174	finally
    //   149	157	185	java/io/IOException
    //   139	149	204	finally
    //   149	157	204	finally
    //   187	201	204	finally
    //   116	120	225	java/lang/Throwable
    //   157	161	230	java/io/IOException
    //   205	209	234	java/io/IOException
  }
  
  private static void a(ClassLoader paramClassLoader, File paramFile, List<? extends File> paramList)
  {
    AppMethodBeat.i(260774);
    if (!paramList.isEmpty())
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        b.install(paramClassLoader, paramList, paramFile);
        AppMethodBeat.o(260774);
        return;
      }
      if (Build.VERSION.SDK_INT >= 14)
      {
        a.install(paramClassLoader, paramList);
        AppMethodBeat.o(260774);
        return;
      }
      c.install(paramClassLoader, paramList);
    }
    AppMethodBeat.o(260774);
  }
  
  private static Field findField(Object paramObject, String paramString)
  {
    AppMethodBeat.i(260776);
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Field localField = localClass.getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        AppMethodBeat.o(260776);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    paramObject = new NoSuchFieldException("Field " + paramString + " not found in " + paramObject.getClass());
    AppMethodBeat.o(260776);
    throw paramObject;
  }
  
  private static Method findMethod(Object paramObject, String paramString, Class<?>... paramVarArgs)
  {
    AppMethodBeat.i(260777);
    Class localClass = paramObject.getClass();
    while (localClass != null) {
      try
      {
        Method localMethod = localClass.getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        AppMethodBeat.o(260777);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    paramObject = new NoSuchMethodException("Method " + paramString + " with parameters " + Arrays.asList(paramVarArgs) + " not found in " + paramObject.getClass());
    AppMethodBeat.o(260777);
    throw paramObject;
  }
  
  private static void n(File paramFile)
  {
    AppMethodBeat.i(260781);
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      File localFile = paramFile.getParentFile();
      if (localFile == null) {
        new StringBuilder("Failed to create dir ").append(paramFile.getPath()).append(". Parent file is null.");
      }
      for (;;)
      {
        paramFile = new IOException("Failed to create directory " + paramFile.getPath());
        AppMethodBeat.o(260781);
        throw paramFile;
        new StringBuilder("Failed to create dir ").append(paramFile.getPath()).append(". parent file is a dir ").append(localFile.isDirectory()).append(", a file ").append(localFile.isFile()).append(", exists ").append(localFile.exists()).append(", readable ").append(localFile.canRead()).append(", writable ").append(localFile.canWrite());
      }
    }
    AppMethodBeat.o(260781);
  }
  
  static final class a
  {
    private static final int acC = 4;
    private final a acD;
    
    private a()
    {
      AppMethodBeat.i(260732);
      Class localClass = Class.forName("dalvik.system.DexPathList$Element");
      try
      {
        b localb = new b(localClass);
        this.acD = localb;
        AppMethodBeat.o(260732);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        for (;;)
        {
          try
          {
            c localc = new c(localClass);
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            d locald = new d(localClass);
          }
        }
      }
    }
    
    static void install(ClassLoader paramClassLoader, List<? extends File> paramList)
    {
      AppMethodBeat.i(260730);
      paramClassLoader = a.b(paramClassLoader, "pathList").get(paramClassLoader);
      a locala = new a();
      Object[] arrayOfObject = new Object[paramList.size()];
      int i = 0;
      while (i < arrayOfObject.length)
      {
        File localFile1 = (File)paramList.get(i);
        a locala1 = locala.acD;
        String str1 = localFile1.getPath();
        File localFile2 = localFile1.getParentFile();
        String str2 = localFile1.getName();
        arrayOfObject[i] = locala1.a(localFile1, DexFile.loadDex(str1, new File(localFile2, str2.substring(0, str2.length() - acC) + ".dex").getPath(), 0));
        i += 1;
      }
      try
      {
        a.a(paramClassLoader, "dexElements", arrayOfObject);
        AppMethodBeat.o(260730);
        return;
      }
      catch (NoSuchFieldException paramList)
      {
        a.a(paramClassLoader, "pathElements", arrayOfObject);
        AppMethodBeat.o(260730);
      }
    }
    
    static abstract interface a
    {
      public abstract Object a(File paramFile, DexFile paramDexFile);
    }
    
    static final class b
      implements a.a.a
    {
      private final Constructor<?> acE;
      
      b(Class<?> paramClass)
      {
        AppMethodBeat.i(260751);
        this.acE = paramClass.getConstructor(new Class[] { File.class, ZipFile.class, DexFile.class });
        this.acE.setAccessible(true);
        AppMethodBeat.o(260751);
      }
      
      public final Object a(File paramFile, DexFile paramDexFile)
      {
        AppMethodBeat.i(260754);
        paramFile = this.acE.newInstance(new Object[] { paramFile, new ZipFile(paramFile), paramDexFile });
        AppMethodBeat.o(260754);
        return paramFile;
      }
    }
    
    static final class c
      implements a.a.a
    {
      private final Constructor<?> acE;
      
      c(Class<?> paramClass)
      {
        AppMethodBeat.i(260802);
        this.acE = paramClass.getConstructor(new Class[] { File.class, File.class, DexFile.class });
        this.acE.setAccessible(true);
        AppMethodBeat.o(260802);
      }
      
      public final Object a(File paramFile, DexFile paramDexFile)
      {
        AppMethodBeat.i(260803);
        paramFile = this.acE.newInstance(new Object[] { paramFile, paramFile, paramDexFile });
        AppMethodBeat.o(260803);
        return paramFile;
      }
    }
    
    static final class d
      implements a.a.a
    {
      private final Constructor<?> acE;
      
      d(Class<?> paramClass)
      {
        AppMethodBeat.i(260794);
        this.acE = paramClass.getConstructor(new Class[] { File.class, Boolean.TYPE, File.class, DexFile.class });
        this.acE.setAccessible(true);
        AppMethodBeat.o(260794);
      }
      
      public final Object a(File paramFile, DexFile paramDexFile)
      {
        AppMethodBeat.i(260795);
        paramFile = this.acE.newInstance(new Object[] { paramFile, Boolean.FALSE, paramFile, paramDexFile });
        AppMethodBeat.o(260795);
        return paramFile;
      }
    }
  }
  
  static final class b
  {
    static void install(ClassLoader paramClassLoader, List<? extends File> paramList, File paramFile)
    {
      AppMethodBeat.i(260743);
      Object localObject = a.b(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      a.a(localObject, "dexElements", makeDexElements(localObject, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        paramClassLoader = localArrayList.iterator();
        while (paramClassLoader.hasNext()) {
          paramClassLoader.next();
        }
        paramList = a.b(localObject, "dexElementsSuppressedExceptions");
        paramFile = (IOException[])paramList.get(localObject);
        if (paramFile == null) {
          paramClassLoader = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]);
        }
        for (;;)
        {
          paramList.set(localObject, paramClassLoader);
          paramClassLoader = new IOException("I/O exception during makeDexElement");
          paramClassLoader.initCause((Throwable)localArrayList.get(0));
          AppMethodBeat.o(260743);
          throw paramClassLoader;
          paramClassLoader = new IOException[localArrayList.size() + paramFile.length];
          localArrayList.toArray(paramClassLoader);
          System.arraycopy(paramFile, 0, paramClassLoader, localArrayList.size(), paramFile.length);
        }
      }
      AppMethodBeat.o(260743);
    }
    
    private static Object[] makeDexElements(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
    {
      AppMethodBeat.i(260745);
      paramObject = (Object[])a.b(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
      AppMethodBeat.o(260745);
      return paramObject;
    }
  }
  
  static final class c
  {
    static void install(ClassLoader paramClassLoader, List<? extends File> paramList)
    {
      AppMethodBeat.i(260762);
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
      AppMethodBeat.o(260762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.multidex.a
 * JD-Core Version:    0.7.0.1
 */