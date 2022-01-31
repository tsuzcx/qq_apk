package com.eclipsesource.v8;

import java.nio.ByteBuffer;

final class V8ContextWrapper$V8ContextImpl
  extends V8Object
  implements V8Context
{
  private final long ptr;
  
  V8ContextWrapper$V8ContextImpl(V8ContextWrapper paramV8ContextWrapper, long paramLong)
  {
    super(V8ContextWrapper.access$000(paramV8ContextWrapper).getV8());
    this.objectHandle = this.v8.getGlobalObject();
    this.ptr = paramLong;
  }
  
  private void shareObjectImpl(String paramString1, V8Context paramV8Context, String paramString2)
  {
    checkReleased();
    this.v8.checkThread();
    if ((paramString1 == null) || (paramString1.isEmpty())) {}
    while (paramV8Context == null) {
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
  }
  
  public final V8Array executeArrayScript(String paramString)
  {
    return this.v8.executeArrayScript(paramString);
  }
  
  public final V8Array executeArrayScript(String paramString1, String paramString2, int paramInt)
  {
    return this.v8.executeArrayScript(paramString1, paramString2, paramInt);
  }
  
  public final boolean executeBooleanScript(String paramString)
  {
    return this.v8.executeBooleanScript(paramString);
  }
  
  public final boolean executeBooleanScript(String paramString1, String paramString2, int paramInt)
  {
    return this.v8.executeBooleanScript(paramString1, paramString2, paramInt);
  }
  
  public final double executeDoubleScript(String paramString)
  {
    return this.v8.executeDoubleScript(paramString);
  }
  
  public final double executeDoubleScript(String paramString1, String paramString2, int paramInt)
  {
    return this.v8.executeDoubleScript(paramString1, paramString2, paramInt);
  }
  
  public final int executeIntegerScript(String paramString)
  {
    return this.v8.executeIntegerScript(paramString);
  }
  
  public final int executeIntegerScript(String paramString1, String paramString2, int paramInt)
  {
    return this.v8.executeIntegerScript(paramString1, paramString2, paramInt);
  }
  
  public final V8Object executeObjectScript(String paramString)
  {
    return this.v8.executeObjectScript(paramString);
  }
  
  public final V8Object executeObjectScript(String paramString1, String paramString2, int paramInt)
  {
    return this.v8.executeObjectScript(paramString1, paramString2, paramInt);
  }
  
  public final Object executeScript(String paramString)
  {
    return this.v8.executeScript(paramString);
  }
  
  public final Object executeScript(String paramString1, String paramString2, int paramInt)
  {
    return this.v8.executeScript(paramString1, paramString2, paramInt);
  }
  
  public final String executeStringScript(String paramString)
  {
    return this.v8.executeStringScript(paramString);
  }
  
  public final String executeStringScript(String paramString1, String paramString2, int paramInt)
  {
    return this.v8.executeStringScript(paramString1, paramString2, paramInt);
  }
  
  public final void executeVoidScript(String paramString)
  {
    this.v8.executeVoidScript(paramString);
  }
  
  public final void executeVoidScript(String paramString1, String paramString2, int paramInt)
  {
    this.v8.executeVoidScript(paramString1, paramString2, paramInt);
  }
  
  public final V8Object getGlobalObject()
  {
    return this;
  }
  
  public final long getPtr()
  {
    return this.ptr;
  }
  
  public final V8Array newV8Array()
  {
    return new V8Array(this.v8);
  }
  
  public final V8ArrayBuffer newV8ArrayBuffer(int paramInt)
  {
    return new V8ArrayBuffer(this.v8, paramInt);
  }
  
  public final V8ArrayBuffer newV8ArrayBuffer(ByteBuffer paramByteBuffer)
  {
    return new V8ArrayBuffer(this.v8, paramByteBuffer);
  }
  
  public final V8Function newV8Function(JavaCallback paramJavaCallback)
  {
    return new V8Function(this.v8, paramJavaCallback);
  }
  
  public final V8Object newV8Object()
  {
    return new V8Object(this.v8);
  }
  
  public final V8TypedArray newV8TypedArray(V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    return new V8TypedArray(this.v8, paramV8ArrayBuffer, paramInt1, paramInt2, paramInt3);
  }
  
  public final void release()
  {
    if (isReleased()) {
      return;
    }
    this.v8.releaseObjRef(this);
    V8ContextWrapper.access$000(this.this$0).releaseContext(this.this$0);
    this.released = true;
  }
  
  public final void shareObject(String paramString, V8Context paramV8Context)
  {
    shareObjectImpl(paramString, paramV8Context, null);
  }
  
  public final void shareObject(String paramString1, V8Context paramV8Context, String paramString2)
  {
    shareObjectImpl(paramString1, paramV8Context, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.V8ContextWrapper.V8ContextImpl
 * JD-Core Version:    0.7.0.1
 */