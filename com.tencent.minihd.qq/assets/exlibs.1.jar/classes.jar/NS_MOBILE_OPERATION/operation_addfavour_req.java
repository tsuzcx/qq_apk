package NS_MOBILE_OPERATION;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class operation_addfavour_req
  extends JceStruct
{
  static Map cache_busi_params;
  static ArrayList cache_photo_url;
  public long appid = 0L;
  public Map busi_params = null;
  public String cellid = "";
  public long owner_uin = 0L;
  public ArrayList photo_url = null;
  public String sid = "";
  public long subid = 0L;
  public String text = "";
  public String ugc_key = "";
  
  public operation_addfavour_req() {}
  
  public operation_addfavour_req(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, ArrayList paramArrayList, String paramString4, Map paramMap)
  {
    this.owner_uin = paramLong1;
    this.appid = paramLong2;
    this.subid = paramLong3;
    this.cellid = paramString1;
    this.sid = paramString2;
    this.ugc_key = paramString3;
    this.photo_url = paramArrayList;
    this.text = paramString4;
    this.busi_params = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.owner_uin = paramJceInputStream.read(this.owner_uin, 0, false);
    this.appid = paramJceInputStream.read(this.appid, 1, false);
    this.subid = paramJceInputStream.read(this.subid, 2, false);
    this.cellid = paramJceInputStream.readString(3, false);
    this.sid = paramJceInputStream.readString(4, false);
    this.ugc_key = paramJceInputStream.readString(5, false);
    if (cache_photo_url == null)
    {
      cache_photo_url = new ArrayList();
      PhotoInformation localPhotoInformation = new PhotoInformation();
      cache_photo_url.add(localPhotoInformation);
    }
    this.photo_url = ((ArrayList)paramJceInputStream.read(cache_photo_url, 6, false));
    this.text = paramJceInputStream.readString(7, false);
    if (cache_busi_params == null)
    {
      cache_busi_params = new HashMap();
      cache_busi_params.put("", "");
    }
    this.busi_params = ((Map)paramJceInputStream.read(cache_busi_params, 8, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.owner_uin, 0);
    paramJceOutputStream.write(this.appid, 1);
    paramJceOutputStream.write(this.subid, 2);
    if (this.cellid != null) {
      paramJceOutputStream.write(this.cellid, 3);
    }
    if (this.sid != null) {
      paramJceOutputStream.write(this.sid, 4);
    }
    if (this.ugc_key != null) {
      paramJceOutputStream.write(this.ugc_key, 5);
    }
    if (this.photo_url != null) {
      paramJceOutputStream.write(this.photo_url, 6);
    }
    if (this.text != null) {
      paramJceOutputStream.write(this.text, 7);
    }
    if (this.busi_params != null) {
      paramJceOutputStream.write(this.busi_params, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_OPERATION.operation_addfavour_req
 * JD-Core Version:    0.7.0.1
 */