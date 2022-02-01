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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends m
{
  private a rvx;
  CharSequence rvy;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112072);
    this.rvx = new a();
    AppMethodBeat.o(112072);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112073);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.XV(this.jpy.talker);
    parama = paramVarArgs;
    if (bt.isNullOrNil(paramVarArgs)) {
      parama = d.XV(this.jpy.roN);
    }
    this.rvy = k.d(paramContext, parama, b.c.rsM);
    AppMethodBeat.o(112073);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.rvx;
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131494215, paramViewGroup, false);
      m.a locala = (m.a)g.this.rvY;
      locala.frr = ((ImageView)paramViewGroup.findViewById(2131297008));
      locala.frs = ((TextView)paramViewGroup.findViewById(2131302867));
      locala.fwR = ((TextView)paramViewGroup.findViewById(2131302555));
      locala.jpE = paramViewGroup.findViewById(2131299154);
      locala.fwS = ((TextView)paramViewGroup.findViewById(2131305822));
      locala.frr.getLayoutParams().width = com.tencent.mm.cd.a.ao(paramContext, 2131165558);
      locala.frr.getLayoutParams().height = com.tencent.mm.cd.a.ao(paramContext, 2131165558);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112070);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112071);
      paramContext = (g)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jpE, g.this.rqz);
      if (bt.isNullOrNil(paramContext.jpy.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.frr, paramContext.jpy.roN);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.rvy, parama.frs);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.ibX, parama.fwR);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.rvW, parama.fwS);
        AppMethodBeat.o(112071);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.frr, paramContext.jpy.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */