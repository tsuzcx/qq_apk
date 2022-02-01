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
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.ebu;
import com.tencent.mm.sdk.platformtools.ai;
import org.json.JSONObject;

public final class s
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static int sFk;
  public String contentType;
  private CharSequence iCd;
  public boolean jvv;
  public ebu sFg;
  public String sFh;
  private CharSequence sFi;
  private CharSequence sFj;
  private b sFl;
  a sFm;
  public long sxH;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(112129);
    sFk = com.tencent.mm.cc.a.ig(ai.getContext()) - com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 116);
    AppMethodBeat.o(112129);
  }
  
  public s(int paramInt)
  {
    super(14, paramInt);
    AppMethodBeat.i(112127);
    this.sFl = new b();
    this.sFm = new a();
    AppMethodBeat.o(112127);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112128);
    super.a(paramContext, parama, paramVarArgs);
    try
    {
      paramContext = new JSONObject(this.sFg.Ghg);
      parama = paramContext.optString("title", "");
      this.thumbUrl = paramContext.optString("image", "");
      this.sFh = paramContext.optString("search_buffer", "");
      this.sFi = f.afV(parama);
      this.contentType = paramContext.optString("content_type", "");
      if (paramContext.optInt("security_icon", 0) != 1) {
        break label247;
      }
      bool = true;
      this.jvv = bool;
    }
    catch (Exception paramContext)
    {
      boolean bool;
      label100:
      label247:
      break label100;
    }
    if ("HOME".equals(this.contentType)) {
      fP(2, 0);
    }
    for (;;)
    {
      this.sFj = f.afV(this.sFg.DPS);
      this.iCd = this.sFg.ndW;
      this.sxH = System.currentTimeMillis();
      paramContext = new cpm();
      paramContext.hOf = this.sFg.hOf;
      paramContext.Scene = 25;
      paramContext.FCv = e.swW;
      paramContext.FCA = e.swV;
      paramContext.FvQ = this.sxH;
      paramContext.FCz = this.position;
      paramContext.FeH = 0;
      paramContext.FCw = this.sFh;
      paramContext.FCx = 1;
      paramContext = new d(paramContext);
      g.agi().a(paramContext, 0);
      AppMethodBeat.o(112128);
      return;
      bool = false;
      break;
      fP(1, 0);
    }
  }
  
  public final a.b adW()
  {
    return this.sFl;
  }
  
  public final String getAppId()
  {
    return this.sFg.ncR;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fuY;
    public TextView fuZ;
    public TextView iCg;
    public TextView ijE;
    public ImageView jPU;
    public TextView sDL;
    public View sFn;
    public ImageView sFo;
    public ImageView sFp;
    public View sFq;
    public TextView sFr;
    
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
      paramViewGroup = (s.a)s.this.sFm;
      paramViewGroup.sFn = paramContext.findViewById(2131296946);
      paramViewGroup.sFo = ((ImageView)paramContext.findViewById(2131305798));
      paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.sDL = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.sFp = ((ImageView)paramContext.findViewById(2131306350));
      paramViewGroup.sFq = paramContext.findViewById(2131298673);
      paramViewGroup.fuZ = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.sFr = ((TextView)paramContext.findViewById(2131298593));
      paramViewGroup.jPU = ((ImageView)paramContext.findViewById(2131306057));
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
        parama.sFn.setVisibility(8);
        parama.sFq.setVisibility(0);
        m.a(paramContext, parama.fuY, s.a(s.this), null, 2131690266, parama.sFo.getMeasuredWidth(), parama.sFo.getMeasuredHeight());
        parama.fuZ.setText(s.b(s.this));
        parama.sFr.setText(s.c(s.this));
        paramContext = parama.jPU;
        if ((s.this.jvv) && (((b)g.ab(b.class)).a(b.a.qam, 0) == 1)) {}
        for (int i = 0;; i = 8)
        {
          paramContext.setVisibility(i);
          if (!"VIDEO".equals(s.this.contentType)) {
            break;
          }
          parama.sFp.setVisibility(0);
          AppMethodBeat.o(112125);
          return;
        }
      }
      parama.sFn.setVisibility(0);
      parama.sFq.setVisibility(8);
      m.a(paramContext, parama.sFo, s.a(s.this), null, 2131690266, parama.sFo.getMeasuredWidth(), parama.sFo.getMeasuredHeight());
      if (parama.iCg.getPaint().measureText(s.b(s.this).toString()) >= s.sFk)
      {
        parama.iCg.setMaxLines(2);
        parama.ijE.setMaxLines(1);
      }
      for (;;)
      {
        parama.iCg.setText(s.b(s.this));
        parama.ijE.setText(s.c(s.this));
        parama.sDL.setText(s.d(s.this));
        break;
        if (parama.ijE.getPaint().measureText(s.c(s.this).toString()) >= s.sFk)
        {
          parama.iCg.setMaxLines(1);
          parama.ijE.setMaxLines(2);
        }
        else
        {
          parama.iCg.setMaxLines(1);
          parama.ijE.setMaxLines(1);
        }
      }
      parama.sFp.setVisibility(8);
      AppMethodBeat.o(112125);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112126);
      paramContext = (s)paramVarArgs;
      paramVarArgs = new cpm();
      paramVarArgs.hOf = paramContext.sFg.hOf;
      paramVarArgs.Scene = 25;
      paramVarArgs.FCv = e.swW;
      paramVarArgs.FCA = e.swV;
      paramVarArgs.FvQ = System.currentTimeMillis();
      paramVarArgs.FCz = paramContext.position;
      paramVarArgs.FeH = ((int)(paramVarArgs.FvQ - paramContext.sxH));
      paramVarArgs.FCw = paramContext.sFh;
      paramVarArgs.FCy = 1;
      paramContext = new d(paramVarArgs);
      g.agi().a(paramContext, 0);
      paramContext = new ut();
      paramContext.dxt.userName = s.this.sFg.ncR;
      paramContext.dxt.dxv = s.this.sFg.tlT;
      paramContext.dxt.scene = 1027;
      paramContext.dxt.cYP = ("$CASSP$B" + e.swW + ":" + s.this.sFg.Ghc + ":3");
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
      AppMethodBeat.o(112126);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s
 * JD-Core Version:    0.7.0.1
 */