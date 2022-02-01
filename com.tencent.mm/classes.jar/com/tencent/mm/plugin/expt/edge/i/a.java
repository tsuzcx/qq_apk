package com.tencent.mm.plugin.expt.edge.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.c.i;

public final class a
{
  private ISQLiteDatabase qFJ;
  private String zAt;
  private List<com.tencent.mm.plugin.expt.edge.e.a.a> zAu;
  
  public a(ISQLiteDatabase paramISQLiteDatabase, String paramString, List<com.tencent.mm.plugin.expt.edge.e.a.a> paramList)
  {
    this.qFJ = paramISQLiteDatabase;
    this.zAt = paramString;
    this.zAu = paramList;
  }
  
  private static String Lw(int paramInt)
  {
    if (paramInt == 0) {
      return "TEXT ";
    }
    if (paramInt == 1) {
      return "INTEGER ";
    }
    if (paramInt == 2) {
      return "INTEGER ";
    }
    return null;
  }
  
  private boolean aqu(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(299631);
    if ((this.qFJ == null) || (i.hm(this.zAt)) || (i.hm(paramString)))
    {
      AppMethodBeat.o(299631);
      return false;
    }
    String str2 = aqw(this.zAt);
    if (i.hm(str2))
    {
      AppMethodBeat.o(299631);
      return false;
    }
    localObject = null;
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = this.qFJ.rawQuery("select * from sqlite_master where name = ? and sql like ?;", new String[] { str2, "%" + paramString + "%" });
        if (paramString == null) {
          continue;
        }
        str1 = paramString;
        localObject = paramString;
        bool2 = paramString.moveToFirst();
        if (!bool2) {
          continue;
        }
        bool2 = bool1;
        if (paramString != null)
        {
          bool2 = bool1;
          if (!paramString.isClosed())
          {
            paramString.close();
            bool2 = bool1;
          }
        }
      }
      catch (Exception paramString)
      {
        localObject = str1;
        Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkColumnExist throw Exception : " + paramString.getMessage());
        if ((str1 == null) || (str1.isClosed())) {
          continue;
        }
        str1.close();
        boolean bool2 = false;
        continue;
      }
      finally
      {
        if ((localObject == null) || (((Cursor)localObject).isClosed())) {
          continue;
        }
        ((Cursor)localObject).close();
        AppMethodBeat.o(299631);
      }
      AppMethodBeat.o(299631);
      return bool2;
      bool1 = false;
    }
  }
  
  private static String aqv(String paramString)
  {
    AppMethodBeat.i(299640);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299640);
      return null;
    }
    paramString = paramString + "_ ";
    AppMethodBeat.o(299640);
    return paramString;
  }
  
  private static String aqw(String paramString)
  {
    AppMethodBeat.i(299646);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299646);
      return null;
    }
    paramString = "ec_data_table_".concat(String.valueOf(paramString));
    AppMethodBeat.o(299646);
    return paramString;
  }
  
  public final boolean dIA()
  {
    AppMethodBeat.i(299675);
    if ((this.qFJ == null) || (i.hm(this.zAt)))
    {
      AppMethodBeat.o(299675);
      return false;
    }
    String str = aqw(this.zAt);
    if (i.hm(str))
    {
      AppMethodBeat.o(299675);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE INDEX ").append("report_time_ec_index_" + this.zAt).append(" ON " + str + " ( ").append(aqv("report_time_ec")).append(" );");
    Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex tableName : %s", new Object[] { str });
    com.tencent.mm.plugin.expt.edge.b.o("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex tableName : %s, createIndexSQL : %s", new Object[] { str, localStringBuilder.toString() });
    if ((this.qFJ instanceof h)) {}
    for (h localh = (h)this.qFJ;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.beginTransaction(-1L);
      }
      for (;;)
      {
        try
        {
          bool = localh.execSQL(str, localStringBuilder.toString());
          localh.endTransaction(l);
        }
        catch (Exception localException)
        {
          Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex throw Exception : " + localException.getMessage());
          localh.endTransaction(l);
          bool = false;
          continue;
        }
        finally
        {
          localh.endTransaction(l);
          AppMethodBeat.o(299675);
        }
        AppMethodBeat.o(299675);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  public final void dIB()
  {
    AppMethodBeat.i(299681);
    if ((this.qFJ == null) || (i.hm(this.zAt)) || (this.zAu == null) || (this.zAu.size() <= 0))
    {
      AppMethodBeat.o(299681);
      return;
    }
    String str1 = aqw(this.zAt);
    if (i.hm(str1))
    {
      AppMethodBeat.o(299681);
      return;
    }
    if ((this.qFJ instanceof h)) {}
    for (h localh = (h)this.qFJ;; localh = null)
    {
      if (localh != null)
      {
        Iterator localIterator = this.zAu.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.expt.edge.e.a.a)localIterator.next();
          String str2 = Lw(((com.tencent.mm.plugin.expt.edge.e.a.a)localObject2).type);
          localObject2 = aqv(((com.tencent.mm.plugin.expt.edge.e.a.a)localObject2).name);
          if ((!i.hm(str2)) && (!i.hm((String)localObject2)) && (!aqu((String)localObject2)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ALTER TABLE ").append(str1).append(" ADD ");
            localStringBuilder.append((String)localObject2).append(" ").append(str2).append(";");
            Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s", new Object[] { str1 });
            com.tencent.mm.plugin.expt.edge.b.o("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, updateTableSQL : %s", new Object[] { str1, localStringBuilder.toString() });
            long l = localh.beginTransaction(-1L);
            try
            {
              com.tencent.mm.plugin.expt.edge.b.o("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, result : %d, updateTableSQL : %s", new Object[] { str1, Boolean.valueOf(localh.execSQL(str1, localStringBuilder.toString())), localStringBuilder.toString() });
              localh.endTransaction(l);
            }
            catch (Exception localException)
            {
              Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable throw Exception : " + localException.getMessage());
              localh.endTransaction(l);
            }
            finally
            {
              localh.endTransaction(l);
              AppMethodBeat.o(299681);
            }
          }
        }
      }
      AppMethodBeat.o(299681);
      return;
    }
  }
  
  public final boolean dIC()
  {
    AppMethodBeat.i(299689);
    if ((this.qFJ == null) || (i.hm(this.zAt)))
    {
      AppMethodBeat.o(299689);
      return false;
    }
    String str1 = aqw(this.zAt);
    if (i.hm(str1))
    {
      AppMethodBeat.o(299689);
      return false;
    }
    String str2 = "DROP TABLE IF EXISTS ".concat(String.valueOf(str1));
    Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s", new Object[] { str1 });
    com.tencent.mm.plugin.expt.edge.b.o("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s, dropSql : %s", new Object[] { str1, str2 });
    if ((this.qFJ instanceof h)) {}
    for (h localh = (h)this.qFJ;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.beginTransaction(-1L);
      }
      for (;;)
      {
        try
        {
          bool = localh.execSQL(str1, str2);
          localh.endTransaction(l);
        }
        catch (Exception localException)
        {
          Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable throw Exception : " + localException.getMessage());
          localh.endTransaction(l);
          bool = false;
          continue;
        }
        finally
        {
          localh.endTransaction(l);
          AppMethodBeat.o(299689);
        }
        AppMethodBeat.o(299689);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  public final List<List<com.tencent.mm.plugin.expt.edge.e.b>> dID()
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 18	com/tencent/mm/plugin/expt/edge/i/a:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   9: ifnull +32 -> 41
    //   12: aload_0
    //   13: getfield 20	com/tencent/mm/plugin/expt/edge/i/a:zAt	Ljava/lang/String;
    //   16: invokestatic 47	org/apache/commons/c/i:hm	(Ljava/lang/String;)Z
    //   19: ifne +22 -> 41
    //   22: aload_0
    //   23: getfield 22	com/tencent/mm/plugin/expt/edge/i/a:zAu	Ljava/util/List;
    //   26: ifnull +15 -> 41
    //   29: aload_0
    //   30: getfield 22	com/tencent/mm/plugin/expt/edge/i/a:zAu	Ljava/util/List;
    //   33: invokeinterface 172 1 0
    //   38: ifgt +10 -> 48
    //   41: ldc 232
    //   43: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aconst_null
    //   47: areturn
    //   48: aload_0
    //   49: getfield 20	com/tencent/mm/plugin/expt/edge/i/a:zAt	Ljava/lang/String;
    //   52: invokestatic 54	com/tencent/mm/plugin/expt/edge/i/a:aqw	(Ljava/lang/String;)Ljava/lang/String;
    //   55: astore 6
    //   57: aload 6
    //   59: invokestatic 47	org/apache/commons/c/i:hm	(Ljava/lang/String;)Z
    //   62: ifeq +10 -> 72
    //   65: ldc 232
    //   67: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aconst_null
    //   71: areturn
    //   72: aload_0
    //   73: getfield 18	com/tencent/mm/plugin/expt/edge/i/a:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   76: aload 6
    //   78: aconst_null
    //   79: aconst_null
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: invokeinterface 236 8 0
    //   89: astore_3
    //   90: aload_3
    //   91: ifnull +445 -> 536
    //   94: aload_3
    //   95: astore 4
    //   97: new 238	java/util/LinkedList
    //   100: dup
    //   101: invokespecial 239	java/util/LinkedList:<init>	()V
    //   104: astore_2
    //   105: aload_3
    //   106: astore 4
    //   108: aload_3
    //   109: invokeinterface 242 1 0
    //   114: ifeq +363 -> 477
    //   117: aload_3
    //   118: astore 4
    //   120: new 244	java/util/ArrayList
    //   123: dup
    //   124: invokespecial 245	java/util/ArrayList:<init>	()V
    //   127: astore 5
    //   129: aload_3
    //   130: astore 4
    //   132: aload_0
    //   133: getfield 22	com/tencent/mm/plugin/expt/edge/i/a:zAu	Ljava/util/List;
    //   136: invokeinterface 176 1 0
    //   141: astore 7
    //   143: aload_3
    //   144: astore 4
    //   146: aload 7
    //   148: invokeinterface 181 1 0
    //   153: ifeq +378 -> 531
    //   156: aload_3
    //   157: astore 4
    //   159: aload 7
    //   161: invokeinterface 185 1 0
    //   166: checkcast 187	com/tencent/mm/plugin/expt/edge/e/a/a
    //   169: astore 8
    //   171: aload_3
    //   172: astore 4
    //   174: new 247	com/tencent/mm/plugin/expt/edge/e/b
    //   177: dup
    //   178: invokespecial 248	com/tencent/mm/plugin/expt/edge/e/b:<init>	()V
    //   181: astore 9
    //   183: aload_3
    //   184: astore 4
    //   186: aload 9
    //   188: aload 8
    //   190: getfield 196	com/tencent/mm/plugin/expt/edge/e/a/a:name	Ljava/lang/String;
    //   193: putfield 249	com/tencent/mm/plugin/expt/edge/e/b:name	Ljava/lang/String;
    //   196: aload_3
    //   197: astore 4
    //   199: aload 9
    //   201: aload 8
    //   203: getfield 252	com/tencent/mm/plugin/expt/edge/e/a/a:index	I
    //   206: putfield 253	com/tencent/mm/plugin/expt/edge/e/b:index	I
    //   209: aload_3
    //   210: astore 4
    //   212: aload 9
    //   214: aload 8
    //   216: getfield 191	com/tencent/mm/plugin/expt/edge/e/a/a:type	I
    //   219: putfield 254	com/tencent/mm/plugin/expt/edge/e/b:type	I
    //   222: aload_3
    //   223: astore 4
    //   225: aload 8
    //   227: getfield 191	com/tencent/mm/plugin/expt/edge/e/a/a:type	I
    //   230: ifne +121 -> 351
    //   233: aload_3
    //   234: astore 4
    //   236: aload 9
    //   238: aload_3
    //   239: aload 8
    //   241: getfield 252	com/tencent/mm/plugin/expt/edge/e/a/a:index	I
    //   244: invokeinterface 257 2 0
    //   249: putfield 260	com/tencent/mm/plugin/expt/edge/e/b:stringValue	Ljava/lang/String;
    //   252: aload_3
    //   253: astore 4
    //   255: aload 5
    //   257: aload 9
    //   259: invokeinterface 264 2 0
    //   264: pop
    //   265: goto -122 -> 143
    //   268: astore 5
    //   270: aload_3
    //   271: astore 4
    //   273: ldc 93
    //   275: new 60	java/lang/StringBuilder
    //   278: dup
    //   279: ldc_w 266
    //   282: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload 5
    //   287: invokevirtual 98	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 104	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload_2
    //   300: astore 4
    //   302: aload_3
    //   303: ifnull +24 -> 327
    //   306: aload_2
    //   307: astore 4
    //   309: aload_3
    //   310: invokeinterface 88 1 0
    //   315: ifne +12 -> 327
    //   318: aload_3
    //   319: invokeinterface 91 1 0
    //   324: aload_2
    //   325: astore 4
    //   327: ldc 93
    //   329: ldc_w 268
    //   332: aload 6
    //   334: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   337: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   340: invokestatic 270	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: ldc 232
    //   345: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   348: aload 4
    //   350: areturn
    //   351: aload_3
    //   352: astore 4
    //   354: aload 8
    //   356: getfield 191	com/tencent/mm/plugin/expt/edge/e/a/a:type	I
    //   359: iconst_1
    //   360: if_icmpne +78 -> 438
    //   363: aload_3
    //   364: astore 4
    //   366: aload 9
    //   368: aload_3
    //   369: aload 8
    //   371: getfield 252	com/tencent/mm/plugin/expt/edge/e/a/a:index	I
    //   374: invokeinterface 274 2 0
    //   379: putfield 277	com/tencent/mm/plugin/expt/edge/e/b:qDL	I
    //   382: goto -130 -> 252
    //   385: astore 4
    //   387: iconst_1
    //   388: istore_1
    //   389: iload_1
    //   390: ifne -285 -> 105
    //   393: aload_3
    //   394: astore 4
    //   396: aload_2
    //   397: aload 5
    //   399: invokeinterface 264 2 0
    //   404: pop
    //   405: goto -300 -> 105
    //   408: astore_2
    //   409: aload 4
    //   411: ifnull +20 -> 431
    //   414: aload 4
    //   416: invokeinterface 88 1 0
    //   421: ifne +10 -> 431
    //   424: aload 4
    //   426: invokeinterface 91 1 0
    //   431: ldc 232
    //   433: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   436: aload_2
    //   437: athrow
    //   438: aload_3
    //   439: astore 4
    //   441: aload 8
    //   443: getfield 191	com/tencent/mm/plugin/expt/edge/e/a/a:type	I
    //   446: iconst_2
    //   447: if_icmpne +25 -> 472
    //   450: aload_3
    //   451: astore 4
    //   453: aload 9
    //   455: aload_3
    //   456: aload 8
    //   458: getfield 252	com/tencent/mm/plugin/expt/edge/e/a/a:index	I
    //   461: invokeinterface 281 2 0
    //   466: putfield 285	com/tencent/mm/plugin/expt/edge/e/b:zzU	J
    //   469: goto -217 -> 252
    //   472: iconst_1
    //   473: istore_1
    //   474: goto -85 -> 389
    //   477: aload_2
    //   478: astore 4
    //   480: aload_3
    //   481: ifnull -154 -> 327
    //   484: aload_2
    //   485: astore 4
    //   487: aload_3
    //   488: invokeinterface 88 1 0
    //   493: ifne -166 -> 327
    //   496: aload_3
    //   497: invokeinterface 91 1 0
    //   502: aload_2
    //   503: astore 4
    //   505: goto -178 -> 327
    //   508: astore_2
    //   509: aconst_null
    //   510: astore 4
    //   512: goto -103 -> 409
    //   515: astore 5
    //   517: aconst_null
    //   518: astore_3
    //   519: aconst_null
    //   520: astore_2
    //   521: goto -251 -> 270
    //   524: astore 5
    //   526: aconst_null
    //   527: astore_2
    //   528: goto -258 -> 270
    //   531: iconst_0
    //   532: istore_1
    //   533: goto -144 -> 389
    //   536: aconst_null
    //   537: astore_2
    //   538: goto -61 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	541	0	this	a
    //   388	145	1	i	int
    //   104	293	2	localLinkedList	java.util.LinkedList
    //   408	95	2	localObject1	Object
    //   508	1	2	localObject2	Object
    //   520	18	2	localObject3	Object
    //   89	430	3	localCursor	Cursor
    //   95	270	4	localObject4	Object
    //   385	1	4	localException1	Exception
    //   394	117	4	localObject5	Object
    //   127	129	5	localArrayList	java.util.ArrayList
    //   268	130	5	localException2	Exception
    //   515	1	5	localException3	Exception
    //   524	1	5	localException4	Exception
    //   55	278	6	str	String
    //   141	19	7	localIterator	Iterator
    //   169	288	8	locala	com.tencent.mm.plugin.expt.edge.e.a.a
    //   181	273	9	localb	com.tencent.mm.plugin.expt.edge.e.b
    // Exception table:
    //   from	to	target	type
    //   108	117	268	java/lang/Exception
    //   120	129	268	java/lang/Exception
    //   132	143	268	java/lang/Exception
    //   146	156	268	java/lang/Exception
    //   159	171	268	java/lang/Exception
    //   174	183	268	java/lang/Exception
    //   186	196	268	java/lang/Exception
    //   199	209	268	java/lang/Exception
    //   212	222	268	java/lang/Exception
    //   255	265	268	java/lang/Exception
    //   396	405	268	java/lang/Exception
    //   225	233	385	java/lang/Exception
    //   236	252	385	java/lang/Exception
    //   354	363	385	java/lang/Exception
    //   366	382	385	java/lang/Exception
    //   441	450	385	java/lang/Exception
    //   453	469	385	java/lang/Exception
    //   97	105	408	finally
    //   108	117	408	finally
    //   120	129	408	finally
    //   132	143	408	finally
    //   146	156	408	finally
    //   159	171	408	finally
    //   174	183	408	finally
    //   186	196	408	finally
    //   199	209	408	finally
    //   212	222	408	finally
    //   225	233	408	finally
    //   236	252	408	finally
    //   255	265	408	finally
    //   273	299	408	finally
    //   354	363	408	finally
    //   366	382	408	finally
    //   396	405	408	finally
    //   441	450	408	finally
    //   453	469	408	finally
    //   72	90	508	finally
    //   72	90	515	java/lang/Exception
    //   97	105	524	java/lang/Exception
  }
  
  public final boolean dIy()
  {
    bool2 = false;
    AppMethodBeat.i(299657);
    if ((this.qFJ == null) || (i.hm(this.zAt)))
    {
      AppMethodBeat.o(299657);
      return false;
    }
    Object localObject4 = aqw(this.zAt);
    if (i.hm((String)localObject4))
    {
      AppMethodBeat.o(299657);
      return false;
    }
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = this.qFJ.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { localObject4 });
      localObject1 = localObject4;
      localObject3 = localObject4;
      bool1 = ((Cursor)localObject4).moveToNext();
      bool2 = bool1;
      bool1 = bool2;
      if (localObject4 != null)
      {
        bool1 = bool2;
        if (!((Cursor)localObject4).isClosed())
        {
          ((Cursor)localObject4).close();
          bool1 = bool2;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = localObject1;
        Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkTableExist throw Exception : " + localException.getMessage());
        boolean bool1 = bool2;
        if (localObject1 != null)
        {
          bool1 = bool2;
          if (!localObject1.isClosed())
          {
            localObject1.close();
            bool1 = bool2;
          }
        }
      }
    }
    finally
    {
      if ((localObject3 == null) || (localObject3.isClosed())) {
        break label221;
      }
      localObject3.close();
      AppMethodBeat.o(299657);
    }
    AppMethodBeat.o(299657);
    return bool1;
  }
  
  public final boolean dIz()
  {
    AppMethodBeat.i(299667);
    if ((this.qFJ == null) || (i.hm(this.zAt)) || (this.zAu == null) || (this.zAu.size() <= 0))
    {
      AppMethodBeat.o(299667);
      return false;
    }
    String str1 = aqw(this.zAt);
    if (i.hm(str1))
    {
      AppMethodBeat.o(299667);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + str1 + " ( ");
    Object localObject1 = this.zAu.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (com.tencent.mm.plugin.expt.edge.e.a.a)((Iterator)localObject1).next();
      String str2 = Lw(((com.tencent.mm.plugin.expt.edge.e.a.a)localObject3).type);
      localObject3 = aqv(((com.tencent.mm.plugin.expt.edge.e.a.a)localObject3).name);
      if ((!i.hm(str2)) && (!i.hm((String)localObject3))) {
        localStringBuilder.append((String)localObject3).append(" ").append(str2).append(",");
      }
    }
    if (localStringBuilder.toString().endsWith(",")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(");");
    Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s", new Object[] { str1 });
    com.tencent.mm.plugin.expt.edge.b.o("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s, createTableSQL : %s", new Object[] { str1, localStringBuilder.toString() });
    if ((this.qFJ instanceof h)) {}
    for (localObject1 = (h)this.qFJ;; localObject1 = null)
    {
      long l;
      if (localObject1 != null) {
        l = ((h)localObject1).beginTransaction(-1L);
      }
      for (;;)
      {
        try
        {
          bool = ((h)localObject1).execSQL(str1, localStringBuilder.toString());
          ((h)localObject1).endTransaction(l);
        }
        catch (Exception localException)
        {
          Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable throw Exception : " + localException.getMessage());
          ((h)localObject1).endTransaction(l);
          bool = false;
          continue;
        }
        finally
        {
          ((h)localObject1).endTransaction(l);
          AppMethodBeat.o(299667);
        }
        AppMethodBeat.o(299667);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  public final boolean fq(List<List<com.tencent.mm.plugin.expt.edge.e.b>> paramList)
  {
    boolean bool2 = false;
    AppMethodBeat.i(299702);
    if ((this.qFJ == null) || (i.hm(this.zAt)) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299702);
      return false;
    }
    String str = aqw(this.zAt);
    if (i.hm(str))
    {
      AppMethodBeat.o(299702);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("INSERT INTO ");
    localStringBuilder.append(str).append(" ( ");
    int i = 0;
    while (i < this.zAu.size())
    {
      localStringBuilder.append(aqv(((com.tencent.mm.plugin.expt.edge.e.a.a)this.zAu.get(i)).name)).append(",");
      i += 1;
    }
    if (localStringBuilder.toString().endsWith(",")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(" ) VALUES ");
    Iterator localIterator1 = paramList.iterator();
    long l;
    while (localIterator1.hasNext())
    {
      paramList = (List)localIterator1.next();
      localStringBuilder.append("(");
      Iterator localIterator2 = paramList.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          paramList = (com.tencent.mm.plugin.expt.edge.e.b)localIterator2.next();
          try
          {
            if (paramList.type == 0) {
              paramList = "'" + paramList.stringValue + "'";
            }
            for (;;)
            {
              localStringBuilder.append(paramList).append(",");
              break;
              if (paramList.type == 1)
              {
                paramList = String.valueOf(paramList.qDL);
              }
              else
              {
                if (paramList.type != 2) {
                  break label371;
                }
                l = paramList.zzU;
                paramList = String.valueOf(l);
              }
            }
          }
          catch (Exception paramList)
          {
            for (;;)
            {
              Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch throw Exception : " + paramList.getMessage());
              label371:
              paramList = "''";
            }
          }
        }
      }
      if (localStringBuilder.toString().endsWith(",")) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localStringBuilder.append("),");
    }
    if (localStringBuilder.toString().endsWith(",")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(";");
    com.tencent.mm.plugin.expt.edge.b.hf("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch tableName : ".concat(String.valueOf(str)));
    if ((this.qFJ instanceof h)) {}
    boolean bool1;
    for (paramList = (h)this.qFJ;; paramList = null)
    {
      bool1 = bool2;
      if (paramList != null) {
        l = paramList.beginTransaction(-1L);
      }
      try
      {
        bool1 = this.qFJ.execSQL(str, localStringBuilder.toString());
        paramList.endTransaction(l);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch throw Exception : " + localException.getMessage());
          paramList.endTransaction(l);
          bool1 = bool2;
        }
      }
      finally
      {
        paramList.endTransaction(l);
        AppMethodBeat.o(299702);
      }
      AppMethodBeat.o(299702);
      return bool1;
    }
  }
  
  public final boolean lX(long paramLong)
  {
    AppMethodBeat.i(299711);
    if ((this.qFJ == null) || (i.hm(this.zAt)))
    {
      AppMethodBeat.o(299711);
      return false;
    }
    String str = aqw(this.zAt);
    if (i.hm(str))
    {
      AppMethodBeat.o(299711);
      return false;
    }
    Log.i("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire tableName : " + str + ", expireTimestamp : " + paramLong);
    if ((this.qFJ instanceof h)) {}
    for (h localh = (h)this.qFJ;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.beginTransaction(-1L);
      }
      for (;;)
      {
        try
        {
          i = localh.delete(str, aqv("report_time_ec") + " < ?", new String[] { String.valueOf(paramLong) });
          localh.endTransaction(l);
        }
        catch (Exception localException)
        {
          Log.e("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire throw Exception : " + localException.getMessage());
          localh.endTransaction(l);
          i = 0;
          continue;
        }
        finally
        {
          localh.endTransaction(l);
          AppMethodBeat.o(299711);
        }
        if (i > 0)
        {
          AppMethodBeat.o(299711);
          return true;
        }
        AppMethodBeat.o(299711);
        return false;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.i.a
 * JD-Core Version:    0.7.0.1
 */