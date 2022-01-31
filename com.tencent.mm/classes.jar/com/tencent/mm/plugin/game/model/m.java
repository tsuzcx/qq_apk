package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URI;
import java.net.URISyntaxException;

public final class m
{
  public static String a(String paramString, o paramo)
  {
    if (paramo != null)
    {
      paramo.aZm();
      if (bk.bl(paramo.kPu.url)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.GameFloatUtil", "hasFloatLayer = " + bool);
      paramo = paramString;
      Uri localUri;
      if (bool)
      {
        localUri = Uri.parse(paramString);
        paramo = localUri.getQuery();
        if (paramo == null) {
          break label129;
        }
        paramo = paramo + "&h5FloatLayer=1";
      }
      try
      {
        for (;;)
        {
          paramo = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), paramo, localUri.getFragment()).toString();
          y.i("MicroMsg.GameFloatUtil", "abtest, url = %s", new Object[] { paramo });
          return paramo;
          label129:
          paramo = "h5FloatLayer=1";
        }
      }
      catch (URISyntaxException paramo)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.GameFloatUtil", paramo, "", new Object[0]);
          paramo = paramString;
        }
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, o paramo, int paramInt)
  {
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString);
    paramIntent.putExtra("game_check_float", paramBoolean);
    if ((paramBoolean) && (paramo != null))
    {
      paramo.aZm();
      if (paramo.kPu.kPR) {
        paramIntent.putExtra("game_transparent_float_url", paramo.kPu.url);
      }
      paramIntent.putExtra("game_sourceScene", paramInt);
    }
    paramString = new Intent();
    paramString.putExtras(paramIntent.getExtras());
    com.tencent.mm.plugin.game.f.c.x(paramString, paramContext);
  }
  
  public static void a(o paramo, int paramInt1, int paramInt2)
  {
    o localo = paramo;
    if (paramo == null)
    {
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
      paramo = r.aZp();
      localo = paramo;
      if (paramo == null) {
        return;
      }
    }
    localo.aZm();
    y.i("MicroMsg.GameFloatUtil", "float layer report");
    if (!bk.bl(localo.kPu.url))
    {
      int i = localo.field_msgType;
      if (localo.field_msgType == 100) {
        i = localo.kPM;
      }
      com.tencent.mm.plugin.game.e.b.a(ae.getContext(), 10, 1006, 1, 1, 0, localo.field_appId, paramInt1, i, localo.field_gameMsgId, localo.kPN, null);
      if (paramInt2 != 1) {
        break label179;
      }
      h.nFQ.a(858L, 16L, 1L, false);
    }
    for (;;)
    {
      localo.field_isRead = true;
      ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYf().c(localo, new String[0]);
      ((com.tencent.mm.plugin.game.a.b)g.r(com.tencent.mm.plugin.game.a.b.class)).aYe();
      r.aZq();
      return;
      label179:
      if (paramInt2 == 2) {
        h.nFQ.a(858L, 17L, 1L, false);
      }
    }
  }
  
  public static void b(Context paramContext, Intent paramIntent, String paramString, boolean paramBoolean, o paramo, int paramInt)
  {
    paramIntent.putExtra("geta8key_scene", 32);
    paramIntent.putExtra("KPublisherId", paramString);
    paramIntent.putExtra("game_check_float", paramBoolean);
    int i;
    if ((paramBoolean) && (paramo != null))
    {
      paramo.aZm();
      if ((paramo.kPu != null) && (!bk.bl(paramo.kPu.url)))
      {
        paramString = new GameFloatLayerInfo();
        paramString.url = paramo.kPu.url;
        paramString.kOO = paramo.kPu.kOO;
        i = -1;
        switch (paramo.kPu.orientation)
        {
        }
      }
    }
    for (;;)
    {
      paramString.orientation = i;
      GameWebViewLaunchParams localGameWebViewLaunchParams = new GameWebViewLaunchParams();
      localGameWebViewLaunchParams.kRd = paramString;
      paramIntent.putExtra("launchParams", localGameWebViewLaunchParams);
      paramString = new Intent();
      paramString.putExtras(paramIntent.getExtras());
      com.tencent.mm.plugin.game.f.c.y(paramString, paramContext);
      a(paramo, paramInt, 1);
      return;
      i = 0;
      continue;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.m
 * JD-Core Version:    0.7.0.1
 */