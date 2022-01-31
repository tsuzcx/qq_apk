package com.tencent.mm.plugin.appbrand.game.h;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  private static boolean bAo = false;
  
  public static void cJ(Context paramContext)
  {
    AppMethodBeat.i(130340);
    Object localObject = ac.erD.emC;
    if (bAo)
    {
      ab.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
      AppMethodBeat.o(130340);
      return;
    }
    String str1 = ah.getResources().getString(2131297125);
    String str2 = ah.getResources().getString(2131297087);
    if (!bo.isNullOrNil((String)localObject)) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (String)localObject, str2, ah.getResources().getString(2131297018), "", new b.1(), new b.2(), new b.3());
      bAo = true;
      AppMethodBeat.o(130340);
      return;
      localObject = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.b
 * JD-Core Version:    0.7.0.1
 */