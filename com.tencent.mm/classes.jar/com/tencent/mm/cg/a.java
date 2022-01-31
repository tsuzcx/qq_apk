package com.tencent.mm.cg;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class a
{
  public static final Pattern yQi;
  private String errMsg = "";
  private boolean isNew = false;
  String key;
  f yQj;
  String yQk = "";
  public boolean yQl = false;
  String yQm = "";
  public boolean yQn = false;
  
  static
  {
    AppMethodBeat.i(59031);
    yQi = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
    AppMethodBeat.o(59031);
  }
  
  private static void a(f paramf)
  {
    AppMethodBeat.i(59027);
    if (paramf.yQt != null) {}
    for (paramf = paramf.yQt;; paramf = paramf.yQu)
    {
      paramf = paramf.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
      if (paramf.moveToFirst()) {
        break;
      }
      paramf = new SQLiteException("Cannot get count for sqlite_master");
      AppMethodBeat.o(59027);
      throw paramf;
    }
    paramf.close();
    AppMethodBeat.o(59027);
  }
  
  private boolean a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    AppMethodBeat.i(59029);
    if (this.yQj != null)
    {
      paramString1 = new AssertionError();
      AppMethodBeat.o(59029);
      throw paramString1;
    }
    boolean bool;
    if (!com.tencent.mm.vfs.e.cN(paramString1)) {
      bool = true;
    }
    int i;
    for (;;)
    {
      this.isNew = bool;
      i = 0;
      Iterator localIterator = dzH().iterator();
      label56:
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.key = com.tencent.mm.a.g.w((str + paramLong).getBytes()).substring(0, 7);
        try
        {
          this.yQj = f.E(paramString1, this.key, paramBoolean);
          a(this.yQj);
          if (!q.bP(true).equals(str))
          {
            ab.i("MicroMsg.DBInit", "IMEI changed detected: ".concat(String.valueOf(str)));
            l.Lm().set(258, str);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 5L, 1L, false);
          }
          AppMethodBeat.o(59029);
          return true;
          bool = false;
        }
        catch (SQLiteException localSQLiteException)
        {
          if ((localSQLiteException instanceof SQLiteDatabaseCorruptException))
          {
            i = 1;
            break label56;
          }
          i = 0;
        }
      }
    }
    if (i != 0)
    {
      if (!paramBoolean) {
        i = 42;
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, i, 1L, true);
        f.atb(paramString1);
        if (paramString1.endsWith("EnMicroMsg.db")) {
          f.atb(com.tencent.mm.kernel.g.RL().eHR + "dbback/EnMicroMsg.db");
        }
        try
        {
          this.key = com.tencent.mm.a.g.w((q.bP(true) + paramLong).getBytes()).substring(0, 7);
          this.yQj = f.E(paramString1, this.key, paramBoolean);
          a(this.yQj);
          this.isNew = true;
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 6L, 1L, false);
          AppMethodBeat.o(59029);
          return true;
        }
        catch (SQLiteException paramString1)
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 7L, 1L, false);
        }
        if (f.dzQ()) {
          i = 43;
        } else {
          i = 41;
        }
      }
    }
    for (;;)
    {
      if (this.yQj != null)
      {
        this.yQj.close();
        this.yQj = null;
      }
      this.key = null;
      AppMethodBeat.o(59029);
      return false;
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        if (!com.tencent.mm.vfs.e.cN(paramString2)) {}
        for (bool = true;; bool = false)
        {
          this.isNew = bool;
          try
          {
            this.yQj = f.E(paramString2, this.key, paramBoolean);
            a(this.yQj);
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 6L, 1L, false);
            AppMethodBeat.o(59029);
            return true;
          }
          catch (SQLiteException paramString1)
          {
            com.tencent.mm.plugin.report.e.qrI.idkeyStat(181L, 7L, 1L, false);
          }
        }
      }
    }
  }
  
  private boolean a(HashMap<Integer, h.d> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(59030);
    if (this.yQj == null)
    {
      AppMethodBeat.o(59030);
      return false;
    }
    if (paramHashMap == null) {}
    Object localObject3;
    for (int i = -1;; i = paramHashMap.size())
    {
      ab.d("MicroMsg.DBInit", "createtables checkCreateIni:%b  tables:%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      localObject1 = "";
      if (!paramBoolean1) {
        break label345;
      }
      this.yQk = (this.yQj.getPath() + ".ini");
      localObject1 = new StringBuilder();
      if (paramHashMap == null) {
        break;
      }
      localObject2 = paramHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h.d)((Iterator)localObject2).next();
        if (((h.d)localObject3).getSQLs() == null)
        {
          ab.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", new Object[] { localObject3.getClass().toString() });
          Assert.assertTrue("factory.getSQLs() is null:" + localObject3.getClass().toString(), false);
        }
        localObject3 = ((h.d)localObject3).getSQLs();
        j = localObject3.length;
        i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject1).append(localObject3[i].hashCode());
          i += 1;
        }
      }
    }
    Object localObject2 = com.tencent.mm.a.g.w(((StringBuilder)localObject1).toString().getBytes());
    Object localObject1 = localObject2;
    if (!paramBoolean2)
    {
      localObject3 = com.tencent.mm.sdk.e.a.getValue(this.yQk, "createmd5");
      localObject1 = localObject2;
      if (!bo.isNullOrNil((String)localObject3))
      {
        localObject1 = localObject2;
        if (((String)localObject2).equals(localObject3))
        {
          ab.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", new Object[] { this.yQj.getPath() });
          AppMethodBeat.o(59030);
          return true;
        }
      }
    }
    label345:
    this.yQj.execSQL("pragma auto_vacuum = 0 ");
    localObject2 = new g.a();
    this.yQj.beginTransaction();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.values().iterator();
      i = 0;
      String str;
      label579:
      for (;;)
      {
        j = i;
        if (!paramHashMap.hasNext()) {
          break;
        }
        localObject3 = ((h.d)paramHashMap.next()).getSQLs();
        int k = localObject3.length;
        j = 0;
        for (;;)
        {
          if (j >= k) {
            break label579;
          }
          str = localObject3[j];
          try
          {
            this.yQj.execSQL(str);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Matcher localMatcher = yQi.matcher(str);
              if ((localMatcher != null) && (localMatcher.matches())) {
                Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
              } else {
                ab.w("MicroMsg.DBInit", "CreateTable failed:[" + str + "][" + localException.getMessage() + "]");
              }
            }
          }
          j += 1;
        }
      }
    }
    int j = 0;
    long l = ((g.a)localObject2).Mm();
    this.yQj.endTransaction();
    ab.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(l), Long.valueOf(((g.a)localObject2).Mm()), Integer.valueOf(j) });
    if (paramBoolean1) {
      com.tencent.mm.sdk.e.a.aE(this.yQk, "createmd5", (String)localObject1);
    }
    AppMethodBeat.o(59030);
    return true;
  }
  
  /* Error */
  private static Collection<String> dzH()
  {
    // Byte code:
    //   0: ldc_w 390
    //   3: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 396	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   9: astore_1
    //   10: new 398	java/util/LinkedHashSet
    //   13: dup
    //   14: invokespecial 399	java/util/LinkedHashSet:<init>	()V
    //   17: astore_3
    //   18: aload_3
    //   19: iconst_1
    //   20: invokestatic 175	com/tencent/mm/compatible/e/q:bP	(Z)Ljava/lang/String;
    //   23: invokevirtual 402	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   26: pop
    //   27: aload_3
    //   28: iconst_0
    //   29: invokestatic 175	com/tencent/mm/compatible/e/q:bP	(Z)Ljava/lang/String;
    //   32: invokevirtual 402	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   35: pop
    //   36: aconst_null
    //   37: astore_0
    //   38: new 404	javax/crypto/spec/SecretKeySpec
    //   41: dup
    //   42: ldc_w 406
    //   45: invokevirtual 151	java/lang/String:getBytes	()[B
    //   48: ldc_w 408
    //   51: invokespecial 411	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   54: astore_2
    //   55: ldc_w 408
    //   58: invokestatic 417	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   61: astore 4
    //   63: aload 4
    //   65: iconst_2
    //   66: aload_2
    //   67: invokevirtual 421	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   70: new 423	java/io/BufferedReader
    //   73: dup
    //   74: new 425	java/io/InputStreamReader
    //   77: dup
    //   78: new 427	javax/crypto/CipherInputStream
    //   81: dup
    //   82: aload_1
    //   83: ldc_w 429
    //   86: invokevirtual 435	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   89: aload 4
    //   91: invokespecial 438	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   94: invokespecial 441	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   97: invokespecial 444	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   100: astore_1
    //   101: aload_1
    //   102: astore_0
    //   103: aload_1
    //   104: invokevirtual 447	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: ifnull +50 -> 159
    //   112: aload_1
    //   113: astore_0
    //   114: aload_3
    //   115: aload_2
    //   116: invokevirtual 402	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   119: pop
    //   120: goto -19 -> 101
    //   123: astore_2
    //   124: aload_1
    //   125: astore_0
    //   126: ldc 181
    //   128: aload_2
    //   129: ldc_w 449
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 453	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_1
    //   140: invokestatic 457	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   143: aload_3
    //   144: ldc_w 459
    //   147: invokevirtual 402	java/util/LinkedHashSet:add	(Ljava/lang/Object;)Z
    //   150: pop
    //   151: ldc_w 390
    //   154: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload_3
    //   158: areturn
    //   159: aload_1
    //   160: invokestatic 457	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   163: goto -20 -> 143
    //   166: astore_2
    //   167: aload_0
    //   168: astore_1
    //   169: aload_2
    //   170: astore_0
    //   171: aload_1
    //   172: invokestatic 457	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   175: ldc_w 390
    //   178: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_0
    //   182: athrow
    //   183: astore_2
    //   184: aload_0
    //   185: astore_1
    //   186: aload_2
    //   187: astore_0
    //   188: goto -17 -> 171
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: goto -70 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	151	0	localObject1	Object
    //   9	185	1	localObject2	Object
    //   54	62	2	localObject3	Object
    //   123	6	2	localException1	Exception
    //   166	4	2	localObject4	Object
    //   183	4	2	localObject5	Object
    //   191	1	2	localException2	Exception
    //   17	141	3	localLinkedHashSet	java.util.LinkedHashSet
    //   61	29	4	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   103	108	123	java/lang/Exception
    //   114	120	123	java/lang/Exception
    //   38	101	166	finally
    //   103	108	183	finally
    //   114	120	183	finally
    //   126	139	183	finally
    //   38	101	191	java/lang/Exception
  }
  
  private void is(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59020);
    HashSet localHashSet = new HashSet();
    Object localObject = this.yQj.a("select * from " + paramString1 + " limit 1 ", null, 0);
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(59020);
      return;
    }
    ((Cursor)localObject).moveToFirst();
    int i = 0;
    while (i < ((Cursor)localObject).getColumnCount())
    {
      localHashSet.add(((Cursor)localObject).getColumnName(i));
      i += 1;
    }
    ((Cursor)localObject).close();
    Cursor localCursor = this.yQj.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
    localObject = "";
    while (localCursor.moveToNext())
    {
      String str = localCursor.getString(localCursor.getColumnIndex("name"));
      if (localHashSet.contains(str))
      {
        localObject = (String)localObject + str;
        localObject = (String)localObject + ",";
      }
    }
    localCursor.close();
    localObject = ((String)localObject).substring(0, ((String)localObject).length() - 1);
    paramString1 = "insert into " + paramString2 + "(" + (String)localObject + ") select " + (String)localObject + " from " + paramString1 + ";";
    this.yQj.execSQL(paramString1);
    AppMethodBeat.o(59020);
  }
  
  private List<String> it(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59022);
    ArrayList localArrayList = new ArrayList();
    if (this.yQj == null)
    {
      AppMethodBeat.o(59022);
      return localArrayList;
    }
    Object localObject1 = this.yQj.a("PRAGMA table_info( " + paramString1 + " )", null, 0);
    if (localObject1 == null)
    {
      AppMethodBeat.o(59022);
      return localArrayList;
    }
    paramString1 = new HashMap();
    int i = ((Cursor)localObject1).getColumnIndex("name");
    int j = ((Cursor)localObject1).getColumnIndex("type");
    while (((Cursor)localObject1).moveToNext()) {
      paramString1.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
    }
    ((Cursor)localObject1).close();
    Object localObject2 = this.yQj.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
    if (localObject2 == null)
    {
      AppMethodBeat.o(59022);
      return localArrayList;
    }
    localObject1 = new HashMap();
    i = ((Cursor)localObject2).getColumnIndex("name");
    j = ((Cursor)localObject2).getColumnIndex("type");
    while (((Cursor)localObject2).moveToNext()) {
      paramString1.put(((Cursor)localObject2).getString(i), ((Cursor)localObject2).getString(j));
    }
    ((Cursor)localObject2).close();
    localObject2 = new HashSet(paramString1.entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject2).next();
      String str1 = (String)((Map.Entry)localObject3).getKey();
      localObject3 = (String)((Map.Entry)localObject3).getValue();
      if ((localObject3 != null) && (((String)localObject3).length() > 0))
      {
        String str2 = (String)((Map)localObject1).get(str1);
        if (str2 == null)
        {
          localArrayList.add("ALTER TABLE " + paramString2 + " ADD COLUMN " + str1 + " " + (String)localObject3 + ";");
          paramString1.remove(str1);
        }
        else if (!((String)localObject3).toLowerCase().startsWith(str2.toLowerCase()))
        {
          ab.e("MicroMsg.DBInit", "conflicting alter table on column: " + str1 + ", " + str2 + "<o-n>" + (String)localObject3);
          paramString1.remove(str1);
        }
      }
    }
    AppMethodBeat.o(59022);
    return localArrayList;
  }
  
  private boolean iu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59023);
    Cursor localCursor = this.yQj.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
    if (localCursor == null)
    {
      AppMethodBeat.o(59023);
      return false;
    }
    try
    {
      if (bo.isNullOrNil(paramString2)) {
        this.yQj.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY ''");
      }
      while (!p(localCursor))
      {
        AppMethodBeat.o(59023);
        return false;
        this.yQj.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY '" + paramString2 + "'");
      }
      this.yQj.beginTransaction();
    }
    catch (SQLiteDatabaseCorruptException paramString2)
    {
      ab.e("MicroMsg.DBInit", "Attached database is corrupted: ".concat(String.valueOf(paramString1)));
      com.tencent.mm.vfs.e.deleteFile(paramString1);
      AppMethodBeat.o(59023);
      throw paramString2;
    }
    int i = 0;
    int j;
    if (i < localCursor.getCount())
    {
      localCursor.moveToPosition(i);
      paramString1 = this.yQj.a("select * from old.sqlite_master where tbl_name = '" + localCursor.getString(0) + "'", null, 0);
      if (paramString1 == null) {
        break label463;
      }
      j = paramString1.getCount();
      paramString1.close();
    }
    for (;;)
    {
      if (j == 0) {
        ab.w("MicroMsg.DBInit", "In old db not found :" + localCursor.getString(0));
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          paramString1 = it("old." + localCursor.getString(0), localCursor.getString(0)).iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            this.yQj.execSQL(paramString2);
          }
        }
        catch (Exception paramString1)
        {
          ab.w("MicroMsg.DBInit", "Insertselect FAILED :" + localCursor.getString(0));
        }
        is("old." + localCursor.getString(0), localCursor.getString(0));
      }
      this.yQj.endTransaction();
      localCursor.close();
      this.yQj.execSQL("DETACH DATABASE old;");
      AppMethodBeat.o(59023);
      return true;
      label463:
      j = 0;
    }
  }
  
  private boolean iv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59026);
    if (iu(paramString1, paramString2))
    {
      ab.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", new Object[] { paramString1 });
      ab.i("MicroMsg.DBInit", "delete result :%b", new Object[] { Boolean.valueOf(com.tencent.mm.vfs.e.deleteFile(paramString1)) });
      AppMethodBeat.o(59026);
      return true;
    }
    ab.i("MicroMsg.DBInit", "system transfer fail path %s", new Object[] { paramString1 });
    AppMethodBeat.o(59026);
    return false;
  }
  
  private boolean p(Cursor paramCursor)
  {
    AppMethodBeat.i(59021);
    HashSet localHashSet = new HashSet();
    Object localObject = new HashSet();
    int i = 0;
    while (i < paramCursor.getCount())
    {
      paramCursor.moveToPosition(i);
      localHashSet.add(paramCursor.getString(0));
      i += 1;
    }
    paramCursor = this.yQj.a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
    if (paramCursor == null)
    {
      AppMethodBeat.o(59021);
      return false;
    }
    i = 0;
    while (i < paramCursor.getCount())
    {
      paramCursor.moveToPosition(i);
      ((HashSet)localObject).add(paramCursor.getString(0));
      i += 1;
    }
    paramCursor.close();
    this.yQj.beginTransaction();
    paramCursor = ((HashSet)localObject).iterator();
    while (paramCursor.hasNext())
    {
      localObject = (String)paramCursor.next();
      if (!localHashSet.contains(localObject))
      {
        localObject = this.yQj.a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + (String)localObject + "'", null, 0);
        if (localObject != null)
        {
          String str = ((Cursor)localObject).getString(0);
          this.yQj.execSQL(str);
          ((Cursor)localObject).close();
        }
      }
    }
    this.yQj.endTransaction();
    AppMethodBeat.o(59021);
    return true;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, long paramLong, HashMap<Integer, h.d> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(59025);
    boolean bool1;
    boolean bool3;
    boolean bool4;
    int i;
    label98:
    int j;
    if (!bo.isNullOrNil(paramString2))
    {
      bool1 = true;
      Assert.assertTrue("create SqliteDB enDbCachePath == null ", bool1);
      this.yQm = (paramString2 + ".errreport");
      if (this.yQj != null)
      {
        this.yQj.close();
        this.yQj = null;
      }
      boolean bool2 = com.tencent.mm.vfs.e.cN(paramString2);
      bool3 = com.tencent.mm.vfs.e.cN(paramString1);
      bool4 = com.tencent.mm.vfs.e.cN(paramString3);
      if ((bool2) || (!bool3)) {
        break label264;
      }
      i = 1;
      this.yQl = a(paramString2, paramLong, f.dzP(), paramString3);
      Boolean localBoolean = Boolean.TRUE;
      boolean bool5 = this.yQl;
      if (this.yQj == null) {
        break label270;
      }
      bool1 = true;
      label134:
      ab.i("MicroMsg.DBInit", "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s", new Object[] { paramString2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), localBoolean, Boolean.valueOf(bool5), Boolean.valueOf(bool1), Thread.currentThread().getName() });
      if ((this.yQj == null) || (this.yQj.getPath().equals(paramString3)) || (!bool4)) {
        break label422;
      }
      j = 1;
      ab.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
    }
    for (;;)
    {
      if (!a(paramHashMap, paramBoolean, this.isNew))
      {
        AppMethodBeat.o(59025);
        return false;
        bool1 = false;
        break;
        label264:
        i = 0;
        break label98;
        label270:
        bool1 = false;
        break label134;
      }
      if ((!bool3) && (!bool4))
      {
        AppMethodBeat.o(59025);
        return true;
      }
      if ((j != 0) || (i != 0)) {
        this.yQn = true;
      }
      if (j != 0)
      {
        this.key = com.tencent.mm.a.g.w((q.bP(true) + paramLong).getBytes()).substring(0, 7);
        iv(paramString3, this.key);
        com.tencent.mm.blink.a.t(201L, 1L);
      }
      if (i != 0)
      {
        paramBoolean = iv(paramString1, "");
        com.tencent.mm.blink.a.t(200L, 1L);
        AppMethodBeat.o(59025);
        return paramBoolean;
      }
      if (this.yQj != null)
      {
        AppMethodBeat.o(59025);
        return true;
      }
      AppMethodBeat.o(59025);
      return false;
      label422:
      j = 0;
    }
  }
  
  public final boolean a(String paramString, HashMap<Integer, h.d> paramHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(59024);
    if (this.yQj != null)
    {
      this.yQj.close();
      this.yQj = null;
    }
    boolean bool = com.tencent.mm.vfs.e.cN(paramString);
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", new Object[] { Boolean.TRUE, Boolean.valueOf(bool), paramString });
        this.yQj = f.ch(paramString, paramBoolean);
        if (!bool)
        {
          paramBoolean = true;
          if (a(paramHashMap, true, paramBoolean)) {
            break;
          }
          if (this.yQj != null)
          {
            this.yQj.close();
            this.yQj = null;
          }
          AppMethodBeat.o(59024);
          return false;
        }
      }
      catch (SQLiteException paramString)
      {
        AppMethodBeat.o(59024);
        return false;
      }
      paramBoolean = false;
    }
    AppMethodBeat.o(59024);
    return true;
  }
  
  public final String getError()
  {
    AppMethodBeat.i(59019);
    if ((bo.isNullOrNil(this.errMsg)) || (bo.isNullOrNil(this.yQm)))
    {
      AppMethodBeat.o(59019);
      return "";
    }
    if (!bo.isNullOrNil(com.tencent.mm.sdk.e.a.getValue(this.yQm, "Reported")))
    {
      AppMethodBeat.o(59019);
      return "";
    }
    com.tencent.mm.sdk.e.a.aE(this.yQm, "Reported", "true");
    String str = this.errMsg;
    AppMethodBeat.o(59019);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.a
 * JD-Core Version:    0.7.0.1
 */