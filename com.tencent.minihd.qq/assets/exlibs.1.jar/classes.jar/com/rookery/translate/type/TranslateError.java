package com.rookery.translate.type;

public class TranslateError
  extends Exception
{
  private static final long serialVersionUID = 221843528590808183L;
  
  public TranslateError(Exception paramException)
  {
    super(paramException);
  }
  
  public TranslateError(String paramString)
  {
    super(paramString);
  }
  
  public TranslateError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.rookery.translate.type.TranslateError
 * JD-Core Version:    0.7.0.1
 */