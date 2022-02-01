package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class mobile_sub_get_ugcright_list_rsp
  extends JceStruct
{
  static ArrayList cache_list;
  static s_ugc_data_key cache_udk;
  public ArrayList list = null;
  public s_ugc_data_key udk = null;
  
  public mobile_sub_get_ugcright_list_rsp() {}
  
  public mobile_sub_get_ugcright_list_rsp(s_ugc_data_key params_ugc_data_key, ArrayList paramArrayList)
  {
    this.udk = params_ugc_data_key;
    this.list = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_udk == null) {
      cache_udk = new s_ugc_data_key();
    }
    this.udk = ((s_ugc_data_key)paramJceInputStream.read(cache_udk, 0, true));
    if (cache_list == null)
    {
      cache_list = new ArrayList();
      cache_list.add(Long.valueOf(0L));
    }
    this.list = ((ArrayList)paramJceInputStream.read(cache_list, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.udk, 0);
    paramJceOutputStream.write(this.list, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_ugcright_list_rsp
 * JD-Core Version:    0.7.0.1
 */