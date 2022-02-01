package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.config.p.a;
import com.tencent.mm.plugin.appbrand.service.m;
import com.tencent.mm.protocal.protobuf.cxb;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class u
  extends k
{
  public static final String[] gLs;
  private static final b<duj> iVi;
  private static final b<LocalUsageInfo> iVj;
  final h iVg;
  private final u.c iVh;
  
  static
  {
    AppMethodBeat.i(44590);
    gLs = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(u.a.gLr, "AppBrandStarApp") };
    iVi = new b() {};
    iVj = new b() {};
    AppMethodBeat.o(44590);
  }
  
  public u(h paramh)
  {
    AppMethodBeat.i(44577);
    this.iVg = paramh;
    this.iVh = new u.c(paramh);
    AppMethodBeat.o(44577);
  }
  
  /* Error */
  private long aRY()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 79
    //   5: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 85	java/util/Locale:US	Ljava/util/Locale;
    //   11: ldc 87
    //   13: iconst_3
    //   14: anewarray 89	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc 91
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: ldc 43
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc 91
    //   31: aastore
    //   32: invokestatic 95	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 68	com/tencent/mm/plugin/appbrand/appusage/u:iVg	Lcom/tencent/mm/storagebase/h;
    //   41: aload 4
    //   43: aconst_null
    //   44: iconst_2
    //   45: invokevirtual 101	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   48: astore 6
    //   50: aload 6
    //   52: ifnull +15 -> 67
    //   55: aload 6
    //   57: invokeinterface 107 1 0
    //   62: istore_1
    //   63: iload_1
    //   64: ifeq +22 -> 86
    //   67: aload 6
    //   69: ifnull +10 -> 79
    //   72: aload 6
    //   74: invokeinterface 110 1 0
    //   79: ldc 79
    //   81: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: lconst_0
    //   85: lreturn
    //   86: aload 6
    //   88: invokeinterface 113 1 0
    //   93: ifeq +31 -> 124
    //   96: aload 6
    //   98: iconst_0
    //   99: invokeinterface 117 2 0
    //   104: lstore_2
    //   105: aload 6
    //   107: ifnull +10 -> 117
    //   110: aload 6
    //   112: invokeinterface 110 1 0
    //   117: ldc 79
    //   119: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: lload_2
    //   123: lreturn
    //   124: aload 6
    //   126: ifnull +10 -> 136
    //   129: aload 6
    //   131: invokeinterface 110 1 0
    //   136: ldc 79
    //   138: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: lconst_0
    //   142: lreturn
    //   143: astore 5
    //   145: ldc 79
    //   147: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 5
    //   152: athrow
    //   153: astore 4
    //   155: aload 6
    //   157: ifnull +15 -> 172
    //   160: aload 5
    //   162: ifnull +39 -> 201
    //   165: aload 6
    //   167: invokeinterface 110 1 0
    //   172: ldc 79
    //   174: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload 4
    //   179: athrow
    //   180: astore 4
    //   182: ldc 79
    //   184: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: lconst_0
    //   188: lreturn
    //   189: astore 6
    //   191: aload 5
    //   193: aload 6
    //   195: invokevirtual 121	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   198: goto -26 -> 172
    //   201: aload 6
    //   203: invokeinterface 110 1 0
    //   208: goto -36 -> 172
    //   211: astore 4
    //   213: goto -58 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	u
    //   62	2	1	bool	boolean
    //   104	19	2	l	long
    //   35	7	4	str	String
    //   153	25	4	localObject1	Object
    //   180	1	4	localException	java.lang.Exception
    //   211	1	4	localObject2	Object
    //   1	1	5	localObject3	Object
    //   143	49	5	localThrowable1	java.lang.Throwable
    //   48	118	6	localCursor	Cursor
    //   189	13	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   55	63	143	java/lang/Throwable
    //   86	105	143	java/lang/Throwable
    //   145	153	153	finally
    //   37	50	180	java/lang/Exception
    //   72	79	180	java/lang/Exception
    //   110	117	180	java/lang/Exception
    //   129	136	180	java/lang/Exception
    //   165	172	180	java/lang/Exception
    //   172	180	180	java/lang/Exception
    //   191	198	180	java/lang/Exception
    //   201	208	180	java/lang/Exception
    //   165	172	189	java/lang/Throwable
    //   55	63	211	finally
    //   86	105	211	finally
  }
  
  private ArrayList<AppBrandRecentTaskInfo> qM(int paramInt)
  {
    AppMethodBeat.i(44583);
    Object localObject1 = "select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
    Object localObject2 = this.iVg.a((String)localObject1, null, 0);
    if (localObject2 == null)
    {
      AppMethodBeat.o(44583);
      return null;
    }
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(44583);
      return null;
    }
    localObject1 = new LinkedList();
    do
    {
      String str = ((Cursor)localObject2).getString(0);
      if (!bt.isNullOrNil(str))
      {
        paramInt = ((Cursor)localObject2).getInt(1);
        long l = ((Cursor)localObject2).getLong(2);
        ((LinkedList)localObject1).add(com.tencent.mm.plugin.appbrand.config.u.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { str, Integer.valueOf(paramInt) }), str, paramInt, l));
      }
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject2 = new ArrayList(((LinkedList)localObject1).size());
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    AppMethodBeat.o(44583);
    return localObject2;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> a(ah.a parama)
  {
    AppMethodBeat.i(44580);
    parama = b(-1, parama);
    AppMethodBeat.o(44580);
    return parama;
  }
  
  final <T> void a(Class<T> paramClass, List<T> paramList, Long paramLong)
  {
    AppMethodBeat.i(44585);
    long l;
    if (paramClass == duj.class)
    {
      paramClass = iVi;
      l = this.iVg.rb(Thread.currentThread().getId());
      this.iVg.delete("AppBrandStarApp", "", null);
      if (bt.gL(paramList)) {
        break label216;
      }
      if (paramList == null) {
        break label211;
      }
    }
    label211:
    for (paramList = d.a.j.j((Iterable)paramList);; paramList = null)
    {
      u.a locala = new u.a();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (!bt.isNullOrNil(paramClass.cn(localObject)))
        {
          locala.field_username = paramClass.cn(localObject);
          locala.field_versionType = paramClass.cm(localObject);
          locala.field_updateTime = paramClass.cl(localObject);
          i += 1;
          locala.field_orderSequence = (i * (v.aSb() * 2));
          this.iVg.a("AppBrandStarApp", null, locala.convertTo());
        }
      }
      if (paramClass == LocalUsageInfo.class)
      {
        paramClass = iVj;
        break;
      }
      AppMethodBeat.o(44585);
      return;
    }
    label216:
    this.iVg.mX(l);
    doNotify("batch", 3, paramLong);
    AppMethodBeat.o(44585);
  }
  
  public final int aRX()
  {
    int i = 0;
    AppMethodBeat.i(44579);
    Cursor localCursor = this.iVg.a("select count(*) from AppBrandStarApp", null, 0);
    if ((localCursor == null) || (localCursor.isClosed()))
    {
      AppMethodBeat.o(44579);
      return 0;
    }
    if (localCursor.moveToFirst()) {
      i = localCursor.getInt(0);
    }
    localCursor.close();
    AppMethodBeat.o(44579);
    return i;
  }
  
  public final boolean aV(String paramString, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(44584);
    if (bt.isNullOrNil(paramString)) {}
    for (paramString = localObject; paramString == null; paramString = this.iVg.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "username", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, null))
    {
      AppMethodBeat.o(44584);
      return false;
    }
    boolean bool = paramString.moveToFirst();
    paramString.close();
    AppMethodBeat.o(44584);
    return bool;
  }
  
  /* Error */
  public final int aW(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 336
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 163	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 336
    //   16: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_m1
    //   20: ireturn
    //   21: iload_2
    //   22: invokestatic 342	com/tencent/mm/plugin/appbrand/appcache/j$a:qD	(I)Z
    //   25: ifeq +125 -> 150
    //   28: invokestatic 348	com/tencent/mm/plugin/appbrand/app/j:aOC	()Lcom/tencent/mm/plugin/appbrand/config/v;
    //   31: aload_1
    //   32: iconst_1
    //   33: anewarray 37	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 350
    //   41: aastore
    //   42: invokevirtual 356	com/tencent/mm/plugin/appbrand/config/v:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   45: astore 11
    //   47: aload 11
    //   49: ifnull +14 -> 63
    //   52: aload 11
    //   54: getfield 361	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appInfo	Ljava/lang/String;
    //   57: invokestatic 367	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +18 -> 78
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq +84 -> 150
    //   69: ldc_w 336
    //   72: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: bipush 253
    //   77: ireturn
    //   78: aload 11
    //   80: invokevirtual 371	com/tencent/mm/plugin/appbrand/config/WxaAttributes:aTN	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   83: getfield 376	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:iVR	J
    //   86: lstore 4
    //   88: getstatic 382	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   91: invokestatic 387	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 390	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   97: lstore 6
    //   99: ldc_w 392
    //   102: ldc_w 394
    //   105: iconst_3
    //   106: anewarray 89	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: lload 4
    //   117: invokestatic 399	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: lload 6
    //   125: invokestatic 399	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: aastore
    //   129: invokestatic 404	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: lload 6
    //   134: lload 4
    //   136: lcmp
    //   137: ifge +8 -> 145
    //   140: iconst_1
    //   141: istore_3
    //   142: goto -77 -> 65
    //   145: iconst_0
    //   146: istore_3
    //   147: goto -82 -> 65
    //   150: iconst_0
    //   151: istore_3
    //   152: invokestatic 407	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   155: lstore 4
    //   157: aload_0
    //   158: invokespecial 409	com/tencent/mm/plugin/appbrand/appusage/u:aRY	()J
    //   161: lstore 6
    //   163: invokestatic 287	com/tencent/mm/plugin/appbrand/appusage/v:aSb	()I
    //   166: iconst_2
    //   167: imul
    //   168: i2l
    //   169: lstore 8
    //   171: aload_0
    //   172: aload_1
    //   173: iload_2
    //   174: invokevirtual 411	com/tencent/mm/plugin/appbrand/appusage/u:aV	(Ljava/lang/String;I)Z
    //   177: ifne +340 -> 517
    //   180: aload_0
    //   181: invokevirtual 413	com/tencent/mm/plugin/appbrand/appusage/u:aRX	()I
    //   184: invokestatic 287	com/tencent/mm/plugin/appbrand/appusage/v:aSb	()I
    //   187: if_icmplt +12 -> 199
    //   190: ldc_w 336
    //   193: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: bipush 254
    //   198: ireturn
    //   199: new 10	com/tencent/mm/plugin/appbrand/appusage/u$a
    //   202: dup
    //   203: invokespecial 243	com/tencent/mm/plugin/appbrand/appusage/u$a:<init>	()V
    //   206: astore 11
    //   208: aload 11
    //   210: aload_1
    //   211: putfield 266	com/tencent/mm/plugin/appbrand/appusage/u$a:field_username	Ljava/lang/String;
    //   214: aload 11
    //   216: iload_2
    //   217: putfield 274	com/tencent/mm/plugin/appbrand/appusage/u$a:field_versionType	I
    //   220: aload 11
    //   222: lload 4
    //   224: putfield 282	com/tencent/mm/plugin/appbrand/appusage/u$a:field_updateTime	J
    //   227: aload 11
    //   229: lload 6
    //   231: lload 8
    //   233: lsub
    //   234: putfield 290	com/tencent/mm/plugin/appbrand/appusage/u$a:field_orderSequence	J
    //   237: aload_0
    //   238: getfield 72	com/tencent/mm/plugin/appbrand/appusage/u:iVh	Lcom/tencent/mm/plugin/appbrand/appusage/u$c;
    //   241: aload 11
    //   243: iconst_0
    //   244: invokevirtual 417	com/tencent/mm/plugin/appbrand/appusage/u$c:insertNotify	(Lcom/tencent/mm/sdk/e/c;Z)Z
    //   247: pop
    //   248: aload_0
    //   249: aload_1
    //   250: iload_2
    //   251: invokevirtual 411	com/tencent/mm/plugin/appbrand/appusage/u:aV	(Ljava/lang/String;I)Z
    //   254: ifeq +15 -> 269
    //   257: aload_0
    //   258: ldc_w 419
    //   261: iconst_2
    //   262: aload 11
    //   264: invokevirtual 309	com/tencent/mm/plugin/appbrand/appusage/u:doNotify	(Ljava/lang/String;ILjava/lang/Object;)V
    //   267: iconst_1
    //   268: istore_3
    //   269: iload_3
    //   270: ifeq +166 -> 436
    //   273: aconst_null
    //   274: astore 13
    //   276: aload_0
    //   277: getfield 68	com/tencent/mm/plugin/appbrand/appusage/u:iVg	Lcom/tencent/mm/storagebase/h;
    //   280: getstatic 422	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   283: ldc_w 424
    //   286: iconst_2
    //   287: anewarray 89	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: ldc 43
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: ldc 91
    //   299: aastore
    //   300: invokestatic 95	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   303: aconst_null
    //   304: iconst_0
    //   305: invokevirtual 101	com/tencent/mm/storagebase/h:a	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   308: astore 14
    //   310: aconst_null
    //   311: astore 12
    //   313: aload 13
    //   315: astore 11
    //   317: aload 14
    //   319: ifnull +62 -> 381
    //   322: aload 13
    //   324: astore 11
    //   326: aload 14
    //   328: invokeinterface 113 1 0
    //   333: ifeq +48 -> 381
    //   336: new 10	com/tencent/mm/plugin/appbrand/appusage/u$a
    //   339: dup
    //   340: invokespecial 243	com/tencent/mm/plugin/appbrand/appusage/u$a:<init>	()V
    //   343: astore 13
    //   345: aload 13
    //   347: aload 14
    //   349: invokevirtual 428	com/tencent/mm/plugin/appbrand/appusage/u$a:convertFrom	(Landroid/database/Cursor;)V
    //   352: new 430	com/tencent/mm/protocal/protobuf/cxb
    //   355: dup
    //   356: invokespecial 431	com/tencent/mm/protocal/protobuf/cxb:<init>	()V
    //   359: astore 11
    //   361: aload 11
    //   363: aload 13
    //   365: getfield 266	com/tencent/mm/plugin/appbrand/appusage/u$a:field_username	Ljava/lang/String;
    //   368: putfield 433	com/tencent/mm/protocal/protobuf/cxb:username	Ljava/lang/String;
    //   371: aload 11
    //   373: aload 13
    //   375: getfield 274	com/tencent/mm/plugin/appbrand/appusage/u$a:field_versionType	I
    //   378: putfield 436	com/tencent/mm/protocal/protobuf/cxb:CLK	I
    //   381: aload 14
    //   383: ifnull +226 -> 609
    //   386: aload 14
    //   388: invokeinterface 110 1 0
    //   393: new 430	com/tencent/mm/protocal/protobuf/cxb
    //   396: dup
    //   397: invokespecial 431	com/tencent/mm/protocal/protobuf/cxb:<init>	()V
    //   400: astore 12
    //   402: aload 12
    //   404: aload_1
    //   405: putfield 433	com/tencent/mm/protocal/protobuf/cxb:username	Ljava/lang/String;
    //   408: aload 12
    //   410: iload_2
    //   411: putfield 436	com/tencent/mm/protocal/protobuf/cxb:CLK	I
    //   414: ldc_w 438
    //   417: invokestatic 444	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   420: checkcast 438	com/tencent/mm/plugin/appbrand/appusage/c
    //   423: aload 12
    //   425: aload 11
    //   427: invokestatic 449	com/tencent/mm/plugin/appbrand/appusage/ab:a	(Lcom/tencent/mm/protocal/protobuf/cxb;Lcom/tencent/mm/protocal/protobuf/cxb;)Lcom/tencent/mm/protocal/protobuf/cxc;
    //   430: getstatic 455	com/tencent/mm/plugin/appbrand/appusage/ab$b:iVD	Lcom/tencent/mm/plugin/appbrand/appusage/ab$b;
    //   433: invokevirtual 458	com/tencent/mm/plugin/appbrand/appusage/c:a	(Lcom/tencent/mm/protocal/protobuf/cxc;Lcom/tencent/mm/plugin/appbrand/appusage/ab$b;)V
    //   436: ldc_w 460
    //   439: invokestatic 444	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   442: checkcast 460	com/tencent/mm/plugin/appbrand/service/m
    //   445: aload_1
    //   446: invokeinterface 464 2 0
    //   451: astore_1
    //   452: aload_1
    //   453: ifnull +159 -> 612
    //   456: aload_1
    //   457: getfield 467	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   460: invokestatic 163	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   463: ifne +149 -> 612
    //   466: invokestatic 471	com/tencent/mm/plugin/appbrand/app/j:Dh	()Lcom/tencent/mm/plugin/appbrand/config/d;
    //   469: aload_1
    //   470: getfield 467	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   473: invokestatic 477	com/tencent/mm/plugin/appbrand/config/p$a:FV	(Ljava/lang/String;)Ljava/lang/String;
    //   476: ldc_w 479
    //   479: invokevirtual 485	com/tencent/mm/plugin/appbrand/config/d:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   482: invokestatic 490	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   485: invokevirtual 493	java/lang/Boolean:booleanValue	()Z
    //   488: ifne +124 -> 612
    //   491: invokestatic 471	com/tencent/mm/plugin/appbrand/app/j:Dh	()Lcom/tencent/mm/plugin/appbrand/config/d;
    //   494: aload_1
    //   495: getfield 467	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   498: invokestatic 477	com/tencent/mm/plugin/appbrand/config/p$a:FV	(Ljava/lang/String;)Ljava/lang/String;
    //   501: invokevirtual 496	com/tencent/mm/plugin/appbrand/config/d:vv	(Ljava/lang/String;)Z
    //   504: pop
    //   505: iload_3
    //   506: ifeq +161 -> 667
    //   509: ldc_w 336
    //   512: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   515: iconst_0
    //   516: ireturn
    //   517: iconst_1
    //   518: istore_3
    //   519: goto -250 -> 269
    //   522: astore 12
    //   524: ldc_w 336
    //   527: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: aload 12
    //   532: athrow
    //   533: astore 11
    //   535: aload 14
    //   537: ifnull +15 -> 552
    //   540: aload 12
    //   542: ifnull +57 -> 599
    //   545: aload 14
    //   547: invokeinterface 110 1 0
    //   552: ldc_w 336
    //   555: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: aload 11
    //   560: athrow
    //   561: astore 11
    //   563: ldc_w 392
    //   566: ldc_w 498
    //   569: iconst_1
    //   570: anewarray 89	java/lang/Object
    //   573: dup
    //   574: iconst_0
    //   575: aload 11
    //   577: aastore
    //   578: invokestatic 501	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   581: aconst_null
    //   582: astore 11
    //   584: goto -191 -> 393
    //   587: astore 13
    //   589: aload 12
    //   591: aload 13
    //   593: invokevirtual 121	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   596: goto -44 -> 552
    //   599: aload 14
    //   601: invokeinterface 110 1 0
    //   606: goto -54 -> 552
    //   609: goto -216 -> 393
    //   612: aload_1
    //   613: ifnonnull +40 -> 653
    //   616: iconst_1
    //   617: istore 10
    //   619: aload_1
    //   620: ifnonnull +39 -> 659
    //   623: aconst_null
    //   624: astore_1
    //   625: ldc_w 392
    //   628: ldc_w 503
    //   631: iconst_2
    //   632: anewarray 89	java/lang/Object
    //   635: dup
    //   636: iconst_0
    //   637: iload 10
    //   639: invokestatic 506	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   642: aastore
    //   643: dup
    //   644: iconst_1
    //   645: aload_1
    //   646: aastore
    //   647: invokestatic 501	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   650: goto -145 -> 505
    //   653: iconst_0
    //   654: istore 10
    //   656: goto -37 -> 619
    //   659: aload_1
    //   660: getfield 467	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   663: astore_1
    //   664: goto -39 -> 625
    //   667: ldc_w 336
    //   670: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   673: iconst_m1
    //   674: ireturn
    //   675: astore 11
    //   677: goto -142 -> 535
    //   680: astore 11
    //   682: goto -119 -> 563
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	this	u
    //   0	685	1	paramString	String
    //   0	685	2	paramInt	int
    //   64	455	3	i	int
    //   86	137	4	l1	long
    //   97	133	6	l2	long
    //   169	63	8	l3	long
    //   617	38	10	bool	boolean
    //   45	381	11	localObject1	Object
    //   533	26	11	localObject2	Object
    //   561	15	11	localSQLiteException	android.database.sqlite.SQLiteException
    //   582	1	11	localObject3	Object
    //   675	1	11	localObject4	Object
    //   680	1	11	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   311	113	12	localcxb	cxb
    //   522	68	12	localThrowable1	java.lang.Throwable
    //   274	100	13	locala	u.a
    //   587	5	13	localThrowable2	java.lang.Throwable
    //   308	292	14	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   326	381	522	java/lang/Throwable
    //   524	533	533	finally
    //   276	310	561	android/database/sqlite/SQLiteException
    //   386	393	561	android/database/sqlite/SQLiteException
    //   545	552	561	android/database/sqlite/SQLiteException
    //   552	561	561	android/database/sqlite/SQLiteException
    //   589	596	561	android/database/sqlite/SQLiteException
    //   599	606	561	android/database/sqlite/SQLiteException
    //   545	552	587	java/lang/Throwable
    //   326	381	675	finally
    //   276	310	680	com/tencent/wcdb/database/SQLiteException
    //   386	393	680	com/tencent/wcdb/database/SQLiteException
    //   545	552	680	com/tencent/wcdb/database/SQLiteException
    //   552	561	680	com/tencent/wcdb/database/SQLiteException
    //   589	596	680	com/tencent/wcdb/database/SQLiteException
    //   599	606	680	com/tencent/wcdb/database/SQLiteException
  }
  
  public final boolean aX(String paramString, int paramInt)
  {
    AppMethodBeat.i(44588);
    boolean bool = i(paramString, paramInt, true);
    AppMethodBeat.o(44588);
    return bool;
  }
  
  public final void add(k.a parama)
  {
    AppMethodBeat.i(44578);
    add("MicroMsg.AppBrandStarAppStorage.WORKER", parama);
    AppMethodBeat.o(44578);
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt, ah.a parama)
  {
    AppMethodBeat.i(44581);
    parama = b(paramInt, parama, 2147483647);
    AppMethodBeat.o(44581);
    return parama;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt1, ah.a parama, int paramInt2)
  {
    AppMethodBeat.i(44582);
    ah.a locala = parama;
    if (parama == null) {
      locala = ah.a.iVL;
    }
    if (locala == ah.a.iVN)
    {
      parama = qM(paramInt1);
      AppMethodBeat.o(44582);
      return parama;
    }
    if (paramInt1 <= 0) {}
    Object localObject1;
    Object localObject2;
    for (paramInt1 = v.aSb();; paramInt1 = Math.min(v.aSb(), paramInt1))
    {
      parama = null;
      localObject1 = null;
      if (paramInt2 != 2147483647)
      {
        parama = String.format(Locale.US, "%s=?", new Object[] { "versionType" });
        localObject1 = new String[1];
        localObject1[0] = String.valueOf(paramInt2);
      }
      localObject2 = this.iVg;
      String str = String.format(Locale.US, "%s desc limit %d offset 0", new Object[] { "orderSequence", Integer.valueOf(paramInt1) });
      localObject1 = ((h)localObject2).query("AppBrandStarApp", new String[] { "username", "versionType" }, parama, (String[])localObject1, null, null, str);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(44582);
      return null;
    }
    parama = null;
    if (ah.a.iVM == locala) {
      if (((Cursor)localObject1).moveToLast())
      {
        localObject2 = new LinkedList();
        parama = new u.a();
        label220:
        do
        {
          parama.convertFrom((Cursor)localObject1);
          ((List)localObject2).add(com.tencent.mm.plugin.appbrand.config.u.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { parama.field_username, Integer.valueOf(parama.field_versionType) }), parama.field_username, parama.field_versionType, -1L));
          if (ah.a.iVM != locala) {
            break;
          }
        } while (((Cursor)localObject1).moveToPrevious());
      }
    }
    for (;;)
    {
      parama = new ArrayList(((List)localObject2).size());
      parama.addAll((Collection)localObject2);
      do
      {
        ((Cursor)localObject1).close();
        AppMethodBeat.o(44582);
        return parama;
      } while (!((Cursor)localObject1).moveToFirst());
      break;
      if (((Cursor)localObject1).moveToNext()) {
        break label220;
      }
    }
  }
  
  public final boolean i(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44589);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44589);
      return false;
    }
    Object localObject = new u.a();
    ((u.a)localObject).field_username = paramString;
    ((u.a)localObject).field_versionType = paramInt;
    if (this.iVh.get((com.tencent.mm.sdk.e.c)localObject, new String[] { "versionType", "username" }))
    {
      this.iVh.delete((com.tencent.mm.sdk.e.c)localObject, false, u.a.iLd);
      if (aV(paramString, paramInt)) {
        break label286;
      }
      doNotify("single", 5, localObject);
    }
    label278:
    label286:
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (paramBoolean))
      {
        localObject = new cxb();
        ((cxb)localObject).username = paramString;
        ((cxb)localObject).CLK = paramInt;
        ((c)g.ab(c.class)).a(ab.a((cxb)localObject), ab.b.iVD);
      }
      paramString = ((m)g.ab(m.class)).FW(paramString);
      if ((paramString != null) && (!bt.isNullOrNil(paramString.field_appId)) && (!Boolean.valueOf(com.tencent.mm.plugin.appbrand.app.j.Dh().get(p.a.FV(paramString.field_appId), "true")).booleanValue()))
      {
        com.tencent.mm.plugin.appbrand.app.j.Dh().vv(p.a.FV(paramString.field_appId));
        AppMethodBeat.o(44589);
        return bool;
      }
      if (paramString == null)
      {
        paramBoolean = true;
        label240:
        if (paramString != null) {
          break label278;
        }
      }
      for (paramString = null;; paramString = paramString.field_appId)
      {
        ad.e("MicroMsg.AppBrandStarAppStorage", "restore receive status fail, attributes is null: %b, appId: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
        break;
        paramBoolean = false;
        break label240;
      }
    }
  }
  
  static abstract interface b<T>
  {
    public abstract long cl(T paramT);
    
    public abstract int cm(T paramT);
    
    public abstract String cn(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u
 * JD-Core Version:    0.7.0.1
 */