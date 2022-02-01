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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public ai contact;
  public String iconUrl;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public CharSequence nyw;
  public CharSequence nyx;
  private b nyy;
  a nyz;
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(5821);
    this.nyy = new b();
    this.nyz = new a();
    AppMethodBeat.o(5821);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5822);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.jPN.sxG;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.username);
    Object localObject = com.tencent.mm.al.f.dX(this.username);
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
      str = v.wk(this.username);
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
      if ((localObject != null) && (!((c)localObject).IT())) {
        break label363;
      }
    }
    label274:
    label363:
    for (int i = 1;; i = 0) {
      switch (this.jPN.sxF)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label591;
        }
        this.nyw = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, str, com.tencent.mm.cc.a.au(paramContext, 2131165517));
        this.nyw = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nyw, this.sxM, bool1, bool2)).syd;
        if (this.pil == -8) {
          this.nyx = paramContext.getString(2131759679);
        }
        if ((j != 0) && (i != 0))
        {
          this.nyx = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, paramVarArgs, com.tencent.mm.cc.a.au(paramContext, 2131165517));
          this.nyx = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nyx, this.sxM, bool1, bool2)).syd;
          this.nyx = TextUtils.concat(new CharSequence[] { parama, this.nyx });
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
      paramVarArgs = this.contact.Tl();
      parama = paramVarArgs;
      if (bs.isNullOrNil(paramVarArgs)) {
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
      localObject = ((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).dS(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.nyx = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cc.a.au(paramContext, 2131165517));
        com.tencent.mm.plugin.fts.a.a.f localf = com.tencent.mm.plugin.fts.a.f.a(e.a(this.nyx, this.sxM, bool3, bool2));
        if (localf.bPH == 0) {
          this.nyx = localf.syd;
        }
      }
      this.nyx = TextUtils.concat(new CharSequence[] { this.nyx, paramContext.getString(2131762902) + str });
      bool1 = bool3;
      break;
      this.nyw = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, str, com.tencent.mm.cc.a.au(paramContext, 2131165517));
      break label274;
      bool2 = false;
      break label372;
      bool2 = false;
    }
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.nyy;
  }
  
  public final String bdr()
  {
    AppMethodBeat.i(5823);
    if (this.nyw != null)
    {
      String str = this.nyw.toString();
      AppMethodBeat.o(5823);
      return str;
    }
    AppMethodBeat.o(5823);
    return "";
  }
  
  public final int bds()
  {
    return this.jPN.syW;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public ImageView fuY;
    public TextView iCg;
    public TextView ijE;
    public View jPT;
    
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
      paramViewGroup = (a.a)a.this.nyz;
      paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.jPT = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(5818);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(5819);
      parama1 = (a)parama1;
      parama = (a.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jPT, a.this.szt);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext, parama.fuY, parama1.iconUrl, null, 2131231342, true);
      if (w.wr(parama1.username)) {
        com.tencent.mm.plugin.fts.ui.m.a(((b)g.ab(b.class)).a(paramContext, parama1.nyw), parama.iCg);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.m.a(parama1.nyx, parama.ijE);
        AppMethodBeat.o(5819);
        return;
        com.tencent.mm.plugin.fts.ui.m.a(parama1.nyw, parama.iCg);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(5820);
      a locala = (a)paramVarArgs;
      a(a.this.sxM.syk, locala.jPN);
      if (com.tencent.mm.al.f.AR(locala.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("enterprise_biz_name", locala.username);
        paramVarArgs.putExtra("enterprise_biz_display_name", v.wk(locala.username));
        paramVarArgs.putExtra("enterprise_from_scene", 3);
        d.e(paramContext, ".ui.conversation.EnterpriseConversationUI", paramVarArgs);
      }
      for (;;)
      {
        ad.aAy(locala.username);
        AppMethodBeat.o(5820);
        return true;
        if (com.tencent.mm.al.f.so(locala.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", locala.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          d.e(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (com.tencent.mm.al.f.AS(locala.username))
          {
            paramVarArgs = com.tencent.mm.al.f.dX(locala.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = null;; paramVarArgs = paramVarArgs.IR())
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
          d.e(paramContext, ".ui.chatting.ChattingUI", paramVarArgs);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */