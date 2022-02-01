package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_feed_alert_rsp
  extends JceStruct
{
  static count_info cache_stActiveInfo;
  static single_count cache_stGameBarInfo;
  static single_count cache_stPersionalInfo;
  static single_count cache_stZebraAppInfo;
  public int iNextTimeout = 0;
  public count_info stActiveInfo = null;
  public single_count stGameBarInfo = null;
  public single_count stPersionalInfo = null;
  public single_count stZebraAppInfo = null;
  
  public mobile_feed_alert_rsp() {}
  
  public mobile_feed_alert_rsp(count_info paramcount_info, single_count paramsingle_count1, int paramInt, single_count paramsingle_count2, single_count paramsingle_count3)
  {
    this.stActiveInfo = paramcount_info;
    this.stGameBarInfo = paramsingle_count1;
    this.iNextTimeout = paramInt;
    this.stZebraAppInfo = paramsingle_count2;
    this.stPersionalInfo = paramsingle_count3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stActiveInfo == null) {
      cache_stActiveInfo = new count_info();
    }
    this.stActiveInfo = ((count_info)paramJceInputStream.read(cache_stActiveInfo, 0, false));
    if (cache_stGameBarInfo == null) {
      cache_stGameBarInfo = new single_count();
    }
    this.stGameBarInfo = ((single_count)paramJceInputStream.read(cache_stGameBarInfo, 1, false));
    this.iNextTimeout = paramJceInputStream.read(this.iNextTimeout, 2, false);
    if (cache_stZebraAppInfo == null) {
      cache_stZebraAppInfo = new single_count();
    }
    this.stZebraAppInfo = ((single_count)paramJceInputStream.read(cache_stZebraAppInfo, 3, false));
    if (cache_stPersionalInfo == null) {
      cache_stPersionalInfo = new single_count();
    }
    this.stPersionalInfo = ((single_count)paramJceInputStream.read(cache_stPersionalInfo, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stActiveInfo != null) {
      paramJceOutputStream.write(this.stActiveInfo, 0);
    }
    if (this.stGameBarInfo != null) {
      paramJceOutputStream.write(this.stGameBarInfo, 1);
    }
    paramJceOutputStream.write(this.iNextTimeout, 2);
    if (this.stZebraAppInfo != null) {
      paramJceOutputStream.write(this.stZebraAppInfo, 3);
    }
    if (this.stPersionalInfo != null) {
      paramJceOutputStream.write(this.stPersionalInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_feed_alert_rsp
 * JD-Core Version:    0.7.0.1
 */