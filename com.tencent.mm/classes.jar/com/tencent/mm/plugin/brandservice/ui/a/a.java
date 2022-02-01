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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public com.tencent.mm.storage.af contact;
  public String iconUrl;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public CharSequence mVX;
  public CharSequence mVY;
  private b mVZ;
  a mWa;
  public String username;
  
  public a(int paramInt)
  {
    super(4, paramInt);
    AppMethodBeat.i(5821);
    this.mVZ = new b();
    this.mWa = new a();
    AppMethodBeat.o(5821);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(5822);
    super.a(paramContext, parama, paramVarArgs);
    this.username = this.jpy.roN;
    this.contact = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.username);
    Object localObject = com.tencent.mm.am.f.ei(this.username);
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
      str = v.sh(this.username);
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
      if ((localObject != null) && (!((c)localObject).Jk())) {
        break label363;
      }
    }
    label274:
    label363:
    for (int i = 1;; i = 0) {
      switch (this.jpy.roM)
      {
      default: 
        bool1 = bool5;
        bool2 = bool6;
        if (k == 0) {
          break label591;
        }
        this.mVX = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, str, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        this.mVX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mVX, this.roS, bool1, bool2)).rpj;
        if (this.oEL == -8) {
          this.mVY = paramContext.getString(2131759679);
        }
        if ((j != 0) && (i != 0))
        {
          this.mVY = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, paramVarArgs, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
          this.mVY = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mVY, this.roS, bool1, bool2)).rpj;
          this.mVY = TextUtils.concat(new CharSequence[] { parama, this.mVY });
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
      paramVarArgs = this.contact.Ss();
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
      localObject = ((com.tencent.mm.api.m)g.ab(com.tencent.mm.api.m.class)).ed(this.username).iterator();
      while (((Iterator)localObject).hasNext())
      {
        this.mVY = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, (String)((Iterator)localObject).next(), com.tencent.mm.cd.a.ao(paramContext, 2131165517));
        com.tencent.mm.plugin.fts.a.a.f localf = com.tencent.mm.plugin.fts.a.f.a(e.a(this.mVY, this.roS, bool3, bool2));
        if (localf.bRZ == 0) {
          this.mVY = localf.rpj;
        }
      }
      this.mVY = TextUtils.concat(new CharSequence[] { this.mVY, paramContext.getString(2131762902) + str });
      bool1 = bool3;
      break;
      this.mVX = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, str, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
      break label274;
      bool2 = false;
      break label372;
      bool2 = false;
    }
  }
  
  public final String aWt()
  {
    AppMethodBeat.i(5823);
    if (this.mVX != null)
    {
      String str = this.mVX.toString();
      AppMethodBeat.o(5823);
      return str;
    }
    AppMethodBeat.o(5823);
    return "";
  }
  
  public final int aWu()
  {
    return this.jpy.rqc;
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.mVZ;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
    public View jpE;
    
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
      paramViewGroup = (a.a)a.this.mWa;
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.jpE = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(5818);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(5819);
      parama1 = (a)parama1;
      parama = (a.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jpE, a.this.rqz);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext, parama.frr, parama1.iconUrl, null, 2131231342, true);
      if (w.so(parama1.username)) {
        com.tencent.mm.plugin.fts.ui.m.a(((b)g.ab(b.class)).a(paramContext, parama1.mVX), parama.ica);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.m.a(parama1.mVY, parama.hJe);
        AppMethodBeat.o(5819);
        return;
        com.tencent.mm.plugin.fts.ui.m.a(parama1.mVX, parama.ica);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(5820);
      a locala = (a)paramVarArgs;
      a(a.this.roS.rpq, locala.jpy);
      if (com.tencent.mm.am.f.wL(locala.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("enterprise_biz_name", locala.username);
        paramVarArgs.putExtra("enterprise_biz_display_name", v.sh(locala.username));
        paramVarArgs.putExtra("enterprise_from_scene", 3);
        d.e(paramContext, ".ui.conversation.EnterpriseConversationUI", paramVarArgs);
      }
      for (;;)
      {
        com.tencent.mm.plugin.websearch.api.af.avh(locala.username);
        AppMethodBeat.o(5820);
        return true;
        if (com.tencent.mm.am.f.pc(locala.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", locala.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          d.e(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (com.tencent.mm.am.f.wM(locala.username))
          {
            paramVarArgs = com.tencent.mm.am.f.ei(locala.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = null;; paramVarArgs = paramVarArgs.Ji())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a
 * JD-Core Version:    0.7.0.1
 */