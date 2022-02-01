package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.appusage.y.a;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

 enum i
{
  private static final a kny;
  
  static
  {
    AppMethodBeat.i(45047);
    knz = new i[0];
    kny = new a();
    AppMethodBeat.o(45047);
  }
  
  static AppBrandRecentTaskInfo Pv(String paramString)
  {
    AppMethodBeat.i(45044);
    if (j.aZs() == null)
    {
      AppMethodBeat.o(45044);
      return null;
    }
    Object localObject = j.aZs();
    if (bu.isNullOrNil(paramString)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(45044);
      return null;
      localObject = ((y)localObject).jSI.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "recordId" }), new String[] { "2", paramString }, null, null, null);
      if (localObject == null)
      {
        paramString = null;
      }
      else
      {
        if (!((Cursor)localObject).moveToFirst()) {
          break label179;
        }
        paramString = new y.a();
        paramString.convertFrom((Cursor)localObject);
        if (bu.isNullOrNil(paramString.field_brandId)) {
          break label179;
        }
      }
    }
    label179:
    for (paramString = v.a(String.valueOf(paramString.field_recordId), paramString.field_brandId, paramString.field_versionType, paramString.field_updateTime, paramString.field_usedInThirdPartyAppRecently, paramString.field_thirdPartyAppUsingDesc);; paramString = null)
    {
      ((Cursor)localObject).close();
      break;
      AppMethodBeat.o(45044);
      return paramString;
    }
  }
  
  static List<AppBrandRecentTaskInfo> bhF()
  {
    AppMethodBeat.i(45043);
    LinkedList localLinkedList = new LinkedList();
    if (j.aZs() != null)
    {
      ArrayList localArrayList = j.aZs().se(10000);
      if (!bu.ht(localArrayList)) {
        localLinkedList.addAll(localArrayList);
      }
    }
    AppMethodBeat.o(45043);
    return localLinkedList;
  }
  
  static void c(k.a parama)
  {
    AppMethodBeat.i(45045);
    if (j.aZs() != null) {
      j.aZs().add(parama);
    }
    AppMethodBeat.o(45045);
  }
  
  static void d(k.a parama)
  {
    AppMethodBeat.i(45046);
    if (j.aZs() != null) {
      j.aZs().remove(parama);
    }
    AppMethodBeat.o(45046);
  }
  
  static void onCreate()
  {
    AppMethodBeat.i(45041);
    v.beQ().add(kny);
    AppMethodBeat.o(45041);
  }
  
  static void onDestroy()
  {
    AppMethodBeat.i(45042);
    v.beQ().remove(kny);
    AppMethodBeat.o(45042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.i
 * JD-Core Version:    0.7.0.1
 */