package com.tencent.mm.plugin.game.luggage.c.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.ax;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class g
  extends a
{
  private a.b rPQ;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(83111);
    this.rPQ = new a.b()
    {
      public final void aXO()
      {
        AppMethodBeat.i(83110);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        AppBrandMainProcessService.a(localFavUrlTask);
        AppMethodBeat.o(83110);
      }
    };
    AppMethodBeat.o(83111);
  }
  
  public final void a(Context paramContext, f paramf, bpp parambpp)
  {
    AppMethodBeat.i(83112);
    parambpp = new Bundle();
    parambpp.putLong("msg_id", paramf.mParams.getLong("msg_id", -9223372036854775808L));
    parambpp.putString("sns_local_id", paramf.mParams.getString("sns_local_id"));
    parambpp.putInt("news_svr_id", paramf.mParams.getInt("news_svr_id", 0));
    parambpp.putString("news_svr_tweetid", paramf.mParams.getString("news_svr_tweetid"));
    parambpp.putInt("message_index", paramf.mParams.getInt("message_index", 0));
    Object localObject = paramf.getUrl();
    String str = paramf.bEx();
    parambpp.putString("rawUrl", str);
    if ((!bt.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambpp.putString("rawUrl", (String)localObject);
        parambpp.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      parambpp.putString("preChatName", paramf.mParams.getString("preChatName"));
      parambpp.putInt("preMsgIndex", paramf.mParams.getInt("preMsgIndex", 0));
      parambpp.putString("prePublishId", paramf.mParams.getString("prePublishId"));
      parambpp.putString("preUsername", paramf.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).dow = parambpp;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).ASK) {
        break;
      }
      ax.SL(1);
      paramf.caI.a(new c()
      {
        public final JSONObject AM()
        {
          return null;
        }
        
        public final String name()
        {
          return "menu:share:appmessage";
        }
      });
      AppMethodBeat.o(83112);
      return;
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambpp.putString("rawUrl", (String)localObject);
        parambpp.putLong("msg_id", -9223372036854775808L);
        parambpp.putString("sns_local_id", "");
      }
    }
    e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.rPQ);
    AppMethodBeat.o(83112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.g
 * JD-Core Version:    0.7.0.1
 */