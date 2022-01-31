package com.tencent.matrix.e;

import org.json.JSONObject;

public final class b
{
  public Integer bOw;
  public JSONObject bOx;
  public com.tencent.matrix.d.b bOy;
  public String key;
  public String tag;
  
  public b() {}
  
  public b(int paramInt)
  {
    this.bOw = Integer.valueOf(paramInt);
  }
  
  public b(JSONObject paramJSONObject)
  {
    this.bOx = paramJSONObject;
  }
  
  public final void setType(int paramInt)
  {
    this.bOw = Integer.valueOf(paramInt);
  }
  
  public final String toString()
  {
    String str = "";
    if (this.bOx != null) {
      str = this.bOx.toString();
    }
    return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[] { this.tag, this.bOw, this.key, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.e.b
 * JD-Core Version:    0.7.0.1
 */