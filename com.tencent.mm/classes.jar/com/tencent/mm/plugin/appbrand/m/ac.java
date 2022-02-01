package com.tencent.mm.plugin.appbrand.m;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.vfs.u;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class ac
  extends at
{
  @Deprecated
  public static final ac.a pOV;
  
  static
  {
    AppMethodBeat.i(50726);
    pOV = new ac.a((byte)0);
    AppMethodBeat.o(50726);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer";
  }
  
  @SuppressLint({"ApplySharedPref"})
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(50724);
    u.deleteDir(ad.bZd());
    String str1 = ad.bZc();
    if (str1 != null)
    {
      String str2 = ad.bZb();
      if ((u.agG(str1)) && (!u.agG(str2)) && (!com.tencent.mm.plugin.appbrand.appstorage.l.cN(str1, str2)))
      {
        u.bBD(str2);
        u.oq(str1, str2);
      }
      u.deleteDir(str1);
    }
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", true).commit();
    AppMethodBeat.o(50724);
  }
  
  public final boolean uQ(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.m.ac
 * JD-Core Version:    0.7.0.1
 */