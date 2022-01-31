package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.g;

public final class c$b
  extends a.b
{
  public c$b(c paramc)
  {
    super(paramc);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_collapse_more_item, paramViewGroup, false);
    paramViewGroup = (c.a)this.kCH.kCE;
    paramViewGroup.kCF = ((TextView)paramContext.findViewById(n.d.more_tv));
    paramViewGroup.kCG = ((ImageView)paramContext.findViewById(n.d.more_arrow));
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    parama = (c.a)parama;
    parama1 = (c)parama1;
    paramContext = paramContext.getResources();
    if (this.kCH.kCC)
    {
      m.a(paramContext.getString(n.g.search_more_contact, new Object[] { paramContext.getString(parama1.kCB) }), parama.kCF);
      parama.kCG.setRotation(0.0F);
      return;
    }
    m.a(paramContext.getString(n.g.search_more_contact_collapse), parama.kCF);
    parama.kCG.setRotation(180.0F);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.c.b
 * JD-Core Version:    0.7.0.1
 */