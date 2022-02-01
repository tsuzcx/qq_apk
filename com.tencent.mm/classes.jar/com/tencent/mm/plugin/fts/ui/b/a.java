package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.f;
import com.tencent.mm.plugin.fts.ui.p.g;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence HAg;
  private b HAh;
  private a HAi;
  
  public a(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(112054);
    this.HAh = new b();
    this.HAi = new a();
    AppMethodBeat.o(112054);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112055);
    this.HAg = f.a(paramContext.getResources().getString(p.g.fts_find_comm_tip_prefix), "", g.c(this.FWt.Hte, this.FWt.Hte)).HsX;
    AppMethodBeat.o(112055);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aXA()
  {
    return this.HAh;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public TextView DSB;
    public View contentView;
    public ImageView ttT;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_search_contact_item, paramViewGroup, false);
      paramViewGroup = new a.a(a.this);
      paramViewGroup.ttT = ((ImageView)paramContext.findViewById(p.d.icon_iv));
      paramViewGroup.DSB = ((TextView)paramContext.findViewById(p.d.tip_tv));
      paramViewGroup.contentView = paramContext.findViewById(p.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112052);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112053);
      paramContext = (a.a)parama;
      o.x(paramContext.contentView, a.this.Hup);
      o.a(a.this.HAg, paramContext.DSB);
      paramContext.ttT.setImageResource(p.f.search_add_icon_green);
      AppMethodBeat.o(112053);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.a
 * JD-Core Version:    0.7.0.1
 */