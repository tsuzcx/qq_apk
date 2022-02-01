package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class a<T>
  implements b<T>
{
  private Class<? extends T> aFS;
  private Bitmap.Config aFT;
  
  public a(Class<? extends T> paramClass)
  {
    this(paramClass, (byte)0);
  }
  
  private a(Class<? extends T> paramClass, byte paramByte)
  {
    this.aFS = paramClass;
    this.aFT = null;
  }
  
  public final T pu()
  {
    AppMethodBeat.i(157341);
    if (this.aFT == null)
    {
      localObject = this.aFS.newInstance();
      AppMethodBeat.o(157341);
      return localObject;
    }
    Object localObject = this.aFS.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.aFT });
    AppMethodBeat.o(157341);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.a
 * JD-Core Version:    0.7.0.1
 */