package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class stGroupRankInfo
  extends JceStruct
{
  static ArrayList cache_vecRankMap;
  public byte cGroupRankSysFlag = 0;
  public byte cGroupRankUserFlag = 0;
  public long dwGroupCode = 0L;
  public long dwGroupRankSeq = 0L;
  public String strAdminName = "";
  public String strOwnerName = "";
  public ArrayList vecRankMap = null;
  
  public stGroupRankInfo() {}
  
  public stGroupRankInfo(long paramLong1, byte paramByte1, byte paramByte2, ArrayList paramArrayList, long paramLong2, String paramString1, String paramString2)
  {
    this.dwGroupCode = paramLong1;
    this.cGroupRankSysFlag = paramByte1;
    this.cGroupRankUserFlag = paramByte2;
    this.vecRankMap = paramArrayList;
    this.dwGroupRankSeq = paramLong2;
    this.strOwnerName = paramString1;
    this.strAdminName = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 0, true);
    this.cGroupRankSysFlag = paramJceInputStream.read(this.cGroupRankSysFlag, 1, false);
    this.cGroupRankUserFlag = paramJceInputStream.read(this.cGroupRankUserFlag, 2, false);
    if (cache_vecRankMap == null)
    {
      cache_vecRankMap = new ArrayList();
      stLevelRankPair localstLevelRankPair = new stLevelRankPair();
      cache_vecRankMap.add(localstLevelRankPair);
    }
    this.vecRankMap = ((ArrayList)paramJceInputStream.read(cache_vecRankMap, 3, false));
    this.dwGroupRankSeq = paramJceInputStream.read(this.dwGroupRankSeq, 4, false);
    this.strOwnerName = paramJceInputStream.readString(5, false);
    this.strAdminName = paramJceInputStream.readString(6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwGroupCode, 0);
    paramJceOutputStream.write(this.cGroupRankSysFlag, 1);
    paramJceOutputStream.write(this.cGroupRankUserFlag, 2);
    if (this.vecRankMap != null) {
      paramJceOutputStream.write(this.vecRankMap, 3);
    }
    paramJceOutputStream.write(this.dwGroupRankSeq, 4);
    if (this.strOwnerName != null) {
      paramJceOutputStream.write(this.strOwnerName, 5);
    }
    if (this.strAdminName != null) {
      paramJceOutputStream.write(this.strAdminName, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.stGroupRankInfo
 * JD-Core Version:    0.7.0.1
 */