package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.sdk.platformtools.y;

@SuppressLint({"ViewConstructor"})
public final class d
  extends k
{
  private f gct;
  private String mURL;
  
  public d(Context paramContext, e parame)
  {
    super(paramContext, parame);
    y.i("MicroMsg.WAGamePage", "hy: WAGamePage on create");
  }
  
  protected final View agE()
  {
    return new FrameLayout(getContext());
  }
  
  protected final View agF()
  {
    f localf = new f(getContext(), getContainer().getRuntime());
    this.gct = localf;
    return localf.gcx;
  }
  
  protected final void agG()
  {
    super.agG();
    this.gct.onDestroy();
  }
  
  public final void agH()
  {
    super.agH();
    this.gct.pY();
  }
  
  public final void agI()
  {
    super.agI();
    this.gct.qa();
  }
  
  protected final void agJ() {}
  
  protected final void agK() {}
  
  public final void b(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    this.gct.i(paramString1, paramString2, 0);
  }
  
  public final void cleanup()
  {
    super.cleanup();
    this.gct.cleanup();
  }
  
  public final f getCurrentPageView()
  {
    return this.gct;
  }
  
  public final String getCurrentUrl()
  {
    return this.mURL;
  }
  
  public final void loadUrl(String paramString)
  {
    this.mURL = paramString;
    this.gct.tB(paramString);
  }
  
  public final boolean tz(String paramString)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.d
 * JD-Core Version:    0.7.0.1
 */