package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzw
  implements zzb
{
  private final Map<String, zzw.zza> zzaw = new LinkedHashMap(16, 0.75F, true);
  private long zzax = 0L;
  private final File zzay;
  private final int zzaz;
  
  public zzw(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public zzw(File paramFile, int paramInt)
  {
    this.zzay = paramFile;
    this.zzaz = paramInt;
  }
  
  private void removeEntry(String paramString)
  {
    zzw.zza localzza = (zzw.zza)this.zzaw.get(paramString);
    if (localzza != null)
    {
      this.zzax -= localzza.zzaA;
      this.zzaw.remove(paramString);
    }
  }
  
  private static int zza(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    if (i == -1) {
      throw new EOFException();
    }
    return i;
  }
  
  static void zza(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void zza(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void zza(OutputStream paramOutputStream, String paramString)
  {
    paramString = paramString.getBytes("UTF-8");
    zza(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  private void zza(String paramString, zzw.zza paramzza)
  {
    if (!this.zzaw.containsKey(paramString)) {}
    zzw.zza localzza;
    long l;
    for (this.zzax += paramzza.zzaA;; this.zzax = (paramzza.zzaA - localzza.zzaA + l))
    {
      this.zzaw.put(paramString, paramzza);
      return;
      localzza = (zzw.zza)this.zzaw.get(paramString);
      l = this.zzax;
    }
  }
  
  static void zza(Map<String, String> paramMap, OutputStream paramOutputStream)
  {
    if (paramMap != null)
    {
      zza(paramOutputStream, paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        zza(paramOutputStream, (String)localEntry.getKey());
        zza(paramOutputStream, (String)localEntry.getValue());
      }
    }
    zza(paramOutputStream, 0);
  }
  
  private static byte[] zza(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
      if (j == -1) {
        break;
      }
      i += j;
    }
    if (i != paramInt) {
      throw new IOException("Expected " + paramInt + " bytes, read " + i + " bytes");
    }
    return arrayOfByte;
  }
  
  static int zzb(InputStream paramInputStream)
  {
    return zza(paramInputStream) << 0 | 0x0 | zza(paramInputStream) << 8 | zza(paramInputStream) << 16 | zza(paramInputStream) << 24;
  }
  
  static long zzc(InputStream paramInputStream)
  {
    return 0L | (zza(paramInputStream) & 0xFF) << 0 | (zza(paramInputStream) & 0xFF) << 8 | (zza(paramInputStream) & 0xFF) << 16 | (zza(paramInputStream) & 0xFF) << 24 | (zza(paramInputStream) & 0xFF) << 32 | (zza(paramInputStream) & 0xFF) << 40 | (zza(paramInputStream) & 0xFF) << 48 | (zza(paramInputStream) & 0xFF) << 56;
  }
  
  private void zzc(int paramInt)
  {
    if (this.zzax + paramInt < this.zzaz) {}
    label229:
    label233:
    for (;;)
    {
      return;
      if (zzt.DEBUG) {
        zzt.zza("Pruning old cache entries.", new Object[0]);
      }
      long l1 = this.zzax;
      long l2 = SystemClock.elapsedRealtime();
      Iterator localIterator = this.zzaw.entrySet().iterator();
      int i = 0;
      zzw.zza localzza;
      if (localIterator.hasNext())
      {
        localzza = (zzw.zza)((Map.Entry)localIterator.next()).getValue();
        if (zzf(localzza.zzaB).delete())
        {
          this.zzax -= localzza.zzaA;
          label119:
          localIterator.remove();
          i += 1;
          if ((float)(this.zzax + paramInt) >= this.zzaz * 0.9F) {
            break label229;
          }
        }
      }
      for (;;)
      {
        if (!zzt.DEBUG) {
          break label233;
        }
        zzt.zza("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(i), Long.valueOf(this.zzax - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
        return;
        zzt.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { localzza.zzaB, zze(localzza.zzaB) });
        break label119;
        break;
      }
    }
  }
  
  static String zzd(InputStream paramInputStream)
  {
    return new String(zza(paramInputStream, (int)zzc(paramInputStream)), "UTF-8");
  }
  
  private String zze(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  static Map<String, String> zze(InputStream paramInputStream)
  {
    int j = zzb(paramInputStream);
    if (j == 0) {}
    for (Object localObject = Collections.emptyMap();; localObject = new HashMap(j))
    {
      int i = 0;
      while (i < j)
      {
        ((Map)localObject).put(zzd(paramInputStream).intern(), zzd(paramInputStream).intern());
        i += 1;
      }
    }
    return localObject;
  }
  
  /* Error */
  public void initialize()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/google/android/gms/internal/zzw:zzay	Ljava/io/File;
    //   6: invokevirtual 276	java/io/File:exists	()Z
    //   9: ifne +36 -> 45
    //   12: aload_0
    //   13: getfield 43	com/google/android/gms/internal/zzw:zzay	Ljava/io/File;
    //   16: invokevirtual 279	java/io/File:mkdirs	()Z
    //   19: ifne +23 -> 42
    //   22: ldc_w 281
    //   25: iconst_1
    //   26: anewarray 4	java/lang/Object
    //   29: dup
    //   30: iconst_0
    //   31: aload_0
    //   32: getfield 43	com/google/android/gms/internal/zzw:zzay	Ljava/io/File;
    //   35: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   38: aastore
    //   39: invokestatic 286	com/google/android/gms/internal/zzt:zzc	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: getfield 43	com/google/android/gms/internal/zzw:zzay	Ljava/io/File;
    //   49: invokevirtual 290	java/io/File:listFiles	()[Ljava/io/File;
    //   52: astore 5
    //   54: aload 5
    //   56: ifnull -14 -> 42
    //   59: aload 5
    //   61: arraylength
    //   62: istore_2
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: iload_2
    //   67: if_icmpge -25 -> 42
    //   70: aload 5
    //   72: iload_1
    //   73: aaload
    //   74: astore 6
    //   76: new 292	java/io/BufferedInputStream
    //   79: dup
    //   80: new 294	java/io/FileInputStream
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 296	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 299	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore 4
    //   94: aload 4
    //   96: astore_3
    //   97: aload 4
    //   99: invokestatic 302	com/google/android/gms/internal/zzw$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzw$zza;
    //   102: astore 7
    //   104: aload 4
    //   106: astore_3
    //   107: aload 7
    //   109: aload 6
    //   111: invokevirtual 304	java/io/File:length	()J
    //   114: putfield 56	com/google/android/gms/internal/zzw$zza:zzaA	J
    //   117: aload 4
    //   119: astore_3
    //   120: aload_0
    //   121: aload 7
    //   123: getfield 195	com/google/android/gms/internal/zzw$zza:zzaB	Ljava/lang/String;
    //   126: aload 7
    //   128: invokespecial 306	com/google/android/gms/internal/zzw:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzw$zza;)V
    //   131: aload 4
    //   133: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   136: iload_1
    //   137: iconst_1
    //   138: iadd
    //   139: istore_1
    //   140: goto -75 -> 65
    //   143: astore_3
    //   144: aconst_null
    //   145: astore 4
    //   147: aload 6
    //   149: ifnull +12 -> 161
    //   152: aload 4
    //   154: astore_3
    //   155: aload 6
    //   157: invokevirtual 204	java/io/File:delete	()Z
    //   160: pop
    //   161: aload 4
    //   163: ifnull -27 -> 136
    //   166: aload 4
    //   168: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   171: goto -35 -> 136
    //   174: astore_3
    //   175: goto -39 -> 136
    //   178: astore_3
    //   179: aconst_null
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +8 -> 192
    //   187: aload 4
    //   189: invokevirtual 309	java/io/BufferedInputStream:close	()V
    //   192: aload_3
    //   193: athrow
    //   194: astore_3
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_3
    //   198: athrow
    //   199: astore_3
    //   200: goto -64 -> 136
    //   203: astore 4
    //   205: goto -13 -> 192
    //   208: astore 4
    //   210: aload_3
    //   211: astore 5
    //   213: aload 4
    //   215: astore_3
    //   216: aload 5
    //   218: astore 4
    //   220: goto -38 -> 182
    //   223: astore_3
    //   224: goto -77 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	zzw
    //   64	76	1	i	int
    //   62	6	2	j	int
    //   96	24	3	localBufferedInputStream1	java.io.BufferedInputStream
    //   143	1	3	localIOException1	IOException
    //   154	1	3	localBufferedInputStream2	java.io.BufferedInputStream
    //   174	1	3	localIOException2	IOException
    //   178	15	3	localObject1	Object
    //   194	4	3	localObject2	Object
    //   199	12	3	localIOException3	IOException
    //   215	1	3	localObject3	Object
    //   223	1	3	localIOException4	IOException
    //   92	96	4	localBufferedInputStream3	java.io.BufferedInputStream
    //   203	1	4	localIOException5	IOException
    //   208	6	4	localObject4	Object
    //   218	1	4	localObject5	Object
    //   52	165	5	localObject6	Object
    //   74	82	6	localFile	File
    //   102	25	7	localzza	zzw.zza
    // Exception table:
    //   from	to	target	type
    //   76	94	143	java/io/IOException
    //   166	171	174	java/io/IOException
    //   76	94	178	finally
    //   2	42	194	finally
    //   45	54	194	finally
    //   59	63	194	finally
    //   131	136	194	finally
    //   166	171	194	finally
    //   187	192	194	finally
    //   192	194	194	finally
    //   131	136	199	java/io/IOException
    //   187	192	203	java/io/IOException
    //   97	104	208	finally
    //   107	117	208	finally
    //   120	131	208	finally
    //   155	161	208	finally
    //   97	104	223	java/io/IOException
    //   107	117	223	java/io/IOException
    //   120	131	223	java/io/IOException
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = zzf(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        zzt.zzb("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, zze(paramString) });
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public zzb.zza zza(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/google/android/gms/internal/zzw:zzaw	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 53 2 0
    //   12: checkcast 10	com/google/android/gms/internal/zzw$zza
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +9 -> 28
    //   22: aconst_null
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 199	com/google/android/gms/internal/zzw:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   33: astore 5
    //   35: new 12	com/google/android/gms/internal/zzw$zzb
    //   38: dup
    //   39: new 292	java/io/BufferedInputStream
    //   42: dup
    //   43: new 294	java/io/FileInputStream
    //   46: dup
    //   47: aload 5
    //   49: invokespecial 296	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: invokespecial 299	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   55: aconst_null
    //   56: invokespecial 315	com/google/android/gms/internal/zzw$zzb:<init>	(Ljava/io/InputStream;Lcom/google/android/gms/internal/zzw$1;)V
    //   59: astore_3
    //   60: aload_3
    //   61: astore_2
    //   62: aload_3
    //   63: invokestatic 302	com/google/android/gms/internal/zzw$zza:zzf	(Ljava/io/InputStream;)Lcom/google/android/gms/internal/zzw$zza;
    //   66: pop
    //   67: aload_3
    //   68: astore_2
    //   69: aload 4
    //   71: aload_3
    //   72: aload 5
    //   74: invokevirtual 304	java/io/File:length	()J
    //   77: aload_3
    //   78: invokestatic 318	com/google/android/gms/internal/zzw$zzb:zza	(Lcom/google/android/gms/internal/zzw$zzb;)I
    //   81: i2l
    //   82: lsub
    //   83: l2i
    //   84: invokestatic 234	com/google/android/gms/internal/zzw:zza	(Ljava/io/InputStream;I)[B
    //   87: invokevirtual 321	com/google/android/gms/internal/zzw$zza:zzb	([B)Lcom/google/android/gms/internal/zzb$zza;
    //   90: astore 4
    //   92: aload 4
    //   94: astore_1
    //   95: aload_3
    //   96: invokevirtual 322	com/google/android/gms/internal/zzw$zzb:close	()V
    //   99: goto -75 -> 24
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_1
    //   105: goto -81 -> 24
    //   108: astore 4
    //   110: aconst_null
    //   111: astore_3
    //   112: aload_3
    //   113: astore_2
    //   114: ldc_w 324
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload 5
    //   125: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: aload 4
    //   133: invokevirtual 325	java/io/IOException:toString	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 228	com/google/android/gms/internal/zzt:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_3
    //   141: astore_2
    //   142: aload_0
    //   143: aload_1
    //   144: invokevirtual 327	com/google/android/gms/internal/zzw:remove	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: ifnull +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 322	com/google/android/gms/internal/zzw$zzb:close	()V
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -133 -> 24
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -139 -> 24
    //   166: astore_1
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_2
    //   170: ifnull +7 -> 177
    //   173: aload_2
    //   174: invokevirtual 322	com/google/android/gms/internal/zzw$zzb:close	()V
    //   177: aload_1
    //   178: athrow
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: aconst_null
    //   186: astore_1
    //   187: goto -163 -> 24
    //   190: astore_1
    //   191: goto -22 -> 169
    //   194: astore 4
    //   196: goto -84 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	zzw
    //   0	199	1	paramString	String
    //   61	113	2	localzzb1	zzw.zzb
    //   59	93	3	localzzb2	zzw.zzb
    //   15	78	4	localObject	Object
    //   108	24	4	localIOException1	IOException
    //   194	1	4	localIOException2	IOException
    //   33	91	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   95	99	102	java/io/IOException
    //   35	60	108	java/io/IOException
    //   151	155	160	java/io/IOException
    //   35	60	166	finally
    //   2	17	179	finally
    //   28	35	179	finally
    //   95	99	179	finally
    //   151	155	179	finally
    //   173	177	179	finally
    //   177	179	179	finally
    //   173	177	184	java/io/IOException
    //   62	67	190	finally
    //   69	92	190	finally
    //   114	140	190	finally
    //   142	147	190	finally
    //   62	67	194	java/io/IOException
    //   69	92	194	java/io/IOException
  }
  
  /* Error */
  public void zza(String paramString, zzb.zza paramzza)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_2
    //   4: getfield 334	com/google/android/gms/internal/zzb$zza:data	[B
    //   7: arraylength
    //   8: invokespecial 336	com/google/android/gms/internal/zzw:zzc	(I)V
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 199	com/google/android/gms/internal/zzw:zzf	(Ljava/lang/String;)Ljava/io/File;
    //   16: astore_3
    //   17: new 338	java/io/BufferedOutputStream
    //   20: dup
    //   21: new 340	java/io/FileOutputStream
    //   24: dup
    //   25: aload_3
    //   26: invokespecial 341	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: invokespecial 344	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: astore 4
    //   34: new 10	com/google/android/gms/internal/zzw$zza
    //   37: dup
    //   38: aload_1
    //   39: aload_2
    //   40: invokespecial 346	com/google/android/gms/internal/zzw$zza:<init>	(Ljava/lang/String;Lcom/google/android/gms/internal/zzb$zza;)V
    //   43: astore 5
    //   45: aload 5
    //   47: aload 4
    //   49: invokevirtual 349	com/google/android/gms/internal/zzw$zza:zza	(Ljava/io/OutputStream;)Z
    //   52: ifne +61 -> 113
    //   55: aload 4
    //   57: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   60: ldc_w 352
    //   63: iconst_1
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_3
    //   70: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 228	com/google/android/gms/internal/zzt:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: new 145	java/io/IOException
    //   80: dup
    //   81: invokespecial 353	java/io/IOException:<init>	()V
    //   84: athrow
    //   85: astore_1
    //   86: aload_3
    //   87: invokevirtual 204	java/io/File:delete	()Z
    //   90: ifne +20 -> 110
    //   93: ldc_w 355
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_3
    //   103: invokevirtual 284	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 228	com/google/android/gms/internal/zzt:zzb	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: aload 4
    //   115: aload_2
    //   116: getfield 334	com/google/android/gms/internal/zzb$zza:data	[B
    //   119: invokevirtual 358	java/io/BufferedOutputStream:write	([B)V
    //   122: aload 4
    //   124: invokevirtual 350	java/io/BufferedOutputStream:close	()V
    //   127: aload_0
    //   128: aload_1
    //   129: aload 5
    //   131: invokespecial 306	com/google/android/gms/internal/zzw:zza	(Ljava/lang/String;Lcom/google/android/gms/internal/zzw$zza;)V
    //   134: goto -24 -> 110
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	zzw
    //   0	142	1	paramString	String
    //   0	142	2	paramzza	zzb.zza
    //   16	87	3	localFile	File
    //   32	91	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   43	87	5	localzza	zzw.zza
    // Exception table:
    //   from	to	target	type
    //   17	85	85	java/io/IOException
    //   113	134	85	java/io/IOException
    //   2	17	137	finally
    //   17	85	137	finally
    //   86	110	137	finally
    //   113	134	137	finally
  }
  
  public File zzf(String paramString)
  {
    return new File(this.zzay, zze(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.internal.zzw
 * JD-Core Version:    0.7.0.1
 */