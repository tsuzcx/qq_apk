package NeighborSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class UserData
  extends JceStruct
{
  public int iLat = 900000000;
  public int iLon = 900000000;
  public long lNextMid = 0L;
  public int lTime = 0;
  public String strProvince = "";
  
  public UserData() {}
  
  public UserData(int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString)
  {
    this.lTime = paramInt1;
    this.iLat = paramInt2;
    this.iLon = paramInt3;
    this.lNextMid = paramLong;
    this.strProvince = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.lTime = paramJceInputStream.read(this.lTime, 0, true);
    this.iLat = paramJceInputStream.read(this.iLat, 1, true);
    this.iLon = paramJceInputStream.read(this.iLon, 2, true);
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 3, true);
    this.strProvince = paramJceInputStream.readString(4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.lTime, 0);
    paramJceOutputStream.write(this.iLat, 1);
    paramJceOutputStream.write(this.iLon, 2);
    paramJceOutputStream.write(this.lNextMid, 3);
    if (this.strProvince != null) {
      paramJceOutputStream.write(this.strProvince, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NeighborSvc.UserData
 * JD-Core Version:    0.7.0.1
 */