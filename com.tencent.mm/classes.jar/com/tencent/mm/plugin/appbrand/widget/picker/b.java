package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Constructor;

public abstract class b
{
  public a jrY;
  
  protected abstract View aEv();
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.n.b> T ah(Class<T> paramClass)
  {
    a locala = ft(true);
    this.jrY = locala;
    if (locala == null) {
      return null;
    }
    try
    {
      locala.setPickerImpl((com.tencent.mm.plugin.appbrand.jsapi.n.b)paramClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { locala.getContext() }));
      return locala.getPicker();
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", new Object[] { paramClass.getSimpleName(), localException });
    }
    return null;
  }
  
  public final a ft(boolean paramBoolean)
  {
    a locala2 = null;
    if (this.jrY != null) {
      locala1 = this.jrY;
    }
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
            locala1 = locala2;
          } while (aEv() == null);
          localn = n.cJ(aEv());
          locala1 = locala2;
        } while (localn == null);
        locala2 = a.cY(localn);
        locala1 = locala2;
      } while (locala2 != null);
      locala1 = locala2;
    } while (!paramBoolean);
    a locala1 = new a(aEv().getContext());
    localn.n(locala1, true);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */