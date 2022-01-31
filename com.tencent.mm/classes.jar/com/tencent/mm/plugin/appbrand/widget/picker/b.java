package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Constructor;

public abstract class b
{
  public a hzI;
  
  public final <T extends com.tencent.mm.plugin.appbrand.jsapi.m.b> T N(Class<T> paramClass)
  {
    a locala = dX(true);
    this.hzI = locala;
    if (locala == null) {
      return null;
    }
    try
    {
      locala.setPickerImpl((com.tencent.mm.plugin.appbrand.jsapi.m.b)paramClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { locala.getContext() }));
      return locala.getPicker();
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.AppBrandBottomPickerInvokeHandler", "newInstance class[%s], exp[%s]", new Object[] { paramClass.getSimpleName(), localException });
    }
    return null;
  }
  
  public abstract View ajS();
  
  public final a dX(boolean paramBoolean)
  {
    a locala2 = null;
    if (this.hzI != null) {
      locala1 = this.hzI;
    }
    m localm;
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
          } while (ajS() == null);
          localm = m.ch(ajS());
          locala1 = locala2;
        } while (localm == null);
        locala2 = a.cu(localm);
        locala1 = locala2;
      } while (locala2 != null);
      locala1 = locala2;
    } while (!paramBoolean);
    a locala1 = new a(ajS().getContext());
    localm.i(locala1, true);
    return locala1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.b
 * JD-Core Version:    0.7.0.1
 */