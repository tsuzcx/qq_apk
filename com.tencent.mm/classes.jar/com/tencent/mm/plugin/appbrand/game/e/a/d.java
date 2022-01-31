package com.tencent.mm.plugin.appbrand.game.e.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.g.a.a;
import com.tencent.mm.plugin.appbrand.game.g.b;
import com.tencent.mm.plugin.appbrand.game.g.b.e;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.game.api.GameShareOption;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public final class d
  extends c
{
  protected final void a(com.tencent.mm.plugin.appbrand.service.c paramc, int paramInt, b.a parama, String paramString, ArrayList<GameShareOption> paramArrayList, b.e parame)
  {
    AppMethodBeat.i(143158);
    ab.i("MicroMsg.WAGameJsApiScreenRecorderEditWC", "hy: wc start edit screen recorder, with result is %s", new Object[] { parame });
    MMActivity localMMActivity = (MMActivity)paramc.X(MMActivity.class);
    localMMActivity.mmSetOnActivityResultCallback(new d.1(this, paramc, paramInt));
    Bundle localBundle = new Bundle();
    localBundle.putString("k_ext_wording", paramString);
    localBundle.putParcelableArrayList("k_ext_share_options", paramArrayList);
    paramString = b.a(paramc.getAppId(), f(paramc));
    if (paramString.huU != null)
    {
      paramString = paramString.huU.aAX();
      paramString.fzT = 64000;
      paramString.audioSampleRate = parame.audioSampleRate;
      paramString.eRF = 1;
      localBundle.putParcelable("k_preferred_trans_param", paramString);
      if (paramc.getRuntime().atR() == null) {
        break label198;
      }
    }
    label198:
    for (paramString = paramc.getRuntime().atR().nickname;; paramString = "")
    {
      ((f)g.E(f.class)).a(localMMActivity, paramc.getAppId(), paramString, parama.htm, localBundle);
      AppMethodBeat.o(143158);
      return;
      paramString = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.d
 * JD-Core Version:    0.7.0.1
 */