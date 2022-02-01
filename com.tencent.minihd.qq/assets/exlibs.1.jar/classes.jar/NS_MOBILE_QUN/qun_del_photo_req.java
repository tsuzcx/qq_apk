package NS_MOBILE_QUN;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class qun_del_photo_req
  extends JceStruct
{
  static Map cache_busi_param;
  static ArrayList cache_photoid_list;
  public String albumid = "";
  public String batchid = "";
  public Map busi_param = null;
  public int del_type = 0;
  public String feedskey = "";
  public String photoid = "";
  public ArrayList photoid_list = null;
  public String qunid = "";
  
  public qun_del_photo_req() {}
  
  public qun_del_photo_req(String paramString1, String paramString2, int paramInt, String paramString3, ArrayList paramArrayList, String paramString4, String paramString5, Map paramMap)
  {
    this.qunid = paramString1;
    this.albumid = paramString2;
    this.del_type = paramInt;
    this.photoid = paramString3;
    this.photoid_list = paramArrayList;
    this.batchid = paramString4;
    this.feedskey = paramString5;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.qunid = paramJceInputStream.readString(0, true);
    this.albumid = paramJceInputStream.readString(1, true);
    this.del_type = paramJceInputStream.read(this.del_type, 2, true);
    this.photoid = paramJceInputStream.readString(3, false);
    if (cache_photoid_list == null)
    {
      cache_photoid_list = new ArrayList();
      cache_photoid_list.add("");
    }
    this.photoid_list = ((ArrayList)paramJceInputStream.read(cache_photoid_list, 4, false));
    this.batchid = paramJceInputStream.readString(5, false);
    this.feedskey = paramJceInputStream.readString(6, false);
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.qunid, 0);
    paramJceOutputStream.write(this.albumid, 1);
    paramJceOutputStream.write(this.del_type, 2);
    if (this.photoid != null) {
      paramJceOutputStream.write(this.photoid, 3);
    }
    if (this.photoid_list != null) {
      paramJceOutputStream.write(this.photoid_list, 4);
    }
    if (this.batchid != null) {
      paramJceOutputStream.write(this.batchid, 5);
    }
    if (this.feedskey != null) {
      paramJceOutputStream.write(this.feedskey, 6);
    }
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_QUN.qun_del_photo_req
 * JD-Core Version:    0.7.0.1
 */