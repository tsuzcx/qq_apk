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
import com.tencent.mm.g.a.vm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.c.d;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.protocal.protobuf.cur;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.aj;
import org.json.JSONObject;

public final class s
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static int tCd;
  public String contentType;
  private CharSequence iVn;
  public boolean jPo;
  public ehy tBY;
  public String tBZ;
  public boolean tCa;
  private CharSequence tCb;
  private CharSequence tCc;
  private b tCe;
  a tCf;
  private String thumbUrl;
  public long tui;
  
  static
  {
    AppMethodBeat.i(112129);
    tCd = com.tencent.mm.cc.a.ip(aj.getContext()) - com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 116);
    AppMethodBeat.o(112129);
  }
  
  public s(int paramInt)
  {
    super(14, paramInt);
    AppMethodBeat.i(112127);
    this.tCe = new b();
    this.tCf = new a();
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
      paramContext = new JSONObject(this.tBY.HSt);
      parama = paramContext.optString("title", "");
      this.thumbUrl = paramContext.optString("image", "");
      this.tBZ = paramContext.optString("search_buffer", "");
      this.tCb = f.akt(parama);
      this.contentType = paramContext.optString("content_type", "");
      if (paramContext.optInt("security_icon", 0) != 1) {
        break label266;
      }
      bool = true;
      this.jPo = bool;
      if (paramContext.optInt("brand_official_label", 0) == 0) {
        break label272;
      }
      bool = true;
      label113:
      this.tCa = bool;
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
      this.tCc = f.akt(this.tBY.Fvh);
      this.iVn = this.tBY.nEt;
      this.tui = System.currentTimeMillis();
      paramContext = new cur();
      paramContext.iht = this.tBY.iht;
      paramContext.Scene = 25;
      paramContext.HmK = e.ttx;
      paramContext.HmP = e.ttw;
      paramContext.HfW = this.tui;
      paramContext.HmO = this.position;
      paramContext.GOl = 0;
      paramContext.HmL = this.tBZ;
      paramContext.HmM = 1;
      paramContext = new d(paramContext);
      g.aiU().a(paramContext, 0);
      AppMethodBeat.o(112128);
      return;
      bool = false;
      break;
      bool = false;
      break label113;
      gf(1, 0);
    }
  }
  
  public final a.b agC()
  {
    return this.tCe;
  }
  
  public final String getAppId()
  {
    return this.tBY.nDo;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fOf;
    public TextView fOg;
    public TextView iCV;
    public TextView iVq;
    public ImageView kkf;
    public TextView tAA;
    public View tCg;
    public ImageView tCh;
    public ImageView tCi;
    public ImageView tCj;
    public View tCk;
    public TextView tCl;
    
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
      paramViewGroup = (s.a)s.this.tCf;
      paramViewGroup.tCg = paramContext.findViewById(2131296946);
      paramViewGroup.tCh = ((ImageView)paramContext.findViewById(2131305798));
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.tAA = ((TextView)paramContext.findViewById(2131305880));
      paramViewGroup.tCi = ((ImageView)paramContext.findViewById(2131306350));
      paramViewGroup.tCk = paramContext.findViewById(2131298673);
      paramViewGroup.fOg = ((TextView)paramContext.findViewById(2131302867));
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.tCl = ((TextView)paramContext.findViewById(2131298593));
      paramViewGroup.kkf = ((ImageView)paramContext.findViewById(2131306057));
      paramViewGroup.tCj = ((ImageView)paramContext.findViewById(2131308167));
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
        parama.tCg.setVisibility(8);
        parama.tCk.setVisibility(0);
        n.a(paramContext, parama.fOf, s.a(s.this), null, 2131690266, parama.tCh.getMeasuredWidth(), parama.tCh.getMeasuredHeight());
        parama.fOg.setText(s.b(s.this));
        parama.tCl.setText(s.c(s.this));
        paramContext = parama.kkf;
        if ((s.this.jPo) && (((b)g.ab(b.class)).a(b.a.qFI, 0) == 1))
        {
          i = 0;
          paramContext.setVisibility(i);
          paramContext = parama.tCj;
          if ((!s.this.tCa) || (((b)g.ab(b.class)).a(b.a.qHW, 0) != 1)) {
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
          parama.tCi.setVisibility(0);
          AppMethodBeat.o(112125);
          return;
          i = 8;
          break;
        }
      }
      parama.tCg.setVisibility(0);
      parama.tCk.setVisibility(8);
      n.a(paramContext, parama.tCh, s.a(s.this), null, 2131690266, parama.tCh.getMeasuredWidth(), parama.tCh.getMeasuredHeight());
      if (parama.iVq.getPaint().measureText(s.b(s.this).toString()) >= s.tCd)
      {
        parama.iVq.setMaxLines(2);
        parama.iCV.setMaxLines(1);
      }
      for (;;)
      {
        parama.iVq.setText(s.b(s.this));
        parama.iCV.setText(s.c(s.this));
        parama.tAA.setText(s.d(s.this));
        break;
        if (parama.iCV.getPaint().measureText(s.c(s.this).toString()) >= s.tCd)
        {
          parama.iVq.setMaxLines(1);
          parama.iCV.setMaxLines(2);
        }
        else
        {
          parama.iVq.setMaxLines(1);
          parama.iCV.setMaxLines(1);
        }
      }
      label443:
      parama.tCi.setVisibility(8);
      AppMethodBeat.o(112125);
    }
    
    public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(112126);
      paramContext = (s)paramVarArgs;
      paramVarArgs = new cur();
      paramVarArgs.iht = paramContext.tBY.iht;
      paramVarArgs.Scene = 25;
      paramVarArgs.HmK = e.ttx;
      paramVarArgs.HmP = e.ttw;
      paramVarArgs.HfW = System.currentTimeMillis();
      paramVarArgs.HmO = paramContext.position;
      paramVarArgs.GOl = ((int)(paramVarArgs.HfW - paramContext.tui));
      paramVarArgs.HmL = paramContext.tBZ;
      paramVarArgs.HmN = 1;
      paramContext = new d(paramVarArgs);
      g.aiU().a(paramContext, 0);
      paramContext = new vm();
      paramContext.dJF.userName = s.this.tBY.nDo;
      paramContext.dJF.dJH = s.this.tBY.ujc;
      paramContext.dJF.scene = 1027;
      paramContext.dJF.dkh = ("$CASSP$B" + e.ttx + ":" + s.this.tBY.HSp + ":3");
      com.tencent.mm.sdk.b.a.IbL.l(paramContext);
      AppMethodBeat.o(112126);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s
 * JD-Core Version:    0.7.0.1
 */