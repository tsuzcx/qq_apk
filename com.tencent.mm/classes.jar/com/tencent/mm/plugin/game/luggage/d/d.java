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
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;

public final class d
  extends l
{
  private f rPG;
  private com.tencent.mm.plugin.game.luggage.c.a.b rPT;
  private com.tencent.mm.plugin.game.luggage.c.b rPU;
  private com.tencent.mm.plugin.game.luggage.c.a.c rPV;
  private RedDotView rPW;
  private e rPX;
  
  public d(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(180138);
    this.rPG = paramf;
    if (this.rPG.mParams.getBoolean("from_find_more_friend", false))
    {
      paramf = y.js(getContext()).inflate(2131494234, this.ATU, false);
      this.rPW = ((RedDotView)paramf.findViewById(2131299218));
      this.ATU.addView(paramf, 0);
      cBD();
      this.rPX = new e()
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
      ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.rPX);
    }
    AppMethodBeat.o(180138);
  }
  
  private void cBD()
  {
    AppMethodBeat.i(180141);
    if (this.rPW == null)
    {
      AppMethodBeat.o(180141);
      return;
    }
    if (((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).bQO())
    {
      this.rPW.setVisibility(0);
      AppMethodBeat.o(180141);
      return;
    }
    this.rPW.setVisibility(8);
    AppMethodBeat.o(180141);
  }
  
  private com.tencent.mm.plugin.game.luggage.c.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(83129);
    if (this.rPT == null) {
      this.rPT = new com.tencent.mm.plugin.game.luggage.c.a.b(this.rPG.mParams.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.c.a.b localb = this.rPT;
    AppMethodBeat.o(83129);
    return localb;
  }
  
  public final void cBA()
  {
    AppMethodBeat.i(83130);
    if (!(this.rPG instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      this.rPG.fF(bool);
      AppMethodBeat.o(83130);
      return;
    }
  }
  
  public final void cBB()
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
        if (bt.isNullOrNil(d.a(d.this).mParams.getString("game_hv_menu_appid")))
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
      aq.n(local1, l);
      AppMethodBeat.o(83131);
      return;
    }
  }
  
  public final void cBC()
  {
    AppMethodBeat.i(83132);
    if (this.rPU != null) {
      this.rPU.eln();
    }
    if (this.rPV != null)
    {
      com.tencent.mm.plugin.game.luggage.c.a.c localc = this.rPV;
      if (localc.rPI != null) {
        localc.rPI.bfo();
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public final com.tencent.mm.plugin.webview.luggage.b.n getMenuHelp()
  {
    AppMethodBeat.i(83128);
    if (this.ATY == null) {
      this.ATY = new com.tencent.mm.plugin.game.luggage.c.a();
    }
    com.tencent.mm.plugin.webview.luggage.b.n localn = this.ATY;
    AppMethodBeat.o(83128);
    return localn;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180139);
    super.onDestroy();
    ((com.tencent.mm.plugin.downloader_app.api.c)g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.rPX);
    AppMethodBeat.o(180139);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(180140);
    super.onForeground();
    cBD();
    if (this.rPG.mParams.getInt("share_report_from_scene", -1) >= 0) {}
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