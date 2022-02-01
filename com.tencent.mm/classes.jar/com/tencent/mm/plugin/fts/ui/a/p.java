package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;

public final class p
  extends m
{
  public int dDG;
  public com.tencent.mm.plugin.fts.a.a.m xcP;
  private a xdG;
  
  public p(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112112);
    this.xdG = new a();
    AppMethodBeat.o(112112);
  }
  
  public final a.b axc()
  {
    return this.xdG;
  }
  
  public final int dOM()
  {
    int i = 2;
    if (this.xdw < 2) {
      i = 0;
    }
    return i;
  }
  
  public final class a
    extends m.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112110);
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131494770, paramViewGroup, false);
      m.a locala = (m.a)p.this.xdz;
      locala.gvv = ((ImageView)paramViewGroup.findViewById(2131297134));
      locala.gvw = ((TextView)paramViewGroup.findViewById(2131305440));
      locala.gBb = ((TextView)paramViewGroup.findViewById(2131304987));
      locala.lrc = paramViewGroup.findViewById(2131299682);
      locala.timeTV = ((TextView)paramViewGroup.findViewById(2131309101));
      locala.gvv.getLayoutParams().width = com.tencent.mm.cb.a.aG(paramContext, 2131165576);
      locala.gvv.getLayoutParams().height = com.tencent.mm.cb.a.aG(paramContext, 2131165576);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112110);
      return paramViewGroup;
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(235404);
      boolean bool = ((n)g.ah(n.class)).getItemClickHandler(p.this.qcr).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(235404);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.p
 * JD-Core Version:    0.7.0.1
 */