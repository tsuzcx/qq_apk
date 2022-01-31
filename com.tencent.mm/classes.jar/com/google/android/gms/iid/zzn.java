package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

final class zzn
{
  private static zzo zzd(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(57587);
    String str1 = paramSharedPreferences.getString(zzak.zzh(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(zzak.zzh(paramString, "|K|"), null);
    if ((str1 == null) || (str2 == null))
    {
      AppMethodBeat.o(57587);
      return null;
    }
    paramSharedPreferences = new zzo(zzg(str1, str2), zze(paramSharedPreferences, paramString));
    AppMethodBeat.o(57587);
    return paramSharedPreferences;
  }
  
  /* Error */
  private static zzo zzd(File paramFile)
  {
    // Byte code:
    //   0: ldc 55
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 57	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 60	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore 4
    //   15: new 62	java/util/Properties
    //   18: dup
    //   19: invokespecial 63	java/util/Properties:<init>	()V
    //   22: astore_0
    //   23: aload_0
    //   24: aload 4
    //   26: invokevirtual 67	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   29: aload_0
    //   30: ldc 69
    //   32: invokevirtual 73	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_3
    //   36: aload_0
    //   37: ldc 75
    //   39: invokevirtual 73	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload_3
    //   45: ifnull +8 -> 53
    //   48: aload 5
    //   50: ifnonnull +16 -> 66
    //   53: aconst_null
    //   54: aload 4
    //   56: invokestatic 78	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   59: ldc 55
    //   61: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_3
    //   67: aload 5
    //   69: invokestatic 42	com/google/android/gms/iid/zzn:zzg	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPair;
    //   72: astore_3
    //   73: aload_0
    //   74: ldc 80
    //   76: invokevirtual 73	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 86	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: lstore_1
    //   83: new 38	com/google/android/gms/iid/zzo
    //   86: dup
    //   87: aload_3
    //   88: lload_1
    //   89: invokespecial 49	com/google/android/gms/iid/zzo:<init>	(Ljava/security/KeyPair;J)V
    //   92: astore_0
    //   93: aconst_null
    //   94: aload 4
    //   96: invokestatic 78	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   99: ldc 55
    //   101: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: new 88	com/google/android/gms/iid/zzp
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 91	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   115: astore_0
    //   116: ldc 55
    //   118: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: athrow
    //   123: astore_3
    //   124: ldc 55
    //   126: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_3
    //   130: athrow
    //   131: astore_0
    //   132: aload_3
    //   133: aload 4
    //   135: invokestatic 78	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   138: ldc 55
    //   140: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_3
    //   148: goto -16 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramFile	File
    //   82	7	1	l	long
    //   35	53	3	localObject1	Object
    //   123	10	3	localThrowable	Throwable
    //   147	1	3	localObject2	Object
    //   13	121	4	localFileInputStream	java.io.FileInputStream
    //   42	26	5	str	String
    // Exception table:
    //   from	to	target	type
    //   73	83	106	java/lang/NumberFormatException
    //   15	44	123	java/lang/Throwable
    //   66	73	123	java/lang/Throwable
    //   73	83	123	java/lang/Throwable
    //   83	93	123	java/lang/Throwable
    //   107	123	123	java/lang/Throwable
    //   124	131	131	finally
    //   15	44	145	finally
    //   66	73	145	finally
    //   73	83	145	finally
    //   83	93	145	finally
    //   107	123	145	finally
  }
  
  private static void zzd(Context paramContext, String paramString, zzo paramzzo)
  {
    Object localObject = null;
    AppMethodBeat.i(57583);
    try
    {
      Log.isLoggable("InstanceID", 3);
      paramContext = zzj(paramContext, paramString);
      paramContext.createNewFile();
      paramString = new Properties();
      paramString.setProperty("pub", zzo.zzd(paramzzo));
      paramString.setProperty("pri", zzo.zze(paramzzo));
      paramString.setProperty("cre", String.valueOf(zzo.zzf(paramzzo)));
      paramzzo = new FileOutputStream(paramContext);
      paramContext = localObject;
      try
      {
        paramString.store(paramzzo, null);
        zzd(null, paramzzo);
        AppMethodBeat.o(57583);
        return;
      }
      catch (Throwable paramString)
      {
        paramContext = paramString;
        AppMethodBeat.o(57583);
        paramContext = paramString;
        throw paramString;
      }
      finally
      {
        zzd(paramContext, paramzzo);
        AppMethodBeat.o(57583);
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 21).append("Failed to write key: ").append(paramContext);
      AppMethodBeat.o(57583);
    }
  }
  
  private static long zze(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(57589);
    paramSharedPreferences = paramSharedPreferences.getString(zzak.zzh(paramString, "cre"), null);
    if (paramSharedPreferences != null) {
      try
      {
        long l = Long.parseLong(paramSharedPreferences);
        AppMethodBeat.o(57589);
        return l;
      }
      catch (NumberFormatException paramSharedPreferences) {}
    }
    AppMethodBeat.o(57589);
    return 0L;
  }
  
  private final void zze(Context paramContext, String paramString, zzo paramzzo)
  {
    AppMethodBeat.i(57588);
    paramContext = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try
    {
      boolean bool = paramzzo.equals(zzd(paramContext, paramString));
      if (bool)
      {
        AppMethodBeat.o(57588);
        return;
      }
    }
    catch (zzp localzzp)
    {
      Log.isLoggable("InstanceID", 3);
      paramContext = paramContext.edit();
      paramContext.putString(zzak.zzh(paramString, "|P|"), zzo.zzd(paramzzo));
      paramContext.putString(zzak.zzh(paramString, "|K|"), zzo.zze(paramzzo));
      paramContext.putString(zzak.zzh(paramString, "cre"), String.valueOf(zzo.zzf(paramzzo)));
      paramContext.commit();
      AppMethodBeat.o(57588);
    }
  }
  
  /* Error */
  private static java.security.KeyPair zzg(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 206
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: bipush 8
    //   8: invokestatic 212	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   11: astore_0
    //   12: aload_1
    //   13: bipush 8
    //   15: invokestatic 212	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   18: astore_1
    //   19: ldc 214
    //   21: invokestatic 220	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   24: astore_2
    //   25: new 222	java/security/KeyPair
    //   28: dup
    //   29: aload_2
    //   30: new 224	java/security/spec/X509EncodedKeySpec
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 227	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   38: invokevirtual 231	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   41: aload_2
    //   42: new 233	java/security/spec/PKCS8EncodedKeySpec
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 234	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   50: invokevirtual 238	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   53: invokespecial 241	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   56: astore_0
    //   57: ldc 206
    //   59: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload_0
    //   63: areturn
    //   64: astore_0
    //   65: new 88	com/google/android/gms/iid/zzp
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 91	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   73: astore_0
    //   74: ldc 206
    //   76: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aload_0
    //   80: athrow
    //   81: astore_0
    //   82: aload_0
    //   83: invokestatic 145	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: astore_1
    //   87: new 147	java/lang/StringBuilder
    //   90: dup
    //   91: aload_1
    //   92: invokestatic 145	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   95: invokevirtual 151	java/lang/String:length	()I
    //   98: bipush 19
    //   100: iadd
    //   101: invokespecial 153	java/lang/StringBuilder:<init>	(I)V
    //   104: ldc 243
    //   106: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: new 88	com/google/android/gms/iid/zzp
    //   117: dup
    //   118: aload_0
    //   119: invokespecial 91	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   122: astore_0
    //   123: ldc 206
    //   125: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload_0
    //   129: athrow
    //   130: astore_0
    //   131: goto -49 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString1	String
    //   0	134	1	paramString2	String
    //   24	18	2	localKeyFactory	java.security.KeyFactory
    // Exception table:
    //   from	to	target	type
    //   5	19	64	java/lang/IllegalArgumentException
    //   19	57	81	java/security/NoSuchAlgorithmException
    //   19	57	130	java/security/spec/InvalidKeySpecException
  }
  
  static void zzg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(57578);
    paramContext = zzj(paramContext, paramString);
    if (paramContext.exists()) {
      paramContext.delete();
    }
    AppMethodBeat.o(57578);
  }
  
  /* Error */
  private final zzo zzh(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 253
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokespecial 256	com/google/android/gms/iid/zzn:zzi	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: aload_3
    //   20: invokespecial 258	com/google/android/gms/iid/zzn:zze	(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/iid/zzo;)V
    //   23: ldc 253
    //   25: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_3
    //   29: areturn
    //   30: aconst_null
    //   31: astore_3
    //   32: aload_1
    //   33: ldc 174
    //   35: iconst_0
    //   36: invokevirtual 180	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   39: aload_2
    //   40: invokestatic 182	com/google/android/gms/iid/zzn:zzd	(Landroid/content/SharedPreferences;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +22 -> 69
    //   50: aload_1
    //   51: aload_2
    //   52: aload 4
    //   54: invokestatic 260	com/google/android/gms/iid/zzn:zzd	(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/iid/zzo;)V
    //   57: ldc 253
    //   59: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: aload 4
    //   64: areturn
    //   65: astore_3
    //   66: goto -34 -> 32
    //   69: aload_3
    //   70: ifnull +10 -> 80
    //   73: ldc 253
    //   75: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_3
    //   79: athrow
    //   80: ldc 253
    //   82: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_3
    //   88: goto -19 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	zzn
    //   0	91	1	paramContext	Context
    //   0	91	2	paramString	String
    //   11	21	3	localzzo1	zzo
    //   65	14	3	localzzp1	zzp
    //   87	1	3	localzzp2	zzp
    //   43	20	4	localzzo2	zzo
    // Exception table:
    //   from	to	target	type
    //   5	12	65	com/google/android/gms/iid/zzp
    //   16	23	65	com/google/android/gms/iid/zzp
    //   32	45	87	com/google/android/gms/iid/zzp
    //   50	57	87	com/google/android/gms/iid/zzp
  }
  
  private final zzo zzi(Context paramContext, String paramString)
  {
    AppMethodBeat.i(57582);
    paramContext = zzj(paramContext, paramString);
    if (!paramContext.exists())
    {
      AppMethodBeat.o(57582);
      return null;
    }
    try
    {
      paramString = zzd(paramContext);
      AppMethodBeat.o(57582);
      return paramString;
    }
    catch (IOException paramString)
    {
      if (Log.isLoggable("InstanceID", 3))
      {
        paramString = String.valueOf(paramString);
        new StringBuilder(String.valueOf(paramString).length() + 40).append("Failed to read key from file, retrying: ").append(paramString);
      }
      try
      {
        paramContext = zzd(paramContext);
        AppMethodBeat.o(57582);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramString = String.valueOf(paramContext);
        new StringBuilder(String.valueOf(paramString).length() + 45).append("IID file exists, but failed to read from it: ").append(paramString);
        paramContext = new zzp(paramContext);
        AppMethodBeat.o(57582);
        throw paramContext;
      }
    }
  }
  
  static void zzi(Context paramContext)
  {
    AppMethodBeat.i(57579);
    paramContext = zzj(paramContext).listFiles();
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if (localObject.getName().startsWith("com.google.InstanceId")) {
        localObject.delete();
      }
      i += 1;
    }
    AppMethodBeat.o(57579);
  }
  
  private static File zzj(Context paramContext)
  {
    AppMethodBeat.i(57584);
    File localFile = b.P(paramContext);
    if ((localFile != null) && (localFile.isDirectory()))
    {
      AppMethodBeat.o(57584);
      return localFile;
    }
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(57584);
    return paramContext;
  }
  
  private static File zzj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(57585);
    if (TextUtils.isEmpty(paramString)) {
      paramString = "com.google.InstanceId.properties";
    }
    for (;;)
    {
      paramContext = new File(zzj(paramContext), paramString);
      AppMethodBeat.o(57585);
      return paramContext;
      try
      {
        paramString = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
        paramString = String.valueOf(paramString).length() + 33 + "com.google.InstanceId_" + paramString + ".properties";
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext = new AssertionError(paramContext);
        AppMethodBeat.o(57585);
        throw paramContext;
      }
    }
  }
  
  final zzo zze(Context paramContext, String paramString)
  {
    AppMethodBeat.i(57576);
    zzo localzzo = zzh(paramContext, paramString);
    if (localzzo != null)
    {
      AppMethodBeat.o(57576);
      return localzzo;
    }
    paramContext = zzf(paramContext, paramString);
    AppMethodBeat.o(57576);
    return paramContext;
  }
  
  final zzo zzf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(57577);
    zzo localzzo1 = new zzo(zzd.zzk(), System.currentTimeMillis());
    try
    {
      zzo localzzo2 = zzh(paramContext, paramString);
      if (localzzo2 != null)
      {
        Log.isLoggable("InstanceID", 3);
        AppMethodBeat.o(57577);
        return localzzo2;
      }
    }
    catch (zzp localzzp)
    {
      Log.isLoggable("InstanceID", 3);
      zzd(paramContext, paramString, localzzo1);
      zze(paramContext, paramString, localzzo1);
      AppMethodBeat.o(57577);
    }
    return localzzo1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.iid.zzn
 * JD-Core Version:    0.7.0.1
 */