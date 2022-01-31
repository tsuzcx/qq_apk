package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public final class FileOp
{
  private static ReentrantReadWriteLock fOi;
  private static TreeMap<String, SFSContextRec> fOj;
  private static String fOk;
  private static final EnumSet<g.a> fOl;
  
  static
  {
    AppMethodBeat.i(93199);
    fOi = new ReentrantReadWriteLock();
    fOj = new TreeMap();
    fOk = "";
    fOl = EnumSet.of(g.a.fOu, g.a.fOv);
    AppMethodBeat.o(93199);
  }
  
  /* Error */
  @Deprecated
  public static long C(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +21 -> 27
    //   9: aload_0
    //   10: invokevirtual 80	java/lang/String:length	()I
    //   13: ifeq +14 -> 27
    //   16: aload_1
    //   17: ifnull +10 -> 27
    //   20: aload_1
    //   21: invokevirtual 80	java/lang/String:length	()I
    //   24: ifne +12 -> 36
    //   27: ldc 74
    //   29: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: ldc2_w 81
    //   35: lreturn
    //   36: lconst_0
    //   37: lstore_3
    //   38: aload_0
    //   39: invokestatic 86	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   42: astore 6
    //   44: aload_1
    //   45: invokestatic 90	com/tencent/mm/modelsfs/FileOp:qC	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   48: astore 5
    //   50: sipush 1024
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: aload 7
    //   61: invokevirtual 96	java/io/InputStream:read	([B)I
    //   64: istore_2
    //   65: iload_2
    //   66: iconst_m1
    //   67: if_icmpeq +20 -> 87
    //   70: aload 5
    //   72: aload 7
    //   74: iconst_0
    //   75: iload_2
    //   76: invokevirtual 102	java/io/OutputStream:write	([BII)V
    //   79: lload_3
    //   80: iload_2
    //   81: i2l
    //   82: ladd
    //   83: lstore_3
    //   84: goto -27 -> 57
    //   87: ldc 104
    //   89: ldc 106
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: aastore
    //   99: dup
    //   100: iconst_1
    //   101: aload_1
    //   102: aastore
    //   103: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload 6
    //   108: ifnull +8 -> 116
    //   111: aload 6
    //   113: invokevirtual 115	java/io/InputStream:close	()V
    //   116: aload 5
    //   118: ifnull +8 -> 126
    //   121: aload 5
    //   123: invokevirtual 116	java/io/OutputStream:close	()V
    //   126: ldc 74
    //   128: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: lload_3
    //   132: lreturn
    //   133: astore 7
    //   135: aconst_null
    //   136: astore 5
    //   138: aconst_null
    //   139: astore 6
    //   141: ldc 104
    //   143: ldc 118
    //   145: iconst_3
    //   146: anewarray 4	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: aload_0
    //   152: aastore
    //   153: dup
    //   154: iconst_1
    //   155: aload_1
    //   156: aastore
    //   157: dup
    //   158: iconst_2
    //   159: aload 7
    //   161: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   164: aastore
    //   165: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload 6
    //   170: ifnull +8 -> 178
    //   173: aload 6
    //   175: invokevirtual 115	java/io/InputStream:close	()V
    //   178: aload 5
    //   180: ifnull +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 116	java/io/OutputStream:close	()V
    //   188: ldc 74
    //   190: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   193: ldc2_w 81
    //   196: lreturn
    //   197: astore_0
    //   198: aconst_null
    //   199: astore 5
    //   201: aconst_null
    //   202: astore 6
    //   204: aload 6
    //   206: ifnull +8 -> 214
    //   209: aload 6
    //   211: invokevirtual 115	java/io/InputStream:close	()V
    //   214: aload 5
    //   216: ifnull +8 -> 224
    //   219: aload 5
    //   221: invokevirtual 116	java/io/OutputStream:close	()V
    //   224: ldc 74
    //   226: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_0
    //   230: athrow
    //   231: astore_0
    //   232: goto -116 -> 116
    //   235: astore_0
    //   236: goto -110 -> 126
    //   239: astore_0
    //   240: goto -62 -> 178
    //   243: astore_0
    //   244: goto -56 -> 188
    //   247: astore_1
    //   248: goto -34 -> 214
    //   251: astore_1
    //   252: goto -28 -> 224
    //   255: astore_0
    //   256: aconst_null
    //   257: astore 5
    //   259: goto -55 -> 204
    //   262: astore_0
    //   263: goto -59 -> 204
    //   266: astore_0
    //   267: goto -63 -> 204
    //   270: astore 7
    //   272: aconst_null
    //   273: astore 5
    //   275: goto -134 -> 141
    //   278: astore 7
    //   280: goto -139 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramString1	String
    //   0	283	1	paramString2	String
    //   64	17	2	i	int
    //   37	95	3	l	long
    //   48	226	5	localOutputStream	OutputStream
    //   42	168	6	localInputStream	InputStream
    //   55	18	7	arrayOfByte	byte[]
    //   133	27	7	localIOException1	IOException
    //   270	1	7	localIOException2	IOException
    //   278	1	7	localIOException3	IOException
    // Exception table:
    //   from	to	target	type
    //   38	44	133	java/io/IOException
    //   38	44	197	finally
    //   111	116	231	java/io/IOException
    //   121	126	235	java/io/IOException
    //   173	178	239	java/io/IOException
    //   183	188	243	java/io/IOException
    //   209	214	247	java/io/IOException
    //   219	224	251	java/io/IOException
    //   44	50	255	finally
    //   50	57	262	finally
    //   57	65	262	finally
    //   70	79	262	finally
    //   87	106	262	finally
    //   141	168	266	finally
    //   44	50	270	java/io/IOException
    //   50	57	278	java/io/IOException
    //   57	65	278	java/io/IOException
    //   70	79	278	java/io/IOException
    //   87	106	278	java/io/IOException
  }
  
  private static boolean a(String paramString, SFSContextRec paramSFSContextRec)
  {
    AppMethodBeat.i(93181);
    if (paramSFSContextRec.fOo == null)
    {
      AppMethodBeat.o(93181);
      return false;
    }
    paramString = paramString.substring(paramSFSContextRec.fOn.length());
    int i = paramString.lastIndexOf('/');
    if (i == -1)
    {
      AppMethodBeat.o(93181);
      return false;
    }
    paramString = paramString.substring(i + 1);
    if (paramString.length() == 0)
    {
      AppMethodBeat.o(93181);
      return false;
    }
    paramSFSContextRec = paramSFSContextRec.fOo;
    int j = paramSFSContextRec.length;
    i = 0;
    while (i < j)
    {
      if (g.a(paramSFSContextRec[i], 0, paramString, 0, fOl))
      {
        AppMethodBeat.o(93181);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(93181);
    return false;
  }
  
  @Deprecated
  private static OutputStream aS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93186);
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = new FileNotFoundException("path == null");
      AppMethodBeat.o(93186);
      throw paramString1;
    }
    Object localObject = tZ(paramString1);
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = new c(paramString1, paramString2);
          fOi.readLock().unlock();
          if (localObject != null) {
            break label160;
          }
          localObject = "regular";
          ab.d("MicroMsg.FileOp", "openWrite: %s [%s, %s]", new Object[] { paramString1, "ok", localObject });
          AppMethodBeat.o(93186);
          return paramString2;
        }
        paramString2 = new FileOutputStream(paramString1);
        continue;
        str = paramString1.substring(((SFSContextRec)localObject).fOn.length());
      }
      finally
      {
        fOi.readLock().unlock();
        AppMethodBeat.o(93186);
      }
      String str;
      paramString2 = ((SFSContextRec)localObject).fOr.aU(str, paramString2);
      continue;
      label160:
      localObject = "SFS";
    }
  }
  
  @Deprecated
  public static boolean aT(String paramString1, String paramString2)
  {
    AppMethodBeat.i(93197);
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0))
    {
      AppMethodBeat.o(93197);
      return false;
    }
    Object localObject = paramString1;
    String str2 = paramString2;
    if (tY(paramString1))
    {
      localObject = paramString1;
      str2 = paramString2;
      if (tY(paramString2))
      {
        String str1 = paramString1;
        if (f.ue(paramString1)) {
          str1 = f.uf(paramString1);
        }
        paramString1 = paramString2;
        if (f.ue(paramString2)) {
          paramString1 = f.uf(paramString2);
        }
        localObject = str1;
        str2 = paramString1;
        if (new File(str1).renameTo(new File(paramString1)))
        {
          AppMethodBeat.o(93197);
          return true;
        }
      }
    }
    if (C((String)localObject, str2) < 0L)
    {
      AppMethodBeat.o(93197);
      return false;
    }
    deleteFile((String)localObject);
    AppMethodBeat.o(93197);
    return true;
  }
  
  public static Map<String, SFSContext.Statistics> ajh()
  {
    AppMethodBeat.i(93180);
    fOi.readLock().lock();
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = fOj.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (SFSContextRec)localIterator.next();
      if ((localObject != null) && (!((SFSContextRec)localObject).fOq))
      {
        if (((SFSContextRec)localObject).fOr == null) {}
        try
        {
          SFSContext localSFSContext = ((SFSContextRec)localObject).fOr;
          if (localSFSContext == null) {}
          try
          {
            ((SFSContextRec)localObject).fOr = ((SFSContextRec)localObject).fOs.create();
            localSFSContext = ((SFSContextRec)localObject).fOr;
            if (localSFSContext.mNativePtr != 0L) {
              break label174;
            }
            localObject = new IllegalArgumentException("Reuse already released SFSContext.");
            AppMethodBeat.o(93180);
            throw ((Throwable)localObject);
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", new Object[] { ((SFSContextRec)localObject).fOn, localException.getMessage() });
            ((SFSContextRec)localObject).fOq = true;
          }
          continue;
        }
        finally
        {
          AppMethodBeat.o(93180);
        }
        label174:
        SFSContext.Statistics localStatistics = SFSContext.nativeStatistics(localException.mNativePtr);
        localMap.put(((SFSContextRec)localObject).fOs.mName, localStatistics);
      }
    }
    fOi.readLock().unlock();
    AppMethodBeat.o(93180);
    return localMap;
  }
  
  /* Error */
  @Deprecated
  private static int b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 300
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +12 -> 19
    //   10: ldc_w 300
    //   13: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: bipush 254
    //   18: ireturn
    //   19: aload_1
    //   20: arraylength
    //   21: iload_2
    //   22: iconst_0
    //   23: iadd
    //   24: if_icmpge +12 -> 36
    //   27: ldc_w 300
    //   30: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: bipush 253
    //   35: ireturn
    //   36: aconst_null
    //   37: astore 4
    //   39: aconst_null
    //   40: astore_3
    //   41: aload_0
    //   42: invokestatic 90	com/tencent/mm/modelsfs/FileOp:qC	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   45: astore 5
    //   47: aload 5
    //   49: astore_3
    //   50: aload 5
    //   52: astore 4
    //   54: aload 5
    //   56: aload_1
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual 102	java/io/OutputStream:write	([BII)V
    //   62: aload 5
    //   64: ifnull +8 -> 72
    //   67: aload 5
    //   69: invokevirtual 116	java/io/OutputStream:close	()V
    //   72: ldc_w 300
    //   75: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_1
    //   81: aload_3
    //   82: astore 4
    //   84: ldc 104
    //   86: ldc_w 302
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_0
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: aload_1
    //   100: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   103: aastore
    //   104: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aload_3
    //   108: ifnull +7 -> 115
    //   111: aload_3
    //   112: invokevirtual 116	java/io/OutputStream:close	()V
    //   115: ldc_w 300
    //   118: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: iconst_m1
    //   122: ireturn
    //   123: astore_0
    //   124: aload 4
    //   126: ifnull +8 -> 134
    //   129: aload 4
    //   131: invokevirtual 116	java/io/OutputStream:close	()V
    //   134: ldc_w 300
    //   137: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: aload_0
    //   141: athrow
    //   142: astore_0
    //   143: goto -71 -> 72
    //   146: astore_0
    //   147: goto -32 -> 115
    //   150: astore_1
    //   151: goto -17 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   0	154	1	paramArrayOfByte	byte[]
    //   0	154	2	paramInt	int
    //   40	72	3	localObject1	Object
    //   37	93	4	localObject2	Object
    //   45	23	5	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   41	47	80	java/io/IOException
    //   54	62	80	java/io/IOException
    //   41	47	123	finally
    //   54	62	123	finally
    //   84	107	123	finally
    //   67	72	142	java/io/IOException
    //   111	115	146	java/io/IOException
    //   129	134	150	java/io/IOException
  }
  
  @Deprecated
  public static boolean cN(String paramString)
  {
    AppMethodBeat.i(93195);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(93195);
      return false;
    }
    Object localObject = tZ(paramString);
    boolean bool1;
    if (localObject != null)
    {
      boolean bool2 = ((SFSContextRec)localObject).fOr.exists(paramString.substring(((SFSContextRec)localObject).fOn.length()));
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (((SFSContextRec)localObject).fOp) {
          bool1 = new File(paramString).exists();
        }
      }
      fOi.readLock().unlock();
      if (localObject != null) {
        break label146;
      }
    }
    label146:
    for (localObject = "regular";; localObject = "SFS")
    {
      ab.d("MicroMsg.FileOp", "fileExists: %s [%b, %s]", new Object[] { paramString, Boolean.valueOf(bool1), localObject });
      AppMethodBeat.o(93195);
      return bool1;
      bool1 = new File(paramString).exists();
      break;
    }
  }
  
  /* Error */
  @Deprecated
  public static String cS(String paramString)
  {
    // Byte code:
    //   0: ldc_w 322
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 324	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: new 327	java/io/InputStreamReader
    //   18: dup
    //   19: aload_0
    //   20: invokestatic 86	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: invokespecial 330	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: sipush 512
    //   32: newarray char
    //   34: astore 5
    //   36: aload_3
    //   37: astore_2
    //   38: aload_3
    //   39: aload 5
    //   41: invokevirtual 333	java/io/InputStreamReader:read	([C)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +76 -> 123
    //   50: aload_3
    //   51: astore_2
    //   52: aload 4
    //   54: aload 5
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 337	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -26 -> 36
    //   65: astore 4
    //   67: aload_3
    //   68: astore_2
    //   69: ldc 104
    //   71: ldc_w 339
    //   74: iconst_2
    //   75: anewarray 4	java/lang/Object
    //   78: dup
    //   79: iconst_0
    //   80: aload_0
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload 4
    //   86: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   89: aastore
    //   90: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_3
    //   94: astore_2
    //   95: ldc_w 322
    //   98: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: aload_3
    //   102: astore_2
    //   103: aload 4
    //   105: athrow
    //   106: astore_0
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 340	java/io/InputStreamReader:close	()V
    //   115: ldc_w 322
    //   118: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: athrow
    //   123: aload_3
    //   124: invokevirtual 340	java/io/InputStreamReader:close	()V
    //   127: aload 4
    //   129: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore_0
    //   133: ldc_w 322
    //   136: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload_0
    //   140: areturn
    //   141: astore_0
    //   142: goto -15 -> 127
    //   145: astore_2
    //   146: goto -31 -> 115
    //   149: astore_0
    //   150: aconst_null
    //   151: astore_2
    //   152: goto -45 -> 107
    //   155: astore 4
    //   157: aconst_null
    //   158: astore_3
    //   159: goto -92 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   44	14	1	i	int
    //   28	84	2	localInputStreamReader1	java.io.InputStreamReader
    //   145	1	2	localIOException1	IOException
    //   151	1	2	localObject	Object
    //   26	133	3	localInputStreamReader2	java.io.InputStreamReader
    //   13	40	4	localStringBuilder	java.lang.StringBuilder
    //   65	63	4	localIOException2	IOException
    //   155	1	4	localIOException3	IOException
    //   34	21	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   29	36	65	java/io/IOException
    //   38	45	65	java/io/IOException
    //   52	62	65	java/io/IOException
    //   29	36	106	finally
    //   38	45	106	finally
    //   52	62	106	finally
    //   69	93	106	finally
    //   95	101	106	finally
    //   103	106	106	finally
    //   123	127	141	java/io/IOException
    //   111	115	145	java/io/IOException
    //   15	27	149	finally
    //   15	27	155	java/io/IOException
  }
  
  @Deprecated
  public static boolean deleteFile(String paramString)
  {
    AppMethodBeat.i(93196);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(93196);
      return false;
    }
    SFSContextRec localSFSContextRec = tZ(paramString);
    boolean bool1;
    if (localSFSContextRec != null)
    {
      str = paramString.substring(localSFSContextRec.fOn.length());
      boolean bool2 = localSFSContextRec.fOr.qD(str);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (localSFSContextRec.fOp) {
          if (!f.ue(paramString)) {
            break label189;
          }
        }
      }
    }
    label184:
    label189:
    for (String str = f.uf(paramString);; str = paramString)
    {
      bool1 = new File(str).delete();
      fOi.readLock().unlock();
      if (localSFSContextRec == null)
      {
        str = "regular";
        label116:
        ab.d("MicroMsg.FileOp", "deleteFile: %s [%b, %s]", new Object[] { paramString, Boolean.valueOf(bool1), str });
        AppMethodBeat.o(93196);
        return bool1;
        if (!f.ue(paramString)) {
          break label184;
        }
      }
      for (str = f.uf(paramString);; str = paramString)
      {
        bool1 = new File(str).delete();
        break;
        str = "SFS";
        break label116;
      }
    }
  }
  
  @Deprecated
  public static InputStream openRead(String paramString)
  {
    AppMethodBeat.i(93184);
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = new FileNotFoundException("path == null");
      AppMethodBeat.o(93184);
      throw paramString;
    }
    Object localObject2 = tZ(paramString);
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        if (f.ue(paramString))
        {
          long l = f.ug(paramString);
          localObject1 = new b(f.uf(paramString), l);
          fOi.readLock().unlock();
          if (localObject2 != null) {
            break label208;
          }
          localObject2 = "regular";
          ab.d("MicroMsg.FileOp", "openRead: %s [%s, %s]", new Object[] { paramString, "ok", localObject2 });
          AppMethodBeat.o(93184);
          return localObject1;
        }
        Object localObject1 = new FileInputStream(paramString);
        continue;
        try
        {
          localObject1 = paramString.substring(((SFSContextRec)localObject2).fOn.length());
          localObject1 = ((SFSContextRec)localObject2).fOr.openRead((String)localObject1);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (!((SFSContextRec)localObject2).fOp)
          {
            AppMethodBeat.o(93184);
            throw localFileNotFoundException;
          }
          FileInputStream localFileInputStream = new FileInputStream(paramString);
        }
      }
      finally
      {
        fOi.readLock().unlock();
        AppMethodBeat.o(93184);
      }
      continue;
      label208:
      localObject2 = "SFS";
    }
  }
  
  @Deprecated
  public static int q(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(93191);
    int i = b(paramString, paramArrayOfByte, paramArrayOfByte.length);
    AppMethodBeat.o(93191);
    return i;
  }
  
  @Deprecated
  public static OutputStream qC(String paramString)
  {
    AppMethodBeat.i(93185);
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = new FileNotFoundException("path == null");
      AppMethodBeat.o(93185);
      throw paramString;
    }
    String str2 = "";
    String str1 = paramString;
    if (f.ue(paramString))
    {
      str2 = f.uh(paramString);
      str1 = f.uf(paramString);
    }
    paramString = aS(str1, str2);
    AppMethodBeat.o(93185);
    return paramString;
  }
  
  private static boolean tY(String paramString)
  {
    AppMethodBeat.i(93182);
    fOi.readLock().lock();
    Object localObject = fOj.floorEntry(paramString);
    if ((localObject != null) && (paramString.startsWith((String)((Map.Entry)localObject).getKey())))
    {
      localObject = (SFSContextRec)((Map.Entry)localObject).getValue();
      if ((((SFSContextRec)localObject).fOq) || (a(paramString, (SFSContextRec)localObject))) {}
    }
    for (boolean bool = false;; bool = true)
    {
      fOi.readLock().unlock();
      AppMethodBeat.o(93182);
      return bool;
    }
  }
  
  private static SFSContextRec tZ(String paramString)
  {
    AppMethodBeat.i(93183);
    fOi.readLock().lock();
    Object localObject = fOj.floorEntry(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(93183);
      return null;
    }
    if (paramString.startsWith((String)((Map.Entry)localObject).getKey()))
    {
      SFSContextRec localSFSContextRec = (SFSContextRec)((Map.Entry)localObject).getValue();
      localObject = localSFSContextRec;
      if (!a(paramString, localSFSContextRec)) {}
    }
    for (localObject = null;; localObject = null)
    {
      if ((localObject != null) && (!((SFSContextRec)localObject).fOq))
      {
        if (((SFSContextRec)localObject).fOr == null) {}
        try
        {
          paramString = ((SFSContextRec)localObject).fOr;
          if (paramString == null) {}
          try
          {
            ((SFSContextRec)localObject).fOr = ((SFSContextRec)localObject).fOs.create();
            return localObject;
          }
          catch (Exception paramString)
          {
            ab.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", new Object[] { ((SFSContextRec)localObject).fOn, paramString.getMessage() });
            ((SFSContextRec)localObject).fOq = true;
            return null;
          }
          AppMethodBeat.o(93183);
        }
        finally
        {
          AppMethodBeat.o(93183);
        }
      }
      return null;
    }
  }
  
  /* Error */
  @Deprecated
  public static boolean ua(String paramString)
  {
    // Byte code:
    //   0: ldc_w 400
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_0
    //   11: invokevirtual 80	java/lang/String:length	()I
    //   14: ifne +11 -> 25
    //   17: ldc_w 400
    //   20: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: iconst_0
    //   24: ireturn
    //   25: aload_0
    //   26: invokestatic 162	com/tencent/mm/modelsfs/FileOp:tZ	(Ljava/lang/String;)Lcom/tencent/mm/modelsfs/FileOp$SFSContextRec;
    //   29: astore_2
    //   30: aload_2
    //   31: ifnonnull +20 -> 51
    //   34: getstatic 38	com/tencent/mm/modelsfs/FileOp:fOi	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   37: invokevirtual 177	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   40: invokevirtual 182	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   43: ldc_w 400
    //   46: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_1
    //   50: ireturn
    //   51: aload_0
    //   52: aload_2
    //   53: getfield 135	com/tencent/mm/modelsfs/FileOp$SFSContextRec:fOn	Ljava/lang/String;
    //   56: invokevirtual 80	java/lang/String:length	()I
    //   59: invokevirtual 139	java/lang/String:substring	(I)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_2
    //   64: getfield 195	com/tencent/mm/modelsfs/FileOp$SFSContextRec:fOr	Lcom/tencent/mm/modelsfs/SFSContext;
    //   67: aload_3
    //   68: invokevirtual 368	com/tencent/mm/modelsfs/SFSContext:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   71: astore_2
    //   72: new 220	java/io/File
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 221	java/io/File:<init>	(Ljava/lang/String;)V
    //   80: invokevirtual 403	java/io/File:getParent	()Ljava/lang/String;
    //   83: astore_3
    //   84: aload_3
    //   85: invokestatic 408	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   88: ifne +15 -> 103
    //   91: new 220	java/io/File
    //   94: dup
    //   95: aload_3
    //   96: invokespecial 221	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: invokevirtual 411	java/io/File:mkdirs	()Z
    //   102: pop
    //   103: new 190	java/io/FileOutputStream
    //   106: dup
    //   107: aload_0
    //   108: invokespecial 191	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   111: astore_3
    //   112: aload_3
    //   113: astore 5
    //   115: aload_2
    //   116: astore 4
    //   118: sipush 1024
    //   121: newarray byte
    //   123: astore 6
    //   125: aload_3
    //   126: astore 5
    //   128: aload_2
    //   129: astore 4
    //   131: aload_2
    //   132: aload 6
    //   134: invokevirtual 96	java/io/InputStream:read	([B)I
    //   137: istore_1
    //   138: iload_1
    //   139: iconst_m1
    //   140: if_icmpeq +85 -> 225
    //   143: aload_3
    //   144: astore 5
    //   146: aload_2
    //   147: astore 4
    //   149: aload_3
    //   150: aload 6
    //   152: iconst_0
    //   153: iload_1
    //   154: invokevirtual 102	java/io/OutputStream:write	([BII)V
    //   157: goto -32 -> 125
    //   160: astore 6
    //   162: aload_3
    //   163: astore 5
    //   165: aload_2
    //   166: astore 4
    //   168: ldc 104
    //   170: ldc_w 413
    //   173: iconst_2
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_0
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: aload 6
    //   185: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   188: aastore
    //   189: invokestatic 125	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 115	java/io/InputStream:close	()V
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 116	java/io/OutputStream:close	()V
    //   208: getstatic 38	com/tencent/mm/modelsfs/FileOp:fOi	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   211: invokevirtual 177	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   214: invokevirtual 182	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   217: ldc_w 400
    //   220: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   223: iconst_0
    //   224: ireturn
    //   225: aload_2
    //   226: invokevirtual 115	java/io/InputStream:close	()V
    //   229: aload_3
    //   230: invokevirtual 116	java/io/OutputStream:close	()V
    //   233: getstatic 38	com/tencent/mm/modelsfs/FileOp:fOi	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   236: invokevirtual 177	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   239: invokevirtual 182	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   242: ldc_w 400
    //   245: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: iconst_1
    //   249: ireturn
    //   250: astore_0
    //   251: aconst_null
    //   252: astore 5
    //   254: aconst_null
    //   255: astore_2
    //   256: aload_2
    //   257: ifnull +7 -> 264
    //   260: aload_2
    //   261: invokevirtual 115	java/io/InputStream:close	()V
    //   264: aload 5
    //   266: ifnull +8 -> 274
    //   269: aload 5
    //   271: invokevirtual 116	java/io/OutputStream:close	()V
    //   274: getstatic 38	com/tencent/mm/modelsfs/FileOp:fOi	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   277: invokevirtual 177	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   280: invokevirtual 182	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   283: ldc_w 400
    //   286: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: aload_0
    //   290: athrow
    //   291: astore_0
    //   292: goto -63 -> 229
    //   295: astore_0
    //   296: goto -63 -> 233
    //   299: astore_0
    //   300: goto -100 -> 200
    //   303: astore_0
    //   304: goto -96 -> 208
    //   307: astore_2
    //   308: goto -44 -> 264
    //   311: astore_2
    //   312: goto -38 -> 274
    //   315: astore_0
    //   316: aconst_null
    //   317: astore 5
    //   319: goto -63 -> 256
    //   322: astore_0
    //   323: aload 4
    //   325: astore_2
    //   326: goto -70 -> 256
    //   329: astore 6
    //   331: aconst_null
    //   332: astore_3
    //   333: aconst_null
    //   334: astore_2
    //   335: goto -173 -> 162
    //   338: astore 6
    //   340: aconst_null
    //   341: astore_3
    //   342: goto -180 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramString	String
    //   137	17	1	i	int
    //   29	232	2	localObject1	Object
    //   307	1	2	localIOException1	IOException
    //   311	1	2	localIOException2	IOException
    //   325	10	2	localObject2	Object
    //   62	280	3	localObject3	Object
    //   116	208	4	localObject4	Object
    //   113	205	5	localObject5	Object
    //   123	28	6	arrayOfByte	byte[]
    //   160	24	6	localIOException3	IOException
    //   329	1	6	localIOException4	IOException
    //   338	1	6	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   118	125	160	java/io/IOException
    //   131	138	160	java/io/IOException
    //   149	157	160	java/io/IOException
    //   51	72	250	finally
    //   225	229	291	java/io/IOException
    //   229	233	295	java/io/IOException
    //   196	200	299	java/io/IOException
    //   204	208	303	java/io/IOException
    //   260	264	307	java/io/IOException
    //   269	274	311	java/io/IOException
    //   72	103	315	finally
    //   103	112	315	finally
    //   118	125	322	finally
    //   131	138	322	finally
    //   149	157	322	finally
    //   168	192	322	finally
    //   51	72	329	java/io/IOException
    //   72	103	338	java/io/IOException
    //   103	112	338	java/io/IOException
  }
  
  @Deprecated
  public static long ub(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(93188);
    if (paramString == null)
    {
      AppMethodBeat.o(93188);
      return 0L;
    }
    SFSContextRec localSFSContextRec = tZ(paramString);
    if (localSFSContextRec != null)
    {
      localObject = paramString.substring(localSFSContextRec.fOn.length());
      localObject = localSFSContextRec.fOr.uj((String)localObject);
      if (localObject == null) {
        if (localSFSContextRec.fOp) {
          if (!f.ue(paramString)) {
            break label188;
          }
        }
      }
    }
    label188:
    for (Object localObject = f.uf(paramString);; localObject = paramString)
    {
      for (l = new File((String)localObject).length();; l = ((SFSContext.FileEntry)localObject).size)
      {
        fOi.readLock().unlock();
        if (localSFSContextRec != null) {
          break;
        }
        localObject = "regular";
        label107:
        ab.d("MicroMsg.FileOp", "readFileLength: %s [%d, %s]", new Object[] { paramString, Long.valueOf(l), localObject });
        AppMethodBeat.o(93188);
        return l;
      }
      if (f.ue(paramString)) {}
      for (localObject = f.uf(paramString);; localObject = paramString)
      {
        l = new File((String)localObject).length();
        break;
        localObject = "SFS";
        break label107;
      }
    }
  }
  
  /* Error */
  @Deprecated
  public static byte[] uc(String paramString)
  {
    // Byte code:
    //   0: ldc_w 437
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +11 -> 18
    //   10: ldc_w 437
    //   13: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: aconst_null
    //   17: areturn
    //   18: new 439	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: sipush 2048
    //   25: invokespecial 441	java/io/ByteArrayOutputStream:<init>	(I)V
    //   28: astore 5
    //   30: aload_0
    //   31: invokestatic 86	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   34: astore 4
    //   36: aload 4
    //   38: astore_3
    //   39: sipush 1024
    //   42: newarray byte
    //   44: astore 6
    //   46: ldc_w 442
    //   49: istore_1
    //   50: aload 4
    //   52: astore_3
    //   53: aload 4
    //   55: aload 6
    //   57: iconst_0
    //   58: iload_1
    //   59: sipush 1024
    //   62: invokestatic 448	java/lang/Math:min	(II)I
    //   65: invokevirtual 451	java/io/InputStream:read	([BII)I
    //   68: istore_2
    //   69: iload_2
    //   70: iconst_m1
    //   71: if_icmpeq +26 -> 97
    //   74: iload_1
    //   75: ifle +22 -> 97
    //   78: aload 4
    //   80: astore_3
    //   81: aload 5
    //   83: aload 6
    //   85: iconst_0
    //   86: iload_2
    //   87: invokevirtual 452	java/io/ByteArrayOutputStream:write	([BII)V
    //   90: iload_1
    //   91: iload_2
    //   92: isub
    //   93: istore_1
    //   94: goto -44 -> 50
    //   97: aload 4
    //   99: ifnull +8 -> 107
    //   102: aload 4
    //   104: invokevirtual 115	java/io/InputStream:close	()V
    //   107: aload 5
    //   109: invokevirtual 456	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   112: astore_3
    //   113: aload 5
    //   115: invokevirtual 457	java/io/ByteArrayOutputStream:close	()V
    //   118: ldc 104
    //   120: ldc_w 459
    //   123: iconst_2
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_0
    //   130: aastore
    //   131: dup
    //   132: iconst_1
    //   133: aload_3
    //   134: arraylength
    //   135: invokestatic 464	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: ldc_w 437
    //   145: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: aload_3
    //   149: areturn
    //   150: astore 5
    //   152: aconst_null
    //   153: astore 4
    //   155: aload 4
    //   157: astore_3
    //   158: ldc 104
    //   160: new 324	java/lang/StringBuilder
    //   163: dup
    //   164: ldc_w 466
    //   167: invokespecial 467	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_0
    //   171: invokevirtual 470	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc_w 472
    //   177: invokevirtual 470	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 122	java/io/IOException:getMessage	()Ljava/lang/String;
    //   185: invokevirtual 470	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 343	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 475	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 4
    //   196: ifnull +8 -> 204
    //   199: aload 4
    //   201: invokevirtual 115	java/io/InputStream:close	()V
    //   204: ldc_w 437
    //   207: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aconst_null
    //   211: areturn
    //   212: astore_0
    //   213: aconst_null
    //   214: astore_3
    //   215: aload_3
    //   216: ifnull +7 -> 223
    //   219: aload_3
    //   220: invokevirtual 115	java/io/InputStream:close	()V
    //   223: ldc_w 437
    //   226: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_0
    //   230: athrow
    //   231: astore_3
    //   232: goto -125 -> 107
    //   235: astore_0
    //   236: goto -32 -> 204
    //   239: astore_3
    //   240: goto -17 -> 223
    //   243: astore 4
    //   245: goto -127 -> 118
    //   248: astore_0
    //   249: goto -34 -> 215
    //   252: astore 5
    //   254: goto -99 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramString	String
    //   49	45	1	i	int
    //   68	25	2	j	int
    //   38	182	3	localObject	Object
    //   231	1	3	localIOException1	IOException
    //   239	1	3	localIOException2	IOException
    //   34	166	4	localInputStream	InputStream
    //   243	1	4	localIOException3	IOException
    //   28	86	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   150	31	5	localIOException4	IOException
    //   252	1	5	localIOException5	IOException
    //   44	40	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	36	150	java/io/IOException
    //   30	36	212	finally
    //   102	107	231	java/io/IOException
    //   199	204	235	java/io/IOException
    //   219	223	239	java/io/IOException
    //   113	118	243	java/io/IOException
    //   39	46	248	finally
    //   53	69	248	finally
    //   81	90	248	finally
    //   158	194	248	finally
    //   39	46	252	java/io/IOException
    //   53	69	252	java/io/IOException
    //   81	90	252	java/io/IOException
  }
  
  @Deprecated
  public static boolean ud(String paramString)
  {
    AppMethodBeat.i(93198);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(93198);
      return false;
    }
    Object localObject2 = tZ(paramString);
    boolean bool;
    Iterator localIterator;
    if (localObject2 != null)
    {
      localObject1 = paramString;
      try
      {
        if (paramString.equals(((SFSContextRec)localObject2).fOn))
        {
          localObject1 = paramString;
          localObject2 = ((SFSContextRec)localObject2).fOr;
          localObject1 = paramString;
          if (((SFSContext)localObject2).mNativePtr == 0L)
          {
            localObject1 = paramString;
            localObject2 = new IllegalArgumentException("Reuse already released SFSContext.");
            localObject1 = paramString;
            AppMethodBeat.o(93198);
            localObject1 = paramString;
            throw ((Throwable)localObject2);
          }
        }
      }
      catch (IOException paramString)
      {
        ab.printErrStackTrace("MicroMsg.FileOp", paramString, "deleteDirIncludedFiles failed: ".concat(String.valueOf(localObject1)), new Object[0]);
        bool = false;
      }
      for (;;)
      {
        fOi.readLock().unlock();
        AppMethodBeat.o(93198);
        return bool;
        localObject1 = paramString;
        if (SFSContext.nativeClear(((SFSContext)localObject2).mNativePtr) != 0)
        {
          localObject1 = paramString;
          localObject2 = new IOException(SFSContext.nativeErrorMessage());
          localObject1 = paramString;
          AppMethodBeat.o(93198);
          localObject1 = paramString;
          throw ((Throwable)localObject2);
          localObject1 = paramString;
          paramString = paramString.substring(((SFSContextRec)localObject2).fOn.length());
          localObject1 = paramString;
          localIterator = ((SFSContextRec)localObject2).fOr.ui(paramString).iterator();
          for (;;)
          {
            localObject1 = paramString;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject1 = paramString;
            SFSContext.FileEntry localFileEntry = (SFSContext.FileEntry)localIterator.next();
            localObject1 = paramString;
            ((SFSContextRec)localObject2).fOr.qD(localFileEntry.name);
          }
        }
        bool = true;
      }
    }
    Object localObject1 = new File(paramString);
    paramString = new ArrayDeque();
    paramString.add(new a((File)localObject1));
    label408:
    label414:
    for (;;)
    {
      localObject1 = (a)paramString.getLast();
      if (((a)localObject1).fOm == null) {
        ((a)localObject1).fOm = ((a)localObject1).dir.listFiles();
      }
      if (((a)localObject1).fOm != null)
      {
        localObject2 = ((a)localObject1).fOm;
        int i = ((a)localObject1).pos;
        if (i >= localObject2.length) {
          break label408;
        }
        localIterator = localObject2[i];
        if (localIterator.isFile()) {
          localIterator.delete();
        }
        while (!localIterator.isDirectory())
        {
          i += 1;
          break;
        }
        ((a)localObject1).pos = i;
        paramString.add(new a(localIterator));
      }
      for (;;)
      {
        if (!paramString.isEmpty()) {
          break label414;
        }
        bool = true;
        break;
        paramString.removeLast();
      }
    }
  }
  
  static class SFSContextRec
    implements Parcelable
  {
    public static final Parcelable.Creator<SFSContextRec> CREATOR;
    String fOn;
    String[] fOo;
    boolean fOp;
    boolean fOq;
    SFSContext fOr;
    SFSContext.Builder fOs;
    
    static
    {
      AppMethodBeat.i(93179);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(93179);
    }
    
    public SFSContextRec() {}
    
    SFSContextRec(Parcel paramParcel)
    {
      AppMethodBeat.i(93178);
      this.fOn = paramParcel.readString();
      this.fOo = paramParcel.createStringArray();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.fOp = bool;
        this.fOr = null;
        this.fOq = false;
        this.fOs = ((SFSContext.Builder)paramParcel.readParcelable(SFSContext.Builder.class.getClassLoader()));
        AppMethodBeat.o(93178);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(93177);
      paramParcel.writeString(this.fOn);
      paramParcel.writeStringArray(this.fOo);
      if (this.fOp) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeParcelable(this.fOs, paramInt);
        AppMethodBeat.o(93177);
        return;
      }
    }
  }
  
  final class a
  {
    File[] fOm = null;
    int pos = 0;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsfs.FileOp
 * JD-Core Version:    0.7.0.1
 */