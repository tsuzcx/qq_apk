package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_ugcright_list_req
  extends JceStruct
{
  static s_ugc_data_key cache_udk;
  public int type = 0;
  public s_ugc_data_key udk = null;
  
  public mobile_sub_get_ugcright_list_req() {}
  
  public mobile_sub_get_ugcright_list_req(s_ugc_data_key params_ugc_data_key, int paramInt)
  {
    this.udk = params_ugc_data_key;
    this.type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_udk == null) {
      cache_udk = new s_ugc_data_key();
    }
    this.udk = ((s_ugc_data_key)paramJceInputStream.read(cache_udk, 0, true));
    this.type = paramJceInputStream.read(this.type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.udk, 0);
    paramJceOutputStream.write(this.type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_ugcright_list_req
 * JD-Core Version:    0.7.0.1
 */