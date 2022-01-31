package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.ShareModel;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeContent
  implements ShareModel
{
  @Deprecated
  public static final Parcelable.Creator<LikeContent> CREATOR;
  private final String objectId;
  private final String objectType;
  
  static
  {
    AppMethodBeat.i(97098);
    CREATOR = new LikeContent.1();
    AppMethodBeat.o(97098);
  }
  
  @Deprecated
  LikeContent(Parcel paramParcel)
  {
    AppMethodBeat.i(97096);
    this.objectId = paramParcel.readString();
    this.objectType = paramParcel.readString();
    AppMethodBeat.o(97096);
  }
  
  private LikeContent(LikeContent.Builder paramBuilder)
  {
    AppMethodBeat.i(97095);
    this.objectId = LikeContent.Builder.access$000(paramBuilder);
    this.objectType = LikeContent.Builder.access$100(paramBuilder);
    AppMethodBeat.o(97095);
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public String getObjectId()
  {
    return this.objectId;
  }
  
  @Deprecated
  public String getObjectType()
  {
    return this.objectType;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97097);
    paramParcel.writeString(this.objectId);
    paramParcel.writeString(this.objectType);
    AppMethodBeat.o(97097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.internal.LikeContent
 * JD-Core Version:    0.7.0.1
 */