package com.tencent.matrix.c;

import org.json.JSONObject;

public final class b
{
  public Integer boJ;
  public JSONObject boK;
  public com.tencent.matrix.b.b boL;
  public String key;
  public String tag;
  
  public b() {}
  
  public b(int paramInt)
  {
    this.boJ = Integer.valueOf(paramInt);
  }
  
  public b(JSONObject paramJSONObject)
  {
    this.boK = paramJSONObject;
  }
  
  public final String toString()
  {
    return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[] { this.tag, this.boJ, this.key, this.boK });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.c.b
 * JD-Core Version:    0.7.0.1
 */