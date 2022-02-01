package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

final class b
  implements Closeable
{
  private final File bKo;
  private final long bKp;
  private final File bKq;
  private final RandomAccessFile bKr;
  private final FileChannel bKs;
  private final FileLock bKt;
  
  /* Error */
  b(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 33	java/lang/Object:<init>	()V
    //   4: ldc 34
    //   6: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: new 42	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 44
    //   15: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   22: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 59
    //   27: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_2
    //   31: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   34: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 61
    //   39: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_0
    //   44: aload_1
    //   45: putfield 63	androidx/multidex/b:bKo	Ljava/io/File;
    //   48: aload_0
    //   49: aload_2
    //   50: putfield 65	androidx/multidex/b:bKq	Ljava/io/File;
    //   53: aload_0
    //   54: aload_1
    //   55: invokestatic 69	androidx/multidex/b:p	(Ljava/io/File;)J
    //   58: putfield 71	androidx/multidex/b:bKp	J
    //   61: new 49	java/io/File
    //   64: dup
    //   65: aload_2
    //   66: ldc 73
    //   68: invokespecial 76	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_1
    //   72: aload_0
    //   73: new 78	java/io/RandomAccessFile
    //   76: dup
    //   77: aload_1
    //   78: ldc 80
    //   80: invokespecial 81	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   83: putfield 83	androidx/multidex/b:bKr	Ljava/io/RandomAccessFile;
    //   86: aload_0
    //   87: aload_0
    //   88: getfield 83	androidx/multidex/b:bKr	Ljava/io/RandomAccessFile;
    //   91: invokevirtual 87	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   94: putfield 89	androidx/multidex/b:bKs	Ljava/nio/channels/FileChannel;
    //   97: new 42	java/lang/StringBuilder
    //   100: dup
    //   101: ldc 91
    //   103: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: aload_1
    //   107: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   110: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 89	androidx/multidex/b:bKs	Ljava/nio/channels/FileChannel;
    //   119: invokevirtual 97	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   122: putfield 99	androidx/multidex/b:bKt	Ljava/nio/channels/FileLock;
    //   125: new 42	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   132: aload_1
    //   133: invokevirtual 53	java/io/File:getPath	()Ljava/lang/String;
    //   136: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc 102
    //   141: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: ldc 34
    //   147: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore_1
    //   152: aload_0
    //   153: getfield 89	androidx/multidex/b:bKs	Ljava/nio/channels/FileChannel;
    //   156: invokestatic 109	androidx/multidex/b:closeQuietly	(Ljava/io/Closeable;)V
    //   159: ldc 34
    //   161: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: aload_1
    //   165: athrow
    //   166: astore_1
    //   167: aload_0
    //   168: getfield 83	androidx/multidex/b:bKr	Ljava/io/RandomAccessFile;
    //   171: invokestatic 109	androidx/multidex/b:closeQuietly	(Ljava/io/Closeable;)V
    //   174: ldc 34
    //   176: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: goto -15 -> 167
    //   185: astore_1
    //   186: goto -19 -> 167
    //   189: astore_1
    //   190: goto -38 -> 152
    //   193: astore_1
    //   194: goto -42 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	b
    //   0	197	1	paramFile1	File
    //   0	197	2	paramFile2	File
    // Exception table:
    //   from	to	target	type
    //   97	125	151	java/lang/RuntimeException
    //   86	97	166	java/io/IOException
    //   125	145	166	java/io/IOException
    //   152	166	166	java/io/IOException
    //   86	97	181	java/lang/RuntimeException
    //   125	145	181	java/lang/RuntimeException
    //   152	166	181	java/lang/RuntimeException
    //   86	97	185	java/lang/Error
    //   125	145	185	java/lang/Error
    //   152	166	185	java/lang/Error
    //   97	125	189	java/lang/Error
    //   97	125	193	java/io/IOException
  }
  
  private List<a> HA()
  {
    AppMethodBeat.i(201202);
    String str3 = this.bKo.getName() + ".classes";
    HB();
    localArrayList = new ArrayList();
    localZipFile = new ZipFile(this.bKo);
    try
    {
      localObject1 = localZipFile.getEntry("classes2.dex");
      k = 2;
    }
    finally
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          int k;
          String str1;
          a locala;
          int i;
          int j;
          label325:
          localZipFile.close();
          AppMethodBeat.o(201202);
          throw localObject2;
          k += 1;
          ZipEntry localZipEntry = localZipFile.getEntry("classes" + k + ".dex");
          continue;
          try
          {
            localZipFile.close();
            AppMethodBeat.o(201202);
            return localArrayList;
          }
          catch (IOException localIOException1)
          {
            continue;
          }
        }
        catch (IOException localIOException3)
        {
          continue;
        }
        continue;
        String str2 = "failed";
      }
    }
    if (localObject1 != null)
    {
      str1 = str3 + k + ".zip";
      locala = new a(this.bKq, str1);
      localArrayList.add(locala);
      new StringBuilder("Extraction is needed for file ").append(locala);
      i = 0;
      j = 0;
      for (;;)
      {
        if ((j >= 3) || (i != 0)) {
          break label325;
        }
        j += 1;
        a(localZipFile, (ZipEntry)localObject1, locala, str3);
        try
        {
          locala.crc = p(locala);
          i = 1;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            StringBuilder localStringBuilder;
            new StringBuilder("Failed to read crc from ").append(locala.getAbsolutePath());
            i = 0;
          }
        }
        localStringBuilder = new StringBuilder("Extraction ");
        if (i == 0) {
          break label456;
        }
        str1 = "succeeded";
        localStringBuilder.append(str1).append(" '").append(locala.getAbsolutePath()).append("': length ").append(locala.length()).append(" - crc: ").append(locala.crc);
        if (i != 0) {
          break label453;
        }
        locala.delete();
        if (!locala.exists()) {
          break label453;
        }
        new StringBuilder("Failed to delete corrupted secondary dex '").append(locala.getPath()).append("'");
      }
      if (i == 0)
      {
        localObject1 = new IOException("Could not create zip file " + locala.getAbsolutePath() + " for secondary dex (" + k + ")");
        AppMethodBeat.o(201202);
        throw ((Throwable)localObject1);
      }
    }
  }
  
  private void HB()
  {
    AppMethodBeat.i(201235);
    File[] arrayOfFile = this.bKq.listFiles(new FileFilter()
    {
      public final boolean accept(File paramAnonymousFile)
      {
        AppMethodBeat.i(201167);
        if (!paramAnonymousFile.getName().equals("MultiDex.lock"))
        {
          AppMethodBeat.o(201167);
          return true;
        }
        AppMethodBeat.o(201167);
        return false;
      }
    });
    if (arrayOfFile == null)
    {
      new StringBuilder("Failed to list secondary dex dir content (").append(this.bKq.getPath()).append(").");
      AppMethodBeat.o(201235);
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
    AppMethodBeat.o(201235);
  }
  
  private static void a(Context paramContext, String paramString, long paramLong1, long paramLong2, List<a> paramList)
  {
    AppMethodBeat.i(201213);
    paramContext = ao(paramContext).edit();
    paramContext.putLong(paramString + "timestamp", paramLong1);
    paramContext.putLong(paramString + "crc", paramLong2);
    paramContext.putInt(paramString + "dex.number", paramList.size() + 1);
    paramList = paramList.iterator();
    int i = 2;
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      paramContext.putLong(paramString + "dex.crc." + i, locala.crc);
      paramContext.putLong(paramString + "dex.time." + i, locala.lastModified());
      i += 1;
    }
    paramContext.commit();
    AppMethodBeat.o(201213);
  }
  
  private static void a(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
  {
    AppMethodBeat.i(201249);
    paramZipFile = paramZipFile.getInputStream(paramZipEntry);
    paramString = File.createTempFile("tmp-".concat(String.valueOf(paramString)), ".zip", paramFile.getParentFile());
    new StringBuilder("Extracting ").append(paramString.getPath());
    try
    {
      ZipOutputStream localZipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramString)));
      ZipEntry localZipEntry;
      int i;
      new StringBuilder("Renaming to ").append(paramFile.getPath());
    }
    finally
    {
      try
      {
        localZipEntry = new ZipEntry("classes.dex");
        localZipEntry.setTime(paramZipEntry.getTime());
        localZipOutputStream.putNextEntry(localZipEntry);
        paramZipEntry = new byte[16384];
        for (i = paramZipFile.read(paramZipEntry); i != -1; i = paramZipFile.read(paramZipEntry)) {
          localZipOutputStream.write(paramZipEntry, 0, i);
        }
        localZipOutputStream.closeEntry();
        localZipOutputStream.close();
        if (paramString.setReadOnly()) {
          break label244;
        }
        paramZipEntry = new IOException("Failed to mark readonly \"" + paramString.getAbsolutePath() + "\" (tmp of \"" + paramFile.getAbsolutePath() + "\")");
        AppMethodBeat.o(201249);
        throw paramZipEntry;
      }
      finally
      {
        localZipOutputStream.close();
        AppMethodBeat.o(201249);
      }
      paramZipEntry = finally;
      closeQuietly(paramZipFile);
      paramString.delete();
      AppMethodBeat.o(201249);
    }
    label244:
    if (!paramString.renameTo(paramFile))
    {
      paramZipEntry = new IOException("Failed to rename \"" + paramString.getAbsolutePath() + "\" to \"" + paramFile.getAbsolutePath() + "\"");
      AppMethodBeat.o(201249);
      throw paramZipEntry;
    }
    closeQuietly(paramZipFile);
    paramString.delete();
    AppMethodBeat.o(201249);
  }
  
  private static SharedPreferences ao(Context paramContext)
  {
    AppMethodBeat.i(201221);
    if (Build.VERSION.SDK_INT < 11) {}
    for (int i = 0;; i = 4)
    {
      paramContext = paramContext.getSharedPreferences("multidex.version", i);
      AppMethodBeat.o(201221);
      return paramContext;
    }
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    AppMethodBeat.i(201259);
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(201259);
      return;
    }
    catch (IOException paramCloseable)
    {
      AppMethodBeat.o(201259);
    }
  }
  
  private List<a> k(Context paramContext, String paramString)
  {
    AppMethodBeat.i(201170);
    String str = this.bKo.getName() + ".classes";
    paramContext = ao(paramContext);
    int j = paramContext.getInt(paramString + "dex.number", 1);
    ArrayList localArrayList = new ArrayList(j - 1);
    int i = 2;
    while (i <= j)
    {
      Object localObject = str + i + ".zip";
      localObject = new a(this.bKq, (String)localObject);
      if (((a)localObject).isFile())
      {
        ((a)localObject).crc = p((File)localObject);
        long l1 = paramContext.getLong(paramString + "dex.crc." + i, -1L);
        long l2 = paramContext.getLong(paramString + "dex.time." + i, -1L);
        long l3 = ((a)localObject).lastModified();
        if ((l2 != l3) || (l1 != ((a)localObject).crc))
        {
          paramContext = new IOException("Invalid extracted dex: " + localObject + " (key \"" + paramString + "\"), expected modification time: " + l2 + ", modification time: " + l3 + ", expected crc: " + l1 + ", file crc: " + ((a)localObject).crc);
          AppMethodBeat.o(201170);
          throw paramContext;
        }
        localArrayList.add(localObject);
        i += 1;
      }
      else
      {
        paramContext = new IOException("Missing extracted secondary dex file '" + ((a)localObject).getPath() + "'");
        AppMethodBeat.o(201170);
        throw paramContext;
      }
    }
    AppMethodBeat.o(201170);
    return localArrayList;
  }
  
  private static long o(File paramFile)
  {
    AppMethodBeat.i(201178);
    long l2 = paramFile.lastModified();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    AppMethodBeat.o(201178);
    return l1;
  }
  
  private static long p(File paramFile)
  {
    AppMethodBeat.i(201188);
    long l2 = c.p(paramFile);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    AppMethodBeat.o(201188);
    return l1;
  }
  
  final List<? extends File> a(Context paramContext, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(201272);
    new StringBuilder("MultiDexExtractor.load(").append(this.bKo.getPath()).append(", ").append(paramBoolean).append(", ").append(paramString).append(")");
    if (!this.bKt.isValid())
    {
      paramContext = new IllegalStateException("MultiDexExtractor was closed");
      AppMethodBeat.o(201272);
      throw paramContext;
    }
    Object localObject;
    int i;
    if (!paramBoolean)
    {
      localObject = this.bKo;
      long l = this.bKp;
      SharedPreferences localSharedPreferences = ao(paramContext);
      if ((localSharedPreferences.getLong(paramString + "timestamp", -1L) != o((File)localObject)) || (localSharedPreferences.getLong(paramString + "crc", -1L) != l))
      {
        i = 1;
        if (i != 0) {
          break label235;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = k(paramContext, paramString);
        paramContext = (Context)localObject;
        new StringBuilder("load found ").append(paramContext.size()).append(" secondary dex files");
        AppMethodBeat.o(201272);
        return paramContext;
      }
      catch (IOException localIOException) {}
      i = 0;
      break;
      label235:
      List localList = HA();
      a(paramContext, paramString, o(this.bKo), this.bKp, localList);
      paramContext = localList;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(201280);
    this.bKt.release();
    this.bKs.close();
    this.bKr.close();
    AppMethodBeat.o(201280);
  }
  
  static final class a
    extends File
  {
    public long crc = -1L;
    
    public a(File paramFile, String paramString)
    {
      super(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.multidex.b
 * JD-Core Version:    0.7.0.1
 */