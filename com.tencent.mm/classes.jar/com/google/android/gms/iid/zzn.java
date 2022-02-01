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
    //   6: new 53	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_0
    //   15: new 58	java/util/Properties
    //   18: dup
    //   19: invokespecial 59	java/util/Properties:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: invokevirtual 63	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   28: aload_3
    //   29: ldc 65
    //   31: invokevirtual 69	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 4
    //   36: aload_3
    //   37: ldc 71
    //   39: invokevirtual 69	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload 4
    //   46: ifnull +8 -> 54
    //   49: aload 5
    //   51: ifnonnull +16 -> 67
    //   54: aconst_null
    //   55: aload_0
    //   56: invokestatic 74	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   59: sipush 2540
    //   62: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: aload 4
    //   69: aload 5
    //   71: invokestatic 41	com/google/android/gms/iid/zzn:zzg	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPair;
    //   74: astore 4
    //   76: aload_3
    //   77: ldc 76
    //   79: invokevirtual 69	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokestatic 82	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   85: lstore_1
    //   86: new 37	com/google/android/gms/iid/zzo
    //   89: dup
    //   90: aload 4
    //   92: lload_1
    //   93: invokespecial 48	com/google/android/gms/iid/zzo:<init>	(Ljava/security/KeyPair;J)V
    //   96: astore_3
    //   97: aconst_null
    //   98: aload_0
    //   99: invokestatic 74	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   102: sipush 2540
    //   105: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_3
    //   109: areturn
    //   110: astore_3
    //   111: new 84	com/google/android/gms/iid/zzp
    //   114: dup
    //   115: aload_3
    //   116: invokespecial 87	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   119: astore_3
    //   120: sipush 2540
    //   123: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: sipush 2540
    //   132: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: athrow
    //   137: astore 4
    //   139: aload_3
    //   140: aload_0
    //   141: invokestatic 74	com/google/android/gms/iid/zzn:zzd	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   144: sipush 2540
    //   147: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 4
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramFile	File
    //   85	8	1	l	long
    //   22	87	3	localObject1	Object
    //   110	6	3	localNumberFormatException	NumberFormatException
    //   119	8	3	localzzp	zzp
    //   128	12	3	localThrowable	java.lang.Throwable
    //   34	57	4	localObject2	Object
    //   137	14	4	localObject3	Object
    //   42	28	5	str	String
    // Exception table:
    //   from	to	target	type
    //   76	86	110	java/lang/NumberFormatException
    //   15	44	128	finally
    //   67	76	128	finally
    //   76	86	128	finally
    //   86	97	128	finally
    //   111	128	128	finally
    //   129	137	137	finally
  }
  
  private static void zzd(Context paramContext, String paramString, zzo paramzzo)
  {
    AppMethodBeat.i(2537);
    try
    {
      Log.isLoggable("InstanceID", 3);
      paramString = zzj(paramContext, paramString);
      paramString.createNewFile();
      paramContext = new Properties();
      paramContext.setProperty("pub", zzo.zzd(paramzzo));
      paramContext.setProperty("pri", zzo.zze(paramzzo));
      paramContext.setProperty("cre", String.valueOf(zzo.zzf(paramzzo)));
      paramString = new FileOutputStream(paramString);
      try
      {
        paramContext.store(paramString, null);
        zzd(null, paramString);
        AppMethodBeat.o(2537);
        return;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(2537);
          throw paramContext;
        }
        finally
        {
          zzd(paramContext, paramString);
          AppMethodBeat.o(2537);
        }
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
    //   9: invokestatic 202	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   12: astore_0
    //   13: aload_1
    //   14: bipush 8
    //   16: invokestatic 202	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   19: astore_1
    //   20: ldc 204
    //   22: invokestatic 210	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   25: astore_2
    //   26: new 212	java/security/KeyPair
    //   29: dup
    //   30: aload_2
    //   31: new 214	java/security/spec/X509EncodedKeySpec
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 217	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   39: invokevirtual 221	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   42: aload_2
    //   43: new 223	java/security/spec/PKCS8EncodedKeySpec
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 224	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   51: invokevirtual 228	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   54: invokespecial 231	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   57: astore_0
    //   58: sipush 2535
    //   61: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: areturn
    //   66: astore_0
    //   67: new 84	com/google/android/gms/iid/zzp
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 87	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
    //   75: astore_0
    //   76: sipush 2535
    //   79: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: aload_0
    //   86: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   89: astore_1
    //   90: new 142	java/lang/StringBuilder
    //   93: dup
    //   94: aload_1
    //   95: invokestatic 140	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 146	java/lang/String:length	()I
    //   101: bipush 19
    //   103: iadd
    //   104: invokespecial 148	java/lang/StringBuilder:<init>	(I)V
    //   107: ldc 233
    //   109: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: new 84	com/google/android/gms/iid/zzp
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 87	com/google/android/gms/iid/zzp:<init>	(Ljava/lang/Exception;)V
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
    //   9: invokespecial 244	com/google/android/gms/iid/zzn:zzi	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +18 -> 32
    //   17: aload_0
    //   18: aload_1
    //   19: aload_2
    //   20: aload_3
    //   21: invokespecial 246	com/google/android/gms/iid/zzn:zze	(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/iid/zzo;)V
    //   24: sipush 2534
    //   27: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_3
    //   31: areturn
    //   32: aconst_null
    //   33: astore_3
    //   34: aload_1
    //   35: ldc 165
    //   37: iconst_0
    //   38: invokevirtual 171	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   41: aload_2
    //   42: invokestatic 173	com/google/android/gms/iid/zzn:zzd	(Landroid/content/SharedPreferences;Ljava/lang/String;)Lcom/google/android/gms/iid/zzo;
    //   45: astore 4
    //   47: aload 4
    //   49: ifnull +23 -> 72
    //   52: aload_1
    //   53: aload_2
    //   54: aload 4
    //   56: invokestatic 248	com/google/android/gms/iid/zzn:zzd	(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/iid/zzo;)V
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
    File localFile = a.ac(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.iid.zzn
 * JD-Core Version:    0.7.0.1
 */