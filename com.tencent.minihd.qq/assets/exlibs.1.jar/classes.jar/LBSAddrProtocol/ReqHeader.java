package LBSAddrProtocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class ReqHeader
  extends JceStruct
{
  static int cache_eUinType;
  public int eUinType = 0;
  public int iClientIp = 0;
  public int iServerIp = 0;
  public short shVersion = 2;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public String strCookie = "";
  public String strUin = "";
  
  public ReqHeader() {}
  
  public ReqHeader(short paramShort, int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4)
  {
    this.shVersion = paramShort;
    this.eUinType = paramInt1;
    this.strUin = paramString1;
    this.iClientIp = paramInt2;
    this.iServerIp = paramInt3;
    this.strAuthName = paramString2;
    this.strAuthPassword = paramString3;
    this.strCookie = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.shVersion = paramJceInputStream.read(this.shVersion, 0, true);
    this.eUinType = paramJceInputStream.read(this.eUinType, 1, true);
    this.strUin = paramJceInputStream.readString(2, true);
    this.iClientIp = paramJceInputStream.read(this.iClientIp, 3, true);
    this.iServerIp = paramJceInputStream.read(this.iServerIp, 4, true);
    this.strAuthName = paramJceInputStream.readString(5, true);
    this.strAuthPassword = paramJceInputStream.readString(6, true);
    this.strCookie = paramJceInputStream.readString(7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.shVersion, 0);
    paramJceOutputStream.write(this.eUinType, 1);
    paramJceOutputStream.write(this.strUin, 2);
    paramJceOutputStream.write(this.iClientIp, 3);
    paramJceOutputStream.write(this.iServerIp, 4);
    paramJceOutputStream.write(this.strAuthName, 5);
    paramJceOutputStream.write(this.strAuthPassword, 6);
    paramJceOutputStream.write(this.strCookie, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     LBSAddrProtocol.ReqHeader
 * JD-Core Version:    0.7.0.1
 */