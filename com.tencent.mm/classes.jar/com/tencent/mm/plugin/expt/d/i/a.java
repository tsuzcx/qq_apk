package com.tencent.mm.plugin.expt.d.i;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.b.g;

public final class a
{
  private e jHa;
  private String qQs;
  private List<com.tencent.mm.plugin.expt.d.e.a.a> qQt;
  
  public a(e parame, String paramString, List<com.tencent.mm.plugin.expt.d.e.a.a> paramList)
  {
    this.jHa = parame;
    this.qQs = paramString;
    this.qQt = paramList;
  }
  
  private static String CP(int paramInt)
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
  
  private boolean ado(String paramString)
  {
    boolean bool1 = true;
    AppMethodBeat.i(210291);
    if ((this.jHa == null) || (g.ea(this.qQs)) || (g.ea(paramString)))
    {
      AppMethodBeat.o(210291);
      return false;
    }
    String str2 = adq(this.qQs);
    if (g.ea(str2))
    {
      AppMethodBeat.o(210291);
      return false;
    }
    localObject = null;
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = this.jHa.rawQuery("select * from sqlite_master where name = ? and sql like ?;", new String[] { str2, "%" + paramString + "%" });
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
        ad.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkColumnExist throw Exception : " + paramString.getMessage());
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
        AppMethodBeat.o(210291);
      }
      AppMethodBeat.o(210291);
      return bool2;
      bool1 = false;
    }
  }
  
  private static String adp(String paramString)
  {
    AppMethodBeat.i(210292);
    if (g.ea(paramString))
    {
      AppMethodBeat.o(210292);
      return null;
    }
    paramString = paramString + "_ ";
    AppMethodBeat.o(210292);
    return paramString;
  }
  
  private static String adq(String paramString)
  {
    AppMethodBeat.i(210293);
    if (g.ea(paramString))
    {
      AppMethodBeat.o(210293);
      return null;
    }
    paramString = "ec_data_table_".concat(String.valueOf(paramString));
    AppMethodBeat.o(210293);
    return paramString;
  }
  
  public final boolean cY(List<b> paramList)
  {
    Object localObject1 = null;
    AppMethodBeat.i(210288);
    if ((this.jHa == null) || (g.ea(this.qQs)) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(210288);
      return false;
    }
    String str1 = adq(this.qQs);
    if (g.ea(str1))
    {
      AppMethodBeat.o(210288);
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      String str2 = adp(localb.name);
      if (!g.ea(str2)) {
        if (localb.type == 0) {
          localContentValues.put(str2, localb.stringValue);
        } else if (localb.type == 1) {
          localContentValues.put(str2, Integer.valueOf(localb.intValue));
        } else if (localb.type == 2) {
          localContentValues.put(str2, Long.valueOf(localb.qQe));
        }
      }
    }
    ad.d("EdgeComputingDataDao", "[EdgeComputingDataDao] insert tableName : ".concat(String.valueOf(str1)));
    paramList = localObject1;
    if ((this.jHa instanceof h)) {
      paramList = (h)this.jHa;
    }
    long l2;
    if (paramList != null) {
      l2 = paramList.xO(-1L);
    }
    for (;;)
    {
      try
      {
        l1 = paramList.a(str1, null, localContentValues);
        paramList.sJ(l2);
      }
      catch (Exception localException)
      {
        ad.e("EdgeComputingDataDao", "[EdgeComputingDataDao] insert throw Exception : " + localException.getMessage());
        paramList.sJ(l2);
        l1 = -1L;
        continue;
      }
      finally
      {
        paramList.sJ(l2);
        AppMethodBeat.o(210288);
      }
      if (l1 == -1L)
      {
        AppMethodBeat.o(210288);
        return false;
      }
      AppMethodBeat.o(210288);
      return true;
      long l1 = -1L;
    }
  }
  
  public final boolean cno()
  {
    bool2 = false;
    AppMethodBeat.i(210284);
    if ((this.jHa == null) || (g.ea(this.qQs)))
    {
      AppMethodBeat.o(210284);
      return false;
    }
    Object localObject4 = adq(this.qQs);
    if (g.ea((String)localObject4))
    {
      AppMethodBeat.o(210284);
      return false;
    }
    localObject3 = null;
    localObject1 = null;
    try
    {
      localObject4 = this.jHa.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { localObject4 });
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
        ad.e("EdgeComputingDataDao", "[EdgeComputingDataDao] checkTableExist throw Exception : " + localException.getMessage());
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
      AppMethodBeat.o(210284);
    }
    AppMethodBeat.o(210284);
    return bool1;
  }
  
  public final boolean cnp()
  {
    AppMethodBeat.i(210285);
    if ((this.jHa == null) || (g.ea(this.qQs)) || (this.qQt == null) || (this.qQt.size() <= 0))
    {
      AppMethodBeat.o(210285);
      return false;
    }
    String str1 = adq(this.qQs);
    if (g.ea(str1))
    {
      AppMethodBeat.o(210285);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + str1 + " ( ");
    Object localObject1 = this.qQt.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (com.tencent.mm.plugin.expt.d.e.a.a)((Iterator)localObject1).next();
      String str2 = CP(((com.tencent.mm.plugin.expt.d.e.a.a)localObject3).type);
      localObject3 = adp(((com.tencent.mm.plugin.expt.d.e.a.a)localObject3).name);
      if ((!g.ea(str2)) && (!g.ea((String)localObject3))) {
        localStringBuilder.append((String)localObject3).append(" ").append(str2).append(",");
      }
    }
    if (localStringBuilder.toString().endsWith(",")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(");");
    ad.i("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s", new Object[] { str1 });
    ad.d("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable tableName : %s, createTableSQL : %s", new Object[] { str1, localStringBuilder.toString() });
    if ((this.jHa instanceof h)) {}
    for (localObject1 = (h)this.jHa;; localObject1 = null)
    {
      long l;
      if (localObject1 != null) {
        l = ((h)localObject1).xO(-1L);
      }
      for (;;)
      {
        try
        {
          bool = ((h)localObject1).execSQL(str1, localStringBuilder.toString());
          ((h)localObject1).sJ(l);
        }
        catch (Exception localException)
        {
          ad.e("EdgeComputingDataDao", "[EdgeComputingDataDao] createTable throw Exception : " + localException.getMessage());
          ((h)localObject1).sJ(l);
          bool = false;
          continue;
        }
        finally
        {
          ((h)localObject1).sJ(l);
          AppMethodBeat.o(210285);
        }
        AppMethodBeat.o(210285);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  public final void cnq()
  {
    AppMethodBeat.i(210286);
    if ((this.jHa == null) || (g.ea(this.qQs)) || (this.qQt == null) || (this.qQt.size() <= 0))
    {
      AppMethodBeat.o(210286);
      return;
    }
    String str1 = adq(this.qQs);
    if (g.ea(str1))
    {
      AppMethodBeat.o(210286);
      return;
    }
    if ((this.jHa instanceof h)) {}
    for (h localh = (h)this.jHa;; localh = null)
    {
      if (localh != null)
      {
        Iterator localIterator = this.qQt.iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = (com.tencent.mm.plugin.expt.d.e.a.a)localIterator.next();
          String str2 = CP(((com.tencent.mm.plugin.expt.d.e.a.a)localObject2).type);
          localObject2 = adp(((com.tencent.mm.plugin.expt.d.e.a.a)localObject2).name);
          if ((!g.ea(str2)) && (!g.ea((String)localObject2)) && (!ado((String)localObject2)))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("ALTER TABLE ").append(str1).append(" ADD ");
            localStringBuilder.append((String)localObject2).append(" ").append(str2).append(";");
            ad.i("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s", new Object[] { str1 });
            ad.d("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, updateTableSQL : %s", new Object[] { str1, localStringBuilder.toString() });
            long l = localh.xO(-1L);
            try
            {
              ad.d("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable tableName : %s, result : %d, updateTableSQL : %s", new Object[] { str1, Boolean.valueOf(localh.execSQL(str1, localStringBuilder.toString())), localStringBuilder.toString() });
              localh.sJ(l);
            }
            catch (Exception localException)
            {
              ad.e("EdgeComputingDataDao", "[EdgeComputingDataDao] updateTable throw Exception : " + localException.getMessage());
              localh.sJ(l);
            }
            finally
            {
              localh.sJ(l);
              AppMethodBeat.o(210286);
            }
          }
        }
      }
      AppMethodBeat.o(210286);
      return;
    }
  }
  
  public final boolean cnr()
  {
    AppMethodBeat.i(210287);
    if ((this.jHa == null) || (g.ea(this.qQs)))
    {
      AppMethodBeat.o(210287);
      return false;
    }
    String str1 = adq(this.qQs);
    if (g.ea(str1))
    {
      AppMethodBeat.o(210287);
      return false;
    }
    String str2 = "DROP TABLE IF EXISTS ".concat(String.valueOf(str1));
    ad.i("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s", new Object[] { str1 });
    ad.d("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable tableName : %s, dropSql : %s", new Object[] { str1, str2 });
    if ((this.jHa instanceof h)) {}
    for (h localh = (h)this.jHa;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.xO(-1L);
      }
      for (;;)
      {
        try
        {
          bool = localh.execSQL(str1, str2);
          localh.sJ(l);
        }
        catch (Exception localException)
        {
          ad.e("EdgeComputingDataDao", "[EdgeComputingDataDao] dropTable throw Exception : " + localException.getMessage());
          localh.sJ(l);
          bool = false;
          continue;
        }
        finally
        {
          localh.sJ(l);
          AppMethodBeat.o(210287);
        }
        AppMethodBeat.o(210287);
        return bool;
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  public final List<List<b>> cns()
  {
    // Byte code:
    //   0: ldc_w 296
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 18	com/tencent/mm/plugin/expt/d/i/a:jHa	Lcom/tencent/mm/sdk/e/e;
    //   10: ifnull +32 -> 42
    //   13: aload_0
    //   14: getfield 20	com/tencent/mm/plugin/expt/d/i/a:qQs	Ljava/lang/String;
    //   17: invokestatic 47	org/apache/commons/b/g:ea	(Ljava/lang/String;)Z
    //   20: ifne +22 -> 42
    //   23: aload_0
    //   24: getfield 22	com/tencent/mm/plugin/expt/d/i/a:qQt	Ljava/util/List;
    //   27: ifnull +15 -> 42
    //   30: aload_0
    //   31: getfield 22	com/tencent/mm/plugin/expt/d/i/a:qQt	Ljava/util/List;
    //   34: invokeinterface 128 1 0
    //   39: ifgt +11 -> 50
    //   42: ldc_w 296
    //   45: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aconst_null
    //   49: areturn
    //   50: aload_0
    //   51: getfield 20	com/tencent/mm/plugin/expt/d/i/a:qQs	Ljava/lang/String;
    //   54: invokestatic 54	com/tencent/mm/plugin/expt/d/i/a:adq	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore 5
    //   59: aload 5
    //   61: invokestatic 47	org/apache/commons/b/g:ea	(Ljava/lang/String;)Z
    //   64: ifeq +11 -> 75
    //   67: ldc_w 296
    //   70: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   73: aconst_null
    //   74: areturn
    //   75: aload_0
    //   76: getfield 18	com/tencent/mm/plugin/expt/d/i/a:jHa	Lcom/tencent/mm/sdk/e/e;
    //   79: aload 5
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokeinterface 300 8 0
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +399 -> 493
    //   97: aload_2
    //   98: astore_3
    //   99: new 302	java/util/LinkedList
    //   102: dup
    //   103: invokespecial 303	java/util/LinkedList:<init>	()V
    //   106: astore_1
    //   107: aload_2
    //   108: astore_3
    //   109: aload_2
    //   110: invokeinterface 215 1 0
    //   115: ifeq +328 -> 443
    //   118: aload_2
    //   119: astore_3
    //   120: new 305	java/util/ArrayList
    //   123: dup
    //   124: invokespecial 306	java/util/ArrayList:<init>	()V
    //   127: astore 4
    //   129: aload_2
    //   130: astore_3
    //   131: aload_0
    //   132: getfield 22	com/tencent/mm/plugin/expt/d/i/a:qQt	Ljava/util/List;
    //   135: invokeinterface 135 1 0
    //   140: astore 6
    //   142: aload_2
    //   143: astore_3
    //   144: aload 6
    //   146: invokeinterface 140 1 0
    //   151: ifeq +278 -> 429
    //   154: aload_2
    //   155: astore_3
    //   156: aload 6
    //   158: invokeinterface 144 1 0
    //   163: checkcast 225	com/tencent/mm/plugin/expt/d/e/a/a
    //   166: astore 7
    //   168: aload_2
    //   169: astore_3
    //   170: new 146	com/tencent/mm/plugin/expt/d/e/b
    //   173: dup
    //   174: invokespecial 307	com/tencent/mm/plugin/expt/d/e/b:<init>	()V
    //   177: astore 8
    //   179: aload_2
    //   180: astore_3
    //   181: aload 8
    //   183: aload 7
    //   185: getfield 229	com/tencent/mm/plugin/expt/d/e/a/a:name	Ljava/lang/String;
    //   188: putfield 149	com/tencent/mm/plugin/expt/d/e/b:name	Ljava/lang/String;
    //   191: aload_2
    //   192: astore_3
    //   193: aload 8
    //   195: aload 7
    //   197: getfield 310	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   200: putfield 311	com/tencent/mm/plugin/expt/d/e/b:index	I
    //   203: aload_2
    //   204: astore_3
    //   205: aload 8
    //   207: aload 7
    //   209: getfield 226	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   212: putfield 155	com/tencent/mm/plugin/expt/d/e/b:type	I
    //   215: aload_2
    //   216: astore_3
    //   217: aload 7
    //   219: getfield 226	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   222: ifne +115 -> 337
    //   225: aload_2
    //   226: astore_3
    //   227: aload 8
    //   229: aload_2
    //   230: aload 7
    //   232: getfield 310	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   235: invokeinterface 314 2 0
    //   240: putfield 158	com/tencent/mm/plugin/expt/d/e/b:stringValue	Ljava/lang/String;
    //   243: aload_2
    //   244: astore_3
    //   245: aload 4
    //   247: aload 8
    //   249: invokeinterface 318 2 0
    //   254: pop
    //   255: goto -113 -> 142
    //   258: astore 4
    //   260: aload_2
    //   261: astore_3
    //   262: ldc 93
    //   264: new 60	java/lang/StringBuilder
    //   267: dup
    //   268: ldc_w 320
    //   271: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: aload 4
    //   276: invokevirtual 98	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 104	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_1
    //   289: astore_3
    //   290: aload_2
    //   291: ifnull +22 -> 313
    //   294: aload_1
    //   295: astore_3
    //   296: aload_2
    //   297: invokeinterface 88 1 0
    //   302: ifne +11 -> 313
    //   305: aload_2
    //   306: invokeinterface 91 1 0
    //   311: aload_1
    //   312: astore_3
    //   313: ldc 93
    //   315: ldc_w 322
    //   318: aload 5
    //   320: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   323: invokevirtual 119	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   326: invokestatic 324	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: ldc_w 296
    //   332: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload_3
    //   336: areturn
    //   337: aload_2
    //   338: astore_3
    //   339: aload 7
    //   341: getfield 226	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   344: iconst_1
    //   345: if_icmpne +52 -> 397
    //   348: aload_2
    //   349: astore_3
    //   350: aload 8
    //   352: aload_2
    //   353: aload 7
    //   355: getfield 310	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   358: invokeinterface 328 2 0
    //   363: putfield 164	com/tencent/mm/plugin/expt/d/e/b:intValue	I
    //   366: goto -123 -> 243
    //   369: astore_1
    //   370: aload_3
    //   371: ifnull +18 -> 389
    //   374: aload_3
    //   375: invokeinterface 88 1 0
    //   380: ifne +9 -> 389
    //   383: aload_3
    //   384: invokeinterface 91 1 0
    //   389: ldc_w 296
    //   392: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   395: aload_1
    //   396: athrow
    //   397: aload_2
    //   398: astore_3
    //   399: aload 7
    //   401: getfield 226	com/tencent/mm/plugin/expt/d/e/a/a:type	I
    //   404: iconst_2
    //   405: if_icmpne -162 -> 243
    //   408: aload_2
    //   409: astore_3
    //   410: aload 8
    //   412: aload_2
    //   413: aload 7
    //   415: getfield 310	com/tencent/mm/plugin/expt/d/e/a/a:index	I
    //   418: invokeinterface 332 2 0
    //   423: putfield 176	com/tencent/mm/plugin/expt/d/e/b:qQe	J
    //   426: goto -183 -> 243
    //   429: aload_2
    //   430: astore_3
    //   431: aload_1
    //   432: aload 4
    //   434: invokeinterface 318 2 0
    //   439: pop
    //   440: goto -333 -> 107
    //   443: aload_1
    //   444: astore_3
    //   445: aload_2
    //   446: ifnull -133 -> 313
    //   449: aload_1
    //   450: astore_3
    //   451: aload_2
    //   452: invokeinterface 88 1 0
    //   457: ifne -144 -> 313
    //   460: aload_2
    //   461: invokeinterface 91 1 0
    //   466: aload_1
    //   467: astore_3
    //   468: goto -155 -> 313
    //   471: astore_1
    //   472: aconst_null
    //   473: astore_3
    //   474: goto -104 -> 370
    //   477: astore 4
    //   479: aconst_null
    //   480: astore_2
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -223 -> 260
    //   486: astore 4
    //   488: aconst_null
    //   489: astore_1
    //   490: goto -230 -> 260
    //   493: aconst_null
    //   494: astore_1
    //   495: goto -52 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	498	0	this	a
    //   106	206	1	localLinkedList	java.util.LinkedList
    //   369	98	1	localObject1	Object
    //   471	1	1	localObject2	Object
    //   482	13	1	localObject3	Object
    //   92	389	2	localCursor	Cursor
    //   98	376	3	localObject4	Object
    //   127	119	4	localArrayList	java.util.ArrayList
    //   258	175	4	localException1	Exception
    //   477	1	4	localException2	Exception
    //   486	1	4	localException3	Exception
    //   57	262	5	str	String
    //   140	17	6	localIterator	Iterator
    //   166	248	7	locala	com.tencent.mm.plugin.expt.d.e.a.a
    //   177	234	8	localb	b
    // Exception table:
    //   from	to	target	type
    //   109	118	258	java/lang/Exception
    //   120	129	258	java/lang/Exception
    //   131	142	258	java/lang/Exception
    //   144	154	258	java/lang/Exception
    //   156	168	258	java/lang/Exception
    //   170	179	258	java/lang/Exception
    //   181	191	258	java/lang/Exception
    //   193	203	258	java/lang/Exception
    //   205	215	258	java/lang/Exception
    //   217	225	258	java/lang/Exception
    //   227	243	258	java/lang/Exception
    //   245	255	258	java/lang/Exception
    //   339	348	258	java/lang/Exception
    //   350	366	258	java/lang/Exception
    //   399	408	258	java/lang/Exception
    //   410	426	258	java/lang/Exception
    //   431	440	258	java/lang/Exception
    //   99	107	369	finally
    //   109	118	369	finally
    //   120	129	369	finally
    //   131	142	369	finally
    //   144	154	369	finally
    //   156	168	369	finally
    //   170	179	369	finally
    //   181	191	369	finally
    //   193	203	369	finally
    //   205	215	369	finally
    //   217	225	369	finally
    //   227	243	369	finally
    //   245	255	369	finally
    //   262	288	369	finally
    //   339	348	369	finally
    //   350	366	369	finally
    //   399	408	369	finally
    //   410	426	369	finally
    //   431	440	369	finally
    //   75	93	471	finally
    //   75	93	477	java/lang/Exception
    //   99	107	486	java/lang/Exception
  }
  
  public final boolean uS(long paramLong)
  {
    AppMethodBeat.i(210289);
    if ((this.jHa == null) || (g.ea(this.qQs)))
    {
      AppMethodBeat.o(210289);
      return false;
    }
    String str = adq(this.qQs);
    if (g.ea(str))
    {
      AppMethodBeat.o(210289);
      return false;
    }
    ad.i("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire tableName : " + str + ", expireTimestamp : " + paramLong);
    if ((this.jHa instanceof h)) {}
    for (h localh = (h)this.jHa;; localh = null)
    {
      long l;
      if (localh != null) {
        l = localh.xO(-1L);
      }
      for (;;)
      {
        try
        {
          i = localh.delete(str, adp("report_time_ec") + " < ?", new String[] { String.valueOf(paramLong) });
          localh.sJ(l);
        }
        catch (Exception localException)
        {
          ad.e("EdgeComputingDataDao", "[EdgeComputingDataDao] deleteExpire throw Exception : " + localException.getMessage());
          localh.sJ(l);
          i = 0;
          continue;
        }
        finally
        {
          localh.sJ(l);
          AppMethodBeat.o(210289);
        }
        if (i > 0)
        {
          AppMethodBeat.o(210289);
          return true;
        }
        AppMethodBeat.o(210289);
        return false;
        int i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.i.a
 * JD-Core Version:    0.7.0.1
 */