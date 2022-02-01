package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tbs.one.TBSOneManager;
import java.util.HashMap;

final class OpenFileRequest$a$2
  implements a.a
{
  OpenFileRequest$a$2(OpenFileRequest.a parama, TBSOneManager paramTBSOneManager) {}
  
  public final boolean bgL()
  {
    AppMethodBeat.i(186619);
    boolean bool = OpenFileRequest.a.a(this.krI);
    AppMethodBeat.o(186619);
    return bool;
  }
  
  public final boolean bgM()
  {
    AppMethodBeat.i(186620);
    if (!this.krJ.isComponentInstalled("file")) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(186620);
      return bool;
    }
  }
  
  public final void bgN()
  {
    AppMethodBeat.i(186621);
    MMActivity localMMActivity = OpenFileRequest.a.b(this.krI);
    if (localMMActivity == null)
    {
      ac.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
      AppMethodBeat.o(186621);
      return;
    }
    OpenFileRequest.a.a(this.krI, localMMActivity, this.krJ);
    AppMethodBeat.o(186621);
  }
  
  public final void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(186622);
    as.a(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(186622);
  }
  
  public final void r(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(186623);
    as.o(paramContext, paramString1, paramString2);
    AppMethodBeat.o(186623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.2
 * JD-Core Version:    0.7.0.1
 */