package com.tencent.mm.plugin.expt.d.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static boolean a(r.a parama, String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(220322);
    if ((parama == null) || (org.apache.commons.b.g.eP(paramString)))
    {
      AppMethodBeat.o(220322);
      return false;
    }
    localObject = null;
    locala = null;
    try
    {
      parama = parama.rawQuery("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString });
      locala = parama;
      localObject = parama;
      bool1 = parama.moveToNext();
      bool2 = bool1;
      bool1 = bool2;
      if (parama != null)
      {
        bool1 = bool2;
        if (!parama.isClosed())
        {
          parama.close();
          bool1 = bool2;
        }
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        localObject = locala;
        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] checkTableExist throw Exception : " + parama.getMessage());
        boolean bool1 = bool2;
        if (locala != null)
        {
          bool1 = bool2;
          if (!locala.isClosed())
          {
            locala.close();
            bool1 = bool2;
          }
        }
      }
    }
    finally
    {
      if ((localObject == null) || (((Cursor)localObject).isClosed())) {
        break label176;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(220322);
    }
    AppMethodBeat.o(220322);
    return bool1;
  }
  
  private static boolean a(r.a parama, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(220323);
    if ((parama == null) || (org.apache.commons.b.g.eP(paramString)) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(220323);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS " + paramString + " ( ");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append((String)paramList.next()).append(" TEXT,");
    }
    if (localStringBuilder.toString().endsWith(",")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(");");
    Log.i("EdgeComputingDBService", "[EdgeComputingDBService] createTable tableName : %s", new Object[] { paramString });
    Log.d("EdgeComputingDBService", "[EdgeComputingDBService] createTable tableName : %s, createTableSQL : %s", new Object[] { paramString, localStringBuilder.toString() });
    if ((parama instanceof h)) {}
    for (;;)
    {
      long l;
      if (parama != null) {
        l = parama.beginTransaction(-1L);
      }
      for (;;)
      {
        try
        {
          bool = parama.execSQL(paramString, localStringBuilder.toString());
          parama.endTransaction(l);
        }
        catch (Exception paramString)
        {
          Log.e("EdgeComputingDBService", "[EdgeComputingDataDao] createTable throw Exception : " + paramString.getMessage());
          parama.endTransaction(l);
          bool = false;
          continue;
        }
        finally
        {
          parama.endTransaction(l);
          AppMethodBeat.o(220323);
        }
        AppMethodBeat.o(220323);
        return bool;
        boolean bool = false;
      }
      parama = null;
    }
  }
  
  public final boolean c(String paramString1, String paramString2, List<String> paramList, List<List<String>> paramList1)
  {
    AppMethodBeat.i(220321);
    if ((org.apache.commons.b.g.eP(paramString1)) || (org.apache.commons.b.g.eP(paramString2)) || (paramList == null) || (paramList.size() <= 0) || (paramList1.size() <= 0))
    {
      AppMethodBeat.o(220321);
      return false;
    }
    Object localObject = com.tencent.mm.kernel.g.aAh().cachePath + paramString1;
    Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB dbPath : " + paramString1 + ", realDBPath : " + (String)localObject);
    paramString1 = null;
    label236:
    label243:
    StringBuilder localStringBuilder;
    try
    {
      r.a locala = r.a(hashCode(), (String)localObject, new HashMap(), true);
      paramString1 = locala;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB createDBInstance throw Exception : " + localException.getMessage());
        Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB createDBInstance throw Exception, realDBPath : ".concat(String.valueOf(localObject)));
      }
      if ((a(paramString1, paramString2)) || (a(paramString1, paramString2, paramList))) {
        break label243;
      }
      if ((paramString1 == null) || (paramString1.isClose())) {
        break label236;
      }
      paramString1.uS(hashCode());
      AppMethodBeat.o(220321);
      return false;
      localStringBuilder = new StringBuilder("INSERT INTO ");
      localStringBuilder.append(paramString2).append(" ( ");
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuilder.append((String)paramList.get(i)).append(",");
        i += 1;
      }
      if (!localStringBuilder.toString().endsWith(",")) {
        break label337;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      localStringBuilder.append(" ) VALUES ");
      localObject = paramList1.iterator();
      while (((Iterator)localObject).hasNext())
      {
        List localList = (List)((Iterator)localObject).next();
        localStringBuilder.append("(");
        i = 0;
        for (;;)
        {
          if (i < paramList.size()) {
            try
            {
              paramList1 = (String)localList.get(i);
              localStringBuilder.append("'").append(paramList1).append("',");
              i += 1;
            }
            catch (Exception paramList1)
            {
              for (;;)
              {
                Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + paramList1.getMessage());
                paramList1 = "''";
              }
            }
          }
        }
        if (localStringBuilder.toString().endsWith(",")) {
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
        }
        localStringBuilder.append("),");
      }
      if (!localStringBuilder.toString().endsWith(",")) {
        break label536;
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      localStringBuilder.append(";");
      Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB tableName : ".concat(String.valueOf(paramString2)));
      bool2 = false;
      if (!(paramString1 instanceof h)) {
        break label749;
      }
    }
    if (paramString1 == null)
    {
      Log.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB dataDB is null, realDBPath : ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(220321);
      return false;
    }
    label337:
    boolean bool2;
    label536:
    boolean bool1;
    long l;
    label749:
    for (paramList = paramString1;; paramList = null)
    {
      bool1 = bool2;
      if (paramList != null) {
        l = paramList.beginTransaction(-1L);
      }
      try
      {
        bool1 = paramString1.execSQL(paramString2, localStringBuilder.toString());
        bool2 = bool1;
        paramList.endTransaction(l);
        bool1 = bool2;
        if (paramString1 != null)
        {
          bool1 = bool2;
          if (!paramString1.isClose())
          {
            paramString1.uS(hashCode());
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + paramString2.getMessage());
          paramList.endTransaction(l);
          bool1 = bool2;
          if (paramString1 != null)
          {
            bool1 = bool2;
            if (!paramString1.isClose())
            {
              paramString1.uS(hashCode());
              bool1 = bool2;
            }
          }
        }
      }
      finally
      {
        paramList.endTransaction(l);
        if ((paramString1 == null) || (paramString1.isClose())) {
          continue;
        }
        paramString1.uS(hashCode());
        AppMethodBeat.o(220321);
      }
      AppMethodBeat.o(220321);
      return bool1;
    }
  }
  
  public final List<List<String>> gn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220320);
    if ((org.apache.commons.b.g.eP(paramString1)) || (org.apache.commons.b.g.eP(paramString2)))
    {
      AppMethodBeat.o(220320);
      return null;
    }
    Object localObject1 = com.tencent.mm.kernel.g.aAh().cachePath + paramString1;
    Log.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL dbPath : " + paramString1 + ", realDBPath : " + (String)localObject1 + ", sql : " + paramString2);
    String[] arrayOfString;
    try
    {
      paramString1 = r.a(hashCode(), (String)localObject1, new HashMap(), true);
      if (paramString1 == null)
      {
        Log.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL dataDB is null, realDBPath : ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(220320);
        return null;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL createDBInstance throw Exception : " + paramString1.getMessage());
        Log.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL createDBInstance throw Exception, realDBPath : ".concat(String.valueOf(localObject1)));
        paramString1 = null;
      }
      try
      {
        paramString2 = paramString1.rawQuery(paramString2, null);
        if ((paramString2 == null) || (!paramString2.moveToFirst()))
        {
          if ((paramString1 != null) && (!paramString1.isClose())) {
            paramString1.uS(hashCode());
          }
          AppMethodBeat.o(220320);
          return null;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL rawQuery throw Exception : " + paramString2.getMessage());
          paramString2 = null;
        }
        arrayOfString = paramString2.getColumnNames();
        if ((arrayOfString == null) || (arrayOfString.length <= 0))
        {
          if ((paramString2 != null) && (!paramString2.isClosed())) {
            paramString2.close();
          }
          if ((paramString1 != null) && (!paramString1.isClose())) {
            paramString1.uS(hashCode());
          }
          AppMethodBeat.o(220320);
          return null;
        }
        localObject1 = new ArrayList();
      }
    }
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        int j = arrayOfString.length;
        if (i >= j) {
          break label567;
        }
        try
        {
          localArrayList.add(paramString2.getString(i));
          i += 1;
        }
        catch (Exception localException2)
        {
          i = 1;
        }
        if (i == 0) {
          ((List)localObject1).add(localArrayList);
        }
        boolean bool = paramString2.moveToNext();
        if (bool) {
          continue;
        }
        if ((paramString2 != null) && (!paramString2.isClosed())) {
          paramString2.close();
        }
        if ((paramString1 != null) && (!paramString1.isClose())) {
          paramString1.uS(hashCode());
        }
      }
      catch (Exception localException1)
      {
        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL moveToNext throw Exception : " + localException1.getMessage());
        if ((paramString2 == null) || (paramString2.isClosed())) {
          continue;
        }
        paramString2.close();
        if ((paramString1 == null) || (paramString1.isClose())) {
          continue;
        }
        paramString1.uS(hashCode());
        continue;
      }
      finally
      {
        if ((paramString2 == null) || (paramString2.isClosed())) {
          continue;
        }
        paramString2.close();
        if ((paramString1 == null) || (paramString1.isClose())) {
          continue;
        }
        paramString1.uS(hashCode());
        AppMethodBeat.o(220320);
      }
      AppMethodBeat.o(220320);
      return localObject1;
      label567:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.c.a
 * JD-Core Version:    0.7.0.1
 */