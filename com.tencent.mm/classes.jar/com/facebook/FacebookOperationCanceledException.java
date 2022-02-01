package com.facebook;

public class FacebookOperationCanceledException
  extends FacebookException
{
  static final long serialVersionUID = 1L;
  
  public FacebookOperationCanceledException() {}
  
  public FacebookOperationCanceledException(String paramString)
  {
    super(paramString);
  }
  
  public FacebookOperationCanceledException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public FacebookOperationCanceledException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.facebook.FacebookOperationCanceledException
 * JD-Core Version:    0.7.0.1
 */