package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.xwebutil.a.a;
import com.tencent.tbs.one.TBSOneManager;
import java.util.HashMap;

final class OpenFileRequest$a$2
  implements a.a
{
  OpenFileRequest$a$2(OpenFileRequest.a parama, TBSOneManager paramTBSOneManager) {}
  
  public final boolean bSd()
  {
    AppMethodBeat.i(275228);
    boolean bool = OpenFileRequest.a.a(this.oSJ);
    AppMethodBeat.o(275228);
    return bool;
  }
  
  public final boolean bSe()
  {
    AppMethodBeat.i(275229);
    if (!this.oSK.isComponentInstalled("file")) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(275229);
      return bool;
    }
  }
  
  public final void bSf()
  {
    AppMethodBeat.i(275230);
    MMActivity localMMActivity = OpenFileRequest.a.b(this.oSJ);
    if (localMMActivity == null)
    {
      Log.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
      AppMethodBeat.o(275230);
      return;
    }
    OpenFileRequest.a.a(this.oSJ, localMMActivity, this.oSK);
    AppMethodBeat.o(275230);
  }
  
  public final void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(275231);
    aw.a(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(275231);
  }
  
  public final void u(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(275232);
    aw.r(paramContext, paramString1, paramString2);
    AppMethodBeat.o(275232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.2
 * JD-Core Version:    0.7.0.1
 */