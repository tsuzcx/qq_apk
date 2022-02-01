package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.b.b;
import com.tencent.mm.plugin.appbrand.o.d.b;
import com.tencent.mm.plugin.appbrand.o.k.c;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class as
{
  private static int jEn;
  private static int jEo;
  private static int jEp;
  private static k.c jEq;
  private static k.c jEr;
  private static d.b jEs;
  private static b.b jEt;
  
  static
  {
    AppMethodBeat.i(43996);
    jEn = 1;
    jEo = 2;
    jEp = 3;
    jEq = new k.c()
    {
      public final boolean Ln(String paramAnonymousString)
      {
        AppMethodBeat.i(43986);
        if (c.TD(paramAnonymousString))
        {
          ae.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
          AppMethodBeat.o(43986);
          return true;
        }
        boolean bool = as.rK(as.jEn);
        AppMethodBeat.o(43986);
        return bool;
      }
      
      public final boolean aYm()
      {
        AppMethodBeat.i(43987);
        boolean bool = as.rL(as.jEn);
        AppMethodBeat.o(43987);
        return bool;
      }
    };
    jEr = new k.c()
    {
      public final boolean Ln(String paramAnonymousString)
      {
        AppMethodBeat.i(43988);
        boolean bool = as.rK(as.jEn);
        AppMethodBeat.o(43988);
        return bool;
      }
      
      public final boolean aYm()
      {
        AppMethodBeat.i(43989);
        boolean bool = as.rL(as.jEn);
        AppMethodBeat.o(43989);
        return bool;
      }
    };
    jEs = new d.b()
    {
      public final boolean aYm()
      {
        AppMethodBeat.i(43991);
        boolean bool = as.rL(as.jEo);
        AppMethodBeat.o(43991);
        return bool;
      }
      
      public final boolean aYn()
      {
        AppMethodBeat.i(43990);
        boolean bool = as.rK(as.jEo);
        AppMethodBeat.o(43990);
        return bool;
      }
    };
    jEt = new b.b()
    {
      public final boolean aYn()
      {
        AppMethodBeat.i(43992);
        boolean bool = as.rK(as.jEp);
        AppMethodBeat.o(43992);
        return bool;
      }
    };
    AppMethodBeat.o(43996);
  }
  
  public static k.c aYi()
  {
    return jEq;
  }
  
  public static k.c aYj()
  {
    return jEr;
  }
  
  public static d.b aYk()
  {
    return jEs;
  }
  
  public static b.b aYl()
  {
    return jEt;
  }
  
  private static Boolean rJ(int paramInt)
  {
    AppMethodBeat.i(43993);
    Object localObject;
    if (paramInt == jEn)
    {
      localObject = ak.foy().getString("appbrandgame_open_wcwss", "");
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
    else if (paramInt == jEo)
    {
      localObject = ak.foy().getString("appbrandgame_open_cdnrequest", "");
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
    else if (paramInt == jEp)
    {
      localObject = ak.foy().getString("appbrandgame_open_cronetdownload", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.as
 * JD-Core Version:    0.7.0.1
 */