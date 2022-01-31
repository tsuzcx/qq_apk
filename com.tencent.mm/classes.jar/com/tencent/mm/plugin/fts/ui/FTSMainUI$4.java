package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.ui.widget.FTSLocalPageRelevantView.b;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.protocal.c.bma;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;

final class FTSMainUI$4
  implements FTSLocalPageRelevantView.b
{
  FTSMainUI$4(FTSMainUI paramFTSMainUI) {}
  
  public final void a(bma parambma, String paramString, int paramInt)
  {
    String str = this.kCm.bVk;
    Object localObject;
    if (parambma.kTS == 1)
    {
      FTSMainUI.a(this.kCm, this.kCm.bVk);
      this.kCm.bVk = parambma.tFy;
      localObject = new HashMap();
      ((Map)localObject).put("prefixSug", FTSMainUI.m(this.kCm));
      ((Map)localObject).put("sugId", paramString);
      ((Map)localObject).put("sceneActionType", "6");
      FTSMainUI.a(this.kCm, (Map)localObject);
    }
    for (;;)
    {
      ((e)g.r(e.class)).e(str, paramString, paramInt, parambma.tFy);
      parambma = FTSMainUI.n(this.kCm);
      k.a(str, FTSMainUI.f(this.kCm).getCount(), FTSMainUI.o(this.kCm), parambma, 23);
      return;
      if ((parambma.kTS == 4) && (!bk.bl(parambma.kRP)))
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", parambma.kRP);
        ((Intent)localObject).putExtra("convertActivityFromTranslucent", false);
        d.b(ae.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.4
 * JD-Core Version:    0.7.0.1
 */