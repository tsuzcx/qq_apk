package com.tencent.mm.plugin.game.luggage.d.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.ba;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class g
  extends a
{
  private a.b ufz;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(83111);
    this.ufz = new a.b()
    {
      public final void biY()
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
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, bzp parambzp)
  {
    AppMethodBeat.i(83112);
    parambzp = new Bundle();
    parambzp.putLong("msg_id", paramg.mParams.getLong("msg_id", -9223372036854775808L));
    parambzp.putString("sns_local_id", paramg.mParams.getString("sns_local_id"));
    parambzp.putInt("news_svr_id", paramg.mParams.getInt("news_svr_id", 0));
    parambzp.putString("news_svr_tweetid", paramg.mParams.getString("news_svr_tweetid"));
    parambzp.putInt("message_index", paramg.mParams.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.bRn();
    parambzp.putString("rawUrl", str);
    if ((!bu.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambzp.putString("rawUrl", (String)localObject);
        parambzp.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      parambzp.putString("preChatName", paramg.mParams.getString("preChatName"));
      parambzp.putInt("preMsgIndex", paramg.mParams.getInt("preMsgIndex", 0));
      parambzp.putString("prePublishId", paramg.mParams.getString("prePublishId"));
      parambzp.putString("preUsername", paramg.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).dyY = parambzp;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).Egc) {
        break;
      }
      ba.Xq(1);
      paramg.chX.a(new d()
      {
        public final JSONObject BP()
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
      if ((!bu.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambzp.putString("rawUrl", (String)localObject);
        parambzp.putLong("msg_id", -9223372036854775808L);
        parambzp.putString("sns_local_id", "");
      }
    }
    e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.ufz);
    AppMethodBeat.o(83112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.g
 * JD-Core Version:    0.7.0.1
 */