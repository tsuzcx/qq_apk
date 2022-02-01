package com.tencent.mapsdk.internal;

import java.io.Serializable;

public abstract class p
  implements Serializable
{
  public static final byte BYTE = 0;
  public static final byte DOUBLE = 5;
  public static final byte FLOAT = 4;
  public static final byte INT = 2;
  public static final int JCE_MAX_STRING_LENGTH = 104857600;
  public static final byte LIST = 9;
  public static final byte LONG = 3;
  public static final byte MAP = 8;
  public static final byte SHORT = 1;
  public static final byte SIMPLE_LIST = 13;
  public static final byte STRING1 = 6;
  public static final byte STRING4 = 7;
  public static final byte STRUCT_BEGIN = 10;
  public static final byte STRUCT_END = 11;
  public static final byte ZERO_TAG = 12;
  private Object a;
  
  public static String toDisplaySimpleString(p paramp)
  {
    if (paramp == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramp.displaySimple(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public String className()
  {
    return "";
  }
  
  public boolean containField(String paramString)
  {
    return false;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt) {}
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt) {}
  
  public Object getFieldByName(String paramString)
  {
    return null;
  }
  
  public Object getTag()
  {
    return this.a;
  }
  
  public p newInit()
  {
    return null;
  }
  
  public abstract void readFrom(m paramm);
  
  public void recyle() {}
  
  public void setFieldByName(String paramString, Object paramObject) {}
  
  public void setTag(Object paramObject)
  {
    this.a = paramObject;
  }
  
  public byte[] toByteArray()
  {
    n localn = new n();
    writeTo(localn);
    return localn.a();
  }
  
  public byte[] toByteArray(String paramString)
  {
    n localn = new n();
    localn.a(paramString);
    writeTo(localn);
    return localn.a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    display(localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  public abstract void writeTo(n paramn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.p
 * JD-Core Version:    0.7.0.1
 */