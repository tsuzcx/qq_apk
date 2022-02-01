package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
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
    AppMethodBeat.i(8417);
    CREATOR = new Parcelable.Creator()
    {
      public final GameRequestContent createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(8398);
        paramAnonymousParcel = new GameRequestContent(paramAnonymousParcel);
        AppMethodBeat.o(8398);
        return paramAnonymousParcel;
      }
      
      public final GameRequestContent[] newArray(int paramAnonymousInt)
      {
        return new GameRequestContent[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(8417);
  }
  
  GameRequestContent(Parcel paramParcel)
  {
    AppMethodBeat.i(8414);
    this.message = paramParcel.readString();
    this.recipients = paramParcel.createStringArrayList();
    this.title = paramParcel.readString();
    this.data = paramParcel.readString();
    this.actionType = ((GameRequestContent.ActionType)paramParcel.readSerializable());
    this.objectId = paramParcel.readString();
    this.filters = ((GameRequestContent.Filters)paramParcel.readSerializable());
    this.suggestions = paramParcel.createStringArrayList();
    paramParcel.readStringList(this.suggestions);
    AppMethodBeat.o(8414);
  }
  
  private GameRequestContent(Builder paramBuilder)
  {
    AppMethodBeat.i(8413);
    this.message = paramBuilder.message;
    this.recipients = paramBuilder.recipients;
    this.title = paramBuilder.title;
    this.data = paramBuilder.data;
    this.actionType = paramBuilder.actionType;
    this.objectId = paramBuilder.objectId;
    this.filters = paramBuilder.filters;
    this.suggestions = paramBuilder.suggestions;
    AppMethodBeat.o(8413);
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
    AppMethodBeat.i(8415);
    if (getRecipients() != null)
    {
      String str = TextUtils.join(",", getRecipients());
      AppMethodBeat.o(8415);
      return str;
    }
    AppMethodBeat.o(8415);
    return null;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(8416);
    paramParcel.writeString(this.message);
    paramParcel.writeStringList(this.recipients);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.data);
    paramParcel.writeSerializable(this.actionType);
    paramParcel.writeString(this.objectId);
    paramParcel.writeSerializable(this.filters);
    paramParcel.writeStringList(this.suggestions);
    AppMethodBeat.o(8416);
  }
  
  public static class Builder
    implements ShareModelBuilder<GameRequestContent, Builder>
  {
    private GameRequestContent.ActionType actionType;
    private String data;
    private GameRequestContent.Filters filters;
    private String message;
    private String objectId;
    private List<String> recipients;
    private List<String> suggestions;
    private String title;
    
    public GameRequestContent build()
    {
      AppMethodBeat.i(8405);
      GameRequestContent localGameRequestContent = new GameRequestContent(this, null);
      AppMethodBeat.o(8405);
      return localGameRequestContent;
    }
    
    Builder readFrom(Parcel paramParcel)
    {
      AppMethodBeat.i(8407);
      paramParcel = readFrom((GameRequestContent)paramParcel.readParcelable(GameRequestContent.class.getClassLoader()));
      AppMethodBeat.o(8407);
      return paramParcel;
    }
    
    public Builder readFrom(GameRequestContent paramGameRequestContent)
    {
      AppMethodBeat.i(8406);
      if (paramGameRequestContent == null)
      {
        AppMethodBeat.o(8406);
        return this;
      }
      paramGameRequestContent = setMessage(paramGameRequestContent.getMessage()).setRecipients(paramGameRequestContent.getRecipients()).setTitle(paramGameRequestContent.getTitle()).setData(paramGameRequestContent.getData()).setActionType(paramGameRequestContent.getActionType()).setObjectId(paramGameRequestContent.getObjectId()).setFilters(paramGameRequestContent.getFilters()).setSuggestions(paramGameRequestContent.getSuggestions());
      AppMethodBeat.o(8406);
      return paramGameRequestContent;
    }
    
    public Builder setActionType(GameRequestContent.ActionType paramActionType)
    {
      this.actionType = paramActionType;
      return this;
    }
    
    public Builder setData(String paramString)
    {
      this.data = paramString;
      return this;
    }
    
    public Builder setFilters(GameRequestContent.Filters paramFilters)
    {
      this.filters = paramFilters;
      return this;
    }
    
    public Builder setMessage(String paramString)
    {
      this.message = paramString;
      return this;
    }
    
    public Builder setObjectId(String paramString)
    {
      this.objectId = paramString;
      return this;
    }
    
    public Builder setRecipients(List<String> paramList)
    {
      this.recipients = paramList;
      return this;
    }
    
    public Builder setSuggestions(List<String> paramList)
    {
      this.suggestions = paramList;
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.title = paramString;
      return this;
    }
    
    public Builder setTo(String paramString)
    {
      AppMethodBeat.i(8404);
      if (paramString != null) {
        this.recipients = Arrays.asList(paramString.split(","));
      }
      AppMethodBeat.o(8404);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.GameRequestContent
 * JD-Core Version:    0.7.0.1
 */