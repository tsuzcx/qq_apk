package com.tencent.mm.model;

import android.content.res.Resources;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class r
{
  private static Set<String> dUR = new HashSet();
  
  public static String a(ad paramad, String paramString)
  {
    return s.a(paramad, paramString);
  }
  
  public static String a(ad paramad, String paramString, boolean paramBoolean)
  {
    if (paramad == null) {}
    do
    {
      return paramString;
      if ((paramBoolean) && (bk.bl(paramad.field_nickname))) {
        return ((c)g.r(c.class)).FF().gV(paramString);
      }
      if ((paramad.Bq() != null) && (paramad.Bq().length() > 0)) {
        return paramad.Bq();
      }
    } while ((!bk.bl(paramad.field_nickname)) || (!s.hT(paramString)));
    return a.ft(paramString);
  }
  
  public static String c(ad paramad)
  {
    Object localObject = gV(paramad.field_username);
    if ((!s.fn(paramad.field_username)) || (!((String)localObject).equals(paramad.field_username))) {
      return localObject;
    }
    localObject = ((c)g.r(c.class)).FF().ir(paramad.field_username);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramad = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramad.add(gV((String)((Iterator)localObject).next()));
      }
      return "(" + bk.c(paramad, ", ") + ")";
    }
    return ae.getResources().getString(b.c.address_chatroom_contact_nick);
  }
  
  public static void c(Set<String> paramSet)
  {
    dUR = paramSet;
  }
  
  public static String gT(String paramString)
  {
    ad localad = ((j)g.r(j.class)).Fw().abl(paramString);
    if (localad == null) {}
    while (bk.bl(localad.field_nickname)) {
      return paramString;
    }
    return localad.field_nickname;
  }
  
  public static String gU(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.length() <= 0)) {
      str = "";
    }
    ad localad;
    do
    {
      do
      {
        do
        {
          return str;
          localad = ((j)g.r(j.class)).Fw().abl(paramString);
          y.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[] { paramString });
          str = paramString;
        } while (localad == null);
        if ((s.fn(paramString)) && (bk.bl(localad.field_nickname)))
        {
          str = ((c)g.r(c.class)).FF().gV(paramString);
          if (!bk.bl(str)) {
            return str;
          }
        }
        str = paramString;
      } while (localad.Bp() == null);
      str = paramString;
    } while (localad.Bp().length() <= 0);
    return localad.Bp();
  }
  
  public static String gV(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    return s.a(((j)g.r(j.class)).Fw().abl(paramString), paramString);
  }
  
  public static String gW(String paramString)
  {
    paramString = ((j)g.r(j.class)).Fw().abl(paramString);
    if (paramString == null) {
      return "";
    }
    if (!bk.bl(paramString.field_conRemark)) {
      return paramString.field_conRemark;
    }
    return "";
  }
  
  public static String gX(String paramString)
  {
    String str = paramString;
    if (dUR.contains(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static String getDisplayName(String paramString1, String paramString2)
  {
    Object localObject;
    if (bk.bl(paramString2)) {
      localObject = gV(paramString1);
    }
    do
    {
      String str;
      do
      {
        return localObject;
        str = gW(paramString1);
        localObject = str;
      } while (!bk.bl(str));
      paramString2 = m.P(paramString1, paramString2);
      localObject = paramString2;
    } while (!bk.bl(paramString2));
    return gV(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.r
 * JD-Core Version:    0.7.0.1
 */