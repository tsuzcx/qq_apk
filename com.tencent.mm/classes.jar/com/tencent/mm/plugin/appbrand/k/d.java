package com.tencent.mm.plugin.appbrand.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.bs;

public final class d
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence fBG;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public AppBrandRecentTaskInfo jPO;
  private b jPP;
  a jPQ;
  public boolean jvv;
  
  public d(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(45027);
    this.jPP = new b();
    this.jPQ = new a();
    AppMethodBeat.o(45027);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(45028);
    super.a(paramContext, parama, paramVarArgs);
    this.jPO = i.Lt(this.jPN.sxG);
    if (this.jPO == null)
    {
      AppMethodBeat.o(45028);
      return;
    }
    boolean bool2;
    switch (this.jPN.sxF)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.fBG = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.jPO.appName, this.sxM, bool1, bool2)).syd;
      this.info = this.jPO.cYF;
      this.jvv = this.jPO.jvv;
      AppMethodBeat.o(45028);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final a.b adW()
  {
    return this.jPP;
  }
  
  public final String bdr()
  {
    return this.jPO.appName;
  }
  
  public final int bds()
  {
    return this.jPN.syW;
  }
  
  public final String getAppId()
  {
    return this.jPO.cYF;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fuY;
    public TextView iCg;
    public TextView jPR;
    public TextView jPS;
    public View jPT;
    public ImageView jPU;
    
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
      paramViewGroup = (d.a)d.this.jPQ;
      paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.jPR = ((TextView)paramContext.findViewById(2131304468));
      paramViewGroup.jPS = ((TextView)paramContext.findViewById(2131305633));
      paramViewGroup.jPT = paramContext.findViewById(2131299154);
      paramViewGroup.jPU = ((ImageView)paramContext.findViewById(2131306056));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(45024);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(45025);
      paramContext = (d)parama1;
      parama = (d.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jPT, d.this.szt);
      if (paramContext.jPO == null)
      {
        parama.contentView.setVisibility(8);
        AppMethodBeat.o(45025);
        return;
      }
      parama.contentView.setVisibility(0);
      parama.iCg.setText(d.this.fBG);
      if (d.this.pil == -8)
      {
        parama.jPR.setText(2131762906);
        parama.jPR.setVisibility(0);
        parama1 = com.tencent.mm.plugin.appbrand.appcache.e.rp(d.this.jPO.joY);
        if (!bs.isNullOrNil(parama1)) {
          break label213;
        }
        parama.jPS.setVisibility(8);
        label132:
        if ((!d.this.jvv) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qal, 0) != 1)) {
          break label232;
        }
        parama.jPU.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.modelappbrand.a.b.aAS().a(parama.fuY, paramContext.jPO.jvt, com.tencent.mm.modelappbrand.a.a.aAR(), com.tencent.mm.modelappbrand.a.g.htk);
        AppMethodBeat.o(45025);
        return;
        parama.jPR.setVisibility(8);
        break;
        label213:
        parama.jPS.setText(parama1);
        parama.jPS.setVisibility(0);
        break label132;
        label232:
        parama.jPU.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(45026);
      paramContext = (d)paramVarArgs;
      paramVarArgs = new ut();
      paramVarArgs.dxt.userName = paramContext.jPO.cYF;
      paramVarArgs.dxt.dxw = paramContext.jPO.joY;
      paramVarArgs.dxt.dxz = true;
      paramVarArgs.dxt.scene = 1027;
      paramVarArgs.dxt.cYP = "1";
      com.tencent.mm.sdk.b.a.GpY.l(paramVarArgs);
      a(d.this.sxM.syk, d.this.jPN);
      AppMethodBeat.o(45026);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.d
 * JD-Core Version:    0.7.0.1
 */