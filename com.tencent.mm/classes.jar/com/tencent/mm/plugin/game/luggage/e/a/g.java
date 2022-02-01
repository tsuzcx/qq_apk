package com.tencent.mm.plugin.game.luggage.e.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.bf;
import com.tencent.mm.protocal.protobuf.doh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends a
{
  private a.b IvJ;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(83111);
    this.IvJ = new a.b()
    {
      public final void onMessageClick()
      {
        AppMethodBeat.i(83110);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        localFavUrlTask.bQt();
        AppMethodBeat.o(83110);
      }
    };
    AppMethodBeat.o(83111);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, doh paramdoh)
  {
    AppMethodBeat.i(83112);
    paramdoh = new Bundle();
    paramdoh.putLong("msg_id", paramg.ejT.getLong("msg_id", -9223372036854775808L));
    paramdoh.putString("sns_local_id", paramg.ejT.getString("sns_local_id"));
    paramdoh.putInt("news_svr_id", paramg.ejT.getInt("news_svr_id", 0));
    paramdoh.putString("news_svr_tweetid", paramg.ejT.getString("news_svr_tweetid"));
    paramdoh.putInt("message_index", paramg.ejT.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.dgY();
    paramdoh.putString("rawUrl", str);
    if ((!Util.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        paramdoh.putString("rawUrl", (String)localObject);
        paramdoh.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      paramdoh.putString("preChatName", paramg.ejT.getString("preChatName"));
      paramdoh.putInt("preMsgIndex", paramg.ejT.getInt("preMsgIndex", 0));
      paramdoh.putString("prePublishId", paramg.ejT.getString("prePublishId"));
      paramdoh.putString("preUsername", paramg.ejT.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).hPH = paramdoh;
      ((FavUrlTask)localObject).cpB();
      if (!((FavUrlTask)localObject).WFx) {
        break;
      }
      bf.atG(1);
      paramg.ejR.a(new d()
      {
        public final JSONObject aoe()
        {
          AppMethodBeat.i(277006);
          JSONObject localJSONObject = new JSONObject();
          try
          {
            localJSONObject.put("scene", "favorite");
            label22:
            AppMethodBeat.o(277006);
            return localJSONObject;
          }
          catch (JSONException localJSONException)
          {
            break label22;
          }
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
        paramdoh.putString("rawUrl", (String)localObject);
        paramdoh.putLong("msg_id", -9223372036854775808L);
        paramdoh.putString("sns_local_id", "");
      }
    }
    e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.IvJ);
    AppMethodBeat.o(83112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.g
 * JD-Core Version:    0.7.0.1
 */