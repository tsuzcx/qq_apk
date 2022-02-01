package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
  private f<String, String> HqQ;
  public volatile h HqR;
  private SQLiteStatement HqS;
  private SQLiteStatement HqT;
  private SQLiteStatement HqU;
  private SQLiteStatement HqV;
  private SQLiteStatement HqW;
  public SQLiteStatement HqX;
  private SQLiteStatement HqY;
  private SQLiteStatement HqZ;
  private volatile boolean feX;
  
  public a()
  {
    Log.i(getLogTag(), "Create %s", new Object[] { getName() });
  }
  
  private static String fi(String paramString, int paramInt)
  {
    return paramString + "​" + paramInt;
  }
  
  public final void F(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(2048);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.G(paramArrayOfInt) + ";", new Object[] { fxn() });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, null);
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    hP(localArrayList);
  }
  
  public final void N(List<Long> paramList, int paramInt)
  {
    boolean bool = this.HqR.inTransaction();
    if (!bool) {
      this.HqR.beginTransaction();
    }
    this.HqW.bindLong(1, paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      long l = ((Long)paramList.next()).longValue();
      this.HqW.bindLong(2, l);
      this.HqW.execute();
    }
    if (!bool) {
      this.HqR.commit();
    }
  }
  
  public final Cursor a(j paramj, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str2 = paramj.fxx();
    label72:
    label101:
    StringBuilder localStringBuilder;
    if (paramBoolean1)
    {
      paramj = String.format(", MMHighlight(%s, %d, type, subtype)", new Object[] { fxo(), Integer.valueOf(paramj.Hti.size()) });
      if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length <= 0)) {
        break label238;
      }
      paramArrayOfInt2 = " AND subtype IN " + d.G(paramArrayOfInt2);
      if ((paramArrayOfInt1 == null) || (paramArrayOfInt1.length <= 0)) {
        break label244;
      }
      paramArrayOfInt1 = " AND type IN " + d.G(paramArrayOfInt1);
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
      paramj = String.format(str1 + paramj + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + paramArrayOfInt1 + "" + " AND status >= 0" + paramArrayOfInt2 + ";", new Object[] { fxn(), fxn(), fxo(), fxn(), fxo(), fxo(), str2 });
      return this.HqR.rawQuery(paramj, null);
      paramj = "";
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
      return com.tencent.mm.storagebase.d.jdS();
    }
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      return com.tencent.mm.storagebase.d.jdS();
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
    paramArrayOfInt = String.format("SELECT %s FROM %s WHERE type IN " + d.G(paramArrayOfInt) + ";", new Object[] { localObject, fxn() });
    return this.HqR.rawQuery(paramArrayOfInt, null);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    paramString2 = d.aEg(paramString2);
    if (Util.isNullOrNil(paramString2)) {}
    for (;;)
    {
      return;
      boolean bool = this.HqR.inTransaction();
      if (!bool) {
        this.HqR.beginTransaction();
      }
      try
      {
        this.HqS.bindString(1, paramString2);
        this.HqS.execute();
        this.HqT.bindLong(1, paramInt1);
        this.HqT.bindLong(2, paramInt2);
        this.HqT.bindLong(3, paramLong1);
        this.HqT.bindString(4, paramString1);
        this.HqT.bindLong(5, paramLong2);
        this.HqT.execute();
        if (!bool) {
          this.HqR.commit();
        }
        if (!fxr()) {
          continue;
        }
        this.HqQ.put(fi(paramString1, paramInt2), paramString2);
        return;
      }
      catch (SQLiteException paramString2)
      {
        Log.e(getLogTag(), String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong1), paramString1, Long.valueOf(paramLong2) }));
        paramString1 = this.HqZ.simpleQueryForString();
        if ((paramString1 != null) && (paramString1.length() > 0)) {
          Log.e(getLogTag(), ">> ".concat(String.valueOf(paramString1)));
        }
        throw paramString2;
      }
    }
  }
  
  public final void aEe(String paramString)
  {
    Object localObject = new HashSet();
    Iterator localIterator = this.HqQ.keySet().iterator();
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
      this.HqQ.remove(localObject);
    }
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    this.HqR.aG(paramLong1, paramLong2);
  }
  
  public final void aG(String paramString, long paramLong)
  {
    this.HqY.bindLong(1, paramLong);
    this.HqY.bindString(2, paramString);
    this.HqY.execute();
  }
  
  protected abstract void aXv();
  
  protected boolean aXw()
  {
    return false;
  }
  
  protected boolean aXx()
  {
    if (this.HqS != null) {
      this.HqS.close();
    }
    if (this.HqT != null) {
      this.HqT.close();
    }
    if (this.HqU != null) {
      this.HqU.close();
    }
    if (this.HqV != null) {
      this.HqV.close();
    }
    if (this.HqW != null) {
      this.HqW.close();
    }
    if (this.HqZ != null) {
      this.HqZ.close();
    }
    if (this.HqQ != null) {
      this.HqQ.clear();
    }
    this.HqR = null;
    return true;
  }
  
  public final void b(int[] paramArrayOfInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.G(paramArrayOfInt) + " AND aux_index=?;", new Object[] { fxn() });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, new String[] { paramString });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    hP(localArrayList);
  }
  
  public final void beginTransaction()
  {
    this.HqR.beginTransaction();
  }
  
  public final List<Long> c(int[] paramArrayOfInt, String paramString)
  {
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.G(paramArrayOfInt) + ";", new Object[] { fxn() });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, new String[] { paramString });
    paramString = new ArrayList();
    while (paramArrayOfInt.moveToNext()) {
      paramString.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    N(paramString, 1);
    return paramString;
  }
  
  public final void c(int[] paramArrayOfInt, long paramLong)
  {
    ArrayList localArrayList = new ArrayList(16);
    paramArrayOfInt = String.format("SELECT docid FROM %s WHERE type IN " + d.G(paramArrayOfInt) + " AND entity_id=?;", new Object[] { fxn() });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, new String[] { Long.toString(paramLong) });
    while (paramArrayOfInt.moveToNext()) {
      localArrayList.add(Long.valueOf(paramArrayOfInt.getLong(0)));
    }
    paramArrayOfInt.close();
    hP(localArrayList);
  }
  
  public final void commit()
  {
    this.HqR.commit();
  }
  
  /* Error */
  public final void create()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 30	com/tencent/mm/plugin/fts/a/a:getLogTag	()Ljava/lang/String;
    //   6: ldc_w 351
    //   9: iconst_2
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload_0
    //   16: invokevirtual 35	com/tencent/mm/plugin/fts/a/a:getName	()Ljava/lang/String;
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_0
    //   23: getfield 353	com/tencent/mm/plugin/fts/a/a:feX	Z
    //   26: invokestatic 358	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   29: aastore
    //   30: invokestatic 41	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: getfield 353	com/tencent/mm/plugin/fts/a/a:feX	Z
    //   37: ifne +51 -> 88
    //   40: ldc_w 360
    //   43: invokestatic 366	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   46: checkcast 360	com/tencent/mm/plugin/fts/a/n
    //   49: invokeinterface 369 1 0
    //   54: ifne +37 -> 91
    //   57: aload_0
    //   58: invokevirtual 30	com/tencent/mm/plugin/fts/a/a:getLogTag	()Ljava/lang/String;
    //   61: ldc_w 371
    //   64: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: iconst_0
    //   68: istore_1
    //   69: iload_1
    //   70: ifeq +18 -> 88
    //   73: aload_0
    //   74: invokevirtual 30	com/tencent/mm/plugin/fts/a/a:getLogTag	()Ljava/lang/String;
    //   77: ldc_w 375
    //   80: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: iconst_1
    //   85: putfield 353	com/tencent/mm/plugin/fts/a/a:feX	Z
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: aload_0
    //   92: ldc_w 360
    //   95: invokestatic 366	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   98: checkcast 360	com/tencent/mm/plugin/fts/a/n
    //   101: invokeinterface 379 1 0
    //   106: putfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   109: aload_0
    //   110: invokevirtual 30	com/tencent/mm/plugin/fts/a/a:getLogTag	()Ljava/lang/String;
    //   113: ldc_w 381
    //   116: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_0
    //   120: invokevirtual 178	com/tencent/mm/plugin/fts/a/a:fxo	()Ljava/lang/String;
    //   123: astore_3
    //   124: aload_0
    //   125: invokevirtual 82	com/tencent/mm/plugin/fts/a/a:fxn	()Ljava/lang/String;
    //   128: astore_2
    //   129: aload_0
    //   130: invokevirtual 30	com/tencent/mm/plugin/fts/a/a:getLogTag	()Ljava/lang/String;
    //   133: ldc_w 383
    //   136: iconst_3
    //   137: anewarray 4	java/lang/Object
    //   140: dup
    //   141: iconst_0
    //   142: aload_3
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload_2
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: aload_0
    //   151: invokevirtual 386	com/tencent/mm/plugin/fts/a/a:getTableName	()Ljava/lang/String;
    //   154: aastore
    //   155: invokestatic 41	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: aload_0
    //   159: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   162: aload_3
    //   163: invokeinterface 389 2 0
    //   168: ifeq +278 -> 446
    //   171: aload_0
    //   172: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   175: aload_2
    //   176: invokeinterface 389 2 0
    //   181: ifeq +265 -> 446
    //   184: aload_0
    //   185: invokevirtual 391	com/tencent/mm/plugin/fts/a/a:aXw	()Z
    //   188: ifne +258 -> 446
    //   191: aload_0
    //   192: invokevirtual 30	com/tencent/mm/plugin/fts/a/a:getLogTag	()Ljava/lang/String;
    //   195: ldc_w 393
    //   198: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: ldc_w 395
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_3
    //   211: aastore
    //   212: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   215: astore 4
    //   217: aload_0
    //   218: aload_0
    //   219: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   222: aload 4
    //   224: invokeinterface 399 2 0
    //   229: putfield 246	com/tencent/mm/plugin/fts/a/a:HqS	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   232: ldc_w 401
    //   235: iconst_1
    //   236: anewarray 4	java/lang/Object
    //   239: dup
    //   240: iconst_0
    //   241: aload_2
    //   242: aastore
    //   243: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   246: astore 4
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   253: aload 4
    //   255: invokeinterface 399 2 0
    //   260: putfield 252	com/tencent/mm/plugin/fts/a/a:HqT	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   263: ldc_w 403
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: aload_3
    //   273: aastore
    //   274: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   277: astore_3
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   283: aload_3
    //   284: invokeinterface 399 2 0
    //   289: putfield 318	com/tencent/mm/plugin/fts/a/a:HqU	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   292: ldc_w 405
    //   295: iconst_1
    //   296: anewarray 4	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload_2
    //   302: aastore
    //   303: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   306: astore_3
    //   307: aload_0
    //   308: aload_0
    //   309: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   312: aload_3
    //   313: invokeinterface 399 2 0
    //   318: putfield 320	com/tencent/mm/plugin/fts/a/a:HqV	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   321: ldc_w 407
    //   324: iconst_1
    //   325: anewarray 4	java/lang/Object
    //   328: dup
    //   329: iconst_0
    //   330: aload_2
    //   331: aastore
    //   332: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   335: astore_3
    //   336: aload_0
    //   337: aload_0
    //   338: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   341: aload_3
    //   342: invokeinterface 399 2 0
    //   347: putfield 133	com/tencent/mm/plugin/fts/a/a:HqW	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   350: ldc_w 409
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload_2
    //   360: aastore
    //   361: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   364: astore_3
    //   365: aload_0
    //   366: aload_0
    //   367: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   370: aload_3
    //   371: invokeinterface 399 2 0
    //   376: putfield 411	com/tencent/mm/plugin/fts/a/a:HqX	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   379: ldc_w 413
    //   382: iconst_1
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload_2
    //   389: aastore
    //   390: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   393: astore_2
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   399: aload_2
    //   400: invokeinterface 399 2 0
    //   405: putfield 312	com/tencent/mm/plugin/fts/a/a:HqY	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   408: aload_0
    //   409: aload_0
    //   410: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   413: ldc_w 415
    //   416: invokeinterface 399 2 0
    //   421: putfield 273	com/tencent/mm/plugin/fts/a/a:HqZ	Lcom/tencent/wcdb/database/SQLiteStatement;
    //   424: aload_0
    //   425: new 417	com/tencent/mm/b/h
    //   428: dup
    //   429: bipush 100
    //   431: invokespecial 418	com/tencent/mm/b/h:<init>	(I)V
    //   434: putfield 257	com/tencent/mm/plugin/fts/a/a:HqQ	Lcom/tencent/mm/b/f;
    //   437: aload_0
    //   438: invokevirtual 420	com/tencent/mm/plugin/fts/a/a:aXv	()V
    //   441: iconst_1
    //   442: istore_1
    //   443: goto -374 -> 69
    //   446: aload_0
    //   447: invokevirtual 30	com/tencent/mm/plugin/fts/a/a:getLogTag	()Ljava/lang/String;
    //   450: ldc_w 422
    //   453: invokestatic 373	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: ldc_w 424
    //   459: iconst_1
    //   460: anewarray 4	java/lang/Object
    //   463: dup
    //   464: iconst_0
    //   465: aload_3
    //   466: aastore
    //   467: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   470: astore 4
    //   472: ldc_w 424
    //   475: iconst_1
    //   476: anewarray 4	java/lang/Object
    //   479: dup
    //   480: iconst_0
    //   481: aload_2
    //   482: aastore
    //   483: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   486: astore 5
    //   488: aload_0
    //   489: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   492: aload 4
    //   494: invokeinterface 427 2 0
    //   499: aload_0
    //   500: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   503: aload 5
    //   505: invokeinterface 427 2 0
    //   510: ldc_w 429
    //   513: iconst_1
    //   514: anewarray 4	java/lang/Object
    //   517: dup
    //   518: iconst_0
    //   519: aload_0
    //   520: invokevirtual 178	com/tencent/mm/plugin/fts/a/a:fxo	()Ljava/lang/String;
    //   523: aastore
    //   524: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   527: astore 4
    //   529: aload_0
    //   530: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   533: aload 4
    //   535: invokeinterface 427 2 0
    //   540: aload_0
    //   541: invokevirtual 432	com/tencent/mm/plugin/fts/a/a:dRh	()Ljava/lang/String;
    //   544: astore 4
    //   546: aload_0
    //   547: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   550: aload 4
    //   552: invokeinterface 427 2 0
    //   557: ldc_w 434
    //   560: iconst_2
    //   561: anewarray 4	java/lang/Object
    //   564: dup
    //   565: iconst_0
    //   566: aload_2
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: aload_2
    //   571: aastore
    //   572: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   575: astore 4
    //   577: aload_0
    //   578: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   581: aload 4
    //   583: invokeinterface 427 2 0
    //   588: ldc_w 436
    //   591: iconst_2
    //   592: anewarray 4	java/lang/Object
    //   595: dup
    //   596: iconst_0
    //   597: aload_2
    //   598: aastore
    //   599: dup
    //   600: iconst_1
    //   601: aload_2
    //   602: aastore
    //   603: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   606: astore 4
    //   608: aload_0
    //   609: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   612: aload 4
    //   614: invokeinterface 427 2 0
    //   619: ldc_w 438
    //   622: iconst_2
    //   623: anewarray 4	java/lang/Object
    //   626: dup
    //   627: iconst_0
    //   628: aload_2
    //   629: aastore
    //   630: dup
    //   631: iconst_1
    //   632: aload_2
    //   633: aastore
    //   634: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   637: astore 4
    //   639: aload_0
    //   640: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   643: aload 4
    //   645: invokeinterface 427 2 0
    //   650: ldc_w 440
    //   653: iconst_2
    //   654: anewarray 4	java/lang/Object
    //   657: dup
    //   658: iconst_0
    //   659: aload_2
    //   660: aastore
    //   661: dup
    //   662: iconst_1
    //   663: aload_2
    //   664: aastore
    //   665: invokestatic 88	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   668: astore 4
    //   670: aload_0
    //   671: getfield 90	com/tencent/mm/plugin/fts/a/a:HqR	Lcom/tencent/mm/plugin/fts/a/h;
    //   674: aload 4
    //   676: invokeinterface 427 2 0
    //   681: goto -480 -> 201
    //   684: astore_2
    //   685: aload_0
    //   686: monitorexit
    //   687: aload_2
    //   688: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	this	a
    //   68	375	1	i	int
    //   128	536	2	str1	String
    //   684	4	2	localObject	Object
    //   123	343	3	str2	String
    //   215	460	4	str3	String
    //   486	18	5	str4	String
    // Exception table:
    //   from	to	target	type
    //   2	67	684	finally
    //   73	88	684	finally
    //   91	201	684	finally
    //   201	441	684	finally
    //   446	681	684	finally
  }
  
  protected String dRh()
  {
    return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[] { fxn() });
  }
  
  public final void destroy()
  {
    Log.i(getLogTag(), "OnDestroy %s | isCreated %b", new Object[] { getName(), Boolean.valueOf(this.feX) });
    if ((this.feX) && (aXx()))
    {
      Log.i(getLogTag(), "SetDestroyed");
      this.feX = false;
    }
  }
  
  public final String fj(String paramString, int paramInt)
  {
    if (fxr())
    {
      localObject = fi(paramString, paramInt);
      if (this.HqQ.check(localObject))
      {
        Log.i(getLogTag(), "hit lru insert content map");
        return (String)this.HqQ.get(localObject);
      }
    }
    Object localObject = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[] { fxn(), fxo(), fxn(), fxo() });
    localObject = this.HqR.rawQuery((String)localObject, new String[] { paramString, String.valueOf(paramInt) });
    paramString = null;
    if (((Cursor)localObject).moveToFirst()) {
      paramString = ((Cursor)localObject).getString(0);
    }
    ((Cursor)localObject).close();
    return paramString;
  }
  
  public final String fxn()
  {
    return "FTS5Meta" + getTableName();
  }
  
  public final String fxo()
  {
    return "FTS5Index" + getTableName();
  }
  
  protected final SQLiteStatement fxp()
  {
    return this.HqZ;
  }
  
  public final SQLiteStatement fxq()
  {
    return this.HqS;
  }
  
  protected boolean fxr()
  {
    return false;
  }
  
  protected String getLogTag()
  {
    return "MicroMsg.FTS.BaseFTS5NativeStorage";
  }
  
  protected String getTableName()
  {
    return "Common";
  }
  
  public final void hP(List<Long> paramList)
  {
    boolean bool = this.HqR.inTransaction();
    if (!bool) {
      this.HqR.beginTransaction();
    }
    Iterator localIterator = paramList.iterator();
    long l;
    while (localIterator.hasNext())
    {
      l = ((Long)localIterator.next()).longValue();
      this.HqU.bindLong(1, l);
      try
      {
        this.HqU.execute();
      }
      catch (Exception localException2)
      {
        Log.printErrStackTrace(getLogTag(), localException2, "deleteIndexByDocIdStmt", new Object[0]);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      l = ((Long)paramList.next()).longValue();
      try
      {
        this.HqV.bindLong(1, l);
        this.HqV.execute();
      }
      catch (Exception localException1)
      {
        Log.printErrStackTrace(getLogTag(), localException1, "deleteMetaByDocIdStmt", new Object[0]);
      }
    }
    if (!bool) {
      commit();
    }
  }
  
  public final boolean iV(int paramInt1, int paramInt2)
  {
    return this.HqR.iV(paramInt1, paramInt2);
  }
  
  public final boolean inTransaction()
  {
    return this.HqR.inTransaction();
  }
  
  public final void rp(long paramLong)
  {
    boolean bool = this.HqR.inTransaction();
    if (!bool) {
      this.HqR.beginTransaction();
    }
    this.HqU.bindLong(1, paramLong);
    try
    {
      this.HqU.execute();
      this.HqV.bindLong(1, paramLong);
    }
    catch (Exception localException1)
    {
      try
      {
        this.HqV.execute();
        if (!bool) {
          commit();
        }
        return;
        localException1 = localException1;
        Log.printErrStackTrace(getLogTag(), localException1, "deleteIndexByDocId", new Object[0]);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printErrStackTrace(getLogTag(), localException2, "deleteMetaByDocIdStmt", new Object[0]);
        }
      }
    }
  }
  
  public final long rq(long paramLong)
  {
    return this.HqR.aF(paramLong, 9223372036854775807L);
  }
  
  public final List<com.tencent.mm.plugin.fts.a.a.d> w(int[] paramArrayOfInt, int paramInt)
  {
    paramArrayOfInt = String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.G(paramArrayOfInt) + ";", new Object[] { fxn() });
    paramArrayOfInt = this.HqR.rawQuery(paramArrayOfInt, null);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    while (paramArrayOfInt.moveToNext())
    {
      com.tencent.mm.plugin.fts.a.a.d locald = new com.tencent.mm.plugin.fts.a.a.d();
      locald.i(paramArrayOfInt);
      localArrayList1.add(locald);
      localArrayList2.add(Long.valueOf(locald.Hsy));
    }
    paramArrayOfInt.close();
    N(localArrayList2, paramInt);
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.a.a
 * JD-Core Version:    0.7.0.1
 */