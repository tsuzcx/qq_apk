package com.tencent.matrix.report;

import com.tencent.matrix.d.b;
import org.json.JSONObject;

public class g
{
  public b eYA;
  public JSONObject eYz;
  public String key;
  public String tag;
  public int type;
  
  public g() {}
  
  public g(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    String str = "";
    if (this.eYz != null) {
      str = this.eYz.toString();
    }
    return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[] { this.tag, Integer.valueOf(this.type), this.key, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.g
 * JD-Core Version:    0.7.0.1
 */