package com.tencent.mm.plugin.appbrand.appstorage;

import a.y;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class b
  extends j<a>
  implements m
{
  public static final String[] SQL_CREATE;
  private e gVl;
  private a.f.a.b<String, String> gYY;
  private a.f.a.m<String, String, y> gYZ;
  
  static
  {
    AppMethodBeat.i(101779);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;" };
    AppMethodBeat.o(101779);
  }
  
  public b(e parame)
  {
    super(parame, a.info, "AppBrandKVData", null);
    AppMethodBeat.i(101763);
    this.gYY = new b.1(this);
    this.gYZ = new b.2(this);
    this.gVl = parame;
    AppMethodBeat.o(101763);
  }
  
  private int K(int paramInt, String paramString)
  {
    AppMethodBeat.i(101772);
    a locala = new a();
    locala.field_key = r.m(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@");
    if (super.get(locala, new String[0]))
    {
      paramInt = bo.getInt(locala.field_data, 0);
      AppMethodBeat.o(101772);
      return paramInt;
    }
    AppMethodBeat.o(101772);
    return 0;
  }
  
  private void aB(String paramString, int paramInt)
  {
    AppMethodBeat.i(101770);
    r.b(paramString, paramInt, this.gYY, this.gYZ);
    AppMethodBeat.o(101770);
  }
  
  private void e(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(101774);
    a locala = new a();
    locala.field_key = r.m(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@");
    locala.field_data = String.valueOf(paramInt2);
    super.replace(locala);
    AppMethodBeat.o(101774);
  }
  
  private int f(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(101775);
    paramInt2 = Math.max(0, K(paramInt1, paramString) + paramInt2);
    e(paramInt1, paramString, paramInt2);
    AppMethodBeat.o(101775);
    return paramInt2;
  }
  
  private int yU(String paramString)
  {
    AppMethodBeat.i(101776);
    paramString = this.gVl.a("AppBrandKVData", new String[] { "size" }, "key = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      int i = paramString.getInt(0);
      paramString.close();
      AppMethodBeat.o(101776);
      return i;
    }
    paramString.close();
    AppMethodBeat.o(101776);
    return 0;
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(101767);
    if (paramInt == 0) {}
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      aB(paramString, paramInt);
      this.gVl.delete("AppBrandKVData", String.format("%s like ? escape ? OR %s=?", new Object[] { "key", "key" }), new String[] { str.replace("_", "\\_") + "%", "\\", r.m(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@") });
      AppMethodBeat.o(101767);
      return;
    }
  }
  
  public final Object[] J(int paramInt, String paramString)
  {
    AppMethodBeat.i(101771);
    if (paramInt == 0) {}
    Object localObject1;
    Object localObject2;
    for (String str = paramString + "__";; str = paramInt + "__" + paramString + "__")
    {
      localObject1 = this.gVl;
      localObject2 = str.replace("_", "\\_") + "%";
      localObject1 = ((e)localObject1).a("AppBrandKVData", new String[] { "key" }, "key like ? escape ?", new String[] { localObject2, "\\" }, null, null, null, 2);
      localObject2 = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        ((ArrayList)localObject2).add(((Cursor)localObject1).getString(0).replace(str, ""));
      }
    }
    ((Cursor)localObject1).close();
    int i = K(paramInt, paramString);
    paramInt = r.L(paramInt, paramString);
    AppMethodBeat.o(101771);
    return new Object[] { localObject2, Integer.valueOf(i), Integer.valueOf(paramInt) };
  }
  
  public final m.a b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(101765);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      paramString1 = m.a.gZX;
      AppMethodBeat.o(101765);
      return paramString1;
    }
    String str = r.c(paramInt, paramString1, paramString2, "__");
    int i = yU(str);
    int j = r.bB(paramString2, paramString3);
    int k = j - i;
    if (K(paramInt, paramString1) + k >= r.L(paramInt, paramString1)) {}
    for (i = 1; i != 0; i = 0)
    {
      paramString1 = m.a.gZZ;
      AppMethodBeat.o(101765);
      return paramString1;
    }
    paramString2 = new a();
    paramString2.field_key = str;
    paramString2.field_data = paramString3;
    paramString2.field_dataType = paramString4;
    paramString2.field_size = j;
    if (super.replace(paramString2))
    {
      r.a(paramString1, paramInt, this.gYY, this.gYZ);
      f(paramInt, paramString1, k);
      paramString1 = m.a.gZV;
      AppMethodBeat.o(101765);
      return paramString1;
    }
    paramString1 = m.a.gZW;
    AppMethodBeat.o(101765);
    return paramString1;
  }
  
  public final Object[] k(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(101764);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      paramString1 = m.a.gZX;
      AppMethodBeat.o(101764);
      return new Object[] { paramString1 };
    }
    Object localObject = new a();
    ((a)localObject).field_key = r.c(paramInt, paramString1, paramString2, "__");
    if (super.get((c)localObject, new String[0]))
    {
      paramString1 = m.a.gZV;
      paramString2 = ((a)localObject).field_data;
      localObject = ((a)localObject).field_dataType;
      AppMethodBeat.o(101764);
      return new Object[] { paramString1, paramString2, localObject };
    }
    paramString1 = r.hab;
    AppMethodBeat.o(101764);
    return paramString1;
  }
  
  public final m.a l(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(101766);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      paramString1 = m.a.gZX;
      AppMethodBeat.o(101766);
      return paramString1;
    }
    paramString2 = r.c(paramInt, paramString1, paramString2, "__");
    int i = f(paramInt, paramString1, -yU(paramString2));
    a locala = new a();
    locala.field_key = paramString2;
    super.delete(locala, new String[0]);
    if (i <= 0) {
      aB(paramString1, paramInt);
    }
    paramString1 = m.a.gZV;
    AppMethodBeat.o(101766);
    return paramString1;
  }
  
  public final void yR(String paramString)
  {
    AppMethodBeat.i(101768);
    int i = 0;
    while (i <= 1)
    {
      I(i, paramString);
      i += 1;
    }
    AppMethodBeat.o(101768);
  }
  
  public final int[] yS(String paramString)
  {
    AppMethodBeat.i(101769);
    paramString = r.a(paramString, this.gYY, this.gYZ);
    AppMethodBeat.o(101769);
    return paramString;
  }
  
  public final int yT(String paramString)
  {
    AppMethodBeat.i(101773);
    int[] arrayOfInt = yS(paramString);
    int k = arrayOfInt.length;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = K(arrayOfInt[j], paramString);
      j += 1;
    }
    AppMethodBeat.o(101773);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b
 * JD-Core Version:    0.7.0.1
 */