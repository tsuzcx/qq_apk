package MyCarrier;

import LBS.LBSInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqCarrier
  extends JceStruct
{
  static LBSInfo cache_lbsInfo;
  public int bindFrom = 0;
  public String bindMobile = "";
  public LBSInfo lbsInfo = null;
  public String optBuf = "";
  
  public ReqCarrier() {}
  
  public ReqCarrier(String paramString1, int paramInt, LBSInfo paramLBSInfo, String paramString2)
  {
    this.bindMobile = paramString1;
    this.bindFrom = paramInt;
    this.lbsInfo = paramLBSInfo;
    this.optBuf = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bindMobile = paramJceInputStream.readString(0, true);
    this.bindFrom = paramJceInputStream.read(this.bindFrom, 1, true);
    if (cache_lbsInfo == null) {
      cache_lbsInfo = new LBSInfo();
    }
    this.lbsInfo = ((LBSInfo)paramJceInputStream.read(cache_lbsInfo, 2, true));
    this.optBuf = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.bindMobile, 0);
    paramJceOutputStream.write(this.bindFrom, 1);
    paramJceOutputStream.write(this.lbsInfo, 2);
    paramJceOutputStream.write(this.optBuf, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MyCarrier.ReqCarrier
 * JD-Core Version:    0.7.0.1
 */