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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class k
  extends a
{
  public String header;
  private b xdp;
  private a xdq;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(112091);
    this.xdp = new b();
    this.xdq = new a();
    AppMethodBeat.o(112091);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112092);
    this.header = Util.nullAs(n.Nu(this.rjr), "");
    Log.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.header });
    AppMethodBeat.o(112092);
  }
  
  public a.b axc()
  {
    return this.xdp;
  }
  
  public a.a dPz()
  {
    return this.xdq;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public TextView qqq;
    public View xcK;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494756, paramViewGroup, false);
      paramViewGroup = (k.a)k.this.dPz();
      paramViewGroup.qqq = ((TextView)paramContext.findViewById(2131302315));
      paramViewGroup.xcK = paramContext.findViewById(2131305768);
      paramViewGroup.contentView = paramContext.findViewById(2131307399);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112089);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112090);
      paramContext = (k.a)parama;
      n.b(k.this.header, paramContext.qqq);
      if (k.this.position == 0) {
        paramContext.xcK.setVisibility(8);
      }
      for (;;)
      {
        n.s(paramContext.contentView, k.this.wXK);
        AppMethodBeat.o(112090);
        return;
        paramContext.xcK.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k
 * JD-Core Version:    0.7.0.1
 */