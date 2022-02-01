package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.f;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.sdk.platformtools.Log;

public class n
  extends a
{
  private b HBr;
  private a HBs;
  public String plR;
  
  public n(int paramInt)
  {
    super(8, paramInt);
    AppMethodBeat.i(112105);
    this.HBr = new b();
    this.HBs = new a();
    AppMethodBeat.o(112105);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112106);
    parama = o.Wp(this.xVf);
    if (parama == null) {}
    for (this.plR = "";; this.plR = paramContext.getResources().getString(p.g.search_contact_button_find_more, new Object[] { parama }))
    {
      Log.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[] { this.plR });
      AppMethodBeat.o(112106);
      return;
    }
  }
  
  public a.b aXA()
  {
    return this.HBr;
  }
  
  public final class a
    extends a.a
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
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112102);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_more_item, paramViewGroup, false);
      paramViewGroup = new n.a(n.this);
      paramViewGroup.DSB = ((TextView)paramContext.findViewById(p.d.tip_tv));
      paramViewGroup.ttT = ((ImageView)paramContext.findViewById(p.d.icon_iv));
      paramViewGroup.contentView = paramContext.findViewById(p.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112102);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112103);
      paramContext = (n.a)parama;
      parama = (n)parama1;
      o.x(paramContext.contentView, n.this.Hup);
      paramContext.DSB.setText(parama.plR);
      paramContext.ttT.setImageResource(p.f.fts_more_button_icon);
      AppMethodBeat.o(112103);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(265724);
      paramView = new Intent();
      paramView.putExtra("detail_query", n.this.FWt.Hte);
      paramView.putExtra("detail_type", n.this.xVf);
      paramView.putExtra("Search_Scene", n.this.syO);
      d.d(paramContext, ".ui.FTSDetailUI", paramView);
      AppMethodBeat.o(265724);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.n
 * JD-Core Version:    0.7.0.1
 */