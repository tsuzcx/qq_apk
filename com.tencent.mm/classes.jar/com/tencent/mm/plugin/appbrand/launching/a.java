package com.tencent.mm.plugin.appbrand.launching;

import android.content.Context;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.appcache.k.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public abstract class a
  implements f
{
  /* Error */
  public final boolean a(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    // Byte code:
    //   0: getstatic 21	com/tencent/mm/plugin/appbrand/launching/v:sZx	Lcom/tencent/mm/plugin/appbrand/launching/v;
    //   3: astore 4
    //   5: invokestatic 25	com/tencent/mm/plugin/appbrand/launching/v:cAb	()Z
    //   8: istore_3
    //   9: ldc 27
    //   11: ldc 29
    //   13: iconst_4
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_2
    //   24: getfield 35	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:username	Ljava/lang/String;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: aload_2
    //   31: getfield 38	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:appId	Ljava/lang/String;
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: iload_3
    //   38: invokestatic 44	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   41: aastore
    //   42: invokestatic 50	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: aload_2
    //   46: getfield 35	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:username	Ljava/lang/String;
    //   49: invokestatic 56	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   52: ifeq +15 -> 67
    //   55: aload_2
    //   56: getfield 38	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:appId	Ljava/lang/String;
    //   59: invokestatic 56	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   62: ifeq +5 -> 67
    //   65: iconst_0
    //   66: ireturn
    //   67: iload_3
    //   68: ifeq +8 -> 76
    //   71: aload_2
    //   72: iconst_2
    //   73: putfield 60	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:euz	I
    //   76: aload_2
    //   77: getstatic 66	com/tencent/luggage/sdk/launching/e:etI	Lcom/tencent/luggage/sdk/launching/e;
    //   80: putfield 69	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:epm	Lcom/tencent/luggage/sdk/launching/e;
    //   83: aload_2
    //   84: invokestatic 73	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   87: putfield 77	com/tencent/mm/plugin/appbrand/launching/params/LaunchParcel:tdX	J
    //   90: aload_1
    //   91: ifnull +20 -> 111
    //   94: aload_1
    //   95: instanceof 79
    //   98: ifeq +26 -> 124
    //   101: aload_1
    //   102: checkcast 79	android/app/Activity
    //   105: invokevirtual 82	android/app/Activity:isFinishing	()Z
    //   108: ifeq +16 -> 124
    //   111: invokestatic 88	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   114: astore 5
    //   116: aload_0
    //   117: aload 5
    //   119: aload_2
    //   120: invokevirtual 91	com/tencent/mm/plugin/appbrand/launching/a:b	(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z
    //   123: ireturn
    //   124: aload_1
    //   125: astore 5
    //   127: aload_1
    //   128: instanceof 79
    //   131: ifeq -15 -> 116
    //   134: aconst_null
    //   135: astore 5
    //   137: aconst_null
    //   138: astore 4
    //   140: aload_1
    //   141: iconst_1
    //   142: newarray int
    //   144: dup
    //   145: iconst_0
    //   146: ldc 92
    //   148: iastore
    //   149: invokevirtual 98	android/content/Context:obtainStyledAttributes	([I)Landroid/content/res/TypedArray;
    //   152: astore 6
    //   154: aload 6
    //   156: astore 4
    //   158: aload 6
    //   160: astore 5
    //   162: aload 6
    //   164: iconst_0
    //   165: iconst_0
    //   166: invokevirtual 104	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   169: ifne +48 -> 217
    //   172: aload 6
    //   174: astore 4
    //   176: aload 6
    //   178: astore 5
    //   180: aload_1
    //   181: checkcast 79	android/app/Activity
    //   184: astore 7
    //   186: ldc 79
    //   188: ldc 106
    //   190: iconst_0
    //   191: anewarray 108	java/lang/Class
    //   194: invokevirtual 112	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   197: astore 4
    //   199: aload 4
    //   201: iconst_1
    //   202: invokevirtual 118	java/lang/reflect/Method:setAccessible	(Z)V
    //   205: aload 4
    //   207: aload 7
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokevirtual 122	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   216: pop
    //   217: aload_1
    //   218: astore 5
    //   220: aload 6
    //   222: ifnull -106 -> 116
    //   225: aload 6
    //   227: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   230: aload_1
    //   231: astore 5
    //   233: goto -117 -> 116
    //   236: astore 7
    //   238: aload 6
    //   240: astore 4
    //   242: aload 6
    //   244: astore 5
    //   246: ldc 27
    //   248: aload 7
    //   250: ldc 127
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload 7
    //   260: invokevirtual 133	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: goto -50 -> 217
    //   270: astore 6
    //   272: aload 4
    //   274: astore 5
    //   276: ldc 27
    //   278: aload 6
    //   280: ldc 139
    //   282: iconst_1
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: aload_1
    //   289: invokevirtual 143	java/lang/Object:getClass	()Ljava/lang/Class;
    //   292: invokevirtual 146	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   295: aastore
    //   296: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   299: aload_1
    //   300: astore 5
    //   302: aload 4
    //   304: ifnull -188 -> 116
    //   307: aload 4
    //   309: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   312: aload_1
    //   313: astore 5
    //   315: goto -199 -> 116
    //   318: astore_1
    //   319: aload 5
    //   321: ifnull +8 -> 329
    //   324: aload 5
    //   326: invokevirtual 125	android/content/res/TypedArray:recycle	()V
    //   329: aload_1
    //   330: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	a
    //   0	331	1	paramContext	Context
    //   0	331	2	paramLaunchParcel	LaunchParcel
    //   8	60	3	bool	boolean
    //   3	305	4	localObject1	Object
    //   114	211	5	localObject2	Object
    //   152	91	6	localTypedArray	android.content.res.TypedArray
    //   270	9	6	localException	java.lang.Exception
    //   184	24	7	localActivity	android.app.Activity
    //   236	23	7	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   186	217	236	finally
    //   140	154	270	java/lang/Exception
    //   162	172	270	java/lang/Exception
    //   180	186	270	java/lang/Exception
    //   246	267	270	java/lang/Exception
    //   140	154	318	finally
    //   162	172	318	finally
    //   180	186	318	finally
    //   246	267	318	finally
    //   276	299	318	finally
  }
  
  public final boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional)
  {
    return a(paramContext, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramAppBrandStatObject, paramAppBrandLaunchReferrer, paramLaunchParamsOptional, "");
  }
  
  public final boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, AppBrandStatObject paramAppBrandStatObject, AppBrandLaunchReferrer paramAppBrandLaunchReferrer, LaunchParamsOptional paramLaunchParamsOptional, String paramString4)
  {
    LaunchParcel localLaunchParcel = new LaunchParcel();
    localLaunchParcel.username = paramString1;
    localLaunchParcel.appId = paramString2;
    if (paramString3 == null)
    {
      paramString1 = null;
      localLaunchParcel.qAF = paramString1;
      if (!k.a.uB(paramInt1)) {
        break label120;
      }
    }
    for (localLaunchParcel.euz = paramInt1;; localLaunchParcel.euz = 0)
    {
      localLaunchParcel.version = paramInt2;
      localLaunchParcel.siB = paramAppBrandStatObject;
      localLaunchParcel.eoV = paramAppBrandLaunchReferrer;
      localLaunchParcel.tdW = paramLaunchParamsOptional;
      if ((paramLaunchParamsOptional != null) && (paramLaunchParamsOptional.opX != 0)) {
        localLaunchParcel.launchMode = 1;
      }
      localLaunchParcel.icX = paramString4;
      return a(paramContext, localLaunchParcel);
      paramString1 = paramString3.trim();
      break;
      label120:
      com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrand.Precondition.AbstractLaunchEntry", "start with invalid versionType[%d], use 0 instead, stack=%s", new Object[] { Integer.valueOf(paramInt1), android.util.Log.getStackTraceString(new Throwable()) });
    }
  }
  
  protected abstract boolean b(Context paramContext, LaunchParcel paramLaunchParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.a
 * JD-Core Version:    0.7.0.1
 */