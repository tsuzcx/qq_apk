package com.tencent.mm.plugin.appbrand.jsapi.file;

import android.content.Context;
import android.webkit.ValueCallback;
import androidx.lifecycle.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.xwebutil.a.a;
import com.tencent.tbs.one.TBSOneManager;
import java.util.HashMap;

final class OpenFileRequest$a$2
  implements a.a
{
  OpenFileRequest$a$2(OpenFileRequest.a parama, TBSOneManager paramTBSOneManager)
  {
    AppMethodBeat.i(329096);
    OpenFileRequest.a.a(this.rYa).getLifecycle().addObserver(new OpenFileRequest.OpenLogic.2.1(this, this));
    AppMethodBeat.o(329096);
  }
  
  public final boolean csh()
  {
    AppMethodBeat.i(329102);
    boolean bool = OpenFileRequest.a.b(this.rYa);
    AppMethodBeat.o(329102);
    return bool;
  }
  
  public final boolean csi()
  {
    AppMethodBeat.i(329105);
    if (!this.rYb.isComponentInstalled("file")) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.AppBrand.OpenFileRequest", "needDownloadMiniQB: %b", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(329105);
      return bool;
    }
  }
  
  public final void csj()
  {
    AppMethodBeat.i(329111);
    MMActivity localMMActivity = OpenFileRequest.a.c(this.rYa);
    if (localMMActivity == null)
    {
      Log.w("MicroMsg.AppBrand.OpenFileRequest", "get context return null");
      AppMethodBeat.o(329111);
      return;
    }
    OpenFileRequest.a.a(this.rYa, localMMActivity, this.rYb);
    AppMethodBeat.o(329111);
  }
  
  public final void d(int paramInt, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback, ValueCallback<Integer> paramValueCallback1)
  {
    AppMethodBeat.i(329118);
    ay.a(paramInt, paramContext, paramString1, paramString2, paramString3, paramBoolean, paramHashMap, paramValueCallback, paramValueCallback1);
    AppMethodBeat.o(329118);
  }
  
  public final void v(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(329121);
    ay.t(paramContext, paramString1, paramString2);
    AppMethodBeat.o(329121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.OpenFileRequest.a.2
 * JD-Core Version:    0.7.0.1
 */