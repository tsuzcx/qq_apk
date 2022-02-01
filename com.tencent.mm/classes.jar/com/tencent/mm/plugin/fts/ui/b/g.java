package com.tencent.mm.plugin.fts.ui.b;

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
import com.tencent.mm.plugin.fts.ui.p.b;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends m
{
  private a HAM;
  CharSequence HAN;
  
  public g(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112072);
    this.HAM = new a();
    AppMethodBeat.o(112072);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112073);
    super.a(paramContext, parama, paramVarArgs);
    paramVarArgs = d.atS(this.rpp.talker);
    parama = paramVarArgs;
    if (Util.isNullOrNil(paramVarArgs)) {
      parama = d.atS(this.rpp.Hsz);
    }
    this.HAN = p.d(paramContext, parama, b.c.HwS);
    AppMethodBeat.o(112073);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HAM;
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(p.e.fts_message_item, paramViewGroup, false);
      m.a locala = (m.a)g.this.HBp;
      locala.lBC = ((ImageView)paramViewGroup.findViewById(p.d.avatar_iv));
      locala.lBD = ((TextView)paramViewGroup.findViewById(p.d.nickname_tv));
      locala.lNZ = ((TextView)paramViewGroup.findViewById(p.d.msg_tv));
      locala.rpv = paramViewGroup.findViewById(p.d.divider);
      locala.timeTV = ((TextView)paramViewGroup.findViewById(p.d.time_tv));
      locala.lBC.getLayoutParams().width = com.tencent.mm.cd.a.br(paramContext, p.b.SettingCatalogPadding);
      locala.lBC.getLayoutParams().height = com.tencent.mm.cd.a.br(paramContext, p.b.SettingCatalogPadding);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112070);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112071);
      paramContext = (g)parama1;
      parama = (m.a)parama;
      com.tencent.mm.plugin.fts.ui.o.w(parama.rpv, g.this.Hup);
      if (Util.isNullOrNil(paramContext.rpp.talker)) {
        com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, paramContext.rpp.Hsz);
      }
      for (;;)
      {
        com.tencent.mm.plugin.fts.ui.o.a(paramContext.HAN, parama.lBD);
        com.tencent.mm.plugin.fts.ui.o.a(paramContext.nnT, parama.lNZ);
        com.tencent.mm.plugin.fts.ui.o.a(paramContext.HBn, parama.timeTV);
        AppMethodBeat.o(112071);
        return;
        com.tencent.mm.pluginsdk.ui.a.b.g(parama.lBC, paramContext.rpp.talker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.g
 * JD-Core Version:    0.7.0.1
 */