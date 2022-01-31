package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.b;
import android.support.v4.e.a;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class p
{
  private final SharedPreferences bfF;
  private final af bfG;
  private final Map<String, ag> bfH;
  private final Context bfj;
  
  public p(Context paramContext)
  {
    this(paramContext, new af());
    AppMethodBeat.i(108749);
    AppMethodBeat.o(108749);
  }
  
  private p(Context paramContext, af paramaf)
  {
    AppMethodBeat.i(108750);
    this.bfH = new a();
    this.bfj = paramContext;
    this.bfF = paramContext.getSharedPreferences("com.google.android.gms.appid", 0);
    this.bfG = paramaf;
    paramContext = new File(b.P(this.bfj), "com.google.android.gms.appid-no-backup");
    if (!paramContext.exists()) {
      try
      {
        if ((paramContext.createNewFile()) && (!isEmpty()))
        {
          zzag();
          FirebaseInstanceId.rL().rQ();
        }
        AppMethodBeat.o(108750);
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
            AppMethodBeat.o(108750);
            return;
          }
          new String("Error creating file in no backup dir: ");
        }
      }
    }
    AppMethodBeat.o(108750);
  }
  
  private static String c(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(108754);
    paramString1 = String.valueOf(paramString1).length() + 4 + String.valueOf(paramString2).length() + String.valueOf(paramString3).length() + paramString1 + "|T|" + paramString2 + "|" + paramString3;
    AppMethodBeat.o(108754);
    return paramString1;
  }
  
  private final boolean isEmpty()
  {
    try
    {
      AppMethodBeat.i(108753);
      boolean bool = this.bfF.getAll().isEmpty();
      AppMethodBeat.o(108753);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static String o(String paramString1, String paramString2)
  {
    AppMethodBeat.i(108755);
    paramString1 = String.valueOf(paramString1).length() + 3 + String.valueOf(paramString2).length() + paramString1 + "|S|" + paramString2;
    AppMethodBeat.o(108755);
    return paramString1;
  }
  
  /* Error */
  public final ag aY(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 160
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 43	com/google/firebase/iid/p:bfH	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 164 2 0
    //   17: checkcast 166	com/google/firebase/iid/ag
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +12 -> 34
    //   25: ldc 160
    //   27: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: areturn
    //   34: aload_0
    //   35: getfield 45	com/google/firebase/iid/p:bfj	Landroid/content/Context;
    //   38: astore_3
    //   39: aload_3
    //   40: aload_1
    //   41: invokestatic 170	com/google/firebase/iid/af:l	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +28 -> 74
    //   49: aload_0
    //   50: getfield 43	com/google/firebase/iid/p:bfH	Ljava/util/Map;
    //   53: aload_1
    //   54: aload_2
    //   55: invokeinterface 174 3 0
    //   60: pop
    //   61: ldc 160
    //   63: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -36 -> 30
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: aload_3
    //   75: aload_1
    //   76: invokestatic 177	com/google/firebase/iid/af:k	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   79: astore_2
    //   80: goto -31 -> 49
    //   83: astore_2
    //   84: invokestatic 89	com/google/firebase/iid/FirebaseInstanceId:rL	()Lcom/google/firebase/iid/FirebaseInstanceId;
    //   87: invokevirtual 92	com/google/firebase/iid/FirebaseInstanceId:rQ	()V
    //   90: aload_0
    //   91: getfield 45	com/google/firebase/iid/p:bfj	Landroid/content/Context;
    //   94: aload_1
    //   95: invokestatic 177	com/google/firebase/iid/af:k	(Landroid/content/Context;Ljava/lang/String;)Lcom/google/firebase/iid/ag;
    //   98: astore_2
    //   99: goto -50 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	this	p
    //   0	102	1	paramString	String
    //   20	60	2	localag1	ag
    //   83	1	2	localah	ah
    //   98	1	2	localag2	ag
    //   38	37	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	21	69	finally
    //   25	30	69	finally
    //   34	45	69	finally
    //   49	66	69	finally
    //   74	80	69	finally
    //   84	99	69	finally
    //   34	45	83	com/google/firebase/iid/ah
    //   74	80	83	com/google/firebase/iid/ah
  }
  
  public final void aZ(String paramString)
  {
    try
    {
      AppMethodBeat.i(108760);
      paramString = String.valueOf(paramString).concat("|T|");
      SharedPreferences.Editor localEditor = this.bfF.edit();
      Iterator localIterator = this.bfF.getAll().keySet().iterator();
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
    AppMethodBeat.o(108760);
  }
  
  /* Error */
  public final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 218
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload 4
    //   9: aload 5
    //   11: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   14: invokestatic 229	com/google/firebase/iid/q:b	(Ljava/lang/String;Ljava/lang/String;J)Ljava/lang/String;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnonnull +11 -> 32
    //   24: ldc 218
    //   26: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 55	com/google/firebase/iid/p:bfF	Landroid/content/SharedPreferences;
    //   36: invokeinterface 183 1 0
    //   41: astore 5
    //   43: aload 5
    //   45: aload_1
    //   46: aload_2
    //   47: aload_3
    //   48: invokestatic 231	com/google/firebase/iid/p:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: aload 4
    //   53: invokeinterface 235 3 0
    //   58: pop
    //   59: aload 5
    //   61: invokeinterface 215 1 0
    //   66: pop
    //   67: ldc 218
    //   69: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: goto -43 -> 29
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	p
    //   0	80	1	paramString1	String
    //   0	80	2	paramString2	String
    //   0	80	3	paramString3	String
    //   0	80	4	paramString4	String
    //   0	80	5	paramString5	String
    // Exception table:
    //   from	to	target	type
    //   2	19	75	finally
    //   24	29	75	finally
    //   32	72	75	finally
  }
  
  public final q d(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      AppMethodBeat.i(108757);
      paramString1 = q.ba(this.bfF.getString(c(paramString1, paramString2, paramString3), null));
      AppMethodBeat.o(108757);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public final String sb()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: ldc 247
    //   6: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 55	com/google/firebase/iid/p:bfF	Landroid/content/SharedPreferences;
    //   13: ldc 249
    //   15: aconst_null
    //   16: invokeinterface 241 3 0
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +38 -> 61
    //   26: aload_2
    //   27: ldc 251
    //   29: invokevirtual 255	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   32: astore_2
    //   33: aload_2
    //   34: arraylength
    //   35: iconst_1
    //   36: if_icmple +25 -> 61
    //   39: aload_2
    //   40: iconst_1
    //   41: aaload
    //   42: invokestatic 260	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +16 -> 61
    //   48: aload_2
    //   49: iconst_1
    //   50: aaload
    //   51: astore_1
    //   52: ldc 247
    //   54: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: areturn
    //   61: ldc 247
    //   63: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: goto -9 -> 57
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	p
    //   1	59	1	str	String
    //   69	4	1	localObject1	Object
    //   21	28	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	22	69	finally
    //   26	48	69	finally
    //   52	57	69	finally
    //   61	66	69	finally
  }
  
  public final void zzag()
  {
    for (;;)
    {
      int i;
      try
      {
        AppMethodBeat.i(108756);
        this.bfH.clear();
        File[] arrayOfFile = af.ai(this.bfj).listFiles();
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
          this.bfF.edit().clear().commit();
          AppMethodBeat.o(108756);
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
        AppMethodBeat.i(108752);
        String str2 = this.bfF.getString("topic_operaion_queue", "");
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
            this.bfF.edit().putString("topic_operaion_queue", paramString).apply();
            bool = true;
            AppMethodBeat.o(108752);
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
      AppMethodBeat.o(108752);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.firebase.iid.p
 * JD-Core Version:    0.7.0.1
 */