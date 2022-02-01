package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphContent
  extends ShareContent<ShareOpenGraphContent, Builder>
{
  public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR;
  private final ShareOpenGraphAction action;
  private final String previewPropertyName;
  
  static
  {
    AppMethodBeat.i(8566);
    CREATOR = new Parcelable.Creator()
    {
      public final ShareOpenGraphContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8554);
        paramAnonymousParcel = new ShareOpenGraphContent(paramAnonymousParcel);
        AppMethodBeat.o(8554);
        return paramAnonymousParcel;
      }
      
      public final ShareOpenGraphContent[] newArray(int paramAnonymousInt)
      {
        return new ShareOpenGraphContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8566);
  }
  
  ShareOpenGraphContent(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(8564);
    this.action = new ShareOpenGraphAction.Builder().readFrom(paramParcel).build();
    this.previewPropertyName = paramParcel.readString();
    AppMethodBeat.o(8564);
  }
  
  private ShareOpenGraphContent(Builder paramBuilder)
  {
    super(paramBuilder);
    AppMethodBeat.i(8563);
    this.action = paramBuilder.action;
    this.previewPropertyName = paramBuilder.previewPropertyName;
    AppMethodBeat.o(8563);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final ShareOpenGraphAction getAction()
  {
    return this.action;
  }
  
  public final String getPreviewPropertyName()
  {
    return this.previewPropertyName;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8565);
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.action, 0);
    paramParcel.writeString(this.previewPropertyName);
    AppMethodBeat.o(8565);
  }
  
  public static final class Builder
    extends ShareContent.Builder<ShareOpenGraphContent, Builder>
  {
    private ShareOpenGraphAction action;
    private String previewPropertyName;
    
    public final ShareOpenGraphContent build()
    {
      AppMethodBeat.i(8558);
      ShareOpenGraphContent localShareOpenGraphContent = new ShareOpenGraphContent(this, null);
      AppMethodBeat.o(8558);
      return localShareOpenGraphContent;
    }
    
    public final Builder readFrom(ShareOpenGraphContent paramShareOpenGraphContent)
    {
      AppMethodBeat.i(8559);
      if (paramShareOpenGraphContent == null)
      {
        AppMethodBeat.o(8559);
        return this;
      }
      paramShareOpenGraphContent = ((Builder)super.readFrom(paramShareOpenGraphContent)).setAction(paramShareOpenGraphContent.getAction()).setPreviewPropertyName(paramShareOpenGraphContent.getPreviewPropertyName());
      AppMethodBeat.o(8559);
      return paramShareOpenGraphContent;
    }
    
    public final Builder setAction(ShareOpenGraphAction paramShareOpenGraphAction)
    {
      AppMethodBeat.i(8557);
      if (paramShareOpenGraphAction == null) {}
      for (paramShareOpenGraphAction = null;; paramShareOpenGraphAction = new ShareOpenGraphAction.Builder().readFrom(paramShareOpenGraphAction).build())
      {
        this.action = paramShareOpenGraphAction;
        AppMethodBeat.o(8557);
        return this;
      }
    }
    
    public final Builder setPreviewPropertyName(String paramString)
    {
      this.previewPropertyName = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.ShareOpenGraphContent
 * JD-Core Version:    0.7.0.1
 */