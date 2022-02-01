package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class mobile_custom_setting_cell_get_rsp
  extends JceStruct
{
  static Map cache_mapExtInfo;
  static ArrayList cache_vecBanner;
  static ArrayList cache_vecCell;
  public Map mapExtInfo = null;
  public ArrayList vecBanner = null;
  public ArrayList vecCell = null;
  
  public mobile_custom_setting_cell_get_rsp() {}
  
  public mobile_custom_setting_cell_get_rsp(ArrayList paramArrayList1, Map paramMap, ArrayList paramArrayList2)
  {
    this.vecCell = paramArrayList1;
    this.mapExtInfo = paramMap;
    this.vecBanner = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    Object localObject;
    if (cache_vecCell == null)
    {
      cache_vecCell = new ArrayList();
      localObject = new CustomSettingCell();
      cache_vecCell.add(localObject);
    }
    this.vecCell = ((ArrayList)paramJceInputStream.read(cache_vecCell, 0, false));
    if (cache_mapExtInfo == null)
    {
      cache_mapExtInfo = new HashMap();
      cache_mapExtInfo.put("", "");
    }
    this.mapExtInfo = ((Map)paramJceInputStream.read(cache_mapExtInfo, 1, false));
    if (cache_vecBanner == null)
    {
      cache_vecBanner = new ArrayList();
      localObject = new QbossBanner();
      cache_vecBanner.add(localObject);
    }
    this.vecBanner = ((ArrayList)paramJceInputStream.read(cache_vecBanner, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vecCell != null) {
      paramJceOutputStream.write(this.vecCell, 0);
    }
    if (this.mapExtInfo != null) {
      paramJceOutputStream.write(this.mapExtInfo, 1);
    }
    if (this.vecBanner != null) {
      paramJceOutputStream.write(this.vecBanner, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.mobile_custom_setting_cell_get_rsp
 * JD-Core Version:    0.7.0.1
 */