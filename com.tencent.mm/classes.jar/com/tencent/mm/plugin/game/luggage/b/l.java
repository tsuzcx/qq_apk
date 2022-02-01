package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  extends bv
{
  public final void a(final Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(277136);
    try
    {
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("videoUrl", "");
      if (Util.isNullOrNil(paramString))
      {
        parama.j("videoUrl is null", null);
        AppMethodBeat.o(277136);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      parama.j("fail", null);
      AppMethodBeat.o(277136);
      return;
    }
    Object localObject = ((JSONObject)localObject).optString("thumbUrl", "");
    if (Util.isNullOrNil((String)localObject))
    {
      parama.j("thumbUrl is null", null);
      AppMethodBeat.o(277136);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("game_from", 11);
    localIntent.putExtra("video_url", paramString);
    localIntent.putExtra("thumb_url", (String)localObject);
    ((MMActivity)paramContext).mmSetOnActivityResultCallback(new MMActivity.a()
    {
      public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(277114);
        if (paramAnonymousInt1 == 1137)
        {
          if (paramAnonymousInt2 != -1) {
            break label71;
          }
          paramAnonymousIntent = paramAnonymousIntent.getStringExtra("ret_info");
          if (!"0".equals(paramAnonymousIntent)) {
            break label59;
          }
          parama.j(null, null);
        }
        for (;;)
        {
          ((MMActivity)paramContext).mmSetOnActivityResultCallback(null);
          AppMethodBeat.o(277114);
          return;
          label59:
          parama.j(paramAnonymousIntent, null);
          continue;
          label71:
          parama.j("cancel", null);
        }
      }
    });
    c.b(paramContext, "game", ".media.GameVideoDownloadUI", localIntent, 1137);
    AppMethodBeat.o(277136);
  }
  
  public final void b(b.a parama) {}
  
  public final int dgI()
  {
    return 2;
  }
  
  public final String name()
  {
    return "downloadGameVideo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */