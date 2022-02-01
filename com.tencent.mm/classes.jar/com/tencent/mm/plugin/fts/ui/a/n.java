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
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ad;

public class n
  extends a
{
  public String hJE;
  private b rwa;
  private a rwb;
  
  public n(int paramInt)
  {
    super(8, paramInt);
    AppMethodBeat.i(112105);
    this.rwa = new b();
    this.rwb = new a();
    AppMethodBeat.o(112105);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112106);
    parama = m.DM(this.oEL);
    if (parama == null) {}
    for (this.hJE = "";; this.hJE = paramContext.getResources().getString(2131762914, new Object[] { parama }))
    {
      ad.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[] { this.hJE });
      AppMethodBeat.o(112106);
      return;
    }
  }
  
  public a.b acQ()
  {
    return this.rwa;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView kXS;
    public TextView ruT;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494216, paramViewGroup, false);
      paramViewGroup = new n.a(n.this);
      paramViewGroup.ruT = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.kXS = ((ImageView)paramContext.findViewById(2131300891));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112102);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112103);
      paramContext = (n.a)parama;
      parama = (n)parama1;
      m.q(paramContext.contentView, n.this.rqz);
      paramContext.ruT.setText(parama.hJE);
      paramContext.kXS.setImageResource(2131690258);
      AppMethodBeat.o(112103);
    }
    
    public boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112104);
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("detail_query", n.this.roS.rpq);
      paramVarArgs.putExtra("detail_type", n.this.oEL);
      paramVarArgs.putExtra("Search_Scene", n.this.kme);
      d.c(paramContext, ".ui.FTSDetailUI", paramVarArgs);
      AppMethodBeat.o(112104);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.n
 * JD-Core Version:    0.7.0.1
 */