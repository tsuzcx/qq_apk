package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class dd
{
  private static dd b = null;
  private static Context c = null;
  public dc a = null;
  private volatile boolean d = false;
  private Timer e = null;
  
  private dd()
  {
    if ((c == null) || (c.getApplicationContext() == null)) {
      throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
    }
  }
  
  /* Error */
  public static dd a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	c/t/m/g/dd:b	Lc/t/m/g/dd;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 20	c/t/m/g/dd:b	Lc/t/m/g/dd;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	c/t/m/g/dd
    //   21: dup
    //   22: invokespecial 47	c/t/m/g/dd:<init>	()V
    //   25: putstatic 20	c/t/m/g/dd:b	Lc/t/m/g/dd;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 20	c/t/m/g/dd:b	Lc/t/m/g/dd;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localdd	dd
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private void a(long paramLong)
  {
    if (this.e != null)
    {
      Timer localTimer = this.e;
      a locala = new a();
      long l = paramLong;
      if (paramLong < 0L) {
        l = 0L;
      }
      localTimer.schedule(locala, l);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramContext.getApplicationContext() == null)) {
      throw new NullPointerException("context cannot be null!");
    }
    paramContext = paramContext.getApplicationContext();
    c = paramContext;
    df.a(paramContext, paramString1);
    de.a(paramString1, paramString2);
    new dd.1().start();
  }
  
  public static void a(String paramString)
  {
    de.a(paramString);
  }
  
  public static void a(HashMap<String, String> paramHashMap)
  {
    de.a(paramHashMap);
  }
  
  private void a(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        int i = de.a().b("cc_version");
        if (i == -1)
        {
          if (paramBoolean)
          {
            l = 5000L;
            da.a("CC_", "schedule : first[" + paramBoolean + "],locVer[" + i + "],delayTime[" + l + "]");
            a(l);
          }
        }
        else
        {
          l = f();
          continue;
        }
        long l = 10800000L;
      }
      catch (Throwable localThrowable)
      {
        da.b("CC_", localThrowable.toString());
        return;
      }
    }
  }
  
  private static long f()
  {
    long l1 = 86400000L;
    long l2 = de.a().c("cc_req_interval");
    if (l2 > 86400000L) {}
    for (;;)
    {
      if (l1 < 3600000L) {
        return 3600000L;
      }
      return l1;
      l1 = l2;
    }
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	c/t/m/g/dd:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 28	c/t/m/g/dd:d	Z
    //   19: ldc 101
    //   21: ldc 158
    //   23: invokestatic 132	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_0
    //   27: new 53	java/util/Timer
    //   30: dup
    //   31: ldc 160
    //   33: invokespecial 161	java/util/Timer:<init>	(Ljava/lang/String;)V
    //   36: putfield 32	c/t/m/g/dd:e	Ljava/util/Timer;
    //   39: aload_0
    //   40: iconst_1
    //   41: invokespecial 146	c/t/m/g/dd:a	(Z)V
    //   44: goto -33 -> 11
    //   47: astore_2
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_2
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	dd
    //   6	2	1	bool	boolean
    //   47	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	47	finally
    //   14	44	47	finally
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	c/t/m/g/dd:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_0
    //   16: putfield 28	c/t/m/g/dd:d	Z
    //   19: invokestatic 92	c/t/m/g/de:a	()Lc/t/m/g/de;
    //   22: getfield 164	c/t/m/g/de:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: invokevirtual 169	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   28: ldc 101
    //   30: ldc 171
    //   32: invokestatic 132	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: lconst_0
    //   37: invokespecial 134	c/t/m/g/dd:a	(J)V
    //   40: aload_0
    //   41: getfield 32	c/t/m/g/dd:e	Ljava/util/Timer;
    //   44: ifnull -33 -> 11
    //   47: aload_0
    //   48: getfield 32	c/t/m/g/dd:e	Ljava/util/Timer;
    //   51: astore_2
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 32	c/t/m/g/dd:e	Ljava/util/Timer;
    //   57: aload_2
    //   58: new 173	c/t/m/g/dd$2
    //   61: dup
    //   62: aload_2
    //   63: invokespecial 176	c/t/m/g/dd$2:<init>	(Ljava/util/Timer;)V
    //   66: ldc2_w 177
    //   69: invokevirtual 57	java/util/Timer:schedule	(Ljava/util/TimerTask;J)V
    //   72: goto -61 -> 11
    //   75: astore_2
    //   76: ldc 101
    //   78: ldc 180
    //   80: aload_2
    //   81: invokestatic 183	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   84: goto -73 -> 11
    //   87: astore_2
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	dd
    //   6	2	1	bool	boolean
    //   51	12	2	localTimer	Timer
    //   75	6	2	localThrowable	Throwable
    //   87	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	72	75	java/lang/Throwable
    //   2	7	87	finally
    //   14	19	87	finally
    //   19	72	87	finally
    //   76	84	87	finally
  }
  
  final class a
    extends TimerTask
  {
    private final JSONObject a = new JSONObject();
    private de b = null;
    private df c = null;
    private String d = "";
    
    public a() {}
    
    private JSONObject a()
    {
      if (dd.c(dd.this) == null) {
        return this.a;
      }
      da.a("CC_Task", "cc_url:" + "https://cc.map.qq.com/?get_c3");
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("cc_version", this.b.e("cc_version"));
        ((JSONObject)localObject).put("m_module", de.a);
        ((JSONObject)localObject).put("m_channel", de.b);
        ((JSONObject)localObject).put("m_version", de.c);
        ((JSONObject)localObject).put("imei", b());
        localObject = db.a(((JSONObject)localObject).toString(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
        da.a("CC_Task", "req:" + (String)localObject);
        String str = dd.c(dd.this).a("https://cc.map.qq.com/?get_c3", ((String)localObject).getBytes());
        if (TextUtils.isEmpty(str))
        {
          da.a("CC_Task", "net work error! res = " + str);
          return this.a;
        }
        da.a("CC_Task", "res:" + str);
        localObject = this.a.toString();
        if (((String)localObject).equals(str)) {
          da.a("CC_Task", "network or server error,response empty json");
        }
        while (TextUtils.isEmpty((CharSequence)localObject))
        {
          return this.a;
          da.a("CC_Task", "start dec");
          localObject = db.b(str, "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q");
          da.a("CC_Task", "end dec");
        }
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        da.a("CC_Task", localThrowable.getMessage(), localThrowable);
      }
      return this.a;
    }
    
    private void a(JSONObject paramJSONObject)
    {
      Object localObject = this.c.b();
      if (localObject == null) {
        return;
      }
      int j = this.b.b("cc_version");
      try
      {
        i = Integer.parseInt(paramJSONObject.optString("version", this.b.e("cc_version")));
        if (i == j)
        {
          da.a("CC_Task", "local version == server version");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        for (;;)
        {
          i = j;
        }
        paramJSONObject = paramJSONObject.optJSONObject("data");
        if (paramJSONObject == null) {
          paramJSONObject = this.a;
        }
        for (;;)
        {
          localObject = ((SharedPreferences)localObject).edit();
          Iterator localIterator = paramJSONObject.keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            try
            {
              String str2 = this.b.e(str1);
              if ((str2 != null) && (str2.length() != 0)) {
                ((SharedPreferences.Editor)localObject).putString(str1, paramJSONObject.optString(str1, str2));
              }
            }
            catch (Exception localException)
            {
              da.b("CC_Task", localException.getMessage());
            }
          }
        }
        ((SharedPreferences.Editor)localObject).putString("cc_version", String.valueOf(i));
      }
      for (;;)
      {
        try
        {
          l2 = Long.parseLong(paramJSONObject.optString("cc_req_interval", this.b.e("cc_req_interval")));
          if (l2 >= 3600000L) {
            continue;
          }
          l1 = 3600000L;
          ((SharedPreferences.Editor)localObject).putString("cc_req_interval", String.valueOf(l1));
        }
        catch (Throwable paramJSONObject)
        {
          long l2;
          long l1;
          continue;
        }
        ((SharedPreferences.Editor)localObject).apply();
        return;
        l1 = l2;
        if (l2 > 86400000L) {
          l1 = 86400000L;
        }
      }
    }
    
    @SuppressLint({"MissingPermission"})
    private String b()
    {
      if ((TextUtils.isEmpty(this.d)) || ("0123456789ABCDEF".equals(this.d))) {}
      try
      {
        String str1 = ((TelephonyManager)dd.e().getSystemService("phone")).getDeviceId();
        String str3 = str1;
        if (TextUtils.isEmpty(str1)) {
          str3 = "0123456789ABCDEF";
        }
        this.d = str3;
        return this.d;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          String str2 = "";
        }
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 30	c/t/m/g/dd$a:b	Lc/t/m/g/de;
      //   4: ldc_w 259
      //   7: invokevirtual 261	c/t/m/g/de:c	(Ljava/lang/String;)J
      //   10: lstore_2
      //   11: invokestatic 267	java/lang/System:currentTimeMillis	()J
      //   14: lload_2
      //   15: lsub
      //   16: invokestatic 273	java/lang/Math:abs	(J)J
      //   19: invokestatic 275	c/t/m/g/dd:d	()J
      //   22: lcmp
      //   23: iflt +295 -> 318
      //   26: aload_0
      //   27: getfield 20	c/t/m/g/dd$a:e	Lc/t/m/g/dd;
      //   30: invokestatic 278	c/t/m/g/dd:a	(Lc/t/m/g/dd;)Z
      //   33: istore 4
      //   35: iload 4
      //   37: ifeq +10 -> 47
      //   40: aload_0
      //   41: getfield 32	c/t/m/g/dd$a:c	Lc/t/m/g/df;
      //   44: invokevirtual 280	c/t/m/g/df:c	()V
      //   47: invokestatic 286	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   50: iconst_1
      //   51: invokevirtual 290	java/lang/Thread:setPriority	(I)V
      //   54: aload_0
      //   55: invokespecial 292	c/t/m/g/dd$a:a	()Lorg/json/JSONObject;
      //   58: astore 5
      //   60: aload 5
      //   62: aload_0
      //   63: getfield 28	c/t/m/g/dd$a:a	Lorg/json/JSONObject;
      //   66: if_acmpeq +121 -> 187
      //   69: aload 5
      //   71: ldc_w 294
      //   74: ldc_w 296
      //   77: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   80: invokestatic 171	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   83: istore_1
      //   84: ldc 55
      //   86: new 57	java/lang/StringBuilder
      //   89: dup
      //   90: ldc_w 298
      //   93: invokespecial 62	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   96: iload_1
      //   97: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   100: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   103: invokestatic 77	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   106: iload_1
      //   107: tableswitch	default:+222 -> 329, 0:+117->224
      //   125: aconst_null
      //   126: fconst_0
      //   127: lstore_2
      //   128: aload_0
      //   129: getfield 32	c/t/m/g/dd$a:c	Lc/t/m/g/df;
      //   132: invokevirtual 158	c/t/m/g/df:b	()Landroid/content/SharedPreferences;
      //   135: astore 5
      //   137: aload 5
      //   139: ifnull +34 -> 173
      //   142: aload 5
      //   144: invokeinterface 185 1 0
      //   149: astore 5
      //   151: aload 5
      //   153: ldc_w 259
      //   156: lload_2
      //   157: invokestatic 229	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   160: invokeinterface 209 3 0
      //   165: pop
      //   166: aload 5
      //   168: invokeinterface 232 1 0
      //   173: ldc2_w 302
      //   176: invokestatic 307	java/lang/Thread:sleep	(J)V
      //   179: ldc 55
      //   181: ldc_w 309
      //   184: invokestatic 77	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   187: aload_0
      //   188: getfield 30	c/t/m/g/dd$a:b	Lc/t/m/g/de;
      //   191: invokevirtual 311	c/t/m/g/de:b	()V
      //   194: iload 4
      //   196: ifeq +10 -> 206
      //   199: aload_0
      //   200: getfield 32	c/t/m/g/dd$a:c	Lc/t/m/g/df;
      //   203: invokevirtual 313	c/t/m/g/df:d	()V
      //   206: aload_0
      //   207: getfield 20	c/t/m/g/dd$a:e	Lc/t/m/g/dd;
      //   210: invokestatic 278	c/t/m/g/dd:a	(Lc/t/m/g/dd;)Z
      //   213: ifeq +10 -> 223
      //   216: aload_0
      //   217: getfield 20	c/t/m/g/dd$a:e	Lc/t/m/g/dd;
      //   220: invokestatic 315	c/t/m/g/dd:b	(Lc/t/m/g/dd;)V
      //   223: return
      //   224: aload 5
      //   226: ldc 163
      //   228: invokevirtual 319	org/json/JSONObject:has	(Ljava/lang/String;)Z
      //   231: ifeq -107 -> 124
      //   234: aload_0
      //   235: aload 5
      //   237: invokespecial 321	c/t/m/g/dd$a:a	(Lorg/json/JSONObject;)V
      //   240: goto -116 -> 124
      //   243: astore 5
      //   245: ldc 55
      //   247: aload 5
      //   249: invokevirtual 149	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   252: aload 5
      //   254: invokestatic 152	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   257: aload_0
      //   258: getfield 30	c/t/m/g/dd$a:b	Lc/t/m/g/de;
      //   261: invokevirtual 311	c/t/m/g/de:b	()V
      //   264: iload 4
      //   266: ifeq -60 -> 206
      //   269: aload_0
      //   270: getfield 32	c/t/m/g/dd$a:c	Lc/t/m/g/df;
      //   273: invokevirtual 313	c/t/m/g/df:d	()V
      //   276: goto -70 -> 206
      //   279: astore 5
      //   281: ldc 55
      //   283: aload 5
      //   285: invokevirtual 149	java/lang/Throwable:getMessage	()Ljava/lang/String;
      //   288: aload 5
      //   290: invokestatic 152	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   293: return
      //   294: astore 5
      //   296: aload_0
      //   297: getfield 30	c/t/m/g/dd$a:b	Lc/t/m/g/de;
      //   300: invokevirtual 311	c/t/m/g/de:b	()V
      //   303: iload 4
      //   305: ifeq +10 -> 315
      //   308: aload_0
      //   309: getfield 32	c/t/m/g/dd$a:c	Lc/t/m/g/df;
      //   312: invokevirtual 313	c/t/m/g/df:d	()V
      //   315: aload 5
      //   317: athrow
      //   318: ldc 55
      //   320: ldc_w 323
      //   323: invokestatic 77	c/t/m/g/da:a	(Ljava/lang/String;Ljava/lang/String;)V
      //   326: goto -120 -> 206
      //   329: goto -205 -> 124
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	332	0	this	a
      //   83	24	1	i	int
      //   10	147	2	l	long
      //   33	271	4	bool	boolean
      //   58	178	5	localObject1	Object
      //   243	10	5	localThrowable1	Throwable
      //   279	10	5	localThrowable2	Throwable
      //   294	22	5	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   40	47	243	java/lang/Throwable
      //   47	106	243	java/lang/Throwable
      //   124	137	243	java/lang/Throwable
      //   142	173	243	java/lang/Throwable
      //   173	187	243	java/lang/Throwable
      //   224	240	243	java/lang/Throwable
      //   0	35	279	java/lang/Throwable
      //   187	194	279	java/lang/Throwable
      //   199	206	279	java/lang/Throwable
      //   206	223	279	java/lang/Throwable
      //   257	264	279	java/lang/Throwable
      //   269	276	279	java/lang/Throwable
      //   296	303	279	java/lang/Throwable
      //   308	315	279	java/lang/Throwable
      //   315	318	279	java/lang/Throwable
      //   318	326	279	java/lang/Throwable
      //   40	47	294	finally
      //   47	106	294	finally
      //   124	137	294	finally
      //   142	173	294	finally
      //   173	187	294	finally
      //   224	240	294	finally
      //   245	257	294	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     c.t.m.g.dd
 * JD-Core Version:    0.7.0.1
 */