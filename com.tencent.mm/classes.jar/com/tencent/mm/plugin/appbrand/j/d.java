package com.tencent.mm.plugin.appbrand.j;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.modelappbrand.a.g;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.expt.b.b.a;
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
  public CharSequence jml;
  public boolean nPD;
  public boolean nPE;
  public m olG;
  public AppBrandRecentTaskInfo olH;
  private b olI;
  a olJ;
  
  public d(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(45027);
    this.olI = new b();
    this.olJ = new a();
    AppMethodBeat.o(45027);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(45028);
    super.a(paramContext, parama, paramVarArgs);
    this.olH = i.agu(this.olG.BHS);
    if (this.olH == null)
    {
      AppMethodBeat.o(45028);
      return;
    }
    boolean bool2;
    switch (this.olG.BHR)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.jml = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.olH.appName, this.BHY, bool1, bool2)).BIp;
      this.fTp = this.olH.fuO;
      this.nPD = this.olH.nPD;
      this.nPE = this.olH.nPD;
      AppMethodBeat.o(45028);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final a.b aEw()
  {
    return this.olI;
  }
  
  public final String bOm()
  {
    return this.olH.appName;
  }
  
  public final int bOn()
  {
    return this.olG.BJj;
  }
  
  public final String getAppId()
  {
    return this.olH.fuO;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView iZG;
    public TextView mNb;
    public TextView olK;
    public TextView olL;
    public View olM;
    public ImageView olN;
    public ImageView olO;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(au.g.app_brand_fts_weapp_item, paramViewGroup, false);
      paramViewGroup = (d.a)d.this.olJ;
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(au.f.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(au.f.title_tv));
      paramViewGroup.contentView = paramContext.findViewById(au.f.search_item_content_layout);
      paramViewGroup.olK = ((TextView)paramContext.findViewById(au.f.secondary_text));
      paramViewGroup.olL = ((TextView)paramContext.findViewById(au.f.tag_text));
      paramViewGroup.olM = paramContext.findViewById(au.f.divider);
      paramViewGroup.olN = ((ImageView)paramContext.findViewById(au.f.trading_guarantee_flag));
      paramViewGroup.olO = ((ImageView)paramContext.findViewById(au.f.official_flag));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(45024);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(45025);
      paramContext = (d)parama1;
      parama = (d.a)parama;
      n.q(parama.olM, d.this.BJG);
      if (paramContext.olH == null)
      {
        parama.contentView.setVisibility(8);
        AppMethodBeat.o(45025);
        return;
      }
      parama.contentView.setVisibility(0);
      parama.mNb.setText(d.this.jml);
      if (d.this.uMD == -8)
      {
        parama.olK.setText(au.i.search_chatroom_appbrand);
        parama.olK.setVisibility(0);
        parama1 = com.tencent.mm.plugin.appbrand.appcache.e.yZ(d.this.olH.cBI);
        if (!Util.isNullOrNil(parama1)) {
          break label253;
        }
        parama.olL.setVisibility(8);
        label133:
        if ((!d.this.nPD) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUC, 0) != 1)) {
          break label272;
        }
        parama.olN.setVisibility(0);
        label172:
        if ((!d.this.nPE) || (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXL, 0) != 1)) {
          break label284;
        }
        parama.olO.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.modelappbrand.a.b.bhh().a(parama.iZG, paramContext.olH.nPB, com.tencent.mm.modelappbrand.a.a.bhg(), g.lzF);
        AppMethodBeat.o(45025);
        return;
        parama.olK.setVisibility(8);
        break;
        label253:
        parama.olL.setText(parama1);
        parama.olL.setVisibility(0);
        break label133;
        label272:
        parama.olN.setVisibility(8);
        break label172;
        label284:
        parama.olO.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(282352);
      if (!WeChatBrands.Business.Entries.GlobalAppbrand.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(282352);
        return true;
      }
      paramContext = (d)paramVarArgs;
      paramView = new xw();
      paramView.fWN.userName = paramContext.olH.fuO;
      paramView.fWN.fWQ = paramContext.olH.cBI;
      paramView.fWN.fWU = true;
      paramView.fWN.scene = 1027;
      paramView.fWN.fvd = "1";
      EventCenter.instance.publish(paramView);
      a(d.this.BHY.BIw, d.this.olG);
      AppMethodBeat.o(282352);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.d
 * JD-Core Version:    0.7.0.1
 */