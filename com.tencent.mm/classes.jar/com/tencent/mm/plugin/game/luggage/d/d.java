package com.tencent.mm.plugin.game.luggage.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.api.e;
import com.tencent.mm.plugin.webview.luggage.RedDotView;
import com.tencent.mm.plugin.webview.luggage.l;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;

public final class d
  extends l
{
  private com.tencent.mm.plugin.game.luggage.c.a.b sXK;
  private com.tencent.mm.plugin.game.luggage.c.b sXL;
  private com.tencent.mm.plugin.game.luggage.c.a.c sXM;
  private RedDotView sXN;
  private e sXO;
  private f sXx;
  
  public d(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(180138);
    this.sXx = paramf;
    if (this.sXx.mParams.getBoolean("from_find_more_friend", false))
    {
      paramf = z.jD(getContext()).inflate(2131494234, this.Cmh, false);
      this.sXN = ((RedDotView)paramf.findViewById(2131299218));
      this.Cmh.addView(paramf, 0);
      cOO();
      this.sXO = new e()
      {
        public final void onChange(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(180137);
          d.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180136);
              if (paramAnonymousBoolean)
              {
                d.c(d.this).setVisibility(0);
                AppMethodBeat.o(180136);
                return;
              }
              d.c(d.this).setVisibility(8);
              AppMethodBeat.o(180136);
            }
          });
          AppMethodBeat.o(180137);
        }
      };
      ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.sXO);
    }
    AppMethodBeat.o(180138);
  }
  
  private void cOO()
  {
    AppMethodBeat.i(180141);
    if (this.sXN == null)
    {
      AppMethodBeat.o(180141);
      return;
    }
    if (((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).bYe())
    {
      this.sXN.setVisibility(0);
      AppMethodBeat.o(180141);
      return;
    }
    this.sXN.setVisibility(8);
    AppMethodBeat.o(180141);
  }
  
  private com.tencent.mm.plugin.game.luggage.c.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(83129);
    if (this.sXK == null) {
      this.sXK = new com.tencent.mm.plugin.game.luggage.c.a.b(this.sXx.mParams.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.c.a.b localb = this.sXK;
    AppMethodBeat.o(83129);
    return localb;
  }
  
  public final void cOL()
  {
    AppMethodBeat.i(83130);
    if (!(this.sXx instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      this.sXx.gb(bool);
      AppMethodBeat.o(83130);
      return;
    }
  }
  
  public final void cOM()
  {
    AppMethodBeat.i(83131);
    boolean bool = false;
    if ((getContext() instanceof MMActivity)) {
      bool = ((MMActivity)getContext()).hideVKBHavingResult();
    }
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(83127);
        if (bs.isNullOrNil(d.a(d.this).mParams.getString("game_hv_menu_appid")))
        {
          d.a(d.this, new com.tencent.mm.plugin.game.luggage.c.b(d.a(d.this), d.this.getMenuHelp()));
          AppMethodBeat.o(83127);
          return;
        }
        d.a(d.this, new com.tencent.mm.plugin.game.luggage.c.a.c(d.a(d.this), d.b(d.this)));
        AppMethodBeat.o(83127);
      }
    };
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      ap.n(local1, l);
      AppMethodBeat.o(83131);
      return;
    }
  }
  
  public final void cON()
  {
    AppMethodBeat.i(83132);
    if (this.sXL != null) {
      this.sXL.eAJ();
    }
    if (this.sXM != null)
    {
      com.tencent.mm.plugin.game.luggage.c.a.c localc = this.sXM;
      if (localc.sXz != null) {
        localc.sXz.bmi();
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public final com.tencent.mm.plugin.webview.luggage.b.n getMenuHelp()
  {
    AppMethodBeat.i(83128);
    if (this.Cml == null) {
      this.Cml = new com.tencent.mm.plugin.game.luggage.c.a();
    }
    com.tencent.mm.plugin.webview.luggage.b.n localn = this.Cml;
    AppMethodBeat.o(83128);
    return localn;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180139);
    super.onDestroy();
    ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.sXO);
    AppMethodBeat.o(180139);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(180140);
    super.onForeground();
    cOO();
    if (this.sXx.mParams.getInt("share_report_from_scene", -1) >= 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        setBackBtn(2131689497);
      }
      AppMethodBeat.o(180140);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.d
 * JD-Core Version:    0.7.0.1
 */