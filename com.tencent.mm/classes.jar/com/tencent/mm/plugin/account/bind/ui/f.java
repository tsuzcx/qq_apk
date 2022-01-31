package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.y;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.b.c;

public final class f
  implements com.tencent.mm.ai.f
{
  Context context;
  private View gwd;
  com.tencent.mm.ui.base.p gwe;
  c gwf;
  SecurityImage gwg;
  String gwh;
  private byte[] gwi;
  private String gwj;
  private String gwk;
  private f.a gwl;
  
  public f(Context paramContext, f.a parama)
  {
    this.context = paramContext;
    this.gwd = null;
    this.gwe = null;
    this.gwf = null;
    this.gwh = "";
    this.gwg = null;
    this.gwi = null;
    this.gwj = "";
    this.gwl = parama;
  }
  
  public final void Yj()
  {
    AppMethodBeat.i(13757);
    g.Rc().a(384, this);
    AppMethodBeat.o(13757);
  }
  
  public final void apV()
  {
    AppMethodBeat.i(13759);
    this.gwd = View.inflate(this.context, 2130970675, null);
    Object localObject = (EditText)this.gwd.findViewById(2131827573);
    ((EditText)localObject).setHint(2131297654);
    localObject = new f.1(this, (EditText)localObject);
    f.2 local2 = new f.2(this);
    this.gwf = h.a(this.context, this.context.getString(2131297649), this.gwd, (DialogInterface.OnClickListener)localObject, local2);
    AppMethodBeat.o(13759);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(13758);
    g.Rc().b(384, this);
    if (this.gwl != null) {
      this.gwl.apU();
    }
    AppMethodBeat.o(13758);
  }
  
  @TargetApi(17)
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(13760);
    onDetach();
    if ((paramm == null) || (paramm.getType() != 384))
    {
      AppMethodBeat.o(13760);
      return;
    }
    if (this.gwe != null)
    {
      this.gwe.dismiss();
      this.gwe = null;
    }
    this.gwj = aa.a(((cqd)((ac)paramm).rr.fsW.fta).xgV);
    paramm = (ac)paramm;
    if ((((cqd)paramm.rr.fsW.fta).wrN != null) && (((cqd)paramm.rr.fsW.fta).wrN.getILen() > 0)) {}
    for (paramm = g.RJ().QN().gC(paramm.fQd);; paramm = aa.a(((cqd)paramm.rr.fsW.fta).woT))
    {
      this.gwi = paramm;
      if ((this.gwl == null) || (!this.gwl.cQ(paramInt1, paramInt2))) {
        break;
      }
      AppMethodBeat.o(13760);
      return;
    }
    if ((this.context instanceof Activity))
    {
      paramm = (Activity)this.context;
      if ((paramm.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramm.isDestroyed())))
      {
        AppMethodBeat.o(13760);
        return;
      }
    }
    if (paramInt1 == 4)
    {
      switch (paramInt2)
      {
      default: 
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString != null)
        {
          paramString.a(this.context, null, null);
          AppMethodBeat.o(13760);
          return;
        }
        break;
      case -311: 
      case -310: 
      case -6: 
        if (g.RG())
        {
          if (this.gwg == null)
          {
            this.gwg = SecurityImage.a.a(this.context, 0, this.gwi, this.gwj, this.gwk, new f.5(this), null, new f.6(this), new f.b(this));
            AppMethodBeat.o(13760);
            return;
          }
          this.gwg.b(0, this.gwi, this.gwj, this.gwk);
        }
        AppMethodBeat.o(13760);
        return;
      case -3: 
        paramString = new f.4(this);
        this.gwf = h.a(this.context, this.context.getString(2131297653), this.context.getString(2131297087), paramString, null);
        AppMethodBeat.o(13760);
        return;
      case -72: 
        this.gwf = h.h(this.context, 2131298267, 2131297087);
        AppMethodBeat.o(13760);
        return;
      case -34: 
        this.gwf = h.b(this.context, this.context.getString(2131297646), this.context.getString(2131297087), true);
        AppMethodBeat.o(13760);
        return;
      }
      AppMethodBeat.o(13760);
      return;
    }
    paramString = com.tencent.mm.h.a.kO(paramString);
    if (paramString != null)
    {
      paramString.a(this.context, null, null);
      AppMethodBeat.o(13760);
      return;
    }
    AppMethodBeat.o(13760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f
 * JD-Core Version:    0.7.0.1
 */