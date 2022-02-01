package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class k
  extends a
{
  public String header;
  private b rvO;
  private a rvP;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(112091);
    this.rvO = new b();
    this.rvP = new a();
    AppMethodBeat.o(112091);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112092);
    this.header = bt.by(m.DM(this.oEL), "");
    ad.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.header });
    AppMethodBeat.o(112092);
  }
  
  public a.b acQ()
  {
    return this.rvO;
  }
  
  public a.a cye()
  {
    return this.rvP;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public TextView nOq;
    public View rvj;
    
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
      AppMethodBeat.i(112089);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494203, paramViewGroup, false);
      paramViewGroup = (k.a)k.this.cye();
      paramViewGroup.nOq = ((TextView)paramContext.findViewById(2131300734));
      paramViewGroup.rvj = paramContext.findViewById(2131303131);
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112089);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112090);
      paramContext = (k.a)parama;
      m.a(k.this.header, paramContext.nOq);
      if (k.this.position == 0) {
        paramContext.rvj.setVisibility(8);
      }
      for (;;)
      {
        m.r(paramContext.contentView, k.this.rqz);
        AppMethodBeat.o(112090);
        return;
        paramContext.rvj.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k
 * JD-Core Version:    0.7.0.1
 */