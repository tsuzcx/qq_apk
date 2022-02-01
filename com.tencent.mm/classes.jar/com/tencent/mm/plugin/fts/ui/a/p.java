package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;

public final class p
  extends m
{
  public int dcz;
  public com.tencent.mm.plugin.fts.a.a.m rvo;
  private a rwf;
  
  public p(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112112);
    this.rwf = new a();
    AppMethodBeat.o(112112);
  }
  
  public final a.b acQ()
  {
    return this.rwf;
  }
  
  public final int cxx()
  {
    int i = 2;
    if (this.rvV < 2) {
      i = 0;
    }
    return i;
  }
  
  public final class a
    extends m.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112110);
      paramViewGroup = LayoutInflater.from(paramContext).inflate(2131494215, paramViewGroup, false);
      m.a locala = (m.a)p.this.rvY;
      locala.frr = ((ImageView)paramViewGroup.findViewById(2131297008));
      locala.frs = ((TextView)paramViewGroup.findViewById(2131302867));
      locala.fwR = ((TextView)paramViewGroup.findViewById(2131302555));
      locala.jpE = paramViewGroup.findViewById(2131299154);
      locala.fwS = ((TextView)paramViewGroup.findViewById(2131305822));
      locala.frr.getLayoutParams().width = com.tencent.mm.cd.a.ao(paramContext, 2131165558);
      locala.frr.getLayoutParams().height = com.tencent.mm.cd.a.ao(paramContext, 2131165558);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112110);
      return paramViewGroup;
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112111);
      boolean bool = ((n)g.ad(n.class)).getItemClickHandler(p.this.nBH).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112111);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.p
 * JD-Core Version:    0.7.0.1
 */