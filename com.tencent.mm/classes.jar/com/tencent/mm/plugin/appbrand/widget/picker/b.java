package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.n.c;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Constructor;

public abstract class b
{
  public a mhO;
  
  private a hF(boolean paramBoolean)
  {
    a locala2 = null;
    if (this.mhO != null) {
      locala1 = this.mhO;
    }
    View localView;
    n localn;
    do
    {
      do
      {
        do
        {
          do
          {
            return locala1;
            localView = bbA();
            locala1 = locala2;
          } while (localView == null);
          localn = n.cZ(localView);
          locala1 = locala2;
        } while (localn == null);
        locala2 = a.jdMethod_do(localn);
        locala1 = locala2;
      } while (locala2 != null);
      locala1 = locala2;
    } while (!paramBoolean);
    a locala1 = new a(localView.getContext());
    localn.n(locala1, true);
    return locala1;
  }
  
  public final <T extends c> T aK(Class<T> paramClass)
  {
    ad.d("MicroMsg.AppBrandBottomPickerInvokeHandler", paramClass.getSimpleName());
    a locala = hF(true);
    this.mhO = locala;
    if (locala == null) {
      return null;
    }
    try
    {
      locala.setPickerImpl((c)paramClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { locala.getContext() }));
      return locala.getPicker();
    }
    catch (Exception paramClass) {}
    return null;
  }
  
  public final <T extends c> T aL(Class<T> paramClass)
  {
    a locala = hF(false);
    if ((locala != null) && (paramClass.isInstance(locala.getPicker()))) {
      return locala.getPicker();
    }
    return null;
  }
  
  protected abstract View bbA();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */