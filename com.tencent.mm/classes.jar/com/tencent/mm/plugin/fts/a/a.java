package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private volatile boolean bRJ;
  private f<String, String> mQq;
  public volatile h mQr;
  protected SQLiteStatement mQs;
  private SQLiteStatement mQt;
  private SQLiteStatement mQu;
  private SQLiteStatement mQv;
  private SQLiteStatement mQw;
  public SQLiteStatement mQx;
  private SQLiteStatement mQy;
  protected SQLiteStatement mQz;
  
  public a()
  {
    ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", new Object[] { getName() });
  }
  
  private static String cn(String paramString, int paramInt)
  {
    return paramString + "​" + paramInt;
  }
  
  public final void M(long paramLong1, long paramLong2)
  {
    this.mQr.M(paramLong1, paramLong2);
  }
  
  public final void OX(String paramString)
  {
    Object localObject = new HashSet();
    Iterator localIterator = this.mQq.keySet().iterator();
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
      this.mQq.remove(localObject);
    }
  }
  
  protected abstract void Pn();
  
  protected boolean Po()
  {
    return false;
  }
  
  protected boolean Pp()
  {
    if (this.mQs != null) {
      this.mQs.close();
    }
    if (this.mQt != null) {
      this.mQt.close();
    }
    if (this.mQu != null) {
      this.mQu.close();
    }
    if (this.mQv != null) {
      this.mQv.close();
    }
    if (this.mQw != null) {
      this.mQw.close();
    }
    if (this.mQz != null) {
      this.mQz.close();
    }
    if (this.mQq != null) {
      this.mQq.clear();
    }
    this.mQr = null;
    return true;
  }
  
  public final void W(String paramString, long paramLong)
  {
    this.mQy.bindLong(1, paramLong);
    this.mQy.bindString(2, paramString);
    this.mQy.execute();
  }
  
  public final Cursor a(g paramg, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = paramg.bBX();
    label72:
    label101:
    StringBuilder localStringBuilder;
    if (paramBoolean1)
    {
      paramg = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { bBS(), Integer.valueOf(paramg.mSA.size()) });
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label238;
      }
      paramArrayOfInt2 = " AND subtype IN " + d.v(paramArrayOfInt2);
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label244;
      }
      paramArrayOfInt1 = " AND type IN " + d.v(paramArrayOfInt1);
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
      paramg = String.format(str1 + paramg + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramArrayOfInt1 + "" + " AND status >= 0" + paramArrayOfInt2 + ";", new Object[] { bBR(), bBR(), bBS(), bBR(), bBS(), bBS(), str2 });
      return this.mQr.rawQuery(paramg, null);
      paramg = "";
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
      return com.tencent.mm.cg.d.dzJ();
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return com.tencent.mm.cg.d.dzJ();
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
    paramArrayOfInt = String.format("SELECT %s FROM %s WHERE type IN " + d.v(paramArrayOfInt) + ";", new Object[] { localObject, bBR() });
    return this.mQr.rawQuery(paramArrayOfInt, null);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    paramString2 = d.OZ(paramString2);
    if (bo.isNullOrNil(paramString2)) {}
    for (;;)
    {
      return;
      boolean bool = this.mQr.inTransaction();
      if (!bool) {
        this.mQr.beginTransaction();
      }
      try
      {
        this.mQs.bindString(1, paramString2);
        this.mQs.execute();
        this.mQt.bindLong(1, paramInt1);
        this.mQt.bindLong(2, paramInt2);
        this.mQt.bindLong(3, paramLong1);
        this.mQt.bindString(4, paramString1);
        this.mQt.bindLong(5, paramLong2);
        this.mQt.execute();
        if (!bool) {
          this.mQr.commit();
        }
        if (!bBT()) {
          continue;
        }
        this.mQq.put(cn(paramString1, paramInt2), paramString2);
        return;
      }
      catch (SQLiteException paramString2)
      {
        ab.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
        paramString1 = this.mQz.simpleQueryForString();
        if ((paramString1 != null) && (paramString1.length() > 0)) {
          ab.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> ".concat(String.valueOf(paramString1)));
        }
        throw paramString2;
      }
    }
  }
  
  public final void b(int[] paramArrayOfInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.v(paramArrayOfInt) + " AND aux_index=?;", new Object[] { bBR() });
    paramArrayOfInt = this.mQr.rawQuery(paramArrayOfInt, new String[] { paramString });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    bS(localArrayList);
  }
  
  public final String bBR()
  {
    return "FTS5Meta" + getTableName();
  }
  
  public final String bBS()
  {
    return "FTS5Index" + getTableName();
  }
  
  protected boolean bBT()
  {
    return false;
  }
  
  public final void bS(List<Long> paramList)
  {
    boolean bool = this.mQr.inTransaction();
    if (!bool) {
      this.mQr.beginTransaction();
    }
    Iterator localIterator = paramList.iterator();
    long l;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      this.mQu.bindLong(1, l);
      this.mQu.execute();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l = ((Long)paramList.next()).longValue();
      this.mQv.bindLong(1, l);
      this.mQv.execute();
    }
    if (!bool) {
      commit();
    }
  }
  
  public final void beginTransaction()
  {
    this.mQr.beginTransaction();
  }
  
  protected String bxi()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { bBR() });
  }
  
  public final List<Long> c(int[] paramArrayOfInt, String paramString)
  {
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.v(paramArrayOfInt) + ";", new Object[] { bBR() });
    paramArrayOfInt = this.mQr.rawQuery(paramArrayOfInt, new String[] { paramString });
    paramString = new ArrayList();
    while (paramArrayOfInt.moveToNext()) {
      paramString.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    l(paramString, 1);
    return paramString;
  }
  
  public final void c(int[] paramArrayOfInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.v(paramArrayOfInt) + " AND entity_id=?;", new Object[] { bBR() });
    paramArrayOfInt = this.mQr.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    bS(localArrayList);
  }
  
  public final String co(String paramString, int paramInt)
  {
    if (bBT())
    {
      localObject = cn(paramString, paramInt);
      if (this.mQq.Z(localObject))
      {
        ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
        return (String)this.mQq.get(localObject);
      }
    }
    Object localObject = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[] { bBR(), bBS(), bBR(), bBS() });
    localObject = this.mQr.rawQuery((String)localObject, new String[] { paramString, String.valueOf(paramInt) });
    paramString = null;
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    return paramString;
  }
  
  public final void commit()
  {
    this.mQr.commit();
  }
  
  /* Error */
  public final void create()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 28
    //   4: ldc_w 381
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
    //   21: getfield 383	com/tencent/mm/plugin/fts/a/a:bRJ	Z
    //   24: invokestatic 388	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   27: aastore
    //   28: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: aload_0
    //   32: getfield 383	com/tencent/mm/plugin/fts/a/a:bRJ	Z
    //   35: ifne +47 -> 82
    //   38: ldc_w 390
    //   41: invokestatic 396	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   44: checkcast 390	com/tencent/mm/plugin/fts/a/n
    //   47: invokeinterface 399 1 0
    //   52: ifne +33 -> 85
    //   55: ldc 28
    //   57: ldc_w 401
    //   60: invokestatic 358	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: iconst_0
    //   64: istore_1
    //   65: iload_1
    //   66: ifeq +16 -> 82
    //   69: ldc 28
    //   71: ldc_w 403
    //   74: invokestatic 358	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: aload_0
    //   78: iconst_1
    //   79: putfield 383	com/tencent/mm/plugin/fts/a/a:bRJ	Z
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: ldc_w 390
    //   89: invokestatic 396	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   92: checkcast 390	com/tencent/mm/plugin/fts/a/n
    //   95: invokeinterface 407 1 0
    //   100: putfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   103: ldc 28
    //   105: ldc_w 409
    //   108: invokestatic 358	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: invokevirtual 160	com/tencent/mm/plugin/fts/a/a:bBS	()Ljava/lang/String;
    //   115: astore_3
    //   116: aload_0
    //   117: invokevirtual 207	com/tencent/mm/plugin/fts/a/a:bBR	()Ljava/lang/String;
    //   120: astore_2
    //   121: ldc 28
    //   123: ldc_w 411
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
    //   141: invokevirtual 321	com/tencent/mm/plugin/fts/a/a:getTableName	()Ljava/lang/String;
    //   144: aastore
    //   145: invokestatic 40	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   148: aload_0
    //   149: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   152: aload_3
    //   153: invokeinterface 414 2 0
    //   158: ifeq +276 -> 434
    //   161: aload_0
    //   162: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   165: aload_2
    //   166: invokeinterface 414 2 0
    //   171: ifeq +263 -> 434
    //   174: aload_0
    //   175: invokevirtual 416	com/tencent/mm/plugin/fts/a/a:Po	()Z
    //   178: ifne +256 -> 434
    //   181: ldc 28
    //   183: ldc_w 418
    //   186: invokestatic 358	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: ldc_w 420
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: aload_3
    //   199: aastore
    //   200: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   203: astore 4
    //   205: aload_0
    //   206: aload_0
    //   207: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   210: aload 4
    //   212: invokeinterface 424 2 0
    //   217: putfield 115	com/tencent/mm/plugin/fts/a/a:mQs	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   220: ldc_w 426
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_2
    //   230: aastore
    //   231: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   234: astore 4
    //   236: aload_0
    //   237: aload_0
    //   238: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   241: aload 4
    //   243: invokeinterface 424 2 0
    //   248: putfield 122	com/tencent/mm/plugin/fts/a/a:mQt	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   251: ldc_w 428
    //   254: iconst_1
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: aload_3
    //   261: aastore
    //   262: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   265: astore_3
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   271: aload_3
    //   272: invokeinterface 424 2 0
    //   277: putfield 124	com/tencent/mm/plugin/fts/a/a:mQu	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   280: ldc_w 430
    //   283: iconst_1
    //   284: anewarray 4	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload_2
    //   290: aastore
    //   291: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   294: astore_3
    //   295: aload_0
    //   296: aload_0
    //   297: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   300: aload_3
    //   301: invokeinterface 424 2 0
    //   306: putfield 126	com/tencent/mm/plugin/fts/a/a:mQv	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   309: ldc_w 432
    //   312: iconst_1
    //   313: anewarray 4	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload_2
    //   319: aastore
    //   320: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   323: astore_3
    //   324: aload_0
    //   325: aload_0
    //   326: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   329: aload_3
    //   330: invokeinterface 424 2 0
    //   335: putfield 128	com/tencent/mm/plugin/fts/a/a:mQw	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   338: ldc_w 434
    //   341: iconst_1
    //   342: anewarray 4	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload_2
    //   348: aastore
    //   349: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   352: astore_3
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   358: aload_3
    //   359: invokeinterface 424 2 0
    //   364: putfield 436	com/tencent/mm/plugin/fts/a/a:mQx	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   367: ldc_w 438
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_2
    //   377: aastore
    //   378: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   381: astore_2
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   387: aload_2
    //   388: invokeinterface 424 2 0
    //   393: putfield 137	com/tencent/mm/plugin/fts/a/a:mQy	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   396: aload_0
    //   397: aload_0
    //   398: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   401: ldc_w 440
    //   404: invokeinterface 424 2 0
    //   409: putfield 130	com/tencent/mm/plugin/fts/a/a:mQz	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   412: aload_0
    //   413: new 442	com/tencent/mm/a/h
    //   416: dup
    //   417: bipush 100
    //   419: invokespecial 443	com/tencent/mm/a/h:<init>	(I)V
    //   422: putfield 73	com/tencent/mm/plugin/fts/a/a:mQq	Lcom/tencent/mm/a/f;
    //   425: aload_0
    //   426: invokevirtual 445	com/tencent/mm/plugin/fts/a/a:Pn	()V
    //   429: iconst_1
    //   430: istore_1
    //   431: goto -366 -> 65
    //   434: ldc 28
    //   436: ldc_w 447
    //   439: invokestatic 358	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: ldc_w 449
    //   445: iconst_1
    //   446: anewarray 4	java/lang/Object
    //   449: dup
    //   450: iconst_0
    //   451: aload_3
    //   452: aastore
    //   453: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   456: astore 4
    //   458: ldc_w 449
    //   461: iconst_1
    //   462: anewarray 4	java/lang/Object
    //   465: dup
    //   466: iconst_0
    //   467: aload_2
    //   468: aastore
    //   469: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   472: astore 5
    //   474: aload_0
    //   475: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   478: aload 4
    //   480: invokeinterface 452 2 0
    //   485: aload_0
    //   486: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   489: aload 5
    //   491: invokeinterface 452 2 0
    //   496: ldc_w 454
    //   499: iconst_1
    //   500: anewarray 4	java/lang/Object
    //   503: dup
    //   504: iconst_0
    //   505: aload_0
    //   506: invokevirtual 160	com/tencent/mm/plugin/fts/a/a:bBS	()Ljava/lang/String;
    //   509: aastore
    //   510: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   513: astore 4
    //   515: aload_0
    //   516: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   519: aload 4
    //   521: invokeinterface 452 2 0
    //   526: aload_0
    //   527: invokevirtual 456	com/tencent/mm/plugin/fts/a/a:bxi	()Ljava/lang/String;
    //   530: astore 4
    //   532: aload_0
    //   533: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   536: aload 4
    //   538: invokeinterface 452 2 0
    //   543: ldc_w 458
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
    //   558: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   561: astore 4
    //   563: aload_0
    //   564: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   567: aload 4
    //   569: invokeinterface 452 2 0
    //   574: ldc_w 460
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
    //   589: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   592: astore 4
    //   594: aload_0
    //   595: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   598: aload 4
    //   600: invokeinterface 452 2 0
    //   605: ldc_w 462
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
    //   620: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   623: astore 4
    //   625: aload_0
    //   626: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   629: aload 4
    //   631: invokeinterface 452 2 0
    //   636: ldc_w 464
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
    //   651: invokestatic 180	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   654: astore 4
    //   656: aload_0
    //   657: getfield 62	com/tencent/mm/plugin/fts/a/a:mQr	Lcom/tencent/mm/plugin/fts/a/h;
    //   660: aload 4
    //   662: invokeinterface 452 2 0
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
  
  public final void destroy()
  {
    ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.bRJ) });
    if ((this.bRJ) && (Pp()))
    {
      ab.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
      this.bRJ = false;
    }
  }
  
  public final boolean er(int paramInt1, int paramInt2)
  {
    return this.mQr.er(paramInt1, paramInt2);
  }
  
  public final List<b> g(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.v(paramArrayOfInt) + ";", new Object[] { bBR() });
    paramArrayOfInt = this.mQr.rawQuery(paramArrayOfInt, null);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    while (paramArrayOfInt.moveToNext())
    {
      b localb = new b();
      localb.f(paramArrayOfInt);
      localArrayList1.add(localb);
      localArrayList2.add(Long.valueOf(localb.mRT));
    }
    paramArrayOfInt.close();
    l(localArrayList2, paramInt);
    return localArrayList1;
  }
  
  public final void g(Long paramLong)
  {
    boolean bool = this.mQr.inTransaction();
    if (!bool) {
      this.mQr.beginTransaction();
    }
    this.mQu.bindLong(1, paramLong.longValue());
    this.mQu.execute();
    this.mQv.bindLong(1, paramLong.longValue());
    this.mQv.execute();
    if (!bool) {
      commit();
    }
  }
  
  protected String getTableName()
  {
    return "Common";
  }
  
  public final void l(List<Long> paramList, int paramInt)
  {
    boolean bool = this.mQr.inTransaction();
    if (!bool) {
      this.mQr.beginTransaction();
    }
    this.mQw.bindLong(1, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = ((Long)paramList.next()).longValue();
      this.mQw.bindLong(2, l);
      this.mQw.execute();
    }
    if (!bool) {
      this.mQr.commit();
    }
  }
  
  public final void u(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(2048);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.v(paramArrayOfInt) + ";", new Object[] { bBR() });
    paramArrayOfInt = this.mQr.rawQuery(paramArrayOfInt, null);
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    bS(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a
 * JD-Core Version:    0.7.0.1
 */