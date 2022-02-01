package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.x;

public class d
  extends MAutoStorage<c>
  implements p
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase kLX;
  private b<String, String> kRJ;
  private m<String, String, x> kRK;
  
  static
  {
    AppMethodBeat.i(146951);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;" };
    AppMethodBeat.o(146951);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "AppBrandKVData", null);
    AppMethodBeat.i(146935);
    this.kRJ = new b() {};
    this.kRK = new m() {};
    this.kLX = paramISQLiteDatabase;
    AppMethodBeat.o(146935);
  }
  
  private int VM(String paramString)
  {
    AppMethodBeat.i(146948);
    paramString = this.kLX.query("AppBrandKVData", new String[] { "size" }, "key = ?", new String[] { paramString }, null, null, null, 2);
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
  
  private int aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(146944);
    c localc = new c();
    localc.field_key = t.n(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@");
    if (super.get(localc, new String[0]))
    {
      paramInt = Util.getInt(localc.field_data, 0);
      AppMethodBeat.o(146944);
      return paramInt;
    }
    AppMethodBeat.o(146944);
    return 0;
  }
  
  private void be(String paramString, int paramInt)
  {
    AppMethodBeat.i(146942);
    t.b(paramString, paramInt, this.kRJ, this.kRK);
    AppMethodBeat.o(146942);
  }
  
  private void g(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(146946);
    c localc = new c();
    localc.field_key = t.n(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@");
    localc.field_data = String.valueOf(paramInt2);
    super.replace(localc);
    AppMethodBeat.o(146946);
  }
  
  private int h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(146947);
    paramInt2 = Math.max(0, aa(paramInt1, paramString) + paramInt2);
    g(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(146947);
    return paramInt2;
  }
  
  public final void VJ(String paramString)
  {
    AppMethodBeat.i(146940);
    int i = 0;
    while (i <= 2)
    {
      Y(i, paramString);
      i += 1;
    }
    AppMethodBeat.o(146940);
  }
  
  public final int[] VK(String paramString)
  {
    AppMethodBeat.i(146941);
    paramString = t.a(paramString, this.kRJ, this.kRK);
    AppMethodBeat.o(146941);
    return paramString;
  }
  
  public final int VL(String paramString)
  {
    AppMethodBeat.i(146945);
    int[] arrayOfInt = VK(paramString);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = aa(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(146945);
    return i;
  }
  
  public final void Y(int paramInt, String paramString)
  {
    AppMethodBeat.i(146939);
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      be(paramString, paramInt);
      this.kLX.delete("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", new Object[] { "key", "key" }), new String[] { str.replace("_", "\\_") + "%", "\\", t.n(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@") });
      AppMethodBeat.o(146939);
      return;
    }
  }
  
  public final Object[] Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(146943);
    if (paramInt == 0) {}
    Object localObject1;
    Object localObject2;
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      localObject1 = this.kLX;
      localObject2 = str.replace("_", "\\_") + "%";
      localObject1 = ((ISQLiteDatabase)localObject1).query("AppBrandKVData", new String[] { "key" }, "key like ? escape ?", new String[] { localObject2, "\\" }, null, null, null, 2);
      localObject2 = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        ((ArrayList)localObject2).add(((Cursor)localObject1).getString(0).replace(str, ""));
      }
    }
    ((Cursor)localObject1).close();
    int i = aa(paramInt, paramString);
    paramInt = t.ab(paramInt, paramString);
    AppMethodBeat.o(146943);
    return new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final p.a c(final int paramInt, final String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(146937);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.kSR;
      AppMethodBeat.o(146937);
      return paramString1;
    }
    Object localObject1 = t.c(paramInt, paramString1, paramString2, "__");
    int i = VM((String)localObject1);
    int j = t.cF(paramString2, paramString3);
    final int k = j - i;
    if (aa(paramInt, paramString1) + k >= t.ab(paramInt, paramString1)) {}
    for (i = 1; i != 0; i = 0)
    {
      paramString1 = p.a.kST;
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
      paramString3 = (p.a)paramString4.invoke();
      AppMethodBeat.o(146937);
      return paramString3;
    }
    catch (SQLiteException paramString3)
    {
      if (Util.nullAsNil(paramString3.getMessage()).contains("no such table"))
      {
        Log.e("AppBrandKVStorage", "set storageId[%d] appId[%s] key[%s], get exception[%s] try create table", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
        try
        {
          Object localObject3 = c.info;
          localObject1 = this.kLX;
          localObject2 = getTableName();
          localObject3 = getUpdateSQLs((IAutoDBItem.MAutoDBInfo)localObject3, getTableName(), (ISQLiteDatabase)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            if (!((ISQLiteDatabase)localObject1).execSQL((String)localObject2, str)) {
              Log.e("AppBrandKVStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { localObject2, str });
            }
          }
          paramString4 = (p.a)paramString4.invoke();
        }
        catch (SQLiteException paramString4)
        {
          paramString1 = String.format(Locale.ENGLISH, "set storageId[%d] appId[%s] key[%s], get exception[%s] after retry", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
          Log.e("AppBrandKVStorage", paramString1);
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
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.kSR;
      AppMethodBeat.o(146936);
      return new Object[] { paramString1 };
    }
    Object localObject2 = new c();
    ((c)localObject2).field_key = t.c(paramInt, paramString1, paramString2, "__");
    try
    {
      if (super.get((IAutoDBItem)localObject2, new String[0]))
      {
        localObject1 = p.a.kSP;
        String str = ((c)localObject2).field_data;
        localObject2 = ((c)localObject2).field_dataType;
        AppMethodBeat.o(146936);
        return new Object[] { localObject1, str, localObject2 };
      }
      Object localObject1 = t.kSW;
      AppMethodBeat.o(146936);
      return localObject1;
    }
    catch (SQLiteException localSQLiteException)
    {
      if (Util.nullAsNil(localSQLiteException.getMessage()).contains("no such table"))
      {
        Log.e("AppBrandKVStorage", "get storageId[%d] appId[%s] key[%s], no such table, return RET_GET_NO_SUCH_KEY", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        paramString1 = t.kSW;
        AppMethodBeat.o(146936);
        return paramString1;
      }
      if (localSQLiteException.getClass().getName().endsWith("CursorWindowAllocationException"))
      {
        paramString1 = p.a.kSU;
        AppMethodBeat.o(146936);
        return new Object[] { paramString1 };
      }
      AppMethodBeat.o(146936);
      throw localSQLiteException;
    }
  }
  
  public final p.a m(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146938);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = p.a.kSR;
      AppMethodBeat.o(146938);
      return paramString1;
    }
    paramString2 = t.c(paramInt, paramString1, paramString2, "__");
    int i = h(paramInt, paramString1, -VM(paramString2));
    c localc = new c();
    localc.field_key = paramString2;
    super.delete(localc, new String[0]);
    if (i <= 0) {
      be(paramString1, paramInt);
    }
    paramString1 = p.a.kSP;
    AppMethodBeat.o(146938);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.d
 * JD-Core Version:    0.7.0.1
 */