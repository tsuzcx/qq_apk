package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqAddDiscussMember
  extends JceStruct
{
  static ArrayList cache_Members;
  public long DiscussUin = 0L;
  public ArrayList Members = null;
  
  public ReqAddDiscussMember() {}
  
  public ReqAddDiscussMember(long paramLong, ArrayList paramArrayList)
  {
    this.DiscussUin = paramLong;
    this.Members = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.DiscussUin = paramJceInputStream.read(this.DiscussUin, 0, true);
    if (cache_Members == null)
    {
      cache_Members = new ArrayList();
      AddDiscussMemberInfo localAddDiscussMemberInfo = new AddDiscussMemberInfo();
      cache_Members.add(localAddDiscussMemberInfo);
    }
    this.Members = ((ArrayList)paramJceInputStream.read(cache_Members, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussUin, 0);
    paramJceOutputStream.write(this.Members, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.ReqAddDiscussMember
 * JD-Core Version:    0.7.0.1
 */