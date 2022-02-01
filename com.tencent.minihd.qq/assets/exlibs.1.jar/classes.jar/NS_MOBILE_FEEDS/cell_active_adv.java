package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class cell_active_adv
  extends JceStruct
{
  static s_picdata cache_picdata;
  public String button_text = "";
  public String copy = "";
  public int is_report = 0;
  public s_picdata picdata = null;
  public String report_url = "";
  public String up_copy = "";
  
  public cell_active_adv() {}
  
  public cell_active_adv(s_picdata params_picdata, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.picdata = params_picdata;
    this.copy = paramString1;
    this.button_text = paramString2;
    this.up_copy = paramString3;
    this.is_report = paramInt;
    this.report_url = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_picdata == null) {
      cache_picdata = new s_picdata();
    }
    this.picdata = ((s_picdata)paramJceInputStream.read(cache_picdata, 1, false));
    this.copy = paramJceInputStream.readString(4, false);
    this.button_text = paramJceInputStream.readString(7, false);
    this.up_copy = paramJceInputStream.readString(9, false);
    this.is_report = paramJceInputStream.read(this.is_report, 11, false);
    this.report_url = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.picdata != null) {
      paramJceOutputStream.write(this.picdata, 1);
    }
    if (this.copy != null) {
      paramJceOutputStream.write(this.copy, 4);
    }
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 7);
    }
    if (this.up_copy != null) {
      paramJceOutputStream.write(this.up_copy, 9);
    }
    paramJceOutputStream.write(this.is_report, 11);
    if (this.report_url != null) {
      paramJceOutputStream.write(this.report_url, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_active_adv
 * JD-Core Version:    0.7.0.1
 */