package com.tencent.mm.plugin.appbrand.k;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.y;
import com.tencent.mm.plugin.appbrand.appusage.y.a;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

 enum i
{
  private static final a jPW;
  
  static
  {
    AppMethodBeat.i(45047);
    jPX = new i[0];
    jPW = new a();
    AppMethodBeat.o(45047);
  }
  
  static AppBrandRecentTaskInfo Lt(String paramString)
  {
    AppMethodBeat.i(45044);
    if (j.aVA() == null)
    {
      AppMethodBeat.o(45044);
      return null;
    }
    Object localObject = j.aVA();
    if (bs.isNullOrNil(paramString)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(45044);
      return null;
      localObject = ((y)localObject).jvw.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "recordId" }), new String[] { "2", paramString }, null, null, null);
      if (localObject == null)
      {
        paramString = null;
      }
      else
      {
        if (!((Cursor)localObject).moveToFirst()) {
          break label171;
        }
        paramString = new y.a();
        paramString.convertFrom((Cursor)localObject);
        if (bs.isNullOrNil(paramString.field_brandId)) {
          break label171;
        }
      }
    }
    label171:
    for (paramString = u.a(String.valueOf(paramString.field_recordId), paramString.field_brandId, paramString.field_versionType, paramString.field_updateTime);; paramString = null)
    {
      ((Cursor)localObject).close();
      break;
      AppMethodBeat.o(45044);
      return paramString;
    }
  }
  
  static List<AppBrandRecentTaskInfo> bdt()
  {
    AppMethodBeat.i(45043);
    LinkedList localLinkedList = new LinkedList();
    if (j.aVA() != null)
    {
      ArrayList localArrayList = j.aVA().rB(10000);
      if (!bs.gY(localArrayList)) {
        localLinkedList.addAll(localArrayList);
      }
    }
    AppMethodBeat.o(45043);
    return localLinkedList;
  }
  
  static void c(k.a parama)
  {
    AppMethodBeat.i(45045);
    if (j.aVA() != null) {
      j.aVA().add(parama);
    }
    AppMethodBeat.o(45045);
  }
  
  static void d(k.a parama)
  {
    AppMethodBeat.i(45046);
    if (j.aVA() != null) {
      j.aVA().remove(parama);
    }
    AppMethodBeat.o(45046);
  }
  
  static void onCreate()
  {
    AppMethodBeat.i(45041);
    u.baJ().add(jPW);
    AppMethodBeat.o(45041);
  }
  
  static void onDestroy()
  {
    AppMethodBeat.i(45042);
    u.baJ().remove(jPW);
    AppMethodBeat.o(45042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.i
 * JD-Core Version:    0.7.0.1
 */