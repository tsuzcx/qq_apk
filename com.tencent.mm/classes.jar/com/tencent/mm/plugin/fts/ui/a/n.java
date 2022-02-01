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
import com.tencent.mm.sdk.platformtools.Log;

public class n
  extends a
{
  public String jCp;
  private b xdB;
  private a xdC;
  
  public n(int paramInt)
  {
    super(8, paramInt);
    AppMethodBeat.i(112105);
    this.xdB = new b();
    this.xdC = new a();
    AppMethodBeat.o(112105);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112106);
    parama = com.tencent.mm.plugin.fts.ui.n.Nu(this.rjr);
    if (parama == null) {}
    for (this.jCp = "";; this.jCp = paramContext.getResources().getString(2131765050, new Object[] { parama }))
    {
      Log.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[] { this.jCp });
      AppMethodBeat.o(112106);
      return;
    }
  }
  
  public a.b axc()
  {
    return this.xdB;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView nnL;
    public TextView xcs;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494771, paramViewGroup, false);
      paramViewGroup = new n.a(n.this);
      paramViewGroup.xcs = ((TextView)paramContext.findViewById(2131309163));
      paramViewGroup.nnL = ((ImageView)paramContext.findViewById(2131302497));
      paramViewGroup.contentView = paramContext.findViewById(2131307399);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112102);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112103);
      paramContext = (n.a)parama;
      parama = (n)parama1;
      com.tencent.mm.plugin.fts.ui.n.r(paramContext.contentView, n.this.wXK);
      paramContext.xcs.setText(parama.jCp);
      paramContext.nnL.setImageResource(2131690354);
      AppMethodBeat.o(112103);
    }
    
    public boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(235403);
      paramView = new Intent();
      paramView.putExtra("detail_query", n.this.wWd.wWB);
      paramView.putExtra("detail_type", n.this.rjr);
      paramView.putExtra("Search_Scene", n.this.mve);
      d.d(paramContext, ".ui.FTSDetailUI", paramView);
      AppMethodBeat.o(235403);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n
 * JD-Core Version:    0.7.0.1
 */