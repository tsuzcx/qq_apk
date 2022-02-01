package protocol.KQQConfig;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ReqUserInfo
  extends JceStruct
{
  static GPS cache_stGps;
  static ArrayList<Cell> cache_vCells;
  static byte[] cache_vLBSKeyData;
  static ArrayList<Long> cache_vMacs;
  public byte cType = 0;
  public GPS stGps = null;
  public String strAuthName = "";
  public String strAuthPassword = "";
  public ArrayList<Cell> vCells = new ArrayList();
  public byte[] vLBSKeyData = null;
  public ArrayList<Long> vMacs = null;
  
  public ReqUserInfo() {}
  
  public ReqUserInfo(GPS paramGPS, ArrayList<Long> paramArrayList, ArrayList<Cell> paramArrayList1, String paramString1, String paramString2, byte paramByte, byte[] paramArrayOfByte)
  {
    this.stGps = paramGPS;
    this.vMacs = paramArrayList;
    this.vCells = paramArrayList1;
    this.strAuthName = paramString1;
    this.strAuthPassword = paramString2;
    this.cType = paramByte;
    this.vLBSKeyData = paramArrayOfByte;
  }
  
  public String className()
  {
    return "KQQConfig.ReqUserInfo";
  }
  
  public String fullClassName()
  {
    return "protocol.KQQConfig.ReqUserInfo";
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_stGps == null) {
      cache_stGps = new GPS();
    }
    this.stGps = ((GPS)paramJceInputStream.read(cache_stGps, 0, true));
    if (cache_vMacs == null)
    {
      cache_vMacs = new ArrayList();
      cache_vMacs.add(Long.valueOf(0L));
    }
    this.vMacs = ((ArrayList)paramJceInputStream.read(cache_vMacs, 1, true));
    if (cache_vCells == null)
    {
      cache_vCells = new ArrayList();
      Cell localCell = new Cell();
      cache_vCells.add(localCell);
    }
    this.vCells = ((ArrayList)paramJceInputStream.read(cache_vCells, 2, true));
    this.strAuthName = paramJceInputStream.readString(3, false);
    this.strAuthPassword = paramJceInputStream.readString(4, false);
    this.cType = paramJceInputStream.read(this.cType, 5, false);
    if (cache_vLBSKeyData == null)
    {
      cache_vLBSKeyData = new byte[1];
      cache_vLBSKeyData[0] = 0;
    }
    this.vLBSKeyData = paramJceInputStream.read(cache_vLBSKeyData, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.stGps, 0);
    paramJceOutputStream.write(this.vMacs, 1);
    paramJceOutputStream.write(this.vCells, 2);
    if (this.strAuthName != null) {
      paramJceOutputStream.write(this.strAuthName, 3);
    }
    if (this.strAuthPassword != null) {
      paramJceOutputStream.write(this.strAuthPassword, 4);
    }
    paramJceOutputStream.write(this.cType, 5);
    if (this.vLBSKeyData != null) {
      paramJceOutputStream.write(this.vLBSKeyData, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     protocol.KQQConfig.ReqUserInfo
 * JD-Core Version:    0.7.0.1
 */