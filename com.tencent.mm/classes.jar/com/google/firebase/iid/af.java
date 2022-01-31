package com.google.firebase.iid;

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

final class af
{
  private static ag a(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(108808);
    String str1 = paramSharedPreferences.getString(p.o(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(p.o(paramString, "|K|"), null);
    if ((str1 == null) || (str2 == null))
    {
      AppMethodBeat.o(108808);
      return null;
    }
    paramSharedPreferences = new ag(q(str1, str2), b(paramSharedPreferences, paramString));
    AppMethodBeat.o(108808);
    return paramSharedPreferences;
  }
  
  private static void a(Context paramContext, String paramString, ag paramag)
  {
    Object localObject = null;
    AppMethodBeat.i(108804);
    try
    {
      Log.isLoggable("FirebaseInstanceId", 3);
      paramContext = n(paramContext, paramString);
      paramContext.createNewFile();
      paramString = new Properties();
      paramString.setProperty("pub", paramag.zzq());
      paramString.setProperty("pri", paramag.se());
      paramString.setProperty("cre", String.valueOf(paramag.bgs));
      paramag = new FileOutputStream(paramContext);
      paramContext = localObject;
      try
      {
        paramString.store(paramag, null);
        a(null, paramag);
        AppMethodBeat.o(108804);
        return;
      }
      catch (Throwable paramString)
      {
        paramContext = paramString;
        AppMethodBeat.o(108804);
        paramContext = paramString;
        throw paramString;
      }
      finally
      {
        a(paramContext, paramag);
        AppMethodBeat.o(108804);
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 21).append("Failed to write key: ").append(paramContext);
      AppMethodBeat.o(108804);
    }
  }
  
  static File ai(Context paramContext)
  {
    AppMethodBeat.i(108805);
    File localFile = b.P(paramContext);
    if ((localFile != null) && (localFile.isDirectory()))
    {
      AppMethodBeat.o(108805);
      return localFile;
    }
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(108805);
    return paramContext;
  }
  
  private static long b(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(108810);
    paramSharedPreferences = paramSharedPreferences.getString(p.o(paramString, "cre"), null);
    if (paramSharedPreferences != null) {
      try
      {
        long l = Long.parseLong(paramSharedPreferences);
        AppMethodBeat.o(108810);
        return l;
      }
      catch (NumberFormatException paramSharedPreferences) {}
    }
    AppMethodBeat.o(108810);
    return 0L;
  }
  
  private static void b(Context paramContext, String paramString, ag paramag)
  {
    AppMethodBeat.i(108809);
    paramContext = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try
    {
      boolean bool = paramag.equals(a(paramContext, paramString));
      if (bool)
      {
        AppMethodBeat.o(108809);
        return;
      }
    }
    catch (ah localah)
    {
      Log.isLoggable("FirebaseInstanceId", 3);
      paramContext = paramContext.edit();
      paramContext.putString(p.o(paramString, "|P|"), paramag.zzq());
      paramContext.putString(p.o(paramString, "|K|"), paramag.se());
      paramContext.putString(p.o(paramString, "cre"), String.valueOf(paramag.bgs));
      paramContext.commit();
      AppMethodBeat.o(108809);
    }
  }
  
  static ag k(Context paramContext, String paramString)
  {
    AppMethodBeat.i(108800);
    ag localag1 = new ag(a.rV(), System.currentTimeMillis());
    try
    {
      ag localag2 = l(paramContext, paramString);
      if (localag2 != null)
      {
        Log.isLoggable("FirebaseInstanceId", 3);
        AppMethodBeat.o(108800);
        return localag2;
      }
    }
    catch (ah localah)
    {
      Log.isLoggable("FirebaseInstanceId", 3);
      a(paramContext, paramString, localag1);
      b(paramContext, paramString, localag1);
      AppMethodBeat.o(108800);
    }
    return localag1;
  }
  
  /* Error */
  static ag l(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 223
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 226	com/google/firebase/iid/af:m	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +16 -> 28
    //   15: aload_0
    //   16: aload_1
    //   17: aload_2
    //   18: invokestatic 222	com/google/firebase/iid/af:b	(Landroid/content/Context;Ljava/lang/String;Lcom/google/firebase/iid/ag;)V
    //   21: ldc 223
    //   23: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_2
    //   27: areturn
    //   28: aconst_null
    //   29: astore_2
    //   30: aload_0
    //   31: ldc 177
    //   33: iconst_0
    //   34: invokevirtual 181	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   37: aload_1
    //   38: invokestatic 183	com/google/firebase/iid/af:a	(Landroid/content/SharedPreferences;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +20 -> 63
    //   46: aload_0
    //   47: aload_1
    //   48: aload_3
    //   49: invokestatic 220	com/google/firebase/iid/af:a	(Landroid/content/Context;Ljava/lang/String;Lcom/google/firebase/iid/ag;)V
    //   52: ldc 223
    //   54: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_3
    //   58: areturn
    //   59: astore_2
    //   60: goto -30 -> 30
    //   63: aload_2
    //   64: ifnull +10 -> 74
    //   67: ldc 223
    //   69: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_2
    //   73: athrow
    //   74: ldc 223
    //   76: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_2
    //   82: goto -19 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramContext	Context
    //   0	85	1	paramString	String
    //   10	20	2	localag1	ag
    //   59	14	2	localah1	ah
    //   81	1	2	localah2	ah
    //   41	17	3	localag2	ag
    // Exception table:
    //   from	to	target	type
    //   5	11	59	com/google/firebase/iid/ah
    //   15	21	59	com/google/firebase/iid/ah
    //   30	42	81	com/google/firebase/iid/ah
    //   46	52	81	com/google/firebase/iid/ah
  }
  
  /* Error */
  private static ag l(File paramFile)
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 135	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 229	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   13: astore 4
    //   15: new 74	java/util/Properties
    //   18: dup
    //   19: invokespecial 75	java/util/Properties:<init>	()V
    //   22: astore_0
    //   23: aload_0
    //   24: aload 4
    //   26: invokevirtual 233	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   29: aload_0
    //   30: ldc 77
    //   32: invokevirtual 237	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_3
    //   36: aload_0
    //   37: ldc 87
    //   39: invokevirtual 237	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload_3
    //   45: ifnull +8 -> 53
    //   48: aload 5
    //   50: ifnonnull +16 -> 66
    //   53: aconst_null
    //   54: aload 4
    //   56: invokestatic 239	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   59: ldc 228
    //   61: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aconst_null
    //   65: areturn
    //   66: aload_3
    //   67: aload 5
    //   69: invokestatic 41	com/google/firebase/iid/af:q	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPair;
    //   72: astore_3
    //   73: aload_0
    //   74: ldc 92
    //   76: invokevirtual 237	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 172	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: lstore_1
    //   83: new 37	com/google/firebase/iid/ag
    //   86: dup
    //   87: aload_3
    //   88: lload_1
    //   89: invokespecial 48	com/google/firebase/iid/ag:<init>	(Ljava/security/KeyPair;J)V
    //   92: astore_0
    //   93: aconst_null
    //   94: aload 4
    //   96: invokestatic 239	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   99: ldc 228
    //   101: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   104: aload_0
    //   105: areturn
    //   106: astore_0
    //   107: new 174	com/google/firebase/iid/ah
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 242	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   115: astore_0
    //   116: ldc 228
    //   118: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_0
    //   122: athrow
    //   123: astore_3
    //   124: ldc 228
    //   126: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: aload_3
    //   130: athrow
    //   131: astore_0
    //   132: aload_3
    //   133: aload 4
    //   135: invokestatic 239	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   138: ldc 228
    //   140: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static ag m(Context paramContext, String paramString)
  {
    AppMethodBeat.i(108803);
    paramContext = n(paramContext, paramString);
    if (!paramContext.exists())
    {
      AppMethodBeat.o(108803);
      return null;
    }
    try
    {
      paramString = l(paramContext);
      AppMethodBeat.o(108803);
      return paramString;
    }
    catch (IOException paramString)
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        paramString = String.valueOf(paramString);
        new StringBuilder(String.valueOf(paramString).length() + 40).append("Failed to read key from file, retrying: ").append(paramString);
      }
      try
      {
        paramContext = l(paramContext);
        AppMethodBeat.o(108803);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramString = String.valueOf(paramContext);
        new StringBuilder(String.valueOf(paramString).length() + 45).append("IID file exists, but failed to read from it: ").append(paramString);
        paramContext = new ah(paramContext);
        AppMethodBeat.o(108803);
        throw paramContext;
      }
    }
  }
  
  private static File n(Context paramContext, String paramString)
  {
    AppMethodBeat.i(108806);
    if (TextUtils.isEmpty(paramString)) {
      paramString = "com.google.InstanceId.properties";
    }
    for (;;)
    {
      paramContext = new File(ai(paramContext), paramString);
      AppMethodBeat.o(108806);
      return paramContext;
      try
      {
        paramString = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
        paramString = String.valueOf(paramString).length() + 33 + "com.google.InstanceId_" + paramString + ".properties";
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext = new AssertionError(paramContext);
        AppMethodBeat.o(108806);
        throw paramContext;
      }
    }
  }
  
  /* Error */
  private static java.security.KeyPair q(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 299
    //   3: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: bipush 8
    //   9: invokestatic 303	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   12: astore_0
    //   13: aload_1
    //   14: bipush 8
    //   16: invokestatic 303	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   19: astore_1
    //   20: ldc_w 305
    //   23: invokestatic 311	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   26: astore_2
    //   27: new 313	java/security/KeyPair
    //   30: dup
    //   31: aload_2
    //   32: new 315	java/security/spec/X509EncodedKeySpec
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 318	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   40: invokevirtual 322	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   43: aload_2
    //   44: new 324	java/security/spec/PKCS8EncodedKeySpec
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 325	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   52: invokevirtual 329	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   55: invokespecial 332	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   58: astore_0
    //   59: ldc_w 299
    //   62: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: new 174	com/google/firebase/iid/ah
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 242	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   76: astore_0
    //   77: ldc_w 299
    //   80: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: aload_0
    //   87: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore_1
    //   91: new 119	java/lang/StringBuilder
    //   94: dup
    //   95: aload_1
    //   96: invokestatic 117	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   99: invokevirtual 123	java/lang/String:length	()I
    //   102: bipush 19
    //   104: iadd
    //   105: invokespecial 125	java/lang/StringBuilder:<init>	(I)V
    //   108: ldc_w 334
    //   111: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: new 174	com/google/firebase/iid/ah
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 242	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   127: astore_0
    //   128: ldc_w 299
    //   131: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: goto -51 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramString1	String
    //   0	140	1	paramString2	String
    //   26	18	2	localKeyFactory	java.security.KeyFactory
    // Exception table:
    //   from	to	target	type
    //   6	20	67	java/lang/IllegalArgumentException
    //   20	59	85	java/security/NoSuchAlgorithmException
    //   20	59	136	java/security/spec/InvalidKeySpecException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.iid.af
 * JD-Core Version:    0.7.0.1
 */