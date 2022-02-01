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
import com.tencent.mm.plugin.fts.ui.o.b;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends m
{
  private a BOW;
  CharSequence BOX;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112072);
    this.BOW = new a();
    AppMethodBeat.o(112072);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112073);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.azM(this.olG.talker);
    parama = paramVarArgs;
    if (Util.isNullOrNil(paramVarArgs)) {
      parama = d.azM(this.olG.BHS);
    }
    this.BOX = l.d(paramContext, parama, b.c.BLW);
    AppMethodBeat.o(112073);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.BOW;
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(o.e.fts_message_item, paramViewGroup, false);
      m.a locala = (m.a)g.this.BPx;
      locala.iZG = ((ImageView)paramViewGroup.findViewById(o.d.avatar_iv));
      locala.iZH = ((TextView)paramViewGroup.findViewById(o.d.nickname_tv));
      locala.jlh = ((TextView)paramViewGroup.findViewById(o.d.msg_tv));
      locala.olM = paramViewGroup.findViewById(o.d.divider);
      locala.timeTV = ((TextView)paramViewGroup.findViewById(o.d.time_tv));
      locala.iZG.getLayoutParams().width = com.tencent.mm.ci.a.aY(paramContext, o.b.SettingCatalogPadding);
      locala.iZG.getLayoutParams().height = com.tencent.mm.ci.a.aY(paramContext, o.b.SettingCatalogPadding);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112070);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112071);
      paramContext = (g)parama1;
      parama = (m.a)parama;
      n.q(parama.olM, g.this.BJG);
      if (Util.isNullOrNil(paramContext.olG.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, paramContext.olG.BHS);
      }
      for (;;)
      {
        n.a(paramContext.BOX, parama.iZH);
        n.a(paramContext.kLX, parama.jlh);
        n.a(paramContext.BPv, parama.timeTV);
        AppMethodBeat.o(112071);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.c(parama.iZG, paramContext.olG.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g
 * JD-Core Version:    0.7.0.1
 */