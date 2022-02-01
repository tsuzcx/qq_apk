package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class k
{
  private d a = null;
  private String b = "";
  private String c = "";
  private final String d = "ver";
  private final String e = ":";
  private String f = "1301";
  private String g = "";
  private boolean h = false;
  private String i = "";
  private final String j = "1301";
  private final int k = 64;
  
  public k(Context paramContext, j paramj)
  {
    if (paramj == null) {
      return;
    }
    boolean bool2 = false;
    this.i = paramj.h;
    if (!paramj.q.equals(""))
    {
      File localFile = new File(paramj.q);
      bool2 = localFile.exists();
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = localFile.mkdirs();
      }
      bool2 = bool1;
      if (bool1 == true)
      {
        bool2 = bool1;
        if (a(paramj.q) < 5L) {
          bool2 = false;
        }
      }
    }
    if (!bool2) {
      if (!Environment.getExternalStorageState().equals("mounted"))
      {
        this.c = paramContext.getFilesDir().getPath();
        this.c = (this.c + File.separator + "TencentMapSDK" + File.separator);
        if ((!this.i.equals("map_raster")) && (!this.i.equals("map_satellite"))) {
          break label346;
        }
        paramContext = b(this.i);
        if (paramContext != null) {
          this.f = paramContext;
        }
      }
    }
    for (;;)
    {
      b();
      return;
      this.c = Environment.getExternalStorageDirectory().getPath();
      if (a(this.b) >= 5L) {
        break;
      }
      this.c = paramContext.getFilesDir().getPath();
      if (a(this.b) >= 5L) {
        break;
      }
      this.c = Environment.getExternalStorageDirectory().getPath();
      break;
      this.c = paramj.q;
      break;
      label346:
      this.h = true;
    }
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 64 * 64 + paramInt2 % 64;
  }
  
  private int a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramBoolean == true) {
      return paramArrayOfByte[3] & 0xFF | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[0] << 24 & 0xFF000000;
    }
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = new File(this.c);
    boolean bool2 = ((File)localObject1).exists();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = ((File)localObject1).mkdirs();
    }
    if (!bool1) {}
    for (;;)
    {
      return;
      Object localObject2 = new File((File)localObject1, this.i + ".cfg");
      if (((File)localObject2).exists() == true)
      {
        if (!paramBoolean) {
          continue;
        }
        ((File)localObject2).delete();
      }
      try
      {
        paramBoolean = ((File)localObject2).createNewFile();
        if (!paramBoolean) {
          continue;
        }
        localObject1 = null;
      }
      catch (IOException localIOException3)
      {
        try
        {
          localObject2 = new FileWriter((File)localObject2, true);
          localObject1 = localObject2;
          if (localObject1 == null) {
            continue;
          }
          localObject2 = new StringBuilder();
          getClass();
          localObject2 = ((StringBuilder)localObject2).append("ver");
          getClass();
          localObject2 = ":" + this.f;
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              ((FileWriter)localObject1).write((String)localObject2 + System.getProperty("line.separator"));
              ((FileWriter)localObject1).close();
              return;
              localIOException1 = localIOException1;
              localIOException1.printStackTrace();
              paramBoolean = bool1;
            }
            localIOException3 = localIOException3;
            localIOException3.printStackTrace();
          }
          catch (IOException localIOException2)
          {
            for (;;)
            {
              localIOException2.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        bool1 = this.h;
        if (bool1 == true)
        {
          bool1 = bool2;
          return bool1;
        }
        String str = q.a(this.i);
        bool1 = bool2;
        if (str == null) {
          continue;
        }
        str = str.trim();
        bool1 = bool2;
        if (str.equals("")) {
          continue;
        }
        this.g = this.f;
        this.f = str;
        this.h = true;
        if (this.f.equals(this.g))
        {
          a(false);
          bool1 = bool2;
          continue;
        }
        b();
      }
      finally {}
      a(true);
      boolean bool1 = true;
    }
  }
  
  private byte[] a(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[4];
    if (paramBoolean == true)
    {
      arrayOfByte[3] = ((byte)(paramInt & 0xFF));
      arrayOfByte[2] = ((byte)((0xFF00 & paramInt) >> 8));
      arrayOfByte[1] = ((byte)((0xFF0000 & paramInt) >> 16));
      arrayOfByte[0] = ((byte)((0xFF000000 & paramInt) >> 24));
      return arrayOfByte;
    }
    arrayOfByte[0] = ((byte)(paramInt & 0xFF));
    arrayOfByte[1] = ((byte)((0xFF00 & paramInt) >> 8));
    arrayOfByte[2] = ((byte)((0xFF0000 & paramInt) >> 16));
    arrayOfByte[3] = ((byte)((0xFF000000 & paramInt) >> 24));
    return arrayOfByte;
  }
  
  /* Error */
  private byte[] a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 69	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 5
    //   10: aload 5
    //   12: invokevirtual 76	java/io/File:exists	()Z
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aconst_null
    //   21: astore_1
    //   22: new 190	java/io/RandomAccessFile
    //   25: dup
    //   26: aload 5
    //   28: ldc 192
    //   30: invokespecial 193	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore 5
    //   35: aload 5
    //   37: astore_1
    //   38: aload_1
    //   39: ifnonnull +15 -> 54
    //   42: aconst_null
    //   43: areturn
    //   44: astore 5
    //   46: aload 5
    //   48: invokevirtual 194	java/io/FileNotFoundException:printStackTrace	()V
    //   51: goto -13 -> 38
    //   54: iconst_4
    //   55: newarray byte
    //   57: astore 5
    //   59: iload_2
    //   60: i2l
    //   61: lstore_3
    //   62: aload_1
    //   63: lload_3
    //   64: invokevirtual 198	java/io/RandomAccessFile:seek	(J)V
    //   67: aload_1
    //   68: aload 5
    //   70: iconst_0
    //   71: iconst_4
    //   72: invokevirtual 202	java/io/RandomAccessFile:read	([BII)I
    //   75: pop
    //   76: aload_0
    //   77: aload 5
    //   79: iconst_0
    //   80: invokespecial 204	com/tencent/tencentmap/mapsdk/map/k:a	([BZ)I
    //   83: istore_2
    //   84: iload_2
    //   85: ifgt +37 -> 122
    //   88: aload_1
    //   89: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore 6
    //   96: aload 6
    //   98: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   101: goto -34 -> 67
    //   104: astore 6
    //   106: aload 6
    //   108: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   111: goto -35 -> 76
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   119: goto -27 -> 92
    //   122: iload_2
    //   123: newarray byte
    //   125: astore 5
    //   127: aload_1
    //   128: aload 5
    //   130: iconst_0
    //   131: iload_2
    //   132: invokevirtual 202	java/io/RandomAccessFile:read	([BII)I
    //   135: pop
    //   136: aload_1
    //   137: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   140: aload 5
    //   142: areturn
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   148: aload 5
    //   150: areturn
    //   151: astore_1
    //   152: aconst_null
    //   153: areturn
    //   154: astore 6
    //   156: aload 6
    //   158: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   161: goto -25 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	k
    //   0	164	1	paramString	String
    //   0	164	2	paramInt	int
    //   61	3	3	l	long
    //   8	28	5	localObject	Object
    //   44	3	5	localFileNotFoundException	java.io.FileNotFoundException
    //   57	92	5	arrayOfByte	byte[]
    //   94	3	6	localIOException1	IOException
    //   104	3	6	localIOException2	IOException
    //   154	3	6	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   22	35	44	java/io/FileNotFoundException
    //   62	67	94	java/io/IOException
    //   67	76	104	java/io/IOException
    //   88	92	114	java/io/IOException
    //   136	140	143	java/io/IOException
    //   122	127	151	java/lang/OutOfMemoryError
    //   127	136	154	java/io/IOException
  }
  
  private String[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    paramInt1 /= 64;
    paramInt2 /= 64;
    int m = paramInt1 / 10;
    int n = paramInt2 / 10;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("/");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("/");
    localStringBuilder.append(m);
    localStringBuilder.append("/");
    localStringBuilder.append(n);
    localStringBuilder.append("/");
    if (!paramBoolean)
    {
      File localFile = new File(localStringBuilder.toString());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    return new String[] { localStringBuilder.toString() + ".ind", localStringBuilder.toString() + ".dat" };
  }
  
  private String b(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.c != null)
        {
          boolean bool = this.c.equals("");
          if (bool != true) {}
        }
        else
        {
          paramString = null;
          return paramString;
        }
        if ((paramString != null) && (paramString.equals("") != true))
        {
          File localFile = new File(this.c);
          if (!localFile.exists())
          {
            paramString = null;
            continue;
          }
          paramString = new File(localFile, paramString + ".cfg");
          if (!paramString.exists())
          {
            paramString = null;
            continue;
          }
          paramString = a(paramString, "ver");
          if ((paramString == null) || (paramString.equals(""))) {
            break label164;
          }
          paramString = paramString.replace("ver", "").replace(":", "");
          continue;
        }
        paramString = null;
      }
      finally {}
      continue;
      label164:
      paramString = null;
    }
  }
  
  private void b()
  {
    if ((!this.i.equals("map_raster")) && (!this.i.equals("map_satellite")))
    {
      this.b = (this.c + this.i);
      return;
    }
    if (this.f.equals("1301"))
    {
      this.b = (this.c + this.i);
      return;
    }
    this.b = (this.c + this.i + this.f);
  }
  
  public long a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getBlockSize() * paramString.getAvailableBlocks() / 1024L / 1024L;
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public String a(File paramFile, String paramString)
  {
    InputStreamReader localInputStreamReader = null;
    BufferedReader localBufferedReader = null;
    Object localObject3 = null;
    Object localObject2 = localInputStreamReader;
    Object localObject1 = localBufferedReader;
    try
    {
      if (paramFile.isFile())
      {
        localObject2 = localInputStreamReader;
        localObject1 = localBufferedReader;
        if (paramFile.exists())
        {
          localObject1 = localBufferedReader;
          localInputStreamReader = new InputStreamReader(new FileInputStream(paramFile), "utf-8");
          localObject1 = localBufferedReader;
          localBufferedReader = new BufferedReader(localInputStreamReader);
          paramFile = localObject3;
          do
          {
            localObject1 = paramFile;
            localObject2 = localBufferedReader.readLine();
            if (localObject2 == null) {
              break;
            }
            paramFile = (File)localObject2;
            localObject1 = paramFile;
            localObject2 = paramFile.trim();
            paramFile = (File)localObject2;
            localObject1 = localObject2;
          } while (!((String)localObject2).contains(paramString));
          paramFile = (File)localObject2;
          localObject1 = paramFile;
          localInputStreamReader.close();
          localObject2 = paramFile;
        }
      }
      return localObject2;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
    return localObject1;
  }
  
  public void a(d paramd)
  {
    this.a = paramd;
  }
  
  /* Error */
  public boolean a(v.a parama, g.a parama1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/tencent/tencentmap/mapsdk/map/k:h	Z
    //   4: ifne +50 -> 54
    //   7: aload_0
    //   8: invokespecial 271	com/tencent/tencentmap/mapsdk/map/k:a	()Z
    //   11: iconst_1
    //   12: if_icmpne +42 -> 54
    //   15: aload_0
    //   16: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   19: ifnull +23 -> 42
    //   22: aload_0
    //   23: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   26: getfield 276	com/tencent/tencentmap/mapsdk/map/d:a	Lcom/tencent/tencentmap/mapsdk/map/e;
    //   29: ifnull +13 -> 42
    //   32: aload_0
    //   33: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   36: getfield 276	com/tencent/tencentmap/mapsdk/map/d:a	Lcom/tencent/tencentmap/mapsdk/map/e;
    //   39: invokevirtual 280	com/tencent/tencentmap/mapsdk/map/e:a	()V
    //   42: aload_2
    //   43: ifnull +9 -> 52
    //   46: aload_2
    //   47: invokeinterface 283 1 0
    //   52: iconst_0
    //   53: ireturn
    //   54: aload_0
    //   55: aload_1
    //   56: getfield 287	com/tencent/tencentmap/mapsdk/map/v$a:a	I
    //   59: aload_1
    //   60: getfield 289	com/tencent/tencentmap/mapsdk/map/v$a:b	I
    //   63: aload_1
    //   64: getfield 291	com/tencent/tencentmap/mapsdk/map/v$a:c	I
    //   67: iconst_1
    //   68: invokespecial 293	com/tencent/tencentmap/mapsdk/map/k:a	(IIIZ)[Ljava/lang/String;
    //   71: astore 8
    //   73: aload 8
    //   75: ifnull +34 -> 109
    //   78: aload 8
    //   80: arraylength
    //   81: iconst_2
    //   82: if_icmpne +27 -> 109
    //   85: aload 8
    //   87: iconst_0
    //   88: aaload
    //   89: ldc 28
    //   91: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   94: ifne +15 -> 109
    //   97: aload 8
    //   99: iconst_1
    //   100: aaload
    //   101: ldc 28
    //   103: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +5 -> 111
    //   109: iconst_0
    //   110: ireturn
    //   111: new 69	java/io/File
    //   114: dup
    //   115: aload 8
    //   117: iconst_0
    //   118: aaload
    //   119: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore_2
    //   123: aload_2
    //   124: invokevirtual 76	java/io/File:exists	()Z
    //   127: ifne +5 -> 132
    //   130: iconst_0
    //   131: ireturn
    //   132: aload_0
    //   133: aload_1
    //   134: getfield 287	com/tencent/tencentmap/mapsdk/map/v$a:a	I
    //   137: aload_1
    //   138: getfield 289	com/tencent/tencentmap/mapsdk/map/v$a:b	I
    //   141: invokespecial 295	com/tencent/tencentmap/mapsdk/map/k:a	(II)I
    //   144: istore_3
    //   145: iload_3
    //   146: ifge +5 -> 151
    //   149: iconst_0
    //   150: ireturn
    //   151: aconst_null
    //   152: astore 7
    //   154: aconst_null
    //   155: astore 6
    //   157: new 190	java/io/RandomAccessFile
    //   160: dup
    //   161: aload_2
    //   162: ldc 192
    //   164: invokespecial 193	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +15 -> 184
    //   172: iload_3
    //   173: iconst_4
    //   174: imul
    //   175: i2l
    //   176: lstore 4
    //   178: aload_2
    //   179: lload 4
    //   181: invokevirtual 198	java/io/RandomAccessFile:seek	(J)V
    //   184: aload_2
    //   185: ifnonnull +35 -> 220
    //   188: iconst_0
    //   189: ireturn
    //   190: astore 7
    //   192: aload 6
    //   194: astore_2
    //   195: aload 7
    //   197: astore 6
    //   199: aload 6
    //   201: invokevirtual 194	java/io/FileNotFoundException:printStackTrace	()V
    //   204: goto -20 -> 184
    //   207: astore 6
    //   209: aload 7
    //   211: astore_2
    //   212: aload 6
    //   214: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   217: goto -33 -> 184
    //   220: iconst_4
    //   221: newarray byte
    //   223: astore 6
    //   225: aload_2
    //   226: aload 6
    //   228: iconst_0
    //   229: iconst_4
    //   230: invokevirtual 202	java/io/RandomAccessFile:read	([BII)I
    //   233: pop
    //   234: aload_0
    //   235: aload 6
    //   237: iconst_1
    //   238: invokespecial 204	com/tencent/tencentmap/mapsdk/map/k:a	([BZ)I
    //   241: istore_3
    //   242: aload_2
    //   243: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   246: iload_3
    //   247: iconst_m1
    //   248: if_icmpne +23 -> 271
    //   251: iconst_0
    //   252: ireturn
    //   253: astore 7
    //   255: aload 7
    //   257: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   260: goto -26 -> 234
    //   263: astore_2
    //   264: aload_2
    //   265: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   268: goto -22 -> 246
    //   271: aconst_null
    //   272: astore 6
    //   274: iload_3
    //   275: bipush 254
    //   277: if_icmpne +12 -> 289
    //   280: aload 6
    //   282: astore_2
    //   283: aload_2
    //   284: ifnonnull +36 -> 320
    //   287: iconst_0
    //   288: ireturn
    //   289: aload 6
    //   291: astore_2
    //   292: iload_3
    //   293: bipush 253
    //   295: if_icmpeq -12 -> 283
    //   298: aload 6
    //   300: astore_2
    //   301: iload_3
    //   302: bipush 156
    //   304: if_icmpeq -21 -> 283
    //   307: aload_0
    //   308: aload 8
    //   310: iconst_1
    //   311: aaload
    //   312: iload_3
    //   313: invokespecial 297	com/tencent/tencentmap/mapsdk/map/k:a	(Ljava/lang/String;I)[B
    //   316: astore_2
    //   317: goto -34 -> 283
    //   320: new 103	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   327: astore 6
    //   329: aload 6
    //   331: aload_1
    //   332: getfield 287	com/tencent/tencentmap/mapsdk/map/v$a:a	I
    //   335: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 6
    //   341: ldc_w 299
    //   344: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 6
    //   350: aload_1
    //   351: getfield 289	com/tencent/tencentmap/mapsdk/map/v$a:b	I
    //   354: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload 6
    //   360: ldc_w 299
    //   363: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 6
    //   369: aload_1
    //   370: getfield 291	com/tencent/tencentmap/mapsdk/map/v$a:c	I
    //   373: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload_0
    //   378: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   381: ifnonnull +5 -> 386
    //   384: iconst_0
    //   385: ireturn
    //   386: aload_0
    //   387: getfield 26	com/tencent/tencentmap/mapsdk/map/k:a	Lcom/tencent/tencentmap/mapsdk/map/d;
    //   390: aload_2
    //   391: aload 6
    //   393: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 302	com/tencent/tencentmap/mapsdk/map/d:a	([BLjava/lang/String;)Z
    //   399: ireturn
    //   400: astore 6
    //   402: goto -190 -> 212
    //   405: astore 6
    //   407: goto -208 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	k
    //   0	410	1	parama	v.a
    //   0	410	2	parama1	g.a
    //   144	169	3	m	int
    //   176	4	4	l	long
    //   155	45	6	localFileNotFoundException1	java.io.FileNotFoundException
    //   207	6	6	localIOException1	IOException
    //   223	169	6	localObject1	Object
    //   400	1	6	localIOException2	IOException
    //   405	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   152	1	7	localObject2	Object
    //   190	20	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   253	3	7	localIOException3	IOException
    //   71	238	8	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   157	168	190	java/io/FileNotFoundException
    //   157	168	207	java/io/IOException
    //   225	234	253	java/io/IOException
    //   242	246	263	java/io/IOException
    //   178	184	400	java/io/IOException
    //   178	184	405	java/io/FileNotFoundException
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +11 -> 14
    //   6: iconst_0
    //   7: istore 6
    //   9: aload_0
    //   10: monitorexit
    //   11: iload 6
    //   13: ireturn
    //   14: aload_1
    //   15: arraylength
    //   16: istore 5
    //   18: iload 5
    //   20: ifgt +9 -> 29
    //   23: iconst_0
    //   24: istore 6
    //   26: goto -17 -> 9
    //   29: aload_0
    //   30: iload_2
    //   31: iload_3
    //   32: iload 4
    //   34: iconst_0
    //   35: invokespecial 293	com/tencent/tencentmap/mapsdk/map/k:a	(IIIZ)[Ljava/lang/String;
    //   38: astore 18
    //   40: aload 18
    //   42: ifnull +602 -> 644
    //   45: aload 18
    //   47: arraylength
    //   48: iconst_2
    //   49: if_icmpne +595 -> 644
    //   52: aload 18
    //   54: iconst_0
    //   55: aaload
    //   56: ldc 28
    //   58: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   61: ifne +583 -> 644
    //   64: aload 18
    //   66: iconst_1
    //   67: aaload
    //   68: ldc 28
    //   70: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   73: ifeq +6 -> 79
    //   76: goto +568 -> 644
    //   79: new 69	java/io/File
    //   82: dup
    //   83: aload 18
    //   85: iconst_1
    //   86: aaload
    //   87: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore 15
    //   92: aload 15
    //   94: invokevirtual 76	java/io/File:exists	()Z
    //   97: istore 6
    //   99: iload 6
    //   101: ifne +43 -> 144
    //   104: iconst_0
    //   105: istore 6
    //   107: aload 15
    //   109: invokevirtual 148	java/io/File:createNewFile	()Z
    //   112: istore 7
    //   114: iload 7
    //   116: istore 6
    //   118: iload 6
    //   120: ifne +24 -> 144
    //   123: iconst_0
    //   124: istore 6
    //   126: goto -117 -> 9
    //   129: astore 14
    //   131: aload 14
    //   133: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   136: goto -18 -> 118
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    //   144: lconst_0
    //   145: lstore 8
    //   147: aconst_null
    //   148: astore 17
    //   150: aconst_null
    //   151: astore 14
    //   153: aconst_null
    //   154: astore 16
    //   156: new 190	java/io/RandomAccessFile
    //   159: dup
    //   160: aload 15
    //   162: ldc_w 305
    //   165: invokespecial 193	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   168: astore 15
    //   170: lload 8
    //   172: lstore 10
    //   174: lload 8
    //   176: lstore 12
    //   178: aload_0
    //   179: iload 5
    //   181: iconst_0
    //   182: invokespecial 307	com/tencent/tencentmap/mapsdk/map/k:a	(IZ)[B
    //   185: astore 14
    //   187: lload 8
    //   189: lstore 10
    //   191: lload 8
    //   193: lstore 12
    //   195: aload 15
    //   197: invokevirtual 311	java/io/RandomAccessFile:length	()J
    //   200: lstore 8
    //   202: lload 8
    //   204: lstore 10
    //   206: lload 8
    //   208: lstore 12
    //   210: aload 15
    //   212: lload 8
    //   214: invokevirtual 198	java/io/RandomAccessFile:seek	(J)V
    //   217: lload 8
    //   219: lstore 10
    //   221: lload 8
    //   223: lstore 12
    //   225: aload 15
    //   227: aload 14
    //   229: invokevirtual 314	java/io/RandomAccessFile:write	([B)V
    //   232: lload 8
    //   234: lstore 10
    //   236: lload 8
    //   238: lstore 12
    //   240: aload 15
    //   242: aload_1
    //   243: invokevirtual 314	java/io/RandomAccessFile:write	([B)V
    //   246: aload 15
    //   248: ifnull +8 -> 256
    //   251: aload 15
    //   253: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   256: new 69	java/io/File
    //   259: dup
    //   260: aload 18
    //   262: iconst_0
    //   263: aaload
    //   264: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 76	java/io/File:exists	()Z
    //   272: istore 6
    //   274: iload 6
    //   276: ifne +98 -> 374
    //   279: iconst_0
    //   280: istore 6
    //   282: aload_1
    //   283: invokevirtual 148	java/io/File:createNewFile	()Z
    //   286: istore 7
    //   288: iload 7
    //   290: istore 6
    //   292: iload 6
    //   294: ifne +80 -> 374
    //   297: iconst_0
    //   298: istore 6
    //   300: goto -291 -> 9
    //   303: astore 15
    //   305: aload 16
    //   307: astore_1
    //   308: aload_1
    //   309: astore 14
    //   311: aload 15
    //   313: invokevirtual 194	java/io/FileNotFoundException:printStackTrace	()V
    //   316: aload_1
    //   317: ifnull +7 -> 324
    //   320: aload_1
    //   321: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   324: goto -68 -> 256
    //   327: astore 15
    //   329: aload 17
    //   331: astore_1
    //   332: aload_1
    //   333: astore 14
    //   335: aload 15
    //   337: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   340: aload_1
    //   341: ifnull +7 -> 348
    //   344: aload_1
    //   345: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   348: goto -92 -> 256
    //   351: astore_1
    //   352: aload 14
    //   354: ifnull +8 -> 362
    //   357: aload 14
    //   359: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   362: aload_1
    //   363: athrow
    //   364: astore 14
    //   366: aload 14
    //   368: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   371: goto -79 -> 292
    //   374: lconst_0
    //   375: lstore 10
    //   377: aconst_null
    //   378: astore 16
    //   380: aconst_null
    //   381: astore 15
    //   383: new 190	java/io/RandomAccessFile
    //   386: dup
    //   387: aload_1
    //   388: ldc_w 305
    //   391: invokespecial 193	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   394: astore_1
    //   395: aload_1
    //   396: invokevirtual 311	java/io/RandomAccessFile:length	()J
    //   399: lstore 12
    //   401: lload 12
    //   403: lstore 10
    //   405: lload 10
    //   407: lconst_0
    //   408: lcmp
    //   409: ifne +48 -> 457
    //   412: sipush 16384
    //   415: newarray byte
    //   417: astore 14
    //   419: aload 14
    //   421: iconst_m1
    //   422: invokestatic 320	java/util/Arrays:fill	([BB)V
    //   425: aload_1
    //   426: ifnonnull +25 -> 451
    //   429: iconst_0
    //   430: istore 6
    //   432: goto -423 -> 9
    //   435: aload 14
    //   437: invokevirtual 194	java/io/FileNotFoundException:printStackTrace	()V
    //   440: goto -35 -> 405
    //   443: aload 14
    //   445: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   448: goto -43 -> 405
    //   451: aload_1
    //   452: aload 14
    //   454: invokevirtual 314	java/io/RandomAccessFile:write	([B)V
    //   457: aload_0
    //   458: iload_2
    //   459: iload_3
    //   460: invokespecial 295	com/tencent/tencentmap/mapsdk/map/k:a	(II)I
    //   463: istore_2
    //   464: iload_2
    //   465: ifge +31 -> 496
    //   468: aload_1
    //   469: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   472: iconst_0
    //   473: istore 6
    //   475: goto -466 -> 9
    //   478: astore 14
    //   480: aload 14
    //   482: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   485: goto -28 -> 457
    //   488: astore_1
    //   489: aload_1
    //   490: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   493: goto -21 -> 472
    //   496: iload_2
    //   497: iconst_4
    //   498: imul
    //   499: i2l
    //   500: lstore 10
    //   502: aload_1
    //   503: lload 10
    //   505: invokevirtual 198	java/io/RandomAccessFile:seek	(J)V
    //   508: aload_1
    //   509: aload_0
    //   510: lload 8
    //   512: l2i
    //   513: iconst_1
    //   514: invokespecial 307	com/tencent/tencentmap/mapsdk/map/k:a	(IZ)[B
    //   517: invokevirtual 314	java/io/RandomAccessFile:write	([B)V
    //   520: aload_1
    //   521: ifnull +7 -> 528
    //   524: aload_1
    //   525: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   528: iconst_1
    //   529: istore 6
    //   531: goto -522 -> 9
    //   534: astore 14
    //   536: aload 14
    //   538: invokevirtual 173	java/io/IOException:printStackTrace	()V
    //   541: aload_1
    //   542: ifnull +7 -> 549
    //   545: aload_1
    //   546: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   549: goto -21 -> 528
    //   552: astore 14
    //   554: aload_1
    //   555: ifnull +7 -> 562
    //   558: aload_1
    //   559: invokevirtual 205	java/io/RandomAccessFile:close	()V
    //   562: aload 14
    //   564: athrow
    //   565: astore_1
    //   566: goto -310 -> 256
    //   569: astore_1
    //   570: goto -246 -> 324
    //   573: astore_1
    //   574: goto -226 -> 348
    //   577: astore 14
    //   579: goto -217 -> 362
    //   582: astore_1
    //   583: goto -55 -> 528
    //   586: astore_1
    //   587: goto -38 -> 549
    //   590: astore_1
    //   591: goto -29 -> 562
    //   594: astore 14
    //   596: goto -153 -> 443
    //   599: astore 14
    //   601: goto -166 -> 435
    //   604: astore_1
    //   605: aload 15
    //   607: astore 14
    //   609: goto -257 -> 352
    //   612: astore 14
    //   614: aload 15
    //   616: astore_1
    //   617: aload 14
    //   619: astore 15
    //   621: lload 10
    //   623: lstore 8
    //   625: goto -293 -> 332
    //   628: astore 14
    //   630: aload 15
    //   632: astore_1
    //   633: aload 14
    //   635: astore 15
    //   637: lload 12
    //   639: lstore 8
    //   641: goto -333 -> 308
    //   644: iconst_0
    //   645: istore 6
    //   647: goto -638 -> 9
    //   650: astore 14
    //   652: aload 15
    //   654: astore_1
    //   655: goto -220 -> 435
    //   658: astore 14
    //   660: aload 16
    //   662: astore_1
    //   663: goto -220 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	666	0	this	k
    //   0	666	1	paramArrayOfByte	byte[]
    //   0	666	2	paramInt1	int
    //   0	666	3	paramInt2	int
    //   0	666	4	paramInt3	int
    //   16	164	5	m	int
    //   7	639	6	bool1	boolean
    //   112	177	7	bool2	boolean
    //   145	495	8	l1	long
    //   172	450	10	l2	long
    //   176	462	12	l3	long
    //   129	3	14	localIOException1	IOException
    //   151	207	14	arrayOfByte1	byte[]
    //   364	3	14	localIOException2	IOException
    //   417	36	14	arrayOfByte2	byte[]
    //   478	3	14	localIOException3	IOException
    //   534	3	14	localIOException4	IOException
    //   552	11	14	localObject1	Object
    //   577	1	14	localIOException5	IOException
    //   594	1	14	localIOException6	IOException
    //   599	1	14	localFileNotFoundException1	java.io.FileNotFoundException
    //   607	1	14	localObject2	Object
    //   612	6	14	localIOException7	IOException
    //   628	6	14	localFileNotFoundException2	java.io.FileNotFoundException
    //   650	1	14	localFileNotFoundException3	java.io.FileNotFoundException
    //   658	1	14	localIOException8	IOException
    //   90	162	15	localObject3	Object
    //   303	9	15	localFileNotFoundException4	java.io.FileNotFoundException
    //   327	9	15	localIOException9	IOException
    //   381	272	15	localObject4	Object
    //   154	507	16	localObject5	Object
    //   148	182	17	localObject6	Object
    //   38	223	18	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   107	114	129	java/io/IOException
    //   14	18	139	finally
    //   29	40	139	finally
    //   45	76	139	finally
    //   79	99	139	finally
    //   107	114	139	finally
    //   131	136	139	finally
    //   251	256	139	finally
    //   256	274	139	finally
    //   282	288	139	finally
    //   320	324	139	finally
    //   344	348	139	finally
    //   357	362	139	finally
    //   362	364	139	finally
    //   366	371	139	finally
    //   383	395	139	finally
    //   395	401	139	finally
    //   412	425	139	finally
    //   435	440	139	finally
    //   443	448	139	finally
    //   451	457	139	finally
    //   457	464	139	finally
    //   468	472	139	finally
    //   480	485	139	finally
    //   489	493	139	finally
    //   524	528	139	finally
    //   545	549	139	finally
    //   558	562	139	finally
    //   562	565	139	finally
    //   156	170	303	java/io/FileNotFoundException
    //   156	170	327	java/io/IOException
    //   156	170	351	finally
    //   311	316	351	finally
    //   335	340	351	finally
    //   282	288	364	java/io/IOException
    //   451	457	478	java/io/IOException
    //   468	472	488	java/io/IOException
    //   502	520	534	java/io/IOException
    //   502	520	552	finally
    //   536	541	552	finally
    //   251	256	565	java/io/IOException
    //   320	324	569	java/io/IOException
    //   344	348	573	java/io/IOException
    //   357	362	577	java/io/IOException
    //   524	528	582	java/io/IOException
    //   545	549	586	java/io/IOException
    //   558	562	590	java/io/IOException
    //   395	401	594	java/io/IOException
    //   395	401	599	java/io/FileNotFoundException
    //   178	187	604	finally
    //   195	202	604	finally
    //   210	217	604	finally
    //   225	232	604	finally
    //   240	246	604	finally
    //   178	187	612	java/io/IOException
    //   195	202	612	java/io/IOException
    //   210	217	612	java/io/IOException
    //   225	232	612	java/io/IOException
    //   240	246	612	java/io/IOException
    //   178	187	628	java/io/FileNotFoundException
    //   195	202	628	java/io/FileNotFoundException
    //   210	217	628	java/io/FileNotFoundException
    //   225	232	628	java/io/FileNotFoundException
    //   240	246	628	java/io/FileNotFoundException
    //   383	395	650	java/io/FileNotFoundException
    //   383	395	658	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.k
 * JD-Core Version:    0.7.0.1
 */