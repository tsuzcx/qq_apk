package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class a
  implements i
{
  private volatile boolean cCu;
  private f<String, String> rnh;
  public volatile h rni;
  protected SQLiteStatement rnj;
  private SQLiteStatement rnk;
  private SQLiteStatement rnl;
  private SQLiteStatement rnm;
  private SQLiteStatement rnn;
  public SQLiteStatement rno;
  private SQLiteStatement rnp;
  protected SQLiteStatement rnq;
  
  public a()
  {
    ad.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", new Object[] { getName() });
  }
  
  private static String dh(String paramString, int paramInt)
  {
    return paramString + "​" + paramInt;
  }
  
  public final void U(long paramLong1, long paramLong2)
  {
    this.rni.U(paramLong1, paramLong2);
  }
  
  public final Cursor a(com.tencent.mm.plugin.fts.a.a.h paramh, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = paramh.cxk();
    label72:
    label101:
    StringBuilder localStringBuilder;
    if (paramBoolean1)
    {
      paramh = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { cxf(), Integer.valueOf(paramh.rpu.size()) });
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label238;
      }
      paramArrayOfInt2 = " AND subtype IN " + d.z(paramArrayOfInt2);
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label244;
      }
      paramArrayOfInt1 = " AND type IN " + d.z(paramArrayOfInt1);
      localStringBuilder = new StringBuilder("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp");
      if (!paramBoolean2) {
        break label250;
      }
    }
    label238:
    label244:
    label250:
    for (String str1 = ", content";; str1 = "")
    {
      paramh = String.format(str1 + paramh + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramArrayOfInt1 + "" + " AND status >= 0" + paramArrayOfInt2 + ";", new Object[] { cxe(), cxe(), cxf(), cxe(), cxf(), cxf(), str2 });
      return this.rni.rawQuery(paramh, null);
      paramh = "";
      break;
      paramArrayOfInt2 = "";
      break label72;
      paramArrayOfInt1 = "";
      break label101;
    }
  }
  
  public final Cursor a(int[] paramArrayOfInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3) && (!paramBoolean4) && (!paramBoolean5)) {
      return com.tencent.mm.storagebase.d.eNU();
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return com.tencent.mm.storagebase.d.eNU();
    }
    Object localObject = new StringBuilder(64);
    if (paramBoolean1) {
      ((StringBuilder)localObject).append("docid,");
    }
    if (paramBoolean2) {
      ((StringBuilder)localObject).append("entity_id,");
    }
    if (paramBoolean3) {
      ((StringBuilder)localObject).append("aux_index,");
    }
    if (paramBoolean4) {
      ((StringBuilder)localObject).append("timestamp,");
    }
    if (paramBoolean5) {
      ((StringBuilder)localObject).append("status,");
    }
    ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
    localObject = ((StringBuilder)localObject).toString();
    paramArrayOfInt = String.format("SELECT %s FROM %s WHERE type IN " + d.z(paramArrayOfInt) + ";", new Object[] { localObject, cxe() });
    return this.rni.rawQuery(paramArrayOfInt, null);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    paramString2 = d.aaX(paramString2);
    if (bt.isNullOrNil(paramString2)) {}
    for (;;)
    {
      return;
      boolean bool = this.rni.inTransaction();
      if (!bool) {
        this.rni.beginTransaction();
      }
      try
      {
        this.rnj.bindString(1, paramString2);
        this.rnj.execute();
        this.rnk.bindLong(1, paramInt1);
        this.rnk.bindLong(2, paramInt2);
        this.rnk.bindLong(3, paramLong1);
        this.rnk.bindString(4, paramString1);
        this.rnk.bindLong(5, paramLong2);
        this.rnk.execute();
        if (!bool) {
          this.rni.commit();
        }
        if (!cxg()) {
          continue;
        }
        this.rnh.put(dh(paramString1, paramInt2), paramString2);
        return;
      }
      catch (SQLiteException paramString2)
      {
        ad.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
        paramString1 = this.rnq.simpleQueryForString();
        if ((paramString1 != null) && (paramString1.length() > 0)) {
          ad.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> ".concat(String.valueOf(paramString1)));
        }
        throw paramString2;
      }
    }
  }
  
  public final void a(int[] paramArrayOfInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.z(paramArrayOfInt) + " AND aux_index=?;", new Object[] { cxe() });
    paramArrayOfInt = this.rni.rawQuery(paramArrayOfInt, new String[] { paramString });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    dD(localArrayList);
  }
  
  public final void aaV(String paramString)
  {
    Object localObject = new HashSet();
    Iterator localIterator = this.rnh.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith(paramString)) {
        ((HashSet)localObject).add(str);
      }
    }
    paramString = ((HashSet)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      this.rnh.remove(localObject);
    }
  }
  
  protected abstract void acM();
  
  protected boolean acN()
  {
    return false;
  }
  
  protected boolean acO()
  {
    if (this.rnj != null) {
      this.rnj.close();
    }
    if (this.rnk != null) {
      this.rnk.close();
    }
    if (this.rnl != null) {
      this.rnl.close();
    }
    if (this.rnm != null) {
      this.rnm.close();
    }
    if (this.rnn != null) {
      this.rnn.close();
    }
    if (this.rnq != null) {
      this.rnq.close();
    }
    if (this.rnh != null) {
      this.rnh.clear();
    }
    this.rni = null;
    return true;
  }
  
  public final void aq(String paramString, long paramLong)
  {
    this.rnp.bindLong(1, paramLong);
    this.rnp.bindString(2, paramString);
    this.rnp.execute();
  }
  
  public final List<Long> b(int[] paramArrayOfInt, String paramString)
  {
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.z(paramArrayOfInt) + ";", new Object[] { cxe() });
    paramArrayOfInt = this.rni.rawQuery(paramArrayOfInt, new String[] { paramString });
    paramString = new ArrayList();
    while (paramArrayOfInt.moveToNext()) {
      paramString.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    o(paramString, 1);
    return paramString;
  }
  
  public final void beginTransaction()
  {
    this.rni.beginTransaction();
  }
  
  public final void c(int[] paramArrayOfInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.z(paramArrayOfInt) + " AND entity_id=?;", new Object[] { cxe() });
    paramArrayOfInt = this.rni.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    dD(localArrayList);
  }
  
  protected String ciy()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { cxe() });
  }
  
  public final void commit()
  {
    this.rni.commit();
  }
  
  /* Error */
  public final void create()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 28
    //   4: ldc_w 346
    //   7: iconst_2
    //   8: anewarray 4	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_0
    //   14: invokevirtual 34	com/tencent/mm/plugin/fts/a/a:getName	()Ljava/lang/String;
    //   17: aastore
    //   18: dup
    //   19: iconst_1
    //   20: aload_0
    //   21: getfield 348	com/tencent/mm/plugin/fts/a/a:cCu	Z
    //   24: invokestatic 353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_0
    //   32: getfield 348	com/tencent/mm/plugin/fts/a/a:cCu	Z
    //   35: ifne +47 -> 82
    //   38: ldc_w 355
    //   41: invokestatic 361	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   44: checkcast 355	com/tencent/mm/plugin/fts/a/n
    //   47: invokeinterface 364 1 0
    //   52: ifne +33 -> 85
    //   55: ldc 28
    //   57: ldc_w 366
    //   60: invokestatic 368	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: ifeq +16 -> 82
    //   69: ldc 28
    //   71: ldc_w 370
    //   74: invokestatic 368	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: iconst_1
    //   79: putfield 348	com/tencent/mm/plugin/fts/a/a:cCu	Z
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: ldc_w 355
    //   89: invokestatic 361	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   92: checkcast 355	com/tencent/mm/plugin/fts/a/n
    //   95: invokeinterface 374 1 0
    //   100: putfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   103: ldc 28
    //   105: ldc_w 376
    //   108: invokestatic 368	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 78	com/tencent/mm/plugin/fts/a/a:cxf	()Ljava/lang/String;
    //   115: astore_3
    //   116: aload_0
    //   117: invokevirtual 128	com/tencent/mm/plugin/fts/a/a:cxe	()Ljava/lang/String;
    //   120: astore_2
    //   121: ldc 28
    //   123: ldc_w 378
    //   126: iconst_3
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_3
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: aload_2
    //   137: aastore
    //   138: dup
    //   139: iconst_2
    //   140: aload_0
    //   141: invokevirtual 381	com/tencent/mm/plugin/fts/a/a:getTableName	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 40	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   152: aload_3
    //   153: invokeinterface 384 2 0
    //   158: ifeq +276 -> 434
    //   161: aload_0
    //   162: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   165: aload_2
    //   166: invokeinterface 384 2 0
    //   171: ifeq +263 -> 434
    //   174: aload_0
    //   175: invokevirtual 386	com/tencent/mm/plugin/fts/a/a:acN	()Z
    //   178: ifne +256 -> 434
    //   181: ldc 28
    //   183: ldc_w 388
    //   186: invokestatic 368	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: ldc_w 390
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_3
    //   199: aastore
    //   200: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   203: astore 4
    //   205: aload_0
    //   206: aload_0
    //   207: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   210: aload 4
    //   212: invokeinterface 394 2 0
    //   217: putfield 182	com/tencent/mm/plugin/fts/a/a:rnj	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   220: ldc_w 396
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_2
    //   230: aastore
    //   231: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   234: astore 4
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   241: aload 4
    //   243: invokeinterface 394 2 0
    //   248: putfield 193	com/tencent/mm/plugin/fts/a/a:rnk	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   251: ldc_w 398
    //   254: iconst_1
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload_3
    //   261: aastore
    //   262: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   265: astore_3
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   271: aload_3
    //   272: invokeinterface 394 2 0
    //   277: putfield 304	com/tencent/mm/plugin/fts/a/a:rnl	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   280: ldc_w 400
    //   283: iconst_1
    //   284: anewarray 4	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload_2
    //   290: aastore
    //   291: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   294: astore_3
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   300: aload_3
    //   301: invokeinterface 394 2 0
    //   306: putfield 306	com/tencent/mm/plugin/fts/a/a:rnm	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   309: ldc_w 402
    //   312: iconst_1
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload_2
    //   319: aastore
    //   320: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   323: astore_3
    //   324: aload_0
    //   325: aload_0
    //   326: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   329: aload_3
    //   330: invokeinterface 394 2 0
    //   335: putfield 308	com/tencent/mm/plugin/fts/a/a:rnn	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   338: ldc_w 404
    //   341: iconst_1
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload_2
    //   348: aastore
    //   349: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   352: astore_3
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   358: aload_3
    //   359: invokeinterface 394 2 0
    //   364: putfield 406	com/tencent/mm/plugin/fts/a/a:rno	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   367: ldc_w 408
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_2
    //   377: aastore
    //   378: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   381: astore_2
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   387: aload_2
    //   388: invokeinterface 394 2 0
    //   393: putfield 315	com/tencent/mm/plugin/fts/a/a:rnp	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   396: aload_0
    //   397: aload_0
    //   398: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   401: ldc_w 410
    //   404: invokeinterface 394 2 0
    //   409: putfield 226	com/tencent/mm/plugin/fts/a/a:rnq	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   412: aload_0
    //   413: new 412	com/tencent/mm/b/h
    //   416: dup
    //   417: bipush 100
    //   419: invokespecial 413	com/tencent/mm/b/h:<init>	(I)V
    //   422: putfield 205	com/tencent/mm/plugin/fts/a/a:rnh	Lcom/tencent/mm/b/f;
    //   425: aload_0
    //   426: invokevirtual 415	com/tencent/mm/plugin/fts/a/a:acM	()V
    //   429: iconst_1
    //   430: istore_1
    //   431: goto -366 -> 65
    //   434: ldc 28
    //   436: ldc_w 417
    //   439: invokestatic 368	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: ldc_w 419
    //   445: iconst_1
    //   446: anewarray 4	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: aload_3
    //   452: aastore
    //   453: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   456: astore 4
    //   458: ldc_w 419
    //   461: iconst_1
    //   462: anewarray 4	java/lang/Object
    //   465: dup
    //   466: iconst_0
    //   467: aload_2
    //   468: aastore
    //   469: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   472: astore 5
    //   474: aload_0
    //   475: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   478: aload 4
    //   480: invokeinterface 422 2 0
    //   485: aload_0
    //   486: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   489: aload 5
    //   491: invokeinterface 422 2 0
    //   496: ldc_w 424
    //   499: iconst_1
    //   500: anewarray 4	java/lang/Object
    //   503: dup
    //   504: iconst_0
    //   505: aload_0
    //   506: invokevirtual 78	com/tencent/mm/plugin/fts/a/a:cxf	()Ljava/lang/String;
    //   509: aastore
    //   510: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   513: astore 4
    //   515: aload_0
    //   516: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   519: aload 4
    //   521: invokeinterface 422 2 0
    //   526: aload_0
    //   527: invokevirtual 426	com/tencent/mm/plugin/fts/a/a:ciy	()Ljava/lang/String;
    //   530: astore 4
    //   532: aload_0
    //   533: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   536: aload 4
    //   538: invokeinterface 422 2 0
    //   543: ldc_w 428
    //   546: iconst_2
    //   547: anewarray 4	java/lang/Object
    //   550: dup
    //   551: iconst_0
    //   552: aload_2
    //   553: aastore
    //   554: dup
    //   555: iconst_1
    //   556: aload_2
    //   557: aastore
    //   558: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   561: astore 4
    //   563: aload_0
    //   564: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   567: aload 4
    //   569: invokeinterface 422 2 0
    //   574: ldc_w 430
    //   577: iconst_2
    //   578: anewarray 4	java/lang/Object
    //   581: dup
    //   582: iconst_0
    //   583: aload_2
    //   584: aastore
    //   585: dup
    //   586: iconst_1
    //   587: aload_2
    //   588: aastore
    //   589: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   592: astore 4
    //   594: aload_0
    //   595: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   598: aload 4
    //   600: invokeinterface 422 2 0
    //   605: ldc_w 432
    //   608: iconst_2
    //   609: anewarray 4	java/lang/Object
    //   612: dup
    //   613: iconst_0
    //   614: aload_2
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: aload_2
    //   619: aastore
    //   620: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   623: astore 4
    //   625: aload_0
    //   626: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   629: aload 4
    //   631: invokeinterface 422 2 0
    //   636: ldc_w 434
    //   639: iconst_2
    //   640: anewarray 4	java/lang/Object
    //   643: dup
    //   644: iconst_0
    //   645: aload_2
    //   646: aastore
    //   647: dup
    //   648: iconst_1
    //   649: aload_2
    //   650: aastore
    //   651: invokestatic 100	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   654: astore 4
    //   656: aload_0
    //   657: getfield 62	com/tencent/mm/plugin/fts/a/a:rni	Lcom/tencent/mm/plugin/fts/a/h;
    //   660: aload 4
    //   662: invokeinterface 422 2 0
    //   667: goto -478 -> 189
    //   670: astore_2
    //   671: aload_0
    //   672: monitorexit
    //   673: aload_2
    //   674: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	675	0	this	a
    //   64	367	1	i	int
    //   120	530	2	str1	String
    //   670	4	2	localObject	Object
    //   115	337	3	str2	String
    //   203	458	4	str3	String
    //   472	18	5	str4	String
    // Exception table:
    //   from	to	target	type
    //   2	63	670	finally
    //   69	82	670	finally
    //   85	189	670	finally
    //   189	429	670	finally
    //   434	667	670	finally
  }
  
  public final String cxe()
  {
    return "FTS5Meta" + getTableName();
  }
  
  public final String cxf()
  {
    return "FTS5Index" + getTableName();
  }
  
  protected boolean cxg()
  {
    return false;
  }
  
  public final void dD(List<Long> paramList)
  {
    boolean bool = this.rni.inTransaction();
    if (!bool) {
      this.rni.beginTransaction();
    }
    Iterator localIterator = paramList.iterator();
    long l;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      this.rnl.bindLong(1, l);
      this.rnl.execute();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l = ((Long)paramList.next()).longValue();
      this.rnm.bindLong(1, l);
      this.rnm.execute();
    }
    if (!bool) {
      commit();
    }
  }
  
  public final void destroy()
  {
    ad.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.cCu) });
    if ((this.cCu) && (acO()))
    {
      ad.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
      this.cCu = false;
    }
  }
  
  public final String di(String paramString, int paramInt)
  {
    if (cxg())
    {
      localObject = dh(paramString, paramInt);
      if (this.rnh.aN(localObject))
      {
        ad.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
        return (String)this.rnh.get(localObject);
      }
    }
    Object localObject = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[] { cxe(), cxf(), cxe(), cxf() });
    localObject = this.rni.rawQuery((String)localObject, new String[] { paramString, String.valueOf(paramInt) });
    paramString = null;
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    return paramString;
  }
  
  public final boolean fH(int paramInt1, int paramInt2)
  {
    return this.rni.fH(paramInt1, paramInt2);
  }
  
  public final List<b> g(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.z(paramArrayOfInt) + ";", new Object[] { cxe() });
    paramArrayOfInt = this.rni.rawQuery(paramArrayOfInt, null);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    while (paramArrayOfInt.moveToNext())
    {
      b localb = new b();
      localb.g(paramArrayOfInt);
      localArrayList1.add(localb);
      localArrayList2.add(Long.valueOf(localb.roL));
    }
    paramArrayOfInt.close();
    o(localArrayList2, paramInt);
    return localArrayList1;
  }
  
  protected String getTableName()
  {
    return "Common";
  }
  
  public final void o(List<Long> paramList, int paramInt)
  {
    boolean bool = this.rni.inTransaction();
    if (!bool) {
      this.rni.beginTransaction();
    }
    this.rnn.bindLong(1, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = ((Long)paramList.next()).longValue();
      this.rnn.bindLong(2, l);
      this.rnn.execute();
    }
    if (!bool) {
      this.rni.commit();
    }
  }
  
  public final void qQ(long paramLong)
  {
    boolean bool = this.rni.inTransaction();
    if (!bool) {
      this.rni.beginTransaction();
    }
    this.rnl.bindLong(1, paramLong);
    this.rnl.execute();
    this.rnm.bindLong(1, paramLong);
    this.rnm.execute();
    if (!bool) {
      commit();
    }
  }
  
  public final void y(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(2048);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.z(paramArrayOfInt) + ";", new Object[] { cxe() });
    paramArrayOfInt = this.rni.rawQuery(paramArrayOfInt, null);
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    dD(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a
 * JD-Core Version:    0.7.0.1
 */