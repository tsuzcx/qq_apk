package NS_MOBILE_MAIN_PAGE;

import NS_MOBILE_COMM.ParasiticUnit;
import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_sub_get_setcover_list_rsp
  extends JceStruct
{
  static ArrayList cache_cates1;
  static ArrayList cache_cates2;
  static Map cache_mapTimeStamp;
  static ArrayList cache_recommendCovers;
  static ArrayList cache_vecParasiticUnit;
  static yellow_info cache_yellowFlag;
  public ArrayList cates1 = null;
  public ArrayList cates2 = null;
  public Map mapTimeStamp = null;
  public ArrayList recommendCovers = null;
  public ArrayList vecParasiticUnit = null;
  public yellow_info yellowFlag = null;
  
  public mobile_sub_get_setcover_list_rsp() {}
  
  public mobile_sub_get_setcover_list_rsp(ArrayList paramArrayList1, yellow_info paramyellow_info, ArrayList paramArrayList2, Map paramMap, ArrayList paramArrayList3, ArrayList paramArrayList4)
  {
    this.cates1 = paramArrayList1;
    this.yellowFlag = paramyellow_info;
    this.recommendCovers = paramArrayList2;
    this.mapTimeStamp = paramMap;
    this.cates2 = paramArrayList3;
    this.vecParasiticUnit = paramArrayList4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_cates1 == null)
    {
      cache_cates1 = new ArrayList();
      localObject = new CoverCate();
      cache_cates1.add(localObject);
    }
    this.cates1 = ((ArrayList)paramJceInputStream.read(cache_cates1, 0, false));
    if (cache_yellowFlag == null) {
      cache_yellowFlag = new yellow_info();
    }
    this.yellowFlag = ((yellow_info)paramJceInputStream.read(cache_yellowFlag, 1, false));
    if (cache_recommendCovers == null)
    {
      cache_recommendCovers = new ArrayList();
      localObject = new CoverRecommend();
      cache_recommendCovers.add(localObject);
    }
    this.recommendCovers = ((ArrayList)paramJceInputStream.read(cache_recommendCovers, 2, false));
    if (cache_mapTimeStamp == null)
    {
      cache_mapTimeStamp = new HashMap();
      cache_mapTimeStamp.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.mapTimeStamp = ((Map)paramJceInputStream.read(cache_mapTimeStamp, 3, false));
    if (cache_cates2 == null)
    {
      cache_cates2 = new ArrayList();
      localObject = new CoverCate();
      cache_cates2.add(localObject);
    }
    this.cates2 = ((ArrayList)paramJceInputStream.read(cache_cates2, 4, false));
    if (cache_vecParasiticUnit == null)
    {
      cache_vecParasiticUnit = new ArrayList();
      localObject = new ParasiticUnit();
      cache_vecParasiticUnit.add(localObject);
    }
    this.vecParasiticUnit = ((ArrayList)paramJceInputStream.read(cache_vecParasiticUnit, 5, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.cates1 != null) {
      paramJceOutputStream.write(this.cates1, 0);
    }
    if (this.yellowFlag != null) {
      paramJceOutputStream.write(this.yellowFlag, 1);
    }
    if (this.recommendCovers != null) {
      paramJceOutputStream.write(this.recommendCovers, 2);
    }
    if (this.mapTimeStamp != null) {
      paramJceOutputStream.write(this.mapTimeStamp, 3);
    }
    if (this.cates2 != null) {
      paramJceOutputStream.write(this.cates2, 4);
    }
    if (this.vecParasiticUnit != null) {
      paramJceOutputStream.write(this.vecParasiticUnit, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_setcover_list_rsp
 * JD-Core Version:    0.7.0.1
 */