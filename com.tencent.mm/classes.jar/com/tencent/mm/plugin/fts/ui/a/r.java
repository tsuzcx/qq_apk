package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o.b;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.List;

public final class r
  extends b
{
  private a BPL;
  
  public r(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112120);
    this.BPL = new a();
    AppMethodBeat.o(112120);
  }
  
  private Pair<String, String> af(as paramas)
  {
    AppMethodBeat.i(112122);
    com.tencent.mm.openim.a.b localb = new com.tencent.mm.openim.a.b();
    localb.ZC(paramas.hDA);
    int i = 0;
    while (i < localb.mxJ.size())
    {
      com.tencent.mm.openim.a.b.a locala = (com.tencent.mm.openim.a.b.a)localb.mxJ.get(i);
      Iterator localIterator = locala.mya.iterator();
      while (localIterator.hasNext())
      {
        String str = ((com.tencent.mm.openim.a.b.b)localIterator.next()).ZD(paramas.field_openImAppid);
        if (!Util.isNullOrNil(str))
        {
          String[] arrayOfString = this.BHY.BIy;
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
    this.username = this.olG.BHS;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.username);
    paramVarArgs = null;
    parama = null;
    int j = 0;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool5 = false;
    String str1 = d.azM(this.username);
    int i;
    switch (this.olG.BHR)
    {
    default: 
      i = 0;
      bool2 = bool5;
      bool3 = bool4;
      if (j != 0)
      {
        this.szA = l.d(paramContext, str1, com.tencent.mm.ci.a.aY(paramContext, o.b.NormalTextSize));
        this.szA = com.tencent.mm.plugin.fts.a.f.a(e.a(this.szA, this.BHY, bool3, bool2, com.tencent.mm.plugin.fts.ui.b.a.BLO, b.c.BLV)).BIp;
        if (i != 0)
        {
          this.szB = l.d(paramContext, parama, com.tencent.mm.ci.a.aY(paramContext, o.b.NormalTextSize));
          this.szB = com.tencent.mm.plugin.fts.a.f.a(e.a(this.szB, this.BHY, bool3, bool2, com.tencent.mm.plugin.fts.ui.b.a.BLO, b.c.BLX)).BIp;
          this.szB = TextUtils.concat(new CharSequence[] { paramVarArgs, this.szB });
        }
        if (!as.bvK(this.contact.field_username)) {
          break label965;
        }
        this.BOs = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(this.contact.field_openImAppid, this.contact.field_descWordingId);
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
      paramVarArgs = paramContext.getString(o.g.search_contact_tag_nickname);
      i = 1;
      break;
      parama = this.contact.hDq;
      paramVarArgs = paramContext.getString(o.g.search_contact_tag_description);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      paramVarArgs = this.contact.apf();
      parama = paramVarArgs;
      if (Util.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      paramVarArgs = paramContext.getString(o.g.search_contact_tag_wxid);
      i = 1;
      bool3 = bool4;
      bool2 = bool5;
      break;
      parama = this.olG.content;
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
          if (paramVarArgs.startsWith(this.BHY.BIw)) {
            parama = paramVarArgs;
          }
        }
      }
      for (;;)
      {
        paramVarArgs = paramContext.getString(o.g.search_contact_tag_mobile);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        i += 1;
        break label552;
        parama = this.olG.content;
        paramVarArgs = paramContext.getString(o.g.search_contact_tag_province);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = this.olG.content;
        paramVarArgs = paramContext.getString(o.g.search_contact_tag_city);
        i = 1;
        bool3 = bool4;
        bool2 = bool5;
        break;
        parama = ((com.tencent.mm.plugin.fts.a.n)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aHF(this.contact.field_contactLabelIds);
        paramVarArgs = new StringBuffer();
        arrayOfString = this.BHY.BIy;
        k = arrayOfString.length;
        i = 0;
        while (i < k)
        {
          String str2 = arrayOfString[i];
          Iterator localIterator = parama.iterator();
          while (localIterator.hasNext())
          {
            String str3 = (String)localIterator.next();
            if (d.aHJ(str3).contains(str2))
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
          paramVarArgs = paramContext.getString(o.g.search_contact_tag_tag);
          i = 1;
          bool3 = bool4;
          bool2 = bool5;
          break;
        }
        paramVarArgs = af(this.contact);
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
        this.szA = l.d(paramContext, str1, com.tencent.mm.ci.a.aY(paramContext, o.b.NormalTextSize));
        break label266;
        label965:
        this.BOs = "";
        AppMethodBeat.o(112121);
        return;
      }
      bool2 = false;
      break label395;
      bool2 = false;
    }
  }
  
  public final a.b aEw()
  {
    return this.BPL;
  }
  
  public final String bOm()
  {
    AppMethodBeat.i(112123);
    if ((this.contact != null) && (as.bvK(this.contact.field_username)))
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
      AppMethodBeat.i(190107);
      paramVarArgs = (r)paramVarArgs;
      if ((ab.QQ(paramVarArgs.username)) && (!WeChatBrands.Business.Entries.HomeNotifyMessage.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(190107);
        return true;
      }
      if (((as.bvK(paramVarArgs.username)) || (ab.PQ(paramVarArgs.username))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext())))
      {
        AppMethodBeat.o(190107);
        return true;
      }
      a(r.this.BHY.BIw, paramVarArgs.olG);
      paramView = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
      paramView.putExtra("chat_from_scene", 5);
      c.f(paramContext, ".ui.chatting.ChattingUI", paramView);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).dp(paramVarArgs.username, 2);
      AppMethodBeat.o(190107);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.r
 * JD-Core Version:    0.7.0.1
 */