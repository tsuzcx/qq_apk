package com.tencent.mm.plugin.appbrand;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.b.b;
import com.tencent.mm.plugin.appbrand.t.d.b;
import com.tencent.mm.plugin.appbrand.t.g.b;
import com.tencent.mm.plugin.appbrand.t.j.c;
import com.tencent.mm.plugin.appbrand.v.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class bl
{
  private static int qyE;
  private static int qyF;
  private static int qyG;
  private static int qyH;
  private static int qyI;
  private static j.c qyJ;
  private static j.c qyK;
  private static d.b qyL;
  private static d.b qyM;
  private static b.b qyN;
  private static g.b qyO;
  
  static
  {
    AppMethodBeat.i(43996);
    qyE = 1;
    qyF = 2;
    qyG = 3;
    qyH = 4;
    qyI = 5;
    qyJ = new j.c()
    {
      public final boolean UG(String paramAnonymousString)
      {
        AppMethodBeat.i(43986);
        if (c.ael(paramAnonymousString))
        {
          Log.i("MicroMsg.WcWssSwitchLogic", "isWcWssOpen : true for hardcode case");
          AppMethodBeat.o(43986);
          return true;
        }
        boolean bool = bl.yZ(bl.qyE);
        AppMethodBeat.o(43986);
        return bool;
      }
      
      public final boolean cdI()
      {
        AppMethodBeat.i(43987);
        boolean bool = bl.za(bl.qyE);
        AppMethodBeat.o(43987);
        return bool;
      }
    };
    qyK = new j.c()
    {
      public final boolean UG(String paramAnonymousString)
      {
        AppMethodBeat.i(43988);
        boolean bool = bl.yZ(bl.qyE);
        AppMethodBeat.o(43988);
        return bool;
      }
      
      public final boolean cdI()
      {
        AppMethodBeat.i(43989);
        boolean bool = bl.za(bl.qyE);
        AppMethodBeat.o(43989);
        return bool;
      }
    };
    qyL = new d.b()
    {
      public final boolean cdI()
      {
        AppMethodBeat.i(43991);
        boolean bool = bl.za(bl.qyF);
        AppMethodBeat.o(43991);
        return bool;
      }
      
      public final boolean cdJ()
      {
        AppMethodBeat.i(43990);
        boolean bool = bl.yZ(bl.qyF);
        AppMethodBeat.o(43990);
        return bool;
      }
      
      public final boolean cdK()
      {
        AppMethodBeat.i(316782);
        boolean bool = bl.yZ(bl.qyH);
        AppMethodBeat.o(316782);
        return bool;
      }
    };
    qyM = new d.b()
    {
      public final boolean cdI()
      {
        return true;
      }
      
      public final boolean cdJ()
      {
        AppMethodBeat.i(43992);
        AppMethodBeat.o(43992);
        return true;
      }
      
      public final boolean cdK()
      {
        AppMethodBeat.i(316790);
        boolean bool = bl.yZ(bl.qyH);
        AppMethodBeat.o(316790);
        return bool;
      }
    };
    qyN = new b.b()
    {
      public final boolean cdJ()
      {
        AppMethodBeat.i(316785);
        boolean bool = bl.yZ(bl.qyG);
        AppMethodBeat.o(316785);
        return bool;
      }
    };
    qyO = new g.b()
    {
      public final boolean cdJ()
      {
        AppMethodBeat.i(316781);
        boolean bool = bl.yZ(bl.cdH());
        AppMethodBeat.o(316781);
        return bool;
      }
    };
    AppMethodBeat.o(43996);
  }
  
  public static j.c cdB()
  {
    return qyJ;
  }
  
  public static j.c cdC()
  {
    return qyK;
  }
  
  public static d.b cdD()
  {
    return qyL;
  }
  
  public static d.b cdE()
  {
    return qyM;
  }
  
  public static b.b cdF()
  {
    return qyN;
  }
  
  public static g.b cdG()
  {
    return qyO;
  }
  
  private static Boolean yY(int paramInt)
  {
    AppMethodBeat.i(43993);
    Object localObject;
    if (paramInt == qyE)
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
    else if (paramInt == qyF)
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
    else if (paramInt == qyG)
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
    else if (paramInt == qyH)
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
    else if (paramInt == qyI)
    {
      localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_cronetupload", "");
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.bl
 * JD-Core Version:    0.7.0.1
 */