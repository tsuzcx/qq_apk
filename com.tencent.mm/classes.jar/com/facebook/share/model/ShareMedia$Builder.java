package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareMedia$Builder<M extends ShareMedia, B extends Builder>
  implements ShareModelBuilder<M, B>
{
  private Bundle params = new Bundle();
  
  static List<ShareMedia> readListFrom(Parcel paramParcel)
  {
    paramParcel = paramParcel.readParcelableArray(ShareMedia.class.getClassLoader());
    ArrayList localArrayList = new ArrayList(paramParcel.length);
    int j = paramParcel.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add((ShareMedia)paramParcel[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  static void writeListTo(Parcel paramParcel, int paramInt, List<ShareMedia> paramList)
  {
    paramParcel.writeParcelableArray((ShareMedia[])paramList.toArray(), paramInt);
  }
  
  public B readFrom(M paramM)
  {
    if (paramM == null) {
      return this;
    }
    return setParameters(paramM.getParameters());
  }
  
  @Deprecated
  public B setParameter(String paramString1, String paramString2)
  {
    this.params.putString(paramString1, paramString2);
    return this;
  }
  
  @Deprecated
  public B setParameters(Bundle paramBundle)
  {
    this.params.putAll(paramBundle);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.share.model.ShareMedia.Builder
 * JD-Core Version:    0.7.0.1
 */