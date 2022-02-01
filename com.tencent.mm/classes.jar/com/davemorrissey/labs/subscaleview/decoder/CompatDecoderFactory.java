package com.davemorrissey.labs.subscaleview.decoder;

import android.graphics.Bitmap.Config;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class CompatDecoderFactory<T>
  implements DecoderFactory<T>
{
  private Bitmap.Config bitmapConfig;
  private Class<? extends T> clazz;
  
  public CompatDecoderFactory(Class<? extends T> paramClass)
  {
    this(paramClass, (byte)0);
  }
  
  private CompatDecoderFactory(Class<? extends T> paramClass, byte paramByte)
  {
    this.clazz = paramClass;
    this.bitmapConfig = null;
  }
  
  public final T make()
  {
    AppMethodBeat.i(157341);
    if (this.bitmapConfig == null)
    {
      localObject = this.clazz.newInstance();
      AppMethodBeat.o(157341);
      return localObject;
    }
    Object localObject = this.clazz.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.bitmapConfig });
    AppMethodBeat.o(157341);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory
 * JD-Core Version:    0.7.0.1
 */