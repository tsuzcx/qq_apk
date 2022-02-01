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
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class k
  extends a
{
  public String header;
  private b tBy;
  private a tBz;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(112091);
    this.tBy = new b();
    this.tBz = new a();
    AppMethodBeat.o(112091);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112092);
    this.header = bt.bI(n.GX(this.pLM), "");
    ad.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.header });
    AppMethodBeat.o(112092);
  }
  
  public a.b agC()
  {
    return this.tBy;
  }
  
  public a.a cTJ()
  {
    return this.tBz;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public TextView oUO;
    public View tAS;
    
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
      paramViewGroup = (k.a)k.this.cTJ();
      paramViewGroup.oUO = ((TextView)paramContext.findViewById(2131300734));
      paramViewGroup.tAS = paramContext.findViewById(2131303131);
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112089);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112090);
      paramContext = (k.a)parama;
      n.a(k.this.header, paramContext.oUO);
      if (k.this.position == 0) {
        paramContext.tAS.setVisibility(8);
      }
      for (;;)
      {
        n.r(paramContext.contentView, k.this.tvU);
        AppMethodBeat.o(112090);
        return;
        paramContext.tAS.setVisibility(0);
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