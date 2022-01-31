package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.model.s;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.n.c;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public final class q$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public q$b(q paramq)
  {
    super(paramq);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_contact_item, paramViewGroup, false);
    paramViewGroup = (q.a)this.kDS.kDR;
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(n.d.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(n.d.title_tv));
    paramViewGroup.eXP = ((TextView)paramContext.findViewById(n.d.desc_tv));
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    parama = (q.a)parama;
    parama1 = (q)parama1;
    com.tencent.mm.plugin.fts.ui.m.k(parama.contentView, this.kDS.kxT);
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.doU, parama1.username);
      if (!s.hb(parama1.username)) {
        break label128;
      }
      com.tencent.mm.plugin.fts.ui.m.a(((b)com.tencent.mm.kernel.g.r(b.class)).a(paramContext, parama1.ieA), parama.eXO);
    }
    for (;;)
    {
      parama.eXO.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(paramContext, 200));
      com.tencent.mm.plugin.fts.ui.m.a(parama1.ieB, parama.eXP);
      return;
      parama.doU.setImageResource(n.c.default_avatar);
      break;
      label128:
      com.tencent.mm.plugin.fts.ui.m.a(parama1.ieA, parama.eXO);
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    paramVarArgs = (q)paramVarArgs;
    a(this.kDS.kwi.kwG, paramVarArgs.fYx);
    Intent localIntent = new Intent().putExtra("Chat_User", paramVarArgs.username).putExtra("finish_direct", true);
    if (s.hb(paramVarArgs.username))
    {
      com.tencent.mm.h.b.a.m localm = new com.tencent.mm.h.b.a.m();
      localm.ciU = paramVarArgs.username;
      localm.ciV = 3L;
      localm.QX();
    }
    d.e(paramContext, ".ui.chatting.ChattingUI", localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.q.b
 * JD-Core Version:    0.7.0.1
 */