package com.tencent.mm.plugin.appbrand.jsruntime;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.vfs.o;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class ac
  extends ao
{
  @Deprecated
  public static final a lGt;
  
  static
  {
    AppMethodBeat.i(50726);
    lGt = new a((byte)0);
    AppMethodBeat.o(50726);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer";
  }
  
  public final boolean os(int paramInt)
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
    o.deleteDir(ad.bra());
    String str1 = ad.bqZ();
    if (str1 != null)
    {
      String str2 = ad.bqY();
      if ((o.fB(str1)) && (!o.fB(str2)) && (!com.tencent.mm.plugin.appbrand.appstorage.l.cq(str1, str2)))
      {
        o.aZI(str2);
        o.mH(str1, str2);
      }
      o.deleteDir(str1);
    }
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", true).commit();
    AppMethodBeat.o(50724);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer$Companion;", "", "()V", "PREF_KEY_TRANSFER_FINISHED", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.ac
 * JD-Core Version:    0.7.0.1
 */