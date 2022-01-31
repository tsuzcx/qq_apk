package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public abstract class b$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public b$b(b paramb)
  {
    super(paramb);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_contact_item, paramViewGroup, false);
    paramViewGroup = (b.a)this.kCA.kCy;
    paramViewGroup.doU = ((ImageView)paramContext.findViewById(n.d.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(n.d.title_tv));
    paramViewGroup.eXP = ((TextView)paramContext.findViewById(n.d.desc_tv));
    paramViewGroup.kCz = ((TextView)paramContext.findViewById(n.d.item_desc_tv));
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (b.a)parama;
    parama = (b)parama1;
    m.k(paramContext.contentView, this.kCA.kxT);
    com.tencent.mm.pluginsdk.ui.a.b.a(paramContext.doU, parama.username);
    m.a(parama.ieA, paramContext.eXO);
    m.a(parama.ieB, paramContext.eXP);
    m.a(parama.kCx, paramContext.kCz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b.b
 * JD-Core Version:    0.7.0.1
 */