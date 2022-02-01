package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
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
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.List;

public final class r
  extends b
{
  private a rwm;
  
  public r(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112120);
    this.rwm = new a();
    AppMethodBeat.o(112120);
  }
  
  private Pair<String, String> Q(af paramaf)
  {
    AppMethodBeat.i(112122);
    c localc = new c();
    localc.Bj(paramaf.evS);
    int i = 0;
    while (i < localc.hND.size())
    {
      c.a locala = (c.a)localc.hND.get(i);
      Iterator localIterator = locala.hNE.iterator();
      while (localIterator.hasNext())
      {
        String str = ((c.b)localIterator.next()).Bk(paramaf.field_openImAppid);
        if (!bt.isNullOrNil(str))
        {
          String[] arrayOfString = this.roS.rps;
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            if (str.contains(arrayOfString[j]))
            {
              paramaf = new Pair(locala.title, str);
              AppMethodBeat.o(112122);
              return paramaf;
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
    this.username = this.jpy.roN;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.username);
    paramVarArgs = null;
    parama = null;
    int j = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    String str1 = com.tencent.mm.plugin.fts.a.d.XV(this.username);
    int i;
    switch (this.jpy.roM)
    {
    default: 
      i = 0;
      bool2 = bool5;
      bool3 = bool4;
      if (j != 0)
      {
        this.mVX = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, str1, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        this.mVX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mVX, this.roS, bool3, bool2, b.a.rsE, b.c.rsL)).rpj;
        if (i != 0)
        {
          this.mVY = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, parama, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
          this.mVY = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mVY, this.roS, bool3, bool2, b.a.rsE, b.c.rsN)).rpj;
          this.mVY = TextUtils.concat(new CharSequence[] { paramVarArgs, this.mVY });
        }
        if (!af.aHH(this.contact.field_username)) {
          break label961;
        }
        this.ruV = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).bt(this.contact.field_openImAppid, this.contact.field_descWordingId);
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
      parama = this.contact.evI;
      paramVarArgs = paramContext.getString(2131762925);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      paramVarArgs = this.contact.Ss();
      parama = paramVarArgs;
      if (bt.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      paramVarArgs = paramContext.getString(2131762935);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      parama = this.jpy.content;
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
          if (paramVarArgs.startsWith(this.roS.rpq)) {
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
        parama = this.jpy.content;
        paramVarArgs = paramContext.getString(2131762931);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = this.jpy.content;
        paramVarArgs = paramContext.getString(2131762924);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = ((n)g.ad(n.class)).getFTSMainDB().aaU(this.contact.field_contactLabelIds);
        paramVarArgs = new StringBuffer();
        arrayOfString = this.roS.rps;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          String str2 = arrayOfString[i];
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            if (com.tencent.mm.plugin.fts.a.d.aaY(str3).contains(str2))
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
        paramVarArgs = Q(this.contact);
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
        this.mVX = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, str1, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        break label265;
        label961:
        this.ruV = "";
        AppMethodBeat.o(112121);
        return;
      }
      bool2 = false;
      break label393;
      bool2 = false;
    }
  }
  
  public final String aWt()
  {
    AppMethodBeat.i(112123);
    if ((this.contact != null) && (af.aHH(this.contact.field_username)))
    {
      String str = "openim:" + this.contact.field_openImAppid;
      AppMethodBeat.o(112123);
      return str;
    }
    AppMethodBeat.o(112123);
    return "";
  }
  
  public final a.b acQ()
  {
    return this.rwm;
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
      a(r.this.roS.rpq, paramVarArgs.jpy);
      com.tencent.mm.bs.d.e(paramContext, ".ui.chatting.ChattingUI", new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true));
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).cE(paramVarArgs.username, 2);
      AppMethodBeat.o(112119);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.r
 * JD-Core Version:    0.7.0.1
 */