package com.i.a;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.i.a.b.e;
import com.i.a.b.f;
import com.i.a.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  static final Map<String, Integer> ecH;
  private static boolean ecI;
  private static int ecJ;
  private static final Object ecK;
  private static final Object ecL;
  static String ecM;
  private static int ecN;
  static final Map<Integer, a> ecO;
  private static Handler handler;
  private static HandlerThread handlerThread;
  static int logLevel;
  private Context context;
  private MethodChannel methodChannel;
  
  static
  {
    AppMethodBeat.i(153389);
    ecH = new HashMap();
    ecI = false;
    ecJ = 0;
    logLevel = 0;
    ecK = new Object();
    ecL = new Object();
    ecN = 0;
    ecO = new HashMap();
    AppMethodBeat.o(153389);
  }
  
  private static a a(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(153373);
    int i = ((Integer)paramMethodCall.argument("id")).intValue();
    paramMethodCall = (a)ecO.get(Integer.valueOf(i));
    if (paramMethodCall != null)
    {
      AppMethodBeat.o(153373);
      return paramMethodCall;
    }
    paramResult.error("sqlite_error", "database_closed ".concat(String.valueOf(i)), null);
    AppMethodBeat.o(153373);
    return null;
  }
  
  private static void a(Exception paramException, f paramf, a parama)
  {
    AppMethodBeat.i(153379);
    if ((paramException instanceof SQLiteCantOpenDatabaseException))
    {
      paramf.error("sqlite_error", "open_failed " + parama.path, null);
      AppMethodBeat.o(153379);
      return;
    }
    if ((paramException instanceof SQLException))
    {
      paramf.error("sqlite_error", paramException.getMessage(), h.a(paramf));
      AppMethodBeat.o(153379);
      return;
    }
    paramf.error("sqlite_error", paramException.getMessage(), h.a(paramf));
    AppMethodBeat.o(153379);
  }
  
  private static boolean a(a parama, f paramf)
  {
    AppMethodBeat.i(153374);
    d locald = paramf.alx();
    if (parama.logLevel > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        new StringBuilder().append(parama.alt()).append(locald);
      }
      Boolean localBoolean = paramf.aly();
      try
      {
        parama.ecE.execSQL(locald.sql, d.aV(locald.ede));
        if (Boolean.TRUE.equals(localBoolean)) {
          parama.ecF = true;
        }
        return true;
      }
      catch (Exception localException)
      {
        a(localException, paramf, parama);
        return false;
      }
      finally
      {
        if (!Boolean.FALSE.equals(localBoolean)) {
          break;
        }
        parama.ecF = false;
        AppMethodBeat.o(153374);
      }
    }
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
        if (com.i.a.a.a.edh)
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
  
  static Map b(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(207506);
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", Integer.valueOf(paramInt));
    if (paramBoolean1) {
      localHashMap.put("recovered", Boolean.TRUE);
    }
    if (paramBoolean2) {
      localHashMap.put("recoveredInTransaction", Boolean.TRUE);
    }
    AppMethodBeat.o(207506);
    return localHashMap;
  }
  
  private static void b(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(153381);
    Object localObject = (String)paramMethodCall.argument("cmd");
    paramMethodCall = new HashMap();
    if ("get".equals(localObject))
    {
      if (logLevel > 0) {
        paramMethodCall.put("logLevel", Integer.valueOf(logLevel));
      }
      if (!ecO.isEmpty())
      {
        localObject = new HashMap();
        Iterator localIterator = ecO.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          a locala = (a)localEntry.getValue();
          HashMap localHashMap = new HashMap();
          localHashMap.put("path", locala.path);
          localHashMap.put("singleInstance", Boolean.valueOf(locala.ecD));
          if (locala.logLevel > 0) {
            localHashMap.put("logLevel", Integer.valueOf(locala.logLevel));
          }
          ((Map)localObject).put(((Integer)localEntry.getKey()).toString(), localHashMap);
        }
        paramMethodCall.put("databases", localObject);
      }
    }
    paramResult.success(paramMethodCall);
    AppMethodBeat.o(153381);
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
    if (paramf.alz())
    {
      paramf.success(null);
      AppMethodBeat.o(153376);
      return true;
    }
    try
    {
      Cursor localCursor = parama.ecE.rawQuery("SELECT changes(), last_insert_rowid()", null);
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
              if (parama.logLevel > 0) {}
              for (i = 1;; i = 0)
              {
                if (i != 0)
                {
                  localObject1 = localCursor;
                  localObject2 = localCursor;
                  new StringBuilder().append(parama.alt()).append("no changes (id was ").append(localCursor.getLong(1)).append(")");
                }
                localObject1 = localCursor;
                localObject2 = localCursor;
                paramf.success(null);
                return true;
              }
            }
            localObject1 = localCursor;
            localObject2 = localCursor;
            long l = localCursor.getLong(1);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (parama.logLevel > 0) {}
            for (int i = 1;; i = 0)
            {
              if (i != 0)
              {
                localObject1 = localCursor;
                localObject2 = localCursor;
                new StringBuilder().append(parama.alt()).append("inserted ").append(l);
              }
              localObject1 = localCursor;
              localObject2 = localCursor;
              paramf.success(Long.valueOf(l));
              return true;
            }
          }
        }
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      new StringBuilder().append(parama.alt()).append("fail to read changes for Insert");
      localObject1 = localCursor;
      localObject2 = localCursor;
      paramf.success(null);
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
  
  /* Error */
  private static boolean c(a parama, f paramf)
  {
    // Byte code:
    //   0: ldc_w 464
    //   3: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokeinterface 249 1 0
    //   12: astore 5
    //   14: new 296	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 465	java/util/ArrayList:<init>	()V
    //   21: astore 8
    //   23: aload_0
    //   24: getfield 169	com/i/a/a:logLevel	I
    //   27: ifle +183 -> 210
    //   30: iconst_1
    //   31: istore_2
    //   32: iload_2
    //   33: ifeq +23 -> 56
    //   36: new 171	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   43: aload_0
    //   44: invokevirtual 176	com/i/a/a:alt	()Ljava/lang/String;
    //   47: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload 5
    //   52: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: getstatic 75	com/i/a/c:ecI	Z
    //   59: istore 4
    //   61: aload 5
    //   63: invokevirtual 468	com/i/a/d:alv	()Lcom/i/a/d;
    //   66: astore 5
    //   68: aload_0
    //   69: getfield 191	com/i/a/a:ecE	Landroid/database/sqlite/SQLiteDatabase;
    //   72: aload 5
    //   74: getfield 255	com/i/a/d:sql	Ljava/lang/String;
    //   77: aload 5
    //   79: getfield 259	com/i/a/d:ede	Ljava/util/List;
    //   82: invokestatic 472	com/i/a/d:aW	(Ljava/util/List;)Ljava/util/List;
    //   85: iconst_0
    //   86: anewarray 108	java/lang/String
    //   89: invokeinterface 476 2 0
    //   94: checkcast 478	[Ljava/lang/String;
    //   97: invokevirtual 439	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore 5
    //   102: iconst_0
    //   103: istore_2
    //   104: aconst_null
    //   105: astore 7
    //   107: aconst_null
    //   108: astore 6
    //   110: aload 5
    //   112: invokeinterface 481 1 0
    //   117: ifeq +185 -> 302
    //   120: iload 4
    //   122: ifeq +98 -> 220
    //   125: aload 5
    //   127: invokestatic 485	com/i/a/c:e	(Landroid/database/Cursor;)Ljava/util/Map;
    //   130: astore 9
    //   132: aload_0
    //   133: getfield 169	com/i/a/a:logLevel	I
    //   136: ifle +79 -> 215
    //   139: iconst_1
    //   140: istore_3
    //   141: iload_3
    //   142: ifeq +26 -> 168
    //   145: new 171	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   152: aload_0
    //   153: invokevirtual 176	com/i/a/a:alt	()Ljava/lang/String;
    //   156: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload 9
    //   161: invokestatic 489	com/i/a/c:ca	(Ljava/lang/Object;)Ljava/lang/String;
    //   164: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 8
    //   170: aload 9
    //   172: invokeinterface 339 2 0
    //   177: pop
    //   178: goto -68 -> 110
    //   181: astore 6
    //   183: aload 6
    //   185: aload_1
    //   186: aload_0
    //   187: invokestatic 283	com/i/a/c:a	(Ljava/lang/Exception;Lcom/i/a/b/f;Lcom/i/a/a;)V
    //   190: aload 5
    //   192: ifnull +10 -> 202
    //   195: aload 5
    //   197: invokeinterface 454 1 0
    //   202: ldc_w 464
    //   205: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: iconst_0
    //   209: ireturn
    //   210: iconst_0
    //   211: istore_2
    //   212: goto -180 -> 32
    //   215: iconst_0
    //   216: istore_3
    //   217: goto -76 -> 141
    //   220: aload 6
    //   222: ifnonnull +182 -> 404
    //   225: new 296	java/util/ArrayList
    //   228: dup
    //   229: invokespecial 465	java/util/ArrayList:<init>	()V
    //   232: astore 7
    //   234: new 68	java/util/HashMap
    //   237: dup
    //   238: invokespecial 71	java/util/HashMap:<init>	()V
    //   241: astore 6
    //   243: aload 5
    //   245: invokeinterface 492 1 0
    //   250: istore_2
    //   251: aload 6
    //   253: ldc_w 494
    //   256: aload 5
    //   258: invokeinterface 498 1 0
    //   263: invokestatic 504	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   266: invokeinterface 374 3 0
    //   271: pop
    //   272: aload 6
    //   274: ldc_w 506
    //   277: aload 7
    //   279: invokeinterface 374 3 0
    //   284: pop
    //   285: aload 7
    //   287: aload 5
    //   289: iload_2
    //   290: invokestatic 508	com/i/a/c:b	(Landroid/database/Cursor;I)Ljava/util/List;
    //   293: invokeinterface 339 2 0
    //   298: pop
    //   299: goto -189 -> 110
    //   302: iload 4
    //   304: ifeq +31 -> 335
    //   307: aload_1
    //   308: aload 8
    //   310: invokeinterface 433 2 0
    //   315: aload 5
    //   317: ifnull +10 -> 327
    //   320: aload 5
    //   322: invokeinterface 454 1 0
    //   327: ldc_w 464
    //   330: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: iconst_1
    //   334: ireturn
    //   335: aload 6
    //   337: astore 7
    //   339: aload 6
    //   341: ifnonnull +12 -> 353
    //   344: new 68	java/util/HashMap
    //   347: dup
    //   348: invokespecial 71	java/util/HashMap:<init>	()V
    //   351: astore 7
    //   353: aload_1
    //   354: aload 7
    //   356: invokeinterface 433 2 0
    //   361: goto -46 -> 315
    //   364: astore_0
    //   365: aload 5
    //   367: ifnull +10 -> 377
    //   370: aload 5
    //   372: invokeinterface 454 1 0
    //   377: ldc_w 464
    //   380: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   383: aload_0
    //   384: athrow
    //   385: astore_0
    //   386: aconst_null
    //   387: astore 5
    //   389: goto -24 -> 365
    //   392: astore_0
    //   393: goto -28 -> 365
    //   396: astore 6
    //   398: aconst_null
    //   399: astore 5
    //   401: goto -218 -> 183
    //   404: goto -119 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	parama	a
    //   0	407	1	paramf	f
    //   31	259	2	i	int
    //   140	77	3	j	int
    //   59	244	4	bool	boolean
    //   12	388	5	localObject1	Object
    //   108	1	6	localObject2	Object
    //   181	40	6	localException1	Exception
    //   241	99	6	localHashMap	HashMap
    //   396	1	6	localException2	Exception
    //   105	250	7	localObject3	Object
    //   21	288	8	localArrayList	ArrayList
    //   130	41	9	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   110	120	181	java/lang/Exception
    //   125	139	181	java/lang/Exception
    //   145	168	181	java/lang/Exception
    //   168	178	181	java/lang/Exception
    //   225	285	181	java/lang/Exception
    //   285	299	181	java/lang/Exception
    //   307	315	181	java/lang/Exception
    //   344	353	181	java/lang/Exception
    //   353	361	181	java/lang/Exception
    //   110	120	364	finally
    //   125	139	364	finally
    //   145	168	364	finally
    //   168	178	364	finally
    //   225	285	364	finally
    //   285	299	364	finally
    //   307	315	364	finally
    //   344	353	364	finally
    //   353	361	364	finally
    //   61	102	385	finally
    //   183	190	392	finally
    //   61	102	396	java/lang/Exception
  }
  
  private static String ca(Object paramObject)
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
      paramObject = h((Map)paramObject).toString();
      AppMethodBeat.o(153372);
      return paramObject;
    }
    paramObject = paramObject.toString();
    AppMethodBeat.o(153372);
    return paramObject;
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
    if (paramf.alz())
    {
      paramf.success(null);
      AppMethodBeat.o(153378);
      return true;
    }
    try
    {
      Cursor localCursor = parama.ecE.rawQuery("SELECT changes()", null);
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
            int j = localCursor.getInt(0);
            localObject1 = localCursor;
            localObject2 = localCursor;
            if (parama.logLevel > 0) {}
            for (int i = 1;; i = 0)
            {
              if (i != 0)
              {
                localObject1 = localCursor;
                localObject2 = localCursor;
                new StringBuilder().append(parama.alt()).append("changed ").append(j);
              }
              localObject1 = localCursor;
              localObject2 = localCursor;
              paramf.success(Integer.valueOf(j));
              return true;
            }
          }
        }
      }
      localObject1 = localCursor;
      localObject2 = localCursor;
      new StringBuilder().append(parama.alt()).append("fail to read changes for Update/Delete");
      localObject1 = localCursor;
      localObject2 = localCursor;
      paramf.success(null);
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
  
  private static Map<String, Object> e(Cursor paramCursor)
  {
    AppMethodBeat.i(153370);
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramCursor.getColumnNames();
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      if (com.i.a.a.a.edh) {
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
  
  private static Map<String, Object> h(Map<Object, Object> paramMap)
  {
    AppMethodBeat.i(153371);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap = localEntry.getValue();
      if ((paramMap instanceof Map)) {}
      for (paramMap = h((Map)paramMap);; paramMap = ca(paramMap))
      {
        localHashMap.put(ca(localEntry.getKey()), paramMap);
        break;
      }
    }
    AppMethodBeat.o(153371);
    return localHashMap;
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(207611);
    Context localContext = paramFlutterPluginBinding.getApplicationContext();
    paramFlutterPluginBinding = paramFlutterPluginBinding.getBinaryMessenger();
    this.context = localContext;
    this.methodChannel = new MethodChannel(paramFlutterPluginBinding, "com.tekartik.sqflite");
    this.methodChannel.setMethodCallHandler(this);
    AppMethodBeat.o(207611);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(207615);
    this.context = null;
    this.methodChannel.setMethodCallHandler(null);
    this.methodChannel = null;
    AppMethodBeat.o(207615);
  }
  
  public final void onMethodCall(final MethodCall paramMethodCall, MethodChannel.Result arg2)
  {
    AppMethodBeat.i(153382);
    ??? = paramMethodCall.method;
    int i = -1;
    switch (((String)???).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        ???.notImplemented();
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
                            if (((String)???).equals("deleteDatabase"))
                            {
                              i = 10;
                              continue;
                              if (((String)???).equals("debug"))
                              {
                                i = 11;
                                continue;
                                if (((String)???).equals("debugMode")) {
                                  i = 12;
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
        }
        break;
      }
    }
    ???.success("Android " + Build.VERSION.RELEASE);
    AppMethodBeat.o(153382);
    return;
    final int j = ((Integer)paramMethodCall.argument("id")).intValue();
    paramMethodCall = a(paramMethodCall, ???);
    if (paramMethodCall != null)
    {
      if (paramMethodCall.logLevel <= 0) {
        break label620;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        new StringBuilder().append(paramMethodCall.alt()).append("closing ").append(j).append(" ").append(paramMethodCall.path);
      }
      ??? = paramMethodCall.path;
      synchronized (ecK)
      {
        ecO.remove(Integer.valueOf(j));
        if (paramMethodCall.ecD) {
          ecH.remove(???);
        }
        ??? = new a(???, (byte)0);
        handler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(153359);
            synchronized (c.ecL)
            {
              c.a(paramMethodCall);
              paramResult.success(null);
              AppMethodBeat.o(153359);
              return;
            }
          }
        });
        AppMethodBeat.o(153382);
        return;
        label620:
        i = 0;
      }
    }
    ??? = a(paramMethodCall, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153353);
          e locale = new e(paramMethodCall, paramResult);
          c.e(this.ecR, locale);
          AppMethodBeat.o(153353);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = a(paramMethodCall, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153355);
          e locale = new e(paramMethodCall, paramResult);
          c.a(c.this, this.ecR, locale);
          AppMethodBeat.o(153355);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = a(paramMethodCall, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153357);
          e locale = new e(paramMethodCall, paramResult);
          c.b(c.this, this.ecR, locale);
          AppMethodBeat.o(153357);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = a(paramMethodCall, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153356);
          if (c.a(this.ecR, paramMethodCall, paramResult) == null)
          {
            AppMethodBeat.o(153356);
            return;
          }
          paramResult.success(null);
          AppMethodBeat.o(153356);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = (String)paramMethodCall.argument("path");
    ??? = (Boolean)paramMethodCall.argument("readOnly");
    final boolean bool1;
    if ((??? == null) || (((String)???).equals(":memory:"))) {
      bool1 = true;
    }
    label900:
    Object localObject4;
    Object localObject5;
    for (;;)
    {
      final boolean bool2;
      if ((!Boolean.FALSE.equals(paramMethodCall.argument("singleInstance"))) && (!bool1))
      {
        bool2 = true;
        if (bool2) {}
        synchronized (ecK)
        {
          if (b.mb(logLevel)) {
            new StringBuilder("Look for ").append((String)???).append(" in ").append(ecH.keySet());
          }
          localObject4 = (Integer)ecH.get(???);
          if (localObject4 != null)
          {
            localObject5 = (a)ecO.get(localObject4);
            if (localObject5 != null)
            {
              if (((a)localObject5).ecE.isOpen()) {
                break label1314;
              }
              if (b.mb(logLevel)) {
                new StringBuilder().append(((a)localObject5).alt()).append("single instance database of ").append((String)???).append(" not opened");
              }
            }
          }
          synchronized (ecK)
          {
            j = ecN + 1;
            ecN = j;
            ??? = new a((String)???, j, bool2, logLevel);
            localObject4 = new a(???, (byte)0);
          }
        }
      }
      synchronized (ecK)
      {
        if (handler == null)
        {
          localObject5 = new HandlerThread("Sqflite", ecJ);
          handlerThread = (HandlerThread)localObject5;
          ((HandlerThread)localObject5).start();
          handler = new Handler(handlerThread.getLooper());
          if (((a)???).logLevel <= 0) {
            break label1442;
          }
        }
        label1314:
        label1442:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            new StringBuilder().append(((a)???).alt()).append("starting thread").append(handlerThread).append(" priority ").append(ecJ);
          }
          if (((a)???).logLevel <= 0) {
            break label1447;
          }
          i = 1;
          if (i != 0) {
            new StringBuilder().append(((a)???).alt()).append("opened ").append(j).append(" ").append((String)???);
          }
          handler.post(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: iconst_1
              //   1: istore_1
              //   2: ldc 53
              //   4: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   7: invokestatic 63	com/i/a/c:access$600	()Ljava/lang/Object;
              //   10: astore_2
              //   11: aload_2
              //   12: monitorenter
              //   13: aload_0
              //   14: getfield 31	com/i/a/c$6:ecT	Z
              //   17: ifne +83 -> 100
              //   20: new 65	java/io/File
              //   23: dup
              //   24: new 65	java/io/File
              //   27: dup
              //   28: aload_0
              //   29: getfield 33	com/i/a/c$6:val$path	Ljava/lang/String;
              //   32: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
              //   35: invokevirtual 72	java/io/File:getParent	()Ljava/lang/String;
              //   38: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
              //   41: astore_3
              //   42: aload_3
              //   43: invokevirtual 76	java/io/File:exists	()Z
              //   46: ifne +54 -> 100
              //   49: aload_3
              //   50: invokevirtual 79	java/io/File:mkdirs	()Z
              //   53: ifne +47 -> 100
              //   56: aload_3
              //   57: invokevirtual 76	java/io/File:exists	()Z
              //   60: ifne +40 -> 100
              //   63: aload_0
              //   64: getfield 35	com/i/a/c$6:ecQ	Lcom/i/a/c$a;
              //   67: ldc 81
              //   69: new 83	java/lang/StringBuilder
              //   72: dup
              //   73: ldc 85
              //   75: invokespecial 86	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
              //   78: aload_0
              //   79: getfield 33	com/i/a/c$6:val$path	Ljava/lang/String;
              //   82: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   85: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
              //   88: aconst_null
              //   89: invokevirtual 99	com/i/a/c$a:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
              //   92: aload_2
              //   93: monitorexit
              //   94: ldc 53
              //   96: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   99: return
              //   100: getstatic 107	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
              //   103: aload_0
              //   104: getfield 37	com/i/a/c$6:ecU	Ljava/lang/Boolean;
              //   107: invokevirtual 111	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
              //   110: ifeq +164 -> 274
              //   113: aload_0
              //   114: getfield 39	com/i/a/c$6:ecR	Lcom/i/a/a;
              //   117: astore_3
              //   118: aload_3
              //   119: aload_3
              //   120: getfield 116	com/i/a/a:path	Ljava/lang/String;
              //   123: aconst_null
              //   124: iconst_1
              //   125: new 118	com/i/a/a$1
              //   128: dup
              //   129: aload_3
              //   130: invokespecial 121	com/i/a/a$1:<init>	(Lcom/i/a/a;)V
              //   133: invokestatic 127	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;ILandroid/database/DatabaseErrorHandler;)Landroid/database/sqlite/SQLiteDatabase;
              //   136: putfield 131	com/i/a/a:ecE	Landroid/database/sqlite/SQLiteDatabase;
              //   139: invokestatic 134	com/i/a/c:access$800	()Ljava/lang/Object;
              //   142: astore_3
              //   143: aload_3
              //   144: monitorenter
              //   145: aload_0
              //   146: getfield 43	com/i/a/c$6:ecV	Z
              //   149: ifeq +23 -> 172
              //   152: getstatic 138	com/i/a/c:ecH	Ljava/util/Map;
              //   155: aload_0
              //   156: getfield 33	com/i/a/c$6:val$path	Ljava/lang/String;
              //   159: aload_0
              //   160: getfield 45	com/i/a/c$6:ecW	I
              //   163: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   166: invokeinterface 150 3 0
              //   171: pop
              //   172: getstatic 153	com/i/a/c:ecO	Ljava/util/Map;
              //   175: aload_0
              //   176: getfield 45	com/i/a/c$6:ecW	I
              //   179: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
              //   182: aload_0
              //   183: getfield 39	com/i/a/c$6:ecR	Lcom/i/a/a;
              //   186: invokeinterface 150 3 0
              //   191: pop
              //   192: aload_3
              //   193: monitorexit
              //   194: aload_0
              //   195: getfield 39	com/i/a/c$6:ecR	Lcom/i/a/a;
              //   198: getfield 156	com/i/a/a:logLevel	I
              //   201: ifle +149 -> 350
              //   204: iload_1
              //   205: ifeq +45 -> 250
              //   208: new 83	java/lang/StringBuilder
              //   211: dup
              //   212: invokespecial 157	java/lang/StringBuilder:<init>	()V
              //   215: aload_0
              //   216: getfield 39	com/i/a/c$6:ecR	Lcom/i/a/a;
              //   219: invokevirtual 160	com/i/a/a:alt	()Ljava/lang/String;
              //   222: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   225: ldc 162
              //   227: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   230: aload_0
              //   231: getfield 45	com/i/a/c$6:ecW	I
              //   234: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
              //   237: ldc 167
              //   239: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   242: aload_0
              //   243: getfield 33	com/i/a/c$6:val$path	Ljava/lang/String;
              //   246: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   249: pop
              //   250: aload_2
              //   251: monitorexit
              //   252: aload_0
              //   253: getfield 35	com/i/a/c$6:ecQ	Lcom/i/a/c$a;
              //   256: aload_0
              //   257: getfield 45	com/i/a/c$6:ecW	I
              //   260: iconst_0
              //   261: iconst_0
              //   262: invokestatic 171	com/i/a/c:b	(IZZ)Ljava/util/Map;
              //   265: invokevirtual 175	com/i/a/c$a:success	(Ljava/lang/Object;)V
              //   268: ldc 53
              //   270: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   273: return
              //   274: aload_0
              //   275: getfield 39	com/i/a/c$6:ecR	Lcom/i/a/a;
              //   278: astore_3
              //   279: aload_3
              //   280: aload_3
              //   281: getfield 116	com/i/a/a:path	Ljava/lang/String;
              //   284: aconst_null
              //   285: ldc 176
              //   287: invokestatic 179	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
              //   290: putfield 131	com/i/a/a:ecE	Landroid/database/sqlite/SQLiteDatabase;
              //   293: goto -154 -> 139
              //   296: astore_3
              //   297: aload_3
              //   298: new 181	com/i/a/b/e
              //   301: dup
              //   302: aload_0
              //   303: getfield 41	com/i/a/c$6:ecP	Lio/flutter/plugin/common/MethodCall;
              //   306: aload_0
              //   307: getfield 35	com/i/a/c$6:ecQ	Lcom/i/a/c$a;
              //   310: invokespecial 184	com/i/a/b/e:<init>	(Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V
              //   313: aload_0
              //   314: getfield 39	com/i/a/c$6:ecR	Lcom/i/a/a;
              //   317: invokestatic 187	com/i/a/c:b	(Ljava/lang/Exception;Lcom/i/a/b/f;Lcom/i/a/a;)V
              //   320: aload_2
              //   321: monitorexit
              //   322: ldc 53
              //   324: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   327: return
              //   328: astore 4
              //   330: aload_3
              //   331: monitorexit
              //   332: ldc 53
              //   334: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   337: aload 4
              //   339: athrow
              //   340: astore_3
              //   341: aload_2
              //   342: monitorexit
              //   343: ldc 53
              //   345: invokestatic 102	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   348: aload_3
              //   349: athrow
              //   350: iconst_0
              //   351: istore_1
              //   352: goto -148 -> 204
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	355	0	this	6
              //   1	351	1	i	int
              //   10	332	2	localObject1	Object
              //   296	35	3	localException	Exception
              //   340	9	3	localObject3	Object
              //   328	10	4	localObject4	Object
              // Exception table:
              //   from	to	target	type
              //   100	139	296	java/lang/Exception
              //   274	293	296	java/lang/Exception
              //   145	172	328	finally
              //   172	194	328	finally
              //   13	94	340	finally
              //   100	139	340	finally
              //   139	145	340	finally
              //   194	204	340	finally
              //   208	250	340	finally
              //   250	252	340	finally
              //   274	293	340	finally
              //   297	322	340	finally
              //   330	340	340	finally
            }
          });
          AppMethodBeat.o(153382);
          return;
          bool1 = false;
          break;
          bool2 = false;
          break label900;
          if (b.mb(logLevel))
          {
            ??? = new StringBuilder().append(((a)localObject5).alt()).append("re-opened single instance ");
            if (!((a)localObject5).ecF) {
              break label1411;
            }
          }
          for (paramMethodCall = "(in transaction) ";; paramMethodCall = "")
          {
            ((StringBuilder)???).append(paramMethodCall).append(localObject4).append(" ").append((String)???);
            ???.success(b(((Integer)localObject4).intValue(), true, ((a)localObject5).ecF));
            AppMethodBeat.o(153382);
            return;
          }
          paramMethodCall = finally;
          AppMethodBeat.o(153382);
          throw paramMethodCall;
          paramMethodCall = finally;
          AppMethodBeat.o(153382);
          throw paramMethodCall;
        }
        label1411:
        label1447:
        i = 0;
      }
    }
    ??? = a(paramMethodCall, ???);
    if (??? != null)
    {
      ??? = new a(???, (byte)0);
      handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153354);
          Object localObject1 = new e(paramMethodCall, paramResult);
          boolean bool1 = ((e)localObject1).alz();
          boolean bool2 = Boolean.TRUE.equals(((com.i.a.b.b)localObject1).er("continueOnError"));
          Object localObject2 = (List)paramMethodCall.argument("operations");
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            com.i.a.b.c localc = new com.i.a.b.c((Map)((Iterator)localObject2).next(), bool1);
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
                paramResult.error("bad_param", "Batch method '" + str + "' not supported", null);
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
            if (c.f(this.ecR, localc))
            {
              localc.aX((List)localObject1);
            }
            else if (bool2)
            {
              localc.aY((List)localObject1);
            }
            else
            {
              localc.a(paramResult);
              AppMethodBeat.o(153354);
              return;
              if (c.a(c.this, this.ecR, localc))
              {
                localc.aX((List)localObject1);
              }
              else if (bool2)
              {
                localc.aY((List)localObject1);
              }
              else
              {
                localc.a(paramResult);
                AppMethodBeat.o(153354);
                return;
                if (c.e(this.ecR, localc))
                {
                  localc.aX((List)localObject1);
                }
                else if (bool2)
                {
                  localc.aY((List)localObject1);
                }
                else
                {
                  localc.a(paramResult);
                  AppMethodBeat.o(153354);
                  return;
                  if (c.b(c.this, this.ecR, localc))
                  {
                    localc.aX((List)localObject1);
                  }
                  else if (bool2)
                  {
                    localc.aY((List)localObject1);
                  }
                  else
                  {
                    localc.a(paramResult);
                    AppMethodBeat.o(153354);
                    return;
                  }
                }
              }
            }
          }
          if (bool1)
          {
            paramResult.success(null);
            AppMethodBeat.o(153354);
            return;
          }
          paramResult.success(localObject1);
          AppMethodBeat.o(153354);
        }
      });
    }
    AppMethodBeat.o(153382);
    return;
    ??? = paramMethodCall.argument("queryAsMapList");
    if (??? != null) {
      ecI = Boolean.TRUE.equals(???);
    }
    ??? = paramMethodCall.argument("androidThreadPriority");
    if (??? != null) {
      ecJ = ((Integer)???).intValue();
    }
    paramMethodCall = (Integer)paramMethodCall.argument("logLevel");
    if (paramMethodCall != null) {
      logLevel = paramMethodCall.intValue();
    }
    ???.success(null);
    AppMethodBeat.o(153382);
    return;
    if (ecM == null) {
      ecM = this.context.getDatabasePath("tekartik_sqflite.db").getParent();
    }
    ???.success(ecM);
    AppMethodBeat.o(153382);
    return;
    ??? = (String)paramMethodCall.argument("path");
    for (;;)
    {
      synchronized (ecK)
      {
        if (b.mb(logLevel)) {
          new StringBuilder("Look for ").append((String)???).append(" in ").append(ecH.keySet());
        }
        localObject4 = (Integer)ecH.get(???);
        if (localObject4 == null) {
          break label2022;
        }
        ??? = (a)ecO.get(localObject4);
        if ((??? == null) || (!((a)???).ecE.isOpen())) {
          break label2022;
        }
        if (b.mb(logLevel))
        {
          localObject5 = new StringBuilder().append(((a)???).alt()).append("found single instance ");
          if (((a)???).ecF)
          {
            paramMethodCall = "(in transaction) ";
            ((StringBuilder)localObject5).append(paramMethodCall).append(localObject4).append(" ").append((String)???);
          }
        }
        else
        {
          ecO.remove(localObject4);
          ecH.remove(???);
          paramMethodCall = (MethodCall)???;
          paramMethodCall = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207420);
              synchronized (c.ecL)
              {
                if (paramMethodCall != null) {
                  c.a(paramMethodCall);
                }
                try
                {
                  if (b.mb(c.logLevel)) {
                    new StringBuilder("delete database ").append(this.val$path);
                  }
                  SQLiteDatabase.deleteDatabase(new File(this.val$path));
                }
                catch (Exception localException)
                {
                  for (;;)
                  {
                    new StringBuilder("error ").append(localException).append(" while closing database ").append(c.alu());
                  }
                }
                this.ecQ.success(null);
                AppMethodBeat.o(207420);
                return;
              }
            }
          };
          if (handler == null) {
            break label1906;
          }
          handler.post(paramMethodCall);
          AppMethodBeat.o(153382);
          return;
        }
        paramMethodCall = "";
      }
      label1906:
      paramMethodCall.run();
      AppMethodBeat.o(153382);
      return;
      b(paramMethodCall, ???);
      AppMethodBeat.o(153382);
      return;
      paramMethodCall = paramMethodCall.arguments();
      com.i.a.a.a.edf = Boolean.TRUE.equals(paramMethodCall);
      if ((com.i.a.a.a.edg) && (com.i.a.a.a.edf))
      {
        bool1 = true;
        com.i.a.a.a.edh = bool1;
        if (!com.i.a.a.a.edf) {
          break label2015;
        }
        if (!com.i.a.a.a.edh) {
          break label2002;
        }
        logLevel = 2;
      }
      for (;;)
      {
        ???.success(null);
        AppMethodBeat.o(153382);
        return;
        bool1 = false;
        break;
        label2002:
        if (com.i.a.a.a.edf)
        {
          logLevel = 1;
          continue;
          label2015:
          logLevel = 0;
        }
      }
      label2022:
      paramMethodCall = null;
    }
  }
  
  final class a
    implements MethodChannel.Result
  {
    private final MethodChannel.Result ecY;
    final Handler handler;
    
    private a(MethodChannel.Result paramResult)
    {
      AppMethodBeat.i(153363);
      this.handler = new Handler(Looper.getMainLooper());
      this.ecY = paramResult;
      AppMethodBeat.o(153363);
    }
    
    public final void error(final String paramString1, final String paramString2, final Object paramObject)
    {
      AppMethodBeat.i(153365);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153361);
          c.a.a(c.a.this).error(paramString1, paramString2, paramObject);
          AppMethodBeat.o(153361);
        }
      });
      AppMethodBeat.o(153365);
    }
    
    public final void notImplemented()
    {
      AppMethodBeat.i(153366);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153362);
          c.a.a(c.a.this).notImplemented();
          AppMethodBeat.o(153362);
        }
      });
      AppMethodBeat.o(153366);
    }
    
    public final void success(final Object paramObject)
    {
      AppMethodBeat.i(153364);
      this.handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(153360);
          c.a.a(c.a.this).success(paramObject);
          AppMethodBeat.o(153360);
        }
      });
      AppMethodBeat.o(153364);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.i.a.c
 * JD-Core Version:    0.7.0.1
 */