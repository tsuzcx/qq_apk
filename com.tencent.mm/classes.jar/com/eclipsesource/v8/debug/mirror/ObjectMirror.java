package com.eclipsesource.v8.debug.mirror;

import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;

public class ObjectMirror
  extends ValueMirror
{
  private static final String PROPERTIES = "properties";
  private static final String PROPERTY_NAMES = "propertyNames";
  
  ObjectMirror(V8Object paramV8Object)
  {
    super(paramV8Object);
  }
  
  public PropertiesArray getProperties(ObjectMirror.PropertyKind paramPropertyKind, int paramInt)
  {
    V8Array localV8Array2 = new V8Array(this.v8Object.getRuntime());
    localV8Array2.push(paramPropertyKind.index);
    localV8Array2.push(paramInt);
    paramPropertyKind = null;
    try
    {
      V8Array localV8Array1 = this.v8Object.executeArrayFunction("properties", localV8Array2);
      paramPropertyKind = localV8Array1;
      PropertiesArray localPropertiesArray = new PropertiesArray(localV8Array1);
      return localPropertiesArray;
    }
    finally
    {
      localV8Array2.release();
      if ((paramPropertyKind != null) && (!paramPropertyKind.isReleased())) {
        paramPropertyKind.release();
      }
    }
  }
  
  public String[] getPropertyNames(ObjectMirror.PropertyKind paramPropertyKind, int paramInt)
  {
    V8Array localV8Array2 = new V8Array(this.v8Object.getRuntime());
    localV8Array2.push(paramPropertyKind.index);
    localV8Array2.push(paramInt);
    paramPropertyKind = null;
    try
    {
      V8Array localV8Array1 = this.v8Object.executeArrayFunction("propertyNames", localV8Array2);
      paramPropertyKind = localV8Array1;
      String[] arrayOfString = new String[localV8Array1.length()];
      paramInt = 0;
      for (;;)
      {
        paramPropertyKind = localV8Array1;
        if (paramInt >= arrayOfString.length) {
          break;
        }
        paramPropertyKind = localV8Array1;
        arrayOfString[paramInt] = localV8Array1.getString(paramInt);
        paramInt += 1;
      }
      return arrayOfString;
    }
    finally
    {
      localV8Array2.release();
      if (paramPropertyKind != null) {
        paramPropertyKind.release();
      }
    }
  }
  
  public boolean isObject()
  {
    return true;
  }
  
  public String toString()
  {
    return this.v8Object.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.eclipsesource.v8.debug.mirror.ObjectMirror
 * JD-Core Version:    0.7.0.1
 */