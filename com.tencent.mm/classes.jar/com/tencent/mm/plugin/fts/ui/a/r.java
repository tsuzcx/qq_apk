package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.b;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class r
  extends b
{
  private r.a kDT = new r.a(this);
  
  public r(int paramInt)
  {
    super(paramInt);
  }
  
  private Pair<String, String> J(ad paramad)
  {
    c localc = new c();
    localc.oT(paramad.cCU);
    int i = 0;
    while (i < localc.ePL.size())
    {
      c.a locala = (c.a)localc.ePL.get(i);
      Iterator localIterator = locala.ePM.iterator();
      while (localIterator.hasNext())
      {
        String str = ((c.b)localIterator.next()).oU(paramad.field_openImAppid);
        if (!bk.bl(str))
        {
          String[] arrayOfString = this.kwi.kwI;
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            if (str.contains(arrayOfString[j])) {
              return new Pair(locala.title, str);
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    return null;
  }
  
  public final a.b BD()
  {
    return this.kDT;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    this.username = this.fYx.kwg;
    this.dnp = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(this.username);
    String str1 = com.tencent.mm.plugin.fts.a.d.Cy(this.username);
    boolean bool2;
    int j;
    int i;
    switch (this.fYx.kwf)
    {
    default: 
      bool2 = false;
      bool1 = false;
      j = 0;
      i = 0;
      parama = null;
      paramVarArgs = null;
    case 3: 
    case 7: 
      while (i != 0)
      {
        this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.aa(paramContext, n.b.NormalTextSize));
        this.ieA = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.ieA, this.kwi, bool1, bool2, b.a.kzX, b.c.kAe)).kwz;
        label239:
        if (j != 0)
        {
          this.ieB = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, parama, com.tencent.mm.cb.a.aa(paramContext, n.b.NormalTextSize));
          this.ieB = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.ieB, this.kwi, bool1, bool2, b.a.kzX, b.c.kAg)).kwz;
          this.ieB = TextUtils.concat(new CharSequence[] { paramVarArgs, this.ieB });
        }
        if (!ad.aaU(this.dnp.field_username)) {
          break label913;
        }
        this.kCx = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.openim.a.b.class)).aK(this.dnp.field_openImAppid, this.dnp.field_descWordingId);
        return;
        bool2 = true;
        label363:
        bool1 = true;
        label366:
        j = 0;
        i = 1;
        parama = null;
        paramVarArgs = null;
        continue;
        bool2 = true;
      }
    }
    label382:
    for (boolean bool1 = true;; bool1 = false)
    {
      parama = this.dnp.field_nickname;
      paramVarArgs = paramContext.getString(n.g.search_contact_tag_nickname);
      j = 1;
      i = 0;
      break;
      parama = this.dnp.cCJ;
      paramVarArgs = paramContext.getString(n.g.search_contact_tag_description);
      bool2 = false;
      bool1 = false;
      j = 1;
      i = 0;
      break;
      paramVarArgs = this.dnp.vk();
      parama = paramVarArgs;
      if (bk.bl(paramVarArgs)) {
        parama = this.dnp.field_username;
      }
      paramVarArgs = paramContext.getString(n.g.search_contact_tag_wxid);
      bool2 = false;
      bool1 = false;
      j = 1;
      i = 0;
      break;
      parama = this.fYx.content;
      String[] arrayOfString;
      if (!bk.bl(parama))
      {
        arrayOfString = parama.split("​");
        j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          paramVarArgs = arrayOfString[i];
          if (paramVarArgs.startsWith(this.kwi.kwG)) {
            parama = paramVarArgs;
          }
        }
      }
      for (;;)
      {
        paramVarArgs = paramContext.getString(n.g.search_contact_tag_mobile);
        bool2 = false;
        bool1 = false;
        j = 1;
        i = 0;
        break;
        i += 1;
        break label521;
        parama = this.fYx.content;
        paramVarArgs = paramContext.getString(n.g.search_contact_tag_province);
        bool2 = false;
        bool1 = false;
        j = 1;
        i = 0;
        break;
        parama = this.fYx.content;
        paramVarArgs = paramContext.getString(n.g.search_contact_tag_city);
        bool2 = false;
        bool1 = false;
        j = 1;
        i = 0;
        break;
        parama = ((n)com.tencent.mm.kernel.g.t(n.class)).getFTSMainDB().DN(this.dnp.field_contactLabelIds);
        paramVarArgs = new StringBuffer();
        arrayOfString = this.kwi.kwI;
        j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          String str2 = arrayOfString[i];
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.DR(str3).contains(str2))
            {
              paramVarArgs.append(str3);
              paramVarArgs.append(",");
            }
          }
          i += 1;
        }
        paramVarArgs.trimToSize();
        if (paramVarArgs.length() == 0) {}
        for (parama = "";; parama = paramVarArgs.substring(0, paramVarArgs.length() - 1))
        {
          paramVarArgs = paramContext.getString(n.g.search_contact_tag_tag);
          bool2 = false;
          bool1 = false;
          j = 1;
          i = 0;
          break;
        }
        paramVarArgs = J(this.dnp);
        parama = (String)paramVarArgs.second;
        paramVarArgs = (String)paramVarArgs.first + "：";
        bool2 = false;
        bool1 = false;
        j = 1;
        i = 0;
        break;
        this.ieA = com.tencent.mm.pluginsdk.ui.d.j.b(paramContext, str1, com.tencent.mm.cb.a.aa(paramContext, n.b.NormalTextSize));
        break label239;
        this.kCx = "";
        return;
      }
      bool2 = false;
      break label363;
      bool2 = false;
      bool1 = false;
      break label366;
      bool2 = false;
      break label382;
      bool2 = false;
    }
  }
  
  public final String afL()
  {
    if ((this.dnp != null) && (ad.aaU(this.dnp.field_username))) {
      return "openim:" + this.dnp.field_openImAppid;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.r
 * JD-Core Version:    0.7.0.1
 */