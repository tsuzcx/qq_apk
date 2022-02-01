package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.core.content.a;
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
    AppMethodBeat.i(2541);
    String str1 = paramSharedPreferences.getString(zzak.zzh(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(zzak.zzh(paramString, "|K|"), null);
    if ((str1 == null) || (str2 == null))
    {
      AppMethodBeat.o(2541);
      return null;
    }
    paramSharedPreferences = new zzo(zzg(str1, str2), zze(paramSharedPreferences, paramString));
    AppMethodBeat.o(2541);
    return paramSharedPreferences;
  }
  
  /* Error */
  private static zzo zzd(File paramFile)
  {
    // Byte code:
    //   0: sipush 2540
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 55	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 58	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore 4
    //   16: new 60	java/util/Properties
    //   19: dup
    //   20: invokespecial 61	java/util/Properties:<init>	()V
    //   23: astore_0
    //   24: aload_0
    //   25: aload 4
    //   27: invokevirtual 65	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   30: aload_0
    //   31: ldc 67
    //   33: invokevirtual 71	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_3
    //   37: aload_0
    //   38: ldc 73
    //   40: invokevirtual 71	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 5
    //   45: aload_3
    //   46: ifnull +8 -> 54
    //   49: aload 5
    //   51: ifnonnull +17 -> 68
    //   54: aconst_null
    //   55: aload 4
    //   57: invokestatic 76	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   60: sipush 2540
    //   63: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: aload_3
    //   69: aload 5
    //   71: invokestatic 41	com/google/android/gms/iid/zzn:zzg	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPair;
    //   74: astore_3
    //   75: aload_0
    //   76: ldc 78
    //   78: invokevirtual 71	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 84	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   84: lstore_1
    //   85: new 37	com/google/android/gms/iid/zzo
    //   88: dup
    //   89: aload_3
    //   90: lload_1
    //   91: invokespecial 48	com/google/android/gms/iid/zzo:<init>	(Ljava/security/KeyPair;J)V
    //   94: astore_0
    //   95: aconst_null
    //   96: aload 4
    //   98: invokestatic 76	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   101: sipush 2540
    //   104: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: new 86	com/google/android/gms/iid/zzp
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 89	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   118: astore_0
    //   119: sipush 2540
    //   122: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_0
    //   126: athrow
    //   127: astore_3
    //   128: sipush 2540
    //   131: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_3
    //   135: athrow
    //   136: astore_0
    //   137: aload_3
    //   138: aload 4
    //   140: invokestatic 76	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   143: sipush 2540
    //   146: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: aload_0
    //   150: athrow
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_3
    //   154: goto -17 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramFile	File
    //   84	7	1	l	long
    //   36	54	3	localObject1	Object
    //   127	11	3	localThrowable	Throwable
    //   153	1	3	localObject2	Object
    //   14	125	4	localFileInputStream	java.io.FileInputStream
    //   43	27	5	str	String
    // Exception table:
    //   from	to	target	type
    //   75	85	109	java/lang/NumberFormatException
    //   16	45	127	java/lang/Throwable
    //   68	75	127	java/lang/Throwable
    //   75	85	127	java/lang/Throwable
    //   85	95	127	java/lang/Throwable
    //   110	127	127	java/lang/Throwable
    //   128	136	136	finally
    //   16	45	151	finally
    //   68	75	151	finally
    //   75	85	151	finally
    //   85	95	151	finally
    //   110	127	151	finally
  }
  
  private static void zzd(Context paramContext, String paramString, zzo paramzzo)
  {
    Object localObject = null;
    AppMethodBeat.i(2537);
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
        AppMethodBeat.o(2537);
        return;
      }
      catch (Throwable paramString)
      {
        paramContext = paramString;
        AppMethodBeat.o(2537);
        paramContext = paramString;
        throw paramString;
      }
      finally
      {
        zzd(paramContext, paramzzo);
        AppMethodBeat.o(2537);
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 21).append("Failed to write key: ").append(paramContext);
      AppMethodBeat.o(2537);
    }
  }
  
  private static long zze(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(2543);
    paramSharedPreferences = paramSharedPreferences.getString(zzak.zzh(paramString, "cre"), null);
    if (paramSharedPreferences != null) {
      try
      {
        long l = Long.parseLong(paramSharedPreferences);
        AppMethodBeat.o(2543);
        return l;
      }
      catch (NumberFormatException paramSharedPreferences) {}
    }
    AppMethodBeat.o(2543);
    return 0L;
  }
  
  private final void zze(Context paramContext, String paramString, zzo paramzzo)
  {
    AppMethodBeat.i(2542);
    paramContext = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try
    {
      boolean bool = paramzzo.equals(zzd(paramContext, paramString));
      if (bool)
      {
        AppMethodBeat.o(2542);
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
      AppMethodBeat.o(2542);
    }
  }
  
  /* Error */
  private static java.security.KeyPair zzg(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 2535
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: bipush 8
    //   9: invokestatic 204	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   12: astore_0
    //   13: aload_1
    //   14: bipush 8
    //   16: invokestatic 204	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   19: astore_1
    //   20: ldc 206
    //   22: invokestatic 212	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   25: astore_2
    //   26: new 214	java/security/KeyPair
    //   29: dup
    //   30: aload_2
    //   31: new 216	java/security/spec/X509EncodedKeySpec
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 219	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   39: invokevirtual 223	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   42: aload_2
    //   43: new 225	java/security/spec/PKCS8EncodedKeySpec
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 226	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   51: invokevirtual 230	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   54: invokespecial 233	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   57: astore_0
    //   58: sipush 2535
    //   61: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: areturn
    //   66: astore_0
    //   67: new 86	com/google/android/gms/iid/zzp
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 89	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   75: astore_0
    //   76: sipush 2535
    //   79: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: aload_0
    //   86: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   89: astore_1
    //   90: new 144	java/lang/StringBuilder
    //   93: dup
    //   94: aload_1
    //   95: invokestatic 142	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 148	java/lang/String:length	()I
    //   101: bipush 19
    //   103: iadd
    //   104: invokespecial 150	java/lang/StringBuilder:<init>	(I)V
    //   107: ldc 235
    //   109: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: new 86	com/google/android/gms/iid/zzp
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 89	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   125: astore_0
    //   126: sipush 2535
    //   129: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_0
    //   133: athrow
    //   134: astore_0
    //   135: goto -50 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString1	String
    //   0	138	1	paramString2	String
    //   25	18	2	localKeyFactory	java.security.KeyFactory
    // Exception table:
    //   from	to	target	type
    //   6	20	66	java/lang/IllegalArgumentException
    //   20	58	84	java/security/NoSuchAlgorithmException
    //   20	58	134	java/security/spec/InvalidKeySpecException
  }
  
  static void zzg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(2532);
    paramContext = zzj(paramContext, paramString);
    if (paramContext.exists()) {
      paramContext.delete();
    }
    AppMethodBeat.o(2532);
  }
  
  /* Error */
  private final zzo zzh(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: sipush 2534
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: invokespecial 246	com/google/android/gms/iid/zzn:zzi	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +18 -> 32
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: aload_3
    //   21: invokespecial 248	com/google/android/gms/iid/zzn:zze	(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/iid/zzo;)V
    //   24: sipush 2534
    //   27: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_3
    //   31: areturn
    //   32: aconst_null
    //   33: astore_3
    //   34: aload_1
    //   35: ldc 167
    //   37: iconst_0
    //   38: invokevirtual 173	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: aload_2
    //   42: invokestatic 175	com/google/android/gms/iid/zzn:zzd	(Landroid/content/SharedPreferences;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   45: astore 4
    //   47: aload 4
    //   49: ifnull +23 -> 72
    //   52: aload_1
    //   53: aload_2
    //   54: aload 4
    //   56: invokestatic 250	com/google/android/gms/iid/zzn:zzd	(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/iid/zzo;)V
    //   59: sipush 2534
    //   62: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload 4
    //   67: areturn
    //   68: astore_3
    //   69: goto -35 -> 34
    //   72: aload_3
    //   73: ifnull +11 -> 84
    //   76: sipush 2534
    //   79: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_3
    //   83: athrow
    //   84: sipush 2534
    //   87: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_3
    //   93: goto -21 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	zzn
    //   0	96	1	paramContext	Context
    //   0	96	2	paramString	String
    //   12	22	3	localzzo1	zzo
    //   68	15	3	localzzp1	zzp
    //   92	1	3	localzzp2	zzp
    //   45	21	4	localzzo2	zzo
    // Exception table:
    //   from	to	target	type
    //   6	13	68	com/google/android/gms/iid/zzp
    //   17	24	68	com/google/android/gms/iid/zzp
    //   34	47	92	com/google/android/gms/iid/zzp
    //   52	59	92	com/google/android/gms/iid/zzp
  }
  
  private final zzo zzi(Context paramContext, String paramString)
  {
    AppMethodBeat.i(2536);
    paramContext = zzj(paramContext, paramString);
    if (!paramContext.exists())
    {
      AppMethodBeat.o(2536);
      return null;
    }
    try
    {
      paramString = zzd(paramContext);
      AppMethodBeat.o(2536);
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
        AppMethodBeat.o(2536);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramString = String.valueOf(paramContext);
        new StringBuilder(String.valueOf(paramString).length() + 45).append("IID file exists, but failed to read from it: ").append(paramString);
        paramContext = new zzp(paramContext);
        AppMethodBeat.o(2536);
        throw paramContext;
      }
    }
  }
  
  static void zzi(Context paramContext)
  {
    AppMethodBeat.i(2533);
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
    AppMethodBeat.o(2533);
  }
  
  private static File zzj(Context paramContext)
  {
    AppMethodBeat.i(2538);
    File localFile = a.R(paramContext);
    if ((localFile != null) && (localFile.isDirectory()))
    {
      AppMethodBeat.o(2538);
      return localFile;
    }
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(2538);
    return paramContext;
  }
  
  private static File zzj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(2539);
    if (TextUtils.isEmpty(paramString)) {
      paramString = "com.google.InstanceId.properties";
    }
    for (;;)
    {
      paramContext = new File(zzj(paramContext), paramString);
      AppMethodBeat.o(2539);
      return paramContext;
      try
      {
        paramString = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
        paramString = String.valueOf(paramString).length() + 33 + "com.google.InstanceId_" + paramString + ".properties";
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext = new AssertionError(paramContext);
        AppMethodBeat.o(2539);
        throw paramContext;
      }
    }
  }
  
  final zzo zze(Context paramContext, String paramString)
  {
    AppMethodBeat.i(2530);
    zzo localzzo = zzh(paramContext, paramString);
    if (localzzo != null)
    {
      AppMethodBeat.o(2530);
      return localzzo;
    }
    paramContext = zzf(paramContext, paramString);
    AppMethodBeat.o(2530);
    return paramContext;
  }
  
  final zzo zzf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(2531);
    zzo localzzo1 = new zzo(zzd.zzk(), System.currentTimeMillis());
    try
    {
      zzo localzzo2 = zzh(paramContext, paramString);
      if (localzzo2 != null)
      {
        Log.isLoggable("InstanceID", 3);
        AppMethodBeat.o(2531);
        return localzzo2;
      }
    }
    catch (zzp localzzp)
    {
      Log.isLoggable("InstanceID", 3);
      zzd(paramContext, paramString, localzzo1);
      zze(paramContext, paramString, localzzo1);
      AppMethodBeat.o(2531);
    }
    return localzzo1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.iid.zzn
 * JD-Core Version:    0.7.0.1
 */