package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class mobile_sub_get_theme_list_req
  extends JceStruct
{
  public String strAttachInfo = "";
  
  public mobile_sub_get_theme_list_req() {}
  
  public mobile_sub_get_theme_list_req(String paramString)
  {
    this.strAttachInfo = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strAttachInfo = paramJceInputStream.readString(0, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.strAttachInfo != null) {
      paramJceOutputStream.write(this.strAttachInfo, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_MAIN_PAGE.mobile_sub_get_theme_list_req
 * JD-Core Version:    0.7.0.1
 */