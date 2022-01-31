package com.facebook.internal;

public abstract class FacebookDialogBase$ModeHandler
{
  protected FacebookDialogBase$ModeHandler(FacebookDialogBase paramFacebookDialogBase) {}
  
  public abstract boolean canShow(CONTENT paramCONTENT, boolean paramBoolean);
  
  public abstract AppCall createAppCall(CONTENT paramCONTENT);
  
  public Object getMode()
  {
    return FacebookDialogBase.BASE_AUTOMATIC_MODE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.internal.FacebookDialogBase.ModeHandler
 * JD-Core Version:    0.7.0.1
 */