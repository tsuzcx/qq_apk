package cooperation.qlink;

import java.io.Serializable;

public class QlAndQQInterface$ExtraTransInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public long apOwner;
  public String localAbs;
  public String peerAbs;
  public int peerOs;
  
  public QlAndQQInterface$ExtraTransInfo(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    this.apOwner = paramLong;
    this.localAbs = paramString1;
    this.peerAbs = paramString2;
    this.peerOs = paramInt;
  }
  
  public String toString()
  {
    return "apOwner[" + this.apOwner + "]localAbs[" + this.localAbs + "] peerAbs[" + this.peerAbs + "] peerOs[" + this.peerOs + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qlink.QlAndQQInterface.ExtraTransInfo
 * JD-Core Version:    0.7.0.1
 */