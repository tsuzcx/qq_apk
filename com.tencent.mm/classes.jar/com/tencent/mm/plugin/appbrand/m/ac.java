package com.tencent.mm.plugin.appbrand.m;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.vfs.s;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class ac
  extends as
{
  @Deprecated
  public static final a mOd;
  
  static
  {
    AppMethodBeat.i(50726);
    mOd = new a((byte)0);
    AppMethodBeat.o(50726);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(50725);
    if (!PluginAppBrand.getProcessSharedPrefs().getBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", false))
    {
      AppMethodBeat.o(50725);
      return true;
    }
    AppMethodBeat.o(50725);
    return false;
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(50724);
    s.deleteDir(ad.bMM());
    String str1 = ad.bML();
    if (str1 != null)
    {
      String str2 = ad.bMK();
      if ((s.YS(str1)) && (!s.YS(str2)) && (!com.tencent.mm.plugin.appbrand.appstorage.l.cE(str1, str2)))
      {
        s.boN(str2);
        s.ny(str1, str2);
      }
      s.deleteDir(str1);
    }
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", true).commit();
    AppMethodBeat.o(50724);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer$Companion;", "", "()V", "PREF_KEY_TRANSFER_FINISHED", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.ac
 * JD-Core Version:    0.7.0.1
 */