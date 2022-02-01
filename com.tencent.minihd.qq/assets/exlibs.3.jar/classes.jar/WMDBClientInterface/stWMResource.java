package WMDBClientInterface;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stWMResource
  extends JceStruct
{
  public boolean isEncrypted = true;
  public int version = 1;
  public String wmId = "";
  public String xmlResUrl = "";
  
  public stWMResource() {}
  
  public stWMResource(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    this.wmId = paramString1;
    this.isEncrypted = paramBoolean;
    this.version = paramInt;
    this.xmlResUrl = paramString2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wmId = paramJceInputStream.readString(0, true);
    this.isEncrypted = paramJceInputStream.read(this.isEncrypted, 1, true);
    this.version = paramJceInputStream.read(this.version, 2, true);
    this.xmlResUrl = paramJceInputStream.readString(3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wmId, 0);
    paramJceOutputStream.write(this.isEncrypted, 1);
    paramJceOutputStream.write(this.version, 2);
    paramJceOutputStream.write(this.xmlResUrl, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     WMDBClientInterface.stWMResource
 * JD-Core Version:    0.7.0.1
 */