package com.tencent.mm.plugin.appbrand.game.h;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  private static boolean cbF = false;
  
  public static void dg(Context paramContext)
  {
    AppMethodBeat.i(45379);
    Object localObject = ae.fFF.fzl;
    if (cbF)
    {
      ad.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
      AppMethodBeat.o(45379);
      return;
    }
    String str1 = aj.getResources().getString(2131755955);
    String str2 = aj.getResources().getString(2131755906);
    if (!bt.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (String)localObject, str2, aj.getResources().getString(2131755835), "", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45376);
          b.acT();
          AppMethodBeat.o(45376);
        }
      }, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45377);
          b.acT();
          AppMethodBeat.o(45377);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(45378);
          b.acT();
          AppMethodBeat.o(45378);
        }
      });
      cbF = true;
      AppMethodBeat.o(45379);
      return;
      localObject = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.b
 * JD-Core Version:    0.7.0.1
 */