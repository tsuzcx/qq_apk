package com.eclipsesource.v8;

import java.lang.reflect.Method;

public class V8Object
  extends V8Value
{
  protected V8Object() {}
  
  public V8Object(V8 paramV8)
  {
    this(paramV8, null);
  }
  
  protected V8Object(V8 paramV8, Object paramObject)
  {
    super(paramV8);
    if (paramV8 != null)
    {
      this.v8.checkThread();
      initialize(this.v8.getV8RuntimePtr(), paramObject);
    }
  }
  
  private void checkKey(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Key cannot be null");
    }
  }
  
  public V8Object add(String paramString, double paramDouble)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramDouble);
    return this;
  }
  
  public V8Object add(String paramString, int paramInt)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramInt);
    return this;
  }
  
  public V8Object add(String paramString, V8Value paramV8Value)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Value);
    if (paramV8Value == null)
    {
      this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
      return this;
    }
    if (paramV8Value.equals(V8.getUndefined()))
    {
      this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
      return this;
    }
    this.v8.addObject(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramV8Value.getHandle());
    return this;
  }
  
  public V8Object add(String paramString1, String paramString2)
  {
    this.v8.checkThread();
    checkReleased();
    if (paramString2 == null)
    {
      this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, paramString1);
      return this;
    }
    if (paramString2.equals(V8.getUndefined()))
    {
      this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, paramString1);
      return this;
    }
    this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString1, paramString2);
    return this;
  }
  
  public V8Object add(String paramString, boolean paramBoolean)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramBoolean);
    return this;
  }
  
  public V8Object addNull(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    return this;
  }
  
  public V8Object addUndefined(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    return this;
  }
  
  public boolean contains(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    return this.v8.contains(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
  }
  
  protected V8Value createTwin()
  {
    return new V8Object(this.v8);
  }
  
  public V8Array executeArrayFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      paramString = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 5, this.objectHandle, paramString, l);
      if (!(paramString instanceof V8Array)) {
        break;
      }
      return (V8Array)paramString;
    }
    throw new V8ResultUndefined();
  }
  
  public boolean executeBooleanFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle()) {
      return this.v8.executeBooleanFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
    }
  }
  
  public double executeDoubleFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle()) {
      return this.v8.executeDoubleFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
    }
  }
  
  public Object executeFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle()) {
      return this.v8.executeFunction(this.v8.getV8RuntimePtr(), 0, this.objectHandle, paramString, l);
    }
  }
  
  public int executeIntegerFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle()) {
      return this.v8.executeIntegerFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
    }
  }
  
  public Object executeJSFunction(String paramString)
  {
    return executeFunction(paramString, null);
  }
  
  public Object executeJSFunction(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return executeFunction(paramString, null);
    }
    V8Array localV8Array = new V8Array(this.v8.getRuntime());
    for (;;)
    {
      int i;
      Object localObject;
      try
      {
        int j = paramVarArgs.length;
        i = 0;
        if (i >= j) {
          break label255;
        }
        localObject = paramVarArgs[i];
        if (localObject == null) {
          localV8Array.pushNull();
        } else if ((localObject instanceof V8Value)) {
          localV8Array.push((V8Value)localObject);
        }
      }
      finally
      {
        localV8Array.release();
      }
      if ((localObject instanceof Integer))
      {
        localV8Array.push((Integer)localObject);
      }
      else if ((localObject instanceof Double))
      {
        localV8Array.push((Double)localObject);
      }
      else if ((localObject instanceof Long))
      {
        localV8Array.push(((Long)localObject).doubleValue());
      }
      else if ((localObject instanceof Float))
      {
        localV8Array.push(((Float)localObject).floatValue());
      }
      else if ((localObject instanceof Boolean))
      {
        localV8Array.push((Boolean)localObject);
      }
      else if ((localObject instanceof String))
      {
        localV8Array.push((String)localObject);
      }
      else
      {
        throw new IllegalArgumentException("Unsupported Object of type: " + localObject.getClass());
        label255:
        paramString = executeFunction(paramString, localV8Array);
        localV8Array.release();
        return paramString;
      }
      i += 1;
    }
  }
  
  public V8Object executeObjectFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      paramString = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramString, l);
      if (!(paramString instanceof V8Object)) {
        break;
      }
      return (V8Object)paramString;
    }
    throw new V8ResultUndefined();
  }
  
  public String executeStringFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle()) {
      return this.v8.executeStringFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
    }
  }
  
  public void executeVoidFunction(String paramString, V8Array paramV8Array)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      this.v8.executeVoidFunction(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, l);
      return;
    }
  }
  
  public Object get(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    return this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramString);
  }
  
  public V8Array getArray(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    paramString = this.v8.get(this.v8.getV8RuntimePtr(), 5, this.objectHandle, paramString);
    if ((paramString == null) || ((paramString instanceof V8Array))) {
      return (V8Array)paramString;
    }
    throw new V8ResultUndefined();
  }
  
  public boolean getBoolean(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    return this.v8.getBoolean(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
  }
  
  public double getDouble(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    return this.v8.getDouble(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
  }
  
  public int getInteger(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    return this.v8.getInteger(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
  }
  
  public String[] getKeys()
  {
    this.v8.checkThread();
    checkReleased();
    return this.v8.getKeys(this.v8.getV8RuntimePtr(), this.objectHandle);
  }
  
  public V8Object getObject(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    paramString = this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramString);
    if ((paramString == null) || ((paramString instanceof V8Object))) {
      return (V8Object)paramString;
    }
    throw new V8ResultUndefined();
  }
  
  public String getString(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    return this.v8.getString(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
  }
  
  public int getType(String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    return this.v8.getType(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
  }
  
  public V8Object registerJavaMethod(JavaCallback paramJavaCallback, String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.registerCallback(paramJavaCallback, getHandle(), paramString);
    return this;
  }
  
  public V8Object registerJavaMethod(JavaVoidCallback paramJavaVoidCallback, String paramString)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.registerVoidCallback(paramJavaVoidCallback, getHandle(), paramString);
    return this;
  }
  
  public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
  {
    return registerJavaMethod(paramObject, paramString1, paramString2, paramArrayOfClass, false);
  }
  
  public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean)
  {
    this.v8.checkThread();
    checkReleased();
    try
    {
      paramString1 = paramObject.getClass().getMethod(paramString1, paramArrayOfClass);
      paramString1.setAccessible(true);
      this.v8.registerCallback(paramObject, paramString1, getHandle(), paramString2, paramBoolean);
      return this;
    }
    catch (NoSuchMethodException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
    catch (SecurityException paramObject)
    {
      throw new IllegalStateException(paramObject);
    }
  }
  
  public V8Object setPrototype(V8Object paramV8Object)
  {
    this.v8.checkThread();
    checkReleased();
    this.v8.setPrototype(this.v8.getV8RuntimePtr(), this.objectHandle, paramV8Object.getHandle());
    return this;
  }
  
  public String toString()
  {
    if ((isReleased()) || (this.v8.isReleased())) {
      return "[Object released]";
    }
    this.v8.checkThread();
    return this.v8.toString(this.v8.getV8RuntimePtr(), getHandle());
  }
  
  public V8Object twin()
  {
    return (V8Object)super.twin();
  }
  
  static class Undefined
    extends V8Object
  {
    public V8Object add(String paramString, double paramDouble)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object add(String paramString, int paramInt)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object add(String paramString, V8Value paramV8Value)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object add(String paramString1, String paramString2)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object add(String paramString, boolean paramBoolean)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object addUndefined(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean contains(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean equals(Object paramObject)
    {
      return ((paramObject instanceof V8Object)) && (((V8Object)paramObject).isUndefined());
    }
    
    public V8Array executeArrayFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean executeBooleanFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public double executeDoubleFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object executeFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public int executeIntegerFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public Object executeJSFunction(String paramString, Object... paramVarArgs)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object executeObjectFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public String executeStringFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public void executeVoidFunction(String paramString, V8Array paramV8Array)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Array getArray(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean getBoolean(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public double getDouble(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public int getInteger(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public String[] getKeys()
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object getObject(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8 getRuntime()
    {
      throw new UnsupportedOperationException();
    }
    
    public String getString(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public int getType(String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public int hashCode()
    {
      return 919;
    }
    
    public boolean isReleased()
    {
      return false;
    }
    
    public boolean isUndefined()
    {
      return true;
    }
    
    public V8Object registerJavaMethod(JavaCallback paramJavaCallback, String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object registerJavaMethod(JavaVoidCallback paramJavaVoidCallback, String paramString)
    {
      throw new UnsupportedOperationException();
    }
    
    public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean)
    {
      throw new UnsupportedOperationException();
    }
    
    public void release() {}
    
    public V8Object setPrototype(V8Object paramV8Object)
    {
      throw new UnsupportedOperationException();
    }
    
    public String toString()
    {
      return "undefined";
    }
    
    public Undefined twin()
    {
      return (Undefined)super.twin();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.V8Object
 * JD-Core Version:    0.7.0.1
 */