package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  private static Set<String> lsx;
  
  static
  {
    AppMethodBeat.i(90684);
    lsx = new HashSet();
    AppMethodBeat.o(90684);
  }
  
  public static String PH(String paramString)
  {
    AppMethodBeat.i(90675);
    as localas = ((n)h.ae(n.class)).bbL().RG(paramString);
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
    if (ab.Qk(paramString))
    {
      AppMethodBeat.o(90675);
      return " ";
    }
    AppMethodBeat.o(90675);
    return paramString;
  }
  
  public static String PI(String paramString)
  {
    AppMethodBeat.i(90677);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90677);
      return "";
    }
    as localas = ((n)h.ae(n.class)).bbL().RG(paramString);
    Log.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localas == null)
    {
      AppMethodBeat.o(90677);
      return paramString;
    }
    if ((ab.Lj(paramString)) && (Util.isNullOrNil(localas.field_nickname)))
    {
      String str = ((b)h.ae(b.class)).bbV().PJ(paramString);
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(90677);
        return str;
      }
    }
    if ((localas.ayr() != null) && (localas.ayr().length() > 0))
    {
      paramString = localas.ayr();
      AppMethodBeat.o(90677);
      return paramString;
    }
    if (ab.Qk(paramString))
    {
      AppMethodBeat.o(90677);
      return " ";
    }
    AppMethodBeat.o(90677);
    return paramString;
  }
  
  public static String PJ(String paramString)
  {
    AppMethodBeat.i(90678);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90678);
      return "";
    }
    paramString = b(((n)h.ae(n.class)).bbL().RG(paramString), paramString);
    AppMethodBeat.o(90678);
    return paramString;
  }
  
  public static String PK(String paramString)
  {
    AppMethodBeat.i(90682);
    paramString = ((n)h.ae(n.class)).bbL().RG(paramString);
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
  
  public static String PL(String paramString)
  {
    AppMethodBeat.i(90683);
    if (lsx.contains(paramString))
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
      paramas = ((b)h.ae(b.class)).bbV().PJ(paramString);
      AppMethodBeat.o(90680);
      return paramas;
    }
    if ((paramas.ays() != null) && (paramas.ays().length() > 0))
    {
      paramas = paramas.ays();
      AppMethodBeat.o(90680);
      return paramas;
    }
    if ((Util.isNullOrNil(paramas.field_nickname)) && (ab.QU(paramString)))
    {
      paramas = d.Lp(paramString);
      AppMethodBeat.o(90680);
      return paramas;
    }
    if (ab.Qk(paramString))
    {
      AppMethodBeat.o(90680);
      return " ";
    }
    AppMethodBeat.o(90680);
    return paramString;
  }
  
  public static String aL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90676);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = PJ(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    String str = PK(paramString1);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(90676);
      return str;
    }
    paramString2 = v.al(paramString1, paramString2);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = PJ(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    AppMethodBeat.o(90676);
    return paramString2;
  }
  
  public static String b(as paramas)
  {
    AppMethodBeat.i(90681);
    Object localObject = PJ(paramas.field_username);
    if (ab.Lj(paramas.field_username))
    {
      if ((localObject != null) && (!((String)localObject).equals(paramas.field_username)))
      {
        AppMethodBeat.o(90681);
        return localObject;
      }
      localObject = ((b)h.ae(b.class)).bbV().RA(paramas.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramas = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramas.add(PJ((String)((Iterator)localObject).next()));
        }
        paramas = "(" + Util.listToString(paramas, ", ") + ")";
        AppMethodBeat.o(90681);
        return paramas;
      }
      paramas = MMApplicationContext.getResources().getString(b.d.address_chatroom_contact_nick);
      AppMethodBeat.o(90681);
      return paramas;
    }
    AppMethodBeat.o(90681);
    return localObject;
  }
  
  public static String b(as paramas, String paramString)
  {
    AppMethodBeat.i(186094);
    paramas = a(paramas, paramString, ab.Lj(paramString));
    AppMethodBeat.o(186094);
    return paramas;
  }
  
  public static void f(Set<String> paramSet)
  {
    lsx = paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.aa
 * JD-Core Version:    0.7.0.1
 */