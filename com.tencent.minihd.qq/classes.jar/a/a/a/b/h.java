package a.a.a.b;

import a.a.a.a.b;
import android.util.Base64;
import java.io.DataInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class h
{
  public static final byte[] a = { 8, 89, -108, 70, 3, 26, 39, -38, 6, 67, -94, 103, 29, 18, 117, -82, 1, 65, -106, 98, 15, 10, 66, -36, 4, 36, -108, 110, 15, 31, 84, -33, 44, 65, -104, 98, 41, 10, 83, -48, 63, 32, -108, 73, 5, 42, 66, -52, 43, 96, -67, 83, 13, 51, 34, -18, 52, 73, -65, 118, 10, 54, 92, -12, 116, 105, -71, 105, 13, 21, 124, -10, 3, 114, -87, 97, 43, 15, 118, -54, 35, 63, -93, 101, 0, 48, 66, -55, 17, 33, -22, 108, 11, 99, 81, -54, 43, 36, -21, 99, 120, 104, 66, -46, 6, 88, -126, 85, 27, 61, 33, -86, 52, 105, -76, 99, 8, 14, 86, -19, 18, 37, -8, 18, 126, 12, 83, -88, 22, 113, -80, 98, 40, 63, 109, -16, 48, 118, -68, 72, 45, 24, 86, -25, 35, 88, -28, 106, 123, 33, 114, -45, 117, 81, -94, 111, 3, 60, 120, -86, 110, 123, -28, 105, 101, 52, 94, -19, 31, 97, -67, 104, 3, 41, 117, -84, 51, 82, -65, 86, 6, 57, 60, -86, 124, 115, -89, 23, 30, 11, 60, -39, 52, 67, -125, 66, 36, 41, 60, -7, 20, 69, -80, 111, 120, 41, 89, -10, 47, 103, -102, 100, 15, 10, 86, -33 };
  public static final byte[] b = { 8, 84, -26, 87, 39, 47, 127, -49, 22, 81 };
  public static final byte[] c = { 23, 67, -110 };
  
  public static b a(DataInputStream paramDataInputStream)
  {
    b localb = new b(null);
    try
    {
      localb.a = paramDataInputStream.readInt();
      localb.b = paramDataInputStream.readInt();
      localb.c = paramDataInputStream.readInt();
      if ((localb.c > 0) && (localb.c <= 256))
      {
        localb.d = new byte[localb.c];
        paramDataInputStream.read(localb.d);
        return localb;
      }
    }
    catch (IOException paramDataInputStream)
    {
      paramDataInputStream.printStackTrace();
      return null;
    }
    return null;
  }
  
  public static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = b.a(a);
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(b.a(c)).generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(DataInputStream paramDataInputStream, int paramInt, byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    for (;;)
    {
      int i;
      try
      {
        localSignature = Signature.getInstance(b.a(b));
        localSignature.initVerify(paramPublicKey);
        paramPublicKey = new byte[8192];
        if (paramInt < 8192)
        {
          i = paramDataInputStream.read(paramPublicKey, 0, paramInt);
          break label83;
          return localSignature.verify(paramArrayOfByte);
        }
        else
        {
          i = paramDataInputStream.read(paramPublicKey);
        }
      }
      catch (Exception paramDataInputStream)
      {
        Signature localSignature;
        paramDataInputStream.printStackTrace();
        return false;
      }
      localSignature.update(paramPublicKey, 0, i);
      paramInt -= i;
      continue;
      label83:
      if (i != 0) {
        if (i != -1) {}
      }
    }
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 109	java/io/File:exists	()Z
    //   7: ifne +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: new 30	java/io/DataInputStream
    //   15: dup
    //   16: new 111	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: invokespecial 117	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 120	java/io/DataInputStream:available	()I
    //   34: istore_2
    //   35: iload_2
    //   36: sipush 140
    //   39: if_icmpgt +17 -> 56
    //   42: aload 5
    //   44: invokevirtual 123	java/io/DataInputStream:close	()V
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   54: iconst_0
    //   55: ireturn
    //   56: iload_2
    //   57: sipush 140
    //   60: isub
    //   61: istore_2
    //   62: aload 5
    //   64: iload_2
    //   65: invokevirtual 127	java/io/DataInputStream:skipBytes	(I)I
    //   68: pop
    //   69: aload 5
    //   71: invokestatic 129	a/a/a/b/h:a	(Ljava/io/DataInputStream;)La/a/a/b/h$b;
    //   74: astore 7
    //   76: aload 7
    //   78: ifnonnull +17 -> 95
    //   81: aload 5
    //   83: invokevirtual 123	java/io/DataInputStream:close	()V
    //   86: iconst_0
    //   87: ireturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 7
    //   97: getfield 37	a/a/a/b/h$b:a	I
    //   100: istore_3
    //   101: iload_3
    //   102: ldc 130
    //   104: if_icmpeq +17 -> 121
    //   107: aload 5
    //   109: invokevirtual 123	java/io/DataInputStream:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   119: iconst_0
    //   120: ireturn
    //   121: aload 7
    //   123: getfield 39	a/a/a/b/h$b:b	I
    //   126: istore_3
    //   127: iload_3
    //   128: ifle +9 -> 137
    //   131: iload_3
    //   132: ldc 131
    //   134: if_icmple +17 -> 151
    //   137: aload 5
    //   139: invokevirtual 123	java/io/DataInputStream:close	()V
    //   142: iconst_0
    //   143: ireturn
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   149: iconst_0
    //   150: ireturn
    //   151: iload_2
    //   152: iload_3
    //   153: if_icmpeq +17 -> 170
    //   156: aload 5
    //   158: invokevirtual 123	java/io/DataInputStream:close	()V
    //   161: iconst_0
    //   162: ireturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: aload_1
    //   171: invokestatic 133	a/a/a/b/h:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   174: astore_1
    //   175: aload_1
    //   176: ifnonnull +17 -> 193
    //   179: aload 5
    //   181: invokevirtual 123	java/io/DataInputStream:close	()V
    //   184: iconst_0
    //   185: ireturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: new 30	java/io/DataInputStream
    //   196: dup
    //   197: new 111	java/io/FileInputStream
    //   200: dup
    //   201: aload_0
    //   202: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   205: invokespecial 117	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   208: astore_0
    //   209: aload_0
    //   210: aload 7
    //   212: getfield 39	a/a/a/b/h$b:b	I
    //   215: aload 7
    //   217: getfield 44	a/a/a/b/h$b:d	[B
    //   220: aload_1
    //   221: invokestatic 135	a/a/a/b/h:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   224: istore 4
    //   226: aload 5
    //   228: invokevirtual 123	java/io/DataInputStream:close	()V
    //   231: aload_0
    //   232: invokevirtual 123	java/io/DataInputStream:close	()V
    //   235: iload 4
    //   237: ireturn
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   243: iload 4
    //   245: ireturn
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   251: goto -20 -> 231
    //   254: astore 6
    //   256: aload 5
    //   258: astore_1
    //   259: aload 6
    //   261: astore 5
    //   263: aload 5
    //   265: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   268: aload_1
    //   269: ifnull +7 -> 276
    //   272: aload_1
    //   273: invokevirtual 123	java/io/DataInputStream:close	()V
    //   276: aload_0
    //   277: ifnull -267 -> 10
    //   280: aload_0
    //   281: invokevirtual 123	java/io/DataInputStream:close	()V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore_0
    //   287: aload_0
    //   288: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   291: iconst_0
    //   292: ireturn
    //   293: astore 6
    //   295: aload 5
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_0
    //   300: aload 6
    //   302: astore 5
    //   304: goto -41 -> 263
    //   307: astore_0
    //   308: aconst_null
    //   309: astore 5
    //   311: aload 6
    //   313: astore_1
    //   314: aload 5
    //   316: ifnull +8 -> 324
    //   319: aload 5
    //   321: invokevirtual 123	java/io/DataInputStream:close	()V
    //   324: aload_1
    //   325: ifnull +7 -> 332
    //   328: aload_1
    //   329: invokevirtual 123	java/io/DataInputStream:close	()V
    //   332: aload_0
    //   333: athrow
    //   334: astore 5
    //   336: aconst_null
    //   337: astore_0
    //   338: aconst_null
    //   339: astore_1
    //   340: goto -77 -> 263
    //   343: astore_1
    //   344: aload_1
    //   345: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   348: goto -72 -> 276
    //   351: astore 6
    //   353: aload 5
    //   355: astore_1
    //   356: aload 6
    //   358: astore 5
    //   360: aload_0
    //   361: astore 6
    //   363: aload 5
    //   365: astore_0
    //   366: aload_1
    //   367: astore 5
    //   369: aload 6
    //   371: astore_1
    //   372: goto -58 -> 314
    //   375: astore 5
    //   377: aload 5
    //   379: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   382: goto -58 -> 324
    //   385: astore_1
    //   386: aload_1
    //   387: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   390: goto -58 -> 332
    //   393: astore 5
    //   395: goto -35 -> 360
    //   398: astore_0
    //   399: aload 6
    //   401: astore_1
    //   402: goto -88 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	paramFile	java.io.File
    //   0	405	1	paramString	String
    //   34	120	2	i	int
    //   100	54	3	j	int
    //   224	20	4	bool	boolean
    //   27	293	5	localObject1	Object
    //   334	20	5	localIOException1	IOException
    //   358	10	5	localObject2	Object
    //   375	3	5	localIOException2	IOException
    //   393	1	5	localObject3	Object
    //   1	1	6	localObject4	Object
    //   254	6	6	localIOException3	IOException
    //   293	19	6	localIOException4	IOException
    //   351	6	6	localObject5	Object
    //   361	39	6	localFile	java.io.File
    //   74	142	7	localb	b
    // Exception table:
    //   from	to	target	type
    //   42	47	49	java/io/IOException
    //   81	86	88	java/io/IOException
    //   107	112	114	java/io/IOException
    //   137	142	144	java/io/IOException
    //   156	161	163	java/io/IOException
    //   179	184	186	java/io/IOException
    //   231	235	238	java/io/IOException
    //   226	231	246	java/io/IOException
    //   209	226	254	java/io/IOException
    //   280	284	286	java/io/IOException
    //   29	35	293	java/io/IOException
    //   62	76	293	java/io/IOException
    //   95	101	293	java/io/IOException
    //   121	127	293	java/io/IOException
    //   170	175	293	java/io/IOException
    //   193	209	293	java/io/IOException
    //   12	29	307	finally
    //   12	29	334	java/io/IOException
    //   272	276	343	java/io/IOException
    //   209	226	351	finally
    //   319	324	375	java/io/IOException
    //   328	332	385	java/io/IOException
    //   263	268	393	finally
    //   29	35	398	finally
    //   62	76	398	finally
    //   95	101	398	finally
    //   121	127	398	finally
    //   170	175	398	finally
    //   193	209	398	finally
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 30	java/io/DataInputStream
    //   12: dup
    //   13: new 138	java/io/ByteArrayInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 139	java/io/ByteArrayInputStream:<init>	([B)V
    //   21: invokespecial 117	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: aload 5
    //   28: invokevirtual 120	java/io/DataInputStream:available	()I
    //   31: istore_2
    //   32: iload_2
    //   33: sipush 140
    //   36: if_icmpgt +17 -> 53
    //   39: aload 5
    //   41: invokevirtual 123	java/io/DataInputStream:close	()V
    //   44: iconst_0
    //   45: ireturn
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   51: iconst_0
    //   52: ireturn
    //   53: iload_2
    //   54: sipush 140
    //   57: isub
    //   58: istore_2
    //   59: aload 5
    //   61: iload_2
    //   62: invokevirtual 127	java/io/DataInputStream:skipBytes	(I)I
    //   65: pop
    //   66: aload 5
    //   68: invokestatic 129	a/a/a/b/h:a	(Ljava/io/DataInputStream;)La/a/a/b/h$b;
    //   71: astore 7
    //   73: aload 7
    //   75: ifnonnull +17 -> 92
    //   78: aload 5
    //   80: invokevirtual 123	java/io/DataInputStream:close	()V
    //   83: iconst_0
    //   84: ireturn
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   90: iconst_0
    //   91: ireturn
    //   92: aload 7
    //   94: getfield 37	a/a/a/b/h$b:a	I
    //   97: istore_3
    //   98: iload_3
    //   99: ldc 130
    //   101: if_icmpeq +17 -> 118
    //   104: aload 5
    //   106: invokevirtual 123	java/io/DataInputStream:close	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: aload 7
    //   120: getfield 39	a/a/a/b/h$b:b	I
    //   123: istore_3
    //   124: iload_3
    //   125: ifle +9 -> 134
    //   128: iload_3
    //   129: ldc 131
    //   131: if_icmple +17 -> 148
    //   134: aload 5
    //   136: invokevirtual 123	java/io/DataInputStream:close	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_0
    //   142: aload_0
    //   143: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: iload_2
    //   149: iload_3
    //   150: if_icmpeq +17 -> 167
    //   153: aload 5
    //   155: invokevirtual 123	java/io/DataInputStream:close	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: aload_1
    //   168: invokestatic 133	a/a/a/b/h:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   171: astore_1
    //   172: aload_1
    //   173: ifnonnull +17 -> 190
    //   176: aload 5
    //   178: invokevirtual 123	java/io/DataInputStream:close	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   188: iconst_0
    //   189: ireturn
    //   190: new 30	java/io/DataInputStream
    //   193: dup
    //   194: new 138	java/io/ByteArrayInputStream
    //   197: dup
    //   198: aload_0
    //   199: invokespecial 139	java/io/ByteArrayInputStream:<init>	([B)V
    //   202: invokespecial 117	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   205: astore_0
    //   206: aload_0
    //   207: aload 7
    //   209: getfield 39	a/a/a/b/h$b:b	I
    //   212: aload 7
    //   214: getfield 44	a/a/a/b/h$b:d	[B
    //   217: aload_1
    //   218: invokestatic 135	a/a/a/b/h:a	(Ljava/io/DataInputStream;I[BLjava/security/PublicKey;)Z
    //   221: istore 4
    //   223: aload 5
    //   225: invokevirtual 123	java/io/DataInputStream:close	()V
    //   228: aload_0
    //   229: invokevirtual 123	java/io/DataInputStream:close	()V
    //   232: iload 4
    //   234: ireturn
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   240: iload 4
    //   242: ireturn
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   248: goto -20 -> 228
    //   251: astore 6
    //   253: aload 5
    //   255: astore_1
    //   256: aload 6
    //   258: astore 5
    //   260: aload 5
    //   262: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 123	java/io/DataInputStream:close	()V
    //   273: aload_0
    //   274: ifnull -267 -> 7
    //   277: aload_0
    //   278: invokevirtual 123	java/io/DataInputStream:close	()V
    //   281: iconst_0
    //   282: ireturn
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   288: iconst_0
    //   289: ireturn
    //   290: astore 6
    //   292: aload 5
    //   294: astore_1
    //   295: aconst_null
    //   296: astore_0
    //   297: aload 6
    //   299: astore 5
    //   301: goto -41 -> 260
    //   304: astore_0
    //   305: aconst_null
    //   306: astore 5
    //   308: aload 6
    //   310: astore_1
    //   311: aload 5
    //   313: ifnull +8 -> 321
    //   316: aload 5
    //   318: invokevirtual 123	java/io/DataInputStream:close	()V
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 123	java/io/DataInputStream:close	()V
    //   329: aload_0
    //   330: athrow
    //   331: astore 5
    //   333: aconst_null
    //   334: astore_0
    //   335: aconst_null
    //   336: astore_1
    //   337: goto -77 -> 260
    //   340: astore_1
    //   341: aload_1
    //   342: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   345: goto -72 -> 273
    //   348: astore 6
    //   350: aload 5
    //   352: astore_1
    //   353: aload 6
    //   355: astore 5
    //   357: aload_0
    //   358: astore 6
    //   360: aload 5
    //   362: astore_0
    //   363: aload_1
    //   364: astore 5
    //   366: aload 6
    //   368: astore_1
    //   369: goto -58 -> 311
    //   372: astore 5
    //   374: aload 5
    //   376: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   379: goto -58 -> 321
    //   382: astore_1
    //   383: aload_1
    //   384: invokevirtual 51	java/io/IOException:printStackTrace	()V
    //   387: goto -58 -> 329
    //   390: astore 5
    //   392: goto -35 -> 357
    //   395: astore_0
    //   396: aload 6
    //   398: astore_1
    //   399: goto -88 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	paramArrayOfByte	byte[]
    //   0	402	1	paramString	String
    //   31	120	2	i	int
    //   97	54	3	j	int
    //   221	20	4	bool	boolean
    //   24	293	5	localObject1	Object
    //   331	20	5	localIOException1	IOException
    //   355	10	5	localObject2	Object
    //   372	3	5	localIOException2	IOException
    //   390	1	5	localObject3	Object
    //   1	1	6	localObject4	Object
    //   251	6	6	localIOException3	IOException
    //   290	19	6	localIOException4	IOException
    //   348	6	6	localObject5	Object
    //   358	39	6	arrayOfByte	byte[]
    //   71	142	7	localb	b
    // Exception table:
    //   from	to	target	type
    //   39	44	46	java/io/IOException
    //   78	83	85	java/io/IOException
    //   104	109	111	java/io/IOException
    //   134	139	141	java/io/IOException
    //   153	158	160	java/io/IOException
    //   176	181	183	java/io/IOException
    //   228	232	235	java/io/IOException
    //   223	228	243	java/io/IOException
    //   206	223	251	java/io/IOException
    //   277	281	283	java/io/IOException
    //   26	32	290	java/io/IOException
    //   59	73	290	java/io/IOException
    //   92	98	290	java/io/IOException
    //   118	124	290	java/io/IOException
    //   167	172	290	java/io/IOException
    //   190	206	290	java/io/IOException
    //   9	26	304	finally
    //   9	26	331	java/io/IOException
    //   269	273	340	java/io/IOException
    //   206	223	348	finally
    //   316	321	372	java/io/IOException
    //   325	329	382	java/io/IOException
    //   260	265	390	finally
    //   26	32	395	finally
    //   59	73	395	finally
    //   92	98	395	finally
    //   118	124	395	finally
    //   167	172	395	finally
    //   190	206	395	finally
  }
  
  public static class b
  {
    public int a;
    public int b;
    public int c;
    public byte[] d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     a.a.a.b.h
 * JD-Core Version:    0.7.0.1
 */