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
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public an contact;
  public String iconUrl;
  public com.tencent.mm.plugin.fts.a.a.m kno;
  public CharSequence ofE;
  public CharSequence ofF;
  private b ofG;
  a ofH;
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(5821);
    this.ofG = new b();
    this.ofH = new a();
    AppMethodBeat.o(5821);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5822);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.kno.tEY;
    this.contact = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(this.username);
    Object localObject = com.tencent.mm.al.g.eX(this.username);
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
      str = w.zP(this.username);
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
      if ((localObject != null) && (!((c)localObject).KB())) {
        break label363;
      }
    }
    label274:
    label363:
    for (int i = 1;; i = 0) {
      switch (this.kno.tEX)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label591;
        }
        this.ofE = k.d(paramContext, str, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
        this.ofE = com.tencent.mm.plugin.fts.a.f.a(e.a(this.ofE, this.tFe, bool1, bool2)).tFv;
        if (this.pSr == -8) {
          this.ofF = paramContext.getString(2131759679);
        }
        if ((j != 0) && (i != 0))
        {
          this.ofF = k.d(paramContext, paramVarArgs, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
          this.ofF = com.tencent.mm.plugin.fts.a.f.a(e.a(this.ofF, this.tFe, bool1, bool2)).tFv;
          this.ofF = TextUtils.concat(new CharSequence[] { parama, this.ofF });
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
      paramVarArgs = this.contact.VI();
      parama = paramVarArgs;
      if (bu.isNullOrNil(paramVarArgs)) {
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
      localObject = ((com.tencent.mm.api.m)com.tencent.mm.kernel.g.ab(com.tencent.mm.api.m.class)).eS(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.ofF = k.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cb.a.ax(paramContext, 2131165517));
        com.tencent.mm.plugin.fts.a.a.f localf = com.tencent.mm.plugin.fts.a.f.a(e.a(this.ofF, this.tFe, bool3, bool2));
        if (localf.bZU == 0) {
          this.ofF = localf.tFv;
        }
      }
      this.ofF = TextUtils.concat(new CharSequence[] { this.ofF, paramContext.getString(2131762902) + str });
      bool1 = bool3;
      break;
      this.ofE = k.d(paramContext, str, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
      break label274;
      bool2 = false;
      break label372;
      bool2 = false;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.ofG;
  }
  
  public final String bhD()
  {
    AppMethodBeat.i(5823);
    if (this.ofE != null)
    {
      String str = this.ofE.toString();
      AppMethodBeat.o(5823);
      return str;
    }
    AppMethodBeat.o(5823);
    return "";
  }
  
  public final int bhE()
  {
    return this.kno.tGo;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public ImageView fQl;
    public TextView iFO;
    public TextView iYj;
    public View knu;
    public WeImageView ofI;
    
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
      paramViewGroup = (a.a)a.this.ofH;
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.knu = paramContext.findViewById(2131299154);
      paramViewGroup.ofI = ((WeImageView)paramContext.findViewById(2131300891));
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
      n.p(parama.knu, a.this.tGL);
      n.a(paramContext, parama.fQl, parama1.iconUrl, null, 2131231342, true);
      if (x.zW(parama1.username)) {
        n.a(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(paramContext, parama1.ofE), parama.iYj);
      }
      for (;;)
      {
        n.a(parama1.ofF, parama.iFO);
        if (!parama1.contact.fuh()) {
          break;
        }
        parama.ofI.setImageDrawable(ao.k(paramContext, 2131690481, com.tencent.mm.cb.a.n(paramContext, 2131100725)));
        parama.ofI.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        n.a(parama1.ofE, parama.iYj);
      }
      if ((parama1.contact.field_verifyFlag & 0x10) > 0) {}
      while (i != 0)
      {
        parama.ofI.setImageDrawable(ao.k(paramContext, 2131690481, com.tencent.mm.cb.a.n(paramContext, 2131099748)));
        parama.ofI.setVisibility(0);
        AppMethodBeat.o(5819);
        return;
        i = 0;
      }
      parama.ofI.setVisibility(8);
      AppMethodBeat.o(5819);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(5820);
      a locala = (a)paramVarArgs;
      a(a.this.tFe.tFC, locala.kno);
      if (com.tencent.mm.al.g.Es(locala.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("enterprise_biz_name", locala.username);
        paramVarArgs.putExtra("enterprise_biz_display_name", w.zP(locala.username));
        paramVarArgs.putExtra("enterprise_from_scene", 3);
        d.f(paramContext, ".ui.conversation.EnterpriseConversationUI", paramVarArgs);
      }
      for (;;)
      {
        ah.aHm(locala.username);
        AppMethodBeat.o(5820);
        return true;
        if (com.tencent.mm.al.g.vz(locala.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", locala.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (com.tencent.mm.al.g.Et(locala.username))
          {
            paramVarArgs = com.tencent.mm.al.g.eX(locala.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = null;; paramVarArgs = paramVarArgs.Kz())
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