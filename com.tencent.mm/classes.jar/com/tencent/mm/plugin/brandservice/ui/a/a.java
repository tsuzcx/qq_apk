package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.g;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
  implements d
{
  public as contact;
  public String iconUrl;
  public m olG;
  public CharSequence szA;
  public CharSequence szB;
  private b szC;
  a szD;
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(5821);
    this.szC = new b();
    this.szD = new a();
    AppMethodBeat.o(5821);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5822);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.olG.BHS;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(this.username);
    Object localObject = g.gu(this.username);
    label67:
    String str;
    int k;
    int j;
    boolean bool4;
    boolean bool3;
    boolean bool5;
    boolean bool6;
    if (localObject == null)
    {
      parama = "";
      this.iconUrl = parama;
      str = aa.PJ(this.username);
      paramVarArgs = null;
      parama = null;
      k = 0;
      j = 0;
      bool4 = false;
      bool3 = false;
      bool5 = false;
      bool1 = false;
      bool2 = false;
      bool6 = false;
      if ((localObject != null) && (!((com.tencent.mm.api.c)localObject).Zd())) {
        break label366;
      }
    }
    label276:
    label366:
    for (int i = 1;; i = 0) {
      switch (this.olG.BHR)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label597;
        }
        this.szA = l.d(paramContext, str, com.tencent.mm.ci.a.aY(paramContext, d.c.NormalTextSize));
        this.szA = com.tencent.mm.plugin.fts.a.f.a(e.a(this.szA, this.BHY, bool1, bool2)).BIp;
        if (this.uMD == -8) {
          this.szB = paramContext.getString(d.i.fts_header_biz);
        }
        if ((j != 0) && (i != 0))
        {
          this.szB = l.d(paramContext, paramVarArgs, com.tencent.mm.ci.a.aY(paramContext, d.c.NormalTextSize));
          this.szB = com.tencent.mm.plugin.fts.a.f.a(e.a(this.szB, this.BHY, bool1, bool2)).BIp;
          this.szB = TextUtils.concat(new CharSequence[] { parama, this.szB });
        }
        AppMethodBeat.o(5822);
        return;
        parama = ((com.tencent.mm.api.c)localObject).field_brandIconURL;
        break label67;
      }
    }
    boolean bool2 = true;
    label375:
    for (boolean bool1 = true;; bool1 = bool4)
    {
      k = 1;
      break;
      j = 1;
      paramVarArgs = this.contact.apf();
      parama = paramVarArgs;
      if (Util.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      localObject = paramContext.getString(d.i.search_contact_tag_wxid);
      paramVarArgs = parama;
      bool2 = bool6;
      bool1 = bool5;
      parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      localObject = ((com.tencent.mm.api.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.n.class)).gp(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.szB = l.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.ci.a.aY(paramContext, d.c.NormalTextSize));
        com.tencent.mm.plugin.fts.a.a.f localf = com.tencent.mm.plugin.fts.a.f.a(e.a(this.szB, this.BHY, bool3, bool2));
        if (localf.resultCode == 0) {
          this.szB = localf.BIp;
        }
      }
      this.szB = TextUtils.concat(new CharSequence[] { this.szB, paramContext.getString(d.i.search_biz_tran_info) + str });
      bool1 = bool3;
      break;
      this.szA = l.d(paramContext, str, com.tencent.mm.ci.a.aY(paramContext, d.c.NormalTextSize));
      break label276;
      bool2 = false;
      break label375;
      bool2 = false;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.szC;
  }
  
  public final String bOm()
  {
    AppMethodBeat.i(5823);
    if (this.szA != null)
    {
      String str = this.szA.toString();
      AppMethodBeat.o(5823);
      return str;
    }
    AppMethodBeat.o(5823);
    return "";
  }
  
  public final int bOn()
  {
    return this.olG.BJj;
  }
  
  public final String getUserName()
  {
    return this.username;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public ImageView iZG;
    public WeImageView jQn;
    public TextView mNb;
    public TextView mrM;
    public View olM;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(5818);
      paramContext = LayoutInflater.from(paramContext).inflate(d.f.suq, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.szD;
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(d.e.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(d.e.title_tv));
      paramViewGroup.mrM = ((TextView)paramContext.findViewById(d.e.desc_tv));
      paramViewGroup.olM = paramContext.findViewById(d.e.divider);
      paramViewGroup.jQn = ((WeImageView)paramContext.findViewById(d.e.icon_iv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(5818);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      int i = 1;
      AppMethodBeat.i(5819);
      parama1 = (a)parama1;
      parama = (a.a)parama;
      com.tencent.mm.plugin.fts.ui.n.q(parama.olM, a.this.BJG);
      com.tencent.mm.plugin.fts.ui.n.a(paramContext, parama.iZG, parama1.iconUrl, null, d.d.brand_default_head, true);
      if (ab.PR(parama1.username)) {
        com.tencent.mm.plugin.fts.ui.n.a(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.szA), parama.mNb);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.n.a(parama1.szB, parama.mrM);
        if (!parama1.contact.hxY()) {
          break;
        }
        parama.jQn.setImageDrawable(au.o(paramContext, d.h.icons_filled_star_identify, com.tencent.mm.ci.a.w(paramContext, d.b.orange_100)));
        parama.jQn.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        com.tencent.mm.plugin.fts.ui.n.a(parama1.szA, parama.mNb);
      }
      if ((parama1.contact.field_verifyFlag & 0x10) > 0) {}
      while (i != 0)
      {
        parama.jQn.setImageDrawable(au.o(paramContext, d.h.icons_filled_star_identify, com.tencent.mm.ci.a.w(paramContext, d.b.Indigo)));
        parama.jQn.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        i = 0;
      }
      parama.jQn.setVisibility(8);
      AppMethodBeat.o(5819);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(261964);
      a locala = (a)paramVarArgs;
      if ((!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext())) && (!ab.PN(String.valueOf(locala.username))))
      {
        AppMethodBeat.o(261964);
        return true;
      }
      a(a.this.BHY.BIw, locala.olG);
      if (g.UC(locala.username))
      {
        paramView = new Intent();
        paramView.putExtra("enterprise_biz_name", locala.username);
        paramView.putExtra("enterprise_biz_display_name", aa.PJ(locala.username));
        paramView.putExtra("enterprise_from_scene", 3);
        com.tencent.mm.by.c.f(paramContext, ".ui.conversation.EnterpriseConversationUI", paramView);
      }
      for (;;)
      {
        am.biS(locala.username);
        AppMethodBeat.o(261964);
        return true;
        if (g.KI(locala.username))
        {
          paramView = new Intent();
          paramView.putExtra("Contact_User", locala.username);
          paramView.addFlags(67108864);
          paramView.putExtra("biz_chat_from_scene", 5);
          com.tencent.mm.by.c.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
        }
        else
        {
          if (g.UD(locala.username))
          {
            paramView = g.gu(locala.username);
            if (paramView == null) {}
            for (paramView = null;; paramView = paramView.Zb())
            {
              paramVarArgs = paramView;
              if (paramView == null) {
                paramVarArgs = "";
              }
              paramView = new Intent();
              paramView.putExtra("rawUrl", paramVarArgs);
              paramView.putExtra("useJs", true);
              paramView.putExtra("srcUsername", locala.username);
              paramView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
              paramView.addFlags(67108864);
              com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
              break;
            }
          }
          paramView = new Intent();
          paramView.putExtra("Chat_User", locala.username);
          paramView.putExtra("finish_direct", true);
          paramView.putExtra("specific_chat_from_scene", 3);
          paramView.putExtra("preChatTYPE", 9);
          paramView.putExtra("chat_from_scene", 5);
          com.tencent.mm.by.c.f(paramContext, ".ui.chatting.ChattingUI", paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */