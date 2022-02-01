package com.tencent.mm.plugin.expt.d.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.sdk.platformtools.ae;
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
    AppMethodBeat.i(195900);
    if ((parama == null) || (org.apache.commons.b.g.ef(paramString)))
    {
      AppMethodBeat.o(195900);
      return false;
    }
    localObject = null;
    locala = null;
    try
    {
      parama = parama.a("SELECT 1 FROM sqlite_master WHERE type='table' AND name=?;", new String[] { paramString }, 0);
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
        ae.e("EdgeComputingDBService", "[EdgeComputingDBService] checkTableExist throw Exception : " + parama.getMessage());
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
        break label177;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(195900);
    }
    AppMethodBeat.o(195900);
    return bool1;
  }
  
  private static boolean a(r.a parama, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(195901);
    if ((parama == null) || (org.apache.commons.b.g.ef(paramString)) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(195901);
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
    ae.i("EdgeComputingDBService", "[EdgeComputingDBService] createTable tableName : %s", new Object[] { paramString });
    ae.d("EdgeComputingDBService", "[EdgeComputingDBService] createTable tableName : %s, createTableSQL : %s", new Object[] { paramString, localStringBuilder.toString() });
    if ((parama instanceof h)) {}
    for (;;)
    {
      long l;
      if (parama != null) {
        l = parama.yi(-1L);
      }
      for (;;)
      {
        try
        {
          bool = parama.execSQL(paramString, localStringBuilder.toString());
          parama.sW(l);
        }
        catch (Exception paramString)
        {
          ae.e("EdgeComputingDBService", "[EdgeComputingDataDao] createTable throw Exception : " + paramString.getMessage());
          parama.sW(l);
          bool = false;
          continue;
        }
        finally
        {
          parama.sW(l);
          AppMethodBeat.o(195901);
        }
        AppMethodBeat.o(195901);
        return bool;
        boolean bool = false;
      }
      parama = null;
    }
  }
  
  public final boolean c(String paramString1, String paramString2, List<String> paramList, List<List<String>> paramList1)
  {
    AppMethodBeat.i(195899);
    if ((org.apache.commons.b.g.ef(paramString1)) || (org.apache.commons.b.g.ef(paramString2)) || (paramList == null) || (paramList.size() <= 0) || (paramList1.size() <= 0))
    {
      AppMethodBeat.o(195899);
      return false;
    }
    Object localObject = com.tencent.mm.kernel.g.ajR().cachePath + paramString1;
    ae.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB dbPath : " + paramString1 + ", realDBPath : " + (String)localObject);
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
        ae.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB createDBInstance throw Exception : " + localException.getMessage());
        ae.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB createDBInstance throw Exception, realDBPath : ".concat(String.valueOf(localObject)));
      }
      if ((a(paramString1, paramString2)) || (a(paramString1, paramString2, paramList))) {
        break label243;
      }
      if ((paramString1 == null) || (paramString1.fqe())) {
        break label236;
      }
      paramString1.ra(hashCode());
      AppMethodBeat.o(195899);
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
                ae.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + paramList1.getMessage());
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
      ae.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB tableName : ".concat(String.valueOf(paramString2)));
      bool2 = false;
      if (!(paramString1 instanceof h)) {
        break label749;
      }
    }
    if (paramString1 == null)
    {
      ae.d("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB dataDB is null, realDBPath : ".concat(String.valueOf(localObject)));
      AppMethodBeat.o(195899);
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
        l = paramList.yi(-1L);
      }
      try
      {
        bool1 = paramString1.execSQL(paramString2, localStringBuilder.toString());
        bool2 = bool1;
        paramList.sW(l);
        bool1 = bool2;
        if (paramString1 != null)
        {
          bool1 = bool2;
          if (!paramString1.fqe())
          {
            paramString1.ra(hashCode());
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ae.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + paramString2.getMessage());
          paramList.sW(l);
          bool1 = bool2;
          if (paramString1 != null)
          {
            bool1 = bool2;
            if (!paramString1.fqe())
            {
              paramString1.ra(hashCode());
              bool1 = bool2;
            }
          }
        }
      }
      finally
      {
        paramList.sW(l);
        if ((paramString1 == null) || (paramString1.fqe())) {
          continue;
        }
        paramString1.ra(hashCode());
        AppMethodBeat.o(195899);
      }
      AppMethodBeat.o(195899);
      return bool1;
    }
  }
  
  public final List<List<String>> fU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(195898);
    if ((org.apache.commons.b.g.ef(paramString1)) || (org.apache.commons.b.g.ef(paramString2)))
    {
      AppMethodBeat.o(195898);
      return null;
    }
    Object localObject1 = com.tencent.mm.kernel.g.ajR().cachePath + paramString1;
    ae.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL dbPath : " + paramString1 + ", realDBPath : " + (String)localObject1 + ", sql : " + paramString2);
    String[] arrayOfString;
    try
    {
      paramString1 = r.a(hashCode(), (String)localObject1, new HashMap(), true);
      if (paramString1 == null)
      {
        ae.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL dataDB is null, realDBPath : ".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(195898);
        return null;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ae.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL createDBInstance throw Exception : " + paramString1.getMessage());
        ae.d("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL createDBInstance throw Exception, realDBPath : ".concat(String.valueOf(localObject1)));
        paramString1 = null;
      }
      try
      {
        paramString2 = paramString1.a(paramString2, null, 0);
        if ((paramString2 == null) || (!paramString2.moveToFirst()))
        {
          if ((paramString1 != null) && (!paramString1.fqe())) {
            paramString1.ra(hashCode());
          }
          AppMethodBeat.o(195898);
          return null;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          ae.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL rawQuery throw Exception : " + paramString2.getMessage());
          paramString2 = null;
        }
        arrayOfString = paramString2.getColumnNames();
        if ((arrayOfString == null) || (arrayOfString.length <= 0))
        {
          if ((paramString2 != null) && (!paramString2.isClosed())) {
            paramString2.close();
          }
          if ((paramString1 != null) && (!paramString1.fqe())) {
            paramString1.ra(hashCode());
          }
          AppMethodBeat.o(195898);
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
          break label568;
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
        if ((paramString1 != null) && (!paramString1.fqe())) {
          paramString1.ra(hashCode());
        }
      }
      catch (Exception localException1)
      {
        ae.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL moveToNext throw Exception : " + localException1.getMessage());
        if ((paramString2 == null) || (paramString2.isClosed())) {
          continue;
        }
        paramString2.close();
        if ((paramString1 == null) || (paramString1.fqe())) {
          continue;
        }
        paramString1.ra(hashCode());
        continue;
      }
      finally
      {
        if ((paramString2 == null) || (paramString2.isClosed())) {
          continue;
        }
        paramString2.close();
        if ((paramString1 == null) || (paramString1.fqe())) {
          continue;
        }
        paramString1.ra(hashCode());
        AppMethodBeat.o(195898);
      }
      AppMethodBeat.o(195898);
      return localObject1;
      label568:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.c.a
 * JD-Core Version:    0.7.0.1
 */