package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView.b;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class FTSMainUI$3
  implements FTSLocalPageRelevantView.b
{
  FTSMainUI$3(FTSMainUI paramFTSMainUI) {}
  
  public final void a(bvm parambvm, String paramString, int paramInt)
  {
    AppMethodBeat.i(61868);
    String str = this.mYi.query;
    Object localObject;
    if (parambvm.nrS == 1)
    {
      FTSMainUI.b(this.mYi, this.mYi.query);
      this.mYi.query = parambvm.xJd;
      localObject = new HashMap();
      ((Map)localObject).put("prefixSug", FTSMainUI.m(this.mYi));
      ((Map)localObject).put("sugId", paramString);
      ((Map)localObject).put("sceneActionType", "6");
      FTSMainUI.a(this.mYi, (Map)localObject);
    }
    for (;;)
    {
      ((e)g.E(e.class)).e(str, paramString, paramInt, parambvm.xJd);
      parambvm = FTSMainUI.k(this.mYi);
      k.a(str, FTSMainUI.d(this.mYi).getCount(), FTSMainUI.n(this.mYi), parambvm, 23);
      FTSMainUI.d(this.mYi).mXk = true;
      if (!FTSMainUI.d(this.mYi).mXb)
      {
        FTSMainUI.d(this.mYi).mXb = true;
        k.a(str, true, FTSMainUI.d(this.mYi).getCount(), 0, parambvm);
      }
      AppMethodBeat.o(61868);
      return;
      if ((parambvm.nrS == 4) && (!bo.isNullOrNil(parambvm.npR)))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", parambvm.npR);
        ((Intent)localObject).putExtra("convertActivityFromTranslucent", false);
        d.b(ah.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.3
 * JD-Core Version:    0.7.0.1
 */