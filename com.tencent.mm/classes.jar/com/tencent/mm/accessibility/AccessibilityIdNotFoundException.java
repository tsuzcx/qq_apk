package com.tencent.mm.accessibility;

public class AccessibilityIdNotFoundException
  extends AccessibilityCaptureNotSupportException
{
  public AccessibilityIdNotFoundException()
  {
    super("Unable to find accessibility id");
  }
  
  public AccessibilityIdNotFoundException(String paramString)
  {
    super(paramString);
  }
  
  public AccessibilityIdNotFoundException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AccessibilityIdNotFoundException(Throwable paramThrowable)
  {
    super("Unable to find accessibility id", paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.accessibility.AccessibilityIdNotFoundException
 * JD-Core Version:    0.7.0.1
 */