package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.f;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.sdk.platformtools.Log;

public class n
  extends a
{
  private a BPA;
  private b BPz;
  public String msn;
  
  public n(int paramInt)
  {
    super(8, paramInt);
    AppMethodBeat.i(112105);
    this.BPz = new b();
    this.BPA = new a();
    AppMethodBeat.o(112105);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112106);
    parama = com.tencent.mm.plugin.fts.ui.n.SI(this.uMD);
    if (parama == null) {}
    for (this.msn = "";; this.msn = paramContext.getResources().getString(o.g.search_contact_button_find_more, new Object[] { parama }))
    {
      Log.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[] { this.msn });
      AppMethodBeat.o(112106);
      return;
    }
  }
  
  public a.b aEw()
  {
    return this.BPz;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView qps;
    public TextView yZg;
    
    public a()
    {
      super();
    }
  }
  
  public class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112102);
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_more_item, paramViewGroup, false);
      paramViewGroup = new n.a(n.this);
      paramViewGroup.yZg = ((TextView)paramContext.findViewById(o.d.tip_tv));
      paramViewGroup.qps = ((ImageView)paramContext.findViewById(o.d.icon_iv));
      paramViewGroup.contentView = paramContext.findViewById(o.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112102);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112103);
      paramContext = (n.a)parama;
      parama = (n)parama1;
      com.tencent.mm.plugin.fts.ui.n.r(paramContext.contentView, n.this.BJG);
      paramContext.yZg.setText(parama.msn);
      paramContext.qps.setImageResource(o.f.fts_more_button_icon);
      AppMethodBeat.o(112103);
    }
    
    public boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(191934);
      paramView = new Intent();
      paramView.putExtra("detail_query", n.this.BHY.BIw);
      paramView.putExtra("detail_type", n.this.uMD);
      paramView.putExtra("Search_Scene", n.this.ptD);
      d.d(paramContext, ".ui.FTSDetailUI", paramView);
      AppMethodBeat.o(191934);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n
 * JD-Core Version:    0.7.0.1
 */