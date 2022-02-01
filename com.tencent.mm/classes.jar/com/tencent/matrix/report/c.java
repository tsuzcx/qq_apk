package com.tencent.matrix.report;

import com.tencent.matrix.e.b;
import org.json.JSONObject;

public class c
{
  public JSONObject cWe;
  public b cWf;
  public String key;
  public String tag;
  public int type;
  
  public c() {}
  
  public c(int paramInt)
  {
    this.type = paramInt;
  }
  
  public c(JSONObject paramJSONObject)
  {
    this.cWe = paramJSONObject;
  }
  
  public String toString()
  {
    String str = "";
    if (this.cWe != null) {
      str = this.cWe.toString();
    }
    return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[] { this.tag, Integer.valueOf(this.type), this.key, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.c
 * JD-Core Version:    0.7.0.1
 */