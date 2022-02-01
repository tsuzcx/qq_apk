package ADV_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class s_anti_cheat
  extends JceStruct
{
  static s_coordinate cache_pop_posi;
  static s_coordinate cache_push_posi;
  public int click_interval = -999;
  public int down_delay = -999;
  public int drag_flag = 0;
  public int play_time = -999;
  public s_coordinate pop_posi = null;
  public s_coordinate push_posi = null;
  public int switch_flag = 0;
  public int up_delay = -999;
  
  public s_anti_cheat() {}
  
  public s_anti_cheat(s_coordinate params_coordinate1, s_coordinate params_coordinate2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.push_posi = params_coordinate1;
    this.pop_posi = params_coordinate2;
    this.click_interval = paramInt1;
    this.play_time = paramInt2;
    this.down_delay = paramInt3;
    this.up_delay = paramInt4;
    this.drag_flag = paramInt5;
    this.switch_flag = paramInt6;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_push_posi == null) {
      cache_push_posi = new s_coordinate();
    }
    this.push_posi = ((s_coordinate)paramJceInputStream.read(cache_push_posi, 0, false));
    if (cache_pop_posi == null) {
      cache_pop_posi = new s_coordinate();
    }
    this.pop_posi = ((s_coordinate)paramJceInputStream.read(cache_pop_posi, 1, false));
    this.click_interval = paramJceInputStream.read(this.click_interval, 2, false);
    this.play_time = paramJceInputStream.read(this.play_time, 3, false);
    this.down_delay = paramJceInputStream.read(this.down_delay, 4, false);
    this.up_delay = paramJceInputStream.read(this.up_delay, 5, false);
    this.drag_flag = paramJceInputStream.read(this.drag_flag, 6, false);
    this.switch_flag = paramJceInputStream.read(this.switch_flag, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.push_posi != null) {
      paramJceOutputStream.write(this.push_posi, 0);
    }
    if (this.pop_posi != null) {
      paramJceOutputStream.write(this.pop_posi, 1);
    }
    paramJceOutputStream.write(this.click_interval, 2);
    paramJceOutputStream.write(this.play_time, 3);
    paramJceOutputStream.write(this.down_delay, 4);
    paramJceOutputStream.write(this.up_delay, 5);
    paramJceOutputStream.write(this.drag_flag, 6);
    paramJceOutputStream.write(this.switch_flag, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ADV_REPORT.s_anti_cheat
 * JD-Core Version:    0.7.0.1
 */