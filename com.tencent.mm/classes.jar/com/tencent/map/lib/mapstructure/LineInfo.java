package com.tencent.map.lib.mapstructure;

import com.tencent.tencentmap.mapsdk.a.la;

public class LineInfo
{
  private static final int ROAD_NAME_BYTE_LEN = 64;
  public int color;
  public int endNum;
  public String roadName;
  public int speed;
  public int startNum;
  
  public byte[] fromBytes()
  {
    byte[] arrayOfByte1 = new byte[80];
    System.arraycopy(la.a(this.startNum), 0, arrayOfByte1, 0, 4);
    System.arraycopy(la.a(this.endNum), 0, arrayOfByte1, 4, 4);
    System.arraycopy(la.a(this.color), 0, arrayOfByte1, 8, 4);
    System.arraycopy(la.a(this.speed), 0, arrayOfByte1, 12, 4);
    byte[] arrayOfByte2 = la.a(this.roadName);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 16, arrayOfByte2.length);
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.mapstructure.LineInfo
 * JD-Core Version:    0.7.0.1
 */