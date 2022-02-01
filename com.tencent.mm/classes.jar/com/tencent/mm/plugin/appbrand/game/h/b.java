package com.tencent.mm.plugin.appbrand.game.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
{
  private static boolean ciW = false;
  
  public static void dp(Context paramContext)
  {
    AppMethodBeat.i(45379);
    Object localObject = com.tencent.mm.compatible.deviceinfo.ae.geV.fYm;
    if (ciW)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
      AppMethodBeat.o(45379);
      return;
    }
    String str1 = ak.getResources().getString(2131755955);
    String str2 = ak.getResources().getString(2131755906);
    if (!bu.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (String)localObject, str2, ak.getResources().getString(2131755835), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45376);
          b.JG();
          AppMethodBeat.o(45376);
        }
      }, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45377);
          b.JG();
          AppMethodBeat.o(45377);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45378);
          b.JG();
          AppMethodBeat.o(45378);
        }
      });
      ciW = true;
      AppMethodBeat.o(45379);
      return;
      localObject = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.b
 * JD-Core Version:    0.7.0.1
 */