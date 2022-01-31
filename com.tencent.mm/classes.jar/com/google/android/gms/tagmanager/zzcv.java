package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaj.zzf;
import com.google.android.gms.internal.zzbjd.zza;
import com.google.android.gms.internal.zzbjf;
import com.google.android.gms.internal.zzbjf.zzc;
import com.google.android.gms.internal.zzbjf.zzg;
import com.google.android.gms.internal.zzbxs;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcv
  implements zzp.zzf
{
  private final Context mContext;
  private final String zzbEY;
  private zzbn<zzbjd.zza> zzbHx;
  private final ExecutorService zzbtM;
  
  zzcv(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.zzbEY = paramString;
    this.zzbtM = Executors.newSingleThreadExecutor();
  }
  
  private zzbjf.zzc zzM(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = zzbjf.zzb(zzaj.zzf.zzf(paramArrayOfByte));
      if (paramArrayOfByte != null) {
        zzbo.v("The container was successfully loaded from the resource (using binary file)");
      }
      return paramArrayOfByte;
    }
    catch (zzbxs paramArrayOfByte)
    {
      zzbo.e("The resource file is corrupted. The container cannot be extracted from the binary file");
      return null;
    }
    catch (zzbjf.zzg paramArrayOfByte)
    {
      zzbo.zzbh("The resource file is invalid. The container from the binary file is invalid");
    }
    return null;
  }
  
  private zzbjf.zzc zza(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    try
    {
      paramByteArrayOutputStream = zzbh.zzhl(paramByteArrayOutputStream.toString("UTF-8"));
      return paramByteArrayOutputStream;
    }
    catch (UnsupportedEncodingException paramByteArrayOutputStream)
    {
      zzbo.zzbf("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
      return null;
    }
    catch (JSONException paramByteArrayOutputStream)
    {
      zzbo.zzbh("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
    }
    return null;
  }
  
  private void zzd(zzbjd.zza paramzza)
  {
    if ((paramzza.zzlr == null) && (paramzza.zzbNj == null)) {
      throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
    }
  }
  
  public void release()
  {
    try
    {
      this.zzbtM.shutdown();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void zzQo()
  {
    this.zzbtM.execute(new zzcv.1(this));
  }
  
  /* Error */
  void zzRl()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 137	com/google/android/gms/tagmanager/zzcv:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   4: ifnonnull +13 -> 17
    //   7: new 139	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc 141
    //   13: invokespecial 142	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: ldc 144
    //   19: invokestatic 59	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   22: invokestatic 150	com/google/android/gms/tagmanager/zzcj:zzRd	()Lcom/google/android/gms/tagmanager/zzcj;
    //   25: invokevirtual 154	com/google/android/gms/tagmanager/zzcj:zzRe	()Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   28: getstatic 160	com/google/android/gms/tagmanager/zzcj$zza:zzbHm	Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   31: if_acmpeq +15 -> 46
    //   34: invokestatic 150	com/google/android/gms/tagmanager/zzcj:zzRd	()Lcom/google/android/gms/tagmanager/zzcj;
    //   37: invokevirtual 154	com/google/android/gms/tagmanager/zzcj:zzRe	()Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   40: getstatic 163	com/google/android/gms/tagmanager/zzcj$zza:zzbHn	Lcom/google/android/gms/tagmanager/zzcj$zza;
    //   43: if_acmpne +32 -> 75
    //   46: aload_0
    //   47: getfield 24	com/google/android/gms/tagmanager/zzcv:zzbEY	Ljava/lang/String;
    //   50: invokestatic 150	com/google/android/gms/tagmanager/zzcj:zzRd	()Lcom/google/android/gms/tagmanager/zzcj;
    //   53: invokevirtual 167	com/google/android/gms/tagmanager/zzcj:getContainerId	()Ljava/lang/String;
    //   56: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +16 -> 75
    //   62: aload_0
    //   63: getfield 137	com/google/android/gms/tagmanager/zzcv:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   66: getstatic 179	com/google/android/gms/tagmanager/zzbn$zza:zzbGM	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   69: invokeinterface 184 2 0
    //   74: return
    //   75: new 186	java/io/FileInputStream
    //   78: dup
    //   79: aload_0
    //   80: invokevirtual 190	com/google/android/gms/tagmanager/zzcv:zzRm	()Ljava/io/File;
    //   83: invokespecial 193	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   86: astore_1
    //   87: new 79	java/io/ByteArrayOutputStream
    //   90: dup
    //   91: invokespecial 194	java/io/ByteArrayOutputStream:<init>	()V
    //   94: astore_2
    //   95: aload_1
    //   96: aload_2
    //   97: invokestatic 198	com/google/android/gms/internal/zzbjf:zzc	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   100: aload_2
    //   101: invokevirtual 202	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   104: invokestatic 206	com/google/android/gms/internal/zzbjd$zza:zzQ	([B)Lcom/google/android/gms/internal/zzbjd$zza;
    //   107: astore_2
    //   108: aload_0
    //   109: aload_2
    //   110: invokespecial 208	com/google/android/gms/tagmanager/zzcv:zzd	(Lcom/google/android/gms/internal/zzbjd$zza;)V
    //   113: aload_0
    //   114: getfield 137	com/google/android/gms/tagmanager/zzcv:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   117: aload_2
    //   118: invokeinterface 212 2 0
    //   123: aload_1
    //   124: invokevirtual 215	java/io/FileInputStream:close	()V
    //   127: ldc 217
    //   129: invokestatic 59	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   132: return
    //   133: astore_1
    //   134: ldc 219
    //   136: invokestatic 94	com/google/android/gms/tagmanager/zzbo:zzbf	(Ljava/lang/String;)V
    //   139: aload_0
    //   140: getfield 137	com/google/android/gms/tagmanager/zzcv:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   143: getstatic 179	com/google/android/gms/tagmanager/zzbn$zza:zzbGM	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   146: invokeinterface 184 2 0
    //   151: return
    //   152: astore_1
    //   153: ldc 221
    //   155: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   158: goto -31 -> 127
    //   161: astore_2
    //   162: aload_0
    //   163: getfield 137	com/google/android/gms/tagmanager/zzcv:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   166: getstatic 224	com/google/android/gms/tagmanager/zzbn$zza:zzbGN	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   169: invokeinterface 184 2 0
    //   174: ldc 226
    //   176: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   179: aload_1
    //   180: invokevirtual 215	java/io/FileInputStream:close	()V
    //   183: goto -56 -> 127
    //   186: astore_1
    //   187: ldc 221
    //   189: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   192: goto -65 -> 127
    //   195: astore_2
    //   196: aload_0
    //   197: getfield 137	com/google/android/gms/tagmanager/zzcv:zzbHx	Lcom/google/android/gms/tagmanager/zzbn;
    //   200: getstatic 224	com/google/android/gms/tagmanager/zzbn$zza:zzbGN	Lcom/google/android/gms/tagmanager/zzbn$zza;
    //   203: invokeinterface 184 2 0
    //   208: ldc 228
    //   210: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   213: aload_1
    //   214: invokevirtual 215	java/io/FileInputStream:close	()V
    //   217: goto -90 -> 127
    //   220: astore_1
    //   221: ldc 221
    //   223: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   226: goto -99 -> 127
    //   229: astore_2
    //   230: aload_1
    //   231: invokevirtual 215	java/io/FileInputStream:close	()V
    //   234: aload_2
    //   235: athrow
    //   236: astore_1
    //   237: ldc 221
    //   239: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   242: goto -8 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	zzcv
    //   86	38	1	localFileInputStream	java.io.FileInputStream
    //   133	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   152	28	1	localIOException1	java.io.IOException
    //   186	28	1	localIOException2	java.io.IOException
    //   220	11	1	localIOException3	java.io.IOException
    //   236	1	1	localIOException4	java.io.IOException
    //   94	24	2	localObject1	Object
    //   161	1	2	localIOException5	java.io.IOException
    //   195	1	2	localIllegalArgumentException	IllegalArgumentException
    //   229	6	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   75	87	133	java/io/FileNotFoundException
    //   123	127	152	java/io/IOException
    //   87	123	161	java/io/IOException
    //   179	183	186	java/io/IOException
    //   87	123	195	java/lang/IllegalArgumentException
    //   213	217	220	java/io/IOException
    //   87	123	229	finally
    //   162	179	229	finally
    //   196	213	229	finally
    //   230	234	236	java/io/IOException
  }
  
  File zzRm()
  {
    String str1 = String.valueOf("resource_");
    String str2 = String.valueOf(this.zzbEY);
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1)) {
      return new File(this.mContext.getDir("google_tagmanager", 0), str1);
    }
  }
  
  public void zza(zzbn<zzbjd.zza> paramzzbn)
  {
    this.zzbHx = paramzzbn;
  }
  
  public void zzb(zzbjd.zza paramzza)
  {
    this.zzbtM.execute(new zzcv.2(this, paramzza));
  }
  
  /* Error */
  boolean zzc(zzbjd.zza paramzza)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 190	com/google/android/gms/tagmanager/zzcv:zzRm	()Ljava/io/File;
    //   4: astore_3
    //   5: new 266	java/io/FileOutputStream
    //   8: dup
    //   9: aload_3
    //   10: invokespecial 267	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   13: astore_2
    //   14: aload_2
    //   15: aload_1
    //   16: invokestatic 272	com/google/android/gms/internal/zzbxt:zzf	(Lcom/google/android/gms/internal/zzbxt;)[B
    //   19: invokevirtual 276	java/io/FileOutputStream:write	([B)V
    //   22: aload_2
    //   23: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   26: iconst_1
    //   27: ireturn
    //   28: astore_1
    //   29: ldc_w 279
    //   32: invokestatic 64	com/google/android/gms/tagmanager/zzbo:e	(Ljava/lang/String;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: astore_1
    //   38: ldc_w 281
    //   41: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   44: goto -18 -> 26
    //   47: astore_1
    //   48: ldc_w 283
    //   51: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   54: aload_3
    //   55: invokevirtual 287	java/io/File:delete	()Z
    //   58: pop
    //   59: aload_2
    //   60: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   63: iconst_0
    //   64: ireturn
    //   65: astore_1
    //   66: ldc_w 281
    //   69: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: aload_2
    //   76: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: ldc_w 281
    //   85: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   88: goto -9 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	zzcv
    //   0	91	1	paramzza	zzbjd.zza
    //   13	63	2	localFileOutputStream	java.io.FileOutputStream
    //   81	1	2	localIOException	java.io.IOException
    //   4	51	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   5	14	28	java/io/FileNotFoundException
    //   22	26	37	java/io/IOException
    //   14	22	47	java/io/IOException
    //   59	63	65	java/io/IOException
    //   14	22	74	finally
    //   48	59	74	finally
    //   75	79	81	java/io/IOException
  }
  
  /* Error */
  public zzbjf.zzc zznz(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/google/android/gms/tagmanager/zzcv:mContext	Landroid/content/Context;
    //   4: invokevirtual 295	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   7: iload_1
    //   8: invokevirtual 301	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 22	com/google/android/gms/tagmanager/zzcv:mContext	Landroid/content/Context;
    //   16: invokevirtual 295	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   19: iload_1
    //   20: invokevirtual 305	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   23: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: astore_3
    //   27: new 307	java/lang/StringBuilder
    //   30: dup
    //   31: aload_3
    //   32: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokevirtual 238	java/lang/String:length	()I
    //   38: bipush 66
    //   40: iadd
    //   41: invokespecial 310	java/lang/StringBuilder:<init>	(I)V
    //   44: ldc_w 312
    //   47: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: iload_1
    //   51: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: ldc_w 321
    //   57: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload_3
    //   61: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 323
    //   67: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 59	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   76: new 79	java/io/ByteArrayOutputStream
    //   79: dup
    //   80: invokespecial 194	java/io/ByteArrayOutputStream:<init>	()V
    //   83: astore_3
    //   84: aload_2
    //   85: aload_3
    //   86: invokestatic 198	com/google/android/gms/internal/zzbjf:zzc	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   89: aload_0
    //   90: aload_3
    //   91: invokespecial 327	com/google/android/gms/tagmanager/zzcv:zza	(Ljava/io/ByteArrayOutputStream;)Lcom/google/android/gms/internal/zzbjf$zzc;
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +39 -> 135
    //   99: ldc_w 329
    //   102: invokestatic 59	com/google/android/gms/tagmanager/zzbo:v	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: areturn
    //   107: astore_2
    //   108: new 307	java/lang/StringBuilder
    //   111: dup
    //   112: bipush 98
    //   114: invokespecial 310	java/lang/StringBuilder:<init>	(I)V
    //   117: ldc_w 331
    //   120: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload_1
    //   124: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   133: aconst_null
    //   134: areturn
    //   135: aload_0
    //   136: aload_3
    //   137: invokevirtual 202	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   140: invokespecial 333	com/google/android/gms/tagmanager/zzcv:zzM	([B)Lcom/google/android/gms/internal/zzbjf$zzc;
    //   143: astore_2
    //   144: aload_2
    //   145: areturn
    //   146: astore_2
    //   147: aload_0
    //   148: getfield 22	com/google/android/gms/tagmanager/zzcv:mContext	Landroid/content/Context;
    //   151: invokevirtual 295	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   154: iload_1
    //   155: invokevirtual 305	android/content/res/Resources:getResourceName	(I)Ljava/lang/String;
    //   158: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   161: astore_2
    //   162: new 307	java/lang/StringBuilder
    //   165: dup
    //   166: aload_2
    //   167: invokestatic 234	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   170: invokevirtual 238	java/lang/String:length	()I
    //   173: bipush 67
    //   175: iadd
    //   176: invokespecial 310	java/lang/StringBuilder:<init>	(I)V
    //   179: ldc_w 335
    //   182: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_1
    //   186: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: ldc_w 321
    //   192: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload_2
    //   196: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 323
    //   202: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 69	com/google/android/gms/tagmanager/zzbo:zzbh	(Ljava/lang/String;)V
    //   211: aconst_null
    //   212: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	zzcv
    //   0	213	1	paramInt	int
    //   11	95	2	localObject1	Object
    //   107	1	2	localNotFoundException	android.content.res.Resources.NotFoundException
    //   143	2	2	localzzc	zzbjf.zzc
    //   146	1	2	localIOException	java.io.IOException
    //   161	35	2	str	String
    //   26	111	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	107	android/content/res/Resources$NotFoundException
    //   76	95	146	java/io/IOException
    //   99	105	146	java/io/IOException
    //   135	144	146	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzcv
 * JD-Core Version:    0.7.0.1
 */