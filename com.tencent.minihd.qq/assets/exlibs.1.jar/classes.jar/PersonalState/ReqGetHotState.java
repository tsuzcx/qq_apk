package PersonalState;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqGetHotState
  extends JceStruct
{
  static BusiReqHead cache_oHead;
  public BusiReqHead oHead = null;
  
  public ReqGetHotState() {}
  
  public ReqGetHotState(BusiReqHead paramBusiReqHead)
  {
    this.oHead = paramBusiReqHead;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_oHead == null) {
      cache_oHead = new BusiReqHead();
    }
    this.oHead = ((BusiReqHead)paramJceInputStream.read(cache_oHead, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.oHead, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     PersonalState.ReqGetHotState
 * JD-Core Version:    0.7.0.1
 */