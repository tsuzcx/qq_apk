package com.tencent.mm.plugin.appbrand.game.f;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.appbrand.y.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class d
{
  private static boolean gbc = false;
  
  public static void ci(Context paramContext)
  {
    Object localObject = q.dyl.duM;
    if (gbc)
    {
      y.i("MicroMsg.WAGameShowFailDialogUtil", "hy: already shown");
      return;
    }
    String str1 = ae.getResources().getString(y.j.appbrand_game_game_start_error);
    String str2 = ae.getResources().getString(y.j.app_tip);
    if (!bk.bl((String)localObject)) {}
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.ipc.a.a(paramContext, (String)localObject, str2, ae.getResources().getString(y.j.app_ok), "", new d.1(), new d.2(), new d.3());
      gbc = true;
      return;
      localObject = str1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.f.d
 * JD-Core Version:    0.7.0.1
 */