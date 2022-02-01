package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.au;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;

public final class d
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  public String hzi;
  public CharSequence lPj;
  public int nOX;
  public boolean qPv;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public AppBrandRecentTaskInfo rpq;
  private b rpr;
  a rps;
  public String userName;
  
  public d(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(45027);
    this.rpr = new b();
    this.rps = new a();
    AppMethodBeat.o(45027);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(45028);
    super.a(paramContext, parama, paramVarArgs);
    this.rpq = i.Zp(this.rpp.Hsz);
    if (this.rpq == null)
    {
      AppMethodBeat.o(45028);
      return;
    }
    boolean bool2;
    switch (this.rpp.subtype)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.lPj = f.a(com.tencent.mm.plugin.fts.a.a.g.a(this.rpq.appName, this.FWt, bool1, bool2)).HsX;
      this.hZn = this.rpq.hzi;
      this.nOX = this.rpq.nOX;
      this.qPv = this.rpq.qPv;
      AppMethodBeat.o(45028);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final a.b aXA()
  {
    return this.rpr;
  }
  
  public final String coA()
  {
    return this.hzi;
  }
  
  public final String coB()
  {
    return this.rpq.appName;
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final String getAppId()
  {
    return this.rpq.hzi;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView lBC;
    public TextView pJJ;
    public TextView rpt;
    public TextView rpu;
    public View rpv;
    public ImageView rpw;
    public ImageView rpx;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_fts_weapp_item, paramViewGroup, false);
      paramViewGroup = (d.a)d.this.rps;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(ba.f.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(ba.f.title_tv));
      paramViewGroup.contentView = paramContext.findViewById(ba.f.search_item_content_layout);
      paramViewGroup.rpt = ((TextView)paramContext.findViewById(ba.f.secondary_text));
      paramViewGroup.rpu = ((TextView)paramContext.findViewById(ba.f.tag_text));
      paramViewGroup.rpv = paramContext.findViewById(ba.f.divider);
      paramViewGroup.rpw = ((ImageView)paramContext.findViewById(ba.f.trading_guarantee_flag));
      paramViewGroup.rpx = ((ImageView)paramContext.findViewById(ba.f.official_flag));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(45024);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(45025);
      paramContext = (d)parama1;
      parama = (d.a)parama;
      com.tencent.mm.plugin.fts.ui.o.w(parama.rpv, d.this.Hup);
      if (paramContext.rpq == null)
      {
        parama.contentView.setVisibility(8);
        AppMethodBeat.o(45025);
        return;
      }
      parama.contentView.setVisibility(0);
      parama.pJJ.setText(d.this.lPj);
      if (d.this.xVf == -8)
      {
        parama.rpt.setText(ba.i.search_chatroom_appbrand);
        parama.rpt.setVisibility(0);
        parama1 = com.tencent.mm.plugin.appbrand.appcache.e.zm(d.this.rpq.eul);
        if (!Util.isNullOrNil(parama1)) {
          break label267;
        }
        parama.rpu.setVisibility(8);
        label133:
        if ((!com.tencent.luggage.sdk.config.g.da(d.this.nOX, 4)) || (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.znj, 0) != 1)) {
          break label286;
        }
        parama.rpw.setVisibility(0);
        au.a(parama.rpw, ba.h.app_brand_relieved_buy_icon);
        label186:
        if ((!d.this.qPv) || (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zqA, 0) != 1)) {
          break label298;
        }
        parama.rpx.setVisibility(0);
      }
      for (;;)
      {
        b.bEY().a(parama.lBC, paramContext.rpq.qPt, com.tencent.mm.modelappbrand.a.a.bEX(), com.tencent.mm.modelappbrand.a.g.org);
        AppMethodBeat.o(45025);
        return;
        parama.rpt.setVisibility(8);
        break;
        label267:
        parama.rpu.setText(parama1);
        parama.rpu.setVisibility(0);
        break label133;
        label286:
        parama.rpw.setVisibility(8);
        break label186;
        label298:
        parama.rpx.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      int j = 0;
      AppMethodBeat.i(316763);
      if (!WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(316763);
        return true;
      }
      paramView = (d)paramVarArgs;
      paramContext = new zp();
      d.this.userName = d.this.rpq.appName;
      d.this.hzi = d.this.rpq.hzi;
      paramContext.icM.userName = paramView.rpq.hzi;
      paramContext.icM.icP = paramView.rpq.eul;
      paramContext.icM.icT = true;
      paramContext.icM.scene = 1027;
      if ((com.tencent.luggage.sdk.config.g.da(d.this.nOX, 4)) && (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.znj, 0) == 1)) {}
      for (int i = 1;; i = 0)
      {
        paramView = paramContext.icM;
        paramVarArgs = new StringBuilder("1:");
        if (i != 0) {
          j = 1;
        }
        paramView.hzx = (j + ":" + com.tencent.mm.plugin.fts.a.e.HrM + ":" + com.tencent.mm.plugin.fts.a.e.HrN + ":" + com.tencent.mm.plugin.fts.a.e.fxu());
        paramContext.publish();
        a(d.this.FWt.Hte, d.this.rpp);
        AppMethodBeat.o(316763);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.d
 * JD-Core Version:    0.7.0.1
 */