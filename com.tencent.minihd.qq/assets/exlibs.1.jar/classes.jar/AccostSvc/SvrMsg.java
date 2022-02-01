package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvrMsg
  extends JceStruct
{
  static ReqHeader cache_stHeader;
  static Msg cache_stMsg;
  public byte bNeedAckClientMsg = 0;
  public byte bResend = 0;
  public ReqHeader stHeader = null;
  public Msg stMsg = null;
  
  public SvrMsg() {}
  
  public SvrMsg(ReqHeader paramReqHeader, Msg paramMsg, byte paramByte1, byte paramByte2)
  {
    this.stHeader = paramReqHeader;
    this.stMsg = paramMsg;
    this.bNeedAckClientMsg = paramByte1;
    this.bResend = paramByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stHeader == null) {
      cache_stHeader = new ReqHeader();
    }
    this.stHeader = ((ReqHeader)paramJceInputStream.read(cache_stHeader, 0, true));
    if (cache_stMsg == null) {
      cache_stMsg = new Msg();
    }
    this.stMsg = ((Msg)paramJceInputStream.read(cache_stMsg, 1, true));
    this.bNeedAckClientMsg = paramJceInputStream.read(this.bNeedAckClientMsg, 2, false);
    this.bResend = paramJceInputStream.read(this.bResend, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stHeader, 0);
    paramJceOutputStream.write(this.stMsg, 1);
    paramJceOutputStream.write(this.bNeedAckClientMsg, 2);
    paramJceOutputStream.write(this.bResend, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     AccostSvc.SvrMsg
 * JD-Core Version:    0.7.0.1
 */