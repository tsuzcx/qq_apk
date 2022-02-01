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
  public int dlp;
  public com.tencent.mm.plugin.fts.a.a.m tAX;
  private a tBP;
  
  public p(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112112);
    this.tBP = new a();
    AppMethodBeat.o(112112);
  }
  
  public final a.b agC()
  {
    return this.tBP;
  }
  
  public final int cSY()
  {
    int i = 2;
    if (this.tBF < 2) {
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
      m.a locala = (m.a)p.this.tBI;
      locala.fOf = ((ImageView)paramViewGroup.findViewById(2131297008));
      locala.fOg = ((TextView)paramViewGroup.findViewById(2131302867));
      locala.fTO = ((TextView)paramViewGroup.findViewById(2131302555));
      locala.kke = paramViewGroup.findViewById(2131299154);
      locala.fTP = ((TextView)paramViewGroup.findViewById(2131305822));
      locala.fOf.getLayoutParams().width = com.tencent.mm.cc.a.ax(paramContext, 2131165558);
      locala.fOf.getLayoutParams().height = com.tencent.mm.cc.a.ax(paramContext, 2131165558);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(112110);
      return paramViewGroup;
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112111);
      boolean bool = ((n)g.ad(n.class)).getItemClickHandler(p.this.oIb).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112111);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.p
 * JD-Core Version:    0.7.0.1
 */