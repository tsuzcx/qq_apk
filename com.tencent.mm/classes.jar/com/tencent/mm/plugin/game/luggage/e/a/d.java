package com.tencent.mm.plugin.game.luggage.e.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import org.json.JSONObject;

public final class d
  extends a
{
  public d()
  {
    super(8);
  }
  
  public final void a(final Context paramContext, final g paramg, cxc paramcxc)
  {
    AppMethodBeat.i(83106);
    paramcxc = paramg.mParams.getString("shortcut_user_name");
    String str = paramg.PPO.getAppId();
    if ((Util.isNullOrNil(paramcxc)) || (Util.isNullOrNil(str)))
    {
      AppMethodBeat.o(83106);
      return;
    }
    final AddShortcutTask localAddShortcutTask = new AddShortcutTask();
    localAddShortcutTask.username = paramcxc;
    localAddShortcutTask.appId = str;
    localAddShortcutTask.otv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83104);
        localAddShortcutTask.bPk();
        paramg.crX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject NU()
          {
            AppMethodBeat.i(83102);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("success", d.1.this.CBN.success);
              label30:
              AppMethodBeat.o(83102);
              return localJSONObject;
            }
            catch (Exception localException)
            {
              break label30;
            }
          }
          
          public final String name()
          {
            return "onAddShortcutStatus";
          }
        });
        if (localAddShortcutTask.success)
        {
          h.a(paramContext, j.f.wv_add_shortcut_success, j.f.app_tip, false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(83103);
              paramAnonymous2DialogInterface.dismiss();
              AppMethodBeat.o(83103);
            }
          });
          AppMethodBeat.o(83104);
          return;
        }
        Toast.makeText(paramContext, paramContext.getString(j.f.wv_add_shortcut_fail), 0).show();
        AppMethodBeat.o(83104);
      }
    };
    localAddShortcutTask.bsM();
    AppMethodBeat.o(83106);
  }
  
  public final void a(g paramg, o paramo, cxc paramcxc)
  {
    AppMethodBeat.i(83105);
    String str1 = paramg.PPO.getAppId();
    String str2 = paramg.mParams.getString("shortcut_user_name");
    if ((!paramg.mParams.getBoolean("from_shortcut", false)) && (!Util.isNullOrNil(str1)) && (!Util.isNullOrNil(str2)))
    {
      paramg = paramcxc.fwr + "__" + paramcxc.ThumbUrl;
      paramo.d(paramcxc.RXp, paramg);
    }
    AppMethodBeat.o(83105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.e.a.d
 * JD-Core Version:    0.7.0.1
 */