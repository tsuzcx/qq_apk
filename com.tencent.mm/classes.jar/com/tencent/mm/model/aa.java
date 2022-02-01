package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class aa
{
  private static Set<String> iCC;
  
  static
  {
    AppMethodBeat.i(90684);
    iCC = new HashSet();
    AppMethodBeat.o(90684);
  }
  
  public static String Iq(String paramString)
  {
    AppMethodBeat.i(90675);
    as localas = ((l)g.af(l.class)).aSN().Kn(paramString);
    if (localas == null)
    {
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (!Util.isNullOrNil(localas.field_nickname))
    {
      paramString = localas.field_nickname;
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (ab.IR(paramString))
    {
      AppMethodBeat.o(90675);
      return " ";
    }
    AppMethodBeat.o(90675);
    return paramString;
  }
  
  public static String Ir(String paramString)
  {
    AppMethodBeat.i(90677);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90677);
      return "";
    }
    as localas = ((l)g.af(l.class)).aSN().Kn(paramString);
    Log.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localas == null)
    {
      AppMethodBeat.o(90677);
      return paramString;
    }
    if ((ab.Eq(paramString)) && (Util.isNullOrNil(localas.field_nickname)))
    {
      String str = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().getDisplayName(paramString);
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(90677);
        return str;
      }
    }
    if ((localas.arI() != null) && (localas.arI().length() > 0))
    {
      paramString = localas.arI();
      AppMethodBeat.o(90677);
      return paramString;
    }
    if (ab.IR(paramString))
    {
      AppMethodBeat.o(90677);
      return " ";
    }
    AppMethodBeat.o(90677);
    return paramString;
  }
  
  public static String Is(String paramString)
  {
    AppMethodBeat.i(90682);
    paramString = ((l)g.af(l.class)).aSN().Kn(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(90682);
      return "";
    }
    if (!Util.isNullOrNil(paramString.field_conRemark))
    {
      paramString = paramString.field_conRemark;
      AppMethodBeat.o(90682);
      return paramString;
    }
    AppMethodBeat.o(90682);
    return "";
  }
  
  public static String It(String paramString)
  {
    AppMethodBeat.i(90683);
    if (iCC.contains(paramString))
    {
      AppMethodBeat.o(90683);
      return "";
    }
    AppMethodBeat.o(90683);
    return paramString;
  }
  
  public static String a(as paramas, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90680);
    if (paramas == null)
    {
      AppMethodBeat.o(90680);
      return paramString;
    }
    if ((paramBoolean) && (Util.isNullOrNil(paramas.field_nickname)) && (Util.isNullOrNil(paramas.field_conRemark)))
    {
      paramas = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().getDisplayName(paramString);
      AppMethodBeat.o(90680);
      return paramas;
    }
    if ((paramas.arJ() != null) && (paramas.arJ().length() > 0))
    {
      paramas = paramas.arJ();
      AppMethodBeat.o(90680);
      return paramas;
    }
    if ((Util.isNullOrNil(paramas.field_nickname)) && (ab.JB(paramString)))
    {
      paramas = com.tencent.mm.contact.c.Ew(paramString);
      AppMethodBeat.o(90680);
      return paramas;
    }
    if (ab.IR(paramString))
    {
      AppMethodBeat.o(90680);
      return " ";
    }
    AppMethodBeat.o(90680);
    return paramString;
  }
  
  public static String b(as paramas)
  {
    AppMethodBeat.i(90681);
    Object localObject = getDisplayName(paramas.field_username);
    if (ab.Eq(paramas.field_username))
    {
      if ((localObject != null) && (!((String)localObject).equals(paramas.field_username)))
      {
        AppMethodBeat.o(90681);
        return localObject;
      }
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kh(paramas.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramas = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramas.add(getDisplayName((String)((Iterator)localObject).next()));
        }
        paramas = "(" + Util.listToString(paramas, ", ") + ")";
        AppMethodBeat.o(90681);
        return paramas;
      }
      paramas = MMApplicationContext.getResources().getString(2131755196);
      AppMethodBeat.o(90681);
      return paramas;
    }
    AppMethodBeat.o(90681);
    return localObject;
  }
  
  public static String b(as paramas, String paramString)
  {
    AppMethodBeat.i(186094);
    paramas = a(paramas, paramString, ab.Eq(paramString));
    AppMethodBeat.o(186094);
    return paramas;
  }
  
  public static void f(Set<String> paramSet)
  {
    iCC = paramSet;
  }
  
  public static String getDisplayName(String paramString)
  {
    AppMethodBeat.i(90678);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90678);
      return "";
    }
    paramString = b(((l)g.af(l.class)).aSN().Kn(paramString), paramString);
    AppMethodBeat.o(90678);
    return paramString;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90676);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = getDisplayName(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    String str = Is(paramString1);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(90676);
      return str;
    }
    paramString2 = v.ah(paramString1, paramString2);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = getDisplayName(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    AppMethodBeat.o(90676);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.aa
 * JD-Core Version:    0.7.0.1
 */