package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SharePhotoContent
  extends ShareContent<SharePhotoContent, Builder>
{
  public static final Parcelable.Creator<SharePhotoContent> CREATOR;
  private final List<SharePhoto> photos;
  
  static
  {
    AppMethodBeat.i(8605);
    CREATOR = new Parcelable.Creator()
    {
      public final SharePhotoContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8590);
        paramAnonymousParcel = new SharePhotoContent(paramAnonymousParcel);
        AppMethodBeat.o(8590);
        return paramAnonymousParcel;
      }
      
      public final SharePhotoContent[] newArray(int paramAnonymousInt)
      {
        return new SharePhotoContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8605);
  }
  
  SharePhotoContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8603);
    this.photos = Collections.unmodifiableList(SharePhoto.Builder.readPhotoListFrom(paramParcel));
    AppMethodBeat.o(8603);
  }
  
  private SharePhotoContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8602);
    this.photos = Collections.unmodifiableList(paramBuilder.photos);
    AppMethodBeat.o(8602);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final List<SharePhoto> getPhotos()
  {
    return this.photos;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8604);
    super.writeToParcel(paramParcel, paramInt);
    SharePhoto.Builder.writePhotoListTo(paramParcel, paramInt, this.photos);
    AppMethodBeat.o(8604);
  }
  
  public static class Builder
    extends ShareContent.Builder<SharePhotoContent, Builder>
  {
    private final List<SharePhoto> photos;
    
    public Builder()
    {
      AppMethodBeat.i(8593);
      this.photos = new ArrayList();
      AppMethodBeat.o(8593);
    }
    
    public Builder addPhoto(SharePhoto paramSharePhoto)
    {
      AppMethodBeat.i(8594);
      if (paramSharePhoto != null) {
        this.photos.add(new SharePhoto.Builder().readFrom(paramSharePhoto).build());
      }
      AppMethodBeat.o(8594);
      return this;
    }
    
    public Builder addPhotos(List<SharePhoto> paramList)
    {
      AppMethodBeat.i(8595);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          addPhoto((SharePhoto)paramList.next());
        }
      }
      AppMethodBeat.o(8595);
      return this;
    }
    
    public SharePhotoContent build()
    {
      AppMethodBeat.i(8596);
      SharePhotoContent localSharePhotoContent = new SharePhotoContent(this, null);
      AppMethodBeat.o(8596);
      return localSharePhotoContent;
    }
    
    public Builder readFrom(SharePhotoContent paramSharePhotoContent)
    {
      AppMethodBeat.i(8597);
      if (paramSharePhotoContent == null)
      {
        AppMethodBeat.o(8597);
        return this;
      }
      paramSharePhotoContent = ((Builder)super.readFrom(paramSharePhotoContent)).addPhotos(paramSharePhotoContent.getPhotos());
      AppMethodBeat.o(8597);
      return paramSharePhotoContent;
    }
    
    public Builder setPhotos(List<SharePhoto> paramList)
    {
      AppMethodBeat.i(8598);
      this.photos.clear();
      addPhotos(paramList);
      AppMethodBeat.o(8598);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.SharePhotoContent
 * JD-Core Version:    0.7.0.1
 */