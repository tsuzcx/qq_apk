package com.tencent.mm.plugin.appbrand.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.sdk.platformtools.bt;

public final class d
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence fxZ;
  public boolean iVf;
  private b jpA;
  a jpB;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public AppBrandRecentTaskInfo jpz;
  
  public d(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(45027);
    this.jpA = new b();
    this.jpB = new a();
    AppMethodBeat.o(45027);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(45028);
    super.a(paramContext, parama, paramVarArgs);
    this.jpz = i.Hp(this.jpy.roN);
    if (this.jpz == null)
    {
      AppMethodBeat.o(45028);
      return;
    }
    boolean bool2;
    switch (this.jpy.roM)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.fxZ = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.jpz.appName, this.roS, bool1, bool2)).rpj;
      this.info = this.jpz.dbj;
      this.iVf = this.jpz.iVf;
      AppMethodBeat.o(45028);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final String aWt()
  {
    return this.jpz.appName;
  }
  
  public final int aWu()
  {
    return this.jpy.rqc;
  }
  
  public final a.b acQ()
  {
    return this.jpA;
  }
  
  public final String getAppId()
  {
    return this.jpz.dbj;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView frr;
    public TextView ica;
    public TextView jpC;
    public TextView jpD;
    public View jpE;
    public ImageView jpF;
    
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
      paramViewGroup = (d.a)d.this.jpB;
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.jpC = ((TextView)paramContext.findViewById(2131304468));
      paramViewGroup.jpD = ((TextView)paramContext.findViewById(2131305633));
      paramViewGroup.jpE = paramContext.findViewById(2131299154);
      paramViewGroup.jpF = ((ImageView)paramContext.findViewById(2131306056));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(45024);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(45025);
      paramContext = (d)parama1;
      parama = (d.a)parama;
      com.tencent.mm.plugin.fts.ui.m.p(parama.jpE, d.this.rqz);
      if (paramContext.jpz == null)
      {
        parama.contentView.setVisibility(8);
        AppMethodBeat.o(45025);
        return;
      }
      parama.contentView.setVisibility(0);
      parama.ica.setText(d.this.fxZ);
      if (d.this.oEL == -8)
      {
        parama.jpC.setText(2131762906);
        parama.jpC.setVisibility(0);
        parama1 = com.tencent.mm.plugin.appbrand.appcache.e.qC(d.this.jpz.iOP);
        if (!bt.isNullOrNil(parama1)) {
          break label213;
        }
        parama.jpD.setVisibility(8);
        label132:
        if ((!d.this.iVf) || (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvX, 0) != 1)) {
          break label232;
        }
        parama.jpF.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.modelappbrand.a.b.aub().a(parama.frr, paramContext.jpz.iVd, com.tencent.mm.modelappbrand.a.a.aua(), com.tencent.mm.modelappbrand.a.g.gSK);
        AppMethodBeat.o(45025);
        return;
        parama.jpC.setVisibility(8);
        break;
        label213:
        parama.jpD.setText(parama1);
        parama.jpD.setVisibility(0);
        break label132;
        label232:
        parama.jpF.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(45026);
      paramContext = (d)paramVarArgs;
      paramVarArgs = new uj();
      paramVarArgs.dzH.userName = paramContext.jpz.dbj;
      paramVarArgs.dzH.dzK = paramContext.jpz.iOP;
      paramVarArgs.dzH.dzN = true;
      paramVarArgs.dzH.scene = 1027;
      paramVarArgs.dzH.dbt = "1";
      com.tencent.mm.sdk.b.a.ESL.l(paramVarArgs);
      a(d.this.roS.rpq, d.this.jpy);
      AppMethodBeat.o(45026);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.k.d
 * JD-Core Version:    0.7.0.1
 */