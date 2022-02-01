package com.google.b;

import java.util.Iterator;
import java.util.List;

public final class cy
  extends RuntimeException
{
  private final List<String> cbo;
  
  public cy()
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    this.cbo = null;
  }
  
  public cy(List<String> paramList)
  {
    super(A(paramList));
    this.cbo = paramList;
  }
  
  private static String A(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("Message missing required fields: ");
    paramList = paramList.iterator();
    int i = 1;
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(str);
        break;
        localStringBuilder.append(", ");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.b.cy
 * JD-Core Version:    0.7.0.1
 */