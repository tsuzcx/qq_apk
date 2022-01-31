package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.h.a.gf;
import com.tencent.mm.h.a.gf.a;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.ui.MMImageView;

public final class a$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.f.fts_favorite_item, paramViewGroup, false);
    paramViewGroup = (a.a)this.kha.kgW;
    paramViewGroup.kgX = ((MMImageView)paramContext.findViewById(n.e.avatar_iv));
    paramViewGroup.eXO = ((TextView)paramContext.findViewById(n.e.title_tv));
    paramViewGroup.kgY = ((TextView)paramContext.findViewById(n.e.abstract_tv));
    paramViewGroup.kgZ = ((TextView)paramContext.findViewById(n.e.status_tv));
    paramViewGroup.contentView = paramContext.findViewById(n.e.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    parama = (a.a)parama;
    parama1 = (a)parama1;
    m.k(parama.contentView, this.kha.kxT);
    m.a(paramContext, parama.kgX, parama1.foS, parama1.kgT, parama1.kgU, false, parama.kgX.getMeasuredWidth(), parama.kgX.getMeasuredHeight());
    a.a(parama.eXO, parama.kgY, this.kha.kgQ, this.kha.kgR);
    m.a(this.kha.kgS, parama.kgZ);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    paramVarArgs = (a)paramVarArgs;
    gf localgf = new gf();
    localgf.bNF.type = 10;
    localgf.bNF.bIr = paramVarArgs.fYx.kxk;
    localgf.bNF.context = paramContext;
    localgf.bNF.bNQ = new yl();
    if (this.kha.pageType == 1) {}
    for (localgf.bNF.bNQ.scene = 3;; localgf.bNF.bNQ.scene = 4)
    {
      localgf.bNF.bNQ.jYS = 3;
      localgf.bNF.bNQ.index = this.kha.kxW;
      com.tencent.mm.sdk.b.a.udP.m(localgf);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.b.a.b
 * JD-Core Version:    0.7.0.1
 */