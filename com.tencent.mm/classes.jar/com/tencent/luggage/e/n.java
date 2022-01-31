package com.tencent.luggage.e;

import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.webview.a;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

public class n
  extends e
  implements b
{
  public View QR;
  private l biG = new n.2(this);
  public k biT;
  public SwipeBackLayout biU;
  public Bundle biV;
  String biW = null;
  
  public n(g paramg, Bundle paramBundle)
  {
    this(paramg, null, paramBundle);
  }
  
  public n(g paramg, k paramk, Bundle paramBundle)
  {
    super(paramg);
    if (paramBundle != null) {}
    for (;;)
    {
      this.biV = paramBundle;
      this.biT = paramk;
      paramk = this.biT;
      paramg = paramk;
      if (paramk == null) {
        paramg = this.bil.qf();
      }
      paramk = paramg;
      if (paramg == null) {
        paramk = new k(this.mContext, this.bil.qg());
      }
      this.biT = paramk;
      paramg = this.biT;
      paramg.a(this.bil.qk(), this);
      paramg.biG = this.biG;
      paramg = pW();
      this.biU = new SwipeBackLayout(this.mContext);
      this.biU.setScrimColor(0);
      this.biU.addView(paramg);
      this.biU.setContentView(paramg);
      this.biU.a(new n.1(this, new boolean[] { false }));
      this.QR = this.biU;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public final void a(e.a parama)
  {
    if ((parama instanceof n.a))
    {
      this.bim = parama;
      return;
    }
    this.bim = new n.a(parama);
  }
  
  public void c(String paramString, Bundle paramBundle)
  {
    this.biT.loadUrl(paramString);
  }
  
  public final void destroy()
  {
    onDestroy();
    this.bik.k(i.c.class);
    this.biT.destroy();
  }
  
  public final View getContentView()
  {
    return this.QR;
  }
  
  public View pW()
  {
    return this.biT.getView();
  }
  
  protected final boolean qc()
  {
    if (this.biT.biH.canGoBack())
    {
      this.biT.biH.goBack();
      return true;
    }
    return false;
  }
  
  public String qq()
  {
    return "";
  }
  
  public final n.a qr()
  {
    return (n.a)this.bim;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.e.n
 * JD-Core Version:    0.7.0.1
 */