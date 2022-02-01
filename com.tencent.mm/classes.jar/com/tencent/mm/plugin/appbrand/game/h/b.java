package com.tencent.mm.plugin.appbrand.game.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  private static boolean elb = false;
  
  public static void showDialog(Context paramContext)
  {
    AppMethodBeat.i(45379);
    Object localObject = af.lYh.lQR;
    if (elb)
    {
      Log.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
      AppMethodBeat.o(45379);
      return;
    }
    String str1 = MMApplicationContext.getResources().getString(ba.i.appbrand_game_game_start_error);
    String str2 = MMApplicationContext.getResources().getString(ba.i.app_tip);
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (String)localObject, str2, MMApplicationContext.getResources().getString(ba.i.app_ok), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45376);
          b.aAs();
          AppMethodBeat.o(45376);
        }
      }, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45377);
          b.aAs();
          AppMethodBeat.o(45377);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45378);
          b.aAs();
          AppMethodBeat.o(45378);
        }
      });
      elb = true;
      AppMethodBeat.o(45379);
      return;
      localObject = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.b
 * JD-Core Version:    0.7.0.1
 */