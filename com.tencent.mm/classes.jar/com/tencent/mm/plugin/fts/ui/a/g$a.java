package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.n.b;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;

public final class g$a
  extends m.b
{
  public g$a(g paramg)
  {
    super(paramg);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(paramContext).inflate(n.e.fts_message_item, paramViewGroup, false);
    m.a locala = (m.a)this.kDe.kDF;
    locala.doU = ((ImageView)paramViewGroup.findViewById(n.d.avatar_iv));
    locala.doV = ((TextView)paramViewGroup.findViewById(n.d.nickname_tv));
    locala.dsy = ((TextView)paramViewGroup.findViewById(n.d.msg_tv));
    locala.contentView = paramViewGroup.findViewById(n.d.search_item_content_layout);
    locala.dsz = ((TextView)paramViewGroup.findViewById(n.d.time_tv));
    locala.doU.getLayoutParams().width = com.tencent.mm.cb.a.aa(paramContext, n.b.SettingCatalogPadding);
    locala.doU.getLayoutParams().height = com.tencent.mm.cb.a.aa(paramContext, n.b.SettingCatalogPadding);
    paramViewGroup.setTag(locala);
    return paramViewGroup;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    paramContext = (g)parama1;
    parama = (m.a)parama;
    com.tencent.mm.plugin.fts.ui.m.k(parama.contentView, this.kDe.kxT);
    if (bk.bl(paramContext.fYx.talker)) {
      a.b.a(parama.doU, paramContext.fYx.kwg);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.ui.m.a(paramContext.kDd, parama.doV);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext.eXL, parama.dsy);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext.kDD, parama.dsz);
      return;
      a.b.a(parama.doU, paramContext.fYx.talker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g.a
 * JD-Core Version:    0.7.0.1
 */