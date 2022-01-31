package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Function
  extends V8Object
{
  protected V8Function(V8 paramV8)
  {
    this(paramV8, null);
  }
  
  public V8Function(V8 paramV8, JavaCallback paramJavaCallback)
  {
    super(paramV8, paramJavaCallback);
  }
  
  public Object call(V8Object paramV8Object, V8Array paramV8Array)
  {
    AppMethodBeat.i(75495);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Object);
    this.v8.checkRuntime(paramV8Array);
    long l1;
    if (paramV8Object != null)
    {
      if (paramV8Array != null) {
        break label95;
      }
      l1 = 0L;
      label42:
      if (!paramV8Object.isUndefined()) {
        break label103;
      }
    }
    label95:
    label103:
    for (long l2 = this.v8.getHandle();; l2 = paramV8Object.getHandle())
    {
      paramV8Object = this.v8.executeFunction(this.v8.getV8RuntimePtr(), l2, this.objectHandle, l1);
      AppMethodBeat.o(75495);
      return paramV8Object;
      paramV8Object = this.v8;
      break;
      l1 = paramV8Array.getHandle();
      break label42;
    }
  }
  
  protected V8Value createTwin()
  {
    AppMethodBeat.i(75491);
    V8Function localV8Function = new V8Function(this.v8);
    AppMethodBeat.o(75491);
    return localV8Function;
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(75493);
    if (paramObject == null)
    {
      super.initialize(paramLong, null);
      AppMethodBeat.o(75493);
      return;
    }
    paramObject = (JavaCallback)paramObject;
    long[] arrayOfLong = this.v8.initNewV8Function(paramLong);
    this.v8.createAndRegisterMethodDescriptor(paramObject, arrayOfLong[1]);
    this.released = false;
    addObjectReference(arrayOfLong[0]);
    AppMethodBeat.o(75493);
  }
  
  public String toString()
  {
    AppMethodBeat.i(75492);
    if ((this.released) || (this.v8.isReleased()))
    {
      AppMethodBeat.o(75492);
      return "[Function released]";
    }
    String str = super.toString();
    AppMethodBeat.o(75492);
    return str;
  }
  
  public V8Function twin()
  {
    AppMethodBeat.i(75494);
    V8Function localV8Function = (V8Function)super.twin();
    AppMethodBeat.o(75494);
    return localV8Function;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.eclipsesource.v8.V8Function
 * JD-Core Version:    0.7.0.1
 */