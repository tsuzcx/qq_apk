package QMF_PROTOCAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_get_config_rsp
  extends JceStruct
{
  static Map cache_config;
  public Map config = null;
  public String cookies = "";
  public int scene_flag = 0;
  
  public mobile_get_config_rsp() {}
  
  public mobile_get_config_rsp(Map paramMap, String paramString, int paramInt)
  {
    this.config = paramMap;
    this.cookies = paramString;
    this.scene_flag = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_config == null)
    {
      cache_config = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      cache_config.put("", arrayOfByte);
    }
    this.config = ((Map)paramJceInputStream.read(cache_config, 0, false));
    this.cookies = paramJceInputStream.readString(1, false);
    this.scene_flag = paramJceInputStream.read(this.scene_flag, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.config != null) {
      paramJceOutputStream.write(this.config, 0);
    }
    if (this.cookies != null) {
      paramJceOutputStream.write(this.cookies, 1);
    }
    paramJceOutputStream.write(this.scene_flag, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QMF_PROTOCAL.mobile_get_config_rsp
 * JD-Core Version:    0.7.0.1
 */