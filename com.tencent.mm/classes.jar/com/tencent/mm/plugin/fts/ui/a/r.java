package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
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
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.Iterator;
import java.util.List;

public final class r
  extends b
{
  private r.a mZP;
  
  public r(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(62036);
    this.mZP = new r.a(this);
    AppMethodBeat.o(62036);
  }
  
  private Pair<String, String> K(ad paramad)
  {
    AppMethodBeat.i(62038);
    c localc = new c();
    localc.wl(paramad.dre);
    int i = 0;
    while (i < localc.gfG.size())
    {
      c.a locala = (c.a)localc.gfG.get(i);
      Iterator localIterator = locala.gfH.iterator();
      while (localIterator.hasNext())
      {
        String str = ((c.b)localIterator.next()).wm(paramad.field_openImAppid);
        if (!bo.isNullOrNil(str))
        {
          String[] arrayOfString = this.mRX.mSy;
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            if (str.contains(arrayOfString[j]))
            {
              paramad = new Pair(locala.title, str);
              AppMethodBeat.o(62038);
              return paramad;
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(62038);
    return null;
  }
  
  public final a.b Pr()
  {
    return this.mZP;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(62037);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.hrL.mRV;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.username);
    paramVarArgs = null;
    parama = null;
    int j = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    String str1 = com.tencent.mm.plugin.fts.a.d.NA(this.username);
    int i;
    switch (this.hrL.mRU)
    {
    default: 
      i = 0;
      bool2 = bool5;
      bool3 = bool4;
      if (j != 0)
      {
        this.jVn = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, str1, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
        this.jVn = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.jVn, this.mRX, bool3, bool2, b.a.mVP, b.c.mVW)).mSp;
        if (i != 0)
        {
          this.jVo = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, parama, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
          this.jVo = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.jVo, this.mRX, bool3, bool2, b.a.mVP, b.c.mVY)).mSp;
          this.jVo = TextUtils.concat(new CharSequence[] { paramVarArgs, this.jVo });
        }
        if (!ad.arf(this.contact.field_username)) {
          break label961;
        }
        this.mYu = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.openim.a.b.class)).bd(this.contact.field_openImAppid, this.contact.field_descWordingId);
        AppMethodBeat.o(62037);
      }
      break;
    case 3: 
      label265:
      bool2 = true;
    }
    label393:
    for (bool1 = true;; bool1 = false)
    {
      j = 1;
      i = 0;
      bool3 = bool1;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = this.contact.field_nickname;
      paramVarArgs = paramContext.getString(2131302992);
      i = 1;
      break;
      parama = this.contact.dqT;
      paramVarArgs = paramContext.getString(2131302987);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      paramVarArgs = this.contact.Hq();
      parama = paramVarArgs;
      if (bo.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      paramVarArgs = paramContext.getString(2131302996);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      parama = this.hrL.content;
      String[] arrayOfString;
      int k;
      if (!bo.isNullOrNil(parama))
      {
        arrayOfString = parama.split("​");
        k = arrayOfString.length;
        i = 0;
        label549:
        if (i < k)
        {
          paramVarArgs = arrayOfString[i];
          if (paramVarArgs.startsWith(this.mRX.mSw)) {
            parama = paramVarArgs;
          }
        }
      }
      for (;;)
      {
        paramVarArgs = paramContext.getString(2131302991);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        i += 1;
        break label549;
        parama = this.hrL.content;
        paramVarArgs = paramContext.getString(2131302993);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = this.hrL.content;
        paramVarArgs = paramContext.getString(2131302986);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = ((n)com.tencent.mm.kernel.g.G(n.class)).getFTSMainDB().OW(this.contact.field_contactLabelIds);
        paramVarArgs = new StringBuffer();
        arrayOfString = this.mRX.mSy;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          String str2 = arrayOfString[i];
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.Pa(str3).contains(str2))
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
          paramVarArgs = paramContext.getString(2131302995);
          i = 1;
          bool3 = bool4;
          bool2 = bool5;
          break;
        }
        paramVarArgs = K(this.contact);
        if (paramVarArgs != null)
        {
          parama = (String)paramVarArgs.second;
          paramVarArgs = (String)paramVarArgs.first + "：";
          i = 1;
          bool3 = bool4;
          bool2 = bool5;
          break;
        }
        i = 1;
        parama = "";
        paramVarArgs = "";
        bool3 = bool4;
        bool2 = bool5;
        break;
        this.jVn = com.tencent.mm.pluginsdk.ui.d.j.d(paramContext, str1, com.tencent.mm.cb.a.ao(paramContext, 2131427809));
        break label265;
        label961:
        this.mYu = "";
        AppMethodBeat.o(62037);
        return;
      }
      bool2 = false;
      break label393;
      bool2 = false;
    }
  }
  
  public final String aAo()
  {
    AppMethodBeat.i(62039);
    if ((this.contact != null) && (ad.arf(this.contact.field_username)))
    {
      String str = "openim:" + this.contact.field_openImAppid;
      AppMethodBeat.o(62039);
      return str;
    }
    AppMethodBeat.o(62039);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.r
 * JD-Core Version:    0.7.0.1
 */