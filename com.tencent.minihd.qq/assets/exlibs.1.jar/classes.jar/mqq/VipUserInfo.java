package mqq;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class VipUserInfo
  extends JceStruct
{
  public int iGrowthSpeed = -1;
  public int iGrowthValue = -1;
  public int iOpenSVip = -1;
  public int iOpenVip = -1;
  public int iUpdateFreq = -1;
  public long iUpdateTime = -1L;
  public int iVipLevel = -1;
  public int iVipType = -1;
  
  public VipUserInfo() {}
  
  public VipUserInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7)
  {
    this.iOpenVip = paramInt1;
    this.iOpenSVip = paramInt2;
    this.iVipLevel = paramInt3;
    this.iVipType = paramInt4;
    this.iGrowthValue = paramInt5;
    this.iGrowthSpeed = paramInt6;
    this.iUpdateTime = paramLong;
    this.iUpdateFreq = paramInt7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iOpenVip = paramJceInputStream.read(this.iOpenVip, 1, true);
    this.iOpenSVip = paramJceInputStream.read(this.iOpenSVip, 2, true);
    this.iVipLevel = paramJceInputStream.read(this.iVipLevel, 3, true);
    this.iVipType = paramJceInputStream.read(this.iVipType, 4, true);
    this.iGrowthValue = paramJceInputStream.read(this.iGrowthValue, 5, true);
    this.iGrowthSpeed = paramJceInputStream.read(this.iGrowthSpeed, 6, true);
    this.iUpdateTime = paramJceInputStream.read(this.iUpdateTime, 7, false);
    this.iUpdateFreq = paramJceInputStream.read(this.iUpdateFreq, 8, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iOpenVip, 1);
    paramJceOutputStream.write(this.iOpenSVip, 2);
    paramJceOutputStream.write(this.iVipLevel, 3);
    paramJceOutputStream.write(this.iVipType, 4);
    paramJceOutputStream.write(this.iGrowthValue, 5);
    paramJceOutputStream.write(this.iGrowthSpeed, 6);
    paramJceOutputStream.write(this.iUpdateTime, 7);
    paramJceOutputStream.write(this.iUpdateFreq, 8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mqq.VipUserInfo
 * JD-Core Version:    0.7.0.1
 */