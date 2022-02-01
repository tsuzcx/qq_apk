package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetOnlineInfoReq
  extends JceStruct
{
  public long dwReqType = 0L;
  public long dwUin = 0L;
  public String strMobile = "";
  public long version = 0L;
  
  public GetOnlineInfoReq() {}
  
  public GetOnlineInfoReq(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    this.dwReqType = paramLong1;
    this.dwUin = paramLong2;
    this.strMobile = paramString;
    this.version = paramLong3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwReqType = paramJceInputStream.read(this.dwReqType, 0, true);
    this.dwUin = paramJceInputStream.read(this.dwUin, 1, false);
    this.strMobile = paramJceInputStream.readString(2, false);
    this.version = paramJceInputStream.read(this.version, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwReqType, 0);
    paramJceOutputStream.write(this.dwUin, 1);
    if (this.strMobile != null) {
      paramJceOutputStream.write(this.strMobile, 2);
    }
    paramJceOutputStream.write(this.version, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.GetOnlineInfoReq
 * JD-Core Version:    0.7.0.1
 */