package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;
import com.tencent.mm.plugin.fts.ui.n.f;

public final class a$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_search_contact_item, paramViewGroup, false);
    paramViewGroup = new a.a(this.kCw);
    paramViewGroup.gSx = ((ImageView)paramContext.findViewById(n.d.icon_iv));
    paramViewGroup.kCv = ((TextView)paramContext.findViewById(n.d.tip_tv));
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    paramContext = (a.a)parama;
    m.k(paramContext.contentView, this.kCw.kxT);
    m.a(this.kCw.kCs, paramContext.kCv);
    paramContext.gSx.setImageResource(n.f.search_add_icon_green);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */