package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class w
{
  private static Set<String> hHS;
  
  static
  {
    AppMethodBeat.i(90684);
    hHS = new HashSet();
    AppMethodBeat.o(90684);
  }
  
  public static String a(an paraman, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90680);
    if (paraman == null)
    {
      AppMethodBeat.o(90680);
      return paramString;
    }
    if ((paramBoolean) && (bu.isNullOrNil(paraman.field_nickname)) && (bu.isNullOrNil(paraman.field_conRemark)))
    {
      paraman = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().zP(paramString);
      AppMethodBeat.o(90680);
      return paraman;
    }
    if ((paraman.adG() != null) && (paraman.adG().length() > 0))
    {
      paraman = paraman.adG();
      AppMethodBeat.o(90680);
      return paraman;
    }
    if ((bu.isNullOrNil(paraman.field_nickname)) && (x.AW(paramString)))
    {
      paraman = com.tencent.mm.contact.c.wh(paramString);
      AppMethodBeat.o(90680);
      return paraman;
    }
    if (x.Am(paramString))
    {
      AppMethodBeat.o(90680);
      return " ";
    }
    AppMethodBeat.o(90680);
    return paramString;
  }
  
  public static String b(an paraman)
  {
    AppMethodBeat.i(90681);
    Object localObject = zP(paraman.field_username);
    if (x.wb(paraman.field_username))
    {
      if ((localObject != null) && (!((String)localObject).equals(paraman.field_username)))
      {
        AppMethodBeat.o(90681);
        return localObject;
      }
      localObject = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().BB(paraman.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paraman = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paraman.add(zP((String)((Iterator)localObject).next()));
        }
        paraman = "(" + bu.m(paraman, ", ") + ")";
        AppMethodBeat.o(90681);
        return paraman;
      }
      paraman = ak.getResources().getString(2131755178);
      AppMethodBeat.o(90681);
      return paraman;
    }
    AppMethodBeat.o(90681);
    return localObject;
  }
  
  public static String b(an paraman, String paramString)
  {
    AppMethodBeat.i(186094);
    paraman = a(paraman, paramString, x.wb(paramString));
    AppMethodBeat.o(186094);
    return paraman;
  }
  
  public static void f(Set<String> paramSet)
  {
    hHS = paramSet;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90676);
    if (bu.isNullOrNil(paramString2))
    {
      paramString1 = zP(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    String str = zQ(paramString1);
    if (!bu.isNullOrNil(str))
    {
      AppMethodBeat.o(90676);
      return str;
    }
    paramString2 = r.af(paramString1, paramString2);
    if (bu.isNullOrNil(paramString2))
    {
      paramString1 = zP(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    AppMethodBeat.o(90676);
    return paramString2;
  }
  
  public static String zN(String paramString)
  {
    AppMethodBeat.i(90675);
    an localan = ((l)g.ab(l.class)).azF().BH(paramString);
    if (localan == null)
    {
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (!bu.isNullOrNil(localan.field_nickname))
    {
      paramString = localan.field_nickname;
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (x.Am(paramString))
    {
      AppMethodBeat.o(90675);
      return " ";
    }
    AppMethodBeat.o(90675);
    return paramString;
  }
  
  public static String zO(String paramString)
  {
    AppMethodBeat.i(90677);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90677);
      return "";
    }
    an localan = ((l)g.ab(l.class)).azF().BH(paramString);
    ae.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localan == null)
    {
      AppMethodBeat.o(90677);
      return paramString;
    }
    if ((x.wb(paramString)) && (bu.isNullOrNil(localan.field_nickname)))
    {
      String str = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().zP(paramString);
      if (!bu.isNullOrNil(str))
      {
        AppMethodBeat.o(90677);
        return str;
      }
    }
    if ((localan.adF() != null) && (localan.adF().length() > 0))
    {
      paramString = localan.adF();
      AppMethodBeat.o(90677);
      return paramString;
    }
    if (x.Am(paramString))
    {
      AppMethodBeat.o(90677);
      return " ";
    }
    AppMethodBeat.o(90677);
    return paramString;
  }
  
  public static String zP(String paramString)
  {
    AppMethodBeat.i(90678);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90678);
      return "";
    }
    paramString = b(((l)g.ab(l.class)).azF().BH(paramString), paramString);
    AppMethodBeat.o(90678);
    return paramString;
  }
  
  public static String zQ(String paramString)
  {
    AppMethodBeat.i(90682);
    paramString = ((l)g.ab(l.class)).azF().BH(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(90682);
      return "";
    }
    if (!bu.isNullOrNil(paramString.field_conRemark))
    {
      paramString = paramString.field_conRemark;
      AppMethodBeat.o(90682);
      return paramString;
    }
    AppMethodBeat.o(90682);
    return "";
  }
  
  public static String zR(String paramString)
  {
    AppMethodBeat.i(90683);
    if (hHS.contains(paramString))
    {
      AppMethodBeat.o(90683);
      return "";
    }
    AppMethodBeat.o(90683);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.w
 * JD-Core Version:    0.7.0.1
 */