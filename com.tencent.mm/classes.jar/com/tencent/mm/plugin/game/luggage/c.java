package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.webview.a.a;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.luggage.h;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import java.util.Map;

public class c
  extends h
{
  private static final Object lock = new Object();
  com.tencent.mm.plugin.wepkg.c kMq = new c.2(this);
  boolean kMr = false;
  private String kMs;
  private boolean kMt = false;
  private boolean kMu = false;
  private GameWebPerformanceInfo kMv;
  private String mTitle;
  private Runnable pHU = new c.1(this);
  
  public c(Context paramContext)
  {
    super(paramContext);
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
  }
  
  private void cux()
  {
    if (this.kMv.dCO != 0L) {
      return;
    }
    evaluateJavascript("javascript:(function(){if (window.WeixinJSBridge) {return 1;} else {return 0;}})();", new c.4(this));
  }
  
  public final void a(a.a parama)
  {
    super.a(parama);
    runOnUiThread(new c.3(this));
  }
  
  public void a(WebView arg1, String paramString)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", new Object[] { Boolean.valueOf(this.kMu) });
    if (this.kMv.dCR == 0L) {
      this.kMv.dCR = System.currentTimeMillis();
    }
    synchronized (lock)
    {
      getSettings().setBlockNetworkImage(this.kMu);
      this.kMt = true;
      cux();
      return;
    }
  }
  
  public void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.kMv.dCQ == 0L) {
      this.kMv.dCQ = System.currentTimeMillis();
    }
    cux();
  }
  
  public void destroy()
  {
    this.kMq.lL(false);
    super.destroy();
  }
  
  public String getTitle()
  {
    return this.mTitle;
  }
  
  public com.tencent.mm.plugin.wepkg.c getWePkgPlugin()
  {
    if (this.kMq == null) {
      this.kMq = new c.5(this);
    }
    return this.kMq;
  }
  
  public void loadUrl(String paramString)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "loadUrl, time : %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.kMv == null)
    {
      this.kMv = GameWebPerformanceInfo.fv(paramString);
      this.kMv.dCP = System.currentTimeMillis();
    }
    this.kMs = paramString;
    if (!this.kMr)
    {
      this.kMq.bu(paramString, true);
      this.kMr = true;
    }
    super.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "loadUrl, time: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
    if (this.kMv == null)
    {
      this.kMv = GameWebPerformanceInfo.fv(paramString);
      this.kMv.dCP = System.currentTimeMillis();
    }
    this.kMs = paramString;
    if (!this.kMr)
    {
      this.kMq.bu(paramString, true);
      this.kMr = true;
    }
    super.loadUrl(paramString, paramMap);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    postDelayed(this.pHU, 3000L);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", new Object[] { Integer.valueOf(hashCode()) });
    removeCallbacks(this.pHU);
  }
  
  public void setBlockNetworkImage(boolean paramBoolean)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kMu = paramBoolean;
    if (this.kMt) {
      synchronized (lock)
      {
        getSettings().setBlockNetworkImage(paramBoolean);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c
 * JD-Core Version:    0.7.0.1
 */