package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareStoryContent
  extends ShareContent<ShareStoryContent, Builder>
{
  public static final Parcelable.Creator<ShareStoryContent> CREATOR;
  private final String mAttributionLink;
  private final ShareMedia mBackgroundAsset;
  private final List<String> mBackgroundColorList;
  private final SharePhoto mStickerAsset;
  
  static
  {
    AppMethodBeat.i(8620);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareStoryContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8606);
        paramAnonymousParcel = new ShareStoryContent(paramAnonymousParcel);
        AppMethodBeat.o(8606);
        return paramAnonymousParcel;
      }
      
      public final ShareStoryContent[] newArray(int paramAnonymousInt)
      {
        return new ShareStoryContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8620);
  }
  
  ShareStoryContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8616);
    this.mBackgroundAsset = ((ShareMedia)paramParcel.readParcelable(ShareMedia.class.getClassLoader()));
    this.mStickerAsset = ((SharePhoto)paramParcel.readParcelable(SharePhoto.class.getClassLoader()));
    this.mBackgroundColorList = readUnmodifiableStringList(paramParcel);
    this.mAttributionLink = paramParcel.readString();
    AppMethodBeat.o(8616);
  }
  
  private ShareStoryContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8615);
    this.mBackgroundAsset = paramBuilder.mBackgroundAsset;
    this.mStickerAsset = paramBuilder.mStickerAsset;
    this.mBackgroundColorList = paramBuilder.mBackgroundColorList;
    this.mAttributionLink = paramBuilder.mAttributionLink;
    AppMethodBeat.o(8615);
  }
  
  private List<String> readUnmodifiableStringList(Parcel paramParcel)
  {
    AppMethodBeat.i(8619);
    ArrayList localArrayList = new ArrayList();
    paramParcel.readStringList(localArrayList);
    if (localArrayList.isEmpty())
    {
      AppMethodBeat.o(8619);
      return null;
    }
    paramParcel = Collections.unmodifiableList(localArrayList);
    AppMethodBeat.o(8619);
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
    AppMethodBeat.i(8617);
    if (this.mBackgroundColorList == null)
    {
      AppMethodBeat.o(8617);
      return null;
    }
    List localList = Collections.unmodifiableList(this.mBackgroundColorList);
    AppMethodBeat.o(8617);
    return localList;
  }
  
  public final SharePhoto getStickerAsset()
  {
    return this.mStickerAsset;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8618);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.mBackgroundAsset, 0);
    paramParcel.writeParcelable(this.mStickerAsset, 0);
    paramParcel.writeStringList(this.mBackgroundColorList);
    paramParcel.writeString(this.mAttributionLink);
    AppMethodBeat.o(8618);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareStoryContent, Builder>
  {
    static final String TAG;
    private String mAttributionLink;
    private ShareMedia mBackgroundAsset;
    private List<String> mBackgroundColorList;
    private SharePhoto mStickerAsset;
    
    static
    {
      AppMethodBeat.i(8614);
      TAG = Builder.class.getSimpleName();
      AppMethodBeat.o(8614);
    }
    
    public final ShareStoryContent build()
    {
      AppMethodBeat.i(8609);
      ShareStoryContent localShareStoryContent = new ShareStoryContent(this, null);
      AppMethodBeat.o(8609);
      return localShareStoryContent;
    }
    
    public final Builder readFrom(ShareStoryContent paramShareStoryContent)
    {
      AppMethodBeat.i(8610);
      if (paramShareStoryContent == null)
      {
        AppMethodBeat.o(8610);
        return this;
      }
      paramShareStoryContent = ((Builder)super.readFrom(paramShareStoryContent)).setBackgroundAsset(paramShareStoryContent.getBackgroundAsset()).setStickerAsset(paramShareStoryContent.getStickerAsset()).setBackgroundColorList(paramShareStoryContent.getBackgroundColorList()).setAttributionLink(paramShareStoryContent.getAttributionLink());
      AppMethodBeat.o(8610);
      return paramShareStoryContent;
    }
    
    public final Builder setAttributionLink(String paramString)
    {
      this.mAttributionLink = paramString;
      return this;
    }
    
    public final Builder setBackgroundAsset(ShareMedia paramShareMedia)
    {
      this.mBackgroundAsset = paramShareMedia;
      return this;
    }
    
    public final Builder setBackgroundColorList(List<String> paramList)
    {
      this.mBackgroundColorList = paramList;
      return this;
    }
    
    public final Builder setStickerAsset(SharePhoto paramSharePhoto)
    {
      this.mStickerAsset = paramSharePhoto;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareStoryContent
 * JD-Core Version:    0.7.0.1
 */