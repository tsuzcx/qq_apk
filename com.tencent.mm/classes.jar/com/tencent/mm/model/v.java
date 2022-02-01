package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class v
{
  private static Set<String> gMl;
  
  static
  {
    AppMethodBeat.i(90684);
    gMl = new HashSet();
    AppMethodBeat.o(90684);
  }
  
  public static String a(af paramaf, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90680);
    if (paramaf == null)
    {
      AppMethodBeat.o(90680);
      return paramString;
    }
    if ((paramBoolean) && (bt.isNullOrNil(paramaf.field_nickname)) && (bt.isNullOrNil(paramaf.field_conRemark)))
    {
      paramaf = ((c)g.ab(c.class)).apV().sh(paramString);
      AppMethodBeat.o(90680);
      return paramaf;
    }
    if ((paramaf.ZX() != null) && (paramaf.ZX().length() > 0))
    {
      paramaf = paramaf.ZX();
      AppMethodBeat.o(90680);
      return paramaf;
    }
    if ((bt.isNullOrNil(paramaf.field_nickname)) && (w.tm(paramString)))
    {
      paramaf = b.pL(paramString);
      AppMethodBeat.o(90680);
      return paramaf;
    }
    AppMethodBeat.o(90680);
    return paramString;
  }
  
  public static String b(af paramaf)
  {
    AppMethodBeat.i(90681);
    Object localObject = sh(paramaf.field_username);
    if (w.pF(paramaf.field_username))
    {
      if ((localObject != null) && (!((String)localObject).equals(paramaf.field_username)))
      {
        AppMethodBeat.o(90681);
        return localObject;
      }
      localObject = ((c)g.ab(c.class)).apV().tL(paramaf.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramaf = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramaf.add(sh((String)((Iterator)localObject).next()));
        }
        paramaf = "(" + bt.n(paramaf, ", ") + ")";
        AppMethodBeat.o(90681);
        return paramaf;
      }
      paramaf = com.tencent.mm.sdk.platformtools.aj.getResources().getString(2131755178);
      AppMethodBeat.o(90681);
      return paramaf;
    }
    AppMethodBeat.o(90681);
    return localObject;
  }
  
  public static String b(af paramaf, String paramString)
  {
    AppMethodBeat.i(186094);
    paramaf = a(paramaf, paramString, w.pF(paramString));
    AppMethodBeat.o(186094);
    return paramaf;
  }
  
  public static void b(Set<String> paramSet)
  {
    gMl = paramSet;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90676);
    if (bt.isNullOrNil(paramString2))
    {
      paramString1 = sh(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    String str = si(paramString1);
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(90676);
      return str;
    }
    paramString2 = q.ab(paramString1, paramString2);
    if (bt.isNullOrNil(paramString2))
    {
      paramString1 = sh(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    AppMethodBeat.o(90676);
    return paramString2;
  }
  
  public static String sf(String paramString)
  {
    AppMethodBeat.i(90675);
    af localaf = ((k)g.ab(k.class)).apM().aHY(paramString);
    if (localaf == null)
    {
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (!bt.isNullOrNil(localaf.field_nickname))
    {
      paramString = localaf.field_nickname;
      AppMethodBeat.o(90675);
      return paramString;
    }
    AppMethodBeat.o(90675);
    return paramString;
  }
  
  public static String sg(String paramString)
  {
    AppMethodBeat.i(90677);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90677);
      return "";
    }
    af localaf = ((k)g.ab(k.class)).apM().aHY(paramString);
    ad.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localaf == null)
    {
      AppMethodBeat.o(90677);
      return paramString;
    }
    if ((w.pF(paramString)) && (bt.isNullOrNil(localaf.field_nickname)))
    {
      String str = ((c)g.ab(c.class)).apV().sh(paramString);
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(90677);
        return str;
      }
    }
    if ((localaf.ZW() != null) && (localaf.ZW().length() > 0))
    {
      paramString = localaf.ZW();
      AppMethodBeat.o(90677);
      return paramString;
    }
    AppMethodBeat.o(90677);
    return paramString;
  }
  
  public static String sh(String paramString)
  {
    AppMethodBeat.i(90678);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90678);
      return "";
    }
    paramString = b(((k)g.ab(k.class)).apM().aHY(paramString), paramString);
    AppMethodBeat.o(90678);
    return paramString;
  }
  
  public static String si(String paramString)
  {
    AppMethodBeat.i(90682);
    paramString = ((k)g.ab(k.class)).apM().aHY(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(90682);
      return "";
    }
    if (!bt.isNullOrNil(paramString.field_conRemark))
    {
      paramString = paramString.field_conRemark;
      AppMethodBeat.o(90682);
      return paramString;
    }
    AppMethodBeat.o(90682);
    return "";
  }
  
  public static String sj(String paramString)
  {
    AppMethodBeat.i(90683);
    if (gMl.contains(paramString))
    {
      AppMethodBeat.o(90683);
      return "";
    }
    AppMethodBeat.o(90683);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.v
 * JD-Core Version:    0.7.0.1
 */