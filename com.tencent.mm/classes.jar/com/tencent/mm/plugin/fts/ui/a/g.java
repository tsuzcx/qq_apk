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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends m
{
  private a tBg;
  CharSequence tBh;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112072);
    this.tBg = new a();
    AppMethodBeat.o(112072);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112073);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.agg(this.kjY.talker);
    parama = paramVarArgs;
    if (bt.isNullOrNil(paramVarArgs)) {
      parama = d.agg(this.kjY.tuh);
    }
    this.tBh = k.d(paramContext, parama, b.c.tyh);
    AppMethodBeat.o(112073);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.tBg;
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
      m.a locala = (m.a)g.this.tBI;
      locala.fOf = ((ImageView)paramViewGroup.findViewById(2131297008));
      locala.fOg = ((TextView)paramViewGroup.findViewById(2131302867));
      locala.fTO = ((TextView)paramViewGroup.findViewById(2131302555));
      locala.kke = paramViewGroup.findViewById(2131299154);
      locala.fTP = ((TextView)paramViewGroup.findViewById(2131305822));
      locala.fOf.getLayoutParams().width = com.tencent.mm.cc.a.ax(paramContext, 2131165558);
      locala.fOf.getLayoutParams().height = com.tencent.mm.cc.a.ax(paramContext, 2131165558);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112070);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112071);
      paramContext = (g)parama1;
      parama = (m.a)parama;
      n.p(parama.kke, g.this.tvU);
      if (bt.isNullOrNil(paramContext.kjY.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, paramContext.kjY.tuh);
      }
      for (;;)
      {
        n.a(paramContext.tBh, parama.fOg);
        n.a(paramContext.hbQ, parama.fTO);
        n.a(paramContext.tBG, parama.fTP);
        AppMethodBeat.o(112071);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fOf, paramContext.kjY.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */