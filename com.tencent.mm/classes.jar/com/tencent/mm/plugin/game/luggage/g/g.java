package com.tencent.mm.plugin.game.luggage.g;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.api.e;
import com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView;
import com.tencent.mm.plugin.webview.luggage.RedDotView;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;

public final class g
  extends m
{
  private i xxA;
  private com.tencent.mm.plugin.game.luggage.e.a.b xyc;
  private com.tencent.mm.plugin.game.luggage.e.b xyd;
  private com.tencent.mm.plugin.game.luggage.e.a.c xye;
  private DownloadProgressImageView xyf;
  private RedDotView xyg;
  private e xyh;
  
  public g(i parami)
  {
    super(parami);
    AppMethodBeat.i(180138);
    this.xxA = parami;
    if (this.xxA.mParams.getBoolean("from_find_more_friend", false))
    {
      View localView = aa.jQ(getContext()).inflate(2131494795, this.IUk, false);
      this.xyf = ((DownloadProgressImageView)localView.findViewById(2131299779));
      this.xyg = ((RedDotView)localView.findViewById(2131299781));
      this.IUk.addView(localView, 0);
      dTJ();
      this.xyh = new e()
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
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.xyh);
    }
    if (parami.mParams.getInt("share_report_from_scene", -1) >= 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        setBackBtn(2131689499);
      }
      AppMethodBeat.o(180138);
      return;
    }
  }
  
  private void dTJ()
  {
    AppMethodBeat.i(180141);
    if (this.xyg == null)
    {
      AppMethodBeat.o(180141);
      return;
    }
    if (((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).cBT())
    {
      this.xyg.setVisibility(0);
      AppMethodBeat.o(180141);
      return;
    }
    this.xyg.setVisibility(8);
    AppMethodBeat.o(180141);
  }
  
  private com.tencent.mm.plugin.game.luggage.e.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(83129);
    if (this.xyc == null) {
      this.xyc = new com.tencent.mm.plugin.game.luggage.e.a.b(this.xxA.mParams.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.e.a.b localb = this.xyc;
    AppMethodBeat.o(83129);
    return localb;
  }
  
  public final void dTG()
  {
    AppMethodBeat.i(83130);
    if (!(this.xxA instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      this.xxA.hb(bool);
      AppMethodBeat.o(83130);
      return;
    }
  }
  
  public final void dTH()
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
  
  public final void dTI()
  {
    AppMethodBeat.i(83132);
    if (this.xyd != null) {
      this.xyd.gca();
    }
    if (this.xye != null)
    {
      com.tencent.mm.plugin.game.luggage.e.a.c localc = this.xye;
      if (localc.xxC != null) {
        localc.xxC.bMo();
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public final n getMenuHelp()
  {
    AppMethodBeat.i(83128);
    if (this.IUo == null) {
      this.IUo = new com.tencent.mm.plugin.game.luggage.e.a();
    }
    n localn = this.IUo;
    AppMethodBeat.o(83128);
    return localn;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180139);
    super.onDestroy();
    ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.xyh);
    AppMethodBeat.o(180139);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(180140);
    super.onForeground();
    dTJ();
    AppMethodBeat.o(180140);
  }
  
  public final void pK(boolean paramBoolean)
  {
    AppMethodBeat.i(186952);
    super.pK(paramBoolean);
    if (this.xyf != null) {
      this.xyf.setDarkMode(paramBoolean);
    }
    AppMethodBeat.o(186952);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(186953);
    super.setAlpha(paramFloat);
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    if ((f < 0.0F) || (f > 1.0F))
    {
      AppMethodBeat.o(186953);
      return;
    }
    int i = (int)(255.0F * f);
    if (this.xyf != null) {
      this.xyf.setImageAlpha(i);
    }
    AppMethodBeat.o(186953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.g.g
 * JD-Core Version:    0.7.0.1
 */