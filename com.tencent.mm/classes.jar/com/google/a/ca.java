package com.google.a;

import java.util.Iterator;
import java.util.List;

public final class ca
  extends RuntimeException
{
  private final List<String> bZL;
  
  public ca()
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    this.bZL = null;
  }
  
  public ca(List<String> paramList)
  {
    super(D(paramList));
    this.bZL = paramList;
  }
  
  private static String D(List<String> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.a.ca
 * JD-Core Version:    0.7.0.1
 */