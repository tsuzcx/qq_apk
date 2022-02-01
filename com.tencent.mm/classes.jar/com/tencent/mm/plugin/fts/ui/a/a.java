package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.ui.n;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence xcp;
  private b xcq;
  private a xcr;
  
  public a(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(112054);
    this.xcq = new b();
    this.xcr = new a();
    AppMethodBeat.o(112054);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112055);
    this.xcp = com.tencent.mm.plugin.fts.a.f.a(paramContext.getResources().getString(2131760997), "", e.c(this.wWd.wWB, this.wWd.wWB)).wWu;
    AppMethodBeat.o(112055);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.xcq;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View contentView;
    public ImageView nnL;
    public TextView xcs;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112052);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494774, paramViewGroup, false);
      paramViewGroup = new a.a(a.this);
      paramViewGroup.nnL = ((ImageView)paramContext.findViewById(2131302497));
      paramViewGroup.xcs = ((TextView)paramContext.findViewById(2131309163));
      paramViewGroup.contentView = paramContext.findViewById(2131307399);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112052);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112053);
      paramContext = (a.a)parama;
      n.r(paramContext.contentView, a.this.wXK);
      n.a(a.this.xcp, paramContext.xcs);
      paramContext.nnL.setImageResource(2131691439);
      AppMethodBeat.o(112053);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a
 * JD-Core Version:    0.7.0.1
 */