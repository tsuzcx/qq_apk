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

public final class c
  extends n
{
  public int resId;
  private b tLx;
  a tLy;
  public boolean tdC;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112058);
    this.tLx = new b();
    this.tLy = new a();
    AppMethodBeat.o(112058);
  }
  
  public final a.b agQ()
  {
    return this.tLx;
  }
  
  public final class a
    extends a.a
  {
    public TextView sDp;
    public ImageView tLz;
    
    public a()
    {
      super();
    }
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
      AppMethodBeat.i(112056);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494191, paramViewGroup, false);
      paramViewGroup = (c.a)c.this.tLy;
      paramViewGroup.sDp = ((TextView)paramContext.findViewById(2131302483));
      paramViewGroup.tLz = ((ImageView)paramContext.findViewById(2131302455));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112056);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112057);
      parama = (c.a)parama;
      parama1 = (c)parama1;
      paramContext = paramContext.getResources();
      if (c.this.tdC)
      {
        com.tencent.mm.plugin.fts.ui.n.a(paramContext.getString(2131762958, new Object[] { paramContext.getString(parama1.resId) }), parama.sDp);
        parama.tLz.setRotation(0.0F);
        AppMethodBeat.o(112057);
        return;
      }
      com.tencent.mm.plugin.fts.ui.n.a(paramContext.getString(2131762959), parama.sDp);
      parama.tLz.setRotation(180.0F);
      AppMethodBeat.o(112057);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.c
 * JD-Core Version:    0.7.0.1
 */