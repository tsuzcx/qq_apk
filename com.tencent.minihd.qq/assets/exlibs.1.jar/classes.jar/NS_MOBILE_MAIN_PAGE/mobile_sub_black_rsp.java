package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_black_rsp
  extends JceStruct
{
  static s_black cache_black;
  public s_black black = null;
  
  public mobile_sub_black_rsp() {}
  
  public mobile_sub_black_rsp(s_black params_black)
  {
    this.black = params_black;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_black == null) {
      cache_black = new s_black();
    }
    this.black = ((s_black)paramJceInputStream.read(cache_black, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.black != null) {
      paramJceOutputStream.write(this.black, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_black_rsp
 * JD-Core Version:    0.7.0.1
 */