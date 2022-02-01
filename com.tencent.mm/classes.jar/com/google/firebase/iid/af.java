package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
  /* Error */
  private static java.security.KeyPair B(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 4238
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: bipush 8
    //   9: invokestatic 29	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   12: astore_0
    //   13: aload_1
    //   14: bipush 8
    //   16: invokestatic 29	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   19: astore_1
    //   20: ldc 31
    //   22: invokestatic 37	java/security/KeyFactory:getInstance	(Ljava/lang/String;)Ljava/security/KeyFactory;
    //   25: astore_2
    //   26: new 39	java/security/KeyPair
    //   29: dup
    //   30: aload_2
    //   31: new 41	java/security/spec/X509EncodedKeySpec
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 44	java/security/spec/X509EncodedKeySpec:<init>	([B)V
    //   39: invokevirtual 48	java/security/KeyFactory:generatePublic	(Ljava/security/spec/KeySpec;)Ljava/security/PublicKey;
    //   42: aload_2
    //   43: new 50	java/security/spec/PKCS8EncodedKeySpec
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 51	java/security/spec/PKCS8EncodedKeySpec:<init>	([B)V
    //   51: invokevirtual 55	java/security/KeyFactory:generatePrivate	(Ljava/security/spec/KeySpec;)Ljava/security/PrivateKey;
    //   54: invokespecial 58	java/security/KeyPair:<init>	(Ljava/security/PublicKey;Ljava/security/PrivateKey;)V
    //   57: astore_0
    //   58: sipush 4238
    //   61: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload_0
    //   65: areturn
    //   66: astore_0
    //   67: new 63	com/google/firebase/iid/ah
    //   70: dup
    //   71: aload_0
    //   72: invokespecial 66	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   75: astore_0
    //   76: sipush 4238
    //   79: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: aload_0
    //   86: invokestatic 72	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   89: astore_1
    //   90: new 74	java/lang/StringBuilder
    //   93: dup
    //   94: aload_1
    //   95: invokestatic 72	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   98: invokevirtual 78	java/lang/String:length	()I
    //   101: bipush 19
    //   103: iadd
    //   104: invokespecial 80	java/lang/StringBuilder:<init>	(I)V
    //   107: ldc 82
    //   109: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: new 63	com/google/firebase/iid/ah
    //   120: dup
    //   121: aload_0
    //   122: invokespecial 66	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   125: astore_0
    //   126: sipush 4238
    //   129: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static ag a(SharedPreferences paramSharedPreferences, String paramString)
  {
    AppMethodBeat.i(4244);
    String str1 = paramSharedPreferences.getString(p.z(paramString, "|P|"), null);
    String str2 = paramSharedPreferences.getString(p.z(paramString, "|K|"), null);
    if ((str1 == null) || (str2 == null))
    {
      AppMethodBeat.o(4244);
      return null;
    }
    paramSharedPreferences = new ag(B(str1, str2), b(paramSharedPreferences, paramString));
    AppMethodBeat.o(4244);
    return paramSharedPreferences;
  }
  
  private static void a(Context paramContext, String paramString, ag paramag)
  {
    AppMethodBeat.i(4240);
    try
    {
      Log.isLoggable("FirebaseInstanceId", 3);
      paramString = r(paramContext, paramString);
      paramString.createNewFile();
      paramContext = new Properties();
      paramContext.setProperty("pub", paramag.zzq());
      paramContext.setProperty("pri", paramag.YA());
      paramContext.setProperty("cre", String.valueOf(paramag.dDQ));
      paramString = new FileOutputStream(paramString);
      try
      {
        paramContext.store(paramString, null);
        a(null, paramString);
        AppMethodBeat.o(4240);
        return;
      }
      finally
      {
        try
        {
          AppMethodBeat.o(4240);
          throw paramContext;
        }
        finally
        {
          a(paramContext, paramString);
          AppMethodBeat.o(4240);
        }
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
  
  static File aY(Context paramContext)
  {
    AppMethodBeat.i(4241);
    File localFile = androidx.core.content.a.ac(paramContext);
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
    paramSharedPreferences = paramSharedPreferences.getString(p.z(paramString, "cre"), null);
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
      paramContext.putString(p.z(paramString, "|P|"), paramag.zzq());
      paramContext.putString(p.z(paramString, "|K|"), paramag.YA());
      paramContext.putString(p.z(paramString, "cre"), String.valueOf(paramag.dDQ));
      paramContext.commit();
      AppMethodBeat.o(4245);
    }
  }
  
  static ag o(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4236);
    ag localag1 = new ag(a.Yr(), System.currentTimeMillis());
    try
    {
      ag localag2 = p(paramContext, paramString);
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
  static ag p(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: sipush 4237
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 261	com/google/firebase/iid/af:q	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 258	com/google/firebase/iid/af:b	(Landroid/content/Context;Ljava/lang/String;Lcom/google/firebase/iid/ag;)V
    //   22: sipush 4237
    //   25: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: ldc 215
    //   35: iconst_0
    //   36: invokevirtual 219	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   39: aload_1
    //   40: invokestatic 221	com/google/firebase/iid/af:a	(Landroid/content/SharedPreferences;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +21 -> 66
    //   48: aload_0
    //   49: aload_1
    //   50: aload_3
    //   51: invokestatic 256	com/google/firebase/iid/af:a	(Landroid/content/Context;Ljava/lang/String;Lcom/google/firebase/iid/ag;)V
    //   54: sipush 4237
    //   57: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_3
    //   61: areturn
    //   62: astore_2
    //   63: goto -31 -> 32
    //   66: aload_2
    //   67: ifnull +11 -> 78
    //   70: sipush 4237
    //   73: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_2
    //   77: athrow
    //   78: sipush 4237
    //   81: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static ag q(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4239);
    paramContext = r(paramContext, paramString);
    if (!paramContext.exists())
    {
      AppMethodBeat.o(4239);
      return null;
    }
    try
    {
      paramString = y(paramContext);
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
        paramContext = y(paramContext);
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
  
  private static File r(Context paramContext, String paramString)
  {
    AppMethodBeat.i(4242);
    if (TextUtils.isEmpty(paramString)) {
      paramString = "com.google.InstanceId.properties";
    }
    for (;;)
    {
      paramContext = new File(aY(paramContext), paramString);
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
  private static ag y(File paramFile)
  {
    // Byte code:
    //   0: sipush 4243
    //   3: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 179	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_0
    //   15: new 137	java/util/Properties
    //   18: dup
    //   19: invokespecial 138	java/util/Properties:<init>	()V
    //   22: astore_3
    //   23: aload_3
    //   24: aload_0
    //   25: invokevirtual 314	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   28: aload_3
    //   29: ldc 140
    //   31: invokevirtual 318	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   34: astore 4
    //   36: aload_3
    //   37: ldc 150
    //   39: invokevirtual 318	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 5
    //   44: aload 4
    //   46: ifnull +8 -> 54
    //   49: aload 5
    //   51: ifnonnull +16 -> 67
    //   54: aconst_null
    //   55: aload_0
    //   56: invokestatic 320	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   59: sipush 4243
    //   62: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: aconst_null
    //   66: areturn
    //   67: aload 4
    //   69: aload 5
    //   71: invokestatic 107	com/google/firebase/iid/af:B	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPair;
    //   74: astore 4
    //   76: aload_3
    //   77: ldc 155
    //   79: invokevirtual 318	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   82: invokestatic 213	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   85: lstore_1
    //   86: new 105	com/google/firebase/iid/ag
    //   89: dup
    //   90: aload 4
    //   92: lload_1
    //   93: invokespecial 114	com/google/firebase/iid/ag:<init>	(Ljava/security/KeyPair;J)V
    //   96: astore_3
    //   97: aconst_null
    //   98: aload_0
    //   99: invokestatic 320	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   102: sipush 4243
    //   105: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_3
    //   109: areturn
    //   110: astore_3
    //   111: new 63	com/google/firebase/iid/ah
    //   114: dup
    //   115: aload_3
    //   116: invokespecial 66	com/google/firebase/iid/ah:<init>	(Ljava/lang/Exception;)V
    //   119: astore_3
    //   120: sipush 4243
    //   123: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_3
    //   129: sipush 4243
    //   132: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_3
    //   136: athrow
    //   137: astore 4
    //   139: aload_3
    //   140: aload_0
    //   141: invokestatic 320	com/google/firebase/iid/af:a	(Ljava/lang/Throwable;Ljava/io/FileInputStream;)V
    //   144: sipush 4243
    //   147: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 4
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramFile	File
    //   85	8	1	l	long
    //   22	87	3	localObject1	Object
    //   110	6	3	localNumberFormatException	NumberFormatException
    //   119	8	3	localah	ah
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.af
 * JD-Core Version:    0.7.0.1
 */