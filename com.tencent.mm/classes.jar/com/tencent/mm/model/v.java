package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class v
{
  private static Set<String> hmL;
  
  static
  {
    AppMethodBeat.i(90684);
    hmL = new HashSet();
    AppMethodBeat.o(90684);
  }
  
  public static String a(com.tencent.mm.storage.ai paramai, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(90680);
    if (paramai == null)
    {
      AppMethodBeat.o(90680);
      return paramString;
    }
    if ((paramBoolean) && (bs.isNullOrNil(paramai.field_nickname)) && (bs.isNullOrNil(paramai.field_conRemark)))
    {
      paramai = ((c)g.ab(c.class)).awK().wk(paramString);
      AppMethodBeat.o(90680);
      return paramai;
    }
    if ((paramai.aaS() != null) && (paramai.aaS().length() > 0))
    {
      paramai = paramai.aaS();
      AppMethodBeat.o(90680);
      return paramai;
    }
    if ((bs.isNullOrNil(paramai.field_nickname)) && (w.xp(paramString)))
    {
      paramai = b.sW(paramString);
      AppMethodBeat.o(90680);
      return paramai;
    }
    if (w.wF(paramString))
    {
      AppMethodBeat.o(90680);
      return " ";
    }
    AppMethodBeat.o(90680);
    return paramString;
  }
  
  public static String b(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(90681);
    Object localObject = wk(paramai.field_username);
    if (w.sQ(paramai.field_username))
    {
      if ((localObject != null) && (!((String)localObject).equals(paramai.field_username)))
      {
        AppMethodBeat.o(90681);
        return localObject;
      }
      localObject = ((c)g.ab(c.class)).awK().xR(paramai.field_username);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramai = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          paramai.add(wk((String)((Iterator)localObject).next()));
        }
        paramai = "(" + bs.n(paramai, ", ") + ")";
        AppMethodBeat.o(90681);
        return paramai;
      }
      paramai = com.tencent.mm.sdk.platformtools.ai.getResources().getString(2131755178);
      AppMethodBeat.o(90681);
      return paramai;
    }
    AppMethodBeat.o(90681);
    return localObject;
  }
  
  public static String b(com.tencent.mm.storage.ai paramai, String paramString)
  {
    AppMethodBeat.i(186094);
    paramai = a(paramai, paramString, w.sQ(paramString));
    AppMethodBeat.o(186094);
    return paramai;
  }
  
  public static void b(Set<String> paramSet)
  {
    hmL = paramSet;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    AppMethodBeat.i(90676);
    if (bs.isNullOrNil(paramString2))
    {
      paramString1 = wk(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    String str = wl(paramString1);
    if (!bs.isNullOrNil(str))
    {
      AppMethodBeat.o(90676);
      return str;
    }
    paramString2 = q.ae(paramString1, paramString2);
    if (bs.isNullOrNil(paramString2))
    {
      paramString1 = wk(paramString1);
      AppMethodBeat.o(90676);
      return paramString1;
    }
    AppMethodBeat.o(90676);
    return paramString2;
  }
  
  public static String wi(String paramString)
  {
    AppMethodBeat.i(90675);
    com.tencent.mm.storage.ai localai = ((k)g.ab(k.class)).awB().aNt(paramString);
    if (localai == null)
    {
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (!bs.isNullOrNil(localai.field_nickname))
    {
      paramString = localai.field_nickname;
      AppMethodBeat.o(90675);
      return paramString;
    }
    if (w.wF(paramString))
    {
      AppMethodBeat.o(90675);
      return " ";
    }
    AppMethodBeat.o(90675);
    return paramString;
  }
  
  public static String wj(String paramString)
  {
    AppMethodBeat.i(90677);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90677);
      return "";
    }
    com.tencent.mm.storage.ai localai = ((k)g.ab(k.class)).awB().aNt(paramString);
    ac.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
    if (localai == null)
    {
      AppMethodBeat.o(90677);
      return paramString;
    }
    if ((w.sQ(paramString)) && (bs.isNullOrNil(localai.field_nickname)))
    {
      String str = ((c)g.ab(c.class)).awK().wk(paramString);
      if (!bs.isNullOrNil(str))
      {
        AppMethodBeat.o(90677);
        return str;
      }
    }
    if ((localai.aaR() != null) && (localai.aaR().length() > 0))
    {
      paramString = localai.aaR();
      AppMethodBeat.o(90677);
      return paramString;
    }
    if (w.wF(paramString))
    {
      AppMethodBeat.o(90677);
      return " ";
    }
    AppMethodBeat.o(90677);
    return paramString;
  }
  
  public static String wk(String paramString)
  {
    AppMethodBeat.i(90678);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      AppMethodBeat.o(90678);
      return "";
    }
    paramString = b(((k)g.ab(k.class)).awB().aNt(paramString), paramString);
    AppMethodBeat.o(90678);
    return paramString;
  }
  
  public static String wl(String paramString)
  {
    AppMethodBeat.i(90682);
    paramString = ((k)g.ab(k.class)).awB().aNt(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(90682);
      return "";
    }
    if (!bs.isNullOrNil(paramString.field_conRemark))
    {
      paramString = paramString.field_conRemark;
      AppMethodBeat.o(90682);
      return paramString;
    }
    AppMethodBeat.o(90682);
    return "";
  }
  
  public static String wm(String paramString)
  {
    AppMethodBeat.i(90683);
    if (hmL.contains(paramString))
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