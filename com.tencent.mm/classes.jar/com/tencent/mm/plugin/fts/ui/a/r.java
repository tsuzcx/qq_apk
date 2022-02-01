package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.a.c;
import com.tencent.mm.openim.a.c.a;
import com.tencent.mm.openim.a.c.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.List;

public final class r
  extends b
{
  private a tBW;
  
  public r(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112120);
    this.tBW = new a();
    AppMethodBeat.o(112120);
  }
  
  private Pair<String, String> R(am paramam)
  {
    AppMethodBeat.i(112122);
    c localc = new c();
    localc.IE(paramam.ePN);
    int i = 0;
    while (i < localc.iHw.size())
    {
      c.a locala = (c.a)localc.iHw.get(i);
      Iterator localIterator = locala.iHx.iterator();
      while (localIterator.hasNext())
      {
        String str = ((c.b)localIterator.next()).IF(paramam.field_openImAppid);
        if (!bt.isNullOrNil(str))
        {
          String[] arrayOfString = this.tun.tuN;
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            if (str.contains(arrayOfString[j]))
            {
              paramam = new Pair(locala.title, str);
              AppMethodBeat.o(112122);
              return paramam;
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(112122);
    return null;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112121);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.kjY.tuh;
    this.contact = ((l)g.ab(l.class)).azp().Bf(this.username);
    paramVarArgs = null;
    parama = null;
    int j = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    String str1 = com.tencent.mm.plugin.fts.a.d.agg(this.username);
    int i;
    switch (this.kjY.tug)
    {
    default: 
      i = 0;
      bool2 = bool5;
      bool3 = bool4;
      if (j != 0)
      {
        this.nZU = k.d(paramContext, str1, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
        this.nZU = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nZU, this.tun, bool3, bool2, b.a.txZ, b.c.tyg)).tuE;
        if (i != 0)
        {
          this.nZV = k.d(paramContext, parama, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
          this.nZV = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nZV, this.tun, bool3, bool2, b.a.txZ, b.c.tyi)).tuE;
          this.nZV = TextUtils.concat(new CharSequence[] { paramVarArgs, this.nZV });
        }
        if (!am.aSQ(this.contact.field_username)) {
          break label961;
        }
        this.tAC = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bC(this.contact.field_openImAppid, this.contact.field_descWordingId);
        AppMethodBeat.o(112121);
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
      paramVarArgs = paramContext.getString(2131762930);
      i = 1;
      break;
      parama = this.contact.ePD;
      paramVarArgs = paramContext.getString(2131762925);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      paramVarArgs = this.contact.VA();
      parama = paramVarArgs;
      if (bt.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      paramVarArgs = paramContext.getString(2131762935);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      parama = this.kjY.content;
      String[] arrayOfString;
      int k;
      if (!bt.isNullOrNil(parama))
      {
        arrayOfString = parama.split("​");
        k = arrayOfString.length;
        i = 0;
        label549:
        if (i < k)
        {
          paramVarArgs = arrayOfString[i];
          if (paramVarArgs.startsWith(this.tun.tuL)) {
            parama = paramVarArgs;
          }
        }
      }
      for (;;)
      {
        paramVarArgs = paramContext.getString(2131762929);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        i += 1;
        break label549;
        parama = this.kjY.content;
        paramVarArgs = paramContext.getString(2131762931);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = this.kjY.content;
        paramVarArgs = paramContext.getString(2131762924);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = ((n)g.ad(n.class)).getFTSMainDB().akk(this.contact.field_contactLabelIds);
        paramVarArgs = new StringBuffer();
        arrayOfString = this.tun.tuN;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          String str2 = arrayOfString[i];
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.ako(str3).contains(str2))
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
          paramVarArgs = paramContext.getString(2131762934);
          i = 1;
          bool3 = bool4;
          bool2 = bool5;
          break;
        }
        paramVarArgs = R(this.contact);
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
        this.nZU = k.d(paramContext, str1, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
        break label265;
        label961:
        this.tAC = "";
        AppMethodBeat.o(112121);
        return;
      }
      bool2 = false;
      break label393;
      bool2 = false;
    }
  }
  
  public final a.b agC()
  {
    return this.tBW;
  }
  
  public final String bgV()
  {
    AppMethodBeat.i(112123);
    if ((this.contact != null) && (am.aSQ(this.contact.field_username)))
    {
      String str = "openim:" + this.contact.field_openImAppid;
      AppMethodBeat.o(112123);
      return str;
    }
    AppMethodBeat.o(112123);
    return "";
  }
  
  public final class a
    extends b.b
  {
    public a()
    {
      super();
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112119);
      paramVarArgs = (r)paramVarArgs;
      a(r.this.tun.tuL, paramVarArgs.kjY);
      com.tencent.mm.bs.d.f(paramContext, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true));
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).cM(paramVarArgs.username, 2);
      AppMethodBeat.o(112119);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.r
 * JD-Core Version:    0.7.0.1
 */