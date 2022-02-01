package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue;
import com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue.JsValueFactory;
import java.nio.ByteBuffer;

public class JsValue
{
  private final JsContext a;
  private final IX5JsValue b;
  
  protected JsValue(JsContext paramJsContext, IX5JsValue paramIX5JsValue)
  {
    this.a = paramJsContext;
    this.b = paramIX5JsValue;
  }
  
  protected static IX5JsValue.JsValueFactory a()
  {
    return new a(null);
  }
  
  private JsValue a(IX5JsValue paramIX5JsValue)
  {
    if (paramIX5JsValue == null) {
      return null;
    }
    return new JsValue(this.a, paramIX5JsValue);
  }
  
  public JsValue call(Object... paramVarArgs)
  {
    return a(this.b.call(paramVarArgs));
  }
  
  public JsValue construct(Object... paramVarArgs)
  {
    return a(this.b.construct(paramVarArgs));
  }
  
  public JsContext context()
  {
    return this.a;
  }
  
  public boolean isArray()
  {
    return this.b.isArray();
  }
  
  public boolean isArrayBufferOrArrayBufferView()
  {
    return this.b.isArrayBufferOrArrayBufferView();
  }
  
  public boolean isBoolean()
  {
    return this.b.isBoolean();
  }
  
  public boolean isFunction()
  {
    return this.b.isFunction();
  }
  
  public boolean isInteger()
  {
    return this.b.isInteger();
  }
  
  public boolean isJavascriptInterface()
  {
    return this.b.isJavascriptInterface();
  }
  
  public boolean isNull()
  {
    return this.b.isNull();
  }
  
  public boolean isNumber()
  {
    return this.b.isNumber();
  }
  
  public boolean isObject()
  {
    return this.b.isObject();
  }
  
  public boolean isPromise()
  {
    return this.b.isPromise();
  }
  
  public boolean isString()
  {
    return this.b.isString();
  }
  
  public boolean isUndefined()
  {
    return this.b.isUndefined();
  }
  
  public void reject(Object paramObject)
  {
    this.b.resolveOrReject(paramObject, false);
  }
  
  public void resolve(Object paramObject)
  {
    this.b.resolveOrReject(paramObject, true);
  }
  
  public boolean toBoolean()
  {
    return this.b.toBoolean();
  }
  
  public ByteBuffer toByteBuffer()
  {
    return this.b.toByteBuffer();
  }
  
  public int toInteger()
  {
    return this.b.toInteger();
  }
  
  public Object toJavascriptInterface()
  {
    return this.b.toJavascriptInterface();
  }
  
  public Number toNumber()
  {
    return this.b.toNumber();
  }
  
  public <T> T toObject(Class<T> paramClass)
  {
    return this.b.toObject(paramClass);
  }
  
  public String toString()
  {
    return this.b.toString();
  }
  
  private static class a
    implements IX5JsValue.JsValueFactory
  {
    public String getJsValueClassName()
    {
      return JsValue.class.getName();
    }
    
    public IX5JsValue unwrap(Object paramObject)
    {
      if ((paramObject != null) && ((paramObject instanceof JsValue))) {
        return JsValue.a((JsValue)paramObject);
      }
      return null;
    }
    
    public Object wrap(IX5JsValue paramIX5JsValue)
    {
      if (paramIX5JsValue != null)
      {
        JsContext localJsContext = JsContext.current();
        if (localJsContext != null) {
          return new JsValue(localJsContext, paramIX5JsValue);
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.JsValue
 * JD-Core Version:    0.7.0.1
 */