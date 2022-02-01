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
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;

public final class j
  extends a
{
  public int actionType;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public CharSequence qji;
  public String qjl;
  public CharSequence rvI;
  public String rvJ;
  public d rvK;
  private b rvL;
  a rvM;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(112087);
    this.actionType = -1;
    this.rvL = new b();
    this.rvM = new a();
    AppMethodBeat.o(112087);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112088);
    super.a(paramContext, parama, paramVarArgs);
    this.rvK = ((d)this.jpy.userData);
    if (this.rvK == null)
    {
      AppMethodBeat.o(112088);
      return;
    }
    this.qji = this.rvK.field_title;
    this.rvI = this.rvK.field_tag;
    this.qjl = this.rvK.field_iconPath;
    this.rvJ = this.rvK.field_androidUrl;
    this.actionType = this.rvK.field_actionType;
    boolean bool1;
    switch (this.jpy.roM)
    {
    default: 
      AppMethodBeat.o(112088);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.qji = com.tencent.mm.plugin.fts.a.f.a(e.a(this.qji, this.roS, bool2, bool1)).rpj;
      AppMethodBeat.o(112088);
      return;
      this.rvI = com.tencent.mm.plugin.fts.a.f.a(e.a(this.rvI, this.roS)).rpj;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final String aWt()
  {
    return this.rvK.field_title;
  }
  
  public final int aWu()
  {
    return this.jpy.rqc;
  }
  
  public final a.b acQ()
  {
    return this.rvL;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
    
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
      paramViewGroup = (j.a)j.this.rvM;
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
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
      com.tencent.mm.plugin.fts.ui.m.q(parama.contentView, j.this.rqz);
      com.tencent.mm.plugin.fts.ui.m.a(j.this.qji, parama.ica);
      com.tencent.mm.plugin.fts.ui.m.a(j.this.rvI, parama.hJe);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext, parama.frr, null, parama1.qjl, 2131690253, true);
      AppMethodBeat.o(112085);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112086);
      boolean bool = ((n)g.ad(n.class)).getItemClickHandler(j.this.nBH).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112086);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */