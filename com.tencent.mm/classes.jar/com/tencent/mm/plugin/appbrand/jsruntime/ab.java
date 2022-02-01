package com.tencent.mm.plugin.appbrand.jsruntime;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.al;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.vfs.i;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"})
public final class ab
  extends al
{
  @Deprecated
  public static final a kDC;
  
  static
  {
    AppMethodBeat.i(50726);
    kDC = new a((byte)0);
    AppMethodBeat.o(50726);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer";
  }
  
  public final boolean nb(int paramInt)
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
    i.deleteDir(ac.bfL());
    String str1 = ac.bfK();
    if (str1 != null)
    {
      String str2 = ac.bfJ();
      if ((i.eK(str1)) && (!i.eK(str2)) && (!k.ce(str1, str2)))
      {
        i.aMF(str2);
        i.lE(str1, str2);
      }
      i.deleteDir(str1);
    }
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", true).commit();
    AppMethodBeat.o(50724);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer$Companion;", "", "()V", "PREF_KEY_TRANSFER_FINISHED", "", "TAG", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsruntime.ab
 * JD-Core Version:    0.7.0.1
 */