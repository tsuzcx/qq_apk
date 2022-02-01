package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends m
{
  private a xcY;
  CharSequence xcZ;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112072);
    this.xcY = new a();
    AppMethodBeat.o(112072);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112073);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.arL(this.lqW.talker);
    parama = paramVarArgs;
    if (Util.isNullOrNil(paramVarArgs)) {
      parama = d.arL(this.lqW.wVX);
    }
    this.xcZ = l.d(paramContext, parama, b.c.wZX);
    AppMethodBeat.o(112073);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.xcY;
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
      AppMethodBeat.i(112070);
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131494770, paramViewGroup, false);
      m.a locala = (m.a)g.this.xdz;
      locala.gvv = ((ImageView)paramViewGroup.findViewById(2131297134));
      locala.gvw = ((TextView)paramViewGroup.findViewById(2131305440));
      locala.gBb = ((TextView)paramViewGroup.findViewById(2131304987));
      locala.lrc = paramViewGroup.findViewById(2131299682);
      locala.timeTV = ((TextView)paramViewGroup.findViewById(2131309101));
      locala.gvv.getLayoutParams().width = com.tencent.mm.cb.a.aG(paramContext, 2131165576);
      locala.gvv.getLayoutParams().height = com.tencent.mm.cb.a.aG(paramContext, 2131165576);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112070);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112071);
      paramContext = (g)parama1;
      parama = (m.a)parama;
      n.q(parama.lrc, g.this.wXK);
      if (Util.isNullOrNil(paramContext.lqW.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, paramContext.lqW.wVX);
      }
      for (;;)
      {
        n.a(paramContext.xcZ, parama.gvw);
        n.a(paramContext.hXr, parama.gBb);
        n.a(paramContext.xdx, parama.timeTV);
        AppMethodBeat.o(112071);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.gvv, paramContext.lqW.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */