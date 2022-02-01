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
import com.tencent.mm.plugin.fts.ui.m;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence sDI;
  private b sDJ;
  private a sDK;
  
  public a(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(112054);
    this.sDJ = new b();
    this.sDK = new a();
    AppMethodBeat.o(112054);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112055);
    this.sDI = com.tencent.mm.plugin.fts.a.f.a(paramContext.getResources().getString(2131759676), "", e.c(this.sxM.syk, this.sxM.syk)).syd;
    AppMethodBeat.o(112055);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.sDJ;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View contentView;
    public ImageView lzC;
    public TextView sDL;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494219, paramViewGroup, false);
      paramViewGroup = new a.a(a.this);
      paramViewGroup.lzC = ((ImageView)paramContext.findViewById(2131300891));
      paramViewGroup.sDL = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112052);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112053);
      paramContext = (a.a)parama;
      m.q(paramContext.contentView, a.this.szt);
      m.a(a.this.sDI, paramContext.sDL);
      paramContext.lzC.setImageResource(2131691130);
      AppMethodBeat.o(112053);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a
 * JD-Core Version:    0.7.0.1
 */