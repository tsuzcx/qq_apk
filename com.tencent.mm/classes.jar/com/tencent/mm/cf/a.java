package com.tencent.mm.cf;

import android.database.Cursor;
import com.tencent.mm.compatible.e.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public static final Pattern uDB = Pattern.compile("^[\\s]*CREATE[\\s]+TABLE[\\s]*", 2);
  private String aox = "";
  private boolean isNew = false;
  String key;
  f uDC;
  String uDD = "";
  public boolean uDE = false;
  String uDF = "";
  public boolean uDG = false;
  
  private static void a(f paramf)
  {
    if (paramf.uDL != null) {}
    for (paramf = paramf.uDL;; paramf = paramf.uDM)
    {
      paramf = paramf.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT count(*) FROM sqlite_master;", null, null);
      if (paramf.moveToFirst()) {
        break;
      }
      throw new SQLiteException("Cannot get count for sqlite_master");
    }
    paramf.close();
  }
  
  private boolean a(String paramString1, long paramLong, String paramString2, boolean paramBoolean, String paramString3)
  {
    if (this.uDC != null) {
      throw new AssertionError();
    }
    this.key = com.tencent.mm.a.g.o((paramString2 + paramLong).getBytes()).substring(0, 7);
    if (!com.tencent.mm.vfs.e.bK(paramString1)) {}
    for (boolean bool = true;; bool = false)
    {
      this.isNew = bool;
      try
      {
        this.uDC = f.y(paramString1, this.key, paramBoolean);
        a(this.uDC);
        return true;
      }
      catch (SQLiteException localSQLiteException)
      {
        if (!(localSQLiteException instanceof SQLiteDatabaseCorruptException)) {
          break;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramString3 = q.getDeviceID(ae.getContext());
        int j = i;
        if (paramString3 != null)
        {
          j = i;
          if (!paramString3.equals(paramString2))
          {
            j = 0;
            paramString2 = com.tencent.mm.a.g.o((paramString3 + paramLong).getBytes()).substring(0, 7);
            try
            {
              this.uDC = f.y(paramString1, paramString2, paramBoolean);
              a(this.uDC);
              this.key = paramString2;
              l.yP().set(258, paramString3);
              com.tencent.mm.plugin.report.f.nEG.a(181L, 5L, 1L, false);
              return true;
            }
            catch (SQLiteException paramString2)
            {
              if ((paramString2 instanceof SQLiteDatabaseCorruptException)) {
                j = 1;
              }
            }
          }
        }
        if ((this.uDC == null) && (j != 0))
        {
          if (!paramBoolean) {
            i = 42;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.f.nEG.a(181L, i, 1L, true);
            f.acN(paramString1);
            if (paramString1.endsWith("EnMicroMsg.db")) {
              f.acN(com.tencent.mm.kernel.g.DP().dKt + "dbback/EnMicroMsg.db");
            }
            try
            {
              this.uDC = f.y(paramString1, this.key, paramBoolean);
              a(this.uDC);
              this.isNew = true;
              com.tencent.mm.plugin.report.f.nEG.a(181L, 6L, 1L, false);
              return true;
            }
            catch (SQLiteException paramString1)
            {
              com.tencent.mm.plugin.report.f.nEG.a(181L, 7L, 1L, false);
            }
            if (f.cxd()) {
              i = 43;
            } else {
              i = 41;
            }
          }
        }
      }
      for (;;)
      {
        if (this.uDC != null)
        {
          this.uDC.close();
          this.uDC = null;
        }
        this.key = null;
        return false;
        if ((paramString3 != null) && (paramString3.length() > 0))
        {
          if (!com.tencent.mm.vfs.e.bK(paramString3)) {}
          for (bool = true;; bool = false)
          {
            this.isNew = bool;
            try
            {
              this.uDC = f.y(paramString3, this.key, paramBoolean);
              a(this.uDC);
              com.tencent.mm.plugin.report.f.nEG.a(181L, 6L, 1L, false);
              return true;
            }
            catch (SQLiteException paramString1)
            {
              com.tencent.mm.plugin.report.f.nEG.a(181L, 7L, 1L, false);
            }
          }
        }
      }
    }
  }
  
  private boolean a(HashMap<Integer, h.d> paramHashMap, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramHashMap == null) {}
    Object localObject3;
    for (int i = -1;; i = paramHashMap.size())
    {
      y.d("MicroMsg.DBInit", "createtables checkCreateIni:%b  tables:%d", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i) });
      localObject1 = "";
      if (!paramBoolean1) {
        break label316;
      }
      this.uDD = (this.uDC.getPath() + ".ini");
      localObject1 = new StringBuilder();
      if (paramHashMap == null) {
        break;
      }
      localObject2 = paramHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (h.d)((Iterator)localObject2).next();
        if (((h.d)localObject3).rK() == null)
        {
          y.e("MicroMsg.DBInit", "factory.getSQLs() is null: %s", new Object[] { localObject3.getClass().toString() });
          Assert.assertTrue("factory.getSQLs() is null:" + localObject3.getClass().toString(), false);
        }
        localObject3 = ((h.d)localObject3).rK();
        j = localObject3.length;
        i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject1).append(localObject3[i].hashCode());
          i += 1;
        }
      }
    }
    Object localObject2 = com.tencent.mm.a.g.o(((StringBuilder)localObject1).toString().getBytes());
    Object localObject1 = localObject2;
    if (!paramBoolean2)
    {
      localObject3 = com.tencent.mm.sdk.e.a.getValue(this.uDD, "createmd5");
      localObject1 = localObject2;
      if (!bk.bl((String)localObject3))
      {
        localObject1 = localObject2;
        if (((String)localObject2).equals(localObject3))
        {
          y.i("MicroMsg.DBInit", "Create table factories not changed , no need create !  %s", new Object[] { this.uDC.getPath() });
          return true;
        }
      }
    }
    label316:
    this.uDC.execSQL("pragma auto_vacuum = 0 ");
    localObject2 = new g.a();
    this.uDC.beginTransaction();
    if (paramHashMap != null)
    {
      paramHashMap = paramHashMap.values().iterator();
      i = 0;
      String str;
      label550:
      for (;;)
      {
        j = i;
        if (!paramHashMap.hasNext()) {
          break;
        }
        localObject3 = ((h.d)paramHashMap.next()).rK();
        int k = localObject3.length;
        j = 0;
        for (;;)
        {
          if (j >= k) {
            break label550;
          }
          str = localObject3[j];
          try
          {
            this.uDC.execSQL(str);
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Matcher localMatcher = uDB.matcher(str);
              if ((localMatcher != null) && (localMatcher.matches())) {
                Assert.assertTrue("CreateTable failed:[" + str + "][" + localException.getMessage() + "]", false);
              } else {
                y.w("MicroMsg.DBInit", "CreateTable failed:[" + str + "][" + localException.getMessage() + "]");
              }
            }
          }
          j += 1;
        }
      }
    }
    int j = 0;
    long l = ((g.a)localObject2).zJ();
    this.uDC.endTransaction();
    y.i("MicroMsg.DBInit", "createtables end sql:%d trans:%d sqlCount:%d", new Object[] { Long.valueOf(l), Long.valueOf(((g.a)localObject2).zJ()), Integer.valueOf(j) });
    if (paramBoolean1) {
      com.tencent.mm.sdk.e.a.an(this.uDD, "createmd5", (String)localObject1);
    }
    return true;
  }
  
  private void gr(String paramString1, String paramString2)
  {
    HashSet localHashSet = new HashSet();
    Object localObject = this.uDC.a("select * from " + paramString1 + " limit 1 ", null, 0);
    if (((Cursor)localObject).getCount() == 0)
    {
      ((Cursor)localObject).close();
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
    Cursor localCursor = this.uDC.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
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
    this.uDC.execSQL(paramString1);
  }
  
  private List<String> gs(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.uDC == null) {
      return localArrayList;
    }
    Object localObject1 = this.uDC.a("PRAGMA table_info( " + paramString1 + " )", null, 0);
    if (localObject1 == null) {
      return localArrayList;
    }
    paramString1 = new HashMap();
    int i = ((Cursor)localObject1).getColumnIndex("name");
    int j = ((Cursor)localObject1).getColumnIndex("type");
    while (((Cursor)localObject1).moveToNext()) {
      paramString1.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
    }
    ((Cursor)localObject1).close();
    Object localObject2 = this.uDC.a("PRAGMA table_info( " + paramString2 + " )", null, 0);
    if (localObject2 == null) {
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
          y.e("MicroMsg.DBInit", "conflicting alter table on column: " + str1 + ", " + str2 + "<o-n>" + (String)localObject3);
          paramString1.remove(str1);
        }
      }
    }
    return localArrayList;
  }
  
  private boolean gt(String paramString1, String paramString2)
  {
    Cursor localCursor = this.uDC.a("select DISTINCT  tbl_name from sqlite_master;", null, 0);
    if (localCursor == null) {
      return false;
    }
    for (;;)
    {
      try
      {
        if (bk.bl(paramString2))
        {
          this.uDC.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY ''");
          if (!o(localCursor)) {
            break;
          }
          this.uDC.beginTransaction();
          int i = 0;
          if (i >= localCursor.getCount()) {
            break label412;
          }
          localCursor.moveToPosition(i);
          paramString1 = this.uDC.a("select * from old.sqlite_master where tbl_name = '" + localCursor.getString(0) + "'", null, 0);
          if (paramString1 == null) {
            break label438;
          }
          j = paramString1.getCount();
          paramString1.close();
          if (j != 0) {
            break label268;
          }
          y.w("MicroMsg.DBInit", "In old db not found :" + localCursor.getString(0));
          i += 1;
          continue;
        }
        this.uDC.execSQL("ATTACH DATABASE '" + paramString1 + "' AS old KEY '" + paramString2 + "'");
        continue;
        try
        {
          paramString1 = gs("old." + localCursor.getString(0), localCursor.getString(0)).iterator();
          while (paramString1.hasNext())
          {
            paramString2 = (String)paramString1.next();
            this.uDC.execSQL(paramString2);
          }
        }
        catch (Exception paramString1)
        {
          y.w("MicroMsg.DBInit", "Insertselect FAILED :" + localCursor.getString(0));
        }
      }
      catch (SQLiteDatabaseCorruptException paramString2)
      {
        y.e("MicroMsg.DBInit", "Attached database is corrupted: " + paramString1);
        com.tencent.mm.vfs.e.deleteFile(paramString1);
        throw paramString2;
      }
      label268:
      gr("old." + localCursor.getString(0), localCursor.getString(0));
      continue;
      label412:
      this.uDC.endTransaction();
      localCursor.close();
      this.uDC.execSQL("DETACH DATABASE old;");
      return true;
      label438:
      int j = 0;
    }
  }
  
  private boolean gu(String paramString1, String paramString2)
  {
    if (gt(paramString1, paramString2))
    {
      y.i("MicroMsg.DBInit", "system transfer success ,delete it path %s", new Object[] { paramString1 });
      y.i("MicroMsg.DBInit", "delete result :%b", new Object[] { Boolean.valueOf(com.tencent.mm.vfs.e.deleteFile(paramString1)) });
      return true;
    }
    y.i("MicroMsg.DBInit", "system transfer fail path %s", new Object[] { paramString1 });
    return false;
  }
  
  private boolean o(Cursor paramCursor)
  {
    HashSet localHashSet = new HashSet();
    Object localObject = new HashSet();
    int i = 0;
    while (i < paramCursor.getCount())
    {
      paramCursor.moveToPosition(i);
      localHashSet.add(paramCursor.getString(0));
      i += 1;
    }
    paramCursor = this.uDC.a("select DISTINCT tbl_name from old.sqlite_master;", null, 0);
    if (paramCursor == null) {
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
    this.uDC.beginTransaction();
    paramCursor = ((HashSet)localObject).iterator();
    while (paramCursor.hasNext())
    {
      localObject = (String)paramCursor.next();
      if (!localHashSet.contains(localObject))
      {
        localObject = this.uDC.a("SELECT sql FROM old.sqlite_master WHERE type='table' AND tbl_name='" + (String)localObject + "'", null, 0);
        if (localObject != null)
        {
          String str = ((Cursor)localObject).getString(0);
          this.uDC.execSQL(str);
          ((Cursor)localObject).close();
        }
      }
    }
    this.uDC.endTransaction();
    return true;
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, HashMap<Integer, h.d> paramHashMap, boolean paramBoolean)
  {
    boolean bool1;
    boolean bool3;
    boolean bool4;
    int i;
    label92:
    label125:
    int j;
    if (!bk.bl(paramString2))
    {
      bool1 = true;
      Assert.assertTrue("create SqliteDB enDbCachePath == null ", bool1);
      this.uDF = (paramString2 + ".errreport");
      if (this.uDC != null)
      {
        this.uDC.close();
        this.uDC = null;
      }
      boolean bool2 = com.tencent.mm.vfs.e.bK(paramString2);
      bool3 = com.tencent.mm.vfs.e.bK(paramString1);
      bool4 = com.tencent.mm.vfs.e.bK(paramString3);
      if ((bool2) || (!bool3)) {
        break label259;
      }
      i = 1;
      this.uDE = a(paramString2, paramLong, paramString4, f.cxc(), paramString3);
      boolean bool5 = this.uDE;
      if (this.uDC == null) {
        break label265;
      }
      bool1 = true;
      y.i("MicroMsg.DBInit", "initDb(en) path:%s enExist:%b oldExist:%b copyold:%b dbopenSUCC:%b db:%b thr:%s", new Object[] { paramString2, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(true), Boolean.valueOf(bool5), Boolean.valueOf(bool1), Thread.currentThread().getName() });
      if ((this.uDC == null) || (this.uDC.getPath().equals(paramString3)) || (!bool4)) {
        break label379;
      }
      j = 1;
      y.i("MicroMsg.DBInit", "backup db exsits, copy data to en db");
    }
    for (;;)
    {
      a(paramHashMap, paramBoolean, this.isNew);
      if ((!bool3) && (!bool4))
      {
        return true;
        bool1 = false;
        break;
        label259:
        i = 0;
        break label92;
        label265:
        bool1 = false;
        break label125;
      }
      if ((j != 0) || (i != 0)) {
        this.uDG = true;
      }
      if (j != 0)
      {
        this.key = com.tencent.mm.a.g.o((paramString4 + paramLong).getBytes()).substring(0, 7);
        gu(paramString3, this.key);
        com.tencent.mm.blink.a.m(201L, 1L);
      }
      if (i != 0)
      {
        paramBoolean = gu(paramString1, "");
        com.tencent.mm.blink.a.m(200L, 1L);
        return paramBoolean;
      }
      return this.uDC != null;
      label379:
      j = 0;
    }
  }
  
  public final boolean a(String paramString, HashMap<Integer, h.d> paramHashMap, boolean paramBoolean)
  {
    boolean bool1 = false;
    if (this.uDC != null)
    {
      this.uDC.close();
      this.uDC = null;
    }
    boolean bool2 = com.tencent.mm.vfs.e.bK(paramString);
    try
    {
      y.i("MicroMsg.DBInit", "initSysDB checkini:%b exist:%b db:%s ", new Object[] { Boolean.valueOf(true), Boolean.valueOf(bool2), paramString });
      this.uDC = f.bF(paramString, paramBoolean);
      paramBoolean = bool1;
      if (!bool2) {
        paramBoolean = true;
      }
      a(paramHashMap, true, paramBoolean);
      return true;
    }
    catch (SQLiteException paramString) {}
    return false;
  }
  
  public final String getError()
  {
    if ((bk.bl(this.aox)) || (bk.bl(this.uDF))) {
      return "";
    }
    if (!bk.bl(com.tencent.mm.sdk.e.a.getValue(this.uDF, "Reported"))) {
      return "";
    }
    com.tencent.mm.sdk.e.a.an(this.uDF, "Reported", "true");
    return this.aox;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.a
 * JD-Core Version:    0.7.0.1
 */