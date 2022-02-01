package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class NeighborBanner
  extends JceStruct
{
  static byte[] cache_description;
  static byte[] cache_pic_url;
  static byte[] cache_skip_url;
  public byte[] description = null;
  public byte[] pic_url = null;
  public int postion = 0;
  public byte[] skip_url = null;
  
  public NeighborBanner() {}
  
  public NeighborBanner(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    this.description = paramArrayOfByte1;
    this.pic_url = paramArrayOfByte2;
    this.skip_url = paramArrayOfByte3;
    this.postion = paramInt;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_description == null)
    {
      cache_description = (byte[])new byte[1];
      ((byte[])cache_description)[0] = 0;
    }
    this.description = ((byte[])paramJceInputStream.read(cache_description, 0, true));
    if (cache_pic_url == null)
    {
      cache_pic_url = (byte[])new byte[1];
      ((byte[])cache_pic_url)[0] = 0;
    }
    this.pic_url = ((byte[])paramJceInputStream.read(cache_pic_url, 1, true));
    if (cache_skip_url == null)
    {
      cache_skip_url = (byte[])new byte[1];
      ((byte[])cache_skip_url)[0] = 0;
    }
    this.skip_url = ((byte[])paramJceInputStream.read(cache_skip_url, 2, true));
    this.postion = paramJceInputStream.read(this.postion, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.description, 0);
    paramJceOutputStream.write(this.pic_url, 1);
    paramJceOutputStream.write(this.skip_url, 2);
    paramJceOutputStream.write(this.postion, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     EncounterSvc.NeighborBanner
 * JD-Core Version:    0.7.0.1
 */