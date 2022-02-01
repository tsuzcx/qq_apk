package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.m.c;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Constructor;

public abstract class b
{
  public a mJP;
  
  private a ie(boolean paramBoolean)
  {
    a locala2 = null;
    if (this.mJP != null) {
      locala1 = this.mJP;
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
            localView = bit();
            locala1 = locala2;
          } while (localView == null);
          localn = n.db(localView);
          locala1 = locala2;
        } while (localn == null);
        locala2 = a.dq(localn);
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
    ac.d("MicroMsg.AppBrandBottomPickerInvokeHandler", paramClass.getSimpleName());
    a locala = ie(true);
    this.mJP = locala;
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
    a locala = ie(false);
    if ((locala != null) && (paramClass.isInstance(locala.getPicker()))) {
      return locala.getPicker();
    }
    return null;
  }
  
  protected abstract View bit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */