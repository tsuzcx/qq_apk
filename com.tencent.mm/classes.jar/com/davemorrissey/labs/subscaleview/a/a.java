package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class a<T>
  implements b<T>
{
  private Bitmap.Config aCO;
  private Class<? extends T> aMt;
  
  public a(Class<? extends T> paramClass)
  {
    this(paramClass, (byte)0);
  }
  
  private a(Class<? extends T> paramClass, byte paramByte)
  {
    this.aMt = paramClass;
    this.aCO = null;
  }
  
  public final T qf()
  {
    AppMethodBeat.i(157341);
    if (this.aCO == null)
    {
      localObject = this.aMt.newInstance();
      AppMethodBeat.o(157341);
      return localObject;
    }
    Object localObject = this.aMt.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.aCO });
    AppMethodBeat.o(157341);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.a
 * JD-Core Version:    0.7.0.1
 */