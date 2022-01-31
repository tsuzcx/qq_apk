package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class d
  extends a
{
  public d()
  {
    super(8);
  }
  
  public final void a(Context paramContext, e parame, bcz parambcz)
  {
    AppMethodBeat.i(135901);
    parambcz = parame.bzu.getString("shortcut_user_name");
    String str = parame.uRD.getAppId();
    if ((bo.isNullOrNil(parambcz)) || (bo.isNullOrNil(str)))
    {
      AppMethodBeat.o(135901);
      return;
    }
    AddShortcutTask localAddShortcutTask = new AddShortcutTask();
    localAddShortcutTask.username = parambcz;
    localAddShortcutTask.appId = str;
    localAddShortcutTask.hxp = new d.1(this, localAddShortcutTask, parame, paramContext);
    localAddShortcutTask.aBj();
    AppBrandMainProcessService.a(localAddShortcutTask);
    AppMethodBeat.o(135901);
  }
  
  public final void a(e parame, l paraml, bcz parambcz)
  {
    AppMethodBeat.i(135900);
    String str1 = parame.uRD.getAppId();
    String str2 = parame.bzu.getString("shortcut_user_name");
    if ((!parame.bzu.getBoolean("from_shortcut", false)) && (!bo.isNullOrNil(str1)) && (!bo.isNullOrNil(str2)))
    {
      parame = parambcz.Title + "__" + parambcz.ThumbUrl;
      paraml.e(parambcz.wzE, parame);
    }
    AppMethodBeat.o(135900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.d
 * JD-Core Version:    0.7.0.1
 */