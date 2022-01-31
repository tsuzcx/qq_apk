package com.facebook.share.model;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public class GameRequestContent$Builder
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
    AppMethodBeat.i(97381);
    GameRequestContent localGameRequestContent = new GameRequestContent(this, null);
    AppMethodBeat.o(97381);
    return localGameRequestContent;
  }
  
  Builder readFrom(Parcel paramParcel)
  {
    AppMethodBeat.i(97383);
    paramParcel = readFrom((GameRequestContent)paramParcel.readParcelable(GameRequestContent.class.getClassLoader()));
    AppMethodBeat.o(97383);
    return paramParcel;
  }
  
  public Builder readFrom(GameRequestContent paramGameRequestContent)
  {
    AppMethodBeat.i(97382);
    if (paramGameRequestContent == null)
    {
      AppMethodBeat.o(97382);
      return this;
    }
    paramGameRequestContent = setMessage(paramGameRequestContent.getMessage()).setRecipients(paramGameRequestContent.getRecipients()).setTitle(paramGameRequestContent.getTitle()).setData(paramGameRequestContent.getData()).setActionType(paramGameRequestContent.getActionType()).setObjectId(paramGameRequestContent.getObjectId()).setFilters(paramGameRequestContent.getFilters()).setSuggestions(paramGameRequestContent.getSuggestions());
    AppMethodBeat.o(97382);
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
    AppMethodBeat.i(97380);
    if (paramString != null) {
      this.recipients = Arrays.asList(paramString.split(","));
    }
    AppMethodBeat.o(97380);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.share.model.GameRequestContent.Builder
 * JD-Core Version:    0.7.0.1
 */