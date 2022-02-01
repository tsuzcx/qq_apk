package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class d
  extends j<c>
  implements o
{
  public static final String[] SQL_CREATE;
  private e iMV;
  private b<String, String> iRK;
  private m<String, String, y> iRL;
  
  static
  {
    AppMethodBeat.i(146951);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;" };
    AppMethodBeat.o(146951);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "AppBrandKVData", null);
    AppMethodBeat.i(146935);
    this.iRK = new b() {};
    this.iRL = new m() {};
    this.iMV = parame;
    AppMethodBeat.o(146935);
  }
  
  private int EF(String paramString)
  {
    AppMethodBeat.i(146948);
    paramString = this.iMV.a("AppBrandKVData", new String[] { "size" }, "key = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      int i = paramString.getInt(0);
      paramString.close();
      AppMethodBeat.o(146948);
      return i;
    }
    paramString.close();
    AppMethodBeat.o(146948);
    return 0;
  }
  
  private int T(int paramInt, String paramString)
  {
    AppMethodBeat.i(146944);
    c localc = new c();
    localc.field_key = s.n(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@");
    if (super.get(localc, new String[0]))
    {
      paramInt = bt.getInt(localc.field_data, 0);
      AppMethodBeat.o(146944);
      return paramInt;
    }
    AppMethodBeat.o(146944);
    return 0;
  }
  
  private void aQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(146942);
    s.b(paramString, paramInt, this.iRK, this.iRL);
    AppMethodBeat.o(146942);
  }
  
  private void f(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(146946);
    c localc = new c();
    localc.field_key = s.n(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@");
    localc.field_data = String.valueOf(paramInt2);
    super.replace(localc);
    AppMethodBeat.o(146946);
  }
  
  private int g(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(146947);
    paramInt2 = Math.max(0, T(paramInt1, paramString) + paramInt2);
    f(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(146947);
    return paramInt2;
  }
  
  public final void EC(String paramString)
  {
    AppMethodBeat.i(146940);
    int i = 0;
    while (i <= 2)
    {
      R(i, paramString);
      i += 1;
    }
    AppMethodBeat.o(146940);
  }
  
  public final int[] ED(String paramString)
  {
    AppMethodBeat.i(146941);
    paramString = s.a(paramString, this.iRK, this.iRL);
    AppMethodBeat.o(146941);
    return paramString;
  }
  
  public final int EE(String paramString)
  {
    AppMethodBeat.i(146945);
    int[] arrayOfInt = ED(paramString);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = T(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(146945);
    return i;
  }
  
  public final void R(int paramInt, String paramString)
  {
    AppMethodBeat.i(146939);
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      aQ(paramString, paramInt);
      this.iMV.delete("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", new Object[] { "key", "key" }), new String[] { str.replace("_", "\\_") + "%", "\\", s.n(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@") });
      AppMethodBeat.o(146939);
      return;
    }
  }
  
  public final Object[] S(int paramInt, String paramString)
  {
    AppMethodBeat.i(146943);
    if (paramInt == 0) {}
    Object localObject1;
    Object localObject2;
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      localObject1 = this.iMV;
      localObject2 = str.replace("_", "\\_") + "%";
      localObject1 = ((e)localObject1).a("AppBrandKVData", new String[] { "key" }, "key like ? escape ?", new String[] { localObject2, "\\" }, null, null, null, 2);
      localObject2 = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        ((ArrayList)localObject2).add(((Cursor)localObject1).getString(0).replace(str, ""));
      }
    }
    ((Cursor)localObject1).close();
    int i = T(paramInt, paramString);
    paramInt = s.U(paramInt, paramString);
    AppMethodBeat.o(146943);
    return new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final o.a c(final int paramInt, final String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(146937);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.iSQ;
      AppMethodBeat.o(146937);
      return paramString1;
    }
    Object localObject1 = s.c(paramInt, paramString1, paramString2, "__");
    int i = EF((String)localObject1);
    int j = s.cf(paramString2, paramString3);
    final int k = j - i;
    if (T(paramInt, paramString1) + k >= s.U(paramInt, paramString1)) {}
    for (i = 1; i != 0; i = 0)
    {
      paramString1 = o.a.iSS;
      AppMethodBeat.o(146937);
      return paramString1;
    }
    Object localObject2 = new c();
    ((c)localObject2).field_key = ((String)localObject1);
    ((c)localObject2).field_data = paramString3;
    ((c)localObject2).field_dataType = paramString4;
    ((c)localObject2).field_size = j;
    paramString4 = new a() {};
    try
    {
      paramString3 = (o.a)paramString4.invoke();
      AppMethodBeat.o(146937);
      return paramString3;
    }
    catch (SQLiteException paramString3)
    {
      if (bt.nullAsNil(paramString3.getMessage()).contains("no such table"))
      {
        ad.e("AppBrandKVStorage", "set storageId[%d] appId[%s] key[%s], get exception[%s] try create table", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
        try
        {
          Object localObject3 = c.info;
          localObject1 = this.iMV;
          localObject2 = getTableName();
          localObject3 = getUpdateSQLs((c.a)localObject3, getTableName(), (e)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            if (!((e)localObject1).execSQL((String)localObject2, str)) {
              ad.e("AppBrandKVStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { localObject2, str });
            }
          }
          paramString4 = (o.a)paramString4.invoke();
        }
        catch (SQLiteException paramString4)
        {
          paramString1 = String.format(Locale.ENGLISH, "set storageId[%d] appId[%s] key[%s], get exception[%s] after retry", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
          ad.e("AppBrandKVStorage", paramString1);
          paramString1 = new SQLiteException(paramString1, paramString4);
          AppMethodBeat.o(146937);
          throw paramString1;
        }
        AppMethodBeat.o(146937);
        return paramString4;
      }
      AppMethodBeat.o(146937);
      throw paramString3;
    }
  }
  
  public final Object[] l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146936);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.iSQ;
      AppMethodBeat.o(146936);
      return new Object[] { paramString1 };
    }
    Object localObject2 = new c();
    ((c)localObject2).field_key = s.c(paramInt, paramString1, paramString2, "__");
    try
    {
      if (super.get((com.tencent.mm.sdk.e.c)localObject2, new String[0]))
      {
        localObject1 = o.a.iSO;
        String str = ((c)localObject2).field_data;
        localObject2 = ((c)localObject2).field_dataType;
        AppMethodBeat.o(146936);
        return new Object[] { localObject1, str, localObject2 };
      }
      Object localObject1 = s.iSV;
      AppMethodBeat.o(146936);
      return localObject1;
    }
    catch (SQLiteException localSQLiteException)
    {
      if (bt.nullAsNil(localSQLiteException.getMessage()).contains("no such table"))
      {
        ad.e("AppBrandKVStorage", "get storageId[%d] appId[%s] key[%s], no such table, return RET_GET_NO_SUCH_KEY", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        paramString1 = s.iSV;
        AppMethodBeat.o(146936);
        return paramString1;
      }
      if (localSQLiteException.getClass().getName().endsWith("CursorWindowAllocationException"))
      {
        paramString1 = o.a.iST;
        AppMethodBeat.o(146936);
        return new Object[] { paramString1 };
      }
      AppMethodBeat.o(146936);
      throw localSQLiteException;
    }
  }
  
  public final o.a m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146938);
    if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
    {
      paramString1 = o.a.iSQ;
      AppMethodBeat.o(146938);
      return paramString1;
    }
    paramString2 = s.c(paramInt, paramString1, paramString2, "__");
    int i = g(paramInt, paramString1, -EF(paramString2));
    c localc = new c();
    localc.field_key = paramString2;
    super.delete(localc, new String[0]);
    if (i <= 0) {
      aQ(paramString1, paramInt);
    }
    paramString1 = o.a.iSO;
    AppMethodBeat.o(146938);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.d
 * JD-Core Version:    0.7.0.1
 */