package com.tencent.mm.plugin.game.luggage.f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.RedDotView;
import com.tencent.mm.plugin.webview.luggage.b.n;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;

public final class e
  extends m
{
  private com.tencent.mm.plugin.game.luggage.d.a.b tUV;
  private com.tencent.mm.plugin.game.luggage.d.b tUW;
  private com.tencent.mm.plugin.game.luggage.d.a.c tUX;
  private RedDotView tUY;
  private com.tencent.mm.plugin.downloader_app.api.e tUZ;
  private g tUx;
  
  public e(g paramg)
  {
    super(paramg);
    AppMethodBeat.i(180138);
    this.tUx = paramg;
    if (this.tUx.mParams.getBoolean("from_find_more_friend", false))
    {
      View localView = z.jO(getContext()).inflate(2131494234, this.DPy, false);
      this.tUY = ((RedDotView)localView.findViewById(2131299218));
      this.DPy.addView(localView, 0);
      cXr();
      this.tUZ = new com.tencent.mm.plugin.downloader_app.api.e()
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
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).a(this.tUZ);
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
  
  private void cXr()
  {
    AppMethodBeat.i(180141);
    if (this.tUY == null)
    {
      AppMethodBeat.o(180141);
      return;
    }
    if (((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).ccI())
    {
      this.tUY.setVisibility(0);
      AppMethodBeat.o(180141);
      return;
    }
    this.tUY.setVisibility(8);
    AppMethodBeat.o(180141);
  }
  
  private com.tencent.mm.plugin.game.luggage.d.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(83129);
    if (this.tUV == null) {
      this.tUV = new com.tencent.mm.plugin.game.luggage.d.a.b(this.tUx.mParams.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.d.a.b localb = this.tUV;
    AppMethodBeat.o(83129);
    return localb;
  }
  
  public final void cXo()
  {
    AppMethodBeat.i(83130);
    if (!(this.tUx instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      this.tUx.gg(bool);
      AppMethodBeat.o(83130);
      return;
    }
  }
  
  public final void cXp()
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
        if (bt.isNullOrNil(e.a(e.this).mParams.getString("game_hv_menu_appid")))
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
      aq.o(local1, l);
      AppMethodBeat.o(83131);
      return;
    }
  }
  
  public final void cXq()
  {
    AppMethodBeat.i(83132);
    if (this.tUW != null) {
      this.tUW.ePB();
    }
    if (this.tUX != null)
    {
      com.tencent.mm.plugin.game.luggage.d.a.c localc = this.tUX;
      if (localc.tUz != null) {
        localc.tUz.bpT();
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public final n getMenuHelp()
  {
    AppMethodBeat.i(83128);
    if (this.DPC == null) {
      this.DPC = new com.tencent.mm.plugin.game.luggage.d.a();
    }
    n localn = this.DPC;
    AppMethodBeat.o(83128);
    return localn;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180139);
    super.onDestroy();
    ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.tUZ);
    AppMethodBeat.o(180139);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(180140);
    super.onForeground();
    cXr();
    AppMethodBeat.o(180140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.f.e
 * JD-Core Version:    0.7.0.1
 */