package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareStoryContent
  extends ShareContent<ShareStoryContent, ShareStoryContent.Builder>
{
  public static final Parcelable.Creator<ShareStoryContent> CREATOR;
  private final String mAttributionLink;
  private final ShareMedia mBackgroundAsset;
  private final List<String> mBackgroundColorList;
  private final SharePhoto mStickerAsset;
  
  static
  {
    AppMethodBeat.i(97596);
    CREATOR = new ShareStoryContent.1();
    AppMethodBeat.o(97596);
  }
  
  ShareStoryContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(97592);
    this.mBackgroundAsset = ((ShareMedia)paramParcel.readParcelable(ShareMedia.class.getClassLoader()));
    this.mStickerAsset = ((SharePhoto)paramParcel.readParcelable(SharePhoto.class.getClassLoader()));
    this.mBackgroundColorList = readUnmodifiableStringList(paramParcel);
    this.mAttributionLink = paramParcel.readString();
    AppMethodBeat.o(97592);
  }
  
  private ShareStoryContent(ShareStoryContent.Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(97591);
    this.mBackgroundAsset = ShareStoryContent.Builder.access$000(paramBuilder);
    this.mStickerAsset = ShareStoryContent.Builder.access$100(paramBuilder);
    this.mBackgroundColorList = ShareStoryContent.Builder.access$200(paramBuilder);
    this.mAttributionLink = ShareStoryContent.Builder.access$300(paramBuilder);
    AppMethodBeat.o(97591);
  }
  
  private List<String> readUnmodifiableStringList(Parcel paramParcel)
  {
    AppMethodBeat.i(97595);
    ArrayList localArrayList = new ArrayList();
    paramParcel.readStringList(localArrayList);
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(97595);
      return null;
    }
    paramParcel = Collections.unmodifiableList(localArrayList);
    AppMethodBeat.o(97595);
    return paramParcel;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String getAttributionLink()
  {
    return this.mAttributionLink;
  }
  
  public final ShareMedia getBackgroundAsset()
  {
    return this.mBackgroundAsset;
  }
  
  public final List<String> getBackgroundColorList()
  {
    AppMethodBeat.i(97593);
    if (this.mBackgroundColorList == null)
    {
      AppMethodBeat.o(97593);
      return null;
    }
    List localList = Collections.unmodifiableList(this.mBackgroundColorList);
    AppMethodBeat.o(97593);
    return localList;
  }
  
  public final SharePhoto getStickerAsset()
  {
    return this.mStickerAsset;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97594);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mBackgroundAsset, 0);
    paramParcel.writeParcelable(this.mStickerAsset, 0);
    paramParcel.writeStringList(this.mBackgroundColorList);
    paramParcel.writeString(this.mAttributionLink);
    AppMethodBeat.o(97594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.share.model.ShareStoryContent
 * JD-Core Version:    0.7.0.1
 */