package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.o.b.b;
import com.tencent.mm.plugin.appbrand.o.d.b;
import com.tencent.mm.plugin.appbrand.o.k.c;
import com.tencent.mm.plugin.appbrand.q.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class ar
{
  private static int jBt;
  private static int jBu;
  private static int jBv;
  private static k.c jBw;
  private static k.c jBx;
  private static d.b jBy;
  private static b.b jBz;
  
  static
  {
    AppMethodBeat.i(43996);
    jBt = 1;
    jBu = 2;
    jBv = 3;
    jBw = new k.c()
    {
      public final boolean KN(String paramAnonymousString)
      {
        AppMethodBeat.i(43986);
        if (c.SU(paramAnonymousString))
        {
          ad.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
          AppMethodBeat.o(43986);
          return true;
        }
        boolean bool = ar.rI(ar.jBt);
        AppMethodBeat.o(43986);
        return bool;
      }
      
      public final boolean aXT()
      {
        AppMethodBeat.i(43987);
        boolean bool = ar.rJ(ar.jBt);
        AppMethodBeat.o(43987);
        return bool;
      }
    };
    jBx = new k.c()
    {
      public final boolean KN(String paramAnonymousString)
      {
        AppMethodBeat.i(43988);
        boolean bool = ar.rI(ar.jBt);
        AppMethodBeat.o(43988);
        return bool;
      }
      
      public final boolean aXT()
      {
        AppMethodBeat.i(43989);
        boolean bool = ar.rJ(ar.jBt);
        AppMethodBeat.o(43989);
        return bool;
      }
    };
    jBy = new d.b()
    {
      public final boolean aXT()
      {
        AppMethodBeat.i(43991);
        boolean bool = ar.rJ(ar.jBu);
        AppMethodBeat.o(43991);
        return bool;
      }
      
      public final boolean aXU()
      {
        AppMethodBeat.i(43990);
        boolean bool = ar.rI(ar.jBu);
        AppMethodBeat.o(43990);
        return bool;
      }
    };
    jBz = new b.b()
    {
      public final boolean aXU()
      {
        AppMethodBeat.i(43992);
        boolean bool = ar.rI(ar.jBv);
        AppMethodBeat.o(43992);
        return bool;
      }
    };
    AppMethodBeat.o(43996);
  }
  
  public static k.c aXP()
  {
    return jBw;
  }
  
  public static k.c aXQ()
  {
    return jBx;
  }
  
  public static d.b aXR()
  {
    return jBy;
  }
  
  public static b.b aXS()
  {
    return jBz;
  }
  
  private static Boolean rH(int paramInt)
  {
    AppMethodBeat.i(43993);
    Object localObject;
    if (paramInt == jBt)
    {
      localObject = aj.fkE().getString("appbrandgame_open_wcwss", "");
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
    else if (paramInt == jBu)
    {
      localObject = aj.fkE().getString("appbrandgame_open_cdnrequest", "");
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
    else if (paramInt == jBv)
    {
      localObject = aj.fkE().getString("appbrandgame_open_cronetdownload", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ar
 * JD-Core Version:    0.7.0.1
 */