package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Array
  extends V8Object
{
  protected V8Array() {}
  
  public V8Array(V8 paramV8)
  {
    super(paramV8);
    AppMethodBeat.i(75404);
    paramV8.checkThread();
    AppMethodBeat.o(75404);
  }
  
  protected V8Array(V8 paramV8, Object paramObject)
  {
    super(paramV8, paramObject);
  }
  
  protected V8Value createTwin()
  {
    AppMethodBeat.i(75405);
    V8Array localV8Array = new V8Array(this.v8);
    AppMethodBeat.o(75405);
    return localV8Array;
  }
  
  public Object get(int paramInt)
  {
    AppMethodBeat.i(75428);
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramInt);
    AppMethodBeat.o(75428);
    return localObject;
  }
  
  public V8Array getArray(int paramInt)
  {
    AppMethodBeat.i(75429);
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 5, this.objectHandle, paramInt);
    if ((localObject == null) || ((localObject instanceof V8Array)))
    {
      localObject = (V8Array)localObject;
      AppMethodBeat.o(75429);
      return localObject;
    }
    localObject = new V8ResultUndefined();
    AppMethodBeat.o(75429);
    throw ((Throwable)localObject);
  }
  
  public boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(75414);
    this.v8.checkThread();
    checkReleased();
    boolean bool = this.v8.arrayGetBoolean(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(75414);
    return bool;
  }
  
  public int getBooleans(int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(75424);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfBoolean.length)
    {
      paramArrayOfBoolean = new IndexOutOfBoundsException();
      AppMethodBeat.o(75424);
      throw paramArrayOfBoolean;
    }
    paramInt1 = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfBoolean);
    AppMethodBeat.o(75424);
    return paramInt1;
  }
  
  public boolean[] getBooleans(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75422);
    this.v8.checkThread();
    checkReleased();
    boolean[] arrayOfBoolean = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(75422);
    return arrayOfBoolean;
  }
  
  public byte getByte(int paramInt)
  {
    AppMethodBeat.i(75415);
    this.v8.checkThread();
    checkReleased();
    byte b = this.v8.arrayGetByte(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(75415);
    return b;
  }
  
  public int getBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(75425);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfByte.length)
    {
      paramArrayOfByte = new IndexOutOfBoundsException();
      AppMethodBeat.o(75425);
      throw paramArrayOfByte;
    }
    paramInt1 = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.o(75425);
    return paramInt1;
  }
  
  public byte[] getBytes(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75423);
    this.v8.checkThread();
    checkReleased();
    byte[] arrayOfByte = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(75423);
    return arrayOfByte;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(75416);
    this.v8.checkThread();
    checkReleased();
    double d = this.v8.arrayGetDouble(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(75416);
    return d;
  }
  
  public int getDoubles(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(75421);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfDouble.length)
    {
      paramArrayOfDouble = new IndexOutOfBoundsException();
      AppMethodBeat.o(75421);
      throw paramArrayOfDouble;
    }
    paramInt1 = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfDouble);
    AppMethodBeat.o(75421);
    return paramInt1;
  }
  
  public double[] getDoubles(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75420);
    this.v8.checkThread();
    checkReleased();
    double[] arrayOfDouble = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(75420);
    return arrayOfDouble;
  }
  
  public int getInteger(int paramInt)
  {
    AppMethodBeat.i(75413);
    this.v8.checkThread();
    checkReleased();
    paramInt = this.v8.arrayGetInteger(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(75413);
    return paramInt;
  }
  
  public int getIntegers(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(75419);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfInt.length)
    {
      paramArrayOfInt = new IndexOutOfBoundsException();
      AppMethodBeat.o(75419);
      throw paramArrayOfInt;
    }
    paramInt1 = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(75419);
    return paramInt1;
  }
  
  public int[] getIntegers(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75418);
    this.v8.checkThread();
    checkReleased();
    int[] arrayOfInt = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(75418);
    return arrayOfInt;
  }
  
  public V8Object getObject(int paramInt)
  {
    AppMethodBeat.i(75430);
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramInt);
    if ((localObject == null) || ((localObject instanceof V8Object)))
    {
      localObject = (V8Object)localObject;
      AppMethodBeat.o(75430);
      return localObject;
    }
    localObject = new V8ResultUndefined();
    AppMethodBeat.o(75430);
    throw ((Throwable)localObject);
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(75417);
    this.v8.checkThread();
    checkReleased();
    String str = this.v8.arrayGetString(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(75417);
    return str;
  }
  
  public int getStrings(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(75427);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfString.length)
    {
      paramArrayOfString = new IndexOutOfBoundsException();
      AppMethodBeat.o(75427);
      throw paramArrayOfString;
    }
    paramInt1 = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfString);
    AppMethodBeat.o(75427);
    return paramInt1;
  }
  
  public String[] getStrings(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75426);
    this.v8.checkThread();
    checkReleased();
    String[] arrayOfString = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(75426);
    return arrayOfString;
  }
  
  public int getType()
  {
    AppMethodBeat.i(75411);
    this.v8.checkThread();
    checkReleased();
    int i = this.v8.getArrayType(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(75411);
    return i;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(75410);
    this.v8.checkThread();
    checkReleased();
    paramInt = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(75410);
    return paramInt;
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(75412);
    this.v8.checkThread();
    checkReleased();
    paramInt1 = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(75412);
    return paramInt1;
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(75408);
    paramLong = this.v8.initNewV8Array(paramLong);
    this.released = false;
    addObjectReference(paramLong);
    AppMethodBeat.o(75408);
  }
  
  public int length()
  {
    AppMethodBeat.i(75409);
    this.v8.checkThread();
    checkReleased();
    int i = this.v8.arrayGetSize(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(75409);
    return i;
  }
  
  public V8Array push(double paramDouble)
  {
    AppMethodBeat.i(75433);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), paramDouble);
    AppMethodBeat.o(75433);
    return this;
  }
  
  public V8Array push(int paramInt)
  {
    AppMethodBeat.i(75431);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(75431);
    return this;
  }
  
  public V8Array push(V8Value paramV8Value)
  {
    AppMethodBeat.i(75435);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Value);
    if (paramV8Value == null) {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    }
    for (;;)
    {
      AppMethodBeat.o(75435);
      return this;
      if (paramV8Value.equals(V8.getUndefined())) {
        this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
      } else {
        this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), paramV8Value.getHandle());
      }
    }
  }
  
  public V8Array push(Object paramObject)
  {
    AppMethodBeat.i(75436);
    this.v8.checkThread();
    checkReleased();
    if ((paramObject instanceof V8Value)) {
      this.v8.checkRuntime((V8Value)paramObject);
    }
    if (paramObject == null) {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    }
    for (;;)
    {
      AppMethodBeat.o(75436);
      return this;
      if (paramObject.equals(V8.getUndefined()))
      {
        this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
      }
      else if ((paramObject instanceof Double))
      {
        this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Double)paramObject).doubleValue());
      }
      else if ((paramObject instanceof Integer))
      {
        this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), ((Integer)paramObject).intValue());
      }
      else if ((paramObject instanceof Float))
      {
        this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Float)paramObject).doubleValue());
      }
      else if ((paramObject instanceof Number))
      {
        this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Number)paramObject).doubleValue());
      }
      else if ((paramObject instanceof Boolean))
      {
        this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), ((Boolean)paramObject).booleanValue());
      }
      else if ((paramObject instanceof String))
      {
        this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), (String)paramObject);
      }
      else
      {
        if (!(paramObject instanceof V8Value)) {
          break;
        }
        this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value)paramObject).getHandle());
      }
    }
    paramObject = new IllegalArgumentException();
    AppMethodBeat.o(75436);
    throw paramObject;
  }
  
  public V8Array push(String paramString)
  {
    AppMethodBeat.i(75434);
    this.v8.checkThread();
    checkReleased();
    if (paramString == null) {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    }
    for (;;)
    {
      AppMethodBeat.o(75434);
      return this;
      if (paramString.equals(V8.getUndefined())) {
        this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
      } else {
        this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), paramString);
      }
    }
  }
  
  public V8Array push(boolean paramBoolean)
  {
    AppMethodBeat.i(75432);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), paramBoolean);
    AppMethodBeat.o(75432);
    return this;
  }
  
  public V8Array pushNull()
  {
    AppMethodBeat.i(75437);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(75437);
    return this;
  }
  
  public V8Array pushUndefined()
  {
    AppMethodBeat.i(75438);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(75438);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(75407);
    if ((this.released) || (this.v8.isReleased()))
    {
      AppMethodBeat.o(75407);
      return "[Array released]";
    }
    String str = super.toString();
    AppMethodBeat.o(75407);
    return str;
  }
  
  public V8Array twin()
  {
    AppMethodBeat.i(75406);
    V8Array localV8Array = (V8Array)super.twin();
    AppMethodBeat.o(75406);
    return localV8Array;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.V8Array
 * JD-Core Version:    0.7.0.1
 */