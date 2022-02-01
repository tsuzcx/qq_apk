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
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends m
{
  private a sEp;
  CharSequence sEq;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112072);
    this.sEp = new a();
    AppMethodBeat.o(112072);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112073);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.acr(this.jPN.talker);
    parama = paramVarArgs;
    if (bs.isNullOrNil(paramVarArgs)) {
      parama = d.acr(this.jPN.sxG);
    }
    this.sEq = k.d(paramContext, parama, b.c.sBG);
    AppMethodBeat.o(112073);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.sEp;
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
      m.a locala = (m.a)g.this.sEQ;
      locala.fuY = ((ImageView)paramViewGroup.findViewById(2131297008));
      locala.fuZ = ((TextView)paramViewGroup.findViewById(2131302867));
      locala.fAy = ((TextView)paramViewGroup.findViewById(2131302555));
      locala.jPT = paramViewGroup.findViewById(2131299154);
      locala.fAz = ((TextView)paramViewGroup.findViewById(2131305822));
      locala.fuY.getLayoutParams().width = com.tencent.mm.cc.a.au(paramContext, 2131165558);
      locala.fuY.getLayoutParams().height = com.tencent.mm.cc.a.au(paramContext, 2131165558);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112070);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112071);
      paramContext = (g)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jPT, g.this.szt);
      if (bs.isNullOrNil(paramContext.jPN.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fuY, paramContext.jPN.sxG);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.sEq, parama.fuZ);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.gIg, parama.fAy);
        com.tencent.mm.plugin.fts.ui.m.a(paramContext.sEO, parama.fAz);
        AppMethodBeat.o(112071);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fuY, paramContext.jPN.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */