package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;

public final class c
  extends n
{
  c.a mYA;
  public boolean mYy;
  private b mYz;
  public int resId;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(61974);
    this.mYz = new b();
    this.mYA = new c.a(this);
    AppMethodBeat.o(61974);
  }
  
  public final a.b Pr()
  {
    return this.mYz;
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(61972);
      paramContext = LayoutInflater.from(paramContext).inflate(2130969649, paramViewGroup, false);
      paramViewGroup = (c.a)c.this.mYA;
      paramViewGroup.mYB = ((TextView)paramContext.findViewById(2131824335));
      paramViewGroup.mYC = ((ImageView)paramContext.findViewById(2131824336));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(61972);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(61973);
      parama = (c.a)parama;
      parama1 = (c)parama1;
      paramContext = paramContext.getResources();
      if (c.this.mYy)
      {
        m.a(paramContext.getString(2131303016, new Object[] { paramContext.getString(parama1.resId) }), parama.mYB);
        parama.mYC.setRotation(0.0F);
        AppMethodBeat.o(61973);
        return;
      }
      m.a(paramContext.getString(2131303017), parama.mYB);
      parama.mYC.setRotation(180.0F);
      AppMethodBeat.o(61973);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.c
 * JD-Core Version:    0.7.0.1
 */