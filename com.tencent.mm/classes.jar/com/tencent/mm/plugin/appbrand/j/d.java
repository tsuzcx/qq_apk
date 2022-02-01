package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

public final class d
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public CharSequence gCf;
  public boolean kVq;
  public boolean kVr;
  public m lqW;
  public AppBrandRecentTaskInfo lqX;
  private b lqY;
  a lqZ;
  
  public d(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(45027);
    this.lqY = new b();
    this.lqZ = new a();
    AppMethodBeat.o(45027);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(45028);
    super.a(paramContext, parama, paramVarArgs);
    this.lqX = i.YG(this.lqW.wVX);
    if (this.lqX == null)
    {
      AppMethodBeat.o(45028);
      return;
    }
    boolean bool2;
    switch (this.lqW.wVW)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.gCf = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.lqX.appName, this.wWd, bool1, bool2)).wWu;
      this.info = this.lqX.dCl;
      this.kVq = this.lqX.kVq;
      this.kVr = this.lqX.kVq;
      AppMethodBeat.o(45028);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final a.b axc()
  {
    return this.lqY;
  }
  
  public final String bCR()
  {
    return this.lqX.appName;
  }
  
  public final int bCS()
  {
    return this.lqW.wXn;
  }
  
  public final String getAppId()
  {
    return this.lqX.dCl;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView gvv;
    public TextView jVO;
    public TextView lra;
    public TextView lrb;
    public View lrc;
    public ImageView lrd;
    public ImageView lre;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131493030, paramViewGroup, false);
      paramViewGroup = (d.a)d.this.lqZ;
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.contentView = paramContext.findViewById(2131307399);
      paramViewGroup.lra = ((TextView)paramContext.findViewById(2131307446));
      paramViewGroup.lrb = ((TextView)paramContext.findViewById(2131308875));
      paramViewGroup.lrc = paramContext.findViewById(2131299682);
      paramViewGroup.lrd = ((ImageView)paramContext.findViewById(2131309386));
      paramViewGroup.lre = ((ImageView)paramContext.findViewById(2131305577));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(45024);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(45025);
      paramContext = (d)parama1;
      parama = (d.a)parama;
      n.q(parama.lrc, d.this.wXK);
      if (paramContext.lqX == null)
      {
        parama.contentView.setVisibility(8);
        AppMethodBeat.o(45025);
        return;
      }
      parama.contentView.setVisibility(0);
      parama.jVO.setText(d.this.gCf);
      if (d.this.rjr == -8)
      {
        parama.lra.setText(2131765042);
        parama.lra.setVisibility(0);
        parama1 = com.tencent.mm.plugin.appbrand.appcache.e.vO(d.this.lqX.eix);
        if (!Util.isNullOrNil(parama1)) {
          break label252;
        }
        parama.lrb.setVisibility(8);
        label132:
        if ((!d.this.kVq) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.ski, 0) != 1)) {
          break label271;
        }
        parama.lrd.setVisibility(0);
        label171:
        if ((!d.this.kVr) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smL, 0) != 1)) {
          break label283;
        }
        parama.lre.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.modelappbrand.a.b.aXY().a(parama.gvv, paramContext.lqX.kVo, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
        AppMethodBeat.o(45025);
        return;
        parama.lra.setVisibility(8);
        break;
        label252:
        parama.lrb.setText(parama1);
        parama.lrb.setVisibility(0);
        break label132;
        label271:
        parama.lrd.setVisibility(8);
        break label171;
        label283:
        parama.lre.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(226608);
      if (!WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(226608);
        return true;
      }
      paramContext = (d)paramVarArgs;
      paramView = new wq();
      paramView.ecI.userName = paramContext.lqX.dCl;
      paramView.ecI.ecL = paramContext.lqX.eix;
      paramView.ecI.ecP = true;
      paramView.ecI.scene = 1027;
      paramView.ecI.dCw = "1";
      EventCenter.instance.publish(paramView);
      a(d.this.wWd.wWB, d.this.lqW);
      AppMethodBeat.o(226608);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.d
 * JD-Core Version:    0.7.0.1
 */