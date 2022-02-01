package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.protocal.protobuf.doe;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.json.JSONObject;

public final class s
  extends com.tencent.mm.plugin.fts.a.d.a.a
{
  private static int xdU;
  public String contentType;
  private CharSequence jVL;
  public boolean kVq;
  private String thumbUrl;
  public long wVY;
  public fei xdP;
  public String xdQ;
  public boolean xdR;
  private CharSequence xdS;
  private CharSequence xdT;
  private b xdV;
  a xdW;
  
  static
  {
    AppMethodBeat.i(112129);
    xdU = com.tencent.mm.cb.a.jn(MMApplicationContext.getContext()) - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 116);
    AppMethodBeat.o(112129);
  }
  
  public s(int paramInt)
  {
    super(14, paramInt);
    AppMethodBeat.i(112127);
    this.xdV = new b();
    this.xdW = new a();
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
      paramContext = new JSONObject(this.xdP.NzC);
      parama = paramContext.optString("title", "");
      this.thumbUrl = paramContext.optString("image", "");
      this.xdQ = paramContext.optString("search_buffer", "");
      this.xdS = f.ayv(parama);
      this.contentType = paramContext.optString("content_type", "");
      if (paramContext.optInt("security_icon", 0) != 1) {
        break label266;
      }
      bool = true;
      this.kVq = bool;
      if (paramContext.optInt("brand_official_label", 0) == 0) {
        break label272;
      }
      bool = true;
      label113:
      this.xdR = bool;
    }
    catch (Exception paramContext)
    {
      boolean bool;
      label119:
      break label119;
    }
    if ("HOME".equals(this.contentType)) {
      gE(2, 0);
    }
    for (;;)
    {
      this.xdT = f.ayv(this.xdP.KHk);
      this.jVL = this.xdP.oUJ;
      this.wVY = System.currentTimeMillis();
      paramContext = new doe();
      paramContext.jfi = this.xdP.jfi;
      paramContext.Scene = 25;
      paramContext.MRu = com.tencent.mm.plugin.fts.a.e.wVn;
      paramContext.MRz = com.tencent.mm.plugin.fts.a.e.wVm;
      paramContext.MKf = this.wVY;
      paramContext.MRy = this.position;
      paramContext.Mnc = 0;
      paramContext.MRv = this.xdQ;
      paramContext.MRw = 1;
      paramContext = new com.tencent.mm.plugin.fts.ui.c.e(paramContext);
      g.azz().a(paramContext, 0);
      AppMethodBeat.o(112128);
      return;
      bool = false;
      break;
      bool = false;
      break label113;
      gE(1, 0);
    }
  }
  
  public final a.b axc()
  {
    return this.xdV;
  }
  
  public final String getAppId()
  {
    return this.xdP.UserName;
  }
  
  public final class a
    extends a.a
  {
    public ImageView gvv;
    public TextView gvw;
    public TextView jBR;
    public TextView jVO;
    public ImageView lrd;
    public TextView xcs;
    public View xdX;
    public ImageView xdY;
    public ImageView xdZ;
    public ImageView xea;
    public View xeb;
    public TextView xec;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494778, paramViewGroup, false);
      paramViewGroup = (s.a)s.this.xdW;
      paramViewGroup.xdX = paramContext.findViewById(2131297053);
      paramViewGroup.xdY = ((ImageView)paramContext.findViewById(2131309073));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
      paramViewGroup.xcs = ((TextView)paramContext.findViewById(2131309163));
      paramViewGroup.xdZ = ((ImageView)paramContext.findViewById(2131309776));
      paramViewGroup.xeb = paramContext.findViewById(2131299110);
      paramViewGroup.gvw = ((TextView)paramContext.findViewById(2131305440));
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.xec = ((TextView)paramContext.findViewById(2131299030));
      paramViewGroup.lrd = ((ImageView)paramContext.findViewById(2131309387));
      paramViewGroup.xea = ((ImageView)paramContext.findViewById(2131305577));
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
        parama.xdX.setVisibility(8);
        parama.xeb.setVisibility(0);
        n.a(paramContext, parama.gvv, s.a(s.this), null, 2131690362, parama.xdY.getMeasuredWidth(), parama.xdY.getMeasuredHeight());
        parama.gvw.setText(s.b(s.this));
        parama.xec.setText(s.c(s.this));
        paramContext = parama.lrd;
        if ((s.this.kVq) && (((b)g.af(b.class)).a(b.a.skj, 0) == 1))
        {
          i = 0;
          paramContext.setVisibility(i);
          paramContext = parama.xea;
          if ((!s.this.xdR) || (((b)g.af(b.class)).a(b.a.smL, 0) != 1)) {
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
          parama.xdZ.setVisibility(0);
          AppMethodBeat.o(112125);
          return;
          i = 8;
          break;
        }
      }
      parama.xdX.setVisibility(0);
      parama.xeb.setVisibility(8);
      n.a(paramContext, parama.xdY, s.a(s.this), null, 2131690362, parama.xdY.getMeasuredWidth(), parama.xdY.getMeasuredHeight());
      if (parama.jVO.getPaint().measureText(s.b(s.this).toString()) >= s.xdU)
      {
        parama.jVO.setMaxLines(2);
        parama.jBR.setMaxLines(1);
      }
      for (;;)
      {
        parama.jVO.setText(s.b(s.this));
        parama.jBR.setText(s.c(s.this));
        parama.xcs.setText(s.d(s.this));
        break;
        if (parama.jBR.getPaint().measureText(s.c(s.this).toString()) >= s.xdU)
        {
          parama.jVO.setMaxLines(1);
          parama.jBR.setMaxLines(2);
        }
        else
        {
          parama.jVO.setMaxLines(1);
          parama.jBR.setMaxLines(1);
        }
      }
      label443:
      parama.xdZ.setVisibility(8);
      AppMethodBeat.o(112125);
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
    {
      AppMethodBeat.i(235407);
      paramContext = (s)paramVarArgs;
      paramView = new doe();
      paramView.jfi = paramContext.xdP.jfi;
      paramView.Scene = 25;
      paramView.MRu = com.tencent.mm.plugin.fts.a.e.wVn;
      paramView.MRz = com.tencent.mm.plugin.fts.a.e.wVm;
      paramView.MKf = System.currentTimeMillis();
      paramView.MRy = paramContext.position;
      paramView.Mnc = ((int)(paramView.MKf - paramContext.wVY));
      paramView.MRv = paramContext.xdQ;
      paramView.MRx = 1;
      paramContext = new com.tencent.mm.plugin.fts.ui.c.e(paramView);
      g.azz().a(paramContext, 0);
      paramContext = new wq();
      paramContext.ecI.userName = s.this.xdP.UserName;
      paramContext.ecI.ecK = s.this.xdP.xut;
      paramContext.ecI.scene = 1027;
      paramContext.ecI.dCw = ("$CASSP$B" + com.tencent.mm.plugin.fts.a.e.wVn + ":" + s.this.xdP.MUT + ":3");
      EventCenter.instance.publish(paramContext);
      AppMethodBeat.o(235407);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.s
 * JD-Core Version:    0.7.0.1
 */