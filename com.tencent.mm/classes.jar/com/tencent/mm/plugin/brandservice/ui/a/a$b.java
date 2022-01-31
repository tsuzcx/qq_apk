package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.websearch.api.ai;

public final class a$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(14081);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969645, paramViewGroup, false);
    paramViewGroup = (a.a)this.jVr.jVq;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.hrR = paramContext.findViewById(2131821148);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(14081);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(14082);
    parama1 = (a)parama1;
    parama = (a.a)parama;
    m.p(parama.hrR, this.jVr.mTH);
    m.a(paramContext, parama.egq, parama1.iconUrl, null, 2130838028);
    if (t.nK(parama1.username)) {
      m.a(((b)com.tencent.mm.kernel.g.E(b.class)).a(paramContext, parama1.jVn), parama.gpL);
    }
    for (;;)
    {
      m.a(parama1.jVo, parama.gpM);
      AppMethodBeat.o(14082);
      return;
      m.a(parama1.jVn, parama.gpL);
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(14083);
    a locala = (a)paramVarArgs;
    a(this.jVr.mRX.mSw, locala.hrL);
    if (f.rX(locala.username))
    {
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("enterprise_biz_name", locala.username);
      paramVarArgs.putExtra("enterprise_biz_display_name", s.nE(locala.username));
      paramVarArgs.putExtra("enterprise_from_scene", 3);
      com.tencent.mm.bq.d.f(paramContext, ".ui.conversation.EnterpriseConversationUI", paramVarArgs);
    }
    for (;;)
    {
      ai.agy(locala.username);
      AppMethodBeat.o(14083);
      return true;
      if (f.lg(locala.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", locala.username);
        paramVarArgs.addFlags(67108864);
        paramVarArgs.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.bq.d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
      }
      else
      {
        if (f.rY(locala.username))
        {
          paramVarArgs = f.rS(locala.username);
          if (paramVarArgs == null) {}
          for (paramVarArgs = null;; paramVarArgs = paramVarArgs.aek())
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
            com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
            break;
          }
        }
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Chat_User", locala.username);
        paramVarArgs.putExtra("finish_direct", true);
        paramVarArgs.putExtra("specific_chat_from_scene", 3);
        paramVarArgs.putExtra("preChatTYPE", 9);
        com.tencent.mm.bq.d.f(paramContext, ".ui.chatting.ChattingUI", paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */