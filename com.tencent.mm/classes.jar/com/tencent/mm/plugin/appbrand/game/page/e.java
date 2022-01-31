package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.al;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.sdk.platformtools.y;

@SuppressLint({"ViewConstructor"})
public final class e
  extends o
{
  private volatile d gcu = null;
  
  public e(Context paramContext, n paramn)
  {
    super(paramContext, paramn);
  }
  
  public final void aa(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      getCurrentPage().loadUrl(paramString);
      try
      {
        getReporter().a(getCurrentPageView(), null, al.gVQ);
        return;
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.WAGamePageContainer", "report autoReLaunch, e = %s", new Object[] { paramString });
        return;
      }
    }
    y.e("MicroMsg.WAGamePageContainer", "reLaunch without auto is not support here");
  }
  
  public final void agL()
  {
    runOnUiThread(new e.2(this));
  }
  
  public final boolean agM()
  {
    return false;
  }
  
  public final void c(String paramString1, String paramString2, int[] paramArrayOfInt) {}
  
  public final d getCurrentPage()
  {
    try
    {
      d locald = this.gcu;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final f getCurrentPageView()
  {
    return getCurrentPage().getCurrentPageView();
  }
  
  public final int getPageCount()
  {
    return 1;
  }
  
  public final void kV(int paramInt)
  {
    agL();
  }
  
  public final void pY()
  {
    getCurrentPage().agH();
    try
    {
      getReporter().d(getCurrentPageView());
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WAGamePageContainer", "report foreground, e = %s", new Object[] { localException });
    }
  }
  
  public final void qa()
  {
    getCurrentPage().agI();
    try
    {
      getReporter().c(getCurrentPageView());
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WAGamePageContainer", "report background, e = %s", new Object[] { localException });
    }
  }
  
  public final void tA(String paramString)
  {
    runOnUiThread(new e.1(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.e
 * JD-Core Version:    0.7.0.1
 */