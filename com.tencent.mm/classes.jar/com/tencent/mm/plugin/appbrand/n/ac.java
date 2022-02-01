package com.tencent.mm.plugin.appbrand.n;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.app.PluginAppBrand;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsruntime/V8CodeCacheDirectoryTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "()V", "getTag", "", "needTransfer", "", "sVer", "", "transfer", "", "transferIfNeed", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  extends au
{
  private static final ac.a sTu;
  
  static
  {
    AppMethodBeat.i(50726);
    sTu = new ac.a((byte)0);
    AppMethodBeat.o(50726);
  }
  
  public final String getTag()
  {
    return "MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer";
  }
  
  public final void vb(int paramInt)
  {
    AppMethodBeat.i(50724);
    y.ew(ad.czp(), true);
    String str1 = ad.czo();
    if (str1 != null)
    {
      String str2 = b.bno();
      if ((y.ZC(str1)) && (!y.ZC(str2)) && (!q.de(str1, str2)))
      {
        y.bDX(str2);
        y.qo(str1, str2);
      }
      y.ew(str1, true);
    }
    PluginAppBrand.getProcessSharedPrefs().edit().putBoolean("MicroMsg.AppBrand.V8CodeCacheDirectoryTransfer_transfer_finished", true).commit();
    AppMethodBeat.o(50724);
  }
  
  public final boolean vc(int paramInt)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.ac
 * JD-Core Version:    0.7.0.1
 */