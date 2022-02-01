package MessageSvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRequestGroupMsgReadConfirm
  extends JceStruct
{
  public byte cVerifyType = 0;
  public long uGroupCode = 0L;
  public long uLastReadSeq = 0L;
  
  public SvcRequestGroupMsgReadConfirm() {}
  
  public SvcRequestGroupMsgReadConfirm(byte paramByte, long paramLong1, long paramLong2)
  {
    this.cVerifyType = paramByte;
    this.uGroupCode = paramLong1;
    this.uLastReadSeq = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cVerifyType = paramJceInputStream.read(this.cVerifyType, 0, true);
    this.uGroupCode = paramJceInputStream.read(this.uGroupCode, 1, true);
    this.uLastReadSeq = paramJceInputStream.read(this.uLastReadSeq, 2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cVerifyType, 0);
    paramJceOutputStream.write(this.uGroupCode, 1);
    paramJceOutputStream.write(this.uLastReadSeq, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     MessageSvcPack.SvcRequestGroupMsgReadConfirm
 * JD-Core Version:    0.7.0.1
 */