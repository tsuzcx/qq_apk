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
    AppMethodBeat.i(4244);
    String str1 = paramSharedPreferences.getString(p.o(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(p.o(paramString, "|K|"), null);
    if ((str1 == null) || (str2 == null))
    {
      AppMethodBeat.o(4244);
      return null;
    }
    paramSharedPreferences = new ag(r(str1, str2), b(paramSharedPreferences, paramString));
    AppMethodBeat.o(4244);
    return paramSharedPreferences;
  }
  
  private static void a(Context paramContext, String paramString, ag paramag)
  {
    Object localObject = null;
    AppMethodBeat.i(4240);
    try
    {
      Log.isLoggable("FirebaseInstanceId", 3);
      paramContext = m(paramContext, paramString);
      paramContext.createNewFile();
      paramString = new Properties();
      paramString.setProperty("pub", paramag.zzq());
      paramString.setProperty("pri", paramag.yn());
      paramString.setProperty("cre", String.valueOf(paramag.bMn));
      paramag = new FileOutputStream(paramContext);
      paramContext = localObject;
      try
      {
        paramString.store(paramag, null);
        a(null, paramag);
        AppMethodBeat.o(4240);
        return;
      }
      catch (Throwable paramString)
      {
        paramContext = paramString;
        AppMethodBeat.o(4240);
        paramContext = paramString;
        throw paramString;
      }
      finally
      {
        a(paramContext, paramag);
        AppMethodBeat.o(4240);
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext = String.valueOf(paramContext);
      new StringBuilder(String.valueOf(paramContext).length() + 21).append("Failed to write key: ").append(paramContext);
      AppMethodBeat.o(4240);
    }
  }
  
  static File ap(Context paramContext)
  {
    AppMethodBeat.i(4241);
    File localFile = b.S(paramContext);
    if ((localFile != null) && (localFile.isDirectory()))
    {
      AppMethodBeat.o(4241);
      return localFile;
    }
    paramContext = paramContext.getFilesDir();
    AppMethodBeat.o(4241);
    return paramContext;
  }
  
  private static long b(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(4246);
    paramSharedPreferences = paramSharedPreferences.getString(p.o(paramString, "cre"), null);
    if (paramSharedPreferences != null) {
      try
      {
        long l = Long.parseLong(paramSharedPreferences);
        AppMethodBeat.o(4246);
        return l;
      }
      catch (NumberFormatException paramSharedPreferences) {}
    }
    AppMethodBeat.o(4246);
    return 0L;
  }
  
  private static void b(Context paramContext, String paramString, ag paramag)
  {
    AppMethodBeat.i(4245);
    paramContext = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    try
    {
      boolean bool = paramag.equals(a(paramContext, paramString));
      if (bool)
      {
        AppMethodBeat.o(4245);
        return;
      }
    }
    catch (ah localah)
    {
      Log.isLoggable("FirebaseInstanceId", 3);
      paramContext = paramContext.edit();
      paramContext.putString(p.o(paramString, "|P|"), paramag.zzq());
      paramContext.putString(p.o(paramString, "|K|"), paramag.yn());
      paramContext.putString(p.o(paramString, "cre"), String.valueOf(paramag.bMn));
      paramContext.commit();
      AppMethodBeat.o(4245);
    }
  }
  
  static ag j(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4236);
    ag localag1 = new ag(a.ye(), System.currentTimeMillis());
    try
    {
      ag localag2 = k(paramContext, paramString);
      if (localag2 != null)
      {
        Log.isLoggable("FirebaseInstanceId", 3);
        AppMethodBeat.o(4236);
        return localag2;
      }
    }
    catch (ah localah)
    {
      Log.isLoggable("FirebaseInstanceId", 3);
      a(paramContext, paramString, localag1);
      b(paramContext, paramString, localag1);
      AppMethodBeat.o(4236);
    }
    return localag1;
  }
  
  /* Error */
  static ag k(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: sipush 4237
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 217	com/google/firebase/iid/af:l	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 214	com/google/firebase/iid/af:b	(Landroid/content/Context;Ljava/lang/String;Lcom/google/firebase/iid/ag;)V
    //   22: sipush 4237
    //   25: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: ldc 170
    //   35: iconst_0
    //   36: invokevirtual 174	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   39: aload_1
    //   40: invokestatic 176	com/google/firebase/iid/af:a	(Landroid/content/SharedPreferences;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +21 -> 66
    //   48: aload_0
    //   49: aload_1
    //   50: aload_3
    //   51: invokestatic 212	com/google/firebase/iid/af:a	(Landroid/content/Context;Ljava/lang/String;Lcom/google/firebase/iid/ag;)V
    //   54: sipush 4237
    //   57: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_3
    //   61: areturn
    //   62: astore_2
    //   63: goto -31 -> 32
    //   66: aload_2
    //   67: ifnull +11 -> 78
    //   70: sipush 4237
    //   73: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: athrow
    //   78: sipush 4237
    //   81: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_2
    //   87: goto -21 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramContext	Context
    //   0	90	1	paramString	String
    //   11	21	2	localag1	ag
    //   62	15	2	localah1	ah
    //   86	1	2	localah2	ah
    //   43	18	3	localag2	ag
    // Exception table:
    //   from	to	target	type
    //   6	12	62	com/google/firebase/iid/ah
    //   16	22	62	com/google/firebase/iid/ah
    //   32	44	86	com/google/firebase/iid/ah
    //   48	54	86	com/google/firebase/iid/ah
  }
  
  private static ag l(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4239);
    paramContext = m(paramContext, paramString);
    if (!paramContext.exists())
    {
      AppMethodBeat.o(4239);
      return null;
    }
    try
    {
      paramString = x(paramContext);
      AppMethodBeat.o(4239);
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
        paramContext = x(paramContext);
        AppMethodBeat.o(4239);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramString = String.valueOf(paramContext);
        new StringBuilder(String.valueOf(paramString).length() + 45).append("IID file exists, but failed to read from it: ").append(paramString);
        paramContext = new ah(paramContext);
        AppMethodBeat.o(4239);
        throw paramContext;
      }
    }
  }
  
  private static File m(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4242);
    if (TextUtils.isEmpty(paramString)) {
      paramString = "com.google.InstanceId.properties";
    }
    for (;;)
    {
      paramContext = new File(ap(paramContext), paramString);
      AppMethodBeat.o(4242);
      return paramContext;
      try
      {
        paramString = Base64.encodeToString(paramString.getBytes("UTF-8"), 11);
        paramString = String.valueOf(paramString).length() + 33 + "com.google.InstanceId_" + paramString + ".properties";
      }
      catch (UnsupportedEncodingException paramContext)
      {
        paramContext = new AssertionError(paramContext);
        AppMethodBeat.o(4242);
        throw paramContext;
      }
    }
  }
  
  /* Error */
  private static java.security.KeyPair r(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 4238
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: bipush 8
    //   9: invokestatic 280	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   12: astore_0
    //   13: aload_1
    //   14: bipush 8
    //   16: invokestatic 280	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   19: astore_1
    //   20: ldc_w 282
    //   23: invokestatic 288	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   26: astore_2
    //   27: new 290	java/security/KeyPair
    //   30: dup
    //   31: aload_2
    //   32: new 292	java/security/spec/X509EncodedKeySpec
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 295	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   40: invokevirtual 299	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   43: aload_2
    //   44: new 301	java/security/spec/PKCS8EncodedKeySpec
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 302	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   52: invokevirtual 306	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   55: invokespecial 309	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   58: astore_0
    //   59: sipush 4238
    //   62: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aload_0
    //   66: areturn
    //   67: astore_0
    //   68: new 168	com/google/firebase/iid/ah
    //   71: dup
    //   72: aload_0
    //   73: invokespecial 231	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   76: astore_0
    //   77: sipush 4238
    //   80: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: aload_0
    //   87: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   90: astore_1
    //   91: new 117	java/lang/StringBuilder
    //   94: dup
    //   95: aload_1
    //   96: invokestatic 115	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   99: invokevirtual 121	java/lang/String:length	()I
    //   102: bipush 19
    //   104: iadd
    //   105: invokespecial 123	java/lang/StringBuilder:<init>	(I)V
    //   108: ldc_w 311
    //   111: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_1
    //   115: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: new 168	com/google/firebase/iid/ah
    //   122: dup
    //   123: aload_0
    //   124: invokespecial 231	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   127: astore_0
    //   128: sipush 4238
    //   131: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  /* Error */
  private static ag x(File paramFile)
  {
    // Byte code:
    //   0: sipush 4243
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 132	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 312	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore 4
    //   16: new 72	java/util/Properties
    //   19: dup
    //   20: invokespecial 73	java/util/Properties:<init>	()V
    //   23: astore_0
    //   24: aload_0
    //   25: aload 4
    //   27: invokevirtual 316	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   30: aload_0
    //   31: ldc 75
    //   33: invokevirtual 320	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_3
    //   37: aload_0
    //   38: ldc 85
    //   40: invokevirtual 320	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 5
    //   45: aload_3
    //   46: ifnull +8 -> 54
    //   49: aload 5
    //   51: ifnonnull +17 -> 68
    //   54: aconst_null
    //   55: aload 4
    //   57: invokestatic 322	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   60: sipush 4243
    //   63: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: aconst_null
    //   67: areturn
    //   68: aload_3
    //   69: aload 5
    //   71: invokestatic 40	com/google/firebase/iid/af:r	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPair;
    //   74: astore_3
    //   75: aload_0
    //   76: ldc 90
    //   78: invokevirtual 320	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 166	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   84: lstore_1
    //   85: new 36	com/google/firebase/iid/ag
    //   88: dup
    //   89: aload_3
    //   90: lload_1
    //   91: invokespecial 47	com/google/firebase/iid/ag:<init>	(Ljava/security/KeyPair;J)V
    //   94: astore_0
    //   95: aconst_null
    //   96: aload 4
    //   98: invokestatic 322	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   101: sipush 4243
    //   104: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: new 168	com/google/firebase/iid/ah
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 231	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   118: astore_0
    //   119: sipush 4243
    //   122: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   125: aload_0
    //   126: athrow
    //   127: astore_3
    //   128: sipush 4243
    //   131: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_3
    //   135: athrow
    //   136: astore_0
    //   137: aload_3
    //   138: aload 4
    //   140: invokestatic 322	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   143: sipush 4243
    //   146: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.af
 * JD-Core Version:    0.7.0.1
 */