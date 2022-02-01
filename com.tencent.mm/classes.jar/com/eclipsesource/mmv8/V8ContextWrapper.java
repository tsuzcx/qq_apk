package com.eclipsesource.mmv8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.ByteBuffer;
import java.util.ArrayList;

class V8ContextWrapper
  implements InvocationHandler
{
  private static final String TAG = "V8ContextWrapper";
  private final MultiContextV8 multiContextV8;
  private final V8Context proxy;
  private final V8ContextImpl v8ContextImpl;
  private final long v8ContextPtr;
  
  V8ContextWrapper(MultiContextV8 paramMultiContextV8, long paramLong)
  {
    AppMethodBeat.i(62112);
    this.multiContextV8 = paramMultiContextV8;
    this.v8ContextPtr = paramLong;
    enterContext();
    this.v8ContextImpl = new V8ContextImpl(paramLong);
    this.proxy = ((V8Context)Proxy.newProxyInstance(V8ContextWrapper.class.getClassLoader(), new Class[] { V8Context.class }, this));
    AppMethodBeat.o(62112);
  }
  
  private void enterContext()
  {
    AppMethodBeat.i(62113);
    this.multiContextV8.enterContext(this);
    AppMethodBeat.o(62113);
  }
  
  public V8Context context()
  {
    return this.proxy;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(62114);
    if (this == paramObject)
    {
      AppMethodBeat.o(62114);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(62114);
      return false;
    }
    paramObject = (V8ContextWrapper)paramObject;
    if (this.v8ContextPtr == paramObject.v8ContextPtr)
    {
      AppMethodBeat.o(62114);
      return true;
    }
    AppMethodBeat.o(62114);
    return false;
  }
  
  protected long getPtr()
  {
    return this.v8ContextPtr;
  }
  
  public int hashCode()
  {
    return (int)(this.v8ContextPtr ^ this.v8ContextPtr >>> 32);
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(62115);
    if (!paramMethod.getName().equals("isReleased"))
    {
      this.v8ContextImpl.checkReleased();
      enterContext();
    }
    try
    {
      paramObject = paramMethod.invoke(this.v8ContextImpl, paramArrayOfObject);
      AppMethodBeat.o(62115);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = paramObject.getCause();
      AppMethodBeat.o(62115);
      throw paramObject;
    }
  }
  
  final class V8ContextImpl
    extends V8Object
    implements V8Context
  {
    private final long ptr;
    
    V8ContextImpl(long paramLong)
    {
      super();
      AppMethodBeat.i(62075);
      this.objectHandle = this.v8.getGlobalObject();
      this.ptr = paramLong;
      AppMethodBeat.o(62075);
    }
    
    private void shareObjectImpl(String paramString1, V8Context paramV8Context, String paramString2)
    {
      AppMethodBeat.i(62111);
      checkReleased();
      this.v8.checkThread();
      if ((paramString1 == null) || (paramString1.isEmpty()))
      {
        AppMethodBeat.o(62111);
        return;
      }
      if (paramV8Context == null)
      {
        AppMethodBeat.o(62111);
        return;
      }
      V8Object localV8Object = getObject(paramString1);
      String str;
      if (paramString2 != null)
      {
        str = paramString2;
        if (!paramString2.isEmpty()) {}
      }
      else
      {
        str = paramString1;
      }
      paramV8Context.add(str, localV8Object);
      localV8Object.release();
      AppMethodBeat.o(62111);
    }
    
    public final V8Array executeArrayScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62091);
      paramString = this.v8.executeArrayScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62091);
      return paramString;
    }
    
    public final V8Array executeArrayScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62092);
      paramString1 = this.v8.executeArrayScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62092);
      return paramString1;
    }
    
    public final V8Array executeArrayScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62093);
      paramString1 = this.v8.executeArrayScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62093);
      return paramString1;
    }
    
    public final boolean executeBooleanScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62088);
      boolean bool = this.v8.executeBooleanScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62088);
      return bool;
    }
    
    public final boolean executeBooleanScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62089);
      boolean bool = this.v8.executeBooleanScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62089);
      return bool;
    }
    
    public final boolean executeBooleanScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62090);
      boolean bool = this.v8.executeBooleanScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62090);
      return bool;
    }
    
    public final String executeDebugScript(String paramString1, String paramString2)
    {
      AppMethodBeat.i(62109);
      paramString1 = this.v8.executeDebugScript(paramString1, paramString2);
      AppMethodBeat.o(62109);
      return paramString1;
    }
    
    public final double executeDoubleScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62082);
      double d = this.v8.executeDoubleScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62082);
      return d;
    }
    
    public final double executeDoubleScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62083);
      double d = this.v8.executeDoubleScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62083);
      return d;
    }
    
    public final double executeDoubleScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62084);
      double d = this.v8.executeDoubleScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62084);
      return d;
    }
    
    public final int executeIntegerScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62079);
      int i = this.v8.executeIntegerScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62079);
      return i;
    }
    
    public final int executeIntegerScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62080);
      paramInt = this.v8.executeIntegerScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62080);
      return paramInt;
    }
    
    public final int executeIntegerScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62081);
      paramInt1 = this.v8.executeIntegerScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62081);
      return paramInt1;
    }
    
    public final V8Object executeObjectScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62097);
      paramString = this.v8.executeObjectScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62097);
      return paramString;
    }
    
    public final V8Object executeObjectScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62098);
      paramString1 = this.v8.executeObjectScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62098);
      return paramString1;
    }
    
    public final V8Object executeObjectScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62099);
      paramString1 = this.v8.executeObjectScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62099);
      return paramString1;
    }
    
    public final Object executeScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62094);
      paramString = this.v8.executeScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62094);
      return paramString;
    }
    
    public final Object executeScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62095);
      paramString1 = this.v8.executeScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62095);
      return paramString1;
    }
    
    public final Object executeScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62096);
      paramString1 = this.v8.executeScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62096);
      return paramString1;
    }
    
    public final String executeStringScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62085);
      paramString = this.v8.executeStringScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62085);
      return paramString;
    }
    
    public final String executeStringScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62086);
      paramString1 = this.v8.executeStringScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62086);
      return paramString1;
    }
    
    public final String executeStringScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62087);
      paramString1 = this.v8.executeStringScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62087);
      return paramString1;
    }
    
    public final void executeVoidScript(String paramString, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62076);
      this.v8.executeVoidScript(paramString, null, 0, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62076);
    }
    
    public final void executeVoidScript(String paramString1, String paramString2, int paramInt, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62077);
      this.v8.executeVoidScript(paramString1, paramString2, paramInt, null, null, 0, paramExecuteDetails);
      AppMethodBeat.o(62077);
    }
    
    public final void executeVoidScript(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(62078);
      this.v8.executeVoidScript(paramString1, paramString2, paramInt1, paramString3, paramString4, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(62078);
    }
    
    public final Object executeWxaScript(ArrayList<ScriptPartObject> paramArrayList, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, ExecuteDetails paramExecuteDetails)
    {
      AppMethodBeat.i(175414);
      paramArrayList = this.v8.executeWxaScript(paramArrayList, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramExecuteDetails);
      AppMethodBeat.o(175414);
      return paramArrayList;
    }
    
    public final V8Object getGlobalObject()
    {
      return this;
    }
    
    public final long getPtr()
    {
      return this.ptr;
    }
    
    public final SharedV8ArrayBuffer newSharedV8ArrayBuffer(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(62106);
      paramByteBuffer = new SharedV8ArrayBuffer(this.v8, paramByteBuffer);
      AppMethodBeat.o(62106);
      return paramByteBuffer;
    }
    
    public final V8Array newV8Array()
    {
      AppMethodBeat.i(62103);
      V8Array localV8Array = new V8Array(this.v8);
      AppMethodBeat.o(62103);
      return localV8Array;
    }
    
    public final V8ArrayBuffer newV8ArrayBuffer(int paramInt)
    {
      AppMethodBeat.i(62104);
      V8ArrayBuffer localV8ArrayBuffer = new V8ArrayBuffer(this.v8, paramInt);
      AppMethodBeat.o(62104);
      return localV8ArrayBuffer;
    }
    
    public final V8ArrayBuffer newV8ArrayBuffer(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(62105);
      paramByteBuffer = new V8ArrayBuffer(this.v8, paramByteBuffer);
      AppMethodBeat.o(62105);
      return paramByteBuffer;
    }
    
    public final V8Function newV8Function(JavaCallback paramJavaCallback)
    {
      AppMethodBeat.i(62107);
      paramJavaCallback = new V8Function(this.v8, paramJavaCallback);
      AppMethodBeat.o(62107);
      return paramJavaCallback;
    }
    
    public final V8Object newV8Object()
    {
      AppMethodBeat.i(62102);
      V8Object localV8Object = new V8Object(this.v8);
      AppMethodBeat.o(62102);
      return localV8Object;
    }
    
    public final V8TypedArray newV8TypedArray(V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(62108);
      paramV8ArrayBuffer = new V8TypedArray(this.v8, paramV8ArrayBuffer, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(62108);
      return paramV8ArrayBuffer;
    }
    
    public final void release()
    {
      AppMethodBeat.i(62110);
      if (isReleased())
      {
        AppMethodBeat.o(62110);
        return;
      }
      this.v8.releaseObjRef(this);
      V8ContextWrapper.this.multiContextV8.releaseContext(V8ContextWrapper.this);
      this.released = true;
      AppMethodBeat.o(62110);
    }
    
    public final void shareObject(String paramString, V8Context paramV8Context)
    {
      AppMethodBeat.i(62100);
      shareObjectImpl(paramString, paramV8Context, null);
      AppMethodBeat.o(62100);
    }
    
    public final void shareObject(String paramString1, V8Context paramV8Context, String paramString2)
    {
      AppMethodBeat.i(62101);
      shareObjectImpl(paramString1, paramV8Context, paramString2);
      AppMethodBeat.o(62101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.eclipsesource.mmv8.V8ContextWrapper
 * JD-Core Version:    0.7.0.1
 */