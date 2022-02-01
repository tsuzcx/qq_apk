package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetFace
  extends JceStruct
{
  static ReqHead cache_stHeader;
  static UserCntlData cache_stUserData;
  public int iPageSize = -1;
  public long lUIN = 0L;
  public ReqHead stHeader = null;
  public UserCntlData stUserData = null;
  
  public ReqGetFace() {}
  
  public ReqGetFace(ReqHead paramReqHead, long paramLong, UserCntlData paramUserCntlData, int paramInt)
  {
    this.stHeader = paramReqHead;
    this.lUIN = paramLong;
    this.stUserData = paramUserCntlData;
    this.iPageSize = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHead();
    }
    this.stHeader = ((ReqHead)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lUIN = paramJceInputStream.read(this.lUIN, 1, true);
    if (cache_stUserData == null) {
      cache_stUserData = new UserCntlData();
    }
    this.stUserData = ((UserCntlData)paramJceInputStream.read(cache_stUserData, 2, false));
    this.iPageSize = paramJceInputStream.read(this.iPageSize, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lUIN, 1);
    if (this.stUserData != null) {
      paramJceOutputStream.write(this.stUserData, 2);
    }
    paramJceOutputStream.write(this.iPageSize, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.ReqGetFace
 * JD-Core Version:    0.7.0.1
 */