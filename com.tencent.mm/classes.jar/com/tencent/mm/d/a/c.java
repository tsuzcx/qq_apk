package com.tencent.mm.d.a;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;

public abstract class c
{
  private final String mKey;
  
  c()
  {
    this("");
  }
  
  c(String paramString)
  {
    this.mKey = paramString;
  }
  
  final c a(b paramb)
  {
    if (TextUtils.isEmpty(this.mKey))
    {
      a(paramb, paramb.byX.getGlobalObject());
      return this;
    }
    V8Object localV8Object = paramb.byX.newV8Object();
    paramb.byX.add(this.mKey, localV8Object);
    a(paramb, localV8Object);
    localV8Object.release();
    return this;
  }
  
  protected abstract void a(b paramb, V8Object paramV8Object);
  
  abstract void cleanup();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.c
 * JD-Core Version:    0.7.0.1
 */