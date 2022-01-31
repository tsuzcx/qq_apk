package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ShareMediaContent
  extends ShareContent<ShareMediaContent, ShareMediaContent.Builder>
{
  public static final Parcelable.Creator<ShareMediaContent> CREATOR;
  private final List<ShareMedia> media;
  
  static
  {
    AppMethodBeat.i(97449);
    CREATOR = new ShareMediaContent.1();
    AppMethodBeat.o(97449);
  }
  
  ShareMediaContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97447);
    this.media = Arrays.asList((ShareMedia[])paramParcel.readParcelableArray(ShareMedia.class.getClassLoader()));
    AppMethodBeat.o(97447);
  }
  
  private ShareMediaContent(ShareMediaContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97446);
    this.media = Collections.unmodifiableList(ShareMediaContent.Builder.access$000(paramBuilder));
    AppMethodBeat.o(97446);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final List<ShareMedia> getMedia()
  {
    return this.media;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97448);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelableArray((ShareMedia[])this.media.toArray(), paramInt);
    AppMethodBeat.o(97448);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareMediaContent
 * JD-Core Version:    0.7.0.1
 */