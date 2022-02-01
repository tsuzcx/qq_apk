package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.appusage.x.a;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

 enum i
{
  private static final a olQ;
  
  static
  {
    AppMethodBeat.i(45047);
    olR = new i[0];
    olQ = new a();
    AppMethodBeat.o(45047);
  }
  
  static AppBrandRecentTaskInfo agu(String paramString)
  {
    AppMethodBeat.i(45044);
    if (m.bFN() == null)
    {
      AppMethodBeat.o(45044);
      return null;
    }
    Object localObject = m.bFN();
    if (Util.isNullOrNil(paramString)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(45044);
      return null;
      localObject = ((x)localObject).nPF.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "recordId" }), new String[] { "2", paramString }, null, null, null);
      if (localObject == null)
      {
        paramString = null;
      }
      else
      {
        if (!((Cursor)localObject).moveToFirst()) {
          break label179;
        }
        paramString = new x.a();
        paramString.convertFrom((Cursor)localObject);
        if (Util.isNullOrNil(paramString.field_brandId)) {
          break label179;
        }
      }
    }
    label179:
    for (paramString = y.a(String.valueOf(paramString.field_recordId), paramString.field_brandId, paramString.field_versionType, paramString.field_updateTime, paramString.field_usedInThirdPartyAppRecently, paramString.field_thirdPartyAppUsingDesc);; paramString = null)
    {
      ((Cursor)localObject).close();
      break;
      AppMethodBeat.o(45044);
      return paramString;
    }
  }
  
  static List<AppBrandRecentTaskInfo> bOo()
  {
    AppMethodBeat.i(45043);
    LinkedList localLinkedList = new LinkedList();
    if (m.bFN() != null)
    {
      ArrayList localArrayList = m.bFN().zk(10000);
      if (!Util.isNullOrNil(localArrayList)) {
        localLinkedList.addAll(localArrayList);
      }
    }
    AppMethodBeat.o(45043);
    return localLinkedList;
  }
  
  static void c(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(45045);
    if (m.bFN() != null) {
      m.bFN().add(paramIOnStorageChange);
    }
    AppMethodBeat.o(45045);
  }
  
  static void d(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(45046);
    if (m.bFN() != null) {
      m.bFN().remove(paramIOnStorageChange);
    }
    AppMethodBeat.o(45046);
  }
  
  static void onCreate()
  {
    AppMethodBeat.i(45041);
    y.bLB().add(olQ);
    AppMethodBeat.o(45041);
  }
  
  static void onDestroy()
  {
    AppMethodBeat.i(45042);
    y.bLB().remove(olQ);
    AppMethodBeat.o(45042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.i
 * JD-Core Version:    0.7.0.1
 */