package NS_UNDEAL_COUNT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_count_req
  extends JceStruct
{
  static Map cache_mapBuf;
  static Map cache_mapTimeStamp;
  public int iRelationType = 0;
  public int iVisitQZoneType = 0;
  public Map mapBuf = null;
  public Map mapTimeStamp = null;
  public long uMask = 0L;
  
  public mobile_count_req() {}
  
  public mobile_count_req(long paramLong, int paramInt1, int paramInt2, Map paramMap1, Map paramMap2)
  {
    this.uMask = paramLong;
    this.iRelationType = paramInt1;
    this.iVisitQZoneType = paramInt2;
    this.mapBuf = paramMap1;
    this.mapTimeStamp = paramMap2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uMask = paramJceInputStream.read(this.uMask, 0, false);
    this.iRelationType = paramJceInputStream.read(this.iRelationType, 1, false);
    this.iVisitQZoneType = paramJceInputStream.read(this.iVisitQZoneType, 2, false);
    if (cache_mapBuf == null)
    {
      cache_mapBuf = new HashMap();
      s_comm_data locals_comm_data = new s_comm_data();
      cache_mapBuf.put(Long.valueOf(0L), locals_comm_data);
    }
    this.mapBuf = ((Map)paramJceInputStream.read(cache_mapBuf, 3, false));
    if (cache_mapTimeStamp == null)
    {
      cache_mapTimeStamp = new HashMap();
      cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 4, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uMask, 0);
    paramJceOutputStream.write(this.iRelationType, 1);
    paramJceOutputStream.write(this.iVisitQZoneType, 2);
    if (this.mapBuf != null) {
      paramJceOutputStream.write(this.mapBuf, 3);
    }
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_UNDEAL_COUNT.mobile_count_req
 * JD-Core Version:    0.7.0.1
 */