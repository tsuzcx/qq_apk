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

public final class l$b
  extends a.b
{
  public l$b(l paraml)
  {
    super(paraml);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(n.e.fts_info_item, paramViewGroup, false);
    paramViewGroup = (l.a)this.kDB.kDA;
    paramViewGroup.kDb = ((TextView)paramContext.findViewById(n.d.info_tv));
    paramViewGroup.kCO = paramContext.findViewById(n.d.padding_view);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (l.a)parama;
    m.a(this.kDB.kDy, paramContext.kDb);
    if (this.kDB.position == 0)
    {
      paramContext.kCO.setVisibility(8);
      return;
    }
    paramContext.kCO.setVisibility(0);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l.b
 * JD-Core Version:    0.7.0.1
 */