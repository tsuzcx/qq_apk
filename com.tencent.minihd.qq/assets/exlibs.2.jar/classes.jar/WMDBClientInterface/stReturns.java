package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stReturns
  extends JceStruct
{
  public int retAD = 0;
  public int retAndroidPush = 0;
  public int retFlashScreen = 0;
  public int retOperation = 0;
  public int retWMResource = 0;
  public int retWatermark = 0;
  public int retWatermarkAdv = 0;
  public int retWatermarkInt = 0;
  
  public stReturns() {}
  
  public stReturns(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    this.retWatermark = paramInt1;
    this.retWMResource = paramInt2;
    this.retFlashScreen = paramInt3;
    this.retAndroidPush = paramInt4;
    this.retAD = paramInt5;
    this.retOperation = paramInt6;
    this.retWatermarkInt = paramInt7;
    this.retWatermarkAdv = paramInt8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.retWatermark = paramJceInputStream.read(this.retWatermark, 0, true);
    this.retWMResource = paramJceInputStream.read(this.retWMResource, 1, true);
    this.retFlashScreen = paramJceInputStream.read(this.retFlashScreen, 2, true);
    this.retAndroidPush = paramJceInputStream.read(this.retAndroidPush, 3, true);
    this.retAD = paramJceInputStream.read(this.retAD, 4, true);
    this.retOperation = paramJceInputStream.read(this.retOperation, 5, true);
    this.retWatermarkInt = paramJceInputStream.read(this.retWatermarkInt, 6, false);
    this.retWatermarkAdv = paramJceInputStream.read(this.retWatermarkAdv, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.retWatermark, 0);
    paramJceOutputStream.write(this.retWMResource, 1);
    paramJceOutputStream.write(this.retFlashScreen, 2);
    paramJceOutputStream.write(this.retAndroidPush, 3);
    paramJceOutputStream.write(this.retAD, 4);
    paramJceOutputStream.write(this.retOperation, 5);
    paramJceOutputStream.write(this.retWatermarkInt, 6);
    paramJceOutputStream.write(this.retWatermarkAdv, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     WMDBClientInterface.stReturns
 * JD-Core Version:    0.7.0.1
 */