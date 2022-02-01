package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqGetDiscussInteRemark
  extends JceStruct
{
  static ArrayList cache_UinList;
  public long DiscussUin = 0L;
  public ArrayList UinList = null;
  
  public ReqGetDiscussInteRemark() {}
  
  public ReqGetDiscussInteRemark(long paramLong, ArrayList paramArrayList)
  {
    this.DiscussUin = paramLong;
    this.UinList = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_UinList == null)
    {
      cache_UinList = new ArrayList();
      cache_UinList.add(Long.valueOf(0L));
    }
    this.UinList = ((ArrayList)paramJceInputStream.read(cache_UinList, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.UinList, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.ReqGetDiscussInteRemark
 * JD-Core Version:    0.7.0.1
 */