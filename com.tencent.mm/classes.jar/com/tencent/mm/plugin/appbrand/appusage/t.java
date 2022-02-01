package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.s.a;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.protocal.protobuf.fhe;
import com.tencent.mm.protocal.protobuf.gkl;
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
import kotlin.a.p;

public final class t
  extends MStorage
{
  public static final String[] nVW;
  private static final b<gkl> qPy;
  private static final b<LocalUsageInfo> qPz;
  final com.tencent.mm.storagebase.h qPw;
  private final t.c qPx;
  
  static
  {
    AppMethodBeat.i(44590);
    nVW = new String[] { MAutoStorage.getCreateSQLs(t.a.nVV, "AppBrandStarApp") };
    qPy = new b() {};
    qPz = new b() {};
    AppMethodBeat.o(44590);
  }
  
  public t(com.tencent.mm.storagebase.h paramh)
  {
    AppMethodBeat.i(44577);
    this.qPw = paramh;
    this.qPx = new t.c(paramh);
    AppMethodBeat.o(44577);
  }
  
  private Cursor bV(String paramString, int paramInt)
  {
    AppMethodBeat.i(319332);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(319332);
      return null;
    }
    paramString = this.qPw.query("AppBrandStarApp", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "username", "versionType" }), new String[] { paramString, String.valueOf(paramInt) }, null, null, null);
    AppMethodBeat.o(319332);
    return paramString;
  }
  
  /* Error */
  private long cje()
  {
    // Byte code:
    //   0: ldc 114
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 87	java/util/Locale:US	Ljava/util/Locale;
    //   8: ldc 116
    //   10: iconst_3
    //   11: anewarray 91	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: ldc 118
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: ldc 43
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc 118
    //   28: aastore
    //   29: invokestatic 99	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   32: astore 4
    //   34: aload_0
    //   35: getfield 68	com/tencent/mm/plugin/appbrand/appusage/t:qPw	Lcom/tencent/mm/storagebase/h;
    //   38: aload 4
    //   40: aconst_null
    //   41: iconst_2
    //   42: invokevirtual 122	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;I)Landroid/database/Cursor;
    //   45: astore 5
    //   47: aload 5
    //   49: ifnull +15 -> 64
    //   52: aload 5
    //   54: invokeinterface 128 1 0
    //   59: istore_1
    //   60: iload_1
    //   61: ifeq +22 -> 83
    //   64: aload 5
    //   66: ifnull +10 -> 76
    //   69: aload 5
    //   71: invokeinterface 131 1 0
    //   76: ldc 114
    //   78: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: lconst_0
    //   82: lreturn
    //   83: aload 5
    //   85: invokeinterface 134 1 0
    //   90: ifeq +31 -> 121
    //   93: aload 5
    //   95: iconst_0
    //   96: invokeinterface 138 2 0
    //   101: lstore_2
    //   102: aload 5
    //   104: ifnull +10 -> 114
    //   107: aload 5
    //   109: invokeinterface 131 1 0
    //   114: ldc 114
    //   116: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   119: lload_2
    //   120: lreturn
    //   121: aload 5
    //   123: ifnull +10 -> 133
    //   126: aload 5
    //   128: invokeinterface 131 1 0
    //   133: ldc 114
    //   135: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: lconst_0
    //   139: lreturn
    //   140: astore 4
    //   142: aload 5
    //   144: ifnull +10 -> 154
    //   147: aload 5
    //   149: invokeinterface 131 1 0
    //   154: ldc 114
    //   156: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload 4
    //   161: athrow
    //   162: astore 4
    //   164: ldc 114
    //   166: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: lconst_0
    //   170: lreturn
    //   171: astore 5
    //   173: aload 4
    //   175: aload 5
    //   177: invokevirtual 144	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   180: goto -26 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	t
    //   59	2	1	bool	boolean
    //   101	19	2	l	long
    //   32	7	4	str	String
    //   140	20	4	localObject	Object
    //   162	12	4	localException	java.lang.Exception
    //   45	103	5	localCursor	Cursor
    //   171	5	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   52	60	140	finally
    //   83	102	140	finally
    //   34	47	162	java/lang/Exception
    //   69	76	162	java/lang/Exception
    //   107	114	162	java/lang/Exception
    //   126	133	162	java/lang/Exception
    //   154	162	162	java/lang/Exception
    //   173	180	162	java/lang/Exception
    //   147	154	171	finally
  }
  
  private ArrayList<AppBrandRecentTaskInfo> zv(int paramInt)
  {
    AppMethodBeat.i(44583);
    Object localObject1 = "select AppBrandStarApp.username, AppBrandStarApp.versionType, AppBrandLocalUsageRecord.updateTime from AppBrandStarApp left outer join AppBrandLocalUsageRecord on AppBrandStarApp.username = AppBrandLocalUsageRecord.username and AppBrandStarApp.versionType = AppBrandLocalUsageRecord.versionType order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
    Object localObject2 = this.qPw.rawQuery((String)localObject1, null);
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
        ((LinkedList)localObject1).add(ad.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { str, Integer.valueOf(paramInt) }), str, paramInt, l));
      }
    } while (((Cursor)localObject2).moveToNext());
    ((Cursor)localObject2).close();
    localObject2 = new ArrayList(((LinkedList)localObject1).size());
    ((ArrayList)localObject2).addAll((Collection)localObject1);
    AppMethodBeat.o(44583);
    return localObject2;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> a(af.a parama)
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
    if (paramClass == gkl.class)
    {
      paramClass = qPy;
      l = this.qPw.beginTransaction(Thread.currentThread().getId());
      this.qPw.delete("AppBrandStarApp", "", null);
      if (Util.isNullOrNil(paramList)) {
        break label216;
      }
      if (paramList != null) {
        break label205;
      }
    }
    label205:
    for (paramList = null;; paramList = p.m((Iterable)paramList))
    {
      t.a locala = new t.a();
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = paramList.next();
        if (!Util.isNullOrNil(paramClass.dR(localObject)))
        {
          locala.field_username = paramClass.dR(localObject);
          locala.field_versionType = paramClass.dQ(localObject);
          locala.field_updateTime = paramClass.dP(localObject);
          i += 1;
          locala.field_orderSequence = (i * (u.cjh() * 2));
          this.qPw.insert("AppBrandStarApp", null, locala.convertTo());
        }
      }
      if (paramClass == LocalUsageInfo.class)
      {
        paramClass = qPz;
        break;
      }
      AppMethodBeat.o(44585);
      return;
    }
    label216:
    this.qPw.endTransaction(l);
    doNotify("batch", 3, paramLong);
    AppMethodBeat.o(44585);
  }
  
  public final void add(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(44578);
    add("MicroMsg.AppBrandStarAppStorage.WORKER", paramIOnStorageChange);
    AppMethodBeat.o(44578);
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt, af.a parama)
  {
    AppMethodBeat.i(44581);
    parama = b(paramInt, parama, 2147483647);
    AppMethodBeat.o(44581);
    return parama;
  }
  
  public final ArrayList<AppBrandRecentTaskInfo> b(int paramInt1, af.a parama, int paramInt2)
  {
    AppMethodBeat.i(44582);
    af.a locala = parama;
    if (parama == null) {
      locala = af.a.qPX;
    }
    if (locala == af.a.qPZ)
    {
      parama = zv(paramInt1);
      AppMethodBeat.o(44582);
      return parama;
    }
    if (paramInt1 <= 0) {}
    Object localObject1;
    Object localObject2;
    for (paramInt1 = u.cjh();; paramInt1 = Math.min(u.cjh(), paramInt1))
    {
      parama = null;
      localObject1 = null;
      if (paramInt2 != 2147483647)
      {
        parama = String.format(Locale.US, "%s=?", new Object[] { "versionType" });
        localObject1 = new String[1];
        localObject1[0] = String.valueOf(paramInt2);
      }
      localObject2 = this.qPw;
      String str = String.format(Locale.US, "%s desc limit %d offset 0", new Object[] { "orderSequence", Integer.valueOf(paramInt1) });
      localObject1 = ((com.tencent.mm.storagebase.h)localObject2).query("AppBrandStarApp", new String[] { "username", "versionType" }, parama, (String[])localObject1, null, null, str);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(44582);
      return null;
    }
    parama = null;
    if (af.a.qPY == locala) {
      if (((Cursor)localObject1).moveToLast())
      {
        localObject2 = new LinkedList();
        parama = new t.a();
        label217:
        do
        {
          parama.convertFrom((Cursor)localObject1);
          ((List)localObject2).add(ad.a(String.format(Locale.US, "$%s$%d@starapp", new Object[] { parama.field_username, Integer.valueOf(parama.field_versionType) }), parama.field_username, parama.field_versionType, -1L));
          if (af.a.qPY != locala) {
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
        break label217;
      }
    }
  }
  
  public final boolean bU(String paramString, int paramInt)
  {
    AppMethodBeat.i(44584);
    paramString = bV(paramString, paramInt);
    if (paramString == null)
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
  public final int bW(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 391
    //   3: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 81	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +11 -> 21
    //   13: ldc_w 391
    //   16: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_m1
    //   20: ireturn
    //   21: iload_2
    //   22: invokestatic 397	com/tencent/mm/plugin/appbrand/appcache/k$a:zn	(I)Z
    //   25: ifeq +125 -> 150
    //   28: invokestatic 403	com/tencent/mm/plugin/appbrand/app/n:cfc	()Lcom/tencent/mm/plugin/appbrand/config/af;
    //   31: aload_1
    //   32: iconst_1
    //   33: anewarray 37	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 405
    //   41: aastore
    //   42: invokevirtual 411	com/tencent/mm/plugin/appbrand/config/af:d	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;
    //   45: astore 9
    //   47: aload 9
    //   49: ifnull +14 -> 63
    //   52: aload 9
    //   54: getfield 416	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appInfo	Ljava/lang/String;
    //   57: invokestatic 422	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   60: ifeq +18 -> 78
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq +84 -> 150
    //   69: ldc_w 391
    //   72: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: bipush 253
    //   77: ireturn
    //   78: aload 9
    //   80: invokevirtual 426	com/tencent/mm/plugin/appbrand/config/WxaAttributes:cld	()Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes$a;
    //   83: getfield 431	com/tencent/mm/plugin/appbrand/config/WxaAttributes$a:qQd	J
    //   86: lstore 4
    //   88: getstatic 437	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   91: invokestatic 442	java/lang/System:currentTimeMillis	()J
    //   94: invokevirtual 445	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   97: lstore 6
    //   99: ldc_w 447
    //   102: ldc_w 449
    //   105: iconst_3
    //   106: anewarray 91	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: lload 4
    //   117: invokestatic 454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: aastore
    //   121: dup
    //   122: iconst_2
    //   123: lload 6
    //   125: invokestatic 454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: aastore
    //   129: invokestatic 459	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   152: invokestatic 462	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   155: lstore 4
    //   157: aload_0
    //   158: invokespecial 464	com/tencent/mm/plugin/appbrand/appusage/t:cje	()J
    //   161: invokestatic 297	com/tencent/mm/plugin/appbrand/appusage/u:cjh	()I
    //   164: iconst_2
    //   165: imul
    //   166: i2l
    //   167: lsub
    //   168: lstore 6
    //   170: ldc_w 447
    //   173: ldc_w 466
    //   176: iconst_1
    //   177: anewarray 91	java/lang/Object
    //   180: dup
    //   181: iconst_0
    //   182: lload 6
    //   184: invokestatic 454	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   187: aastore
    //   188: invokestatic 459	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: aload_0
    //   192: aload_1
    //   193: iload_2
    //   194: invokevirtual 468	com/tencent/mm/plugin/appbrand/appusage/t:bU	(Ljava/lang/String;I)Z
    //   197: ifne +333 -> 530
    //   200: aload_0
    //   201: invokevirtual 471	com/tencent/mm/plugin/appbrand/appusage/t:cjd	()I
    //   204: invokestatic 297	com/tencent/mm/plugin/appbrand/appusage/u:cjh	()I
    //   207: if_icmplt +12 -> 219
    //   210: ldc_w 391
    //   213: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: bipush 254
    //   218: ireturn
    //   219: new 10	com/tencent/mm/plugin/appbrand/appusage/t$a
    //   222: dup
    //   223: invokespecial 253	com/tencent/mm/plugin/appbrand/appusage/t$a:<init>	()V
    //   226: astore 9
    //   228: aload 9
    //   230: aload_1
    //   231: putfield 276	com/tencent/mm/plugin/appbrand/appusage/t$a:field_username	Ljava/lang/String;
    //   234: aload 9
    //   236: iload_2
    //   237: putfield 284	com/tencent/mm/plugin/appbrand/appusage/t$a:field_versionType	I
    //   240: aload 9
    //   242: lload 4
    //   244: putfield 292	com/tencent/mm/plugin/appbrand/appusage/t$a:field_updateTime	J
    //   247: aload 9
    //   249: lload 6
    //   251: putfield 300	com/tencent/mm/plugin/appbrand/appusage/t$a:field_orderSequence	J
    //   254: aload_0
    //   255: getfield 72	com/tencent/mm/plugin/appbrand/appusage/t:qPx	Lcom/tencent/mm/plugin/appbrand/appusage/t$c;
    //   258: aload 9
    //   260: iconst_0
    //   261: invokevirtual 475	com/tencent/mm/plugin/appbrand/appusage/t$c:insertNotify	(Lcom/tencent/mm/sdk/storage/IAutoDBItem;Z)Z
    //   264: pop
    //   265: aload_0
    //   266: aload_1
    //   267: iload_2
    //   268: invokevirtual 468	com/tencent/mm/plugin/appbrand/appusage/t:bU	(Ljava/lang/String;I)Z
    //   271: ifeq +15 -> 286
    //   274: aload_0
    //   275: ldc_w 477
    //   278: iconst_2
    //   279: aload 9
    //   281: invokevirtual 328	com/tencent/mm/plugin/appbrand/appusage/t:doNotify	(Ljava/lang/String;ILjava/lang/Object;)V
    //   284: iconst_1
    //   285: istore_3
    //   286: iload_3
    //   287: ifeq +162 -> 449
    //   290: aconst_null
    //   291: astore 10
    //   293: aload_0
    //   294: getfield 68	com/tencent/mm/plugin/appbrand/appusage/t:qPw	Lcom/tencent/mm/storagebase/h;
    //   297: getstatic 480	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   300: ldc_w 482
    //   303: iconst_2
    //   304: anewarray 91	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: ldc 43
    //   311: aastore
    //   312: dup
    //   313: iconst_1
    //   314: ldc 118
    //   316: aastore
    //   317: invokestatic 99	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   320: aconst_null
    //   321: invokevirtual 176	com/tencent/mm/storagebase/h:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   324: astore 11
    //   326: aload 10
    //   328: astore 9
    //   330: aload 11
    //   332: ifnull +62 -> 394
    //   335: aload 10
    //   337: astore 9
    //   339: aload 11
    //   341: invokeinterface 134 1 0
    //   346: ifeq +48 -> 394
    //   349: new 10	com/tencent/mm/plugin/appbrand/appusage/t$a
    //   352: dup
    //   353: invokespecial 253	com/tencent/mm/plugin/appbrand/appusage/t$a:<init>	()V
    //   356: astore 10
    //   358: aload 10
    //   360: aload 11
    //   362: invokevirtual 371	com/tencent/mm/plugin/appbrand/appusage/t$a:convertFrom	(Landroid/database/Cursor;)V
    //   365: new 484	com/tencent/mm/protocal/protobuf/fhe
    //   368: dup
    //   369: invokespecial 485	com/tencent/mm/protocal/protobuf/fhe:<init>	()V
    //   372: astore 9
    //   374: aload 9
    //   376: aload 10
    //   378: getfield 276	com/tencent/mm/plugin/appbrand/appusage/t$a:field_username	Ljava/lang/String;
    //   381: putfield 487	com/tencent/mm/protocal/protobuf/fhe:username	Ljava/lang/String;
    //   384: aload 9
    //   386: aload 10
    //   388: getfield 284	com/tencent/mm/plugin/appbrand/appusage/t$a:field_versionType	I
    //   391: putfield 490	com/tencent/mm/protocal/protobuf/fhe:Tqb	I
    //   394: aload 11
    //   396: ifnull +205 -> 601
    //   399: aload 11
    //   401: invokeinterface 131 1 0
    //   406: new 484	com/tencent/mm/protocal/protobuf/fhe
    //   409: dup
    //   410: invokespecial 485	com/tencent/mm/protocal/protobuf/fhe:<init>	()V
    //   413: astore 10
    //   415: aload 10
    //   417: aload_1
    //   418: putfield 487	com/tencent/mm/protocal/protobuf/fhe:username	Ljava/lang/String;
    //   421: aload 10
    //   423: iload_2
    //   424: putfield 490	com/tencent/mm/protocal/protobuf/fhe:Tqb	I
    //   427: ldc_w 492
    //   430: invokestatic 498	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   433: checkcast 492	com/tencent/mm/plugin/appbrand/appusage/c
    //   436: aload 10
    //   438: aload 9
    //   440: invokestatic 503	com/tencent/mm/plugin/appbrand/appusage/z:a	(Lcom/tencent/mm/protocal/protobuf/fhe;Lcom/tencent/mm/protocal/protobuf/fhe;)Lcom/tencent/mm/protocal/protobuf/fhf;
    //   443: getstatic 509	com/tencent/mm/plugin/appbrand/appusage/z$b:qPS	Lcom/tencent/mm/plugin/appbrand/appusage/z$b;
    //   446: invokevirtual 512	com/tencent/mm/plugin/appbrand/appusage/c:a	(Lcom/tencent/mm/protocal/protobuf/fhf;Lcom/tencent/mm/plugin/appbrand/appusage/z$b;)V
    //   449: ldc_w 514
    //   452: invokestatic 498	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   455: checkcast 514	com/tencent/mm/plugin/appbrand/service/s
    //   458: aload_1
    //   459: invokeinterface 518 2 0
    //   464: astore_1
    //   465: aload_1
    //   466: ifnull +138 -> 604
    //   469: aload_1
    //   470: getfield 521	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   473: invokestatic 81	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   476: ifne +128 -> 604
    //   479: invokestatic 525	com/tencent/mm/plugin/appbrand/app/n:aqS	()Lcom/tencent/mm/plugin/appbrand/config/e;
    //   482: aload_1
    //   483: getfield 521	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   486: invokestatic 531	com/tencent/mm/plugin/appbrand/config/s$a:Xx	(Ljava/lang/String;)Ljava/lang/String;
    //   489: ldc_w 533
    //   492: invokevirtual 539	com/tencent/mm/plugin/appbrand/config/e:O	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   495: invokestatic 544	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   498: invokevirtual 547	java/lang/Boolean:booleanValue	()Z
    //   501: ifne +103 -> 604
    //   504: invokestatic 525	com/tencent/mm/plugin/appbrand/app/n:aqS	()Lcom/tencent/mm/plugin/appbrand/config/e;
    //   507: aload_1
    //   508: getfield 521	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   511: invokestatic 531	com/tencent/mm/plugin/appbrand/config/s$a:Xx	(Ljava/lang/String;)Ljava/lang/String;
    //   514: invokevirtual 550	com/tencent/mm/plugin/appbrand/config/e:iP	(Ljava/lang/String;)Z
    //   517: pop
    //   518: iload_3
    //   519: ifeq +140 -> 659
    //   522: ldc_w 391
    //   525: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: iconst_0
    //   529: ireturn
    //   530: iconst_1
    //   531: istore_3
    //   532: goto -246 -> 286
    //   535: astore 9
    //   537: aload 11
    //   539: ifnull +10 -> 549
    //   542: aload 11
    //   544: invokeinterface 131 1 0
    //   549: ldc_w 391
    //   552: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   555: aload 9
    //   557: athrow
    //   558: astore 9
    //   560: ldc_w 447
    //   563: ldc_w 552
    //   566: iconst_1
    //   567: anewarray 91	java/lang/Object
    //   570: dup
    //   571: iconst_0
    //   572: aload 9
    //   574: aastore
    //   575: invokestatic 555	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: aconst_null
    //   579: astore 9
    //   581: goto -175 -> 406
    //   584: astore 10
    //   586: aload 9
    //   588: aload 10
    //   590: invokevirtual 144	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   593: goto -44 -> 549
    //   596: astore 9
    //   598: goto -38 -> 560
    //   601: goto -195 -> 406
    //   604: aload_1
    //   605: ifnonnull +40 -> 645
    //   608: iconst_1
    //   609: istore 8
    //   611: aload_1
    //   612: ifnonnull +39 -> 651
    //   615: aconst_null
    //   616: astore_1
    //   617: ldc_w 447
    //   620: ldc_w 557
    //   623: iconst_2
    //   624: anewarray 91	java/lang/Object
    //   627: dup
    //   628: iconst_0
    //   629: iload 8
    //   631: invokestatic 560	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   634: aastore
    //   635: dup
    //   636: iconst_1
    //   637: aload_1
    //   638: aastore
    //   639: invokestatic 555	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   642: goto -124 -> 518
    //   645: iconst_0
    //   646: istore 8
    //   648: goto -37 -> 611
    //   651: aload_1
    //   652: getfield 521	com/tencent/mm/plugin/appbrand/config/WxaAttributes:field_appId	Ljava/lang/String;
    //   655: astore_1
    //   656: goto -39 -> 617
    //   659: ldc_w 391
    //   662: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: iconst_m1
    //   666: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	667	0	this	t
    //   0	667	1	paramString	String
    //   0	667	2	paramInt	int
    //   64	468	3	i	int
    //   86	157	4	l1	long
    //   97	153	6	l2	long
    //   609	38	8	bool	boolean
    //   45	394	9	localObject1	Object
    //   535	21	9	localObject2	Object
    //   558	15	9	localSQLiteException	android.database.sqlite.SQLiteException
    //   579	8	9	localObject3	Object
    //   596	1	9	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   291	146	10	localObject4	Object
    //   584	5	10	localThrowable	java.lang.Throwable
    //   324	219	11	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   339	394	535	finally
    //   293	326	558	android/database/sqlite/SQLiteException
    //   399	406	558	android/database/sqlite/SQLiteException
    //   549	558	558	android/database/sqlite/SQLiteException
    //   586	593	558	android/database/sqlite/SQLiteException
    //   542	549	584	finally
    //   293	326	596	com/tencent/wcdb/database/SQLiteException
    //   399	406	596	com/tencent/wcdb/database/SQLiteException
    //   549	558	596	com/tencent/wcdb/database/SQLiteException
    //   586	593	596	com/tencent/wcdb/database/SQLiteException
  }
  
  public final int cjd()
  {
    int i = 0;
    AppMethodBeat.i(44579);
    Cursor localCursor = this.qPw.rawQuery("select count(*) from AppBrandStarApp", null);
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
  
  public final boolean o(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(44589);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44589);
      return false;
    }
    Object localObject = new t.a();
    ((t.a)localObject).field_username = paramString;
    ((t.a)localObject).field_versionType = paramInt;
    if (this.qPx.get((IAutoDBItem)localObject, new String[] { "versionType", "username" }))
    {
      this.qPx.delete((IAutoDBItem)localObject, false, t.a.qDJ);
      if (bU(paramString, paramInt)) {
        break label284;
      }
      doNotify("single", 5, localObject);
    }
    label276:
    label284:
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (paramBoolean))
      {
        localObject = new fhe();
        ((fhe)localObject).username = paramString;
        ((fhe)localObject).Tqb = paramInt;
        ((c)com.tencent.mm.kernel.h.ax(c.class)).a(z.a((fhe)localObject), z.b.qPS);
      }
      paramString = ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(paramString);
      if ((paramString != null) && (!Util.isNullOrNil(paramString.field_appId)) && (!Boolean.valueOf(n.aqS().O(s.a.Xx(paramString.field_appId), "true")).booleanValue()))
      {
        n.aqS().iP(s.a.Xx(paramString.field_appId));
        AppMethodBeat.o(44589);
        return bool;
      }
      if (paramString == null)
      {
        paramBoolean = true;
        label238:
        if (paramString != null) {
          break label276;
        }
      }
      for (paramString = null;; paramString = paramString.field_appId)
      {
        Log.e("MicroMsg.AppBrandStarAppStorage", "restore receive status fail, attributes is null: %b, appId: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
        break;
        paramBoolean = false;
        break label238;
      }
    }
  }
  
  static abstract interface b<T>
  {
    public abstract long dP(T paramT);
    
    public abstract int dQ(T paramT);
    
    public abstract String dR(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.t
 * JD-Core Version:    0.7.0.1
 */