package com.tencent.mm.plugin.game.luggage.d.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.luggage.d.p;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.protocal.protobuf.byv;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class d
  extends a
{
  public d()
  {
    super(8);
  }
  
  public final void a(final Context paramContext, final g paramg, byv parambyv)
  {
    AppMethodBeat.i(83106);
    parambyv = paramg.mParams.getString("shortcut_user_name");
    String str = paramg.DOL.getAppId();
    if ((bt.isNullOrNil(parambyv)) || (bt.isNullOrNil(str)))
    {
      AppMethodBeat.o(83106);
      return;
    }
    final AddShortcutTask localAddShortcutTask = new AddShortcutTask();
    localAddShortcutTask.username = parambyv;
    localAddShortcutTask.appId = str;
    localAddShortcutTask.krg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83104);
        localAddShortcutTask.bhO();
        paramg.chX.a(new com.tencent.luggage.d.d()
        {
          public final JSONObject BO()
          {
            AppMethodBeat.i(83102);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("success", d.1.this.tUB.success);
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
          h.a(paramContext, 2131766244, 2131755906, false, new DialogInterface.OnClickListener()
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
        Toast.makeText(paramContext, paramContext.getString(2131766243), 0).show();
        AppMethodBeat.o(83104);
      }
    };
    localAddShortcutTask.bhN();
    AppBrandMainProcessService.a(localAddShortcutTask);
    AppMethodBeat.o(83106);
  }
  
  public final void a(g paramg, l paraml, byv parambyv)
  {
    AppMethodBeat.i(83105);
    String str1 = paramg.DOL.getAppId();
    String str2 = paramg.mParams.getString("shortcut_user_name");
    if ((!paramg.mParams.getBoolean("from_shortcut", false)) && (!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)))
    {
      paramg = parambyv.Title + "__" + parambyv.ThumbUrl;
      paraml.c(parambyv.FJz, paramg);
    }
    AppMethodBeat.o(83105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.a.d
 * JD-Core Version:    0.7.0.1
 */