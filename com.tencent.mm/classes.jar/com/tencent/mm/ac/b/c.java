package com.tencent.mm.ac.b;

import org.json.JSONObject;

public abstract class c
  implements e
{
  private int index;
  public String name;
  
  public c(String paramString)
  {
    this.name = paramString;
  }
  
  public c(String paramString, int paramInt)
  {
    this.name = paramString;
    this.index = paramInt;
  }
  
  public abstract JSONObject aZh();
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ac.b.c
 * JD-Core Version:    0.7.0.1
 */