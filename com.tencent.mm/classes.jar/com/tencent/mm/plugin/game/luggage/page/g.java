package com.tencent.mm.plugin.game.luggage.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.downloader_app.api.e;
import com.tencent.mm.plugin.game.luggage.j.c;
import com.tencent.mm.plugin.game.luggage.j.d;
import com.tencent.mm.plugin.game.luggage.j.e;
import com.tencent.mm.plugin.webview.c.e;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView;
import com.tencent.mm.plugin.webview.luggage.RedDotView;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class g
  extends com.tencent.mm.plugin.webview.luggage.n
{
  private GameWebPage Ivz;
  private com.tencent.mm.plugin.game.luggage.e.a.b Iwb;
  private com.tencent.mm.plugin.game.luggage.e.b Iwc;
  private com.tencent.mm.plugin.game.luggage.e.a.c Iwd;
  private View Iwe;
  private DownloadProgressImageView Iwf;
  private RedDotView Iwg;
  private e Iwh;
  private View Iwi;
  private View Iwj;
  private TextView Iwk;
  String Iwl;
  String Iwm;
  int Iwn;
  String Iwo;
  String Iwp;
  
  public g(GameWebPage paramGameWebPage)
  {
    super(paramGameWebPage);
    AppMethodBeat.i(180138);
    this.Ivz = paramGameWebPage;
    if (this.Ivz.ejT.getBoolean("from_find_more_friend", false)) {
      fEJ();
    }
    if (paramGameWebPage.ejT.getInt("share_report_from_scene", -1) >= 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        setBackBtn(j.e.actionbar_icon_light_back);
      }
      this.Iwi = af.mU(getContext()).inflate(j.d.Iuo, this.WGW, false);
      this.Iwj = this.Iwi.findViewById(j.c.webview_top_bar_bg_view);
      this.Iwk = ((TextView)this.Iwi.findViewById(j.c.nickname_tv));
      AppMethodBeat.o(180138);
      return;
    }
  }
  
  /* Error */
  private void fEJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 199
    //   4: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 201	com/tencent/mm/plugin/game/luggage/page/g:Iwe	Landroid/view/View;
    //   11: ifnull +11 -> 22
    //   14: ldc 199
    //   16: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: aload_0
    //   24: invokevirtual 96	com/tencent/mm/plugin/game/luggage/page/g:getContext	()Landroid/content/Context;
    //   27: invokestatic 102	com/tencent/mm/ui/af:mU	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   30: getstatic 204	com/tencent/mm/plugin/game/luggage/j$d:Ium	I
    //   33: aload_0
    //   34: getfield 208	com/tencent/mm/plugin/game/luggage/page/g:WGZ	Landroid/widget/LinearLayout;
    //   37: iconst_0
    //   38: invokevirtual 117	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;Z)Landroid/view/View;
    //   41: putfield 201	com/tencent/mm/plugin/game/luggage/page/g:Iwe	Landroid/view/View;
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 201	com/tencent/mm/plugin/game/luggage/page/g:Iwe	Landroid/view/View;
    //   49: getstatic 211	com/tencent/mm/plugin/game/luggage/j$c:Iug	I
    //   52: invokevirtual 130	android/view/View:findViewById	(I)Landroid/view/View;
    //   55: checkcast 213	com/tencent/mm/plugin/webview/luggage/DownloadProgressImageView
    //   58: putfield 215	com/tencent/mm/plugin/game/luggage/page/g:Iwf	Lcom/tencent/mm/plugin/webview/luggage/DownloadProgressImageView;
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 201	com/tencent/mm/plugin/game/luggage/page/g:Iwe	Landroid/view/View;
    //   66: getstatic 218	com/tencent/mm/plugin/game/luggage/j$c:Iuh	I
    //   69: invokevirtual 130	android/view/View:findViewById	(I)Landroid/view/View;
    //   72: checkcast 220	com/tencent/mm/plugin/webview/luggage/RedDotView
    //   75: putfield 186	com/tencent/mm/plugin/game/luggage/page/g:Iwg	Lcom/tencent/mm/plugin/webview/luggage/RedDotView;
    //   78: aload_0
    //   79: getfield 208	com/tencent/mm/plugin/game/luggage/page/g:WGZ	Landroid/widget/LinearLayout;
    //   82: aload_0
    //   83: getfield 201	com/tencent/mm/plugin/game/luggage/page/g:Iwe	Landroid/view/View;
    //   86: iconst_0
    //   87: invokevirtual 226	android/widget/LinearLayout:addView	(Landroid/view/View;I)V
    //   90: aload_0
    //   91: invokespecial 229	com/tencent/mm/plugin/game/luggage/page/g:fEL	()V
    //   94: aload_0
    //   95: new 8	com/tencent/mm/plugin/game/luggage/page/g$2
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 231	com/tencent/mm/plugin/game/luggage/page/g$2:<init>	(Lcom/tencent/mm/plugin/game/luggage/page/g;)V
    //   103: putfield 233	com/tencent/mm/plugin/game/luggage/page/g:Iwh	Lcom/tencent/mm/plugin/downloader_app/api/e;
    //   106: ldc 235
    //   108: invokestatic 172	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   111: checkcast 235	com/tencent/mm/plugin/downloader_app/api/c
    //   114: aload_0
    //   115: getfield 233	com/tencent/mm/plugin/game/luggage/page/g:Iwh	Lcom/tencent/mm/plugin/downloader_app/api/e;
    //   118: invokeinterface 238 2 0
    //   123: ldc 199
    //   125: invokestatic 142	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: goto -109 -> 19
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	g
    //   131	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	131	finally
    //   22	128	131	finally
  }
  
  private void fEK()
  {
    try
    {
      AppMethodBeat.i(277052);
      if ((this.Iwe != null) && (this.Iwe.getParent() != null)) {
        this.WGZ.removeView(this.Iwe);
      }
      this.Iwe = null;
      ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.Iwh);
      AppMethodBeat.o(277052);
      return;
    }
    finally {}
  }
  
  private void fEL()
  {
    AppMethodBeat.i(180141);
    if (this.Iwg == null)
    {
      AppMethodBeat.o(180141);
      return;
    }
    if (((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).duQ())
    {
      this.Iwg.setVisibility(0);
      AppMethodBeat.o(180141);
      return;
    }
    this.Iwg.setVisibility(8);
    AppMethodBeat.o(180141);
  }
  
  private com.tencent.mm.plugin.game.luggage.e.a.b getH5GameMenuHelp()
  {
    AppMethodBeat.i(83129);
    if (this.Iwb == null) {
      this.Iwb = new com.tencent.mm.plugin.game.luggage.e.a.b(this.Ivz.ejT.getString("game_hv_menu_appid"));
    }
    com.tencent.mm.plugin.game.luggage.e.a.b localb = this.Iwb;
    AppMethodBeat.o(83129);
    return localb;
  }
  
  private static String iU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(277061);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", paramString1);
      localJSONObject.put("reportStr", paramString2);
      label32:
      paramString1 = URLEncoder.encode(localJSONObject.toString());
      AppMethodBeat.o(277061);
      return paramString1;
    }
    catch (JSONException paramString1)
    {
      break label32;
    }
  }
  
  public final void cxQ()
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
        if (Util.isNullOrNil(g.a(g.this).ejT.getString("game_hv_menu_appid")))
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
  
  public final void fEH()
  {
    AppMethodBeat.i(83130);
    if (!(this.Ivz instanceof a)) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ivz.iR(bool);
      AppMethodBeat.o(83130);
      return;
    }
  }
  
  public final void fEI()
  {
    AppMethodBeat.i(83132);
    if (this.Iwc != null) {
      this.Iwc.iuH();
    }
    if (this.Iwd != null)
    {
      com.tencent.mm.plugin.game.luggage.e.a.c localc = this.Iwd;
      if (localc.IvB != null) {
        localc.IvB.cyW();
      }
    }
    AppMethodBeat.o(83132);
  }
  
  public final void fEM()
  {
    AppMethodBeat.i(277138);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(277026);
        final String str1 = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiD(g.f(g.this));
        if ((Util.isNullOrNil(str1)) || (!g.aGi(g.f(g.this))))
        {
          if (g.g(g.this).getParent() != null) {
            ((ViewGroup)g.g(g.this).getParent()).removeView(g.g(g.this));
          }
          g.h(g.this).setVisibility(0);
          AppMethodBeat.o(277026);
          return;
        }
        g.i(g.this).setVisibility(8);
        if (g.g(g.this).getParent() != null)
        {
          AppMethodBeat.o(277026);
          return;
        }
        int i = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiE(g.f(g.this));
        final String str2 = g.iV(g.j(g.this), g.k(g.this));
        com.tencent.mm.plugin.report.service.h.OAn.b(23044, new Object[] { Integer.valueOf(1), g.f(g.this), Integer.valueOf(0), Integer.valueOf(0), str1, Integer.valueOf(i), Integer.valueOf(2), str2, Integer.valueOf(g.l(g.this)) });
        g.m(g.this).addView(g.g(g.this));
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)g.g(g.this).getLayoutParams();
        localLayoutParams.addRule(13);
        g.g(g.this).setLayoutParams(localLayoutParams);
        g.n(g.this).setText(g.this.getContext().getString(c.i.biz_time_line_finder_live_title));
        g.o(g.this).setBackgroundResource(c.e.webview_top_bar_live_bg);
        g.n(g.this).setTextSize(1, 13.0F);
        aw.e(g.n(g.this).getPaint());
        g.g(g.this).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            AppMethodBeat.i(277035);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymous2View);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/luggage/page/GameWebActionBar$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymous2View = new Bundle();
            paramAnonymous2View.putString("userName", g.f(g.this));
            paramAnonymous2View.putString("exportId", str1);
            paramAnonymous2View.putString("byPass", g.p(g.this));
            XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramAnonymous2View, g.a.class, null);
            int i = ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiE(g.f(g.this));
            com.tencent.mm.plugin.report.service.h.OAn.b(23044, new Object[] { Integer.valueOf(2), g.f(g.this), Integer.valueOf(0), Integer.valueOf(0), str1, Integer.valueOf(i), Integer.valueOf(2), str2, Integer.valueOf(g.l(g.this)) });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/luggage/page/GameWebActionBar$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(277035);
          }
        });
        AppMethodBeat.o(277026);
      }
    });
    AppMethodBeat.o(277138);
  }
  
  public final com.tencent.mm.plugin.webview.luggage.b.n getMenuHelp()
  {
    AppMethodBeat.i(83128);
    if (this.WHc == null) {
      this.WHc = new com.tencent.mm.plugin.game.luggage.e.a();
    }
    com.tencent.mm.plugin.webview.luggage.b.n localn = this.WHc;
    AppMethodBeat.o(83128);
    return localn;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(180139);
    super.onDestroy();
    ((com.tencent.mm.plugin.downloader_app.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.downloader_app.api.c.class)).b(this.Iwh);
    AppMethodBeat.o(180139);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(180140);
    super.onForeground();
    fEL();
    AppMethodBeat.o(180140);
  }
  
  public final void setAlpha(float paramFloat)
  {
    AppMethodBeat.i(277137);
    super.setAlpha(paramFloat);
    float f = paramFloat;
    if (paramFloat == 0.0F) {
      f = 1.0F;
    }
    if ((f < 0.0F) || (f > 1.0F))
    {
      AppMethodBeat.o(277137);
      return;
    }
    int i = (int)(255.0F * f);
    if (this.Iwf != null) {
      this.Iwf.setImageAlpha(i);
    }
    AppMethodBeat.o(277137);
  }
  
  public final void wm(boolean paramBoolean)
  {
    AppMethodBeat.i(277135);
    super.wm(paramBoolean);
    if (this.Iwf != null) {
      this.Iwf.setDarkMode(paramBoolean);
    }
    AppMethodBeat.o(277135);
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static final class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Object>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.page.g
 * JD-Core Version:    0.7.0.1
 */