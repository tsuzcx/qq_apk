package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.List;

public final class r
  extends b
{
  private a xdN;
  
  public r(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112120);
    this.xdN = new a();
    AppMethodBeat.o(112120);
  }
  
  private Pair<String, String> Y(as paramas)
  {
    AppMethodBeat.i(112122);
    com.tencent.mm.openim.a.b localb = new com.tencent.mm.openim.a.b();
    localb.Sa(paramas.fvb);
    int i = 0;
    while (i < localb.jGV.size())
    {
      com.tencent.mm.openim.a.b.a locala = (com.tencent.mm.openim.a.b.a)localb.jGV.get(i);
      Iterator localIterator = locala.jGW.iterator();
      while (localIterator.hasNext())
      {
        String str = ((com.tencent.mm.openim.a.b.b)localIterator.next()).Sb(paramas.field_openImAppid);
        if (!Util.isNullOrNil(str))
        {
          String[] arrayOfString = this.wWd.wWD;
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            if (str.contains(arrayOfString[j]))
            {
              paramas = new Pair(locala.title, str);
              AppMethodBeat.o(112122);
              return paramas;
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
    this.username = this.lqW.wVX;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.username);
    paramVarArgs = null;
    parama = null;
    int j = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    String str1 = d.arL(this.username);
    int i;
    switch (this.lqW.wVW)
    {
    default: 
      i = 0;
      bool2 = bool5;
      bool3 = bool4;
      if (j != 0)
      {
        this.pqB = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, str1, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        this.pqB = com.tencent.mm.plugin.fts.a.f.a(e.a(this.pqB, this.wWd, bool3, bool2, com.tencent.mm.plugin.fts.ui.b.a.wZP, b.c.wZW)).wWu;
        if (i != 0)
        {
          this.pqC = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, parama, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
          this.pqC = com.tencent.mm.plugin.fts.a.f.a(e.a(this.pqC, this.wWd, bool3, bool2, com.tencent.mm.plugin.fts.ui.b.a.wZP, b.c.wZY)).wWu;
          this.pqC = TextUtils.concat(new CharSequence[] { paramVarArgs, this.pqC });
        }
        if (!as.bjp(this.contact.field_username)) {
          break label961;
        }
        this.xcu = ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).bN(this.contact.field_openImAppid, this.contact.field_descWordingId);
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
      paramVarArgs = paramContext.getString(2131765066);
      i = 1;
      break;
      parama = this.contact.fuR;
      paramVarArgs = paramContext.getString(2131765061);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      paramVarArgs = this.contact.ajx();
      parama = paramVarArgs;
      if (Util.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      paramVarArgs = paramContext.getString(2131765071);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      parama = this.lqW.content;
      String[] arrayOfString;
      int k;
      if (!Util.isNullOrNil(parama))
      {
        arrayOfString = parama.split("​");
        k = arrayOfString.length;
        i = 0;
        label549:
        if (i < k)
        {
          paramVarArgs = arrayOfString[i];
          if (paramVarArgs.startsWith(this.wWd.wWB)) {
            parama = paramVarArgs;
          }
        }
      }
      for (;;)
      {
        paramVarArgs = paramContext.getString(2131765065);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        i += 1;
        break label549;
        parama = this.lqW.content;
        paramVarArgs = paramContext.getString(2131765067);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = this.lqW.content;
        paramVarArgs = paramContext.getString(2131765060);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = ((n)g.ah(n.class)).getFTSMainDB().aym(this.contact.field_contactLabelIds);
        paramVarArgs = new StringBuffer();
        arrayOfString = this.wWd.wWD;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          String str2 = arrayOfString[i];
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            if (d.ayq(str3).contains(str2))
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
          paramVarArgs = paramContext.getString(2131765070);
          i = 1;
          bool3 = bool4;
          bool2 = bool5;
          break;
        }
        paramVarArgs = Y(this.contact);
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
        this.pqB = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, str1, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        break label265;
        label961:
        this.xcu = "";
        AppMethodBeat.o(112121);
        return;
      }
      bool2 = false;
      break label393;
      bool2 = false;
    }
  }
  
  public final a.b axc()
  {
    return this.xdN;
  }
  
  public final String bCR()
  {
    AppMethodBeat.i(112123);
    if ((this.contact != null) && (as.bjp(this.contact.field_username)))
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
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(235406);
      paramVarArgs = (r)paramVarArgs;
      if ((ab.Jx(paramVarArgs.username)) && (!WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(235406);
        return true;
      }
      if (((as.bjp(paramVarArgs.username)) || (ab.Iy(paramVarArgs.username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(235406);
        return true;
      }
      a(r.this.wWd.wWB, paramVarArgs.lqW);
      paramView = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      paramView.putExtra("chat_from_scene", 5);
      c.f(paramContext, ".ui.chatting.ChattingUI", paramView);
      ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).cV(paramVarArgs.username, 2);
      AppMethodBeat.o(235406);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.r
 * JD-Core Version:    0.7.0.1
 */