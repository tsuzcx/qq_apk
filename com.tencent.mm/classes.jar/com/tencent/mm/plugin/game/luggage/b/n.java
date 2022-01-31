package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bh.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bi;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class n
  extends bi<com.tencent.mm.plugin.game.luggage.d.f>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<com.tencent.mm.plugin.game.luggage.d.f>.a parama)
  {
    AppMethodBeat.i(154151);
    String str1 = parama.byF.bxK.optString("videoUrl");
    String str2 = parama.byF.bxK.optString("thumbUrl");
    String str3 = parama.byF.bxK.optString("appId");
    if (bo.isNullOrNil(str1))
    {
      parama.a("invalid_videoUrl", null);
      AppMethodBeat.o(154151);
      return;
    }
    ((com.tencent.mm.plugin.game.api.f)g.E(com.tencent.mm.plugin.game.api.f.class)).b(((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).mContext, str1, str2, str3, 510);
    ((MMActivity)((com.tencent.mm.plugin.game.luggage.d.f)parama.byE).mContext).mmSetOnActivityResultCallback(new n.1(this, parama));
    AppMethodBeat.o(154151);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "launchGameVideoEditor";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.n
 * JD-Core Version:    0.7.0.1
 */