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
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;

public class g
  extends MAutoStorage<f>
  implements v
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase qFJ;
  private b<String, String> qLU;
  private m<String, String, ah> qLV;
  
  static
  {
    AppMethodBeat.i(146951);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(f.info, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;" };
    AppMethodBeat.o(146951);
  }
  
  public g(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.info, "AppBrandKVData", null);
    AppMethodBeat.i(146935);
    this.qLU = new b() {};
    this.qLV = new m() {};
    this.qFJ = paramISQLiteDatabase;
    AppMethodBeat.o(146935);
  }
  
  private int VY(String paramString)
  {
    AppMethodBeat.i(146948);
    paramString = this.qFJ.query("AppBrandKVData", new String[] { "size" }, "key = ?", new String[] { paramString }, null, null, null, 2);
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
  
  private v.a a(final int paramInt1, final String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2)
  {
    AppMethodBeat.i(323159);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = v.a.qNi;
      AppMethodBeat.o(323159);
      return paramString1;
    }
    Object localObject1 = aa.c(paramInt1, paramString1, paramString2, "__");
    final int j = paramInt2 - VY((String)localObject1);
    if (ak(paramInt1, paramString1) + j >= aa.al(paramInt1, paramString1)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString1 = v.a.qNk;
      AppMethodBeat.o(323159);
      return paramString1;
    }
    Object localObject2 = new f();
    ((f)localObject2).field_key = ((String)localObject1);
    ((f)localObject2).field_data = paramString3;
    ((f)localObject2).field_dataType = paramString4;
    ((f)localObject2).field_size = paramInt2;
    paramString4 = new a() {};
    try
    {
      paramString3 = (v.a)paramString4.invoke();
      AppMethodBeat.o(323159);
      return paramString3;
    }
    catch (SQLiteException paramString3)
    {
      if (Util.nullAsNil(paramString3.getMessage()).contains("no such table"))
      {
        Log.e("AppBrandKVStorage", "set storageId[%d] appId[%s] key[%s], get exception[%s] try create table", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3 });
        try
        {
          Object localObject3 = f.info;
          localObject1 = this.qFJ;
          localObject2 = getTableName();
          localObject3 = getUpdateSQLs((IAutoDBItem.MAutoDBInfo)localObject3, getTableName(), (ISQLiteDatabase)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            if (!((ISQLiteDatabase)localObject1).execSQL((String)localObject2, str)) {
              Log.e("AppBrandKVStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { localObject2, str });
            }
          }
          paramString4 = (v.a)paramString4.invoke();
        }
        catch (SQLiteException paramString4)
        {
          paramString1 = String.format(Locale.ENGLISH, "set storageId[%d] appId[%s] key[%s], get exception[%s] after retry", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3 });
          Log.e("AppBrandKVStorage", paramString1);
          paramString1 = new SQLiteException(paramString1, paramString4);
          AppMethodBeat.o(323159);
          throw paramString1;
        }
        AppMethodBeat.o(323159);
        return paramString4;
      }
      AppMethodBeat.o(323159);
      throw paramString3;
    }
  }
  
  private int ak(int paramInt, String paramString)
  {
    AppMethodBeat.i(146944);
    f localf = new f();
    localf.field_key = aa.q(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@");
    if (super.get(localf, new String[0]))
    {
      paramInt = Util.getInt(localf.field_data, 0);
      AppMethodBeat.o(146944);
      return paramInt;
    }
    AppMethodBeat.o(146944);
    return 0;
  }
  
  private void bO(String paramString, int paramInt)
  {
    AppMethodBeat.i(146942);
    aa.b(paramString, paramInt, this.qLU, this.qLV);
    AppMethodBeat.o(146942);
  }
  
  private void g(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(146946);
    f localf = new f();
    localf.field_key = aa.q(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@");
    localf.field_data = String.valueOf(paramInt2);
    super.replace(localf);
    AppMethodBeat.o(146946);
  }
  
  private int h(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(146947);
    paramInt2 = Math.max(0, ak(paramInt1, paramString) + paramInt2);
    g(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(146947);
    return paramInt2;
  }
  
  public final int VT(String paramString)
  {
    AppMethodBeat.i(146945);
    int[] arrayOfInt = VX(paramString);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = ak(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(146945);
    return i;
  }
  
  public final void VW(String paramString)
  {
    AppMethodBeat.i(146940);
    int i = 0;
    while (i <= 2)
    {
      ai(i, paramString);
      i += 1;
    }
    AppMethodBeat.o(146940);
  }
  
  public final int[] VX(String paramString)
  {
    AppMethodBeat.i(146941);
    paramString = aa.a(paramString, this.qLU, this.qLV);
    AppMethodBeat.o(146941);
    return paramString;
  }
  
  public final void ai(int paramInt, String paramString)
  {
    AppMethodBeat.i(146939);
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      bO(paramString, paramInt);
      this.qFJ.delete("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", new Object[] { "key", "key" }), new String[] { str.replace("_", "\\_") + "%", "\\", aa.q(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@") });
      AppMethodBeat.o(146939);
      return;
    }
  }
  
  public final Object[] aj(int paramInt, String paramString)
  {
    AppMethodBeat.i(146943);
    if (paramInt == 0) {}
    Object localObject1;
    Object localObject2;
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      localObject1 = this.qFJ;
      localObject2 = str.replace("_", "\\_") + "%";
      localObject1 = ((ISQLiteDatabase)localObject1).query("AppBrandKVData", new String[] { "key" }, "key like ? escape ?", new String[] { localObject2, "\\" }, null, null, null, 2);
      localObject2 = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        ((ArrayList)localObject2).add(((Cursor)localObject1).getString(0).replace(str, ""));
      }
    }
    ((Cursor)localObject1).close();
    int i = ak(paramInt, paramString);
    paramInt = aa.al(paramInt, paramString);
    AppMethodBeat.o(146943);
    return new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final v.a d(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(146937);
    paramString1 = a(paramInt, paramString1, paramString2, paramString3, paramString4, aa.dg(paramString2, paramString3));
    AppMethodBeat.o(146937);
    return paramString1;
  }
  
  public final v.a o(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146938);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = v.a.qNi;
      AppMethodBeat.o(146938);
      return paramString1;
    }
    paramString2 = aa.c(paramInt, paramString1, paramString2, "__");
    int i = h(paramInt, paramString1, -VY(paramString2));
    f localf = new f();
    localf.field_key = paramString2;
    super.delete(localf, new String[0]);
    if (i <= 0) {
      bO(paramString1, paramInt);
    }
    paramString1 = v.a.qNg;
    AppMethodBeat.o(146938);
    return paramString1;
  }
  
  public final Object[] p(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(146936);
    if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
    {
      paramString1 = v.a.qNi;
      AppMethodBeat.o(146936);
      return new Object[] { paramString1 };
    }
    Object localObject2 = new f();
    ((f)localObject2).field_key = aa.c(paramInt, paramString1, paramString2, "__");
    try
    {
      if (super.get((IAutoDBItem)localObject2, new String[0]))
      {
        localObject1 = v.a.qNg;
        String str = ((f)localObject2).field_data;
        localObject2 = ((f)localObject2).field_dataType;
        AppMethodBeat.o(146936);
        return new Object[] { localObject1, str, localObject2 };
      }
      Object localObject1 = aa.qNo;
      AppMethodBeat.o(146936);
      return localObject1;
    }
    catch (SQLiteException localSQLiteException)
    {
      if (Util.nullAsNil(localSQLiteException.getMessage()).contains("no such table"))
      {
        Log.e("AppBrandKVStorage", "get storageId[%d] appId[%s] key[%s], no such table, return RET_GET_NO_SUCH_KEY", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
        paramString1 = aa.qNo;
        AppMethodBeat.o(146936);
        return paramString1;
      }
      if (localSQLiteException.getClass().getName().endsWith("CursorWindowAllocationException"))
      {
        paramString1 = v.a.qNl;
        AppMethodBeat.o(146936);
        return new Object[] { paramString1 };
      }
      AppMethodBeat.o(146936);
      throw localSQLiteException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.g
 * JD-Core Version:    0.7.0.1
 */