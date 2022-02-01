package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.plugin.fts.ui.o.f;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.fpj;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class s
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static int BPS;
  public long BHT;
  public fpj BPN;
  public String BPO;
  public boolean BPP;
  private CharSequence BPQ;
  private CharSequence BPR;
  private b BPT;
  a BPU;
  public String contentType;
  private CharSequence mMY;
  public boolean nPD;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(112129);
    BPS = com.tencent.mm.ci.a.kr(MMApplicationContext.getContext()) - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 116);
    AppMethodBeat.o(112129);
  }
  
  public s(int paramInt)
  {
    super(14, paramInt);
    AppMethodBeat.i(112127);
    this.BPT = new b();
    this.BPU = new a();
    AppMethodBeat.o(112127);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112128);
    super.a(paramContext, parama, paramVarArgs);
    label266:
    label272:
    try
    {
      paramContext = new JSONObject(this.BPN.UNe);
      parama = paramContext.optString("title", "");
      this.thumbUrl = paramContext.optString("image", "");
      this.BPO = paramContext.optString("search_buffer", "");
      this.BPQ = f.aHP(parama);
      this.contentType = paramContext.optString("content_type", "");
      if (paramContext.optInt("security_icon", 0) != 1) {
        break label266;
      }
      bool = true;
      this.nPD = bool;
      if (paramContext.optInt("brand_official_label", 0) == 0) {
        break label272;
      }
      bool = true;
      label113:
      this.BPP = bool;
    }
    catch (Exception paramContext)
    {
      boolean bool;
      label119:
      break label119;
    }
    if ("HOME".equals(this.contentType)) {
      hx(2, 0);
    }
    for (;;)
    {
      this.BPR = f.aHP(this.BPN.RIC);
      this.mMY = this.BPN.rWI;
      this.BHT = System.currentTimeMillis();
      paramContext = new dxw();
      paramContext.lVG = this.BPN.lVG;
      paramContext.CPw = 25;
      paramContext.UdA = com.tencent.mm.plugin.fts.a.e.BHj;
      paramContext.UdF = com.tencent.mm.plugin.fts.a.e.BHi;
      paramContext.TVZ = this.BHT;
      paramContext.UdE = this.position;
      paramContext.TxX = 0;
      paramContext.UdB = this.BPO;
      paramContext.UdC = 1;
      paramContext = new com.tencent.mm.plugin.fts.ui.c.e(paramContext);
      h.aGY().a(paramContext, 0);
      AppMethodBeat.o(112128);
      return;
      bool = false;
      break;
      bool = false;
      break label113;
      hx(1, 0);
    }
  }
  
  public final a.b aEw()
  {
    return this.BPT;
  }
  
  public final String getAppId()
  {
    return this.BPN.UserName;
  }
  
  public final class a
    extends a.a
  {
    public View BPV;
    public ImageView BPW;
    public ImageView BPX;
    public ImageView BPY;
    public View BPZ;
    public TextView BQa;
    public ImageView iZG;
    public TextView iZH;
    public TextView mNb;
    public TextView mrM;
    public ImageView olN;
    public TextView yZg;
    
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
      AppMethodBeat.i(112124);
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_we_app_search_item, paramViewGroup, false);
      paramViewGroup = (s.a)s.this.BPU;
      paramViewGroup.BPV = paramContext.findViewById(o.d.article_layout);
      paramViewGroup.BPW = ((ImageView)paramContext.findViewById(o.d.thumb_iv));
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(o.d.title_tv));
      paramViewGroup.mrM = ((TextView)paramContext.findViewById(o.d.desc_tv));
      paramViewGroup.yZg = ((TextView)paramContext.findViewById(o.d.tip_tv));
      paramViewGroup.BPX = ((ImageView)paramContext.findViewById(o.d.video_iv));
      paramViewGroup.BPZ = paramContext.findViewById(o.d.contact_layout);
      paramViewGroup.iZH = ((TextView)paramContext.findViewById(o.d.nickname_tv));
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(o.d.avatar_iv));
      paramViewGroup.BQa = ((TextView)paramContext.findViewById(o.d.contact_desc_tv));
      paramViewGroup.olN = ((ImageView)paramContext.findViewById(o.d.trading_guarantee_icon));
      paramViewGroup.BPY = ((ImageView)paramContext.findViewById(o.d.official_flag));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112124);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112125);
      parama = (s.a)parama;
      if ("HOME".equals(s.this.contentType))
      {
        parama.BPV.setVisibility(8);
        parama.BPZ.setVisibility(0);
        n.a(paramContext, parama.iZG, s.a(s.this), null, o.f.fts_weapp_search_default_icon, parama.BPW.getMeasuredWidth(), parama.BPW.getMeasuredHeight());
        parama.iZH.setText(s.b(s.this));
        parama.BQa.setText(s.c(s.this));
        paramContext = parama.olN;
        if ((s.this.nPD) && (((b)h.ae(b.class)).a(b.a.vUD, 0) == 1))
        {
          i = 0;
          paramContext.setVisibility(i);
          paramContext = parama.BPY;
          if ((!s.this.BPP) || (((b)h.ae(b.class)).a(b.a.vXL, 0) != 1)) {
            break label229;
          }
        }
        label229:
        for (int i = 0;; i = 8)
        {
          paramContext.setVisibility(i);
          if (!"VIDEO".equals(s.this.contentType)) {
            break label445;
          }
          parama.BPX.setVisibility(0);
          AppMethodBeat.o(112125);
          return;
          i = 8;
          break;
        }
      }
      parama.BPV.setVisibility(0);
      parama.BPZ.setVisibility(8);
      n.a(paramContext, parama.BPW, s.a(s.this), null, o.f.fts_weapp_search_default_icon, parama.BPW.getMeasuredWidth(), parama.BPW.getMeasuredHeight());
      if (parama.mNb.getPaint().measureText(s.b(s.this).toString()) >= s.BPS)
      {
        parama.mNb.setMaxLines(2);
        parama.mrM.setMaxLines(1);
      }
      for (;;)
      {
        parama.mNb.setText(s.b(s.this));
        parama.mrM.setText(s.c(s.this));
        parama.yZg.setText(s.d(s.this));
        break;
        if (parama.mrM.getPaint().measureText(s.c(s.this).toString()) >= s.BPS)
        {
          parama.mNb.setMaxLines(1);
          parama.mrM.setMaxLines(2);
        }
        else
        {
          parama.mNb.setMaxLines(1);
          parama.mrM.setMaxLines(1);
        }
      }
      label445:
      parama.BPX.setVisibility(8);
      AppMethodBeat.o(112125);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(193512);
      paramContext = (s)paramVarArgs;
      paramView = new dxw();
      paramView.lVG = paramContext.BPN.lVG;
      paramView.CPw = 25;
      paramView.UdA = com.tencent.mm.plugin.fts.a.e.BHj;
      paramView.UdF = com.tencent.mm.plugin.fts.a.e.BHi;
      paramView.TVZ = System.currentTimeMillis();
      paramView.UdE = paramContext.position;
      paramView.TxX = ((int)(paramView.TVZ - paramContext.BHT));
      paramView.UdB = paramContext.BPO;
      paramView.UdD = 1;
      paramContext = new com.tencent.mm.plugin.fts.ui.c.e(paramView);
      h.aGY().a(paramContext, 0);
      paramContext = new xw();
      paramContext.fWN.userName = s.this.BPN.UserName;
      paramContext.fWN.fWP = s.this.BPN.CqK;
      paramContext.fWN.scene = 1027;
      paramContext.fWN.fvd = ("$CASSP$B" + com.tencent.mm.plugin.fts.a.e.BHj + ":" + s.this.BPN.Uhd + ":3");
      EventCenter.instance.publish(paramContext);
      AppMethodBeat.o(193512);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s
 * JD-Core Version:    0.7.0.1
 */