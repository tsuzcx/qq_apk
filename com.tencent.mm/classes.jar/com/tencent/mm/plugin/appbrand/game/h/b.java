package com.tencent.mm.plugin.appbrand.game.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
{
  private static boolean cuS = false;
  
  public static void showDialog(Context paramContext)
  {
    AppMethodBeat.i(45379);
    Object localObject = ae.gKC.gDz;
    if (cuS)
    {
      Log.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
      AppMethodBeat.o(45379);
      return;
    }
    String str1 = MMApplicationContext.getResources().getString(2131756055);
    String str2 = MMApplicationContext.getResources().getString(2131755998);
    if (!Util.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (String)localObject, str2, MMApplicationContext.getResources().getString(2131755921), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45376);
          b.TT();
          AppMethodBeat.o(45376);
        }
      }, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45377);
          b.TT();
          AppMethodBeat.o(45377);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45378);
          b.TT();
          AppMethodBeat.o(45378);
        }
      });
      cuS = true;
      AppMethodBeat.o(45379);
      return;
      localObject = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.b
 * JD-Core Version:    0.7.0.1
 */