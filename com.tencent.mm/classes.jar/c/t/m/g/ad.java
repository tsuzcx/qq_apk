package c.t.m.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class ad
{
  private JSONObject a;
  
  /* Error */
  public final String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   6: ifnonnull +10 -> 16
    //   9: ldc 18
    //   11: astore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: aload_0
    //   17: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   20: invokevirtual 23	org/json/JSONObject:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: goto -12 -> 12
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	ad
    //   11	13	1	str	String
    //   27	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	27	finally
    //   16	24	27	finally
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    label189:
    boolean bool;
    for (;;)
    {
      JSONObject localJSONObject;
      ArrayList localArrayList;
      try
      {
        if ((this.a == null) || (TextUtils.isEmpty(paramString1)))
        {
          paramString1 = "";
          return paramString1;
        }
        localJSONObject = this.a.optJSONObject("data");
        if (localJSONObject == null)
        {
          paramString1 = "";
          continue;
        }
        localJSONObject = localJSONObject.optJSONObject(paramString1);
        if (localJSONObject == null)
        {
          paramString1 = "";
          continue;
        }
        localArrayList = new ArrayList();
        paramString1 = localJSONObject.keys();
        if (paramString1.hasNext())
        {
          Object localObject = (String)paramString1.next();
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            continue;
          }
          if (((String)localObject).equals("deviceid"))
          {
            paramString1 = localJSONObject.optString("deviceid");
            continue;
          }
          localObject = new ad.a((String)localObject, paramInt, paramString2, paramString3, paramString4, paramString5);
          if (!((ad.a)localObject).b) {
            continue;
          }
          localArrayList.add(localObject);
          continue;
        }
        if (localArrayList.size() != 0) {
          break label189;
        }
      }
      finally {}
      paramString1 = "";
      continue;
      if (localArrayList.size() == 1)
      {
        paramString1 = localJSONObject.optString(((ad.a)localArrayList.get(0)).a);
      }
      else
      {
        paramString1 = (ad.a)localArrayList.get(0);
        paramInt = 1;
        if (paramInt < localArrayList.size())
        {
          paramString2 = (ad.a)localArrayList.get(paramInt);
          if (!paramString1.b) {
            break label397;
          }
          if (paramString2.c != paramString1.c)
          {
            bool = paramString2.c;
            break;
          }
          if (paramString2.d != paramString1.d)
          {
            bool = paramString2.d;
            break;
          }
          if (paramString2.e != paramString1.e)
          {
            bool = paramString2.e;
            break;
          }
          if (paramString2.f != paramString1.f)
          {
            bool = paramString2.f;
            break;
          }
          if (paramString2.g == paramString1.g) {
            break label397;
          }
          bool = paramString2.g;
          break;
        }
        paramString1 = localJSONObject.optString(paramString1.a);
      }
    }
    label397:
    label401:
    for (;;)
    {
      for (;;)
      {
        if (!bool) {
          break label401;
        }
        paramString1 = paramString2;
        paramInt += 1;
        break;
        bool = true;
      }
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 20	org/json/JSONObject
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 108	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   27: ifnonnull +11 -> 38
    //   30: aload_0
    //   31: aload_3
    //   32: putfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   35: goto -24 -> 11
    //   38: aload_3
    //   39: ldc 32
    //   41: invokevirtual 36	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   44: astore_1
    //   45: aload_3
    //   46: ldc 110
    //   48: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_3
    //   52: aload_1
    //   53: ifnull -42 -> 11
    //   56: aload_3
    //   57: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifne -49 -> 11
    //   63: aload_0
    //   64: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   67: ldc 32
    //   69: invokevirtual 36	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   72: astore 4
    //   74: aload 4
    //   76: ifnonnull +33 -> 109
    //   79: aload_0
    //   80: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   83: ldc 32
    //   85: aload_1
    //   86: invokevirtual 114	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   89: pop
    //   90: aload_0
    //   91: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   94: ldc 110
    //   96: aload_3
    //   97: invokevirtual 114	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   100: pop
    //   101: goto -90 -> 11
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: aload_1
    //   110: invokevirtual 43	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   113: astore 5
    //   115: aload 5
    //   117: invokeinterface 49 1 0
    //   122: ifeq -32 -> 90
    //   125: aload 5
    //   127: invokeinterface 53 1 0
    //   132: checkcast 55	java/lang/String
    //   135: astore 6
    //   137: aload 6
    //   139: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne -27 -> 115
    //   145: aload_1
    //   146: aload 6
    //   148: invokevirtual 36	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   151: astore 7
    //   153: aload 7
    //   155: ifnull -40 -> 115
    //   158: aload 4
    //   160: aload 6
    //   162: aload 7
    //   164: invokevirtual 114	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   167: pop
    //   168: goto -53 -> 115
    //   171: astore_1
    //   172: goto -161 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	ad
    //   0	175	1	paramString	String
    //   6	2	2	bool	boolean
    //   22	75	3	localObject	Object
    //   72	87	4	localJSONObject1	JSONObject
    //   113	13	5	localIterator	Iterator
    //   135	26	6	str	String
    //   151	12	7	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   2	7	104	finally
    //   14	35	104	finally
    //   38	52	104	finally
    //   56	74	104	finally
    //   79	90	104	finally
    //   90	101	104	finally
    //   109	115	104	finally
    //   115	153	104	finally
    //   158	168	104	finally
    //   14	35	171	java/lang/Throwable
    //   38	52	171	java/lang/Throwable
    //   56	74	171	java/lang/Throwable
    //   79	90	171	java/lang/Throwable
    //   90	101	171	java/lang/Throwable
    //   109	115	171	java/lang/Throwable
    //   115	153	171	java/lang/Throwable
    //   158	168	171	java/lang/Throwable
  }
  
  public final void b()
  {
    try
    {
      this.a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   6: ifnull +17 -> 23
    //   9: aload_0
    //   10: getfield 16	c/t/m/g/ad:a	Lorg/json/JSONObject;
    //   13: ldc 110
    //   15: invokevirtual 65	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: ldc 18
    //   25: astore_1
    //   26: goto -7 -> 19
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	ad
    //   18	8	1	str	String
    //   29	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	29	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     c.t.m.g.ad
 * JD-Core Version:    0.7.0.1
 */