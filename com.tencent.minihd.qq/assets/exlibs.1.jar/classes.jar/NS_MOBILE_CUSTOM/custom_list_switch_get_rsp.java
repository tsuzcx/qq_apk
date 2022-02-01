package NS_MOBILE_CUSTOM;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class custom_list_switch_get_rsp
  extends JceStruct
{
  static custom_list_switch cache_stSwitch;
  public custom_list_switch stSwitch = null;
  
  public custom_list_switch_get_rsp() {}
  
  public custom_list_switch_get_rsp(custom_list_switch paramcustom_list_switch)
  {
    this.stSwitch = paramcustom_list_switch;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stSwitch == null) {
      cache_stSwitch = new custom_list_switch();
    }
    this.stSwitch = ((custom_list_switch)paramJceInputStream.read(cache_stSwitch, 0, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.stSwitch != null) {
      paramJceOutputStream.write(this.stSwitch, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_CUSTOM.custom_list_switch_get_rsp
 * JD-Core Version:    0.7.0.1
 */