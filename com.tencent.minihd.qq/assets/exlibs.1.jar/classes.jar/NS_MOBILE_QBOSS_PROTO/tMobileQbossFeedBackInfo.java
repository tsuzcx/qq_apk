package NS_MOBILE_QBOSS_PROTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class tMobileQbossFeedBackInfo
  extends JceStruct
{
  public int iOperSource = 0;
  public int iOperType = 0;
  public String sQBosstrace = "";
  public String sQua = "";
  public String sUserID = "";
  public long uiUin = 0L;
  
  public tMobileQbossFeedBackInfo() {}
  
  public tMobileQbossFeedBackInfo(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.uiUin = paramLong;
    this.sQBosstrace = paramString1;
    this.iOperType = paramInt1;
    this.iOperSource = paramInt2;
    this.sQua = paramString2;
    this.sUserID = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uiUin = paramJceInputStream.read(this.uiUin, 0, true);
    this.sQBosstrace = paramJceInputStream.readString(1, true);
    this.iOperType = paramJceInputStream.read(this.iOperType, 2, true);
    this.iOperSource = paramJceInputStream.read(this.iOperSource, 3, false);
    this.sQua = paramJceInputStream.readString(4, false);
    this.sUserID = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uiUin, 0);
    paramJceOutputStream.write(this.sQBosstrace, 1);
    paramJceOutputStream.write(this.iOperType, 2);
    paramJceOutputStream.write(this.iOperSource, 3);
    if (this.sQua != null) {
      paramJceOutputStream.write(this.sQua, 4);
    }
    if (this.sUserID != null) {
      paramJceOutputStream.write(this.sUserID, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QBOSS_PROTO.tMobileQbossFeedBackInfo
 * JD-Core Version:    0.7.0.1
 */