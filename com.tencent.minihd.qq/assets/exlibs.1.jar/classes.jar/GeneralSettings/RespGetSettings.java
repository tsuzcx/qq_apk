package GeneralSettings;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class RespGetSettings
  extends JceStruct
{
  static ArrayList cache_Settings;
  public int Revision = 0;
  public ArrayList Settings = null;
  public long Total = 0L;
  
  public RespGetSettings() {}
  
  public RespGetSettings(int paramInt, ArrayList paramArrayList, long paramLong)
  {
    this.Revision = paramInt;
    this.Settings = paramArrayList;
    this.Total = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Revision = paramJceInputStream.read(this.Revision, 0, true);
    if (cache_Settings == null)
    {
      cache_Settings = new ArrayList();
      Setting localSetting = new Setting();
      cache_Settings.add(localSetting);
    }
    this.Settings = ((ArrayList)paramJceInputStream.read(cache_Settings, 1, false));
    this.Total = paramJceInputStream.read(this.Total, 2, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Revision, 0);
    if (this.Settings != null) {
      paramJceOutputStream.write(this.Settings, 1);
    }
    paramJceOutputStream.write(this.Total, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     GeneralSettings.RespGetSettings
 * JD-Core Version:    0.7.0.1
 */