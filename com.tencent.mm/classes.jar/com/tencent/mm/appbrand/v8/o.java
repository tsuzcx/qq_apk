package com.tencent.mm.appbrand.v8;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;

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
  
  final o a(m paramm)
  {
    if (TextUtils.isEmpty(this.mKey))
    {
      a(paramm, paramm.NA().getGlobalObject());
      return this;
    }
    V8Object localV8Object = paramm.NA().newV8Object();
    paramm.NA().add(this.mKey, localV8Object);
    a(paramm, localV8Object);
    localV8Object.release();
    return this;
  }
  
  protected abstract void a(m paramm, V8Object paramV8Object);
  
  abstract void cleanup();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.o
 * JD-Core Version:    0.7.0.1
 */