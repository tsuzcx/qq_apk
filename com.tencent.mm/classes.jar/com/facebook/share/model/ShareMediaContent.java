package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ShareMediaContent
  extends ShareContent<ShareMediaContent, Builder>
{
  public static final Parcelable.Creator<ShareMediaContent> CREATOR;
  private final List<ShareMedia> media;
  
  static
  {
    AppMethodBeat.i(8473);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareMediaContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8458);
        paramAnonymousParcel = new ShareMediaContent(paramAnonymousParcel);
        AppMethodBeat.o(8458);
        return paramAnonymousParcel;
      }
      
      public final ShareMediaContent[] newArray(int paramAnonymousInt)
      {
        return new ShareMediaContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8473);
  }
  
  ShareMediaContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8471);
    this.media = Arrays.asList((ShareMedia[])paramParcel.readParcelableArray(ShareMedia.class.getClassLoader()));
    AppMethodBeat.o(8471);
  }
  
  private ShareMediaContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8470);
    this.media = Collections.unmodifiableList(paramBuilder.media);
    AppMethodBeat.o(8470);
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
    AppMethodBeat.i(8472);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelableArray((ShareMedia[])this.media.toArray(), paramInt);
    AppMethodBeat.o(8472);
  }
  
  public static class Builder
    extends ShareContent.Builder<ShareMediaContent, Builder>
  {
    private final List<ShareMedia> media;
    
    public Builder()
    {
      AppMethodBeat.i(8461);
      this.media = new ArrayList();
      AppMethodBeat.o(8461);
    }
    
    public Builder addMedia(List<ShareMedia> paramList)
    {
      AppMethodBeat.i(8463);
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          addMedium((ShareMedia)paramList.next());
        }
      }
      AppMethodBeat.o(8463);
      return this;
    }
    
    public Builder addMedium(ShareMedia paramShareMedia)
    {
      AppMethodBeat.i(8462);
      if (paramShareMedia != null) {
        if (!(paramShareMedia instanceof SharePhoto)) {
          break label54;
        }
      }
      for (paramShareMedia = new SharePhoto.Builder().readFrom((SharePhoto)paramShareMedia).build();; paramShareMedia = new ShareVideo.Builder().readFrom((ShareVideo)paramShareMedia).build())
      {
        this.media.add(paramShareMedia);
        AppMethodBeat.o(8462);
        return this;
        label54:
        if (!(paramShareMedia instanceof ShareVideo)) {
          break;
        }
      }
      paramShareMedia = new IllegalArgumentException("medium must be either a SharePhoto or ShareVideo");
      AppMethodBeat.o(8462);
      throw paramShareMedia;
    }
    
    public ShareMediaContent build()
    {
      AppMethodBeat.i(8464);
      ShareMediaContent localShareMediaContent = new ShareMediaContent(this, null);
      AppMethodBeat.o(8464);
      return localShareMediaContent;
    }
    
    public Builder readFrom(ShareMediaContent paramShareMediaContent)
    {
      AppMethodBeat.i(8465);
      if (paramShareMediaContent == null)
      {
        AppMethodBeat.o(8465);
        return this;
      }
      paramShareMediaContent = ((Builder)super.readFrom(paramShareMediaContent)).addMedia(paramShareMediaContent.getMedia());
      AppMethodBeat.o(8465);
      return paramShareMediaContent;
    }
    
    public Builder setMedia(List<ShareMedia> paramList)
    {
      AppMethodBeat.i(8466);
      this.media.clear();
      addMedia(paramList);
      AppMethodBeat.o(8466);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareMediaContent
 * JD-Core Version:    0.7.0.1
 */