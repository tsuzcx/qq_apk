package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class v
{
  private static Set<String> hFa;
  
  static
  {
    AppMethodBeat.i(90684);
    hFa = new HashSet();
    AppMethodBeat.o(90684);
  }
  
  public static String a(am paramam, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90680);
    if (paramam == null)
    {
      AppMethodBeat.o(90680);
      return paramString;
    }
    if ((paramBoolean) && (bt.isNullOrNil(paramam.field_nickname)) && (bt.isNullOrNil(paramam.field_conRemark)))
    {
      paramam = ((c)g.ab(c.class)).azz().zf(paramString);
      AppMethodBeat.o(90680);
      return paramam;
    }
    if ((paramam.adv() != null) && (paramam.adv().length() > 0))
    {
      paramam = paramam.adv();
      AppMethodBeat.o(90680);
      return paramam;
    }
    if ((bt.isNullOrNil(paramam.field_nickname)) && (w.Am(paramString)))
    {
      paramam = b.vL(paramString);
      AppMethodBeat.o(90680);
      return paramam;
    }
    if (w.zC(paramString))
    {
      AppMethodBeat.o(90680);
      return " ";
    }
    AppMethodBeat.o(90680);
    return paramString;
  }
  
  public static String b(am paramam)
  {
    AppMethodBeat.i(90681);
    Object localObject = zf(paramam.field_username);
    if (w.vF(paramam.field_username))
    {
      if ((localObject != null) && (!((String)localObject).equals(paramam.field_username)))
      {
        AppMethodBeat.o(90681);
        return localObject;
      }
      localObject = ((c)g.ab(c.class)).azz().AR(paramam.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramam = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramam.add(zf((String)((Iterator)localObject).next()));
        }
        paramam = "(" + bt.m(paramam, ", ") + ")";
        AppMethodBeat.o(90681);
        return paramam;
      }
      paramam = aj.getResources().getString(2131755178);
      AppMethodBeat.o(90681);
      return paramam;
    }
    AppMethodBeat.o(90681);
    return localObject;
  }
  
  public static String b(am paramam, String paramString)
  {
    AppMethodBeat.i(186094);
    paramam = a(paramam, paramString, w.vF(paramString));
    AppMethodBeat.o(186094);
    return paramam;
  }
  
  public static void f(Set<String> paramSet)
  {
    hFa = paramSet;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90676);
    if (bt.isNullOrNil(paramString2))
    {
      paramString1 = zf(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    String str = zg(paramString1);
    if (!bt.isNullOrNil(str))
    {
      AppMethodBeat.o(90676);
      return str;
    }
    paramString2 = q.af(paramString1, paramString2);
    if (bt.isNullOrNil(paramString2))
    {
      paramString1 = zf(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    AppMethodBeat.o(90676);
    return paramString2;
  }
  
  public static String zd(String paramString)
  {
    AppMethodBeat.i(90675);
    am localam = ((l)g.ab(l.class)).azp().Bf(paramString);
    if (localam == null)
    {
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (!bt.isNullOrNil(localam.field_nickname))
    {
      paramString = localam.field_nickname;
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (w.zC(paramString))
    {
      AppMethodBeat.o(90675);
      return " ";
    }
    AppMethodBeat.o(90675);
    return paramString;
  }
  
  public static String ze(String paramString)
  {
    AppMethodBeat.i(90677);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90677);
      return "";
    }
    am localam = ((l)g.ab(l.class)).azp().Bf(paramString);
    ad.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localam == null)
    {
      AppMethodBeat.o(90677);
      return paramString;
    }
    if ((w.vF(paramString)) && (bt.isNullOrNil(localam.field_nickname)))
    {
      String str = ((c)g.ab(c.class)).azz().zf(paramString);
      if (!bt.isNullOrNil(str))
      {
        AppMethodBeat.o(90677);
        return str;
      }
    }
    if ((localam.adu() != null) && (localam.adu().length() > 0))
    {
      paramString = localam.adu();
      AppMethodBeat.o(90677);
      return paramString;
    }
    if (w.zC(paramString))
    {
      AppMethodBeat.o(90677);
      return " ";
    }
    AppMethodBeat.o(90677);
    return paramString;
  }
  
  public static String zf(String paramString)
  {
    AppMethodBeat.i(90678);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90678);
      return "";
    }
    paramString = b(((l)g.ab(l.class)).azp().Bf(paramString), paramString);
    AppMethodBeat.o(90678);
    return paramString;
  }
  
  public static String zg(String paramString)
  {
    AppMethodBeat.i(90682);
    paramString = ((l)g.ab(l.class)).azp().Bf(paramString);
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
  
  public static String zh(String paramString)
  {
    AppMethodBeat.i(90683);
    if (hFa.contains(paramString))
    {
      AppMethodBeat.o(90683);
      return "";
    }
    AppMethodBeat.o(90683);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.v
 * JD-Core Version:    0.7.0.1
 */