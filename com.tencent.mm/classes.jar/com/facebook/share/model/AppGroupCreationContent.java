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
    AppMethodBeat.i(97334);
    CREATOR = new AppGroupCreationContent.1();
    AppMethodBeat.o(97334);
  }
  
  AppGroupCreationContent(Parcel paramParcel)
  {
    AppMethodBeat.i(97332);
    this.name = paramParcel.readString();
    this.description = paramParcel.readString();
    this.privacy = ((AppGroupCreationContent.AppGroupPrivacy)paramParcel.readSerializable());
    AppMethodBeat.o(97332);
  }
  
  private AppGroupCreationContent(AppGroupCreationContent.Builder paramBuilder)
  {
    AppMethodBeat.i(97331);
    this.name = AppGroupCreationContent.Builder.access$000(paramBuilder);
    this.description = AppGroupCreationContent.Builder.access$100(paramBuilder);
    this.privacy = AppGroupCreationContent.Builder.access$200(paramBuilder);
    AppMethodBeat.o(97331);
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
    AppMethodBeat.i(97333);
    paramParcel.writeString(this.name);
    paramParcel.writeString(this.description);
    paramParcel.writeSerializable(this.privacy);
    AppMethodBeat.o(97333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.share.model.AppGroupCreationContent
 * JD-Core Version:    0.7.0.1
 */