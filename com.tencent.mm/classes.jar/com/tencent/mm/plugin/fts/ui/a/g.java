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
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  extends m
{
  private a tLX;
  CharSequence tLY;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112072);
    this.tLX = new a();
    AppMethodBeat.o(112072);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112073);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.ahd(this.kno.talker);
    parama = paramVarArgs;
    if (bu.isNullOrNil(paramVarArgs)) {
      parama = d.ahd(this.kno.tEY);
    }
    this.tLY = k.d(paramContext, parama, b.c.tIY);
    AppMethodBeat.o(112073);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.tLX;
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
      m.a locala = (m.a)g.this.tMz;
      locala.fQl = ((ImageView)paramViewGroup.findViewById(2131297008));
      locala.fQm = ((TextView)paramViewGroup.findViewById(2131302867));
      locala.fVU = ((TextView)paramViewGroup.findViewById(2131302555));
      locala.knu = paramViewGroup.findViewById(2131299154);
      locala.fVV = ((TextView)paramViewGroup.findViewById(2131305822));
      locala.fQl.getLayoutParams().width = com.tencent.mm.cb.a.ax(paramContext, 2131165558);
      locala.fQl.getLayoutParams().height = com.tencent.mm.cb.a.ax(paramContext, 2131165558);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112070);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112071);
      paramContext = (g)parama1;
      parama = (m.a)parama;
      n.p(parama.knu, g.this.tGL);
      if (bu.isNullOrNil(paramContext.kno.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, paramContext.kno.tEY);
      }
      for (;;)
      {
        n.a(paramContext.tLY, parama.fQm);
        n.a(paramContext.heE, parama.fVU);
        n.a(paramContext.tMx, parama.fVV);
        AppMethodBeat.o(112071);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, paramContext.kno.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */