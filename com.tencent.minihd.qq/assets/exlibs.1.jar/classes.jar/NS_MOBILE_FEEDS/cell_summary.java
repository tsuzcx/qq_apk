package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_summary
  extends JceStruct
{
  static ArrayList cache_summarypic;
  public int actiontype = 0;
  public int hasmore = 0;
  public String summary = "";
  public ArrayList summarypic = null;
  
  public cell_summary() {}
  
  public cell_summary(String paramString, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    this.summary = paramString;
    this.hasmore = paramInt1;
    this.actiontype = paramInt2;
    this.summarypic = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.summary = paramJceInputStream.readString(0, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    if (cache_summarypic == null)
    {
      cache_summarypic = new ArrayList();
      s_picdata locals_picdata = new s_picdata();
      cache_summarypic.add(locals_picdata);
    }
    this.summarypic = ((ArrayList)paramJceInputStream.read(cache_summarypic, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.summarypic != null) {
      paramJceOutputStream.write(this.summarypic, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_summary
 * JD-Core Version:    0.7.0.1
 */