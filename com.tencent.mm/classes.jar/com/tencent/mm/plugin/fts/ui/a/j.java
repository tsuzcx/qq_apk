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
  public String jgI;
  public m lqW;
  public CharSequence tjG;
  public String tjJ;
  public CharSequence xdk;
  public d xdl;
  private b xdm;
  a xdn;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(112087);
    this.actionType = -1;
    this.xdm = new b();
    this.xdn = new a();
    AppMethodBeat.o(112087);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112088);
    super.a(paramContext, parama, paramVarArgs);
    this.xdl = ((d)this.lqW.userData);
    if (this.xdl == null)
    {
      AppMethodBeat.o(112088);
      return;
    }
    this.tjG = this.xdl.field_title;
    this.xdk = this.xdl.field_tag;
    this.tjJ = this.xdl.field_iconPath;
    this.jgI = this.xdl.field_androidUrl;
    this.actionType = this.xdl.field_actionType;
    boolean bool1;
    switch (this.lqW.wVW)
    {
    default: 
      AppMethodBeat.o(112088);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.tjG = com.tencent.mm.plugin.fts.a.f.a(e.a(this.tjG, this.wWd, bool2, bool1)).wWu;
      AppMethodBeat.o(112088);
      return;
      this.xdk = com.tencent.mm.plugin.fts.a.f.a(e.a(this.xdk, this.wWd)).wWu;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final a.b axc()
  {
    return this.xdm;
  }
  
  public final String bCR()
  {
    return this.xdl.field_title;
  }
  
  public final int bCS()
  {
    return this.lqW.wXn;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView gvv;
    public TextView jBR;
    public TextView jVO;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494744, paramViewGroup, false);
      paramViewGroup = (j.a)j.this.xdn;
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
      paramViewGroup.contentView = paramContext.findViewById(2131307399);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112084);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112085);
      parama = (j.a)parama;
      parama1 = (j)parama1;
      com.tencent.mm.plugin.fts.ui.n.r(parama.contentView, j.this.wXK);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.tjG, parama.jVO);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.xdk, parama.jBR);
      com.tencent.mm.plugin.fts.ui.n.a(paramContext, parama.gvv, null, parama1.tjJ, 2131690349, true);
      AppMethodBeat.o(112085);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(235401);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)g.ah(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(j.this.qcr).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(235401);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */