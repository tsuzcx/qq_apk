package com.tencent.mobileqq.pb;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class MessageMicro<T extends MessageMicro<T>>
  extends PBPrimitiveField<T>
{
  private FieldMap _fields = null;
  private int cachedSize = -1;
  
  private final FieldMap getFieldMap()
  {
    Object localObject;
    if (this._fields == null) {
      localObject = getClass();
    }
    try
    {
      localObject = ((Class)localObject).getDeclaredField("__fieldMap__");
      ((Field)localObject).setAccessible(true);
      this._fields = ((FieldMap)((Field)localObject).get(this));
      return this._fields;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        localSecurityException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  protected static FieldMap initFieldMap(int[] paramArrayOfInt, String[] paramArrayOfString, Object[] paramArrayOfObject, Class<?> paramClass)
  {
    return new FieldMap(paramArrayOfInt, paramArrayOfString, paramArrayOfObject, paramClass);
  }
  
  public static void main(String[] paramArrayOfString)
    throws Exception
  {}
  
  public void clear(Object paramObject)
  {
    try
    {
      getFieldMap().clear(this);
      setHasFlag(false);
      return;
    }
    catch (IllegalArgumentException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
    catch (IllegalAccessException paramObject)
    {
      for (;;)
      {
        paramObject.printStackTrace();
      }
    }
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeMessageSize(paramInt, this);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, T paramT)
  {
    return CodedOutputStreamMicro.computeMessageSize(paramInt, paramT);
  }
  
  protected void copyFrom(PBField<T> paramPBField)
  {
    MessageMicro localMessageMicro = (MessageMicro)paramPBField;
    try
    {
      getFieldMap().copyFields(this, localMessageMicro);
      setHasFlag(((MessageMicro)paramPBField).has());
      return;
    }
    catch (IllegalArgumentException paramPBField)
    {
      paramPBField.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramPBField)
    {
      paramPBField.printStackTrace();
    }
  }
  
  public T get()
  {
    return this;
  }
  
  public final int getCachedSize()
  {
    return getSerializedSize();
  }
  
  public final int getSerializedSize()
  {
    int i = -1;
    try
    {
      int j = getFieldMap().getSerializedSize(this);
      i = j;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    this.cachedSize = i;
    return i;
  }
  
  public final T mergeFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    FieldMap localFieldMap = getFieldMap();
    setHasFlag(true);
    for (;;)
    {
      int i = paramCodedInputStreamMicro.readTag();
      try
      {
        if (!localFieldMap.readFieldFrom(paramCodedInputStreamMicro, i, this))
        {
          if (i == 0) {
            return this;
          }
          boolean bool = parseUnknownField(paramCodedInputStreamMicro, i);
          if (!bool) {
            return this;
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
      }
    }
  }
  
  public final T mergeFrom(byte[] paramArrayOfByte)
    throws InvalidProtocolBufferMicroException
  {
    return mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final T mergeFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidProtocolBufferMicroException
  {
    try
    {
      paramArrayOfByte = CodedInputStreamMicro.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      mergeFrom(paramArrayOfByte);
      paramArrayOfByte.checkLastTagWas(0);
      return this;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      throw paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
    }
  }
  
  protected boolean parseUnknownField(CodedInputStreamMicro paramCodedInputStreamMicro, int paramInt)
    throws IOException
  {
    return paramCodedInputStreamMicro.skipField(paramInt);
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    paramCodedInputStreamMicro.readMessage(this);
  }
  
  protected T readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
    throws IOException
  {
    try
    {
      MessageMicro localMessageMicro = (MessageMicro)getClass().newInstance();
      paramCodedInputStreamMicro.readMessage(localMessageMicro);
      return localMessageMicro;
    }
    catch (InstantiationException paramCodedInputStreamMicro)
    {
      paramCodedInputStreamMicro.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramCodedInputStreamMicro)
    {
      for (;;)
      {
        paramCodedInputStreamMicro.printStackTrace();
      }
    }
  }
  
  public void set(T paramT)
  {
    set(paramT, true);
  }
  
  public void set(T paramT, boolean paramBoolean)
  {
    copyFrom(paramT);
    setHasFlag(paramBoolean);
    this.cachedSize = -1;
  }
  
  public final void toByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = CodedOutputStreamMicro.newInstance(paramArrayOfByte, paramInt1, paramInt2);
      writeTo(paramArrayOfByte);
      paramArrayOfByte.checkNoSpaceLeft();
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
    }
  }
  
  public final byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[getSerializedSize()];
    toByteArray(arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public final void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro)
    throws IOException
  {
    try
    {
      getFieldMap().writeTo(paramCodedOutputStreamMicro, this);
      return;
    }
    catch (IllegalArgumentException paramCodedOutputStreamMicro)
    {
      paramCodedOutputStreamMicro.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramCodedOutputStreamMicro)
    {
      paramCodedOutputStreamMicro.printStackTrace();
    }
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
    throws IOException
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeMessage(paramInt, this);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, T paramT)
    throws IOException
  {
    paramCodedOutputStreamMicro.writeMessage(paramInt, paramT);
  }
  
  protected static final class FieldMap
  {
    private Object[] defaultValues;
    private Field[] fields;
    private int[] tags;
    
    FieldMap(int[] paramArrayOfInt, String[] paramArrayOfString, Object[] paramArrayOfObject, Class<?> paramClass)
    {
      this.tags = paramArrayOfInt;
      this.defaultValues = paramArrayOfObject;
      this.fields = new Field[paramArrayOfInt.length];
      int i = 0;
      for (;;)
      {
        if (i < paramArrayOfInt.length) {
          try
          {
            this.fields[i] = paramClass.getField(paramArrayOfString[i]);
            i += 1;
          }
          catch (Exception paramArrayOfObject)
          {
            for (;;)
            {
              paramArrayOfObject.printStackTrace();
            }
          }
        }
      }
    }
    
    void clear(MessageMicro<?> paramMessageMicro)
      throws IllegalArgumentException, IllegalAccessException
    {
      int i = 0;
      while (i < this.tags.length)
      {
        ((PBField)this.fields[i].get(paramMessageMicro)).clear(this.defaultValues[i]);
        i += 1;
      }
    }
    
    <U extends MessageMicro<U>> void copyFields(U paramU1, U paramU2)
      throws IllegalArgumentException, IllegalAccessException
    {
      int i = 0;
      while (i < this.tags.length)
      {
        Field localField = this.fields[i];
        ((PBField)localField.get(paramU1)).copyFrom((PBField)localField.get(paramU2));
        i += 1;
      }
    }
    
    Field get(int paramInt)
    {
      paramInt = Arrays.binarySearch(this.tags, paramInt);
      if (paramInt < 0) {
        return null;
      }
      return this.fields[paramInt];
    }
    
    int getSerializedSize(MessageMicro<?> paramMessageMicro)
      throws IllegalArgumentException, IllegalAccessException
    {
      int i = 0;
      int j = 0;
      while (i < this.tags.length)
      {
        int k = WireFormatMicro.getTagFieldNumber(this.tags[i]);
        j += ((PBField)this.fields[i].get(paramMessageMicro)).computeSize(k);
        i += 1;
      }
      return j;
    }
    
    public boolean readFieldFrom(CodedInputStreamMicro paramCodedInputStreamMicro, int paramInt, MessageMicro<?> paramMessageMicro)
      throws IOException, IllegalArgumentException, IllegalAccessException, InstantiationException
    {
      paramInt = Arrays.binarySearch(this.tags, paramInt);
      if (paramInt < 0) {
        return false;
      }
      ((PBField)this.fields[paramInt].get(paramMessageMicro)).readFrom(paramCodedInputStreamMicro);
      return true;
    }
    
    void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, MessageMicro<?> paramMessageMicro)
      throws IllegalArgumentException, IllegalAccessException, IOException
    {
      int i = 0;
      while (i < this.tags.length)
      {
        int j = WireFormatMicro.getTagFieldNumber(this.tags[i]);
        ((PBField)this.fields[i].get(paramMessageMicro)).writeTo(paramCodedOutputStreamMicro, j);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pb.MessageMicro
 * JD-Core Version:    0.7.0.1
 */