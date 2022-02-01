package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.protocal.protobuf.ckf;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class s
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static int rws;
  public String bxn;
  public long exposeTime;
  public boolean iVf;
  private CharSequence ibW;
  public dwd rwo;
  public String rwp;
  private CharSequence rwq;
  private CharSequence rwr;
  private b rwt;
  a rwu;
  private String thumbUrl;
  
  static
  {
    AppMethodBeat.i(112129);
    rws = com.tencent.mm.cd.a.hV(aj.getContext()) - com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 116);
    AppMethodBeat.o(112129);
  }
  
  public s(int paramInt)
  {
    super(14, paramInt);
    AppMethodBeat.i(112127);
    this.rwt = new b();
    this.rwu = new a();
    AppMethodBeat.o(112127);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112128);
    super.a(paramContext, parama, paramVarArgs);
    try
    {
      paramContext = new JSONObject(this.rwo.EJU);
      parama = paramContext.optString("title", "");
      this.thumbUrl = paramContext.optString("image", "");
      this.rwp = paramContext.optString("search_buffer", "");
      this.rwq = f.abd(parama);
      this.bxn = paramContext.optString("content_type", "");
      if (paramContext.optInt("security_icon", 0) != 1) {
        break label247;
      }
      bool = true;
      this.iVf = bool;
    }
    catch (Exception paramContext)
    {
      boolean bool;
      label100:
      label247:
      break label100;
    }
    if ("HOME".equals(this.bxn)) {
      fI(2, 0);
    }
    for (;;)
    {
      this.rwr = f.abd(this.rwo.Cxw);
      this.ibW = this.rwo.mBV;
      this.exposeTime = System.currentTimeMillis();
      paramContext = new ckf();
      paramContext.hnC = this.rwo.hnC;
      paramContext.Scene = 25;
      paramContext.Efv = e.roc;
      paramContext.EfA = e.rob;
      paramContext.DYU = this.exposeTime;
      paramContext.Efz = this.position;
      paramContext.DJm = 0;
      paramContext.Efw = this.rwp;
      paramContext.Efx = 1;
      paramContext = new d(paramContext);
      g.aeS().a(paramContext, 0);
      AppMethodBeat.o(112128);
      return;
      bool = false;
      break;
      fI(1, 0);
    }
  }
  
  public final a.b acQ()
  {
    return this.rwt;
  }
  
  public final String getAppId()
  {
    return this.rwo.mAQ;
  }
  
  public final class a
    extends a.a
  {
    public ImageView frr;
    public TextView frs;
    public TextView hJe;
    public TextView ica;
    public ImageView jpF;
    public TextView ruT;
    public View rwv;
    public ImageView rww;
    public ImageView rwx;
    public View rwy;
    public TextView rwz;
    
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
      paramViewGroup = (s.a)s.this.rwu;
      paramViewGroup.rwv = paramContext.findViewById(2131296946);
      paramViewGroup.rww = ((ImageView)paramContext.findViewById(2131305798));
      paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.ruT = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.rwx = ((ImageView)paramContext.findViewById(2131306350));
      paramViewGroup.rwy = paramContext.findViewById(2131298673);
      paramViewGroup.frs = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.rwz = ((TextView)paramContext.findViewById(2131298593));
      paramViewGroup.jpF = ((ImageView)paramContext.findViewById(2131306057));
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112124);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112125);
      parama = (s.a)parama;
      if ("HOME".equals(s.this.bxn))
      {
        parama.rwv.setVisibility(8);
        parama.rwy.setVisibility(0);
        m.a(paramContext, parama.frr, s.a(s.this), null, 2131690266, parama.rww.getMeasuredWidth(), parama.rww.getMeasuredHeight());
        parama.frs.setText(s.b(s.this));
        parama.rwz.setText(s.c(s.this));
        paramContext = parama.jpF;
        if ((s.this.iVf) && (((b)g.ab(b.class)).a(b.a.pvY, 0) == 1)) {}
        for (int i = 0;; i = 8)
        {
          paramContext.setVisibility(i);
          if (!"VIDEO".equals(s.this.bxn)) {
            break;
          }
          parama.rwx.setVisibility(0);
          AppMethodBeat.o(112125);
          return;
        }
      }
      parama.rwv.setVisibility(0);
      parama.rwy.setVisibility(8);
      m.a(paramContext, parama.rww, s.a(s.this), null, 2131690266, parama.rww.getMeasuredWidth(), parama.rww.getMeasuredHeight());
      if (parama.ica.getPaint().measureText(s.b(s.this).toString()) >= s.rws)
      {
        parama.ica.setMaxLines(2);
        parama.hJe.setMaxLines(1);
      }
      for (;;)
      {
        parama.ica.setText(s.b(s.this));
        parama.hJe.setText(s.c(s.this));
        parama.ruT.setText(s.d(s.this));
        break;
        if (parama.hJe.getPaint().measureText(s.c(s.this).toString()) >= s.rws)
        {
          parama.ica.setMaxLines(1);
          parama.hJe.setMaxLines(2);
        }
        else
        {
          parama.ica.setMaxLines(1);
          parama.hJe.setMaxLines(1);
        }
      }
      parama.rwx.setVisibility(8);
      AppMethodBeat.o(112125);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112126);
      paramContext = (s)paramVarArgs;
      paramVarArgs = new ckf();
      paramVarArgs.hnC = paramContext.rwo.hnC;
      paramVarArgs.Scene = 25;
      paramVarArgs.Efv = e.roc;
      paramVarArgs.EfA = e.rob;
      paramVarArgs.DYU = System.currentTimeMillis();
      paramVarArgs.Efz = paramContext.position;
      paramVarArgs.DJm = ((int)(paramVarArgs.DYU - paramContext.exposeTime));
      paramVarArgs.Efw = paramContext.rwp;
      paramVarArgs.Efy = 1;
      paramContext = new d(paramVarArgs);
      g.aeS().a(paramContext, 0);
      paramContext = new uj();
      paramContext.dzH.userName = s.this.rwo.mAQ;
      paramContext.dzH.dzJ = s.this.rwo.sdZ;
      paramContext.dzH.scene = 1027;
      paramContext.dzH.dbt = ("$CASSP$B" + e.roc + ":" + s.this.rwo.EJQ + ":3");
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      AppMethodBeat.o(112126);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s
 * JD-Core Version:    0.7.0.1
 */