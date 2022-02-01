package com.tencent.mm.plugin.appbrand.j;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.w;
import com.tencent.mm.plugin.appbrand.appusage.w.a;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

 enum i
{
  private static final a rpz;
  
  static
  {
    AppMethodBeat.i(45047);
    rpA = new i[0];
    rpz = new a();
    AppMethodBeat.o(45047);
  }
  
  static AppBrandRecentTaskInfo Zp(String paramString)
  {
    AppMethodBeat.i(45044);
    if (n.cfk() == null)
    {
      AppMethodBeat.o(45044);
      return null;
    }
    Object localObject = n.cfk();
    if (Util.isNullOrNil(paramString)) {
      paramString = null;
    }
    while (paramString == null)
    {
      AppMethodBeat.o(45044);
      return null;
      localObject = ((w)localObject).qPw.query("AppBrandLauncherLayoutItem", null, String.format(Locale.US, "%s=? and %s=?", new Object[] { "scene", "recordId" }), new String[] { "2", paramString }, null, null, null);
      if (localObject == null)
      {
        paramString = null;
      }
      else
      {
        if (!((Cursor)localObject).moveToFirst()) {
          break label179;
        }
        paramString = new w.a();
        paramString.convertFrom((Cursor)localObject);
        if (Util.isNullOrNil(paramString.field_brandId)) {
          break label179;
        }
      }
    }
    label179:
    for (paramString = ad.a(String.valueOf(paramString.field_recordId), paramString.field_brandId, paramString.field_versionType, paramString.field_updateTime, paramString.field_usedInThirdPartyAppRecently, paramString.field_thirdPartyAppUsingDesc);; paramString = null)
    {
      ((Cursor)localObject).close();
      break;
      AppMethodBeat.o(45044);
      return paramString;
    }
  }
  
  static void c(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(45045);
    if (n.cfk() != null) {
      n.cfk().add(paramIOnStorageChange);
    }
    AppMethodBeat.o(45045);
  }
  
  static List<AppBrandRecentTaskInfo> coD()
  {
    AppMethodBeat.i(45043);
    LinkedList localLinkedList = new LinkedList();
    if (n.cfk() != null)
    {
      ArrayList localArrayList = n.cfk().zx(10000);
      if (!Util.isNullOrNil(localArrayList)) {
        localLinkedList.addAll(localArrayList);
      }
    }
    AppMethodBeat.o(45043);
    return localLinkedList;
  }
  
  static void d(MStorage.IOnStorageChange paramIOnStorageChange)
  {
    AppMethodBeat.i(45046);
    if (n.cfk() != null) {
      n.cfk().remove(paramIOnStorageChange);
    }
    AppMethodBeat.o(45046);
  }
  
  static void onCreate()
  {
    AppMethodBeat.i(45041);
    ad.ckY().add(rpz);
    AppMethodBeat.o(45041);
  }
  
  static void onDestroy()
  {
    AppMethodBeat.i(45042);
    ad.ckY().remove(rpz);
    AppMethodBeat.o(45042);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.i
 * JD-Core Version:    0.7.0.1
 */