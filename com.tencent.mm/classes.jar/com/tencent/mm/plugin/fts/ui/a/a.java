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
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.f;
import com.tencent.mm.plugin.fts.ui.o.g;

public final class a
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence BOo;
  private b BOp;
  private a BOq;
  
  public a(int paramInt)
  {
    super(7, paramInt);
    AppMethodBeat.i(112054);
    this.BOp = new b();
    this.BOq = new a();
    AppMethodBeat.o(112054);
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112055);
    this.BOo = com.tencent.mm.plugin.fts.a.f.a(paramContext.getResources().getString(o.g.fts_find_comm_tip_prefix), "", e.c(this.BHY.BIw, this.BHY.BIw)).BIp;
    AppMethodBeat.o(112055);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b aEw()
  {
    return this.BOp;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.a
  {
    public View contentView;
    public ImageView qps;
    public TextView yZg;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_search_contact_item, paramViewGroup, false);
      paramViewGroup = new a.a(a.this);
      paramViewGroup.qps = ((ImageView)paramContext.findViewById(o.d.icon_iv));
      paramViewGroup.yZg = ((TextView)paramContext.findViewById(o.d.tip_tv));
      paramViewGroup.contentView = paramContext.findViewById(o.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112052);
      return paramContext;
    }
    
    public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112053);
      paramContext = (a.a)parama;
      n.r(paramContext.contentView, a.this.BJG);
      n.a(a.this.BOo, paramContext.yZg);
      paramContext.qps.setImageResource(o.f.search_add_icon_green);
      AppMethodBeat.o(112053);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a
 * JD-Core Version:    0.7.0.1
 */