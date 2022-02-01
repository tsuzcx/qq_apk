package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QueryADBannerUnit
  extends JceStruct
{
  static int cache_eAdType;
  static TimeRange cache_sShowTimeRange;
  public String btnText = "";
  public String description = "";
  public int detail_info = 0;
  public int duration = 0;
  public int eAdType = 0;
  public long iAdID = 0L;
  public long iStoreID = 0L;
  public long iTraceID = 0L;
  public int noCloseButton = 0;
  public int priority = 0;
  public int reopenHours = 0;
  public String report_info = "";
  public TimeRange sShowTimeRange = null;
  public String strJmpUrl = "";
  public String strPicMD5 = "";
  public String strPicUrl = "";
  public String strSchemeUrl = "";
  public String strStoreUrl = "";
  public String strTraceInfo = "";
  public int type = 0;
  
  public QueryADBannerUnit() {}
  
  public QueryADBannerUnit(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, TimeRange paramTimeRange, String paramString3, long paramLong3, String paramString4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString5, String paramString6, int paramInt7, String paramString7, String paramString8, String paramString9)
  {
    this.strPicUrl = paramString1;
    this.strJmpUrl = paramString2;
    this.iAdID = paramLong1;
    this.iTraceID = paramLong2;
    this.eAdType = paramInt1;
    this.sShowTimeRange = paramTimeRange;
    this.strStoreUrl = paramString3;
    this.iStoreID = paramLong3;
    this.strSchemeUrl = paramString4;
    this.detail_info = paramInt2;
    this.noCloseButton = paramInt3;
    this.reopenHours = paramInt4;
    this.priority = paramInt5;
    this.duration = paramInt6;
    this.report_info = paramString5;
    this.strPicMD5 = paramString6;
    this.type = paramInt7;
    this.description = paramString7;
    this.btnText = paramString8;
    this.strTraceInfo = paramString9;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPicUrl = paramJceInputStream.readString(0, true);
    this.strJmpUrl = paramJceInputStream.readString(1, true);
    this.iAdID = paramJceInputStream.read(this.iAdID, 2, true);
    this.iTraceID = paramJceInputStream.read(this.iTraceID, 3, true);
    this.eAdType = paramJceInputStream.read(this.eAdType, 4, true);
    if (cache_sShowTimeRange == null) {
      cache_sShowTimeRange = new TimeRange();
    }
    this.sShowTimeRange = ((TimeRange)paramJceInputStream.read(cache_sShowTimeRange, 5, false));
    this.strStoreUrl = paramJceInputStream.readString(6, false);
    this.iStoreID = paramJceInputStream.read(this.iStoreID, 7, false);
    this.strSchemeUrl = paramJceInputStream.readString(8, false);
    this.detail_info = paramJceInputStream.read(this.detail_info, 9, false);
    this.noCloseButton = paramJceInputStream.read(this.noCloseButton, 10, false);
    this.reopenHours = paramJceInputStream.read(this.reopenHours, 11, false);
    this.priority = paramJceInputStream.read(this.priority, 12, false);
    this.duration = paramJceInputStream.read(this.duration, 13, false);
    this.report_info = paramJceInputStream.readString(14, false);
    this.strPicMD5 = paramJceInputStream.readString(15, false);
    this.type = paramJceInputStream.read(this.type, 16, false);
    this.description = paramJceInputStream.readString(17, false);
    this.btnText = paramJceInputStream.readString(18, false);
    this.strTraceInfo = paramJceInputStream.readString(19, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPicUrl, 0);
    paramJceOutputStream.write(this.strJmpUrl, 1);
    paramJceOutputStream.write(this.iAdID, 2);
    paramJceOutputStream.write(this.iTraceID, 3);
    paramJceOutputStream.write(this.eAdType, 4);
    if (this.sShowTimeRange != null) {
      paramJceOutputStream.write(this.sShowTimeRange, 5);
    }
    if (this.strStoreUrl != null) {
      paramJceOutputStream.write(this.strStoreUrl, 6);
    }
    paramJceOutputStream.write(this.iStoreID, 7);
    if (this.strSchemeUrl != null) {
      paramJceOutputStream.write(this.strSchemeUrl, 8);
    }
    paramJceOutputStream.write(this.detail_info, 9);
    paramJceOutputStream.write(this.noCloseButton, 10);
    paramJceOutputStream.write(this.reopenHours, 11);
    paramJceOutputStream.write(this.priority, 12);
    paramJceOutputStream.write(this.duration, 13);
    if (this.report_info != null) {
      paramJceOutputStream.write(this.report_info, 14);
    }
    if (this.strPicMD5 != null) {
      paramJceOutputStream.write(this.strPicMD5, 15);
    }
    paramJceOutputStream.write(this.type, 16);
    if (this.description != null) {
      paramJceOutputStream.write(this.description, 17);
    }
    if (this.btnText != null) {
      paramJceOutputStream.write(this.btnText, 18);
    }
    if (this.strTraceInfo != null) {
      paramJceOutputStream.write(this.strTraceInfo, 19);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_AD_BANNER.QueryADBannerUnit
 * JD-Core Version:    0.7.0.1
 */