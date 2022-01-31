package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.e.g;
import com.tencent.luggage.e.k;
import com.tencent.luggage.e.n;
import com.tencent.luggage.j.h;
import com.tencent.mm.R.e;
import com.tencent.mm.R.i;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.plugin.webview.ui.tools.game.c.a;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.widget.MovingImageButton;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class d
  extends com.tencent.mm.plugin.webview.luggage.e
{
  private String kMA;
  public com.tencent.mm.plugin.webview.ui.tools.game.c kMB = new d.1(this);
  private long kMC;
  protected GameWebPerformanceInfo kMv;
  private View kMx;
  private GameMenuImageButton kMy;
  public boolean kMz = false;
  
  public d(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg, paramk, paramBundle);
    y.i("MicroMsg.GameWebPage", "initWebPageEnd, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    this.kMv = GameWebPerformanceInfo.fv(paramBundle.getString("rawUrl"));
    this.kMv.dCN = System.currentTimeMillis();
  }
  
  public final boolean EB(String paramString)
  {
    c localc = (c)this.rbA;
    if (!localc.kMr)
    {
      localc.kMq.bu(paramString, true);
      localc.kMr = true;
    }
    return localc.kMq.UQ(paramString);
  }
  
  protected final void EC(String paramString)
  {
    super.EC(paramString);
    com.tencent.mm.plugin.webview.luggage.c.a.Sa(caV());
  }
  
  public void Ex(String paramString)
  {
    if (paramString.equals(caV())) {
      this.kMv.dCS = System.currentTimeMillis();
    }
    super.Ex(paramString);
  }
  
  protected final void aYA()
  {
    if (!this.rbV)
    {
      this.gTL = this.biV.getInt("customize_status_bar_color");
      if (this.gTL == 0) {
        break label45;
      }
      this.gTN = this.biV.getString("status_bar_style");
    }
    for (;;)
    {
      aYB();
      return;
      label45:
      dc localdc = com.tencent.mm.plugin.game.commlib.a.aYn();
      if ((localdc != null) && (!bk.bl(localdc.color))) {
        try
        {
          this.gTL = Color.parseColor(localdc.color);
          if (this.gTL == 0) {
            this.gTL = android.support.v4.content.b.i(this.mContext, R.e.action_bar_color);
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            y.e("MicroMsg.GameWebPage", "parse color: " + localIllegalArgumentException.getMessage());
          }
          this.gTN = localdc.kQS;
        }
      }
    }
  }
  
  public final void aYB()
  {
    if (Thread.currentThread() != Looper.getMainLooper().getThread())
    {
      this.mHandler.post(new d.3(this));
      return;
    }
    if ((this.mContext instanceof LuggageGameWebViewUI))
    {
      LuggageGameWebViewUI localLuggageGameWebViewUI = (LuggageGameWebViewUI)this.mContext;
      int i = this.gTL;
      boolean bool = bk.pm(this.gTN).equals("black");
      if (Build.VERSION.SDK_INT >= 21) {
        if (localLuggageGameWebViewUI.getSwipeBackLayout() == null) {
          bool = com.tencent.mm.plugin.webview.luggage.d.a.c(localLuggageGameWebViewUI, i, bool);
        }
      }
      while (bool)
      {
        caR();
        return;
        if ((Build.VERSION.SDK_INT >= 21) && (localLuggageGameWebViewUI.getWindow() != null))
        {
          com.tencent.mm.ui.statusbar.a.d(localLuggageGameWebViewUI.getSwipeBackLayout().getChildAt(0), i, bool);
          bool = true;
        }
        else
        {
          bool = false;
        }
      }
      this.gTL = this.mContext.getResources().getColor(R.e.dark_actionbar_color);
      this.gTN = "";
      caR();
      return;
    }
    if (com.tencent.mm.plugin.webview.luggage.d.a.b(this.mContext, this.gTL, this.gTN))
    {
      caR();
      return;
    }
    this.gTL = this.mContext.getResources().getColor(R.e.dark_actionbar_color);
    this.gTN = "";
    caR();
  }
  
  protected void aYC()
  {
    this.kMx.setVisibility(0);
  }
  
  protected final void aYD()
  {
    this.kMx.setVisibility(8);
  }
  
  public final com.tencent.mm.plugin.wepkg.c aYE()
  {
    return ((c)this.rbA).getWePkgPlugin();
  }
  
  protected final void aYv()
  {
    this.rbE.aYv();
  }
  
  protected final View aYz()
  {
    this.rbE = new b(this);
    return this.rbE;
  }
  
  public void b(String paramString1, String paramString2, final Map<String, String> paramMap)
  {
    super.b(paramString1, paramString2, paramMap);
    if (paramString1.equals(caV())) {
      this.kMv.dCT = System.currentTimeMillis();
    }
    com.tencent.mm.plugin.webview.luggage.c.a.RV(caV());
    if (EB(paramString1)) {
      this.mHandler.post(new Runnable()
      {
        public final void run()
        {
          if ((paramMap != null) && (paramMap.size() != 0))
          {
            d.a(d.this);
            com.tencent.xweb.c.il(d.this.mContext);
            com.tencent.xweb.b localb = com.tencent.xweb.b.cSe();
            Iterator localIterator = paramMap.keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localb.setCookie(bk.aai(d.b(d.this)), str + "=" + (String)paramMap.get(str));
            }
            localb.setCookie(bk.aai(d.c(d.this)), "httponly");
            com.tencent.xweb.c.cSg();
            com.tencent.xweb.c.sync();
            y.i("MicroMsg.GameWebPage", "cookies:%s", new Object[] { localb.getCookie(bk.aai(d.d(d.this))) });
          }
          d.this.biT.a(new com.tencent.luggage.e.c()
          {
            public final String name()
            {
              return "onGetA8KeyUrl";
            }
            
            public final JSONObject pV()
            {
              localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("url", d.e(d.this));
                if ((d.4.this.kME != null) && (d.4.this.kME.size() != 0)) {}
                for (int i = 1;; i = 0)
                {
                  localJSONObject.put("set_cookie", i);
                  return localJSONObject;
                }
                return localJSONObject;
              }
              catch (Exception localException)
              {
                y.e("MicroMsg.GameWebPage", "onGetA8Key, e:" + localException.getMessage());
              }
            }
          });
        }
      });
    }
  }
  
  protected final void bc(String paramString)
  {
    y.d("MicroMsg.GameWebPage", "onUrlLoadingStarted, url = %s, time = %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    super.bc(paramString);
    com.tencent.mm.plugin.webview.luggage.c.a.RW(caV());
    this.kMB.rwj.cfP();
  }
  
  protected final void bd(String paramString)
  {
    y.d("MicroMsg.GameWebPage", "onUrlLoadingFinished, url = %s, time = %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis()) });
    super.bd(paramString);
    com.tencent.mm.plugin.webview.luggage.c.a.RX(caV());
    this.kMB.rwj.cfQ();
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    y.i("MicroMsg.GameWebPage", "load url, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    com.tencent.mm.plugin.webview.luggage.c.a.RU(paramString);
    super.c(paramString, paramBundle);
  }
  
  protected void gv(boolean paramBoolean)
  {
    super.gv(paramBoolean);
    if (isFullScreen())
    {
      this.kMA = this.biV.getString("game_hv_menu_appid");
      if (!bk.bl(this.kMA))
      {
        if (this.kMy == null)
        {
          this.kMy = new GameMenuImageButton(this.mContext);
          this.kMy.a(this.rbC, new d.2(this));
        }
        this.rbK.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    this.rbK.setVisibility(0);
  }
  
  protected final void onDestroy()
  {
    y.i("MicroMsg.GameWebPage", "onDestroy");
    com.tencent.mm.plugin.game.luggage.d.a.EK(caV());
    super.onDestroy();
    com.tencent.mm.plugin.webview.ui.tools.game.c.a(this.kMB.rwj.rwk);
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.kMv;
    localGameWebPerformanceInfo.dCU += System.currentTimeMillis() - this.kMC;
    this.kMv.dCV = System.currentTimeMillis();
    com.tencent.mm.game.report.api.c.dCx.a(GameWebPerformanceInfo.fw(caV()));
  }
  
  protected final View pW()
  {
    View localView = super.pW();
    this.kMx = LayoutInflater.from(this.mContext).inflate(R.i.game_loading_progressbar, this.rbL, false);
    this.kMx.setVisibility(8);
    this.rbL.addView(this.kMx, new FrameLayout.LayoutParams(-2, -2, 17));
    y.i("MicroMsg.GameWebPage", "create vie end, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    return localView;
  }
  
  protected void pY()
  {
    y.i("MicroMsg.GameWebPage", "onForeground");
    if (this.kMv.dCL == 0L) {
      this.kMv.dCL = System.currentTimeMillis();
    }
    this.kMC = System.currentTimeMillis();
    this.kMB.rwj.onResume();
    super.pY();
  }
  
  protected final void qa()
  {
    y.i("MicroMsg.GameWebPage", "onBackground");
    GameWebPerformanceInfo localGameWebPerformanceInfo = this.kMv;
    localGameWebPerformanceInfo.dCU += System.currentTimeMillis() - this.kMC;
    this.kMC = System.currentTimeMillis();
    this.kMB.rwj.onPause();
    int i = this.bil.getPageStack().indexOf(this);
    if ((i > 1) && (((com.tencent.luggage.e.e)this.bil.getPageStack().get(i - 1) instanceof j))) {
      return;
    }
    super.qa();
  }
  
  protected final String qq()
  {
    return h.k(this.mContext, "luggage_game_adapter.js");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d
 * JD-Core Version:    0.7.0.1
 */