package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.v.c;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Constructor;

public abstract class b
{
  private a uMW;
  
  private a lJ(boolean paramBoolean)
  {
    a locala2 = null;
    if (this.uMW != null) {
      locala1 = this.uMW;
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
            localView = cuk();
            locala1 = locala2;
          } while (localView == null);
          localn = n.ed(localView);
          locala1 = locala2;
        } while (localn == null);
        locala2 = a.es(localn);
        locala1 = locala2;
      } while (locala2 != null);
      locala1 = locala2;
    } while (!paramBoolean);
    a locala1 = eL(localView.getContext());
    localn.n(locala1, true);
    return locala1;
  }
  
  public final <T extends c> T bb(Class<T> paramClass)
  {
    Log.d("MicroMsg.AppBrandBottomPickerInvokeHandler", paramClass.getSimpleName());
    a locala = lJ(true);
    this.uMW = locala;
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
  
  public final <T extends c> T bc(Class<T> paramClass)
  {
    a locala = lJ(false);
    if ((locala != null) && (paramClass.isInstance(locala.getPicker()))) {
      return locala.getPicker();
    }
    return null;
  }
  
  public final a cSl()
  {
    return this.uMW;
  }
  
  protected abstract View cuk();
  
  protected a eL(Context paramContext)
  {
    return new a(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */