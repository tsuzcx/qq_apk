package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.b.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class aa
{
  private static Set<String> ojV;
  
  static
  {
    AppMethodBeat.i(90684);
    ojV = new HashSet();
    AppMethodBeat.o(90684);
  }
  
  public static String IC(String paramString)
  {
    AppMethodBeat.i(90675);
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    if (localau == null)
    {
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (!Util.isNullOrNil(localau.field_nickname))
    {
      paramString = localau.field_nickname;
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (!Util.isNullOrNil(localau.aJs()))
    {
      paramString = localau.aJs();
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (au.bxa(paramString))
    {
      AppMethodBeat.o(90675);
      return " ";
    }
    AppMethodBeat.o(90675);
    return paramString;
  }
  
  public static String ID(String paramString)
  {
    AppMethodBeat.i(90677);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90677);
      return "";
    }
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    Log.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localau == null)
    {
      AppMethodBeat.o(90677);
      return paramString;
    }
    if ((au.bwE(paramString)) && (Util.isNullOrNil(localau.field_nickname)))
    {
      String str = ((b)h.ax(b.class)).bzK().getDisplayName(paramString);
      if (!Util.isNullOrNil(str))
      {
        AppMethodBeat.o(90677);
        return str;
      }
    }
    if ((localau.aSU() != null) && (localau.aSU().length() > 0))
    {
      paramString = localau.aSU();
      AppMethodBeat.o(90677);
      return paramString;
    }
    if (au.bxa(paramString))
    {
      AppMethodBeat.o(90677);
      return " ";
    }
    AppMethodBeat.o(90677);
    return paramString;
  }
  
  public static String IE(String paramString)
  {
    AppMethodBeat.i(90682);
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
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
  
  public static String IF(String paramString)
  {
    AppMethodBeat.i(90683);
    if (ojV.contains(paramString))
    {
      AppMethodBeat.o(90683);
      return "";
    }
    AppMethodBeat.o(90683);
    return paramString;
  }
  
  public static String a(au paramau, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90680);
    if (paramau == null)
    {
      AppMethodBeat.o(90680);
      return paramString;
    }
    if ((paramBoolean) && (Util.isNullOrNil(paramau.field_nickname)) && (Util.isNullOrNil(paramau.field_conRemark)))
    {
      paramau = ((b)h.ax(b.class)).bzK();
      if ((Util.isNullOrNil(paramau.getDisplayName(paramString))) && (v.Iw(paramString)))
      {
        paramau = v.bAE();
        AppMethodBeat.o(90680);
        return paramau;
      }
      paramau = paramau.getDisplayName(paramString);
      AppMethodBeat.o(90680);
      return paramau;
    }
    if ((paramau.aSV() != null) && (paramau.aSV().length() > 0))
    {
      paramau = paramau.aSV();
      AppMethodBeat.o(90680);
      return paramau;
    }
    if ((Util.isNullOrNil(paramau.field_nickname)) && (au.bwy(paramString)))
    {
      paramau = d.DW(paramString);
      AppMethodBeat.o(90680);
      return paramau;
    }
    if (au.bxa(paramString))
    {
      AppMethodBeat.o(90680);
      return " ";
    }
    AppMethodBeat.o(90680);
    return paramString;
  }
  
  public static String aV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90676);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = getDisplayName(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    String str = IE(paramString1);
    if (!Util.isNullOrNil(str))
    {
      AppMethodBeat.o(90676);
      return str;
    }
    paramString2 = v.aq(paramString1, paramString2);
    if (Util.isNullOrNil(paramString2))
    {
      paramString1 = getDisplayName(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    AppMethodBeat.o(90676);
    return paramString2;
  }
  
  public static String b(au paramau)
  {
    AppMethodBeat.i(90681);
    Object localObject = getDisplayName(paramau.field_username);
    if (au.bwE(paramau.field_username))
    {
      if ((localObject != null) && (!((String)localObject).equals(paramau.field_username)))
      {
        AppMethodBeat.o(90681);
        return localObject;
      }
      localObject = ((b)h.ax(b.class)).bzK().Jy(paramau.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramau = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramau.add(getDisplayName((String)((Iterator)localObject).next()));
        }
        paramau = "(" + Util.listToString(paramau, ", ") + ")";
        AppMethodBeat.o(90681);
        return paramau;
      }
      paramau = MMApplicationContext.getResources().getString(b.e.address_chatroom_contact_nick);
      AppMethodBeat.o(90681);
      return paramau;
    }
    AppMethodBeat.o(90681);
    return localObject;
  }
  
  public static String b(au paramau, String paramString)
  {
    AppMethodBeat.i(186094);
    paramau = a(paramau, paramString, au.bwE(paramString));
    AppMethodBeat.o(186094);
    return paramau;
  }
  
  public static String getDisplayName(String paramString)
  {
    AppMethodBeat.i(90678);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90678);
      return "";
    }
    paramString = b(((n)h.ax(n.class)).bzA().JE(paramString), paramString);
    AppMethodBeat.o(90678);
    return paramString;
  }
  
  public static void m(Set<String> paramSet)
  {
    ojV = paramSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.aa
 * JD-Core Version:    0.7.0.1
 */