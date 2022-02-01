package com.tencent.mm.plugin.eggspring.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.p;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  public static void a(Context paramContext, bsr parambsr)
  {
    AppMethodBeat.i(108142);
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.AdJumpHelper", "handleLinkClick, type=" + parambsr.uIW);
        int i = parambsr.uIW;
        switch (i)
        {
        default: 
          AppMethodBeat.o(108142);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ae.e("MicroMsg.AdJumpHelper", "handleLinkClick, exp=" + paramContext.toString());
        AppMethodBeat.o(108142);
        return;
      }
      paramContext = parambsr.Hgn;
      parambsr = parambsr.Hgo;
      ae.i("MicroMsg.AdJumpHelper", "jumpWeApp, name=" + paramContext + ", path=" + parambsr);
      Object localObject = new f();
      ((f)localObject).dlj = "";
      ((f)localObject).username = paramContext;
      ((f)localObject).jFL = parambsr;
      ((f)localObject).scene = 1084;
      ((p)g.ab(p.class)).a(ak.getContext(), (f)localObject);
      AppMethodBeat.o(108142);
      return;
      parambsr = parambsr.mdj;
      ae.i("MicroMsg.AdJumpHelper", "jumpH5, url=".concat(String.valueOf(parambsr)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", parambsr);
      ((Intent)localObject).putExtra("useJs", true);
      ((Intent)localObject).putExtra("geta8key_scene", 2);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambsr = parambsr.Hgp;
      ae.i("MicroMsg.AdJumpHelper", "jumpAdCanvas, canvasXml=".concat(String.valueOf(parambsr)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("sns_landing_pages_xml", parambsr);
      ((Intent)localObject).putExtra("sns_landig_pages_from_source", 14);
      ((Intent)localObject).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambsr = parambsr.Hgq;
      ae.i("MicroMsg.AdJumpHelper", "jumpEmojiDetail, productID=".concat(String.valueOf(parambsr)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("preceding_scence", 8);
      ((Intent)localObject).putExtra("download_entrance_scene", 16);
      ((Intent)localObject).putExtra("extra_id", parambsr);
      d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d.a
 * JD-Core Version:    0.7.0.1
 */