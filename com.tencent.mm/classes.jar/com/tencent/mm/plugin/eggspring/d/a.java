package com.tencent.mm.plugin.eggspring.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  public static void a(Context paramContext, brx parambrx)
  {
    AppMethodBeat.i(108142);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.AdJumpHelper", "handleLinkClick, type=" + parambrx.uxt);
        int i = parambrx.uxt;
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
      paramContext = parambrx.GMM;
      parambrx = parambrx.GMN;
      ad.i("MicroMsg.AdJumpHelper", "jumpWeApp, name=" + paramContext + ", path=" + parambrx);
      Object localObject = new f();
      ((f)localObject).dkh = "";
      ((f)localObject).username = paramContext;
      ((f)localObject).jCN = parambrx;
      ((f)localObject).scene = 1084;
      ((o)g.ab(o.class)).a(aj.getContext(), (f)localObject);
      AppMethodBeat.o(108142);
      return;
      parambrx = parambrx.lYC;
      ad.i("MicroMsg.AdJumpHelper", "jumpH5, url=".concat(String.valueOf(parambrx)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("rawUrl", parambrx);
      ((Intent)localObject).putExtra("useJs", true);
      ((Intent)localObject).putExtra("geta8key_scene", 2);
      d.b(paramContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambrx = parambrx.GMO;
      ad.i("MicroMsg.AdJumpHelper", "jumpAdCanvas, canvasXml=".concat(String.valueOf(parambrx)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("sns_landing_pages_xml", parambrx);
      ((Intent)localObject).putExtra("sns_landig_pages_from_source", 14);
      ((Intent)localObject).putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
      d.b(paramContext, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", (Intent)localObject);
      AppMethodBeat.o(108142);
      return;
      parambrx = parambrx.GMP;
      ad.i("MicroMsg.AdJumpHelper", "jumpEmojiDetail, productID=".concat(String.valueOf(parambrx)));
      localObject = new Intent();
      ((Intent)localObject).putExtra("preceding_scence", 8);
      ((Intent)localObject).putExtra("download_entrance_scene", 16);
      ((Intent)localObject).putExtra("extra_id", parambrx);
      d.b(paramContext, "emoji", ".ui.EmojiStoreDetailUI", (Intent)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.d.a
 * JD-Core Version:    0.7.0.1
 */