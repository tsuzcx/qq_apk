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
import com.tencent.mm.plugin.webview.luggage.jsapi.bb;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class g
  extends a
{
  private a.b CBU;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(83111);
    this.CBU = new a.b()
    {
      public final void bPM()
      {
        AppMethodBeat.i(83110);
        FavUrlTask localFavUrlTask = new FavUrlTask();
        localFavUrlTask.actionType = 2;
        localFavUrlTask.bsM();
        AppMethodBeat.o(83110);
      }
    };
    AppMethodBeat.o(83111);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, cxc paramcxc)
  {
    AppMethodBeat.i(83112);
    paramcxc = new Bundle();
    paramcxc.putLong("msg_id", paramg.mParams.getLong("msg_id", -9223372036854775808L));
    paramcxc.putString("sns_local_id", paramg.mParams.getString("sns_local_id"));
    paramcxc.putInt("news_svr_id", paramg.mParams.getInt("news_svr_id", 0));
    paramcxc.putString("news_svr_tweetid", paramg.mParams.getString("news_svr_tweetid"));
    paramcxc.putInt("message_index", paramg.mParams.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.cDu();
    paramcxc.putString("rawUrl", str);
    if ((!Util.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!Util.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        paramcxc.putString("rawUrl", (String)localObject);
        paramcxc.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      paramcxc.putString("preChatName", paramg.mParams.getString("preChatName"));
      paramcxc.putInt("preMsgIndex", paramg.mParams.getInt("preMsgIndex", 0));
      paramcxc.putString("prePublishId", paramg.mParams.getString("prePublishId"));
      paramcxc.putString("preUsername", paramg.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).fKb = paramcxc;
      ((FavUrlTask)localObject).bPu();
      if (!((FavUrlTask)localObject).PPe) {
        break;
      }
      bb.anM(1);
      paramg.crX.a(new d()
      {
        public final JSONObject NU()
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
        paramcxc.putString("rawUrl", (String)localObject);
        paramcxc.putLong("msg_id", -9223372036854775808L);
        paramcxc.putString("sns_local_id", "");
      }
    }
    e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.CBU);
    AppMethodBeat.o(83112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.g
 * JD-Core Version:    0.7.0.1
 */