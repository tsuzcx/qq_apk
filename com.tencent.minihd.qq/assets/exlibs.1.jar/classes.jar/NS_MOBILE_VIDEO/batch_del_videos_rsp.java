package NS_MOBILE_VIDEO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class batch_del_videos_rsp
  extends JceStruct
{
  static ArrayList cache_summarys;
  public String msg = "";
  public int ret = 0;
  public ArrayList summarys = null;
  
  public batch_del_videos_rsp() {}
  
  public batch_del_videos_rsp(int paramInt, String paramString, ArrayList paramArrayList)
  {
    this.ret = paramInt;
    this.msg = paramString;
    this.summarys = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, false);
    this.msg = paramJceInputStream.readString(1, false);
    if (cache_summarys == null)
    {
      cache_summarys = new ArrayList();
      DelVideoSummary localDelVideoSummary = new DelVideoSummary();
      cache_summarys.add(localDelVideoSummary);
    }
    this.summarys = ((ArrayList)paramJceInputStream.read(cache_summarys, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    if (this.msg != null) {
      paramJceOutputStream.write(this.msg, 1);
    }
    if (this.summarys != null) {
      paramJceOutputStream.write(this.summarys, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_VIDEO.batch_del_videos_rsp
 * JD-Core Version:    0.7.0.1
 */