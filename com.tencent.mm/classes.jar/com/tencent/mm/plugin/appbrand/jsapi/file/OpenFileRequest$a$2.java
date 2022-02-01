package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tbs.one.TBSOneManager;
import java.util.HashMap;

final class OpenFileRequest$a$2
  implements a.a
{
  OpenFileRequest$a$2(OpenFileRequest.a parama, TBSOneManager paramTBSOneManager) {}
  
  public final boolean bGw()
  {
    AppMethodBeat.i(226785);
    boolean bool = OpenFileRequest.a.a(this.lVF);
    AppMethodBeat.o(226785);
    return bool;
  }
  
  public final boolean bGx()
  {
    AppMethodBeat.i(226786);
    if (!this.lVG.isComponentInstalled("file")) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(226786);
      return bool;
    }
  }
  
  public final void bGy()
  {
    AppMethodBeat.i(226787);
    MMActivity localMMActivity = OpenFileRequest.a.b(this.lVF);
    if (localMMActivity == null)
    {
      Log.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
      AppMethodBeat.o(226787);
      return;
    }
    OpenFileRequest.a.a(this.lVF, localMMActivity, this.lVG);
    AppMethodBeat.o(226787);
  }
  
  public final void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(226788);
    au.a(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(226788);
  }
  
  public final void r(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(226789);
    au.o(paramContext, paramString1, paramString2);
    AppMethodBeat.o(226789);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.2
 * JD-Core Version:    0.7.0.1
 */