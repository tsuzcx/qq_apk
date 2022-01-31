package com.tencent.mm.modelsfs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public final class FileOp
{
  private static ReentrantReadWriteLock eyv = new ReentrantReadWriteLock();
  private static TreeMap<String, SFSContextRec> eyw = new TreeMap();
  private static String eyx = "";
  private static final EnumSet<g.a> eyy = EnumSet.of(g.a.eyG, g.a.eyH);
  
  public static Map<String, SFSContext.Statistics> Qb()
  {
    eyv.readLock().lock();
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = eyw.values().iterator();
    while (localIterator.hasNext())
    {
      SFSContextRec localSFSContextRec = (SFSContextRec)localIterator.next();
      if ((localSFSContextRec != null) && (!localSFSContextRec.eyC))
      {
        if (localSFSContextRec.eyD == null) {}
        try
        {
          SFSContext localSFSContext = localSFSContextRec.eyD;
          if (localSFSContext == null) {}
          try
          {
            localSFSContextRec.eyD = localSFSContextRec.eyE.create();
            localSFSContext = localSFSContextRec.eyD;
            if (localSFSContext.mNativePtr != 0L) {
              break label155;
            }
            throw new IllegalArgumentException("Reuse already released SFSContext.");
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.FileOp", "Failed to create SFSContext for prefix '%s': %s", new Object[] { localSFSContextRec.eyz, localException.getMessage() });
            localSFSContextRec.eyC = true;
          }
          continue;
        }
        finally {}
        label155:
        SFSContext.Statistics localStatistics = SFSContext.nativeStatistics(localException.mNativePtr);
        localMap.put(localSFSContextRec.eyE.mName, localStatistics);
      }
    }
    eyv.readLock().unlock();
    return localMap;
  }
  
  private static boolean a(String paramString, SFSContextRec paramSFSContextRec)
  {
    if (paramSFSContextRec.eyA == null) {}
    for (;;)
    {
      return false;
      paramString = paramString.substring(paramSFSContextRec.eyz.length());
      int i = paramString.lastIndexOf('/');
      if (i != -1)
      {
        paramString = paramString.substring(i + 1);
        if (paramString.length() != 0)
        {
          paramSFSContextRec = paramSFSContextRec.eyA;
          int j = paramSFSContextRec.length;
          i = 0;
          while (i < j)
          {
            if (g.a(paramSFSContextRec[i], 0, paramString, 0, eyy)) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
  }
  
  @Deprecated
  public static boolean aA(String paramString1, String paramString2)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString2 == null) || (paramString1.length() == 0) || (paramString2.length() == 0)) {
      bool = false;
    }
    String str1;
    do
    {
      return bool;
      str1 = paramString1;
      str2 = paramString2;
      if (!mO(paramString1)) {
        break;
      }
      str1 = paramString1;
      str2 = paramString2;
      if (!mO(paramString2)) {
        break;
      }
      str1 = paramString1;
      if (f.mT(paramString1)) {
        str1 = f.mU(paramString1);
      }
      paramString1 = paramString2;
      if (f.mT(paramString2)) {
        paramString1 = f.mU(paramString2);
      }
    } while (new File(str1).renameTo(new File(paramString1)));
    String str2 = paramString1;
    if (r(str1, str2) < 0L) {
      return false;
    }
    deleteFile(str1);
    return true;
  }
  
  @Deprecated
  private static OutputStream az(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      throw new FileNotFoundException("path == null");
    }
    Object localObject = mP(paramString1);
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString2))
        {
          paramString2 = new c(paramString1, paramString2);
          eyv.readLock().unlock();
          if (localObject != null) {
            break label138;
          }
          localObject = "regular";
          y.d("MicroMsg.FileOp", "openWrite: %s [%s, %s]", new Object[] { paramString1, "ok", localObject });
          return paramString2;
        }
        paramString2 = new FileOutputStream(paramString1);
        continue;
        str = paramString1.substring(((SFSContextRec)localObject).eyz.length());
      }
      finally
      {
        eyv.readLock().unlock();
      }
      String str;
      paramString2 = ((SFSContextRec)localObject).eyD.aB(str, paramString2);
      continue;
      label138:
      localObject = "SFS";
    }
  }
  
  /* Error */
  @Deprecated
  private static int b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_1
    //   3: ifnonnull +8 -> 11
    //   6: bipush 254
    //   8: istore_2
    //   9: iload_2
    //   10: ireturn
    //   11: aload_1
    //   12: arraylength
    //   13: iload_2
    //   14: iconst_0
    //   15: iadd
    //   16: if_icmpge +6 -> 22
    //   19: bipush 253
    //   21: ireturn
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 4
    //   28: aload_0
    //   29: invokestatic 253	com/tencent/mm/modelsfs/FileOp:jI	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   32: astore 6
    //   34: aload 6
    //   36: astore 4
    //   38: aload 6
    //   40: astore 5
    //   42: aload 6
    //   44: aload_1
    //   45: iconst_0
    //   46: iload_2
    //   47: invokevirtual 259	java/io/OutputStream:write	([BII)V
    //   50: iload_3
    //   51: istore_2
    //   52: aload 6
    //   54: ifnull -45 -> 9
    //   57: aload 6
    //   59: invokevirtual 262	java/io/OutputStream:close	()V
    //   62: iconst_0
    //   63: ireturn
    //   64: astore_0
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_1
    //   68: aload 4
    //   70: astore 5
    //   72: ldc 119
    //   74: ldc_w 264
    //   77: iconst_2
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: aload_1
    //   88: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
    //   91: aastore
    //   92: invokestatic 134	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload 4
    //   97: ifnull +8 -> 105
    //   100: aload 4
    //   102: invokevirtual 262	java/io/OutputStream:close	()V
    //   105: iconst_m1
    //   106: ireturn
    //   107: astore_0
    //   108: aload 5
    //   110: ifnull +8 -> 118
    //   113: aload 5
    //   115: invokevirtual 262	java/io/OutputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_0
    //   121: goto -16 -> 105
    //   124: astore_1
    //   125: goto -7 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramString	String
    //   0	128	1	paramArrayOfByte	byte[]
    //   0	128	2	paramInt	int
    //   1	50	3	i	int
    //   26	75	4	localObject1	Object
    //   23	91	5	localObject2	Object
    //   32	26	6	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   57	62	64	java/io/IOException
    //   28	34	67	java/io/IOException
    //   42	50	67	java/io/IOException
    //   28	34	107	finally
    //   42	50	107	finally
    //   72	95	107	finally
    //   100	105	120	java/io/IOException
    //   113	118	124	java/io/IOException
  }
  
  @Deprecated
  public static boolean bK(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    Object localObject = mP(paramString);
    boolean bool1;
    if (localObject != null)
    {
      boolean bool2 = ((SFSContextRec)localObject).eyD.exists(paramString.substring(((SFSContextRec)localObject).eyz.length()));
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (((SFSContextRec)localObject).eyB) {
          bool1 = new File(paramString).exists();
        }
      }
      eyv.readLock().unlock();
      if (localObject != null) {
        break label128;
      }
    }
    label128:
    for (localObject = "regular";; localObject = "SFS")
    {
      y.d("MicroMsg.FileOp", "fileExists: %s [%b, %s]", new Object[] { paramString, Boolean.valueOf(bool1), localObject });
      return bool1;
      bool1 = new File(paramString).exists();
      break;
    }
  }
  
  /* Error */
  @Deprecated
  public static String bP(String paramString)
  {
    // Byte code:
    //   0: new 285	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 286	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: new 288	java/io/InputStreamReader
    //   12: dup
    //   13: aload_0
    //   14: invokestatic 292	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: invokespecial 295	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: sipush 512
    //   26: newarray char
    //   28: astore 5
    //   30: aload_3
    //   31: astore_2
    //   32: aload_3
    //   33: aload 5
    //   35: invokevirtual 299	java/io/InputStreamReader:read	([C)I
    //   38: istore_1
    //   39: iload_1
    //   40: iconst_m1
    //   41: if_icmpeq +62 -> 103
    //   44: aload_3
    //   45: astore_2
    //   46: aload 4
    //   48: aload 5
    //   50: iconst_0
    //   51: iload_1
    //   52: invokevirtual 303	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: goto -26 -> 30
    //   59: astore 4
    //   61: aload_3
    //   62: astore_2
    //   63: ldc 119
    //   65: ldc_w 305
    //   68: iconst_2
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload_0
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: aload 4
    //   80: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
    //   83: aastore
    //   84: invokestatic 134	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_3
    //   88: astore_2
    //   89: aload 4
    //   91: athrow
    //   92: astore_0
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 306	java/io/InputStreamReader:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: aload_3
    //   104: invokevirtual 306	java/io/InputStreamReader:close	()V
    //   107: aload 4
    //   109: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: areturn
    //   113: astore_0
    //   114: goto -7 -> 107
    //   117: astore_2
    //   118: goto -17 -> 101
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_2
    //   124: goto -31 -> 93
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_3
    //   131: goto -70 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   38	14	1	i	int
    //   22	76	2	localInputStreamReader1	java.io.InputStreamReader
    //   117	1	2	localIOException1	java.io.IOException
    //   123	1	2	localObject	Object
    //   20	111	3	localInputStreamReader2	java.io.InputStreamReader
    //   7	40	4	localStringBuilder	java.lang.StringBuilder
    //   59	49	4	localIOException2	java.io.IOException
    //   127	1	4	localIOException3	java.io.IOException
    //   28	21	5	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   23	30	59	java/io/IOException
    //   32	39	59	java/io/IOException
    //   46	56	59	java/io/IOException
    //   23	30	92	finally
    //   32	39	92	finally
    //   46	56	92	finally
    //   63	87	92	finally
    //   89	92	92	finally
    //   103	107	113	java/io/IOException
    //   97	101	117	java/io/IOException
    //   9	21	121	finally
    //   9	21	127	java/io/IOException
  }
  
  @Deprecated
  public static boolean deleteFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    SFSContextRec localSFSContextRec = mP(paramString);
    boolean bool1;
    if (localSFSContextRec != null)
    {
      str = paramString.substring(localSFSContextRec.eyz.length());
      boolean bool2 = localSFSContextRec.eyD.jJ(str);
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (localSFSContextRec.eyB) {
          if (!f.mT(paramString)) {
            break label171;
          }
        }
      }
    }
    label166:
    label171:
    for (String str = f.mU(paramString);; str = paramString)
    {
      bool1 = new File(str).delete();
      eyv.readLock().unlock();
      if (localSFSContextRec == null)
      {
        str = "regular";
        label104:
        y.d("MicroMsg.FileOp", "deleteFile: %s [%b, %s]", new Object[] { paramString, Boolean.valueOf(bool1), str });
        return bool1;
        if (!f.mT(paramString)) {
          break label166;
        }
      }
      for (str = f.mU(paramString);; str = paramString)
      {
        bool1 = new File(str).delete();
        break;
        str = "SFS";
        break label104;
      }
    }
  }
  
  @Deprecated
  public static OutputStream jI(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new FileNotFoundException("path == null");
    }
    String str2 = "";
    String str1 = paramString;
    if (f.mT(paramString))
    {
      str2 = f.mW(paramString);
      str1 = f.mU(paramString);
    }
    return az(str1, str2);
  }
  
  @Deprecated
  public static int k(String paramString, byte[] paramArrayOfByte)
  {
    return b(paramString, paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private static boolean mO(String paramString)
  {
    eyv.readLock().lock();
    Object localObject = eyw.floorEntry(paramString);
    if ((localObject != null) && (paramString.startsWith((String)((Map.Entry)localObject).getKey())))
    {
      localObject = (SFSContextRec)((Map.Entry)localObject).getValue();
      if ((((SFSContextRec)localObject).eyC) || (a(paramString, (SFSContextRec)localObject))) {}
    }
    for (boolean bool = false;; bool = true)
    {
      eyv.readLock().unlock();
      return bool;
    }
  }
  
  /* Error */
  private static SFSContextRec mP(String paramString)
  {
    // Byte code:
    //   0: getstatic 26	com/tencent/mm/modelsfs/FileOp:eyv	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   3: invokevirtual 61	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 66	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: getstatic 31	com/tencent/mm/modelsfs/FileOp:eyw	Ljava/util/TreeMap;
    //   12: aload_0
    //   13: invokevirtual 330	java/util/TreeMap:floorEntry	(Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +7 -> 25
    //   21: aconst_null
    //   22: astore_0
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: aload_1
    //   27: invokeinterface 335 1 0
    //   32: checkcast 158	java/lang/String
    //   35: invokevirtual 338	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   38: ifeq +113 -> 151
    //   41: aload_1
    //   42: invokeinterface 341 1 0
    //   47: checkcast 6	com/tencent/mm/modelsfs/FileOp$SFSContextRec
    //   50: astore_2
    //   51: aload_2
    //   52: astore_1
    //   53: aload_0
    //   54: aload_2
    //   55: invokestatic 343	com/tencent/mm/modelsfs/FileOp:a	(Ljava/lang/String;Lcom/tencent/mm/modelsfs/FileOp$SFSContextRec;)Z
    //   58: ifeq +5 -> 63
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +85 -> 149
    //   67: aload_1
    //   68: getfield 90	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyC	Z
    //   71: ifne +78 -> 149
    //   74: aload_1
    //   75: astore_0
    //   76: aload_1
    //   77: getfield 94	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyD	Lcom/tencent/mm/modelsfs/SFSContext;
    //   80: ifnonnull -57 -> 23
    //   83: aload_1
    //   84: monitorenter
    //   85: aload_1
    //   86: getfield 94	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyD	Lcom/tencent/mm/modelsfs/SFSContext;
    //   89: astore_0
    //   90: aload_0
    //   91: ifnonnull +14 -> 105
    //   94: aload_1
    //   95: aload_1
    //   96: getfield 98	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyE	Lcom/tencent/mm/modelsfs/SFSContext$Builder;
    //   99: invokevirtual 104	com/tencent/mm/modelsfs/SFSContext$Builder:create	()Lcom/tencent/mm/modelsfs/SFSContext;
    //   102: putfield 94	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyD	Lcom/tencent/mm/modelsfs/SFSContext;
    //   105: aload_1
    //   106: monitorexit
    //   107: aload_1
    //   108: areturn
    //   109: astore_0
    //   110: aload_1
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    //   114: astore_0
    //   115: ldc 119
    //   117: ldc 121
    //   119: iconst_2
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_1
    //   126: getfield 124	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyz	Ljava/lang/String;
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: aload_0
    //   133: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 134	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_1
    //   141: iconst_1
    //   142: putfield 90	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyC	Z
    //   145: aload_1
    //   146: monitorexit
    //   147: aconst_null
    //   148: areturn
    //   149: aconst_null
    //   150: areturn
    //   151: aconst_null
    //   152: astore_1
    //   153: goto -90 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   16	137	1	localObject	Object
    //   50	5	2	localSFSContextRec	SFSContextRec
    // Exception table:
    //   from	to	target	type
    //   85	90	109	finally
    //   94	105	109	finally
    //   105	107	109	finally
    //   110	112	109	finally
    //   115	147	109	finally
    //   94	105	114	java/lang/Exception
  }
  
  /* Error */
  @Deprecated
  public static boolean mQ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 162	java/lang/String:length	()I
    //   8: ifne +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_0
    //   14: invokestatic 217	com/tencent/mm/modelsfs/FileOp:mP	(Ljava/lang/String;)Lcom/tencent/mm/modelsfs/FileOp$SFSContextRec;
    //   17: astore_2
    //   18: aload_2
    //   19: ifnonnull +14 -> 33
    //   22: getstatic 26	com/tencent/mm/modelsfs/FileOp:eyv	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   25: invokevirtual 61	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   28: invokevirtual 148	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   31: iconst_1
    //   32: ireturn
    //   33: aload_0
    //   34: aload_2
    //   35: getfield 124	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyz	Ljava/lang/String;
    //   38: invokevirtual 162	java/lang/String:length	()I
    //   41: invokevirtual 166	java/lang/String:substring	(I)Ljava/lang/String;
    //   44: astore_3
    //   45: aload_2
    //   46: getfield 94	com/tencent/mm/modelsfs/FileOp$SFSContextRec:eyD	Lcom/tencent/mm/modelsfs/SFSContext;
    //   49: aload_3
    //   50: invokevirtual 345	com/tencent/mm/modelsfs/SFSContext:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: astore_2
    //   54: new 193	java/io/File
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: invokevirtual 348	java/io/File:getParent	()Ljava/lang/String;
    //   65: astore_3
    //   66: aload_3
    //   67: invokestatic 353	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   70: ifne +15 -> 85
    //   73: new 193	java/io/File
    //   76: dup
    //   77: aload_3
    //   78: invokespecial 194	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 356	java/io/File:mkdirs	()Z
    //   84: pop
    //   85: new 239	java/io/FileOutputStream
    //   88: dup
    //   89: aload_0
    //   90: invokespecial 240	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: astore 5
    //   97: aload_2
    //   98: astore 4
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore 6
    //   107: aload_3
    //   108: astore 5
    //   110: aload_2
    //   111: astore 4
    //   113: aload_2
    //   114: aload 6
    //   116: invokevirtual 361	java/io/InputStream:read	([B)I
    //   119: istore_1
    //   120: iload_1
    //   121: iconst_m1
    //   122: if_icmpeq +79 -> 201
    //   125: aload_3
    //   126: astore 5
    //   128: aload_2
    //   129: astore 4
    //   131: aload_3
    //   132: aload 6
    //   134: iconst_0
    //   135: iload_1
    //   136: invokevirtual 259	java/io/OutputStream:write	([BII)V
    //   139: goto -32 -> 107
    //   142: astore 6
    //   144: aload_3
    //   145: astore 5
    //   147: aload_2
    //   148: astore 4
    //   150: ldc 119
    //   152: ldc_w 363
    //   155: iconst_2
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload 6
    //   167: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
    //   170: aastore
    //   171: invokestatic 134	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: aload_2
    //   175: ifnull +7 -> 182
    //   178: aload_2
    //   179: invokevirtual 364	java/io/InputStream:close	()V
    //   182: aload_3
    //   183: ifnull +7 -> 190
    //   186: aload_3
    //   187: invokevirtual 262	java/io/OutputStream:close	()V
    //   190: getstatic 26	com/tencent/mm/modelsfs/FileOp:eyv	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   193: invokevirtual 61	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   196: invokevirtual 148	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_2
    //   202: invokevirtual 364	java/io/InputStream:close	()V
    //   205: aload_3
    //   206: invokevirtual 262	java/io/OutputStream:close	()V
    //   209: getstatic 26	com/tencent/mm/modelsfs/FileOp:eyv	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   212: invokevirtual 61	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   215: invokevirtual 148	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   218: iconst_1
    //   219: ireturn
    //   220: astore_0
    //   221: aconst_null
    //   222: astore 5
    //   224: aconst_null
    //   225: astore_2
    //   226: aload_2
    //   227: ifnull +7 -> 234
    //   230: aload_2
    //   231: invokevirtual 364	java/io/InputStream:close	()V
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 262	java/io/OutputStream:close	()V
    //   244: getstatic 26	com/tencent/mm/modelsfs/FileOp:eyv	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   247: invokevirtual 61	java/util/concurrent/locks/ReentrantReadWriteLock:readLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   250: invokevirtual 148	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   253: aload_0
    //   254: athrow
    //   255: astore_0
    //   256: goto -51 -> 205
    //   259: astore_0
    //   260: goto -51 -> 209
    //   263: astore_0
    //   264: goto -82 -> 182
    //   267: astore_0
    //   268: goto -78 -> 190
    //   271: astore_2
    //   272: goto -38 -> 234
    //   275: astore_2
    //   276: goto -32 -> 244
    //   279: astore_0
    //   280: aconst_null
    //   281: astore 5
    //   283: goto -57 -> 226
    //   286: astore_0
    //   287: aload 4
    //   289: astore_2
    //   290: goto -64 -> 226
    //   293: astore 6
    //   295: aconst_null
    //   296: astore_3
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -155 -> 144
    //   302: astore 6
    //   304: aconst_null
    //   305: astore_3
    //   306: goto -162 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramString	String
    //   119	17	1	i	int
    //   17	214	2	localObject1	Object
    //   271	1	2	localIOException1	java.io.IOException
    //   275	1	2	localIOException2	java.io.IOException
    //   289	10	2	localObject2	Object
    //   44	262	3	localObject3	Object
    //   98	190	4	localObject4	Object
    //   95	187	5	localObject5	Object
    //   105	28	6	arrayOfByte	byte[]
    //   142	24	6	localIOException3	java.io.IOException
    //   293	1	6	localIOException4	java.io.IOException
    //   302	1	6	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   100	107	142	java/io/IOException
    //   113	120	142	java/io/IOException
    //   131	139	142	java/io/IOException
    //   33	54	220	finally
    //   201	205	255	java/io/IOException
    //   205	209	259	java/io/IOException
    //   178	182	263	java/io/IOException
    //   186	190	267	java/io/IOException
    //   230	234	271	java/io/IOException
    //   239	244	275	java/io/IOException
    //   54	85	279	finally
    //   85	94	279	finally
    //   100	107	286	finally
    //   113	120	286	finally
    //   131	139	286	finally
    //   150	174	286	finally
    //   33	54	293	java/io/IOException
    //   54	85	302	java/io/IOException
    //   85	94	302	java/io/IOException
  }
  
  @Deprecated
  public static long mR(String paramString)
  {
    long l = 0L;
    if (paramString == null) {
      return 0L;
    }
    SFSContextRec localSFSContextRec = mP(paramString);
    if (localSFSContextRec != null)
    {
      localObject = paramString.substring(localSFSContextRec.eyz.length());
      localObject = localSFSContextRec.eyD.mY((String)localObject);
      if (localObject == null) {
        if (localSFSContextRec.eyB) {
          if (!f.mT(paramString)) {
            break label170;
          }
        }
      }
    }
    label170:
    for (Object localObject = f.mU(paramString);; localObject = paramString)
    {
      for (l = new File((String)localObject).length();; l = ((SFSContext.FileEntry)localObject).size)
      {
        eyv.readLock().unlock();
        if (localSFSContextRec != null) {
          break;
        }
        localObject = "regular";
        label95:
        y.d("MicroMsg.FileOp", "readFileLength: %s [%d, %s]", new Object[] { paramString, Long.valueOf(l), localObject });
        return l;
      }
      if (f.mT(paramString)) {}
      for (localObject = f.mU(paramString);; localObject = paramString)
      {
        l = new File((String)localObject).length();
        break;
        localObject = "SFS";
        break label95;
      }
    }
  }
  
  /* Error */
  @Deprecated
  public static byte[] mS(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 389	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 2048
    //   13: invokespecial 392	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore 5
    //   18: aload_0
    //   19: invokestatic 292	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore 4
    //   24: aload 4
    //   26: astore_3
    //   27: sipush 1024
    //   30: newarray byte
    //   32: astore 6
    //   34: ldc_w 393
    //   37: istore_1
    //   38: aload 4
    //   40: astore_3
    //   41: aload 4
    //   43: aload 6
    //   45: iconst_0
    //   46: iload_1
    //   47: sipush 1024
    //   50: invokestatic 399	java/lang/Math:min	(II)I
    //   53: invokevirtual 402	java/io/InputStream:read	([BII)I
    //   56: istore_2
    //   57: iload_2
    //   58: iconst_m1
    //   59: if_icmpeq +26 -> 85
    //   62: iload_1
    //   63: ifle +22 -> 85
    //   66: aload 4
    //   68: astore_3
    //   69: aload 5
    //   71: aload 6
    //   73: iconst_0
    //   74: iload_2
    //   75: invokevirtual 403	java/io/ByteArrayOutputStream:write	([BII)V
    //   78: iload_1
    //   79: iload_2
    //   80: isub
    //   81: istore_1
    //   82: goto -44 -> 38
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 364	java/io/InputStream:close	()V
    //   95: aload 5
    //   97: invokevirtual 407	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   100: astore_3
    //   101: aload 5
    //   103: invokevirtual 408	java/io/ByteArrayOutputStream:close	()V
    //   106: ldc 119
    //   108: ldc_w 410
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_0
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: aload_3
    //   122: arraylength
    //   123: invokestatic 415	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: aastore
    //   127: invokestatic 237	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_3
    //   131: areturn
    //   132: astore 5
    //   134: aconst_null
    //   135: astore 4
    //   137: aload 4
    //   139: astore_3
    //   140: ldc 119
    //   142: new 285	java/lang/StringBuilder
    //   145: dup
    //   146: ldc_w 417
    //   149: invokespecial 418	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: ldc_w 423
    //   159: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 5
    //   164: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 421	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 309	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 426	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 4
    //   178: ifnull -174 -> 4
    //   181: aload 4
    //   183: invokevirtual 364	java/io/InputStream:close	()V
    //   186: aconst_null
    //   187: areturn
    //   188: astore_0
    //   189: aconst_null
    //   190: areturn
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_3
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 364	java/io/InputStream:close	()V
    //   202: aload_0
    //   203: athrow
    //   204: astore_3
    //   205: goto -110 -> 95
    //   208: astore_3
    //   209: goto -7 -> 202
    //   212: astore 4
    //   214: goto -108 -> 106
    //   217: astore_0
    //   218: goto -24 -> 194
    //   221: astore 5
    //   223: goto -86 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramString	String
    //   37	45	1	i	int
    //   56	25	2	j	int
    //   26	173	3	localObject	Object
    //   204	1	3	localIOException1	java.io.IOException
    //   208	1	3	localIOException2	java.io.IOException
    //   22	160	4	localInputStream	InputStream
    //   212	1	4	localIOException3	java.io.IOException
    //   16	86	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   132	31	5	localIOException4	java.io.IOException
    //   221	1	5	localIOException5	java.io.IOException
    //   32	40	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   18	24	132	java/io/IOException
    //   181	186	188	java/io/IOException
    //   18	24	191	finally
    //   90	95	204	java/io/IOException
    //   198	202	208	java/io/IOException
    //   101	106	212	java/io/IOException
    //   27	34	217	finally
    //   41	57	217	finally
    //   69	78	217	finally
    //   140	176	217	finally
    //   27	34	221	java/io/IOException
    //   41	57	221	java/io/IOException
    //   69	78	221	java/io/IOException
  }
  
  @Deprecated
  public static InputStream openRead(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new FileNotFoundException("path == null");
    }
    Object localObject2 = mP(paramString);
    if (localObject2 == null) {}
    for (;;)
    {
      try
      {
        if (f.mT(paramString))
        {
          long l = f.mV(paramString);
          localObject1 = new b(f.mU(paramString), l);
          eyv.readLock().unlock();
          if (localObject2 != null) {
            break label176;
          }
          localObject2 = "regular";
          y.d("MicroMsg.FileOp", "openRead: %s [%s, %s]", new Object[] { paramString, "ok", localObject2 });
          return localObject1;
        }
        Object localObject1 = new FileInputStream(paramString);
        continue;
        try
        {
          localObject1 = paramString.substring(((SFSContextRec)localObject2).eyz.length());
          localObject1 = ((SFSContextRec)localObject2).eyD.openRead((String)localObject1);
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          if (!((SFSContextRec)localObject2).eyB) {
            throw localFileNotFoundException;
          }
          FileInputStream localFileInputStream = new FileInputStream(paramString);
        }
      }
      finally
      {
        eyv.readLock().unlock();
      }
      continue;
      label176:
      localObject2 = "SFS";
    }
  }
  
  /* Error */
  @Deprecated
  public static long r(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +21 -> 22
    //   4: aload_0
    //   5: invokevirtual 162	java/lang/String:length	()I
    //   8: ifeq +14 -> 22
    //   11: aload_1
    //   12: ifnull +10 -> 22
    //   15: aload_1
    //   16: invokevirtual 162	java/lang/String:length	()I
    //   19: ifne +11 -> 30
    //   22: ldc2_w 440
    //   25: lstore 5
    //   27: lload 5
    //   29: lreturn
    //   30: lconst_0
    //   31: lstore_3
    //   32: aload_0
    //   33: invokestatic 292	com/tencent/mm/modelsfs/FileOp:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore 8
    //   38: aload_1
    //   39: invokestatic 253	com/tencent/mm/modelsfs/FileOp:jI	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   42: astore 7
    //   44: sipush 1024
    //   47: newarray byte
    //   49: astore 9
    //   51: aload 8
    //   53: aload 9
    //   55: invokevirtual 361	java/io/InputStream:read	([B)I
    //   58: istore_2
    //   59: iload_2
    //   60: iconst_m1
    //   61: if_icmpeq +20 -> 81
    //   64: aload 7
    //   66: aload 9
    //   68: iconst_0
    //   69: iload_2
    //   70: invokevirtual 259	java/io/OutputStream:write	([BII)V
    //   73: lload_3
    //   74: iload_2
    //   75: i2l
    //   76: ladd
    //   77: lstore_3
    //   78: goto -27 -> 51
    //   81: ldc 119
    //   83: ldc_w 443
    //   86: iconst_2
    //   87: anewarray 4	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload_0
    //   93: aastore
    //   94: dup
    //   95: iconst_1
    //   96: aload_1
    //   97: aastore
    //   98: invokestatic 237	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload 8
    //   103: ifnull +8 -> 111
    //   106: aload 8
    //   108: invokevirtual 364	java/io/InputStream:close	()V
    //   111: lload_3
    //   112: lstore 5
    //   114: aload 7
    //   116: ifnull -89 -> 27
    //   119: aload 7
    //   121: invokevirtual 262	java/io/OutputStream:close	()V
    //   124: lload_3
    //   125: lreturn
    //   126: astore_0
    //   127: lload_3
    //   128: lreturn
    //   129: astore 9
    //   131: aconst_null
    //   132: astore 7
    //   134: aconst_null
    //   135: astore 8
    //   137: ldc 119
    //   139: ldc_w 445
    //   142: iconst_3
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_0
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_1
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: aload 9
    //   158: invokevirtual 265	java/io/IOException:getMessage	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 134	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: aload 8
    //   167: ifnull +8 -> 175
    //   170: aload 8
    //   172: invokevirtual 364	java/io/InputStream:close	()V
    //   175: aload 7
    //   177: ifnull +8 -> 185
    //   180: aload 7
    //   182: invokevirtual 262	java/io/OutputStream:close	()V
    //   185: ldc2_w 440
    //   188: lreturn
    //   189: astore_0
    //   190: aconst_null
    //   191: astore 7
    //   193: aconst_null
    //   194: astore 8
    //   196: aload 8
    //   198: ifnull +8 -> 206
    //   201: aload 8
    //   203: invokevirtual 364	java/io/InputStream:close	()V
    //   206: aload 7
    //   208: ifnull +8 -> 216
    //   211: aload 7
    //   213: invokevirtual 262	java/io/OutputStream:close	()V
    //   216: aload_0
    //   217: athrow
    //   218: astore_0
    //   219: goto -108 -> 111
    //   222: astore_0
    //   223: goto -48 -> 175
    //   226: astore_0
    //   227: goto -42 -> 185
    //   230: astore_1
    //   231: goto -25 -> 206
    //   234: astore_1
    //   235: goto -19 -> 216
    //   238: astore_0
    //   239: aconst_null
    //   240: astore 7
    //   242: goto -46 -> 196
    //   245: astore_0
    //   246: goto -50 -> 196
    //   249: astore_0
    //   250: goto -54 -> 196
    //   253: astore 9
    //   255: aconst_null
    //   256: astore 7
    //   258: goto -121 -> 137
    //   261: astore 9
    //   263: goto -126 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramString1	String
    //   0	266	1	paramString2	String
    //   58	17	2	i	int
    //   31	97	3	l1	long
    //   25	88	5	l2	long
    //   42	215	7	localOutputStream	OutputStream
    //   36	166	8	localInputStream	InputStream
    //   49	18	9	arrayOfByte	byte[]
    //   129	28	9	localIOException1	java.io.IOException
    //   253	1	9	localIOException2	java.io.IOException
    //   261	1	9	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   119	124	126	java/io/IOException
    //   32	38	129	java/io/IOException
    //   32	38	189	finally
    //   106	111	218	java/io/IOException
    //   170	175	222	java/io/IOException
    //   180	185	226	java/io/IOException
    //   201	206	230	java/io/IOException
    //   211	216	234	java/io/IOException
    //   38	44	238	finally
    //   44	51	245	finally
    //   51	59	245	finally
    //   64	73	245	finally
    //   81	101	245	finally
    //   137	165	249	finally
    //   38	44	253	java/io/IOException
    //   44	51	261	java/io/IOException
    //   51	59	261	java/io/IOException
    //   64	73	261	java/io/IOException
    //   81	101	261	java/io/IOException
  }
  
  static class SFSContextRec
    implements Parcelable
  {
    public static final Parcelable.Creator<SFSContextRec> CREATOR = new FileOp.SFSContextRec.1();
    String[] eyA;
    boolean eyB;
    boolean eyC;
    SFSContext eyD;
    SFSContext.Builder eyE;
    String eyz;
    
    public SFSContextRec() {}
    
    SFSContextRec(Parcel paramParcel)
    {
      this.eyz = paramParcel.readString();
      this.eyA = paramParcel.createStringArray();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.eyB = bool;
        this.eyD = null;
        this.eyC = false;
        this.eyE = ((SFSContext.Builder)paramParcel.readParcelable(SFSContext.Builder.class.getClassLoader()));
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.eyz);
      paramParcel.writeStringArray(this.eyA);
      if (this.eyB) {}
      for (int i = 1;; i = 0)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeParcelable(this.eyE, paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsfs.FileOp
 * JD-Core Version:    0.7.0.1
 */