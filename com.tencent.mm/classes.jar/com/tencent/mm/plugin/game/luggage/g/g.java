package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader_app.api.e;
import com.tencent.mm.plugin.game.luggage.j.c;
import com.tencent.mm.plugin.game.luggage.j.d;
import com.tencent.mm.plugin.game.luggage.j.e;
import com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView;
import com.tencent.mm.plugin.webview.luggage.RedDotView;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;

public final class g
  extends m
{
  private i CBJ;
  private com.tencent.mm.plugin.game.luggage.e.a.b CCm;
  private com.tencent.mm.plugin.game.luggage.e.b CCn;
  private com.tencent.mm.plugin.game.luggage.e.a.c CCo;
  private DownloadProgressImageView CCp;
  private RedDotView CCq;
  private e CCr;
  
  public g(i parami)
  {
    super(parami);
    AppMethodBeat.i(180138);
    this.CBJ = parami;
    if (this.CBJ.mParams.getBoolean("from_find_more_friend", false))
    {
      View localView = ad.kS(getContext()).inflate(j.d.CAB, this.PQC, false);
      this.CCp = ((DownloadProgressImageView)localView.findViewById(j.c.CAv));
      this.CCq = ((RedDotView)localView.findViewById(j.c.CAw));
      this.PQC.addView(localView, 0);
      ewR();
      this.CCr = new e()
      {
        public final void onChange(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(180137);
          g.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180136);
              if (paramAnonymousBoolean)
              {
                g.c(g.this).setVisibility(0);
                AppMethodBeat.o(180136);
                return;
              }
              g.c(g.this).setVisibility(8);
              AppMethodBeat.o(180136);
            }
          });
          AppMethodBeat.o(180137);
        }
      };
      ((com.tencent.mm.plugin.downloader_app.api.c)h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.CCr);
    }
    if (parami.mParams.getInt("share_report_from_scene", -1) >= 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        setBackBtn(j.e.actionbar_icon_light_back);
      }
      AppMethodBeat.o(180138);
      return;
    }
  }
  
  private void ewR()
  {
    AppMethodBeat.i(180141);
    if (this.CCq == null)
    {
      AppMethodBeat.o(180141);
      return;
    }
    if (((com.tencent.mm.plugin.downloader_app.api.c)h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).cQx())
    {
      this.CCq.setVisibility(0);
      AppMethodBeat.o(180141);
      return;
    }
    this.CCq.setVisibility(8);
    AppMethodBeat.o(180141);
  }
  
  private com.tencent.mm.plugin.game.luggage.e.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(83129);
    if (this.CCm == null) {
      this.CCm = new com.tencent.mm.plugin.game.luggage.e.a.b(this.CBJ.mParams.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.e.a.b localb = this.CCm;
    AppMethodBeat.o(83129);
    return localb;
  }
  
  public final void bXF()
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
        if (Util.isNullOrNil(g.a(g.this).mParams.getString("game_hv_menu_appid")))
        {
          g.a(g.this, new com.tencent.mm.plugin.game.luggage.e.b(g.a(g.this), g.this.getMenuHelp()));
          AppMethodBeat.o(83127);
          return;
        }
        g.a(g.this, new com.tencent.mm.plugin.game.luggage.e.a.c(g.a(g.this), g.b(g.this)));
        AppMethodBeat.o(83127);
      }
    };
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      MMHandlerThread.postToMainThreadDelayed(local1, l);
      AppMethodBeat.o(83131);
      return;
    }
  }
  
  public final void ewP()
  {
    AppMethodBeat.i(83130);
    if (!(this.CBJ instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      this.CBJ.hS(bool);
      AppMethodBeat.o(83130);
      return;
    }
  }
  
  public final void ewQ()
  {
    AppMethodBeat.i(83132);
    if (this.CCn != null) {
      this.CCn.gUW();
    }
    if (this.CCo != null)
    {
      com.tencent.mm.plugin.game.luggage.e.a.c localc = this.CCo;
      if (localc.CBL != null) {
        localc.CBL.bYF();
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public final n getMenuHelp()
  {
    AppMethodBeat.i(83128);
    if (this.PQF == null) {
      this.PQF = new com.tencent.mm.plugin.game.luggage.e.a();
    }
    n localn = this.PQF;
    AppMethodBeat.o(83128);
    return localn;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180139);
    super.onDestroy();
    ((com.tencent.mm.plugin.downloader_app.api.c)h.ae(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.CCr);
    AppMethodBeat.o(180139);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(180140);
    super.onForeground();
    ewR();
    AppMethodBeat.o(180140);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(231151);
    super.setAlpha(paramFloat);
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    if ((f < 0.0F) || (f > 1.0F))
    {
      AppMethodBeat.o(231151);
      return;
    }
    int i = (int)(255.0F * f);
    if (this.CCp != null) {
      this.CCp.setImageAlpha(i);
    }
    AppMethodBeat.o(231151);
  }
  
  public final void sh(boolean paramBoolean)
  {
    AppMethodBeat.i(231149);
    super.sh(paramBoolean);
    if (this.CCp != null) {
      this.CCp.setDarkMode(paramBoolean);
    }
    AppMethodBeat.o(231149);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.g
 * JD-Core Version:    0.7.0.1
 */