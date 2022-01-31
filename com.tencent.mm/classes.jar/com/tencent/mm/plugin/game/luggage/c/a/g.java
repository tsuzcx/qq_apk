package com.tencent.mm.plugin.game.luggage.c.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.au;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class g
  extends a
{
  private a.b nkf;
  
  public g()
  {
    super(4);
    AppMethodBeat.i(135906);
    this.nkf = new g.2(this);
    AppMethodBeat.o(135906);
  }
  
  public final void a(Context paramContext, e parame, bcz parambcz)
  {
    AppMethodBeat.i(135907);
    parambcz = new Bundle();
    parambcz.putLong("msg_id", parame.bzu.getLong("msg_id", -9223372036854775808L));
    parambcz.putString("sns_local_id", parame.bzu.getString("sns_local_id"));
    parambcz.putInt("news_svr_id", parame.bzu.getInt("news_svr_id", 0));
    parambcz.putString("news_svr_tweetid", parame.bzu.getString("news_svr_tweetid"));
    parambcz.putInt("message_index", parame.bzu.getInt("message_index", 0));
    Object localObject = parame.getUrl();
    String str = parame.daZ();
    parambcz.putString("rawUrl", str);
    if ((!bo.isNullOrNil(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambcz.putString("rawUrl", (String)localObject);
        parambcz.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      parambcz.putString("preChatName", parame.bzu.getString("preChatName"));
      parambcz.putInt("preMsgIndex", parame.bzu.getInt("preMsgIndex", 0));
      parambcz.putString("prePublishId", parame.bzu.getString("prePublishId"));
      parambcz.putString("preUsername", parame.bzu.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).mEJ = parambcz;
      AppBrandMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).uRc) {
        break;
      }
      au.JS(1);
      parame.bzs.a(new g.1(this));
      AppMethodBeat.o(135907);
      return;
      if ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        parambcz.putString("rawUrl", (String)localObject);
        parambcz.putLong("msg_id", -9223372036854775808L);
        parambcz.putString("sns_local_id", "");
      }
    }
    c.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.nkf);
    AppMethodBeat.o(135907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.g
 * JD-Core Version:    0.7.0.1
 */