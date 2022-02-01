package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.g.a;
import com.tencent.mm.openim.api.g.b;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.p.b;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Iterator;
import java.util.List;

public final class u
  extends b
{
  private a HBT;
  
  public u(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112120);
    this.HBT = new a();
    AppMethodBeat.o(112120);
  }
  
  private Pair<String, String> ak(au paramau)
  {
    AppMethodBeat.i(112122);
    com.tencent.mm.openim.api.g localg = new com.tencent.mm.openim.api.g();
    localg.RH(paramau.kav);
    int i = 0;
    while (i < localg.aYV.size())
    {
      g.a locala = (g.a)localg.aYV.get(i);
      Iterator localIterator = locala.pre.iterator();
      while (localIterator.hasNext())
      {
        String str = ((g.b)localIterator.next()).RI(paramau.field_openImAppid);
        if (!Util.isNullOrNil(str))
        {
          String[] arrayOfString = this.FWt.Htg;
          int k = arrayOfString.length;
          int j = 0;
          while (j < k)
          {
            if (str.contains(arrayOfString[j]))
            {
              paramau = new Pair(locala.title, str);
              AppMethodBeat.o(112122);
              return paramau;
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
    this.username = this.rpp.Hsz;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.username);
    paramVarArgs = null;
    parama = null;
    int j = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    String str1 = d.atS(this.username);
    int i;
    switch (this.rpp.subtype)
    {
    default: 
      i = 0;
      bool2 = bool5;
      bool3 = bool4;
      if (j != 0)
      {
        this.vFf = p.d(paramContext, str1, com.tencent.mm.cd.a.br(paramContext, p.b.NormalTextSize));
        this.vFf = f.a(com.tencent.mm.plugin.fts.a.a.g.a(this.vFf, this.FWt, bool3, bool2, b.a.HwK, b.c.HwR)).HsX;
        if (i != 0)
        {
          this.vFg = p.d(paramContext, parama, com.tencent.mm.cd.a.br(paramContext, p.b.NormalTextSize));
          this.vFg = f.a(com.tencent.mm.plugin.fts.a.a.g.a(this.vFg, this.FWt, bool3, bool2, b.a.HwK, b.c.HwT)).HsX;
          this.vFg = TextUtils.concat(new CharSequence[] { paramVarArgs, this.vFg });
        }
        if (!au.bwO(this.contact.field_username)) {
          break label965;
        }
        this.Buk = ((e)com.tencent.mm.kernel.h.ax(e.class)).cc(this.contact.field_openImAppid, this.contact.field_descWordingId);
        AppMethodBeat.o(112121);
      }
      break;
    case 3: 
      label266:
      bool2 = true;
    }
    label395:
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
      paramVarArgs = paramContext.getString(p.g.search_contact_tag_nickname);
      i = 1;
      break;
      parama = this.contact.kal;
      paramVarArgs = paramContext.getString(p.g.search_contact_tag_description);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      paramVarArgs = this.contact.aJs();
      parama = paramVarArgs;
      if (Util.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      paramVarArgs = paramContext.getString(p.g.search_contact_tag_wxid);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      parama = this.rpp.content;
      String[] arrayOfString;
      int k;
      if (!Util.isNullOrNil(parama))
      {
        arrayOfString = parama.split("​");
        k = arrayOfString.length;
        i = 0;
        label552:
        if (i < k)
        {
          paramVarArgs = arrayOfString[i];
          if (paramVarArgs.startsWith(this.FWt.Hte)) {
            parama = paramVarArgs;
          }
        }
      }
      for (;;)
      {
        paramVarArgs = paramContext.getString(p.g.search_contact_tag_mobile);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        i += 1;
        break label552;
        parama = this.rpp.content;
        paramVarArgs = paramContext.getString(p.g.search_contact_tag_province);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = this.rpp.content;
        paramVarArgs = paramContext.getString(p.g.search_contact_tag_city);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aEd(this.contact.field_contactLabelIds);
        paramVarArgs = new StringBuffer();
        arrayOfString = this.FWt.Htg;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          String str2 = arrayOfString[i];
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            if (d.aEh(str3).contains(str2))
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
          paramVarArgs = paramContext.getString(p.g.search_contact_tag_tag);
          i = 1;
          bool3 = bool4;
          bool2 = bool5;
          break;
        }
        paramVarArgs = ak(this.contact);
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
        this.vFf = p.d(paramContext, str1, com.tencent.mm.cd.a.br(paramContext, p.b.NormalTextSize));
        break label266;
        label965:
        this.Buk = "";
        AppMethodBeat.o(112121);
        return;
      }
      bool2 = false;
      break label395;
      bool2 = false;
    }
  }
  
  public final a.b aXA()
  {
    return this.HBT;
  }
  
  public final String coB()
  {
    AppMethodBeat.i(112123);
    if ((this.contact != null) && (au.bwO(this.contact.field_username)))
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
      AppMethodBeat.i(265734);
      paramVarArgs = (u)paramVarArgs;
      if ((au.bwu(paramVarArgs.username)) && (!WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(265734);
        return true;
      }
      if (((au.bwO(paramVarArgs.username)) || (au.bwF(paramVarArgs.username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(265734);
        return true;
      }
      a(u.this.FWt.Hte, paramVarArgs.rpp);
      paramView = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      paramView.putExtra("chat_from_scene", 5);
      com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", paramView);
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).dQ(paramVarArgs.username, 2);
      AppMethodBeat.o(265734);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.u
 * JD-Core Version:    0.7.0.1
 */