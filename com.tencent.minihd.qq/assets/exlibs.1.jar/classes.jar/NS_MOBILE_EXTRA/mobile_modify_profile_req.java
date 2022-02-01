package NS_MOBILE_EXTRA;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_modify_profile_req
  extends JceStruct
{
  static s_profile_for_set cache_profile;
  public s_profile_for_set profile = null;
  public long uin = 0L;
  
  public mobile_modify_profile_req() {}
  
  public mobile_modify_profile_req(long paramLong, s_profile_for_set params_profile_for_set)
  {
    this.uin = paramLong;
    this.profile = params_profile_for_set;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    if (cache_profile == null) {
      cache_profile = new s_profile_for_set();
    }
    this.profile = ((s_profile_for_set)paramJceInputStream.read(cache_profile, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.profile != null) {
      paramJceOutputStream.write(this.profile, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_EXTRA.mobile_modify_profile_req
 * JD-Core Version:    0.7.0.1
 */