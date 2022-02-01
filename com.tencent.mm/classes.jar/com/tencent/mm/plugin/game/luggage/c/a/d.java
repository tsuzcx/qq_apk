package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.protocal.protobuf.bpp;
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
  
  public final void a(final Context paramContext, final f paramf, bpp parambpp)
  {
    AppMethodBeat.i(83106);
    parambpp = paramf.mParams.getString("shortcut_user_name");
    String str = paramf.ATn.getAppId();
    if ((bt.isNullOrNil(parambpp)) || (bt.isNullOrNil(str)))
    {
      AppMethodBeat.o(83106);
      return;
    }
    final AddShortcutTask localAddShortcutTask = new AddShortcutTask();
    localAddShortcutTask.username = parambpp;
    localAddShortcutTask.appId = str;
    localAddShortcutTask.jwt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83104);
        localAddShortcutTask.aXn();
        paramf.caI.a(new c()
        {
          public final JSONObject AM()
          {
            AppMethodBeat.i(83102);
            JSONObject localJSONObject = new JSONObject();
            try
            {
              localJSONObject.put("success", d.1.this.rPK.success);
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
    localAddShortcutTask.aXm();
    AppBrandMainProcessService.a(localAddShortcutTask);
    AppMethodBeat.o(83106);
  }
  
  public final void a(f paramf, l paraml, bpp parambpp)
  {
    AppMethodBeat.i(83105);
    String str1 = paramf.ATn.getAppId();
    String str2 = paramf.mParams.getString("shortcut_user_name");
    if ((!paramf.mParams.getBoolean("from_shortcut", false)) && (!bt.isNullOrNil(str1)) && (!bt.isNullOrNil(str2)))
    {
      paramf = parambpp.Title + "__" + parambpp.ThumbUrl;
      paraml.c(parambpp.CKO, paramf);
    }
    AppMethodBeat.o(83105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a.d
 * JD-Core Version:    0.7.0.1
 */