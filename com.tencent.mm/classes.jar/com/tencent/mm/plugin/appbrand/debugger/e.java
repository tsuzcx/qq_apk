package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.be.c;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.launching.t;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.plugin.appbrand.utils.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public final class e
  implements be.c, DebuggerShell.a
{
  private static void a(String paramString1, final String paramString2, final String paramString3, final Runnable paramRunnable)
  {
    AppMethodBeat.i(226511);
    com.tencent.f.h.RTc.aX(new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: ldc 34
        //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: new 42	java/lang/StringBuilder
        //   8: dup
        //   9: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   12: invokestatic 49	com/tencent/mm/loader/j/b:aKP	()Ljava/lang/String;
        //   15: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   18: aload_0
        //   19: getfield 20	com/tencent/mm/plugin/appbrand/debugger/e$4:val$appId	Ljava/lang/String;
        //   22: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   25: ldc 55
        //   27: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   30: aload_0
        //   31: getfield 22	com/tencent/mm/plugin/appbrand/debugger/e$4:val$name	Ljava/lang/String;
        //   34: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   37: ldc 55
        //   39: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   42: invokestatic 61	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
        //   45: invokevirtual 64	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   48: ldc 66
        //   50: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   53: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   56: astore 6
        //   58: aload_0
        //   59: getfield 24	com/tencent/mm/plugin/appbrand/debugger/e$4:val$url	Ljava/lang/String;
        //   62: aconst_null
        //   63: invokestatic 74	com/tencent/mm/network/d:a	(Ljava/lang/String;Lcom/tencent/mm/network/d$b;)Lcom/tencent/mm/network/x;
        //   66: astore_1
        //   67: aload_1
        //   68: sipush 10000
        //   71: invokeinterface 79 2 0
        //   76: aload_1
        //   77: sipush 20000
        //   80: invokeinterface 82 2 0
        //   85: aload_1
        //   86: ldc 84
        //   88: invokeinterface 88 2 0
        //   93: aload_1
        //   94: invokeinterface 92 1 0
        //   99: pop
        //   100: aload_1
        //   101: invokeinterface 96 1 0
        //   106: astore_1
        //   107: aload_1
        //   108: ifnull +314 -> 422
        //   111: aload 6
        //   113: iconst_0
        //   114: invokestatic 102	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
        //   117: astore_3
        //   118: aload_3
        //   119: astore_2
        //   120: aload_1
        //   121: astore 4
        //   123: aload_3
        //   124: astore 5
        //   126: aload_1
        //   127: aload_3
        //   128: invokestatic 108	org/apache/commons/a/e:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
        //   131: pop
        //   132: aload_3
        //   133: astore_2
        //   134: aload_1
        //   135: astore 4
        //   137: aload_3
        //   138: astore 5
        //   140: aload_3
        //   141: invokevirtual 113	java/io/OutputStream:flush	()V
        //   144: aload_3
        //   145: astore_2
        //   146: aload_1
        //   147: astore 4
        //   149: aload_3
        //   150: astore 5
        //   152: aload_0
        //   153: getfield 20	com/tencent/mm/plugin/appbrand/debugger/e$4:val$appId	Ljava/lang/String;
        //   156: astore 7
        //   158: aload_3
        //   159: astore_2
        //   160: aload_1
        //   161: astore 4
        //   163: aload_3
        //   164: astore 5
        //   166: aload_0
        //   167: getfield 22	com/tencent/mm/plugin/appbrand/debugger/e$4:val$name	Ljava/lang/String;
        //   170: astore 8
        //   172: aload_3
        //   173: astore_2
        //   174: aload_1
        //   175: astore 4
        //   177: aload_3
        //   178: astore 5
        //   180: ldc 115
        //   182: ldc 117
        //   184: iconst_4
        //   185: anewarray 4	java/lang/Object
        //   188: dup
        //   189: iconst_0
        //   190: aload 7
        //   192: aastore
        //   193: dup
        //   194: iconst_1
        //   195: aload 8
        //   197: aastore
        //   198: dup
        //   199: iconst_2
        //   200: aload 6
        //   202: aastore
        //   203: dup
        //   204: iconst_3
        //   205: new 119	com/tencent/mm/vfs/o
        //   208: dup
        //   209: aload 6
        //   211: invokespecial 121	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
        //   214: invokestatic 127	com/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo:n	(Lcom/tencent/mm/vfs/o;)Ljava/lang/String;
        //   217: aastore
        //   218: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   221: aload_3
        //   222: astore_2
        //   223: aload_1
        //   224: astore 4
        //   226: aload_3
        //   227: astore 5
        //   229: ldc 134
        //   231: iconst_2
        //   232: invokestatic 140	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;I)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
        //   235: new 42	java/lang/StringBuilder
        //   238: dup
        //   239: invokespecial 43	java/lang/StringBuilder:<init>	()V
        //   242: aload 7
        //   244: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: ldc 55
        //   249: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   252: aload 8
        //   254: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   257: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   260: aload 6
        //   262: invokevirtual 144	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:putString	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
        //   265: invokeinterface 150 1 0
        //   270: pop
        //   271: aload_1
        //   272: invokestatic 154	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
        //   275: aload_3
        //   276: invokestatic 158	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
        //   279: aload_0
        //   280: getfield 26	com/tencent/mm/plugin/appbrand/debugger/e$4:kDM	Ljava/lang/Runnable;
        //   283: invokeinterface 160 1 0
        //   288: ldc 34
        //   290: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   293: return
        //   294: astore 6
        //   296: aconst_null
        //   297: astore_3
        //   298: aconst_null
        //   299: astore_1
        //   300: aload_3
        //   301: astore_2
        //   302: aload_1
        //   303: astore 4
        //   305: ldc 115
        //   307: ldc 165
        //   309: iconst_4
        //   310: anewarray 4	java/lang/Object
        //   313: dup
        //   314: iconst_0
        //   315: aload_0
        //   316: getfield 20	com/tencent/mm/plugin/appbrand/debugger/e$4:val$appId	Ljava/lang/String;
        //   319: aastore
        //   320: dup
        //   321: iconst_1
        //   322: aload_0
        //   323: getfield 22	com/tencent/mm/plugin/appbrand/debugger/e$4:val$name	Ljava/lang/String;
        //   326: aastore
        //   327: dup
        //   328: iconst_2
        //   329: aload_0
        //   330: getfield 24	com/tencent/mm/plugin/appbrand/debugger/e$4:val$url	Ljava/lang/String;
        //   333: aastore
        //   334: dup
        //   335: iconst_3
        //   336: aload 6
        //   338: aastore
        //   339: invokestatic 167	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   342: aload_1
        //   343: invokestatic 154	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
        //   346: aload_3
        //   347: invokestatic 158	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
        //   350: aload_0
        //   351: getfield 26	com/tencent/mm/plugin/appbrand/debugger/e$4:kDM	Ljava/lang/Runnable;
        //   354: invokeinterface 160 1 0
        //   359: ldc 34
        //   361: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   364: return
        //   365: astore_3
        //   366: aconst_null
        //   367: astore_2
        //   368: aconst_null
        //   369: astore_1
        //   370: aload_1
        //   371: invokestatic 154	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
        //   374: aload_2
        //   375: invokestatic 158	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
        //   378: aload_0
        //   379: getfield 26	com/tencent/mm/plugin/appbrand/debugger/e$4:kDM	Ljava/lang/Runnable;
        //   382: invokeinterface 160 1 0
        //   387: ldc 34
        //   389: invokestatic 163	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   392: aload_3
        //   393: athrow
        //   394: astore_3
        //   395: aconst_null
        //   396: astore_2
        //   397: goto -27 -> 370
        //   400: astore_3
        //   401: aload 4
        //   403: astore_1
        //   404: goto -34 -> 370
        //   407: astore 6
        //   409: aconst_null
        //   410: astore_3
        //   411: goto -111 -> 300
        //   414: astore 6
        //   416: aload 5
        //   418: astore_3
        //   419: goto -119 -> 300
        //   422: aconst_null
        //   423: astore_3
        //   424: goto -280 -> 144
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	427	0	this	4
        //   66	338	1	localObject1	Object
        //   119	278	2	localOutputStream1	java.io.OutputStream
        //   117	230	3	localOutputStream2	java.io.OutputStream
        //   365	28	3	localObject2	Object
        //   394	1	3	localObject3	Object
        //   400	1	3	localObject4	Object
        //   410	14	3	localObject5	Object
        //   121	281	4	localObject6	Object
        //   124	293	5	localOutputStream3	java.io.OutputStream
        //   56	205	6	str1	String
        //   294	43	6	localException1	java.lang.Exception
        //   407	1	6	localException2	java.lang.Exception
        //   414	1	6	localException3	java.lang.Exception
        //   156	87	7	str2	String
        //   170	83	8	str3	String
        // Exception table:
        //   from	to	target	type
        //   58	107	294	java/lang/Exception
        //   58	107	365	finally
        //   111	118	394	finally
        //   126	132	400	finally
        //   140	144	400	finally
        //   152	158	400	finally
        //   166	172	400	finally
        //   180	221	400	finally
        //   229	271	400	finally
        //   305	342	400	finally
        //   111	118	407	java/lang/Exception
        //   126	132	414	java/lang/Exception
        //   140	144	414	java/lang/Exception
        //   152	158	414	java/lang/Exception
        //   166	172	414	java/lang/Exception
        //   180	221	414	java/lang/Exception
        //   229	271	414	java/lang/Exception
      }
    });
    AppMethodBeat.o(226511);
  }
  
  public static String cU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226512);
    paramString1 = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.ForceOpenAppNotify.TestInjectJsPath", 2).getString(paramString1 + "-" + paramString2, null);
    AppMethodBeat.o(226512);
    return paramString1;
  }
  
  public final void A(Intent paramIntent)
  {
    AppMethodBeat.i(44949);
    String str = paramIntent.getStringExtra("appId");
    int i = paramIntent.getIntExtra("versionType", 0);
    paramIntent = new AppBrandStatObject();
    paramIntent.scene = 1030;
    ((r)com.tencent.mm.kernel.g.af(r.class)).a(null, null, str, i, 0, null, paramIntent);
    AppMethodBeat.o(44949);
  }
  
  public final void l(final String paramString, Map<String, String> paramMap)
  {
    AppMethodBeat.i(226510);
    if (DebuggerShell.bAx())
    {
      Log.i("MicroMsg.AppBrand.ForceOpenAppNotify", "handleMessage %s", new Object[] { paramString });
      paramString = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
      Object localObject = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
      final int i = Util.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
      final int j = Util.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
      final String str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
      final String str2 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
      final String str3 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
      final String str4 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
      paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutPluginCodeUrls");
      if (i < 0)
      {
        AppMethodBeat.o(226510);
        return;
      }
      int k;
      if (!TextUtils.isEmpty(paramString))
      {
        k = Util.getInt((String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.setEnableDebug"), -1);
        if (k != 1) {
          break label215;
        }
        m.an(paramString, true);
      }
      while (i != 0) {
        if (n.buL() == null)
        {
          AppMethodBeat.o(226510);
          return;
          label215:
          if ((k == 0) && (!m.Xd(paramString))) {
            m.an(paramString, false);
          }
        }
        else
        {
          if ((!Util.isNullOrNil(str2)) && (!Util.isNullOrNil(str3))) {
            break label389;
          }
          if (i == 1)
          {
            AppMethodBeat.o(226510);
            return;
          }
          if (i != 2) {
            break;
          }
        }
      }
      Log.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp username[%s], appId[%s], versionType[%d]", new Object[] { localObject, paramString, Integer.valueOf(i) });
      localObject = new k(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(44947);
          if ((j.a.sE(i)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3))) {
            n.buL().a(paramString, i, str2, str3, 0L, 0L);
          }
          if ((j.a.sE(i)) && (!TextUtils.isEmpty(str4))) {
            ((t)n.W(t.class)).A(paramString, i, str4);
          }
          this.lhK.appId = paramString;
          this.lhK.username = this.gtu;
          this.lhK.iOo = i;
          this.lhK.kHw = str1;
          this.lhK.version = j;
          this.lhK.scene = 1030;
          ((r)com.tencent.mm.kernel.g.af(r.class)).a(MMApplicationContext.getContext(), this.lhK);
          AppMethodBeat.o(44947);
        }
      }, 2);
      str1 = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needjs");
      if (TextUtils.isEmpty(str1)) {
        ((k)localObject).countDown();
      }
      for (;;)
      {
        paramMap = (String)paramMap.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Needwebviewjs");
        if (!TextUtils.isEmpty(paramMap)) {
          break label448;
        }
        ((k)localObject).countDown();
        AppMethodBeat.o(226510);
        return;
        label389:
        if (!n.buL().a(paramString, i, str2, str3, Util.nowSecond(), Util.nowSecond() + 432000L)) {
          break;
        }
        com.tencent.mm.plugin.appbrand.task.h.bWb().cl(paramString, i);
        break;
        a(paramString, "Needjs", str1, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(226507);
            this.kMe.countDown();
            AppMethodBeat.o(226507);
          }
        });
      }
      label448:
      a(paramString, "Needwebviewjs", paramMap, new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(226508);
          this.kMe.countDown();
          AppMethodBeat.o(226508);
        }
      });
    }
    AppMethodBeat.o(226510);
  }
  
  public final String name()
  {
    return "ForceOpenAppNotify";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.e
 * JD-Core Version:    0.7.0.1
 */