package com.tencent.mm.plugin.game.luggage.e.a;

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
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class g
  extends a
{
  private a.b xxK;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(83111);
    this.xxK = new a.b()
    {
      public final void bDZ()
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
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, coq paramcoq)
  {
    AppMethodBeat.i(83112);
    paramcoq = new Bundle();
    paramcoq.putLong("msg_id", paramg.mParams.getLong("msg_id", -9223372036854775808L));
    paramcoq.putString("sns_local_id", paramg.mParams.getString("sns_local_id"));
    paramcoq.putInt("news_svr_id", paramg.mParams.getInt("news_svr_id", 0));
    paramcoq.putString("news_svr_tweetid", paramg.mParams.getString("news_svr_tweetid"));
    paramcoq.putInt("message_index", paramg.mParams.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.coX();
    paramcoq.putString("rawUrl", str);
    if ((!Util.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        paramcoq.putString("rawUrl", (String)localObject);
        paramcoq.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      paramcoq.putString("preChatName", paramg.mParams.getString("preChatName"));
      paramcoq.putInt("preMsgIndex", paramg.mParams.getInt("preMsgIndex", 0));
      paramcoq.putString("prePublishId", paramg.mParams.getString("prePublishId"));
      paramcoq.putString("preUsername", paramg.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).dQL = paramcoq;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).ISL) {
        break;
      }
      bb.afY(1);
      paramg.ctS.a(new d()
      {
        public final JSONObject Ld()
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
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        paramcoq.putString("rawUrl", (String)localObject);
        paramcoq.putLong("msg_id", -9223372036854775808L);
        paramcoq.putString("sns_local_id", "");
      }
    }
    e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.xxK);
    AppMethodBeat.o(83112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.g
 * JD-Core Version:    0.7.0.1
 */