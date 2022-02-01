package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence fUT;
  public boolean jPo;
  public boolean jPp;
  public m kjY;
  public AppBrandRecentTaskInfo kjZ;
  private b kka;
  a kkb;
  
  public d(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(45027);
    this.kka = new b();
    this.kkb = new a();
    AppMethodBeat.o(45027);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(45028);
    super.a(paramContext, parama, paramVarArgs);
    this.kjZ = i.ON(this.kjY.tuh);
    if (this.kjZ == null)
    {
      AppMethodBeat.o(45028);
      return;
    }
    boolean bool2;
    switch (this.kjY.tug)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.fUT = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.kjZ.appName, this.tun, bool1, bool2)).tuE;
      this.info = this.kjZ.djX;
      this.jPo = this.kjZ.jPo;
      this.jPp = this.kjZ.jPo;
      AppMethodBeat.o(45028);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final a.b agC()
  {
    return this.kka;
  }
  
  public final String bgV()
  {
    return this.kjZ.appName;
  }
  
  public final int bgW()
  {
    return this.kjY.tvx;
  }
  
  public final String getAppId()
  {
    return this.kjZ.djX;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fOf;
    public TextView iVq;
    public TextView kkc;
    public TextView kkd;
    public View kke;
    public ImageView kkf;
    public ImageView kkg;
    
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
      AppMethodBeat.i(45024);
      paramContext = LayoutInflater.from(paramContext).inflate(2131492995, paramViewGroup, false);
      paramViewGroup = (d.a)d.this.kkb;
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.kkc = ((TextView)paramContext.findViewById(2131304468));
      paramViewGroup.kkd = ((TextView)paramContext.findViewById(2131305633));
      paramViewGroup.kke = paramContext.findViewById(2131299154);
      paramViewGroup.kkf = ((ImageView)paramContext.findViewById(2131306056));
      paramViewGroup.kkg = ((ImageView)paramContext.findViewById(2131308167));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(45024);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(45025);
      paramContext = (d)parama1;
      parama = (d.a)parama;
      n.p(parama.kke, d.this.tvU);
      if (paramContext.kjZ == null)
      {
        parama.contentView.setVisibility(8);
        AppMethodBeat.o(45025);
        return;
      }
      parama.contentView.setVisibility(0);
      parama.iVq.setText(d.this.fUT);
      if (d.this.pLM == -8)
      {
        parama.kkc.setText(2131762906);
        parama.kkc.setVisibility(0);
        parama1 = com.tencent.mm.plugin.appbrand.appcache.e.rP(d.this.kjZ.dPf);
        if (!bt.isNullOrNil(parama1)) {
          break label252;
        }
        parama.kkd.setVisibility(8);
        label132:
        if ((!d.this.jPo) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFH, 0) != 1)) {
          break label271;
        }
        parama.kkf.setVisibility(0);
        label171:
        if ((!d.this.jPp) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHW, 0) != 1)) {
          break label283;
        }
        parama.kkg.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.modelappbrand.a.b.aDV().a(parama.fOf, paramContext.kjZ.jPm, com.tencent.mm.modelappbrand.a.a.aDU(), com.tencent.mm.modelappbrand.a.g.hLC);
        AppMethodBeat.o(45025);
        return;
        parama.kkc.setVisibility(8);
        break;
        label252:
        parama.kkd.setText(parama1);
        parama.kkd.setVisibility(0);
        break label132;
        label271:
        parama.kkf.setVisibility(8);
        break label171;
        label283:
        parama.kkg.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(45026);
      paramContext = (d)paramVarArgs;
      paramVarArgs = new vm();
      paramVarArgs.dJF.userName = paramContext.kjZ.djX;
      paramVarArgs.dJF.dJI = paramContext.kjZ.dPf;
      paramVarArgs.dJF.dJL = true;
      paramVarArgs.dJF.scene = 1027;
      paramVarArgs.dJF.dkh = "1";
      com.tencent.mm.sdk.b.a.IbL.l(paramVarArgs);
      a(d.this.tun.tuL, d.this.kjY);
      AppMethodBeat.o(45026);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.d
 * JD-Core Version:    0.7.0.1
 */