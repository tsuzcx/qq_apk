package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum GameRequestContent$Filters
{
  static
  {
    AppMethodBeat.i(8412);
    APP_USERS = new Filters("APP_USERS", 0);
    APP_NON_USERS = new Filters("APP_NON_USERS", 1);
    $VALUES = new Filters[] { APP_USERS, APP_NON_USERS };
    AppMethodBeat.o(8412);
  }
  
  private GameRequestContent$Filters() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.share.model.GameRequestContent.Filters
 * JD-Core Version:    0.7.0.1
 */