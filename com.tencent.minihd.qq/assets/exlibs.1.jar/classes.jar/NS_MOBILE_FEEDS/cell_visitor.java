package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class cell_visitor
  extends JceStruct
{
  static ArrayList cache_visitors;
  public byte mod = 0;
  public int view_count = 0;
  public int view_count_byfriends = 0;
  public int visitor_count = 0;
  public ArrayList visitors = null;
  
  public cell_visitor() {}
  
  public cell_visitor(int paramInt1, int paramInt2, ArrayList paramArrayList, byte paramByte, int paramInt3)
  {
    this.view_count = paramInt1;
    this.visitor_count = paramInt2;
    this.visitors = paramArrayList;
    this.mod = paramByte;
    this.view_count_byfriends = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.view_count = paramJceInputStream.read(this.view_count, 0, false);
    this.visitor_count = paramJceInputStream.read(this.visitor_count, 1, false);
    if (cache_visitors == null)
    {
      cache_visitors = new ArrayList();
      s_user locals_user = new s_user();
      cache_visitors.add(locals_user);
    }
    this.visitors = ((ArrayList)paramJceInputStream.read(cache_visitors, 2, false));
    this.mod = paramJceInputStream.read(this.mod, 3, false);
    this.view_count_byfriends = paramJceInputStream.read(this.view_count_byfriends, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.view_count, 0);
    paramJceOutputStream.write(this.visitor_count, 1);
    if (this.visitors != null) {
      paramJceOutputStream.write(this.visitors, 2);
    }
    paramJceOutputStream.write(this.mod, 3);
    paramJceOutputStream.write(this.view_count_byfriends, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_FEEDS.cell_visitor
 * JD-Core Version:    0.7.0.1
 */