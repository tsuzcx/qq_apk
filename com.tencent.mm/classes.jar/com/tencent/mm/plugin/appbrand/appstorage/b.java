package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.ArrayList;

public final class b
  extends i<a>
{
  public static final String[] dXp = { i.a(a.buS, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;" };
  private e fCV;
  
  public b(e parame)
  {
    super(parame, a.buS, "AppBrandKVData", null);
    this.fCV = parame;
  }
  
  private int ao(String paramString, int paramInt)
  {
    paramInt = Math.max(0, rr(paramString) + paramInt);
    a locala = new a();
    locala.field_key = y(paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    locala.field_data = String.valueOf(paramInt);
    super.a(locala);
    return paramInt;
  }
  
  private int rr(String paramString)
  {
    int i = 0;
    a locala = new a();
    locala.field_key = y(paramString, "@@@TOTAL@DATA@SIZE@@@", "++");
    if (super.b(locala, new String[0])) {
      i = bk.getInt(locala.field_data, 0);
    }
    return i;
  }
  
  private int rs(String paramString)
  {
    paramString = this.fCV.a("AppBrandKVData", new String[] { "size" }, "key = ?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      int i = paramString.getInt(0);
      paramString.close();
      return i;
    }
    paramString.close();
    return 0;
  }
  
  private static int rt(String paramString)
  {
    if ("wxGlobal".equals(paramString)) {
      return AppBrandGlobalSystemConfig.aec().fOG;
    }
    return k.sn(paramString);
  }
  
  private static String y(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public final Object[] aZ(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return new Object[] { b.a.fGr };
    }
    a locala = new a();
    locala.field_key = y(paramString1, paramString2, "__");
    if (super.b(locala, new String[0])) {
      return new Object[] { b.a.fGp, locala.field_data, locala.field_dataType };
    }
    return new Object[] { b.a.fGs };
  }
  
  public final b.a ba(String paramString1, String paramString2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return b.a.fGr;
    }
    paramString2 = y(paramString1, paramString2, "__");
    ao(paramString1, -rs(paramString2));
    paramString1 = new a();
    paramString1.field_key = paramString2;
    super.a(paramString1, new String[0]);
    return b.a.fGp;
  }
  
  public final void clear(String paramString)
  {
    super.gk("AppBrandKVData", String.format("delete from %s where %s like '%s%%'", new Object[] { "AppBrandKVData", "key", paramString }));
  }
  
  public final b.a f(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int k = 0;
    if ((bk.bl(paramString1)) || (bk.bl(paramString2))) {
      return b.a.fGr;
    }
    String str = y(paramString1, paramString2, "__");
    int m = rs(str);
    int i;
    if (paramString2 == null)
    {
      i = 0;
      if (paramString3 != null) {
        break label106;
      }
    }
    label106:
    for (int j = 0;; j = paramString3.length())
    {
      j += i;
      m = j - m;
      i = k;
      if (rr(paramString1) + m >= rt(paramString1)) {
        i = 1;
      }
      if (i == 0) {
        break label115;
      }
      return b.a.fGt;
      i = paramString2.length();
      break;
    }
    label115:
    paramString2 = new a();
    paramString2.field_key = str;
    paramString2.field_data = paramString3;
    paramString2.field_dataType = paramString4;
    paramString2.field_size = j;
    if (super.a(paramString2))
    {
      ao(paramString1, m);
      return b.a.fGp;
    }
    return b.a.fGq;
  }
  
  public final Object[] rq(String paramString)
  {
    String str = paramString + "__";
    Object localObject1 = this.fCV;
    Object localObject2 = str.replace("_", "\\_") + "%";
    localObject1 = ((e)localObject1).a("AppBrandKVData", new String[] { "key" }, "key like ? escape ?", new String[] { localObject2, "\\" }, null, null, null, 2);
    localObject2 = new ArrayList();
    while (((Cursor)localObject1).moveToNext()) {
      ((ArrayList)localObject2).add(((Cursor)localObject1).getString(0).replace(str, ""));
    }
    ((Cursor)localObject1).close();
    return new Object[] { localObject2, Integer.valueOf(rr(paramString)), Integer.valueOf(rt(paramString)) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b
 * JD-Core Version:    0.7.0.1
 */