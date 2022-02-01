package com.eclipsesource.v8;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class V8Array
  extends V8Object
{
  protected V8Array() {}
  
  public V8Array(V8 paramV8)
  {
    super(paramV8);
    AppMethodBeat.i(62029);
    paramV8.checkThread();
    AppMethodBeat.o(62029);
  }
  
  protected V8Array(V8 paramV8, Object paramObject)
  {
    super(paramV8, paramObject);
  }
  
  protected V8Value createTwin()
  {
    AppMethodBeat.i(62030);
    V8Array localV8Array = new V8Array(this.v8);
    AppMethodBeat.o(62030);
    return localV8Array;
  }
  
  public Object get(int paramInt)
  {
    AppMethodBeat.i(62053);
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramInt);
    AppMethodBeat.o(62053);
    return localObject;
  }
  
  public V8Array getArray(int paramInt)
  {
    AppMethodBeat.i(62054);
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 5, this.objectHandle, paramInt);
    if ((localObject == null) || ((localObject instanceof V8Array)))
    {
      localObject = (V8Array)localObject;
      AppMethodBeat.o(62054);
      return localObject;
    }
    localObject = new V8ResultUndefined();
    AppMethodBeat.o(62054);
    throw ((Throwable)localObject);
  }
  
  public boolean getBoolean(int paramInt)
  {
    AppMethodBeat.i(62039);
    this.v8.checkThread();
    checkReleased();
    boolean bool = this.v8.arrayGetBoolean(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(62039);
    return bool;
  }
  
  public int getBooleans(int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(62049);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfBoolean.length)
    {
      paramArrayOfBoolean = new IndexOutOfBoundsException();
      AppMethodBeat.o(62049);
      throw paramArrayOfBoolean;
    }
    paramInt1 = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfBoolean);
    AppMethodBeat.o(62049);
    return paramInt1;
  }
  
  public boolean[] getBooleans(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62047);
    this.v8.checkThread();
    checkReleased();
    boolean[] arrayOfBoolean = this.v8.arrayGetBooleans(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(62047);
    return arrayOfBoolean;
  }
  
  public byte getByte(int paramInt)
  {
    AppMethodBeat.i(62040);
    this.v8.checkThread();
    checkReleased();
    byte b = this.v8.arrayGetByte(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(62040);
    return b;
  }
  
  public int getBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(62050);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfByte.length)
    {
      paramArrayOfByte = new IndexOutOfBoundsException();
      AppMethodBeat.o(62050);
      throw paramArrayOfByte;
    }
    paramInt1 = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfByte);
    AppMethodBeat.o(62050);
    return paramInt1;
  }
  
  public byte[] getBytes(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62048);
    this.v8.checkThread();
    checkReleased();
    byte[] arrayOfByte = this.v8.arrayGetBytes(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(62048);
    return arrayOfByte;
  }
  
  public double getDouble(int paramInt)
  {
    AppMethodBeat.i(62041);
    this.v8.checkThread();
    checkReleased();
    double d = this.v8.arrayGetDouble(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(62041);
    return d;
  }
  
  public int getDoubles(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
  {
    AppMethodBeat.i(62046);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfDouble.length)
    {
      paramArrayOfDouble = new IndexOutOfBoundsException();
      AppMethodBeat.o(62046);
      throw paramArrayOfDouble;
    }
    paramInt1 = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfDouble);
    AppMethodBeat.o(62046);
    return paramInt1;
  }
  
  public double[] getDoubles(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62045);
    this.v8.checkThread();
    checkReleased();
    double[] arrayOfDouble = this.v8.arrayGetDoubles(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(62045);
    return arrayOfDouble;
  }
  
  public int getInteger(int paramInt)
  {
    AppMethodBeat.i(62038);
    this.v8.checkThread();
    checkReleased();
    paramInt = this.v8.arrayGetInteger(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(62038);
    return paramInt;
  }
  
  public int getIntegers(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(62044);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfInt.length)
    {
      paramArrayOfInt = new IndexOutOfBoundsException();
      AppMethodBeat.o(62044);
      throw paramArrayOfInt;
    }
    paramInt1 = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfInt);
    AppMethodBeat.o(62044);
    return paramInt1;
  }
  
  public int[] getIntegers(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62043);
    this.v8.checkThread();
    checkReleased();
    int[] arrayOfInt = this.v8.arrayGetIntegers(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(62043);
    return arrayOfInt;
  }
  
  public V8Object getObject(int paramInt)
  {
    AppMethodBeat.i(62055);
    this.v8.checkThread();
    checkReleased();
    Object localObject = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, paramInt);
    if ((localObject == null) || ((localObject instanceof V8Object)))
    {
      localObject = (V8Object)localObject;
      AppMethodBeat.o(62055);
      return localObject;
    }
    localObject = new V8ResultUndefined();
    AppMethodBeat.o(62055);
    throw ((Throwable)localObject);
  }
  
  public String getString(int paramInt)
  {
    AppMethodBeat.i(62042);
    this.v8.checkThread();
    checkReleased();
    String str = this.v8.arrayGetString(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(62042);
    return str;
  }
  
  public int getStrings(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(62052);
    this.v8.checkThread();
    checkReleased();
    if (paramInt2 > paramArrayOfString.length)
    {
      paramArrayOfString = new IndexOutOfBoundsException();
      AppMethodBeat.o(62052);
      throw paramArrayOfString;
    }
    paramInt1 = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2, paramArrayOfString);
    AppMethodBeat.o(62052);
    return paramInt1;
  }
  
  public String[] getStrings(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62051);
    this.v8.checkThread();
    checkReleased();
    String[] arrayOfString = this.v8.arrayGetStrings(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(62051);
    return arrayOfString;
  }
  
  public int getType()
  {
    AppMethodBeat.i(62036);
    this.v8.checkThread();
    checkReleased();
    int i = this.v8.getArrayType(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(62036);
    return i;
  }
  
  public int getType(int paramInt)
  {
    AppMethodBeat.i(62035);
    this.v8.checkThread();
    checkReleased();
    paramInt = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(62035);
    return paramInt;
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(62037);
    this.v8.checkThread();
    checkReleased();
    paramInt1 = this.v8.getType(this.v8.getV8RuntimePtr(), getHandle(), paramInt1, paramInt2);
    AppMethodBeat.o(62037);
    return paramInt1;
  }
  
  protected void initialize(long paramLong, Object paramObject)
  {
    AppMethodBeat.i(62033);
    paramLong = this.v8.initNewV8Array(paramLong);
    this.released = false;
    addObjectReference(paramLong);
    AppMethodBeat.o(62033);
  }
  
  public int length()
  {
    AppMethodBeat.i(62034);
    this.v8.checkThread();
    checkReleased();
    int i = this.v8.arrayGetSize(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(62034);
    return i;
  }
  
  public V8Array push(double paramDouble)
  {
    AppMethodBeat.i(62058);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), paramDouble);
    AppMethodBeat.o(62058);
    return this;
  }
  
  public V8Array push(int paramInt)
  {
    AppMethodBeat.i(62056);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), paramInt);
    AppMethodBeat.o(62056);
    return this;
  }
  
  public V8Array push(V8Value paramV8Value)
  {
    AppMethodBeat.i(62060);
    this.v8.checkThread();
    checkReleased();
    this.v8.checkRuntime(paramV8Value);
    if (paramV8Value == null) {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    }
    for (;;)
    {
      AppMethodBeat.o(62060);
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
    AppMethodBeat.i(62061);
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
      AppMethodBeat.o(62061);
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
    AppMethodBeat.o(62061);
    throw paramObject;
  }
  
  public V8Array push(String paramString)
  {
    AppMethodBeat.i(62059);
    this.v8.checkThread();
    checkReleased();
    if (paramString == null) {
      this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    }
    for (;;)
    {
      AppMethodBeat.o(62059);
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
    AppMethodBeat.i(62057);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), paramBoolean);
    AppMethodBeat.o(62057);
    return this;
  }
  
  public V8Array pushNull()
  {
    AppMethodBeat.i(62062);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(62062);
    return this;
  }
  
  public V8Array pushUndefined()
  {
    AppMethodBeat.i(62063);
    this.v8.checkThread();
    checkReleased();
    this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
    AppMethodBeat.o(62063);
    return this;
  }
  
  public String toString()
  {
    AppMethodBeat.i(62032);
    if ((this.released) || (this.v8.isReleased()))
    {
      AppMethodBeat.o(62032);
      return "[Array released]";
    }
    String str = super.toString();
    AppMethodBeat.o(62032);
    return str;
  }
  
  public V8Array twin()
  {
    AppMethodBeat.i(62031);
    V8Array localV8Array = (V8Array)super.twin();
    AppMethodBeat.o(62031);
    return localV8Array;
  }
  
  static class Undefined
    extends V8Array
  {
    public V8Object add(String paramString, double paramDouble)
    {
      AppMethodBeat.i(61973);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61973);
      throw paramString;
    }
    
    public V8Object add(String paramString, int paramInt)
    {
      AppMethodBeat.i(61974);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61974);
      throw paramString;
    }
    
    public V8Object add(String paramString, V8Value paramV8Value)
    {
      AppMethodBeat.i(61976);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61976);
      throw paramString;
    }
    
    public V8Object add(String paramString1, String paramString2)
    {
      AppMethodBeat.i(61975);
      paramString1 = new UnsupportedOperationException();
      AppMethodBeat.o(61975);
      throw paramString1;
    }
    
    public V8Object add(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(61972);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61972);
      throw paramString;
    }
    
    public V8Object addUndefined(String paramString)
    {
      AppMethodBeat.i(61977);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61977);
      throw paramString;
    }
    
    public boolean contains(String paramString)
    {
      AppMethodBeat.i(61978);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61978);
      throw paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(61970);
      if (((paramObject instanceof V8Object)) && (((V8Object)paramObject).isUndefined()))
      {
        AppMethodBeat.o(61970);
        return true;
      }
      AppMethodBeat.o(61970);
      return false;
    }
    
    public V8Array executeArrayFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(61979);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61979);
      throw paramString;
    }
    
    public boolean executeBooleanFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(61980);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61980);
      throw paramString;
    }
    
    public double executeDoubleFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(61981);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61981);
      throw paramString;
    }
    
    public int executeIntegerFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(61982);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61982);
      throw paramString;
    }
    
    public V8Object executeObjectFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(61983);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61983);
      throw paramString;
    }
    
    public String executeStringFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(61984);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61984);
      throw paramString;
    }
    
    public void executeVoidFunction(String paramString, V8Array paramV8Array)
    {
      AppMethodBeat.i(61985);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61985);
      throw paramString;
    }
    
    public Object get(int paramInt)
    {
      AppMethodBeat.i(61998);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(61998);
      throw localUnsupportedOperationException;
    }
    
    public V8Array getArray(int paramInt)
    {
      AppMethodBeat.i(61999);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(61999);
      throw localUnsupportedOperationException;
    }
    
    public V8Array getArray(String paramString)
    {
      AppMethodBeat.i(61986);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61986);
      throw paramString;
    }
    
    public boolean getBoolean(int paramInt)
    {
      AppMethodBeat.i(62000);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62000);
      throw localUnsupportedOperationException;
    }
    
    public boolean getBoolean(String paramString)
    {
      AppMethodBeat.i(61987);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61987);
      throw paramString;
    }
    
    public int getBooleans(int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
    {
      AppMethodBeat.i(62005);
      paramArrayOfBoolean = new UnsupportedOperationException();
      AppMethodBeat.o(62005);
      throw paramArrayOfBoolean;
    }
    
    public boolean[] getBooleans(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(62001);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62001);
      throw localUnsupportedOperationException;
    }
    
    public byte getByte(int paramInt)
    {
      AppMethodBeat.i(62004);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62004);
      throw localUnsupportedOperationException;
    }
    
    public int getBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(62003);
      paramArrayOfByte = new UnsupportedOperationException();
      AppMethodBeat.o(62003);
      throw paramArrayOfByte;
    }
    
    public byte[] getBytes(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(62002);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62002);
      throw localUnsupportedOperationException;
    }
    
    public double getDouble(int paramInt)
    {
      AppMethodBeat.i(62006);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62006);
      throw localUnsupportedOperationException;
    }
    
    public double getDouble(String paramString)
    {
      AppMethodBeat.i(61988);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61988);
      throw paramString;
    }
    
    public int getDoubles(int paramInt1, int paramInt2, double[] paramArrayOfDouble)
    {
      AppMethodBeat.i(62008);
      paramArrayOfDouble = new UnsupportedOperationException();
      AppMethodBeat.o(62008);
      throw paramArrayOfDouble;
    }
    
    public double[] getDoubles(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(62007);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62007);
      throw localUnsupportedOperationException;
    }
    
    public int getInteger(int paramInt)
    {
      AppMethodBeat.i(62009);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62009);
      throw localUnsupportedOperationException;
    }
    
    public int getInteger(String paramString)
    {
      AppMethodBeat.i(61989);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61989);
      throw paramString;
    }
    
    public int getIntegers(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    {
      AppMethodBeat.i(62011);
      paramArrayOfInt = new UnsupportedOperationException();
      AppMethodBeat.o(62011);
      throw paramArrayOfInt;
    }
    
    public int[] getIntegers(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(62010);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62010);
      throw localUnsupportedOperationException;
    }
    
    public String[] getKeys()
    {
      AppMethodBeat.i(61990);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(61990);
      throw localUnsupportedOperationException;
    }
    
    public V8Object getObject(int paramInt)
    {
      AppMethodBeat.i(62012);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62012);
      throw localUnsupportedOperationException;
    }
    
    public V8Object getObject(String paramString)
    {
      AppMethodBeat.i(61991);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61991);
      throw paramString;
    }
    
    public V8 getRuntime()
    {
      AppMethodBeat.i(61971);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(61971);
      throw localUnsupportedOperationException;
    }
    
    public String getString(int paramInt)
    {
      AppMethodBeat.i(62013);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62013);
      throw localUnsupportedOperationException;
    }
    
    public String getString(String paramString)
    {
      AppMethodBeat.i(61992);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61992);
      throw paramString;
    }
    
    public int getStrings(int paramInt1, int paramInt2, String[] paramArrayOfString)
    {
      AppMethodBeat.i(62015);
      paramArrayOfString = new UnsupportedOperationException();
      AppMethodBeat.o(62015);
      throw paramArrayOfString;
    }
    
    public String[] getStrings(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(62014);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62014);
      throw localUnsupportedOperationException;
    }
    
    public int getType()
    {
      AppMethodBeat.i(62016);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62016);
      throw localUnsupportedOperationException;
    }
    
    public int getType(int paramInt)
    {
      AppMethodBeat.i(62017);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62017);
      throw localUnsupportedOperationException;
    }
    
    public int getType(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(62018);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62018);
      throw localUnsupportedOperationException;
    }
    
    public int getType(String paramString)
    {
      AppMethodBeat.i(61993);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(61993);
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
    
    public int length()
    {
      AppMethodBeat.i(62019);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62019);
      throw localUnsupportedOperationException;
    }
    
    public V8Array push(double paramDouble)
    {
      AppMethodBeat.i(62021);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62021);
      throw localUnsupportedOperationException;
    }
    
    public V8Array push(int paramInt)
    {
      AppMethodBeat.i(62022);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62022);
      throw localUnsupportedOperationException;
    }
    
    public V8Array push(V8Value paramV8Value)
    {
      AppMethodBeat.i(62024);
      paramV8Value = new UnsupportedOperationException();
      AppMethodBeat.o(62024);
      throw paramV8Value;
    }
    
    public V8Array push(String paramString)
    {
      AppMethodBeat.i(62023);
      paramString = new UnsupportedOperationException();
      AppMethodBeat.o(62023);
      throw paramString;
    }
    
    public V8Array push(boolean paramBoolean)
    {
      AppMethodBeat.i(62020);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62020);
      throw localUnsupportedOperationException;
    }
    
    public V8Array pushUndefined()
    {
      AppMethodBeat.i(62025);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(62025);
      throw localUnsupportedOperationException;
    }
    
    public V8Object registerJavaMethod(JavaCallback paramJavaCallback, String paramString)
    {
      AppMethodBeat.i(61994);
      paramJavaCallback = new UnsupportedOperationException();
      AppMethodBeat.o(61994);
      throw paramJavaCallback;
    }
    
    public V8Object registerJavaMethod(JavaVoidCallback paramJavaVoidCallback, String paramString)
    {
      AppMethodBeat.i(61995);
      paramJavaVoidCallback = new UnsupportedOperationException();
      AppMethodBeat.o(61995);
      throw paramJavaVoidCallback;
    }
    
    public V8Object registerJavaMethod(Object paramObject, String paramString1, String paramString2, Class<?>[] paramArrayOfClass, boolean paramBoolean)
    {
      AppMethodBeat.i(61996);
      paramObject = new UnsupportedOperationException();
      AppMethodBeat.o(61996);
      throw paramObject;
    }
    
    public void release() {}
    
    public V8Object setPrototype(V8Object paramV8Object)
    {
      AppMethodBeat.i(61997);
      paramV8Object = new UnsupportedOperationException();
      AppMethodBeat.o(61997);
      throw paramV8Object;
    }
    
    public String toString()
    {
      return "undefined";
    }
    
    public Undefined twin()
    {
      AppMethodBeat.i(61969);
      Undefined localUndefined = (Undefined)super.twin();
      AppMethodBeat.o(61969);
      return localUndefined;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.eclipsesource.v8.V8Array
 * JD-Core Version:    0.7.0.1
 */