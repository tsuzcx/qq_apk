package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class ShareOpenGraphValueContainer<P extends ShareOpenGraphValueContainer, E extends Builder>
  implements ShareModel
{
  private final Bundle bundle;
  
  ShareOpenGraphValueContainer(Parcel paramParcel)
  {
    this.bundle = paramParcel.readBundle(Builder.class.getClassLoader());
  }
  
  protected ShareOpenGraphValueContainer(Builder<P, E> paramBuilder)
  {
    this.bundle = ((Bundle)paramBuilder.bundle.clone());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object get(String paramString)
  {
    return this.bundle.get(paramString);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    return this.bundle.getBoolean(paramString, paramBoolean);
  }
  
  public boolean[] getBooleanArray(String paramString)
  {
    return this.bundle.getBooleanArray(paramString);
  }
  
  public Bundle getBundle()
  {
    return (Bundle)this.bundle.clone();
  }
  
  public double getDouble(String paramString, double paramDouble)
  {
    return this.bundle.getDouble(paramString, paramDouble);
  }
  
  public double[] getDoubleArray(String paramString)
  {
    return this.bundle.getDoubleArray(paramString);
  }
  
  public int getInt(String paramString, int paramInt)
  {
    return this.bundle.getInt(paramString, paramInt);
  }
  
  public int[] getIntArray(String paramString)
  {
    return this.bundle.getIntArray(paramString);
  }
  
  public long getLong(String paramString, long paramLong)
  {
    return this.bundle.getLong(paramString, paramLong);
  }
  
  public long[] getLongArray(String paramString)
  {
    return this.bundle.getLongArray(paramString);
  }
  
  public ShareOpenGraphObject getObject(String paramString)
  {
    paramString = this.bundle.get(paramString);
    if ((paramString instanceof ShareOpenGraphObject)) {
      return (ShareOpenGraphObject)paramString;
    }
    return null;
  }
  
  public ArrayList<ShareOpenGraphObject> getObjectArrayList(String paramString)
  {
    Object localObject = this.bundle.getParcelableArrayList(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Parcelable localParcelable = (Parcelable)((Iterator)localObject).next();
      if ((localParcelable instanceof ShareOpenGraphObject)) {
        paramString.add((ShareOpenGraphObject)localParcelable);
      }
    }
    return paramString;
  }
  
  public SharePhoto getPhoto(String paramString)
  {
    paramString = this.bundle.getParcelable(paramString);
    if ((paramString instanceof SharePhoto)) {
      return (SharePhoto)paramString;
    }
    return null;
  }
  
  public ArrayList<SharePhoto> getPhotoArrayList(String paramString)
  {
    Object localObject = this.bundle.getParcelableArrayList(paramString);
    if (localObject == null) {
      return null;
    }
    paramString = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Parcelable localParcelable = (Parcelable)((Iterator)localObject).next();
      if ((localParcelable instanceof SharePhoto)) {
        paramString.add((SharePhoto)localParcelable);
      }
    }
    return paramString;
  }
  
  public String getString(String paramString)
  {
    return this.bundle.getString(paramString);
  }
  
  public ArrayList<String> getStringArrayList(String paramString)
  {
    return this.bundle.getStringArrayList(paramString);
  }
  
  public Set<String> keySet()
  {
    return this.bundle.keySet();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.bundle);
  }
  
  public static abstract class Builder<P extends ShareOpenGraphValueContainer, E extends Builder>
    implements ShareModelBuilder<P, E>
  {
    private Bundle bundle = new Bundle();
    
    public E putBoolean(String paramString, boolean paramBoolean)
    {
      this.bundle.putBoolean(paramString, paramBoolean);
      return this;
    }
    
    public E putBooleanArray(String paramString, boolean[] paramArrayOfBoolean)
    {
      this.bundle.putBooleanArray(paramString, paramArrayOfBoolean);
      return this;
    }
    
    public E putDouble(String paramString, double paramDouble)
    {
      this.bundle.putDouble(paramString, paramDouble);
      return this;
    }
    
    public E putDoubleArray(String paramString, double[] paramArrayOfDouble)
    {
      this.bundle.putDoubleArray(paramString, paramArrayOfDouble);
      return this;
    }
    
    public E putInt(String paramString, int paramInt)
    {
      this.bundle.putInt(paramString, paramInt);
      return this;
    }
    
    public E putIntArray(String paramString, int[] paramArrayOfInt)
    {
      this.bundle.putIntArray(paramString, paramArrayOfInt);
      return this;
    }
    
    public E putLong(String paramString, long paramLong)
    {
      this.bundle.putLong(paramString, paramLong);
      return this;
    }
    
    public E putLongArray(String paramString, long[] paramArrayOfLong)
    {
      this.bundle.putLongArray(paramString, paramArrayOfLong);
      return this;
    }
    
    public E putObject(String paramString, ShareOpenGraphObject paramShareOpenGraphObject)
    {
      this.bundle.putParcelable(paramString, paramShareOpenGraphObject);
      return this;
    }
    
    public E putObjectArrayList(String paramString, ArrayList<ShareOpenGraphObject> paramArrayList)
    {
      this.bundle.putParcelableArrayList(paramString, paramArrayList);
      return this;
    }
    
    public E putPhoto(String paramString, SharePhoto paramSharePhoto)
    {
      this.bundle.putParcelable(paramString, paramSharePhoto);
      return this;
    }
    
    public E putPhotoArrayList(String paramString, ArrayList<SharePhoto> paramArrayList)
    {
      this.bundle.putParcelableArrayList(paramString, paramArrayList);
      return this;
    }
    
    public E putString(String paramString1, String paramString2)
    {
      this.bundle.putString(paramString1, paramString2);
      return this;
    }
    
    public E putStringArrayList(String paramString, ArrayList<String> paramArrayList)
    {
      this.bundle.putStringArrayList(paramString, paramArrayList);
      return this;
    }
    
    public E readFrom(P paramP)
    {
      if (paramP != null) {
        this.bundle.putAll(paramP.getBundle());
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphValueContainer
 * JD-Core Version:    0.7.0.1
 */