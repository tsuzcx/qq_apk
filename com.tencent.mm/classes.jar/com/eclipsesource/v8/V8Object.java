package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(62166);
    if (paramV8 != null)
    {
      this.v8.checkThread();
      initialize(this.v8.getV8RuntimePtr(), paramObject);
    }
    AppMethodBeat.o(62166);
  }
  
  private void checkKey(String paramString)
  {
    AppMethodBeat.i(62202);
    if (paramString == null)
    {
      paramString = new IllegalArgumentException("Key cannot be null");
      AppMethodBeat.o(62202);
      throw paramString;
    }
    AppMethodBeat.o(62202);
  }
  
  public V8Object add(String paramString, double paramDouble)
  {
    AppMethodBeat.i(62191);
    this.v8.checkThread();
    checkReleased();
    this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramDouble);
    AppMethodBeat.o(62191);
    return this;
  }
  
  public V8Object add(String paramString, int paramInt)
  {
    AppMethodBeat.i(62189);
    this.v8.checkThread();
    checkReleased();
    this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramInt);
    AppMethodBeat.o(62189);
    return this;
  }
  
  public V8Object add(String paramString, V8Value paramV8Value)
  {
    AppMethodBeat.i(62193);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Value);
    if (paramV8Value == null) {
      this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    }
    for (;;)
    {
      AppMethodBeat.o(62193);
      return this;
      if (paramV8Value.equals(V8.getUndefined())) {
        this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
      } else {
        this.v8.addObject(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramV8Value.getHandle());
      }
    }
  }
  
  public V8Object add(String paramString1, String paramString2)
  {
    AppMethodBeat.i(62192);
    this.v8.checkThread();
    checkReleased();
    if (paramString2 == null) {
      this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, paramString1);
    }
    for (;;)
    {
      AppMethodBeat.o(62192);
      return this;
      if (paramString2.equals(V8.getUndefined())) {
        this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, paramString1);
      } else {
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString1, paramString2);
      }
    }
  }
  
  public V8Object add(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(62190);
    this.v8.checkThread();
    checkReleased();
    this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, paramBoolean);
    AppMethodBeat.o(62190);
    return this;
  }
  
  public V8Object addNull(String paramString)
  {
    AppMethodBeat.i(62195);
    this.v8.checkThread();
    checkReleased();
    this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62195);
    return this;
  }
  
  public V8Object addUndefined(String paramString)
  {
    AppMethodBeat.i(62194);
    this.v8.checkThread();
    checkReleased();
    this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62194);
    return this;
  }
  
  public boolean contains(String paramString)
  {
    AppMethodBeat.i(62169);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    boolean bool = this.v8.contains(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62169);
    return bool;
  }
  
  protected V8Value createTwin()
  {
    AppMethodBeat.i(62167);
    V8Object localV8Object = new V8Object(this.v8);
    AppMethodBeat.o(62167);
    return localV8Object;
  }
  
  public V8Array executeArrayFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62183);
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
      paramString = (V8Array)paramString;
      AppMethodBeat.o(62183);
      return paramString;
    }
    paramString = new V8ResultUndefined();
    AppMethodBeat.o(62183);
    throw paramString;
  }
  
  public boolean executeBooleanFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62182);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      boolean bool = this.v8.executeBooleanFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
      AppMethodBeat.o(62182);
      return bool;
    }
  }
  
  public double executeDoubleFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62180);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      double d = this.v8.executeDoubleFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
      AppMethodBeat.o(62180);
      return d;
    }
  }
  
  public Object executeFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62185);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      paramString = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 0, this.objectHandle, paramString, l);
      AppMethodBeat.o(62185);
      return paramString;
    }
  }
  
  public int executeIntegerFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62179);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      int i = this.v8.executeIntegerFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
      AppMethodBeat.o(62179);
      return i;
    }
  }
  
  public Object executeJSFunction(String paramString)
  {
    AppMethodBeat.i(62186);
    paramString = executeFunction(paramString, null);
    AppMethodBeat.o(62186);
    return paramString;
  }
  
  public Object executeJSFunction(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(62187);
    if (paramVarArgs == null)
    {
      paramString = executeFunction(paramString, null);
      AppMethodBeat.o(62187);
      return paramString;
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
          break label279;
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
        AppMethodBeat.o(62187);
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
        paramString = new IllegalArgumentException("Unsupported Object of type: " + localObject.getClass());
        AppMethodBeat.o(62187);
        throw paramString;
        label279:
        paramString = executeFunction(paramString, localV8Array);
        localV8Array.release();
        AppMethodBeat.o(62187);
        return paramString;
      }
      i += 1;
    }
  }
  
  public V8Object executeObjectFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62184);
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
      paramString = (V8Object)paramString;
      AppMethodBeat.o(62184);
      return paramString;
    }
    paramString = new V8ResultUndefined();
    AppMethodBeat.o(62184);
    throw paramString;
  }
  
  public String executeStringFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62181);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      paramString = this.v8.executeStringFunction(this.v8.getV8RuntimePtr(), getHandle(), paramString, l);
      AppMethodBeat.o(62181);
      return paramString;
    }
  }
  
  public void executeVoidFunction(String paramString, V8Array paramV8Array)
  {
    AppMethodBeat.i(62188);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Array);
    if (paramV8Array == null) {}
    for (long l = 0L;; l = paramV8Array.getHandle())
    {
      this.v8.executeVoidFunction(this.v8.getV8RuntimePtr(), this.objectHandle, paramString, l);
      AppMethodBeat.o(62188);
      return;
    }
  }
  
  public Object get(String paramString)
  {
    AppMethodBeat.i(62172);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    paramString = this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramString);
    AppMethodBeat.o(62172);
    return paramString;
  }
  
  public V8Array getArray(String paramString)
  {
    AppMethodBeat.i(62177);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    paramString = this.v8.get(this.v8.getV8RuntimePtr(), 5, this.objectHandle, paramString);
    if ((paramString == null) || ((paramString instanceof V8Array)))
    {
      paramString = (V8Array)paramString;
      AppMethodBeat.o(62177);
      return paramString;
    }
    paramString = new V8ResultUndefined();
    AppMethodBeat.o(62177);
    throw paramString;
  }
  
  public boolean getBoolean(String paramString)
  {
    AppMethodBeat.i(62174);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    boolean bool = this.v8.getBoolean(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62174);
    return bool;
  }
  
  public double getDouble(String paramString)
  {
    AppMethodBeat.i(62175);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    double d = this.v8.getDouble(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62175);
    return d;
  }
  
  public int getInteger(String paramString)
  {
    AppMethodBeat.i(62173);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    int i = this.v8.getInteger(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62173);
    return i;
  }
  
  public String[] getKeys()
  {
    AppMethodBeat.i(62170);
    this.v8.checkThread();
    checkReleased();
    String[] arrayOfString = this.v8.getKeys(this.v8.getV8RuntimePtr(), this.objectHandle);
    AppMethodBeat.o(62170);
    return arrayOfString;
  }
  
  public V8Object getObject(String paramString)
  {
    AppMethodBeat.i(62178);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    paramString = this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramString);
    if ((paramString == null) || ((paramString instanceof V8Object)))
    {
      paramString = (V8Object)paramString;
      AppMethodBeat.o(62178);
      return paramString;
    }
    paramString = new V8ResultUndefined();
    AppMethodBeat.o(62178);
    throw paramString;
  }
  
  public String getString(String paramString)
  {
    AppMethodBeat.i(62176);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    paramString = this.v8.getString(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62176);
    return paramString;
  }
  
  public int getType(String paramString)
  {
    AppMethodBeat.i(62171);
    this.v8.checkThread();
    checkReleased();
    checkKey(paramString);
    int i = this.v8.getType(this.v8.getV8RuntimePtr(), this.objectHandle, paramString);
    AppMethodBeat.o(62171);
    return i;
  }
  
  public V8Object registerJavaMethod(JavaCallback paramJavaCallback, String paramString)
  {
    AppMethodBeat.i(62197);
    this.v8.checkThread();
    checkReleased();
    this.v8.registerCallback(paramJavaCallback, getHandle(), paramString);
    AppMethodBeat.o(62197);
    return this;
  }
  
  public V8Object registerJavaMethod(JavaVoidCallback paramJavaVoidCallback, String paramString)
  {
    AppMethodBeat.i(62198);
    this.v8.checkThread();
    checkReleased();
    this.v8.registerVoidCallback(paramJavaVoidCallback, getHandle(), paramString);
    AppMethodBeat.o(62198);
    return this;
  }
  
  public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(62199);
    paramObject = registerJavaMethod(paramObject, paramString1, paramString2, paramArrayOfClass, false);
    AppMethodBeat.o(62199);
    return paramObject;
  }
  
  public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean)
  {
    AppMethodBeat.i(62200);
    this.v8.checkThread();
    checkReleased();
    try
    {
      paramString1 = paramObject.getClass().getMethod(paramString1, paramArrayOfClass);
      paramString1.setAccessible(true);
      this.v8.registerCallback(paramObject, paramString1, getHandle(), paramString2, paramBoolean);
      AppMethodBeat.o(62200);
      return this;
    }
    catch (NoSuchMethodException paramObject)
    {
      paramObject = new IllegalStateException(paramObject);
      AppMethodBeat.o(62200);
      throw paramObject;
    }
    catch (SecurityException paramObject)
    {
      paramObject = new IllegalStateException(paramObject);
      AppMethodBeat.o(62200);
      throw paramObject;
    }
  }
  
  public V8Object setPrototype(V8Object paramV8Object)
  {
    AppMethodBeat.i(62196);
    this.v8.checkThread();
    checkReleased();
    this.v8.setPrototype(this.v8.getV8RuntimePtr(), this.objectHandle, paramV8Object.getHandle());
    AppMethodBeat.o(62196);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(62201);
    if ((isReleased()) || (this.v8.isReleased()))
    {
      AppMethodBeat.o(62201);
      return "[Object released]";
    }
    this.v8.checkThread();
    String str = this.v8.toString(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(62201);
    return str;
  }
  
  public V8Object twin()
  {
    AppMethodBeat.i(62168);
    V8Object localV8Object = (V8Object)super.twin();
    AppMethodBeat.o(62168);
    return localV8Object;
  }
  
  static class Undefined
    extends V8Object
  {
    public V8Object add(String paramString, double paramDouble)
    {
      AppMethodBeat.i(62137);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62137);
      throw paramString;
    }
    
    public V8Object add(String paramString, int paramInt)
    {
      AppMethodBeat.i(62138);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62138);
      throw paramString;
    }
    
    public V8Object add(String paramString, V8Value paramV8Value)
    {
      AppMethodBeat.i(62142);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62142);
      throw paramString;
    }
    
    public V8Object add(String paramString1, String paramString2)
    {
      AppMethodBeat.i(62141);
      paramString1 = new UnsupportedOperationException();
      AppMethodBeat.o(62141);
      throw paramString1;
    }
    
    public V8Object add(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(62135);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62135);
      throw paramString;
    }
    
    public V8Object addUndefined(String paramString)
    {
      AppMethodBeat.i(62143);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62143);
      throw paramString;
    }
    
    public boolean contains(String paramString)
    {
      AppMethodBeat.i(62144);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62144);
      throw paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(62134);
      if (((paramObject instanceof V8Object)) && (((V8Object)paramObject).isUndefined()))
      {
        AppMethodBeat.o(62134);
        return true;
      }
      AppMethodBeat.o(62134);
      return false;
    }
    
    public V8Array executeArrayFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62145);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62145);
      throw paramString;
    }
    
    public boolean executeBooleanFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62146);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62146);
      throw paramString;
    }
    
    public double executeDoubleFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62147);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62147);
      throw paramString;
    }
    
    public Object executeFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62140);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62140);
      throw paramString;
    }
    
    public int executeIntegerFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62148);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62148);
      throw paramString;
    }
    
    public Object executeJSFunction(String paramString, Object... paramVarArgs)
    {
      AppMethodBeat.i(62139);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62139);
      throw paramString;
    }
    
    public V8Object executeObjectFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62149);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62149);
      throw paramString;
    }
    
    public String executeStringFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62150);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62150);
      throw paramString;
    }
    
    public void executeVoidFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(62151);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62151);
      throw paramString;
    }
    
    public V8Array getArray(String paramString)
    {
      AppMethodBeat.i(62152);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62152);
      throw paramString;
    }
    
    public boolean getBoolean(String paramString)
    {
      AppMethodBeat.i(62153);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62153);
      throw paramString;
    }
    
    public double getDouble(String paramString)
    {
      AppMethodBeat.i(62154);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62154);
      throw paramString;
    }
    
    public int getInteger(String paramString)
    {
      AppMethodBeat.i(62155);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62155);
      throw paramString;
    }
    
    public String[] getKeys()
    {
      AppMethodBeat.i(62156);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62156);
      throw localUnsupportedOperationException;
    }
    
    public V8Object getObject(String paramString)
    {
      AppMethodBeat.i(62157);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62157);
      throw paramString;
    }
    
    public V8 getRuntime()
    {
      AppMethodBeat.i(62136);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62136);
      throw localUnsupportedOperationException;
    }
    
    public String getString(String paramString)
    {
      AppMethodBeat.i(62158);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62158);
      throw paramString;
    }
    
    public int getType(String paramString)
    {
      AppMethodBeat.i(62159);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62159);
      throw paramString;
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
      AppMethodBeat.i(62160);
      paramJavaCallback = new UnsupportedOperationException();
      AppMethodBeat.o(62160);
      throw paramJavaCallback;
    }
    
    public V8Object registerJavaMethod(JavaVoidCallback paramJavaVoidCallback, String paramString)
    {
      AppMethodBeat.i(62161);
      paramJavaVoidCallback = new UnsupportedOperationException();
      AppMethodBeat.o(62161);
      throw paramJavaVoidCallback;
    }
    
    public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean)
    {
      AppMethodBeat.i(62162);
      paramObject = new UnsupportedOperationException();
      AppMethodBeat.o(62162);
      throw paramObject;
    }
    
    public void release() {}
    
    public V8Object setPrototype(V8Object paramV8Object)
    {
      AppMethodBeat.i(62163);
      paramV8Object = new UnsupportedOperationException();
      AppMethodBeat.o(62163);
      throw paramV8Object;
    }
    
    public String toString()
    {
      return "undefined";
    }
    
    public Undefined twin()
    {
      AppMethodBeat.i(62133);
      Undefined localUndefined = (Undefined)super.twin();
      AppMethodBeat.o(62133);
      return localUndefined;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.V8Object
 * JD-Core Version:    0.7.0.1
 */