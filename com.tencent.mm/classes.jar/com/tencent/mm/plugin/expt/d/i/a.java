package com.tencent.mm.plugin.expt.d.i;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public final class a
{
  private e jKa;
  private String qYq;
  private List<com.tencent.mm.plugin.expt.d.e.a.a> qYr;
  
  public a(e parame, String paramString, List<com.tencent.mm.plugin.expt.d.e.a.a> paramList)
  {
    this.jKa = parame;
    this.qYq = paramString;
    this.qYr = paramList;
  }
  
  private static String Dc(int paramInt)
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
  
  private boolean aei(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(195951);
    if ((this.jKa == null) || (g.ef(this.qYq)) || (g.ef(paramString)))
    {
      AppMethodBeat.o(195951);
      return false;
    }
    String str2 = aek(this.qYq);
    if (g.ef(str2))
    {
      AppMethodBeat.o(195951);
      return false;
    }
    localObject = null;
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = this.jKa.rawQuery("select * from sqlite_master where name = ? and sql like ?;", new String[] { str2, "%" + paramString + "%" });
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
        ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkColumnExist throw Exception : " + paramString.getMessage());
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
        AppMethodBeat.o(195951);
      }
      AppMethodBeat.o(195951);
      return bool2;
      bool1 = false;
    }
  }
  
  private static String aej(String paramString)
  {
    AppMethodBeat.i(195952);
    if (g.ef(paramString))
    {
      AppMethodBeat.o(195952);
      return null;
    }
    paramString = paramString + "_ ";
    AppMethodBeat.o(195952);
    return paramString;
  }
  
  private static String aek(String paramString)
  {
    AppMethodBeat.i(195953);
    if (g.ef(paramString))
    {
      AppMethodBeat.o(195953);
      return null;
    }
    paramString = "ec_data_table_".concat(String.valueOf(paramString));
    AppMethodBeat.o(195953);
    return paramString;
  }
  
  public final boolean coP()
  {
    bool2 = false;
    AppMethodBeat.i(195943);
    if ((this.jKa == null) || (g.ef(this.qYq)))
    {
      AppMethodBeat.o(195943);
      return false;
    }
    Object localObject4 = aek(this.qYq);
    if (g.ef((String)localObject4))
    {
      AppMethodBeat.o(195943);
      return false;
    }
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = this.jKa.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { localObject4 });
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
        ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkTableExist throw Exception : " + localException.getMessage());
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
        break label215;
      }
      localObject3.close();
      AppMethodBeat.o(195943);
    }
    AppMethodBeat.o(195943);
    return bool1;
  }
  
  public final boolean coQ()
  {
    AppMethodBeat.i(195944);
    if ((this.jKa == null) || (g.ef(this.qYq)) || (this.qYr == null) || (this.qYr.size() <= 0))
    {
      AppMethodBeat.o(195944);
      return false;
    }
    String str1 = aek(this.qYq);
    if (g.ef(str1))
    {
      AppMethodBeat.o(195944);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + str1 + " ( ");
    Object localObject1 = this.qYr.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (com.tencent.mm.plugin.expt.d.e.a.a)((Iterator)localObject1).next();
      String str2 = Dc(((com.tencent.mm.plugin.expt.d.e.a.a)localObject3).type);
      localObject3 = aej(((com.tencent.mm.plugin.expt.d.e.a.a)localObject3).name);
      if ((!g.ef(str2)) && (!g.ef((String)localObject3))) {
        localStringBuilder.append((String)localObject3).append(" ").append(str2).append(",");
      }
    }
    if (localStringBuilder.toString().endsWith(",")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(");");
    ae.i("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s", new Object[] { str1 });
    ae.d("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s, createTableSQL : %s", new Object[] { str1, localStringBuilder.toString() });
    if ((this.jKa instanceof h)) {}
    for (localObject1 = (h)this.jKa;; localObject1 = null)
    {
      long l;
      if (localObject1 != null) {
        l = ((h)localObject1).yi(-1L);
      }
      for (;;)
      {
        try
        {
          bool = ((h)localObject1).execSQL(str1, localStringBuilder.toString());
          ((h)localObject1).sW(l);
        }
        catch (Exception localException)
        {
          ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable throw Exception : " + localException.getMessage());
          ((h)localObject1).sW(l);
          bool = false;
          continue;
        }
        finally
        {
          ((h)localObject1).sW(l);
          AppMethodBeat.o(195944);
        }
        AppMethodBeat.o(195944);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  public final boolean coR()
  {
    AppMethodBeat.i(195945);
    if ((this.jKa == null) || (g.ef(this.qYq)))
    {
      AppMethodBeat.o(195945);
      return false;
    }
    String str = aek(this.qYq);
    if (g.ef(str))
    {
      AppMethodBeat.o(195945);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE INDEX ").append("report_time_ec_index_" + this.qYq).append(" ON " + str + " ( ").append(aej("report_time_ec")).append(" );");
    ae.i("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex tableName : %s", new Object[] { str });
    ae.d("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex tableName : %s, createIndexSQL : %s", new Object[] { str, localStringBuilder.toString() });
    if ((this.jKa instanceof h)) {}
    for (h localh = (h)this.jKa;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.yi(-1L);
      }
      for (;;)
      {
        try
        {
          bool = localh.execSQL(str, localStringBuilder.toString());
          localh.sW(l);
        }
        catch (Exception localException)
        {
          ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] createIndex throw Exception : " + localException.getMessage());
          localh.sW(l);
          bool = false;
          continue;
        }
        finally
        {
          localh.sW(l);
          AppMethodBeat.o(195945);
        }
        AppMethodBeat.o(195945);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  public final void coS()
  {
    AppMethodBeat.i(195946);
    if ((this.jKa == null) || (g.ef(this.qYq)) || (this.qYr == null) || (this.qYr.size() <= 0))
    {
      AppMethodBeat.o(195946);
      return;
    }
    String str1 = aek(this.qYq);
    if (g.ef(str1))
    {
      AppMethodBeat.o(195946);
      return;
    }
    if ((this.jKa instanceof h)) {}
    for (h localh = (h)this.jKa;; localh = null)
    {
      if (localh != null)
      {
        Iterator localIterator = this.qYr.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.expt.d.e.a.a)localIterator.next();
          String str2 = Dc(((com.tencent.mm.plugin.expt.d.e.a.a)localObject2).type);
          localObject2 = aej(((com.tencent.mm.plugin.expt.d.e.a.a)localObject2).name);
          if ((!g.ef(str2)) && (!g.ef((String)localObject2)) && (!aei((String)localObject2)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ALTER TABLE ").append(str1).append(" ADD ");
            localStringBuilder.append((String)localObject2).append(" ").append(str2).append(";");
            ae.i("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s", new Object[] { str1 });
            ae.d("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, updateTableSQL : %s", new Object[] { str1, localStringBuilder.toString() });
            long l = localh.yi(-1L);
            try
            {
              ae.d("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, result : %d, updateTableSQL : %s", new Object[] { str1, Boolean.valueOf(localh.execSQL(str1, localStringBuilder.toString())), localStringBuilder.toString() });
              localh.sW(l);
            }
            catch (Exception localException)
            {
              ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable throw Exception : " + localException.getMessage());
              localh.sW(l);
            }
            finally
            {
              localh.sW(l);
              AppMethodBeat.o(195946);
            }
          }
        }
      }
      AppMethodBeat.o(195946);
      return;
    }
  }
  
  public final boolean coT()
  {
    AppMethodBeat.i(195947);
    if ((this.jKa == null) || (g.ef(this.qYq)))
    {
      AppMethodBeat.o(195947);
      return false;
    }
    String str1 = aek(this.qYq);
    if (g.ef(str1))
    {
      AppMethodBeat.o(195947);
      return false;
    }
    String str2 = "DROP TABLE IF EXISTS ".concat(String.valueOf(str1));
    ae.i("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s", new Object[] { str1 });
    ae.d("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s, dropSql : %s", new Object[] { str1, str2 });
    if ((this.jKa instanceof h)) {}
    for (h localh = (h)this.jKa;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.yi(-1L);
      }
      for (;;)
      {
        try
        {
          bool = localh.execSQL(str1, str2);
          localh.sW(l);
        }
        catch (Exception localException)
        {
          ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable throw Exception : " + localException.getMessage());
          localh.sW(l);
          bool = false;
          continue;
        }
        finally
        {
          localh.sW(l);
          AppMethodBeat.o(195947);
        }
        AppMethodBeat.o(195947);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  public final List<List<b>> coU()
  {
    // Byte code:
    //   0: ldc_w 264
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 18	com/tencent/mm/plugin/expt/d/i/a:jKa	Lcom/tencent/mm/sdk/e/e;
    //   10: ifnull +32 -> 42
    //   13: aload_0
    //   14: getfield 20	com/tencent/mm/plugin/expt/d/i/a:qYq	Ljava/lang/String;
    //   17: invokestatic 47	org/apache/commons/b/g:ef	(Ljava/lang/String;)Z
    //   20: ifne +22 -> 42
    //   23: aload_0
    //   24: getfield 22	com/tencent/mm/plugin/expt/d/i/a:qYr	Ljava/util/List;
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 22	com/tencent/mm/plugin/expt/d/i/a:qYr	Ljava/util/List;
    //   34: invokeinterface 136 1 0
    //   39: ifgt +11 -> 50
    //   42: ldc_w 264
    //   45: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_0
    //   51: getfield 20	com/tencent/mm/plugin/expt/d/i/a:qYq	Ljava/lang/String;
    //   54: invokestatic 54	com/tencent/mm/plugin/expt/d/i/a:aek	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 6
    //   59: aload 6
    //   61: invokestatic 47	org/apache/commons/b/g:ef	(Ljava/lang/String;)Z
    //   64: ifeq +11 -> 75
    //   67: ldc_w 264
    //   70: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_0
    //   76: getfield 18	com/tencent/mm/plugin/expt/d/i/a:jKa	Lcom/tencent/mm/sdk/e/e;
    //   79: aload 6
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokeinterface 268 8 0
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +447 -> 541
    //   97: aload_3
    //   98: astore 4
    //   100: new 270	java/util/LinkedList
    //   103: dup
    //   104: invokespecial 271	java/util/LinkedList:<init>	()V
    //   107: astore_2
    //   108: aload_3
    //   109: astore 4
    //   111: aload_3
    //   112: invokeinterface 126 1 0
    //   117: ifeq +365 -> 482
    //   120: aload_3
    //   121: astore 4
    //   123: new 273	java/util/ArrayList
    //   126: dup
    //   127: invokespecial 274	java/util/ArrayList:<init>	()V
    //   130: astore 5
    //   132: aload_3
    //   133: astore 4
    //   135: aload_0
    //   136: getfield 22	com/tencent/mm/plugin/expt/d/i/a:qYr	Ljava/util/List;
    //   139: invokeinterface 144 1 0
    //   144: astore 7
    //   146: aload_3
    //   147: astore 4
    //   149: aload 7
    //   151: invokeinterface 149 1 0
    //   156: ifeq +380 -> 536
    //   159: aload_3
    //   160: astore 4
    //   162: aload 7
    //   164: invokeinterface 153 1 0
    //   169: checkcast 155	com/tencent/mm/plugin/expt/d/e/a/a
    //   172: astore 8
    //   174: aload_3
    //   175: astore 4
    //   177: new 276	com/tencent/mm/plugin/expt/d/e/b
    //   180: dup
    //   181: invokespecial 277	com/tencent/mm/plugin/expt/d/e/b:<init>	()V
    //   184: astore 9
    //   186: aload_3
    //   187: astore 4
    //   189: aload 9
    //   191: aload 8
    //   193: getfield 164	com/tencent/mm/plugin/expt/d/e/a/a:name	Ljava/lang/String;
    //   196: putfield 278	com/tencent/mm/plugin/expt/d/e/b:name	Ljava/lang/String;
    //   199: aload_3
    //   200: astore 4
    //   202: aload 9
    //   204: aload 8
    //   206: getfield 281	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   209: putfield 282	com/tencent/mm/plugin/expt/d/e/b:index	I
    //   212: aload_3
    //   213: astore 4
    //   215: aload 9
    //   217: aload 8
    //   219: getfield 159	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   222: putfield 283	com/tencent/mm/plugin/expt/d/e/b:type	I
    //   225: aload_3
    //   226: astore 4
    //   228: aload 8
    //   230: getfield 159	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   233: ifne +122 -> 355
    //   236: aload_3
    //   237: astore 4
    //   239: aload 9
    //   241: aload_3
    //   242: aload 8
    //   244: getfield 281	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   247: invokeinterface 286 2 0
    //   252: putfield 289	com/tencent/mm/plugin/expt/d/e/b:stringValue	Ljava/lang/String;
    //   255: aload_3
    //   256: astore 4
    //   258: aload 5
    //   260: aload 9
    //   262: invokeinterface 293 2 0
    //   267: pop
    //   268: goto -122 -> 146
    //   271: astore 5
    //   273: aload_3
    //   274: astore 4
    //   276: ldc 93
    //   278: new 60	java/lang/StringBuilder
    //   281: dup
    //   282: ldc_w 295
    //   285: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: aload 5
    //   290: invokevirtual 98	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   293: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 104	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_2
    //   303: astore 4
    //   305: aload_3
    //   306: ifnull +24 -> 330
    //   309: aload_2
    //   310: astore 4
    //   312: aload_3
    //   313: invokeinterface 88 1 0
    //   318: ifne +12 -> 330
    //   321: aload_3
    //   322: invokeinterface 91 1 0
    //   327: aload_2
    //   328: astore 4
    //   330: ldc 93
    //   332: ldc_w 297
    //   335: aload 6
    //   337: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   340: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   343: invokestatic 299	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: ldc_w 264
    //   349: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: aload 4
    //   354: areturn
    //   355: aload_3
    //   356: astore 4
    //   358: aload 8
    //   360: getfield 159	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   363: iconst_1
    //   364: if_icmpne +79 -> 443
    //   367: aload_3
    //   368: astore 4
    //   370: aload 9
    //   372: aload_3
    //   373: aload 8
    //   375: getfield 281	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   378: invokeinterface 303 2 0
    //   383: putfield 306	com/tencent/mm/plugin/expt/d/e/b:intValue	I
    //   386: goto -131 -> 255
    //   389: astore 4
    //   391: iconst_1
    //   392: istore_1
    //   393: iload_1
    //   394: ifne -286 -> 108
    //   397: aload_3
    //   398: astore 4
    //   400: aload_2
    //   401: aload 5
    //   403: invokeinterface 293 2 0
    //   408: pop
    //   409: goto -301 -> 108
    //   412: astore_2
    //   413: aload 4
    //   415: ifnull +20 -> 435
    //   418: aload 4
    //   420: invokeinterface 88 1 0
    //   425: ifne +10 -> 435
    //   428: aload 4
    //   430: invokeinterface 91 1 0
    //   435: ldc_w 264
    //   438: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   441: aload_2
    //   442: athrow
    //   443: aload_3
    //   444: astore 4
    //   446: aload 8
    //   448: getfield 159	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   451: iconst_2
    //   452: if_icmpne +25 -> 477
    //   455: aload_3
    //   456: astore 4
    //   458: aload 9
    //   460: aload_3
    //   461: aload 8
    //   463: getfield 281	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   466: invokeinterface 310 2 0
    //   471: putfield 314	com/tencent/mm/plugin/expt/d/e/b:qXY	J
    //   474: goto -219 -> 255
    //   477: iconst_1
    //   478: istore_1
    //   479: goto -86 -> 393
    //   482: aload_2
    //   483: astore 4
    //   485: aload_3
    //   486: ifnull -156 -> 330
    //   489: aload_2
    //   490: astore 4
    //   492: aload_3
    //   493: invokeinterface 88 1 0
    //   498: ifne -168 -> 330
    //   501: aload_3
    //   502: invokeinterface 91 1 0
    //   507: aload_2
    //   508: astore 4
    //   510: goto -180 -> 330
    //   513: astore_2
    //   514: aconst_null
    //   515: astore 4
    //   517: goto -104 -> 413
    //   520: astore 5
    //   522: aconst_null
    //   523: astore_3
    //   524: aconst_null
    //   525: astore_2
    //   526: goto -253 -> 273
    //   529: astore 5
    //   531: aconst_null
    //   532: astore_2
    //   533: goto -260 -> 273
    //   536: iconst_0
    //   537: istore_1
    //   538: goto -145 -> 393
    //   541: aconst_null
    //   542: astore_2
    //   543: goto -61 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	this	a
    //   392	146	1	i	int
    //   107	294	2	localLinkedList	java.util.LinkedList
    //   412	96	2	localObject1	Object
    //   513	1	2	localObject2	Object
    //   525	18	2	localObject3	Object
    //   92	432	3	localCursor	Cursor
    //   98	271	4	localObject4	Object
    //   389	1	4	localException1	Exception
    //   398	118	4	localObject5	Object
    //   130	129	5	localArrayList	java.util.ArrayList
    //   271	131	5	localException2	Exception
    //   520	1	5	localException3	Exception
    //   529	1	5	localException4	Exception
    //   57	279	6	str	String
    //   144	19	7	localIterator	Iterator
    //   172	290	8	locala	com.tencent.mm.plugin.expt.d.e.a.a
    //   184	275	9	localb	b
    // Exception table:
    //   from	to	target	type
    //   111	120	271	java/lang/Exception
    //   123	132	271	java/lang/Exception
    //   135	146	271	java/lang/Exception
    //   149	159	271	java/lang/Exception
    //   162	174	271	java/lang/Exception
    //   177	186	271	java/lang/Exception
    //   189	199	271	java/lang/Exception
    //   202	212	271	java/lang/Exception
    //   215	225	271	java/lang/Exception
    //   258	268	271	java/lang/Exception
    //   400	409	271	java/lang/Exception
    //   228	236	389	java/lang/Exception
    //   239	255	389	java/lang/Exception
    //   358	367	389	java/lang/Exception
    //   370	386	389	java/lang/Exception
    //   446	455	389	java/lang/Exception
    //   458	474	389	java/lang/Exception
    //   100	108	412	finally
    //   111	120	412	finally
    //   123	132	412	finally
    //   135	146	412	finally
    //   149	159	412	finally
    //   162	174	412	finally
    //   177	186	412	finally
    //   189	199	412	finally
    //   202	212	412	finally
    //   215	225	412	finally
    //   228	236	412	finally
    //   239	255	412	finally
    //   258	268	412	finally
    //   276	302	412	finally
    //   358	367	412	finally
    //   370	386	412	finally
    //   400	409	412	finally
    //   446	455	412	finally
    //   458	474	412	finally
    //   75	93	513	finally
    //   75	93	520	java/lang/Exception
    //   100	108	529	java/lang/Exception
  }
  
  public final boolean db(List<List<b>> paramList)
  {
    boolean bool2 = false;
    AppMethodBeat.i(195948);
    if ((this.jKa == null) || (g.ef(this.qYq)) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(195948);
      return false;
    }
    String str = aek(this.qYq);
    if (g.ef(str))
    {
      AppMethodBeat.o(195948);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("INSERT INTO ");
    localStringBuilder.append(str).append(" ( ");
    int i = 0;
    while (i < this.qYr.size())
    {
      localStringBuilder.append(aej(((com.tencent.mm.plugin.expt.d.e.a.a)this.qYr.get(i)).name)).append(",");
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
          paramList = (b)localIterator2.next();
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
                paramList = String.valueOf(paramList.intValue);
              }
              else
              {
                if (paramList.type != 2) {
                  break label368;
                }
                l = paramList.qXY;
                paramList = String.valueOf(l);
              }
            }
          }
          catch (Exception paramList)
          {
            for (;;)
            {
              ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch throw Exception : " + paramList.getMessage());
              label368:
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
    ae.d("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch tableName : ".concat(String.valueOf(str)));
    if ((this.jKa instanceof h)) {}
    boolean bool1;
    for (paramList = (h)this.jKa;; paramList = null)
    {
      bool1 = bool2;
      if (paramList != null) {
        l = paramList.yi(-1L);
      }
      try
      {
        bool1 = this.jKa.execSQL(str, localStringBuilder.toString());
        paramList.sW(l);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] insertPatch throw Exception : " + localException.getMessage());
          paramList.sW(l);
          bool1 = bool2;
        }
      }
      finally
      {
        paramList.sW(l);
        AppMethodBeat.o(195948);
      }
      AppMethodBeat.o(195948);
      return bool1;
    }
  }
  
  public final boolean vj(long paramLong)
  {
    AppMethodBeat.i(195949);
    if ((this.jKa == null) || (g.ef(this.qYq)))
    {
      AppMethodBeat.o(195949);
      return false;
    }
    String str = aek(this.qYq);
    if (g.ef(str))
    {
      AppMethodBeat.o(195949);
      return false;
    }
    ae.i("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire tableName : " + str + ", expireTimestamp : " + paramLong);
    if ((this.jKa instanceof h)) {}
    for (h localh = (h)this.jKa;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.yi(-1L);
      }
      for (;;)
      {
        try
        {
          i = localh.delete(str, aej("report_time_ec") + " < ?", new String[] { String.valueOf(paramLong) });
          localh.sW(l);
        }
        catch (Exception localException)
        {
          ae.e("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire throw Exception : " + localException.getMessage());
          localh.sW(l);
          i = 0;
          continue;
        }
        finally
        {
          localh.sW(l);
          AppMethodBeat.o(195949);
        }
        if (i > 0)
        {
          AppMethodBeat.o(195949);
          return true;
        }
        AppMethodBeat.o(195949);
        return false;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.i.a
 * JD-Core Version:    0.7.0.1
 */