package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.emh;
import com.tencent.mm.protocal.protobuf.fno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.a.j;

public final class u
  extends MStorage
{
  public static final String[] lqL;
  private static final b<fno> nPH;
  private static final b<LocalUsageInfo> nPI;
  final com.tencent.mm.storagebase.h nPF;
  private final u.c nPG;
  
  static
  {
    AppMethodBeat.i(44590);
    lqL = new String[] { MAutoStorage.getCreateSQLs(u.a.lqK, "AppBrandStarApp") };
    nPH = new u.1();
    nPI = new u.2();
    AppMethodBeat.o(44590);
  }
  
  public u(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(44577);
    this.nPF = paramh;
    this.nPG = new u.c(paramh);
    AppMethodBeat.o(44577);
  }
  
  private ArrayList<AppBrandRecentTaskInfo> zi(int paramInt)
  {
    AppMethodBeat.i(44583);
    Object localObject1 = "select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
    Object localObject2 = this.nPF.rawQuery((String)localObject1, null);
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
      if (!Util.isNullOrNil(str))
      {
        paramInt = ((Cursor)localObject2).getInt(1);
        long l = ((Cursor)localObject2).getLong(2);
        ((LinkedList)localObject1).add(y.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { str, Integer.valueOf(paramInt) }), str, paramInt, l));
      }
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject2 = new ArrayList(((LinkedList)localObject1).size());
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    AppMethodBeat.o(44583);
    return localObject2;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> a(ag.a parama)
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
    if (paramClass == fno.class)
    {
      paramClass = nPH;
      l = this.nPF.beginTransaction(Thread.currentThread().getId());
      this.nPF.delete("AppBrandStarApp", "", null);
      if (Util.isNullOrNil(paramList)) {
        break label216;
      }
      if (paramList == null) {
        break label211;
      }
    }
    label211:
    for (paramList = j.m((Iterable)paramList);; paramList = null)
    {
      u.a locala = new u.a();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (!Util.isNullOrNil(paramClass.cw(localObject)))
        {
          locala.field_username = paramClass.cw(localObject);
          locala.field_versionType = paramClass.cv(localObject);
          locala.field_updateTime = paramClass.cu(localObject);
          i += 1;
          locala.field_orderSequence = (i * (v.bJC() * 2));
          this.nPF.insert("AppBrandStarApp", null, locala.convertTo());
        }
      }
      if (paramClass == LocalUsageInfo.class)
      {
        paramClass = nPI;
        break;
      }
      AppMethodBeat.o(44585);
      return;
    }
    label216:
    this.nPF.endTransaction(l);
    doNotify("batch", 3, paramLong);
    AppMethodBeat.o(44585);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(44578);
    add("MicroMsg.AppBrandStarAppStorage.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(44578);
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt, ag.a parama)
  {
    AppMethodBeat.i(44581);
    parama = b(paramInt, parama, 2147483647);
    AppMethodBeat.o(44581);
    return parama;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt1, ag.a parama, int paramInt2)
  {
    AppMethodBeat.i(44582);
    ag.a locala = parama;
    if (parama == null) {
      locala = ag.a.nQi;
    }
    if (locala == ag.a.nQk)
    {
      parama = zi(paramInt1);
      AppMethodBeat.o(44582);
      return parama;
    }
    if (paramInt1 <= 0) {}
    Object localObject1;
    Object localObject2;
    for (paramInt1 = v.bJC();; paramInt1 = Math.min(v.bJC(), paramInt1))
    {
      parama = null;
      localObject1 = null;
      if (paramInt2 != 2147483647)
      {
        parama = String.format(Locale.US, "%s=?", new Object[] { "versionType" });
        localObject1 = new String[1];
        localObject1[0] = String.valueOf(paramInt2);
      }
      localObject2 = this.nPF;
      String str = String.format(Locale.US, "%s desc limit %d offset 0", new Object[] { "orderSequence", Integer.valueOf(paramInt1) });
      localObject1 = ((com.tencent.mm.storagebase.h)localObject2).query("AppBrandStarApp", new String[] { "username", "versionType" }, parama, (String[])localObject1, null, null, str);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(44582);
      return null;
    }
    parama = null;
    if (ag.a.nQj == locala) {
      if (((Cursor)localObject1).moveToLast())
      {
        localObject2 = new LinkedList();
        parama = new u.a();
        label221:
        do
        {
          parama.convertFrom((Cursor)localObject1);
          ((List)localObject2).add(y.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { parama.field_username, Integer.valueOf(parama.field_versionType) }), parama.field_username, parama.field_versionType, -1L));
          if (ag.a.nQj != locala) {
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
        break label221;
      }
    }
  }
  
  public final boolean bC(String paramString, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(44584);
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = localObject; paramString == null; paramString = this.nPF.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "username", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, null))
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
  public final int bD(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: ldc_w 370
    //   6: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_1
    //   10: invokestatic 129	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   13: ifeq +11 -> 24
    //   16: ldc_w 370
    //   19: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   22: iconst_m1
    //   23: ireturn
    //   24: iload_2
    //   25: invokestatic 376	com/tencent/mm/plugin/appbrand/appcache/j$a:za	(I)Z
    //   28: ifeq +125 -> 153
    //   31: invokestatic 382	com/tencent/mm/plugin/appbrand/app/m:bFF	()Lcom/tencent/mm/plugin/appbrand/config/z;
    //   34: aload_1
    //   35: iconst_1
    //   36: anewarray 33	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: ldc_w 384
    //   44: aastore
    //   45: invokevirtual 390	com/tencent/mm/plugin/appbrand/config/z:c	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   48: astore 11
    //   50: aload 11
    //   52: ifnull +14 -> 66
    //   55: aload 11
    //   57: getfield 395	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appInfo	Ljava/lang/String;
    //   60: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +18 -> 81
    //   66: iconst_0
    //   67: istore_3
    //   68: iload_3
    //   69: ifeq +84 -> 153
    //   72: ldc_w 370
    //   75: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: bipush 253
    //   80: ireturn
    //   81: aload 11
    //   83: invokevirtual 405	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bLF	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   86: getfield 410	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:nQo	J
    //   89: lstore 4
    //   91: getstatic 416	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   94: invokestatic 421	java/lang/System:currentTimeMillis	()J
    //   97: invokevirtual 424	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   100: lstore 6
    //   102: ldc_w 426
    //   105: ldc_w 428
    //   108: iconst_3
    //   109: anewarray 147	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_1
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: lload 4
    //   120: invokestatic 433	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   123: aastore
    //   124: dup
    //   125: iconst_2
    //   126: lload 6
    //   128: invokestatic 433	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   131: aastore
    //   132: invokestatic 438	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: lload 6
    //   137: lload 4
    //   139: lcmp
    //   140: ifge +8 -> 148
    //   143: iconst_1
    //   144: istore_3
    //   145: goto -77 -> 68
    //   148: iconst_0
    //   149: istore_3
    //   150: goto -82 -> 68
    //   153: invokestatic 441	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   156: lstore 6
    //   158: getstatic 143	java/util/Locale:US	Ljava/util/Locale;
    //   161: ldc_w 443
    //   164: iconst_3
    //   165: anewarray 147	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: ldc_w 329
    //   173: aastore
    //   174: dup
    //   175: iconst_1
    //   176: ldc 39
    //   178: aastore
    //   179: dup
    //   180: iconst_2
    //   181: ldc_w 329
    //   184: aastore
    //   185: invokestatic 157	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   188: astore 11
    //   190: aload_0
    //   191: getfield 68	com/tencent/mm/plugin/appbrand/appusage/u:nPF	Lcom/tencent/mm/storagebase/h;
    //   194: aload 11
    //   196: aconst_null
    //   197: iconst_2
    //   198: invokevirtual 446	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   201: astore 11
    //   203: aload 11
    //   205: ifnull +13 -> 218
    //   208: aload 11
    //   210: invokeinterface 449 1 0
    //   215: ifeq +42 -> 257
    //   218: lconst_0
    //   219: lstore 4
    //   221: invokestatic 270	com/tencent/mm/plugin/appbrand/appusage/v:bJC	()I
    //   224: iconst_2
    //   225: imul
    //   226: i2l
    //   227: lstore 8
    //   229: aload_0
    //   230: aload_1
    //   231: iload_2
    //   232: invokevirtual 451	com/tencent/mm/plugin/appbrand/appusage/u:bC	(Ljava/lang/String;I)Z
    //   235: ifne +362 -> 597
    //   238: aload_0
    //   239: invokevirtual 454	com/tencent/mm/plugin/appbrand/appusage/u:bJz	()I
    //   242: invokestatic 270	com/tencent/mm/plugin/appbrand/appusage/v:bJC	()I
    //   245: if_icmplt +48 -> 293
    //   248: ldc_w 370
    //   251: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: bipush 254
    //   256: ireturn
    //   257: aload 11
    //   259: invokeinterface 113 1 0
    //   264: ifne +16 -> 280
    //   267: lconst_0
    //   268: lstore 4
    //   270: aload 11
    //   272: invokeinterface 116 1 0
    //   277: goto -56 -> 221
    //   280: aload 11
    //   282: iconst_0
    //   283: invokeinterface 137 2 0
    //   288: lstore 4
    //   290: goto -20 -> 270
    //   293: new 6	com/tencent/mm/plugin/appbrand/appusage/u$a
    //   296: dup
    //   297: invokespecial 226	com/tencent/mm/plugin/appbrand/appusage/u$a:<init>	()V
    //   300: astore 11
    //   302: aload 11
    //   304: aload_1
    //   305: putfield 249	com/tencent/mm/plugin/appbrand/appusage/u$a:field_username	Ljava/lang/String;
    //   308: aload 11
    //   310: iload_2
    //   311: putfield 257	com/tencent/mm/plugin/appbrand/appusage/u$a:field_versionType	I
    //   314: aload 11
    //   316: lload 6
    //   318: putfield 265	com/tencent/mm/plugin/appbrand/appusage/u$a:field_updateTime	J
    //   321: aload 11
    //   323: lload 4
    //   325: lload 8
    //   327: ladd
    //   328: putfield 273	com/tencent/mm/plugin/appbrand/appusage/u$a:field_orderSequence	J
    //   331: aload_0
    //   332: getfield 72	com/tencent/mm/plugin/appbrand/appusage/u:nPG	Lcom/tencent/mm/plugin/appbrand/appusage/u$c;
    //   335: aload 11
    //   337: iconst_0
    //   338: invokevirtual 458	com/tencent/mm/plugin/appbrand/appusage/u$c:insertNotify	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Z)Z
    //   341: pop
    //   342: aload_0
    //   343: aload_1
    //   344: iload_2
    //   345: invokevirtual 451	com/tencent/mm/plugin/appbrand/appusage/u:bC	(Ljava/lang/String;I)Z
    //   348: ifeq +422 -> 770
    //   351: aload_0
    //   352: ldc_w 460
    //   355: iconst_2
    //   356: aload 11
    //   358: invokevirtual 293	com/tencent/mm/plugin/appbrand/appusage/u:doNotify	(Ljava/lang/String;ILjava/lang/Object;)V
    //   361: iconst_1
    //   362: istore_3
    //   363: iload_3
    //   364: ifeq +152 -> 516
    //   367: aload_0
    //   368: getfield 68	com/tencent/mm/plugin/appbrand/appusage/u:nPF	Lcom/tencent/mm/storagebase/h;
    //   371: getstatic 463	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   374: ldc_w 465
    //   377: iconst_2
    //   378: anewarray 147	java/lang/Object
    //   381: dup
    //   382: iconst_0
    //   383: ldc 39
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: ldc_w 329
    //   391: aastore
    //   392: invokestatic 157	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   395: aconst_null
    //   396: invokevirtual 107	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   399: astore 14
    //   401: aload 14
    //   403: ifnull +361 -> 764
    //   406: aload 14
    //   408: invokeinterface 113 1 0
    //   413: ifeq +351 -> 764
    //   416: new 6	com/tencent/mm/plugin/appbrand/appusage/u$a
    //   419: dup
    //   420: invokespecial 226	com/tencent/mm/plugin/appbrand/appusage/u$a:<init>	()V
    //   423: astore 12
    //   425: aload 12
    //   427: aload 14
    //   429: invokevirtual 348	com/tencent/mm/plugin/appbrand/appusage/u$a:convertFrom	(Landroid/database/Cursor;)V
    //   432: new 467	com/tencent/mm/protocal/protobuf/emh
    //   435: dup
    //   436: invokespecial 468	com/tencent/mm/protocal/protobuf/emh:<init>	()V
    //   439: astore 11
    //   441: aload 11
    //   443: aload 12
    //   445: getfield 249	com/tencent/mm/plugin/appbrand/appusage/u$a:field_username	Ljava/lang/String;
    //   448: putfield 470	com/tencent/mm/protocal/protobuf/emh:username	Ljava/lang/String;
    //   451: aload 11
    //   453: aload 12
    //   455: getfield 257	com/tencent/mm/plugin/appbrand/appusage/u$a:field_versionType	I
    //   458: putfield 473	com/tencent/mm/protocal/protobuf/emh:RYL	I
    //   461: aload 14
    //   463: ifnull +226 -> 689
    //   466: aload 14
    //   468: invokeinterface 116 1 0
    //   473: new 467	com/tencent/mm/protocal/protobuf/emh
    //   476: dup
    //   477: invokespecial 468	com/tencent/mm/protocal/protobuf/emh:<init>	()V
    //   480: astore 12
    //   482: aload 12
    //   484: aload_1
    //   485: putfield 470	com/tencent/mm/protocal/protobuf/emh:username	Ljava/lang/String;
    //   488: aload 12
    //   490: iload_2
    //   491: putfield 473	com/tencent/mm/protocal/protobuf/emh:RYL	I
    //   494: ldc_w 475
    //   497: invokestatic 481	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   500: checkcast 475	com/tencent/mm/plugin/appbrand/appusage/c
    //   503: aload 12
    //   505: aload 11
    //   507: invokestatic 486	com/tencent/mm/plugin/appbrand/appusage/aa:a	(Lcom/tencent/mm/protocal/protobuf/emh;Lcom/tencent/mm/protocal/protobuf/emh;)Lcom/tencent/mm/protocal/protobuf/emi;
    //   510: getstatic 492	com/tencent/mm/plugin/appbrand/appusage/aa$b:nQa	Lcom/tencent/mm/plugin/appbrand/appusage/aa$b;
    //   513: invokevirtual 495	com/tencent/mm/plugin/appbrand/appusage/c:a	(Lcom/tencent/mm/protocal/protobuf/emi;Lcom/tencent/mm/plugin/appbrand/appusage/aa$b;)V
    //   516: ldc_w 497
    //   519: invokestatic 481	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   522: checkcast 497	com/tencent/mm/plugin/appbrand/service/q
    //   525: aload_1
    //   526: invokeinterface 501 2 0
    //   531: astore_1
    //   532: aload_1
    //   533: ifnull +159 -> 692
    //   536: aload_1
    //   537: getfield 504	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   540: invokestatic 129	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   543: ifne +149 -> 692
    //   546: invokestatic 508	com/tencent/mm/plugin/appbrand/app/m:QG	()Lcom/tencent/mm/plugin/appbrand/config/e;
    //   549: aload_1
    //   550: getfield 504	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   553: invokestatic 514	com/tencent/mm/plugin/appbrand/config/q$a:aeV	(Ljava/lang/String;)Ljava/lang/String;
    //   556: ldc_w 516
    //   559: invokevirtual 522	com/tencent/mm/plugin/appbrand/config/e:L	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   562: invokestatic 527	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   565: invokevirtual 530	java/lang/Boolean:booleanValue	()Z
    //   568: ifne +124 -> 692
    //   571: invokestatic 508	com/tencent/mm/plugin/appbrand/app/m:QG	()Lcom/tencent/mm/plugin/appbrand/config/e;
    //   574: aload_1
    //   575: getfield 504	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   578: invokestatic 514	com/tencent/mm/plugin/appbrand/config/q$a:aeV	(Ljava/lang/String;)Ljava/lang/String;
    //   581: invokevirtual 533	com/tencent/mm/plugin/appbrand/config/e:ho	(Ljava/lang/String;)Z
    //   584: pop
    //   585: iload_3
    //   586: ifeq +162 -> 748
    //   589: ldc_w 370
    //   592: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   595: iconst_0
    //   596: ireturn
    //   597: iconst_1
    //   598: istore_3
    //   599: goto -236 -> 363
    //   602: astore 12
    //   604: ldc_w 370
    //   607: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   610: aload 12
    //   612: athrow
    //   613: astore 11
    //   615: aload 14
    //   617: ifnull +15 -> 632
    //   620: aload 12
    //   622: ifnull +57 -> 679
    //   625: aload 14
    //   627: invokeinterface 116 1 0
    //   632: ldc_w 370
    //   635: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   638: aload 11
    //   640: athrow
    //   641: astore 11
    //   643: ldc_w 426
    //   646: ldc_w 535
    //   649: iconst_1
    //   650: anewarray 147	java/lang/Object
    //   653: dup
    //   654: iconst_0
    //   655: aload 11
    //   657: aastore
    //   658: invokestatic 538	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   661: aconst_null
    //   662: astore 11
    //   664: goto -191 -> 473
    //   667: astore 14
    //   669: aload 12
    //   671: aload 14
    //   673: invokevirtual 542	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   676: goto -44 -> 632
    //   679: aload 14
    //   681: invokeinterface 116 1 0
    //   686: goto -54 -> 632
    //   689: goto -216 -> 473
    //   692: aload_1
    //   693: ifnonnull +41 -> 734
    //   696: iconst_1
    //   697: istore 10
    //   699: aload_1
    //   700: ifnonnull +40 -> 740
    //   703: aload 13
    //   705: astore_1
    //   706: ldc_w 426
    //   709: ldc_w 544
    //   712: iconst_2
    //   713: anewarray 147	java/lang/Object
    //   716: dup
    //   717: iconst_0
    //   718: iload 10
    //   720: invokestatic 547	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   723: aastore
    //   724: dup
    //   725: iconst_1
    //   726: aload_1
    //   727: aastore
    //   728: invokestatic 538	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   731: goto -146 -> 585
    //   734: iconst_0
    //   735: istore 10
    //   737: goto -38 -> 699
    //   740: aload_1
    //   741: getfield 504	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   744: astore_1
    //   745: goto -39 -> 706
    //   748: ldc_w 370
    //   751: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   754: iconst_m1
    //   755: ireturn
    //   756: astore 11
    //   758: aconst_null
    //   759: astore 12
    //   761: goto -146 -> 615
    //   764: aconst_null
    //   765: astore 11
    //   767: goto -306 -> 461
    //   770: iconst_0
    //   771: istore_3
    //   772: goto -409 -> 363
    //   775: astore 11
    //   777: goto -134 -> 643
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	this	u
    //   0	780	1	paramString	String
    //   0	780	2	paramInt	int
    //   67	705	3	i	int
    //   89	235	4	l1	long
    //   100	217	6	l2	long
    //   227	99	8	l3	long
    //   697	39	10	bool	boolean
    //   48	458	11	localObject1	Object
    //   613	26	11	localObject2	Object
    //   641	15	11	localSQLiteException	android.database.sqlite.SQLiteException
    //   662	1	11	localObject3	Object
    //   756	1	11	localObject4	Object
    //   765	1	11	localObject5	Object
    //   775	1	11	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   423	81	12	localObject6	Object
    //   602	68	12	localThrowable1	java.lang.Throwable
    //   759	1	12	localObject7	Object
    //   1	703	13	localObject8	Object
    //   399	227	14	localCursor	Cursor
    //   667	13	14	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   406	461	602	java/lang/Throwable
    //   604	613	613	finally
    //   367	401	641	android/database/sqlite/SQLiteException
    //   466	473	641	android/database/sqlite/SQLiteException
    //   625	632	641	android/database/sqlite/SQLiteException
    //   632	641	641	android/database/sqlite/SQLiteException
    //   669	676	641	android/database/sqlite/SQLiteException
    //   679	686	641	android/database/sqlite/SQLiteException
    //   625	632	667	java/lang/Throwable
    //   406	461	756	finally
    //   367	401	775	com/tencent/wcdb/database/SQLiteException
    //   466	473	775	com/tencent/wcdb/database/SQLiteException
    //   625	632	775	com/tencent/wcdb/database/SQLiteException
    //   632	641	775	com/tencent/wcdb/database/SQLiteException
    //   669	676	775	com/tencent/wcdb/database/SQLiteException
    //   679	686	775	com/tencent/wcdb/database/SQLiteException
  }
  
  public final boolean bE(String paramString, int paramInt)
  {
    AppMethodBeat.i(44588);
    boolean bool = n(paramString, paramInt, true);
    AppMethodBeat.o(44588);
    return bool;
  }
  
  public final int bJz()
  {
    int i = 0;
    AppMethodBeat.i(44579);
    Cursor localCursor = this.nPF.rawQuery("select count(*) from AppBrandStarApp", null);
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
  
  public final boolean n(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44589);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44589);
      return false;
    }
    Object localObject = new u.a();
    ((u.a)localObject).field_username = paramString;
    ((u.a)localObject).field_versionType = paramInt;
    if (this.nPG.get((IAutoDBItem)localObject, new String[] { "versionType", "username" }))
    {
      this.nPG.delete((IAutoDBItem)localObject, false, u.a.nDP);
      if (bC(paramString, paramInt)) {
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
        localObject = new emh();
        ((emh)localObject).username = paramString;
        ((emh)localObject).RYL = paramInt;
        ((c)com.tencent.mm.kernel.h.ae(c.class)).a(aa.a((emh)localObject), aa.b.nQa);
      }
      paramString = ((q)com.tencent.mm.kernel.h.ae(q.class)).aeW(paramString);
      if ((paramString != null) && (!Util.isNullOrNil(paramString.field_appId)) && (!Boolean.valueOf(m.QG().L(q.a.aeV(paramString.field_appId), "true")).booleanValue()))
      {
        m.QG().ho(q.a.aeV(paramString.field_appId));
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
        Log.e("MicroMsg.AppBrandStarAppStorage", "restore receive status fail, attributes is null: %b, appId: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
        break;
        paramBoolean = false;
        break label240;
      }
    }
  }
  
  static abstract interface b<T>
  {
    public abstract long cu(T paramT);
    
    public abstract int cv(T paramT);
    
    public abstract String cw(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u
 * JD-Core Version:    0.7.0.1
 */