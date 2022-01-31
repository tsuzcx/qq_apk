package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class a<T>
  implements b<T>
{
  private Class<? extends T> aqP;
  private Bitmap.Config aqQ;
  
  public a(Class<? extends T> paramClass)
  {
    this(paramClass, (byte)0);
  }
  
  private a(Class<? extends T> paramClass, byte paramByte)
  {
    this.aqP = paramClass;
    this.aqQ = null;
  }
  
  public final T ll()
  {
    AppMethodBeat.i(115606);
    if (this.aqQ == null)
    {
      localObject = this.aqP.newInstance();
      AppMethodBeat.o(115606);
      return localObject;
    }
    Object localObject = this.aqP.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.aqQ });
    AppMethodBeat.o(115606);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.a
 * JD-Core Version:    0.7.0.1
 */