package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.e.n;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.ipc.LuggageMainProcessService;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;

public final class d
  extends a
{
  public d()
  {
    super(8);
  }
  
  public final void a(Context paramContext, e parame, awk paramawk)
  {
    paramawk = parame.biV.getString("shortcut_user_name");
    String str = parame.rbS.getAppId();
    if ((bk.bl(paramawk)) || (bk.bl(str))) {
      return;
    }
    AddShortcutTask localAddShortcutTask = new AddShortcutTask();
    localAddShortcutTask.username = paramawk;
    localAddShortcutTask.appId = str;
    localAddShortcutTask.gfD = new d.1(this, localAddShortcutTask, parame, paramContext);
    localAddShortcutTask.ahC();
    LuggageMainProcessService.a(localAddShortcutTask);
  }
  
  public final void a(e parame, l paraml, awk paramawk)
  {
    String str1 = parame.rbS.getAppId();
    String str2 = parame.biV.getString("shortcut_user_name");
    if ((!parame.biV.getBoolean("from_shortcut", false)) && (!bk.bl(str1)) && (!bk.bl(str2)))
    {
      parame = paramawk.bGw + "__" + paramawk.mQp;
      paraml.e(paramawk.sYX, parame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.d
 * JD-Core Version:    0.7.0.1
 */