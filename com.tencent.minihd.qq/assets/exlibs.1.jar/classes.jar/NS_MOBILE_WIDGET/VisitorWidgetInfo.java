package NS_MOBILE_WIDGET;

import NS_MOBILE_COMM.yellow_info;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class VisitorWidgetInfo
  extends JceStruct
{
  static ArrayList cache_delta_visitor;
  static yellow_info cache_yellow_flag;
  public int blocked_visitor_count = 0;
  public ArrayList delta_visitor = null;
  public int today_delta = 0;
  public int today_visitor = 0;
  public int total_visitor = 0;
  public yellow_info yellow_flag = null;
  
  public VisitorWidgetInfo() {}
  
  public VisitorWidgetInfo(int paramInt1, int paramInt2, int paramInt3, yellow_info paramyellow_info, int paramInt4, ArrayList paramArrayList)
  {
    this.today_delta = paramInt1;
    this.today_visitor = paramInt2;
    this.total_visitor = paramInt3;
    this.yellow_flag = paramyellow_info;
    this.blocked_visitor_count = paramInt4;
    this.delta_visitor = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.today_delta = paramJceInputStream.read(this.today_delta, 0, false);
    this.today_visitor = paramJceInputStream.read(this.today_visitor, 1, false);
    this.total_visitor = paramJceInputStream.read(this.total_visitor, 2, false);
    if (cache_yellow_flag == null) {
      cache_yellow_flag = new yellow_info();
    }
    this.yellow_flag = ((yellow_info)paramJceInputStream.read(cache_yellow_flag, 4, false));
    this.blocked_visitor_count = paramJceInputStream.read(this.blocked_visitor_count, 5, false);
    if (cache_delta_visitor == null)
    {
      cache_delta_visitor = new ArrayList();
      Visitor localVisitor = new Visitor();
      cache_delta_visitor.add(localVisitor);
    }
    this.delta_visitor = ((ArrayList)paramJceInputStream.read(cache_delta_visitor, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.today_delta, 0);
    paramJceOutputStream.write(this.today_visitor, 1);
    paramJceOutputStream.write(this.total_visitor, 2);
    if (this.yellow_flag != null) {
      paramJceOutputStream.write(this.yellow_flag, 4);
    }
    paramJceOutputStream.write(this.blocked_visitor_count, 5);
    if (this.delta_visitor != null) {
      paramJceOutputStream.write(this.delta_visitor, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_WIDGET.VisitorWidgetInfo
 * JD-Core Version:    0.7.0.1
 */