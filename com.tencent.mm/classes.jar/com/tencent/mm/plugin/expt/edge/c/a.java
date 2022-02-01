package com.tencent.mm.plugin.expt.edge.c;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.o;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.plugin.expt.edge.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public final class a
{
  private Map<String, o.a> zzN;
  
  public a()
  {
    AppMethodBeat.i(299620);
    this.zzN = new HashMap();
    AppMethodBeat.o(299620);
  }
  
  private static boolean a(o.a parama, String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(299634);
    if ((parama == null) || (i.hm(paramString)))
    {
      AppMethodBeat.o(299634);
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
      AppMethodBeat.o(299634);
    }
    AppMethodBeat.o(299634);
    return bool1;
  }
  
  private static boolean a(o.a parama, String paramString, List<String> paramList)
  {
    AppMethodBeat.i(299642);
    if ((parama == null) || (i.hm(paramString)) || (paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299642);
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
    b.o("EdgeComputingDBService", "[EdgeComputingDBService] createTable tableName : %s, createTableSQL : %s", new Object[] { paramString, localStringBuilder.toString() });
    if ((parama instanceof com.tencent.mm.storagebase.h)) {}
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
          AppMethodBeat.o(299642);
        }
        AppMethodBeat.o(299642);
        return bool;
        boolean bool = false;
      }
      parama = null;
    }
  }
  
  private o.a aqn(String paramString)
  {
    AppMethodBeat.i(299627);
    if (i.hm(paramString))
    {
      AppMethodBeat.o(299627);
      return null;
    }
    Object localObject1 = (o.a)this.zzN.get(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = com.tencent.mm.kernel.h.baE().cachePath + paramString;
    }
    try
    {
      localObject2 = o.a(hashCode(), (String)localObject2, new HashMap(), true);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] getOrCreateDataDB getOrCreateDataDB throw Exception : " + localException.getMessage());
      }
    }
    localObject2 = localObject1;
    if (localObject1 != null)
    {
      this.zzN.put(paramString, localObject1);
      localObject2 = localObject1;
    }
    AppMethodBeat.o(299627);
    return localObject2;
  }
  
  public final boolean c(String paramString1, String paramString2, List<String> paramList, List<List<String>> paramList1)
  {
    AppMethodBeat.i(299665);
    if ((i.hm(paramString1)) || (i.hm(paramString2)) || (paramList == null) || (paramList.size() <= 0) || (paramList1.size() <= 0))
    {
      AppMethodBeat.o(299665);
      return false;
    }
    o.a locala = aqn(paramString1);
    if (locala == null)
    {
      b.hf("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB dataDB is null, dbPath : ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(299665);
      return false;
    }
    if ((!a(locala, paramString2)) && (!a(locala, paramString2, paramList)))
    {
      AppMethodBeat.o(299665);
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder("INSERT INTO ");
    localStringBuilder.append(paramString2).append(" ( ");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append((String)paramList.get(i)).append(",");
      i += 1;
    }
    if (localStringBuilder.toString().endsWith(",")) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    localStringBuilder.append(" ) VALUES ");
    paramList1 = paramList1.iterator();
    while (paramList1.hasNext())
    {
      List localList = (List)paramList1.next();
      localStringBuilder.append("(");
      i = 0;
      for (;;)
      {
        if (i < paramList.size()) {
          try
          {
            paramString1 = (String)localList.get(i);
            localStringBuilder.append("'").append(paramString1).append("',");
            i += 1;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + paramString1.getMessage());
              paramString1 = "''";
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
    b.hf("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB tableName : ".concat(String.valueOf(paramString2)));
    boolean bool2 = false;
    if ((locala instanceof com.tencent.mm.storagebase.h)) {}
    boolean bool1;
    long l;
    for (paramString1 = locala;; paramString1 = null)
    {
      bool1 = bool2;
      if (paramString1 != null) {
        l = paramString1.beginTransaction(-1L);
      }
      try
      {
        bool1 = paramString1.execSQL(paramString2, localStringBuilder.toString());
        paramString1.endTransaction(l);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.e("EdgeComputingDBService", "[EdgeComputingDBService] saveDatasToDB throw Exception : " + paramString2.getMessage());
          paramString1.endTransaction(l);
          bool1 = bool2;
        }
      }
      finally
      {
        paramString1.endTransaction(l);
        AppMethodBeat.o(299665);
      }
      AppMethodBeat.o(299665);
      return bool1;
    }
  }
  
  public final List<List<String>> hi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(299654);
    if ((i.hm(paramString1)) || (i.hm(paramString2)))
    {
      AppMethodBeat.o(299654);
      return null;
    }
    Object localObject = aqn(paramString1);
    if (localObject == null)
    {
      b.hf("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL dataDB is null, dbPath : ".concat(String.valueOf(paramString1)));
      AppMethodBeat.o(299654);
      return null;
    }
    try
    {
      paramString1 = ((o.a)localObject).rawQuery(paramString2, null);
      if ((paramString1 == null) || (!paramString1.moveToFirst()))
      {
        AppMethodBeat.o(299654);
        return null;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL rawQuery throw Exception : " + paramString1.getMessage());
        paramString1 = null;
      }
      localObject = paramString1.getColumnNames();
      if ((localObject == null) || (localObject.length <= 0))
      {
        if ((paramString1 != null) && (!paramString1.isClosed())) {
          paramString1.close();
        }
        AppMethodBeat.o(299654);
        return null;
      }
      paramString2 = new ArrayList();
    }
    for (;;)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        i = 0;
        int j = localObject.length;
        if (i >= j) {
          break label347;
        }
        try
        {
          localArrayList.add(paramString1.getString(i));
          i += 1;
        }
        catch (Exception localException2)
        {
          i = 1;
        }
        if (i == 0) {
          paramString2.add(localArrayList);
        }
        boolean bool = paramString1.moveToNext();
        if (bool) {
          continue;
        }
        if ((paramString1 != null) && (!paramString1.isClosed())) {
          paramString1.close();
        }
      }
      catch (Exception localException1)
      {
        Log.e("EdgeComputingDBService", "[EdgeComputingDBService] queryDataBySQL moveToNext throw Exception : " + localException1.getMessage());
        if ((paramString1 == null) || (paramString1.isClosed())) {
          continue;
        }
        paramString1.close();
        continue;
      }
      finally
      {
        if ((paramString1 == null) || (paramString1.isClosed())) {
          continue;
        }
        paramString1.close();
        AppMethodBeat.o(299654);
      }
      AppMethodBeat.o(299654);
      return paramString2;
      label347:
      int i = 0;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(299670);
    Iterator localIterator = this.zzN.values().iterator();
    while (localIterator.hasNext())
    {
      o.a locala = (o.a)localIterator.next();
      if ((locala != null) && (!locala.isClose())) {
        locala.yb(hashCode());
      }
    }
    this.zzN.clear();
    AppMethodBeat.o(299670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.c.a
 * JD-Core Version:    0.7.0.1
 */