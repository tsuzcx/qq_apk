package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
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
    paramContext = LayoutInflater.from(paramContext).inflate(b.e.fts_biz_contact_item, paramViewGroup, false);
    paramViewGroup = (a.a)this.ieE.ieD;
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(b.d.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(b.d.title_tv));
    paramViewGroup.eXP = ((TextView)paramContext.findViewById(b.d.desc_tv));
    paramViewGroup.contentView = paramContext.findViewById(b.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    parama1 = (a)parama1;
    parama = (a.a)parama;
    m.k(parama.contentView, this.ieE.kxT);
    m.a(paramContext, parama.doU, parama1.iconUrl, null, b.c.brand_default_head);
    if (s.hb(parama1.username)) {
      m.a(((b)com.tencent.mm.kernel.g.r(b.class)).a(paramContext, parama1.ieA), parama.eXO);
    }
    for (;;)
    {
      m.a(parama1.ieB, parama.eXP);
      return;
      m.a(parama1.ieA, parama.eXO);
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    a locala = (a)paramVarArgs;
    a(this.ieE.kwi.kwG, locala.fYx);
    if (f.lc(locala.username))
    {
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("enterprise_biz_name", locala.username);
      paramVarArgs.putExtra("enterprise_biz_display_name", r.gV(locala.username));
      paramVarArgs.putExtra("enterprise_from_scene", 3);
      com.tencent.mm.br.d.e(paramContext, ".ui.conversation.EnterpriseConversationUI", paramVarArgs);
    }
    for (;;)
    {
      ai.Rx(locala.username);
      return true;
      if (f.eW(locala.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", locala.username);
        paramVarArgs.addFlags(67108864);
        paramVarArgs.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.br.d.e(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
      }
      else
      {
        if (f.ld(locala.username))
        {
          paramVarArgs = f.kX(locala.username);
          if (paramVarArgs == null) {}
          for (paramVarArgs = null;; paramVarArgs = paramVarArgs.LC())
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
            com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
            break;
          }
        }
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Chat_User", locala.username);
        paramVarArgs.putExtra("finish_direct", true);
        paramVarArgs.putExtra("specific_chat_from_scene", 3);
        com.tencent.mm.br.d.e(paramContext, ".ui.chatting.ChattingUI", paramVarArgs);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */