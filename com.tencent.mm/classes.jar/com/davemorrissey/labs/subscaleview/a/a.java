package com.davemorrissey.labs.subscaleview.a;

import android.graphics.Bitmap.Config;
import java.lang.reflect.Constructor;

public final class a<T>
  implements b<T>
{
  private Class<? extends T> aov;
  private Bitmap.Config aow;
  
  public a(Class<? extends T> paramClass)
  {
    this(paramClass, (byte)0);
  }
  
  private a(Class<? extends T> paramClass, byte paramByte)
  {
    this.aov = paramClass;
    this.aow = null;
  }
  
  public final T jr()
  {
    if (this.aow == null) {
      return this.aov.newInstance();
    }
    return this.aov.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.aow });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.davemorrissey.labs.subscaleview.a.a
 * JD-Core Version:    0.7.0.1
 */