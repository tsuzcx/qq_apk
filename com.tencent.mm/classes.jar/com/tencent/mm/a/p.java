package com.tencent.mm.a;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipOutputStream;

public final class p
{
  /* Error */
  private static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    // Byte code:
    //   0: new 10	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   7: aload_2
    //   8: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11: astore 5
    //   13: aload_2
    //   14: invokevirtual 24	java/lang/String:trim	()Ljava/lang/String;
    //   17: invokevirtual 28	java/lang/String:length	()I
    //   20: ifne +64 -> 84
    //   23: ldc 30
    //   25: astore_2
    //   26: aload 5
    //   28: aload_2
    //   29: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_0
    //   33: invokevirtual 35	java/io/File:getName	()Ljava/lang/String;
    //   36: invokevirtual 18	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 5
    //   44: aload_0
    //   45: invokevirtual 42	java/io/File:isDirectory	()Z
    //   48: ifeq +43 -> 91
    //   51: aload_0
    //   52: invokevirtual 46	java/io/File:listFiles	()[Ljava/io/File;
    //   55: astore_0
    //   56: aload_0
    //   57: arraylength
    //   58: istore 4
    //   60: iconst_0
    //   61: istore_3
    //   62: iload_3
    //   63: iload 4
    //   65: if_icmpge +125 -> 190
    //   68: aload_0
    //   69: iload_3
    //   70: aaload
    //   71: aload_1
    //   72: aload 5
    //   74: invokestatic 48	com/tencent/mm/a/p:a	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   77: iload_3
    //   78: iconst_1
    //   79: iadd
    //   80: istore_3
    //   81: goto -19 -> 62
    //   84: getstatic 52	java/io/File:separator	Ljava/lang/String;
    //   87: astore_2
    //   88: goto -62 -> 26
    //   91: ldc 53
    //   93: newarray byte
    //   95: astore 6
    //   97: new 55	java/io/BufferedInputStream
    //   100: dup
    //   101: new 57	java/io/FileInputStream
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: ldc 53
    //   111: invokespecial 63	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   114: astore_2
    //   115: aload_2
    //   116: astore_0
    //   117: aload_1
    //   118: new 65	java/util/zip/ZipEntry
    //   121: dup
    //   122: aload 5
    //   124: invokespecial 68	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   127: invokevirtual 74	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   130: aload_2
    //   131: astore_0
    //   132: aload_2
    //   133: aload 6
    //   135: invokevirtual 78	java/io/BufferedInputStream:read	([B)I
    //   138: istore_3
    //   139: iload_3
    //   140: iconst_m1
    //   141: if_icmpeq +50 -> 191
    //   144: aload_2
    //   145: astore_0
    //   146: aload_1
    //   147: aload 6
    //   149: iconst_0
    //   150: iload_3
    //   151: invokevirtual 82	java/util/zip/ZipOutputStream:write	([BII)V
    //   154: goto -24 -> 130
    //   157: astore 5
    //   159: aload_2
    //   160: astore_0
    //   161: ldc 84
    //   163: aload 5
    //   165: ldc 30
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 90	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 93	java/io/BufferedInputStream:close	()V
    //   182: aload_1
    //   183: invokevirtual 96	java/util/zip/ZipOutputStream:flush	()V
    //   186: aload_1
    //   187: invokevirtual 99	java/util/zip/ZipOutputStream:closeEntry	()V
    //   190: return
    //   191: aload_2
    //   192: invokevirtual 93	java/io/BufferedInputStream:close	()V
    //   195: goto -13 -> 182
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 93	java/io/BufferedInputStream:close	()V
    //   209: aload_1
    //   210: athrow
    //   211: astore_1
    //   212: goto -11 -> 201
    //   215: astore 5
    //   217: aconst_null
    //   218: astore_2
    //   219: goto -60 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramFile	File
    //   0	222	1	paramZipOutputStream	ZipOutputStream
    //   0	222	2	paramString	String
    //   61	90	3	i	int
    //   58	8	4	j	int
    //   11	112	5	localObject	Object
    //   157	7	5	localException1	Exception
    //   215	1	5	localException2	Exception
    //   95	53	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   117	130	157	java/lang/Exception
    //   132	139	157	java/lang/Exception
    //   146	154	157	java/lang/Exception
    //   97	115	198	finally
    //   117	130	211	finally
    //   132	139	211	finally
    //   146	154	211	finally
    //   161	174	211	finally
    //   97	115	215	java/lang/Exception
  }
  
  public static void a(Collection<File> paramCollection, File paramFile)
  {
    paramFile = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(paramFile), 131072));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      File localFile = (File)paramCollection.next();
      if (localFile.exists()) {
        a(localFile, paramFile, "");
      }
    }
    paramFile.close();
  }
  
  public static String b(File paramFile, boolean paramBoolean, String paramString)
  {
    int j = 0;
    Object localObject;
    if (paramString != null)
    {
      localObject = new File(paramString).getParentFile();
      if ((localObject != null) && (!((File)localObject).exists())) {
        ((File)localObject).mkdirs();
      }
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      if (localObject == null) {
        return null;
      }
      i = 0;
      while (i < localObject.length)
      {
        localArrayList.add(localObject[i]);
        i += 1;
      }
      localObject = paramString;
      if (paramString == null) {
        localObject = paramFile.getAbsolutePath() + File.separator + paramFile.getName() + ".zip";
      }
    }
    for (;;)
    {
      paramFile = new File((String)localObject);
      if (paramFile.exists()) {
        paramFile.delete();
      }
      try
      {
        a(localArrayList, paramFile);
        if (paramBoolean)
        {
          i = j;
          for (;;)
          {
            if (i < localArrayList.size())
            {
              ((File)localArrayList.get(i)).delete();
              i += 1;
              continue;
              localArrayList.add(paramFile);
              localObject = paramString;
              if (paramString != null) {
                break;
              }
              localObject = paramFile.getAbsoluteFile().getParentFile().getAbsolutePath() + File.separator + paramFile.getName() + ".zip";
            }
          }
        }
      }
      catch (Exception paramFile)
      {
        return null;
      }
    }
    return paramFile.getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.a.p
 * JD-Core Version:    0.7.0.1
 */