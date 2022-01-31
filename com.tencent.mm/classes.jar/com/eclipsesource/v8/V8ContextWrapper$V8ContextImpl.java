package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

final class V8ContextWrapper$V8ContextImpl
  extends V8Object
  implements V8Context
{
  private final long ptr;
  
  V8ContextWrapper$V8ContextImpl(V8ContextWrapper paramV8ContextWrapper, long paramLong)
  {
    super(V8ContextWrapper.access$000(paramV8ContextWrapper).getV8());
    AppMethodBeat.i(75450);
    this.objectHandle = this.v8.getGlobalObject();
    this.ptr = paramLong;
    AppMethodBeat.o(75450);
  }
  
  private void shareObjectImpl(String paramString1, V8Context paramV8Context, String paramString2)
  {
    AppMethodBeat.i(75486);
    checkReleased();
    this.v8.checkThread();
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(75486);
      return;
    }
    if (paramV8Context == null)
    {
      AppMethodBeat.o(75486);
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
    AppMethodBeat.o(75486);
  }
  
  public final V8Array executeArrayScript(String paramString)
  {
    AppMethodBeat.i(75466);
    paramString = this.v8.executeArrayScript(paramString);
    AppMethodBeat.o(75466);
    return paramString;
  }
  
  public final V8Array executeArrayScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75467);
    paramString1 = this.v8.executeArrayScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75467);
    return paramString1;
  }
  
  public final V8Array executeArrayScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75468);
    paramString1 = this.v8.executeArrayScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75468);
    return paramString1;
  }
  
  public final boolean executeBooleanScript(String paramString)
  {
    AppMethodBeat.i(75463);
    boolean bool = this.v8.executeBooleanScript(paramString);
    AppMethodBeat.o(75463);
    return bool;
  }
  
  public final boolean executeBooleanScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75464);
    boolean bool = this.v8.executeBooleanScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75464);
    return bool;
  }
  
  public final boolean executeBooleanScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75465);
    boolean bool = this.v8.executeBooleanScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75465);
    return bool;
  }
  
  public final String executeDebugScript(String paramString1, String paramString2)
  {
    AppMethodBeat.i(75484);
    paramString1 = this.v8.executeDebugScript(paramString1, paramString2);
    AppMethodBeat.o(75484);
    return paramString1;
  }
  
  public final double executeDoubleScript(String paramString)
  {
    AppMethodBeat.i(75457);
    double d = this.v8.executeDoubleScript(paramString);
    AppMethodBeat.o(75457);
    return d;
  }
  
  public final double executeDoubleScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75458);
    double d = this.v8.executeDoubleScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75458);
    return d;
  }
  
  public final double executeDoubleScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75459);
    double d = this.v8.executeDoubleScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75459);
    return d;
  }
  
  public final int executeIntegerScript(String paramString)
  {
    AppMethodBeat.i(75454);
    int i = this.v8.executeIntegerScript(paramString);
    AppMethodBeat.o(75454);
    return i;
  }
  
  public final int executeIntegerScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75455);
    paramInt = this.v8.executeIntegerScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75455);
    return paramInt;
  }
  
  public final int executeIntegerScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75456);
    paramInt = this.v8.executeIntegerScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75456);
    return paramInt;
  }
  
  public final V8Object executeObjectScript(String paramString)
  {
    AppMethodBeat.i(75472);
    paramString = this.v8.executeObjectScript(paramString);
    AppMethodBeat.o(75472);
    return paramString;
  }
  
  public final V8Object executeObjectScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75473);
    paramString1 = this.v8.executeObjectScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75473);
    return paramString1;
  }
  
  public final V8Object executeObjectScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75474);
    paramString1 = this.v8.executeObjectScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75474);
    return paramString1;
  }
  
  public final Object executeScript(String paramString)
  {
    AppMethodBeat.i(75469);
    paramString = this.v8.executeScript(paramString);
    AppMethodBeat.o(75469);
    return paramString;
  }
  
  public final Object executeScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75470);
    paramString1 = this.v8.executeScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75470);
    return paramString1;
  }
  
  public final Object executeScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75471);
    paramString1 = this.v8.executeScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75471);
    return paramString1;
  }
  
  public final String executeStringScript(String paramString)
  {
    AppMethodBeat.i(75460);
    paramString = this.v8.executeStringScript(paramString);
    AppMethodBeat.o(75460);
    return paramString;
  }
  
  public final String executeStringScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75461);
    paramString1 = this.v8.executeStringScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75461);
    return paramString1;
  }
  
  public final String executeStringScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75462);
    paramString1 = this.v8.executeStringScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75462);
    return paramString1;
  }
  
  public final void executeVoidScript(String paramString)
  {
    AppMethodBeat.i(75451);
    this.v8.executeVoidScript(paramString);
    AppMethodBeat.o(75451);
  }
  
  public final void executeVoidScript(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(75452);
    this.v8.executeVoidScript(paramString1, paramString2, paramInt);
    AppMethodBeat.o(75452);
  }
  
  public final void executeVoidScript(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    AppMethodBeat.i(75453);
    this.v8.executeVoidScript(paramString1, paramString2, paramInt, paramString3, paramString4);
    AppMethodBeat.o(75453);
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
    AppMethodBeat.i(75481);
    paramByteBuffer = new SharedV8ArrayBuffer(this.v8, paramByteBuffer);
    AppMethodBeat.o(75481);
    return paramByteBuffer;
  }
  
  public final V8Array newV8Array()
  {
    AppMethodBeat.i(75478);
    V8Array localV8Array = new V8Array(this.v8);
    AppMethodBeat.o(75478);
    return localV8Array;
  }
  
  public final V8ArrayBuffer newV8ArrayBuffer(int paramInt)
  {
    AppMethodBeat.i(75479);
    V8ArrayBuffer localV8ArrayBuffer = new V8ArrayBuffer(this.v8, paramInt);
    AppMethodBeat.o(75479);
    return localV8ArrayBuffer;
  }
  
  public final V8ArrayBuffer newV8ArrayBuffer(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(75480);
    paramByteBuffer = new V8ArrayBuffer(this.v8, paramByteBuffer);
    AppMethodBeat.o(75480);
    return paramByteBuffer;
  }
  
  public final V8Function newV8Function(JavaCallback paramJavaCallback)
  {
    AppMethodBeat.i(75482);
    paramJavaCallback = new V8Function(this.v8, paramJavaCallback);
    AppMethodBeat.o(75482);
    return paramJavaCallback;
  }
  
  public final V8Object newV8Object()
  {
    AppMethodBeat.i(75477);
    V8Object localV8Object = new V8Object(this.v8);
    AppMethodBeat.o(75477);
    return localV8Object;
  }
  
  public final V8TypedArray newV8TypedArray(V8ArrayBuffer paramV8ArrayBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(75483);
    paramV8ArrayBuffer = new V8TypedArray(this.v8, paramV8ArrayBuffer, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(75483);
    return paramV8ArrayBuffer;
  }
  
  public final void release()
  {
    AppMethodBeat.i(75485);
    if (isReleased())
    {
      AppMethodBeat.o(75485);
      return;
    }
    this.v8.releaseObjRef(this);
    V8ContextWrapper.access$000(this.this$0).releaseContext(this.this$0);
    this.released = true;
    AppMethodBeat.o(75485);
  }
  
  public final void shareObject(String paramString, V8Context paramV8Context)
  {
    AppMethodBeat.i(75475);
    shareObjectImpl(paramString, paramV8Context, null);
    AppMethodBeat.o(75475);
  }
  
  public final void shareObject(String paramString1, V8Context paramV8Context, String paramString2)
  {
    AppMethodBeat.i(75476);
    shareObjectImpl(paramString1, paramV8Context, paramString2);
    AppMethodBeat.o(75476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.eclipsesource.v8.V8ContextWrapper.V8ContextImpl
 * JD-Core Version:    0.7.0.1
 */