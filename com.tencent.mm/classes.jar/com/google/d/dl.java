package com.google.d;

import java.util.Iterator;
import java.util.List;

public class dl
  extends RuntimeException
{
  private final List<String> dVP;
  
  public dl()
  {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    this.dVP = null;
  }
  
  public dl(List<String> paramList)
  {
    super(aU(paramList));
    this.dVP = paramList;
  }
  
  private static String aU(List<String> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.d.dl
 * JD-Core Version:    0.7.0.1
 */