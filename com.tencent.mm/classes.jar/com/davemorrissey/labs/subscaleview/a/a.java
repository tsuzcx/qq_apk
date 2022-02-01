package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class a<T>
  implements b<T>
{
  private Bitmap.Config aBW;
  private Class<? extends T> aLD;
  
  public a(Class<? extends T> paramClass)
  {
    this(paramClass, (byte)0);
  }
  
  private a(Class<? extends T> paramClass, byte paramByte)
  {
    this.aLD = paramClass;
    this.aBW = null;
  }
  
  public final T pV()
  {
    AppMethodBeat.i(157341);
    if (this.aBW == null)
    {
      localObject = this.aLD.newInstance();
      AppMethodBeat.o(157341);
      return localObject;
    }
    Object localObject = this.aLD.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.aBW });
    AppMethodBeat.o(157341);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.a
 * JD-Core Version:    0.7.0.1
 */