package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class a<T>
  implements b<T>
{
  private Bitmap.Config aEF;
  private Class<? extends T> aWC;
  
  public a(Class<? extends T> paramClass)
  {
    this(paramClass, (byte)0);
  }
  
  private a(Class<? extends T> paramClass, byte paramByte)
  {
    this.aWC = paramClass;
    this.aEF = null;
  }
  
  public final T rG()
  {
    AppMethodBeat.i(157341);
    if (this.aEF == null)
    {
      localObject = this.aWC.newInstance();
      AppMethodBeat.o(157341);
      return localObject;
    }
    Object localObject = this.aWC.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.aEF });
    AppMethodBeat.o(157341);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.a
 * JD-Core Version:    0.7.0.1
 */