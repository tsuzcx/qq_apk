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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class k
  extends a
{
  public String header;
  private b sEG;
  private a sEH;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(112091);
    this.sEG = new b();
    this.sEH = new a();
    AppMethodBeat.o(112091);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112092);
    this.header = bs.bG(m.FI(this.pil), "");
    ac.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.header });
    AppMethodBeat.o(112092);
  }
  
  public a.b adW()
  {
    return this.sEG;
  }
  
  public a.a cLq()
  {
    return this.sEH;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public TextView ors;
    public View sEb;
    
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
      paramViewGroup = (k.a)k.this.cLq();
      paramViewGroup.ors = ((TextView)paramContext.findViewById(2131300734));
      paramViewGroup.sEb = paramContext.findViewById(2131303131);
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112089);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112090);
      paramContext = (k.a)parama;
      m.a(k.this.header, paramContext.ors);
      if (k.this.position == 0) {
        paramContext.sEb.setVisibility(8);
      }
      for (;;)
      {
        m.r(paramContext.contentView, k.this.szt);
        AppMethodBeat.o(112090);
        return;
        paramContext.sEb.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k
 * JD-Core Version:    0.7.0.1
 */