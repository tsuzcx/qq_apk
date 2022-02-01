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
import com.tencent.mm.api.c;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public am contact;
  public String iconUrl;
  public com.tencent.mm.plugin.fts.a.a.m kjY;
  public CharSequence nZU;
  public CharSequence nZV;
  private b nZW;
  a nZX;
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(5821);
    this.nZW = new b();
    this.nZX = new a();
    AppMethodBeat.o(5821);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5822);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.kjY.tuh;
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(this.username);
    Object localObject = com.tencent.mm.am.g.eS(this.username);
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
      str = v.zf(this.username);
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
      if ((localObject != null) && (!((c)localObject).Kt())) {
        break label363;
      }
    }
    label274:
    label363:
    for (int i = 1;; i = 0) {
      switch (this.kjY.tug)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label591;
        }
        this.nZU = k.d(paramContext, str, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
        this.nZU = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nZU, this.tun, bool1, bool2)).tuE;
        if (this.pLM == -8) {
          this.nZV = paramContext.getString(2131759679);
        }
        if ((j != 0) && (i != 0))
        {
          this.nZV = k.d(paramContext, paramVarArgs, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
          this.nZV = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nZV, this.tun, bool1, bool2)).tuE;
          this.nZV = TextUtils.concat(new CharSequence[] { parama, this.nZV });
        }
        AppMethodBeat.o(5822);
        return;
        parama = ((c)localObject).field_brandIconURL;
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
      paramVarArgs = this.contact.VA();
      parama = paramVarArgs;
      if (bt.isNullOrNil(paramVarArgs)) {
        parama = this.contact.field_username;
      }
      localObject = paramContext.getString(2131762935);
      paramVarArgs = parama;
      bool2 = bool6;
      bool1 = bool5;
      parama = (com.tencent.mm.plugin.fts.a.d.a.a.a)localObject;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      localObject = ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eN(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.nZV = k.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cc.a.ax(paramContext, 2131165517));
        com.tencent.mm.plugin.fts.a.a.f localf = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nZV, this.tun, bool3, bool2));
        if (localf.bZU == 0) {
          this.nZV = localf.tuE;
        }
      }
      this.nZV = TextUtils.concat(new CharSequence[] { this.nZV, paramContext.getString(2131762902) + str });
      bool1 = bool3;
      break;
      this.nZU = k.d(paramContext, str, com.tencent.mm.cc.a.ax(paramContext, 2131165517));
      break label274;
      bool2 = false;
      break label372;
      bool2 = false;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.nZW;
  }
  
  public final String bgV()
  {
    AppMethodBeat.i(5823);
    if (this.nZU != null)
    {
      String str = this.nZU.toString();
      AppMethodBeat.o(5823);
      return str;
    }
    AppMethodBeat.o(5823);
    return "";
  }
  
  public final int bgW()
  {
    return this.kjY.tvx;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public ImageView fOf;
    public TextView iCV;
    public TextView iVq;
    public View kke;
    public WeImageView nZY;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494187, paramViewGroup, false);
      paramViewGroup = (a.a)a.this.nZX;
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.kke = paramContext.findViewById(2131299154);
      paramViewGroup.nZY = ((WeImageView)paramContext.findViewById(2131300891));
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
      n.p(parama.kke, a.this.tvU);
      n.a(paramContext, parama.fOf, parama1.iconUrl, null, 2131231342, true);
      if (w.zm(parama1.username)) {
        n.a(((b)com.tencent.mm.kernel.g.ab(b.class)).a(paramContext, parama1.nZU), parama.iVq);
      }
      for (;;)
      {
        n.a(parama1.nZV, parama.iCV);
        if (!parama1.contact.fqh()) {
          break;
        }
        parama.nZY.setImageDrawable(ao.k(paramContext, 2131690481, com.tencent.mm.cc.a.n(paramContext, 2131100725)));
        parama.nZY.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        n.a(parama1.nZU, parama.iVq);
      }
      if ((parama1.contact.field_verifyFlag & 0x10) > 0) {}
      while (i != 0)
      {
        parama.nZY.setImageDrawable(ao.k(paramContext, 2131690481, com.tencent.mm.cc.a.n(paramContext, 2131099748)));
        parama.nZY.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        i = 0;
      }
      parama.nZY.setVisibility(8);
      AppMethodBeat.o(5819);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(5820);
      a locala = (a)paramVarArgs;
      a(a.this.tun.tuL, locala.kjY);
      if (com.tencent.mm.am.g.DQ(locala.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("enterprise_biz_name", locala.username);
        paramVarArgs.putExtra("enterprise_biz_display_name", v.zf(locala.username));
        paramVarArgs.putExtra("enterprise_from_scene", 3);
        d.f(paramContext, ".ui.conversation.EnterpriseConversationUI", paramVarArgs);
      }
      for (;;)
      {
        ah.aFS(locala.username);
        AppMethodBeat.o(5820);
        return true;
        if (com.tencent.mm.am.g.vd(locala.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", locala.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (com.tencent.mm.am.g.DR(locala.username))
          {
            paramVarArgs = com.tencent.mm.am.g.eS(locala.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = null;; paramVarArgs = paramVarArgs.Kr())
            {
              Object localObject = paramVarArgs;
              if (paramVarArgs == null) {
                localObject = "";
              }
              paramVarArgs = new Intent();
              paramVarArgs.putExtra("rawUrl", (String)localObject);
              paramVarArgs.putExtra("useJs", true);
              paramVarArgs.putExtra("srcUsername", locala.username);
              paramVarArgs.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
              paramVarArgs.addFlags(67108864);
              d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
              break;
            }
          }
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Chat_User", locala.username);
          paramVarArgs.putExtra("finish_direct", true);
          paramVarArgs.putExtra("specific_chat_from_scene", 3);
          paramVarArgs.putExtra("preChatTYPE", 9);
          d.f(paramContext, ".ui.chatting.ChattingUI", paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */