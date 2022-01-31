package com.tencent.map.lib.mapstructure;

import com.tencent.tencentmap.mapsdk.a.la;

public class MapRouteSectionWithName
{
  public static final int kMaxRoadNameLength = 128;
  public int color;
  public int endNum;
  public String roadName;
  public int startNum;
  
  public static int byteLength()
  {
    return 140;
  }
  
  public byte[] toBytes()
  {
    byte[] arrayOfByte1 = new byte[byteLength()];
    System.arraycopy(la.a(this.startNum), 0, arrayOfByte1, 0, 4);
    System.arraycopy(la.a(this.endNum), 0, arrayOfByte1, 4, 4);
    System.arraycopy(la.a(this.color), 0, arrayOfByte1, 8, 4);
    byte[] arrayOfByte2 = la.a(this.roadName);
    if (arrayOfByte2.length < 128)
    {
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 12, arrayOfByte2.length);
      return arrayOfByte1;
    }
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 12, 128);
    return arrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.lib.mapstructure.MapRouteSectionWithName
 * JD-Core Version:    0.7.0.1
 */