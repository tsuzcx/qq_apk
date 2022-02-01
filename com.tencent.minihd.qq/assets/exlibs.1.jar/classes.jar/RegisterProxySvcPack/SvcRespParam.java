package RegisterProxySvcPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcRespParam
  extends JceStruct
{
  public int PCstat = 0;
  public int iIsSupportC2CRoamMsg = 0;
  public int iIsSupportDataLine = 0;
  public int iIsSupportPrintable = 0;
  public int iIsSupportViewPCFile = 0;
  public int iPcVersion = 0;
  public long uRoamFlag = 0L;
  
  public SvcRespParam() {}
  
  public SvcRespParam(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong)
  {
    this.PCstat = paramInt1;
    this.iIsSupportC2CRoamMsg = paramInt2;
    this.iIsSupportDataLine = paramInt3;
    this.iIsSupportPrintable = paramInt4;
    this.iIsSupportViewPCFile = paramInt5;
    this.iPcVersion = paramInt6;
    this.uRoamFlag = paramLong;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.PCstat = paramJceInputStream.read(this.PCstat, 0, false);
    this.iIsSupportC2CRoamMsg = paramJceInputStream.read(this.iIsSupportC2CRoamMsg, 1, false);
    this.iIsSupportDataLine = paramJceInputStream.read(this.iIsSupportDataLine, 2, false);
    this.iIsSupportPrintable = paramJceInputStream.read(this.iIsSupportPrintable, 3, false);
    this.iIsSupportViewPCFile = paramJceInputStream.read(this.iIsSupportViewPCFile, 4, false);
    this.iPcVersion = paramJceInputStream.read(this.iPcVersion, 5, false);
    this.uRoamFlag = paramJceInputStream.read(this.uRoamFlag, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.PCstat, 0);
    paramJceOutputStream.write(this.iIsSupportC2CRoamMsg, 1);
    paramJceOutputStream.write(this.iIsSupportDataLine, 2);
    paramJceOutputStream.write(this.iIsSupportPrintable, 3);
    paramJceOutputStream.write(this.iIsSupportViewPCFile, 4);
    paramJceOutputStream.write(this.iPcVersion, 5);
    paramJceOutputStream.write(this.uRoamFlag, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     RegisterProxySvcPack.SvcRespParam
 * JD-Core Version:    0.7.0.1
 */