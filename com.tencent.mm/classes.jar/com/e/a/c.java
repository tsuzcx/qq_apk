package com.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.e.a.b.e;
import com.e.a.b.f;
import com.e.a.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.a.j;
import io.flutter.a.a.k;
import io.flutter.a.a.k.c;
import io.flutter.a.a.k.d;
import io.flutter.a.a.m.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements k.c
{
  static int azO;
  static final Map<String, Integer> bYo;
  private static boolean bYp;
  private static int bYq;
  private final Object bYr;
  private final Object bYs;
  String bYt;
  private int bYu;
  @SuppressLint({"UseSparseArrays"})
  private final Map<Integer, a> bYw;
  private Context context;
  private Handler handler;
  private HandlerThread handlerThread;
  
  static
  {
    AppMethodBeat.i(153389);
    bYo = new HashMap();
    bYp = false;
    bYq = 10;
    azO = 0;
    AppMethodBeat.o(153389);
  }
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(153367);
    this.bYr = new Object();
    this.bYs = new Object();
    this.bYu = 0;
    this.bYw = new HashMap();
    this.context = paramContext;
    AppMethodBeat.o(153367);
  }
  
  private static a a(a parama, d paramd, k.d paramd1)
  {
    AppMethodBeat.i(153375);
    if (parama.azO > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new StringBuilder("[").append(parama.Au()).append("] ").append(paramd);
      }
      try
      {
        parama.bYm.execSQL(paramd.sql, paramd.Ax());
        AppMethodBeat.o(153375);
        return parama;
      }
      catch (Exception localException)
      {
        a(localException, new com.e.a.b.d(paramd1, paramd), parama);
        AppMethodBeat.o(153375);
      }
    }
    return null;
  }
  
  public static void a(m.c paramc)
  {
    AppMethodBeat.i(153368);
    new k(paramc.IJ(), "com.tekartik.sqflite").a(new c(paramc.II()));
    AppMethodBeat.o(153368);
  }
  
  private static void a(Exception paramException, f paramf, a parama)
  {
    AppMethodBeat.i(153379);
    if ((paramException instanceof SQLiteCantOpenDatabaseException))
    {
      paramf.a("sqlite_error", "open_failed " + parama.path, null);
      AppMethodBeat.o(153379);
      return;
    }
    if ((paramException instanceof SQLException))
    {
      paramf.a("sqlite_error", paramException.getMessage(), h.a(paramf));
      AppMethodBeat.o(153379);
      return;
    }
    paramf.a("sqlite_error", paramException.getMessage(), h.a(paramf));
    AppMethodBeat.o(153379);
  }
  
  private static boolean a(a parama, f paramf)
  {
    AppMethodBeat.i(153374);
    d locald = paramf.Az();
    if (parama.azO > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new StringBuilder("[").append(parama.Au()).append("] ").append(locald);
      }
      try
      {
        parama.bYm.execSQL(locald.sql, locald.Ax());
        AppMethodBeat.o(153374);
        return true;
      }
      catch (Exception localException)
      {
        a(localException, paramf, parama);
        AppMethodBeat.o(153374);
      }
    }
    return false;
  }
  
  private a b(j paramj, k.d paramd)
  {
    AppMethodBeat.i(153373);
    int i = ((Integer)paramj.qa("id")).intValue();
    paramj = (a)this.bYw.get(Integer.valueOf(i));
    if (paramj != null)
    {
      AppMethodBeat.o(153373);
      return paramj;
    }
    paramd.a("sqlite_error", "database_closed ".concat(String.valueOf(i)), null);
    AppMethodBeat.o(153373);
    return null;
  }
  
  private static List<Object> b(Cursor paramCursor, int paramInt)
  {
    AppMethodBeat.i(153369);
    ArrayList localArrayList = new ArrayList(paramInt);
    int i = 0;
    Object localObject;
    label66:
    String str;
    if (i < paramInt) {
      switch (paramCursor.getType(i))
      {
      default: 
        localObject = null;
        if (com.e.a.a.a.bYN)
        {
          if (localObject == null) {
            break label301;
          }
          if (!localObject.getClass().isArray()) {
            break label251;
          }
          str = "array(" + localObject.getClass().getComponentType().getName() + ")";
        }
        break;
      }
    }
    for (;;)
    {
      label120:
      StringBuilder localStringBuilder = new StringBuilder("column ").append(i).append(" ").append(paramCursor.getType(i)).append(": ").append(localObject);
      if (str == null) {}
      for (str = "";; str = " (" + str + ")")
      {
        localStringBuilder.append(str);
        localArrayList.add(localObject);
        i += 1;
        break;
        localObject = null;
        break label66;
        localObject = Long.valueOf(paramCursor.getLong(i));
        break label66;
        localObject = Double.valueOf(paramCursor.getDouble(i));
        break label66;
        localObject = paramCursor.getString(i);
        break label66;
        localObject = paramCursor.getBlob(i);
        break label66;
        label251:
        str = localObject.getClass().getName();
        break label120;
      }
      AppMethodBeat.o(153369);
      return localArrayList;
      label301:
      str = null;
    }
  }
  
  private static boolean b(a parama, f paramf)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(153376);
    if (!a(parama, paramf))
    {
      AppMethodBeat.o(153376);
      return false;
    }
    if (paramf.AA())
    {
      paramf.ay(null);
      AppMethodBeat.o(153376);
      return true;
    }
    try
    {
      Cursor localCursor = parama.bYm.rawQuery("SELECT changes(), last_insert_rowid()", null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.getCount() > 0)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (localCursor.moveToFirst())
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (localCursor.getInt(0) == 0)
            {
              localObject1 = localCursor;
              localObject2 = localCursor;
              if (parama.azO > 0) {}
              for (int i = 1;; i = 0)
              {
                if (i != 0)
                {
                  localObject1 = localCursor;
                  localObject2 = localCursor;
                  new StringBuilder("no changes (id was ").append(localCursor.getLong(1)).append(")");
                }
                localObject1 = localCursor;
                localObject2 = localCursor;
                paramf.ay(null);
                return true;
              }
            }
            localObject1 = localCursor;
            localObject2 = localCursor;
            paramf.ay(Long.valueOf(localCursor.getLong(1)));
            return true;
          }
        }
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      paramf.ay(null);
      return true;
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      a(localException, paramf, parama);
      return false;
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.close();
      }
      AppMethodBeat.o(153376);
    }
  }
  
  private static Map<String, Object> c(Cursor paramCursor)
  {
    AppMethodBeat.i(153370);
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramCursor.getColumnNames();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      if (com.e.a.a.a.bYN) {
        new StringBuilder("column ").append(i).append(" ").append(paramCursor.getType(i));
      }
      switch (paramCursor.getType(i))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(arrayOfString[i], null);
        continue;
        localHashMap.put(arrayOfString[i], Long.valueOf(paramCursor.getLong(i)));
        continue;
        localHashMap.put(arrayOfString[i], Double.valueOf(paramCursor.getDouble(i)));
        continue;
        localHashMap.put(arrayOfString[i], paramCursor.getString(i));
        continue;
        localHashMap.put(arrayOfString[i], paramCursor.getBlob(i));
      }
    }
    AppMethodBeat.o(153370);
    return localHashMap;
  }
  
  private static Map<String, Object> c(Map<Object, Object> paramMap)
  {
    AppMethodBeat.i(153371);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = localEntry.getValue();
      if ((paramMap instanceof Map)) {}
      for (paramMap = c((Map)paramMap);; paramMap = toString(paramMap))
      {
        localHashMap.put(toString(localEntry.getKey()), paramMap);
        break;
      }
    }
    AppMethodBeat.o(153371);
    return localHashMap;
  }
  
  private void c(j paramj, k.d paramd)
  {
    AppMethodBeat.i(153381);
    Object localObject = (String)paramj.qa("cmd");
    paramj = new HashMap();
    if ("get".equals(localObject))
    {
      if (azO > 0) {
        paramj.put("logLevel", Integer.valueOf(azO));
      }
      if (!this.bYw.isEmpty())
      {
        localObject = new HashMap();
        Iterator localIterator = this.bYw.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          a locala = (a)localEntry.getValue();
          HashMap localHashMap = new HashMap();
          localHashMap.put("path", locala.path);
          localHashMap.put("singleInstance", Boolean.valueOf(locala.bYl));
          if (locala.azO > 0) {
            localHashMap.put("logLevel", Integer.valueOf(locala.azO));
          }
          ((Map)localObject).put(((Integer)localEntry.getKey()).toString(), localHashMap);
        }
        paramj.put("databases", localObject);
      }
    }
    paramd.ay(paramj);
    AppMethodBeat.o(153381);
  }
  
  /* Error */
  private static boolean c(a parama, f paramf)
  {
    // Byte code:
    //   0: ldc_w 451
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokeinterface 226 1 0
    //   12: astore 5
    //   14: new 263	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 452	java/util/ArrayList:<init>	()V
    //   21: astore 8
    //   23: aload_0
    //   24: getfield 100	com/e/a/a:azO	I
    //   27: ifle +172 -> 199
    //   30: iconst_1
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq +29 -> 62
    //   36: new 102	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 104
    //   42: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: invokestatic 458	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   48: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc 117
    //   53: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 5
    //   58: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: getstatic 72	com/e/a/c:bYp	Z
    //   65: istore 4
    //   67: aload 5
    //   69: invokevirtual 461	com/e/a/d:Aw	()Lcom/e/a/d;
    //   72: astore 5
    //   74: aload_0
    //   75: getfield 124	com/e/a/a:bYm	Landroid/database/sqlite/SQLiteDatabase;
    //   78: aload 5
    //   80: getfield 129	com/e/a/d:sql	Ljava/lang/String;
    //   83: aload 5
    //   85: getfield 465	com/e/a/d:bYL	Ljava/util/List;
    //   88: invokestatic 469	com/e/a/d:G	(Ljava/util/List;)Ljava/util/List;
    //   91: iconst_0
    //   92: anewarray 158	java/lang/String
    //   95: invokeinterface 473 2 0
    //   100: checkcast 475	[Ljava/lang/String;
    //   103: invokevirtual 357	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore 5
    //   108: iconst_0
    //   109: istore_2
    //   110: aconst_null
    //   111: astore 7
    //   113: aconst_null
    //   114: astore 6
    //   116: aload 5
    //   118: invokeinterface 478 1 0
    //   123: ifeq +168 -> 291
    //   126: iload 4
    //   128: ifeq +81 -> 209
    //   131: aload 5
    //   133: invokestatic 480	com/e/a/c:c	(Landroid/database/Cursor;)Ljava/util/Map;
    //   136: astore 9
    //   138: aload_0
    //   139: getfield 100	com/e/a/a:azO	I
    //   142: ifle +62 -> 204
    //   145: iconst_1
    //   146: istore_3
    //   147: iload_3
    //   148: ifeq +9 -> 157
    //   151: aload 9
    //   153: invokestatic 421	com/e/a/c:toString	(Ljava/lang/Object;)Ljava/lang/String;
    //   156: pop
    //   157: aload 8
    //   159: aload 9
    //   161: invokeinterface 311 2 0
    //   166: pop
    //   167: goto -51 -> 116
    //   170: astore 6
    //   172: aload 6
    //   174: aload_1
    //   175: aload_0
    //   176: invokestatic 147	com/e/a/c:a	(Ljava/lang/Exception;Lcom/e/a/b/f;Lcom/e/a/a;)V
    //   179: aload 5
    //   181: ifnull +10 -> 191
    //   184: aload 5
    //   186: invokeinterface 374 1 0
    //   191: ldc_w 451
    //   194: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_0
    //   198: ireturn
    //   199: iconst_0
    //   200: istore_2
    //   201: goto -169 -> 32
    //   204: iconst_0
    //   205: istore_3
    //   206: goto -59 -> 147
    //   209: aload 6
    //   211: ifnonnull +182 -> 393
    //   214: new 263	java/util/ArrayList
    //   217: dup
    //   218: invokespecial 452	java/util/ArrayList:<init>	()V
    //   221: astore 7
    //   223: new 65	java/util/HashMap
    //   226: dup
    //   227: invokespecial 68	java/util/HashMap:<init>	()V
    //   230: astore 6
    //   232: aload 5
    //   234: invokeinterface 483 1 0
    //   239: istore_2
    //   240: aload 6
    //   242: ldc_w 485
    //   245: aload 5
    //   247: invokeinterface 381 1 0
    //   252: invokestatic 491	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   255: invokeinterface 385 3 0
    //   260: pop
    //   261: aload 6
    //   263: ldc_w 493
    //   266: aload 7
    //   268: invokeinterface 385 3 0
    //   273: pop
    //   274: aload 7
    //   276: aload 5
    //   278: iload_2
    //   279: invokestatic 495	com/e/a/c:b	(Landroid/database/Cursor;I)Ljava/util/List;
    //   282: invokeinterface 311 2 0
    //   287: pop
    //   288: goto -172 -> 116
    //   291: iload 4
    //   293: ifeq +31 -> 324
    //   296: aload_1
    //   297: aload 8
    //   299: invokeinterface 351 2 0
    //   304: aload 5
    //   306: ifnull +10 -> 316
    //   309: aload 5
    //   311: invokeinterface 374 1 0
    //   316: ldc_w 451
    //   319: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iconst_1
    //   323: ireturn
    //   324: aload 6
    //   326: astore 7
    //   328: aload 6
    //   330: ifnonnull +12 -> 342
    //   333: new 65	java/util/HashMap
    //   336: dup
    //   337: invokespecial 68	java/util/HashMap:<init>	()V
    //   340: astore 7
    //   342: aload_1
    //   343: aload 7
    //   345: invokeinterface 351 2 0
    //   350: goto -46 -> 304
    //   353: astore_0
    //   354: aload 5
    //   356: ifnull +10 -> 366
    //   359: aload 5
    //   361: invokeinterface 374 1 0
    //   366: ldc_w 451
    //   369: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload_0
    //   373: athrow
    //   374: astore_0
    //   375: aconst_null
    //   376: astore 5
    //   378: goto -24 -> 354
    //   381: astore_0
    //   382: goto -28 -> 354
    //   385: astore 6
    //   387: aconst_null
    //   388: astore 5
    //   390: goto -218 -> 172
    //   393: goto -119 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	parama	a
    //   0	396	1	paramf	f
    //   31	248	2	i	int
    //   146	60	3	j	int
    //   65	227	4	bool	boolean
    //   12	377	5	localObject1	Object
    //   114	1	6	localObject2	Object
    //   170	40	6	localException1	Exception
    //   230	99	6	localHashMap	HashMap
    //   385	1	6	localException2	Exception
    //   111	233	7	localObject3	Object
    //   21	277	8	localArrayList	ArrayList
    //   136	24	9	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   116	126	170	java/lang/Exception
    //   131	145	170	java/lang/Exception
    //   151	157	170	java/lang/Exception
    //   157	167	170	java/lang/Exception
    //   214	274	170	java/lang/Exception
    //   274	288	170	java/lang/Exception
    //   296	304	170	java/lang/Exception
    //   333	342	170	java/lang/Exception
    //   342	350	170	java/lang/Exception
    //   116	126	353	finally
    //   131	145	353	finally
    //   151	157	353	finally
    //   157	167	353	finally
    //   214	274	353	finally
    //   274	288	353	finally
    //   296	304	353	finally
    //   333	342	353	finally
    //   342	350	353	finally
    //   67	108	374	finally
    //   172	179	381	finally
    //   67	108	385	java/lang/Exception
  }
  
  private static boolean d(a parama, f paramf)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(153378);
    if (!a(parama, paramf))
    {
      AppMethodBeat.o(153378);
      return false;
    }
    if (paramf.AA())
    {
      paramf.ay(null);
      AppMethodBeat.o(153378);
      return true;
    }
    try
    {
      Cursor localCursor = parama.bYm.rawQuery("SELECT changes()", null);
      if (localCursor != null)
      {
        localObject1 = localCursor;
        localObject2 = localCursor;
        if (localCursor.getCount() > 0)
        {
          localObject1 = localCursor;
          localObject2 = localCursor;
          if (localCursor.moveToFirst())
          {
            localObject1 = localCursor;
            localObject2 = localCursor;
            paramf.ay(Integer.valueOf(localCursor.getInt(0)));
            return true;
          }
        }
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      paramf.ay(null);
      return true;
    }
    catch (Exception localException)
    {
      localObject2 = localObject1;
      a(localException, paramf, parama);
      return false;
    }
    finally
    {
      if (localObject2 != null) {
        localObject2.close();
      }
      AppMethodBeat.o(153378);
    }
  }
  
  static Map q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(153380);
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", Integer.valueOf(paramInt));
    if (paramBoolean) {
      localHashMap.put("recovered", Boolean.TRUE);
    }
    AppMethodBeat.o(153380);
    return localHashMap;
  }
  
  private static String toString(Object paramObject)
  {
    AppMethodBeat.i(153372);
    if (paramObject == null)
    {
      AppMethodBeat.o(153372);
      return null;
    }
    if ((paramObject instanceof byte[]))
    {
      ArrayList localArrayList = new ArrayList();
      paramObject = (byte[])paramObject;
      int j = paramObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramObject[i]));
        i += 1;
      }
      paramObject = localArrayList.toString();
      AppMethodBeat.o(153372);
      return paramObject;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = c((Map)paramObject).toString();
      AppMethodBeat.o(153372);
      return paramObject;
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(153372);
    return paramObject;
  }
  
  public final void a(final j paramj, k.d arg2)
  {
    AppMethodBeat.i(153382);
    ??? = paramj.method;
    int i = -1;
    switch (((String)???).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        ???.Av();
        AppMethodBeat.o(153382);
        return;
        if (((String)???).equals("getPlatformVersion"))
        {
          i = 0;
          continue;
          if (((String)???).equals("closeDatabase"))
          {
            i = 1;
            continue;
            if (((String)???).equals("query"))
            {
              i = 2;
              continue;
              if (((String)???).equals("insert"))
              {
                i = 3;
                continue;
                if (((String)???).equals("update"))
                {
                  i = 4;
                  continue;
                  if (((String)???).equals("execute"))
                  {
                    i = 5;
                    continue;
                    if (((String)???).equals("openDatabase"))
                    {
                      i = 6;
                      continue;
                      if (((String)???).equals("batch"))
                      {
                        i = 7;
                        continue;
                        if (((String)???).equals("options"))
                        {
                          i = 8;
                          continue;
                          if (((String)???).equals("getDatabasesPath"))
                          {
                            i = 9;
                            continue;
                            if (((String)???).equals("debug"))
                            {
                              i = 10;
                              continue;
                              if (((String)???).equals("debugMode")) {
                                i = 11;
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    ???.ay("Android " + Build.VERSION.RELEASE);
    AppMethodBeat.o(153382);
    return;
    final int j = ((Integer)paramj.qa("id")).intValue();
    paramj = b(paramj, ???);
    if (paramj != null)
    {
      if (paramj.azO <= 0) {
        break label598;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        new StringBuilder("[").append(Thread.currentThread()).append("] closing ").append(j).append(" ").append(paramj.path);
      }
      localObject2 = paramj.path;
      synchronized (this.bYr)
      {
        this.bYw.remove(Integer.valueOf(j));
        if (paramj.bYl) {
          bYo.remove(localObject2);
        }
        ??? = new a(???, (byte)0);
        this.handler.post(new Runnable()
        {
          /* Error */
          public final void run()
          {
            // Byte code:
            //   0: ldc 34
            //   2: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: aload_0
            //   6: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   9: invokestatic 44	com/e/a/c:a	(Lcom/e/a/c;)Ljava/lang/Object;
            //   12: astore_2
            //   13: aload_2
            //   14: monitorenter
            //   15: aload_0
            //   16: getfield 22	com/e/a/c$7:bYz	Lcom/e/a/a;
            //   19: getfield 50	com/e/a/a:bYm	Landroid/database/sqlite/SQLiteDatabase;
            //   22: invokevirtual 55	android/database/sqlite/SQLiteDatabase:close	()V
            //   25: aload_0
            //   26: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   29: invokestatic 58	com/e/a/c:b	(Lcom/e/a/c;)Ljava/lang/Object;
            //   32: astore_3
            //   33: aload_3
            //   34: monitorenter
            //   35: aload_0
            //   36: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   39: invokestatic 62	com/e/a/c:c	(Lcom/e/a/c;)Ljava/util/Map;
            //   42: invokeinterface 68 1 0
            //   47: ifeq +76 -> 123
            //   50: aload_0
            //   51: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   54: invokestatic 72	com/e/a/c:d	(Lcom/e/a/c;)Landroid/os/Handler;
            //   57: ifnull +66 -> 123
            //   60: aload_0
            //   61: getfield 22	com/e/a/c$7:bYz	Lcom/e/a/a;
            //   64: getfield 75	com/e/a/a:azO	I
            //   67: ifle +114 -> 181
            //   70: iconst_1
            //   71: istore_1
            //   72: iload_1
            //   73: ifeq +23 -> 96
            //   76: new 77	java/lang/StringBuilder
            //   79: dup
            //   80: ldc 79
            //   82: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   85: aload_0
            //   86: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   89: invokestatic 86	com/e/a/c:e	(Lcom/e/a/c;)Landroid/os/HandlerThread;
            //   92: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   95: pop
            //   96: aload_0
            //   97: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   100: invokestatic 86	com/e/a/c:e	(Lcom/e/a/c;)Landroid/os/HandlerThread;
            //   103: invokevirtual 95	android/os/HandlerThread:quit	()Z
            //   106: pop
            //   107: aload_0
            //   108: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   111: invokestatic 98	com/e/a/c:f	(Lcom/e/a/c;)Landroid/os/HandlerThread;
            //   114: pop
            //   115: aload_0
            //   116: getfield 20	com/e/a/c$7:bYA	Lcom/e/a/c;
            //   119: invokestatic 101	com/e/a/c:g	(Lcom/e/a/c;)Landroid/os/Handler;
            //   122: pop
            //   123: aload_3
            //   124: monitorexit
            //   125: aload_2
            //   126: monitorexit
            //   127: aload_0
            //   128: getfield 26	com/e/a/c$7:bYy	Lcom/e/a/c$a;
            //   131: aconst_null
            //   132: invokevirtual 107	com/e/a/c$a:ay	(Ljava/lang/Object;)V
            //   135: ldc 34
            //   137: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   140: return
            //   141: astore_3
            //   142: new 77	java/lang/StringBuilder
            //   145: dup
            //   146: ldc 112
            //   148: invokespecial 82	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   151: aload_3
            //   152: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
            //   155: ldc 114
            //   157: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   160: aload_0
            //   161: getfield 24	com/e/a/c$7:bYE	I
            //   164: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
            //   167: pop
            //   168: goto -143 -> 25
            //   171: astore_3
            //   172: aload_2
            //   173: monitorexit
            //   174: ldc 34
            //   176: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   179: aload_3
            //   180: athrow
            //   181: iconst_0
            //   182: istore_1
            //   183: goto -111 -> 72
            //   186: astore 4
            //   188: aload_3
            //   189: monitorexit
            //   190: ldc 34
            //   192: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   195: aload 4
            //   197: athrow
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	198	0	this	7
            //   71	112	1	i	int
            //   12	161	2	localObject1	Object
            //   141	11	3	localException	Exception
            //   171	18	3	localObject3	Object
            //   186	10	4	localObject4	Object
            // Exception table:
            //   from	to	target	type
            //   15	25	141	java/lang/Exception
            //   15	25	171	finally
            //   25	35	171	finally
            //   125	127	171	finally
            //   142	168	171	finally
            //   172	174	171	finally
            //   190	198	171	finally
            //   35	70	186	finally
            //   76	96	186	finally
            //   96	123	186	finally
            //   123	125	186	finally
            //   188	190	186	finally
          }
        });
        AppMethodBeat.o(153382);
        return;
        label598:
        i = 0;
      }
    }
    ??? = b(paramj, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153353);
          e locale = new e(paramj, paramd);
          c.e(this.bYz, locale);
          AppMethodBeat.o(153353);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = b(paramj, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153355);
          e locale = new e(paramj, paramd);
          c.g(this.bYz, locale);
          AppMethodBeat.o(153355);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = b(paramj, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153357);
          e locale = new e(paramj, paramd);
          c.h(this.bYz, locale);
          AppMethodBeat.o(153357);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = b(paramj, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153356);
          if (c.a(this.bYz, paramj, paramd) == null)
          {
            AppMethodBeat.o(153356);
            return;
          }
          paramd.ay(null);
          AppMethodBeat.o(153356);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = (String)paramj.qa("path");
    Object localObject2 = (Boolean)paramj.qa("readOnly");
    final boolean bool1;
    if ((??? == null) || (((String)???).equals(":memory:"))) {
      bool1 = true;
    }
    for (;;)
    {
      final boolean bool2;
      label886:
      Object localObject4;
      if ((!Boolean.FALSE.equals(paramj.qa("singleInstance"))) && (!bool1))
      {
        bool2 = true;
        if (bool2) {}
        synchronized (this.bYr)
        {
          if (b.gE(azO)) {
            new StringBuilder("Look for ").append((String)???).append(" in ").append(bYo.keySet());
          }
          localObject4 = (Integer)bYo.get(???);
          if (localObject4 != null)
          {
            a locala = (a)this.bYw.get(localObject4);
            if (locala != null)
            {
              if (locala.bYm.isOpen()) {
                break label1299;
              }
              if (b.gE(azO)) {
                new StringBuilder("[").append(Thread.currentThread()).append("] single instance database of ").append((String)???).append(" not opened");
              }
            }
          }
          synchronized (this.bYr)
          {
            j = this.bYu + 1;
            this.bYu = j;
            ??? = new a((String)???, j, bool2, azO);
            localObject4 = new a(???, (byte)0);
          }
        }
      }
      synchronized (this.bYr)
      {
        if (this.handler == null)
        {
          this.handlerThread = new HandlerThread("Sqflite", bYq);
          this.handlerThread.start();
          this.handler = new Handler(this.handlerThread.getLooper());
          if (((a)???).azO <= 0) {
            break label1395;
          }
        }
        label1299:
        label1395:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            new StringBuilder("starting thread").append(this.handlerThread).append(" priority ").append(bYq);
          }
          if (((a)???).azO <= 0) {
            break label1400;
          }
          i = 1;
          if (i != 0) {
            new StringBuilder("[").append(Thread.currentThread()).append("] opened ").append(j).append(" ").append((String)???);
          }
          this.handler.post(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: iconst_1
              //   1: istore_1
              //   2: ldc 53
              //   4: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   7: aload_0
              //   8: getfield 29	com/e/a/c$6:bYA	Lcom/e/a/c;
              //   11: invokestatic 63	com/e/a/c:a	(Lcom/e/a/c;)Ljava/lang/Object;
              //   14: astore_2
              //   15: aload_2
              //   16: monitorenter
              //   17: aload_0
              //   18: getfield 31	com/e/a/c$6:bYB	Z
              //   21: ifne +83 -> 104
              //   24: new 65	java/io/File
              //   27: dup
              //   28: new 65	java/io/File
              //   31: dup
              //   32: aload_0
              //   33: getfield 33	com/e/a/c$6:val$path	Ljava/lang/String;
              //   36: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
              //   39: invokevirtual 72	java/io/File:getParent	()Ljava/lang/String;
              //   42: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
              //   45: astore_3
              //   46: aload_3
              //   47: invokevirtual 76	java/io/File:exists	()Z
              //   50: ifne +54 -> 104
              //   53: aload_3
              //   54: invokevirtual 79	java/io/File:mkdirs	()Z
              //   57: ifne +47 -> 104
              //   60: aload_3
              //   61: invokevirtual 76	java/io/File:exists	()Z
              //   64: ifne +40 -> 104
              //   67: aload_0
              //   68: getfield 35	com/e/a/c$6:bYy	Lcom/e/a/c$a;
              //   71: ldc 81
              //   73: new 83	java/lang/StringBuilder
              //   76: dup
              //   77: ldc 85
              //   79: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   82: aload_0
              //   83: getfield 33	com/e/a/c$6:val$path	Ljava/lang/String;
              //   86: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   89: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   92: aconst_null
              //   93: invokevirtual 98	com/e/a/c$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
              //   96: aload_2
              //   97: monitorexit
              //   98: ldc 53
              //   100: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   103: return
              //   104: getstatic 106	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
              //   107: aload_0
              //   108: getfield 37	com/e/a/c$6:bYC	Ljava/lang/Boolean;
              //   111: invokevirtual 110	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
              //   114: ifeq +169 -> 283
              //   117: aload_0
              //   118: getfield 39	com/e/a/c$6:bYz	Lcom/e/a/a;
              //   121: astore_3
              //   122: aload_3
              //   123: aload_3
              //   124: getfield 115	com/e/a/a:path	Ljava/lang/String;
              //   127: aconst_null
              //   128: iconst_1
              //   129: new 117	com/e/a/a$1
              //   132: dup
              //   133: aload_3
              //   134: invokespecial 120	com/e/a/a$1:<init>	(Lcom/e/a/a;)V
              //   137: invokestatic 126	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;ILandroid/database/DatabaseErrorHandler;)Landroid/database/sqlite/SQLiteDatabase;
              //   140: putfield 130	com/e/a/a:bYm	Landroid/database/sqlite/SQLiteDatabase;
              //   143: aload_0
              //   144: getfield 29	com/e/a/c$6:bYA	Lcom/e/a/c;
              //   147: invokestatic 133	com/e/a/c:b	(Lcom/e/a/c;)Ljava/lang/Object;
              //   150: astore_3
              //   151: aload_3
              //   152: monitorenter
              //   153: aload_0
              //   154: getfield 43	com/e/a/c$6:bYD	Z
              //   157: ifeq +23 -> 180
              //   160: getstatic 137	com/e/a/c:bYo	Ljava/util/Map;
              //   163: aload_0
              //   164: getfield 33	com/e/a/c$6:val$path	Ljava/lang/String;
              //   167: aload_0
              //   168: getfield 45	com/e/a/c$6:bYE	I
              //   171: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   174: invokeinterface 149 3 0
              //   179: pop
              //   180: aload_0
              //   181: getfield 29	com/e/a/c$6:bYA	Lcom/e/a/c;
              //   184: invokestatic 153	com/e/a/c:c	(Lcom/e/a/c;)Ljava/util/Map;
              //   187: aload_0
              //   188: getfield 45	com/e/a/c$6:bYE	I
              //   191: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   194: aload_0
              //   195: getfield 39	com/e/a/c$6:bYz	Lcom/e/a/a;
              //   198: invokeinterface 149 3 0
              //   203: pop
              //   204: aload_3
              //   205: monitorexit
              //   206: aload_0
              //   207: getfield 39	com/e/a/c$6:bYz	Lcom/e/a/a;
              //   210: getfield 156	com/e/a/a:azO	I
              //   213: ifle +146 -> 359
              //   216: iload_1
              //   217: ifeq +43 -> 260
              //   220: new 83	java/lang/StringBuilder
              //   223: dup
              //   224: ldc 158
              //   226: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   229: invokestatic 164	java/lang/Thread:currentThread	()Ljava/lang/Thread;
              //   232: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
              //   235: ldc 169
              //   237: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   240: aload_0
              //   241: getfield 45	com/e/a/c$6:bYE	I
              //   244: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
              //   247: ldc 174
              //   249: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   252: aload_0
              //   253: getfield 33	com/e/a/c$6:val$path	Ljava/lang/String;
              //   256: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   259: pop
              //   260: aload_2
              //   261: monitorexit
              //   262: aload_0
              //   263: getfield 35	com/e/a/c$6:bYy	Lcom/e/a/c$a;
              //   266: aload_0
              //   267: getfield 45	com/e/a/c$6:bYE	I
              //   270: iconst_0
              //   271: invokestatic 178	com/e/a/c:q	(IZ)Ljava/util/Map;
              //   274: invokevirtual 182	com/e/a/c$a:ay	(Ljava/lang/Object;)V
              //   277: ldc 53
              //   279: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   282: return
              //   283: aload_0
              //   284: getfield 39	com/e/a/c$6:bYz	Lcom/e/a/a;
              //   287: astore_3
              //   288: aload_3
              //   289: aload_3
              //   290: getfield 115	com/e/a/a:path	Ljava/lang/String;
              //   293: aconst_null
              //   294: ldc 183
              //   296: invokestatic 186	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
              //   299: putfield 130	com/e/a/a:bYm	Landroid/database/sqlite/SQLiteDatabase;
              //   302: goto -159 -> 143
              //   305: astore_3
              //   306: aload_3
              //   307: new 188	com/e/a/b/e
              //   310: dup
              //   311: aload_0
              //   312: getfield 41	com/e/a/c$6:bYx	Lio/flutter/a/a/j;
              //   315: aload_0
              //   316: getfield 35	com/e/a/c$6:bYy	Lcom/e/a/c$a;
              //   319: invokespecial 191	com/e/a/b/e:<init>	(Lio/flutter/a/a/j;Lio/flutter/a/a/k$d;)V
              //   322: aload_0
              //   323: getfield 39	com/e/a/c$6:bYz	Lcom/e/a/a;
              //   326: invokestatic 194	com/e/a/c:b	(Ljava/lang/Exception;Lcom/e/a/b/f;Lcom/e/a/a;)V
              //   329: aload_2
              //   330: monitorexit
              //   331: ldc 53
              //   333: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   336: return
              //   337: astore 4
              //   339: aload_3
              //   340: monitorexit
              //   341: ldc 53
              //   343: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   346: aload 4
              //   348: athrow
              //   349: astore_3
              //   350: aload_2
              //   351: monitorexit
              //   352: ldc 53
              //   354: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   357: aload_3
              //   358: athrow
              //   359: iconst_0
              //   360: istore_1
              //   361: goto -145 -> 216
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	364	0	this	6
              //   1	360	1	i	int
              //   14	337	2	localObject1	Object
              //   305	35	3	localException	Exception
              //   349	9	3	localObject3	Object
              //   337	10	4	localObject4	Object
              // Exception table:
              //   from	to	target	type
              //   104	143	305	java/lang/Exception
              //   283	302	305	java/lang/Exception
              //   153	180	337	finally
              //   180	206	337	finally
              //   339	341	337	finally
              //   17	98	349	finally
              //   104	143	349	finally
              //   143	153	349	finally
              //   206	216	349	finally
              //   220	260	349	finally
              //   260	262	349	finally
              //   283	302	349	finally
              //   306	331	349	finally
              //   341	349	349	finally
              //   350	352	349	finally
            }
          });
          AppMethodBeat.o(153382);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label886;
          if (b.gE(azO)) {
            new StringBuilder("[").append(Thread.currentThread()).append("] re-opened single instance ").append(localObject4).append(" ").append((String)???);
          }
          ???.ay(q(((Integer)localObject4).intValue(), true));
          AppMethodBeat.o(153382);
          return;
          paramj = finally;
          AppMethodBeat.o(153382);
          throw paramj;
          paramj = finally;
          AppMethodBeat.o(153382);
          throw paramj;
        }
        label1400:
        i = 0;
      }
    }
    ??? = b(paramj, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153354);
          Object localObject1 = new e(paramj, paramd);
          boolean bool1 = ((e)localObject1).AA();
          boolean bool2 = Boolean.TRUE.equals(((com.e.a.b.b)localObject1).bK("continueOnError"));
          Object localObject2 = (List)paramj.qa("operations");
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            com.e.a.b.c localc = new com.e.a.b.c((Map)((Iterator)localObject2).next(), bool1);
            String str = (String)localc.map.get("method");
            int i = -1;
            switch (str.hashCode())
            {
            }
            for (;;)
            {
              switch (i)
              {
              default: 
                paramd.a("bad_param", "Batch method '" + str + "' not supported", null);
                AppMethodBeat.o(153354);
                return;
                if (str.equals("execute"))
                {
                  i = 0;
                  continue;
                  if (str.equals("insert"))
                  {
                    i = 1;
                    continue;
                    if (str.equals("query"))
                    {
                      i = 2;
                      continue;
                      if (str.equals("update")) {
                        i = 3;
                      }
                    }
                  }
                }
                break;
              }
            }
            if (c.f(this.bYz, localc))
            {
              localc.H((List)localObject1);
            }
            else if (bool2)
            {
              localc.I((List)localObject1);
            }
            else
            {
              localc.a(paramd);
              AppMethodBeat.o(153354);
              return;
              if (c.g(this.bYz, localc))
              {
                localc.H((List)localObject1);
              }
              else if (bool2)
              {
                localc.I((List)localObject1);
              }
              else
              {
                localc.a(paramd);
                AppMethodBeat.o(153354);
                return;
                if (c.e(this.bYz, localc))
                {
                  localc.H((List)localObject1);
                }
                else if (bool2)
                {
                  localc.I((List)localObject1);
                }
                else
                {
                  localc.a(paramd);
                  AppMethodBeat.o(153354);
                  return;
                  if (c.h(this.bYz, localc))
                  {
                    localc.H((List)localObject1);
                  }
                  else if (bool2)
                  {
                    localc.I((List)localObject1);
                  }
                  else
                  {
                    localc.a(paramd);
                    AppMethodBeat.o(153354);
                    return;
                  }
                }
              }
            }
          }
          if (bool1)
          {
            paramd.ay(null);
            AppMethodBeat.o(153354);
            return;
          }
          paramd.ay(localObject1);
          AppMethodBeat.o(153354);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = paramj.qa("queryAsMapList");
    if (??? != null) {
      bYp = Boolean.TRUE.equals(???);
    }
    ??? = paramj.qa("androidThreadPriority");
    if (??? != null) {
      bYq = ((Integer)???).intValue();
    }
    paramj = (Integer)paramj.qa("logLevel");
    if (paramj != null) {
      azO = paramj.intValue();
    }
    ???.ay(null);
    AppMethodBeat.o(153382);
    return;
    if (this.bYt == null) {
      this.bYt = this.context.getDatabasePath("tekartik_sqflite.db").getParent();
    }
    ???.ay(this.bYt);
    AppMethodBeat.o(153382);
    return;
    c(paramj, ???);
    AppMethodBeat.o(153382);
    return;
    paramj = paramj.fTP;
    com.e.a.a.a.LOGV = Boolean.TRUE.equals(paramj);
    if ((com.e.a.a.a.bYM) && (com.e.a.a.a.LOGV))
    {
      bool1 = true;
      com.e.a.a.a.bYN = bool1;
      if (!com.e.a.a.a.LOGV) {
        break label1691;
      }
      if (!com.e.a.a.a.bYN) {
        break label1678;
      }
      azO = 2;
    }
    for (;;)
    {
      ???.ay(null);
      AppMethodBeat.o(153382);
      return;
      bool1 = false;
      break;
      label1678:
      if (com.e.a.a.a.LOGV)
      {
        azO = 1;
        continue;
        label1691:
        azO = 0;
      }
    }
  }
  
  final class a
    implements k.d
  {
    final k.d bYF;
    final Handler handler;
    
    private a(k.d paramd)
    {
      AppMethodBeat.i(153363);
      this.handler = new Handler();
      this.bYF = paramd;
      AppMethodBeat.o(153363);
    }
    
    public final void Av()
    {
      AppMethodBeat.i(153366);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153362);
          c.a.this.bYF.Av();
          AppMethodBeat.o(153362);
        }
      });
      AppMethodBeat.o(153366);
    }
    
    public final void a(final String paramString1, final String paramString2, final Object paramObject)
    {
      AppMethodBeat.i(153365);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153361);
          c.a.this.bYF.a(paramString1, paramString2, paramObject);
          AppMethodBeat.o(153361);
        }
      });
      AppMethodBeat.o(153365);
    }
    
    public final void ay(final Object paramObject)
    {
      AppMethodBeat.i(153364);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153360);
          c.a.this.bYF.ay(paramObject);
          AppMethodBeat.o(153360);
        }
      });
      AppMethodBeat.o(153364);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.e.a.c
 * JD-Core Version:    0.7.0.1
 */