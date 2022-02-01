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
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public CharSequence qRK;
  public String qRN;
  public CharSequence sEA;
  public String sEB;
  public d sEC;
  private b sED;
  a sEE;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(112087);
    this.actionType = -1;
    this.sED = new b();
    this.sEE = new a();
    AppMethodBeat.o(112087);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(112088);
    super.a(paramContext, parama, paramVarArgs);
    this.sEC = ((d)this.jPN.userData);
    if (this.sEC == null)
    {
      AppMethodBeat.o(112088);
      return;
    }
    this.qRK = this.sEC.field_title;
    this.sEA = this.sEC.field_tag;
    this.qRN = this.sEC.field_iconPath;
    this.sEB = this.sEC.field_androidUrl;
    this.actionType = this.sEC.field_actionType;
    boolean bool1;
    switch (this.jPN.sxF)
    {
    default: 
      AppMethodBeat.o(112088);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.qRK = com.tencent.mm.plugin.fts.a.f.a(e.a(this.qRK, this.sxM, bool2, bool1)).syd;
      AppMethodBeat.o(112088);
      return;
      this.sEA = com.tencent.mm.plugin.fts.a.f.a(e.a(this.sEA, this.sxM)).syd;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final a.b adW()
  {
    return this.sED;
  }
  
  public final String bdr()
  {
    return this.sEC.field_title;
  }
  
  public final int bds()
  {
    return this.jPN.syW;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fuY;
    public TextView iCg;
    public TextView ijE;
    
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
      paramViewGroup = (j.a)j.this.sEE;
      paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
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
      com.tencent.mm.plugin.fts.ui.m.q(parama.contentView, j.this.szt);
      com.tencent.mm.plugin.fts.ui.m.a(j.this.qRK, parama.iCg);
      com.tencent.mm.plugin.fts.ui.m.a(j.this.sEA, parama.ijE);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext, parama.fuY, null, parama1.qRN, 2131690253, true);
      AppMethodBeat.o(112085);
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      AppMethodBeat.i(112086);
      boolean bool = ((n)g.ad(n.class)).getItemClickHandler(j.this.oeH).a(paramContext, paramVarArgs);
      AppMethodBeat.o(112086);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */