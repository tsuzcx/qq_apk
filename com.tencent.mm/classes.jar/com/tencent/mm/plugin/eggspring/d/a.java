package com.tencent.mm.plugin.eggspring.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.a.f;
import com.tencent.mm.plugin.appbrand.service.n;
import com.tencent.mm.protocal.protobuf.bjs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  public static void a(Context paramContext, bjs parambjs)
  {
    AppMethodBeat.i(108142);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.AdJumpHelper", "handleLinkClick, type=" + parambjs.uaQ);
        int i = parambjs.uaQ;
        switch (i)
        {
        default: 
          AppMethodBeat.o(108142);
          return;
        }
      }
      catch (Exception paramContext)
      {
        ad.e("MicroMsg.AdJumpHelper", "handleLinkClick, exp=" + paramContext.toString());
        AppMethodBeat.o(108142);
        return;
      }
      paramContext = parambjs.DHP;
      parambjs = parambjs.DHQ;
      ad.i("MicroMsg.AdJumpHelper", "jumpWeApp, name=" + paramContext + ", path=" + parambjs);
      Object localObject = new f();
      ((f)localObject).dbt = "";
      ((f)localObject).username = paramContext;
      ((f)localObject).iJb = parambjs;
      ((f)localObject).scene = 1084;
      ((n)g.ab(n.class)).a(aj.getContext(), (f)localObject);
      AppMethodBeat.o(108142);
      return;
      parambjs = parambjs.kXu;
      ad.i("MicroMsg.AdJumpHelper", "jumpH5, url=".concat(String.valueOf(parambjs)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", parambjs);
      ((Intent)localObject).putExtra("useJs", true);
      ((Intent)localObject).putExtra("geta8key_scene", 2);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambjs = parambjs.DHR;
      ad.i("MicroMsg.AdJumpHelper", "jumpAdCanvas, canvasXml=".concat(String.valueOf(parambjs)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("sns_landing_pages_xml", parambjs);
      ((Intent)localObject).putExtra("sns_landig_pages_from_source", 14);
      ((Intent)localObject).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambjs = parambjs.DHS;
      ad.i("MicroMsg.AdJumpHelper", "jumpEmojiDetail, productID=".concat(String.valueOf(parambjs)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("preceding_scence", 8);
      ((Intent)localObject).putExtra("download_entrance_scene", 16);
      ((Intent)localObject).putExtra("extra_id", parambjs);
      d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d.a
 * JD-Core Version:    0.7.0.1
 */