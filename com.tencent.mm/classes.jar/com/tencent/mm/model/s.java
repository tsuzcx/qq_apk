package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class s
{
  private static Set<String> fla;
  
  static
  {
    AppMethodBeat.i(136854);
    fla = new HashSet();
    AppMethodBeat.o(136854);
  }
  
  public static String a(ad paramad, String paramString)
  {
    AppMethodBeat.i(156754);
    paramad = t.a(paramad, paramString);
    AppMethodBeat.o(156754);
    return paramad;
  }
  
  public static String a(ad paramad, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(136850);
    if (paramad == null)
    {
      AppMethodBeat.o(136850);
      return paramString;
    }
    if ((paramBoolean) && (bo.isNullOrNil(paramad.field_nickname)))
    {
      paramad = ((c)g.E(c.class)).YJ().nE(paramString);
      AppMethodBeat.o(136850);
      return paramad;
    }
    if ((paramad.Of() != null) && (paramad.Of().length() > 0))
    {
      paramad = paramad.Of();
      AppMethodBeat.o(136850);
      return paramad;
    }
    if ((bo.isNullOrNil(paramad.field_nickname)) && (t.oC(paramString)))
    {
      paramad = a.lG(paramString);
      AppMethodBeat.o(136850);
      return paramad;
    }
    AppMethodBeat.o(136850);
    return paramString;
  }
  
  public static void b(Set<String> paramSet)
  {
    fla = paramSet;
  }
  
  public static String c(ad paramad)
  {
    AppMethodBeat.i(136851);
    Object localObject = nE(paramad.field_username);
    if (t.lA(paramad.field_username))
    {
      if (!((String)localObject).equals(paramad.field_username))
      {
        AppMethodBeat.o(136851);
        return localObject;
      }
      localObject = ((c)g.E(c.class)).YJ().oY(paramad.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramad = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramad.add(nE((String)((Iterator)localObject).next()));
        }
        paramad = "(" + bo.d(paramad, ", ") + ")";
        AppMethodBeat.o(136851);
        return paramad;
      }
      paramad = ah.getResources().getString(2131296450);
      AppMethodBeat.o(136851);
      return paramad;
    }
    AppMethodBeat.o(136851);
    return localObject;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(136846);
    if (bo.isNullOrNil(paramString2))
    {
      paramString1 = nE(paramString1);
      AppMethodBeat.o(136846);
      return paramString1;
    }
    String str = nF(paramString1);
    if (!bo.isNullOrNil(str))
    {
      AppMethodBeat.o(136846);
      return str;
    }
    paramString2 = n.af(paramString1, paramString2);
    if (bo.isNullOrNil(paramString2))
    {
      paramString1 = nE(paramString1);
      AppMethodBeat.o(136846);
      return paramString1;
    }
    AppMethodBeat.o(136846);
    return paramString2;
  }
  
  public static String nC(String paramString)
  {
    AppMethodBeat.i(136845);
    ad localad = ((j)g.E(j.class)).YA().arw(paramString);
    if (localad == null)
    {
      AppMethodBeat.o(136845);
      return paramString;
    }
    if (!bo.isNullOrNil(localad.field_nickname))
    {
      paramString = localad.field_nickname;
      AppMethodBeat.o(136845);
      return paramString;
    }
    AppMethodBeat.o(136845);
    return paramString;
  }
  
  public static String nD(String paramString)
  {
    AppMethodBeat.i(136847);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(136847);
      return "";
    }
    ad localad = ((j)g.E(j.class)).YA().arw(paramString);
    ab.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localad == null)
    {
      AppMethodBeat.o(136847);
      return paramString;
    }
    if ((t.lA(paramString)) && (bo.isNullOrNil(localad.field_nickname)))
    {
      String str = ((c)g.E(c.class)).YJ().nE(paramString);
      if (!bo.isNullOrNil(str))
      {
        AppMethodBeat.o(136847);
        return str;
      }
    }
    if ((localad.Oe() != null) && (localad.Oe().length() > 0))
    {
      paramString = localad.Oe();
      AppMethodBeat.o(136847);
      return paramString;
    }
    AppMethodBeat.o(136847);
    return paramString;
  }
  
  public static String nE(String paramString)
  {
    AppMethodBeat.i(136848);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(136848);
      return "";
    }
    paramString = t.a(((j)g.E(j.class)).YA().arw(paramString), paramString);
    AppMethodBeat.o(136848);
    return paramString;
  }
  
  public static String nF(String paramString)
  {
    AppMethodBeat.i(136852);
    paramString = ((j)g.E(j.class)).YA().arw(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(136852);
      return "";
    }
    if (!bo.isNullOrNil(paramString.field_conRemark))
    {
      paramString = paramString.field_conRemark;
      AppMethodBeat.o(136852);
      return paramString;
    }
    AppMethodBeat.o(136852);
    return "";
  }
  
  public static String nG(String paramString)
  {
    AppMethodBeat.i(136853);
    if (fla.contains(paramString))
    {
      AppMethodBeat.o(136853);
      return "";
    }
    AppMethodBeat.o(136853);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.s
 * JD-Core Version:    0.7.0.1
 */