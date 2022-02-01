package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class EctCookie
  extends JceStruct
{
  static int cache_eNextGridListType;
  static byte[] cache_vCookie;
  public byte cNextGridSIndex = 0;
  public int eNextGridListType = 0;
  public long lCurrentGrid = 0L;
  public long lNextMid = 0L;
  public long lOriginGridS = 0L;
  public int last_max_distance = 0;
  public byte[] vCookie = null;
  
  public EctCookie() {}
  
  public EctCookie(byte[] paramArrayOfByte, long paramLong1, long paramLong2, byte paramByte, int paramInt1, long paramLong3, int paramInt2)
  {
    this.vCookie = paramArrayOfByte;
    this.lCurrentGrid = paramLong1;
    this.lOriginGridS = paramLong2;
    this.cNextGridSIndex = paramByte;
    this.eNextGridListType = paramInt1;
    this.lNextMid = paramLong3;
    this.last_max_distance = paramInt2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_vCookie == null)
    {
      cache_vCookie = (byte[])new byte[1];
      ((byte[])cache_vCookie)[0] = 0;
    }
    this.vCookie = ((byte[])paramJceInputStream.read(cache_vCookie, 0, false));
    this.lCurrentGrid = paramJceInputStream.read(this.lCurrentGrid, 1, false);
    this.lOriginGridS = paramJceInputStream.read(this.lOriginGridS, 2, false);
    this.cNextGridSIndex = paramJceInputStream.read(this.cNextGridSIndex, 3, false);
    this.eNextGridListType = paramJceInputStream.read(this.eNextGridListType, 4, false);
    this.lNextMid = paramJceInputStream.read(this.lNextMid, 5, false);
    this.last_max_distance = paramJceInputStream.read(this.last_max_distance, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.vCookie != null) {
      paramJceOutputStream.write(this.vCookie, 0);
    }
    paramJceOutputStream.write(this.lCurrentGrid, 1);
    paramJceOutputStream.write(this.lOriginGridS, 2);
    paramJceOutputStream.write(this.cNextGridSIndex, 3);
    paramJceOutputStream.write(this.eNextGridListType, 4);
    paramJceOutputStream.write(this.lNextMid, 5);
    paramJceOutputStream.write(this.last_max_distance, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     EncounterSvc.EctCookie
 * JD-Core Version:    0.7.0.1
 */