package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.api.d;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public final class l
{
  public static String a(String paramString, n paramn)
  {
    AppMethodBeat.i(111278);
    Object localObject = paramString;
    String str;
    if (paramn != null)
    {
      paramn.bGm();
      str = paramString;
      if (!bo.isNullOrNil(paramn.nnq.url))
      {
        bZ(paramn.nnq.nnR);
        str = eG(paramString, "h5FloatLayer=1");
        ab.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", new Object[] { str });
      }
      localObject = str;
      if (!bo.isNullOrNil(paramn.nnH.nnS)) {
        bZ(paramn.nnH.nnR);
      }
    }
    try
    {
      paramString = eG(str, "h5BannerId=" + com.tencent.mm.compatible.util.q.encode(paramn.nnH.nnS, "UTF-8"));
      str = paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label121:
      break label121;
    }
    ab.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", new Object[] { str });
    localObject = str;
    AppMethodBeat.o(111278);
    return localObject;
  }
  
  public static void a(Activity paramActivity, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(111273);
    if ((bo.isNullOrNil(paramString)) || (paramIntent == null))
    {
      AppMethodBeat.o(111273);
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    ((d)g.E(d.class)).bER();
    n localn2 = q.bGp();
    n localn1 = localn2;
    if (localn2 == null)
    {
      ((d)g.E(d.class)).bER();
      localn1 = q.bGt();
    }
    paramIntent.putExtra("rawUrl", a(paramString, localn1));
    if (bool)
    {
      a(paramActivity, paramIntent, "game_center_entrance", true, localn1, i);
      ((d)g.E(d.class)).bER();
      q.bGu();
      ((d)g.E(d.class)).bER();
      q.bGo();
      AppMethodBeat.o(111273);
      return;
    }
    a(paramActivity, paramIntent, "game_center_entrance", false, localn1, i);
    AppMethodBeat.o(111273);
  }
  
  private static void a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, n paramn, int paramInt)
  {
    AppMethodBeat.i(111276);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString);
    paramIntent.putExtra("game_check_float", paramBoolean);
    if ((paramBoolean) && (paramn != null))
    {
      paramn.bGm();
      if (paramn.nnq.nnQ) {
        paramIntent.putExtra("game_transparent_float_url", paramn.nnq.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
      paramIntent.putExtra("game_float_layer_url", paramn.nnq.url);
    }
    com.tencent.mm.plugin.game.f.c.w(paramIntent, paramContext);
    AppMethodBeat.o(111276);
  }
  
  public static void a(n paramn, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111275);
    n localn = paramn;
    if (paramn == null)
    {
      ((d)g.E(d.class)).bER();
      paramn = q.bGp();
      localn = paramn;
      if (paramn == null)
      {
        AppMethodBeat.o(111275);
        return;
      }
    }
    localn.bGm();
    ab.i("MicroMsg.GameEntranceChecker", "float layer report");
    if (!bo.isNullOrNil(localn.nnq.url))
    {
      int i = localn.field_msgType;
      if (localn.field_msgType == 100) {
        i = localn.nnL;
      }
      com.tencent.mm.game.report.c.a(ah.getContext(), 10, 1006, 1, 1, 0, localn.field_appId, paramInt1, i, localn.field_gameMsgId, localn.nnM, null);
      if (paramInt2 != 1) {
        break label194;
      }
      h.qsU.idkeyStat(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localn.field_isRead = true;
      ((e)g.E(e.class)).bES().update(localn, new String[0]);
      ((d)g.E(d.class)).bER();
      q.bGq();
      AppMethodBeat.o(111275);
      return;
      label194:
      if (paramInt2 == 2) {
        h.qsU.idkeyStat(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(Activity paramActivity, String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(111274);
    if ((bo.isNullOrNil(paramString)) || (paramIntent == null))
    {
      AppMethodBeat.o(111274);
      return;
    }
    boolean bool = paramIntent.getBooleanExtra("from_find_more_friend", false);
    int i = paramIntent.getIntExtra("game_report_from_scene", 0);
    ((d)g.E(d.class)).bER();
    n localn2 = q.bGp();
    n localn1 = localn2;
    if (localn2 == null)
    {
      ((d)g.E(d.class)).bER();
      localn1 = q.bGt();
    }
    paramIntent.putExtra("rawUrl", a(paramString, localn1));
    if (bool)
    {
      b(paramActivity, paramIntent, "game_center_entrance", true, localn1, i);
      ((d)g.E(d.class)).bER();
      q.bGu();
      ((d)g.E(d.class)).bER();
      q.bGo();
      AppMethodBeat.o(111274);
      return;
    }
    b(paramActivity, paramIntent, "game_center_entrance", false, localn1, i);
    AppMethodBeat.o(111274);
  }
  
  private static void b(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, n paramn, int paramInt)
  {
    AppMethodBeat.i(111277);
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString);
    paramIntent.putExtra("game_check_float", paramBoolean);
    Object localObject = paramIntent.getStringExtra("rawUrl");
    int i;
    if ((paramBoolean) && (paramn != null))
    {
      paramn.bGm();
      if ((paramn.nnq != null) && (!bo.isNullOrNil(paramn.nnq.url)))
      {
        paramString = new GameFloatLayerInfo();
        paramString.url = eF((String)localObject, paramn.nnq.url);
        paramString.njd = paramn.nnq.njd;
        i = -1;
        switch (paramn.nnq.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString.orientation = i;
      localObject = new GameWebViewLaunchParams();
      ((GameWebViewLaunchParams)localObject).njg = paramString;
      paramIntent.putExtra("launchParams", (Parcelable)localObject);
      paramIntent.putExtra("game_float_layer_url", paramn.nnq.url);
      com.tencent.mm.plugin.game.f.c.x(paramIntent, paramContext);
      a(paramn, paramInt, 1);
      AppMethodBeat.o(111277);
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
  
  private static void bZ(List paramList)
  {
    AppMethodBeat.i(111279);
    if (bo.es(paramList))
    {
      AppMethodBeat.o(111279);
      return;
    }
    wi localwi = new wi();
    localwi.cNO.coO = 8;
    localwi.cNO.scene = 1;
    localwi.cNO.cNT = paramList;
    a.ymk.l(localwi);
    AppMethodBeat.o(111279);
  }
  
  private static String eF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151884);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(151884);
      return paramString2;
    }
    paramString1 = Uri.parse(paramString1).getQueryParameter("nav_color");
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(151884);
      return paramString2;
    }
    paramString1 = eG(paramString2, "nav_color=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(151884);
    return paramString1;
  }
  
  private static String eG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(111280);
    Uri localUri = Uri.parse(paramString1);
    String str = localUri.getQuery();
    if (str != null) {
      paramString2 = str + "&" + paramString2;
    }
    for (;;)
    {
      try
      {
        paramString2 = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), paramString2, localUri.getFragment()).toString();
        paramString1 = paramString2;
      }
      catch (URISyntaxException paramString2)
      {
        ab.printErrStackTrace("MicroMsg.GameEntranceChecker", paramString2, "", new Object[0]);
        continue;
      }
      AppMethodBeat.o(111280);
      return paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.l
 * JD-Core Version:    0.7.0.1
 */