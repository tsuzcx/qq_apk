package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class GameRequestContent
  implements ShareModel
{
  public static final Parcelable.Creator<GameRequestContent> CREATOR;
  private final GameRequestContent.ActionType actionType;
  private final String data;
  private final GameRequestContent.Filters filters;
  private final String message;
  private final String objectId;
  private final List<String> recipients;
  private final List<String> suggestions;
  private final String title;
  
  static
  {
    AppMethodBeat.i(97393);
    CREATOR = new Parcelable.Creator()
    {
      public final GameRequestContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(97374);
        paramAnonymousParcel = new GameRequestContent(paramAnonymousParcel);
        AppMethodBeat.o(97374);
        return paramAnonymousParcel;
      }
      
      public final GameRequestContent[] newArray(int paramAnonymousInt)
      {
        return new GameRequestContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(97393);
  }
  
  GameRequestContent(Parcel paramParcel)
  {
    AppMethodBeat.i(97390);
    this.message = paramParcel.readString();
    this.recipients = paramParcel.createStringArrayList();
    this.title = paramParcel.readString();
    this.data = paramParcel.readString();
    this.actionType = ((GameRequestContent.ActionType)paramParcel.readSerializable());
    this.objectId = paramParcel.readString();
    this.filters = ((GameRequestContent.Filters)paramParcel.readSerializable());
    this.suggestions = paramParcel.createStringArrayList();
    paramParcel.readStringList(this.suggestions);
    AppMethodBeat.o(97390);
  }
  
  private GameRequestContent(GameRequestContent.Builder paramBuilder)
  {
    AppMethodBeat.i(97389);
    this.message = GameRequestContent.Builder.access$000(paramBuilder);
    this.recipients = GameRequestContent.Builder.access$100(paramBuilder);
    this.title = GameRequestContent.Builder.access$200(paramBuilder);
    this.data = GameRequestContent.Builder.access$300(paramBuilder);
    this.actionType = GameRequestContent.Builder.access$400(paramBuilder);
    this.objectId = GameRequestContent.Builder.access$500(paramBuilder);
    this.filters = GameRequestContent.Builder.access$600(paramBuilder);
    this.suggestions = GameRequestContent.Builder.access$700(paramBuilder);
    AppMethodBeat.o(97389);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final GameRequestContent.ActionType getActionType()
  {
    return this.actionType;
  }
  
  public final String getData()
  {
    return this.data;
  }
  
  public final GameRequestContent.Filters getFilters()
  {
    return this.filters;
  }
  
  public final String getMessage()
  {
    return this.message;
  }
  
  public final String getObjectId()
  {
    return this.objectId;
  }
  
  public final List<String> getRecipients()
  {
    return this.recipients;
  }
  
  public final List<String> getSuggestions()
  {
    return this.suggestions;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final String getTo()
  {
    AppMethodBeat.i(97391);
    if (getRecipients() != null)
    {
      String str = TextUtils.join(",", getRecipients());
      AppMethodBeat.o(97391);
      return str;
    }
    AppMethodBeat.o(97391);
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(97392);
    paramParcel.writeString(this.message);
    paramParcel.writeStringList(this.recipients);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.data);
    paramParcel.writeSerializable(this.actionType);
    paramParcel.writeString(this.objectId);
    paramParcel.writeSerializable(this.filters);
    paramParcel.writeStringList(this.suggestions);
    AppMethodBeat.o(97392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.share.model.GameRequestContent
 * JD-Core Version:    0.7.0.1
 */