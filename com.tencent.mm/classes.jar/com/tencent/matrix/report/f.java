package com.tencent.matrix.report;

import com.tencent.matrix.d.b;
import org.json.JSONObject;

public class f
{
  public JSONObject cZZ;
  public b daa;
  public String key;
  public String tag;
  public int type;
  
  public f() {}
  
  public f(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    String str = "";
    if (this.cZZ != null) {
      str = this.cZZ.toString();
    }
    return String.format("tag[%s]type[%d];key[%s];content[%s]", new Object[] { this.tag, Integer.valueOf(this.type), this.key, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.f
 * JD-Core Version:    0.7.0.1
 */