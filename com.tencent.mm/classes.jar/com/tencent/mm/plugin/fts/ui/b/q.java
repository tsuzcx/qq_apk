package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;

public final class q
  extends k
{
  public int HBF;
  private b HBG;
  a HBH;
  
  public q(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(265728);
    this.HBG = new b();
    this.HBH = new a();
    AppMethodBeat.o(265728);
  }
  
  public final a.b aXA()
  {
    return this.HBG;
  }
  
  public final a.a fyW()
  {
    return this.HBH;
  }
  
  public final class a
    extends a.a
  {
    public TextView FwJ;
    public TextView pJJ;
    
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
      AppMethodBeat.i(265732);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_servicenotify_sender_header_item, paramViewGroup, false);
      paramViewGroup = (q.a)q.this.HBH;
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(p.d.title_tv));
      paramViewGroup.FwJ = ((TextView)paramContext.findViewById(p.d.more_tv));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(265732);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(265733);
      parama1 = (q)parama1;
      parama = (q.a)parama;
      paramVarArgs = paramContext.getString(p.g.search_service_notify_sender_head_wording, new Object[] { q.this.FWt.Hte });
      TextView localTextView = parama.pJJ;
      j localj = q.this.FWt;
      g localg = new g();
      localg.HsG = paramVarArgs;
      localg.FWt = localj;
      localg.HsH = false;
      localg.HsI = false;
      localg.dso = localTextView.getPaint();
      o.a(f.a(localg).HsX, parama.pJJ);
      if (parama1.HBF > 3)
      {
        parama.FwJ.setVisibility(0);
        parama.FwJ.setOnClickListener(new q.b.1(this, paramContext));
        AppMethodBeat.o(265733);
        return;
      }
      parama.FwJ.setVisibility(8);
      parama.FwJ.setOnClickListener(null);
      AppMethodBeat.o(265733);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.q
 * JD-Core Version:    0.7.0.1
 */