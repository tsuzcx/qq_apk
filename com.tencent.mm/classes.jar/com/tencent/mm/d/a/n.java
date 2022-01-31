package com.tencent.mm.d.a;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;

public abstract class n
{
  private final String mKey;
  
  public n()
  {
    this("");
  }
  
  public n(String paramString)
  {
    this.mKey = paramString;
  }
  
  final n a(l paraml)
  {
    if (TextUtils.isEmpty(this.mKey))
    {
      a(paraml, paraml.Cu().getGlobalObject());
      return this;
    }
    V8Object localV8Object = paraml.Cu().newV8Object();
    paraml.Cu().add(this.mKey, localV8Object);
    a(paraml, localV8Object);
    localV8Object.release();
    return this;
  }
  
  protected abstract void a(l paraml, V8Object paramV8Object);
  
  abstract void cleanup();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.d.a.n
 * JD-Core Version:    0.7.0.1
 */