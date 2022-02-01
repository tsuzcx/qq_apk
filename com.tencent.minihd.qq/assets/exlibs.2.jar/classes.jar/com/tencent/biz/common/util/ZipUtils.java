package com.tencent.biz.common.util;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipUtils
{
  protected static final int a = 1048576;
  
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 27	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +40 -> 43
    //   6: ldc 29
    //   8: iconst_4
    //   9: new 31	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   16: ldc 34
    //   18: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 44	java/lang/String:toString	()Ljava/lang/String;
    //   25: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 46
    //   30: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: new 53	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 5
    //   53: aload 5
    //   55: invokevirtual 59	java/io/File:exists	()Z
    //   58: ifne +9 -> 67
    //   61: aload 5
    //   63: invokevirtual 62	java/io/File:mkdirs	()Z
    //   66: pop
    //   67: new 53	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_0
    //   76: new 64	java/util/zip/ZipFile
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 67	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 71	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   89: astore 5
    //   91: aload 5
    //   93: invokeinterface 76 1 0
    //   98: ifeq +466 -> 564
    //   101: aload 5
    //   103: invokeinterface 80 1 0
    //   108: checkcast 82	java/util/zip/ZipEntry
    //   111: astore 6
    //   113: aload 6
    //   115: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   118: ifnull -27 -> 91
    //   121: aload 6
    //   123: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   126: ldc 87
    //   128: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   131: ifne -40 -> 91
    //   134: aload 6
    //   136: invokevirtual 94	java/util/zip/ZipEntry:isDirectory	()Z
    //   139: ifeq +137 -> 276
    //   142: aload 6
    //   144: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   147: astore 6
    //   149: new 53	java/io/File
    //   152: dup
    //   153: new 31	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   160: aload_1
    //   161: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: getstatic 98	java/io/File:separator	Ljava/lang/String;
    //   167: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload 6
    //   172: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: astore 6
    //   183: aload 6
    //   185: invokevirtual 59	java/io/File:exists	()Z
    //   188: ifne -97 -> 91
    //   191: aload 6
    //   193: invokevirtual 62	java/io/File:mkdirs	()Z
    //   196: pop
    //   197: goto -106 -> 91
    //   200: astore_1
    //   201: aload_1
    //   202: invokevirtual 101	java/io/FileNotFoundException:printStackTrace	()V
    //   205: iconst_5
    //   206: istore_2
    //   207: aload_0
    //   208: invokevirtual 104	java/util/zip/ZipFile:close	()V
    //   211: iload_2
    //   212: ireturn
    //   213: astore_0
    //   214: aload_0
    //   215: invokevirtual 105	java/util/zip/ZipException:printStackTrace	()V
    //   218: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +11 -> 232
    //   224: ldc 29
    //   226: iconst_2
    //   227: ldc 110
    //   229: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_0
    //   235: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +11 -> 249
    //   241: ldc 29
    //   243: iconst_2
    //   244: ldc 112
    //   246: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: aload_0
    //   250: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   253: iconst_2
    //   254: ireturn
    //   255: astore_0
    //   256: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +11 -> 270
    //   262: ldc 29
    //   264: iconst_2
    //   265: ldc 115
    //   267: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: aload_0
    //   271: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   274: iconst_3
    //   275: ireturn
    //   276: aload_0
    //   277: aload 6
    //   279: invokevirtual 120	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   282: astore 7
    //   284: new 122	java/util/zip/CheckedInputStream
    //   287: dup
    //   288: aload 7
    //   290: new 124	java/util/zip/CRC32
    //   293: dup
    //   294: invokespecial 125	java/util/zip/CRC32:<init>	()V
    //   297: invokespecial 128	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   300: astore 8
    //   302: new 53	java/io/File
    //   305: dup
    //   306: new 40	java/lang/String
    //   309: dup
    //   310: new 31	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   317: aload_1
    //   318: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: getstatic 98	java/io/File:separator	Ljava/lang/String;
    //   324: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: aload 6
    //   329: invokevirtual 85	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   332: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: ldc 130
    //   340: invokevirtual 134	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   343: ldc 136
    //   345: invokespecial 139	java/lang/String:<init>	([BLjava/lang/String;)V
    //   348: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   351: astore 9
    //   353: aload 9
    //   355: invokevirtual 59	java/io/File:exists	()Z
    //   358: ifne +30 -> 388
    //   361: aload 9
    //   363: invokevirtual 143	java/io/File:getParentFile	()Ljava/io/File;
    //   366: astore 10
    //   368: aload 10
    //   370: invokevirtual 59	java/io/File:exists	()Z
    //   373: ifne +9 -> 382
    //   376: aload 10
    //   378: invokevirtual 62	java/io/File:mkdirs	()Z
    //   381: pop
    //   382: aload 9
    //   384: invokevirtual 146	java/io/File:createNewFile	()Z
    //   387: pop
    //   388: new 148	java/io/FileOutputStream
    //   391: dup
    //   392: aload 9
    //   394: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   397: astore 9
    //   399: sipush 4096
    //   402: newarray byte
    //   404: astore 10
    //   406: aload 6
    //   408: invokevirtual 153	java/util/zip/ZipEntry:getSize	()J
    //   411: lstore_3
    //   412: lload_3
    //   413: lconst_0
    //   414: lcmp
    //   415: ifle +32 -> 447
    //   418: aload 8
    //   420: aload 10
    //   422: iconst_0
    //   423: sipush 4096
    //   426: invokevirtual 157	java/util/zip/CheckedInputStream:read	([BII)I
    //   429: istore_2
    //   430: aload 9
    //   432: aload 10
    //   434: iconst_0
    //   435: iload_2
    //   436: invokevirtual 163	java/io/OutputStream:write	([BII)V
    //   439: lload_3
    //   440: iload_2
    //   441: i2l
    //   442: lsub
    //   443: lstore_3
    //   444: goto -32 -> 412
    //   447: aload 6
    //   449: invokevirtual 166	java/util/zip/ZipEntry:getCrc	()J
    //   452: aload 8
    //   454: invokevirtual 170	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   457: invokeinterface 175 1 0
    //   462: lcmp
    //   463: ifeq +53 -> 516
    //   466: aload 7
    //   468: invokevirtual 178	java/io/InputStream:close	()V
    //   471: aload 9
    //   473: invokevirtual 179	java/io/OutputStream:close	()V
    //   476: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +80 -> 559
    //   482: ldc 29
    //   484: iconst_2
    //   485: new 31	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   492: ldc 181
    //   494: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 6
    //   499: invokevirtual 166	java/util/zip/ZipEntry:getCrc	()J
    //   502: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   505: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 51	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   511: iconst_4
    //   512: istore_2
    //   513: goto -306 -> 207
    //   516: aload 7
    //   518: invokevirtual 178	java/io/InputStream:close	()V
    //   521: aload 9
    //   523: invokevirtual 179	java/io/OutputStream:close	()V
    //   526: goto -435 -> 91
    //   529: astore_1
    //   530: aload_1
    //   531: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   534: bipush 6
    //   536: istore_2
    //   537: goto -330 -> 207
    //   540: astore_1
    //   541: aload_1
    //   542: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   545: bipush 7
    //   547: istore_2
    //   548: goto -341 -> 207
    //   551: astore_0
    //   552: aload_0
    //   553: invokevirtual 113	java/io/IOException:printStackTrace	()V
    //   556: bipush 8
    //   558: ireturn
    //   559: iconst_4
    //   560: istore_2
    //   561: goto -354 -> 207
    //   564: iconst_0
    //   565: istore_2
    //   566: goto -359 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	paramString1	String
    //   0	569	1	paramString2	String
    //   206	360	2	i	int
    //   411	33	3	l	long
    //   51	51	5	localObject1	Object
    //   111	387	6	localObject2	Object
    //   282	235	7	localInputStream	InputStream
    //   300	153	8	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   351	171	9	localObject3	Object
    //   366	67	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   85	91	200	java/io/FileNotFoundException
    //   91	197	200	java/io/FileNotFoundException
    //   276	382	200	java/io/FileNotFoundException
    //   382	388	200	java/io/FileNotFoundException
    //   388	412	200	java/io/FileNotFoundException
    //   418	439	200	java/io/FileNotFoundException
    //   447	511	200	java/io/FileNotFoundException
    //   516	526	200	java/io/FileNotFoundException
    //   76	85	213	java/util/zip/ZipException
    //   76	85	234	java/io/IOException
    //   76	85	255	java/lang/Exception
    //   85	91	529	java/io/IOException
    //   91	197	529	java/io/IOException
    //   276	382	529	java/io/IOException
    //   382	388	529	java/io/IOException
    //   388	412	529	java/io/IOException
    //   418	439	529	java/io/IOException
    //   447	511	529	java/io/IOException
    //   516	526	529	java/io/IOException
    //   85	91	540	java/lang/Exception
    //   91	197	540	java/lang/Exception
    //   276	382	540	java/lang/Exception
    //   382	388	540	java/lang/Exception
    //   388	412	540	java/lang/Exception
    //   418	439	540	java/lang/Exception
    //   447	511	540	java/lang/Exception
    //   516	526	540	java/lang/Exception
    //   207	211	551	java/io/IOException
  }
  
  public static String a(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getComment().getBytes("GB2312"), "8859_1");
  }
  
  public static ArrayList a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    while (paramFile.hasMoreElements()) {
      localArrayList.add(new String(b((ZipEntry)paramFile.nextElement()).getBytes("GB2312"), "8859_1"));
    }
    return localArrayList;
  }
  
  public static ArrayList a(File paramFile, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramString1);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    paramFile = new ZipFile(paramFile);
    localObject1 = paramFile.entries();
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject2 = (ZipEntry)((Enumeration)localObject1).nextElement();
      if ((((ZipEntry)localObject2).getName() != null) && (!((ZipEntry)localObject2).getName().contains("../")) && (((ZipEntry)localObject2).getName().contains(paramString2)))
      {
        InputStream localInputStream = paramFile.getInputStream((ZipEntry)localObject2);
        localObject2 = new File(new String((paramString1 + File.separator + ((ZipEntry)localObject2).getName()).getBytes("8859_1"), "GB2312"));
        if (!((File)localObject2).exists())
        {
          localObject3 = ((File)localObject2).getParentFile();
          if (!((File)localObject3).exists()) {
            ((File)localObject3).mkdirs();
          }
          ((File)localObject2).createNewFile();
        }
        Object localObject3 = new FileOutputStream((File)localObject2);
        byte[] arrayOfByte = new byte[1048576];
        for (;;)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          ((OutputStream)localObject3).write(arrayOfByte, 0, i);
        }
        localInputStream.close();
        ((OutputStream)localObject3).close();
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
  
  public static Enumeration a(File paramFile)
  {
    return new ZipFile(paramFile).entries();
  }
  
  public static void a(File paramFile, String paramString)
  {
    paramFile = new ZipFile(paramFile);
    Enumeration localEnumeration = paramFile.entries();
    byte[] arrayOfByte = new byte[1024];
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = (ZipEntry)localEnumeration.nextElement();
      if ((((ZipEntry)localObject1).getName() != null) && (!((ZipEntry)localObject1).getName().contains("../"))) {
        if (((ZipEntry)localObject1).isDirectory())
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("upZipFile", 4, "ze.getName() = " + ((ZipEntry)localObject1).getName());
          }
          localObject1 = new String((paramString + ((ZipEntry)localObject1).getName()).getBytes("8859_1"), "GB2312");
          if (QLog.isColorLevel()) {
            QLog.d("upZipFile", 2, "str = " + (String)localObject1);
          }
          new File((String)localObject1).mkdir();
        }
        else
        {
          Object localObject2 = new File(paramString + ((ZipEntry)localObject1).getName());
          ((File)localObject2).getParentFile().mkdirs();
          localObject2 = new BufferedOutputStream(new FileOutputStream((File)localObject2));
          localObject1 = new BufferedInputStream(paramFile.getInputStream((ZipEntry)localObject1));
          for (;;)
          {
            int i = ((InputStream)localObject1).read(arrayOfByte, 0, 1024);
            if (i == -1) {
              break;
            }
            ((OutputStream)localObject2).write(arrayOfByte, 0, i);
          }
          ((InputStream)localObject1).close();
          ((OutputStream)localObject2).close();
        }
      }
    }
    paramFile.close();
  }
  
  public static String b(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.common.util.ZipUtils
 * JD-Core Version:    0.7.0.1
 */