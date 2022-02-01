package com.tencent.mm.plugin.eggspring.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.f;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.protocal.protobuf.bnm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
{
  public static void a(Context paramContext, bnm parambnm)
  {
    AppMethodBeat.i(108142);
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.AdJumpHelper", "handleLinkClick, type=" + parambnm.vjP);
        int i = parambnm.vjP;
        switch (i)
        {
        default: 
          AppMethodBeat.o(108142);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ac.e("MicroMsg.AdJumpHelper", "handleLinkClick, exp=" + paramContext.toString());
        AppMethodBeat.o(108142);
        return;
      }
      paramContext = parambnm.Fdk;
      parambnm = parambnm.Fdl;
      ac.i("MicroMsg.AdJumpHelper", "jumpWeApp, name=" + paramContext + ", path=" + parambnm);
      Object localObject = new f();
      ((f)localObject).cYP = "";
      ((f)localObject).username = paramContext;
      ((f)localObject).jjf = parambnm;
      ((f)localObject).scene = 1084;
      ((n)g.ab(n.class)).a(ai.getContext(), (f)localObject);
      AppMethodBeat.o(108142);
      return;
      parambnm = parambnm.lze;
      ac.i("MicroMsg.AdJumpHelper", "jumpH5, url=".concat(String.valueOf(parambnm)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", parambnm);
      ((Intent)localObject).putExtra("useJs", true);
      ((Intent)localObject).putExtra("geta8key_scene", 2);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambnm = parambnm.Fdm;
      ac.i("MicroMsg.AdJumpHelper", "jumpAdCanvas, canvasXml=".concat(String.valueOf(parambnm)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("sns_landing_pages_xml", parambnm);
      ((Intent)localObject).putExtra("sns_landig_pages_from_source", 14);
      ((Intent)localObject).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambnm = parambnm.Fdn;
      ac.i("MicroMsg.AdJumpHelper", "jumpEmojiDetail, productID=".concat(String.valueOf(parambnm)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("preceding_scence", 8);
      ((Intent)localObject).putExtra("download_entrance_scene", 16);
      ((Intent)localObject).putExtra("extra_id", parambnm);
      d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d.a
 * JD-Core Version:    0.7.0.1
 */