package NeighborSvc;

import EncounterSvc.ReqUserInfo;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetEntrance
  extends JceStruct
{
  static ReqUserInfo cache_stUserInfo;
  public ReqUserInfo stUserInfo = null;
  public int support_entrace_type = -1;
  
  public ReqGetEntrance() {}
  
  public ReqGetEntrance(ReqUserInfo paramReqUserInfo, int paramInt)
  {
    this.stUserInfo = paramReqUserInfo;
    this.support_entrace_type = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stUserInfo == null) {
      cache_stUserInfo = new ReqUserInfo();
    }
    this.stUserInfo = ((ReqUserInfo)paramJceInputStream.read(cache_stUserInfo, 0, true));
    this.support_entrace_type = paramJceInputStream.read(this.support_entrace_type, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stUserInfo, 0);
    paramJceOutputStream.write(this.support_entrace_type, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NeighborSvc.ReqGetEntrance
 * JD-Core Version:    0.7.0.1
 */