package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class p
{
  private final Context bJa;
  private final SharedPreferences bJv;
  private final af bJw;
  private final Map<String, ag> bJx;
  
  public p(Context paramContext)
  {
    this(paramContext, new af());
    AppMethodBeat.i(4185);
    AppMethodBeat.o(4185);
  }
  
  private p(Context paramContext, af paramaf)
  {
    AppMethodBeat.i(4186);
    this.bJx = new androidx.b.a();
    this.bJa = paramContext;
    this.bJv = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    this.bJw = paramaf;
    paramContext = new File(androidx.core.content.a.R(this.bJa), "com.google.android.gms.appid-no-backup");
    if (!paramContext.exists()) {
      try
      {
        if ((paramContext.createNewFile()) && (!isEmpty()))
        {
          zzag();
          FirebaseInstanceId.yw().yB();
        }
        AppMethodBeat.o(4186);
        return;
      }
      catch (IOException paramContext)
      {
        if (Log.isLoggable("FirebaseInstanceId", 3))
        {
          paramContext = String.valueOf(paramContext.getMessage());
          if (paramContext.length() != 0)
          {
            "Error creating file in no backup dir: ".concat(paramContext);
            AppMethodBeat.o(4186);
            return;
          }
          new String("Error creating file in no backup dir: ");
        }
      }
    }
    AppMethodBeat.o(4186);
  }
  
  private static String b(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(4190);
    paramString1 = String.valueOf(paramString1).length() + 4 + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + "|T|" + paramString2 + "|" + paramString3;
    AppMethodBeat.o(4190);
    return paramString1;
  }
  
  private final boolean isEmpty()
  {
    try
    {
      AppMethodBeat.i(4189);
      boolean bool = this.bJv.getAll().isEmpty();
      AppMethodBeat.o(4189);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String t(String paramString1, String paramString2)
  {
    AppMethodBeat.i(4191);
    paramString1 = String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length() + paramString1 + "|S|" + paramString2;
    AppMethodBeat.o(4191);
    return paramString1;
  }
  
  /* Error */
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 4194
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload 4
    //   10: aload 5
    //   12: invokestatic 158	java/lang/System:currentTimeMillis	()J
    //   15: invokestatic 163	com/google/firebase/iid/q:b	(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnonnull +12 -> 34
    //   25: sipush 4194
    //   28: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: getfield 53	com/google/firebase/iid/p:bJv	Landroid/content/SharedPreferences;
    //   38: invokeinterface 167 1 0
    //   43: astore 5
    //   45: aload 5
    //   47: aload_1
    //   48: aload_2
    //   49: aload_3
    //   50: invokestatic 169	com/google/firebase/iid/p:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   53: aload 4
    //   55: invokeinterface 175 3 0
    //   60: pop
    //   61: aload 5
    //   63: invokeinterface 178 1 0
    //   68: pop
    //   69: sipush 4194
    //   72: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: goto -44 -> 31
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	p
    //   0	83	1	paramString1	String
    //   0	83	2	paramString2	String
    //   0	83	3	paramString3	String
    //   0	83	4	paramString4	String
    //   0	83	5	paramString5	String
    // Exception table:
    //   from	to	target	type
    //   2	20	78	finally
    //   25	31	78	finally
    //   34	75	78	finally
  }
  
  public final q c(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(4193);
      paramString1 = q.cd(this.bJv.getString(b(paramString1, paramString2, paramString3), null));
      AppMethodBeat.o(4193);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public final ag cb(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 4195
    //   5: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 41	com/google/firebase/iid/p:bJx	Ljava/util/Map;
    //   12: aload_1
    //   13: invokeinterface 195 2 0
    //   18: checkcast 197	com/google/firebase/iid/ag
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +13 -> 36
    //   26: sipush 4195
    //   29: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: aload_0
    //   37: getfield 43	com/google/firebase/iid/p:bJa	Landroid/content/Context;
    //   40: astore_3
    //   41: aload_3
    //   42: aload_1
    //   43: invokestatic 201	com/google/firebase/iid/af:l	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +29 -> 77
    //   51: aload_0
    //   52: getfield 41	com/google/firebase/iid/p:bJx	Ljava/util/Map;
    //   55: aload_1
    //   56: aload_2
    //   57: invokeinterface 205 3 0
    //   62: pop
    //   63: sipush 4195
    //   66: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -37 -> 32
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    //   77: aload_3
    //   78: aload_1
    //   79: invokestatic 208	com/google/firebase/iid/af:k	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   82: astore_2
    //   83: goto -32 -> 51
    //   86: astore_2
    //   87: invokestatic 87	com/google/firebase/iid/FirebaseInstanceId:yw	()Lcom/google/firebase/iid/FirebaseInstanceId;
    //   90: invokevirtual 90	com/google/firebase/iid/FirebaseInstanceId:yB	()V
    //   93: aload_0
    //   94: getfield 43	com/google/firebase/iid/p:bJa	Landroid/content/Context;
    //   97: aload_1
    //   98: invokestatic 208	com/google/firebase/iid/af:k	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   101: astore_2
    //   102: goto -51 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	p
    //   0	105	1	paramString	String
    //   21	62	2	localag1	ag
    //   86	1	2	localah	ah
    //   101	1	2	localag2	ag
    //   40	38	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	22	72	finally
    //   26	32	72	finally
    //   36	47	72	finally
    //   51	69	72	finally
    //   77	83	72	finally
    //   87	102	72	finally
    //   36	47	86	com/google/firebase/iid/ah
    //   77	83	86	com/google/firebase/iid/ah
  }
  
  public final void cc(String paramString)
  {
    try
    {
      AppMethodBeat.i(4196);
      paramString = String.valueOf(paramString).concat("|T|");
      SharedPreferences.Editor localEditor = this.bJv.edit();
      Iterator localIterator = this.bJv.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str.startsWith(paramString)) {
          localEditor.remove(str);
        }
      }
      localEditor.commit();
    }
    finally {}
    AppMethodBeat.o(4196);
  }
  
  /* Error */
  public final String yM()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: sipush 4187
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_0
    //   11: getfield 53	com/google/firebase/iid/p:bJv	Landroid/content/SharedPreferences;
    //   14: ldc 239
    //   16: aconst_null
    //   17: invokeinterface 183 3 0
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +39 -> 63
    //   27: aload_2
    //   28: ldc 241
    //   30: invokevirtual 245	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore_2
    //   34: aload_2
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmple +26 -> 63
    //   40: aload_2
    //   41: iconst_1
    //   42: aaload
    //   43: invokestatic 250	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +17 -> 63
    //   49: aload_2
    //   50: iconst_1
    //   51: aaload
    //   52: astore_1
    //   53: sipush 4187
    //   56: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: sipush 4187
    //   66: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: goto -10 -> 59
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	p
    //   1	61	1	str	String
    //   72	4	1	localObject1	Object
    //   22	28	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	23	72	finally
    //   27	49	72	finally
    //   53	59	72	finally
    //   63	69	72	finally
  }
  
  public final void zzag()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(4192);
        this.bJx.clear();
        File[] arrayOfFile = af.an(this.bJa).listFiles();
        int j = arrayOfFile.length;
        i = 0;
        if (i < j)
        {
          File localFile = arrayOfFile[i];
          if (localFile.getName().startsWith("com.google.InstanceId")) {
            localFile.delete();
          }
        }
        else
        {
          this.bJv.edit().clear().commit();
          AppMethodBeat.o(4192);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public final boolean zzf(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(4188);
        String str2 = this.bJv.getString("topic_operaion_queue", "");
        String str1 = String.valueOf(",");
        String str3 = String.valueOf(paramString);
        if (str3.length() != 0)
        {
          str1 = str1.concat(str3);
          if (!str2.startsWith(str1)) {
            break label157;
          }
          str1 = String.valueOf(",");
          paramString = String.valueOf(paramString);
          if (paramString.length() != 0)
          {
            paramString = str1.concat(paramString);
            paramString = str2.substring(paramString.length());
            this.bJv.edit().putString("topic_operaion_queue", paramString).apply();
            bool = true;
            AppMethodBeat.o(4188);
            return bool;
          }
        }
        else
        {
          str1 = new String(str1);
          continue;
        }
        paramString = new String(str1);
      }
      finally {}
      continue;
      label157:
      boolean bool = false;
      AppMethodBeat.o(4188);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.p
 * JD-Core Version:    0.7.0.1
 */