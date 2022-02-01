package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.d.dg;
import com.tencent.mm.plugin.game.d.m;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.au;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;

public final class t
  implements View.OnClickListener, com.tencent.mm.al.g
{
  private Context mContext;
  private com.tencent.mm.plugin.game.model.c rVN = null;
  int rXI;
  DialogInterface.OnClickListener snb = null;
  
  public t(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42412);
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.c))
    {
      ad.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
      AppMethodBeat.o(42412);
      return;
    }
    this.rVN = ((com.tencent.mm.plugin.game.model.c)paramView.getTag());
    ad.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.rVN.field_appId);
    com.tencent.mm.kernel.g.aeS().a(1219, this);
    paramView = ac.eFu();
    paramView = new au(this.rVN.field_appId, paramView, this.rVN.dcC, this.rVN.rVe);
    com.tencent.mm.kernel.g.aeS().a(paramView, 0);
    AppMethodBeat.o(42412);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    AppMethodBeat.i(42413);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.getType() == 1219))
    {
      com.tencent.mm.kernel.g.aeS().b(1219, this);
      paramn = new ag(((au)paramn).fUF.gUT.gUX);
      paramString = new b();
      paramString.snf = Boolean.valueOf(paramn.rYo.rZC);
      paramString.title = paramn.rYo.Title;
      paramString.content = paramn.rYo.sac;
      if (paramn.rYo.sdN != null)
      {
        paramString.sng = new a();
        paramString.sng.message = paramn.rYo.sdN.sac;
        paramString.sng.snd = paramn.rYo.sdN.sad;
        paramString.sng.sne = paramn.rYo.sdN.sae;
        paramString.sng.url = paramn.rYo.sdN.Url;
      }
      this.rVN.hHQ = paramString.snf.booleanValue();
      if (bt.isNullOrNil(paramString.title))
      {
        AppMethodBeat.o(42413);
        return;
      }
      if (paramString.sng != null)
      {
        paramn = paramString.sng.url;
        d.a locala = new d.a(this.mContext);
        locala.aMf(paramString.title);
        locala.aMg(paramString.sng.message);
        locala.wX(false);
        locala.aMm(paramString.sng.snd).a(true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(42411);
            com.tencent.mm.plugin.game.f.c.ax(t.a(t.this), paramn);
            e.a(t.a(t.this), t.b(t.this).scene, t.b(t.this).dvS, t.b(t.this).position, 17, t.b(t.this).field_appId, t.c(t.this), t.b(t.this).dcC, t.b(t.this).rVj);
            AppMethodBeat.o(42411);
          }
        });
        locala.aMn(paramString.sng.sne).c(this.snb);
        locala.fft().show();
        AppMethodBeat.o(42413);
        return;
      }
      if (bt.isNullOrNil(paramString.content))
      {
        AppMethodBeat.o(42413);
        return;
      }
      paramn = new d.a(this.mContext);
      paramn.aMf(paramString.title);
      paramn.aMg(paramString.content);
      paramn.wX(false);
      paramn.aaB(2131759989).b(this.snb);
      paramn.fft().show();
      AppMethodBeat.o(42413);
      return;
    }
    paramString = new d.a(this.mContext);
    paramString.aay(2131759990);
    paramString.aaB(2131759989);
    paramString.fft().show();
    AppMethodBeat.o(42413);
  }
  
  public static final class a
  {
    public String message;
    public String snd;
    public String sne;
    public String url;
  }
  
  public static final class b
  {
    public String content;
    public Boolean snf;
    public t.a sng;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.t
 * JD-Core Version:    0.7.0.1
 */