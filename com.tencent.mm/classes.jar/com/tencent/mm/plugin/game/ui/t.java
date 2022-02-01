package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.plugin.game.d.m;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class t
  implements View.OnClickListener, com.tencent.mm.ak.g
{
  private Context mContext;
  private com.tencent.mm.plugin.game.model.c tdF = null;
  int tfA;
  DialogInterface.OnClickListener tuU = null;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42412);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ac.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      AppMethodBeat.o(42412);
      return;
    }
    this.tdF = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ac.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.tdF.field_appId);
    com.tencent.mm.kernel.g.agi().a(1219, this);
    paramView = ab.eUO();
    paramView = new au(this.tdF.field_appId, paramView, this.tdF.daa, this.tdF.tcW);
    com.tencent.mm.kernel.g.agi().a(paramView, 0);
    AppMethodBeat.o(42412);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(42413);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.getType() == 1219))
    {
      com.tencent.mm.kernel.g.agi().b(1219, this);
      paramn = new ag(((au)paramn).fYA.hvs.hvw);
      paramString = new b();
      paramString.tuY = Boolean.valueOf(paramn.tgg.thv);
      paramString.title = paramn.tgg.Title;
      paramString.content = paramn.tgg.thV;
      if (paramn.tgg.tlH != null)
      {
        paramString.tuZ = new a();
        paramString.tuZ.message = paramn.tgg.tlH.thV;
        paramString.tuZ.tuW = paramn.tgg.tlH.thW;
        paramString.tuZ.tuX = paramn.tgg.tlH.thX;
        paramString.tuZ.url = paramn.tgg.tlH.Url;
      }
      this.tdF.iis = paramString.tuY.booleanValue();
      if (bs.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(42413);
        return;
      }
      if (paramString.tuZ != null)
      {
        paramn = paramString.tuZ.url;
        d.a locala = new d.a(this.mContext);
        locala.aRH(paramString.title);
        locala.aRI(paramString.tuZ.message);
        locala.yf(false);
        locala.aRO(paramString.tuZ.tuW).a(true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42411);
            com.tencent.mm.plugin.game.f.c.ay(t.a(t.this), paramn);
            e.a(t.a(t.this), t.b(t.this).scene, t.b(t.this).dtF, t.b(t.this).position, 17, t.b(t.this).field_appId, t.c(t.this), t.b(t.this).daa, t.b(t.this).tdb);
            AppMethodBeat.o(42411);
          }
        });
        locala.aRP(paramString.tuZ.tuX).c(this.tuU);
        locala.fvp().show();
        AppMethodBeat.o(42413);
        return;
      }
      if (bs.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(42413);
        return;
      }
      paramn = new d.a(this.mContext);
      paramn.aRH(paramString.title);
      paramn.aRI(paramString.content);
      paramn.yf(false);
      paramn.acM(2131759989).b(this.tuU);
      paramn.fvp().show();
      AppMethodBeat.o(42413);
      return;
    }
    paramString = new d.a(this.mContext);
    paramString.acJ(2131759990);
    paramString.acM(2131759989);
    paramString.fvp().show();
    AppMethodBeat.o(42413);
  }
  
  public static final class a
  {
    public String message;
    public String tuW;
    public String tuX;
    public String url;
  }
  
  public static final class b
  {
    public String content;
    public String title;
    public Boolean tuY;
    public t.a tuZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */