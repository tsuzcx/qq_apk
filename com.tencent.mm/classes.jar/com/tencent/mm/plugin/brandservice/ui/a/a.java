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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
  implements com.tencent.mm.plugin.brandservice.a.c
{
  public as contact;
  public String iconUrl;
  public m lqW;
  public CharSequence pqB;
  public CharSequence pqC;
  private b pqD;
  a pqE;
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(5821);
    this.pqD = new b();
    this.pqE = new a();
    AppMethodBeat.o(5821);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5822);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.lqW.wVX;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.username);
    Object localObject = com.tencent.mm.al.g.fJ(this.username);
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
      if ((localObject != null) && (!((com.tencent.mm.api.c)localObject).UL())) {
        break label363;
      }
    }
    label274:
    label363:
    for (int i = 1;; i = 0) {
      switch (this.lqW.wVW)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label591;
        }
        this.pqB = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, str, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        this.pqB = com.tencent.mm.plugin.fts.a.f.a(e.a(this.pqB, this.wWd, bool1, bool2)).wWu;
        if (this.rjr == -8) {
          this.pqC = paramContext.getString(2131761000);
        }
        if ((j != 0) && (i != 0))
        {
          this.pqC = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, paramVarArgs, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
          this.pqC = com.tencent.mm.plugin.fts.a.f.a(e.a(this.pqC, this.wWd, bool1, bool2)).wWu;
          this.pqC = TextUtils.concat(new CharSequence[] { parama, this.pqC });
        }
        AppMethodBeat.o(5822);
        return;
        parama = ((com.tencent.mm.api.c)localObject).field_brandIconURL;
        break label67;
      }
    }
    boolean bool2 = true;
    label372:
    for (boolean bool1 = true;; bool1 = bool4)
    {
      k = 1;
      break;
      j = 1;
      paramVarArgs = this.contact.ajx();
      parama = paramVarArgs;
      if (Util.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      localObject = paramContext.getString(2131765071);
      paramVarArgs = parama;
      bool2 = bool6;
      bool1 = bool5;
      parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      localObject = ((com.tencent.mm.api.n)com.tencent.mm.kernel.g.af(com.tencent.mm.api.n.class)).fE(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.pqC = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cb.a.aG(paramContext, 2131165535));
        com.tencent.mm.plugin.fts.a.a.f localf = com.tencent.mm.plugin.fts.a.f.a(e.a(this.pqC, this.wWd, bool3, bool2));
        if (localf.resultCode == 0) {
          this.pqC = localf.wWu;
        }
      }
      this.pqC = TextUtils.concat(new CharSequence[] { this.pqC, paramContext.getString(2131765038) + str });
      bool1 = bool3;
      break;
      this.pqB = com.tencent.mm.pluginsdk.ui.span.l.d(paramContext, str, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
      break label274;
      bool2 = false;
      break label372;
      bool2 = false;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.pqD;
  }
  
  public final String bCR()
  {
    AppMethodBeat.i(5823);
    if (this.pqB != null)
    {
      String str = this.pqB.toString();
      AppMethodBeat.o(5823);
      return str;
    }
    AppMethodBeat.o(5823);
    return "";
  }
  
  public final int bCS()
  {
    return this.lqW.wXn;
  }
  
  public final String getUserName()
  {
    return this.username;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public ImageView gvv;
    public WeImageView hex;
    public TextView jBR;
    public TextView jVO;
    public View lrc;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494741, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.pqE;
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
      paramViewGroup.lrc = paramContext.findViewById(2131299682);
      paramViewGroup.hex = ((WeImageView)paramContext.findViewById(2131302497));
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
      com.tencent.mm.plugin.fts.ui.n.q(parama.lrc, a.this.wXK);
      com.tencent.mm.plugin.fts.ui.n.a(paramContext, parama.gvv, parama1.iconUrl, null, 2131231405, true);
      if (ab.Iz(parama1.username)) {
        com.tencent.mm.plugin.fts.ui.n.a(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.pqB), parama.jVO);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.n.a(parama1.pqC, parama.jBR);
        if (!parama1.contact.gBN()) {
          break;
        }
        parama.hex.setImageDrawable(ar.m(paramContext, 2131690678, com.tencent.mm.cb.a.n(paramContext, 2131100919)));
        parama.hex.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        com.tencent.mm.plugin.fts.ui.n.a(parama1.pqB, parama.jVO);
      }
      if ((parama1.contact.field_verifyFlag & 0x10) > 0) {}
      while (i != 0)
      {
        parama.hex.setImageDrawable(ar.m(paramContext, 2131690678, com.tencent.mm.cb.a.n(paramContext, 2131099762)));
        parama.hex.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        i = 0;
      }
      parama.hex.setVisibility(8);
      AppMethodBeat.o(5819);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(194914);
      a locala = (a)paramVarArgs;
      if ((!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext())) && (!ab.Iv(String.valueOf(locala.username))))
      {
        AppMethodBeat.o(194914);
        return true;
      }
      a(a.this.wWd.wWB, locala.lqW);
      if (com.tencent.mm.al.g.Ng(locala.username))
      {
        paramView = new Intent();
        paramView.putExtra("enterprise_biz_name", locala.username);
        paramView.putExtra("enterprise_biz_display_name", aa.getDisplayName(locala.username));
        paramView.putExtra("enterprise_from_scene", 3);
        com.tencent.mm.br.c.f(paramContext, ".ui.conversation.EnterpriseConversationUI", paramView);
      }
      for (;;)
      {
        am.aXh(locala.username);
        AppMethodBeat.o(194914);
        return true;
        if (com.tencent.mm.al.g.DQ(locala.username))
        {
          paramView = new Intent();
          paramView.putExtra("Contact_User", locala.username);
          paramView.addFlags(67108864);
          paramView.putExtra("biz_chat_from_scene", 5);
          com.tencent.mm.br.c.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
        }
        else
        {
          if (com.tencent.mm.al.g.Nh(locala.username))
          {
            paramView = com.tencent.mm.al.g.fJ(locala.username);
            if (paramView == null) {}
            for (paramView = null;; paramView = paramView.UJ())
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
          com.tencent.mm.br.c.f(paramContext, ".ui.chatting.ChattingUI", paramView);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */