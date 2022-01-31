package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class m$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public m$b(m paramm)
  {
    super(paramm);
  }
  
  public View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_message_item, paramViewGroup, false);
    paramViewGroup = (m.a)this.kDG.kDF;
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(n.d.avatar_iv));
    paramViewGroup.doV = ((TextView)paramContext.findViewById(n.d.nickname_tv));
    paramViewGroup.dsy = ((TextView)paramContext.findViewById(n.d.msg_tv));
    paramViewGroup.dsz = ((TextView)paramContext.findViewById(n.d.time_tv));
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    parama1 = (m)parama1;
    parama = (m.a)parama;
    com.tencent.mm.plugin.fts.ui.m.k(parama.contentView, this.kDG.kxT);
    com.tencent.mm.pluginsdk.ui.a.b.a(parama.doU, parama1.username);
    com.tencent.mm.plugin.fts.ui.m.a(parama1.eXL, parama.dsy);
    com.tencent.mm.plugin.fts.ui.m.a(parama1.kDD, parama.dsz);
    if (s.hb(parama1.username))
    {
      com.tencent.mm.plugin.fts.ui.m.a(((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.eXK), parama.doV);
      return;
    }
    if (ad.aaU(parama1.username))
    {
      g.DQ();
      paramContext = ((j)g.r(j.class)).Fw().abl(parama1.username);
      ((com.tencent.mm.openim.a.b)g.r(com.tencent.mm.openim.a.b.class)).a(parama.doV.getContext(), parama.doV, parama1.eXK, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.doV.getTextSize());
      return;
    }
    com.tencent.mm.plugin.fts.ui.m.a(parama1.eXK, parama.doV);
  }
  
  public boolean a(Context paramContext, a paramVarArgs)
  {
    return ((n)g.t(n.class)).getItemClickHandler(this.kDG.ivk).a(paramContext, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m.b
 * JD-Core Version:    0.7.0.1
 */