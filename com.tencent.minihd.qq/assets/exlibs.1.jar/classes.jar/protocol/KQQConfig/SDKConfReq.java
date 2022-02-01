package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class SDKConfReq
  extends JceStruct
{
  static ArrayList cache_sUin;
  public int iConfVersion = 0;
  public int iGetEspLastTime = 0;
  public int iGetSdkLastTime = 0;
  public ArrayList sUin = null;
  
  public SDKConfReq() {}
  
  public SDKConfReq(int paramInt1, int paramInt2, ArrayList paramArrayList, int paramInt3)
  {
    this.iConfVersion = paramInt1;
    this.iGetSdkLastTime = paramInt2;
    this.sUin = paramArrayList;
    this.iGetEspLastTime = paramInt3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.iConfVersion = paramJceInputStream.read(this.iConfVersion, 1, false);
    this.iGetSdkLastTime = paramJceInputStream.read(this.iGetSdkLastTime, 2, false);
    if (cache_sUin == null)
    {
      cache_sUin = new ArrayList();
      cache_sUin.add("");
    }
    this.sUin = ((ArrayList)paramJceInputStream.read(cache_sUin, 3, false));
    this.iGetEspLastTime = paramJceInputStream.read(this.iGetEspLastTime, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.iConfVersion, 1);
    paramJceOutputStream.write(this.iGetSdkLastTime, 2);
    if (this.sUin != null) {
      paramJceOutputStream.write(this.sUin, 3);
    }
    paramJceOutputStream.write(this.iGetEspLastTime, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     protocol.KQQConfig.SDKConfReq
 * JD-Core Version:    0.7.0.1
 */