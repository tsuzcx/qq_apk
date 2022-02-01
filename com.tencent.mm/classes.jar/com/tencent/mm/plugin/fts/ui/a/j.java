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
  public m kjY;
  public CharSequence rBK;
  public String rBN;
  public CharSequence tBs;
  public String tBt;
  public d tBu;
  private b tBv;
  a tBw;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(112087);
    this.actionType = -1;
    this.tBv = new b();
    this.tBw = new a();
    AppMethodBeat.o(112087);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112088);
    super.a(paramContext, parama, paramVarArgs);
    this.tBu = ((d)this.kjY.userData);
    if (this.tBu == null)
    {
      AppMethodBeat.o(112088);
      return;
    }
    this.rBK = this.tBu.field_title;
    this.tBs = this.tBu.field_tag;
    this.rBN = this.tBu.field_iconPath;
    this.tBt = this.tBu.field_androidUrl;
    this.actionType = this.tBu.field_actionType;
    boolean bool1;
    switch (this.kjY.tug)
    {
    default: 
      AppMethodBeat.o(112088);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.rBK = com.tencent.mm.plugin.fts.a.f.a(e.a(this.rBK, this.tun, bool2, bool1)).tuE;
      AppMethodBeat.o(112088);
      return;
      this.tBs = com.tencent.mm.plugin.fts.a.f.a(e.a(this.tBs, this.tun)).tuE;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final a.b agC()
  {
    return this.tBv;
  }
  
  public final String bgV()
  {
    return this.tBu.field_title;
  }
  
  public final int bgW()
  {
    return this.kjY.tvx;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fOf;
    public TextView iCV;
    public TextView iVq;
    
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
      paramViewGroup = (j.a)j.this.tBw;
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
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
      com.tencent.mm.plugin.fts.ui.n.q(parama.contentView, j.this.tvU);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.rBK, parama.iVq);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.tBs, parama.iCV);
      com.tencent.mm.plugin.fts.ui.n.a(paramContext, parama.fOf, null, parama1.rBN, 2131690253, true);
      AppMethodBeat.o(112085);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112086);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)g.ad(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(j.this.oIb).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112086);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */