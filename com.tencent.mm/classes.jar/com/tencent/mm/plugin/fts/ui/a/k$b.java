package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.d;
import com.tencent.mm.plugin.fts.ui.n.e;

public final class k$b
  extends a.b
{
  public k$b(k paramk)
  {
    super(paramk);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_header_item, paramViewGroup, false);
    paramViewGroup = (k.a)this.kDx.afK();
    paramViewGroup.iCG = ((TextView)paramContext.findViewById(n.d.header_tv));
    paramViewGroup.kCO = paramContext.findViewById(n.d.padding_view);
    paramViewGroup.contentView = paramContext.findViewById(n.d.search_item_content_layout);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (k.a)parama;
    m.a(this.kDx.kDu, paramContext.iCG);
    if (this.kDx.position == 0) {
      paramContext.kCO.setVisibility(8);
    }
    for (;;)
    {
      m.l(paramContext.contentView, this.kDx.kxT);
      return;
      paramContext.kCO.setVisibility(0);
    }
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k.b
 * JD-Core Version:    0.7.0.1
 */