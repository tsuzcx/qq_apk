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
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class g
  extends a
{
  private a.b tUH;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(83111);
    this.tUH = new a.b()
    {
      public final void bip()
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
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, byv parambyv)
  {
    AppMethodBeat.i(83112);
    parambyv = new Bundle();
    parambyv.putLong("msg_id", paramg.mParams.getLong("msg_id", -9223372036854775808L));
    parambyv.putString("sns_local_id", paramg.mParams.getString("sns_local_id"));
    parambyv.putInt("news_svr_id", paramg.mParams.getInt("news_svr_id", 0));
    parambyv.putString("news_svr_tweetid", paramg.mParams.getString("news_svr_tweetid"));
    parambyv.putInt("message_index", paramg.mParams.getInt("message_index", 0));
    Object localObject = paramg.getUrl();
    String str = paramg.bQm();
    parambyv.putString("rawUrl", str);
    if ((!bt.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bt.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambyv.putString("rawUrl", (String)localObject);
        parambyv.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      parambyv.putString("preChatName", paramg.mParams.getString("preChatName"));
      parambyv.putInt("preMsgIndex", paramg.mParams.getInt("preMsgIndex", 0));
      parambyv.putString("prePublishId", paramg.mParams.getString("prePublishId"));
      parambyv.putString("preUsername", paramg.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).dxT = parambyv;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).DOc) {
        break;
      }
      ba.WJ(1);
      paramg.chX.a(new d()
      {
        public final JSONObject BO()
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
        parambyv.putString("rawUrl", (String)localObject);
        parambyv.putLong("msg_id", -9223372036854775808L);
        parambyv.putString("sns_local_id", "");
      }
    }
    e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.tUH);
    AppMethodBeat.o(83112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.g
 * JD-Core Version:    0.7.0.1
 */