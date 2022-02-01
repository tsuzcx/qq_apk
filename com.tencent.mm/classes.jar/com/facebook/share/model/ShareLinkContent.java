package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareLinkContent
  extends ShareContent<ShareLinkContent, Builder>
{
  public static final Parcelable.Creator<ShareLinkContent> CREATOR;
  @Deprecated
  private final String contentDescription;
  @Deprecated
  private final String contentTitle;
  @Deprecated
  private final Uri imageUrl;
  private final String quote;
  
  static
  {
    AppMethodBeat.i(8454);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareLinkContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8442);
        paramAnonymousParcel = new ShareLinkContent(paramAnonymousParcel);
        AppMethodBeat.o(8442);
        return paramAnonymousParcel;
      }
      
      public final ShareLinkContent[] newArray(int paramAnonymousInt)
      {
        return new ShareLinkContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8454);
  }
  
  ShareLinkContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8452);
    this.contentDescription = paramParcel.readString();
    this.contentTitle = paramParcel.readString();
    this.imageUrl = ((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()));
    this.quote = paramParcel.readString();
    AppMethodBeat.o(8452);
  }
  
  private ShareLinkContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8451);
    this.contentDescription = paramBuilder.contentDescription;
    this.contentTitle = paramBuilder.contentTitle;
    this.imageUrl = paramBuilder.imageUrl;
    this.quote = paramBuilder.quote;
    AppMethodBeat.o(8451);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public final String getContentDescription()
  {
    return this.contentDescription;
  }
  
  @Deprecated
  public final String getContentTitle()
  {
    return this.contentTitle;
  }
  
  @Deprecated
  public final Uri getImageUrl()
  {
    return this.imageUrl;
  }
  
  public final String getQuote()
  {
    return this.quote;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8453);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.contentDescription);
    paramParcel.writeString(this.contentTitle);
    paramParcel.writeParcelable(this.imageUrl, 0);
    paramParcel.writeString(this.quote);
    AppMethodBeat.o(8453);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareLinkContent, Builder>
  {
    static final String TAG;
    @Deprecated
    private String contentDescription;
    @Deprecated
    private String contentTitle;
    @Deprecated
    private Uri imageUrl;
    private String quote;
    
    static
    {
      AppMethodBeat.i(8450);
      TAG = Builder.class.getSimpleName();
      AppMethodBeat.o(8450);
    }
    
    public final ShareLinkContent build()
    {
      AppMethodBeat.i(8445);
      ShareLinkContent localShareLinkContent = new ShareLinkContent(this, null);
      AppMethodBeat.o(8445);
      return localShareLinkContent;
    }
    
    public final Builder readFrom(ShareLinkContent paramShareLinkContent)
    {
      AppMethodBeat.i(8446);
      if (paramShareLinkContent == null)
      {
        AppMethodBeat.o(8446);
        return this;
      }
      paramShareLinkContent = ((Builder)super.readFrom(paramShareLinkContent)).setContentDescription(paramShareLinkContent.getContentDescription()).setImageUrl(paramShareLinkContent.getImageUrl()).setContentTitle(paramShareLinkContent.getContentTitle()).setQuote(paramShareLinkContent.getQuote());
      AppMethodBeat.o(8446);
      return paramShareLinkContent;
    }
    
    @Deprecated
    public final Builder setContentDescription(String paramString)
    {
      return this;
    }
    
    @Deprecated
    public final Builder setContentTitle(String paramString)
    {
      return this;
    }
    
    @Deprecated
    public final Builder setImageUrl(Uri paramUri)
    {
      return this;
    }
    
    public final Builder setQuote(String paramString)
    {
      this.quote = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.model.ShareLinkContent
 * JD-Core Version:    0.7.0.1
 */