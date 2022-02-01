package QzoneCombine;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class PushInfo
  extends JceStruct
{
  static ArrayList cache_vecMsg;
  public long uin = 0L;
  public ArrayList vecMsg = null;
  
  public PushInfo() {}
  
  public PushInfo(long paramLong, ArrayList paramArrayList)
  {
    this.uin = paramLong;
    this.vecMsg = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    if (cache_vecMsg == null)
    {
      cache_vecMsg = new ArrayList();
      SingleMsg localSingleMsg = new SingleMsg();
      cache_vecMsg.add(localSingleMsg);
    }
    this.vecMsg = ((ArrayList)paramJceInputStream.read(cache_vecMsg, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.vecMsg != null) {
      paramJceOutputStream.write(this.vecMsg, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QzoneCombine.PushInfo
 * JD-Core Version:    0.7.0.1
 */