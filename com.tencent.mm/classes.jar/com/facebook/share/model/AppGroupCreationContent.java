package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AppGroupCreationContent
  implements ShareModel
{
  public static final Parcelable.Creator<AppGroupCreationContent> CREATOR;
  private final String description;
  private final String name;
  private AppGroupCreationContent.AppGroupPrivacy privacy;
  
  static
  {
    AppMethodBeat.i(8358);
    CREATOR = new Parcelable.Creator()
    {
      public final AppGroupCreationContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8345);
        paramAnonymousParcel = new AppGroupCreationContent(paramAnonymousParcel);
        AppMethodBeat.o(8345);
        return paramAnonymousParcel;
      }
      
      public final AppGroupCreationContent[] newArray(int paramAnonymousInt)
      {
        return new AppGroupCreationContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8358);
  }
  
  AppGroupCreationContent(Parcel paramParcel)
  {
    AppMethodBeat.i(8356);
    this.name = paramParcel.readString();
    this.description = paramParcel.readString();
    this.privacy = ((AppGroupCreationContent.AppGroupPrivacy)paramParcel.readSerializable());
    AppMethodBeat.o(8356);
  }
  
  private AppGroupCreationContent(Builder paramBuilder)
  {
    AppMethodBeat.i(8355);
    this.name = paramBuilder.name;
    this.description = paramBuilder.description;
    this.privacy = paramBuilder.privacy;
    AppMethodBeat.o(8355);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final AppGroupCreationContent.AppGroupPrivacy getAppGroupPrivacy()
  {
    return this.privacy;
  }
  
  public final String getDescription()
  {
    return this.description;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8357);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.description);
    paramParcel.writeSerializable(this.privacy);
    AppMethodBeat.o(8357);
  }
  
  public static class Builder
    implements ShareModelBuilder<AppGroupCreationContent, Builder>
  {
    private String description;
    private String name;
    private AppGroupCreationContent.AppGroupPrivacy privacy;
    
    public AppGroupCreationContent build()
    {
      AppMethodBeat.i(8351);
      AppGroupCreationContent localAppGroupCreationContent = new AppGroupCreationContent(this, null);
      AppMethodBeat.o(8351);
      return localAppGroupCreationContent;
    }
    
    public Builder readFrom(AppGroupCreationContent paramAppGroupCreationContent)
    {
      AppMethodBeat.i(8352);
      if (paramAppGroupCreationContent == null)
      {
        AppMethodBeat.o(8352);
        return this;
      }
      paramAppGroupCreationContent = setName(paramAppGroupCreationContent.getName()).setDescription(paramAppGroupCreationContent.getDescription()).setAppGroupPrivacy(paramAppGroupCreationContent.getAppGroupPrivacy());
      AppMethodBeat.o(8352);
      return paramAppGroupCreationContent;
    }
    
    public Builder setAppGroupPrivacy(AppGroupCreationContent.AppGroupPrivacy paramAppGroupPrivacy)
    {
      this.privacy = paramAppGroupPrivacy;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.description = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.name = paramString;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.AppGroupCreationContent
 * JD-Core Version:    0.7.0.1
 */