package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DayWeather
  extends JceStruct
{
  public int WeatherId = 0;
  public String bWeather = "";
  public String bWind = "";
  public String eWeather = "";
  public String eWind = "";
  public int highTemp = 0;
  public int lowTemp = 0;
  
  public DayWeather() {}
  
  public DayWeather(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3)
  {
    this.highTemp = paramInt1;
    this.lowTemp = paramInt2;
    this.bWeather = paramString1;
    this.eWeather = paramString2;
    this.bWind = paramString3;
    this.eWind = paramString4;
    this.WeatherId = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.highTemp = paramJceInputStream.read(this.highTemp, 1, true);
    this.lowTemp = paramJceInputStream.read(this.lowTemp, 2, true);
    this.bWeather = paramJceInputStream.readString(3, true);
    this.eWeather = paramJceInputStream.readString(4, true);
    this.bWind = paramJceInputStream.readString(5, true);
    this.eWind = paramJceInputStream.readString(6, true);
    this.WeatherId = paramJceInputStream.read(this.WeatherId, 7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.highTemp, 1);
    paramJceOutputStream.write(this.lowTemp, 2);
    paramJceOutputStream.write(this.bWeather, 3);
    paramJceOutputStream.write(this.eWeather, 4);
    paramJceOutputStream.write(this.bWind, 5);
    paramJceOutputStream.write(this.eWind, 6);
    paramJceOutputStream.write(this.WeatherId, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.DayWeather
 * JD-Core Version:    0.7.0.1
 */