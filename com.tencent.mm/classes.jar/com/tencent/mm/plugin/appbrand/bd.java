package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b.b;
import com.tencent.mm.plugin.appbrand.s.d.b;
import com.tencent.mm.plugin.appbrand.s.k.c;
import com.tencent.mm.plugin.appbrand.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class bd
{
  private static int kFW;
  private static int kFX;
  private static int kFY;
  private static int kFZ;
  private static k.c kGa;
  private static k.c kGb;
  private static d.b kGc;
  private static b.b kGd;
  
  static
  {
    AppMethodBeat.i(43996);
    kFW = 1;
    kFX = 2;
    kFY = 3;
    kFZ = 4;
    kGa = new k.c()
    {
      public final boolean Uw(String paramAnonymousString)
      {
        AppMethodBeat.i(43986);
        if (c.adj(paramAnonymousString))
        {
          Log.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
          AppMethodBeat.o(43986);
          return true;
        }
        boolean bool = bd.vF(bd.kFW);
        AppMethodBeat.o(43986);
        return bool;
      }
      
      public final boolean btz()
      {
        AppMethodBeat.i(43987);
        boolean bool = bd.vG(bd.kFW);
        AppMethodBeat.o(43987);
        return bool;
      }
    };
    kGb = new k.c()
    {
      public final boolean Uw(String paramAnonymousString)
      {
        AppMethodBeat.i(43988);
        boolean bool = bd.vF(bd.kFW);
        AppMethodBeat.o(43988);
        return bool;
      }
      
      public final boolean btz()
      {
        AppMethodBeat.i(43989);
        boolean bool = bd.vG(bd.kFW);
        AppMethodBeat.o(43989);
        return bool;
      }
    };
    kGc = new d.b()
    {
      public final boolean btA()
      {
        AppMethodBeat.i(43990);
        boolean bool = bd.vF(bd.kFX);
        AppMethodBeat.o(43990);
        return bool;
      }
      
      public final boolean btB()
      {
        AppMethodBeat.i(226252);
        boolean bool = bd.vF(bd.kFZ);
        AppMethodBeat.o(226252);
        return bool;
      }
      
      public final boolean btz()
      {
        AppMethodBeat.i(43991);
        boolean bool = bd.vG(bd.kFX);
        AppMethodBeat.o(43991);
        return bool;
      }
    };
    kGd = new b.b()
    {
      public final boolean btA()
      {
        AppMethodBeat.i(43992);
        boolean bool = bd.vF(bd.kFY);
        AppMethodBeat.o(43992);
        return bool;
      }
    };
    AppMethodBeat.o(43996);
  }
  
  public static k.c btv()
  {
    return kGa;
  }
  
  public static k.c btw()
  {
    return kGb;
  }
  
  public static d.b btx()
  {
    return kGc;
  }
  
  public static b.b bty()
  {
    return kGd;
  }
  
  private static Boolean vE(int paramInt)
  {
    AppMethodBeat.i(43993);
    Object localObject;
    if (paramInt == kFW)
    {
      localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_wcwss", "");
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("wcwss")))
      {
        localObject = Boolean.TRUE;
        AppMethodBeat.o(43993);
        return localObject;
      }
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("websocket")))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(43993);
        return localObject;
      }
    }
    else if (paramInt == kFX)
    {
      localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_cdnrequest", "");
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("chromium")))
      {
        localObject = Boolean.TRUE;
        AppMethodBeat.o(43993);
        return localObject;
      }
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("request")))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(43993);
        return localObject;
      }
    }
    else if (paramInt == kFY)
    {
      localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_cronetdownload", "");
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("open")))
      {
        localObject = Boolean.TRUE;
        AppMethodBeat.o(43993);
        return localObject;
      }
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close")))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(43993);
        return localObject;
      }
    }
    else if (paramInt == kFZ)
    {
      localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_cdnrequest_httpdns", "");
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("open")))
      {
        localObject = Boolean.TRUE;
        AppMethodBeat.o(43993);
        return localObject;
      }
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close")))
      {
        localObject = Boolean.FALSE;
        AppMethodBeat.o(43993);
        return localObject;
      }
    }
    AppMethodBeat.o(43993);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bd
 * JD-Core Version:    0.7.0.1
 */