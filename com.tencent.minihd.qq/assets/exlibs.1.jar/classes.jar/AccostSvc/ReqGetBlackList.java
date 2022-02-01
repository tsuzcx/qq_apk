package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetBlackList
  extends JceStruct
{
  static int cache_eListType;
  static int cache_eType;
  static ReqHeader cache_stHeader;
  public int eListType = 1;
  public int eType = 0;
  public long lNextMid = 0L;
  public ReqHeader stHeader = null;
  
  public ReqGetBlackList() {}
  
  public ReqGetBlackList(ReqHeader paramReqHeader, long paramLong, int paramInt1, int paramInt2)
  {
    this.stHeader = paramReqHeader;
    this.lNextMid = paramLong;
    this.eListType = paramInt1;
    this.eType = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 1, true);
    this.eListType = paramJceInputStream.read(this.eListType, 2, false);
    this.eType = paramJceInputStream.read(this.eType, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.lNextMid, 1);
    paramJceOutputStream.write(this.eListType, 2);
    paramJceOutputStream.write(this.eType, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     AccostSvc.ReqGetBlackList
 * JD-Core Version:    0.7.0.1
 */