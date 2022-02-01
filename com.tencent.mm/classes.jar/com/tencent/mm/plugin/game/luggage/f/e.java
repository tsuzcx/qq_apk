package com.tencent.mm.plugin.game.luggage.f;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView;
import com.tencent.mm.plugin.webview.luggage.RedDotView;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;

public final class e
  extends m
{
  private com.tencent.mm.plugin.game.luggage.d.a.b ufQ;
  private com.tencent.mm.plugin.game.luggage.d.b ufR;
  private com.tencent.mm.plugin.game.luggage.d.a.c ufS;
  private DownloadProgressImageView ufT;
  private RedDotView ufU;
  private com.tencent.mm.plugin.downloader_app.api.e ufV;
  private g ufp;
  
  public e(g paramg)
  {
    super(paramg);
    AppMethodBeat.i(180138);
    this.ufp = paramg;
    if (this.ufp.mParams.getBoolean("from_find_more_friend", false))
    {
      View localView = z.jV(getContext()).inflate(2131494234, this.Ehy, false);
      this.ufT = ((DownloadProgressImageView)localView.findViewById(2131308482));
      this.ufU = ((RedDotView)localView.findViewById(2131299218));
      this.Ehy.addView(localView, 0);
      dab();
      this.ufV = new com.tencent.mm.plugin.downloader_app.api.e()
      {
        public final void onChange(final boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(180137);
          e.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(180136);
              if (paramAnonymousBoolean)
              {
                e.c(e.this).setVisibility(0);
                AppMethodBeat.o(180136);
                return;
              }
              e.c(e.this).setVisibility(8);
              AppMethodBeat.o(180136);
            }
          });
          AppMethodBeat.o(180137);
        }
      };
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.ufV);
    }
    if (paramg.mParams.getInt("share_report_from_scene", -1) >= 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        setBackBtn(2131689497);
      }
      AppMethodBeat.o(180138);
      return;
    }
  }
  
  private void dab()
  {
    AppMethodBeat.i(180141);
    if (this.ufU == null)
    {
      AppMethodBeat.o(180141);
      return;
    }
    if (((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).cdX())
    {
      this.ufU.setVisibility(0);
      AppMethodBeat.o(180141);
      return;
    }
    this.ufU.setVisibility(8);
    AppMethodBeat.o(180141);
  }
  
  private com.tencent.mm.plugin.game.luggage.d.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(83129);
    if (this.ufQ == null) {
      this.ufQ = new com.tencent.mm.plugin.game.luggage.d.a.b(this.ufp.mParams.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.d.a.b localb = this.ufQ;
    AppMethodBeat.o(83129);
    return localb;
  }
  
  public final void cZY()
  {
    AppMethodBeat.i(83130);
    if (!(this.ufp instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      this.ufp.ge(bool);
      AppMethodBeat.o(83130);
      return;
    }
  }
  
  public final void cZZ()
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
        if (bu.isNullOrNil(e.a(e.this).mParams.getString("game_hv_menu_appid")))
        {
          e.a(e.this, new com.tencent.mm.plugin.game.luggage.d.b(e.a(e.this), e.this.getMenuHelp()));
          AppMethodBeat.o(83127);
          return;
        }
        e.a(e.this, new com.tencent.mm.plugin.game.luggage.d.a.c(e.a(e.this), e.b(e.this)));
        AppMethodBeat.o(83127);
      }
    };
    if (bool) {}
    for (long l = 100L;; l = 0L)
    {
      ar.o(local1, l);
      AppMethodBeat.o(83131);
      return;
    }
  }
  
  public final void daa()
  {
    AppMethodBeat.i(83132);
    if (this.ufR != null) {
      this.ufR.eTn();
    }
    if (this.ufS != null)
    {
      com.tencent.mm.plugin.game.luggage.d.a.c localc = this.ufS;
      if (localc.ufr != null) {
        localc.ufr.bqD();
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public final n getMenuHelp()
  {
    AppMethodBeat.i(83128);
    if (this.EhC == null) {
      this.EhC = new com.tencent.mm.plugin.game.luggage.d.a();
    }
    n localn = this.EhC;
    AppMethodBeat.o(83128);
    return localn;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180139);
    super.onDestroy();
    ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.ufV);
    AppMethodBeat.o(180139);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(180140);
    super.onForeground();
    dab();
    AppMethodBeat.o(180140);
  }
  
  public final void setActionBarColor(int paramInt)
  {
    AppMethodBeat.i(193066);
    super.setActionBarColor(paramInt);
    int i = paramInt;
    if (paramInt == 0) {
      i = getResources().getColor(2131101179);
    }
    if (this.ufT != null) {
      this.ufT.setBgColor(i);
    }
    AppMethodBeat.o(193066);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(193067);
    super.setAlpha(paramFloat);
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    if ((f < 0.0F) || (f > 1.0F))
    {
      AppMethodBeat.o(193067);
      return;
    }
    int i = (int)(255.0F * f);
    if (this.ufT != null) {
      this.ufT.setImageAlpha(i);
    }
    AppMethodBeat.o(193067);
  }
  
  public final void setImmersiveStyle(boolean paramBoolean)
  {
    AppMethodBeat.i(193065);
    super.setImmersiveStyle(paramBoolean);
    if (this.ufT != null) {
      this.ufT.setDarkMode(paramBoolean);
    }
    AppMethodBeat.o(193065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.e
 * JD-Core Version:    0.7.0.1
 */