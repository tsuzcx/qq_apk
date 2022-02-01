package com.tencent.mm.plugin.fts.ui.b;

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
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;

public final class c
  extends n
{
  public boolean Gxy;
  private b HAm;
  a HAn;
  public int resId;
  
  public c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112058);
    this.HAm = new b();
    this.HAn = new a();
    AppMethodBeat.o(112058);
  }
  
  public final a.b aXA()
  {
    return this.HAm;
  }
  
  public final class a
    extends a.a
  {
    public TextView FwJ;
    public ImageView HAo;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_collapse_more_item, paramViewGroup, false);
      paramViewGroup = (c.a)c.this.HAn;
      paramViewGroup.FwJ = ((TextView)paramContext.findViewById(p.d.more_tv));
      paramViewGroup.HAo = ((ImageView)paramContext.findViewById(p.d.more_arrow));
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
      if (c.this.Gxy)
      {
        o.b(paramContext.getString(p.g.search_more_contact, new Object[] { paramContext.getString(parama1.resId) }), parama.FwJ);
        parama.HAo.setRotation(0.0F);
        AppMethodBeat.o(112057);
        return;
      }
      o.b(paramContext.getString(p.g.search_more_contact_collapse), parama.FwJ);
      parama.HAo.setRotation(180.0F);
      AppMethodBeat.o(112057);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.c
 * JD-Core Version:    0.7.0.1
 */