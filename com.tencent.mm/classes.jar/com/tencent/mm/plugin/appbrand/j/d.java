package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.bu;

public final class d
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence fWZ;
  public boolean jSG;
  public boolean jSH;
  public m kno;
  public AppBrandRecentTaskInfo knp;
  private b knq;
  a knr;
  
  public d(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(45027);
    this.knq = new b();
    this.knr = new a();
    AppMethodBeat.o(45027);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(45028);
    super.a(paramContext, parama, paramVarArgs);
    this.knp = i.Pv(this.kno.tEY);
    if (this.knp == null)
    {
      AppMethodBeat.o(45028);
      return;
    }
    boolean bool2;
    switch (this.kno.tEX)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.fWZ = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.knp.appName, this.tFe, bool1, bool2)).tFv;
      this.info = this.knp.dkZ;
      this.jSG = this.knp.jSG;
      this.jSH = this.knp.jSG;
      AppMethodBeat.o(45028);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final a.b agQ()
  {
    return this.knq;
  }
  
  public final String bhD()
  {
    return this.knp.appName;
  }
  
  public final int bhE()
  {
    return this.kno.tGo;
  }
  
  public final String getAppId()
  {
    return this.knp.dkZ;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fQl;
    public TextView iYj;
    public TextView kns;
    public TextView knt;
    public View knu;
    public ImageView knv;
    public ImageView knw;
    
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
      paramViewGroup = (d.a)d.this.knr;
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.kns = ((TextView)paramContext.findViewById(2131304468));
      paramViewGroup.knt = ((TextView)paramContext.findViewById(2131305633));
      paramViewGroup.knu = paramContext.findViewById(2131299154);
      paramViewGroup.knv = ((ImageView)paramContext.findViewById(2131306056));
      paramViewGroup.knw = ((ImageView)paramContext.findViewById(2131308167));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(45024);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(45025);
      paramContext = (d)parama1;
      parama = (d.a)parama;
      n.p(parama.knu, d.this.tGL);
      if (paramContext.knp == null)
      {
        parama.contentView.setVisibility(8);
        AppMethodBeat.o(45025);
        return;
      }
      parama.contentView.setVisibility(0);
      parama.iYj.setText(d.this.fWZ);
      if (d.this.pSr == -8)
      {
        parama.kns.setText(2131762906);
        parama.kns.setVisibility(0);
        parama1 = com.tencent.mm.plugin.appbrand.appcache.e.rS(d.this.knp.dQv);
        if (!bu.isNullOrNil(parama1)) {
          break label252;
        }
        parama.knt.setVisibility(8);
        label132:
        if ((!d.this.jSG) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNn, 0) != 1)) {
          break label271;
        }
        parama.knv.setVisibility(0);
        label171:
        if ((!d.this.jSH) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPC, 0) != 1)) {
          break label283;
        }
        parama.knw.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.modelappbrand.a.b.aEl().a(parama.fQl, paramContext.knp.jSE, com.tencent.mm.modelappbrand.a.a.aEk(), com.tencent.mm.modelappbrand.a.g.hOv);
        AppMethodBeat.o(45025);
        return;
        parama.kns.setVisibility(8);
        break;
        label252:
        parama.knt.setText(parama1);
        parama.knt.setVisibility(0);
        break label132;
        label271:
        parama.knv.setVisibility(8);
        break label171;
        label283:
        parama.knw.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(45026);
      paramContext = (d)paramVarArgs;
      paramVarArgs = new vq();
      paramVarArgs.dKT.userName = paramContext.knp.dkZ;
      paramVarArgs.dKT.dKW = paramContext.knp.dQv;
      paramVarArgs.dKT.dLa = true;
      paramVarArgs.dKT.scene = 1027;
      paramVarArgs.dKT.dlj = "1";
      com.tencent.mm.sdk.b.a.IvT.l(paramVarArgs);
      a(d.this.tFe.tFC, d.this.kno);
      AppMethodBeat.o(45026);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.d
 * JD-Core Version:    0.7.0.1
 */