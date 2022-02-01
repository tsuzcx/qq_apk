package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FeedSkinInfo
  extends JceStruct
{
  public String desc = "";
  public int iExpireTime = 0;
  public int iHasNewFlag = 0;
  public int iPrice = 0;
  public int iVipPrize = 0;
  public long lTime = 0L;
  public long lUin = 0L;
  public String sPicUrl = "";
  public String sSkinId = "";
  public int sSkinType = 0;
  public String strItemSummary = "";
  public String strThumbUrl = "";
  public String strTraceInfo = "";
  public String title = "";
  public long uiSettleTime = 0L;
  public int vip_property = 0;
  
  public FeedSkinInfo() {}
  
  public FeedSkinInfo(String paramString1, long paramLong1, String paramString2, long paramLong2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong3, String paramString5, String paramString6, String paramString7, int paramInt6)
  {
    this.sSkinId = paramString1;
    this.lUin = paramLong1;
    this.sPicUrl = paramString2;
    this.lTime = paramLong2;
    this.desc = paramString3;
    this.title = paramString4;
    this.vip_property = paramInt1;
    this.sSkinType = paramInt2;
    this.iPrice = paramInt3;
    this.iVipPrize = paramInt4;
    this.iExpireTime = paramInt5;
    this.uiSettleTime = paramLong3;
    this.strItemSummary = paramString5;
    this.strThumbUrl = paramString6;
    this.strTraceInfo = paramString7;
    this.iHasNewFlag = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.sSkinId = paramJceInputStream.readString(0, false);
    this.lUin = paramJceInputStream.read(this.lUin, 1, false);
    this.sPicUrl = paramJceInputStream.readString(2, false);
    this.lTime = paramJceInputStream.read(this.lTime, 3, false);
    this.desc = paramJceInputStream.readString(4, false);
    this.title = paramJceInputStream.readString(5, false);
    this.vip_property = paramJceInputStream.read(this.vip_property, 6, false);
    this.sSkinType = paramJceInputStream.read(this.sSkinType, 7, false);
    this.iPrice = paramJceInputStream.read(this.iPrice, 8, false);
    this.iVipPrize = paramJceInputStream.read(this.iVipPrize, 9, false);
    this.iExpireTime = paramJceInputStream.read(this.iExpireTime, 10, false);
    this.uiSettleTime = paramJceInputStream.read(this.uiSettleTime, 11, false);
    this.strItemSummary = paramJceInputStream.readString(12, false);
    this.strThumbUrl = paramJceInputStream.readString(13, false);
    this.strTraceInfo = paramJceInputStream.readString(14, false);
    this.iHasNewFlag = paramJceInputStream.read(this.iHasNewFlag, 15, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.sSkinId != null) {
      paramJceOutputStream.write(this.sSkinId, 0);
    }
    paramJceOutputStream.write(this.lUin, 1);
    if (this.sPicUrl != null) {
      paramJceOutputStream.write(this.sPicUrl, 2);
    }
    paramJceOutputStream.write(this.lTime, 3);
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 4);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 5);
    }
    paramJceOutputStream.write(this.vip_property, 6);
    paramJceOutputStream.write(this.sSkinType, 7);
    paramJceOutputStream.write(this.iPrice, 8);
    paramJceOutputStream.write(this.iVipPrize, 9);
    paramJceOutputStream.write(this.iExpireTime, 10);
    paramJceOutputStream.write(this.uiSettleTime, 11);
    if (this.strItemSummary != null) {
      paramJceOutputStream.write(this.strItemSummary, 12);
    }
    if (this.strThumbUrl != null) {
      paramJceOutputStream.write(this.strThumbUrl, 13);
    }
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 14);
    }
    paramJceOutputStream.write(this.iHasNewFlag, 15);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.FeedSkinInfo
 * JD-Core Version:    0.7.0.1
 */