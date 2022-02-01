package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GSMCell
  extends JceStruct
{
  public int cellid = -1;
  public int lac = -1;
  public short mcc = -1;
  public short mnc = -1;
  
  public GSMCell() {}
  
  public GSMCell(short paramShort1, short paramShort2, int paramInt1, int paramInt2)
  {
    this.mcc = paramShort1;
    this.mnc = paramShort2;
    this.lac = paramInt1;
    this.cellid = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.mcc = paramJceInputStream.read(this.mcc, 0, true);
    this.mnc = paramJceInputStream.read(this.mnc, 1, true);
    this.lac = paramJceInputStream.read(this.lac, 2, true);
    this.cellid = paramJceInputStream.read(this.cellid, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.mcc, 0);
    paramJceOutputStream.write(this.mnc, 1);
    paramJceOutputStream.write(this.lac, 2);
    paramJceOutputStream.write(this.cellid, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.GSMCell
 * JD-Core Version:    0.7.0.1
 */