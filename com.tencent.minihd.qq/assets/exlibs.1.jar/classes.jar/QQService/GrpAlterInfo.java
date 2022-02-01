package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GrpAlterInfo
  extends JceStruct
{
  static ArrayList cache_AlterInfo;
  public ArrayList AlterInfo = null;
  public long GrpId = 0L;
  
  public GrpAlterInfo() {}
  
  public GrpAlterInfo(long paramLong, ArrayList paramArrayList)
  {
    this.GrpId = paramLong;
    this.AlterInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GrpId = paramJceInputStream.read(this.GrpId, 0, true);
    if (cache_AlterInfo == null)
    {
      cache_AlterInfo = new ArrayList();
      GrpInfoItem localGrpInfoItem = new GrpInfoItem();
      cache_AlterInfo.add(localGrpInfoItem);
    }
    this.AlterInfo = ((ArrayList)paramJceInputStream.read(cache_AlterInfo, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GrpId, 0);
    paramJceOutputStream.write(this.AlterInfo, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.GrpAlterInfo
 * JD-Core Version:    0.7.0.1
 */