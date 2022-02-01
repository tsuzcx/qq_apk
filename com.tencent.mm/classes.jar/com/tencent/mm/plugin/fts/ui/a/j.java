package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;

public final class j
  extends a
{
  public int actionType;
  public m kno;
  public CharSequence rJV;
  public String rJY;
  public CharSequence tMj;
  public String tMk;
  public d tMl;
  private b tMm;
  a tMn;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(112087);
    this.actionType = -1;
    this.tMm = new b();
    this.tMn = new a();
    AppMethodBeat.o(112087);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112088);
    super.a(paramContext, parama, paramVarArgs);
    this.tMl = ((d)this.kno.userData);
    if (this.tMl == null)
    {
      AppMethodBeat.o(112088);
      return;
    }
    this.rJV = this.tMl.field_title;
    this.tMj = this.tMl.field_tag;
    this.rJY = this.tMl.field_iconPath;
    this.tMk = this.tMl.field_androidUrl;
    this.actionType = this.tMl.field_actionType;
    boolean bool1;
    switch (this.kno.tEX)
    {
    default: 
      AppMethodBeat.o(112088);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.rJV = com.tencent.mm.plugin.fts.a.f.a(e.a(this.rJV, this.tFe, bool2, bool1)).tFv;
      AppMethodBeat.o(112088);
      return;
      this.tMj = com.tencent.mm.plugin.fts.a.f.a(e.a(this.tMj, this.tFe)).tFv;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final a.b agQ()
  {
    return this.tMm;
  }
  
  public final String bhD()
  {
    return this.tMl.field_title;
  }
  
  public final int bhE()
  {
    return this.kno.tGo;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fQl;
    public TextView iFO;
    public TextView iYj;
    
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
      AppMethodBeat.i(112084);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494192, paramViewGroup, false);
      paramViewGroup = (j.a)j.this.tMn;
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112084);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112085);
      parama = (j.a)parama;
      parama1 = (j)parama1;
      com.tencent.mm.plugin.fts.ui.n.q(parama.contentView, j.this.tGL);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.rJV, parama.iYj);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.tMj, parama.iFO);
      com.tencent.mm.plugin.fts.ui.n.a(paramContext, parama.fQl, null, parama1.rJY, 2131690253, true);
      AppMethodBeat.o(112085);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112086);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(j.this.oOD).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112086);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */