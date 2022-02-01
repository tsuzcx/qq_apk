package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.b.b;
import com.tencent.mm.plugin.appbrand.s.d.b;
import com.tencent.mm.plugin.appbrand.s.k.c;
import com.tencent.mm.plugin.appbrand.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class bf
{
  private static int nzD;
  private static int nzE;
  private static int nzF;
  private static int nzG;
  private static k.c nzH;
  private static k.c nzI;
  private static d.b nzJ;
  private static b.b nzK;
  
  static
  {
    AppMethodBeat.i(43996);
    nzD = 1;
    nzE = 2;
    nzF = 3;
    nzG = 4;
    nzH = new k.c()
    {
      public final boolean acg(String paramAnonymousString)
      {
        AppMethodBeat.i(43986);
        if (c.ale(paramAnonymousString))
        {
          Log.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
          AppMethodBeat.o(43986);
          return true;
        }
        boolean bool = bf.yQ(bf.nzD);
        AppMethodBeat.o(43986);
        return bool;
      }
      
      public final boolean bEw()
      {
        AppMethodBeat.i(43987);
        boolean bool = bf.yR(bf.nzD);
        AppMethodBeat.o(43987);
        return bool;
      }
    };
    nzI = new k.c()
    {
      public final boolean acg(String paramAnonymousString)
      {
        AppMethodBeat.i(43988);
        boolean bool = bf.yQ(bf.nzD);
        AppMethodBeat.o(43988);
        return bool;
      }
      
      public final boolean bEw()
      {
        AppMethodBeat.i(43989);
        boolean bool = bf.yR(bf.nzD);
        AppMethodBeat.o(43989);
        return bool;
      }
    };
    nzJ = new d.b()
    {
      public final boolean bEw()
      {
        AppMethodBeat.i(43991);
        boolean bool = bf.yR(bf.nzE);
        AppMethodBeat.o(43991);
        return bool;
      }
      
      public final boolean bEx()
      {
        AppMethodBeat.i(43990);
        boolean bool = bf.yQ(bf.nzE);
        AppMethodBeat.o(43990);
        return bool;
      }
      
      public final boolean bEy()
      {
        AppMethodBeat.i(280196);
        boolean bool = bf.yQ(bf.nzG);
        AppMethodBeat.o(280196);
        return bool;
      }
    };
    nzK = new b.b()
    {
      public final boolean bEx()
      {
        AppMethodBeat.i(43992);
        boolean bool = bf.yQ(bf.nzF);
        AppMethodBeat.o(43992);
        return bool;
      }
    };
    AppMethodBeat.o(43996);
  }
  
  public static k.c bEs()
  {
    return nzH;
  }
  
  public static k.c bEt()
  {
    return nzI;
  }
  
  public static d.b bEu()
  {
    return nzJ;
  }
  
  public static b.b bEv()
  {
    return nzK;
  }
  
  private static Boolean yP(int paramInt)
  {
    AppMethodBeat.i(43993);
    Object localObject;
    if (paramInt == nzD)
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
    else if (paramInt == nzE)
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
    else if (paramInt == nzF)
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
    else if (paramInt == nzG)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bf
 * JD-Core Version:    0.7.0.1
 */