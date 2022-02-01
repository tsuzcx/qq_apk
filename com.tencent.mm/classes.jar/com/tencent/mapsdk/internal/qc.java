package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.mapsdk.core.utils.cache.DiskCache.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public final class qc
  implements DiskCache.a
{
  private final int a = 128;
  private String b;
  
  public qc(String paramString)
  {
    this.b = paramString;
  }
  
  private static long a(int paramInt1, int paramInt2)
  {
    return paramInt1 % 128 * 128L + paramInt2 % 128;
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(226092);
    Object localObject = new StringBuilder();
    paramInt1 /= 128;
    paramInt2 /= 128;
    int i = paramInt1 / 10;
    int j = paramInt2 / 10;
    ((StringBuilder)localObject).append(File.separatorChar).append("glGrid").append(File.separatorChar).append(paramInt3).append(File.separatorChar).append(i).append(File.separatorChar).append(j).append(File.separatorChar).append(paramInt3).append("_").append(paramInt1).append("_").append(paramInt2);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(226092);
    return localObject;
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 4)) {
      return;
    }
    int i = paramArrayOfByte[0];
    paramArrayOfByte[0] = paramArrayOfByte[3];
    paramArrayOfByte[3] = i;
    i = paramArrayOfByte[1];
    paramArrayOfByte[1] = paramArrayOfByte[2];
    paramArrayOfByte[2] = i;
  }
  
  /* Error */
  private static boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 66
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: ifnonnull +10 -> 16
    //   9: ldc 66
    //   11: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_3
    //   17: arraylength
    //   18: istore 4
    //   20: iload 4
    //   22: ifgt +10 -> 32
    //   25: ldc 66
    //   27: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: iconst_0
    //   31: ireturn
    //   32: iconst_2
    //   33: anewarray 68	java/lang/String
    //   36: astore 9
    //   38: aload 9
    //   40: iconst_0
    //   41: new 33	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   48: aload_0
    //   49: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 70
    //   54: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: aastore
    //   61: aload 9
    //   63: iconst_1
    //   64: new 33	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   71: aload_0
    //   72: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 72
    //   77: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: aastore
    //   84: new 36	java/io/File
    //   87: dup
    //   88: aload 9
    //   90: iconst_1
    //   91: aaload
    //   92: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 78	java/io/File:exists	()Z
    //   100: ifne +17 -> 117
    //   103: aload_0
    //   104: invokestatic 83	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;)Z
    //   107: ifne +10 -> 117
    //   110: ldc 66
    //   112: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: iconst_0
    //   116: ireturn
    //   117: new 85	java/io/RandomAccessFile
    //   120: dup
    //   121: aload_0
    //   122: ldc 87
    //   124: invokespecial 90	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   127: astore_0
    //   128: aload_0
    //   129: ifnonnull +16 -> 145
    //   132: ldc 66
    //   134: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: aconst_null
    //   141: astore_0
    //   142: goto -14 -> 128
    //   145: iload 4
    //   147: invokestatic 93	com/tencent/mapsdk/internal/qc:a	(I)[B
    //   150: astore 10
    //   152: aload 10
    //   154: invokestatic 95	com/tencent/mapsdk/internal/qc:a	([B)V
    //   157: aload_0
    //   158: invokevirtual 99	java/io/RandomAccessFile:length	()J
    //   161: lstore 5
    //   163: aload_0
    //   164: lload 5
    //   166: invokevirtual 103	java/io/RandomAccessFile:seek	(J)V
    //   169: aload_0
    //   170: aload 10
    //   172: invokevirtual 106	java/io/RandomAccessFile:write	([B)V
    //   175: aload_0
    //   176: aload_3
    //   177: invokevirtual 106	java/io/RandomAccessFile:write	([B)V
    //   180: aload_0
    //   181: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   184: new 36	java/io/File
    //   187: dup
    //   188: aload 9
    //   190: iconst_0
    //   191: aaload
    //   192: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: astore_0
    //   196: aload_0
    //   197: invokevirtual 78	java/io/File:exists	()Z
    //   200: ifne +40 -> 240
    //   203: aload_0
    //   204: invokestatic 83	com/tencent/mapsdk/internal/ka:a	(Ljava/io/File;)Z
    //   207: ifne +33 -> 240
    //   210: ldc 66
    //   212: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: iconst_0
    //   216: ireturn
    //   217: astore_3
    //   218: lconst_0
    //   219: lstore 5
    //   221: aload_0
    //   222: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   225: goto -41 -> 184
    //   228: astore_3
    //   229: aload_0
    //   230: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   233: ldc 66
    //   235: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   238: aload_3
    //   239: athrow
    //   240: new 85	java/io/RandomAccessFile
    //   243: dup
    //   244: aload_0
    //   245: ldc 87
    //   247: invokespecial 90	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   250: astore_0
    //   251: aload_0
    //   252: ifnonnull +16 -> 268
    //   255: ldc 66
    //   257: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_0
    //   263: aconst_null
    //   264: astore_0
    //   265: goto -14 -> 251
    //   268: aload_0
    //   269: invokevirtual 99	java/io/RandomAccessFile:length	()J
    //   272: lstore 7
    //   274: lload 7
    //   276: lconst_0
    //   277: lcmp
    //   278: ifne +18 -> 296
    //   281: ldc 112
    //   283: newarray byte
    //   285: astore_3
    //   286: aload_3
    //   287: iconst_m1
    //   288: invokestatic 118	java/util/Arrays:fill	([BB)V
    //   291: aload_0
    //   292: aload_3
    //   293: invokevirtual 106	java/io/RandomAccessFile:write	([B)V
    //   296: iload_1
    //   297: iload_2
    //   298: invokestatic 120	com/tencent/mapsdk/internal/qc:a	(II)J
    //   301: lstore 7
    //   303: lload 7
    //   305: lconst_0
    //   306: lcmp
    //   307: ifge +21 -> 328
    //   310: aload_0
    //   311: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   314: ldc 66
    //   316: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   319: iconst_0
    //   320: ireturn
    //   321: astore_3
    //   322: lconst_0
    //   323: lstore 7
    //   325: goto -51 -> 274
    //   328: aload_0
    //   329: ldc2_w 121
    //   332: lload 7
    //   334: lmul
    //   335: invokevirtual 103	java/io/RandomAccessFile:seek	(J)V
    //   338: lload 5
    //   340: l2i
    //   341: invokestatic 93	com/tencent/mapsdk/internal/qc:a	(I)[B
    //   344: astore_3
    //   345: aload_3
    //   346: invokestatic 95	com/tencent/mapsdk/internal/qc:a	([B)V
    //   349: aload_0
    //   350: aload_3
    //   351: invokevirtual 106	java/io/RandomAccessFile:write	([B)V
    //   354: aload_0
    //   355: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   358: ldc 66
    //   360: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: iconst_1
    //   364: ireturn
    //   365: astore_3
    //   366: aload_0
    //   367: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   370: goto -12 -> 358
    //   373: astore_3
    //   374: aload_0
    //   375: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   378: ldc 66
    //   380: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload_3
    //   384: athrow
    //   385: astore_3
    //   386: goto -90 -> 296
    //   389: astore_3
    //   390: goto -52 -> 338
    //   393: astore_3
    //   394: goto -173 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramString	String
    //   0	397	1	paramInt1	int
    //   0	397	2	paramInt2	int
    //   0	397	3	paramArrayOfByte	byte[]
    //   18	128	4	i	int
    //   161	178	5	l1	long
    //   272	61	7	l2	long
    //   36	153	9	arrayOfString	String[]
    //   150	21	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   117	128	139	java/lang/Exception
    //   157	163	217	java/lang/Exception
    //   157	163	228	finally
    //   163	180	228	finally
    //   240	251	262	java/lang/Exception
    //   268	274	321	java/lang/Exception
    //   349	354	365	java/lang/Exception
    //   349	354	373	finally
    //   291	296	385	java/lang/Exception
    //   328	338	389	java/lang/Exception
    //   163	180	393	java/lang/Exception
  }
  
  private static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)((0xFF00 & paramInt) >> 8), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF000000 & paramInt) >> 24) };
  }
  
  /* Error */
  private static byte[] a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 127
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_2
    //   6: anewarray 68	java/lang/String
    //   9: astore 6
    //   11: aload 6
    //   13: iconst_0
    //   14: new 33	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   21: aload_0
    //   22: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 70
    //   27: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: aastore
    //   34: aload 6
    //   36: iconst_1
    //   37: new 33	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 72
    //   50: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: aastore
    //   57: new 36	java/io/File
    //   60: dup
    //   61: aload 6
    //   63: iconst_0
    //   64: aaload
    //   65: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_0
    //   69: aload_0
    //   70: invokevirtual 78	java/io/File:exists	()Z
    //   73: ifeq +12 -> 85
    //   76: aload_0
    //   77: invokevirtual 128	java/io/File:length	()J
    //   80: lconst_0
    //   81: lcmp
    //   82: ifne +10 -> 92
    //   85: ldc 127
    //   87: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aconst_null
    //   91: areturn
    //   92: iload_1
    //   93: iload_2
    //   94: invokestatic 120	com/tencent/mapsdk/internal/qc:a	(II)J
    //   97: lstore_3
    //   98: lload_3
    //   99: lconst_0
    //   100: lcmp
    //   101: ifge +10 -> 111
    //   104: ldc 127
    //   106: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aconst_null
    //   110: areturn
    //   111: iconst_4
    //   112: newarray byte
    //   114: astore 5
    //   116: new 85	java/io/RandomAccessFile
    //   119: dup
    //   120: aload_0
    //   121: ldc 130
    //   123: invokespecial 90	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   126: astore_0
    //   127: aload_0
    //   128: lload_3
    //   129: ldc2_w 121
    //   132: lmul
    //   133: invokevirtual 103	java/io/RandomAccessFile:seek	(J)V
    //   136: aload_0
    //   137: aload 5
    //   139: iconst_0
    //   140: iconst_4
    //   141: invokevirtual 134	java/io/RandomAccessFile:read	([BII)I
    //   144: pop
    //   145: aload_0
    //   146: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   149: aload 5
    //   151: invokestatic 95	com/tencent/mapsdk/internal/qc:a	([B)V
    //   154: aload 5
    //   156: invokestatic 137	com/tencent/mapsdk/internal/qc:b	([B)I
    //   159: istore_1
    //   160: iload_1
    //   161: ifge +40 -> 201
    //   164: ldc 127
    //   166: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aconst_null
    //   173: astore_0
    //   174: aload_0
    //   175: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   178: ldc 127
    //   180: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_0
    //   186: aconst_null
    //   187: astore 5
    //   189: aload 5
    //   191: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   194: ldc 127
    //   196: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   199: aload_0
    //   200: athrow
    //   201: new 36	java/io/File
    //   204: dup
    //   205: aload 6
    //   207: iconst_1
    //   208: aaload
    //   209: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 78	java/io/File:exists	()Z
    //   217: ifne +10 -> 227
    //   220: ldc 127
    //   222: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aconst_null
    //   226: areturn
    //   227: new 85	java/io/RandomAccessFile
    //   230: dup
    //   231: aload_0
    //   232: ldc 130
    //   234: invokespecial 90	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   237: astore_0
    //   238: iload_1
    //   239: i2l
    //   240: lstore_3
    //   241: aload_0
    //   242: lload_3
    //   243: invokevirtual 103	java/io/RandomAccessFile:seek	(J)V
    //   246: aload_0
    //   247: aload 5
    //   249: iconst_0
    //   250: iconst_4
    //   251: invokevirtual 134	java/io/RandomAccessFile:read	([BII)I
    //   254: pop
    //   255: aload 5
    //   257: invokestatic 95	com/tencent/mapsdk/internal/qc:a	([B)V
    //   260: aload 5
    //   262: invokestatic 137	com/tencent/mapsdk/internal/qc:b	([B)I
    //   265: istore_1
    //   266: iload_1
    //   267: ifgt +28 -> 295
    //   270: aload_0
    //   271: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   274: ldc 127
    //   276: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_0
    //   284: aload_0
    //   285: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   288: ldc 127
    //   290: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   293: aconst_null
    //   294: areturn
    //   295: iload_1
    //   296: newarray byte
    //   298: astore 5
    //   300: aload_0
    //   301: aload 5
    //   303: iconst_0
    //   304: iload_1
    //   305: invokevirtual 134	java/io/RandomAccessFile:read	([BII)I
    //   308: pop
    //   309: aload_0
    //   310: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   313: ldc 127
    //   315: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: aload 5
    //   320: areturn
    //   321: astore 5
    //   323: ldc 139
    //   325: aload 5
    //   327: invokestatic 144	com/tencent/mapsdk/internal/kh:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload_0
    //   331: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   334: ldc 127
    //   336: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   339: aconst_null
    //   340: areturn
    //   341: astore 5
    //   343: aload_0
    //   344: invokestatic 111	com/tencent/mapsdk/internal/kb:a	(Ljava/io/Closeable;)V
    //   347: ldc 127
    //   349: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload 5
    //   354: athrow
    //   355: astore 5
    //   357: goto -73 -> 284
    //   360: astore 5
    //   362: aload_0
    //   363: astore 6
    //   365: aload 5
    //   367: astore_0
    //   368: aload 6
    //   370: astore 5
    //   372: goto -183 -> 189
    //   375: astore 5
    //   377: goto -203 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramString	String
    //   0	380	1	paramInt1	int
    //   0	380	2	paramInt2	int
    //   97	146	3	l	long
    //   114	205	5	arrayOfByte	byte[]
    //   321	5	5	localThrowable	java.lang.Throwable
    //   341	12	5	localObject1	Object
    //   355	1	5	localException1	java.lang.Exception
    //   360	6	5	localObject2	Object
    //   370	1	5	localObject3	Object
    //   375	1	5	localException2	java.lang.Exception
    //   9	360	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   116	127	171	java/lang/Exception
    //   116	127	185	finally
    //   227	238	281	java/lang/Exception
    //   295	309	321	finally
    //   323	330	341	finally
    //   241	255	355	java/lang/Exception
    //   127	145	360	finally
    //   127	145	375	java/lang/Exception
  }
  
  private static int[] a(String paramString)
  {
    AppMethodBeat.i(226061);
    paramString = paramString.split("-");
    if (paramString.length < 3)
    {
      AppMethodBeat.o(226061);
      return null;
    }
    int[] arrayOfInt = new int[3];
    int i = 0;
    while (i < 3) {
      try
      {
        arrayOfInt[i] = Integer.parseInt(paramString[i]);
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        kh.a(Log.getStackTraceString(paramString));
        AppMethodBeat.o(226061);
        return null;
      }
    }
    AppMethodBeat.o(226061);
    return arrayOfInt;
  }
  
  private static int b(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 16 & 0xFF0000 | paramArrayOfByte[3] << 24 & 0xFF000000;
  }
  
  public final File a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(226115);
    if (TextUtils.isEmpty(this.b))
    {
      AppMethodBeat.o(226115);
      return null;
    }
    int i = paramString1.lastIndexOf(File.separatorChar);
    String str2 = paramString1;
    String str1 = paramString2;
    if (i >= 0)
    {
      str2 = paramString1.substring(0, i);
      str1 = paramString2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = paramString2 + File.separator + str2;
      }
      str2 = paramString1.substring(i + 1);
    }
    paramString1 = a(str2);
    if (paramString1 == null)
    {
      paramString1 = new File(str1, str2);
      AppMethodBeat.o(226115);
      return paramString1;
    }
    paramString2 = str1 + a(paramString1[0], paramString1[1], paramString1[2]);
    if (!a(paramString2, paramString1[0], paramString1[1], paramArrayOfByte))
    {
      paramString1 = new File(str1, str2);
      AppMethodBeat.o(226115);
      return paramString1;
    }
    paramString1 = new File(paramString2 + ".dat");
    AppMethodBeat.o(226115);
    return paramString1;
  }
  
  public final boolean a(File paramFile)
  {
    AppMethodBeat.i(226133);
    boolean bool = ka.b(new File(this.b));
    AppMethodBeat.o(226133);
    return bool;
  }
  
  public final byte[] a(String paramString, File paramFile)
  {
    AppMethodBeat.i(226123);
    String str1 = this.b;
    int i = paramString.lastIndexOf(File.separatorChar);
    paramFile = str1;
    String str2 = paramString;
    if (i >= 0)
    {
      str2 = paramString.substring(0, i);
      paramFile = str1;
      if (!TextUtils.isEmpty(str2)) {
        paramFile = str1 + File.separator + str2;
      }
      str2 = paramString.substring(i + 1);
    }
    paramString = a(str2);
    if (paramString == null)
    {
      AppMethodBeat.o(226123);
      return null;
    }
    paramString = a(paramFile + a(paramString[0], paramString[1], paramString[2]), paramString[0], paramString[1]);
    AppMethodBeat.o(226123);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.qc
 * JD-Core Version:    0.7.0.1
 */