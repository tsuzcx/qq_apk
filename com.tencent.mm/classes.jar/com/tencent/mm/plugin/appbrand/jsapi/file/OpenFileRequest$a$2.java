package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cq.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tbs.one.TBSOneManager;
import java.util.HashMap;

final class OpenFileRequest$a$2
  implements a.a
{
  OpenFileRequest$a$2(OpenFileRequest.a parama, TBSOneManager paramTBSOneManager) {}
  
  public final boolean bkq()
  {
    AppMethodBeat.i(188352);
    boolean bool = OpenFileRequest.a.a(this.kNe);
    AppMethodBeat.o(188352);
    return bool;
  }
  
  public final boolean bkr()
  {
    AppMethodBeat.i(188353);
    if (!this.kNf.isComponentInstalled("file")) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(188353);
      return bool;
    }
  }
  
  public final void bks()
  {
    AppMethodBeat.i(188354);
    MMActivity localMMActivity = OpenFileRequest.a.b(this.kNe);
    if (localMMActivity == null)
    {
      ad.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
      AppMethodBeat.o(188354);
      return;
    }
    OpenFileRequest.a.a(this.kNe, localMMActivity, this.kNf);
    AppMethodBeat.o(188354);
  }
  
  public final void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(188355);
    as.a(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(188355);
  }
  
  public final void s(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(188356);
    as.p(paramContext, paramString1, paramString2);
    AppMethodBeat.o(188356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.2
 * JD-Core Version:    0.7.0.1
 */