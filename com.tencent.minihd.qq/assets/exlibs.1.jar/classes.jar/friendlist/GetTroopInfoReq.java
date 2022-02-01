package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetTroopInfoReq
  extends JceStruct
{
  public long GroupCode = 0L;
  public long GroupUin = 0L;
  public byte isneedstatus = 0;
  public long uin = 0L;
  
  public GetTroopInfoReq() {}
  
  public GetTroopInfoReq(long paramLong1, long paramLong2, long paramLong3, byte paramByte)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.isneedstatus = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 2, true);
    this.isneedstatus = paramJceInputStream.read(this.isneedstatus, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 2);
    paramJceOutputStream.write(this.isneedstatus, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     friendlist.GetTroopInfoReq
 * JD-Core Version:    0.7.0.1
 */