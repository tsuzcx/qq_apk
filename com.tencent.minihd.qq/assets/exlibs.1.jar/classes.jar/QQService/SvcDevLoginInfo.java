package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class SvcDevLoginInfo
  extends JceStruct
{
  static DeviceItemDes cache_stDeviceItemDes;
  static byte[] cache_vecGuid;
  public long iAppId = 0L;
  public long iLoginPlatform = 0L;
  public long iLoginTime = 0L;
  public DeviceItemDes stDeviceItemDes = null;
  public String strDeviceName = "";
  public String strDeviceTypeInfo = "";
  public String strLoginLocation = "";
  public byte[] vecGuid = null;
  
  public SvcDevLoginInfo() {}
  
  public SvcDevLoginInfo(long paramLong1, byte[] paramArrayOfByte, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, DeviceItemDes paramDeviceItemDes)
  {
    this.iAppId = paramLong1;
    this.vecGuid = paramArrayOfByte;
    this.iLoginTime = paramLong2;
    this.iLoginPlatform = paramLong3;
    this.strLoginLocation = paramString1;
    this.strDeviceName = paramString2;
    this.strDeviceTypeInfo = paramString3;
    this.stDeviceItemDes = paramDeviceItemDes;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iAppId = paramJceInputStream.read(this.iAppId, 0, true);
    if (cache_vecGuid == null)
    {
      cache_vecGuid = (byte[])new byte[1];
      ((byte[])cache_vecGuid)[0] = 0;
    }
    this.vecGuid = ((byte[])paramJceInputStream.read(cache_vecGuid, 1, false));
    this.iLoginTime = paramJceInputStream.read(this.iLoginTime, 2, true);
    this.iLoginPlatform = paramJceInputStream.read(this.iLoginPlatform, 3, false);
    this.strLoginLocation = paramJceInputStream.readString(4, false);
    this.strDeviceName = paramJceInputStream.readString(5, false);
    this.strDeviceTypeInfo = paramJceInputStream.readString(6, false);
    if (cache_stDeviceItemDes == null) {
      cache_stDeviceItemDes = new DeviceItemDes();
    }
    this.stDeviceItemDes = ((DeviceItemDes)paramJceInputStream.read(cache_stDeviceItemDes, 7, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iAppId, 0);
    if (this.vecGuid != null) {
      paramJceOutputStream.write(this.vecGuid, 1);
    }
    paramJceOutputStream.write(this.iLoginTime, 2);
    paramJceOutputStream.write(this.iLoginPlatform, 3);
    if (this.strLoginLocation != null) {
      paramJceOutputStream.write(this.strLoginLocation, 4);
    }
    if (this.strDeviceName != null) {
      paramJceOutputStream.write(this.strDeviceName, 5);
    }
    if (this.strDeviceTypeInfo != null) {
      paramJceOutputStream.write(this.strDeviceTypeInfo, 6);
    }
    if (this.stDeviceItemDes != null) {
      paramJceOutputStream.write(this.stDeviceItemDes, 7);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     QQService.SvcDevLoginInfo
 * JD-Core Version:    0.7.0.1
 */