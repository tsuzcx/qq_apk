package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.n;

public final class e
  extends k
{
  public int count;
  public CharSequence iYg;
  private a tLE;
  b tLF;
  public String talker;
  
  public e(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112064);
    this.tLE = new a();
    this.tLF = new b();
    AppMethodBeat.o(112064);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112065);
    parama = (b)parama;
    this.header = paramContext.getString(2131762956, new Object[] { Integer.valueOf(this.count) });
    this.iYg = com.tencent.mm.pluginsdk.ui.span.k.d(paramContext, d.ahd(this.talker), parama.fQm.getTextSize());
    AppMethodBeat.o(112065);
  }
  
  public final com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.tLE;
  }
  
  public final a.a cWo()
  {
    return this.tLF;
  }
  
  public final class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112062);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494193, paramViewGroup, false);
      paramViewGroup = (e.b)e.this.tLF;
      paramViewGroup.tLI = paramContext.findViewById(2131308326);
      paramViewGroup.pbr = ((TextView)paramContext.findViewById(2131300734));
      paramViewGroup.tLJ = paramContext.findViewById(2131303131);
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.fQm = ((TextView)paramContext.findViewById(2131302867));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112062);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112063);
      parama = (e.b)parama;
      n.a(e.this.header, parama.pbr);
      com.tencent.mm.pluginsdk.ui.a.b.c(parama.fQl, e.this.talker);
      n.a(e.this.iYg, parama.fQm);
      parama.tLI.setBackgroundResource(2131231818);
      parama.tLI.setOnClickListener(new e.a.1(this, paramContext));
      AppMethodBeat.o(112063);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public ImageView fQl;
    public TextView fQm;
    public TextView pbr;
    public View tLI;
    public View tLJ;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e
 * JD-Core Version:    0.7.0.1
 */