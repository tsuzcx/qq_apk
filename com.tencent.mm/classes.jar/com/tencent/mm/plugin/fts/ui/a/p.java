package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.o.b;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;

public final class p
  extends m
{
  public com.tencent.mm.plugin.fts.a.a.m BON;
  private a BPE;
  public int fwp;
  
  public p(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112112);
    this.BPE = new a();
    AppMethodBeat.o(112112);
  }
  
  public final a.b aEw()
  {
    return this.BPE;
  }
  
  public final int erf()
  {
    int i = 2;
    if (this.BPu < 2) {
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
      paramViewGroup = LayoutInflater.from(paramContext).inflate(o.e.fts_message_item, paramViewGroup, false);
      m.a locala = (m.a)p.this.BPx;
      locala.iZG = ((ImageView)paramViewGroup.findViewById(o.d.avatar_iv));
      locala.iZH = ((TextView)paramViewGroup.findViewById(o.d.nickname_tv));
      locala.jlh = ((TextView)paramViewGroup.findViewById(o.d.msg_tv));
      locala.olM = paramViewGroup.findViewById(o.d.divider);
      locala.timeTV = ((TextView)paramViewGroup.findViewById(o.d.time_tv));
      locala.iZG.getLayoutParams().width = com.tencent.mm.ci.a.aY(paramContext, o.b.SettingCatalogPadding);
      locala.iZG.getLayoutParams().height = com.tencent.mm.ci.a.aY(paramContext, o.b.SettingCatalogPadding);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112110);
      return paramViewGroup;
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(193394);
      boolean bool = ((n)h.ag(n.class)).getItemClickHandler(p.this.viewType).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(193394);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.p
 * JD-Core Version:    0.7.0.1
 */