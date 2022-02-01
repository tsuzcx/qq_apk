package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetResourceReqInfoV2
  extends JceStruct
{
  public byte cPush = 0;
  public byte cState = 0;
  public byte cStatus = 0;
  public int iPluginType = 64;
  public short sLanType = 0;
  public short sResSubType = 0;
  public String strPkgName = "";
  public long uiCurVer = 0L;
  public long uiResId = 0L;
  
  public GetResourceReqInfoV2() {}
  
  public GetResourceReqInfoV2(String paramString, long paramLong1, short paramShort1, short paramShort2, byte paramByte1, long paramLong2, byte paramByte2, byte paramByte3, int paramInt)
  {
    this.strPkgName = paramString;
    this.uiCurVer = paramLong1;
    this.sResSubType = paramShort1;
    this.sLanType = paramShort2;
    this.cState = paramByte1;
    this.uiResId = paramLong2;
    this.cStatus = paramByte2;
    this.cPush = paramByte3;
    this.iPluginType = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.strPkgName = paramJceInputStream.readString(1, true);
    this.uiCurVer = paramJceInputStream.read(this.uiCurVer, 2, true);
    this.sResSubType = paramJceInputStream.read(this.sResSubType, 3, true);
    this.sLanType = paramJceInputStream.read(this.sLanType, 4, true);
    this.cState = paramJceInputStream.read(this.cState, 5, true);
    this.uiResId = paramJceInputStream.read(this.uiResId, 6, false);
    this.cStatus = paramJceInputStream.read(this.cStatus, 7, false);
    this.cPush = paramJceInputStream.read(this.cPush, 8, false);
    this.iPluginType = paramJceInputStream.read(this.iPluginType, 9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.strPkgName, 1);
    paramJceOutputStream.write(this.uiCurVer, 2);
    paramJceOutputStream.write(this.sResSubType, 3);
    paramJceOutputStream.write(this.sLanType, 4);
    paramJceOutputStream.write(this.cState, 5);
    paramJceOutputStream.write(this.uiResId, 6);
    paramJceOutputStream.write(this.cStatus, 7);
    paramJceOutputStream.write(this.cPush, 8);
    paramJceOutputStream.write(this.iPluginType, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     protocol.KQQConfig.GetResourceReqInfoV2
 * JD-Core Version:    0.7.0.1
 */