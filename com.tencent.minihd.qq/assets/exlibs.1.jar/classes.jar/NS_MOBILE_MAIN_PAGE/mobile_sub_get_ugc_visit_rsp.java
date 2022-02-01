package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_ugc_visit_rsp
  extends JceStruct
{
  static s_visit cache_visit;
  public boolean end = true;
  public String page = "";
  public s_visit visit = null;
  
  public mobile_sub_get_ugc_visit_rsp() {}
  
  public mobile_sub_get_ugc_visit_rsp(s_visit params_visit, String paramString, boolean paramBoolean)
  {
    this.visit = params_visit;
    this.page = paramString;
    this.end = paramBoolean;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_visit == null) {
      cache_visit = new s_visit();
    }
    this.visit = ((s_visit)paramJceInputStream.read(cache_visit, 0, false));
    this.page = paramJceInputStream.readString(1, false);
    this.end = paramJceInputStream.read(this.end, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.visit != null) {
      paramJceOutputStream.write(this.visit, 0);
    }
    if (this.page != null) {
      paramJceOutputStream.write(this.page, 1);
    }
    paramJceOutputStream.write(this.end, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_ugc_visit_rsp
 * JD-Core Version:    0.7.0.1
 */