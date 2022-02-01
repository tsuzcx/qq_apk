package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.f;

public final class j
  extends a
{
  public CharSequence BPi;
  public d BPj;
  private b BPk;
  a BPl;
  public int actionType;
  public String lXl;
  public m olG;
  public CharSequence wPX;
  public String wQa;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(112087);
    this.actionType = -1;
    this.BPk = new b();
    this.BPl = new a();
    AppMethodBeat.o(112087);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112088);
    super.a(paramContext, parama, paramVarArgs);
    this.BPj = ((d)this.olG.BJh);
    if (this.BPj == null)
    {
      AppMethodBeat.o(112088);
      return;
    }
    this.wPX = this.BPj.field_title;
    this.BPi = this.BPj.field_tag;
    this.wQa = this.BPj.field_iconPath;
    this.lXl = this.BPj.field_androidUrl;
    this.actionType = this.BPj.field_actionType;
    boolean bool1;
    switch (this.olG.BHR)
    {
    default: 
      AppMethodBeat.o(112088);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.wPX = com.tencent.mm.plugin.fts.a.f.a(e.a(this.wPX, this.BHY, bool2, bool1)).BIp;
      AppMethodBeat.o(112088);
      return;
      this.BPi = com.tencent.mm.plugin.fts.a.f.a(e.a(this.BPi, this.BHY)).BIp;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final a.b aEw()
  {
    return this.BPk;
  }
  
  public final String bOm()
  {
    return this.BPj.field_title;
  }
  
  public final int bOn()
  {
    return this.olG.BJj;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView iZG;
    public TextView mNb;
    public TextView mrM;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_contact_item, paramViewGroup, false);
      paramViewGroup = (j.a)j.this.BPl;
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(o.d.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(o.d.title_tv));
      paramViewGroup.mrM = ((TextView)paramContext.findViewById(o.d.desc_tv));
      paramViewGroup.contentView = paramContext.findViewById(o.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112084);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112085);
      parama = (j.a)parama;
      parama1 = (j)parama1;
      com.tencent.mm.plugin.fts.ui.n.r(parama.contentView, j.this.BJG);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.wPX, parama.mNb);
      com.tencent.mm.plugin.fts.ui.n.a(j.this.BPi, parama.mrM);
      com.tencent.mm.plugin.fts.ui.n.a(paramContext, parama.iZG, null, parama1.wQa, o.f.fts_default_img, true);
      AppMethodBeat.o(112085);
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      AppMethodBeat.i(193609);
      boolean bool = ((com.tencent.mm.plugin.fts.a.n)h.ag(com.tencent.mm.plugin.fts.a.n.class)).getItemClickHandler(j.this.viewType).a(paramContext, paramView, paramVarArgs);
      AppMethodBeat.o(193609);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */