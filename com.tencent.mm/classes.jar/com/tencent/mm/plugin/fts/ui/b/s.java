package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.p.b;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;

public final class s
  extends m
{
  public o HAD;
  private a HBM;
  public int hAN;
  
  public s(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112112);
    this.HBM = new a();
    AppMethodBeat.o(112112);
  }
  
  public final a.b aXA()
  {
    return this.HBM;
  }
  
  public final int fxM()
  {
    int i = 2;
    if (this.HBm < 2) {
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(p.e.fts_message_item, paramViewGroup, false);
      m.a locala = (m.a)s.this.HBp;
      locala.lBC = ((ImageView)paramViewGroup.findViewById(p.d.avatar_iv));
      locala.lBD = ((TextView)paramViewGroup.findViewById(p.d.nickname_tv));
      locala.lNZ = ((TextView)paramViewGroup.findViewById(p.d.msg_tv));
      locala.rpv = paramViewGroup.findViewById(p.d.divider);
      locala.timeTV = ((TextView)paramViewGroup.findViewById(p.d.time_tv));
      locala.lBC.getLayoutParams().width = com.tencent.mm.cd.a.br(paramContext, p.b.SettingCatalogPadding);
      locala.lBC.getLayoutParams().height = com.tencent.mm.cd.a.br(paramContext, p.b.SettingCatalogPadding);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112110);
      return paramViewGroup;
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(265735);
      boolean bool = ((n)h.az(n.class)).getItemClickHandler(s.this.viewType).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(265735);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.s
 * JD-Core Version:    0.7.0.1
 */