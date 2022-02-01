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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.brandservice.api.d;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.c;
import com.tencent.mm.plugin.brandservice.d.d;
import com.tencent.mm.plugin.brandservice.d.e;
import com.tencent.mm.plugin.brandservice.d.f;
import com.tencent.mm.plugin.brandservice.d.h;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
  implements d
{
  public au contact;
  public String iconUrl;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  public CharSequence vFf;
  public CharSequence vFg;
  private b vFh;
  a vFi;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(5821);
    this.vFh = new b();
    this.vFi = new a();
    AppMethodBeat.o(5821);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5822);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.rpp.Hsz;
    this.contact = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.username);
    Object localObject = com.tencent.mm.an.g.hU(this.username);
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
      str = aa.getDisplayName(this.username);
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
      if ((localObject != null) && (!((com.tencent.mm.api.c)localObject).aAV())) {
        break label366;
      }
    }
    label276:
    label366:
    for (int i = 1;; i = 0) {
      switch (this.rpp.subtype)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label597;
        }
        this.vFf = p.d(paramContext, str, com.tencent.mm.cd.a.br(paramContext, d.c.NormalTextSize));
        this.vFf = f.a(com.tencent.mm.plugin.fts.a.a.g.a(this.vFf, this.FWt, bool1, bool2)).HsX;
        if (this.xVf == -8) {
          this.vFg = paramContext.getString(d.i.fts_header_biz);
        }
        if ((j != 0) && (i != 0))
        {
          this.vFg = p.d(paramContext, paramVarArgs, com.tencent.mm.cd.a.br(paramContext, d.c.NormalTextSize));
          this.vFg = f.a(com.tencent.mm.plugin.fts.a.a.g.a(this.vFg, this.FWt, bool1, bool2)).HsX;
          this.vFg = TextUtils.concat(new CharSequence[] { parama, this.vFg });
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
      paramVarArgs = this.contact.aJs();
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
      localObject = ((com.tencent.mm.api.o)com.tencent.mm.kernel.h.ax(com.tencent.mm.api.o.class)).hP(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.vFg = p.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cd.a.br(paramContext, d.c.NormalTextSize));
        com.tencent.mm.plugin.fts.a.a.h localh = f.a(com.tencent.mm.plugin.fts.a.a.g.a(this.vFg, this.FWt, bool3, bool2));
        if (localh.resultCode == 0) {
          this.vFg = localh.HsX;
        }
      }
      this.vFg = TextUtils.concat(new CharSequence[] { this.vFg, paramContext.getString(d.i.search_biz_tran_info) + str });
      bool1 = bool3;
      break;
      this.vFf = p.d(paramContext, str, com.tencent.mm.cd.a.br(paramContext, d.c.NormalTextSize));
      break label276;
      bool2 = false;
      break label375;
      bool2 = false;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.vFh;
  }
  
  public final String coB()
  {
    AppMethodBeat.i(5823);
    if (this.vFf != null)
    {
      String str = this.vFf.toString();
      AppMethodBeat.o(5823);
      return str;
    }
    AppMethodBeat.o(5823);
    return "";
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final String getUserName()
  {
    return this.username;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public ImageView lBC;
    public WeImageView mpe;
    public TextView pJJ;
    public TextView plr;
    public View rpv;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(d.f.fts_biz_contact_item, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.vFi;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(d.e.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(d.e.title_tv));
      paramViewGroup.plr = ((TextView)paramContext.findViewById(d.e.desc_tv));
      paramViewGroup.rpv = paramContext.findViewById(d.e.divider);
      paramViewGroup.mpe = ((WeImageView)paramContext.findViewById(d.e.icon_iv));
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
      com.tencent.mm.plugin.fts.ui.o.w(parama.rpv, a.this.Hup);
      com.tencent.mm.plugin.fts.ui.o.a(paramContext, parama.lBC, parama1.iconUrl, null, d.d.brand_default_head, true);
      if (ab.IG(parama1.username)) {
        com.tencent.mm.plugin.fts.ui.o.a(((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(paramContext, parama1.vFf), parama.pJJ);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.o.a(parama1.vFg, parama.plr);
        if (!parama1.contact.iZD()) {
          break;
        }
        parama.mpe.setImageDrawable(bb.m(paramContext, d.h.icons_filled_star_identify, com.tencent.mm.cd.a.w(paramContext, d.b.orange_100)));
        parama.mpe.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        com.tencent.mm.plugin.fts.ui.o.a(parama1.vFf, parama.pJJ);
      }
      if ((parama1.contact.field_verifyFlag & 0x10) > 0) {}
      while (i != 0)
      {
        parama.mpe.setImageDrawable(bb.m(paramContext, d.h.icons_filled_star_identify, com.tencent.mm.cd.a.w(paramContext, d.b.Indigo)));
        parama.mpe.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        i = 0;
      }
      parama.mpe.setVisibility(8);
      AppMethodBeat.o(5819);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(301724);
      a locala = (a)paramVarArgs;
      if ((!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext())) && (!au.bwJ(String.valueOf(locala.username))))
      {
        AppMethodBeat.o(301724);
        return true;
      }
      a(a.this.FWt.Hte, locala.rpp);
      if (com.tencent.mm.an.g.MB(locala.username))
      {
        paramView = new Intent();
        paramView.putExtra("enterprise_biz_name", locala.username);
        paramView.putExtra("enterprise_biz_display_name", aa.getDisplayName(locala.username));
        paramView.putExtra("uinserve_search_id", com.tencent.mm.plugin.fts.a.e.HrN);
        paramView.putExtra("uinserve_search_session_id", com.tencent.mm.plugin.fts.a.e.HrM);
        paramView.putExtra("enterprise_from_scene", 3);
        paramView.putExtra("uinserve_search_session_id", com.tencent.mm.plugin.fts.a.e.fxu());
        com.tencent.mm.br.c.g(paramContext, ".ui.conversation.EnterpriseConversationUI", paramView);
      }
      for (;;)
      {
        an.biA(locala.username);
        AppMethodBeat.o(301724);
        return true;
        if (com.tencent.mm.an.g.Dn(locala.username))
        {
          paramView = new Intent();
          paramView.putExtra("Contact_User", locala.username);
          paramView.addFlags(67108864);
          paramView.putExtra("uinserve_search_id", com.tencent.mm.plugin.fts.a.e.HrN);
          paramView.putExtra("uinserve_search_session_id", com.tencent.mm.plugin.fts.a.e.HrM);
          paramView.putExtra("biz_chat_from_scene", 5);
          paramView.putExtra("uinserve_search_time_token", com.tencent.mm.plugin.fts.a.e.fxu());
          com.tencent.mm.br.c.g(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
        }
        else
        {
          if (com.tencent.mm.an.g.MC(locala.username))
          {
            paramView = com.tencent.mm.an.g.hU(locala.username);
            if (paramView == null) {}
            for (paramView = null;; paramView = paramView.aAT())
            {
              paramVarArgs = paramView;
              if (paramView == null) {
                paramVarArgs = "";
              }
              paramView = new Intent();
              paramView.putExtra("rawUrl", paramVarArgs);
              paramView.putExtra("useJs", true);
              paramView.putExtra("uinserve_search_id", com.tencent.mm.plugin.fts.a.e.HrN);
              paramView.putExtra("uinserve_search_session_id", com.tencent.mm.plugin.fts.a.e.HrM);
              paramView.putExtra("uinserve_search_time_token", com.tencent.mm.plugin.fts.a.e.fxu());
              paramView.putExtra("srcUsername", locala.username);
              paramView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
              paramView.addFlags(67108864);
              com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
              break;
            }
          }
          paramView = new Intent();
          paramView.putExtra("Chat_User", locala.username);
          paramView.putExtra("finish_direct", true);
          paramView.putExtra("specific_chat_from_scene", 3);
          paramView.putExtra("preChatTYPE", 9);
          paramView.putExtra("chat_from_scene", 5);
          paramView.putExtra("uinserve_search_id", com.tencent.mm.plugin.fts.a.e.HrN);
          paramView.putExtra("uinserve_search_session_id", com.tencent.mm.plugin.fts.a.e.HrM);
          paramView.putExtra("uinserve_search_time_token", com.tencent.mm.plugin.fts.a.e.fxu());
          com.tencent.mm.br.c.g(paramContext, ".ui.chatting.ChattingUI", paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */