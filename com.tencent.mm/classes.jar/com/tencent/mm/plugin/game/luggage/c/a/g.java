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
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.snackbar.a.b;
import org.json.JSONObject;

public final class g
  extends a
{
  private a.b sXH;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(83111);
    this.sXH = new a.b()
    {
      public final void beL()
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
  
  public final void a(Context paramContext, f paramf, bug parambug)
  {
    AppMethodBeat.i(83112);
    parambug = new Bundle();
    parambug.putLong("msg_id", paramf.mParams.getLong("msg_id", -9223372036854775808L));
    parambug.putString("sns_local_id", paramf.mParams.getString("sns_local_id"));
    parambug.putInt("news_svr_id", paramf.mParams.getInt("news_svr_id", 0));
    parambug.putString("news_svr_tweetid", paramf.mParams.getString("news_svr_tweetid"));
    parambug.putInt("message_index", paramf.mParams.getInt("message_index", 0));
    Object localObject = paramf.getUrl();
    String str = paramf.bLL();
    parambug.putString("rawUrl", str);
    if ((!bs.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambug.putString("rawUrl", (String)localObject);
        parambug.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      parambug.putString("preChatName", paramf.mParams.getString("preChatName"));
      parambug.putInt("preMsgIndex", paramf.mParams.getInt("preMsgIndex", 0));
      parambug.putString("prePublishId", paramf.mParams.getString("prePublishId"));
      parambug.putString("preUsername", paramf.mParams.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).dmf = parambug;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).CkX) {
        break;
      }
      ax.UT(1);
      paramf.bXF.a(new c()
      {
        public final JSONObject Aq()
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
      if ((!bs.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambug.putString("rawUrl", (String)localObject);
        parambug.putLong("msg_id", -9223372036854775808L);
        parambug.putString("sns_local_id", "");
      }
    }
    e.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.sXH);
    AppMethodBeat.o(83112);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.g
 * JD-Core Version:    0.7.0.1
 */