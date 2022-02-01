package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public abstract class FastSafeParcelableJsonResponse
  extends FastJsonResponse
  implements SafeParcelable
{
  public final int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!getClass().isInstance(paramObject)) {
      return false;
    }
    paramObject = (FastJsonResponse)paramObject;
    Iterator localIterator = getFieldMappings().values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (isFieldSet(localField))
      {
        if (paramObject.isFieldSet(localField))
        {
          if (!getFieldValue(localField).equals(paramObject.getFieldValue(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (paramObject.isFieldSet(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public Object getValueObject(String paramString)
  {
    return null;
  }
  
  public int hashCode()
  {
    Iterator localIterator = getFieldMappings().values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!isFieldSet(localField)) {
        break label63;
      }
      i = getFieldValue(localField).hashCode() + i * 31;
    }
    label63:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isPrimitiveFieldSet(String paramString)
  {
    return false;
  }
  
  public byte[] toByteArray()
  {
    Parcel localParcel = Parcel.obtain();
    writeToParcel(localParcel, 0);
    byte[] arrayOfByte = localParcel.marshall();
    localParcel.recycle();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
 * JD-Core Version:    0.7.0.1
 */