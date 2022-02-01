package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.f;

public final class j
  extends a
{
  public String AmC;
  public CharSequence Amz;
  public CharSequence HAX;
  public com.tencent.mm.plugin.fts.a.a.f HAY;
  private b HAZ;
  a HBa;
  public int actionType;
  public String oQn;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(112087);
    this.actionType = -1;
    this.HAZ = new b();
    this.HBa = new a();
    AppMethodBeat.o(112087);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112088);
    super.a(paramContext, parama, paramVarArgs);
    this.HAY = ((com.tencent.mm.plugin.fts.a.a.f)this.rpp.HtQ);
    if (this.HAY == null)
    {
      AppMethodBeat.o(112088);
      return;
    }
    this.Amz = this.HAY.field_title;
    this.HAX = this.HAY.field_tag;
    this.AmC = this.HAY.field_iconPath;
    this.oQn = this.HAY.field_androidUrl;
    this.actionType = this.HAY.field_actionType;
    boolean bool1;
    switch (this.rpp.subtype)
    {
    default: 
      AppMethodBeat.o(112088);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.Amz = com.tencent.mm.plugin.fts.a.f.a(g.a(this.Amz, this.FWt, bool2, bool1)).HsX;
      AppMethodBeat.o(112088);
      return;
      this.HAX = com.tencent.mm.plugin.fts.a.f.a(g.a(this.HAX, this.FWt)).HsX;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final a.b aXA()
  {
    return this.HAZ;
  }
  
  public final String coB()
  {
    return this.HAY.field_title;
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView lBC;
    public TextView pJJ;
    public TextView plr;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_contact_item, paramViewGroup, false);
      paramViewGroup = (j.a)j.this.HBa;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(p.d.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(p.d.title_tv));
      paramViewGroup.plr = ((TextView)paramContext.findViewById(p.d.desc_tv));
      paramViewGroup.contentView = paramContext.findViewById(p.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112084);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112085);
      parama = (j.a)parama;
      parama1 = (j)parama1;
      com.tencent.mm.plugin.fts.ui.o.x(parama.contentView, j.this.Hup);
      com.tencent.mm.plugin.fts.ui.o.a(j.this.Amz, parama.pJJ);
      com.tencent.mm.plugin.fts.ui.o.a(j.this.HAX, parama.plr);
      com.tencent.mm.plugin.fts.ui.o.a(paramContext, parama.lBC, null, parama1.AmC, p.f.fts_default_img, true);
      AppMethodBeat.o(112085);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(265729);
      boolean bool = ((n)com.tencent.mm.kernel.h.az(n.class)).getItemClickHandler(j.this.viewType).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(265729);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.j
 * JD-Core Version:    0.7.0.1
 */