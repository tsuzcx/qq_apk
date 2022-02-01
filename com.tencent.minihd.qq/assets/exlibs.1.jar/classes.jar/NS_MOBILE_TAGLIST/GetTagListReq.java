package NS_MOBILE_TAGLIST;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetTagListReq
  extends JceStruct
{
  public String fingerPrint = "";
  public byte ifGetFriendGroup = 0;
  public long uin = 0L;
  
  public GetTagListReq() {}
  
  public GetTagListReq(long paramLong, byte paramByte, String paramString)
  {
    this.uin = paramLong;
    this.ifGetFriendGroup = paramByte;
    this.fingerPrint = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.ifGetFriendGroup = paramJceInputStream.read(this.ifGetFriendGroup, 1, true);
    this.fingerPrint = paramJceInputStream.readString(2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.ifGetFriendGroup, 1);
    if (this.fingerPrint != null) {
      paramJceOutputStream.write(this.fingerPrint, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TAGLIST.GetTagListReq
 * JD-Core Version:    0.7.0.1
 */