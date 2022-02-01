package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.mmv8.V8Context;
import com.eclipsesource.mmv8.V8Object;

public abstract class o
{
  private final String mKey;
  
  public o()
  {
    this("");
  }
  
  public o(String paramString)
  {
    this.mKey = paramString;
  }
  
  protected abstract void b(m paramm, V8Object paramV8Object);
  
  abstract void cleanup();
  
  final o f(m paramm)
  {
    if (TextUtils.isEmpty(this.mKey))
    {
      b(paramm, paramm.aEm().getGlobalObject());
      return this;
    }
    V8Object localV8Object = paramm.aEm().newV8Object();
    paramm.aEm().add(this.mKey, localV8Object);
    b(paramm, localV8Object);
    localV8Object.release();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.o
 * JD-Core Version:    0.7.0.1
 */