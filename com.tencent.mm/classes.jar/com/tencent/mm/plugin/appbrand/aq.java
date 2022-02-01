package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.p.b.b;
import com.tencent.mm.plugin.appbrand.p.d.b;
import com.tencent.mm.plugin.appbrand.p.k.c;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class aq
{
  private static int jid;
  private static int jie;
  private static int jif;
  private static k.c jig;
  private static k.c jih;
  private static d.b jii;
  private static b.b jij;
  
  static
  {
    AppMethodBeat.i(43996);
    jid = 1;
    jie = 2;
    jif = 3;
    jig = new k.c()
    {
      public final boolean HA(String paramAnonymousString)
      {
        AppMethodBeat.i(43986);
        if (c.Pr(paramAnonymousString))
        {
          ac.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
          AppMethodBeat.o(43986);
          return true;
        }
        boolean bool = aq.rh(aq.jid);
        AppMethodBeat.o(43986);
        return bool;
      }
      
      public final boolean aUH()
      {
        AppMethodBeat.i(43987);
        boolean bool = aq.ri(aq.jid);
        AppMethodBeat.o(43987);
        return bool;
      }
    };
    jih = new k.c()
    {
      public final boolean HA(String paramAnonymousString)
      {
        AppMethodBeat.i(43988);
        boolean bool = aq.rh(aq.jid);
        AppMethodBeat.o(43988);
        return bool;
      }
      
      public final boolean aUH()
      {
        AppMethodBeat.i(43989);
        boolean bool = aq.ri(aq.jid);
        AppMethodBeat.o(43989);
        return bool;
      }
    };
    jii = new d.b()
    {
      public final boolean aUH()
      {
        AppMethodBeat.i(43991);
        boolean bool = aq.ri(aq.jie);
        AppMethodBeat.o(43991);
        return bool;
      }
      
      public final boolean aUI()
      {
        AppMethodBeat.i(43990);
        boolean bool = aq.rh(aq.jie);
        AppMethodBeat.o(43990);
        return bool;
      }
    };
    jij = new b.b()
    {
      public final boolean aUI()
      {
        AppMethodBeat.i(43992);
        boolean bool = aq.rh(aq.jif);
        AppMethodBeat.o(43992);
        return bool;
      }
    };
    AppMethodBeat.o(43996);
  }
  
  public static k.c aUD()
  {
    return jig;
  }
  
  public static k.c aUE()
  {
    return jih;
  }
  
  public static d.b aUF()
  {
    return jii;
  }
  
  public static b.b aUG()
  {
    return jij;
  }
  
  private static Boolean rg(int paramInt)
  {
    AppMethodBeat.i(43993);
    Object localObject;
    if (paramInt == jid)
    {
      localObject = ai.eUZ().getString("appbrandgame_open_wcwss", "");
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
    else if (paramInt == jie)
    {
      localObject = ai.eUZ().getString("appbrandgame_open_cdnrequest", "");
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
    else if (paramInt == jif)
    {
      localObject = ai.eUZ().getString("appbrandgame_open_cronetdownload", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aq
 * JD-Core Version:    0.7.0.1
 */