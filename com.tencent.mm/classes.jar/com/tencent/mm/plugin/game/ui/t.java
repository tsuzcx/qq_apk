package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.df;
import com.tencent.mm.plugin.game.d.k;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.av;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c.a;

public final class t
  implements View.OnClickListener, f
{
  private Context mContext;
  DialogInterface.OnClickListener nDC = null;
  private com.tencent.mm.plugin.game.model.c nmJ = null;
  int nok;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112214);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ab.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      AppMethodBeat.o(112214);
      return;
    }
    this.nmJ = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ab.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.nmJ.field_appId);
    g.Rc().a(1219, this);
    paramView = aa.dsG();
    paramView = new av(this.nmJ.field_appId, paramView, this.nmJ.cnG, this.nmJ.nmg);
    g.Rc().a(paramView, 0);
    AppMethodBeat.o(112214);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(112215);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm.getType() == 1219))
    {
      g.Rc().b(1219, this);
      paramm = new ag(((av)paramm).lFp.fsW.fta);
      paramString = new t.b();
      paramString.nDG = Boolean.valueOf(paramm.noT.nqg);
      paramString.title = paramm.noT.Title;
      paramString.content = paramm.noT.nqz;
      if (paramm.noT.nuj != null)
      {
        paramString.nDH = new t.a();
        paramString.nDH.message = paramm.noT.nuj.nqz;
        paramString.nDH.nDE = paramm.noT.nuj.nqA;
        paramString.nDH.nDF = paramm.noT.nuj.nqB;
        paramString.nDH.url = paramm.noT.nuj.Url;
      }
      this.nmJ.nlY = paramString.nDG.booleanValue();
      if (bo.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(112215);
        return;
      }
      if (paramString.nDH != null)
      {
        paramm = paramString.nDH.url;
        c.a locala = new c.a(this.mContext);
        locala.avm(paramString.title);
        locala.avn(paramString.nDH.message);
        locala.rG(false);
        locala.avs(paramString.nDH.nDE).a(true, new t.1(this, paramm));
        locala.avt(paramString.nDH.nDF).b(this.nDC);
        locala.aLZ().show();
        AppMethodBeat.o(112215);
        return;
      }
      if (bo.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(112215);
        return;
      }
      paramm = new c.a(this.mContext);
      paramm.avm(paramString.title);
      paramm.avn(paramString.content);
      paramm.rG(false);
      paramm.Ri(2131300463).a(this.nDC);
      paramm.aLZ().show();
      AppMethodBeat.o(112215);
      return;
    }
    paramString = new c.a(this.mContext);
    paramString.Rf(2131300464);
    paramString.Ri(2131300463);
    paramString.aLZ().show();
    AppMethodBeat.o(112215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */