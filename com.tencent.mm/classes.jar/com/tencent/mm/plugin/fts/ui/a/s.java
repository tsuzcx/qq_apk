package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.protocal.protobuf.ejp;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONObject;

public final class s
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static int tMU;
  public String contentType;
  private CharSequence iYg;
  public boolean jSG;
  public long tEZ;
  public ejp tMP;
  public String tMQ;
  public boolean tMR;
  private CharSequence tMS;
  private CharSequence tMT;
  private b tMV;
  a tMW;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(112129);
    tMU = com.tencent.mm.cb.a.iu(ak.getContext()) - com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 116);
    AppMethodBeat.o(112129);
  }
  
  public s(int paramInt)
  {
    super(14, paramInt);
    AppMethodBeat.i(112127);
    this.tMV = new b();
    this.tMW = new a();
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
      paramContext = new JSONObject(this.tMP.ImA);
      parama = paramContext.optString("title", "");
      this.thumbUrl = paramContext.optString("image", "");
      this.tMQ = paramContext.optString("search_buffer", "");
      this.tMS = f.alr(parama);
      this.contentType = paramContext.optString("content_type", "");
      if (paramContext.optInt("security_icon", 0) != 1) {
        break label266;
      }
      bool = true;
      this.jSG = bool;
      if (paramContext.optInt("brand_official_label", 0) == 0) {
        break label272;
      }
      bool = true;
      label113:
      this.tMR = bool;
    }
    catch (Exception paramContext)
    {
      boolean bool;
      label119:
      break label119;
    }
    if ("HOME".equals(this.contentType)) {
      gf(2, 0);
    }
    for (;;)
    {
      this.tMT = f.alr(this.tMP.FNF);
      this.iYg = this.tMP.nJO;
      this.tEZ = System.currentTimeMillis();
      paramContext = new cvl();
      paramContext.ikm = this.tMP.ikm;
      paramContext.Scene = 25;
      paramContext.HGk = e.tEo;
      paramContext.HGp = e.tEn;
      paramContext.Hzw = this.tEZ;
      paramContext.HGo = this.position;
      paramContext.HhL = 0;
      paramContext.HGl = this.tMQ;
      paramContext.HGm = 1;
      paramContext = new d(paramContext);
      g.ajj().a(paramContext, 0);
      AppMethodBeat.o(112128);
      return;
      bool = false;
      break;
      bool = false;
      break label113;
      gf(1, 0);
    }
  }
  
  public final a.b agQ()
  {
    return this.tMV;
  }
  
  public final String getAppId()
  {
    return this.tMP.nIJ;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fQl;
    public TextView fQm;
    public TextView iFO;
    public TextView iYj;
    public ImageView knv;
    public TextView tLr;
    public View tMX;
    public ImageView tMY;
    public ImageView tMZ;
    public ImageView tNa;
    public View tNb;
    public TextView tNc;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494222, paramViewGroup, false);
      paramViewGroup = (s.a)s.this.tMW;
      paramViewGroup.tMX = paramContext.findViewById(2131296946);
      paramViewGroup.tMY = ((ImageView)paramContext.findViewById(2131305798));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.tLr = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.tMZ = ((ImageView)paramContext.findViewById(2131306350));
      paramViewGroup.tNb = paramContext.findViewById(2131298673);
      paramViewGroup.fQm = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.tNc = ((TextView)paramContext.findViewById(2131298593));
      paramViewGroup.knv = ((ImageView)paramContext.findViewById(2131306057));
      paramViewGroup.tNa = ((ImageView)paramContext.findViewById(2131308167));
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
        parama.tMX.setVisibility(8);
        parama.tNb.setVisibility(0);
        n.a(paramContext, parama.fQl, s.a(s.this), null, 2131690266, parama.tMY.getMeasuredWidth(), parama.tMY.getMeasuredHeight());
        parama.fQm.setText(s.b(s.this));
        parama.tNc.setText(s.c(s.this));
        paramContext = parama.knv;
        if ((s.this.jSG) && (((b)g.ab(b.class)).a(b.a.qNo, 0) == 1))
        {
          i = 0;
          paramContext.setVisibility(i);
          paramContext = parama.tNa;
          if ((!s.this.tMR) || (((b)g.ab(b.class)).a(b.a.qPC, 0) != 1)) {
            break label228;
          }
        }
        label228:
        for (int i = 0;; i = 8)
        {
          paramContext.setVisibility(i);
          if (!"VIDEO".equals(s.this.contentType)) {
            break label443;
          }
          parama.tMZ.setVisibility(0);
          AppMethodBeat.o(112125);
          return;
          i = 8;
          break;
        }
      }
      parama.tMX.setVisibility(0);
      parama.tNb.setVisibility(8);
      n.a(paramContext, parama.tMY, s.a(s.this), null, 2131690266, parama.tMY.getMeasuredWidth(), parama.tMY.getMeasuredHeight());
      if (parama.iYj.getPaint().measureText(s.b(s.this).toString()) >= s.tMU)
      {
        parama.iYj.setMaxLines(2);
        parama.iFO.setMaxLines(1);
      }
      for (;;)
      {
        parama.iYj.setText(s.b(s.this));
        parama.iFO.setText(s.c(s.this));
        parama.tLr.setText(s.d(s.this));
        break;
        if (parama.iFO.getPaint().measureText(s.c(s.this).toString()) >= s.tMU)
        {
          parama.iYj.setMaxLines(1);
          parama.iFO.setMaxLines(2);
        }
        else
        {
          parama.iYj.setMaxLines(1);
          parama.iFO.setMaxLines(1);
        }
      }
      label443:
      parama.tMZ.setVisibility(8);
      AppMethodBeat.o(112125);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112126);
      paramContext = (s)paramVarArgs;
      paramVarArgs = new cvl();
      paramVarArgs.ikm = paramContext.tMP.ikm;
      paramVarArgs.Scene = 25;
      paramVarArgs.HGk = e.tEo;
      paramVarArgs.HGp = e.tEn;
      paramVarArgs.Hzw = System.currentTimeMillis();
      paramVarArgs.HGo = paramContext.position;
      paramVarArgs.HhL = ((int)(paramVarArgs.Hzw - paramContext.tEZ));
      paramVarArgs.HGl = paramContext.tMQ;
      paramVarArgs.HGn = 1;
      paramContext = new d(paramVarArgs);
      g.ajj().a(paramContext, 0);
      paramContext = new vq();
      paramContext.dKT.userName = s.this.tMP.nIJ;
      paramContext.dKT.dKV = s.this.tMP.uuA;
      paramContext.dKT.scene = 1027;
      paramContext.dKT.dlj = ("$CASSP$B" + e.tEo + ":" + s.this.tMP.Imw + ":3");
      com.tencent.mm.sdk.b.a.IvT.l(paramContext);
      AppMethodBeat.o(112126);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s
 * JD-Core Version:    0.7.0.1
 */