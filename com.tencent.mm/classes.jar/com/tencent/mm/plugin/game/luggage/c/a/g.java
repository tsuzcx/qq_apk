package com.tencent.mm.plugin.game.luggage.c.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.webview.luggage.FavUrlTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.plugin.webview.luggage.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.luggage.jsapi.ak;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.snackbar.a.b;

public final class g
  extends a
{
  private a.b kNz = new g.2(this);
  
  public g()
  {
    super(4);
  }
  
  public final void a(Context paramContext, e parame, awk paramawk)
  {
    paramawk = new Bundle();
    paramawk.putLong("msg_id", parame.biV.getLong("msg_id", -9223372036854775808L));
    paramawk.putString("sns_local_id", parame.biV.getString("sns_local_id"));
    paramawk.putInt("news_svr_id", parame.biV.getInt("news_svr_id", 0));
    paramawk.putString("news_svr_tweetid", parame.biV.getString("news_svr_tweetid"));
    paramawk.putInt("message_index", parame.biV.getInt("message_index", 0));
    Object localObject = parame.getUrl();
    String str = parame.caV();
    paramawk.putString("rawUrl", str);
    if ((!bk.bl(str)) && (str.endsWith("#rd")))
    {
      str = str.substring(0, str.length() - 3);
      if ((!bk.bl((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        paramawk.putString("rawUrl", (String)localObject);
        paramawk.putLong("msg_id", -9223372036854775808L);
      }
    }
    for (;;)
    {
      paramawk.putString("preChatName", parame.biV.getString("preChatName"));
      paramawk.putInt("preMsgIndex", parame.biV.getInt("preMsgIndex", 0));
      paramawk.putString("prePublishId", parame.biV.getString("prePublishId"));
      paramawk.putString("preUsername", parame.biV.getString("preUsername"));
      localObject = new FavUrlTask();
      ((FavUrlTask)localObject).actionType = 1;
      ((FavUrlTask)localObject).kke = paramawk;
      LuggageMainProcessService.b((MainProcessTask)localObject);
      if (!((FavUrlTask)localObject).rbu) {
        break;
      }
      ak.BY(1);
      parame.biT.a(new g.1(this));
      return;
      if ((!bk.bl((String)localObject)) && (!((String)localObject).startsWith(str)))
      {
        paramawk.putString("rawUrl", (String)localObject);
        paramawk.putLong("msg_id", -9223372036854775808L);
        paramawk.putString("sns_local_id", "");
      }
    }
    c.a(((FavUrlTask)localObject).ret, (Activity)paramContext, this.kNz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.g
 * JD-Core Version:    0.7.0.1
 */