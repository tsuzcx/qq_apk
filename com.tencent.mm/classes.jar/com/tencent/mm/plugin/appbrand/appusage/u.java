package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.protocal.protobuf.fcn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storagebase.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.a.j;

public final class u
  extends MStorage
{
  public static final String[] iBh;
  private static final b<fcn> kVu;
  private static final b<LocalUsageInfo> kVv;
  final h kVs;
  private final c kVt;
  
  static
  {
    AppMethodBeat.i(44590);
    iBh = new String[] { MAutoStorage.getCreateSQLs(a.iBg, "AppBrandStarApp") };
    kVu = new b() {};
    kVv = new b() {};
    AppMethodBeat.o(44590);
  }
  
  public u(h paramh)
  {
    AppMethodBeat.i(44577);
    this.kVs = paramh;
    this.kVt = new c(paramh);
    AppMethodBeat.o(44577);
  }
  
  /* Error */
  private long byl()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 81
    //   5: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 87	java/util/Locale:US	Ljava/util/Locale;
    //   11: ldc 89
    //   13: iconst_3
    //   14: anewarray 91	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc 93
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: ldc 45
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc 93
    //   31: aastore
    //   32: invokestatic 97	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 70	com/tencent/mm/plugin/appbrand/appusage/u:kVs	Lcom/tencent/mm/storagebase/h;
    //   41: aload 4
    //   43: aconst_null
    //   44: iconst_2
    //   45: invokevirtual 103	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   48: astore 6
    //   50: aload 6
    //   52: ifnull +15 -> 67
    //   55: aload 6
    //   57: invokeinterface 109 1 0
    //   62: istore_1
    //   63: iload_1
    //   64: ifeq +22 -> 86
    //   67: aload 6
    //   69: ifnull +10 -> 79
    //   72: aload 6
    //   74: invokeinterface 112 1 0
    //   79: ldc 81
    //   81: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: lconst_0
    //   85: lreturn
    //   86: aload 6
    //   88: invokeinterface 115 1 0
    //   93: ifeq +31 -> 124
    //   96: aload 6
    //   98: iconst_0
    //   99: invokeinterface 119 2 0
    //   104: lstore_2
    //   105: aload 6
    //   107: ifnull +10 -> 117
    //   110: aload 6
    //   112: invokeinterface 112 1 0
    //   117: ldc 81
    //   119: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: lload_2
    //   123: lreturn
    //   124: aload 6
    //   126: ifnull +10 -> 136
    //   129: aload 6
    //   131: invokeinterface 112 1 0
    //   136: ldc 81
    //   138: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: lconst_0
    //   142: lreturn
    //   143: astore 5
    //   145: ldc 81
    //   147: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload 5
    //   152: athrow
    //   153: astore 4
    //   155: aload 6
    //   157: ifnull +15 -> 172
    //   160: aload 5
    //   162: ifnull +39 -> 201
    //   165: aload 6
    //   167: invokeinterface 112 1 0
    //   172: ldc 81
    //   174: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload 4
    //   179: athrow
    //   180: astore 4
    //   182: ldc 81
    //   184: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: lconst_0
    //   188: lreturn
    //   189: astore 6
    //   191: aload 5
    //   193: aload 6
    //   195: invokevirtual 123	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   198: goto -26 -> 172
    //   201: aload 6
    //   203: invokeinterface 112 1 0
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
  
  private ArrayList<AppBrandRecentTaskInfo> vX(int paramInt)
  {
    AppMethodBeat.i(44583);
    Object localObject1 = "select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
    Object localObject2 = this.kVs.rawQuery((String)localObject1, null);
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
    if (paramClass == fcn.class)
    {
      paramClass = kVu;
      l = this.kVs.beginTransaction(Thread.currentThread().getId());
      this.kVs.delete("AppBrandStarApp", "", null);
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
      a locala = new a();
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
          locala.field_orderSequence = (i * (v.byo() * 2));
          this.kVs.insert("AppBrandStarApp", null, locala.convertTo());
        }
      }
      if (paramClass == LocalUsageInfo.class)
      {
        paramClass = kVv;
        break;
      }
      AppMethodBeat.o(44585);
      return;
    }
    label216:
    this.kVs.endTransaction(l);
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
      locala = ag.a.kVV;
    }
    if (locala == ag.a.kVX)
    {
      parama = vX(paramInt1);
      AppMethodBeat.o(44582);
      return parama;
    }
    if (paramInt1 <= 0) {}
    Object localObject1;
    Object localObject2;
    for (paramInt1 = v.byo();; paramInt1 = Math.min(v.byo(), paramInt1))
    {
      parama = null;
      localObject1 = null;
      if (paramInt2 != 2147483647)
      {
        parama = String.format(Locale.US, "%s=?", new Object[] { "versionType" });
        localObject1 = new String[1];
        localObject1[0] = String.valueOf(paramInt2);
      }
      localObject2 = this.kVs;
      String str = String.format(Locale.US, "%s desc limit %d offset 0", new Object[] { "orderSequence", Integer.valueOf(paramInt1) });
      localObject1 = ((h)localObject2).query("AppBrandStarApp", new String[] { "username", "versionType" }, parama, (String[])localObject1, null, null, str);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(44582);
      return null;
    }
    parama = null;
    if (ag.a.kVW == locala) {
      if (((Cursor)localObject1).moveToLast())
      {
        localObject2 = new LinkedList();
        parama = new a();
        label220:
        do
        {
          parama.convertFrom((Cursor)localObject1);
          ((List)localObject2).add(y.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { parama.field_username, Integer.valueOf(parama.field_versionType) }), parama.field_username, parama.field_versionType, -1L));
          if (ag.a.kVW != locala) {
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
  
  public final boolean bj(String paramString, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(44584);
    if (Util.isNullOrNil(paramString)) {}
    for (paramString = localObject; paramString == null; paramString = this.kVs.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "username", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, null))
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
  public final int bk(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 387
    //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 168	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 387
    //   16: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_m1
    //   20: ireturn
    //   21: iload_2
    //   22: invokestatic 393	com/tencent/mm/plugin/appbrand/appcache/j$a:vP	(I)Z
    //   25: ifeq +125 -> 150
    //   28: invokestatic 399	com/tencent/mm/plugin/appbrand/app/n:buC	()Lcom/tencent/mm/plugin/appbrand/config/z;
    //   31: aload_1
    //   32: iconst_1
    //   33: anewarray 39	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 401
    //   41: aastore
    //   42: invokevirtual 407	com/tencent/mm/plugin/appbrand/config/z:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   45: astore 11
    //   47: aload 11
    //   49: ifnull +14 -> 63
    //   52: aload 11
    //   54: getfield 412	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appInfo	Ljava/lang/String;
    //   57: invokestatic 418	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +18 -> 78
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq +84 -> 150
    //   69: ldc_w 387
    //   72: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: bipush 253
    //   77: ireturn
    //   78: aload 11
    //   80: invokevirtual 422	com/tencent/mm/plugin/appbrand/config/WxaAttributes:bAn	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   83: getfield 427	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:kWb	J
    //   86: lstore 4
    //   88: getstatic 433	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   91: invokestatic 438	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 441	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   97: lstore 6
    //   99: ldc_w 443
    //   102: ldc_w 445
    //   105: iconst_3
    //   106: anewarray 91	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: lload 4
    //   117: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: lload 6
    //   125: invokestatic 450	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: aastore
    //   129: invokestatic 455	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   152: invokestatic 458	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   155: lstore 4
    //   157: aload_0
    //   158: invokespecial 460	com/tencent/mm/plugin/appbrand/appusage/u:byl	()J
    //   161: lstore 6
    //   163: invokestatic 291	com/tencent/mm/plugin/appbrand/appusage/v:byo	()I
    //   166: iconst_2
    //   167: imul
    //   168: i2l
    //   169: lstore 8
    //   171: aload_0
    //   172: aload_1
    //   173: iload_2
    //   174: invokevirtual 462	com/tencent/mm/plugin/appbrand/appusage/u:bj	(Ljava/lang/String;I)Z
    //   177: ifne +339 -> 516
    //   180: aload_0
    //   181: invokevirtual 465	com/tencent/mm/plugin/appbrand/appusage/u:byk	()I
    //   184: invokestatic 291	com/tencent/mm/plugin/appbrand/appusage/v:byo	()I
    //   187: if_icmplt +12 -> 199
    //   190: ldc_w 387
    //   193: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: bipush 254
    //   198: ireturn
    //   199: new 10	com/tencent/mm/plugin/appbrand/appusage/u$a
    //   202: dup
    //   203: invokespecial 247	com/tencent/mm/plugin/appbrand/appusage/u$a:<init>	()V
    //   206: astore 11
    //   208: aload 11
    //   210: aload_1
    //   211: putfield 270	com/tencent/mm/plugin/appbrand/appusage/u$a:field_username	Ljava/lang/String;
    //   214: aload 11
    //   216: iload_2
    //   217: putfield 278	com/tencent/mm/plugin/appbrand/appusage/u$a:field_versionType	I
    //   220: aload 11
    //   222: lload 4
    //   224: putfield 286	com/tencent/mm/plugin/appbrand/appusage/u$a:field_updateTime	J
    //   227: aload 11
    //   229: lload 6
    //   231: lload 8
    //   233: lsub
    //   234: putfield 294	com/tencent/mm/plugin/appbrand/appusage/u$a:field_orderSequence	J
    //   237: aload_0
    //   238: getfield 74	com/tencent/mm/plugin/appbrand/appusage/u:kVt	Lcom/tencent/mm/plugin/appbrand/appusage/u$c;
    //   241: aload 11
    //   243: iconst_0
    //   244: invokevirtual 469	com/tencent/mm/plugin/appbrand/appusage/u$c:insertNotify	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Z)Z
    //   247: pop
    //   248: aload_0
    //   249: aload_1
    //   250: iload_2
    //   251: invokevirtual 462	com/tencent/mm/plugin/appbrand/appusage/u:bj	(Ljava/lang/String;I)Z
    //   254: ifeq +15 -> 269
    //   257: aload_0
    //   258: ldc_w 471
    //   261: iconst_2
    //   262: aload 11
    //   264: invokevirtual 314	com/tencent/mm/plugin/appbrand/appusage/u:doNotify	(Ljava/lang/String;ILjava/lang/Object;)V
    //   267: iconst_1
    //   268: istore_3
    //   269: iload_3
    //   270: ifeq +165 -> 435
    //   273: aconst_null
    //   274: astore 13
    //   276: aload_0
    //   277: getfield 70	com/tencent/mm/plugin/appbrand/appusage/u:kVs	Lcom/tencent/mm/storagebase/h;
    //   280: getstatic 474	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   283: ldc_w 476
    //   286: iconst_2
    //   287: anewarray 91	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: ldc 45
    //   294: aastore
    //   295: dup
    //   296: iconst_1
    //   297: ldc 93
    //   299: aastore
    //   300: invokestatic 97	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   303: aconst_null
    //   304: invokevirtual 155	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   307: astore 14
    //   309: aconst_null
    //   310: astore 12
    //   312: aload 13
    //   314: astore 11
    //   316: aload 14
    //   318: ifnull +62 -> 380
    //   321: aload 13
    //   323: astore 11
    //   325: aload 14
    //   327: invokeinterface 115 1 0
    //   332: ifeq +48 -> 380
    //   335: new 10	com/tencent/mm/plugin/appbrand/appusage/u$a
    //   338: dup
    //   339: invokespecial 247	com/tencent/mm/plugin/appbrand/appusage/u$a:<init>	()V
    //   342: astore 13
    //   344: aload 13
    //   346: aload 14
    //   348: invokevirtual 367	com/tencent/mm/plugin/appbrand/appusage/u$a:convertFrom	(Landroid/database/Cursor;)V
    //   351: new 478	com/tencent/mm/protocal/protobuf/ecg
    //   354: dup
    //   355: invokespecial 479	com/tencent/mm/protocal/protobuf/ecg:<init>	()V
    //   358: astore 11
    //   360: aload 11
    //   362: aload 13
    //   364: getfield 270	com/tencent/mm/plugin/appbrand/appusage/u$a:field_username	Ljava/lang/String;
    //   367: putfield 481	com/tencent/mm/protocal/protobuf/ecg:username	Ljava/lang/String;
    //   370: aload 11
    //   372: aload 13
    //   374: getfield 278	com/tencent/mm/plugin/appbrand/appusage/u$a:field_versionType	I
    //   377: putfield 484	com/tencent/mm/protocal/protobuf/ecg:KXC	I
    //   380: aload 14
    //   382: ifnull +226 -> 608
    //   385: aload 14
    //   387: invokeinterface 112 1 0
    //   392: new 478	com/tencent/mm/protocal/protobuf/ecg
    //   395: dup
    //   396: invokespecial 479	com/tencent/mm/protocal/protobuf/ecg:<init>	()V
    //   399: astore 12
    //   401: aload 12
    //   403: aload_1
    //   404: putfield 481	com/tencent/mm/protocal/protobuf/ecg:username	Ljava/lang/String;
    //   407: aload 12
    //   409: iload_2
    //   410: putfield 484	com/tencent/mm/protocal/protobuf/ecg:KXC	I
    //   413: ldc_w 486
    //   416: invokestatic 492	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   419: checkcast 486	com/tencent/mm/plugin/appbrand/appusage/c
    //   422: aload 12
    //   424: aload 11
    //   426: invokestatic 497	com/tencent/mm/plugin/appbrand/appusage/aa:a	(Lcom/tencent/mm/protocal/protobuf/ecg;Lcom/tencent/mm/protocal/protobuf/ecg;)Lcom/tencent/mm/protocal/protobuf/ech;
    //   429: getstatic 503	com/tencent/mm/plugin/appbrand/appusage/aa$b:kVN	Lcom/tencent/mm/plugin/appbrand/appusage/aa$b;
    //   432: invokevirtual 506	com/tencent/mm/plugin/appbrand/appusage/c:a	(Lcom/tencent/mm/protocal/protobuf/ech;Lcom/tencent/mm/plugin/appbrand/appusage/aa$b;)V
    //   435: ldc_w 508
    //   438: invokestatic 492	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   441: checkcast 508	com/tencent/mm/plugin/appbrand/service/q
    //   444: aload_1
    //   445: invokeinterface 512 2 0
    //   450: astore_1
    //   451: aload_1
    //   452: ifnull +159 -> 611
    //   455: aload_1
    //   456: getfield 515	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   459: invokestatic 168	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   462: ifne +149 -> 611
    //   465: invokestatic 519	com/tencent/mm/plugin/appbrand/app/n:NL	()Lcom/tencent/mm/plugin/appbrand/config/e;
    //   468: aload_1
    //   469: getfield 515	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   472: invokestatic 525	com/tencent/mm/plugin/appbrand/config/q$a:Xj	(Ljava/lang/String;)Ljava/lang/String;
    //   475: ldc_w 527
    //   478: invokevirtual 533	com/tencent/mm/plugin/appbrand/config/e:get	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   481: invokestatic 538	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   484: invokevirtual 541	java/lang/Boolean:booleanValue	()Z
    //   487: ifne +124 -> 611
    //   490: invokestatic 519	com/tencent/mm/plugin/appbrand/app/n:NL	()Lcom/tencent/mm/plugin/appbrand/config/e;
    //   493: aload_1
    //   494: getfield 515	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   497: invokestatic 525	com/tencent/mm/plugin/appbrand/config/q$a:Xj	(Ljava/lang/String;)Ljava/lang/String;
    //   500: invokevirtual 544	com/tencent/mm/plugin/appbrand/config/e:gC	(Ljava/lang/String;)Z
    //   503: pop
    //   504: iload_3
    //   505: ifeq +161 -> 666
    //   508: ldc_w 387
    //   511: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   514: iconst_0
    //   515: ireturn
    //   516: iconst_1
    //   517: istore_3
    //   518: goto -249 -> 269
    //   521: astore 12
    //   523: ldc_w 387
    //   526: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   529: aload 12
    //   531: athrow
    //   532: astore 11
    //   534: aload 14
    //   536: ifnull +15 -> 551
    //   539: aload 12
    //   541: ifnull +57 -> 598
    //   544: aload 14
    //   546: invokeinterface 112 1 0
    //   551: ldc_w 387
    //   554: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   557: aload 11
    //   559: athrow
    //   560: astore 11
    //   562: ldc_w 443
    //   565: ldc_w 546
    //   568: iconst_1
    //   569: anewarray 91	java/lang/Object
    //   572: dup
    //   573: iconst_0
    //   574: aload 11
    //   576: aastore
    //   577: invokestatic 549	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   580: aconst_null
    //   581: astore 11
    //   583: goto -191 -> 392
    //   586: astore 13
    //   588: aload 12
    //   590: aload 13
    //   592: invokevirtual 123	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   595: goto -44 -> 551
    //   598: aload 14
    //   600: invokeinterface 112 1 0
    //   605: goto -54 -> 551
    //   608: goto -216 -> 392
    //   611: aload_1
    //   612: ifnonnull +40 -> 652
    //   615: iconst_1
    //   616: istore 10
    //   618: aload_1
    //   619: ifnonnull +39 -> 658
    //   622: aconst_null
    //   623: astore_1
    //   624: ldc_w 443
    //   627: ldc_w 551
    //   630: iconst_2
    //   631: anewarray 91	java/lang/Object
    //   634: dup
    //   635: iconst_0
    //   636: iload 10
    //   638: invokestatic 554	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   641: aastore
    //   642: dup
    //   643: iconst_1
    //   644: aload_1
    //   645: aastore
    //   646: invokestatic 549	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   649: goto -145 -> 504
    //   652: iconst_0
    //   653: istore 10
    //   655: goto -37 -> 618
    //   658: aload_1
    //   659: getfield 515	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   662: astore_1
    //   663: goto -39 -> 624
    //   666: ldc_w 387
    //   669: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   672: iconst_m1
    //   673: ireturn
    //   674: astore 11
    //   676: goto -142 -> 534
    //   679: astore 11
    //   681: goto -119 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	u
    //   0	684	1	paramString	String
    //   0	684	2	paramInt	int
    //   64	454	3	i	int
    //   86	137	4	l1	long
    //   97	133	6	l2	long
    //   169	63	8	l3	long
    //   616	38	10	bool	boolean
    //   45	380	11	localObject1	Object
    //   532	26	11	localObject2	Object
    //   560	15	11	localSQLiteException	android.database.sqlite.SQLiteException
    //   581	1	11	localObject3	Object
    //   674	1	11	localObject4	Object
    //   679	1	11	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   310	113	12	localecg	ecg
    //   521	68	12	localThrowable1	java.lang.Throwable
    //   274	99	13	locala	a
    //   586	5	13	localThrowable2	java.lang.Throwable
    //   307	292	14	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   325	380	521	java/lang/Throwable
    //   523	532	532	finally
    //   276	309	560	android/database/sqlite/SQLiteException
    //   385	392	560	android/database/sqlite/SQLiteException
    //   544	551	560	android/database/sqlite/SQLiteException
    //   551	560	560	android/database/sqlite/SQLiteException
    //   588	595	560	android/database/sqlite/SQLiteException
    //   598	605	560	android/database/sqlite/SQLiteException
    //   544	551	586	java/lang/Throwable
    //   325	380	674	finally
    //   276	309	679	com/tencent/wcdb/database/SQLiteException
    //   385	392	679	com/tencent/wcdb/database/SQLiteException
    //   544	551	679	com/tencent/wcdb/database/SQLiteException
    //   551	560	679	com/tencent/wcdb/database/SQLiteException
    //   588	595	679	com/tencent/wcdb/database/SQLiteException
    //   598	605	679	com/tencent/wcdb/database/SQLiteException
  }
  
  public final boolean bl(String paramString, int paramInt)
  {
    AppMethodBeat.i(44588);
    boolean bool = j(paramString, paramInt, true);
    AppMethodBeat.o(44588);
    return bool;
  }
  
  public final int byk()
  {
    int i = 0;
    AppMethodBeat.i(44579);
    Cursor localCursor = this.kVs.rawQuery("select count(*) from AppBrandStarApp", null);
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
  
  public final boolean j(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44589);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44589);
      return false;
    }
    Object localObject = new a();
    ((a)localObject).field_username = paramString;
    ((a)localObject).field_versionType = paramInt;
    if (this.kVt.get((IAutoDBItem)localObject, new String[] { "versionType", "username" }))
    {
      this.kVt.delete((IAutoDBItem)localObject, false, a.kJX);
      if (bj(paramString, paramInt)) {
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
        localObject = new ecg();
        ((ecg)localObject).username = paramString;
        ((ecg)localObject).KXC = paramInt;
        ((c)g.af(c.class)).a(aa.a((ecg)localObject), aa.b.kVN);
      }
      paramString = ((q)g.af(q.class)).Xk(paramString);
      if ((paramString != null) && (!Util.isNullOrNil(paramString.field_appId)) && (!Boolean.valueOf(n.NL().get(q.a.Xj(paramString.field_appId), "true")).booleanValue()))
      {
        n.NL().gC(q.a.Xj(paramString.field_appId));
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
  
  public static final class a
    extends com.tencent.mm.g.c.u
  {
    static final IAutoDBItem.MAutoDBInfo iBg;
    static final String[] kJX;
    
    static
    {
      int i = 0;
      AppMethodBeat.i(44576);
      kJX = new String[] { "username", "versionType" };
      Object localObject1 = new IAutoDBItem.MAutoDBInfo();
      ((IAutoDBItem.MAutoDBInfo)localObject1).fields = new Field[4];
      ((IAutoDBItem.MAutoDBInfo)localObject1).columns = new String[5];
      Object localObject2 = new StringBuilder();
      ((IAutoDBItem.MAutoDBInfo)localObject1).columns[0] = "username";
      ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("username", "TEXT");
      ((StringBuilder)localObject2).append(" username TEXT");
      ((StringBuilder)localObject2).append(", ");
      ((IAutoDBItem.MAutoDBInfo)localObject1).columns[1] = "versionType";
      ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("versionType", "INTEGER");
      ((StringBuilder)localObject2).append(" versionType INTEGER");
      ((StringBuilder)localObject2).append(", ");
      ((IAutoDBItem.MAutoDBInfo)localObject1).columns[2] = "updateTime";
      ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("updateTime", "LONG");
      ((StringBuilder)localObject2).append(" updateTime LONG");
      ((StringBuilder)localObject2).append(", ");
      ((IAutoDBItem.MAutoDBInfo)localObject1).columns[3] = "orderSequence";
      ((IAutoDBItem.MAutoDBInfo)localObject1).colsMap.put("orderSequence", "LONG");
      ((StringBuilder)localObject2).append(" orderSequence LONG");
      ((IAutoDBItem.MAutoDBInfo)localObject1).columns[4] = "rowid";
      ((IAutoDBItem.MAutoDBInfo)localObject1).sql = ((StringBuilder)localObject2).toString();
      iBg = (IAutoDBItem.MAutoDBInfo)localObject1;
      localObject1 = " PRIMARY KEY ( ";
      localObject2 = kJX;
      int j = localObject2.length;
      while (i < j)
      {
        localObject3 = localObject2[i];
        localObject1 = (String)localObject1 + ", " + (String)localObject3;
        i += 1;
      }
      localObject1 = ((String)localObject1).replaceFirst(",", "");
      localObject1 = (String)localObject1 + " )";
      localObject2 = new StringBuilder();
      Object localObject3 = iBg;
      ((IAutoDBItem.MAutoDBInfo)localObject3).sql = (((IAutoDBItem.MAutoDBInfo)localObject3).sql + "," + (String)localObject1);
      AppMethodBeat.o(44576);
    }
    
    public final IAutoDBItem.MAutoDBInfo getDBInfo()
    {
      return iBg;
    }
  }
  
  static abstract interface b<T>
  {
    public abstract long cu(T paramT);
    
    public abstract int cv(T paramT);
    
    public abstract String cw(T paramT);
  }
  
  static final class c
    extends MAutoStorage<u.a>
  {
    c(h paramh)
    {
      super(u.a.iBg, "AppBrandStarApp", u.a.INDEX_CREATE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.u
 * JD-Core Version:    0.7.0.1
 */