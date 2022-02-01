package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class edit_batch_photo_req
  extends JceStruct
{
  static EditPhoto cache_PhotoInfo;
  static Map cache_busi_param;
  static ArrayList cache_picid_list;
  public EditPhoto PhotoInfo = null;
  public String albumid = "";
  public Map busi_param = null;
  public ArrayList picid_list = null;
  
  public edit_batch_photo_req() {}
  
  public edit_batch_photo_req(String paramString, ArrayList paramArrayList, EditPhoto paramEditPhoto, Map paramMap)
  {
    this.albumid = paramString;
    this.picid_list = paramArrayList;
    this.PhotoInfo = paramEditPhoto;
    this.busi_param = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.albumid = paramJceInputStream.readString(0, true);
    if (cache_picid_list == null)
    {
      cache_picid_list = new ArrayList();
      cache_picid_list.add("");
    }
    this.picid_list = ((ArrayList)paramJceInputStream.read(cache_picid_list, 1, true));
    if (cache_PhotoInfo == null) {
      cache_PhotoInfo = new EditPhoto();
    }
    this.PhotoInfo = ((EditPhoto)paramJceInputStream.read(cache_PhotoInfo, 2, true));
    if (cache_busi_param == null)
    {
      cache_busi_param = new HashMap();
      cache_busi_param.put(Integer.valueOf(0), "");
    }
    this.busi_param = ((Map)paramJceInputStream.read(cache_busi_param, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.albumid, 0);
    paramJceOutputStream.write(this.picid_list, 1);
    paramJceOutputStream.write(this.PhotoInfo, 2);
    if (this.busi_param != null) {
      paramJceOutputStream.write(this.busi_param, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_PHOTO.edit_batch_photo_req
 * JD-Core Version:    0.7.0.1
 */